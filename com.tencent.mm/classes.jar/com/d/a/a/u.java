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
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class u
  extends d
  implements SensorEventListener
{
  private static u caQ;
  private static final int caw;
  private static final int cax;
  private Sensor caA;
  private Sensor caB;
  private Sensor caC;
  private long caD;
  private boolean caE;
  private float[][] caF;
  private float[][] caG;
  private float[][] caH;
  private float[][] caI;
  private float[][] caJ;
  private float[][] caK;
  private float[][] caL;
  private float[] caM;
  private float[][] caN;
  private float[][] caO;
  private float[][] caP;
  boolean caR;
  private c caS;
  private boolean[] caT;
  private int[] caU;
  private float[] caV;
  private float[] caW;
  private float[] caX;
  private float[][] caY;
  private final d caZ;
  private Sensor cay;
  private Sensor caz;
  private final f cba;
  private final a cbb;
  private SensorManager mSensorManager;
  
  static
  {
    AppMethodBeat.i(87986);
    int i = Math.round(50000.0F);
    caw = i;
    cax = i;
    AppMethodBeat.o(87986);
  }
  
  private u()
  {
    AppMethodBeat.i(87988);
    this.mSensorManager = null;
    this.caC = null;
    this.caD = 0L;
    this.caE = true;
    this.caF = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
    this.caG = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
    this.caH = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
    this.caI = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.caJ = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.caK = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.caL = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.caM = new float[4];
    this.caN = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.caO = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.caP = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
    this.caT = new boolean[6];
    this.caU = new int[6];
    this.caV = new float[6];
    this.caW = new float[6];
    this.caX = new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
    this.caY = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 }));
    this.cbb = new a((byte)0);
    this.caZ = new d((byte)0);
    this.cba = new f((byte)0);
    AppMethodBeat.o(87988);
  }
  
  static u AD()
  {
    AppMethodBeat.i(87987);
    if (caQ == null) {
      caQ = new u();
    }
    u localu = caQ;
    AppMethodBeat.o(87987);
    return localu;
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
  
  final void Ab() {}
  
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
        this.caR = false;
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
        this.cay = this.mSensorManager.getDefaultSensor(10);
        this.caB = this.mSensorManager.getDefaultSensor(9);
        if ((this.cay == null) || (this.caB == null)) {
          break label419;
        }
        this.caC = this.mSensorManager.getDefaultSensor(11);
        if (this.caC == null) {
          break label329;
        }
        bool = a(this.mSensorManager, this, caw, cax, paramHandler, new Sensor[] { this.cay, this.caB, this.caC });
      }
      for (;;)
      {
        if (!bool) {
          break label423;
        }
        this.caR = true;
        this.caS = new c(paramHandler);
        if (this.caS != null) {
          this.caS.n(Math.round(50.0F), 1000L);
        }
        AppMethodBeat.o(87990);
        return;
        this.caG[i][0] = 1065353216;
        this.caG[i][1] = 0;
        this.caG[i][2] = 0;
        this.caG[i][3] = 0;
        this.caG[i][4] = 1065353216;
        this.caG[i][5] = 0;
        this.caG[i][6] = 0;
        this.caG[i][7] = 0;
        this.caG[i][8] = 1065353216;
        i += 1;
        break;
        label329:
        this.caz = this.mSensorManager.getDefaultSensor(4);
        this.caA = this.mSensorManager.getDefaultSensor(2);
        if ((this.caz != null) && (this.caA != null)) {
          bool = a(this.mSensorManager, this, caw, cax, paramHandler, new Sensor[] { this.cay, this.caB, this.caz, this.caA });
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
  
  final void as(Context paramContext) {}
  
  final void at(Context paramContext)
  {
    AppMethodBeat.i(87991);
    if (this.caS != null) {
      this.caS.stop();
    }
    if (this.mSensorManager != null) {}
    try
    {
      this.mSensorManager.unregisterListener(this);
      label35:
      this.mSensorManager = null;
      this.caC = null;
      this.caB = null;
      this.caA = null;
      this.caz = null;
      this.cay = null;
      this.caD = 0L;
      this.caE = true;
      this.caF = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.caG = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.caI = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.caJ = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.caK = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.caT = new boolean[6];
      this.caU = new int[6];
      this.caV = new float[6];
      this.caW = new float[6];
      this.caX = new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
      this.caY = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 }));
      this.cbb.reset();
      this.caZ.reset();
      this.cba.reset();
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
      if (this.caC != null) {}
      float[] arrayOfFloat1;
      for (Object localObject1 = this.caH;; localObject1 = this.caG)
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
        Matrix.multiplyMV(this.caM, 0, (float[])localObject3, 0, new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], 0.0F }, 0);
        this.caZ.a(this.caM, paramSensorEvent.values, this.caP[2]);
        AppMethodBeat.o(87995);
        return;
      }
      a(paramSensorEvent.values, this.caP);
      if ((this.caO[2][0] == 0.0F) && (this.caO[2][1] == 0.0F) && (this.caO[2][2] == 0.0F)) {
        continue;
      }
      paramSensorEvent = this.caF;
      localObject1 = this.caP;
      localObject3 = this.caO;
      if ((SensorManager.getRotationMatrix(paramSensorEvent[0], null, localObject1[0], localObject3[0])) && (SensorManager.getRotationMatrix(paramSensorEvent[1], null, localObject1[1], localObject3[1])) && (SensorManager.getRotationMatrix(paramSensorEvent[2], null, localObject1[2], localObject3[2])) && (SensorManager.getRotationMatrix(paramSensorEvent[3], null, localObject1[3], localObject3[3])) && (SensorManager.getRotationMatrix(paramSensorEvent[4], null, localObject1[4], localObject3[4])) && (SensorManager.getRotationMatrix(paramSensorEvent[5], null, localObject1[5], localObject3[5])))
      {
        i = 1;
        if (i != 0)
        {
          a(this.caF, this.caI);
          if ((this.caJ[2][0] == 0.0F) && (this.caJ[2][1] == 0.0F) && (this.caJ[2][2] == 0.0F))
          {
            paramSensorEvent = this.caI;
            localObject1 = this.caJ;
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
        SensorManager.getRotationMatrixFromVector(this.caH[2], paramSensorEvent.values);
        SensorManager.remapCoordinateSystem(this.caH[2], 2, 129, this.caH[0]);
        SensorManager.remapCoordinateSystem(this.caH[2], 130, 1, this.caH[1]);
        SensorManager.remapCoordinateSystem(this.caH[2], 129, 130, this.caH[3]);
        SensorManager.remapCoordinateSystem(this.caH[2], 129, 3, this.caH[4]);
        SensorManager.remapCoordinateSystem(this.caH[2], 1, 3, this.caH[5]);
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
            SensorManager.getRotationMatrixFromVector(this.caH[2], new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2] });
            continue;
            SensorManager.getOrientation(this.caH[i], this.caL[i]);
            i += 1;
          }
        }
      }
      Object localObject2;
      float f1;
      if ((this.caI[2][0] != 0.0F) || (this.caI[2][1] != 0.0F) || (this.caI[2][2] != 0.0F))
      {
        if (this.caE)
        {
          i = 0;
          if (i <= 5) {
            break label987;
          }
          this.caE = false;
        }
        localObject2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 4 });
        if (this.caD != 0L)
        {
          f1 = (float)(paramSensorEvent.timestamp - this.caD);
          a(paramSensorEvent.values, this.caN);
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
          this.caD = paramSensorEvent.timestamp;
          i = j;
          if (i <= 5) {
            break label1208;
          }
          a(this.caG, this.caJ);
          AppMethodBeat.o(87995);
          return;
          localObject2 = this.caF[i];
          localObject3 = this.caG;
          localObject3[i] = b(localObject3[i], (float[])localObject2);
          i += 1;
          break;
        }
        localObject3 = this.caN[i];
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
        localObject3 = this.caG;
        localObject3[i] = b(localObject3[i], paramSensorEvent);
        i += 1;
        break label963;
        a(paramSensorEvent.values, this.caO);
        localObject2 = this.cbb;
        paramSensorEvent = paramSensorEvent.values;
        if (paramSensorEvent.length < 3) {
          continue;
        }
        ((a)localObject2).cbc += 1;
        double d = ((a)localObject2).cbd;
        f1 = paramSensorEvent[0];
        f2 = paramSensorEvent[0];
        f3 = paramSensorEvent[1];
        float f4 = paramSensorEvent[1];
        float f5 = paramSensorEvent[2];
        ((a)localObject2).cbd = ((float)(Math.sqrt(f2 * f1 + f4 * f3 + paramSensorEvent[2] * f5) + d));
      }
      catch (Exception localException)
      {
        break label1222;
      }
    }
  }
  
  static final class a
  {
    int cbc;
    float cbd;
    long cbe;
    float cbf;
    boolean cbg;
    long cbh;
    float[] cbi;
    float[] cbj;
    float[] cbk;
    float[] cbl;
    float[] cbm;
    float[] cbn;
    float[] cbo;
    float[] cbp;
    float[] cbq;
    float cbr;
    float cbs;
    float cbt;
    boolean cbu;
    
    private a()
    {
      AppMethodBeat.i(87973);
      this.cbc = 0;
      this.cbd = 0.0F;
      this.cbe = 0L;
      this.cbf = 0.0F;
      this.cbg = false;
      this.cbh = 0L;
      this.cbi = new float[6];
      this.cbj = new float[6];
      this.cbk = new float[6];
      this.cbl = new float[6];
      this.cbm = new float[6];
      this.cbn = new float[6];
      this.cbo = new float[6];
      this.cbp = new float[6];
      this.cbq = new float[6];
      this.cbr = 0.0F;
      this.cbs = (1.0F / -1.0F);
      this.cbt = (1.0F / 1.0F);
      this.cbu = false;
      AppMethodBeat.o(87973);
    }
    
    final void reset()
    {
      this.cbc = 0;
      this.cbd = 0.0F;
      this.cbe = 0L;
      this.cbf = 0.0F;
      this.cbg = false;
      this.cbh = 0L;
      this.cbi = new float[6];
      this.cbj = new float[6];
      this.cbk = new float[6];
      this.cbr = 0.0F;
      this.cbs = (1.0F / -1.0F);
      this.cbt = (1.0F / 1.0F);
    }
  }
  
  static final class b
  {
    float cbA;
    float cbB;
    float cbC;
    float cbD;
    float cbE;
    float cbF;
    float[] cbG;
    float[] cbH;
    float[] cbI;
    float[] cbJ;
    float[] cbK;
    float cbv;
    float cbw;
    float cbx;
    float cby;
    float cbz;
    long time;
    
    private b()
    {
      AppMethodBeat.i(87974);
      this.cbG = new float[6];
      this.cbH = new float[6];
      this.cbI = new float[6];
      this.cbJ = new float[6];
      this.cbK = new float[6];
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
    
    final void Af()
    {
      AppMethodBeat.i(87975);
      u.a(u.this);
      AppMethodBeat.o(87975);
    }
  }
  
  static final class d
  {
    private float cbM = 0.0F;
    private float cbN = 0.0F;
    private float cbO = 0.0F;
    private float cbP = 0.0F;
    private float cbQ = 0.0F;
    private float cbR = 0.0F;
    private float cbS = 0.0F;
    private float cbT = 0.0F;
    private float cbU = 0.0F;
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
            localb.cbv = (this.cbM / this.count);
            localb.cbw = (this.cbN / this.count);
            localb.cbx = (this.cbO / this.count);
            localb.cby = (this.cbP / this.count);
            localb.cbz = (this.cbQ / this.count);
            localb.cbA = (this.cbR / this.count);
            localb.cbB = (this.cbS / this.count);
            localb.cbC = (this.cbT / this.count);
            localb.cbD = (this.cbU / this.count);
            localb.cbF = ((float)Math.sqrt(localb.cbv * localb.cbv + localb.cbw * localb.cbw));
            reset();
            AppMethodBeat.o(87976);
            paramArrayOfFloat = localb;
            continue;
          }
          localb.cbG[i] = paramArrayOfFloat[i][0];
        }
        finally {}
        localb.cbH[i] = paramArrayOfFloat[i][1];
        localb.cbI[i] = paramArrayOfFloat[i][2];
        localb.cbJ[i] = ((float)Math.sin(localb.cbG[i]));
        localb.cbK[i] = ((float)Math.cos(localb.cbG[i]));
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
          this.cbM += paramArrayOfFloat1[0];
          this.cbN += paramArrayOfFloat1[1];
          this.cbO += paramArrayOfFloat1[2];
          this.cbP += paramArrayOfFloat2[0];
          this.cbQ += paramArrayOfFloat2[1];
          this.cbR += paramArrayOfFloat2[2];
          this.cbS += paramArrayOfFloat3[0];
          this.cbT += paramArrayOfFloat3[1];
          this.cbU += paramArrayOfFloat3[2];
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
        this.cbM = 0.0F;
        this.cbN = 0.0F;
        this.cbO = 0.0F;
        this.cbP = 0.0F;
        this.cbQ = 0.0F;
        this.cbR = 0.0F;
        this.cbS = 0.0F;
        this.cbT = 0.0F;
        this.cbU = 0.0F;
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
    final float bdQ;
    final float cbV;
    final float cbW;
    final int cbX;
    final float x;
    final float y;
    
    private e(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5)
    {
      super();
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.cbX = paramInt;
      this.cbV = paramFloat3;
      this.cbW = paramFloat4;
      this.bdQ = paramFloat5;
    }
  }
  
  final class f
  {
    private ArrayList<u.b> cbY;
    private a[] cbZ;
    private int cca;
    private float[][] ccb;
    private float[][] ccc;
    private float[][] ccd;
    private int[] cce;
    private int ccf;
    private int ccg;
    private int cch;
    
    private f()
    {
      AppMethodBeat.i(87979);
      this.cbY = new ArrayList();
      this.cbZ = new a[5];
      this.cca = 0;
      this.ccb = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
      this.ccc = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
      this.ccd = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
      this.cce = new int[6];
      this.ccf = 5;
      this.ccg = -1;
      this.cch = 0;
      AppMethodBeat.o(87979);
    }
    
    /* Error */
    private boolean AE()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 92
      //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 51	com/d/a/a/u$f:cca	I
      //   11: bipush 20
      //   13: if_icmplt +716 -> 729
      //   16: aload_0
      //   17: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   20: iconst_0
      //   21: aaload
      //   22: astore 17
      //   24: aload 17
      //   26: iconst_2
      //   27: aload 17
      //   29: iconst_2
      //   30: faload
      //   31: ldc 93
      //   33: fdiv
      //   34: fastore
      //   35: aload_0
      //   36: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   39: iconst_1
      //   40: aaload
      //   41: astore 17
      //   43: aload 17
      //   45: iconst_2
      //   46: aload 17
      //   48: iconst_2
      //   49: faload
      //   50: ldc 93
      //   52: fdiv
      //   53: fastore
      //   54: aload_0
      //   55: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   58: iconst_2
      //   59: aaload
      //   60: astore 17
      //   62: aload 17
      //   64: iconst_2
      //   65: aload 17
      //   67: iconst_2
      //   68: faload
      //   69: ldc 93
      //   71: fdiv
      //   72: fastore
      //   73: aload_0
      //   74: getfield 59	com/d/a/a/u$f:ccc	[[F
      //   77: iconst_0
      //   78: aaload
      //   79: astore 17
      //   81: aload 17
      //   83: iconst_2
      //   84: aload 17
      //   86: iconst_2
      //   87: faload
      //   88: ldc 93
      //   90: fdiv
      //   91: fastore
      //   92: aload_0
      //   93: getfield 59	com/d/a/a/u$f:ccc	[[F
      //   96: iconst_1
      //   97: aaload
      //   98: astore 17
      //   100: aload 17
      //   102: iconst_2
      //   103: aload 17
      //   105: iconst_2
      //   106: faload
      //   107: ldc 93
      //   109: fdiv
      //   110: fastore
      //   111: aload_0
      //   112: getfield 59	com/d/a/a/u$f:ccc	[[F
      //   115: iconst_2
      //   116: aaload
      //   117: astore 17
      //   119: aload 17
      //   121: iconst_2
      //   122: aload 17
      //   124: iconst_2
      //   125: faload
      //   126: ldc 93
      //   128: fdiv
      //   129: fastore
      //   130: aload_0
      //   131: getfield 59	com/d/a/a/u$f:ccc	[[F
      //   134: iconst_0
      //   135: aaload
      //   136: iconst_2
      //   137: faload
      //   138: fstore_1
      //   139: aload_0
      //   140: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   143: iconst_0
      //   144: aaload
      //   145: iconst_0
      //   146: faload
      //   147: fstore_2
      //   148: aload_0
      //   149: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   152: iconst_0
      //   153: aaload
      //   154: iconst_2
      //   155: faload
      //   156: fstore_3
      //   157: aload_0
      //   158: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   161: iconst_0
      //   162: aaload
      //   163: iconst_2
      //   164: faload
      //   165: fstore 4
      //   167: aload_0
      //   168: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   171: iconst_0
      //   172: aaload
      //   173: iconst_1
      //   174: faload
      //   175: fstore 5
      //   177: aload_0
      //   178: getfield 59	com/d/a/a/u$f:ccc	[[F
      //   181: iconst_1
      //   182: aaload
      //   183: iconst_2
      //   184: faload
      //   185: fstore 6
      //   187: aload_0
      //   188: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   191: iconst_1
      //   192: aaload
      //   193: iconst_0
      //   194: faload
      //   195: fstore 7
      //   197: aload_0
      //   198: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   201: iconst_1
      //   202: aaload
      //   203: iconst_2
      //   204: faload
      //   205: fstore 8
      //   207: aload_0
      //   208: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   211: iconst_1
      //   212: aaload
      //   213: iconst_2
      //   214: faload
      //   215: fstore 9
      //   217: aload_0
      //   218: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   221: iconst_1
      //   222: aaload
      //   223: iconst_1
      //   224: faload
      //   225: fstore 10
      //   227: aload_0
      //   228: getfield 59	com/d/a/a/u$f:ccc	[[F
      //   231: iconst_2
      //   232: aaload
      //   233: iconst_2
      //   234: faload
      //   235: fstore 11
      //   237: aload_0
      //   238: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   241: iconst_2
      //   242: aaload
      //   243: iconst_0
      //   244: faload
      //   245: fstore 12
      //   247: aload_0
      //   248: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   251: iconst_2
      //   252: aaload
      //   253: iconst_2
      //   254: faload
      //   255: fstore 13
      //   257: aload_0
      //   258: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   261: iconst_2
      //   262: aaload
      //   263: iconst_2
      //   264: faload
      //   265: fstore 14
      //   267: aload_0
      //   268: getfield 57	com/d/a/a/u$f:ccb	[[F
      //   271: iconst_2
      //   272: aaload
      //   273: iconst_1
      //   274: faload
      //   275: fstore 15
      //   277: aload_0
      //   278: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   281: iconst_0
      //   282: aaload
      //   283: iconst_0
      //   284: fload_1
      //   285: ldc 94
      //   287: fmul
      //   288: ldc 95
      //   290: aload_0
      //   291: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   294: iconst_0
      //   295: aaload
      //   296: iconst_0
      //   297: faload
      //   298: fmul
      //   299: fadd
      //   300: fastore
      //   301: aload_0
      //   302: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   305: iconst_0
      //   306: aaload
      //   307: iconst_1
      //   308: fload_2
      //   309: fload_3
      //   310: fsub
      //   311: ldc 94
      //   313: fmul
      //   314: ldc 95
      //   316: aload_0
      //   317: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   320: iconst_0
      //   321: aaload
      //   322: iconst_1
      //   323: faload
      //   324: fmul
      //   325: fadd
      //   326: fastore
      //   327: aload_0
      //   328: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   331: iconst_0
      //   332: aaload
      //   333: iconst_2
      //   334: fload 4
      //   336: fload 5
      //   338: fsub
      //   339: ldc 94
      //   341: fmul
      //   342: ldc 95
      //   344: aload_0
      //   345: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   348: iconst_0
      //   349: aaload
      //   350: iconst_2
      //   351: faload
      //   352: fmul
      //   353: fadd
      //   354: fastore
      //   355: aload_0
      //   356: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   359: iconst_1
      //   360: aaload
      //   361: iconst_0
      //   362: ldc 95
      //   364: aload_0
      //   365: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   368: iconst_1
      //   369: aaload
      //   370: iconst_0
      //   371: faload
      //   372: fmul
      //   373: fload 6
      //   375: ldc 94
      //   377: fmul
      //   378: fadd
      //   379: fastore
      //   380: aload_0
      //   381: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   384: iconst_1
      //   385: aaload
      //   386: iconst_1
      //   387: ldc 95
      //   389: aload_0
      //   390: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   393: iconst_1
      //   394: aaload
      //   395: iconst_1
      //   396: faload
      //   397: fmul
      //   398: ldc 94
      //   400: fload 7
      //   402: fload 8
      //   404: fsub
      //   405: fmul
      //   406: fadd
      //   407: fastore
      //   408: aload_0
      //   409: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   412: iconst_1
      //   413: aaload
      //   414: iconst_2
      //   415: ldc 95
      //   417: aload_0
      //   418: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   421: iconst_1
      //   422: aaload
      //   423: iconst_2
      //   424: faload
      //   425: fmul
      //   426: ldc 94
      //   428: fload 9
      //   430: fload 10
      //   432: fsub
      //   433: fmul
      //   434: fadd
      //   435: fastore
      //   436: aload_0
      //   437: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   440: iconst_2
      //   441: aaload
      //   442: iconst_0
      //   443: ldc 95
      //   445: aload_0
      //   446: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   449: iconst_2
      //   450: aaload
      //   451: iconst_0
      //   452: faload
      //   453: fmul
      //   454: ldc 94
      //   456: fload 11
      //   458: fmul
      //   459: fadd
      //   460: fastore
      //   461: aload_0
      //   462: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   465: iconst_2
      //   466: aaload
      //   467: iconst_1
      //   468: ldc 95
      //   470: aload_0
      //   471: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   474: iconst_2
      //   475: aaload
      //   476: iconst_1
      //   477: faload
      //   478: fmul
      //   479: ldc 94
      //   481: fload 12
      //   483: fload 13
      //   485: fsub
      //   486: fmul
      //   487: fadd
      //   488: fastore
      //   489: aload_0
      //   490: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   493: iconst_2
      //   494: aaload
      //   495: iconst_2
      //   496: ldc 95
      //   498: aload_0
      //   499: getfield 74	com/d/a/a/u$f:ccd	[[F
      //   502: iconst_2
      //   503: aaload
      //   504: iconst_2
      //   505: faload
      //   506: fmul
      //   507: ldc 94
      //   509: fload 14
      //   511: fload 15
      //   513: fsub
      //   514: fmul
      //   515: fadd
      //   516: fastore
      //   517: aload_0
      //   518: aload_0
      //   519: invokespecial 99	com/d/a/a/u$f:AF	()Lcom/d/a/a/u$f$a;
      //   522: invokespecial 102	com/d/a/a/u$f:a	(Lcom/d/a/a/u$f$a;)V
      //   525: aload_0
      //   526: iconst_0
      //   527: putfield 51	com/d/a/a/u$f:cca	I
      //   530: iconst_3
      //   531: newarray float
      //   533: dup
      //   534: iconst_0
      //   535: ldc 54
      //   537: fastore
      //   538: dup
      //   539: iconst_1
      //   540: ldc 55
      //   542: fastore
      //   543: dup
      //   544: iconst_2
      //   545: fconst_0
      //   546: fastore
      //   547: astore 17
      //   549: iconst_3
      //   550: newarray float
      //   552: dup
      //   553: iconst_0
      //   554: ldc 54
      //   556: fastore
      //   557: dup
      //   558: iconst_1
      //   559: ldc 55
      //   561: fastore
      //   562: dup
      //   563: iconst_2
      //   564: fconst_0
      //   565: fastore
      //   566: astore 18
      //   568: aload_0
      //   569: iconst_3
      //   570: anewarray 53	[F
      //   573: dup
      //   574: iconst_0
      //   575: iconst_3
      //   576: newarray float
      //   578: dup
      //   579: iconst_0
      //   580: ldc 54
      //   582: fastore
      //   583: dup
      //   584: iconst_1
      //   585: ldc 55
      //   587: fastore
      //   588: dup
      //   589: iconst_2
      //   590: fconst_0
      //   591: fastore
      //   592: aastore
      //   593: dup
      //   594: iconst_1
      //   595: aload 17
      //   597: aastore
      //   598: dup
      //   599: iconst_2
      //   600: aload 18
      //   602: aastore
      //   603: putfield 57	com/d/a/a/u$f:ccb	[[F
      //   606: iconst_3
      //   607: newarray float
      //   609: dup
      //   610: iconst_0
      //   611: ldc 54
      //   613: fastore
      //   614: dup
      //   615: iconst_1
      //   616: ldc 55
      //   618: fastore
      //   619: dup
      //   620: iconst_2
      //   621: fconst_0
      //   622: fastore
      //   623: astore 17
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
      //   642: astore 18
      //   644: aload_0
      //   645: iconst_3
      //   646: anewarray 53	[F
      //   649: dup
      //   650: iconst_0
      //   651: aload 17
      //   653: aastore
      //   654: dup
      //   655: iconst_1
      //   656: iconst_3
      //   657: newarray float
      //   659: dup
      //   660: iconst_0
      //   661: ldc 54
      //   663: fastore
      //   664: dup
      //   665: iconst_1
      //   666: ldc 55
      //   668: fastore
      //   669: dup
      //   670: iconst_2
      //   671: fconst_0
      //   672: fastore
      //   673: aastore
      //   674: dup
      //   675: iconst_2
      //   676: aload 18
      //   678: aastore
      //   679: putfield 59	com/d/a/a/u$f:ccc	[[F
      //   682: aload_0
      //   683: getfield 47	com/d/a/a/u$f:cbY	Ljava/util/ArrayList;
      //   686: invokevirtual 106	java/util/ArrayList:size	()I
      //   689: bipush 100
      //   691: if_icmplt +25 -> 716
      //   694: aload_0
      //   695: getfield 47	com/d/a/a/u$f:cbY	Ljava/util/ArrayList;
      //   698: iconst_0
      //   699: bipush 20
      //   701: invokevirtual 110	java/util/ArrayList:subList	(II)Ljava/util/List;
      //   704: invokeinterface 115 1 0
      //   709: aload_0
      //   710: getfield 47	com/d/a/a/u$f:cbY	Ljava/util/ArrayList;
      //   713: invokevirtual 118	java/util/ArrayList:trimToSize	()V
      //   716: iconst_1
      //   717: istore 16
      //   719: ldc 92
      //   721: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   724: aload_0
      //   725: monitorexit
      //   726: iload 16
      //   728: ireturn
      //   729: iconst_0
      //   730: istore 16
      //   732: ldc 92
      //   734: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   737: goto -13 -> 724
      //   740: astore 17
      //   742: aload_0
      //   743: monitorexit
      //   744: aload 17
      //   746: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	747	0	this	f
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
      //   717	14	16	bool	boolean
      //   22	630	17	arrayOfFloat1	float[]
      //   740	5	17	localObject	Object
      //   566	111	18	arrayOfFloat2	float[]
      // Exception table:
      //   from	to	target	type
      //   2	716	740	finally
      //   719	724	740	finally
      //   732	737	740	finally
    }
    
    private a AF()
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
          if (this.cch == 0)
          {
            i2 = 1;
            if (i2 == 0) {
              continue;
            }
            if (Math.abs(this.ccd[2][0]) < 9.300000000000001D)
            {
              i = 5;
              this.ccf = i;
              this.cce = new int[6];
              j = 0;
              if ((this.ccg >= 0) && (this.ccg <= 5)) {
                this.ccf = this.ccg;
              }
              localObject3 = new a((byte)0);
              locala = new a((byte)0);
              if (this.cbZ[0] != null)
              {
                ((a)localObject3).ccm = this.cbZ[0].ccm;
                ((a)localObject3).ccj = this.cbZ[0].ccj;
              }
              if (this.cbZ[4] != null)
              {
                locala.ccm = this.cbZ[4].ccm;
                locala.ccj = this.cbZ[4].ccj;
              }
              if (!this.cbY.isEmpty())
              {
                k = this.cbY.size();
                localObject5 = new float[6];
                localObject6 = new float[6];
                localObject7 = this.cbY.iterator();
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
                localObject5 = this.cbY.iterator();
                f2 = f4;
                f8 = 0.0F;
                f9 = 0.0F;
                i = 0;
                if (((Iterator)localObject5).hasNext()) {
                  break;
                }
                if (((a)localObject3).cci > 0)
                {
                  if (j != 0) {
                    break label1716;
                  }
                  f1 = 0.0F;
                  f2 = localObject1 / ((a)localObject3).cci;
                  f3 = ((a)localObject3).ccj;
                  f2 = f1 + ((f2 - f11) / 15.0F + 0.537F);
                  f1 = f2;
                  if (f3 != 0.0F) {
                    f1 = f2 * 0.67F + 0.33F * f3;
                  }
                  ((a)localObject3).ccj = f1;
                  ((a)localObject3).x *= ((a)localObject3).ccj;
                  ((a)localObject3).y *= ((a)localObject3).ccj;
                  ((a)localObject3).cck = (((a)localObject3).cci * ((a)localObject3).ccj);
                }
              }
              ((a)localObject3).ccl = (((a)localObject3).cck / (this.cbY.size() / 20));
              if (this.cbZ[0] != null)
              {
                ((a)localObject3).x += this.cbZ[0].x;
                ((a)localObject3).y += this.cbZ[0].y;
                ((a)localObject3).z += this.cbZ[0].z;
                ((a)localObject3).cci += this.cbZ[0].cci;
                ((a)localObject3).cck += this.cbZ[0].cck;
              }
              if ((this.cbZ[4] != null) && (locala.cci > 0))
              {
                this.cbZ[4].x = ((this.cbZ[4].x + ((a)localObject3).x + locala.x * ((a)localObject3).ccj) / 2.0F);
                this.cbZ[4].y = ((this.cbZ[4].y + ((a)localObject3).y + locala.y * ((a)localObject3).ccj) / 2.0F);
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
          if (Math.abs(this.ccd[0][0]) < 7.0F) {
            break label1764;
          }
          if (this.ccd[1][1] >= 2.3F) {
            break label1758;
          }
          if (this.ccd[1][2] < 2.3F) {
            break label1764;
          }
          break label1758;
          if (i != 0)
          {
            this.ccf = 2;
            this.cce = new int[6];
            j = i;
            continue;
          }
          f1 = Math.abs(this.ccd[0][0]);
          f2 = Math.abs(this.ccd[1][0]);
          f3 = Math.abs(this.ccd[2][0]);
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
          Object localObject3 = this.cce;
          localObject3[j] += 1;
          j = 0;
          break label1784;
          f2 = f1;
          if (this.ccd[k][n] <= f1) {
            break label1885;
          }
          f2 = this.ccd[k][n];
          m = n;
          i1 = k;
          break label1885;
          if ((j == this.ccf) || (this.cce[j] <= this.cce[this.ccf])) {
            break label1897;
          }
          this.ccf = j;
          break label1897;
          u.b localb = (u.b)((Iterator)localObject7).next();
          if (j == 0)
          {
            f3 = localb.cbx;
            f3 = f2 + f3;
            if (j == 0)
            {
              f2 = localb.cbF;
              break label1906;
              label1084:
              f1 = f4;
              f2 = f3;
              if (i > 5) {
                continue;
              }
              localObject5[i] += localb.cbJ[i];
              localObject6[i] += localb.cbK[i];
              i += 1;
              continue;
            }
          }
          else
          {
            f3 = localb.cbA;
            continue;
          }
          f2 = (float)Math.sqrt(localb.cby * localb.cby + localb.cbz * localb.cbz + localb.cbA * localb.cbA);
          localb.cbE = f2;
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
      for (float f3 = ((u.b)localObject6).cbx;; f3 = ((u.b)localObject6).cbE)
      {
        if (j != 0) {
          break label1328;
        }
        f5 = ((u.b)localObject6).cbF;
        break label1918;
        if (i > 0) {
          break label1338;
        }
        if (f3 > localObject2) {
          break label1937;
        }
        f9 = localObject6.cbJ[this.ccf];
        f8 = localObject6.cbK[this.ccf];
        break;
      }
      label1328:
      float f5 = ((u.b)localObject6).cbE;
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
              if (localObject4.ccm == 0L) {
                break label1990;
              }
              i = k;
              if (((u.b)localObject6).time - localObject4.ccm >= 250L) {
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
          localObject4.cci += 1;
          localObject1 += f10;
          f3 = localObject6.cbJ[this.ccf];
          f5 = localObject6.cbK[this.ccf];
          f5 = (float)Math.atan2(f3 + f9, f5 + f8);
          f8 = Math.abs(f5 - localObject7[this.ccf]);
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
          if (((u.b)localObject6).time - locala.ccm > 250L)
          {
            locala.x -= f8;
            locala.y -= f5;
            locala.cci += 1;
            f3 = f7;
          }
          localObject4.ccm = ((u.b)localObject6).time;
          f9 = localObject6.cbJ[this.ccf];
          f8 = localObject6.cbK[this.ccf];
          i = 0;
          f7 = f3;
          break;
          label1704:
          f5 = localObject7[this.ccf];
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
    
    /* Error */
    private void a(a parama)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 231
      //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 49	com/d/a/a/u$f:cbZ	[Lcom/d/a/a/u$f$a;
      //   11: iconst_1
      //   12: aload_0
      //   13: getfield 49	com/d/a/a/u$f:cbZ	[Lcom/d/a/a/u$f$a;
      //   16: iconst_0
      //   17: iconst_4
      //   18: invokestatic 237	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   21: aload_0
      //   22: getfield 49	com/d/a/a/u$f:cbZ	[Lcom/d/a/a/u$f$a;
      //   25: iconst_4
      //   26: aaload
      //   27: ifnull +143 -> 170
      //   30: invokestatic 243	android/os/SystemClock:elapsedRealtime	()J
      //   33: aload_1
      //   34: getfield 134	com/d/a/a/u$f$a:ccm	J
      //   37: lsub
      //   38: ldc2_w 244
      //   41: lcmp
      //   42: ifle +128 -> 170
      //   45: aload_0
      //   46: getfield 49	com/d/a/a/u$f:cbZ	[Lcom/d/a/a/u$f$a;
      //   49: iconst_4
      //   50: aaload
      //   51: astore_2
      //   52: aload_2
      //   53: aload_2
      //   54: getfield 163	com/d/a/a/u$f$a:x	F
      //   57: aload_1
      //   58: getfield 163	com/d/a/a/u$f$a:x	F
      //   61: fadd
      //   62: fconst_2
      //   63: fdiv
      //   64: putfield 163	com/d/a/a/u$f$a:x	F
      //   67: aload_2
      //   68: aload_2
      //   69: getfield 166	com/d/a/a/u$f$a:y	F
      //   72: aload_1
      //   73: getfield 166	com/d/a/a/u$f$a:y	F
      //   76: fadd
      //   77: fconst_2
      //   78: fdiv
      //   79: putfield 166	com/d/a/a/u$f$a:y	F
      //   82: aload_2
      //   83: aload_2
      //   84: getfield 175	com/d/a/a/u$f$a:z	F
      //   87: aload_1
      //   88: getfield 175	com/d/a/a/u$f$a:z	F
      //   91: fadd
      //   92: fconst_2
      //   93: fdiv
      //   94: putfield 175	com/d/a/a/u$f$a:z	F
      //   97: aload_2
      //   98: aload_2
      //   99: getfield 157	com/d/a/a/u$f$a:cci	I
      //   102: aload_1
      //   103: getfield 157	com/d/a/a/u$f$a:cci	I
      //   106: iadd
      //   107: i2f
      //   108: fconst_2
      //   109: fdiv
      //   110: invokestatic 249	java/lang/Math:round	(F)I
      //   113: putfield 157	com/d/a/a/u$f$a:cci	I
      //   116: aload_2
      //   117: aload_2
      //   118: getfield 138	com/d/a/a/u$f$a:ccj	F
      //   121: aload_1
      //   122: getfield 138	com/d/a/a/u$f$a:ccj	F
      //   125: fadd
      //   126: fconst_2
      //   127: fdiv
      //   128: putfield 138	com/d/a/a/u$f$a:ccj	F
      //   131: aload_2
      //   132: aload_2
      //   133: getfield 169	com/d/a/a/u$f$a:cck	F
      //   136: aload_1
      //   137: getfield 169	com/d/a/a/u$f$a:cck	F
      //   140: fadd
      //   141: fconst_2
      //   142: fdiv
      //   143: putfield 169	com/d/a/a/u$f$a:cck	F
      //   146: aload_2
      //   147: aload_1
      //   148: getfield 134	com/d/a/a/u$f$a:ccm	J
      //   151: putfield 134	com/d/a/a/u$f$a:ccm	J
      //   154: aload_2
      //   155: aload_1
      //   156: getfield 172	com/d/a/a/u$f$a:ccl	F
      //   159: putfield 172	com/d/a/a/u$f$a:ccl	F
      //   162: ldc 231
      //   164: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   167: aload_0
      //   168: monitorexit
      //   169: return
      //   170: aload_0
      //   171: getfield 49	com/d/a/a/u$f:cbZ	[Lcom/d/a/a/u$f$a;
      //   174: iconst_4
      //   175: aload_1
      //   176: aastore
      //   177: ldc 231
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
    final a AG()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 251
      //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 49	com/d/a/a/u$f:cbZ	[Lcom/d/a/a/u$f$a;
      //   11: iconst_4
      //   12: aaload
      //   13: ifnull +22 -> 35
      //   16: aload_0
      //   17: getfield 49	com/d/a/a/u$f:cbZ	[Lcom/d/a/a/u$f$a;
      //   20: iconst_4
      //   21: aaload
      //   22: invokevirtual 254	com/d/a/a/u$f$a:AH	()Lcom/d/a/a/u$f$a;
      //   25: astore_1
      //   26: ldc 251
      //   28: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   31: aload_0
      //   32: monitorexit
      //   33: aload_1
      //   34: areturn
      //   35: aconst_null
      //   36: astore_1
      //   37: ldc 251
      //   39: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: goto -11 -> 31
      //   45: astore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_1
      //   49: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	this	f
      //   25	12	1	locala	a
      //   45	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	31	45	finally
      //   37	42	45	finally
    }
    
    final void a(u.b paramb)
    {
      try
      {
        AppMethodBeat.i(87984);
        if ((this.cch > 0) && (this.cch < 101)) {
          this.cch -= 1;
        }
        this.cbY.add(paramb);
        this.cca += 1;
        if (paramb.cby > this.ccb[0][0]) {
          this.ccb[0][0] = paramb.cby;
        }
        if (paramb.cby < this.ccb[0][1]) {
          this.ccb[0][1] = paramb.cby;
        }
        float[] arrayOfFloat = this.ccb[0];
        arrayOfFloat[2] += paramb.cby;
        if (paramb.cbz > this.ccb[1][0]) {
          this.ccb[1][0] = paramb.cbz;
        }
        if (paramb.cbz < this.ccb[1][1]) {
          this.ccb[1][1] = paramb.cbz;
        }
        arrayOfFloat = this.ccb[1];
        arrayOfFloat[2] += paramb.cbz;
        if (paramb.cbA > this.ccb[2][0]) {
          this.ccb[2][0] = paramb.cbA;
        }
        if (paramb.cbA < this.ccb[2][1]) {
          this.ccb[2][1] = paramb.cbA;
        }
        arrayOfFloat = this.ccb[2];
        arrayOfFloat[2] += paramb.cbA;
        if (paramb.cbB > this.ccc[0][0]) {
          this.ccc[0][0] = paramb.cbB;
        }
        if (paramb.cbB < this.ccc[0][1]) {
          this.ccc[0][1] = paramb.cbB;
        }
        arrayOfFloat = this.ccc[0];
        arrayOfFloat[2] += paramb.cbB;
        if (paramb.cbC > this.ccc[1][0]) {
          this.ccc[1][0] = paramb.cbC;
        }
        if (paramb.cbC < this.ccc[1][1]) {
          this.ccc[1][1] = paramb.cbC;
        }
        arrayOfFloat = this.ccc[1];
        arrayOfFloat[2] += paramb.cbC;
        if (paramb.cbD > this.ccc[2][0]) {
          this.ccc[2][0] = paramb.cbD;
        }
        if (paramb.cbD < this.ccc[2][1]) {
          this.ccc[2][1] = paramb.cbD;
        }
        arrayOfFloat = this.ccc[2];
        arrayOfFloat[2] += paramb.cbD;
        if (AE()) {
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
        this.cbY.clear();
        this.cbZ = new a[5];
        this.cca = 0;
        this.ccb = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
        this.ccc = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
        this.ccd = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
        this.cce = new int[6];
        this.ccf = 5;
        AppMethodBeat.o(87980);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final class a
    {
      int cci = 0;
      float ccj = 0.0F;
      float cck = 0.0F;
      float ccl = 0.0F;
      long ccm = 0L;
      float x = 0.0F;
      float y = 0.0F;
      float z = 0.0F;
      
      private a() {}
      
      protected final a AH()
      {
        AppMethodBeat.i(87977);
        a locala = new a(u.f.this);
        locala.x = this.x;
        locala.y = this.y;
        locala.z = this.z;
        locala.cci = this.cci;
        locala.ccj = this.ccj;
        locala.cck = this.cck;
        locala.ccm = this.ccm;
        locala.ccl = this.ccl;
        AppMethodBeat.o(87977);
        return locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.u
 * JD-Core Version:    0.7.0.1
 */