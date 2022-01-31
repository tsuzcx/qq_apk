package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.n.a;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.sdk.platformtools.x;

public final class a
{
  public Button fks;
  public TextView iCY;
  public long kjh = b.aPL();
  public boolean kjj = false;
  public View kjk;
  public a.a kjl;
  
  public final void aRZ()
  {
    this.iCY.setText(this.iCY.getContext().getString(n.i.fav_clean_capacity_info, new Object[] { b.ev(this.kjh) }));
    this.fks.setEnabled(false);
  }
  
  public final void hide()
  {
    if (!this.kjj) {}
    while (this.kjk.getVisibility() == 8) {
      return;
    }
    this.kjk.setVisibility(8);
    this.kjk.startAnimation(AnimationUtils.loadAnimation(this.kjk.getContext(), n.a.fast_faded_out));
  }
  
  public final void show()
  {
    if (!this.kjj) {
      if (this.kjk != null) {}
    }
    while (this.kjk.getVisibility() == 0)
    {
      return;
      if ((this.kjk instanceof ViewStub)) {
        this.kjk = ((ViewStub)this.kjk).inflate();
      }
      this.iCY = ((TextView)this.kjk.findViewById(n.e.fav_clean_delete_info_tv));
      if (!x.cqF()) {
        this.iCY.setTextSize(1, 14.0F);
      }
      this.fks = ((Button)this.kjk.findViewById(n.e.fav_clean_del_btn));
      aRZ();
      this.fks.setOnClickListener(new a.1(this));
      this.kjj = true;
    }
    this.kjk.setVisibility(0);
    this.kjk.startAnimation(AnimationUtils.loadAnimation(this.kjk.getContext(), n.a.fast_faded_in));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */