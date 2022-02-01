package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.al.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.vending.c.a;

public class h
  extends c<bdq>
{
  private static a iLz = null;
  public final b rr;
  
  public h(bdp parambdp)
  {
    this(parambdp, 1139, "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl");
  }
  
  public h(bdp parambdp, int paramInt, String paramString)
  {
    AppMethodBeat.i(90542);
    b.a locala = new b.a();
    locala.funcId = paramInt;
    locala.uri = paramString;
    locala.gUU = parambdp;
    locala.gUV = new bdq();
    parambdp = locala.atI();
    this.rr = parambdp;
    this.rr = parambdp;
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
  
  public static bdp a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90540);
    bdp localbdp = new bdp();
    localbdp.CLL = paramInt1;
    localbdp.dlB = paramString1;
    localbdp.kKY = paramString2;
    localbdp.DyU = paramInt2;
    localbdp.DAL = paramInt3;
    AppMethodBeat.o(90540);
    return localbdp;
  }
  
  public static void a(a parama)
  {
    iLz = parama;
  }
  
  public final bdp aPf()
  {
    return (bdp)this.rr.gUS.gUX;
  }
  
  public final int aPg()
  {
    return ((bdp)this.rr.gUS.gUX).DyU;
  }
  
  /* Error */
  public final f<c.a<bdq>> auK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 114
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 120	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   10: lstore_1
    //   11: getstatic 18	com/tencent/mm/plugin/appbrand/appcache/h:iLz	Lcom/tencent/mm/plugin/appbrand/appcache/h$a;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +48 -> 64
    //   19: aload_3
    //   20: aload_0
    //   21: invokeinterface 123 2 0
    //   26: astore_3
    //   27: aload_3
    //   28: astore 4
    //   30: aload_3
    //   31: ifnonnull +9 -> 40
    //   34: aload_0
    //   35: invokespecial 125	com/tencent/mm/al/c:auK	()Lcom/tencent/mm/co/f;
    //   38: astore 4
    //   40: aload 4
    //   42: new 7	com/tencent/mm/plugin/appbrand/appcache/h$1
    //   45: dup
    //   46: aload_0
    //   47: lload_1
    //   48: invokespecial 128	com/tencent/mm/plugin/appbrand/appcache/h$1:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/h;J)V
    //   51: invokevirtual 134	com/tencent/mm/co/f:b	(Lcom/tencent/mm/vending/c/a;)Lcom/tencent/mm/co/f;
    //   54: astore_3
    //   55: ldc 114
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
  
  public static abstract interface a
  {
    public abstract f<c.a<bdq>> a(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.h
 * JD-Core Version:    0.7.0.1
 */