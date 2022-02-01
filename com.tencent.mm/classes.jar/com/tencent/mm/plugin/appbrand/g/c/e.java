package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static final String TAG;
  protected f kdP;
  protected h kdQ;
  protected List<NetworkInterface> kdR;
  protected InetSocketAddress kdS;
  protected MulticastSocket kdT;
  protected MulticastSocket kdU;
  private int port;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(158986);
    TAG = e.class.getSimpleName();
    AppMethodBeat.o(158986);
  }
  
  public e(f paramf, List<NetworkInterface> paramList, h paramh, int paramInt)
  {
    AppMethodBeat.i(158980);
    this.running = false;
    this.kdP = paramf;
    this.port = paramInt;
    a(paramList, paramh);
    AppMethodBeat.o(158980);
  }
  
  private void a(List<NetworkInterface> paramList, h paramh)
  {
    AppMethodBeat.i(158981);
    this.kdQ = paramh;
    this.kdR = paramList;
    try
    {
      this.kdT = new MulticastSocket(this.port);
      this.kdT.setReuseAddress(true);
      this.kdT.setReceiveBufferSize(32768);
      a.i(TAG, "Creating wildcard socketNotify (for receiving multicast datagrams) on port: " + this.kdP.port);
      this.kdS = new InetSocketAddress(this.kdP.kdX, this.kdP.port);
      this.kdU = new MulticastSocket(this.kdP.port);
      this.kdU.setReuseAddress(true);
      this.kdU.setReceiveBufferSize(32768);
      paramList = this.kdR.iterator();
      while (paramList.hasNext())
      {
        paramh = (NetworkInterface)paramList.next();
        a.i(TAG, "Joining multicast group: " + this.kdS + " on network interface: " + paramh.getDisplayName());
        this.kdU.joinGroup(this.kdS, paramh);
      }
      AppMethodBeat.o(158981);
    }
    catch (Exception paramList)
    {
      paramList = new Exception("Could not initialize " + TAG + ": " + paramList);
      AppMethodBeat.o(158981);
      throw paramList;
    }
  }
  
  public final void close()
  {
    try
    {
      AppMethodBeat.i(158983);
      this.running = false;
      if ((this.kdT != null) && (!this.kdT.isClosed())) {
        this.kdT.close();
      }
      if (this.kdU != null)
      {
        boolean bool = this.kdU.isClosed();
        if (!bool) {
          try
          {
            a.i(TAG, "Leaving multicast group");
            Iterator localIterator = this.kdR.iterator();
            while (localIterator.hasNext())
            {
              NetworkInterface localNetworkInterface = (NetworkInterface)localIterator.next();
              this.kdU.leaveGroup(this.kdS, localNetworkInterface);
            }
            AppMethodBeat.o(158983);
          }
          catch (Exception localException)
          {
            a.i(TAG, "Could not leave multicast group: ".concat(String.valueOf(localException)));
            this.kdU.close();
          }
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 250
    //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 56	com/tencent/mm/plugin/appbrand/g/c/e:running	Z
    //   11: ifeq +11 -> 22
    //   14: ldc 250
    //   16: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 56	com/tencent/mm/plugin/appbrand/g/c/e:running	Z
    //   27: new 252	java/lang/Thread
    //   30: dup
    //   31: new 9	com/tencent/mm/plugin/appbrand/g/c/e$b
    //   34: dup
    //   35: aload_0
    //   36: iconst_0
    //   37: invokespecial 255	com/tencent/mm/plugin/appbrand/g/c/e$b:<init>	(Lcom/tencent/mm/plugin/appbrand/g/c/e;B)V
    //   40: invokespecial 258	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   43: invokevirtual 260	java/lang/Thread:start	()V
    //   46: new 252	java/lang/Thread
    //   49: dup
    //   50: new 6	com/tencent/mm/plugin/appbrand/g/c/e$a
    //   53: dup
    //   54: aload_0
    //   55: iconst_0
    //   56: invokespecial 261	com/tencent/mm/plugin/appbrand/g/c/e$a:<init>	(Lcom/tencent/mm/plugin/appbrand/g/c/e;B)V
    //   59: invokespecial 258	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   62: invokevirtual 260	java/lang/Thread:start	()V
    //   65: ldc 250
    //   67: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -51 -> 19
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	e
    //   73	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	73	finally
    //   22	70	73	finally
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(158978);
      try
      {
        e.b(e.this);
        AppMethodBeat.o(158978);
        return;
      }
      catch (Exception localException)
      {
        if (localException.getCause() != null) {
          a.e(e.TAG, localException.getCause().toString());
        }
        AppMethodBeat.o(158978);
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(158979);
      try
      {
        e.a(e.this);
        AppMethodBeat.o(158979);
        return;
      }
      catch (Exception localException)
      {
        if (localException.getCause() != null) {
          a.e(e.TAG, localException.getCause().toString());
        }
        AppMethodBeat.o(158979);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.e
 * JD-Core Version:    0.7.0.1
 */