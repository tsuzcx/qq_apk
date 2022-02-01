package com.tencent.mm.media.widget.b.a;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.a;
import com.tencent.mm.media.widget.b.a.a.c;
import com.tencent.mm.media.widget.b.a.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera2/effect/WCCameraEffectHelper;", "", "()V", "CAMERA_ID_BACK", "", "getCAMERA_ID_BACK", "()I", "CAMERA_ID_FRONT", "getCAMERA_ID_FRONT", "CAMERA_STREAM_IMAGE", "getCAMERA_STREAM_IMAGE", "CAMERA_STREAM_PREVIEW", "getCAMERA_STREAM_PREVIEW", "CAMERA_STREAM_RECORD", "getCAMERA_STREAM_RECORD", "TAG", "", "isUseCaptureKeyCreator", "", "autoConfig", "", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "effectTag", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "enable", "getVendorTagCaptureKey", "Landroid/hardware/camera2/CaptureRequest$Key;", "list", "", "getVendorTagCaptureKeyByCreator", "getVendorTagCaptureKeyByFinder", "manualConfig", "value", "plugin-mediaeditor_release"})
public final class b
{
  private static final String TAG = "MicroMsg.WCCameraEffectHelper";
  private static boolean hrU = false;
  private static final int hrV = 1;
  private static final int hrW = 2;
  private static final int hrX = 4;
  private static final int hrY = 1;
  private static final int hrZ = 2;
  public static final b hsa;
  
  static
  {
    AppMethodBeat.i(94185);
    hsa = new b();
    hrU = true;
    TAG = "MicroMsg.WCCameraEffectHelper";
    hrV = 1;
    hrW = 2;
    hrX = 4;
    hrY = 1;
    hrZ = 2;
    AppMethodBeat.o(94185);
  }
  
  private static CaptureRequest.Key<?> a(a parama, List<CaptureRequest.Key<?>> paramList)
  {
    AppMethodBeat.i(94182);
    p.h(parama, "effectTag");
    if (paramList == null)
    {
      paramList = parama.aFh;
      if ((paramList instanceof Integer))
      {
        parama = parama.hsy;
        if (parama == null) {
          p.gfZ();
        }
        parama = c.d(parama, Integer.TYPE);
        AppMethodBeat.o(94182);
        return parama;
      }
      if ((paramList instanceof Boolean))
      {
        parama = parama.hsy;
        if (parama == null) {
          p.gfZ();
        }
        parama = c.d(parama, Boolean.TYPE);
        AppMethodBeat.o(94182);
        return parama;
      }
      if ((paramList instanceof String))
      {
        parama = parama.hsy;
        if (parama == null) {
          p.gfZ();
        }
        parama = c.d(parama, String.class);
        AppMethodBeat.o(94182);
        return parama;
      }
      ad.e(TAG, "getVendorTagCaptureKeyByCreator: with unknow type value = " + parama.aFh + " key = " + parama.hsy);
      AppMethodBeat.o(94182);
      return null;
    }
    Object localObject = parama.aFh;
    if ((localObject instanceof Integer))
    {
      parama = d.a(parama, paramList, Integer.TYPE);
      AppMethodBeat.o(94182);
      return parama;
    }
    if ((localObject instanceof Boolean))
    {
      parama = d.a(parama, paramList, Boolean.TYPE);
      AppMethodBeat.o(94182);
      return parama;
    }
    if ((localObject instanceof String))
    {
      parama = d.a(parama, paramList, String.class);
      AppMethodBeat.o(94182);
      return parama;
    }
    AppMethodBeat.o(94182);
    return null;
  }
  
  public static final void a(CaptureRequest.Builder paramBuilder, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94183);
    p.h(paramBuilder, "builder");
    if (parama == null) {
      p.gfZ();
    }
    Object localObject = parama.aFh;
    if (localObject == null) {
      p.gfZ();
    }
    a(paramBuilder, parama, paramBoolean, localObject);
    AppMethodBeat.o(94183);
  }
  
  public static final void a(CaptureRequest.Builder paramBuilder, a parama, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(94184);
    p.h(paramBuilder, "builder");
    p.h(paramObject, "value");
    if (parama == null)
    {
      AppMethodBeat.o(94184);
      return;
    }
    if (hrU) {}
    for (CaptureRequest.Key localKey = a(parama, null);; localKey = a(parama, ((CaptureRequest)localObject1).getKeys()))
    {
      localObject1 = parama.hsx;
      if (!(localObject1 instanceof Range)) {
        break label180;
      }
      localObject1 = parama.hsx;
      if (localObject1 != null) {
        break;
      }
      paramBuilder = new v("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
      AppMethodBeat.o(94184);
      throw paramBuilder;
      localObject1 = paramBuilder.build();
      p.g(localObject1, "builder.build()");
    }
    Object localObject1 = ((Range)localObject1).getLower();
    for (;;)
    {
      ad.i(TAG, parama.hsw + " has been set value is " + paramBoolean);
      if (!(paramObject instanceof Integer)) {
        break label433;
      }
      if (localKey != null) {
        break;
      }
      paramBuilder = new v("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.Int>");
      AppMethodBeat.o(94184);
      throw paramBuilder;
      label180:
      if ((localObject1 instanceof ArrayList))
      {
        localObject1 = parama.hsx;
        if (localObject1 == null)
        {
          paramBuilder = new v("null cannot be cast to non-null type kotlin.collections.ArrayList<*> /* = java.util.ArrayList<*> */");
          AppMethodBeat.o(94184);
          throw paramBuilder;
        }
        localObject1 = (ArrayList)localObject1;
        Object localObject2 = ((ArrayList)localObject1).get(0);
        if ((localObject2 instanceof Integer))
        {
          localObject1 = ((ArrayList)localObject1).get(0);
          if (localObject1 == null)
          {
            paramBuilder = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(94184);
            throw paramBuilder;
          }
          localObject1 = (Integer)localObject1;
        }
        else if ((localObject2 instanceof Boolean))
        {
          localObject1 = ((ArrayList)localObject1).get(0);
          if (localObject1 == null)
          {
            paramBuilder = new v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(94184);
            throw paramBuilder;
          }
          localObject1 = (Boolean)localObject1;
        }
        else if ((localObject2 instanceof String))
        {
          localObject1 = ((ArrayList)localObject1).get(0);
          if (localObject1 == null)
          {
            paramBuilder = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(94184);
            throw paramBuilder;
          }
          localObject1 = (String)localObject1;
        }
        else
        {
          localObject1 = null;
        }
      }
      else
      {
        localObject1 = null;
      }
    }
    if (paramBoolean) {
      localObject1 = paramObject;
    }
    if (localObject1 == null)
    {
      paramBuilder = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(94184);
      throw paramBuilder;
    }
    paramBuilder.set(localKey, (Integer)localObject1);
    AppMethodBeat.o(94184);
    return;
    label433:
    if ((paramObject instanceof Boolean))
    {
      if (localKey == null)
      {
        paramBuilder = new v("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.Boolean>");
        AppMethodBeat.o(94184);
        throw paramBuilder;
      }
      paramBuilder.set(localKey, Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(94184);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (localKey == null)
      {
        paramBuilder = new v("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.String>");
        AppMethodBeat.o(94184);
        throw paramBuilder;
      }
      if (paramBoolean) {
        localObject1 = paramObject;
      }
      if (localObject1 == null)
      {
        paramBuilder = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(94184);
        throw paramBuilder;
      }
      paramBuilder.set(localKey, (String)localObject1);
      AppMethodBeat.o(94184);
      return;
    }
    ad.i(TAG, "error set config");
    AppMethodBeat.o(94184);
  }
  
  public static int axd()
  {
    return hrV;
  }
  
  public static int axe()
  {
    return hrW;
  }
  
  public static int axf()
  {
    return hrX;
  }
  
  public static int axg()
  {
    return hrY;
  }
  
  public static int axh()
  {
    return hrZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b
 * JD-Core Version:    0.7.0.1
 */