package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class c$c$1
  implements View.OnClickListener
{
  c$c$1(c.c paramc) {}
  
  public final void onClick(View paramView)
  {
    if (c.c.a(this.jSm).get() != null)
    {
      paramView = (c)c.c.a(this.jSm).get();
      if (paramView.jSh != null) {
        paramView.jSh.aPd();
      }
      paramView.dismiss();
      return;
    }
    y.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.c.c.1
 * JD-Core Version:    0.7.0.1
 */