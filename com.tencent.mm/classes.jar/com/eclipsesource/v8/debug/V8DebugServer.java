package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.List;

public class V8DebugServer
{
  private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
  public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
  private static final String HEADER_EMBEDDING_HOST = "Embedding-Host: ";
  private static final String HEADER_PROTOCOL_VERSION = "Protocol-Version: ";
  private static final String HEADER_TYPE = "Type: ";
  private static final String HEADER_V8_VERSION = "V8-Version: ";
  private static final String J2V8_VERSION = "4.0.0";
  private static final String MAKE_BREAK_EVENT = "__j2v8_MakeBreakEvent";
  private static final String MAKE_COMPILE_EVENT = "__j2v8_MakeCompileEvent";
  private static final int PROTOCOL_BUFFER_SIZE = 4096;
  private static final Charset PROTOCOL_CHARSET = Charset.forName("UTF-8");
  private static final byte[] PROTOCOL_CONTENT_LENGTH_BYTES = "Content-Length:".getBytes(PROTOCOL_CHARSET);
  private static final String PROTOCOL_CONTENT_LENGTH_HEADER = "Content-Length:";
  private static final String PROTOCOL_EOL = "\r\n";
  private static final byte[] PROTOCOL_EOL_BYTES = "\r\n".getBytes(PROTOCOL_CHARSET);
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
  
  /* Error */
  public V8DebugServer(V8 paramV8, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 114	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 114	java/lang/Object:<init>	()V
    //   12: putfield 116	com/eclipsesource/v8/debug/V8DebugServer:clientLock	Ljava/lang/Object;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 118	com/eclipsesource/v8/debug/V8DebugServer:traceCommunication	Z
    //   20: aload_0
    //   21: new 120	java/util/LinkedList
    //   24: dup
    //   25: invokespecial 121	java/util/LinkedList:<init>	()V
    //   28: putfield 123	com/eclipsesource/v8/debug/V8DebugServer:requests	Ljava/util/List;
    //   31: aload_0
    //   32: aload_1
    //   33: putfield 125	com/eclipsesource/v8/debug/V8DebugServer:runtime	Lcom/eclipsesource/v8/V8;
    //   36: aload_0
    //   37: iload_3
    //   38: putfield 127	com/eclipsesource/v8/debug/V8DebugServer:waitForConnection	Z
    //   41: aload_1
    //   42: getstatic 87	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   45: invokevirtual 133	com/eclipsesource/v8/V8:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   48: astore 4
    //   50: aload 4
    //   52: ifnonnull +12 -> 64
    //   55: getstatic 139	java/lang/System:err	Ljava/io/PrintStream;
    //   58: ldc 141
    //   60: invokevirtual 147	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   63: return
    //   64: aload_0
    //   65: aload 4
    //   67: ldc 60
    //   69: invokevirtual 150	com/eclipsesource/v8/V8Object:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   72: putfield 152	com/eclipsesource/v8/debug/V8DebugServer:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   75: aload 4
    //   77: invokevirtual 155	com/eclipsesource/v8/V8Object:release	()V
    //   80: aload_1
    //   81: new 157	java/lang/StringBuilder
    //   84: dup
    //   85: ldc 159
    //   87: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: getstatic 87	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   93: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 167
    //   98: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: getstatic 87	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   104: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 169
    //   109: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 87	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   115: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 171
    //   120: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: getstatic 87	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   126: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 173
    //   131: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: getstatic 87	com/eclipsesource/v8/debug/V8DebugServer:DEBUG_OBJECT_NAME	Ljava/lang/String;
    //   137: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 175
    //   142: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 182	com/eclipsesource/v8/V8:executeVoidScript	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: new 184	java/net/ServerSocket
    //   155: dup
    //   156: iload_2
    //   157: invokespecial 187	java/net/ServerSocket:<init>	(I)V
    //   160: putfield 189	com/eclipsesource/v8/debug/V8DebugServer:server	Ljava/net/ServerSocket;
    //   163: return
    //   164: astore_1
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual 193	com/eclipsesource/v8/debug/V8DebugServer:logError	(Ljava/lang/Throwable;)V
    //   170: return
    //   171: astore_1
    //   172: aload 4
    //   174: invokevirtual 155	com/eclipsesource/v8/V8Object:release	()V
    //   177: aload_1
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	V8DebugServer
    //   0	179	1	paramV8	V8
    //   0	179	2	paramInt	int
    //   0	179	3	paramBoolean	boolean
    //   48	125	4	localV8Object	V8Object
    // Exception table:
    //   from	to	target	type
    //   151	163	164	java/lang/Exception
    //   64	75	171	finally
  }
  
