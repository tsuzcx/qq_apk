package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.d;

final class ad$6
  implements b.d
{
  ad$6(ad paramad) {}
  
  public final void a(ImageView paramImageView, final View paramView1, View paramView2)
  {
    AppMethodBeat.i(222867);
    if (paramImageView != null)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramImageView.getLayoutParams();
      i = this.mgZ.getContext().getResources().getDimensionPixelOffset(2131165746);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.gravity = 17;
      paramImageView.setLayoutParams(localLayoutParams);
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      paramImageView.clearColorFilter();
      paramImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(this.mgZ.getContext().getResources(), 2131689590));
      paramImageView.setColorFilter(this.mgZ.mgo.getForegroundColor(), PorterDuff.Mode.SRC_ATOP);
      paramImageView.setBackgroundResource(2131230957);
      i = this.mgZ.getContext().getResources().getDimensionPixelOffset(2131165568);
      paramImageView.setPadding(i, paramImageView.getPaddingTop(), i, paramImageView.getPaddingBottom());
    }
    if (paramView1 != null)
    {
      paramImageView = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
      i = this.mgZ.getContext().getResources().getDimensionPixelOffset(2131165743);
      paramImageView.height = i;
      paramImageView.width = i;
      paramImageView.gravity = 17;
      paramImageView.leftMargin = this.mgZ.getContext().getResources().getDimensionPixelOffset(2131165744);
      paramImageView.rightMargin = this.mgZ.getContext().getResources().getDimensionPixelOffset(2131165745);
      paramView1.setLayoutParams(paramImageView);
      if (this.mgZ.mgo.getForegroundColor() != -1) {
        break label290;
      }
    }
    label290:
    for (int i = 2131230978;; i = 2131230979)
    {
      paramView1.setBackgroundResource(i);
      if (paramView2 != null) {
        paramView2.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(222866);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$14$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (paramView1 != null)
            {
              paramView1.onTouchEvent(paramAnonymousMotionEvent);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$14$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(222866);
              return true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$14$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(222866);
            return false;
          }
        });
      }
      AppMethodBeat.o(222867);
      return;
    }
  }
  
  public final int bvI()
  {
    return 2131165744;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad.6
 * JD-Core Version:    0.7.0.1
 */