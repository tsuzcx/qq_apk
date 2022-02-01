package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "", "()V", "TAG", "", "contentPadding", "", "getContentPadding", "()I", "setContentPadding", "(I)V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "itemSpace", "getItemSpace", "setItemSpace", "minSpaceSize", "getMinSpaceSize", "parentWidth", "spanCount", "getSpanCount", "setSpanCount", "titlePadding", "getTitlePadding", "setTitlePadding", "setParentWidth", "", "width", "updateSize", "plugin-emojisdk_release"})
public abstract class o
{
  private final String TAG = "MicroMsg.PanelSizeResolver";
  public int aqI;
  private int fQq;
  private int fQr;
  public int fQs;
  int fQt;
  
  public o()
  {
    Context localContext = aj.getContext();
    k.g(localContext, "context");
    localContext.getResources();
    this.fQq = a.fromDPToPix(localContext, 400);
  }
  
  public abstract float ace();
  
  public abstract float acf();
  
  public abstract float acg();
  
  protected final void ach()
  {
    float f = this.fQq - acf() * 2.0F;
    if (f < ace() * 2.0F)
    {
      this.aqI = 1;
      return;
    }
    int i = (int)((f - ace()) / (ace() + acg())) + 1;
    this.fQr = ((int)((f - ace() * i) / (i - 1)));
    this.fQs = ((int)((this.fQq - ace() * i - this.fQr * i) / 2.0F));
    this.fQt = (this.fQr / 2);
    ad.i(this.TAG, "updateSize: " + ace() + ", " + acf() + ", " + acg() + ", " + this.aqI + ", " + this.fQr + ", " + this.fQs + ", " + this.fQt);
    this.aqI = i;
  }
  
  public final void lF(int paramInt)
  {
    ad.i(this.TAG, "setParentWidth: ".concat(String.valueOf(paramInt)));
    this.fQq = paramInt;
    ach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.o
 * JD-Core Version:    0.7.0.1
 */