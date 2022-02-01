package com.tencent.mm.media.widget.b.a.b;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.CaptureResult.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCaptureResult;", "", "result", "Landroid/hardware/camera2/CaptureResult;", "mCameraId", "", "mWCEffectResultList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "Lkotlin/collections/ArrayList;", "(Landroid/hardware/camera2/CaptureResult;Ljava/lang/String;Ljava/util/ArrayList;)V", "mCameraIDRef", "", "getMCameraIDRef", "()I", "setMCameraIDRef", "(I)V", "getMWCEffectResultList", "()Ljava/util/ArrayList;", "setMWCEffectResultList", "(Ljava/util/ArrayList;)V", "getResult", "()Landroid/hardware/camera2/CaptureResult;", "setResult", "(Landroid/hardware/camera2/CaptureResult;)V", "checkEffectSupported", "", "key", "stream", "getBooleanRet", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getByteRet", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "getIntRet", "(Ljava/lang/String;)Ljava/lang/Integer;", "getRetType", "getStringRet", "refKey", "Landroid/hardware/camera2/CaptureResult$Key;", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  private static final String TAG = "MicroMsg.WCCaptureResult";
  private static final String hsT = "cameraeffect.result.hdrdetected";
  public static final b.a hsU;
  public int hsA;
  public CaptureResult hsR;
  public ArrayList<a> hsS;
  
  static
  {
    AppMethodBeat.i(94208);
    hsU = new b.a((byte)0);
    TAG = "MicroMsg.WCCaptureResult";
    hsT = "cameraeffect.result.hdrdetected";
    AppMethodBeat.o(94208);
  }
  
  public b(CaptureResult paramCaptureResult, String paramString, ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(94207);
    this.hsR = paramCaptureResult;
    this.hsS = paramArrayList;
    if (p.i(paramString, "0")) {
      paramCaptureResult = com.tencent.mm.media.widget.b.a.b.hsa;
    }
    for (int i = com.tencent.mm.media.widget.b.a.b.axg();; i = com.tencent.mm.media.widget.b.a.b.axh())
    {
      this.hsA = i;
      AppMethodBeat.o(94207);
      return;
      paramCaptureResult = com.tencent.mm.media.widget.b.a.b.hsa;
    }
  }
  
  public final CaptureResult.Key<?> yj(String paramString)
  {
    AppMethodBeat.i(94206);
    p.h(paramString, "key");
    Object localObject1 = this.hsS;
    int i;
    if (localObject1 != null)
    {
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (!localIterator.hasNext()) {
        break label121;
      }
      localObject1 = localIterator.next();
      Object localObject2 = (a)localObject1;
      if (!p.i(((a)localObject2).hsu, paramString)) {
        break label116;
      }
      localObject2 = ((a)localObject2).hsv;
      if ((localObject2 != null) && ((((Integer)localObject2).intValue() & this.hsA) == 0)) {
        break label116;
      }
      i = 1;
      label94:
      if (i == 0) {
        break label119;
      }
    }
    label116:
    label119:
    label121:
    for (paramString = (String)localObject1;; paramString = null)
    {
      paramString = (a)paramString;
      if (paramString != null) {
        break label126;
      }
      AppMethodBeat.o(94206);
      return null;
      i = 0;
      break label94;
      break;
    }
    label126:
    localObject1 = paramString.hsQ;
    if (localObject1 == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              AppMethodBeat.o(94206);
              return null;
              switch (((String)localObject1).hashCode())
              {
              }
            }
          } while (!((String)localObject1).equals("String"));
          paramString = paramString.hsy;
          if (paramString == null) {
            p.gfZ();
          }
          paramString = c.e(paramString, String.class);
          AppMethodBeat.o(94206);
          return paramString;
        } while (!((String)localObject1).equals("Integer"));
        paramString = paramString.hsy;
        if (paramString == null) {
          p.gfZ();
        }
        paramString = c.e(paramString, Integer.TYPE);
        AppMethodBeat.o(94206);
        return paramString;
      } while (!((String)localObject1).equals("Byte"));
      paramString = paramString.hsy;
      if (paramString == null) {
        p.gfZ();
      }
      paramString = c.e(paramString, Byte.TYPE);
      AppMethodBeat.o(94206);
      return paramString;
    } while (!((String)localObject1).equals("Boolean"));
    paramString = paramString.hsy;
    if (paramString == null) {
      p.gfZ();
    }
    paramString = c.e(paramString, Boolean.TYPE);
    AppMethodBeat.o(94206);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */