package com.d.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.List;

class n
  extends b
{
  private final n.e aXR = new n.e(this, (byte)0);
  final j aXS = new j();
  private final d aXT = new d((byte)0);
  private final i aXU;
  final s aXV;
  private long aXW;
  private long aXX;
  private long aXY;
  private int aXZ;
  private long aYa;
  private boolean aYb;
  private Location aYc;
  private int aYd;
  private float aYe;
  private float aYf;
  private float aYg;
  private int aYh;
  private int aYi;
  private long aYj;
  
  n()
  {
    if (i.aWq == null) {
      i.aWq = new i();
    }
    this.aXU = i.aWq;
    this.aYb = true;
    this.aXV = new s(this);
  }
  
  private boolean a(long paramLong, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, int paramInt2, float paramFloat2)
  {
    paramLong /= 1000L;
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble2);
    if (this.aYb)
    {
      this.aXS.a(paramLong, paramDouble1, paramDouble2, paramFloat1, this.aXR.aYu, y.bbR);
      this.aYb = false;
    }
    for (boolean bool = true;; bool = false)
    {
      j.a locala = new j.a(paramInt1, paramLong, paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramInt2, paramFloat2, 0, 0.0D, 0.0D);
      this.aXS.a(locala);
      if (y.bbL) {
        o.m("filter_input_log_" + y.bbS, locala.toString());
      }
      return bool;
    }
  }
  
  private void pg()
  {
    this.aXU.aWz = false;
    this.aXV.ps();
    this.aXT.reset();
    this.aXR.reset();
    pf();
    this.aXX = 0L;
    this.aXY = SystemClock.elapsedRealtime();
    this.aYe = 0.0F;
    this.aYf = 0.0F;
    this.aYg = 0.0F;
    this.aYh = 0;
    this.aYi = 0;
    this.aXZ = 0;
  }
  
  final k.a a(d.a parama)
  {
    return new k.a(0L);
  }
  
  final void a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, long paramLong1, long paramLong2)
  {
    if (paramInt2 <= 0) {
      return;
    }
    Object localObject = this.aXR;
    if (paramInt3 >= 3)
    {
      if (paramLong2 - ((n.e)localObject).aYt <= 5000L) {
        ((n.e)localObject).aH(true);
      }
      ((n.e)localObject).aYt = paramLong2;
    }
    int i = Math.round(paramFloat);
    if (!v.e(paramDouble1, paramDouble2)) {}
    for (localObject = "";; localObject = "&GD=" + paramDouble1 + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt3 + ',' + paramInt5 + ',' + paramInt2 + ',' + i + ',' + paramLong1 + ',')
    {
      this.aXT.c((String)localObject, paramLong2);
      if (a(paramLong2, 1, paramDouble1, paramDouble2, paramInt1, paramInt2, paramInt5, paramInt3)) {
        this.aXU.a(paramDouble1, paramDouble2, paramInt2, this.aYe, this.aYf, this.aYg);
      }
      if (d.j(paramLong2, this.aXY)) {
        this.aXV.a(paramDouble1, paramDouble2, paramInt2, paramFloat, this.aYe, this.aYf, this.aYg, paramLong2);
      }
      if (!y.bbL) {
        break;
      }
      o.m("gps_log_" + y.bbS, String.valueOf(paramDouble1) + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4 + ',' + paramInt5 + ',' + paramFloat + ',' + paramLong1);
      return;
    }
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong)
  {
    Object localObject1 = this.aXR;
    if (paramLong - ((n.e)localObject1).aYt > 5000L) {
      ((n.e)localObject1).aH(false);
    }
    if (paramLong - this.aXY > 5000L) {
      pg();
    }
    this.aYe = paramFloat1;
    this.aYf = paramFloat2;
    this.aYg = paramFloat4;
    this.aYh = paramInt;
    this.aXY = paramLong;
    boolean bool;
    if (paramFloat5 > 0.0F)
    {
      i = 1;
      this.aYi = i;
      if ((this.aXX != 0L) || (paramLong - this.aYj >= 30000L))
      {
        if (i != 0) {
          break label327;
        }
        bool = true;
        label119:
        if ((!bool) || (!this.aXR.aYu))
        {
          ab.pF().aG(bool);
          k.pe().aG(bool);
        }
      }
      localObject1 = new double[2];
      localObject2 = this.aXU;
      arrayOfDouble1 = new double[2];
      arrayOfDouble1[0] = paramFloat1;
      arrayOfDouble1[1] = paramFloat2;
      if (!((i)localObject2).aWz) {
        break label385;
      }
      localObject1[0] = ((i)localObject2).aWr;
      localObject1[1] = ((i)localObject2).aWs;
      localObject1[0] += 1.E-005D * (arrayOfDouble1[1] - ((i)localObject2).aWu) / ((i)localObject2).aWx;
      localObject1[1] += 1.E-005D * (arrayOfDouble1[0] - ((i)localObject2).aWt) / ((i)localObject2).aWy;
      if (localObject1[0] <= 90.0D) {
        break label333;
      }
      localObject1[0] = (180.0D - localObject1[0]);
      label289:
      if (localObject1[1] <= 180.0D) {
        break label359;
      }
      localObject1[1] -= 360.0D;
    }
    label312:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label391;
      }
      return;
      i = 0;
      break;
      label327:
      bool = false;
      break label119;
      label333:
      if (localObject1[0] >= -90.0D) {
        break label289;
      }
      localObject1[0] = (-180.0D - localObject1[0]);
      break label289;
      label359:
      if (localObject1[1] >= -180.0D) {
        break label312;
      }
      localObject1[1] += 360.0D;
      break label312;
    }
    label385:
    label391:
    double d1 = localObject1[0];
    double d2 = localObject1[1];
    localObject1 = this.aXU;
    paramFloat2 = (paramFloat4 - ((i)localObject1).aWv) / 10.0F;
    paramFloat4 = ((i)localObject1).aWw;
    paramFloat1 = 0.0F;
    localObject1 = new Location("S");
    ((Location)localObject1).setLatitude(d1);
    ((Location)localObject1).setLongitude(d2);
    if (this.aYc != null) {
      paramFloat1 = this.aYc.bearingTo((Location)localObject1);
    }
    this.aYc = ((Location)localObject1);
    i = Math.max(0, paramInt - this.aYd);
    this.aYd = paramInt;
    long l = paramLong / 1000L;
    d1 = Math.toRadians(d1);
    d2 = Math.toRadians(d2);
    double d3 = Math.toRadians(paramFloat1);
    localObject1 = new j.a(3, l, d1, d2, 0.0D, paramFloat2 + paramFloat4, 0, paramFloat5, i, paramFloat3, d3);
    this.aXS.a((j.a)localObject1);
    if (y.bbL) {
      o.m("filter_input_log_" + y.bbS, ((j.a)localObject1).toString());
    }
    localObject1 = new double[4];
    l = paramLong / 1000L;
    Object localObject2 = new double[2];
    double[] arrayOfDouble1 = new double[2];
    double[] arrayOfDouble2 = new double[2];
    double[][] arrayOfDouble3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    double[][] arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    j localj = this.aXS;
    d1 = l - localj.aWB.aWD;
    d2 = d1 * d1;
    double[] arrayOfDouble5 = new double[2];
    localObject2[0] = (localj.aWB.aXm[0] + localj.aWB.aXm[2] * d1);
    d3 = localj.aWB.aXm[1];
    localObject2[1] = (d1 * localj.aWB.aXm[3] + d3);
    arrayOfDouble2[0] = localj.aWB.aXm[2];
    arrayOfDouble2[1] = localj.aWB.aXm[3];
    int j;
    if (localj.aWB.aWU)
    {
      localObject2[0] -= localj.aWB.aWV[0];
      localObject2[1] -= localj.aWB.aWV[1];
      d1 = Math.sqrt(arrayOfDouble5[0] * arrayOfDouble5[0] + arrayOfDouble5[1] * arrayOfDouble5[1]);
      d1 = d1 * d1 * localj.aWB.aXp;
      arrayOfDouble3[0][0] = (localj.aWB.aXn[0][0] + localj.aWB.aXn[2][2] * d2 + d1);
      arrayOfDouble3[0][1] = (localj.aWB.aXn[0][1] + localj.aWB.aXn[2][3] * d2);
      arrayOfDouble3[1][0] = (localj.aWB.aXn[1][0] + localj.aWB.aXn[3][2] * d2);
      arrayOfDouble5 = arrayOfDouble3[1];
      d3 = localj.aWB.aXn[1][1];
      arrayOfDouble5[1] = (d1 + (d2 * localj.aWB.aXn[3][3] + d3));
      arrayOfDouble4[0][0] = localj.aWB.aXn[2][2];
      arrayOfDouble4[0][1] = localj.aWB.aXn[2][3];
      arrayOfDouble4[1][0] = localj.aWB.aXn[3][2];
      arrayOfDouble4[1][1] = localj.aWB.aXn[3][3];
      localj.a(1, (double[])localObject2, arrayOfDouble1);
      localObject1[0] = Math.toDegrees(arrayOfDouble1[0]);
      localObject1[1] = Math.toDegrees(arrayOfDouble1[1]);
      localObject1[2] = Math.sqrt((arrayOfDouble3[0][0] + arrayOfDouble3[1][1]) / 2.0D);
      d1 = arrayOfDouble2[0];
      d2 = arrayOfDouble2[0];
      d3 = arrayOfDouble2[1];
      localObject1[3] = Math.sqrt(d1 * d2 + arrayOfDouble2[1] * d3);
      if (y.bbL) {
        o.m("filter_output_log_" + y.bbS, String.valueOf(l) + ',' + localObject1[0] + ',' + localObject1[1] + ',' + localObject1[2] + ',' + localObject1[3]);
      }
      d1 = localObject1[0];
      d2 = localObject1[1];
      paramInt = Double.valueOf(localObject1[2]).intValue();
      i = Double.valueOf(localObject1[3]).intValue();
      j = this.aXZ;
      if (v.e(d1, d2)) {
        break label1391;
      }
    }
    label1391:
    for (localObject1 = "";; localObject1 = "&SD=" + d1 + ',' + d2 + ',' + 0 + ',' + paramInt + ',' + j + ',' + 0 + ',' + i + ',' + 0 + ',' + 0 + ',' + 0)
    {
      this.aXT.d((String)localObject1, paramLong);
      c(new n.a(d1, d2, paramInt, this.aXZ, this.aYa));
      return;
      d1 = 0.0D;
      break;
    }
  }
  
  void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    c(new n.b(paramInt, paramString, (byte)0));
    if ((paramInt == -4) || (paramInt == -5)) {
      stop();
    }
  }
  
  /* Error */
  void a(android.os.Handler paramHandler, d.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: instanceof 10
    //   6: ifeq +44 -> 50
    //   9: aload_2
    //   10: checkcast 10	com/d/a/a/n$c
    //   13: astore_2
    //   14: aload_0
    //   15: aload_2
    //   16: getfield 417	com/d/a/a/n$c:aYo	J
    //   19: putfield 419	com/d/a/a/n:aXW	J
    //   22: aload_0
    //   23: invokespecial 250	com/d/a/a/n:pg	()V
    //   26: aload_0
    //   27: getfield 80	com/d/a/a/n:aXV	Lcom/d/a/a/s;
    //   30: aload_1
    //   31: putfield 423	com/d/a/a/s:aZh	Landroid/os/Handler;
    //   34: aload_0
    //   35: invokestatic 161	android/os/SystemClock:elapsedRealtime	()J
    //   38: putfield 252	com/d/a/a/n:aYj	J
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: invokespecial 425	com/d/a/a/b:a	(Landroid/os/Handler;Lcom/d/a/a/d$a;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_2
    //   51: ifnull +23 -> 74
    //   54: aload_2
    //   55: getfield 430	com/d/a/a/d$a:aVM	J
    //   58: lstore_3
    //   59: new 10	com/d/a/a/n$c
    //   62: dup
    //   63: lload_3
    //   64: ldc2_w 431
    //   67: invokespecial 435	com/d/a/a/n$c:<init>	(JJ)V
    //   70: astore_2
    //   71: goto -57 -> 14
    //   74: ldc2_w 186
    //   77: lstore_3
    //   78: goto -19 -> 59
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	n
    //   0	86	1	paramHandler	android.os.Handler
    //   0	86	2	parama	d.a
    //   58	20	3	l	long
    // Exception table:
    //   from	to	target	type
    //   2	14	81	finally
    //   14	47	81	finally
    //   54	59	81	finally
    //   59	71	81	finally
  }
  
  void a(x paramx, long paramLong1, long paramLong2)
  {
    this.aXX = paramx.aYW;
    this.aXZ = paramx.level;
    this.aYa = paramx.aYm;
    if ((paramx.bbx.equals("W")) && (a(paramLong2, 2, paramx.latitude, paramx.longitude, paramx.altitude, paramx.aXH, paramx.bbC, paramx.auT))) {
      this.aXU.a(paramx.latitude, paramx.longitude, paramx.aXH, this.aYe, this.aYf, this.aYg);
    }
    if (!u.pz().aZU) {
      c(new n.a(paramx.latitude, paramx.longitude, Float.valueOf(paramx.aXH).intValue(), this.aXZ, this.aYa));
    }
  }
  
  final void a(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    paramLong1 = aa.ad(paramLong1);
    boolean bool;
    Object localObject1;
    Object localObject2;
    r localr;
    int i;
    long l1;
    if ((this.aXX != 0L) && (paramLong2 - this.aXX < this.aXW))
    {
      bool = false;
      localObject1 = v.a(paramList, bool);
      localObject2 = this.aXT.c((String)localObject1, paramLong2, bool);
      if (!bool) {
        break label308;
      }
      localr = r.pi();
      i = this.aYi;
      if (localObject2 != null)
      {
        if (!localr.isRunning) {
          break label266;
        }
        if (!localr.pk()) {
          break label261;
        }
        l1 = System.currentTimeMillis();
        long l2 = SystemClock.elapsedRealtime();
        if (localr.aYI != null) {
          localr.aYI.execute(new r.e(localr, (String)localObject2, l1, l2, i, (byte)0));
        }
      }
      label136:
      if (d.j(paramLong2, this.aXY)) {
        if (bool) {
          break label326;
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
      localObject1 = this.aXV;
      float f1 = this.aYe;
      float f2 = this.aYf;
      float f3 = this.aYg;
      float f4 = this.aYh;
      i = this.aXZ;
      if (((s)localObject1).aZc != 0.0F) {
        z.b(null).execute(new s.a((s)localObject1, f1, f2, f3, f4, i, paramList, (byte)0));
      }
      return;
      bool = true;
      break;
      label261:
      localr.pj();
      label266:
      l1 = aa.ad(System.currentTimeMillis());
      if (localr.aYI == null) {
        break label136;
      }
      localr.aYI.execute(new r.c(localr, (String)localObject2, l1, 0, (byte)0));
      break label136;
      label308:
      r.pi().aO(v.a((String)localObject2, paramLong1, "0"));
      break label136;
      label326:
      localObject1 = null;
    }
  }
  
  final void pf()
  {
    this.aYb = true;
    this.aYc = null;
    this.aYd = 0;
  }
  
  final void stop()
  {
    try
    {
      this.aXV.pq();
      super.stop();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static final class d
  {
    private String aYp;
    private long aYq;
    private String aYr;
    private long aYs;
    
    static boolean j(long paramLong1, long paramLong2)
    {
      return Math.abs(paramLong1 - paramLong2) <= 10000L;
    }
    
    final String c(String paramString, long paramLong, boolean paramBoolean)
    {
      String str;
      if (paramBoolean) {
        str = paramString;
      }
      for (;;)
      {
        try
        {
          if (this.aYp != null)
          {
            str = paramString;
            if (j(paramLong, this.aYq))
            {
              str = paramString + this.aYp;
              this.aYp = null;
            }
          }
          paramString = str;
          if (this.aYr != null)
          {
            paramString = str;
            if (j(paramLong, this.aYs))
            {
              paramString = str + this.aYr;
              this.aYr = null;
            }
          }
          return paramString;
        }
        finally {}
        str = paramString;
        if (this.aYp != null)
        {
          str = paramString;
          if (j(paramLong, this.aYq))
          {
            str = paramString + v.aT(this.aYp);
            this.aYp = null;
          }
        }
        paramString = str;
        if (this.aYr != null)
        {
          paramString = str;
          if (j(paramLong, this.aYs))
          {
            paramString = str + v.aS(this.aYr);
            this.aYr = null;
          }
        }
      }
    }
    
    final void c(String paramString, long paramLong)
    {
      try
      {
        this.aYp = paramString;
        this.aYq = paramLong;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    final void d(String paramString, long paramLong)
    {
      try
      {
        this.aYr = paramString;
        this.aYs = paramLong;
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
        this.aYp = null;
        this.aYr = null;
        this.aYq = 0L;
        this.aYs = 0L;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.n
 * JD-Core Version:    0.7.0.1
 */