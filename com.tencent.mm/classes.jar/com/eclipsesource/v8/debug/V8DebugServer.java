package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.List;

public class V8DebugServer
{
  private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
  public static String DEBUG_OBJECT_NAME;
  private static final String HEADER_EMBEDDING_HOST = "Embedding-Host: ";
  private static final String HEADER_PROTOCOL_VERSION = "Protocol-Version: ";
  private static final String HEADER_TYPE = "Type: ";
  private static final String HEADER_V8_VERSION = "V8-Version: ";
  private static final String J2V8_VERSION = "4.0.0";
  private static final String MAKE_BREAK_EVENT = "__j2v8_MakeBreakEvent";
  private static final String MAKE_COMPILE_EVENT = "__j2v8_MakeCompileEvent";
  private static final int PROTOCOL_BUFFER_SIZE = 4096;
  private static final Charset PROTOCOL_CHARSET;
  private static final byte[] PROTOCOL_CONTENT_LENGTH_BYTES;
  private static final String PROTOCOL_CONTENT_LENGTH_HEADER = "Content-Length:";
  private static final String PROTOCOL_EOL = "\r\n";
  private static final byte[] PROTOCOL_EOL_BYTES;
  private static final String PROTOCOL_VERSION = "1";
  private static final String SET_LISTENER = "setListener";
  private static final String V8_DEBUG_OBJECT = "Debug";
  private static final String V8_VERSION = "4.10.253";
  private Socket client;
  private Object clientLock;
  private V8Object debugObject;
  private List<String> requests;
  private V8Object runningStateDcp;
  private V8 runtime;
  private ServerSocket server;
  private V8Object stoppedStateDcp;
  private boolean traceCommunication;
  private boolean waitForConnection;
  
  static
  {
    AppMethodBeat.i(61569);
    DEBUG_OBJECT_NAME = "__j2v8_Debug";
    PROTOCOL_CHARSET = Charset.forName("UTF-8");
    PROTOCOL_EOL_BYTES = "\r\n".getBytes(PROTOCOL_CHARSET);
    PROTOCOL_CONTENT_LENGTH_BYTES = "Content-Length:".getBytes(PROTOCOL_CHARSET);
    AppMethodBeat.o(61569);
  }
  
  /* Error */
  public V8DebugServer(V8 paramV8, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 125	java/lang/Object:<init>	()V
    //   4: ldc 126
    //   6: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: new 4	java/lang/Object
    //   13: dup
    //   14: invokespecial 125	java/lang/Object:<init>	()V
    //   17: putfield 128	com/eclipsesource/v8/debug/V8DebugServer:clientLock	Ljava/lang/Object;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 130	com/eclipsesource/v8/debug/V8DebugServer:traceCommunication	Z
    //   25: aload_0
    //   26: new 132	java/util/LinkedList
    //   29: dup
    //   30: invokespecial 133	java/util/LinkedList:<init>	()V
    //   33: putfield 135	com/eclipsesource/v8/debug/V8DebugServer:requests	Ljava/util/List;
    //   36: aload_0
    //   37: aload_1
    //   38: putfield 137	com/eclipsesource/v8/debug/V8DebugServer:runtime	Lcom/eclipsesource/v8/V8;
    //   41: aload_0
    //   42: iload_3
    //   43: putfield 139	com/eclipsesource/v8/debug/V8DebugServer:waitForConnection	Z
    //   46: aload_1
    //   47: getstatic 95	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   50: invokevirtual 145	com/eclipsesource/v8/V8:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   53: astore 4
    //   55: aload 4
    //   57: ifnonnull +17 -> 74
    //   60: getstatic 151	java/lang/System:err	Ljava/io/PrintStream;
    //   63: ldc 153
    //   65: invokevirtual 159	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   68: ldc 126
    //   70: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: return
    //   74: aload_0
    //   75: aload 4
    //   77: ldc 61
    //   79: invokevirtual 162	com/eclipsesource/v8/V8Object:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   82: putfield 164	com/eclipsesource/v8/debug/V8DebugServer:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   85: aload 4
    //   87: invokevirtual 167	com/eclipsesource/v8/V8Object:release	()V
    //   90: aload_1
    //   91: new 169	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 171
    //   97: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: getstatic 95	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   103: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 179
    //   108: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: getstatic 95	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   114: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 181
    //   119: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: getstatic 95	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   125: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 183
    //   130: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: getstatic 95	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   136: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 185
    //   141: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: getstatic 95	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   147: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 187
    //   152: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 194	com/eclipsesource/v8/V8:executeVoidScript	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: new 196	java/net/ServerSocket
    //   165: dup
    //   166: iload_2
    //   167: invokespecial 198	java/net/ServerSocket:<init>	(I)V
    //   170: putfield 200	com/eclipsesource/v8/debug/V8DebugServer:server	Ljava/net/ServerSocket;
    //   173: ldc 126
    //   175: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: return
    //   179: astore_1
    //   180: aload 4
    //   182: invokevirtual 167	com/eclipsesource/v8/V8Object:release	()V
    //   185: ldc 126
    //   187: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_1
    //   191: athrow
    //   192: astore_1
    //   193: aload_0
    //   194: aload_1
    //   195: invokevirtual 204	com/eclipsesource/v8/debug/V8DebugServer:logError	(Ljava/lang/Throwable;)V
    //   198: ldc 126
    //   200: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	V8DebugServer
    //   0	204	1	paramV8	V8
    //   0	204	2	paramInt	int
    //   0	204	3	paramBoolean	boolean
    //   53	128	4	localV8Object	V8Object
    // Exception table:
    //   from	to	target	type
    //   74	85	179	finally
    //   161	173	192	java/lang/Exception
  }
  
