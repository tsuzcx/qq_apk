package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.xlabeffect.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.xeffect.FaceTracker;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.p;
import org.json.JSONObject;

public final class a
{
  static a oQt;
  private float aCa;
  private float aCb;
  h oQu;
  FaceTracker oQv;
  ExecutorService oQw;
  ArrayList<HashMap<String, Object>> oQx;
  
  public a()
  {
    AppMethodBeat.i(282984);
    this.oQw = Executors.newSingleThreadExecutor();
    this.aCa = -1.0F;
    this.aCb = -1.0F;
    this.oQx = new ArrayList();
    AppMethodBeat.o(282984);
  }
  
  public static int a(c paramc)
  {
    AppMethodBeat.i(282986);
    switch (1.oQy[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(282986);
      return -1;
    case 1: 
      AppMethodBeat.o(282986);
      return 0;
    case 2: 
      AppMethodBeat.o(282986);
      return 1;
    case 3: 
      AppMethodBeat.o(282986);
      return 2;
    case 4: 
      AppMethodBeat.o(282986);
      return 3;
    case 5: 
      AppMethodBeat.o(282986);
      return 4;
    case 6: 
      AppMethodBeat.o(282986);
      return 5;
    case 7: 
      AppMethodBeat.o(282986);
      return 6;
    }
    AppMethodBeat.o(282986);
    return 7;
  }
  
  public static a bRV()
  {
    try
    {
      AppMethodBeat.i(282985);
      if (oQt == null) {
        oQt = new a();
      }
      a locala = oQt;
      AppMethodBeat.o(282985);
      return locala;
    }
    finally {}
  }
  
  public final HashMap<String, Object> a(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(282987);
    HashMap localHashMap2 = new HashMap();
    if ((oQt == null) || (oQt.oQv == null))
    {
      localHashMap2.put("errCode", Integer.valueOf(a(c.oQG)));
      AppMethodBeat.o(282987);
      return localHashMap2;
    }
    if (!paramByteBuffer.isDirect())
    {
      paramByteBuffer = z.n(paramByteBuffer).order(ByteOrder.nativeOrder());
      paramByteBuffer.position(0);
    }
    for (;;)
    {
      Object localObject1 = oQt.oQv;
      p.k(paramByteBuffer, "data");
      List localList2;
      if (((FaceTracker)localObject1).NmO != 0L)
      {
        paramInt1 = ((FaceTracker)localObject1).nDetect(((FaceTracker)localObject1).NmO, paramByteBuffer, paramInt1, paramInt2);
        localList2 = oQt.oQv.ijT();
        if ((paramInt1 != 0) || (localList2.size() <= 0)) {
          break label665;
        }
        localHashMap2.put("errCode", Integer.valueOf(a(c.oQF)));
        this.oQx.clear();
        if (!paramJSONObject.optBoolean("enablePoint")) {
          break label728;
        }
      }
      label648:
      label665:
      label728:
      for (paramByteBuffer = oQt.oQv.ijU();; paramByteBuffer = null)
      {
        if (paramJSONObject.optBoolean("enableConf")) {}
        for (localObject1 = oQt.oQv.ijV();; localObject1 = null)
        {
          if (paramJSONObject.optBoolean("enableAngle")) {}
          for (List localList1 = oQt.oQv.ijS();; localList1 = null)
          {
            paramInt1 = 0;
            Object localObject2;
            if (paramInt1 < localList2.size())
            {
              d locald = new d((RectF)localList2.get(paramInt1));
              Object localObject3 = null;
              localObject2 = localObject3;
              if (paramJSONObject.optBoolean("enablePoint"))
              {
                localObject2 = localObject3;
                if (!Util.isNullOrNil(paramByteBuffer))
                {
                  localObject2 = localObject3;
                  if (paramByteBuffer.size() > paramInt1)
                  {
                    localObject4 = (PointF[])paramByteBuffer.get(paramInt1);
                    localObject2 = localObject3;
                    if (localObject4 != null)
                    {
                      localObject3 = new ArrayList(localObject4.length);
                      int i = localObject4.length;
                      paramInt2 = 0;
                      for (;;)
                      {
                        localObject2 = localObject3;
                        if (paramInt2 >= i) {
                          break;
                        }
                        localObject2 = localObject4[paramInt2];
                        localHashMap1 = new HashMap(2);
                        localHashMap1.put("x", Float.valueOf(((PointF)localObject2).x));
                        localHashMap1.put("y", Float.valueOf(((PointF)localObject2).y));
                        ((ArrayList)localObject3).add(localHashMap1);
                        paramInt2 += 1;
                      }
                      paramInt1 = -1;
                      break;
                    }
                  }
                }
              }
              Object localObject4 = null;
              localObject3 = localObject4;
              if (paramJSONObject.optBoolean("enableConf"))
              {
                localObject3 = localObject4;
                if (!Util.isNullOrNil((List)localObject1))
                {
                  localObject3 = localObject4;
                  if (((List)localObject1).size() > paramInt1) {
                    localObject3 = new b((float[])((List)localObject1).get(paramInt1));
                  }
                }
              }
              HashMap localHashMap1 = null;
              localObject4 = localHashMap1;
              if (paramJSONObject.optBoolean("enableAngle"))
              {
                localObject4 = localHashMap1;
                if (!Util.isNullOrNil(localList1))
                {
                  localObject4 = localHashMap1;
                  if (localList1.size() > paramInt1) {
                    localObject4 = new a((com.tencent.mm.xeffect.a)localList1.get(paramInt1));
                  }
                }
              }
              localObject2 = new e(((RectF)localList2.get(paramInt1)).centerX(), ((RectF)localList2.get(paramInt1)).centerY(), locald, (ArrayList)localObject2, (b)localObject3, (a)localObject4).bRW();
              if (paramJSONObject.optBoolean("enableMultiFace")) {
                break label648;
              }
              localHashMap2.putAll((Map)localObject2);
            }
            if (paramJSONObject.optBoolean("enableMultiFace")) {
              localHashMap2.put("faceInfo", this.oQx);
            }
            for (;;)
            {
              AppMethodBeat.o(282987);
              return localHashMap2;
              this.oQx.add(localObject2);
              paramInt1 += 1;
              break;
              localHashMap2.putAll(new e(-1.0F, -1.0F, new d(), null, null, null).bRW());
              localHashMap2.put("errCode", Integer.valueOf(a(c.oQK)));
            }
          }
        }
      }
    }
  }
  
  final class a
  {
    float pitch = 0.0F;
    float roll = 0.0F;
    float yaw = 0.0F;
    
    public a(com.tencent.mm.xeffect.a parama)
    {
      this.pitch = parama.pitch;
      this.roll = parama.roll;
      this.yaw = parama.yaw;
    }
    
    public final HashMap<String, Float> bRW()
    {
      AppMethodBeat.i(282399);
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("pitch", Float.valueOf(this.pitch));
      localHashMap.put("roll", Float.valueOf(this.roll));
      localHashMap.put("yaw", Float.valueOf(this.yaw));
      AppMethodBeat.o(282399);
      return localHashMap;
    }
  }
  
  final class b
  {
    float oQA;
    float oQB;
    float oQC;
    float oQD;
    float oQE;
    
    public b(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(283328);
      this.oQA = 0.0F;
      this.oQB = 0.0F;
      this.oQC = 0.0F;
      this.oQD = 0.0F;
      this.oQE = 0.0F;
      if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length != 5))
      {
        AppMethodBeat.o(283328);
        return;
      }
      this.oQA = paramArrayOfFloat[0];
      this.oQB = paramArrayOfFloat[1];
      this.oQC = paramArrayOfFloat[2];
      this.oQD = paramArrayOfFloat[3];
      this.oQE = paramArrayOfFloat[4];
      AppMethodBeat.o(283328);
    }
    
    public final HashMap<String, Float> bRW()
    {
      AppMethodBeat.i(283329);
      HashMap localHashMap = new HashMap(5);
      localHashMap.put("global", Float.valueOf(this.oQA));
      localHashMap.put("leftEye", Float.valueOf(this.oQB));
      localHashMap.put("rightEye", Float.valueOf(this.oQC));
      localHashMap.put("mouth", Float.valueOf(this.oQD));
      localHashMap.put("nose", Float.valueOf(this.oQE));
      AppMethodBeat.o(283329);
      return localHashMap;
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(280309);
      oQF = new c("ResultOK", 0);
      oQG = new c("ResultNotInit", 1);
      oQH = new c("ResultInited", 2);
      oQI = new c("ResultInitFail", 3);
      oQJ = new c("ResultNoLicense", 4);
      oQK = new c("ResultFaceDetectedFail", 5);
      oQL = new c("ResultStopFail", 6);
      oQM = new c("ResultUndefinedError", 7);
      oQN = new c[] { oQF, oQG, oQH, oQI, oQJ, oQK, oQL, oQM };
      AppMethodBeat.o(280309);
    }
    
    private c() {}
  }
  
  final class d
  {
    float mHeight;
    float mWidth;
    float oQO;
    float oQP;
    
    public d()
    {
      this.oQO = -1.0F;
      this.oQP = -1.0F;
      this.mWidth = 0.0F;
      this.mHeight = 0.0F;
    }
    
    public d(RectF paramRectF)
    {
      AppMethodBeat.i(271909);
      this.oQO = (paramRectF.centerX() - paramRectF.width() / 2.0F);
      this.oQP = (paramRectF.centerY() - paramRectF.height() / 2.0F);
      this.mWidth = paramRectF.width();
      this.mHeight = paramRectF.height();
      AppMethodBeat.o(271909);
    }
    
    public final HashMap<String, Float> bRW()
    {
      AppMethodBeat.i(271913);
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("originX", Float.valueOf(this.oQO));
      localHashMap.put("originY", Float.valueOf(this.oQP));
      localHashMap.put("width", Float.valueOf(this.mWidth));
      localHashMap.put("height", Float.valueOf(this.mHeight));
      AppMethodBeat.o(271913);
      return localHashMap;
    }
  }
  
  public final class e
  {
    ArrayList<HashMap<String, Float>> oQQ = null;
    a.d oQR = null;
    a.b oQS = null;
    a.a oQT = null;
    float x = -1.0F;
    float y = -1.0F;
    
    public e(float paramFloat, a.d paramd, ArrayList<HashMap<String, Float>> paramArrayList, a.b paramb, a.a parama)
    {
      this.x = paramFloat;
      this.y = paramd;
      this.oQQ = paramb;
      this.oQR = paramArrayList;
      this.oQS = parama;
      Object localObject;
      this.oQT = localObject;
    }
    
    public final HashMap<String, Object> bRW()
    {
      AppMethodBeat.i(273487);
      HashMap localHashMap = new HashMap();
      localHashMap.put("x", Float.valueOf(this.x));
      localHashMap.put("y", Float.valueOf(this.y));
      if (this.oQR != null) {
        localHashMap.put("detectRect", this.oQR.bRW());
      }
      if (this.oQQ != null) {
        localHashMap.put("pointArray", this.oQQ);
      }
      if (this.oQS != null) {
        localHashMap.put("confArray", this.oQS.bRW());
      }
      if (this.oQT != null) {
        localHashMap.put("angleArray", this.oQT.bRW());
      }
      AppMethodBeat.o(273487);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.a
 * JD-Core Version:    0.7.0.1
 */