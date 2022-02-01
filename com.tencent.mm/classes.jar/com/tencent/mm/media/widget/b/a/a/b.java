package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCCaptureRequest;", "", "mRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "mCameraId", "", "mWCEffectRequestList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "(Landroid/hardware/camera2/CaptureRequest$Builder;Ljava/lang/String;Ljava/util/ArrayList;)V", "mCameraIDRef", "", "getMCameraIDRef", "()I", "setMCameraIDRef", "(I)V", "getMRequest", "()Landroid/hardware/camera2/CaptureRequest$Builder;", "setMRequest", "(Landroid/hardware/camera2/CaptureRequest$Builder;)V", "getMWCEffectRequestList", "()Ljava/util/ArrayList;", "setMWCEffectRequestList", "(Ljava/util/ArrayList;)V", "checkEffectSupported", "", "key", "stream", "getSupportedValue", "child", "index", "getSupportedVendorTag", "requestList", "", "set", "enable", "value", "setBase", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  private static final String ioS = "cameraeffect.request.facebeauty";
  private static final String ioT = "level";
  private static final String ioU = "slim";
  private static final String ioV = "skin";
  private static final String ioW = "cameraeffect.request.denois";
  private static final String ioX = "cameraeffect.request.hdr";
  private static final String ioY = "cameraeffect.request.stabilization";
  private static final String ioZ = "cameraeffect.request.hdrchecker";
  public static final b.a ipa;
  public int ioP;
  private CaptureRequest.Builder ioQ;
  public ArrayList<a> ioR;
  
  static
  {
    AppMethodBeat.i(94200);
    ipa = new b.a((byte)0);
    ioS = "cameraeffect.request.facebeauty";
    ioT = "level";
    ioU = "slim";
    ioV = "skin";
    ioW = "cameraeffect.request.denois";
    ioX = "cameraeffect.request.hdr";
    ioY = "cameraeffect.request.stabilization";
    ioZ = "cameraeffect.request.hdrchecker";
    AppMethodBeat.o(94200);
  }
  
  public b(CaptureRequest.Builder paramBuilder, String paramString, ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(94199);
    this.ioQ = paramBuilder;
    this.ioR = paramArrayList;
    if (p.j(paramString, "0")) {
      paramBuilder = com.tencent.mm.media.widget.b.a.b.iop;
    }
    for (int i = com.tencent.mm.media.widget.b.a.b.aPT();; i = com.tencent.mm.media.widget.b.a.b.aPU())
    {
      this.ioP = i;
      AppMethodBeat.o(94199);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.b.iop;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94195);
    p.h(paramString1, "key");
    p.h(paramString2, "child");
    paramBoolean = a(paramString1, paramString2, paramBoolean, Integer.valueOf(paramInt1), paramInt2);
    AppMethodBeat.o(94195);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(94196);
    Object localObject1 = this.ioR;
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
        if (p.j(locala.ioJ, paramString1))
        {
          Integer localInteger = locala.ioK;
          if ((localInteger == null) || ((localInteger.intValue() & this.ioP) != 0))
          {
            localInteger = locala.ioO;
            if ((localInteger == null) || ((localInteger.intValue() & paramInt) != 0)) {
              if (paramString2 != null)
              {
                bool = p.j(locala.ioL, paramString2);
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
          com.tencent.mm.media.widget.b.a.b.a(this.ioQ, paramString2, paramBoolean);
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
      com.tencent.mm.media.widget.b.a.b.a(this.ioQ, paramString2, paramBoolean, paramObject);
    }
    AppMethodBeat.o(94196);
    return true;
  }
  
  public final boolean af(String paramString, int paramInt)
  {
    AppMethodBeat.i(94197);
    p.h(paramString, "key");
    Object localObject1 = this.ioR;
    int i;
    if (localObject1 != null)
    {
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (!localIterator.hasNext()) {
        break label147;
      }
      localObject1 = localIterator.next();
      Object localObject2 = (a)localObject1;
      if (!p.j(((a)localObject2).ioJ, paramString)) {
        break label142;
      }
      Integer localInteger = ((a)localObject2).ioK;
      if ((localInteger != null) && ((localInteger.intValue() & this.ioP) == 0)) {
        break label142;
      }
      localObject2 = ((a)localObject2).ioO;
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
  
  public final ArrayList<String> ak(List<String> paramList)
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
        paramList = this.ioR;
        label70:
        int i;
        if (paramList != null)
        {
          Iterator localIterator2 = ((Iterable)paramList).iterator();
          if (localIterator2.hasNext())
          {
            paramList = localIterator2.next();
            Object localObject = (a)paramList;
            if (p.j(((a)localObject).ioJ, str))
            {
              localObject = ((a)localObject).ioK;
              if ((localObject == null) || ((((Integer)localObject).intValue() & this.ioP) != 0))
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
        for (str = paramList.ioN;; str = null)
        {
          if (str == null) {
            break label195;
          }
          paramList = paramList.ioN;
          if (paramList == null) {
            p.hyc();
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
    p.h(paramString, "key");
    paramBoolean = a(paramString, null, paramBoolean, null, paramInt);
    AppMethodBeat.o(94194);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */