package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.ui.widget.b.a;

final class f$d$4
  implements View.OnLongClickListener
{
  f$d$4(f.d paramd) {}
  
  private void k(View paramView, int paramInt1, int paramInt2)
  {
    int i = ((Integer)paramView.getTag(n.e.fav_filter_data_pos)).intValue();
    f.c localc = this.khY.khK.rf(i);
    if (localc == null) {
      return;
    }
    a locala = new a(this.khY.khK.mContext);
    this.khY.khT.setVisibility(0);
    locala.wfc = new f.d.4.1(this);
    locala.a(paramView, new f.d.4.2(this, localc), new f.d.4.3(this, localc, i), paramInt1, paramInt2);
  }
  
  public final boolean onLongClick(View paramView)
  {
    if (this.khY.khK.khJ) {
      return false;
    }
    if ((paramView.getTag(n.e.touch_loc) instanceof int[]))
    {
      int[] arrayOfInt = (int[])paramView.getTag(n.e.touch_loc);
      k(paramView, arrayOfInt[0], arrayOfInt[1]);
    }
    for (;;)
    {
      return true;
      k(paramView, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.4
 * JD-Core Version:    0.7.0.1
 */