  public static void configureV8ForDebugging()
  {
    AppMethodBeat.i(61552);
    try
    {
      V8.setFlags("-expose-debug-as=" + DEBUG_OBJECT_NAME);
      AppMethodBeat.o(61552);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(61552);
    }
  }
  
  private void enterBreakLoop(V8Object paramV8Object1, V8Object paramV8Object2)
  {
    AppMethodBeat.i(61563);
    V8Array localV8Array1;
    try
    {
      localV8Array1 = new V8Array(this.runtime);
      int i;
      V8Array localV8Array2;
      label156:
      boolean bool;
      localV8Array2.release();
    }
    finally
    {
      try
      {
        localV8Array1.push(false);
        this.stoppedStateDcp = paramV8Object1.executeObjectFunction("debugCommandProcessor", localV8Array1);
        localV8Array1.release();
        i = paramV8Object1.getInteger("break_id");
        localV8Array1 = paramV8Object2.getArray("break_points_hit_");
        localV8Array2 = new V8Array(this.runtime);
        this.stoppedStateDcp = null;
      }
      finally
      {
        try
        {
          localV8Array2.push(i);
          localV8Array2.push(localV8Array1);
          paramV8Object1 = this.debugObject.executeObjectFunction("__j2v8_MakeBreakEvent", localV8Array2);
        }
        finally {}
        try
        {
          paramV8Object2 = paramV8Object1.executeStringFunction("toJSONProtocol", null);
          if (this.traceCommunication) {
            System.out.println("Sending event (Break):\n".concat(String.valueOf(paramV8Object2)));
          }
          sendJson(paramV8Object2);
          localV8Array2.release();
          localV8Array1.release();
          if (paramV8Object1 != null) {
            paramV8Object1.release();
          }
          for (;;)
          {
            if (!isConnected()) {
              break label259;
            }
            bool = this.stoppedStateDcp.executeBooleanFunction("isRunning", null);
            if (bool) {
              break label259;
            }
            try
            {
              processRequests(10L);
            }
            catch (InterruptedException paramV8Object1) {}
          }
          break label156;
          paramV8Object1 = finally;
          localV8Array1.release();
          AppMethodBeat.o(61563);
          throw paramV8Object1;
        }
        finally
        {
          break label233;
        }
        paramV8Object1 = finally;
        this.stoppedStateDcp.release();
      }
      AppMethodBeat.o(61563);
    }
    label233:
    localV8Array1.release();
    if (paramV8Object1 != null) {
      paramV8Object1.release();
    }
    AppMethodBeat.o(61563);
    throw paramV8Object2;
    label259:
    this.stoppedStateDcp.release();
    this.stoppedStateDcp = null;
    AppMethodBeat.o(61563);
  }
  
  private boolean isConnected()
  {
    AppMethodBeat.i(61559);
    synchronized (this.clientLock)
    {
      if ((this.server != null) && (this.client != null) && (this.client.isConnected()))
      {
        bool = true;
        AppMethodBeat.o(61559);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  private void processRequest(String paramString)
  {
    AppMethodBeat.i(61561);
    if (this.traceCommunication) {
      System.out.println("Got message: \n" + paramString.substring(0, Math.min(paramString.length(), 1000)));
    }
    Object localObject = new V8Array(this.runtime);
    ((V8Array)localObject).push(paramString);
    if (this.stoppedStateDcp != null) {}
    for (paramString = this.stoppedStateDcp;; paramString = this.runningStateDcp)
    {
      String str = paramString.executeFunction("processDebugJSONRequest", (V8Array)localObject).toString();
      localObject = str;
      if (this.stoppedStateDcp == null)
      {
        localObject = str;
        if (str.contains("\"running\":false"))
        {
          localObject = str.replace("\"running\":false", "\"running\":true").replace("\"success\":true", "\"success\":false").replace("{\"", "{\"message\":\"Client requested suspension is not supported on J2V8.\",\"");
          paramString.add("running_", true);
        }
      }
      if (this.traceCommunication) {
        System.out.println("Returning response: \n" + ((String)localObject).substring(0, Math.min(((String)localObject).length(), 1000)));
      }
      sendJson((String)localObject);
      AppMethodBeat.o(61561);
      return;
    }
  }
  
  private void sendCompileEvent(V8Object paramV8Object)
  {
    V8Object localV8Object1 = null;
    AppMethodBeat.i(61564);
    if (!isConnected())
    {
      AppMethodBeat.o(61564);
      return;
    }
    int i = paramV8Object.getInteger("type_");
    V8Object localV8Object2 = paramV8Object.getObject("script_");
    V8Array localV8Array = new V8Array(this.runtime);
    paramV8Object = localV8Object1;
    try
    {
      localV8Array.push(localV8Object2);
      paramV8Object = localV8Object1;
      localV8Array.push(i);
      paramV8Object = localV8Object1;
      localV8Object1 = this.debugObject.executeObjectFunction("__j2v8_MakeCompileEvent", localV8Array);
      paramV8Object = localV8Object1;
      String str = localV8Object1.executeStringFunction("toJSONProtocol", null);
      paramV8Object = localV8Object1;
      if (this.traceCommunication)
      {
        paramV8Object = localV8Object1;
        System.out.println("Sending event (CompileEvent):\n" + str.substring(0, Math.min(str.length(), 1000)));
      }
      paramV8Object = localV8Object1;
      if (str.length() > 0)
      {
        paramV8Object = localV8Object1;
        sendJson(str);
      }
      return;
    }
    finally
    {
      localV8Array.release();
      localV8Object2.release();
      if (paramV8Object != null) {
        paramV8Object.release();
      }
      AppMethodBeat.o(61564);
    }
    AppMethodBeat.o(61564);
  }
  
  private void sendJson(String paramString)
  {
    AppMethodBeat.i(61557);
    sendMessage("", paramString.replace("\\/", "/"));
    AppMethodBeat.o(61557);
  }
  
  private void sendMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(61558);
    synchronized (this.clientLock)
    {
      if (!isConnected())
      {
        paramString1 = new IOException("There is no connected client.");
        AppMethodBeat.o(61558);
        throw paramString1;
      }
    }
    paramString2 = paramString2.getBytes(PROTOCOL_CHARSET);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("Content-Length:");
    localStringBuilder.append(Integer.toString(paramString2.length));
    localStringBuilder.append("\r\n");
    localStringBuilder.append("\r\n");
    this.client.getOutputStream().write(localStringBuilder.toString().getBytes(PROTOCOL_CHARSET));
    if (paramString2.length > 0) {
      this.client.getOutputStream().write(paramString2);
    }
    AppMethodBeat.o(61558);
  }
  
  /* Error */
  private void setupEventHandler()
  {
    // Byte code:
    //   0: ldc_w 433
    //   3: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 11	com/eclipsesource/v8/debug/V8DebugServer$EventHandler
    //   9: dup
    //   10: aload_0
    //   11: aconst_null
    //   12: invokespecial 436	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:<init>	(Lcom/eclipsesource/v8/debug/V8DebugServer;Lcom/eclipsesource/v8/debug/V8DebugServer$1;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getfield 164	com/eclipsesource/v8/debug/V8DebugServer:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   20: aload_1
    //   21: ldc 16
    //   23: invokevirtual 440	com/eclipsesource/v8/V8Object:registerJavaMethod	(Lcom/eclipsesource/v8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   26: pop
    //   27: aload_0
    //   28: getfield 164	com/eclipsesource/v8/debug/V8DebugServer:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   31: ldc 16
    //   33: invokevirtual 162	com/eclipsesource/v8/V8Object:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   36: checkcast 442	com/eclipsesource/v8/V8Function
    //   39: astore_1
    //   40: new 266	com/eclipsesource/v8/V8Array
    //   43: dup
    //   44: aload_0
    //   45: getfield 137	com/eclipsesource/v8/debug/V8DebugServer:runtime	Lcom/eclipsesource/v8/V8;
    //   48: invokespecial 269	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   51: aload_1
    //   52: invokevirtual 300	com/eclipsesource/v8/V8Array:push	(Lcom/eclipsesource/v8/V8Value;)Lcom/eclipsesource/v8/V8Array;
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 164	com/eclipsesource/v8/debug/V8DebugServer:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   60: ldc 58
    //   62: aload_2
    //   63: invokevirtual 364	com/eclipsesource/v8/V8Object:executeFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)Ljava/lang/Object;
    //   66: pop
    //   67: aload_1
    //   68: ifnull +14 -> 82
    //   71: aload_1
    //   72: invokevirtual 445	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   75: ifne +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 446	com/eclipsesource/v8/V8Function:release	()V
    //   82: aload_2
    //   83: ifnull +64 -> 147
    //   86: aload_2
    //   87: invokevirtual 447	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   90: ifne +57 -> 147
    //   93: aload_2
    //   94: invokevirtual 282	com/eclipsesource/v8/V8Array:release	()V
    //   97: ldc_w 433
    //   100: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: return
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_3
    //   109: aload_3
    //   110: ifnull +14 -> 124
    //   113: aload_3
    //   114: invokevirtual 445	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   117: ifne +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 446	com/eclipsesource/v8/V8Function:release	()V
    //   124: aload_2
    //   125: ifnull +14 -> 139
    //   128: aload_2
    //   129: invokevirtual 447	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   132: ifne +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 282	com/eclipsesource/v8/V8Array:release	()V
    //   139: ldc_w 433
    //   142: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_1
    //   146: athrow
    //   147: ldc_w 433
    //   150: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: astore 4
    //   156: aconst_null
    //   157: astore_2
    //   158: aload_1
    //   159: astore_3
    //   160: aload 4
    //   162: astore_1
    //   163: goto -54 -> 109
    //   166: astore 4
    //   168: aload_1
    //   169: astore_3
    //   170: aload 4
    //   172: astore_1
    //   173: goto -64 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	V8DebugServer
    //   15	64	1	localObject1	Object
    //   104	55	1	localObject2	Object
    //   162	11	1	localObject3	Object
    //   55	103	2	localV8Array	V8Array
    //   108	62	3	localObject4	Object
    //   154	7	4	localObject5	Object
    //   166	5	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   27	40	104	finally
    //   40	56	154	finally
    //   56	67	166	finally
  }
  
  public int getPort()
  {
    AppMethodBeat.i(61554);
    if ((this.server != null) && (this.server.isBound()))
    {
      int i = this.server.getLocalPort();
      AppMethodBeat.o(61554);
      return i;
    }
    AppMethodBeat.o(61554);
    return -1;
  }
  
  protected void logError(Throwable paramThrowable) {}
  
  public void processRequests(long paramLong)
  {
    AppMethodBeat.i(61560);
    if (this.server == null)
    {
      AppMethodBeat.o(61560);
      return;
    }
    long l = System.currentTimeMillis();
    label129:
    do
    {
      do
      {
        for (;;)
        {
          int i;
          synchronized (this.requests)
          {
            String[] arrayOfString = (String[])this.requests.toArray(new String[this.requests.size()]);
            this.requests.clear();
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label129;
            }
            ??? = arrayOfString[i];
          }
          try
          {
            processRequest(???);
            i += 1;
            continue;
            localObject = finally;
            AppMethodBeat.o(61560);
            throw localObject;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              logError(localException);
            }
          }
        }
      } while (localObject.length > 0);
      if (paramLong > 0L) {
        Thread.sleep(10L);
      }
    } while ((paramLong > 0L) && (l + paramLong > System.currentTimeMillis()));
    AppMethodBeat.o(61560);
  }
  
  public void setTraceCommunication(boolean paramBoolean)
  {
    this.traceCommunication = paramBoolean;
  }
  
  public void start()
  {
    AppMethodBeat.i(61555);
    if (this.server == null)
    {
      AppMethodBeat.o(61555);
      return;
    }
    boolean bool = this.waitForConnection;
    ??? = new Thread(new ClientLoop(null), "J2V8 Debugger Server");
    ((Thread)???).setDaemon(true);
    ((Thread)???).start();
    setupEventHandler();
    this.runningStateDcp = this.runtime.executeObjectScript("(function() {return new " + DEBUG_OBJECT_NAME + ".DebugCommandProcessor(null, true)})()");
    if (bool)
    {
      synchronized (this.clientLock)
      {
        for (;;)
        {
          bool = this.waitForConnection;
          if (!bool) {
            break;
          }
          try
          {
            this.clientLock.wait();
          }
          catch (InterruptedException localInterruptedException2) {}
        }
      }
      try
      {
        processRequests(100L);
        AppMethodBeat.o(61555);
        return;
      }
      catch (InterruptedException localInterruptedException1) {}
      localObject2 = finally;
      AppMethodBeat.o(61555);
      throw localObject2;
    }
    AppMethodBeat.o(61555);
  }
  
  public void stop()
  {
    AppMethodBeat.i(61556);
    for (;;)
    {
      try
      {
        this.server.close();
      }
      catch (IOException localIOException)
      {
        logError(localIOException);
        continue;
      }
      synchronized (this.clientLock)
      {
        if (this.client != null)
        {
          this.client.close();
          this.client = null;
        }
        if (this.runningStateDcp != null)
        {
          this.runningStateDcp.release();
          this.runningStateDcp = null;
        }
        if (this.debugObject != null)
        {
          this.debugObject.release();
          this.debugObject = null;
        }
        if (this.stoppedStateDcp != null)
        {
          this.stoppedStateDcp.release();
          this.stoppedStateDcp = null;
        }
        AppMethodBeat.o(61556);
        return;
      }
    }
  }
  
  class ClientLoop
    implements Runnable
  {
    private int from;
    
    private ClientLoop() {}
    
    private int indexOf(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
    {
      int j = paramArrayOfByte1.length;
      while (paramInt1 < paramInt2)
      {
        int i = 0;
        while (i <= j)
        {
          if (i == j) {
            return paramInt1;
          }
          if ((paramInt1 + i >= paramInt2) || (paramArrayOfByte2[(paramInt1 + i)] != paramArrayOfByte1[i])) {
            break;
          }
          i += 1;
        }
        paramInt1 += 1;
      }
      return -1;
    }
    
    private byte[] join(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(61549);
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramInt2];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte2, paramInt1, arrayOfByte, paramArrayOfByte1.length, paramInt2);
      AppMethodBeat.o(61549);
      return arrayOfByte;
    }
    
    private void processClientRequests()
    {
      AppMethodBeat.i(61546);
      byte[] arrayOfByte1 = new byte[0];
      byte[] arrayOfByte2 = new byte[4096];
      for (;;)
      {
        int j;
        int k;
        int m;
        Object localObject2;
        boolean bool2;
        synchronized (V8DebugServer.this.clientLock)
        {
          InputStream localInputStream = V8DebugServer.this.client.getInputStream();
          j = -1;
          ??? = arrayOfByte1;
          bool1 = false;
          i = 0;
          k = localInputStream.read(arrayOfByte2, i, 4096 - i);
          if (k <= 0) {
            break;
          }
          m = i + k;
          this.from = 0;
          localObject2 = ???;
          k = j;
          i = k;
          if (k < 0)
          {
            i = readContentLength(arrayOfByte2, m);
            j = i;
            ??? = localObject2;
            bool2 = bool1;
            if (i < 0) {}
          }
          else
          {
            bool2 = bool1;
            if (!bool1)
            {
              bool1 = skipToolInfo(arrayOfByte2, m);
              j = i;
              ??? = localObject2;
              bool2 = bool1;
              if (bool1) {
                bool2 = bool1;
              }
            }
            else
            {
              j = Math.min(i - localObject2.length, m - this.from);
              localObject2 = join((byte[])localObject2, arrayOfByte2, this.from, j);
              this.from = (j + this.from);
              j = i;
              ??? = localObject2;
              if (localObject2.length == i) {
                localObject2 = new String((byte[])localObject2, V8DebugServer.PROTOCOL_CHARSET);
              }
            }
          }
        }
        synchronized (V8DebugServer.this.requests)
        {
          V8DebugServer.this.requests.add(localObject2);
          j = -1;
          ??? = arrayOfByte1;
          bool2 = false;
          k = j;
          localObject2 = ???;
          bool1 = bool2;
          if (this.from < m) {
            continue;
          }
          if (this.from < m)
          {
            System.arraycopy(arrayOfByte2, this.from, arrayOfByte2, 0, m - this.from);
            i = m - this.from;
            bool1 = bool2;
            continue;
            localObject3 = finally;
            AppMethodBeat.o(61546);
            throw localObject3;
          }
        }
        int i = 0;
        boolean bool1 = bool2;
      }
      AppMethodBeat.o(61546);
    }
    
