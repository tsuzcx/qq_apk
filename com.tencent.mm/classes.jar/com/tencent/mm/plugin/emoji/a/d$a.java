package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.emoji.f.c;

public final class d$a
  extends a
{
  public d$a(d paramd, Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  protected final void aGB()
  {
    this.iUy.setVisibility(8);
    this.iUA.setVisibility(8);
    this.iUz.setVisibility(0);
    this.iUB.setVisibility(8);
    this.iUF.setVisibility(8);
    this.iUG.setVisibility(8);
    this.iUx.setVisibility(0);
    this.haW.setVisibility(0);
    this.iUD.setVisibility(0);
    this.iUC.setVisibility(0);
    this.iUC.setBackgroundDrawable(null);
    this.iUE.setVisibility(0);
  }
  
  protected final int[] aGC()
  {
    int i = com.tencent.mm.cb.a.aa(this.mContext, f.c.emoji_paid_item_icon_height);
    return new int[] { i, i };
  }
  
  protected final int aGD()
  {
    return com.tencent.mm.cb.a.aa(this.mContext, f.c.emoji_paid_item_min_height);
  }
  
  protected final boolean aGJ()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d.a
 * JD-Core Version:    0.7.0.1
 */