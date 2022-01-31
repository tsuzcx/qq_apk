package com.tencent.mm.plugin.appbrand.u.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.d.d.a;
import com.tencent.mm.plugin.appbrand.u.e.c;
import com.tencent.mm.plugin.appbrand.u.e.e;
import com.tencent.mm.plugin.appbrand.u.e.f;
import com.tencent.mm.plugin.appbrand.u.e.h;
import com.tencent.mm.plugin.appbrand.u.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a
{
  public static int iZm = 1000;
  public static int iZn = 64;
  public static final byte[] iZo = com.tencent.mm.plugin.appbrand.u.f.b.FA("");
  protected com.tencent.mm.plugin.appbrand.u.a.b iYT = null;
  protected d.a iZp = null;
  
  public static List<ByteBuffer> e(f paramf)
  {
    return f(paramf);
  }
  
  public static List<ByteBuffer> f(f paramf)
  {
    Object localObject1 = new StringBuilder(100);
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.u.e.a))
    {
      ((StringBuilder)localObject1).append("GET ");
      ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.appbrand.u.e.a)paramf).aOp());
      ((StringBuilder)localObject1).append(" HTTP/1.1");
    }
    Object localObject2;
    for (;;)
    {
      ((StringBuilder)localObject1).append("\r\n");
      localObject2 = paramf.aOs();
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Iterator)localObject2).next();
        String str2 = paramf.Fy(str1);
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("\r\n");
      }
      if ((paramf instanceof h))
      {
        ((StringBuilder)localObject1).append("HTTP/1.1 101 " + ((h)paramf).aOq());
      }
      else
      {
        ((StringBuilder)localObject1).append("GET ");
        ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.appbrand.u.e.a)paramf).aOp());
        ((StringBuilder)localObject1).append(" HTTP/1.1");
        ab.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
      }
    }
    ((StringBuilder)localObject1).append("\r\n");
    localObject1 = com.tencent.mm.plugin.appbrand.u.f.b.FB(((StringBuilder)localObject1).toString());
    paramf = paramf.aOt();
    if (paramf == null) {}
    for (int i = 0;; i = paramf.length)
    {
      localObject2 = ByteBuffer.allocate(i + localObject1.length);
      ((ByteBuffer)localObject2).put((byte[])localObject1);
      if (paramf != null) {
        ((ByteBuffer)localObject2).put(paramf);
      }
      ((ByteBuffer)localObject2).flip();
      return Collections.singletonList(localObject2);
    }
  }
  
  public static int pR(int paramInt)
  {
    if (paramInt < 0) {
      throw new com.tencent.mm.plugin.appbrand.u.c.b("Negative count");
    }
    return paramInt;
  }
  
  private static String s(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b;
    for (int i = 48;; i = b) {
      if (paramByteBuffer.hasRemaining())
      {
        b = paramByteBuffer.get();
        localByteBuffer.put(b);
        if ((i == 13) && (b == 10))
        {
          localByteBuffer.limit(localByteBuffer.position() - 2);
          localByteBuffer.position(0);
        }
      }
      else
      {
        for (paramByteBuffer = localByteBuffer; paramByteBuffer == null; paramByteBuffer = null)
        {
          return null;
          paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
        }
        return com.tencent.mm.plugin.appbrand.u.f.b.G(paramByteBuffer.array(), paramByteBuffer.limit());
      }
    }
  }
  
  public abstract a.b a(com.tencent.mm.plugin.appbrand.u.e.a parama, h paramh);
  
  public abstract com.tencent.mm.plugin.appbrand.u.e.b a(com.tencent.mm.plugin.appbrand.u.e.b paramb);
  
  public abstract c a(com.tencent.mm.plugin.appbrand.u.e.a parama, i parami);
  
  public abstract List<com.tencent.mm.plugin.appbrand.u.d.d> a(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public final void a(com.tencent.mm.plugin.appbrand.u.a.b paramb)
  {
    this.iYT = paramb;
  }
  
  public abstract a aOg();
  
  public abstract a aOh();
  
  public abstract List<com.tencent.mm.plugin.appbrand.u.d.d> au(String paramString, boolean paramBoolean);
  
  public abstract a.b c(com.tencent.mm.plugin.appbrand.u.e.a parama);
  
  public abstract ByteBuffer d(com.tencent.mm.plugin.appbrand.u.d.d paramd);
  
  public abstract void reset();
  
  public abstract List<com.tencent.mm.plugin.appbrand.u.d.d> t(ByteBuffer paramByteBuffer);
  
  public final f u(ByteBuffer paramByteBuffer)
  {
    Object localObject1 = this.iYT;
    Object localObject2 = s(paramByteBuffer);
    if (localObject2 == null) {
      throw new com.tencent.mm.plugin.appbrand.u.c.a(paramByteBuffer.capacity() + 128);
    }
    localObject2 = ((String)localObject2).split(" ", 3);
    if (localObject2.length != 3) {
      throw new com.tencent.mm.plugin.appbrand.u.c.d();
    }
    if (localObject1 == com.tencent.mm.plugin.appbrand.u.a.b.iYE)
    {
      localObject1 = new e();
      i locali = (i)localObject1;
      locali.a(Short.parseShort(localObject2[1]));
      locali.Fx(localObject2[2]);
    }
    for (;;)
    {
      localObject2 = s(paramByteBuffer);
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break;
      }
      localObject2 = ((String)localObject2).split(":", 2);
      if (localObject2.length != 2)
      {
        throw new com.tencent.mm.plugin.appbrand.u.c.d("not an http header");
        localObject1 = new com.tencent.mm.plugin.appbrand.u.e.d();
        ((com.tencent.mm.plugin.appbrand.u.e.b)localObject1).Fw(localObject2[1]);
      }
      else
      {
        ((c)localObject1).put(localObject2[0], localObject2[1].replaceFirst("^ +", ""));
      }
    }
    if (localObject2 == null) {
      throw new com.tencent.mm.plugin.appbrand.u.c.a();
    }
    return localObject1;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(73229);
      iZq = new a("NONE", 0);
      iZr = new a("ONEWAY", 1);
      iZs = new a("TWOWAY", 2);
      iZt = new a[] { iZq, iZr, iZs };
      AppMethodBeat.o(73229);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b.a
 * JD-Core Version:    0.7.0.1
 */