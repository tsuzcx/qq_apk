package com.tencent.mm.media.camera.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/preload/CameraKitPreloadModel;", "T", "", "preload", "status", "Lcom/tencent/mm/media/camera/preload/CameraKitPreloadStatus;", "(Ljava/lang/Object;Lcom/tencent/mm/media/camera/preload/CameraKitPreloadStatus;)V", "getPreload", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStatus", "()Lcom/tencent/mm/media/camera/preload/CameraKitPreloadStatus;", "setStatus", "(Lcom/tencent/mm/media/camera/preload/CameraKitPreloadStatus;)V", "component1", "component2", "copy", "(Ljava/lang/Object;Lcom/tencent/mm/media/camera/preload/CameraKitPreloadStatus;)Lcom/tencent/mm/media/camera/preload/CameraKitPreloadModel;", "equals", "", "other", "hashCode", "", "toString", "", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b<T>
{
  final T nvS;
  c nvT;
  
  private b(T paramT, c paramc)
  {
    AppMethodBeat.i(237229);
    this.nvS = paramT;
    this.nvT = paramc;
    AppMethodBeat.o(237229);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237261);
    if (this == paramObject)
    {
      AppMethodBeat.o(237261);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(237261);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.nvS, paramObject.nvS))
    {
      AppMethodBeat.o(237261);
      return false;
    }
    if (this.nvT != paramObject.nvT)
    {
      AppMethodBeat.o(237261);
      return false;
    }
    AppMethodBeat.o(237261);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(237254);
    if (this.nvS == null) {}
    for (int i = 0;; i = this.nvS.hashCode())
    {
      int j = this.nvT.hashCode();
      AppMethodBeat.o(237254);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237244);
    String str = "CameraKitPreloadModel(preload=" + this.nvS + ", status=" + this.nvT + ')';
    AppMethodBeat.o(237244);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.camera.e.b
 * JD-Core Version:    0.7.0.1
 */