package com.d.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.List;

class n
  extends b
{
  private final e bYQ;
  final j bYR;
  private final d bYS;
  private final i bYT;
  final s bYU;
  private long bYV;
  private long bYW;
  private long bYX;
  private int bYY;
  private long bYZ;
  private boolean bZa;
  private Location bZb;
  private int bZc;
  private float bZd;
  private float bZe;
  private float bZf;
  private int bZg;
  private int bZh;
  private long bZi;
  
  n()
  {
    AppMethodBeat.i(88030);
    this.bYQ = new e((byte)0);
    this.bYR = new j();
    this.bYS = new d((byte)0);
    if (i.bXr == null) {
      i.bXr = new i();
    }
    this.bYT = i.bXr;
    this.bZa = true;
    this.bYU = new s(this);
    AppMethodBeat.o(88030);
  }
  
  private void Al()
  {
    AppMethodBeat.i(88039);
    this.bYT.bXy = false;
    this.bYU.Ax();
    this.bYS.reset();
    e.a(this.bYQ);
    Ak();
    this.bYW = 0L;
    this.bYX = SystemClock.elapsedRealtime();
    this.bZd = 0.0F;
    this.bZe = 0.0F;
    this.bZf = 0.0F;
    this.bZg = 0;
    this.bZh = 0;
    this.bYY = 0;
    AppMethodBeat.o(88039);
  }
  
  private boolean a(long paramLong, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, int paramInt2, float paramFloat2)
  {
    AppMethodBeat.i(88031);
    paramLong /= 1000L;
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble2);
    if (this.bZa)
    {
      this.bYR.a(paramLong, paramDouble1, paramDouble2, paramFloat1, this.bYQ.bZs, y.ccN);
      this.bZa = false;
    }
    for (boolean bool = true;; bool = false)
    {
      j.a locala = new j.a(paramInt1, paramLong, paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramInt2, paramFloat2, 0, 0.0D, 0.0D);
      this.bYR.a(locala);
      if (y.ccH) {
        o.t("filter_input_log_" + y.ccO, locala.toString());
      }
      AppMethodBeat.o(88031);
      return bool;
    }
  }
  
  final void Ak()
  {
    this.bZa = true;
    this.bZb = null;
    this.bZc = 0;
  }
  
  final k.a a(d.a parama)
  {
    AppMethodBeat.i(88040);
    parama = new k.a(0L);
    AppMethodBeat.o(88040);
    return parama;
  }
  
  final void a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88035);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(88035);
      return;
    }
    Object localObject = this.bYQ;
    if (paramInt3 >= 3)
    {
      if (paramLong2 - ((e)localObject).bZr <= 5000L) {
        ((e)localObject).bk(true);
      }
      ((e)localObject).bZr = paramLong2;
    }
    int i = Math.round(paramFloat);
    if (!v.b(paramDouble1, paramDouble2)) {}
    for (localObject = "";; localObject = "&GD=" + paramDouble1 + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt3 + ',' + paramInt5 + ',' + paramInt2 + ',' + i + ',' + paramLong1 + ',')
    {
      this.bYS.l((String)localObject, paramLong2);
      if (a(paramLong2, 1, paramDouble1, paramDouble2, paramInt1, paramInt2, paramInt5, paramInt3)) {
        this.bYT.a(paramDouble1, paramDouble2, paramInt2, this.bZd, this.bZe, this.bZf);
      }
      if (d.o(paramLong2, this.bYX)) {
        this.bYU.a(paramDouble1, paramDouble2, paramInt2, paramFloat, this.bZd, this.bZe, this.bZf, paramLong2);
      }
      if (y.ccH) {
        o.t("gps_log_" + y.ccO, String.valueOf(paramDouble1) + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4 + ',' + paramInt5 + ',' + paramFloat + ',' + paramLong1);
      }
      AppMethodBeat.o(88035);
      return;
    }
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong)
  {
    AppMethodBeat.i(88034);
    Object localObject1 = this.bYQ;
    if (paramLong - ((e)localObject1).bZr > 5000L) {
      ((e)localObject1).bk(false);
    }
    if (paramLong - this.bYX > 5000L) {
      Al();
    }
    this.bZd = paramFloat1;
    this.bZe = paramFloat2;
    this.bZf = paramFloat4;
    this.bZg = paramInt;
    this.bYX = paramLong;
    boolean bool;
    if (paramFloat5 > 0.0F)
    {
      i = 1;
      this.bZh = i;
      if ((this.bYW != 0L) || (paramLong - this.bZi >= 30000L))
      {
        if (i != 0) {
          break label339;
        }
        bool = true;
        label125:
        if ((!bool) || (!this.bYQ.bZs))
        {
          ab.AK().bj(bool);
          k.Aj().bj(bool);
        }
      }
      localObject1 = new double[2];
      localObject2 = this.bYT;
      arrayOfDouble1 = new double[2];
      arrayOfDouble1[0] = paramFloat1;
      arrayOfDouble1[1] = paramFloat2;
      if (!((i)localObject2).bXy) {
        break label397;
      }
      localObject1[0] = ((i)localObject2).bXs;
      localObject1[1] = ((i)localObject2).bXt;
      localObject1[0] += 1.E-005D * (arrayOfDouble1[1] - ((i)localObject2).anchorY) / ((i)localObject2).bXw;
      localObject1[1] += 1.E-005D * (arrayOfDouble1[0] - ((i)localObject2).anchorX) / ((i)localObject2).bXx;
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
      AppMethodBeat.o(88034);
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
    localObject1 = this.bYT;
    paramFloat2 = (paramFloat4 - ((i)localObject1).bXu) / 10.0F;
    paramFloat4 = ((i)localObject1).bXv;
    paramFloat1 = 0.0F;
    localObject1 = new Location("S");
    ((Location)localObject1).setLatitude(d1);
    ((Location)localObject1).setLongitude(d2);
    if (this.bZb != null) {
      paramFloat1 = this.bZb.bearingTo((Location)localObject1);
    }
    this.bZb = ((Location)localObject1);
    i = Math.max(0, paramInt - this.bZc);
    this.bZc = paramInt;
    long l = paramLong / 1000L;
    d1 = Math.toRadians(d1);
    d2 = Math.toRadians(d2);
    double d3 = Math.toRadians(paramFloat1);
    localObject1 = new j.a(3, l, d1, d2, 0.0D, paramFloat2 + paramFloat4, 0, paramFloat5, i, paramFloat3, d3);
    this.bYR.a((j.a)localObject1);
    if (y.ccH) {
      o.t("filter_input_log_" + y.ccO, ((j.a)localObject1).toString());
    }
    localObject1 = new double[4];
    l = paramLong / 1000L;
    Object localObject2 = new double[2];
    double[] arrayOfDouble1 = new double[2];
    double[] arrayOfDouble2 = new double[2];
    double[][] arrayOfDouble3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    double[][] arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    j localj = this.bYR;
    d1 = l - localj.bXA.bXC;
    d2 = d1 * d1;
    double[] arrayOfDouble5 = new double[2];
    localObject2[0] = (localj.bXA.bYl[0] + localj.bXA.bYl[2] * d1);
    d3 = localj.bXA.bYl[1];
    localObject2[1] = (d1 * localj.bXA.bYl[3] + d3);
    arrayOfDouble2[0] = localj.bXA.bYl[2];
    arrayOfDouble2[1] = localj.bXA.bYl[3];
    int j;
    if (localj.bXA.bXT)
    {
      localObject2[0] -= localj.bXA.bXU[0];
      localObject2[1] -= localj.bXA.bXU[1];
      d1 = Math.sqrt(arrayOfDouble5[0] * arrayOfDouble5[0] + arrayOfDouble5[1] * arrayOfDouble5[1]);
      d1 = d1 * d1 * localj.bXA.bYo;
      arrayOfDouble3[0][0] = (localj.bXA.bYm[0][0] + localj.bXA.bYm[2][2] * d2 + d1);
      arrayOfDouble3[0][1] = (localj.bXA.bYm[0][1] + localj.bXA.bYm[2][3] * d2);
      arrayOfDouble3[1][0] = (localj.bXA.bYm[1][0] + localj.bXA.bYm[3][2] * d2);
      arrayOfDouble5 = arrayOfDouble3[1];
      d3 = localj.bXA.bYm[1][1];
      arrayOfDouble5[1] = (d1 + (d2 * localj.bXA.bYm[3][3] + d3));
      arrayOfDouble4[0][0] = localj.bXA.bYm[2][2];
      arrayOfDouble4[0][1] = localj.bXA.bYm[2][3];
      arrayOfDouble4[1][0] = localj.bXA.bYm[3][2];
      arrayOfDouble4[1][1] = localj.bXA.bYm[3][3];
      localj.a(1, (double[])localObject2, arrayOfDouble1);
      localObject1[0] = Math.toDegrees(arrayOfDouble1[0]);
      localObject1[1] = Math.toDegrees(arrayOfDouble1[1]);
      localObject1[2] = Math.sqrt((arrayOfDouble3[0][0] + arrayOfDouble3[1][1]) / 2.0D);
      d1 = arrayOfDouble2[0];
      d2 = arrayOfDouble2[0];
      d3 = arrayOfDouble2[1];
      localObject1[3] = Math.sqrt(d1 * d2 + arrayOfDouble2[1] * d3);
      if (y.ccH) {
        o.t("filter_output_log_" + y.ccO, String.valueOf(l) + ',' + localObject1[0] + ',' + localObject1[1] + ',' + localObject1[2] + ',' + localObject1[3]);
      }
      d1 = localObject1[0];
      d2 = localObject1[1];
      paramInt = Double.valueOf(localObject1[2]).intValue();
      i = Double.valueOf(localObject1[3]).intValue();
      j = this.bYY;
      if (v.b(d1, d2)) {
        break label1409;
      }
    }
    label1409:
    for (localObject1 = "";; localObject1 = "&SD=" + d1 + ',' + d2 + ',' + 0 + ',' + paramInt + ',' + j + ',' + 0 + ',' + i + ',' + 0 + ',' + 0 + ',' + 0)
    {
      this.bYS.m((String)localObject1, paramLong);
      c(new a(d1, d2, paramInt, this.bYY, this.bYZ));
      AppMethodBeat.o(88034);
      return;
      d1 = 0.0D;
      break;
    }
  }
  
  void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88036);
    c(new b(paramInt, paramString, (byte)0));
    if ((paramInt == -4) || (paramInt == -5)) {
      stop();
    }
    AppMethodBeat.o(88036);
  }
  
  /* Error */
  void a(android.os.Handler paramHandler, d.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 435
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: instanceof 12
    //   12: ifeq +50 -> 62
    //   15: aload_2
    //   16: checkcast 12	com/d/a/a/n$c
    //   19: astore_2
    //   20: aload_0
    //   21: aload_2
    //   22: getfield 438	com/d/a/a/n$c:bZm	J
    //   25: putfield 440	com/d/a/a/n:bYV	J
    //   28: aload_0
    //   29: invokespecial 272	com/d/a/a/n:Al	()V
    //   32: aload_0
    //   33: getfield 91	com/d/a/a/n:bYU	Lcom/d/a/a/s;
    //   36: aload_1
    //   37: putfield 444	com/d/a/a/s:cad	Landroid/os/Handler;
    //   40: aload_0
    //   41: invokestatic 120	android/os/SystemClock:elapsedRealtime	()J
    //   44: putfield 274	com/d/a/a/n:bZi	J
    //   47: aload_0
    //   48: aload_1
    //   49: aload_2
    //   50: invokespecial 446	com/d/a/a/b:a	(Landroid/os/Handler;Lcom/d/a/a/d$a;)V
    //   53: ldc_w 435
    //   56: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_2
    //   63: ifnull +23 -> 86
    //   66: aload_2
    //   67: getfield 451	com/d/a/a/d$a:bWP	J
    //   70: lstore_3
    //   71: new 12	com/d/a/a/n$c
    //   74: dup
    //   75: lload_3
    //   76: ldc2_w 452
    //   79: invokespecial 456	com/d/a/a/n$c:<init>	(JJ)V
    //   82: astore_2
    //   83: goto -63 -> 20
    //   86: ldc2_w 209
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
    AppMethodBeat.i(88033);
    this.bYW = paramx.bZS;
    this.bYY = paramx.level;
    this.bYZ = paramx.bZl;
    if ((paramx.provider.equals("W")) && (a(paramLong2, 2, paramx.latitude, paramx.longitude, paramx.altitude, paramx.bYG, paramx.ccy, paramx.bdQ))) {
      this.bYT.a(paramx.latitude, paramx.longitude, paramx.bYG, this.bZd, this.bZe, this.bZf);
    }
    if (!u.AE().caR) {
      c(new a(paramx.latitude, paramx.longitude, Float.valueOf(paramx.bYG).intValue(), this.bYY, this.bYZ));
    }
    AppMethodBeat.o(88033);
  }
  
  final void a(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88032);
    paramLong1 = aa.az(paramLong1);
    boolean bool;
    Object localObject1;
    Object localObject2;
    r localr;
    int i;
    long l1;
    if ((this.bYW != 0L) && (paramLong2 - this.bYW < this.bYV))
    {
      bool = false;
      localObject1 = v.a(paramList, bool);
      localObject2 = this.bYS.a((String)localObject1, paramLong2, bool);
      if (!bool) {
        break label320;
      }
      localr = r.An();
      i = this.bZh;
      if (localObject2 != null)
      {
        if (!localr.isRunning) {
          break label278;
        }
        if (!localr.Ap()) {
          break label273;
        }
        l1 = System.currentTimeMillis();
        long l2 = SystemClock.elapsedRealtime();
        if (localr.bZG != null) {
          localr.bZG.execute(new r.e(localr, (String)localObject2, l1, l2, i, (byte)0));
        }
      }
      label142:
      if (d.o(paramLong2, this.bYX)) {
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
      paramList = v.b((String)localObject2, paramLong1, "2");
      localObject1 = this.bYU;
      float f1 = this.bZd;
      float f2 = this.bZe;
      float f3 = this.bZf;
      float f4 = this.bZg;
      i = this.bYY;
      if (((s)localObject1).bZY != 0.0F) {
        z.b(null).execute(new s.a((s)localObject1, f1, f2, f3, f4, i, paramList, (byte)0));
      }
      AppMethodBeat.o(88032);
      return;
      bool = true;
      break;
      label273:
      localr.Ao();
      label278:
      l1 = aa.az(System.currentTimeMillis());
      if (localr.bZG == null) {
        break label142;
      }
      localr.bZG.execute(new r.c(localr, (String)localObject2, l1, 0, (byte)0));
      break label142;
      label320:
      r.An().cm(v.b((String)localObject2, paramLong1, "0"));
      break label142;
      label338:
      localObject1 = null;
    }
  }
  
  final void stop()
  {
    try
    {
      AppMethodBeat.i(88038);
      this.bYU.Av();
      super.stop();
      AppMethodBeat.o(88038);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static final class a
    extends p
  {
    final int bZj;
    final int bZk;
    final long bZl;
    final double lat;
    final double lng;
    
    a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.bZj = paramInt1;
      this.bZk = paramInt2;
      this.bZl = paramLong;
    }
  }
  
  static final class b
    extends p
  {
    final boolean authResult;
    final int code;
    final String message;
    
    private b(int paramInt, String paramString)
    {
      super();
      this.code = paramInt;
      this.message = paramString;
      this.authResult = false;
    }
    
    b(int paramInt, String paramString, byte paramByte)
    {
      this(paramInt, paramString);
    }
  }
  
  static final class c
    extends d.a
  {
    final long bZm;
    
    c(long paramLong1, long paramLong2)
    {
      super();
      AppMethodBeat.i(88025);
      this.bZm = paramLong2;
      AppMethodBeat.o(88025);
    }
  }
  
  static final class d
  {
    private String bZn;
    private long bZo;
    private String bZp;
    private long bZq;
    
    static boolean o(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(88027);
      if (Math.abs(paramLong1 - paramLong2) <= 10000L)
      {
        AppMethodBeat.o(88027);
        return true;
      }
      AppMethodBeat.o(88027);
      return false;
    }
    
    /* Error */
    final String a(String paramString, long paramLong, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 42
      //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: iload 4
      //   9: ifeq +116 -> 125
      //   12: aload_1
      //   13: astore 5
      //   15: aload_0
      //   16: getfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
      //   19: ifnull +45 -> 64
      //   22: aload_1
      //   23: astore 5
      //   25: lload_2
      //   26: aload_0
      //   27: getfield 46	com/d/a/a/n$d:bZo	J
      //   30: invokestatic 48	com/d/a/a/n$d:o	(JJ)Z
      //   33: ifeq +31 -> 64
      //   36: new 50	java/lang/StringBuilder
      //   39: dup
      //   40: aload_1
      //   41: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   44: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   47: aload_0
      //   48: getfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
      //   51: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   54: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   57: astore 5
      //   59: aload_0
      //   60: aconst_null
      //   61: putfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
      //   64: aload 5
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
      //   71: ifnull +45 -> 116
      //   74: aload 5
      //   76: astore_1
      //   77: lload_2
      //   78: aload_0
      //   79: getfield 71	com/d/a/a/n$d:bZq	J
      //   82: invokestatic 48	com/d/a/a/n$d:o	(JJ)Z
      //   85: ifeq +31 -> 116
      //   88: new 50	java/lang/StringBuilder
      //   91: dup
      //   92: aload 5
      //   94: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   97: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   100: aload_0
      //   101: getfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
      //   104: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   110: astore_1
      //   111: aload_0
      //   112: aconst_null
      //   113: putfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
      //   116: ldc 42
      //   118: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   121: aload_0
      //   122: monitorexit
      //   123: aload_1
      //   124: areturn
      //   125: aload_1
      //   126: astore 5
      //   128: aload_0
      //   129: getfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
      //   132: ifnull +48 -> 180
      //   135: aload_1
      //   136: astore 5
      //   138: lload_2
      //   139: aload_0
      //   140: getfield 46	com/d/a/a/n$d:bZo	J
      //   143: invokestatic 48	com/d/a/a/n$d:o	(JJ)Z
      //   146: ifeq +34 -> 180
      //   149: new 50	java/lang/StringBuilder
      //   152: dup
      //   153: aload_1
      //   154: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   157: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   160: aload_0
      //   161: getfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
      //   164: invokestatic 77	com/d/a/a/v:cr	(Ljava/lang/String;)Ljava/lang/String;
      //   167: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   173: astore 5
      //   175: aload_0
      //   176: aconst_null
      //   177: putfield 44	com/d/a/a/n$d:bZn	Ljava/lang/String;
      //   180: aload 5
      //   182: astore_1
      //   183: aload_0
      //   184: getfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
      //   187: ifnull -71 -> 116
      //   190: aload 5
      //   192: astore_1
      //   193: lload_2
      //   194: aload_0
      //   195: getfield 71	com/d/a/a/n$d:bZq	J
      //   198: invokestatic 48	com/d/a/a/n$d:o	(JJ)Z
      //   201: ifeq -85 -> 116
      //   204: new 50	java/lang/StringBuilder
      //   207: dup
      //   208: aload 5
      //   210: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   213: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   216: aload_0
      //   217: getfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
      //   220: invokestatic 80	com/d/a/a/v:cq	(Ljava/lang/String;)Ljava/lang/String;
      //   223: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   226: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   229: astore_1
      //   230: aload_0
      //   231: aconst_null
      //   232: putfield 69	com/d/a/a/n$d:bZp	Ljava/lang/String;
      //   235: goto -119 -> 116
      //   238: astore_1
      //   239: aload_0
      //   240: monitorexit
      //   241: aload_1
      //   242: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	243	0	this	d
      //   0	243	1	paramString	String
      //   0	243	2	paramLong	long
      //   0	243	4	paramBoolean	boolean
      //   13	196	5	str	String
      // Exception table:
      //   from	to	target	type
      //   2	7	238	finally
      //   15	22	238	finally
      //   25	64	238	finally
      //   67	74	238	finally
      //   77	116	238	finally
      //   116	121	238	finally
      //   128	135	238	finally
      //   138	180	238	finally
      //   183	190	238	finally
      //   193	235	238	finally
    }
    
    final void l(String paramString, long paramLong)
    {
      try
      {
        this.bZn = paramString;
        this.bZo = paramLong;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    final void m(String paramString, long paramLong)
    {
      try
      {
        this.bZp = paramString;
        this.bZq = paramLong;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    final void reset()
    {
      try
      {
        this.bZn = null;
        this.bZp = null;
        this.bZo = 0L;
        this.bZq = 0L;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  final class e
  {
    long bZr;
    boolean bZs = y.ccM;
    
    private e() {}
    
    private void reset()
    {
      this.bZr = 0L;
      this.bZs = y.ccM;
    }
    
    final void bk(boolean paramBoolean)
    {
      AppMethodBeat.i(88028);
      StringBuilder localStringBuilder;
      if ((this.bZs ^ paramBoolean))
      {
        if (!this.bZs) {
          break label156;
        }
        paramBoolean = false;
        this.bZs = paramBoolean;
        n.this.bYU.Av();
        n.this.bYU.Ax();
        n.this.bYR.bk(this.bZs);
        n.this.Ak();
        if (y.ccH)
        {
          localStringBuilder = new StringBuilder("vehicle mode: ");
          if (!this.bZs) {
            break label161;
          }
        }
      }
      label156:
      label161:
      for (String str = "enable";; str = "disable")
      {
        str = str;
        o.t("filter_input_log_" + y.ccO, str);
        o.t("filter_output_log_" + y.ccO, str);
        AppMethodBeat.o(88028);
        return;
        paramBoolean = true;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.n
 * JD-Core Version:    0.7.0.1
 */