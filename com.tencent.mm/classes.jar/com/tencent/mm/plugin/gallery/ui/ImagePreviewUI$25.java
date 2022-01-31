package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ImagePreviewUI$25
  implements View.OnClickListener
{
  ImagePreviewUI$25(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21523);
    paramView = ImagePreviewUI.h(this.ngC).getItem(ImagePreviewUI.g(this.ngC).intValue());
    if (bo.isNullOrNil(paramView))
    {
      ab.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(this.ngC) });
      AppMethodBeat.o(21523);
      return;
    }
    ab.i("MicroMsg.ImagePreviewUI", "editVideoMaxTimeLength : %d", new Object[] { Integer.valueOf(ImagePreviewUI.i(this.ngC)) });
    paramView = RecordConfigProvider.aa(paramView, CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4", CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg");
    paramView.qbq = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
    paramView.qbx = (ImagePreviewUI.i(this.ngC) * 1000);
    paramView.scene = e.bDQ().hQK;
    a locala = a.qbG;
    a.a(this.ngC.getContext(), 4370, paramView, 3, 0);
    AppMethodBeat.o(21523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.25
 * JD-Core Version:    0.7.0.1
 */