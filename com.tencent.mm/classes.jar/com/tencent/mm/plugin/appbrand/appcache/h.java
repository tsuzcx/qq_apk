package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.vending.c.a;

public class h
  extends c<bhi>
{
  private static a jlG = null;
  public final b rr;
  
  public h(bhh parambhh)
  {
    this(parambhh, 1139, "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl");
  }
  
  public h(bhh parambhh, int paramInt, String paramString)
  {
    AppMethodBeat.i(90542);
    b.a locala = new b.a();
    locala.funcId = paramInt;
    locala.uri = paramString;
    locala.hvt = parambhh;
    locala.hvu = new bhi();
    parambhh = locala.aAz();
    this.rr = parambhh;
    this.rr = parambhh;
    AppMethodBeat.o(90542);
  }
  
  private h(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this(a(paramString1, paramInt1, paramString2, paramInt2, 0));
    AppMethodBeat.i(90541);
    AppMethodBeat.o(90541);
  }
  
  public h(String paramString1, int paramInt1, String paramString2, int paramInt2, byte paramByte)
  {
    this(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public static bhh a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90540);
    bhh localbhh = new bhh();
    localbhh.Eeo = paramInt1;
    localbhh.djj = paramString1;
    localbhh.lmu = paramString2;
    localbhh.EUq = paramInt2;
    localbhh.EWh = paramInt3;
    AppMethodBeat.o(90540);
    return localbhh;
  }
  
  public static void a(a parama)
  {
    jlG = parama;
  }
  
  /* Error */
  public final f<c.a<bhi>> aBB()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 99
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 105	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   10: lstore_1
    //   11: getstatic 18	com/tencent/mm/plugin/appbrand/appcache/h:jlG	Lcom/tencent/mm/plugin/appbrand/appcache/h$a;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +48 -> 64
    //   19: aload_3
    //   20: aload_0
    //   21: invokeinterface 108 2 0
    //   26: astore_3
    //   27: aload_3
    //   28: astore 4
    //   30: aload_3
    //   31: ifnonnull +9 -> 40
    //   34: aload_0
    //   35: invokespecial 110	com/tencent/mm/ak/c:aBB	()Lcom/tencent/mm/cn/f;
    //   38: astore 4
    //   40: aload 4
    //   42: new 7	com/tencent/mm/plugin/appbrand/appcache/h$1
    //   45: dup
    //   46: aload_0
    //   47: lload_1
    //   48: invokespecial 113	com/tencent/mm/plugin/appbrand/appcache/h$1:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/h;J)V
    //   51: invokevirtual 119	com/tencent/mm/cn/f:b	(Lcom/tencent/mm/vending/c/a;)Lcom/tencent/mm/cn/f;
    //   54: astore_3
    //   55: ldc 99
    //   57: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_3
    //   63: areturn
    //   64: aconst_null
    //   65: astore_3
    //   66: goto -39 -> 27
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	h
    //   10	38	1	l	long
    //   14	52	3	localObject1	Object
    //   69	4	3	localObject2	Object
    //   28	13	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	69	finally
    //   19	27	69	finally
    //   34	40	69	finally
    //   40	60	69	finally
  }
  
  public final bhh aVX()
  {
    return (bhh)this.rr.hvr.hvw;
  }
  
  public final int aVY()
  {
    return ((bhh)this.rr.hvr.hvw).EUq;
  }
  
  public static abstract interface a
  {
    public abstract f<c.a<bhi>> a(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.h
 * JD-Core Version:    0.7.0.1
 */