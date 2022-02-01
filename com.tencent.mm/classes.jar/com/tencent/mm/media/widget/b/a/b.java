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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/WCCameraEffectHelper;", "", "()V", "CAMERA_ID_BACK", "", "getCAMERA_ID_BACK", "()I", "CAMERA_ID_FRONT", "getCAMERA_ID_FRONT", "CAMERA_STREAM_IMAGE", "getCAMERA_STREAM_IMAGE", "CAMERA_STREAM_PREVIEW", "getCAMERA_STREAM_PREVIEW", "CAMERA_STREAM_RECORD", "getCAMERA_STREAM_RECORD", "TAG", "", "isUseCaptureKeyCreator", "", "autoConfig", "", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "effectTag", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "enable", "getVendorTagCaptureKey", "Landroid/hardware/camera2/CaptureRequest$Key;", "list", "", "getVendorTagCaptureKeyByCreator", "getVendorTagCaptureKeyByFinder", "manualConfig", "value", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b nIb;
  private static boolean nIc;
  private static final int nId;
  private static final int nIe;
  private static final int nIf;
  private static final int nIg;
  private static final int nIh;
  
  static
  {
    AppMethodBeat.i(94185);
    nIb = new b();
    nIc = true;
    TAG = "MicroMsg.WCCameraEffectHelper";
    nId = 1;
    nIe = 2;
    nIf = 4;
    nIg = 1;
    nIh = 2;
    AppMethodBeat.o(94185);
  }
  
  private static CaptureRequest.Key<?> a(a parama, List<CaptureRequest.Key<?>> paramList)
  {
    AppMethodBeat.i(94182);
    s.u(parama, "effectTag");
    if (paramList == null)
    {
      paramList = parama.dOI;
      if ((paramList instanceof Integer))
      {
        parama = parama.nIC;
        s.checkNotNull(parama);
        parama = c.h(parama, Integer.TYPE);
        AppMethodBeat.o(94182);
        return parama;
      }
      if ((paramList instanceof Boolean))
      {
        parama = parama.nIC;
        s.checkNotNull(parama);
        parama = c.h(parama, Boolean.TYPE);
        AppMethodBeat.o(94182);
        return parama;
      }
      if ((paramList instanceof String))
      {
        parama = parama.nIC;
        s.checkNotNull(parama);
        parama = c.h(parama, String.class);
        AppMethodBeat.o(94182);
        return parama;
      }
      Log.e(TAG, "getVendorTagCaptureKeyByCreator: with unknow type value = " + parama.dOI + " key = " + parama.nIC);
      AppMethodBeat.o(94182);
      return null;
    }
    Object localObject = parama.dOI;
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
    s.u(paramBuilder, "builder");
    s.checkNotNull(parama);
    Object localObject = parama.dOI;
    s.checkNotNull(localObject);
    a(paramBuilder, parama, paramBoolean, localObject);
    AppMethodBeat.o(94183);
  }
  
  public static final void a(CaptureRequest.Builder paramBuilder, a parama, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(94184);
    s.u(paramBuilder, "builder");
    s.u(paramObject, "value");
    if (parama == null)
    {
      AppMethodBeat.o(94184);
      return;
    }
    if (nIc) {}
    for (CaptureRequest.Key localKey = a(parama, null);; localKey = a(parama, paramBuilder.build().getKeys()))
    {
      localObject1 = parama.nIB;
      if (!(localObject1 instanceof Range)) {
        break label169;
      }
      localObject1 = parama.nIB;
      if (localObject1 != null) {
        break;
      }
      paramBuilder = new NullPointerException("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
      AppMethodBeat.o(94184);
      throw paramBuilder;
    }
    Object localObject1 = ((Range)localObject1).getLower();
    for (;;)
    {
      Log.i(TAG, parama.nIA + " has been set value is " + paramBoolean);
      if (!(paramObject instanceof Integer)) {
        break label440;
      }
      if (localKey != null) {
        break;
      }
      paramBuilder = new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.Int>");
      AppMethodBeat.o(94184);
      throw paramBuilder;
      label169:
      if ((localObject1 instanceof ArrayList))
      {
        localObject1 = parama.nIB;
        if (localObject1 == null)
        {
          paramBuilder = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
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
            paramBuilder = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(94184);
            throw paramBuilder;
          }
          localObject1 = Integer.valueOf(((Integer)localObject1).intValue());
        }
        else if ((localObject2 instanceof Boolean))
        {
          localObject1 = ((ArrayList)localObject1).get(0);
          if (localObject1 == null)
          {
            paramBuilder = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(94184);
            throw paramBuilder;
          }
          localObject1 = Boolean.valueOf(((Boolean)localObject1).booleanValue());
        }
        else if ((localObject2 instanceof String))
        {
          localObject1 = ((ArrayList)localObject1).get(0);
          if (localObject1 == null)
          {
            paramBuilder = new NullPointerException("null cannot be cast to non-null type kotlin.String");
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
      paramBuilder = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(94184);
      throw paramBuilder;
    }
    paramBuilder.set(localKey, Integer.valueOf(((Integer)localObject1).intValue()));
    AppMethodBeat.o(94184);
    return;
    label440:
    if ((paramObject instanceof Boolean))
    {
      if (localKey == null)
      {
        paramBuilder = new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.Boolean>");
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
        paramBuilder = new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<kotlin.String>");
        AppMethodBeat.o(94184);
        throw paramBuilder;
      }
      if (paramBoolean) {
        localObject1 = paramObject;
      }
      if (localObject1 == null)
      {
        paramBuilder = new NullPointerException("null cannot be cast to non-null type kotlin.String");
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
  
  public static int btG()
  {
    return nId;
  }
  
  public static int btH()
  {
    return nIe;
  }
  
  public static int btI()
  {
    return nIf;
  }
  
  public static int btJ()
  {
    return nIg;
  }
  
  public static int btK()
  {
    return nIh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b
 * JD-Core Version:    0.7.0.1
 */