package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class ImagePreviewUI$24
  implements View.OnClickListener
{
  ImagePreviewUI$24(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21522);
    paramView = this.ngC;
    boolean bool;
    if (!ImagePreviewUI.b(this.ngC))
    {
      bool = true;
      ImagePreviewUI.c(paramView, bool);
      if (!ImagePreviewUI.b(this.ngC)) {
        break label145;
      }
      ImagePreviewUI.c(this.ngC).setImageResource(2131231906);
      if (ImagePreviewUI.d(this.ngC).size() == 0) {
        ImagePreviewUI.e(this.ngC).performClick();
      }
    }
    for (;;)
    {
      ImagePreviewUI.f(this.ngC).setText(this.ngC.getContext().getString(2131300289) + ImagePreviewUI.bEE());
      ImagePreviewUI.a(this.ngC, ImagePreviewUI.g(this.ngC).intValue());
      AppMethodBeat.o(21522);
      return;
      bool = false;
      break;
      label145:
      ImagePreviewUI.c(this.ngC).setImageResource(2131231905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.24
 * JD-Core Version:    0.7.0.1
 */