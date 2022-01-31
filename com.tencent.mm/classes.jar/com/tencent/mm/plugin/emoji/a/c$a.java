package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.h.a.cy;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.h.a;

public final class c$a
  extends a
{
  public c$a(c paramc, Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  protected final boolean a(h.a parama, View paramView)
  {
    aGH();
    return super.a(parama, paramView);
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
    int i = this.mContext.getResources().getDimensionPixelSize(f.c.BigIconSize);
    return new int[] { i, i };
  }
  
  protected final int aGD()
  {
    return -1;
  }
  
  protected final boolean aGJ()
  {
    return true;
  }
  
  public final void aGM()
  {
    if (this.iUv == null) {
      return;
    }
    switch (aGH())
    {
    default: 
      this.iUB.setVisibility(8);
      this.iUC.setBackgroundResource(f.d.btn_solid_white);
      this.iUC.setVisibility(0);
      this.iUE.setVisibility(0);
      this.iUE.setText(f.h.emoji_store_uninstall_emoji);
      this.iUE.setTextColor(this.mContext.getResources().getColorStateList(f.b.black_text_color_selector));
      this.iUF.setVisibility(4);
      this.iUF.setImageResource(f.d.emoji_download);
      this.iUG.setVisibility(4);
      return;
    case 0: 
    case 3: 
      this.iUB.setVisibility(8);
      this.iUC.setBackgroundResource(f.d.btn_solid_green);
      this.iUC.setVisibility(0);
      this.iUE.setVisibility(0);
      this.iUE.setText(f.h.emoji_store_download);
      this.iUE.setTextColor(this.mContext.getResources().getColorStateList(f.b.white_text_color_selector));
      this.iUF.setVisibility(4);
      this.iUF.setImageResource(f.d.emoji_download);
      this.iUG.setVisibility(4);
      return;
    }
    aGK();
  }
  
  protected final void b(h.a parama, View paramView)
  {
    super.b(parama, paramView);
    if (com.tencent.mm.plugin.emoji.h.a.Bh(getProductId()))
    {
      parama = new cy();
      parama.bJc.bJd = getProductId();
      paramView = parama.bJc;
      if (!com.tencent.mm.plugin.emoji.h.a.aJh()) {
        break label88;
      }
    }
    label88:
    for (int i = 7;; i = 3)
    {
      paramView.status = i;
      parama.bJc.progress = getProgress();
      parama.bJc.bJe = this.iUv.iVX;
      com.tencent.mm.sdk.b.a.udP.m(parama);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c.a
 * JD-Core Version:    0.7.0.1
 */