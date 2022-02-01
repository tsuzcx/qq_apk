package com.tencent.mm.media.widget.b.a;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.a.a.a;
import com.tencent.mm.media.widget.b.a.a.c;
import com.tencent.mm.media.widget.b.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera2/effect/WCCameraEffectHelper;", "", "()V", "CAMERA_ID_BACK", "", "getCAMERA_ID_BACK", "()I", "CAMERA_ID_FRONT", "getCAMERA_ID_FRONT", "CAMERA_STREAM_IMAGE", "getCAMERA_STREAM_IMAGE", "CAMERA_STREAM_PREVIEW", "getCAMERA_STREAM_PREVIEW", "CAMERA_STREAM_RECORD", "getCAMERA_STREAM_RECORD", "TAG", "", "isUseCaptureKeyCreator", "", "autoConfig", "", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "effectTag", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "enable", "getVendorTagCaptureKey", "Landroid/hardware/camera2/CaptureRequest$Key;", "list", "", "getVendorTagCaptureKeyByCreator", "getVendorTagCaptureKeyByFinder", "manualConfig", "value", "plugin-mediaeditor_release"})
public final class b
{
  private static final String TAG = "MicroMsg.WCCameraEffectHelper";
  private static boolean ioj = false;
  private static final int iok = 1;
  private static final int iol = 2;
  private static final int iom = 4;
  private static final int ion = 1;
  private static final int ioo = 2;
  public static final b iop;
  
  static
  {
    AppMethodBeat.i(94185);
    iop = new b();
    ioj = true;
    TAG = "MicroMsg.WCCameraEffectHelper";
    iok = 1;
    iol = 2;
    iom = 4;
    ion = 1;
    ioo = 2;
    AppMethodBeat.o(94185);
  }
  
  private static CaptureRequest.Key<?> a(a parama, List<CaptureRequest.Key<?>> paramList)
  {
    AppMethodBeat.i(94182);
    p.h(parama, "effectTag");
    if (paramList == null)
    {
      paramList = parama.aEX;
      if ((paramList instanceof Integer))
      {
        parama = parama.ioN;
        if (parama == null) {
          p.hyc();
        }
        parama = c.d(parama, Integer.TYPE);
        AppMethodBeat.o(94182);
        return parama;
      }
      if ((paramList instanceof Boolean))
      {
        parama = parama.ioN;
        if (parama == null) {
          p.hyc();
        }
        parama = c.d(parama, Boolean.TYPE);
        AppMethodBeat.o(94182);
        return parama;
      }
      if ((paramList instanceof String))
      {
        parama = parama.ioN;
        if (parama == null) {
          p.hyc();
        }
        parama = c.d(parama, String.class);
        AppMethodBeat.o(94182);
        return parama;
      }
      Log.e(TAG, "getVendorTagCaptureKeyByCreator: with unknow type value = " + parama.aEX + " key = " + parama.ioN);
      AppMethodBeat.o(94182);
      return null;
    }
    Object localObject = parama.aEX;
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
      p.hyc();
    }
    Object localObject = parama.aEX;
    if (localObject == null) {
      p.hyc();
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
    if (ioj) {}
    for (CaptureRequest.Key localKey = a(parama, null);; localKey = a(parama, ((CaptureRequest)localObject1).getKeys()))
    {
      localObject1 = parama.ioM;
      if (!(localObject1 instanceof Range)) {
        break label180;
      }
      localObject1 = parama.ioM;
      if (localObject1 != null) {
        break;
      }
      paramBuilder = new t("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
      AppMethodBeat.o(94184);
      throw paramBuilder;
      localObject1 = paramBuilder.build();
      p.g(localObject1, "builder.build()");
    }
    Object localObject1 = ((Range)localObject1).getLower();
    for (;;)
    {
      Log.i(TAG, parama.ioL + " has been set value is " + paramBoolean);
      if (!(paramObject instanceof Integer)) {
        break label433;
      }
      if (localKey != null) {
        break;
      }
      paramBuilder = new t("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.Int>");
      AppMethodBeat.o(94184);
      throw paramBuilder;
      label180:
      if ((localObject1 instanceof ArrayList))
      {
        localObject1 = parama.ioM;
        if (localObject1 == null)
        {
          paramBuilder = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<*> /* = java.util.ArrayList<*> */");
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
            paramBuilder = new t("null cannot be cast to non-null type kotlin.Int");
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
            paramBuilder = new t("null cannot be cast to non-null type kotlin.Boolean");
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
            paramBuilder = new t("null cannot be cast to non-null type kotlin.String");
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
      paramBuilder = new t("null cannot be cast to non-null type kotlin.Int");
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
        paramBuilder = new t("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.Boolean>");
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
        paramBuilder = new t("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.String>");
        AppMethodBeat.o(94184);
        throw paramBuilder;
      }
      if (paramBoolean) {
        localObject1 = paramObject;
      }
      if (localObject1 == null)
      {
        paramBuilder = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(94184);
        throw paramBuilder;
      }
      paramBuilder.set(localKey, (String)localObject1);
      AppMethodBeat.o(94184);
      return;
    }
    Log.i(TAG, "error set config");
    AppMethodBeat.o(94184);
  }
  
  public static int aPQ()
  {
    return iok;
  }
  
  public static int aPR()
  {
    return iol;
  }
  
  public static int aPS()
  {
    return iom;
  }
  
  public static int aPT()
  {
    return ion;
  }
  
  public static int aPU()
  {
    return ioo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b
 * JD-Core Version:    0.7.0.1
 */