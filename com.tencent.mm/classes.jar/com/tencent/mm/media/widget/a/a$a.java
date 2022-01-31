package com.tencent.mm.media.widget.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "CAMERA_IS_DEFAULT", "CAMERA_IS_PREVIEWING", "plugin-mediaeditor_release"})
public enum a$a
{
  private final int status;
  
  static
  {
    AppMethodBeat.i(13183);
    a locala1 = new a("CAMERA_IS_DEFAULT", 0, -1);
    eZR = locala1;
    a locala2 = new a("CAMERA_IS_PREVIEWING", 1, 0);
    eZS = locala2;
    eZT = new a[] { locala1, locala2 };
    AppMethodBeat.o(13183);
  }
  
  private a$a(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a.a
 * JD-Core Version:    0.7.0.1
 */