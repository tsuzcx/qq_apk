package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCRequestKeyFinder;", "", "()V", "mCaptureRequest", "Landroid/hardware/camera2/CaptureRequest;", "requestKeyFinder", "Landroid/hardware/camera2/CaptureRequest$Key;", "resultKeyFinder", "Landroid/hardware/camera2/CaptureResult$Key;", "requestKey", "T", "effectRequestTag", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "list", "", "klass", "Ljava/lang/Class;", "resultKey", "name", "", "setRequestKey", "", "mRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "kClass", "plugin-mediaeditor_release"})
public final class d
{
  public static final d hvC;
  
  static
  {
    AppMethodBeat.i(94204);
    hvC = new d();
    AppMethodBeat.o(94204);
  }
  
  public static final <T> CaptureRequest.Key<T> a(a parama, List<CaptureRequest.Key<?>> paramList, Class<T> paramClass)
  {
    AppMethodBeat.i(94203);
    p.h(parama, "effectRequestTag");
    p.h(paramList, "list");
    p.h(paramClass, "klass");
    paramClass = ((Iterable)paramList).iterator();
    do
    {
      if (!paramClass.hasNext()) {
        break;
      }
      paramList = paramClass.next();
    } while (!p.i(((CaptureRequest.Key)paramList).getName(), parama.hvm));
    for (parama = paramList; parama == null; parama = null)
    {
      parama = new v("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<T>");
      AppMethodBeat.o(94203);
      throw parama;
    }
    parama = (CaptureRequest.Key)parama;
    AppMethodBeat.o(94203);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */