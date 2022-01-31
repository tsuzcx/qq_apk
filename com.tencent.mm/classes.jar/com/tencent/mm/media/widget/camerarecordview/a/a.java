package com.tencent.mm.media.widget.camerarecordview.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "", "getFilePath", "", "getRecordType", "", "getThumbPath", "Companion", "RecordTypeInfo", "plugin-mediaeditor_release"})
public abstract interface a
{
  public static final a fbl = a.fbm;
  
  public abstract int Xh();
  
  public abstract String Xi();
  
  public abstract String getFilePath();
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig$Companion;", "", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "plugin-mediaeditor_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(13261);
      fbm = new a();
      AppMethodBeat.o(13261);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.a
 * JD-Core Version:    0.7.0.1
 */