package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.plugin.xlabeffect.d;
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
import kotlin.g.b.s;
import org.json.JSONObject;

public final class a
{
  static a rWa;
  private float cxM;
  private float cxN;
  d rWb;
  FaceTracker rWc;
  ExecutorService rWd;
  ArrayList<HashMap<String, Object>> rWe;
  
  public a()
  {
    AppMethodBeat.i(326550);
    this.rWd = Executors.newSingleThreadExecutor();
    this.cxM = -1.0F;
    this.cxN = -1.0F;
    this.rWe = new ArrayList();
    AppMethodBeat.o(326550);
  }
  
  public static int a(c paramc)
  {
    AppMethodBeat.i(326558);
    switch (1.rWf[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(326558);
      return -1;
    case 1: 
      AppMethodBeat.o(326558);
      return 0;
    case 2: 
      AppMethodBeat.o(326558);
      return 1;
    case 3: 
      AppMethodBeat.o(326558);
      return 2;
    case 4: 
      AppMethodBeat.o(326558);
      return 3;
    case 5: 
      AppMethodBeat.o(326558);
      return 4;
    case 6: 
      AppMethodBeat.o(326558);
      return 5;
    case 7: 
      AppMethodBeat.o(326558);
      return 6;
    }
    AppMethodBeat.o(326558);
    return 7;
  }
  
  public static a crZ()
  {
    try
    {
      AppMethodBeat.i(326553);
      if (rWa == null) {
        rWa = new a();
      }
      a locala = rWa;
      AppMethodBeat.o(326553);
      return locala;
    }
    finally {}
  }
  
  public final HashMap<String, Object> a(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(326562);
    HashMap localHashMap2 = new HashMap();
    if ((rWa == null) || (rWa.rWc == null))
    {
      localHashMap2.put("errCode", Integer.valueOf(a(c.rWn)));
      AppMethodBeat.o(326562);
      return localHashMap2;
    }
    if (!paramByteBuffer.isDirect())
    {
      paramByteBuffer = ae.t(paramByteBuffer).order(ByteOrder.nativeOrder());
      paramByteBuffer.position(0);
    }
    for (;;)
    {
      Object localObject1 = rWa.rWc;
      s.t(paramByteBuffer, "data");
      List localList2;
      if (((FaceTracker)localObject1).nNg != 0L)
      {
        paramInt1 = ((FaceTracker)localObject1).nDetect(((FaceTracker)localObject1).nNg, paramByteBuffer, paramInt1, paramInt2);
        localList2 = rWa.rWc.jQb();
        if ((paramInt1 != 0) || (localList2.size() <= 0)) {
          break label665;
        }
        localHashMap2.put("errCode", Integer.valueOf(a(c.rWm)));
        this.rWe.clear();
        if (!paramJSONObject.optBoolean("enablePoint")) {
          break label728;
        }
      }
      label648:
      label665:
      label728:
      for (paramByteBuffer = rWa.rWc.jQc();; paramByteBuffer = null)
      {
        if (paramJSONObject.optBoolean("enableConf")) {}
        for (localObject1 = rWa.rWc.jQd();; localObject1 = null)
        {
          if (paramJSONObject.optBoolean("enableAngle")) {}
          for (List localList1 = rWa.rWc.jQa();; localList1 = null)
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
              localObject2 = new e(((RectF)localList2.get(paramInt1)).centerX(), ((RectF)localList2.get(paramInt1)).centerY(), locald, (ArrayList)localObject2, (b)localObject3, (a)localObject4).csa();
              if (paramJSONObject.optBoolean("enableMultiFace")) {
                break label648;
              }
              localHashMap2.putAll((Map)localObject2);
            }
            if (paramJSONObject.optBoolean("enableMultiFace")) {
              localHashMap2.put("faceInfo", this.rWe);
            }
            for (;;)
            {
              AppMethodBeat.o(326562);
              return localHashMap2;
              this.rWe.add(localObject2);
              paramInt1 += 1;
              break;
              localHashMap2.putAll(new e(-1.0F, -1.0F, new d(), null, null, null).csa());
              localHashMap2.put("errCode", Integer.valueOf(a(c.rWr)));
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
    
    public final HashMap<String, Float> csa()
    {
      AppMethodBeat.i(326546);
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("pitch", Float.valueOf(this.pitch));
      localHashMap.put("roll", Float.valueOf(this.roll));
      localHashMap.put("yaw", Float.valueOf(this.yaw));
      AppMethodBeat.o(326546);
      return localHashMap;
    }
  }
  
  final class b
  {
    float rWh;
    float rWi;
    float rWj;
    float rWk;
    float rWl;
    
    public b(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(326538);
      this.rWh = 0.0F;
      this.rWi = 0.0F;
      this.rWj = 0.0F;
      this.rWk = 0.0F;
      this.rWl = 0.0F;
      if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length != 5))
      {
        AppMethodBeat.o(326538);
        return;
      }
      this.rWh = paramArrayOfFloat[0];
      this.rWi = paramArrayOfFloat[1];
      this.rWj = paramArrayOfFloat[2];
      this.rWk = paramArrayOfFloat[3];
      this.rWl = paramArrayOfFloat[4];
      AppMethodBeat.o(326538);
    }
    
    public final HashMap<String, Float> csa()
    {
      AppMethodBeat.i(326543);
      HashMap localHashMap = new HashMap(5);
      localHashMap.put("global", Float.valueOf(this.rWh));
      localHashMap.put("leftEye", Float.valueOf(this.rWi));
      localHashMap.put("rightEye", Float.valueOf(this.rWj));
      localHashMap.put("mouth", Float.valueOf(this.rWk));
      localHashMap.put("nose", Float.valueOf(this.rWl));
      AppMethodBeat.o(326543);
      return localHashMap;
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(326556);
      rWm = new c("ResultOK", 0);
      rWn = new c("ResultNotInit", 1);
      rWo = new c("ResultInited", 2);
      rWp = new c("ResultInitFail", 3);
      rWq = new c("ResultNoLicense", 4);
      rWr = new c("ResultFaceDetectedFail", 5);
      rWs = new c("ResultStopFail", 6);
      rWt = new c("ResultUndefinedError", 7);
      rWu = new c[] { rWm, rWn, rWo, rWp, rWq, rWr, rWs, rWt };
      AppMethodBeat.o(326556);
    }
    
    private c() {}
  }
  
  final class d
  {
    float mHeight;
    float mWidth;
    float rWv;
    float rWw;
    
    public d()
    {
      this.rWv = -1.0F;
      this.rWw = -1.0F;
      this.mWidth = 0.0F;
      this.mHeight = 0.0F;
    }
    
    public d(RectF paramRectF)
    {
      AppMethodBeat.i(326539);
      this.rWv = (paramRectF.centerX() - paramRectF.width() / 2.0F);
      this.rWw = (paramRectF.centerY() - paramRectF.height() / 2.0F);
      this.mWidth = paramRectF.width();
      this.mHeight = paramRectF.height();
      AppMethodBeat.o(326539);
    }
    
    public final HashMap<String, Float> csa()
    {
      AppMethodBeat.i(326552);
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("originX", Float.valueOf(this.rWv));
      localHashMap.put("originY", Float.valueOf(this.rWw));
      localHashMap.put("width", Float.valueOf(this.mWidth));
      localHashMap.put("height", Float.valueOf(this.mHeight));
      AppMethodBeat.o(326552);
      return localHashMap;
    }
  }
  
  public final class e
  {
    a.a rWA = null;
    ArrayList<HashMap<String, Float>> rWx = null;
    a.d rWy = null;
    a.b rWz = null;
    float x = -1.0F;
    float y = -1.0F;
    
    public e(float paramFloat, a.d paramd, ArrayList<HashMap<String, Float>> paramArrayList, a.b paramb, a.a parama)
    {
      this.x = paramFloat;
      this.y = paramd;
      this.rWx = paramb;
      this.rWy = paramArrayList;
      this.rWz = parama;
      Object localObject;
      this.rWA = localObject;
    }
    
    public final HashMap<String, Object> csa()
    {
      AppMethodBeat.i(326548);
      HashMap localHashMap = new HashMap();
      localHashMap.put("x", Float.valueOf(this.x));
      localHashMap.put("y", Float.valueOf(this.y));
      if (this.rWy != null) {
        localHashMap.put("detectRect", this.rWy.csa());
      }
      if (this.rWx != null) {
        localHashMap.put("pointArray", this.rWx);
      }
      if (this.rWz != null) {
        localHashMap.put("confArray", this.rWz.csa());
      }
      if (this.rWA != null) {
        localHashMap.put("angleArray", this.rWA.csa());
      }
      AppMethodBeat.o(326548);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.a
 * JD-Core Version:    0.7.0.1
 */