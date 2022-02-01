package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCCaptureRequest;", "", "mRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "mCameraId", "", "mWCEffectRequestList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "(Landroid/hardware/camera2/CaptureRequest$Builder;Ljava/lang/String;Ljava/util/ArrayList;)V", "mCameraIDRef", "", "getMCameraIDRef", "()I", "setMCameraIDRef", "(I)V", "getMRequest", "()Landroid/hardware/camera2/CaptureRequest$Builder;", "setMRequest", "(Landroid/hardware/camera2/CaptureRequest$Builder;)V", "getMWCEffectRequestList", "()Ljava/util/ArrayList;", "setMWCEffectRequestList", "(Ljava/util/ArrayList;)V", "checkEffectSupported", "", "key", "stream", "getSupportedValue", "child", "index", "getSupportedVendorTag", "requestList", "", "set", "enable", "value", "setBase", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a nIE;
  private static final String nII;
  private static final String nIJ;
  private static final String nIK;
  private static final String nIL;
  private static final String nIM;
  private static final String nIN;
  private static final String nIO;
  private static final String nIP;
  private CaptureRequest.Builder nIF;
  public ArrayList<a> nIG;
  public int nIH;
  
  static
  {
    AppMethodBeat.i(94200);
    nIE = new b.a((byte)0);
    nII = "cameraeffect.request.facebeauty";
    nIJ = "level";
    nIK = "slim";
    nIL = "skin";
    nIM = "cameraeffect.request.denois";
    nIN = "cameraeffect.request.hdr";
    nIO = "cameraeffect.request.stabilization";
    nIP = "cameraeffect.request.hdrchecker";
    AppMethodBeat.o(94200);
  }
  
  public b(CaptureRequest.Builder paramBuilder, String paramString, ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(94199);
    this.nIF = paramBuilder;
    this.nIG = paramArrayList;
    if (s.p(paramString, "0")) {
      paramBuilder = com.tencent.mm.media.widget.b.a.b.nIb;
    }
    for (int i = com.tencent.mm.media.widget.b.a.b.btJ();; i = com.tencent.mm.media.widget.b.a.b.btK())
    {
      this.nIH = i;
      AppMethodBeat.o(94199);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.b.nIb;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94195);
    s.u(paramString1, "key");
    s.u(paramString2, "child");
    paramBoolean = a(paramString1, paramString2, paramBoolean, Integer.valueOf(paramInt1), paramInt2);
    AppMethodBeat.o(94195);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(94196);
    Object localObject1 = this.nIG;
    if (localObject1 == null) {}
    for (paramString1 = null; paramString1 == null; paramString1 = (List)localObject1)
    {
      AppMethodBeat.o(94196);
      return false;
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label154:
      label174:
      label206:
      label212:
      label218:
      label222:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        a locala = (a)localObject3;
        label123:
        boolean bool;
        if (s.p(locala.nIy, paramString1))
        {
          Integer localInteger = locala.nIz;
          if ((localInteger != null) && ((localInteger.intValue() & this.nIH) == 0))
          {
            i = 1;
            if (i != 0) {
              break label218;
            }
            localInteger = locala.nID;
            if ((localInteger == null) || ((localInteger.intValue() & paramInt) != 0)) {
              break label206;
            }
            i = 1;
            if (i != 0) {
              break label218;
            }
            if (paramString2 == null) {
              break label212;
            }
            bool = s.p(locala.nIA, paramString2);
            if (!bool) {
              break label218;
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label222;
          }
          ((Collection)localObject1).add(localObject3);
          break;
          i = 0;
          break label123;
          i = 0;
          break label154;
          bool = true;
          break label174;
        }
      }
    }
    if (paramObject == null)
    {
      paramString1 = ((Iterable)paramString1).iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (a)paramString1.next();
        com.tencent.mm.media.widget.b.a.b.a(this.nIF, paramString2, paramBoolean);
      }
      AppMethodBeat.o(94196);
      return true;
    }
    paramString1 = ((Iterable)paramString1).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (a)paramString1.next();
      com.tencent.mm.media.widget.b.a.b.a(this.nIF, paramString2, paramBoolean, paramObject);
    }
    AppMethodBeat.o(94196);
    return true;
  }
  
  public final boolean aG(String paramString, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(94197);
    s.u(paramString, "key");
    Object localObject2 = this.nIG;
    if (localObject2 == null)
    {
      paramString = localObject1;
      if (paramString == null)
      {
        AppMethodBeat.o(94197);
        return false;
      }
    }
    else
    {
      localObject2 = ((Iterable)localObject2).iterator();
      label51:
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        Object localObject3 = (a)localObject1;
        if (s.p(((a)localObject3).nIy, paramString))
        {
          Integer localInteger = ((a)localObject3).nIz;
          if ((localInteger != null) && ((localInteger.intValue() & this.nIH) == 0))
          {
            i = 1;
            label116:
            if (i != 0) {
              break label175;
            }
            localObject3 = ((a)localObject3).nID;
            if ((localObject3 == null) || ((((Integer)localObject3).intValue() & paramInt) != 0)) {
              break label170;
            }
            i = 1;
            label144:
            if (i != 0) {
              break label175;
            }
            i = 1;
            label150:
            if (i == 0) {
              break label178;
            }
          }
        }
      }
      for (paramString = localObject1;; paramString = null)
      {
        paramString = (a)paramString;
        break;
        i = 0;
        break label116;
        label170:
        i = 0;
        break label144;
        label175:
        i = 0;
        break label150;
        label178:
        break label51;
      }
    }
    AppMethodBeat.o(94197);
    return true;
  }
  
  public final boolean b(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(94194);
    s.u(paramString, "key");
    paramBoolean = a(paramString, null, paramBoolean, null, paramInt);
    AppMethodBeat.o(94194);
    return paramBoolean;
  }
  
  public final ArrayList<String> bJ(List<String> paramList)
  {
    AppMethodBeat.i(94198);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator1 = ((Iterable)paramList).iterator();
      label164:
      label170:
      label187:
      label190:
      label197:
      label203:
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        paramList = this.nIG;
        if (paramList == null)
        {
          paramList = null;
          if (paramList != null) {
            break label197;
          }
        }
        for (str = null;; str = paramList.nIC)
        {
          if (str == null) {
            break label203;
          }
          paramList = paramList.nIC;
          s.checkNotNull(paramList);
          localArrayList.add(paramList);
          break;
          Iterator localIterator2 = ((Iterable)paramList).iterator();
          label101:
          int i;
          if (localIterator2.hasNext())
          {
            paramList = localIterator2.next();
            Object localObject = (a)paramList;
            if (s.p(((a)localObject).nIy, str))
            {
              localObject = ((a)localObject).nIz;
              if ((localObject != null) && ((((Integer)localObject).intValue() & this.nIH) == 0))
              {
                i = 1;
                if (i != 0) {
                  break label187;
                }
                i = 1;
                if (i == 0) {
                  break label190;
                }
              }
            }
          }
          for (;;)
          {
            paramList = (a)paramList;
            break;
            i = 0;
            break label164;
            i = 0;
            break label170;
            break label101;
            paramList = null;
          }
        }
      }
    }
    AppMethodBeat.o(94198);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */