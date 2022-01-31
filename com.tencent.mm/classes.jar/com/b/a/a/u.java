package com.b.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

final class u
  extends d
  implements SensorEventListener
{
  private static final int bqg;
  private static final int bqh;
  private static u bqz;
  private Sensor accelerometer;
  private SensorManager bmB;
  boolean bqA;
  private u.c bqB;
  private boolean[] bqC;
  private int[] bqD;
  private float[] bqE;
  private float[] bqF;
  private float[] bqG;
  private float[][] bqH;
  private final u.d bqI;
  private final u.f bqJ;
  private final u.a bqK;
  private Sensor bqi;
  private Sensor bqj;
  private Sensor bqk;
  private Sensor bql;
  private long bqm;
  private boolean bqn;
  private float[][] bqo;
  private float[][] bqp;
  private float[][] bqq;
  private float[][] bqr;
  private float[][] bqs;
  private float[][] bqt;
  private float[][] bqu;
  private float[] bqv;
  private float[][] bqw;
  private float[][] bqx;
  private float[][] bqy;
  
  static
  {
    AppMethodBeat.i(55641);
    int i = Math.round(50000.0F);
    bqg = i;
    bqh = i;
    AppMethodBeat.o(55641);
  }
  
  private u()
  {
    AppMethodBeat.i(55643);
    this.bmB = null;
    this.bql = null;
    this.bqm = 0L;
    this.bqn = true;
    this.bqo = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
    this.bqp = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
    this.bqq = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
    this.bqr = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bqs = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bqt = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bqu = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bqv = new float[4];
    this.bqw = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bqx = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bqy = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.bqC = new boolean[6];
    this.bqD = new int[6];
    this.bqE = new float[6];
    this.bqF = new float[6];
    this.bqG = new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
    this.bqH = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 }));
    this.bqK = new u.a((byte)0);
    this.bqI = new u.d((byte)0);
    this.bqJ = new u.f(this, (byte)0);
    AppMethodBeat.o(55643);
  }
  
  private static void a(float[] paramArrayOfFloat, float[][] paramArrayOfFloat1)
  {
    AppMethodBeat.i(55649);
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
    AppMethodBeat.o(55649);
  }
  
  private static void a(float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    AppMethodBeat.i(55644);
    int i = 0;
    for (;;)
    {
      if (i > 5)
      {
        AppMethodBeat.o(55644);
        return;
      }
      SensorManager.getOrientation(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
      i += 1;
    }
  }
  
  @TargetApi(19)
  private static boolean a(SensorManager paramSensorManager, SensorEventListener paramSensorEventListener, int paramInt1, int paramInt2, Handler paramHandler, Sensor... paramVarArgs)
  {
    AppMethodBeat.i(55648);
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
          AppMethodBeat.o(55648);
          return true;
          i = 0;
          break;
        }
        Sensor localSensor = paramVarArgs[j];
        if (i != 0) {}
        for (boolean bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramInt2, paramHandler); !bool; bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramHandler))
        {
          paramSensorManager.unregisterListener(paramSensorEventListener);
          AppMethodBeat.o(55648);
          return false;
        }
        j += 1;
      }
      return false;
    }
    catch (Error paramSensorManager)
    {
      AppMethodBeat.o(55648);
      return false;
    }
    catch (Exception paramSensorManager)
    {
      AppMethodBeat.o(55648);
    }
  }
  
  private static float[] b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return new float[] { paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[3] + paramArrayOfFloat1[2] * paramArrayOfFloat2[6], paramArrayOfFloat1[0] * paramArrayOfFloat2[1] + paramArrayOfFloat1[1] * paramArrayOfFloat2[4] + paramArrayOfFloat1[2] * paramArrayOfFloat2[7], paramArrayOfFloat1[0] * paramArrayOfFloat2[2] + paramArrayOfFloat1[1] * paramArrayOfFloat2[5] + paramArrayOfFloat1[2] * paramArrayOfFloat2[8], paramArrayOfFloat1[3] * paramArrayOfFloat2[0] + paramArrayOfFloat1[4] * paramArrayOfFloat2[3] + paramArrayOfFloat1[5] * paramArrayOfFloat2[6], paramArrayOfFloat1[3] * paramArrayOfFloat2[1] + paramArrayOfFloat1[4] * paramArrayOfFloat2[4] + paramArrayOfFloat1[5] * paramArrayOfFloat2[7], paramArrayOfFloat1[3] * paramArrayOfFloat2[2] + paramArrayOfFloat1[4] * paramArrayOfFloat2[5] + paramArrayOfFloat1[5] * paramArrayOfFloat2[8], paramArrayOfFloat1[6] * paramArrayOfFloat2[0] + paramArrayOfFloat1[7] * paramArrayOfFloat2[3] + paramArrayOfFloat1[8] * paramArrayOfFloat2[6], paramArrayOfFloat1[6] * paramArrayOfFloat2[1] + paramArrayOfFloat1[7] * paramArrayOfFloat2[4] + paramArrayOfFloat1[8] * paramArrayOfFloat2[7], paramArrayOfFloat1[6] * paramArrayOfFloat2[2] + paramArrayOfFloat1[7] * paramArrayOfFloat2[5] + paramArrayOfFloat1[8] * paramArrayOfFloat2[8] };
  }
  
  static u tF()
  {
    AppMethodBeat.i(55642);
    if (bqz == null) {
      bqz = new u();
    }
    u localu = bqz;
    AppMethodBeat.o(55642);
    return localu;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(55645);
    if (paramContext == null) {
      try
      {
        paramContext = new Exception("SensorModule: register with null context");
        AppMethodBeat.o(55645);
        throw paramContext;
      }
      catch (Exception paramContext)
      {
        this.bqA = false;
      }
    }
    label419:
    label423:
    for (;;)
    {
      AppMethodBeat.o(55645);
      return;
      int i = 0;
      boolean bool;
      if (i > 5)
      {
        this.bmB = ((SensorManager)paramContext.getSystemService("sensor"));
        this.accelerometer = this.bmB.getDefaultSensor(10);
        this.bqk = this.bmB.getDefaultSensor(9);
        if ((this.accelerometer == null) || (this.bqk == null)) {
          break label419;
        }
        this.bql = this.bmB.getDefaultSensor(11);
        if (this.bql == null) {
          break label329;
        }
        bool = a(this.bmB, this, bqg, bqh, paramHandler, new Sensor[] { this.accelerometer, this.bqk, this.bql });
      }
      for (;;)
      {
        if (!bool) {
          break label423;
        }
        this.bqA = true;
        this.bqB = new u.c(this, paramHandler);
        if (this.bqB != null) {
          this.bqB.p(Math.round(50.0F), 1000L);
        }
        AppMethodBeat.o(55645);
        return;
        this.bqp[i][0] = 1065353216;
        this.bqp[i][1] = 0;
        this.bqp[i][2] = 0;
        this.bqp[i][3] = 0;
        this.bqp[i][4] = 1065353216;
        this.bqp[i][5] = 0;
        this.bqp[i][6] = 0;
        this.bqp[i][7] = 0;
        this.bqp[i][8] = 1065353216;
        i += 1;
        break;
        label329:
        this.bqi = this.bmB.getDefaultSensor(4);
        this.bqj = this.bmB.getDefaultSensor(2);
        if ((this.bqi != null) && (this.bqj != null)) {
          bool = a(this.bmB, this, bqg, bqh, paramHandler, new Sensor[] { this.accelerometer, this.bqk, this.bqi, this.bqj });
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
      AppMethodBeat.i(55647);
      super.a(paramHandler, parama);
      AppMethodBeat.o(55647);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  final void al(Context paramContext) {}
  
  final void am(Context paramContext)
  {
    AppMethodBeat.i(55646);
    if (this.bqB != null) {
      this.bqB.stop();
    }
    if (this.bmB != null) {}
    try
    {
      this.bmB.unregisterListener(this);
      label35:
      this.bmB = null;
      this.bql = null;
      this.bqk = null;
      this.bqj = null;
      this.bqi = null;
      this.accelerometer = null;
      this.bqm = 0L;
      this.bqn = true;
      this.bqo = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.bqp = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.bqr = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.bqs = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.bqt = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.bqC = new boolean[6];
      this.bqD = new int[6];
      this.bqE = new float[6];
      this.bqF = new float[6];
      this.bqG = new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
      this.bqH = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 }));
      this.bqK.reset();
      this.bqI.reset();
      this.bqJ.reset();
      AppMethodBeat.o(55646);
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
    AppMethodBeat.i(55650);
    switch (paramSensorEvent.sensor.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55650);
      return;
      Object localObject3 = new float[16];
      if (this.bql != null) {}
      float[] arrayOfFloat1;
      for (Object localObject1 = this.bqq;; localObject1 = this.bqp)
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
        Matrix.multiplyMV(this.bqv, 0, (float[])localObject3, 0, new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], 0.0F }, 0);
        this.bqI.a(this.bqv, paramSensorEvent.values, this.bqy[2]);
        AppMethodBeat.o(55650);
        return;
      }
      a(paramSensorEvent.values, this.bqy);
      if ((this.bqx[2][0] == 0.0F) && (this.bqx[2][1] == 0.0F) && (this.bqx[2][2] == 0.0F)) {
        continue;
      }
      paramSensorEvent = this.bqo;
      localObject1 = this.bqy;
      localObject3 = this.bqx;
      if ((SensorManager.getRotationMatrix(paramSensorEvent[0], null, localObject1[0], localObject3[0])) && (SensorManager.getRotationMatrix(paramSensorEvent[1], null, localObject1[1], localObject3[1])) && (SensorManager.getRotationMatrix(paramSensorEvent[2], null, localObject1[2], localObject3[2])) && (SensorManager.getRotationMatrix(paramSensorEvent[3], null, localObject1[3], localObject3[3])) && (SensorManager.getRotationMatrix(paramSensorEvent[4], null, localObject1[4], localObject3[4])) && (SensorManager.getRotationMatrix(paramSensorEvent[5], null, localObject1[5], localObject3[5])))
      {
        i = 1;
        if (i != 0)
        {
          a(this.bqo, this.bqr);
          if ((this.bqs[2][0] == 0.0F) && (this.bqs[2][1] == 0.0F) && (this.bqs[2][2] == 0.0F))
          {
            paramSensorEvent = this.bqr;
            localObject1 = this.bqs;
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i > 5)
        {
          AppMethodBeat.o(55650);
          return;
          i = 0;
          break;
        }
        System.arraycopy(paramSensorEvent[i], 0, localObject1[i], 0, 3);
        i += 1;
      }
      try
      {
        SensorManager.getRotationMatrixFromVector(this.bqq[2], paramSensorEvent.values);
        SensorManager.remapCoordinateSystem(this.bqq[2], 2, 129, this.bqq[0]);
        SensorManager.remapCoordinateSystem(this.bqq[2], 130, 1, this.bqq[1]);
        SensorManager.remapCoordinateSystem(this.bqq[2], 129, 130, this.bqq[3]);
        SensorManager.remapCoordinateSystem(this.bqq[2], 129, 3, this.bqq[4]);
        SensorManager.remapCoordinateSystem(this.bqq[2], 1, 3, this.bqq[5]);
        if (i > 5)
        {
          AppMethodBeat.o(55650);
          return;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (paramSensorEvent.values.length > 3)
          {
            SensorManager.getRotationMatrixFromVector(this.bqq[2], new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2] });
            continue;
            SensorManager.getOrientation(this.bqq[i], this.bqu[i]);
            i += 1;
          }
        }
      }
      Object localObject2;
      float f1;
      if ((this.bqr[2][0] != 0.0F) || (this.bqr[2][1] != 0.0F) || (this.bqr[2][2] != 0.0F))
      {
        if (this.bqn)
        {
          i = 0;
          if (i <= 5) {
            break label987;
          }
          this.bqn = false;
        }
        localObject2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 4 });
        if (this.bqm != 0L)
        {
          f1 = (float)(paramSensorEvent.timestamp - this.bqm);
          a(paramSensorEvent.values, this.bqw);
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
          this.bqm = paramSensorEvent.timestamp;
          i = j;
          if (i <= 5) {
            break label1208;
          }
          a(this.bqp, this.bqs);
          AppMethodBeat.o(55650);
          return;
          localObject2 = this.bqo[i];
          localObject3 = this.bqp;
          localObject3[i] = b(localObject3[i], (float[])localObject2);
          i += 1;
          break;
        }
        localObject3 = this.bqw[i];
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
        localObject3 = this.bqp;
        localObject3[i] = b(localObject3[i], paramSensorEvent);
        i += 1;
        break label963;
        a(paramSensorEvent.values, this.bqx);
        localObject2 = this.bqK;
        paramSensorEvent = paramSensorEvent.values;
        if (paramSensorEvent.length < 3) {
          continue;
        }
        ((u.a)localObject2).bqL += 1;
        double d = ((u.a)localObject2).bqM;
        f1 = paramSensorEvent[0];
        f2 = paramSensorEvent[0];
        f3 = paramSensorEvent[1];
        float f4 = paramSensorEvent[1];
        float f5 = paramSensorEvent[2];
        ((u.a)localObject2).bqM = ((float)(Math.sqrt(f2 * f1 + f4 * f3 + paramSensorEvent[2] * f5) + d));
      }
      catch (Exception localException)
      {
        break label1222;
      }
    }
  }
  
  final void td() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.b.a.a.u
 * JD-Core Version:    0.7.0.1
 */