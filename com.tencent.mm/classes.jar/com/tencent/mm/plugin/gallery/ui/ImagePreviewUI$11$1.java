package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Collection;

final class ImagePreviewUI$11$1
  implements Runnable
{
  ImagePreviewUI$11$1(ImagePreviewUI.11 param11, String paramString) {}
  
  public final void run()
  {
    ImagePreviewUI.h(this.kKc.kKb).D(ImagePreviewUI.r(this.kKc.kKb));
    Object localObject = (f)ImagePreviewUI.o(this.kKc.kKb).getAdapter();
    ArrayList localArrayList = ImagePreviewUI.r(this.kKc.kKb);
    ((f)localObject).kKm.clear();
    ((f)localObject).kKm.addAll(localArrayList);
    ((RecyclerView.a)localObject).agL.notifyChanged();
    localObject = this.kKc.hSF.getStringArrayListExtra("preview_select_image_list");
    ImagePreviewUI.d(this.kKc.kKb).clear();
    if (localObject != null) {
      ImagePreviewUI.d(this.kKc.kKb).addAll((Collection)localObject);
    }
    this.kKc.kKb.updateOptionMenuText(0, ImagePreviewUI.m(this.kKc.kKb));
    ImagePreviewUI.f(this.kKc.kKb).setText(this.kKc.kKb.mController.uMN.getString(R.l.gallery_pic_orignal) + ImagePreviewUI.aXU());
    if (!ImagePreviewUI.d(this.kKc.kKb).contains(this.val$filePath)) {
      ImagePreviewUI.e(this.kKc.kKb).performClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.11.1
 * JD-Core Version:    0.7.0.1
 */