package com.tencent.mm.plugin.appbrand.aa.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d.d.a;
import com.tencent.mm.plugin.appbrand.aa.e.c;
import com.tencent.mm.plugin.appbrand.aa.e.e;
import com.tencent.mm.plugin.appbrand.aa.e.f;
import com.tencent.mm.plugin.appbrand.aa.e.h;
import com.tencent.mm.plugin.appbrand.aa.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a
{
  public static int mqb = 1000;
  public static int mqc = 64;
  public static final byte[] mqd = com.tencent.mm.plugin.appbrand.aa.f.b.RG("");
  protected com.tencent.mm.plugin.appbrand.aa.a.b mpJ = null;
  protected d.a mqe = null;
  
  public static List<ByteBuffer> e(f paramf)
  {
    return f(paramf);
  }
  
  public static List<ByteBuffer> f(f paramf)
  {
    Object localObject1 = new StringBuilder(100);
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.aa.e.a))
    {
      ((StringBuilder)localObject1).append("GET ");
      ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.appbrand.aa.e.a)paramf).bxI());
      ((StringBuilder)localObject1).append(" HTTP/1.1");
    }
    Object localObject2;
    for (;;)
    {
      ((StringBuilder)localObject1).append("\r\n");
      localObject2 = paramf.bxL();
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Iterator)localObject2).next();
        String str2 = paramf.RE(str1);
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("\r\n");
      }
      if ((paramf instanceof h))
      {
        ((StringBuilder)localObject1).append("HTTP/1.1 101 " + ((h)paramf).bxJ());
      }
      else
      {
        ((StringBuilder)localObject1).append("GET ");
        ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.appbrand.aa.e.a)paramf).bxI());
        ((StringBuilder)localObject1).append(" HTTP/1.1");
        ac.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
      }
    }
    ((StringBuilder)localObject1).append("\r\n");
    localObject1 = com.tencent.mm.plugin.appbrand.aa.f.b.RH(((StringBuilder)localObject1).toString());
    paramf = paramf.bxM();
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
  
  public static int vh(int paramInt)
  {
    if (paramInt < 0) {
      throw new com.tencent.mm.plugin.appbrand.aa.c.b("Negative count");
    }
    return paramInt;
  }
  
  private static String w(ByteBuffer paramByteBuffer)
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
        return com.tencent.mm.plugin.appbrand.aa.f.b.I(paramByteBuffer.array(), paramByteBuffer.limit());
      }
    }
  }
  
  public abstract b a(com.tencent.mm.plugin.appbrand.aa.e.a parama, h paramh);
  
  public abstract com.tencent.mm.plugin.appbrand.aa.e.b a(com.tencent.mm.plugin.appbrand.aa.e.b paramb);
  
  public abstract c a(com.tencent.mm.plugin.appbrand.aa.e.a parama, i parami);
  
  public abstract List<com.tencent.mm.plugin.appbrand.aa.d.d> a(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public final void a(com.tencent.mm.plugin.appbrand.aa.a.b paramb)
  {
    this.mpJ = paramb;
  }
  
  public abstract List<com.tencent.mm.plugin.appbrand.aa.d.d> az(String paramString, boolean paramBoolean);
  
  public abstract a bxA();
  
  public abstract a bxz();
  
  public abstract b c(com.tencent.mm.plugin.appbrand.aa.e.a parama);
  
  public abstract ByteBuffer d(com.tencent.mm.plugin.appbrand.aa.d.d paramd);
  
  public abstract void reset();
  
  public abstract List<com.tencent.mm.plugin.appbrand.aa.d.d> x(ByteBuffer paramByteBuffer);
  
  public final f y(ByteBuffer paramByteBuffer)
  {
    Object localObject1 = this.mpJ;
    Object localObject2 = w(paramByteBuffer);
    if (localObject2 == null) {
      throw new com.tencent.mm.plugin.appbrand.aa.c.a(paramByteBuffer.capacity() + 128);
    }
    localObject2 = ((String)localObject2).split(" ", 3);
    if (localObject2.length != 3) {
      throw new com.tencent.mm.plugin.appbrand.aa.c.d();
    }
    if (localObject1 == com.tencent.mm.plugin.appbrand.aa.a.b.mpu)
    {
      localObject1 = new e();
      i locali = (i)localObject1;
      locali.a(Short.parseShort(localObject2[1]));
      locali.RD(localObject2[2]);
    }
    for (;;)
    {
      localObject2 = w(paramByteBuffer);
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break;
      }
      localObject2 = ((String)localObject2).split(":", 2);
      if (localObject2.length != 2)
      {
        throw new com.tencent.mm.plugin.appbrand.aa.c.d("not an http header");
        localObject1 = new com.tencent.mm.plugin.appbrand.aa.e.d();
        ((com.tencent.mm.plugin.appbrand.aa.e.b)localObject1).RC(localObject2[1]);
      }
      else
      {
        ((c)localObject1).put(localObject2[0], localObject2[1].replaceFirst("^ +", ""));
      }
    }
    if (localObject2 == null) {
      throw new com.tencent.mm.plugin.appbrand.aa.c.a();
    }
    return localObject1;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156627);
      mqf = new a("NONE", 0);
      mqg = new a("ONEWAY", 1);
      mqh = new a("TWOWAY", 2);
      mqi = new a[] { mqf, mqg, mqh };
      AppMethodBeat.o(156627);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(156630);
      mqj = new b("MATCHED", 0);
      mqk = new b("NOT_MATCHED", 1);
      mql = new b[] { mqj, mqk };
      AppMethodBeat.o(156630);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.b.a
 * JD-Core Version:    0.7.0.1
 */