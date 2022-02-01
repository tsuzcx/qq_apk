package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "", "()V", "TAG", "", "contentPadding", "", "getContentPadding", "()I", "setContentPadding", "(I)V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "itemSpace", "getItemSpace", "setItemSpace", "minSpaceSize", "getMinSpaceSize", "parentWidth", "spanCount", "getSpanCount", "setSpanCount", "titlePadding", "getTitlePadding", "setTitlePadding", "setParentWidth", "", "width", "updateSize", "plugin-emojisdk_release"})
public abstract class o
{
  private final String TAG = "MicroMsg.PanelSizeResolver";
  public int atv;
  private int gqj;
  private int gqk;
  public int gql;
  int gqm;
  
  public o()
  {
    Context localContext = ak.getContext();
    p.g(localContext, "context");
    localContext.getResources();
    this.gqj = a.fromDPToPix(localContext, 400);
  }
  
  public abstract float age();
  
  public abstract float agf();
  
  public abstract float agg();
  
  public final void mf(int paramInt)
  {
    ae.i(this.TAG, "setParentWidth: ".concat(String.valueOf(paramInt)));
    this.gqj = paramInt;
    updateSize();
  }
  
  protected final void updateSize()
  {
    float f = this.gqj - agf() * 2.0F;
    if (f < age() * 2.0F)
    {
      this.atv = 1;
      return;
    }
    int i = (int)((f - age()) / (age() + agg())) + 1;
    this.gqk = ((int)((f - age() * i) / (i - 1)));
    this.gql = ((int)((this.gqj - age() * i - this.gqk * i) / 2.0F));
    this.gqm = (this.gqk / 2);
    ae.i(this.TAG, "updateSize: " + age() + ", " + agf() + ", " + agg() + ", " + this.atv + ", " + this.gqk + ", " + this.gql + ", " + this.gqm);
    this.atv = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.o
 * JD-Core Version:    0.7.0.1
 */