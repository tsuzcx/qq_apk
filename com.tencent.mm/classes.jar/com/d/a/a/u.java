package com.d.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import java.lang.reflect.Array;

final class u
  extends d
  implements SensorEventListener
{
  private static final int aZA;
  private static final int aZB;
  private static u aZT;
  private SensorManager aVT = null;
  private Sensor aZC;
  private Sensor aZD;
  private Sensor aZE;
  private Sensor aZF = null;
  private long aZG = 0L;
  private boolean aZH = true;
  private float[][] aZI = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 });
  private float[][] aZJ = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 });
  private float[][] aZK = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 });
  private float[][] aZL = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] aZM = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] aZN = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] aZO = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[] aZP = new float[4];
  private float[][] aZQ = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] aZR = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] aZS = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  boolean aZU;
  private u.c aZV;
  private boolean[] aZW = new boolean[6];
  private int[] aZX = new int[6];
  private float[] aZY = new float[6];
  private float[] aZZ = new float[6];
  private Sensor accelerometer;
  private float[] baa = { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
  private float[][] bab = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 });
  private final u.d bac = new u.d((byte)0);
  private final u.f bad = new u.f(this, (byte)0);
  private final a bae = new a((byte)0);
  
  static
  {
    int i = Math.round(50000.0F);
    aZA = i;
    aZB = i;
  }
  
  private static void a(float[] paramArrayOfFloat, float[][] paramArrayOfFloat1)
  {
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
  }
  
  private static void a(float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    int i = 0;
    for (;;)
    {
      if (i > 5) {
        return;
      }
      SensorManager.getOrientation(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
      i += 1;
    }
  }
  
  @TargetApi(19)
  private static boolean a(SensorManager paramSensorManager, SensorEventListener paramSensorEventListener, int paramInt1, int paramInt2, Handler paramHandler, Sensor... paramVarArgs)
  {
    for (;;)
    {
      int i;
      int k;
      int j;
      try
      {
        if (Build.VERSION.SDK_INT < 19) {
          break label98;
        }
        i = 1;
        k = paramVarArgs.length;
        j = 0;
      }
      catch (Error paramSensorManager)
      {
        Sensor localSensor;
        boolean bool;
        return false;
      }
      catch (Exception paramSensorManager)
      {
        return false;
      }
      localSensor = paramVarArgs[j];
      if (i != 0)
      {
        bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramInt2, paramHandler);
        if (!bool)
        {
          paramSensorManager.unregisterListener(paramSensorEventListener);
          return false;
        }
      }
      else
      {
        bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramHandler);
        continue;
      }
      j += 1;
      if (j >= k)
      {
        return true;
        label98:
        i = 0;
      }
    }
  }
  
  private static float[] b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return new float[] { paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[3] + paramArrayOfFloat1[2] * paramArrayOfFloat2[6], paramArrayOfFloat1[0] * paramArrayOfFloat2[1] + paramArrayOfFloat1[1] * paramArrayOfFloat2[4] + paramArrayOfFloat1[2] * paramArrayOfFloat2[7], paramArrayOfFloat1[0] * paramArrayOfFloat2[2] + paramArrayOfFloat1[1] * paramArrayOfFloat2[5] + paramArrayOfFloat1[2] * paramArrayOfFloat2[8], paramArrayOfFloat1[3] * paramArrayOfFloat2[0] + paramArrayOfFloat1[4] * paramArrayOfFloat2[3] + paramArrayOfFloat1[5] * paramArrayOfFloat2[6], paramArrayOfFloat1[3] * paramArrayOfFloat2[1] + paramArrayOfFloat1[4] * paramArrayOfFloat2[4] + paramArrayOfFloat1[5] * paramArrayOfFloat2[7], paramArrayOfFloat1[3] * paramArrayOfFloat2[2] + paramArrayOfFloat1[4] * paramArrayOfFloat2[5] + paramArrayOfFloat1[5] * paramArrayOfFloat2[8], paramArrayOfFloat1[6] * paramArrayOfFloat2[0] + paramArrayOfFloat1[7] * paramArrayOfFloat2[3] + paramArrayOfFloat1[8] * paramArrayOfFloat2[6], paramArrayOfFloat1[6] * paramArrayOfFloat2[1] + paramArrayOfFloat1[7] * paramArrayOfFloat2[4] + paramArrayOfFloat1[8] * paramArrayOfFloat2[7], paramArrayOfFloat1[6] * paramArrayOfFloat2[2] + paramArrayOfFloat1[7] * paramArrayOfFloat2[5] + paramArrayOfFloat1[8] * paramArrayOfFloat2[8] };
  }
  
  static u pz()
  {
    if (aZT == null) {
      aZT = new u();
    }
    return aZT;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    if (paramContext == null) {
      try
      {
        throw new Exception("SensorModule: register with null context");
      }
      catch (Exception paramContext)
      {
        this.aZU = false;
      }
    }
    label393:
    label397:
    for (;;)
    {
      return;
      int i = 0;
      label25:
      boolean bool;
      if (i > 5)
      {
        this.aVT = ((SensorManager)paramContext.getSystemService("sensor"));
        this.accelerometer = this.aVT.getDefaultSensor(10);
        this.aZE = this.aVT.getDefaultSensor(9);
        if ((this.accelerometer == null) || (this.aZE == null)) {
          break label393;
        }
        this.aZF = this.aVT.getDefaultSensor(11);
        if (this.aZF == null) {
          break label303;
        }
        bool = a(this.aVT, this, aZA, aZB, paramHandler, new Sensor[] { this.accelerometer, this.aZE, this.aZF });
      }
      for (;;)
      {
        if (!bool) {
          break label397;
        }
        this.aZU = true;
        this.aZV = new u.c(this, paramHandler);
        if (this.aZV == null) {
          break;
        }
        this.aZV.i(Math.round(50.0F), 1000L);
        return;
        this.aZJ[i][0] = 1065353216;
        this.aZJ[i][1] = 0;
        this.aZJ[i][2] = 0;
        this.aZJ[i][3] = 0;
        this.aZJ[i][4] = 1065353216;
        this.aZJ[i][5] = 0;
        this.aZJ[i][6] = 0;
        this.aZJ[i][7] = 0;
        this.aZJ[i][8] = 1065353216;
        i += 1;
        break label25;
        label303:
        this.aZC = this.aVT.getDefaultSensor(4);
        this.aZD = this.aVT.getDefaultSensor(2);
        if ((this.aZC != null) && (this.aZD != null)) {
          bool = a(this.aVT, this, aZA, aZB, paramHandler, new Sensor[] { this.accelerometer, this.aZE, this.aZC, this.aZD });
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
      super.a(paramHandler, parama);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  final void aa(Context paramContext) {}
  
  final void ab(Context paramContext)
  {
    if (this.aZV != null) {
      this.aZV.stop();
    }
    if (this.aVT != null) {}
    try
    {
      this.aVT.unregisterListener(this);
      label29:
      this.aVT = null;
      this.aZF = null;
      this.aZE = null;
      this.aZD = null;
      this.aZC = null;
      this.accelerometer = null;
      this.aZG = 0L;
      this.aZH = true;
      this.aZI = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.aZJ = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.aZL = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.aZM = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.aZN = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.aZW = new boolean[6];
      this.aZX = new int[6];
      this.aZY = new float[6];
      this.aZZ = new float[6];
      this.baa = new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
      this.bab = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 }));
      this.bae.reset();
      this.bac.reset();
      this.bad.reset();
      return;
    }
    catch (Error paramContext)
    {
      break label29;
    }
    catch (Exception paramContext)
    {
      break label29;
    }
  }
  
  final void oX() {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int j = 0;
    int i = 0;
    switch (paramSensorEvent.sensor.getType())
    {
    }
    for (;;)
    {
      return;
      Object localObject3 = new float[16];
      if (this.aZF != null) {}
      float[] arrayOfFloat1;
      for (Object localObject1 = this.aZK;; localObject1 = this.aZJ)
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
        Matrix.multiplyMV(this.aZP, 0, (float[])localObject3, 0, new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], 0.0F }, 0);
        this.bac.a(this.aZP, paramSensorEvent.values, this.aZS[2]);
        return;
      }
      a(paramSensorEvent.values, this.aZS);
      if ((this.aZR[2][0] == 0.0F) && (this.aZR[2][1] == 0.0F) && (this.aZR[2][2] == 0.0F)) {
        continue;
      }
      paramSensorEvent = this.aZI;
      localObject1 = this.aZS;
      localObject3 = this.aZR;
      if ((SensorManager.getRotationMatrix(paramSensorEvent[0], null, localObject1[0], localObject3[0])) && (SensorManager.getRotationMatrix(paramSensorEvent[1], null, localObject1[1], localObject3[1])) && (SensorManager.getRotationMatrix(paramSensorEvent[2], null, localObject1[2], localObject3[2])) && (SensorManager.getRotationMatrix(paramSensorEvent[3], null, localObject1[3], localObject3[3])) && (SensorManager.getRotationMatrix(paramSensorEvent[4], null, localObject1[4], localObject3[4])) && (SensorManager.getRotationMatrix(paramSensorEvent[5], null, localObject1[5], localObject3[5]))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label596;
        }
        a(this.aZI, this.aZL);
        if ((this.aZM[2][0] != 0.0F) || (this.aZM[2][1] != 0.0F) || (this.aZM[2][2] != 0.0F)) {
          break;
        }
        paramSensorEvent = this.aZL;
        localObject1 = this.aZM;
        i = 0;
        while (i <= 5)
        {
          System.arraycopy(paramSensorEvent[i], 0, localObject1[i], 0, 3);
          i += 1;
        }
        break;
      }
      label596:
      continue;
      try
      {
        SensorManager.getRotationMatrixFromVector(this.aZK[2], paramSensorEvent.values);
        SensorManager.remapCoordinateSystem(this.aZK[2], 2, 129, this.aZK[0]);
        SensorManager.remapCoordinateSystem(this.aZK[2], 130, 1, this.aZK[1]);
        SensorManager.remapCoordinateSystem(this.aZK[2], 129, 130, this.aZK[3]);
        SensorManager.remapCoordinateSystem(this.aZK[2], 129, 3, this.aZK[4]);
        SensorManager.remapCoordinateSystem(this.aZK[2], 1, 3, this.aZK[5]);
        while (i <= 5)
        {
          SensorManager.getOrientation(this.aZK[i], this.aZO[i]);
          i += 1;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (paramSensorEvent.values.length > 3) {
            SensorManager.getRotationMatrixFromVector(this.aZK[2], new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2] });
          }
        }
      }
      if ((this.aZL[2][0] == 0.0F) && (this.aZL[2][1] == 0.0F) && (this.aZL[2][2] == 0.0F)) {
        continue;
      }
      Object localObject2;
      float f1;
      if (this.aZH)
      {
        i = 0;
        if (i > 5) {
          this.aZH = false;
        }
      }
      else
      {
        localObject2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 4 });
        if (this.aZG != 0L)
        {
          f1 = (float)(paramSensorEvent.timestamp - this.aZG);
          a(paramSensorEvent.values, this.aZQ);
          i = 0;
        }
      }
      label933:
      float f2;
      float f3;
      for (;;)
      {
        if (i > 5)
        {
          this.aZG = paramSensorEvent.timestamp;
          i = j;
          if (i <= 5) {
            break label1170;
          }
          a(this.aZJ, this.aZM);
          return;
          localObject2 = this.aZI[i];
          this.aZJ[i] = b(this.aZJ[i], (float[])localObject2);
          i += 1;
          break;
        }
        localObject3 = this.aZQ[i];
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
      label1170:
      paramSensorEvent = new float[9];
      try
      {
        SensorManager.getRotationMatrixFromVector(paramSensorEvent, localObject2[i]);
        label1184:
        this.aZJ[i] = b(this.aZJ[i], paramSensorEvent);
        i += 1;
        break label933;
        a(paramSensorEvent.values, this.aZR);
        localObject2 = this.bae;
        paramSensorEvent = paramSensorEvent.values;
        if (paramSensorEvent.length < 3) {
          continue;
        }
        ((a)localObject2).baf += 1;
        double d = ((a)localObject2).bag;
        f1 = paramSensorEvent[0];
        f2 = paramSensorEvent[0];
        f3 = paramSensorEvent[1];
        float f4 = paramSensorEvent[1];
        float f5 = paramSensorEvent[2];
        ((a)localObject2).bag = ((float)(Math.sqrt(f2 * f1 + f4 * f3 + paramSensorEvent[2] * f5) + d));
        return;
      }
      catch (Exception localException)
      {
        break label1184;
      }
    }
  }
  
  private static final class a
  {
    int baf = 0;
    float bag = 0.0F;
    long bah = 0L;
    float bai = 0.0F;
    boolean baj = false;
    long bak = 0L;
    float[] bal = new float[6];
    float[] bam = new float[6];
    float[] ban = new float[6];
    float[] bao = new float[6];
    float[] bap = new float[6];
    float[] baq = new float[6];
    float[] bar = new float[6];
    float[] bas = new float[6];
    float[] bat = new float[6];
    float bau = 0.0F;
    float bav = (1.0F / -1.0F);
    float baw = (1.0F / 1.0F);
    boolean bax = false;
    
    final void reset()
    {
      this.baf = 0;
      this.bag = 0.0F;
      this.bah = 0L;
      this.bai = 0.0F;
      this.baj = false;
      this.bak = 0L;
      this.bal = new float[6];
      this.bam = new float[6];
      this.ban = new float[6];
      this.bau = 0.0F;
      this.bav = (1.0F / -1.0F);
      this.baw = (1.0F / 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.d.a.a.u
 * JD-Core Version:    0.7.0.1
 */