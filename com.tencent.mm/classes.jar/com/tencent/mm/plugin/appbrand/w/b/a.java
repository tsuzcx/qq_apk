package com.tencent.mm.plugin.appbrand.w.b;

import com.tencent.mm.plugin.appbrand.w.d.d.a;
import com.tencent.mm.plugin.appbrand.w.e.c;
import com.tencent.mm.plugin.appbrand.w.e.e;
import com.tencent.mm.plugin.appbrand.w.e.f;
import com.tencent.mm.plugin.appbrand.w.e.h;
import com.tencent.mm.plugin.appbrand.w.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a
{
  public static int hmN = 1000;
  public static int hmO = 64;
  public static final byte[] hmP = com.tencent.mm.plugin.appbrand.w.f.b.wU("");
  protected d.a hmQ = null;
  protected com.tencent.mm.plugin.appbrand.w.a.b hmu = null;
  
  public static List<ByteBuffer> e(f paramf)
  {
    Object localObject1 = new StringBuilder(100);
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.w.e.a))
    {
      ((StringBuilder)localObject1).append("GET ");
      ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.appbrand.w.e.a)paramf).aqO());
      ((StringBuilder)localObject1).append(" HTTP/1.1");
    }
    Object localObject2;
    for (;;)
    {
      ((StringBuilder)localObject1).append("\r\n");
      localObject2 = paramf.aqQ();
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Iterator)localObject2).next();
        String str2 = paramf.wS(str1);
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("\r\n");
      }
      if ((paramf instanceof h))
      {
        ((StringBuilder)localObject1).append("HTTP/1.1 101 " + ((h)paramf).aqP());
      }
      else
      {
        ((StringBuilder)localObject1).append("GET ");
        ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.appbrand.w.e.a)paramf).aqO());
        ((StringBuilder)localObject1).append(" HTTP/1.1");
        y.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
      }
    }
    ((StringBuilder)localObject1).append("\r\n");
    localObject1 = com.tencent.mm.plugin.appbrand.w.f.b.wV(((StringBuilder)localObject1).toString());
    paramf = paramf.aqR();
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
  
  public static int mA(int paramInt)
  {
    if (paramInt < 0) {
      throw new com.tencent.mm.plugin.appbrand.w.c.b("Negative count");
    }
    return paramInt;
  }
  
  private static String r(ByteBuffer paramByteBuffer)
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
        return com.tencent.mm.plugin.appbrand.w.f.b.F(paramByteBuffer.array(), paramByteBuffer.limit());
      }
    }
  }
  
  public abstract a.b a(com.tencent.mm.plugin.appbrand.w.e.a parama, h paramh);
  
  public abstract com.tencent.mm.plugin.appbrand.w.e.b a(com.tencent.mm.plugin.appbrand.w.e.b paramb);
  
  public abstract c a(com.tencent.mm.plugin.appbrand.w.e.a parama, i parami);
  
  public abstract List<com.tencent.mm.plugin.appbrand.w.d.d> a(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public final void a(com.tencent.mm.plugin.appbrand.w.a.b paramb)
  {
    this.hmu = paramb;
  }
  
  public abstract List<com.tencent.mm.plugin.appbrand.w.d.d> ak(String paramString, boolean paramBoolean);
  
  public abstract a.a aqH();
  
  public abstract a aqI();
  
  public abstract a.b c(com.tencent.mm.plugin.appbrand.w.e.a parama);
  
  public abstract ByteBuffer d(com.tencent.mm.plugin.appbrand.w.d.d paramd);
  
  public abstract void reset();
  
  public abstract List<com.tencent.mm.plugin.appbrand.w.d.d> s(ByteBuffer paramByteBuffer);
  
  public final f t(ByteBuffer paramByteBuffer)
  {
    Object localObject1 = this.hmu;
    Object localObject2 = r(paramByteBuffer);
    if (localObject2 == null) {
      throw new com.tencent.mm.plugin.appbrand.w.c.a(paramByteBuffer.capacity() + 128);
    }
    localObject2 = ((String)localObject2).split(" ", 3);
    if (localObject2.length != 3) {
      throw new com.tencent.mm.plugin.appbrand.w.c.d();
    }
    if (localObject1 == com.tencent.mm.plugin.appbrand.w.a.b.hmf)
    {
      localObject1 = new e();
      i locali = (i)localObject1;
      locali.a(Short.parseShort(localObject2[1]));
      locali.wR(localObject2[2]);
    }
    for (;;)
    {
      localObject2 = r(paramByteBuffer);
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break;
      }
      localObject2 = ((String)localObject2).split(":", 2);
      if (localObject2.length != 2)
      {
        throw new com.tencent.mm.plugin.appbrand.w.c.d("not an http header");
        localObject1 = new com.tencent.mm.plugin.appbrand.w.e.d();
        ((com.tencent.mm.plugin.appbrand.w.e.b)localObject1).wQ(localObject2[1]);
      }
      else
      {
        ((c)localObject1).put(localObject2[0], localObject2[1].replaceFirst("^ +", ""));
      }
    }
    if (localObject2 == null) {
      throw new com.tencent.mm.plugin.appbrand.w.c.a();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.b.a
 * JD-Core Version:    0.7.0.1
 */