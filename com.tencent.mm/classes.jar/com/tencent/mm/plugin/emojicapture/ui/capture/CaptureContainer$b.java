package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a.a;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.plugin.emojicapture.model.c.a;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-emojicapture_release"})
public final class CaptureContainer$b
  implements a
{
  public final int Xh()
  {
    return 2;
  }
  
  public final String Xi()
  {
    AppMethodBeat.i(2964);
    Object localObject = c.ltu;
    localObject = c.a.bnR() + "temp_thumb" + bo.aoy();
    AppMethodBeat.o(2964);
    return localObject;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(2963);
    Object localObject = c.ltu;
    localObject = c.a.bnR() + "video_" + bo.aoy();
    AppMethodBeat.o(2963);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.b
 * JD-Core Version:    0.7.0.1
 */