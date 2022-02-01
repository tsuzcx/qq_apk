package com.tencent.mm.media.widget.b.a.b;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.CaptureResult.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCaptureResult;", "", "result", "Landroid/hardware/camera2/CaptureResult;", "mCameraId", "", "mWCEffectResultList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "Lkotlin/collections/ArrayList;", "(Landroid/hardware/camera2/CaptureResult;Ljava/lang/String;Ljava/util/ArrayList;)V", "mCameraIDRef", "", "getMCameraIDRef", "()I", "setMCameraIDRef", "(I)V", "getMWCEffectResultList", "()Ljava/util/ArrayList;", "setMWCEffectResultList", "(Ljava/util/ArrayList;)V", "getResult", "()Landroid/hardware/camera2/CaptureResult;", "setResult", "(Landroid/hardware/camera2/CaptureResult;)V", "checkEffectSupported", "", "key", "stream", "getBooleanRet", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getByteRet", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "getIntRet", "(Ljava/lang/String;)Ljava/lang/Integer;", "getRetType", "getStringRet", "refKey", "Landroid/hardware/camera2/CaptureResult$Key;", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b.a nIV;
  private static final String nIY;
  public int nIH;
  public CaptureResult nIW;
  public ArrayList<a> nIX;
  
  static
  {
    AppMethodBeat.i(94208);
    nIV = new b.a((byte)0);
    TAG = "MicroMsg.WCCaptureResult";
    nIY = "cameraeffect.result.hdrdetected";
    AppMethodBeat.o(94208);
  }
  
  public b(CaptureResult paramCaptureResult, String paramString, ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(94207);
    this.nIW = paramCaptureResult;
    this.nIX = paramArrayList;
    if (s.p(paramString, "0")) {
      paramCaptureResult = com.tencent.mm.media.widget.b.a.b.nIb;
    }
    for (int i = com.tencent.mm.media.widget.b.a.b.btJ();; i = com.tencent.mm.media.widget.b.a.b.btK())
    {
      this.nIH = i;
      AppMethodBeat.o(94207);
      return;
      paramCaptureResult = com.tencent.mm.media.widget.b.a.b.nIb;
    }
  }
  
  public final CaptureResult.Key<?> GY(String paramString)
  {
    AppMethodBeat.i(94206);
    s.u(paramString, "key");
    Object localObject1 = this.nIX;
    if (localObject1 == null)
    {
      paramString = null;
      if (paramString == null)
      {
        AppMethodBeat.o(94206);
        return null;
      }
    }
    else
    {
      Iterator localIterator = ((Iterable)localObject1).iterator();
      label44:
      int i;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        Object localObject2 = (a)localObject1;
        if (s.p(((a)localObject2).nIy, paramString))
        {
          localObject2 = ((a)localObject2).nIz;
          if ((localObject2 != null) && ((((Integer)localObject2).intValue() & this.nIH) == 0))
          {
            i = 1;
            label107:
            if (i != 0) {
              break label132;
            }
            i = 1;
            label113:
            if (i == 0) {
              break label135;
            }
          }
        }
      }
      for (paramString = (String)localObject1;; paramString = null)
      {
        paramString = (a)paramString;
        break;
        i = 0;
        break label107;
        label132:
        i = 0;
        break label113;
        label135:
        break label44;
      }
    }
    localObject1 = paramString.nIU;
    if (localObject1 != null) {
      switch (((String)localObject1).hashCode())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(94206);
            return null;
          } while (!((String)localObject1).equals("Integer"));
          paramString = paramString.nIC;
          s.checkNotNull(paramString);
          paramString = c.i(paramString, Integer.TYPE);
          AppMethodBeat.o(94206);
          return paramString;
        } while (!((String)localObject1).equals("Byte"));
        paramString = paramString.nIC;
        s.checkNotNull(paramString);
        paramString = c.i(paramString, Byte.TYPE);
        AppMethodBeat.o(94206);
        return paramString;
      } while (!((String)localObject1).equals("String"));
      paramString = paramString.nIC;
      s.checkNotNull(paramString);
      paramString = c.i(paramString, String.class);
      AppMethodBeat.o(94206);
      return paramString;
    } while (!((String)localObject1).equals("Boolean"));
    paramString = paramString.nIC;
    s.checkNotNull(paramString);
    paramString = c.i(paramString, Boolean.TYPE);
    AppMethodBeat.o(94206);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */