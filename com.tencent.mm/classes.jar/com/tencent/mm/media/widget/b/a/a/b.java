package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCCaptureRequest;", "", "mRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "mCameraId", "", "mWCEffectRequestList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "(Landroid/hardware/camera2/CaptureRequest$Builder;Ljava/lang/String;Ljava/util/ArrayList;)V", "mCameraIDRef", "", "getMCameraIDRef", "()I", "setMCameraIDRef", "(I)V", "getMRequest", "()Landroid/hardware/camera2/CaptureRequest$Builder;", "setMRequest", "(Landroid/hardware/camera2/CaptureRequest$Builder;)V", "getMWCEffectRequestList", "()Ljava/util/ArrayList;", "setMWCEffectRequestList", "(Ljava/util/ArrayList;)V", "checkEffectSupported", "", "key", "stream", "getSupportedValue", "child", "index", "getSupportedVendorTag", "requestList", "", "set", "enable", "value", "setBase", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  private static final String haA = "skin";
  private static final String haB = "cameraeffect.request.denois";
  private static final String haC = "cameraeffect.request.hdr";
  private static final String haD = "cameraeffect.request.stabilization";
  private static final String haE = "cameraeffect.request.hdrchecker";
  public static final b.a haF;
  private static final String hax = "cameraeffect.request.facebeauty";
  private static final String hay = "level";
  private static final String haz = "slim";
  public int hau;
  private CaptureRequest.Builder hav;
  public ArrayList<a> haw;
  
  static
  {
    AppMethodBeat.i(94200);
    haF = new b.a((byte)0);
    hax = "cameraeffect.request.facebeauty";
    hay = "level";
    haz = "slim";
    haA = "skin";
    haB = "cameraeffect.request.denois";
    haC = "cameraeffect.request.hdr";
    haD = "cameraeffect.request.stabilization";
    haE = "cameraeffect.request.hdrchecker";
    AppMethodBeat.o(94200);
  }
  
  public b(CaptureRequest.Builder paramBuilder, String paramString, ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(94199);
    this.hav = paramBuilder;
    this.haw = paramArrayList;
    if (k.g(paramString, "0")) {
      paramBuilder = com.tencent.mm.media.widget.b.a.b.gZU;
    }
    for (int i = com.tencent.mm.media.widget.b.a.b.aut();; i = com.tencent.mm.media.widget.b.a.b.auu())
    {
      this.hau = i;
      AppMethodBeat.o(94199);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.b.gZU;
    }
  }
  
  public final boolean Y(String paramString, int paramInt)
  {
    AppMethodBeat.i(94197);
    k.h(paramString, "key");
    Object localObject1 = this.haw;
    int i;
    if (localObject1 != null)
    {
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (!localIterator.hasNext()) {
        break label147;
      }
      localObject1 = localIterator.next();
      Object localObject2 = (a)localObject1;
      if (!k.g(((a)localObject2).hao, paramString)) {
        break label142;
      }
      Integer localInteger = ((a)localObject2).hap;
      if ((localInteger != null) && ((localInteger.intValue() & this.hau) == 0)) {
        break label142;
      }
      localObject2 = ((a)localObject2).hat;
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
    Object localObject1 = this.haw;
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
        if (k.g(locala.hao, paramString1))
        {
          Integer localInteger = locala.hap;
          if ((localInteger == null) || ((localInteger.intValue() & this.hau) != 0))
          {
            localInteger = locala.hat;
            if ((localInteger == null) || ((localInteger.intValue() & paramInt) != 0)) {
              if (paramString2 != null)
              {
                bool = k.g(locala.haq, paramString2);
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
          com.tencent.mm.media.widget.b.a.b.a(this.hav, paramString2, paramBoolean);
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
      com.tencent.mm.media.widget.b.a.b.a(this.hav, paramString2, paramBoolean, paramObject);
    }
    AppMethodBeat.o(94196);
    return true;
  }
  
  public final ArrayList<String> ab(List<String> paramList)
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
        paramList = this.haw;
        label70:
        int i;
        if (paramList != null)
        {
          Iterator localIterator2 = ((Iterable)paramList).iterator();
          if (localIterator2.hasNext())
          {
            paramList = localIterator2.next();
            Object localObject = (a)paramList;
            if (k.g(((a)localObject).hao, str))
            {
              localObject = ((a)localObject).hap;
              if ((localObject == null) || ((((Integer)localObject).intValue() & this.hau) != 0))
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
        for (str = paramList.has;; str = null)
        {
          if (str == null) {
            break label195;
          }
          paramList = paramList.has;
          if (paramList == null) {
            k.fOy();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */