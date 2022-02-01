package com.tencent.mm.media.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "CAMERA_IS_DEFAULT", "CAMERA_IS_PREVIEWING", "CAMERA_IS_CAPTURING", "plugin-mediaeditor_release"})
public enum a$a
{
  private final int status;
  
  static
  {
    AppMethodBeat.i(94005);
    a locala1 = new a("CAMERA_IS_DEFAULT", 0, -1);
    gwI = locala1;
    a locala2 = new a("CAMERA_IS_PREVIEWING", 1, 0);
    gwJ = locala2;
    a locala3 = new a("CAMERA_IS_CAPTURING", 2, 1);
    gwK = locala3;
    gwL = new a[] { locala1, locala2, locala3 };
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