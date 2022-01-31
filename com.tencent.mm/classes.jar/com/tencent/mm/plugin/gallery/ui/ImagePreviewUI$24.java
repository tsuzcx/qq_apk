package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ImagePreviewUI$24
  implements View.OnClickListener
{
  ImagePreviewUI$24(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = ImagePreviewUI.h(this.kKb).ke(ImagePreviewUI.g(this.kKb).intValue());
    if (bk.bl(paramView))
    {
      y.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(this.kKb) });
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_video_path", paramView);
    localIntent.putExtra("key_need_clip_video_first", true);
    d.b(this.kKb.mController.uMN, "mmsight", ".segment.MMSightEditUI", localIntent, 4370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.24
 * JD-Core Version:    0.7.0.1
 */