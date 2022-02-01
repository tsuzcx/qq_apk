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
  private int port;
  protected f rjf;
  protected h rjg;
  protected List<NetworkInterface> rjh;
  protected InetSocketAddress rji;
  protected MulticastSocket rjj;
  protected MulticastSocket rjk;
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
    this.rjf = paramf;
    this.port = paramInt;
    a(paramList, paramh);
    AppMethodBeat.o(158980);
  }
  
  private void a(List<NetworkInterface> paramList, h paramh)
  {
    AppMethodBeat.i(158981);
    this.rjg = paramh;
    this.rjh = paramList;
    try
    {
      this.rjj = new MulticastSocket(this.port);
      this.rjj.setReuseAddress(true);
      this.rjj.setReceiveBufferSize(32768);
      a.i(TAG, "Creating wildcard socketNotify (for receiving multicast datagrams) on port: " + this.rjf.port);
      this.rji = new InetSocketAddress(this.rjf.rjn, this.rjf.port);
      this.rjk = new MulticastSocket(this.rjf.port);
      this.rjk.setReuseAddress(true);
      this.rjk.setReceiveBufferSize(32768);
      paramList = this.rjh.iterator();
      while (paramList.hasNext())
      {
        paramh = (NetworkInterface)paramList.next();
        a.i(TAG, "Joining multicast group: " + this.rji + " on network interface: " + paramh.getDisplayName());
        this.rjk.joinGroup(this.rji, paramh);
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
      if ((this.rjj != null) && (!this.rjj.isClosed())) {
        this.rjj.close();
      }
      if (this.rjk != null)
      {
        boolean bool = this.rjk.isClosed();
        if (!bool) {
          try
          {
            a.i(TAG, "Leaving multicast group");
            Iterator localIterator = this.rjh.iterator();
            while (localIterator.hasNext())
            {
              NetworkInterface localNetworkInterface = (NetworkInterface)localIterator.next();
              this.rjk.leaveGroup(this.rji, localNetworkInterface);
            }
            AppMethodBeat.o(158983);
          }
          catch (Exception localException)
          {
            a.i(TAG, "Could not leave multicast group: ".concat(String.valueOf(localException)));
            this.rjk.close();
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
    //   2: ldc_w 262
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 56	com/tencent/mm/plugin/appbrand/g/c/e:running	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 262
    //   18: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 56	com/tencent/mm/plugin/appbrand/g/c/e:running	Z
    //   29: new 264	java/lang/Thread
    //   32: dup
    //   33: new 9	com/tencent/mm/plugin/appbrand/g/c/e$b
    //   36: dup
    //   37: aload_0
    //   38: iconst_0
    //   39: invokespecial 267	com/tencent/mm/plugin/appbrand/g/c/e$b:<init>	(Lcom/tencent/mm/plugin/appbrand/g/c/e;B)V
    //   42: invokespecial 270	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   45: invokevirtual 272	java/lang/Thread:start	()V
    //   48: new 264	java/lang/Thread
    //   51: dup
    //   52: new 6	com/tencent/mm/plugin/appbrand/g/c/e$a
    //   55: dup
    //   56: aload_0
    //   57: iconst_0
    //   58: invokespecial 273	com/tencent/mm/plugin/appbrand/g/c/e$a:<init>	(Lcom/tencent/mm/plugin/appbrand/g/c/e;B)V
    //   61: invokespecial 270	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   64: invokevirtual 272	java/lang/Thread:start	()V
    //   67: ldc_w 262
    //   70: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: goto -52 -> 21
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	e
    //   76	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	76	finally
    //   24	73	76	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.e
 * JD-Core Version:    0.7.0.1
 */