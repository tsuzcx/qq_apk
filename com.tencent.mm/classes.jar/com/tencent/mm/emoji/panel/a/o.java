package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "", "()V", "TAG", "", "contentPadding", "", "getContentPadding", "()I", "setContentPadding", "(I)V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "itemSpace", "getItemSpace", "setItemSpace", "minSpaceSize", "getMinSpaceSize", "parentWidth", "spanCount", "getSpanCount", "setSpanCount", "titlePadding", "getTitlePadding", "setTitlePadding", "setParentWidth", "", "width", "updateSize", "plugin-emojisdk_release"})
public abstract class o
{
  private final String TAG = "MicroMsg.PanelSizeResolver";
  public int arE;
  private int fUl;
  private int fUm;
  public int fUn;
  int fUo;
  
  public o()
  {
    Context localContext = ai.getContext();
    k.g(localContext, "context");
    localContext.getResources();
    this.fUl = a.fromDPToPix(localContext, 400);
  }
  
  public abstract float adk();
  
  public abstract float adl();
  
  public abstract float adm();
  
  protected final void adn()
  {
    float f = this.fUl - adl() * 2.0F;
    if (f < adk() * 2.0F)
    {
      this.arE = 1;
      return;
    }
    int i = (int)((f - adk()) / (adk() + adm())) + 1;
    this.fUm = ((int)((f - adk() * i) / (i - 1)));
    this.fUn = ((int)((this.fUl - adk() * i - this.fUm * i) / 2.0F));
    this.fUo = (this.fUm / 2);
    ac.i(this.TAG, "updateSize: " + adk() + ", " + adl() + ", " + adm() + ", " + this.arE + ", " + this.fUm + ", " + this.fUn + ", " + this.fUo);
    this.arE = i;
  }
  
  public final void lC(int paramInt)
  {
    ac.i(this.TAG, "setParentWidth: ".concat(String.valueOf(paramInt)));
    this.fUl = paramInt;
    adn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.o
 * JD-Core Version:    0.7.0.1
 */