package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "", "()V", "TAG", "", "contentPadding", "", "getContentPadding", "()I", "setContentPadding", "(I)V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "itemSpace", "getItemSpace", "setItemSpace", "minSpaceSize", "getMinSpaceSize", "parentWidth", "spanCount", "getSpanCount", "setSpanCount", "titlePadding", "getTitlePadding", "setTitlePadding", "setParentWidth", "", "width", "updateSize", "plugin-emojisdk_release"})
public abstract class q
{
  private final String TAG = "MicroMsg.PanelSizeResolver";
  public int contentPadding;
  private int itemSpace;
  private int jMo;
  int jMp;
  public int spanCount;
  
  public q()
  {
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "context");
    localContext.getResources();
    this.jMo = a.fromDPToPix(localContext, 400);
  }
  
  public abstract float aCP();
  
  public abstract float aCQ();
  
  public abstract float aCR();
  
  public final void rG(int paramInt)
  {
    Log.i(this.TAG, "setParentWidth: ".concat(String.valueOf(paramInt)));
    if (paramInt <= 0) {
      return;
    }
    this.jMo = paramInt;
    updateSize();
  }
  
  protected final void updateSize()
  {
    float f = this.jMo - aCQ() * 2.0F;
    if (f < aCP() * 2.0F)
    {
      this.spanCount = 1;
      return;
    }
    int i = (int)((f - aCP()) / (aCP() + aCR())) + 1;
    this.itemSpace = ((int)((f - aCP() * i) / (i - 1)));
    this.contentPadding = ((int)((this.jMo - aCP() * i - this.itemSpace * i) / 2.0F));
    this.jMp = (this.itemSpace / 2);
    Log.i(this.TAG, "updateSize: " + aCP() + ", " + aCQ() + ", " + aCR() + ", " + this.spanCount + ", " + this.itemSpace + ", " + this.contentPadding + ", " + this.jMp);
    this.spanCount = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.q
 * JD-Core Version:    0.7.0.1
 */