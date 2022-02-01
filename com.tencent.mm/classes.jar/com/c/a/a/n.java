package com.c.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.List;

class n
  extends b
{
  private final e bQV;
  final j bQW;
  private final n.d bQX;
  private final i bQY;
  final s bQZ;
  private long bRa;
  private long bRb;
  private long bRc;
  private int bRd;
  private long bRe;
  private boolean bRf;
  private Location bRg;
  private int bRh;
  private float bRi;
  private float bRj;
  private float bRk;
  private int bRl;
  private int bRm;
  private long bRn;
  
  n()
  {
    AppMethodBeat.i(88030);
    this.bQV = new e((byte)0);
    this.bQW = new j();
    this.bQX = new n.d((byte)0);
    if (i.bPw == null) {
      i.bPw = new i();
    }
    this.bQY = i.bPw;
    this.bRf = true;
    this.bQZ = new s(this);
    AppMethodBeat.o(88030);
  }
  
  private boolean a(long paramLong, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, int paramInt2, float paramFloat2)
  {
    AppMethodBeat.i(88031);
    paramLong /= 1000L;
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble2);
    if (this.bRf)
    {
      this.bQW.a(paramLong, paramDouble1, paramDouble2, paramFloat1, this.bQV.bRx, y.bUS);
      this.bRf = false;
    }
    for (boolean bool = true;; bool = false)
    {
      j.a locala = new j.a(paramInt1, paramLong, paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramInt2, paramFloat2, 0, 0.0D, 0.0D);
      this.bQW.a(locala);
      if (y.bUM) {
        o.s("filter_input_log_" + y.bUT, locala.toString());
      }
      AppMethodBeat.o(88031);
      return bool;
    }
  }
  
  private void za()
  {
    AppMethodBeat.i(88039);
    this.bQY.bPD = false;
    this.bQZ.zm();
    this.bQX.reset();
    e.a(this.bQV);
    yZ();
    this.bRb = 0L;
    this.bRc = SystemClock.elapsedRealtime();
    this.bRi = 0.0F;
    this.bRj = 0.0F;
    this.bRk = 0.0F;
    this.bRl = 0;
    this.bRm = 0;
    this.bRd = 0;
    AppMethodBeat.o(88039);
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
    Object localObject = this.bQV;
    if (paramInt3 >= 3)
    {
      if (paramLong2 - ((e)localObject).bRw <= 5000L) {
        ((e)localObject).bk(true);
      }
      ((e)localObject).bRw = paramLong2;
    }
    int i = Math.round(paramFloat);
    if (!v.b(paramDouble1, paramDouble2)) {}
    for (localObject = "";; localObject = "&GD=" + paramDouble1 + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt3 + ',' + paramInt5 + ',' + paramInt2 + ',' + i + ',' + paramLong1 + ',')
    {
      this.bQX.l((String)localObject, paramLong2);
      if (a(paramLong2, 1, paramDouble1, paramDouble2, paramInt1, paramInt2, paramInt5, paramInt3)) {
        this.bQY.a(paramDouble1, paramDouble2, paramInt2, this.bRi, this.bRj, this.bRk);
      }
      if (n.d.r(paramLong2, this.bRc)) {
        this.bQZ.a(paramDouble1, paramDouble2, paramInt2, paramFloat, this.bRi, this.bRj, this.bRk, paramLong2);
      }
      if (y.bUM) {
        o.s("gps_log_" + y.bUT, String.valueOf(paramDouble1) + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4 + ',' + paramInt5 + ',' + paramFloat + ',' + paramLong1);
      }
      AppMethodBeat.o(88035);
      return;
    }
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong)
  {
    AppMethodBeat.i(88034);
    Object localObject1 = this.bQV;
    if (paramLong - ((e)localObject1).bRw > 5000L) {
      ((e)localObject1).bk(false);
    }
    if (paramLong - this.bRc > 5000L) {
      za();
    }
    this.bRi = paramFloat1;
    this.bRj = paramFloat2;
    this.bRk = paramFloat4;
    this.bRl = paramInt;
    this.bRc = paramLong;
    boolean bool;
    if (paramFloat5 > 0.0F)
    {
      i = 1;
      this.bRm = i;
      if ((this.bRb != 0L) || (paramLong - this.bRn >= 30000L))
      {
        if (i != 0) {
          break label339;
        }
        bool = true;
        label125:
        if ((!bool) || (!this.bQV.bRx))
        {
          ab.zz().bj(bool);
          k.yY().bj(bool);
        }
      }
      localObject1 = new double[2];
      localObject2 = this.bQY;
      arrayOfDouble1 = new double[2];
      arrayOfDouble1[0] = paramFloat1;
      arrayOfDouble1[1] = paramFloat2;
      if (!((i)localObject2).bPD) {
        break label397;
      }
      localObject1[0] = ((i)localObject2).bPx;
      localObject1[1] = ((i)localObject2).bPy;
      localObject1[0] += 1.E-005D * (arrayOfDouble1[1] - ((i)localObject2).anchorY) / ((i)localObject2).bPB;
      localObject1[1] += 1.E-005D * (arrayOfDouble1[0] - ((i)localObject2).anchorX) / ((i)localObject2).bPC;
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
    localObject1 = this.bQY;
    paramFloat2 = (paramFloat4 - ((i)localObject1).bPz) / 10.0F;
    paramFloat4 = ((i)localObject1).bPA;
    paramFloat1 = 0.0F;
    localObject1 = new Location("S");
    ((Location)localObject1).setLatitude(d1);
    ((Location)localObject1).setLongitude(d2);
    if (this.bRg != null) {
      paramFloat1 = this.bRg.bearingTo((Location)localObject1);
    }
    this.bRg = ((Location)localObject1);
    i = Math.max(0, paramInt - this.bRh);
    this.bRh = paramInt;
    long l = paramLong / 1000L;
    d1 = Math.toRadians(d1);
    d2 = Math.toRadians(d2);
    double d3 = Math.toRadians(paramFloat1);
    localObject1 = new j.a(3, l, d1, d2, 0.0D, paramFloat2 + paramFloat4, 0, paramFloat5, i, paramFloat3, d3);
    this.bQW.a((j.a)localObject1);
    if (y.bUM) {
      o.s("filter_input_log_" + y.bUT, ((j.a)localObject1).toString());
    }
    localObject1 = new double[4];
    l = paramLong / 1000L;
    Object localObject2 = new double[2];
    double[] arrayOfDouble1 = new double[2];
    double[] arrayOfDouble2 = new double[2];
    double[][] arrayOfDouble3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    double[][] arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    j localj = this.bQW;
    d1 = l - localj.bPF.bPH;
    d2 = d1 * d1;
    double[] arrayOfDouble5 = new double[2];
    localObject2[0] = (localj.bPF.bQq[0] + localj.bPF.bQq[2] * d1);
    d3 = localj.bPF.bQq[1];
    localObject2[1] = (d1 * localj.bPF.bQq[3] + d3);
    arrayOfDouble2[0] = localj.bPF.bQq[2];
    arrayOfDouble2[1] = localj.bPF.bQq[3];
    int j;
    if (localj.bPF.bPY)
    {
      localObject2[0] -= localj.bPF.bPZ[0];
      localObject2[1] -= localj.bPF.bPZ[1];
      d1 = Math.sqrt(arrayOfDouble5[0] * arrayOfDouble5[0] + arrayOfDouble5[1] * arrayOfDouble5[1]);
      d1 = d1 * d1 * localj.bPF.bQt;
      arrayOfDouble3[0][0] = (localj.bPF.bQr[0][0] + localj.bPF.bQr[2][2] * d2 + d1);
      arrayOfDouble3[0][1] = (localj.bPF.bQr[0][1] + localj.bPF.bQr[2][3] * d2);
      arrayOfDouble3[1][0] = (localj.bPF.bQr[1][0] + localj.bPF.bQr[3][2] * d2);
      arrayOfDouble5 = arrayOfDouble3[1];
      d3 = localj.bPF.bQr[1][1];
      arrayOfDouble5[1] = (d1 + (d2 * localj.bPF.bQr[3][3] + d3));
      arrayOfDouble4[0][0] = localj.bPF.bQr[2][2];
      arrayOfDouble4[0][1] = localj.bPF.bQr[2][3];
      arrayOfDouble4[1][0] = localj.bPF.bQr[3][2];
      arrayOfDouble4[1][1] = localj.bPF.bQr[3][3];
      localj.a(1, (double[])localObject2, arrayOfDouble1);
      localObject1[0] = Math.toDegrees(arrayOfDouble1[0]);
      localObject1[1] = Math.toDegrees(arrayOfDouble1[1]);
      localObject1[2] = Math.sqrt((arrayOfDouble3[0][0] + arrayOfDouble3[1][1]) / 2.0D);
      d1 = arrayOfDouble2[0];
      d2 = arrayOfDouble2[0];
      d3 = arrayOfDouble2[1];
      localObject1[3] = Math.sqrt(d1 * d2 + arrayOfDouble2[1] * d3);
      if (y.bUM) {
        o.s("filter_output_log_" + y.bUT, String.valueOf(l) + ',' + localObject1[0] + ',' + localObject1[1] + ',' + localObject1[2] + ',' + localObject1[3]);
      }
      d1 = localObject1[0];
      d2 = localObject1[1];
      paramInt = Double.valueOf(localObject1[2]).intValue();
      i = Double.valueOf(localObject1[3]).intValue();
      j = this.bRd;
      if (v.b(d1, d2)) {
        break label1409;
      }
    }
    label1409:
    for (localObject1 = "";; localObject1 = "&SD=" + d1 + ',' + d2 + ',' + 0 + ',' + paramInt + ',' + j + ',' + 0 + ',' + i + ',' + 0 + ',' + 0 + ',' + 0)
    {
      this.bQX.m((String)localObject1, paramLong);
      c(new a(d1, d2, paramInt, this.bRd, this.bRe));
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
    //   5: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: instanceof 12
    //   12: ifeq +50 -> 62
    //   15: aload_2
    //   16: checkcast 12	com/c/a/a/n$c
    //   19: astore_2
    //   20: aload_0
    //   21: aload_2
    //   22: getfield 438	com/c/a/a/n$c:bRr	J
    //   25: putfield 440	com/c/a/a/n:bRa	J
    //   28: aload_0
    //   29: invokespecial 268	com/c/a/a/n:za	()V
    //   32: aload_0
    //   33: getfield 90	com/c/a/a/n:bQZ	Lcom/c/a/a/s;
    //   36: aload_1
    //   37: putfield 444	com/c/a/a/s:bSi	Landroid/os/Handler;
    //   40: aload_0
    //   41: invokestatic 177	android/os/SystemClock:elapsedRealtime	()J
    //   44: putfield 270	com/c/a/a/n:bRn	J
    //   47: aload_0
    //   48: aload_1
    //   49: aload_2
    //   50: invokespecial 446	com/c/a/a/b:a	(Landroid/os/Handler;Lcom/c/a/a/d$a;)V
    //   53: ldc_w 435
    //   56: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_2
    //   63: ifnull +23 -> 86
    //   66: aload_2
    //   67: getfield 451	com/c/a/a/d$a:bOU	J
    //   70: lstore_3
    //   71: new 12	com/c/a/a/n$c
    //   74: dup
    //   75: lload_3
    //   76: ldc2_w 452
    //   79: invokespecial 456	com/c/a/a/n$c:<init>	(JJ)V
    //   82: astore_2
    //   83: goto -63 -> 20
    //   86: ldc2_w 204
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
    this.bRb = paramx.bRX;
    this.bRd = paramx.level;
    this.bRe = paramx.bRq;
    if ((paramx.provider.equals("W")) && (a(paramLong2, 2, paramx.latitude, paramx.longitude, paramx.altitude, paramx.bQL, paramx.bUD, paramx.aSD))) {
      this.bQY.a(paramx.latitude, paramx.longitude, paramx.bQL, this.bRi, this.bRj, this.bRk);
    }
    if (!u.zt().bSW) {
      c(new a(paramx.latitude, paramx.longitude, Float.valueOf(paramx.bQL).intValue(), this.bRd, this.bRe));
    }
    AppMethodBeat.o(88033);
  }
  
  final void a(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(88032);
    paramLong1 = aa.aD(paramLong1);
    boolean bool;
    Object localObject1;
    Object localObject2;
    r localr;
    int i;
    long l1;
    if ((this.bRb != 0L) && (paramLong2 - this.bRb < this.bRa))
    {
      bool = false;
      localObject1 = v.a(paramList, bool);
      localObject2 = this.bQX.a((String)localObject1, paramLong2, bool);
      if (!bool) {
        break label320;
      }
      localr = r.zc();
      i = this.bRm;
      if (localObject2 != null)
      {
        if (!localr.isRunning) {
          break label278;
        }
        if (!localr.ze()) {
          break label273;
        }
        l1 = System.currentTimeMillis();
        long l2 = SystemClock.elapsedRealtime();
        if (localr.bRL != null) {
          localr.bRL.execute(new r.e(localr, (String)localObject2, l1, l2, i, (byte)0));
        }
      }
      label142:
      if (n.d.r(paramLong2, this.bRc)) {
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
      localObject1 = this.bQZ;
      float f1 = this.bRi;
      float f2 = this.bRj;
      float f3 = this.bRk;
      float f4 = this.bRl;
      i = this.bRd;
      if (((s)localObject1).bSd != 0.0F) {
        z.b(null).execute(new s.a((s)localObject1, f1, f2, f3, f4, i, paramList, (byte)0));
      }
      AppMethodBeat.o(88032);
      return;
      bool = true;
      break;
      label273:
      localr.zd();
      label278:
      l1 = aa.aD(System.currentTimeMillis());
      if (localr.bRL == null) {
        break label142;
      }
      localr.bRL.execute(new r.c(localr, (String)localObject2, l1, 0, (byte)0));
      break label142;
      label320:
      r.zc().bB(v.b((String)localObject2, paramLong1, "0"));
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
      this.bQZ.zk();
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
  
  final void yZ()
  {
    this.bRf = true;
    this.bRg = null;
    this.bRh = 0;
  }
  
  static final class a
    extends p
  {
    final int bRo;
    final int bRp;
    final long bRq;
    final double lat;
    final double lng;
    
    a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.bRo = paramInt1;
      this.bRp = paramInt2;
      this.bRq = paramLong;
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
    final long bRr;
    
    c(long paramLong1, long paramLong2)
    {
      super();
      AppMethodBeat.i(88025);
      this.bRr = paramLong2;
      AppMethodBeat.o(88025);
    }
  }
  
  final class e
  {
    long bRw;
    boolean bRx = y.bUR;
    
    private e() {}
    
    private void reset()
    {
      this.bRw = 0L;
      this.bRx = y.bUR;
    }
    
    final void bk(boolean paramBoolean)
    {
      AppMethodBeat.i(88028);
      StringBuilder localStringBuilder;
      if ((this.bRx ^ paramBoolean))
      {
        if (!this.bRx) {
          break label156;
        }
        paramBoolean = false;
        this.bRx = paramBoolean;
        n.this.bQZ.zk();
        n.this.bQZ.zm();
        n.this.bQW.bk(this.bRx);
        n.this.yZ();
        if (y.bUM)
        {
          localStringBuilder = new StringBuilder("vehicle mode: ");
          if (!this.bRx) {
            break label161;
          }
        }
      }
      label156:
      label161:
      for (String str = "enable";; str = "disable")
      {
        str = str;
        o.s("filter_input_log_" + y.bUT, str);
        o.s("filter_output_log_" + y.bUT, str);
        AppMethodBeat.o(88028);
        return;
        paramBoolean = true;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.n
 * JD-Core Version:    0.7.0.1
 */