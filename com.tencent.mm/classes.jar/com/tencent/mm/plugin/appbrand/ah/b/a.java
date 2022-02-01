package com.tencent.mm.plugin.appbrand.ah.b;

import com.tencent.mm.plugin.appbrand.ah.d.d.a;
import com.tencent.mm.plugin.appbrand.ah.e.c;
import com.tencent.mm.plugin.appbrand.ah.e.e;
import com.tencent.mm.plugin.appbrand.ah.e.f;
import com.tencent.mm.plugin.appbrand.ah.e.h;
import com.tencent.mm.plugin.appbrand.ah.e.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a
{
  public static int uuM = 1000;
  public static int uuN = 64;
  public static final byte[] uuO = com.tencent.mm.plugin.appbrand.ah.f.b.agV("");
  protected d.a uuP = null;
  protected com.tencent.mm.plugin.appbrand.ah.a.b uuv = null;
  
  public static int DO(int paramInt)
  {
    if (paramInt < 0) {
      throw new com.tencent.mm.plugin.appbrand.ah.c.b("Negative count");
    }
    return paramInt;
  }
  
  public static List<ByteBuffer> e(f paramf)
  {
    return f(paramf);
  }
  
  public static List<ByteBuffer> f(f paramf)
  {
    Object localObject1 = new StringBuilder(100);
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.ah.e.a))
    {
      ((StringBuilder)localObject1).append("GET ");
      ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.appbrand.ah.e.a)paramf).cOr());
      ((StringBuilder)localObject1).append(" HTTP/1.1");
    }
    Object localObject2;
    for (;;)
    {
      ((StringBuilder)localObject1).append("\r\n");
      localObject2 = paramf.cOu();
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Iterator)localObject2).next();
        String str2 = paramf.agT(str1);
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("\r\n");
      }
      if ((paramf instanceof h))
      {
        ((StringBuilder)localObject1).append("HTTP/1.1 101 " + ((h)paramf).cOs());
      }
      else
      {
        ((StringBuilder)localObject1).append("GET ");
        ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.appbrand.ah.e.a)paramf).cOr());
        ((StringBuilder)localObject1).append(" HTTP/1.1");
        Log.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
      }
    }
    ((StringBuilder)localObject1).append("\r\n");
    localObject1 = com.tencent.mm.plugin.appbrand.ah.f.b.agW(((StringBuilder)localObject1).toString());
    paramf = paramf.getContent();
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
  
  private static String z(ByteBuffer paramByteBuffer)
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
        return com.tencent.mm.plugin.appbrand.ah.f.b.J(paramByteBuffer.array(), paramByteBuffer.limit());
      }
    }
  }
  
  public abstract List<com.tencent.mm.plugin.appbrand.ah.d.d> A(ByteBuffer paramByteBuffer);
  
  public final f B(ByteBuffer paramByteBuffer)
  {
    Object localObject1 = this.uuv;
    Object localObject2 = z(paramByteBuffer);
    if (localObject2 == null) {
      throw new com.tencent.mm.plugin.appbrand.ah.c.a(paramByteBuffer.capacity() + 128);
    }
    localObject2 = ((String)localObject2).split(" ", 3);
    if (localObject2.length != 3) {
      throw new com.tencent.mm.plugin.appbrand.ah.c.d();
    }
    if (localObject1 == com.tencent.mm.plugin.appbrand.ah.a.b.uug)
    {
      localObject1 = new e();
      i locali = (i)localObject1;
      locali.e(Short.parseShort(localObject2[1]));
      locali.agS(localObject2[2]);
    }
    for (;;)
    {
      localObject2 = z(paramByteBuffer);
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break;
      }
      localObject2 = ((String)localObject2).split(":", 2);
      if (localObject2.length != 2)
      {
        throw new com.tencent.mm.plugin.appbrand.ah.c.d("not an http header");
        localObject1 = new com.tencent.mm.plugin.appbrand.ah.e.d();
        ((com.tencent.mm.plugin.appbrand.ah.e.b)localObject1).agR(localObject2[1]);
      }
      else
      {
        ((c)localObject1).put(localObject2[0], localObject2[1].replaceFirst("^ +", ""));
      }
    }
    if (localObject2 == null) {
      throw new com.tencent.mm.plugin.appbrand.ah.c.a();
    }
    return localObject1;
  }
  
  public abstract a.b a(com.tencent.mm.plugin.appbrand.ah.e.a parama, h paramh);
  
  public abstract com.tencent.mm.plugin.appbrand.ah.e.b a(com.tencent.mm.plugin.appbrand.ah.e.b paramb);
  
  public abstract c a(com.tencent.mm.plugin.appbrand.ah.e.a parama, i parami);
  
  public final void a(com.tencent.mm.plugin.appbrand.ah.a.b paramb)
  {
    this.uuv = paramb;
  }
  
  public abstract List<com.tencent.mm.plugin.appbrand.ah.d.d> aT(String paramString, boolean paramBoolean);
  
  public abstract List<com.tencent.mm.plugin.appbrand.ah.d.d> b(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public abstract a.b c(com.tencent.mm.plugin.appbrand.ah.e.a parama);
  
  public abstract a.a cOi();
  
  public abstract a cOj();
  
  public abstract ByteBuffer d(com.tencent.mm.plugin.appbrand.ah.d.d paramd);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.b.a
 * JD-Core Version:    0.7.0.1
 */