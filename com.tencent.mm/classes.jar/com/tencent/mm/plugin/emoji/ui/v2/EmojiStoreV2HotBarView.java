package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class EmojiStoreV2HotBarView
  extends LinearLayout
{
  private View ipf;
  private View jgR;
  private TextView jgS;
  private View jgT;
  private TextView jgU;
  private View.OnClickListener jgV = new EmojiStoreV2HotBarView.1(this);
  
  public EmojiStoreV2HotBarView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  @TargetApi(11)
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.ipf = ((ViewGroup)com.tencent.mm.ui.y.gt(getContext()).inflate(f.f.emoji_store_v2_hot_bar_view, this)).findViewById(f.e.root);
    this.jgR = this.ipf.findViewById(f.e.emoji_designer_catalog);
    this.jgS = ((TextView)this.ipf.findViewById(f.e.emoji_more));
    this.jgS.setText(getResources().getText(f.h.emoji_store_new_suggest) + " ");
    this.jgT = this.ipf.findViewById(f.e.designer_product);
    this.jgT.setOnClickListener(new EmojiStoreV2HotBarView.2(this));
    this.jgU = ((TextView)this.ipf.findViewById(f.e.new_tips));
    aJA();
    setMoreOnClickListener(this.jgV);
  }
  
  public final void aJA()
  {
    boolean bool = ((Boolean)g.DP().Dz().get(ac.a.uof, Boolean.valueOf(false))).booleanValue();
    TextView localTextView;
    if (this.jgU != null)
    {
      localTextView = this.jgU;
      if (!bool) {
        break label47;
      }
    }
    label47:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public View getRootView()
  {
    return this.ipf;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
  }
  
  public void setDesignerCatalogViewPadding(boolean paramBoolean)
  {
    if ((this.jgR != null) && (!paramBoolean))
    {
      int i = a.aa(getContext(), f.c.ListPadding);
      int j = a.aa(getContext(), f.c.MiddlePadding);
      int k = a.aa(getContext(), f.c.NormalPadding);
      this.jgR.setPadding(k, i, k, j);
    }
  }
  
  public void setDesignerEmojiViewVisibility(int paramInt)
  {
    if (this.jgT != null) {
      this.jgT.setVisibility(paramInt);
    }
  }
  
  public void setMoreOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jgS != null) {
      this.jgS.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.ipf != null)
    {
      this.ipf.setVisibility(paramInt);
      return;
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView
 * JD-Core Version:    0.7.0.1
 */