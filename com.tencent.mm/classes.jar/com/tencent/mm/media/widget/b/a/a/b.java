package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCCaptureRequest;", "", "mRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "mCameraId", "", "mWCEffectRequestList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "(Landroid/hardware/camera2/CaptureRequest$Builder;Ljava/lang/String;Ljava/util/ArrayList;)V", "mCameraIDRef", "", "getMCameraIDRef", "()I", "setMCameraIDRef", "(I)V", "getMRequest", "()Landroid/hardware/camera2/CaptureRequest$Builder;", "setMRequest", "(Landroid/hardware/camera2/CaptureRequest$Builder;)V", "getMWCEffectRequestList", "()Ljava/util/ArrayList;", "setMWCEffectRequestList", "(Ljava/util/ArrayList;)V", "checkEffectSupported", "", "key", "stream", "getSupportedValue", "child", "index", "getSupportedVendorTag", "requestList", "", "set", "enable", "value", "setBase", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  private static final String gAa = "cameraeffect.request.facebeauty";
  private static final String gAb = "level";
  private static final String gAc = "slim";
  private static final String gAd = "skin";
  private static final String gAe = "cameraeffect.request.denois";
  private static final String gAf = "cameraeffect.request.hdr";
  private static final String gAg = "cameraeffect.request.stabilization";
  private static final String gAh = "cameraeffect.request.hdrchecker";
  public static final a gAi;
  public int gzX;
  private CaptureRequest.Builder gzY;
  public ArrayList<a> gzZ;
  
  static
  {
    AppMethodBeat.i(94200);
    gAi = new a((byte)0);
    gAa = "cameraeffect.request.facebeauty";
    gAb = "level";
    gAc = "slim";
    gAd = "skin";
    gAe = "cameraeffect.request.denois";
    gAf = "cameraeffect.request.hdr";
    gAg = "cameraeffect.request.stabilization";
    gAh = "cameraeffect.request.hdrchecker";
    AppMethodBeat.o(94200);
  }
  
  public b(CaptureRequest.Builder paramBuilder, String paramString, ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(94199);
    this.gzY = paramBuilder;
    this.gzZ = paramArrayList;
    if (k.g(paramString, "0")) {
      paramBuilder = com.tencent.mm.media.widget.b.a.b.gzx;
    }
    for (int i = com.tencent.mm.media.widget.b.a.b.anB();; i = com.tencent.mm.media.widget.b.a.b.anC())
    {
      this.gzX = i;
      AppMethodBeat.o(94199);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.b.gzx;
    }
  }
  
  public final boolean T(String paramString, int paramInt)
  {
    AppMethodBeat.i(94197);
    k.h(paramString, "key");
    Object localObject1 = this.gzZ;
    int i;
    if (localObject1 != null)
    {
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (!localIterator.hasNext()) {
        break label147;
      }
      localObject1 = localIterator.next();
      Object localObject2 = (a)localObject1;
      if (!k.g(((a)localObject2).gzR, paramString)) {
        break label142;
      }
      Integer localInteger = ((a)localObject2).gzS;
      if ((localInteger != null) && ((localInteger.intValue() & this.gzX) == 0)) {
        break label142;
      }
      localObject2 = ((a)localObject2).gzW;
      if ((localObject2 != null) && ((((Integer)localObject2).intValue() & paramInt) == 0)) {
        break label142;
      }
      i = 1;
      label121:
      if (i == 0) {
        break label145;
      }
    }
    label142:
    label145:
    label147:
    for (paramString = (String)localObject1;; paramString = null)
    {
      if ((a)paramString != null) {
        break label152;
      }
      AppMethodBeat.o(94197);
      return false;
      i = 0;
      break label121;
      break;
    }
    label152:
    AppMethodBeat.o(94197);
    return true;
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94195);
    k.h(paramString1, "key");
    k.h(paramString2, "child");
    paramBoolean = a(paramString1, paramString2, paramBoolean, Integer.valueOf(paramInt1), paramInt2);
    AppMethodBeat.o(94195);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(94196);
    Object localObject1 = this.gzZ;
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label145:
      label177:
      label181:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        a locala = (a)localObject3;
        boolean bool;
        if (k.g(locala.gzR, paramString1))
        {
          Integer localInteger = locala.gzS;
          if ((localInteger == null) || ((localInteger.intValue() & this.gzX) != 0))
          {
            localInteger = locala.gzW;
            if ((localInteger == null) || ((localInteger.intValue() & paramInt) != 0)) {
              if (paramString2 != null)
              {
                bool = k.g(locala.gzT, paramString2);
                if (!bool) {
                  break label177;
                }
              }
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label181;
          }
          ((Collection)localObject1).add(localObject3);
          break;
          bool = true;
          break label145;
        }
      }
      paramString1 = (List)localObject1;
      if (paramObject == null)
      {
        paramString1 = ((Iterable)paramString1).iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (a)paramString1.next();
          com.tencent.mm.media.widget.b.a.b.a(this.gzY, paramString2, paramBoolean);
        }
      }
    }
    else
    {
      AppMethodBeat.o(94196);
      return false;
      AppMethodBeat.o(94196);
      return true;
    }
    paramString1 = ((Iterable)paramString1).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (a)paramString1.next();
      com.tencent.mm.media.widget.b.a.b.a(this.gzY, paramString2, paramBoolean, paramObject);
    }
    AppMethodBeat.o(94196);
    return true;
  }
  
  public final ArrayList<String> ae(List<String> paramList)
  {
    AppMethodBeat.i(94198);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator1 = ((Iterable)paramList).iterator();
      label133:
      label137:
      label142:
      label180:
      label192:
      label195:
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        paramList = this.gzZ;
        label70:
        int i;
        if (paramList != null)
        {
          Iterator localIterator2 = ((Iterable)paramList).iterator();
          if (localIterator2.hasNext())
          {
            paramList = localIterator2.next();
            Object localObject = (a)paramList;
            if (k.g(((a)localObject).gzR, str))
            {
              localObject = ((a)localObject).gzS;
              if ((localObject == null) || ((((Integer)localObject).intValue() & this.gzX) != 0))
              {
                i = 1;
                if (i == 0) {
                  break label180;
                }
                paramList = (a)paramList;
                if (paramList == null) {
                  break label192;
                }
              }
            }
          }
        }
        for (str = paramList.gzV;; str = null)
        {
          if (str == null) {
            break label195;
          }
          paramList = paramList.gzV;
          if (paramList == null) {
            k.fvU();
          }
          localArrayList.add(paramList);
          break;
          i = 0;
          break label133;
          break label70;
          paramList = null;
          break label137;
          paramList = null;
          break label142;
        }
      }
    }
    AppMethodBeat.o(94198);
    return localArrayList;
  }
  
  public final boolean b(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94194);
    k.h(paramString, "key");
    paramBoolean = a(paramString, null, paramBoolean, null, paramInt);
    AppMethodBeat.o(94194);
    return paramBoolean;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCCaptureRequest$Companion;", "", "()V", "WCAMERA_EFFECT_FACEBEAUTY_LEVEL", "", "getWCAMERA_EFFECT_FACEBEAUTY_LEVEL", "()Ljava/lang/String;", "WCAMERA_EFFECT_FACEBEAUTY_SKIN", "getWCAMERA_EFFECT_FACEBEAUTY_SKIN", "WCAMERA_EFFECT_FACEBEAUTY_SLIM", "getWCAMERA_EFFECT_FACEBEAUTY_SLIM", "WCCAMERA_EFFECT_DENOIS", "getWCCAMERA_EFFECT_DENOIS", "WCCAMERA_EFFECT_FACEBEAUTY", "getWCCAMERA_EFFECT_FACEBEAUTY", "WCCAMERA_EFFECT_HDR", "getWCCAMERA_EFFECT_HDR", "WCCAMERA_EFFECT_HDRChecker", "getWCCAMERA_EFFECT_HDRChecker", "WCCAMERA_EFFECT_STABILIZATION", "getWCCAMERA_EFFECT_STABILIZATION", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */