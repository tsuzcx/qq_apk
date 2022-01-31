package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.c.a;

final class f$d$4
  implements View.OnLongClickListener
{
  f$d$4(f.d paramd) {}
  
  private void t(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74576);
    int i = ((Integer)paramView.getTag(2131820604)).intValue();
    f.c localc = this.mCF.mCs.wb(i);
    if (localc == null)
    {
      AppMethodBeat.o(74576);
      return;
    }
    a locala = new a(this.mCF.mCs.mContext);
    this.mCF.mCA.setVisibility(0);
    locala.AxS = new f.d.4.1(this);
    locala.a(paramView, new f.d.4.2(this, localc), new f.d.4.3(this, localc, i), paramInt1, paramInt2);
    AppMethodBeat.o(74576);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(74575);
    if (this.mCF.mCs.mCr)
    {
      AppMethodBeat.o(74575);
      return false;
    }
    if ((paramView.getTag(2131820681) instanceof int[]))
    {
      int[] arrayOfInt = (int[])paramView.getTag(2131820681);
      t(paramView, arrayOfInt[0], arrayOfInt[1]);
    }
    for (;;)
    {
      AppMethodBeat.o(74575);
      return true;
      t(paramView, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.4
 * JD-Core Version:    0.7.0.1
 */