  public static void configureV8ForDebugging()
  {
    try
    {
      V8.setFlags("-expose-debug-as=" + DEBUG_OBJECT_NAME);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void enterBreakLoop(V8Object paramV8Object1, V8Object paramV8Object2)
  {
    V8Array localV8Array1;
    try
    {
      localV8Array1 = new V8Array(this.runtime);
      int i;
      V8Array localV8Array2;
      label157:
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
        this.stoppedStateDcp.release();
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
            System.out.println("Sending event (Break):\n" + paramV8Object2);
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
              break label242;
            }
            bool = this.stoppedStateDcp.executeBooleanFunction("isRunning", null);
            if (bool) {
              break label242;
            }
            try
            {
              processRequests(10L);
            }
            catch (InterruptedException paramV8Object1) {}
          }
          break label157;
          paramV8Object1 = finally;
          localV8Array1.release();
          throw paramV8Object1;
        }
        finally
        {
          break label222;
        }
        paramV8Object1 = finally;
      }
      this.stoppedStateDcp = null;
    }
    label222:
    localV8Array1.release();
    if (paramV8Object1 != null) {
      paramV8Object1.release();
    }
    throw paramV8Object2;
    label242:
    this.stoppedStateDcp.release();
    this.stoppedStateDcp = null;
  }
  
  private boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.clientLock)
      {
        if ((this.server != null) && (this.client != null) && (this.client.isConnected()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void processRequest(String paramString)
  {
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
      return;
    }
  }
  
  private void sendCompileEvent(V8Object paramV8Object)
  {
    V8Object localV8Object1 = null;
    if (!isConnected()) {}
    for (;;)
    {
      return;
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
      }
    }
  }
  
  private void sendJson(String paramString)
  {
    sendMessage("", paramString.replace("\\/", "/"));
  }
  
  private void sendMessage(String paramString1, String paramString2)
  {
    synchronized (this.clientLock)
    {
      if (!isConnected()) {
        throw new IOException("There is no connected client.");
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
  }
  
  /* Error */
  private void setupEventHandler()
  {
    // Byte code:
    //   0: new 10	com/eclipsesource/v8/debug/V8DebugServer$EventHandler
    //   3: dup
    //   4: aload_0
    //   5: aconst_null
    //   6: invokespecial 405	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:<init>	(Lcom/eclipsesource/v8/debug/V8DebugServer;Lcom/eclipsesource/v8/debug/V8DebugServer$1;)V
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 152	com/eclipsesource/v8/debug/V8DebugServer:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   14: aload_1
    //   15: ldc 15
    //   17: invokevirtual 409	com/eclipsesource/v8/V8Object:registerJavaMethod	(Lcom/eclipsesource/v8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   20: pop
    //   21: aload_0
    //   22: getfield 152	com/eclipsesource/v8/debug/V8DebugServer:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   25: ldc 15
    //   27: invokevirtual 150	com/eclipsesource/v8/V8Object:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   30: checkcast 411	com/eclipsesource/v8/V8Function
    //   33: astore_1
    //   34: new 249	com/eclipsesource/v8/V8Array
    //   37: dup
    //   38: aload_0
    //   39: getfield 125	com/eclipsesource/v8/debug/V8DebugServer:runtime	Lcom/eclipsesource/v8/V8;
    //   42: invokespecial 252	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   45: aload_1
    //   46: invokevirtual 283	com/eclipsesource/v8/V8Array:push	(Lcom/eclipsesource/v8/V8Value;)Lcom/eclipsesource/v8/V8Array;
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 152	com/eclipsesource/v8/debug/V8DebugServer:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   54: ldc 57
    //   56: aload_2
    //   57: invokevirtual 337	com/eclipsesource/v8/V8Object:executeFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)Ljava/lang/Object;
    //   60: pop
    //   61: aload_1
    //   62: ifnull +14 -> 76
    //   65: aload_1
    //   66: invokevirtual 414	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   69: ifne +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 415	com/eclipsesource/v8/V8Function:release	()V
    //   76: aload_2
    //   77: ifnull +14 -> 91
    //   80: aload_2
    //   81: invokevirtual 416	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   84: ifne +7 -> 91
    //   87: aload_2
    //   88: invokevirtual 265	com/eclipsesource/v8/V8Array:release	()V
    //   91: return
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_3
    //   97: aload_3
    //   98: ifnull +14 -> 112
    //   101: aload_3
    //   102: invokevirtual 414	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   105: ifne +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 415	com/eclipsesource/v8/V8Function:release	()V
    //   112: aload_2
    //   113: ifnull +14 -> 127
    //   116: aload_2
    //   117: invokevirtual 416	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   120: ifne +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 265	com/eclipsesource/v8/V8Array:release	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_1
    //   134: astore_3
    //   135: aload 4
    //   137: astore_1
    //   138: goto -41 -> 97
    //   141: astore 4
    //   143: aload_1
    //   144: astore_3
    //   145: aload 4
    //   147: astore_1
    //   148: goto -51 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	V8DebugServer
    //   9	64	1	localObject1	Object
    //   92	42	1	localObject2	Object
    //   137	11	1	localObject3	Object
    //   49	84	2	localV8Array	V8Array
    //   96	49	3	localObject4	Object
    //   129	7	4	localObject5	Object
    //   141	5	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	92	finally
    //   34	50	129	finally
    //   50	61	141	finally
  }
  
  public int getPort()
  {
    if ((this.server != null) && (this.server.isBound())) {
      return this.server.getLocalPort();
    }
    return -1;
  }
  
  protected void logError(Throwable paramThrowable) {}
  
  public void processRequests(long paramLong)
  {
    if (this.server == null) {
      return;
    }
    long l = System.currentTimeMillis();
    label111:
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
              break label111;
            }
            ??? = arrayOfString[i];
          }
          try
          {
            processRequest(???);
            i += 1;
            continue;
            localObject = finally;
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
      if (paramLong <= 0L) {
        break;
      }
    } while (l + paramLong > System.currentTimeMillis());
  }
  
  public void setTraceCommunication(boolean paramBoolean)
  {
    this.traceCommunication = paramBoolean;
  }
  
  public void start()
  {
    if (this.server == null) {}
    boolean bool;
    do
    {
      return;
      bool = this.waitForConnection;
      ??? = new Thread(new V8DebugServer.ClientLoop(this, null), "J2V8 Debugger Server");
      ((Thread)???).setDaemon(true);
      ((Thread)???).start();
      setupEventHandler();
      this.runningStateDcp = this.runtime.executeObjectScript("(function() {return new " + DEBUG_OBJECT_NAME + ".DebugCommandProcessor(null, true)})()");
    } while (!bool);
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
      try
      {
        processRequests(100L);
        return;
      }
      catch (InterruptedException localInterruptedException1) {}
    }
  }
  
  public void stop()
  {
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
        return;
      }
    }
  }
  
  private class EventHandler
    implements JavaVoidCallback
  {
    private EventHandler() {}
    
    private void safeRelease(Releasable paramReleasable)
    {
      if (paramReleasable != null) {
        paramReleasable.release();
      }
    }
    
    /* Error */
    public void invoke(V8Object paramV8Object, V8Array paramV8Array)
    {
      // Byte code:
      //   0: aload_2
      //   1: ifnull +10 -> 11
      //   4: aload_2
      //   5: invokevirtual 39	com/eclipsesource/v8/V8Array:isUndefined	()Z
      //   8: ifeq +4 -> 12
      //   11: return
      //   12: aload_2
      //   13: iconst_0
      //   14: invokevirtual 43	com/eclipsesource/v8/V8Array:getInteger	(I)I
      //   17: istore_3
      //   18: aload_2
      //   19: iconst_1
      //   20: invokevirtual 47	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
      //   23: astore 5
      //   25: aload_2
      //   26: iconst_2
      //   27: invokevirtual 47	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
      //   30: astore_2
      //   31: aload_2
      //   32: astore 6
      //   34: aload 5
      //   36: astore 7
      //   38: aload_0
      //   39: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   42: invokestatic 51	com/eclipsesource/v8/debug/V8DebugServer:access$200	(Lcom/eclipsesource/v8/debug/V8DebugServer;)Z
      //   45: ifeq +84 -> 129
      //   48: ldc 53
      //   50: astore_1
      //   51: iload_3
      //   52: tableswitch	default:+295 -> 347, 1:+110->162, 2:+298->350, 3:+304->356, 4:+310->362, 5:+316->368, 6:+322->374, 7:+328->380, 8:+116->168
      //   101: astore 6
      //   103: aload 5
      //   105: astore 7
      //   107: getstatic 59	java/lang/System:out	Ljava/io/PrintStream;
      //   110: new 61	java/lang/StringBuilder
      //   113: dup
      //   114: ldc 63
      //   116: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   119: aload_1
      //   120: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   126: invokevirtual 79	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   129: aload_2
      //   130: astore 6
      //   132: aload 5
      //   134: astore 7
      //   136: aload_0
      //   137: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   140: invokestatic 82	com/eclipsesource/v8/debug/V8DebugServer:access$300	(Lcom/eclipsesource/v8/debug/V8DebugServer;)Z
      //   143: istore 4
      //   145: iload 4
      //   147: ifne +27 -> 174
      //   150: aload_0
      //   151: aload 5
      //   153: invokespecial 84	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   156: aload_0
      //   157: aload_2
      //   158: invokespecial 84	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   161: return
      //   162: ldc 86
      //   164: astore_1
      //   165: goto -65 -> 100
      //   168: ldc 88
      //   170: astore_1
      //   171: goto -71 -> 100
      //   174: iload_3
      //   175: tableswitch	default:+37 -> 212, 1:+49->224, 2:+37->212, 3:+37->212, 4:+37->212, 5:+103->278, 6:+103->278
      //   213: aload 5
      //   215: invokespecial 84	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   218: aload_0
      //   219: aload_2
      //   220: invokespecial 84	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   223: return
      //   224: aload_2
      //   225: astore 6
      //   227: aload 5
      //   229: astore 7
      //   231: aload_0
      //   232: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   235: aload 5
      //   237: aload_2
      //   238: invokestatic 92	com/eclipsesource/v8/debug/V8DebugServer:access$400	(Lcom/eclipsesource/v8/debug/V8DebugServer;Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8Object;)V
      //   241: goto -29 -> 212
      //   244: astore 6
      //   246: aload_2
      //   247: astore_1
      //   248: aload 6
      //   250: astore_2
      //   251: aload_1
      //   252: astore 6
      //   254: aload 5
      //   256: astore 7
      //   258: aload_0
      //   259: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   262: aload_2
      //   263: invokevirtual 96	com/eclipsesource/v8/debug/V8DebugServer:logError	(Ljava/lang/Throwable;)V
      //   266: aload_0
      //   267: aload 5
      //   269: invokespecial 84	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   272: aload_0
      //   273: aload_1
      //   274: invokespecial 84	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   277: return
      //   278: aload_2
      //   279: astore 6
      //   281: aload 5
      //   283: astore 7
      //   285: aload_0
      //   286: getfield 15	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:this$0	Lcom/eclipsesource/v8/debug/V8DebugServer;
      //   289: aload_2
      //   290: invokestatic 100	com/eclipsesource/v8/debug/V8DebugServer:access$500	(Lcom/eclipsesource/v8/debug/V8DebugServer;Lcom/eclipsesource/v8/V8Object;)V
      //   293: goto -81 -> 212
      //   296: astore_1
      //   297: aload 7
      //   299: astore 5
      //   301: aload_0
      //   302: aload 5
      //   304: invokespecial 84	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   307: aload_0
      //   308: aload 6
      //   310: invokespecial 84	com/eclipsesource/v8/debug/V8DebugServer$EventHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   313: aload_1
      //   314: athrow
      //   315: astore_1
      //   316: aconst_null
      //   317: astore 6
      //   319: aconst_null
      //   320: astore 5
      //   322: goto -21 -> 301
      //   325: astore_1
      //   326: aconst_null
      //   327: astore 6
      //   329: goto -28 -> 301
      //   332: astore_2
      //   333: aconst_null
      //   334: astore_1
      //   335: aconst_null
      //   336: astore 5
      //   338: goto -87 -> 251
      //   341: astore_2
      //   342: aconst_null
      //   343: astore_1
      //   344: goto -93 -> 251
      //   347: goto -247 -> 100
      //   350: ldc 102
      //   352: astore_1
      //   353: goto -253 -> 100
      //   356: ldc 104
      //   358: astore_1
      //   359: goto -259 -> 100
      //   362: ldc 106
      //   364: astore_1
      //   365: goto -265 -> 100
      //   368: ldc 108
      //   370: astore_1
      //   371: goto -271 -> 100
      //   374: ldc 110
      //   376: astore_1
      //   377: goto -277 -> 100
      //   380: ldc 112
      //   382: astore_1
      //   383: goto -283 -> 100
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	386	0	this	EventHandler
      //   0	386	1	paramV8Object	V8Object
      //   0	386	2	paramV8Array	V8Array
      //   17	158	3	i	int
      //   143	3	4	bool	boolean
      //   23	314	5	localObject1	Object
      //   32	194	6	localV8Array	V8Array
      //   244	5	6	localException	Exception
      //   252	76	6	localObject2	Object
      //   36	262	7	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   38	48	244	java/lang/Exception
      //   107	129	244	java/lang/Exception
      //   136	145	244	java/lang/Exception
      //   231	241	244	java/lang/Exception
      //   285	293	244	java/lang/Exception
      //   38	48	296	finally
      //   107	129	296	finally
      //   136	145	296	finally
      //   231	241	296	finally
      //   258	266	296	finally
      //   285	293	296	finally
      //   12	25	315	finally
      //   25	31	325	finally
      //   12	25	332	java/lang/Exception
      //   25	31	341	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.v8.debug.V8DebugServer
 * JD-Core Version:    0.7.0.1
 */