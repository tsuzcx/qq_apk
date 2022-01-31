package com.tencent.mm.plugin.appbrand.w;

import com.tencent.mm.plugin.appbrand.w.d.d.a;
import com.tencent.mm.plugin.appbrand.w.e.h;
import com.tencent.mm.plugin.appbrand.w.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class c
  implements a
{
  public static boolean DEBUG;
  public static int hmj = 16384;
  public static final List<com.tencent.mm.plugin.appbrand.w.b.a> hmk;
  private Boolean hmA = null;
  public String hmB = null;
  public SelectionKey hml;
  public ByteChannel hmm;
  public final BlockingQueue<ByteBuffer> hmn;
  public final BlockingQueue<ByteBuffer> hmo;
  private volatile boolean hmp = false;
  private a.a hmq = a.a.hlZ;
  public final d hmr;
  private List<com.tencent.mm.plugin.appbrand.w.b.a> hms;
  public com.tencent.mm.plugin.appbrand.w.b.a hmt = null;
  public a.b hmu;
  private d.a hmv = null;
  private ByteBuffer hmw = ByteBuffer.allocate(0);
  public com.tencent.mm.plugin.appbrand.w.e.a hmx = null;
  private String hmy = null;
  private Integer hmz = null;
  
  static
  {
    DEBUG = false;
    ArrayList localArrayList = new ArrayList(4);
    hmk = localArrayList;
    localArrayList.add(new com.tencent.mm.plugin.appbrand.w.b.c());
    hmk.add(new com.tencent.mm.plugin.appbrand.w.b.b());
    hmk.add(new com.tencent.mm.plugin.appbrand.w.b.d());
  }
  
  public c(d paramd, com.tencent.mm.plugin.appbrand.w.b.a parama)
  {
    if ((paramd == null) || ((parama == null) && (this.hmu == a.b.hmg))) {
      throw new IllegalArgumentException("parameters must not be null");
    }
    this.hmn = new LinkedBlockingQueue();
    this.hmo = new LinkedBlockingQueue();
    this.hmr = paramd;
    this.hmu = a.b.hmf;
    if (parama != null) {
      this.hmt = parama.aqI();
    }
  }
  
  private void a(com.tencent.mm.plugin.appbrand.w.c.b paramb)
  {
    d(paramb.hne, paramb.getMessage(), false);
  }
  
  private void c(com.tencent.mm.plugin.appbrand.w.e.f paramf)
  {
    if (DEBUG) {
      y.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.hmt.getClass().getSimpleName());
    }
    this.hmq = a.a.hmb;
    try
    {
      this.hmr.d(paramf);
      return;
    }
    catch (RuntimeException paramf)
    {
      this.hmr.e(paramf);
    }
  }
  
  /* Error */
  private void e(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/tencent/mm/plugin/appbrand/w/c:hmp	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: putfield 104	com/tencent/mm/plugin/appbrand/w/c:hmz	Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 102	com/tencent/mm/plugin/appbrand/w/c:hmy	Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic 210	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: putfield 106	com/tencent/mm/plugin/appbrand/w/c:hmA	Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 79	com/tencent/mm/plugin/appbrand/w/c:hmp	Z
    //   42: aload_0
    //   43: getfield 88	com/tencent/mm/plugin/appbrand/w/c:hmt	Lcom/tencent/mm/plugin/appbrand/w/b/a;
    //   46: ifnull +10 -> 56
    //   49: aload_0
    //   50: getfield 88	com/tencent/mm/plugin/appbrand/w/c:hmt	Lcom/tencent/mm/plugin/appbrand/w/b/a;
    //   53: invokevirtual 213	com/tencent/mm/plugin/appbrand/w/b/a:reset	()V
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 100	com/tencent/mm/plugin/appbrand/w/c:hmx	Lcom/tencent/mm/plugin/appbrand/w/e/a;
    //   61: goto -48 -> 13
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	c
    //   0	69	1	paramInt	int
    //   0	69	2	paramString	String
    //   0	69	3	paramBoolean	boolean
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	64	finally
    //   16	56	64	finally
    //   56	61	64	finally
  }
  
  private boolean m(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer;
    if (this.hmw.capacity() == 0) {
      localByteBuffer = paramByteBuffer;
    }
    for (;;)
    {
      localByteBuffer.mark();
      try
      {
        if (this.hmu == a.b.hmg) {
          if (this.hmt == null)
          {
            Iterator localIterator = this.hms.iterator();
            label47:
            if (localIterator.hasNext())
            {
              com.tencent.mm.plugin.appbrand.w.b.a locala1 = ((com.tencent.mm.plugin.appbrand.w.b.a)localIterator.next()).aqI();
              try
              {
                locala1.a(this.hmu);
                localByteBuffer.reset();
                Object localObject2 = locala1.t(localByteBuffer);
                if (!(localObject2 instanceof com.tencent.mm.plugin.appbrand.w.e.a))
                {
                  e(1002, "wrong http function", false);
                  return false;
                  if (this.hmw.remaining() < paramByteBuffer.remaining())
                  {
                    localByteBuffer = ByteBuffer.allocate(this.hmw.capacity() + paramByteBuffer.remaining());
                    this.hmw.flip();
                    localByteBuffer.put(this.hmw);
                    this.hmw = localByteBuffer;
                  }
                  this.hmw.put(paramByteBuffer);
                  this.hmw.flip();
                  localByteBuffer = this.hmw;
                  continue;
                }
                localObject2 = (com.tencent.mm.plugin.appbrand.w.e.a)localObject2;
                if (locala1.c((com.tencent.mm.plugin.appbrand.w.e.a)localObject2) != com.tencent.mm.plugin.appbrand.w.b.a.b.hmV) {
                  break label47;
                }
                this.hmB = ((com.tencent.mm.plugin.appbrand.w.e.a)localObject2).aqO();
                try
                {
                  i locali = this.hmr.aqD();
                  aD(com.tencent.mm.plugin.appbrand.w.b.a.e(locala1.a((com.tencent.mm.plugin.appbrand.w.e.a)localObject2, locali)));
                  this.hmt = locala1;
                  c((com.tencent.mm.plugin.appbrand.w.e.f)localObject2);
                  return true;
                }
                catch (com.tencent.mm.plugin.appbrand.w.c.b localb)
                {
                  e(localb.hne, localb.getMessage(), false);
                  return false;
                }
                catch (RuntimeException localRuntimeException)
                {
                  this.hmr.e(localRuntimeException);
                  e(-1, localRuntimeException.getMessage(), false);
                  return false;
                }
              }
              catch (com.tencent.mm.plugin.appbrand.w.c.d locald2)
              {
                y.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + locald2.toString());
              }
            }
          }
        }
        Object localObject1;
        int j;
        int i;
        return false;
      }
      catch (com.tencent.mm.plugin.appbrand.w.c.d locald1)
      {
        y.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + locald1.toString());
        a(locald1);
        for (;;)
        {
          return false;
          if (this.hmt != null) {
            break;
          }
          d(1002, "no draft matches", false);
          break;
          localObject1 = this.hmt.t(localByteBuffer);
          if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.w.e.a))
          {
            e(1002, "wrong http function", false);
            return false;
          }
          localObject1 = (com.tencent.mm.plugin.appbrand.w.e.a)localObject1;
          if (this.hmt.c((com.tencent.mm.plugin.appbrand.w.e.a)localObject1) == com.tencent.mm.plugin.appbrand.w.b.a.b.hmV)
          {
            c((com.tencent.mm.plugin.appbrand.w.e.f)localObject1);
            return true;
          }
          d(1002, "the handshake did finaly not match", false);
          return false;
          if (this.hmu == a.b.hmf)
          {
            this.hmt.a(this.hmu);
            localObject1 = this.hmt.t(localByteBuffer);
            if (!(localObject1 instanceof h))
            {
              e(1002, "wrong http function", false);
              return false;
            }
            localObject1 = (h)localObject1;
            if (this.hmt.a(this.hmx, (h)localObject1) == com.tencent.mm.plugin.appbrand.w.b.a.b.hmV)
            {
              c((com.tencent.mm.plugin.appbrand.w.e.f)localObject1);
              return true;
            }
            d(1002, "draft refuses handshake" + ((h)localObject1).aqP(), false);
          }
        }
      }
      catch (com.tencent.mm.plugin.appbrand.w.c.a locala)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + locala.toString());
          if (this.hmw.capacity() == 0)
          {
            localByteBuffer.reset();
            j = locala.hnd;
            i = j;
            if (j == 0) {
              i = localByteBuffer.capacity() + 16;
            }
            this.hmw = ByteBuffer.allocate(i);
            this.hmw.put(paramByteBuffer);
          }
          else
          {
            this.hmw.position(this.hmw.limit());
            this.hmw.limit(this.hmw.capacity());
          }
        }
      }
    }
  }
  
  private void n(ByteBuffer paramByteBuffer)
  {
    for (;;)
    {
      d.a locala1;
      boolean bool;
      int i;
      try
      {
        Iterator localIterator = this.hmt.s(paramByteBuffer).iterator();
        if (localIterator.hasNext())
        {
          paramByteBuffer = (com.tencent.mm.plugin.appbrand.w.d.d)localIterator.next();
          if (DEBUG) {
            y.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: " + paramByteBuffer);
          }
          locala1 = paramByteBuffer.aqN();
          bool = paramByteBuffer.aqL();
          if (locala1 != d.a.hnm) {
            break label211;
          }
          i = 1005;
          if (!(paramByteBuffer instanceof com.tencent.mm.plugin.appbrand.w.d.a)) {
            break label480;
          }
          paramByteBuffer = (com.tencent.mm.plugin.appbrand.w.d.a)paramByteBuffer;
          i = paramByteBuffer.aqJ();
          paramByteBuffer = paramByteBuffer.getMessage();
          if (this.hmq == a.a.hmc) {
            Q(i, paramByteBuffer);
          }
        }
        else
        {
          return;
        }
      }
      catch (com.tencent.mm.plugin.appbrand.w.c.b paramByteBuffer)
      {
        y.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + paramByteBuffer.toString());
        this.hmr.e(paramByteBuffer);
        a(paramByteBuffer);
      }
      if (this.hmt.aqH() == com.tencent.mm.plugin.appbrand.w.b.a.a.hmT)
      {
        d(i, paramByteBuffer, true);
      }
      else
      {
        e(i, paramByteBuffer, false);
        continue;
        label211:
        if (locala1 == d.a.hnk)
        {
          this.hmr.a(this, paramByteBuffer);
        }
        else if (locala1 != d.a.hnl)
        {
          if ((!bool) || (locala1 == d.a.hnh))
          {
            if (locala1 != d.a.hnh)
            {
              if (this.hmv != null) {
                throw new com.tencent.mm.plugin.appbrand.w.c.b("Previous continuous frame sequence not completed.");
              }
              this.hmv = locala1;
            }
            label342:
            do
            {
              for (;;)
              {
                try
                {
                  this.hmr.c(paramByteBuffer);
                }
                catch (RuntimeException paramByteBuffer)
                {
                  this.hmr.e(paramByteBuffer);
                }
                break;
                if (!bool) {
                  break label342;
                }
                if (this.hmv == null) {
                  throw new com.tencent.mm.plugin.appbrand.w.c.b("Continuous frame sequence was not started.");
                }
                this.hmv = null;
              }
            } while (this.hmv != null);
            throw new com.tencent.mm.plugin.appbrand.w.c.b("Continuous frame sequence was not started.");
          }
          if (this.hmv != null) {
            throw new com.tencent.mm.plugin.appbrand.w.c.b("Continuous frame sequence not completed.");
          }
          d.a locala2 = d.a.hni;
          if (locala1 == locala2)
          {
            try
            {
              this.hmr.wN(com.tencent.mm.plugin.appbrand.w.f.b.w(paramByteBuffer.aqK()));
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.hmr.e(paramByteBuffer);
            }
          }
          else
          {
            locala2 = d.a.hnj;
            if (locala1 == locala2)
            {
              try
              {
                this.hmr.p(paramByteBuffer.aqK());
              }
              catch (RuntimeException paramByteBuffer)
              {
                this.hmr.e(paramByteBuffer);
              }
            }
            else
            {
              throw new com.tencent.mm.plugin.appbrand.w.c.b("non control or continious frame expected");
              label480:
              paramByteBuffer = "";
            }
          }
        }
      }
    }
  }
  
  private void o(ByteBuffer paramByteBuffer)
  {
    if (DEBUG) {
      y.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
    }
    this.hmn.add(paramByteBuffer);
  }
  
  /* Error */
  public final void Q(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/tencent/mm/plugin/appbrand/w/c:hmq	Lcom/tencent/mm/plugin/appbrand/w/a$a;
    //   6: astore_3
    //   7: getstatic 443	com/tencent/mm/plugin/appbrand/w/a$a:hmd	Lcom/tencent/mm/plugin/appbrand/w/a$a;
    //   10: astore 4
    //   12: aload_3
    //   13: aload 4
    //   15: if_acmpne +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 445	com/tencent/mm/plugin/appbrand/w/c:hml	Ljava/nio/channels/SelectionKey;
    //   25: ifnull +10 -> 35
    //   28: aload_0
    //   29: getfield 445	com/tencent/mm/plugin/appbrand/w/c:hml	Ljava/nio/channels/SelectionKey;
    //   32: invokevirtual 450	java/nio/channels/SelectionKey:cancel	()V
    //   35: aload_0
    //   36: getfield 452	com/tencent/mm/plugin/appbrand/w/c:hmm	Ljava/nio/channels/ByteChannel;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +12 -> 53
    //   44: aload_0
    //   45: getfield 452	com/tencent/mm/plugin/appbrand/w/c:hmm	Ljava/nio/channels/ByteChannel;
    //   48: invokeinterface 457 1 0
    //   53: aload_0
    //   54: getfield 131	com/tencent/mm/plugin/appbrand/w/c:hmr	Lcom/tencent/mm/plugin/appbrand/w/d;
    //   57: iload_1
    //   58: aload_2
    //   59: invokeinterface 460 3 0
    //   64: aload_0
    //   65: getfield 88	com/tencent/mm/plugin/appbrand/w/c:hmt	Lcom/tencent/mm/plugin/appbrand/w/b/a;
    //   68: ifnull +10 -> 78
    //   71: aload_0
    //   72: getfield 88	com/tencent/mm/plugin/appbrand/w/c:hmt	Lcom/tencent/mm/plugin/appbrand/w/b/a;
    //   75: invokevirtual 213	com/tencent/mm/plugin/appbrand/w/b/a:reset	()V
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 100	com/tencent/mm/plugin/appbrand/w/c:hmx	Lcom/tencent/mm/plugin/appbrand/w/e/a;
    //   83: aload_0
    //   84: getstatic 443	com/tencent/mm/plugin/appbrand/w/a$a:hmd	Lcom/tencent/mm/plugin/appbrand/w/a$a;
    //   87: putfield 86	com/tencent/mm/plugin/appbrand/w/c:hmq	Lcom/tencent/mm/plugin/appbrand/w/a$a;
    //   90: aload_0
    //   91: getfield 127	com/tencent/mm/plugin/appbrand/w/c:hmn	Ljava/util/concurrent/BlockingQueue;
    //   94: invokeinterface 463 1 0
    //   99: goto -81 -> 18
    //   102: astore_2
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 131	com/tencent/mm/plugin/appbrand/w/c:hmr	Lcom/tencent/mm/plugin/appbrand/w/d;
    //   112: aload_3
    //   113: invokeinterface 199 2 0
    //   118: goto -65 -> 53
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 131	com/tencent/mm/plugin/appbrand/w/c:hmr	Lcom/tencent/mm/plugin/appbrand/w/d;
    //   126: aload_2
    //   127: invokeinterface 199 2 0
    //   132: goto -68 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	c
    //   0	135	1	paramInt	int
    //   0	135	2	paramString	String
    //   6	35	3	localObject	Object
    //   107	6	3	localIOException	java.io.IOException
    //   10	4	4	locala	a.a
    // Exception table:
    //   from	to	target	type
    //   2	12	102	finally
    //   21	35	102	finally
    //   35	40	102	finally
    //   44	53	102	finally
    //   53	64	102	finally
    //   64	78	102	finally
    //   78	99	102	finally
    //   108	118	102	finally
    //   122	132	102	finally
    //   44	53	107	java/io/IOException
    //   53	64	121	java/lang/RuntimeException
  }
  
  public final void aD(List<ByteBuffer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      o((ByteBuffer)paramList.next());
    }
  }
  
  public final void aqE()
  {
    if (this.hmq == a.a.hlZ)
    {
      Q(-1, "");
      return;
    }
    if (this.hmp)
    {
      int i = this.hmz.intValue();
      String str = this.hmy;
      this.hmA.booleanValue();
      Q(i, str);
      return;
    }
    if (this.hmt.aqH() == com.tencent.mm.plugin.appbrand.w.b.a.a.hmR)
    {
      Q(1000, "");
      return;
    }
    if ((this.hmt.aqH() == com.tencent.mm.plugin.appbrand.w.b.a.a.hmS) && (this.hmu != a.b.hmg))
    {
      Q(1000, "");
      return;
    }
    Q(1006, "");
  }
  
  public final boolean aqF()
  {
    return this.hmq == a.a.hmc;
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.w.d.d paramd)
  {
    if (DEBUG) {
      y.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
    }
    o(this.hmt.d(paramd));
  }
  
  public final void d(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.hmq != a.a.hmc) && (this.hmq != a.a.hmd))
    {
      if (this.hmq != a.a.hmb) {
        break label165;
      }
      if (paramInt == 1006)
      {
        this.hmq = a.a.hmc;
        e(paramInt, paramString, false);
      }
    }
    else
    {
      return;
    }
    if (this.hmt.aqH() != com.tencent.mm.plugin.appbrand.w.b.a.a.hmR) {}
    for (;;)
    {
      try
      {
        b(new com.tencent.mm.plugin.appbrand.w.d.b(paramInt, paramString));
        e(paramInt, paramString, paramBoolean);
        if (paramInt == 1002) {
          e(paramInt, paramString, paramBoolean);
        }
        this.hmq = a.a.hmc;
        this.hmw = null;
        return;
      }
      catch (com.tencent.mm.plugin.appbrand.w.c.b localb)
      {
        y.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + localb.toString());
        this.hmr.e(localb);
        e(1006, "generated frame is invalid", false);
        continue;
      }
      label165:
      if (paramInt == -3) {
        e(-3, paramString, true);
      } else {
        e(-1, paramString, false);
      }
    }
  }
  
  public final void d(Collection<com.tencent.mm.plugin.appbrand.w.d.d> paramCollection)
  {
    if (!isOpen()) {
      throw new com.tencent.mm.plugin.appbrand.w.c.f();
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      b((com.tencent.mm.plugin.appbrand.w.d.d)paramCollection.next());
    }
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final boolean isClosed()
  {
    return this.hmq == a.a.hmd;
  }
  
  public final boolean isOpen()
  {
    return this.hmq == a.a.hmb;
  }
  
  public final void l(ByteBuffer paramByteBuffer)
  {
    if (DEBUG) {
      y.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
    }
    if (this.hmq != a.a.hlZ) {
      if (this.hmq == a.a.hmb) {
        n(paramByteBuffer);
      }
    }
    do
    {
      do
      {
        return;
      } while ((!m(paramByteBuffer)) || (aqF()) || (isClosed()));
      if (paramByteBuffer.hasRemaining())
      {
        n(paramByteBuffer);
        return;
      }
    } while (!this.hmw.hasRemaining());
    n(this.hmw);
  }
  
  public final String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.c
 * JD-Core Version:    0.7.0.1
 */