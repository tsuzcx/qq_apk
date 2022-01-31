package com.b.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.List;

class n
  extends b
{
  private final n.d boA;
  private final i boB;
  final s boC;
  private long boD;
  private long boE;
  private long boF;
  private int boG;
  private long boH;
  private boolean boI;
  private Location boJ;
  private int boK;
  private float boL;
  private float boM;
  private float boN;
  private int boO;
  private int boP;
  private long boQ;
  private final n.e boy;
  final j boz;
  
  n()
  {
    AppMethodBeat.i(55685);
    this.boy = new n.e(this, (byte)0);
    this.boz = new j();
    this.boA = new n.d((byte)0);
    if (i.bmX == null) {
      i.bmX = new i();
    }
    this.boB = i.bmX;
    this.boI = true;
    this.boC = new s(this);
    AppMethodBeat.o(55685);
  }
  
  private boolean a(long paramLong, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, int paramInt2, float paramFloat2)
  {
    AppMethodBeat.i(55686);
    paramLong /= 1000L;
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble2);
    if (this.boI)
    {
      this.boz.a(paramLong, paramDouble1, paramDouble2, paramFloat1, this.boy.bpb, y.bsx);
      this.boI = false;
    }
    for (boolean bool = true;; bool = false)
    {
      j.a locala = new j.a(paramInt1, paramLong, paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramInt2, paramFloat2, 0, 0.0D, 0.0D);
      this.boz.a(locala);
      if (y.bsr) {
        o.r("filter_input_log_" + y.bsy, locala.toString());
      }
      AppMethodBeat.o(55686);
      return bool;
    }
  }
  
  private void tm()
  {
    AppMethodBeat.i(55694);
    this.boB.bng = false;
    this.boC.ty();
    this.boA.reset();
    n.e.a(this.boy);
    tl();
    this.boE = 0L;
    this.boF = SystemClock.elapsedRealtime();
    this.boL = 0.0F;
    this.boM = 0.0F;
    this.boN = 0.0F;
    this.boO = 0;
    this.boP = 0;
    this.boG = 0;
    AppMethodBeat.o(55694);
  }
  
  final k.a a(d.a parama)
  {
    AppMethodBeat.i(55695);
    parama = new k.a(0L);
    AppMethodBeat.o(55695);
    return parama;
  }
  
  final void a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(55690);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(55690);
      return;
    }
    Object localObject = this.boy;
    if (paramInt3 >= 3)
    {
      if (paramLong2 - ((n.e)localObject).bpa <= 5000L) {
        ((n.e)localObject).aV(true);
      }
      ((n.e)localObject).bpa = paramLong2;
    }
    int i = Math.round(paramFloat);
    if (!v.e(paramDouble1, paramDouble2)) {}
    for (localObject = "";; localObject = "&GD=" + paramDouble1 + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt3 + ',' + paramInt5 + ',' + paramInt2 + ',' + i + ',' + paramLong1 + ',')
    {
      this.boA.l((String)localObject, paramLong2);
      if (a(paramLong2, 1, paramDouble1, paramDouble2, paramInt1, paramInt2, paramInt5, paramInt3)) {
        this.boB.a(paramDouble1, paramDouble2, paramInt2, this.boL, this.boM, this.boN);
      }
      if (n.d.q(paramLong2, this.boF)) {
        this.boC.a(paramDouble1, paramDouble2, paramInt2, paramFloat, this.boL, this.boM, this.boN, paramLong2);
      }
      if (y.bsr) {
        o.r("gps_log_" + y.bsy, String.valueOf(paramDouble1) + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4 + ',' + paramInt5 + ',' + paramFloat + ',' + paramLong1);
      }
      AppMethodBeat.o(55690);
      return;
    }
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong)
  {
    AppMethodBeat.i(55689);
    Object localObject1 = this.boy;
    if (paramLong - ((n.e)localObject1).bpa > 5000L) {
      ((n.e)localObject1).aV(false);
    }
    if (paramLong - this.boF > 5000L) {
      tm();
    }
    this.boL = paramFloat1;
    this.boM = paramFloat2;
    this.boN = paramFloat4;
    this.boO = paramInt;
    this.boF = paramLong;
    boolean bool;
    if (paramFloat5 > 0.0F)
    {
      i = 1;
      this.boP = i;
      if ((this.boE != 0L) || (paramLong - this.boQ >= 30000L))
      {
        if (i != 0) {
          break label339;
        }
        bool = true;
        label125:
        if ((!bool) || (!this.boy.bpb))
        {
          ab.tL().aU(bool);
          k.tk().aU(bool);
        }
      }
      localObject1 = new double[2];
      localObject2 = this.boB;
      arrayOfDouble1 = new double[2];
      arrayOfDouble1[0] = paramFloat1;
      arrayOfDouble1[1] = paramFloat2;
      if (!((i)localObject2).bng) {
        break label397;
      }
      localObject1[0] = ((i)localObject2).bmY;
      localObject1[1] = ((i)localObject2).bmZ;
      localObject1[0] += 1.E-005D * (arrayOfDouble1[1] - ((i)localObject2).bnb) / ((i)localObject2).bne;
      localObject1[1] += 1.E-005D * (arrayOfDouble1[0] - ((i)localObject2).bna) / ((i)localObject2).bnf;
      if (localObject1[0] <= 90.0D) {
        break label345;
      }
      localObject1[0] = (180.0D - localObject1[0]);
      label295:
      if (localObject1[1] <= 180.0D) {
        break label371;
      }
      localObject1[1] -= 360.0D;
    }
    label318:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label403;
      }
      AppMethodBeat.o(55689);
      return;
      i = 0;
      break;
      label339:
      bool = false;
      break label125;
      label345:
      if (localObject1[0] >= -90.0D) {
        break label295;
      }
      localObject1[0] = (-180.0D - localObject1[0]);
      break label295;
      label371:
      if (localObject1[1] >= -180.0D) {
        break label318;
      }
      localObject1[1] += 360.0D;
      break label318;
    }
    label397:
    label403:
    double d1 = localObject1[0];
    double d2 = localObject1[1];
    localObject1 = this.boB;
    paramFloat2 = (paramFloat4 - ((i)localObject1).bnc) / 10.0F;
    paramFloat4 = ((i)localObject1).bnd;
    paramFloat1 = 0.0F;
    localObject1 = new Location("S");
    ((Location)localObject1).setLatitude(d1);
    ((Location)localObject1).setLongitude(d2);
    if (this.boJ != null) {
      paramFloat1 = this.boJ.bearingTo((Location)localObject1);
    }
    this.boJ = ((Location)localObject1);
    i = Math.max(0, paramInt - this.boK);
    this.boK = paramInt;
    long l = paramLong / 1000L;
    d1 = Math.toRadians(d1);
    d2 = Math.toRadians(d2);
    double d3 = Math.toRadians(paramFloat1);
    localObject1 = new j.a(3, l, d1, d2, 0.0D, paramFloat2 + paramFloat4, 0, paramFloat5, i, paramFloat3, d3);
    this.boz.a((j.a)localObject1);
    if (y.bsr) {
      o.r("filter_input_log_" + y.bsy, ((j.a)localObject1).toString());
    }
    localObject1 = new double[4];
    l = paramLong / 1000L;
    Object localObject2 = new double[2];
    double[] arrayOfDouble1 = new double[2];
    double[] arrayOfDouble2 = new double[2];
    double[][] arrayOfDouble3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    double[][] arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    j localj = this.boz;
    d1 = l - localj.bni.bnk;
    d2 = d1 * d1;
    double[] arrayOfDouble5 = new double[2];
    localObject2[0] = (localj.bni.bnT[0] + localj.bni.bnT[2] * d1);
    d3 = localj.bni.bnT[1];
    localObject2[1] = (d1 * localj.bni.bnT[3] + d3);
    arrayOfDouble2[0] = localj.bni.bnT[2];
    arrayOfDouble2[1] = localj.bni.bnT[3];
    int j;
    if (localj.bni.bnB)
    {
      localObject2[0] -= localj.bni.bnC[0];
      localObject2[1] -= localj.bni.bnC[1];
      d1 = Math.sqrt(arrayOfDouble5[0] * arrayOfDouble5[0] + arrayOfDouble5[1] * arrayOfDouble5[1]);
      d1 = d1 * d1 * localj.bni.bnW;
      arrayOfDouble3[0][0] = (localj.bni.bnU[0][0] + localj.bni.bnU[2][2] * d2 + d1);
      arrayOfDouble3[0][1] = (localj.bni.bnU[0][1] + localj.bni.bnU[2][3] * d2);
      arrayOfDouble3[1][0] = (localj.bni.bnU[1][0] + localj.bni.bnU[3][2] * d2);
      arrayOfDouble5 = arrayOfDouble3[1];
      d3 = localj.bni.bnU[1][1];
      arrayOfDouble5[1] = (d1 + (d2 * localj.bni.bnU[3][3] + d3));
      arrayOfDouble4[0][0] = localj.bni.bnU[2][2];
      arrayOfDouble4[0][1] = localj.bni.bnU[2][3];
      arrayOfDouble4[1][0] = localj.bni.bnU[3][2];
      arrayOfDouble4[1][1] = localj.bni.bnU[3][3];
      localj.a(1, (double[])localObject2, arrayOfDouble1);
      localObject1[0] = Math.toDegrees(arrayOfDouble1[0]);
      localObject1[1] = Math.toDegrees(arrayOfDouble1[1]);
      localObject1[2] = Math.sqrt((arrayOfDouble3[0][0] + arrayOfDouble3[1][1]) / 2.0D);
      d1 = arrayOfDouble2[0];
      d2 = arrayOfDouble2[0];
      d3 = arrayOfDouble2[1];
      localObject1[3] = Math.sqrt(d1 * d2 + arrayOfDouble2[1] * d3);
      if (y.bsr) {
        o.r("filter_output_log_" + y.bsy, String.valueOf(l) + ',' + localObject1[0] + ',' + localObject1[1] + ',' + localObject1[2] + ',' + localObject1[3]);
      }
      d1 = localObject1[0];
      d2 = localObject1[1];
      paramInt = Double.valueOf(localObject1[2]).intValue();
      i = Double.valueOf(localObject1[3]).intValue();
      j = this.boG;
      if (v.e(d1, d2)) {
        break label1409;
      }
    }
    label1409:
    for (localObject1 = "";; localObject1 = "&SD=" + d1 + ',' + d2 + ',' + 0 + ',' + paramInt + ',' + j + ',' + 0 + ',' + i + ',' + 0 + ',' + 0 + ',' + 0)
    {
      this.boA.m((String)localObject1, paramLong);
      c(new n.a(d1, d2, paramInt, this.boG, this.boH));
      AppMethodBeat.o(55689);
      return;
      d1 = 0.0D;
      break;
    }
  }
  
  void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(55691);
    c(new n.b(paramInt, paramString, (byte)0));
    if ((paramInt == -4) || (paramInt == -5)) {
      stop();
    }
    AppMethodBeat.o(55691);
  }
  
  /* Error */
  void a(android.os.Handler paramHandler, d.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 434
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: instanceof 10
    //   12: ifeq +50 -> 62
    //   15: aload_2
    //   16: checkcast 10	com/b/a/a/n$c
    //   19: astore_2
    //   20: aload_0
    //   21: aload_2
    //   22: getfield 437	com/b/a/a/n$c:boV	J
    //   25: putfield 439	com/b/a/a/n:boD	J
    //   28: aload_0
    //   29: invokespecial 266	com/b/a/a/n:tm	()V
    //   32: aload_0
    //   33: getfield 86	com/b/a/a/n:boC	Lcom/b/a/a/s;
    //   36: aload_1
    //   37: putfield 443	com/b/a/a/s:bpN	Landroid/os/Handler;
    //   40: aload_0
    //   41: invokestatic 174	android/os/SystemClock:elapsedRealtime	()J
    //   44: putfield 268	com/b/a/a/n:boQ	J
    //   47: aload_0
    //   48: aload_1
    //   49: aload_2
    //   50: invokespecial 445	com/b/a/a/b:a	(Landroid/os/Handler;Lcom/b/a/a/d$a;)V
    //   53: ldc_w 434
    //   56: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_2
    //   63: ifnull +23 -> 86
    //   66: aload_2
    //   67: getfield 450	com/b/a/a/d$a:bmu	J
    //   70: lstore_3
    //   71: new 10	com/b/a/a/n$c
    //   74: dup
    //   75: lload_3
    //   76: ldc2_w 451
    //   79: invokespecial 455	com/b/a/a/n$c:<init>	(JJ)V
    //   82: astore_2
    //   83: goto -63 -> 20
    //   86: ldc2_w 201
    //   89: lstore_3
    //   90: goto -19 -> 71
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	n
    //   0	98	1	paramHandler	android.os.Handler
    //   0	98	2	parama	d.a
    //   70	20	3	l	long
    // Exception table:
    //   from	to	target	type
    //   2	20	93	finally
    //   20	59	93	finally
    //   66	71	93	finally
    //   71	83	93	finally
  }
  
  void a(x paramx, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(55688);
    this.boE = paramx.bpC;
    this.boG = paramx.level;
    this.boH = paramx.boT;
    if ((paramx.bsd.equals("W")) && (a(paramLong2, 2, paramx.latitude, paramx.longitude, paramx.altitude, paramx.boo, paramx.bsi, paramx.speed))) {
      this.boB.a(paramx.latitude, paramx.longitude, paramx.boo, this.boL, this.boM, this.boN);
    }
    if (!u.tF().bqA) {
      c(new n.a(paramx.latitude, paramx.longitude, Float.valueOf(paramx.boo).intValue(), this.boG, this.boH));
    }
    AppMethodBeat.o(55688);
  }
  
  final void a(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(55687);
    paramLong1 = aa.ar(paramLong1);
    boolean bool;
    Object localObject1;
    Object localObject2;
    r localr;
    int i;
    long l1;
    if ((this.boE != 0L) && (paramLong2 - this.boE < this.boD))
    {
      bool = false;
      localObject1 = v.a(paramList, bool);
      localObject2 = this.boA.c((String)localObject1, paramLong2, bool);
      if (!bool) {
        break label320;
      }
      localr = r.to();
      i = this.boP;
      if (localObject2 != null)
      {
        if (!localr.isRunning) {
          break label278;
        }
        if (!localr.tq()) {
          break label273;
        }
        l1 = System.currentTimeMillis();
        long l2 = SystemClock.elapsedRealtime();
        if (localr.bpp != null) {
          localr.bpp.execute(new r.e(localr, (String)localObject2, l1, l2, i, (byte)0));
        }
      }
      label142:
      if (n.d.q(paramLong2, this.boF)) {
        if (bool) {
          break label338;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = v.a(paramList, false);
      }
      paramList = v.a((String)localObject2, paramLong1, "2");
      localObject1 = this.boC;
      float f1 = this.boL;
      float f2 = this.boM;
      float f3 = this.boN;
      float f4 = this.boO;
      i = this.boG;
      if (((s)localObject1).bpI != 0.0F) {
        z.b(null).execute(new s.a((s)localObject1, f1, f2, f3, f4, i, paramList, (byte)0));
      }
      AppMethodBeat.o(55687);
      return;
      bool = true;
      break;
      label273:
      localr.tp();
      label278:
      l1 = aa.ar(System.currentTimeMillis());
      if (localr.bpp == null) {
        break label142;
      }
      localr.bpp.execute(new r.c(localr, (String)localObject2, l1, 0, (byte)0));
      break label142;
      label320:
      r.to().bp(v.a((String)localObject2, paramLong1, "0"));
      break label142;
      label338:
      localObject1 = null;
    }
  }
  
  final void stop()
  {
    try
    {
      AppMethodBeat.i(55693);
      this.boC.tw();
      super.stop();
      AppMethodBeat.o(55693);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void tl()
  {
    this.boI = true;
    this.boJ = null;
    this.boK = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.a.n
 * JD-Core Version:    0.7.0.1
 */