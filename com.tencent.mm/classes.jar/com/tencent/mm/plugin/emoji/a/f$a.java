package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.emoji.f.c;

public final class f$a
  extends a
{
  public f$a(f paramf, Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  protected final void aGB()
  {
    this.iUy.setVisibility(8);
    aGG();
    this.iUB.setVisibility(8);
    this.iUF.setVisibility(8);
    this.iUG.setVisibility(8);
    this.iUx.setVisibility(0);
    this.haW.setVisibility(0);
    this.iUD.setVisibility(0);
    this.iUC.setVisibility(0);
    this.iUE.setVisibility(0);
  }
  
  protected final int[] aGC()
  {
    int i = com.tencent.mm.cb.a.aa(this.mContext, f.c.emoji_item_store_image_size);
    return new int[] { i, i };
  }
  
  protected final int aGD()
  {
    return com.tencent.mm.cb.a.aa(this.mContext, f.c.emoji_item_store_height);
  }
  
  protected final boolean aGJ()
  {
    return f.a(this.iVi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f.a
 * JD-Core Version:    0.7.0.1
 */