    private int readContentLength(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(61547);
      int i = indexOf(V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES, paramArrayOfByte, this.from, paramInt);
      if (i < 0)
      {
        AppMethodBeat.o(61547);
        return -1;
      }
      i += V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES.length;
      paramInt = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, paramArrayOfByte, i, paramInt);
      if (paramInt < 0)
      {
        AppMethodBeat.o(61547);
        return -1;
      }
      String str = new String(paramArrayOfByte, i, paramInt - i, V8DebugServer.PROTOCOL_CHARSET);
      try
      {
        i = Integer.parseInt(str.trim());
        this.from = (V8DebugServer.PROTOCOL_EOL_BYTES.length + paramInt);
        AppMethodBeat.o(61547);
        return i;
      }
      catch (Exception localException)
      {
        paramArrayOfByte = new IOException("Invalid content length header: '" + str + "' in message" + new String(paramArrayOfByte, V8DebugServer.PROTOCOL_CHARSET));
        AppMethodBeat.o(61547);
        throw paramArrayOfByte;
      }
    }
    
    private boolean skipToolInfo(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(61548);
      paramInt = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, paramArrayOfByte, this.from, paramInt);
      if (paramInt < 0)
      {
        AppMethodBeat.o(61548);
        return false;
      }
      this.from = (paramInt + V8DebugServer.PROTOCOL_EOL_BYTES.length);
      AppMethodBeat.o(61548);
      return true;
    }
    
    private void startHandshake()
    {
      AppMethodBeat.i(61545);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("V8-Version: ");
      localStringBuilder.append("4.10.253");
      localStringBuilder.append("\r\n");
      localStringBuilder.append("Protocol-Version: ");
      localStringBuilder.append("1");
      localStringBuilder.append("\r\n");
      localStringBuilder.append("Embedding-Host: ");
      localStringBuilder.append("j2v8 ");
      localStringBuilder.append("4.0.0");
      localStringBuilder.append("\r\n");
      localStringBuilder.append("Type: ");
      localStringBuilder.append("connect");
      localStringBuilder.append("\r\n");
      V8DebugServer.access$1000(V8DebugServer.this, localStringBuilder.toString(), "");
      AppMethodBeat.o(61545);
    }
    
    public void run()
    {
      AppMethodBeat.i(61544);
      for (;;)
      {
        try
        {
          localSocket1 = V8DebugServer.this.server.accept();
          localSocket1.setTcpNoDelay(true);
        }
        catch (Exception localException)
        {
          synchronized (V8DebugServer.this.clientLock)
          {
            Socket localSocket1;
            V8DebugServer.access$802(V8DebugServer.this, localSocket1);
            V8DebugServer.access$902(V8DebugServer.this, false);
            V8DebugServer.this.clientLock.notifyAll();
            startHandshake();
            processClientRequests();
            continue;
            localException = localException;
            synchronized (V8DebugServer.this.clientLock)
            {
              Socket localSocket2 = V8DebugServer.this.client;
              if (localSocket2 == null) {}
            }
          }
        }
        try
        {
          V8DebugServer.this.client.close();
          label105:
          V8DebugServer.access$802(V8DebugServer.this, null);
          V8DebugServer.this.logError(localException);
          continue;
          localObject2 = finally;
          AppMethodBeat.o(61544);
          throw localObject2;
          localObject3 = finally;
          AppMethodBeat.o(61544);
          throw localObject3;
        }
        catch (IOException localIOException)
        {
          break label105;
        }
      }
    }
  }
  
  class EventHandler
    implements JavaVoidCallback
  {
    private EventHandler() {}
    
    private void safeRelease(Releasable paramReleasable)
    {
      AppMethodBeat.i(61551);
      if (paramReleasable != null) {
        paramReleasable.release();
      }
      AppMethodBeat.o(61551);
    }
    
    /* Error */
    public void invoke(V8Object paramV8Object, V8Array paramV8Array)
    {
      // Byte code:
      //   0: ldc 44
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_2
      //   6: ifnull +10 -> 16
      //   9: aload_2
      //   10: invokevirtual 50	com/eclipsesource/v8/V8Array:isUndefined	()Z
      //   13: ifeq +9 -> 22
      //   16: ldc 44
      //   18: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   21: return
      //   22: aload_2
      //   23: iconst_0
      //   24: invokevirtual 54	com/eclipsesource/v8/V8Array:getInteger	(I)I
      //   27: istore_3
      //   28: aload_2
      //   29: iconst_1
      //   30: invokevirtual 58	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
      //   33: astore 5
      //   35: aload_2
      //   36: iconst_2
      //   37: invokevirtual 58	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
      //   40: astore_2
      //   41: aload_2
      //   42: astore 6
      //   44: aload 5
      //   46: astore 7
      //   48: aload_0
      //   49: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   52: invokestatic 62	com/eclipsesource/v8/debug/V8DebugServer:access$200	(Lcom/eclipsesource/v8/debug/V8DebugServer;)Z
      //   55: ifeq +75 -> 130
      //   58: ldc 64
      //   60: astore_1
      //   61: iload_3
      //   62: tableswitch	default:+308 -> 370, 1:+106->168, 2:+311->373, 3:+317->379, 4:+323->385, 5:+329->391, 6:+335->397, 7:+341->403, 8:+112->174
      //   109: astore 6
      //   111: aload 5
      //   113: astore 7
      //   115: getstatic 70	java/lang/System:out	Ljava/io/PrintStream;
      //   118: ldc 72
      //   120: aload_1
      //   121: invokestatic 78	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   124: invokevirtual 82	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   127: invokevirtual 88	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   130: aload_2
      //   131: astore 6
      //   133: aload 5
      //   135: astore 7
      //   137: aload_0
      //   138: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   141: invokestatic 91	com/eclipsesource/v8/debug/V8DebugServer:access$300	(Lcom/eclipsesource/v8/debug/V8DebugServer;)Z
      //   144: istore 4
      //   146: iload 4
      //   148: ifne +32 -> 180
      //   151: aload_0
      //   152: aload 5
      //   154: invokespecial 93	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   157: aload_0
      //   158: aload_2
      //   159: invokespecial 93	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   162: ldc 44
      //   164: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   167: return
      //   168: ldc 95
      //   170: astore_1
      //   171: goto -63 -> 108
      //   174: ldc 97
      //   176: astore_1
      //   177: goto -69 -> 108
      //   180: iload_3
      //   181: tableswitch	default:+39 -> 220, 1:+56->237, 2:+39->220, 3:+39->220, 4:+39->220, 5:+115->296, 6:+115->296
      //   221: aload 5
      //   223: invokespecial 93	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   226: aload_0
      //   227: aload_2
      //   228: invokespecial 93	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   231: ldc 44
      //   233: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   236: return
      //   237: aload_2
      //   238: astore 6
      //   240: aload 5
      //   242: astore 7
      //   244: aload_0
      //   245: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   248: aload 5
      //   250: aload_2
      //   251: invokestatic 101	com/eclipsesource/v8/debug/V8DebugServer:access$400	(Lcom/eclipsesource/v8/debug/V8DebugServer;Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8Object;)V
      //   254: goto -34 -> 220
      //   257: astore 6
      //   259: aload_2
      //   260: astore_1
      //   261: aload 6
      //   263: astore_2
      //   264: aload_1
      //   265: astore 6
      //   267: aload 5
      //   269: astore 7
      //   271: aload_0
      //   272: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   275: aload_2
      //   276: invokevirtual 105	com/eclipsesource/v8/debug/V8DebugServer:logError	(Ljava/lang/Throwable;)V
      //   279: aload_0
      //   280: aload 5
      //   282: invokespecial 93	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   285: aload_0
      //   286: aload_1
      //   287: invokespecial 93	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   290: ldc 44
      //   292: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   295: return
      //   296: aload_2
      //   297: astore 6
      //   299: aload 5
      //   301: astore 7
      //   303: aload_0
      //   304: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   307: aload_2
      //   308: invokestatic 109	com/eclipsesource/v8/debug/V8DebugServer:access$500	(Lcom/eclipsesource/v8/debug/V8DebugServer;Lcom/eclipsesource/v8/V8Object;)V
      //   311: goto -91 -> 220
      //   314: astore_1
      //   315: aload 7
      //   317: astore 5
      //   319: aload_0
      //   320: aload 5
      //   322: invokespecial 93	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   325: aload_0
      //   326: aload 6
      //   328: invokespecial 93	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   331: ldc 44
      //   333: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   336: aload_1
      //   337: athrow
      //   338: astore_1
      //   339: aconst_null
      //   340: astore 6
      //   342: aconst_null
      //   343: astore 5
      //   345: goto -26 -> 319
      //   348: astore_1
      //   349: aconst_null
      //   350: astore 6
      //   352: goto -33 -> 319
      //   355: astore_2
      //   356: aconst_null
      //   357: astore_1
      //   358: aconst_null
      //   359: astore 5
      //   361: goto -97 -> 264
      //   364: astore_2
      //   365: aconst_null
      //   366: astore_1
      //   367: goto -103 -> 264
      //   370: goto -262 -> 108
      //   373: ldc 111
      //   375: astore_1
      //   376: goto -268 -> 108
      //   379: ldc 113
      //   381: astore_1
      //   382: goto -274 -> 108
      //   385: ldc 115
      //   387: astore_1
      //   388: goto -280 -> 108
      //   391: ldc 117
      //   393: astore_1
      //   394: goto -286 -> 108
      //   397: ldc 119
      //   399: astore_1
      //   400: goto -292 -> 108
      //   403: ldc 121
      //   405: astore_1
      //   406: goto -298 -> 108
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	409	0	this	EventHandler
      //   0	409	1	paramV8Object	V8Object
      //   0	409	2	paramV8Array	V8Array
      //   27	154	3	i	int
      //   144	3	4	bool	boolean
      //   33	327	5	localObject1	Object
      //   42	197	6	localV8Array	V8Array
      //   257	5	6	localException	Exception
      //   265	86	6	localObject2	Object
      //   46	270	7	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   48	58	257	java/lang/Exception
      //   115	130	257	java/lang/Exception
      //   137	146	257	java/lang/Exception
      //   244	254	257	java/lang/Exception
      //   303	311	257	java/lang/Exception
      //   48	58	314	finally
      //   115	130	314	finally
      //   137	146	314	finally
      //   244	254	314	finally
      //   271	279	314	finally
      //   303	311	314	finally
      //   22	35	338	finally
      //   35	41	348	finally
      //   22	35	355	java/lang/Exception
      //   35	41	364	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.debug.V8DebugServer
 * JD-Core Version:    0.7.0.1
 */