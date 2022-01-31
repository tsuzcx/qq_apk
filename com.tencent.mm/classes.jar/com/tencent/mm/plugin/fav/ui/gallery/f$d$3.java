package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class f$d$3
  implements View.OnClickListener
{
  f$d$3(f.d paramd, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74571);
    boolean bool;
    if (!this.mCF.mCC.isChecked())
    {
      bool = true;
      if (e.a.bym().mCl.size() >= 9) {
        break label140;
      }
      this.mCF.mCC.setChecked(bool);
      if (bool) {
        break label126;
      }
      this.mCF.mCA.setVisibility(8);
    }
    for (;;)
    {
      if (this.mCF.mCs.mCq != null)
      {
        int i = ((Integer)paramView.getTag()).intValue();
        paramView = this.mCF.mCs.wb(i);
        this.mCF.mCs.mCq.a(bool, paramView, i);
      }
      AppMethodBeat.o(74571);
      return;
      bool = false;
      break;
      label126:
      this.mCF.mCA.setVisibility(0);
      continue;
      label140:
      if (!bool) {
        this.mCF.mCC.setChecked(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.3
 * JD-Core Version:    0.7.0.1
 */