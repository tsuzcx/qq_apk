package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

final class ImagePreviewUI$10$1
  implements Runnable
{
  ImagePreviewUI$10$1(ImagePreviewUI.10 param10, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(111570);
    ImagePreviewUI.h(this.sSu.sSr).af(ImagePreviewUI.s(this.sSu.sSr));
    Object localObject = (g)ImagePreviewUI.p(this.sSu.sSr).getAdapter();
    ArrayList localArrayList = ImagePreviewUI.s(this.sSu.sSr);
    ((g)localObject).sSD.clear();
    ((g)localObject).sSD.addAll(localArrayList);
    ((RecyclerView.a)localObject).arg.notifyChanged();
    localObject = this.sSu.val$data.getStringArrayListExtra("preview_select_image_list");
    ImagePreviewUI.d(this.sSu.sSr).clear();
    if (localObject != null) {
      ImagePreviewUI.d(this.sSu.sSr).addAll((Collection)localObject);
    }
    this.sSu.sSr.updateOptionMenuText(0, ImagePreviewUI.n(this.sSu.sSr));
    ImagePreviewUI.f(this.sSu.sSr).setText(this.sSu.sSr.getContext().getString(2131759782) + ImagePreviewUI.cNU());
    if (!ImagePreviewUI.d(this.sSu.sSr).contains(com.tencent.mm.plugin.gallery.a.d.agK(this.sSt))) {
      ImagePreviewUI.e(this.sSu.sSr).performClick();
    }
    AppMethodBeat.o(111570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.10.1
 * JD-Core Version:    0.7.0.1
 */