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

final class ImagePreviewUI$13$1
  implements Runnable
{
  ImagePreviewUI$13$1(ImagePreviewUI.13 param13, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(150887);
    ImagePreviewUI.h(this.ngH.ngC).E(ImagePreviewUI.s(this.ngH.ngC));
    Object localObject = (f)ImagePreviewUI.p(this.ngH.ngC).getAdapter();
    ArrayList localArrayList = ImagePreviewUI.s(this.ngH.ngC);
    ((f)localObject).ngM.clear();
    ((f)localObject).ngM.addAll(localArrayList);
    ((RecyclerView.a)localObject).ajb.notifyChanged();
    localObject = this.ngH.val$data.getStringArrayListExtra("preview_select_image_list");
    ImagePreviewUI.d(this.ngH.ngC).clear();
    if (localObject != null) {
      ImagePreviewUI.d(this.ngH.ngC).addAll((Collection)localObject);
    }
    this.ngH.ngC.updateOptionMenuText(0, ImagePreviewUI.n(this.ngH.ngC));
    ImagePreviewUI.f(this.ngH.ngC).setText(this.ngH.ngC.getContext().getString(2131300289) + ImagePreviewUI.bEE());
    if (!ImagePreviewUI.d(this.ngH.ngC).contains(this.val$filePath)) {
      ImagePreviewUI.e(this.ngH.ngC).performClick();
    }
    AppMethodBeat.o(150887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.13.1
 * JD-Core Version:    0.7.0.1
 */