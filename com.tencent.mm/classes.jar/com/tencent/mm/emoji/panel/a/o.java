package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "", "()V", "TAG", "", "contentPadding", "", "getContentPadding", "()I", "setContentPadding", "(I)V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "itemSpace", "getItemSpace", "setItemSpace", "minSpaceSize", "getMinSpaceSize", "parentWidth", "spanCount", "getSpanCount", "setSpanCount", "titlePadding", "getTitlePadding", "setTitlePadding", "setParentWidth", "", "width", "updateSize", "plugin-emojisdk_release"})
public abstract class o
{
  private final String TAG = "MicroMsg.PanelSizeResolver";
  public int atv;
  private int gnN;
  private int gnO;
  public int gnP;
  int gnQ;
  
  public o()
  {
    Context localContext = aj.getContext();
    p.g(localContext, "context");
    localContext.getResources();
    this.gnN = a.fromDPToPix(localContext, 400);
  }
  
  public abstract float afQ();
  
  public abstract float afR();
  
  public abstract float afS();
  
  public final void mc(int paramInt)
  {
    ad.i(this.TAG, "setParentWidth: ".concat(String.valueOf(paramInt)));
    this.gnN = paramInt;
    updateSize();
  }
  
  protected final void updateSize()
  {
    float f = this.gnN - afR() * 2.0F;
    if (f < afQ() * 2.0F)
    {
      this.atv = 1;
      return;
    }
    int i = (int)((f - afQ()) / (afQ() + afS())) + 1;
    this.gnO = ((int)((f - afQ() * i) / (i - 1)));
    this.gnP = ((int)((this.gnN - afQ() * i - this.gnO * i) / 2.0F));
    this.gnQ = (this.gnO / 2);
    ad.i(this.TAG, "updateSize: " + afQ() + ", " + afR() + ", " + afS() + ", " + this.atv + ", " + this.gnO + ", " + this.gnP + ", " + this.gnQ);
    this.atv = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.o
 * JD-Core Version:    0.7.0.1
 */