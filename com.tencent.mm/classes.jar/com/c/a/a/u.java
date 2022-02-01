package com.c.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class u
  extends d
  implements SensorEventListener
{
  private static final int bSB;
  private static final int bSC;
  private static u bSV;
  private Sensor bSD;
  private Sensor bSE;
  private Sensor bSF;
  private Sensor bSG;
  private Sensor bSH;
  private long bSI;
  private boolean bSJ;
  private float[][] bSK;
  private float[][] bSL;
  private float[][] bSM;
  private float[][] bSN;
  private float[][] bSO;
  private float[][] bSP;
  private float[][] bSQ;
  private float[] bSR;
  private float[][] bSS;
  private float[][] bST;
  private float[][] bSU;
  boolean bSW;
  private c bSX;
  private boolean[] bSY;
  private int[] bSZ;
  private float[] bTa;
  private float[] bTb;
  private float[] bTc;
  private float[][] bTd;
  private final d bTe;
  private final f bTf;
  private final a bTg;
  private SensorManager mSensorManager;
  
  static
  {
    AppMethodBeat.i(87986);
    int i = Math.round(50000.0F);
    bSB = i;
    bSC = i;
    AppMethodBeat.o(87986);
  }
  
  private u()
  {
    AppMethodBeat.i(87988);
    this.mSensorManager = null;
    this.bSH = null;
    this.bSI = 0L;
    this.bSJ = true;
    this.bSK = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
    this.bSL = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
    this.bSM = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
    this.bSN = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bSO = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bSP = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bSQ = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bSR = new float[4];
    this.bSS = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bST = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bSU = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bSY = new boolean[6];
    this.bSZ = new int[6];
    this.bTa = new float[6];
    this.bTb = new float[6];
    this.bTc = new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
    this.bTd = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 }));
    this.bTg = new a((byte)0);
    this.bTe = new d((byte)0);
    this.bTf = new f((byte)0);
    AppMethodBeat.o(87988);
  }
  
  private static void a(float[] paramArrayOfFloat, float[][] paramArrayOfFloat1)
  {
    AppMethodBeat.i(87994);
    paramArrayOfFloat1[0][0] = (-paramArrayOfFloat[1]);
    paramArrayOfFloat1[0][1] = paramArrayOfFloat[0];
    paramArrayOfFloat1[0][2] = paramArrayOfFloat[2];
    paramArrayOfFloat1[1][0] = paramArrayOfFloat[1];
    paramArrayOfFloat1[1][1] = (-paramArrayOfFloat[0]);
    paramArrayOfFloat1[1][2] = paramArrayOfFloat[2];
    System.arraycopy(paramArrayOfFloat, 0, paramArrayOfFloat1[2], 0, 3);
    paramArrayOfFloat1[3][0] = (-paramArrayOfFloat[0]);
    paramArrayOfFloat1[3][1] = (-paramArrayOfFloat[1]);
    paramArrayOfFloat1[3][2] = paramArrayOfFloat[2];
    paramArrayOfFloat1[4][0] = paramArrayOfFloat[0];
    paramArrayOfFloat1[4][1] = paramArrayOfFloat[2];
    paramArrayOfFloat1[4][2] = (-paramArrayOfFloat[1]);
    paramArrayOfFloat1[5][0] = paramArrayOfFloat[0];
    paramArrayOfFloat1[5][1] = (-paramArrayOfFloat[2]);
    paramArrayOfFloat1[5][2] = paramArrayOfFloat[1];
    AppMethodBeat.o(87994);
  }
  
  private static void a(float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    AppMethodBeat.i(87989);
    int i = 0;
    for (;;)
    {
      if (i > 5)
      {
        AppMethodBeat.o(87989);
        return;
      }
      SensorManager.getOrientation(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
      i += 1;
    }
  }
  
  @TargetApi(19)
  private static boolean a(SensorManager paramSensorManager, SensorEventListener paramSensorEventListener, int paramInt1, int paramInt2, Handler paramHandler, Sensor... paramVarArgs)
  {
    AppMethodBeat.i(87993);
    try
    {
      int i;
      int k;
      int j;
      if (Build.VERSION.SDK_INT >= 19)
      {
        i = 1;
        k = paramVarArgs.length;
        j = 0;
      }
      for (;;)
      {
        if (j >= k)
        {
          AppMethodBeat.o(87993);
          return true;
          i = 0;
          break;
        }
        Sensor localSensor = paramVarArgs[j];
        if (i != 0) {}
        for (boolean bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramInt2, paramHandler); !bool; bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramHandler))
        {
          paramSensorManager.unregisterListener(paramSensorEventListener);
          AppMethodBeat.o(87993);
          return false;
        }
        j += 1;
      }
      return false;
    }
    catch (Error paramSensorManager)
    {
      AppMethodBeat.o(87993);
      return false;
    }
    catch (Exception paramSensorManager)
    {
      AppMethodBeat.o(87993);
    }
  }
  
  private static float[] b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return new float[] { paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[3] + paramArrayOfFloat1[2] * paramArrayOfFloat2[6], paramArrayOfFloat1[0] * paramArrayOfFloat2[1] + paramArrayOfFloat1[1] * paramArrayOfFloat2[4] + paramArrayOfFloat1[2] * paramArrayOfFloat2[7], paramArrayOfFloat1[0] * paramArrayOfFloat2[2] + paramArrayOfFloat1[1] * paramArrayOfFloat2[5] + paramArrayOfFloat1[2] * paramArrayOfFloat2[8], paramArrayOfFloat1[3] * paramArrayOfFloat2[0] + paramArrayOfFloat1[4] * paramArrayOfFloat2[3] + paramArrayOfFloat1[5] * paramArrayOfFloat2[6], paramArrayOfFloat1[3] * paramArrayOfFloat2[1] + paramArrayOfFloat1[4] * paramArrayOfFloat2[4] + paramArrayOfFloat1[5] * paramArrayOfFloat2[7], paramArrayOfFloat1[3] * paramArrayOfFloat2[2] + paramArrayOfFloat1[4] * paramArrayOfFloat2[5] + paramArrayOfFloat1[5] * paramArrayOfFloat2[8], paramArrayOfFloat1[6] * paramArrayOfFloat2[0] + paramArrayOfFloat1[7] * paramArrayOfFloat2[3] + paramArrayOfFloat1[8] * paramArrayOfFloat2[6], paramArrayOfFloat1[6] * paramArrayOfFloat2[1] + paramArrayOfFloat1[7] * paramArrayOfFloat2[4] + paramArrayOfFloat1[8] * paramArrayOfFloat2[7], paramArrayOfFloat1[6] * paramArrayOfFloat2[2] + paramArrayOfFloat1[7] * paramArrayOfFloat2[5] + paramArrayOfFloat1[8] * paramArrayOfFloat2[8] };
  }
  
  static u zt()
  {
    AppMethodBeat.i(87987);
    if (bSV == null) {
      bSV = new u();
    }
    u localu = bSV;
    AppMethodBeat.o(87987);
    return localu;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87990);
    if (paramContext == null) {
      try
      {
        paramContext = new Exception("SensorModule: register with null context");
        AppMethodBeat.o(87990);
        throw paramContext;
      }
      catch (Exception paramContext)
      {
        this.bSW = false;
      }
    }
    label419:
    label423:
    for (;;)
    {
      AppMethodBeat.o(87990);
      return;
      int i = 0;
      boolean bool;
      if (i > 5)
      {
        this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
        this.bSD = this.mSensorManager.getDefaultSensor(10);
        this.bSG = this.mSensorManager.getDefaultSensor(9);
        if ((this.bSD == null) || (this.bSG == null)) {
          break label419;
        }
        this.bSH = this.mSensorManager.getDefaultSensor(11);
        if (this.bSH == null) {
          break label329;
        }
        bool = a(this.mSensorManager, this, bSB, bSC, paramHandler, new Sensor[] { this.bSD, this.bSG, this.bSH });
      }
      for (;;)
      {
        if (!bool) {
          break label423;
        }
        this.bSW = true;
        this.bSX = new c(paramHandler);
        if (this.bSX != null) {
          this.bSX.q(Math.round(50.0F), 1000L);
        }
        AppMethodBeat.o(87990);
        return;
        this.bSL[i][0] = 1065353216;
        this.bSL[i][1] = 0;
        this.bSL[i][2] = 0;
        this.bSL[i][3] = 0;
        this.bSL[i][4] = 1065353216;
        this.bSL[i][5] = 0;
        this.bSL[i][6] = 0;
        this.bSL[i][7] = 0;
        this.bSL[i][8] = 1065353216;
        i += 1;
        break;
        label329:
        this.bSE = this.mSensorManager.getDefaultSensor(4);
        this.bSF = this.mSensorManager.getDefaultSensor(2);
        if ((this.bSE != null) && (this.bSF != null)) {
          bool = a(this.mSensorManager, this, bSB, bSC, paramHandler, new Sensor[] { this.bSD, this.bSG, this.bSE, this.bSF });
        } else {
          bool = false;
        }
      }
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    try
    {
      AppMethodBeat.i(87992);
      super.a(paramHandler, parama);
      AppMethodBeat.o(87992);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  final void ar(Context paramContext) {}
  
  final void as(Context paramContext)
  {
    AppMethodBeat.i(87991);
    if (this.bSX != null) {
      this.bSX.stop();
    }
    if (this.mSensorManager != null) {}
    try
    {
      this.mSensorManager.unregisterListener(this);
      label35:
      this.mSensorManager = null;
      this.bSH = null;
      this.bSG = null;
      this.bSF = null;
      this.bSE = null;
      this.bSD = null;
      this.bSI = 0L;
      this.bSJ = true;
      this.bSK = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.bSL = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.bSN = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.bSO = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.bSP = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.bSY = new boolean[6];
      this.bSZ = new int[6];
      this.bTa = new float[6];
      this.bTb = new float[6];
      this.bTc = new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
      this.bTd = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 }));
      this.bTg.reset();
      this.bTe.reset();
      this.bTf.reset();
      AppMethodBeat.o(87991);
      return;
    }
    catch (Error paramContext)
    {
      break label35;
    }
    catch (Exception paramContext)
    {
      break label35;
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(87995);
    switch (paramSensorEvent.sensor.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(87995);
      return;
      Object localObject3 = new float[16];
      if (this.bSH != null) {}
      float[] arrayOfFloat1;
      for (Object localObject1 = this.bSM;; localObject1 = this.bSL)
      {
        localObject1 = localObject1[2];
        arrayOfFloat1 = new float[16];
        if (localObject1.length == 9)
        {
          arrayOfFloat1[0] = localObject1[0];
          arrayOfFloat1[1] = localObject1[1];
          arrayOfFloat1[2] = localObject1[2];
          arrayOfFloat1[3] = 0.0F;
          arrayOfFloat1[4] = localObject1[3];
          arrayOfFloat1[5] = localObject1[4];
          arrayOfFloat1[6] = localObject1[5];
          arrayOfFloat1[7] = 0.0F;
          arrayOfFloat1[8] = localObject1[6];
          arrayOfFloat1[9] = localObject1[7];
          arrayOfFloat1[10] = localObject1[8];
          arrayOfFloat1[11] = 0.0F;
          arrayOfFloat1[12] = 0.0F;
          arrayOfFloat1[13] = 0.0F;
          arrayOfFloat1[14] = 0.0F;
          arrayOfFloat1[15] = 1.0F;
        }
        Matrix.invertM((float[])localObject3, 0, arrayOfFloat1, 0);
        Matrix.multiplyMV(this.bSR, 0, (float[])localObject3, 0, new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], 0.0F }, 0);
        this.bTe.a(this.bSR, paramSensorEvent.values, this.bSU[2]);
        AppMethodBeat.o(87995);
        return;
      }
      a(paramSensorEvent.values, this.bSU);
      if ((this.bST[2][0] == 0.0F) && (this.bST[2][1] == 0.0F) && (this.bST[2][2] == 0.0F)) {
        continue;
      }
      paramSensorEvent = this.bSK;
      localObject1 = this.bSU;
      localObject3 = this.bST;
      if ((SensorManager.getRotationMatrix(paramSensorEvent[0], null, localObject1[0], localObject3[0])) && (SensorManager.getRotationMatrix(paramSensorEvent[1], null, localObject1[1], localObject3[1])) && (SensorManager.getRotationMatrix(paramSensorEvent[2], null, localObject1[2], localObject3[2])) && (SensorManager.getRotationMatrix(paramSensorEvent[3], null, localObject1[3], localObject3[3])) && (SensorManager.getRotationMatrix(paramSensorEvent[4], null, localObject1[4], localObject3[4])) && (SensorManager.getRotationMatrix(paramSensorEvent[5], null, localObject1[5], localObject3[5])))
      {
        i = 1;
        if (i != 0)
        {
          a(this.bSK, this.bSN);
          if ((this.bSO[2][0] == 0.0F) && (this.bSO[2][1] == 0.0F) && (this.bSO[2][2] == 0.0F))
          {
            paramSensorEvent = this.bSN;
            localObject1 = this.bSO;
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i > 5)
        {
          AppMethodBeat.o(87995);
          return;
          i = 0;
          break;
        }
        System.arraycopy(paramSensorEvent[i], 0, localObject1[i], 0, 3);
        i += 1;
      }
      try
      {
        SensorManager.getRotationMatrixFromVector(this.bSM[2], paramSensorEvent.values);
        SensorManager.remapCoordinateSystem(this.bSM[2], 2, 129, this.bSM[0]);
        SensorManager.remapCoordinateSystem(this.bSM[2], 130, 1, this.bSM[1]);
        SensorManager.remapCoordinateSystem(this.bSM[2], 129, 130, this.bSM[3]);
        SensorManager.remapCoordinateSystem(this.bSM[2], 129, 3, this.bSM[4]);
        SensorManager.remapCoordinateSystem(this.bSM[2], 1, 3, this.bSM[5]);
        if (i > 5)
        {
          AppMethodBeat.o(87995);
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (paramSensorEvent.values.length > 3)
          {
            SensorManager.getRotationMatrixFromVector(this.bSM[2], new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2] });
            continue;
            SensorManager.getOrientation(this.bSM[i], this.bSQ[i]);
            i += 1;
          }
        }
      }
      Object localObject2;
      float f1;
      if ((this.bSN[2][0] != 0.0F) || (this.bSN[2][1] != 0.0F) || (this.bSN[2][2] != 0.0F))
      {
        if (this.bSJ)
        {
          i = 0;
          if (i <= 5) {
            break label987;
          }
          this.bSJ = false;
        }
        localObject2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 4 });
        if (this.bSI != 0L)
        {
          f1 = (float)(paramSensorEvent.timestamp - this.bSI);
          a(paramSensorEvent.values, this.bSS);
          i = 0;
        }
      }
      label963:
      label987:
      float f2;
      float f3;
      for (;;)
      {
        if (i > 5)
        {
          this.bSI = paramSensorEvent.timestamp;
          i = j;
          if (i <= 5) {
            break label1208;
          }
          a(this.bSL, this.bSO);
          AppMethodBeat.o(87995);
          return;
          localObject2 = this.bSK[i];
          localObject3 = this.bSL;
          localObject3[i] = b(localObject3[i], (float[])localObject2);
          i += 1;
          break;
        }
        localObject3 = this.bSS[i];
        arrayOfFloat1 = localObject2[i];
        f2 = 1.0E-009F * f1 / 2.0F;
        float[] arrayOfFloat2 = new float[3];
        f3 = (float)Math.sqrt(localObject3[0] * localObject3[0] + localObject3[1] * localObject3[1] + localObject3[2] * localObject3[2]);
        if (f3 > 1.0E-009F)
        {
          localObject3[0] /= f3;
          localObject3[1] /= f3;
          localObject3[2] /= f3;
        }
        f3 *= f2;
        f2 = (float)Math.sin(f3);
        f3 = (float)Math.cos(f3);
        arrayOfFloat2[0] *= f2;
        arrayOfFloat2[1] *= f2;
        arrayOfFloat1[2] = (f2 * arrayOfFloat2[2]);
        arrayOfFloat1[3] = f3;
        i += 1;
      }
      label1208:
      paramSensorEvent = new float[9];
      try
      {
        SensorManager.getRotationMatrixFromVector(paramSensorEvent, localObject2[i]);
        label1222:
        localObject3 = this.bSL;
        localObject3[i] = b(localObject3[i], paramSensorEvent);
        i += 1;
        break label963;
        a(paramSensorEvent.values, this.bST);
        localObject2 = this.bTg;
        paramSensorEvent = paramSensorEvent.values;
        if (paramSensorEvent.length < 3) {
          continue;
        }
        ((a)localObject2).bTh += 1;
        double d = ((a)localObject2).bTi;
        f1 = paramSensorEvent[0];
        f2 = paramSensorEvent[0];
        f3 = paramSensorEvent[1];
        float f4 = paramSensorEvent[1];
        float f5 = paramSensorEvent[2];
        ((a)localObject2).bTi = ((float)(Math.sqrt(f2 * f1 + f4 * f3 + paramSensorEvent[2] * f5) + d));
      }
      catch (Exception localException)
      {
        break label1222;
      }
    }
  }
  
  final void yR() {}
  
  static final class a
  {
    int bTh;
    float bTi;
    long bTj;
    float bTk;
    boolean bTl;
    long bTm;
    float[] bTn;
    float[] bTo;
    float[] bTp;
    float[] bTq;
    float[] bTr;
    float[] bTs;
    float[] bTt;
    float[] bTu;
    float[] bTv;
    float bTw;
    float bTx;
    float bTy;
    boolean bTz;
    
    private a()
    {
      AppMethodBeat.i(87973);
      this.bTh = 0;
      this.bTi = 0.0F;
      this.bTj = 0L;
      this.bTk = 0.0F;
      this.bTl = false;
      this.bTm = 0L;
      this.bTn = new float[6];
      this.bTo = new float[6];
      this.bTp = new float[6];
      this.bTq = new float[6];
      this.bTr = new float[6];
      this.bTs = new float[6];
      this.bTt = new float[6];
      this.bTu = new float[6];
      this.bTv = new float[6];
      this.bTw = 0.0F;
      this.bTx = (1.0F / -1.0F);
      this.bTy = (1.0F / 1.0F);
      this.bTz = false;
      AppMethodBeat.o(87973);
    }
    
    final void reset()
    {
      this.bTh = 0;
      this.bTi = 0.0F;
      this.bTj = 0L;
      this.bTk = 0.0F;
      this.bTl = false;
      this.bTm = 0L;
      this.bTn = new float[6];
      this.bTo = new float[6];
      this.bTp = new float[6];
      this.bTw = 0.0F;
      this.bTx = (1.0F / -1.0F);
      this.bTy = (1.0F / 1.0F);
    }
  }
  
  static final class b
  {
    float bTA;
    float bTB;
    float bTC;
    float bTD;
    float bTE;
    float bTF;
    float bTG;
    float bTH;
    float bTI;
    float bTJ;
    float bTK;
    float[] bTL;
    float[] bTM;
    float[] bTN;
    float[] bTO;
    float[] bTP;
    long time;
    
    private b()
    {
      AppMethodBeat.i(87974);
      this.bTL = new float[6];
      this.bTM = new float[6];
      this.bTN = new float[6];
      this.bTO = new float[6];
      this.bTP = new float[6];
      AppMethodBeat.o(87974);
    }
  }
  
  final class c
    extends e
  {
    c(Handler paramHandler)
    {
      super();
    }
    
    final void yV()
    {
      AppMethodBeat.i(87975);
      u.a(u.this);
      AppMethodBeat.o(87975);
    }
  }
  
  static final class d
  {
    private float bTR = 0.0F;
    private float bTS = 0.0F;
    private float bTT = 0.0F;
    private float bTU = 0.0F;
    private float bTV = 0.0F;
    private float bTW = 0.0F;
    private float bTX = 0.0F;
    private float bTY = 0.0F;
    private float bTZ = 0.0F;
    private int count = 0;
    
    final u.b a(float[][] paramArrayOfFloat)
    {
      int i = 0;
      for (;;)
      {
        u.b localb;
        try
        {
          AppMethodBeat.i(87976);
          if ((this.count <= 0) || (paramArrayOfFloat.length < 3))
          {
            paramArrayOfFloat = null;
            AppMethodBeat.o(87976);
            return paramArrayOfFloat;
          }
          localb = new u.b((byte)0);
          localb.time = SystemClock.elapsedRealtime();
          if (i > 5)
          {
            localb.bTA = (this.bTR / this.count);
            localb.bTB = (this.bTS / this.count);
            localb.bTC = (this.bTT / this.count);
            localb.bTD = (this.bTU / this.count);
            localb.bTE = (this.bTV / this.count);
            localb.bTF = (this.bTW / this.count);
            localb.bTG = (this.bTX / this.count);
            localb.bTH = (this.bTY / this.count);
            localb.bTI = (this.bTZ / this.count);
            localb.bTK = ((float)Math.sqrt(localb.bTA * localb.bTA + localb.bTB * localb.bTB));
            reset();
            AppMethodBeat.o(87976);
            paramArrayOfFloat = localb;
            continue;
          }
          localb.bTL[i] = paramArrayOfFloat[i][0];
        }
        finally {}
        localb.bTM[i] = paramArrayOfFloat[i][1];
        localb.bTN[i] = paramArrayOfFloat[i][2];
        localb.bTO[i] = ((float)Math.sin(localb.bTL[i]));
        localb.bTP[i] = ((float)Math.cos(localb.bTL[i]));
        i += 1;
      }
    }
    
    final void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
    {
      try
      {
        if (paramArrayOfFloat1.length >= 3)
        {
          this.count += 1;
          this.bTR += paramArrayOfFloat1[0];
          this.bTS += paramArrayOfFloat1[1];
          this.bTT += paramArrayOfFloat1[2];
          this.bTU += paramArrayOfFloat2[0];
          this.bTV += paramArrayOfFloat2[1];
          this.bTW += paramArrayOfFloat2[2];
          this.bTX += paramArrayOfFloat3[0];
          this.bTY += paramArrayOfFloat3[1];
          this.bTZ += paramArrayOfFloat3[2];
        }
        return;
      }
      finally
      {
        paramArrayOfFloat1 = finally;
        throw paramArrayOfFloat1;
      }
    }
    
    final void reset()
    {
      try
      {
        this.count = 0;
        this.bTR = 0.0F;
        this.bTS = 0.0F;
        this.bTT = 0.0F;
        this.bTU = 0.0F;
        this.bTV = 0.0F;
        this.bTW = 0.0F;
        this.bTX = 0.0F;
        this.bTY = 0.0F;
        this.bTZ = 0.0F;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  static final class e
    extends p
  {
    final float aSD;
    final float bUa;
    final float bUb;
    final int bUc;
    final float x;
    final float y;
    
    private e(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5)
    {
      super();
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.bUc = paramInt;
      this.bUa = paramFloat3;
      this.bUb = paramFloat4;
      this.aSD = paramFloat5;
    }
  }
  
  final class f
  {
    private ArrayList<u.b> bUd;
    private a[] bUe;
    private int bUf;
    private float[][] bUg;
    private float[][] bUh;
    private float[][] bUi;
    private int[] bUj;
    private int bUk;
    private int bUl;
    private int bUm;
    
    private f()
    {
      AppMethodBeat.i(87979);
      this.bUd = new ArrayList();
      this.bUe = new a[5];
      this.bUf = 0;
      this.bUg = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
      this.bUh = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
      this.bUi = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
      this.bUj = new int[6];
      this.bUk = 5;
      this.bUl = -1;
      this.bUm = 0;
      AppMethodBeat.o(87979);
    }
    
    /* Error */
    private void a(a parama)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 91
      //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 49	com/c/a/a/u$f:bUe	[Lcom/c/a/a/u$f$a;
      //   11: iconst_1
      //   12: aload_0
      //   13: getfield 49	com/c/a/a/u$f:bUe	[Lcom/c/a/a/u$f$a;
      //   16: iconst_0
      //   17: iconst_4
      //   18: invokestatic 97	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   21: aload_0
      //   22: getfield 49	com/c/a/a/u$f:bUe	[Lcom/c/a/a/u$f$a;
      //   25: iconst_4
      //   26: aaload
      //   27: ifnull +143 -> 170
      //   30: invokestatic 103	android/os/SystemClock:elapsedRealtime	()J
      //   33: aload_1
      //   34: getfield 107	com/c/a/a/u$f$a:bUr	J
      //   37: lsub
      //   38: ldc2_w 108
      //   41: lcmp
      //   42: ifle +128 -> 170
      //   45: aload_0
      //   46: getfield 49	com/c/a/a/u$f:bUe	[Lcom/c/a/a/u$f$a;
      //   49: iconst_4
      //   50: aaload
      //   51: astore_2
      //   52: aload_2
      //   53: aload_2
      //   54: getfield 113	com/c/a/a/u$f$a:x	F
      //   57: aload_1
      //   58: getfield 113	com/c/a/a/u$f$a:x	F
      //   61: fadd
      //   62: fconst_2
      //   63: fdiv
      //   64: putfield 113	com/c/a/a/u$f$a:x	F
      //   67: aload_2
      //   68: aload_2
      //   69: getfield 116	com/c/a/a/u$f$a:y	F
      //   72: aload_1
      //   73: getfield 116	com/c/a/a/u$f$a:y	F
      //   76: fadd
      //   77: fconst_2
      //   78: fdiv
      //   79: putfield 116	com/c/a/a/u$f$a:y	F
      //   82: aload_2
      //   83: aload_2
      //   84: getfield 119	com/c/a/a/u$f$a:z	F
      //   87: aload_1
      //   88: getfield 119	com/c/a/a/u$f$a:z	F
      //   91: fadd
      //   92: fconst_2
      //   93: fdiv
      //   94: putfield 119	com/c/a/a/u$f$a:z	F
      //   97: aload_2
      //   98: aload_2
      //   99: getfield 122	com/c/a/a/u$f$a:bUn	I
      //   102: aload_1
      //   103: getfield 122	com/c/a/a/u$f$a:bUn	I
      //   106: iadd
      //   107: i2f
      //   108: fconst_2
      //   109: fdiv
      //   110: invokestatic 128	java/lang/Math:round	(F)I
      //   113: putfield 122	com/c/a/a/u$f$a:bUn	I
      //   116: aload_2
      //   117: aload_2
      //   118: getfield 131	com/c/a/a/u$f$a:bUo	F
      //   121: aload_1
      //   122: getfield 131	com/c/a/a/u$f$a:bUo	F
      //   125: fadd
      //   126: fconst_2
      //   127: fdiv
      //   128: putfield 131	com/c/a/a/u$f$a:bUo	F
      //   131: aload_2
      //   132: aload_2
      //   133: getfield 134	com/c/a/a/u$f$a:bUp	F
      //   136: aload_1
      //   137: getfield 134	com/c/a/a/u$f$a:bUp	F
      //   140: fadd
      //   141: fconst_2
      //   142: fdiv
      //   143: putfield 134	com/c/a/a/u$f$a:bUp	F
      //   146: aload_2
      //   147: aload_1
      //   148: getfield 107	com/c/a/a/u$f$a:bUr	J
      //   151: putfield 107	com/c/a/a/u$f$a:bUr	J
      //   154: aload_2
      //   155: aload_1
      //   156: getfield 137	com/c/a/a/u$f$a:bUq	F
      //   159: putfield 137	com/c/a/a/u$f$a:bUq	F
      //   162: ldc 91
      //   164: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   167: aload_0
      //   168: monitorexit
      //   169: return
      //   170: aload_0
      //   171: getfield 49	com/c/a/a/u$f:bUe	[Lcom/c/a/a/u$f$a;
      //   174: iconst_4
      //   175: aload_1
      //   176: aastore
      //   177: ldc 91
      //   179: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   182: goto -15 -> 167
      //   185: astore_1
      //   186: aload_0
      //   187: monitorexit
      //   188: aload_1
      //   189: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	190	0	this	f
      //   0	190	1	parama	a
      //   51	104	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	167	185	finally
      //   170	182	185	finally
    }
    
    /* Error */
    private boolean zu()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 140
      //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 51	com/c/a/a/u$f:bUf	I
      //   11: bipush 20
      //   13: if_icmplt +700 -> 713
      //   16: aload_0
      //   17: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   20: iconst_0
      //   21: aaload
      //   22: astore 17
      //   24: aload 17
      //   26: iconst_2
      //   27: aload 17
      //   29: iconst_2
      //   30: faload
      //   31: ldc 141
      //   33: fdiv
      //   34: fastore
      //   35: aload_0
      //   36: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   39: iconst_1
      //   40: aaload
      //   41: astore 17
      //   43: aload 17
      //   45: iconst_2
      //   46: aload 17
      //   48: iconst_2
      //   49: faload
      //   50: ldc 141
      //   52: fdiv
      //   53: fastore
      //   54: aload_0
      //   55: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   58: iconst_2
      //   59: aaload
      //   60: astore 17
      //   62: aload 17
      //   64: iconst_2
      //   65: aload 17
      //   67: iconst_2
      //   68: faload
      //   69: ldc 141
      //   71: fdiv
      //   72: fastore
      //   73: aload_0
      //   74: getfield 59	com/c/a/a/u$f:bUh	[[F
      //   77: iconst_0
      //   78: aaload
      //   79: astore 17
      //   81: aload 17
      //   83: iconst_2
      //   84: aload 17
      //   86: iconst_2
      //   87: faload
      //   88: ldc 141
      //   90: fdiv
      //   91: fastore
      //   92: aload_0
      //   93: getfield 59	com/c/a/a/u$f:bUh	[[F
      //   96: iconst_1
      //   97: aaload
      //   98: astore 17
      //   100: aload 17
      //   102: iconst_2
      //   103: aload 17
      //   105: iconst_2
      //   106: faload
      //   107: ldc 141
      //   109: fdiv
      //   110: fastore
      //   111: aload_0
      //   112: getfield 59	com/c/a/a/u$f:bUh	[[F
      //   115: iconst_2
      //   116: aaload
      //   117: astore 17
      //   119: aload 17
      //   121: iconst_2
      //   122: aload 17
      //   124: iconst_2
      //   125: faload
      //   126: ldc 141
      //   128: fdiv
      //   129: fastore
      //   130: aload_0
      //   131: getfield 59	com/c/a/a/u$f:bUh	[[F
      //   134: iconst_0
      //   135: aaload
      //   136: iconst_2
      //   137: faload
      //   138: fstore_1
      //   139: aload_0
      //   140: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   143: iconst_0
      //   144: aaload
      //   145: iconst_0
      //   146: faload
      //   147: fstore_2
      //   148: aload_0
      //   149: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   152: iconst_0
      //   153: aaload
      //   154: iconst_2
      //   155: faload
      //   156: fstore_3
      //   157: aload_0
      //   158: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   161: iconst_0
      //   162: aaload
      //   163: iconst_2
      //   164: faload
      //   165: fstore 4
      //   167: aload_0
      //   168: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   171: iconst_0
      //   172: aaload
      //   173: iconst_1
      //   174: faload
      //   175: fstore 5
      //   177: aload_0
      //   178: getfield 59	com/c/a/a/u$f:bUh	[[F
      //   181: iconst_1
      //   182: aaload
      //   183: iconst_2
      //   184: faload
      //   185: fstore 6
      //   187: aload_0
      //   188: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   191: iconst_1
      //   192: aaload
      //   193: iconst_0
      //   194: faload
      //   195: fstore 7
      //   197: aload_0
      //   198: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   201: iconst_1
      //   202: aaload
      //   203: iconst_2
      //   204: faload
      //   205: fstore 8
      //   207: aload_0
      //   208: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   211: iconst_1
      //   212: aaload
      //   213: iconst_2
      //   214: faload
      //   215: fstore 9
      //   217: aload_0
      //   218: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   221: iconst_1
      //   222: aaload
      //   223: iconst_1
      //   224: faload
      //   225: fstore 10
      //   227: aload_0
      //   228: getfield 59	com/c/a/a/u$f:bUh	[[F
      //   231: iconst_2
      //   232: aaload
      //   233: iconst_2
      //   234: faload
      //   235: fstore 11
      //   237: aload_0
      //   238: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   241: iconst_2
      //   242: aaload
      //   243: iconst_0
      //   244: faload
      //   245: fstore 12
      //   247: aload_0
      //   248: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   251: iconst_2
      //   252: aaload
      //   253: iconst_2
      //   254: faload
      //   255: fstore 13
      //   257: aload_0
      //   258: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   261: iconst_2
      //   262: aaload
      //   263: iconst_2
      //   264: faload
      //   265: fstore 14
      //   267: aload_0
      //   268: getfield 57	com/c/a/a/u$f:bUg	[[F
      //   271: iconst_2
      //   272: aaload
      //   273: iconst_1
      //   274: faload
      //   275: fstore 15
      //   277: aload_0
      //   278: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   281: iconst_0
      //   282: aaload
      //   283: iconst_0
      //   284: fload_1
      //   285: ldc 142
      //   287: fmul
      //   288: ldc 143
      //   290: aload_0
      //   291: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   294: iconst_0
      //   295: aaload
      //   296: iconst_0
      //   297: faload
      //   298: fmul
      //   299: fadd
      //   300: fastore
      //   301: aload_0
      //   302: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   305: iconst_0
      //   306: aaload
      //   307: iconst_1
      //   308: fload_2
      //   309: fload_3
      //   310: fsub
      //   311: ldc 142
      //   313: fmul
      //   314: ldc 143
      //   316: aload_0
      //   317: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   320: iconst_0
      //   321: aaload
      //   322: iconst_1
      //   323: faload
      //   324: fmul
      //   325: fadd
      //   326: fastore
      //   327: aload_0
      //   328: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   331: iconst_0
      //   332: aaload
      //   333: iconst_2
      //   334: fload 4
      //   336: fload 5
      //   338: fsub
      //   339: ldc 142
      //   341: fmul
      //   342: ldc 143
      //   344: aload_0
      //   345: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   348: iconst_0
      //   349: aaload
      //   350: iconst_2
      //   351: faload
      //   352: fmul
      //   353: fadd
      //   354: fastore
      //   355: aload_0
      //   356: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   359: iconst_1
      //   360: aaload
      //   361: iconst_0
      //   362: ldc 143
      //   364: aload_0
      //   365: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   368: iconst_1
      //   369: aaload
      //   370: iconst_0
      //   371: faload
      //   372: fmul
      //   373: fload 6
      //   375: ldc 142
      //   377: fmul
      //   378: fadd
      //   379: fastore
      //   380: aload_0
      //   381: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   384: iconst_1
      //   385: aaload
      //   386: iconst_1
      //   387: ldc 143
      //   389: aload_0
      //   390: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   393: iconst_1
      //   394: aaload
      //   395: iconst_1
      //   396: faload
      //   397: fmul
      //   398: ldc 142
      //   400: fload 7
      //   402: fload 8
      //   404: fsub
      //   405: fmul
      //   406: fadd
      //   407: fastore
      //   408: aload_0
      //   409: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   412: iconst_1
      //   413: aaload
      //   414: iconst_2
      //   415: ldc 143
      //   417: aload_0
      //   418: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   421: iconst_1
      //   422: aaload
      //   423: iconst_2
      //   424: faload
      //   425: fmul
      //   426: ldc 142
      //   428: fload 9
      //   430: fload 10
      //   432: fsub
      //   433: fmul
      //   434: fadd
      //   435: fastore
      //   436: aload_0
      //   437: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   440: iconst_2
      //   441: aaload
      //   442: iconst_0
      //   443: ldc 143
      //   445: aload_0
      //   446: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   449: iconst_2
      //   450: aaload
      //   451: iconst_0
      //   452: faload
      //   453: fmul
      //   454: ldc 142
      //   456: fload 11
      //   458: fmul
      //   459: fadd
      //   460: fastore
      //   461: aload_0
      //   462: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   465: iconst_2
      //   466: aaload
      //   467: iconst_1
      //   468: ldc 143
      //   470: aload_0
      //   471: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   474: iconst_2
      //   475: aaload
      //   476: iconst_1
      //   477: faload
      //   478: fmul
      //   479: ldc 142
      //   481: fload 12
      //   483: fload 13
      //   485: fsub
      //   486: fmul
      //   487: fadd
      //   488: fastore
      //   489: aload_0
      //   490: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   493: iconst_2
      //   494: aaload
      //   495: iconst_2
      //   496: ldc 143
      //   498: aload_0
      //   499: getfield 74	com/c/a/a/u$f:bUi	[[F
      //   502: iconst_2
      //   503: aaload
      //   504: iconst_2
      //   505: faload
      //   506: fmul
      //   507: ldc 142
      //   509: fload 14
      //   511: fload 15
      //   513: fsub
      //   514: fmul
      //   515: fadd
      //   516: fastore
      //   517: aload_0
      //   518: aload_0
      //   519: invokespecial 147	com/c/a/a/u$f:zv	()Lcom/c/a/a/u$f$a;
      //   522: invokespecial 149	com/c/a/a/u$f:a	(Lcom/c/a/a/u$f$a;)V
      //   525: aload_0
      //   526: iconst_0
      //   527: putfield 51	com/c/a/a/u$f:bUf	I
      //   530: aload_0
      //   531: iconst_3
      //   532: anewarray 53	[F
      //   535: dup
      //   536: iconst_0
      //   537: iconst_3
      //   538: newarray float
      //   540: dup
      //   541: iconst_0
      //   542: ldc 54
      //   544: fastore
      //   545: dup
      //   546: iconst_1
      //   547: ldc 55
      //   549: fastore
      //   550: dup
      //   551: iconst_2
      //   552: fconst_0
      //   553: fastore
      //   554: aastore
      //   555: dup
      //   556: iconst_1
      //   557: iconst_3
      //   558: newarray float
      //   560: dup
      //   561: iconst_0
      //   562: ldc 54
      //   564: fastore
      //   565: dup
      //   566: iconst_1
      //   567: ldc 55
      //   569: fastore
      //   570: dup
      //   571: iconst_2
      //   572: fconst_0
      //   573: fastore
      //   574: aastore
      //   575: dup
      //   576: iconst_2
      //   577: iconst_3
      //   578: newarray float
      //   580: dup
      //   581: iconst_0
      //   582: ldc 54
      //   584: fastore
      //   585: dup
      //   586: iconst_1
      //   587: ldc 55
      //   589: fastore
      //   590: dup
      //   591: iconst_2
      //   592: fconst_0
      //   593: fastore
      //   594: aastore
      //   595: putfield 57	com/c/a/a/u$f:bUg	[[F
      //   598: aload_0
      //   599: iconst_3
      //   600: anewarray 53	[F
      //   603: dup
      //   604: iconst_0
      //   605: iconst_3
      //   606: newarray float
      //   608: dup
      //   609: iconst_0
      //   610: ldc 54
      //   612: fastore
      //   613: dup
      //   614: iconst_1
      //   615: ldc 55
      //   617: fastore
      //   618: dup
      //   619: iconst_2
      //   620: fconst_0
      //   621: fastore
      //   622: aastore
      //   623: dup
      //   624: iconst_1
      //   625: iconst_3
      //   626: newarray float
      //   628: dup
      //   629: iconst_0
      //   630: ldc 54
      //   632: fastore
      //   633: dup
      //   634: iconst_1
      //   635: ldc 55
      //   637: fastore
      //   638: dup
      //   639: iconst_2
      //   640: fconst_0
      //   641: fastore
      //   642: aastore
      //   643: dup
      //   644: iconst_2
      //   645: iconst_3
      //   646: newarray float
      //   648: dup
      //   649: iconst_0
      //   650: ldc 54
      //   652: fastore
      //   653: dup
      //   654: iconst_1
      //   655: ldc 55
      //   657: fastore
      //   658: dup
      //   659: iconst_2
      //   660: fconst_0
      //   661: fastore
      //   662: aastore
      //   663: putfield 59	com/c/a/a/u$f:bUh	[[F
      //   666: aload_0
      //   667: getfield 47	com/c/a/a/u$f:bUd	Ljava/util/ArrayList;
      //   670: invokevirtual 153	java/util/ArrayList:size	()I
      //   673: bipush 100
      //   675: if_icmplt +25 -> 700
      //   678: aload_0
      //   679: getfield 47	com/c/a/a/u$f:bUd	Ljava/util/ArrayList;
      //   682: iconst_0
      //   683: bipush 20
      //   685: invokevirtual 157	java/util/ArrayList:subList	(II)Ljava/util/List;
      //   688: invokeinterface 162 1 0
      //   693: aload_0
      //   694: getfield 47	com/c/a/a/u$f:bUd	Ljava/util/ArrayList;
      //   697: invokevirtual 165	java/util/ArrayList:trimToSize	()V
      //   700: iconst_1
      //   701: istore 16
      //   703: ldc 140
      //   705: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   708: aload_0
      //   709: monitorexit
      //   710: iload 16
      //   712: ireturn
      //   713: iconst_0
      //   714: istore 16
      //   716: ldc 140
      //   718: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   721: goto -13 -> 708
      //   724: astore 17
      //   726: aload_0
      //   727: monitorexit
      //   728: aload 17
      //   730: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	731	0	this	f
      //   138	147	1	f1	float
      //   147	162	2	f2	float
      //   156	154	3	f3	float
      //   165	170	4	f4	float
      //   175	162	5	f5	float
      //   185	189	6	f6	float
      //   195	206	7	f7	float
      //   205	198	8	f8	float
      //   215	214	9	f9	float
      //   225	206	10	f10	float
      //   235	222	11	f11	float
      //   245	237	12	f12	float
      //   255	229	13	f13	float
      //   265	245	14	f14	float
      //   275	237	15	f15	float
      //   701	14	16	bool	boolean
      //   22	101	17	arrayOfFloat	float[]
      //   724	5	17	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	700	724	finally
      //   703	708	724	finally
      //   716	721	724	finally
    }
    
    private a zv()
    {
      int i2;
      int j;
      a locala;
      int k;
      Object localObject5;
      Object localObject7;
      float f1;
      float f2;
      float f6;
      float f4;
      float f10;
      label385:
      float f8;
      float f9;
      label407:
      label432:
      Object localObject1;
      label836:
      int n;
      label919:
      int m;
      label960:
      int i1;
      label1001:
      float f12;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(87982);
          if (this.bUm == 0)
          {
            i2 = 1;
            if (i2 == 0) {
              continue;
            }
            if (Math.abs(this.bUi[2][0]) < 9.300000000000001D)
            {
              i = 5;
              this.bUk = i;
              this.bUj = new int[6];
              j = 0;
              if ((this.bUl >= 0) && (this.bUl <= 5)) {
                this.bUk = this.bUl;
              }
              localObject3 = new a((byte)0);
              locala = new a((byte)0);
              if (this.bUe[0] != null)
              {
                ((a)localObject3).bUr = this.bUe[0].bUr;
                ((a)localObject3).bUo = this.bUe[0].bUo;
              }
              if (this.bUe[4] != null)
              {
                locala.bUr = this.bUe[4].bUr;
                locala.bUo = this.bUe[4].bUo;
              }
              if (!this.bUd.isEmpty())
              {
                k = this.bUd.size();
                localObject5 = new float[6];
                localObject6 = new float[6];
                localObject7 = this.bUd.iterator();
                f1 = 0.0F;
                f2 = 0.0F;
                if (((Iterator)localObject7).hasNext()) {
                  continue;
                }
                f6 = f2 / k;
                f4 = f1 / k;
                if (j != 0) {
                  break label1213;
                }
                f11 = f6;
                localObject7 = new float[6];
                localObject7[0] = ((float)Math.atan2(localObject5[0], localObject6[0]));
                localObject7[1] = ((float)Math.atan2(localObject5[1], localObject6[1]));
                localObject7[2] = ((float)Math.atan2(localObject5[2], localObject6[2]));
                localObject7[3] = ((float)Math.atan2(localObject5[3], localObject6[3]));
                localObject7[4] = ((float)Math.atan2(localObject5[4], localObject6[4]));
                localObject7[5] = ((float)Math.atan2(localObject5[5], localObject6[5]));
                if (j != 0) {
                  break label1220;
                }
                f10 = f6;
                break label1735;
                localObject5 = this.bUd.iterator();
                f2 = f4;
                f8 = 0.0F;
                f9 = 0.0F;
                i = 0;
                if (((Iterator)localObject5).hasNext()) {
                  break;
                }
                if (((a)localObject3).bUn > 0)
                {
                  if (j != 0) {
                    break label1716;
                  }
                  f1 = 0.0F;
                  f2 = localObject1 / ((a)localObject3).bUn;
                  f3 = ((a)localObject3).bUo;
                  f2 = f1 + ((f2 - f11) / 15.0F + 0.537F);
                  f1 = f2;
                  if (f3 != 0.0F) {
                    f1 = f2 * 0.67F + 0.33F * f3;
                  }
                  ((a)localObject3).bUo = f1;
                  ((a)localObject3).x *= ((a)localObject3).bUo;
                  ((a)localObject3).y *= ((a)localObject3).bUo;
                  ((a)localObject3).bUp = (((a)localObject3).bUn * ((a)localObject3).bUo);
                }
              }
              ((a)localObject3).bUq = (((a)localObject3).bUp / (this.bUd.size() / 20));
              if (this.bUe[0] != null)
              {
                ((a)localObject3).x += this.bUe[0].x;
                ((a)localObject3).y += this.bUe[0].y;
                ((a)localObject3).z += this.bUe[0].z;
                ((a)localObject3).bUn += this.bUe[0].bUn;
                ((a)localObject3).bUp += this.bUe[0].bUp;
              }
              if ((this.bUe[4] != null) && (locala.bUn > 0))
              {
                this.bUe[4].x = ((this.bUe[4].x + ((a)localObject3).x + locala.x * ((a)localObject3).bUo) / 2.0F);
                this.bUe[4].y = ((this.bUe[4].y + ((a)localObject3).y + locala.y * ((a)localObject3).bUo) / 2.0F);
              }
              AppMethodBeat.o(87982);
              return localObject3;
            }
          }
          else
          {
            i2 = 0;
            continue;
          }
          i = 2;
          continue;
          if (Math.abs(this.bUi[0][0]) < 7.0F) {
            break label1764;
          }
          if (this.bUi[1][1] >= 2.3F) {
            break label1758;
          }
          if (this.bUi[1][2] < 2.3F) {
            break label1764;
          }
          break label1758;
          if (i != 0)
          {
            this.bUk = 2;
            this.bUj = new int[6];
            j = i;
            continue;
          }
          f1 = Math.abs(this.bUi[0][0]);
          f2 = Math.abs(this.bUi[1][0]);
          f3 = Math.abs(this.bUi[2][0]);
          if (f1 <= f2) {
            break label1803;
          }
          if (f1 <= f3) {
            break label1797;
          }
          j = 0;
          break label1770;
          if (k < 3) {
            break label1823;
          }
          j = n * 2 + m - 1;
          Object localObject3 = this.bUj;
          localObject3[j] += 1;
          j = 0;
          break label1784;
          f2 = f1;
          if (this.bUi[k][n] <= f1) {
            break label1885;
          }
          f2 = this.bUi[k][n];
          m = n;
          i1 = k;
          break label1885;
          if ((j == this.bUk) || (this.bUj[j] <= this.bUj[this.bUk])) {
            break label1897;
          }
          this.bUk = j;
          break label1897;
          u.b localb = (u.b)((Iterator)localObject7).next();
          if (j == 0)
          {
            f3 = localb.bTC;
            f3 = f2 + f3;
            if (j == 0)
            {
              f2 = localb.bTK;
              break label1906;
              label1084:
              f1 = f4;
              f2 = f3;
              if (i > 5) {
                continue;
              }
              localObject5[i] += localb.bTO[i];
              localObject6[i] += localb.bTP[i];
              i += 1;
              continue;
            }
          }
          else
          {
            f3 = localb.bTF;
            continue;
          }
          f2 = (float)Math.sqrt(localb.bTD * localb.bTD + localb.bTE * localb.bTE + localb.bTF * localb.bTF);
          localb.bTJ = f2;
        }
        finally {}
        label1213:
        float f11 = f4;
        continue;
        label1220:
        f10 = f4;
        break label1735;
        label1227:
        f1 = 1.0F;
        break label1746;
        label1232:
        f12 = 0.261799F;
      }
      Object localObject6 = (u.b)((Iterator)localObject5).next();
      if (j == 0) {}
      label1278:
      Object localObject2;
      for (float f3 = ((u.b)localObject6).bTC;; f3 = ((u.b)localObject6).bTJ)
      {
        if (j != 0) {
          break label1328;
        }
        f5 = ((u.b)localObject6).bTK;
        break label1918;
        if (i > 0) {
          break label1338;
        }
        if (f3 > localObject2) {
          break label1937;
        }
        f9 = localObject6.bTO[this.bUk];
        f8 = localObject6.bTP[this.bUk];
        break;
      }
      label1328:
      float f5 = ((u.b)localObject6).bTJ;
      break label1918;
      label1338:
      if (f10 < f3) {
        if (i2 == 0)
        {
          f10 = f3 - localObject2;
          if (f10 > 2.0F * f1)
          {
            f1 = f10 / 2.0F;
            f10 = f3;
            break label1961;
            label1379:
            f3 = localObject1;
            if (i <= 10)
            {
              k = 1;
              i = k;
              if (localObject4.bUr == 0L) {
                break label1990;
              }
              i = k;
              if (((u.b)localObject6).time - localObject4.bUr >= 250L) {
                break label1990;
              }
              i = 0;
              break label1990;
            }
          }
        }
      }
      for (;;)
      {
        f3 = localObject1;
        float f7;
        if (k != 0)
        {
          localObject4.bUn += 1;
          localObject1 += f10;
          f3 = localObject6.bTO[this.bUk];
          f5 = localObject6.bTP[this.bUk];
          f5 = (float)Math.atan2(f3 + f9, f5 + f8);
          f8 = Math.abs(f5 - localObject7[this.bUk]);
          f3 = f8;
          if (f8 <= 3.141593F) {
            break label2020;
          }
          f3 = 6.283186F - f8;
          break label2020;
        }
        for (;;)
        {
          f8 = (float)(Math.sin(f5) * f3);
          double d = Math.cos(f5);
          f5 = (float)(f3 * d);
          localObject4.x += f8;
          localObject4.y += f5;
          f3 = f7;
          if (((u.b)localObject6).time - locala.bUr > 250L)
          {
            locala.x -= f8;
            locala.y -= f5;
            locala.bUn += 1;
            f3 = f7;
          }
          localObject4.bUr = ((u.b)localObject6).time;
          f9 = localObject6.bTO[this.bUk];
          f8 = localObject6.bTP[this.bUk];
          i = 0;
          f7 = f3;
          break;
          label1704:
          f5 = localObject7[this.bUk];
        }
        label1716:
        f1 = 0.08F;
        break label432;
        label1735:
        label1746:
        label1758:
        label1764:
        label1770:
        label1784:
        label1918:
        float f13;
        for (;;)
        {
          break label1973;
          f10 = f3;
          break label1961;
          break label1961;
          f7 = 0.0F;
          if (j != 0) {
            break label1227;
          }
          f1 = 1.2F;
          if (i2 == 0) {
            break label1232;
          }
          f12 = 0.08726647F;
          break label385;
          i = 1;
          break label836;
          i = 0;
          break label836;
          f1 = 0.0F;
          n = 0;
          m = 0;
          k = 0;
          break label919;
          for (;;)
          {
            if (j <= 5) {
              break label1904;
            }
            j = i;
            break;
            label1797:
            j = 2;
            break label1770;
            label1803:
            if (f2 > f3)
            {
              j = 1;
              break label1770;
            }
            j = 2;
            break label1770;
            label1823:
            int i3 = m;
            i1 = n;
            f2 = f1;
            if (k != j)
            {
              i3 = 1;
              i1 = n;
              n = i3;
            }
            for (;;)
            {
              if (n < 3) {
                break label1895;
              }
              f2 = f1;
              i3 = m;
              k += 1;
              m = i3;
              n = i1;
              f1 = f2;
              break;
              label1885:
              n += 1;
              f1 = f2;
            }
            label1895:
            break label960;
            label1897:
            j += 1;
          }
          label1904:
          break label1001;
          label1906:
          f4 = f1 + f2;
          i = 0;
          break label1084;
          if (j == 0)
          {
            f13 = f6;
            break label1278;
          }
          f13 = f4;
          break label1278;
          label1937:
          if (f3 - f13 < f1) {
            break label407;
          }
          f2 = f5;
          i = 1;
          f10 = f3;
          break label407;
          label1961:
          if (f2 < f5) {
            f2 = f5;
          }
        }
        label1973:
        if (f3 <= f13) {
          break label1379;
        }
        i += 1;
        break label407;
        label1990:
        k = i;
        if (i != 0)
        {
          k = i;
          if (f2 - f4 < 0.3F) {
            k = 0;
          }
        }
      }
      label2020:
      if (f3 >= f12) {}
      for (int i = 1;; i = 0)
      {
        f3 = 1.0F;
        if (i == 0) {
          break label1704;
        }
        f3 = 0.93F;
        break;
      }
    }
    
    final void a(u.b paramb)
    {
      try
      {
        AppMethodBeat.i(87984);
        if ((this.bUm > 0) && (this.bUm < 101)) {
          this.bUm -= 1;
        }
        this.bUd.add(paramb);
        this.bUf += 1;
        if (paramb.bTD > this.bUg[0][0]) {
          this.bUg[0][0] = paramb.bTD;
        }
        if (paramb.bTD < this.bUg[0][1]) {
          this.bUg[0][1] = paramb.bTD;
        }
        float[] arrayOfFloat = this.bUg[0];
        arrayOfFloat[2] += paramb.bTD;
        if (paramb.bTE > this.bUg[1][0]) {
          this.bUg[1][0] = paramb.bTE;
        }
        if (paramb.bTE < this.bUg[1][1]) {
          this.bUg[1][1] = paramb.bTE;
        }
        arrayOfFloat = this.bUg[1];
        arrayOfFloat[2] += paramb.bTE;
        if (paramb.bTF > this.bUg[2][0]) {
          this.bUg[2][0] = paramb.bTF;
        }
        if (paramb.bTF < this.bUg[2][1]) {
          this.bUg[2][1] = paramb.bTF;
        }
        arrayOfFloat = this.bUg[2];
        arrayOfFloat[2] += paramb.bTF;
        if (paramb.bTG > this.bUh[0][0]) {
          this.bUh[0][0] = paramb.bTG;
        }
        if (paramb.bTG < this.bUh[0][1]) {
          this.bUh[0][1] = paramb.bTG;
        }
        arrayOfFloat = this.bUh[0];
        arrayOfFloat[2] += paramb.bTG;
        if (paramb.bTH > this.bUh[1][0]) {
          this.bUh[1][0] = paramb.bTH;
        }
        if (paramb.bTH < this.bUh[1][1]) {
          this.bUh[1][1] = paramb.bTH;
        }
        arrayOfFloat = this.bUh[1];
        arrayOfFloat[2] += paramb.bTH;
        if (paramb.bTI > this.bUh[2][0]) {
          this.bUh[2][0] = paramb.bTI;
        }
        if (paramb.bTI < this.bUh[2][1]) {
          this.bUh[2][1] = paramb.bTI;
        }
        arrayOfFloat = this.bUh[2];
        arrayOfFloat[2] += paramb.bTI;
        if (zu()) {
          u.b(u.this);
        }
        AppMethodBeat.o(87984);
        return;
      }
      finally {}
    }
    
    final void reset()
    {
      try
      {
        AppMethodBeat.i(87980);
        this.bUd.clear();
        this.bUe = new a[5];
        this.bUf = 0;
        float[] arrayOfFloat1 = { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F };
        float[] arrayOfFloat2 = { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F };
        this.bUg = new float[][] { arrayOfFloat1, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, arrayOfFloat2 };
        this.bUh = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
        this.bUi = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
        this.bUj = new int[6];
        this.bUk = 5;
        AppMethodBeat.o(87980);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    final a zw()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 274
      //   5: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: getfield 49	com/c/a/a/u$f:bUe	[Lcom/c/a/a/u$f$a;
      //   12: iconst_4
      //   13: aaload
      //   14: ifnull +23 -> 37
      //   17: aload_0
      //   18: getfield 49	com/c/a/a/u$f:bUe	[Lcom/c/a/a/u$f$a;
      //   21: iconst_4
      //   22: aaload
      //   23: invokevirtual 277	com/c/a/a/u$f$a:zx	()Lcom/c/a/a/u$f$a;
      //   26: astore_1
      //   27: ldc_w 274
      //   30: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: areturn
      //   37: aconst_null
      //   38: astore_1
      //   39: ldc_w 274
      //   42: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   45: goto -12 -> 33
      //   48: astore_1
      //   49: aload_0
      //   50: monitorexit
      //   51: aload_1
      //   52: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	53	0	this	f
      //   26	13	1	locala	a
      //   48	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	33	48	finally
      //   39	45	48	finally
    }
    
    final class a
    {
      int bUn = 0;
      float bUo = 0.0F;
      float bUp = 0.0F;
      float bUq = 0.0F;
      long bUr = 0L;
      float x = 0.0F;
      float y = 0.0F;
      float z = 0.0F;
      
      private a() {}
      
      protected final a zx()
      {
        AppMethodBeat.i(87977);
        a locala = new a(u.f.this);
        locala.x = this.x;
        locala.y = this.y;
        locala.z = this.z;
        locala.bUn = this.bUn;
        locala.bUo = this.bUo;
        locala.bUp = this.bUp;
        locala.bUr = this.bUr;
        locala.bUq = this.bUq;
        AppMethodBeat.o(87977);
        return locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.u
 * JD-Core Version:    0.7.0.1
 */