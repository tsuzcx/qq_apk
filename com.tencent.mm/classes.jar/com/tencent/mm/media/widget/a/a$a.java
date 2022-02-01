package com.tencent.mm.media.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "CAMERA_IS_DEFAULT", "CAMERA_IS_PREVIEWING", "CAMERA_IS_CAPTURING", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$a
{
  private final int status;
  
  static
  {
    AppMethodBeat.i(94005);
    nGf = new a("CAMERA_IS_DEFAULT", 0, -1);
    nGg = new a("CAMERA_IS_PREVIEWING", 1, 0);
    nGh = new a("CAMERA_IS_CAPTURING", 2, 1);
    nGi = new a[] { nGf, nGg, nGh };
    AppMethodBeat.o(94005);
  }
  
  private a$a(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a.a
 * JD-Core Version:    0.7.0.1
 */