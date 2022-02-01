package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.cm.f;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.vending.c.a;

public class h
  extends com.tencent.mm.plugin.appbrand.networking.b<bmi>
{
  private static a jIv = null;
  public final com.tencent.mm.ak.b rr;
  
  public h(bmh parambmh)
  {
    this(parambmh, 1139, "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl");
  }
  
  public h(bmh parambmh, int paramInt, String paramString)
  {
    super(parambmh.dwb, null);
    AppMethodBeat.i(90542);
    b.a locala = new b.a();
    locala.funcId = paramInt;
    locala.uri = paramString;
    locala.hQF = parambmh;
    locala.hQG = new bmi();
    parambmh = locala.aDS();
    this.rr = parambmh;
    c(parambmh);
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
  
  public static bmh a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90540);
    bmh localbmh = new bmh();
    localbmh.Gdm = paramInt1;
    localbmh.dwb = paramString1;
    localbmh.lOc = paramString2;
    localbmh.GXq = paramInt2;
    localbmh.GZg = paramInt3;
    AppMethodBeat.o(90540);
    return localbmh;
  }
  
  public static void a(a parama)
  {
    jIv = parama;
  }
  
  /* Error */
  public final f<a.a<bmi>> aET()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 104
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 110	com/tencent/mm/sdk/platformtools/bu:fpO	()J
    //   10: lstore_1
    //   11: getstatic 18	com/tencent/mm/plugin/appbrand/appcache/h:jIv	Lcom/tencent/mm/plugin/appbrand/appcache/h$a;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +48 -> 64
    //   19: aload_3
    //   20: aload_0
    //   21: invokeinterface 113 2 0
    //   26: astore_3
    //   27: aload_3
    //   28: astore 4
    //   30: aload_3
    //   31: ifnonnull +9 -> 40
    //   34: aload_0
    //   35: invokespecial 115	com/tencent/mm/plugin/appbrand/networking/b:aET	()Lcom/tencent/mm/cm/f;
    //   38: astore 4
    //   40: aload 4
    //   42: new 7	com/tencent/mm/plugin/appbrand/appcache/h$1
    //   45: dup
    //   46: aload_0
    //   47: lload_1
    //   48: invokespecial 118	com/tencent/mm/plugin/appbrand/appcache/h$1:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/h;J)V
    //   51: invokevirtual 124	com/tencent/mm/cm/f:b	(Lcom/tencent/mm/vending/c/a;)Lcom/tencent/mm/cm/f;
    //   54: astore_3
    //   55: ldc 104
    //   57: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final bmh aZP()
  {
    return (bmh)this.rr.hQD.hQJ;
  }
  
  public final int aZQ()
  {
    return ((bmh)this.rr.hQD.hQJ).GXq;
  }
  
  public static abstract interface a
  {
    public abstract f<a.a<bmi>> a(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.h
 * JD-Core Version:    0.7.0.1
 */