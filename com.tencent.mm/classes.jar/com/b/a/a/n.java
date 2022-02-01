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
  private final i cjA;
  final s cjB;
  private long cjC;
  private long cjD;
  private long cjE;
  private int cjF;
  private long cjG;
  private boolean cjH;
  private Location cjI;
  private int cjJ;
  private float cjK;
  private float cjL;
  private float cjM;
  private int cjN;
  private int cjO;
  private long cjP;
  private final e cjx;
  final j cjy;
  private final d cjz;
  
  n()
  {
    AppMethodBeat.i(88030);
    this.cjx = new e((byte)0);
    this.cjy = new j();
    this.cjz = new d((byte)0);
    if (i.chY == null) {
      i.chY = new i();
    }
    this.cjA = i.chY;
    this.cjH = true;
    this.cjB = new s(this);
    AppMethodBeat.o(88030);
  }
  
  private void Je()
  {
    AppMethodBeat.i(88039);
    this.cjA.cif = false;
    this.cjB.Jq();
    this.cjz.reset();
    e.a(this.cjx);
    Jd();
    this.cjD = 0L;
    this.cjE = SystemClock.elapsedRealtime();
    this.cjK = 0.0F;
    this.cjL = 0.0F;
    this.cjM = 0.0F;
    this.cjN = 0;
    this.cjO = 0;
    this.cjF = 0;
    AppMethodBeat.o(88039);
  }
  
  private boolean a(long paramLong, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, int paramInt2, float paramFloat2)
  {
    AppMethodBeat.i(88031);
    paramLong /= 1000L;
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble2);
    if (this.cjH)
    {
      this.cjy.a(paramLong, paramDouble1, paramDouble2, paramFloat1, this.cjx.cjZ, y.cnt);
      this.cjH = false;
    }
    for (boolean bool = true;; bool = false)
    {
      j.a locala = new j.a(paramInt1, paramLong, paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramInt2, paramFloat2, 0, 0.0D, 0.0D);
      this.cjy.a(locala);
      if (y.cnn) {
        o.t("filter_input_log_" + y.cnu, locala.toString());
      }
      AppMethodBeat.o(88031);
      return bool;
    }
  }
  
  final void Jd()
  {
    this.cjH = true;
    this.cjI = null;
    this.cjJ = 0;
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
    Object localObject = this.cjx;
    if (paramInt3 >= 3)
    {
      if (paramLong2 - ((e)localObject).cjY <= 5000L) {
        ((e)localObject).bK(true);
      }
      ((e)localObject).cjY = paramLong2;
    }
    int i = Math.round(paramFloat);
    if (!v.b(paramDouble1, paramDouble2)) {}
    for (localObject = "";; localObject = "&GD=" + paramDouble1 + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt3 + ',' + paramInt5 + ',' + paramInt2 + ',' + i + ',' + paramLong1 + ',')
    {
      this.cjz.m((String)localObject, paramLong2);
      if (a(paramLong2, 1, paramDouble1, paramDouble2, paramInt1, paramInt2, paramInt5, paramInt3)) {
        this.cjA.a(paramDouble1, paramDouble2, paramInt2, this.cjK, this.cjL, this.cjM);
      }
      if (d.o(paramLong2, this.cjE)) {
        this.cjB.a(paramDouble1, paramDouble2, paramInt2, paramFloat, this.cjK, this.cjL, this.cjM, paramLong2);
      }
      if (y.cnn) {
        o.t("gps_log_" + y.cnu, String.valueOf(paramDouble1) + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4 + ',' + paramInt5 + ',' + paramFloat + ',' + paramLong1);
      }
      AppMethodBeat.o(88035);
      return;
    }
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong)
  {
    AppMethodBeat.i(88034);
    Object localObject1 = this.cjx;
    if (paramLong - ((e)localObject1).cjY > 5000L) {
      ((e)localObject1).bK(false);
    }
    if (paramLong - this.cjE > 5000L) {
      Je();
    }
    this.cjK = paramFloat1;
    this.cjL = paramFloat2;
    this.cjM = paramFloat4;
    this.cjN = paramInt;
    this.cjE = paramLong;
    boolean bool;
    if (paramFloat5 > 0.0F)
    {
      i = 1;
      this.cjO = i;
      if ((this.cjD != 0L) || (paramLong - this.cjP >= 30000L))
      {
        if (i != 0) {
          break label339;
        }
        bool = true;
        label125:
        if ((!bool) || (!this.cjx.cjZ))
        {
          ab.JD().bJ(bool);
          k.Jc().bJ(bool);
        }
      }
      localObject1 = new double[2];
      localObject2 = this.cjA;
      arrayOfDouble1 = new double[2];
      arrayOfDouble1[0] = paramFloat1;
      arrayOfDouble1[1] = paramFloat2;
      if (!((i)localObject2).cif) {
        break label397;
      }
      localObject1[0] = ((i)localObject2).chZ;
      localObject1[1] = ((i)localObject2).cia;
      localObject1[0] += 1.E-005D * (arrayOfDouble1[1] - ((i)localObject2).anchorY) / ((i)localObject2).cid;
      localObject1[1] += 1.E-005D * (arrayOfDouble1[0] - ((i)localObject2).anchorX) / ((i)localObject2).cie;
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
    localObject1 = this.cjA;
    paramFloat2 = (paramFloat4 - ((i)localObject1).cib) / 10.0F;
    paramFloat4 = ((i)localObject1).cic;
    paramFloat1 = 0.0F;
    localObject1 = new Location("S");
    ((Location)localObject1).setLatitude(d1);
    ((Location)localObject1).setLongitude(d2);
    if (this.cjI != null) {
      paramFloat1 = this.cjI.bearingTo((Location)localObject1);
    }
    this.cjI = ((Location)localObject1);
    i = Math.max(0, paramInt - this.cjJ);
    this.cjJ = paramInt;
    long l = paramLong / 1000L;
    d1 = Math.toRadians(d1);
    d2 = Math.toRadians(d2);
    double d3 = Math.toRadians(paramFloat1);
    localObject1 = new j.a(3, l, d1, d2, 0.0D, paramFloat2 + paramFloat4, 0, paramFloat5, i, paramFloat3, d3);
    this.cjy.a((j.a)localObject1);
    if (y.cnn) {
      o.t("filter_input_log_" + y.cnu, ((j.a)localObject1).toString());
    }
    localObject1 = new double[4];
    l = paramLong / 1000L;
    Object localObject2 = new double[2];
    double[] arrayOfDouble1 = new double[2];
    double[] arrayOfDouble2 = new double[2];
    double[][] arrayOfDouble3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    double[][] arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    j localj = this.cjy;
    d1 = l - localj.cih.cij;
    d2 = d1 * d1;
    double[] arrayOfDouble5 = new double[2];
    localObject2[0] = (localj.cih.ciS[0] + localj.cih.ciS[2] * d1);
    d3 = localj.cih.ciS[1];
    localObject2[1] = (d1 * localj.cih.ciS[3] + d3);
    arrayOfDouble2[0] = localj.cih.ciS[2];
    arrayOfDouble2[1] = localj.cih.ciS[3];
    int j;
    if (localj.cih.ciA)
    {
      localObject2[0] -= localj.cih.ciB[0];
      localObject2[1] -= localj.cih.ciB[1];
      d1 = Math.sqrt(arrayOfDouble5[0] * arrayOfDouble5[0] + arrayOfDouble5[1] * arrayOfDouble5[1]);
      d1 = d1 * d1 * localj.cih.ciV;
      arrayOfDouble3[0][0] = (localj.cih.ciT[0][0] + localj.cih.ciT[2][2] * d2 + d1);
      arrayOfDouble3[0][1] = (localj.cih.ciT[0][1] + localj.cih.ciT[2][3] * d2);
      arrayOfDouble3[1][0] = (localj.cih.ciT[1][0] + localj.cih.ciT[3][2] * d2);
      arrayOfDouble5 = arrayOfDouble3[1];
      d3 = localj.cih.ciT[1][1];
      arrayOfDouble5[1] = (d1 + (d2 * localj.cih.ciT[3][3] + d3));
      arrayOfDouble4[0][0] = localj.cih.ciT[2][2];
      arrayOfDouble4[0][1] = localj.cih.ciT[2][3];
      arrayOfDouble4[1][0] = localj.cih.ciT[3][2];
      arrayOfDouble4[1][1] = localj.cih.ciT[3][3];
      localj.a(1, (double[])localObject2, arrayOfDouble1);
      localObject1[0] = Math.toDegrees(arrayOfDouble1[0]);
      localObject1[1] = Math.toDegrees(arrayOfDouble1[1]);
      localObject1[2] = Math.sqrt((arrayOfDouble3[0][0] + arrayOfDouble3[1][1]) / 2.0D);
      d1 = arrayOfDouble2[0];
      d2 = arrayOfDouble2[0];
      d3 = arrayOfDouble2[1];
      localObject1[3] = Math.sqrt(d1 * d2 + arrayOfDouble2[1] * d3);
      if (y.cnn) {
        o.t("filter_output_log_" + y.cnu, String.valueOf(l) + ',' + localObject1[0] + ',' + localObject1[1] + ',' + localObject1[2] + ',' + localObject1[3]);
      }
      d1 = localObject1[0];
      d2 = localObject1[1];
      paramInt = Double.valueOf(localObject1[2]).intValue();
      i = Double.valueOf(localObject1[3]).intValue();
      j = this.cjF;
      if (v.b(d1, d2)) {
        break label1409;
      }
    }
    label1409:
    for (localObject1 = "";; localObject1 = "&SD=" + d1 + ',' + d2 + ',' + 0 + ',' + paramInt + ',' + j + ',' + 0 + ',' + i + ',' + 0 + ',' + 0 + ',' + 0)
    {
      this.cjz.n((String)localObject1, paramLong);
      c(new a(d1, d2, paramInt, this.cjF, this.cjG));
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
    //   16: checkcast 12	com/b/a/a/n$c
    //   19: astore_2
    //   20: aload_0
    //   21: aload_2
    //   22: getfield 438	com/b/a/a/n$c:cjT	J
    //   25: putfield 440	com/b/a/a/n:cjC	J
    //   28: aload_0
    //   29: invokespecial 272	com/b/a/a/n:Je	()V
    //   32: aload_0
    //   33: getfield 91	com/b/a/a/n:cjB	Lcom/b/a/a/s;
    //   36: aload_1
    //   37: putfield 444	com/b/a/a/s:ckJ	Landroid/os/Handler;
    //   40: aload_0
    //   41: invokestatic 120	android/os/SystemClock:elapsedRealtime	()J
    //   44: putfield 274	com/b/a/a/n:cjP	J
    //   47: aload_0
    //   48: aload_1
    //   49: aload_2
    //   50: invokespecial 446	com/b/a/a/b:a	(Landroid/os/Handler;Lcom/b/a/a/d$a;)V
    //   53: ldc_w 435
    //   56: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_2
    //   63: ifnull +23 -> 86
    //   66: aload_2
    //   67: getfield 451	com/b/a/a/d$a:chx	J
    //   70: lstore_3
    //   71: new 12	com/b/a/a/n$c
    //   74: dup
    //   75: lload_3
    //   76: ldc2_w 452
    //   79: invokespecial 456	com/b/a/a/n$c:<init>	(JJ)V
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
    this.cjD = paramx.ckz;
    this.cjF = paramx.level;
    this.cjG = paramx.cjS;
    if ((paramx.provider.equals("W")) && (a(paramLong2, 2, paramx.latitude, paramx.longitude, paramx.altitude, paramx.cjn, paramx.cne, paramx.bdN))) {
      this.cjA.a(paramx.latitude, paramx.longitude, paramx.cjn, this.cjK, this.cjL, this.cjM);
    }
    if (!u.Jx().clx) {
      c(new a(paramx.latitude, paramx.longitude, Float.valueOf(paramx.cjn).intValue(), this.cjF, this.cjG));
    }
    AppMethodBeat.o(88033);
  }
  
  final void a(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88032);
    paramLong1 = aa.aM(paramLong1);
    boolean bool;
    Object localObject1;
    Object localObject2;
    r localr;
    int i;
    long l1;
    if ((this.cjD != 0L) && (paramLong2 - this.cjD < this.cjC))
    {
      bool = false;
      localObject1 = v.a(paramList, bool);
      localObject2 = this.cjz.a((String)localObject1, paramLong2, bool);
      if (!bool) {
        break label319;
      }
      localr = r.Jg();
      i = this.cjO;
      if (localObject2 != null)
      {
        if (!localr.isRunning) {
          break label277;
        }
        if (!localr.Ji()) {
          break label272;
        }
        l1 = System.currentTimeMillis();
        long l2 = SystemClock.elapsedRealtime();
        if (localr.ckn != null) {
          localr.ckn.execute(new r.e(localr, (String)localObject2, l1, l2, i));
        }
      }
      label141:
      if (d.o(paramLong2, this.cjE)) {
        if (bool) {
          break label337;
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
      localObject1 = this.cjB;
      float f1 = this.cjK;
      float f2 = this.cjL;
      float f3 = this.cjM;
      float f4 = this.cjN;
      i = this.cjF;
      if (((s)localObject1).ckE != 0.0F) {
        z.b(null).execute(new s.a((s)localObject1, f1, f2, f3, f4, i, paramList, (byte)0));
      }
      AppMethodBeat.o(88032);
      return;
      bool = true;
      break;
      label272:
      localr.Jh();
      label277:
      l1 = aa.aM(System.currentTimeMillis());
      if (localr.ckn == null) {
        break label141;
      }
      localr.ckn.execute(new r.c(localr, (String)localObject2, l1, 0, (byte)0));
      break label141;
      label319:
      r.Jg().cB(v.b((String)localObject2, paramLong1, "0"));
      break label141;
      label337:
      localObject1 = null;
    }
  }
  
  final void stop()
  {
    try
    {
      AppMethodBeat.i(88038);
      this.cjB.Jo();
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
    final int cjQ;
    final int cjR;
    final long cjS;
    final double lat;
    final double lng;
    
    a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.cjQ = paramInt1;
      this.cjR = paramInt2;
      this.cjS = paramLong;
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
    final long cjT;
    
    c(long paramLong1, long paramLong2)
    {
      super();
      AppMethodBeat.i(88025);
      this.cjT = paramLong2;
      AppMethodBeat.o(88025);
    }
  }
  
  static final class d
  {
    private String cjU;
    private long cjV;
    private String cjW;
    private long cjX;
    
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
      //   16: getfield 44	com/b/a/a/n$d:cjU	Ljava/lang/String;
      //   19: ifnull +45 -> 64
      //   22: aload_1
      //   23: astore 5
      //   25: lload_2
      //   26: aload_0
      //   27: getfield 46	com/b/a/a/n$d:cjV	J
      //   30: invokestatic 48	com/b/a/a/n$d:o	(JJ)Z
      //   33: ifeq +31 -> 64
      //   36: new 50	java/lang/StringBuilder
      //   39: dup
      //   40: aload_1
      //   41: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   44: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   47: aload_0
      //   48: getfield 44	com/b/a/a/n$d:cjU	Ljava/lang/String;
      //   51: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   54: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   57: astore 5
      //   59: aload_0
      //   60: aconst_null
      //   61: putfield 44	com/b/a/a/n$d:cjU	Ljava/lang/String;
      //   64: aload 5
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 69	com/b/a/a/n$d:cjW	Ljava/lang/String;
      //   71: ifnull +45 -> 116
      //   74: aload 5
      //   76: astore_1
      //   77: lload_2
      //   78: aload_0
      //   79: getfield 71	com/b/a/a/n$d:cjX	J
      //   82: invokestatic 48	com/b/a/a/n$d:o	(JJ)Z
      //   85: ifeq +31 -> 116
      //   88: new 50	java/lang/StringBuilder
      //   91: dup
      //   92: aload 5
      //   94: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   97: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   100: aload_0
      //   101: getfield 69	com/b/a/a/n$d:cjW	Ljava/lang/String;
      //   104: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   110: astore_1
      //   111: aload_0
      //   112: aconst_null
      //   113: putfield 69	com/b/a/a/n$d:cjW	Ljava/lang/String;
      //   116: ldc 42
      //   118: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   121: aload_0
      //   122: monitorexit
      //   123: aload_1
      //   124: areturn
      //   125: aload_1
      //   126: astore 5
      //   128: aload_0
      //   129: getfield 44	com/b/a/a/n$d:cjU	Ljava/lang/String;
      //   132: ifnull +48 -> 180
      //   135: aload_1
      //   136: astore 5
      //   138: lload_2
      //   139: aload_0
      //   140: getfield 46	com/b/a/a/n$d:cjV	J
      //   143: invokestatic 48	com/b/a/a/n$d:o	(JJ)Z
      //   146: ifeq +34 -> 180
      //   149: new 50	java/lang/StringBuilder
      //   152: dup
      //   153: aload_1
      //   154: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   157: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   160: aload_0
      //   161: getfield 44	com/b/a/a/n$d:cjU	Ljava/lang/String;
      //   164: invokestatic 77	com/b/a/a/v:cG	(Ljava/lang/String;)Ljava/lang/String;
      //   167: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   173: astore 5
      //   175: aload_0
      //   176: aconst_null
      //   177: putfield 44	com/b/a/a/n$d:cjU	Ljava/lang/String;
      //   180: aload 5
      //   182: astore_1
      //   183: aload_0
      //   184: getfield 69	com/b/a/a/n$d:cjW	Ljava/lang/String;
      //   187: ifnull -71 -> 116
      //   190: aload 5
      //   192: astore_1
      //   193: lload_2
      //   194: aload_0
      //   195: getfield 71	com/b/a/a/n$d:cjX	J
      //   198: invokestatic 48	com/b/a/a/n$d:o	(JJ)Z
      //   201: ifeq -85 -> 116
      //   204: new 50	java/lang/StringBuilder
      //   207: dup
      //   208: aload 5
      //   210: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   213: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   216: aload_0
      //   217: getfield 69	com/b/a/a/n$d:cjW	Ljava/lang/String;
      //   220: invokestatic 80	com/b/a/a/v:cF	(Ljava/lang/String;)Ljava/lang/String;
      //   223: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   226: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   229: astore_1
      //   230: aload_0
      //   231: aconst_null
      //   232: putfield 69	com/b/a/a/n$d:cjW	Ljava/lang/String;
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
    
    final void m(String paramString, long paramLong)
    {
      try
      {
        this.cjU = paramString;
        this.cjV = paramLong;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    final void n(String paramString, long paramLong)
    {
      try
      {
        this.cjW = paramString;
        this.cjX = paramLong;
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
        this.cjU = null;
        this.cjW = null;
        this.cjV = 0L;
        this.cjX = 0L;
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
    long cjY;
    boolean cjZ = y.cns;
    
    private e() {}
    
    private void reset()
    {
      this.cjY = 0L;
      this.cjZ = y.cns;
    }
    
    final void bK(boolean paramBoolean)
    {
      AppMethodBeat.i(88028);
      StringBuilder localStringBuilder;
      if ((this.cjZ ^ paramBoolean))
      {
        if (!this.cjZ) {
          break label156;
        }
        paramBoolean = false;
        this.cjZ = paramBoolean;
        n.this.cjB.Jo();
        n.this.cjB.Jq();
        n.this.cjy.bK(this.cjZ);
        n.this.Jd();
        if (y.cnn)
        {
          localStringBuilder = new StringBuilder("vehicle mode: ");
          if (!this.cjZ) {
            break label161;
          }
        }
      }
      label156:
      label161:
      for (String str = "enable";; str = "disable")
      {
        str = str;
        o.t("filter_input_log_" + y.cnu, str);
        o.t("filter_output_log_" + y.cnu, str);
        AppMethodBeat.o(88028);
        return;
        paramBoolean = true;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.n
 * JD-Core Version:    0.7.0.1
 */