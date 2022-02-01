package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "", "()V", "TAG", "", "contentPadding", "", "getContentPadding", "()I", "setContentPadding", "(I)V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "itemSpace", "getItemSpace", "setItemSpace", "minSpaceSize", "getMinSpaceSize", "parentWidth", "spanCount", "getSpanCount", "setSpanCount", "titlePadding", "getTitlePadding", "setTitlePadding", "setParentWidth", "", "width", "updateSize", "plugin-emojisdk_release"})
public abstract class o
{
  private final String TAG = "MicroMsg.PanelSizeResolver";
  public int att;
  private int hbc;
  private int hbd;
  public int hbe;
  int hbf;
  
  public o()
  {
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "context");
    localContext.getResources();
    this.hbc = a.fromDPToPix(localContext, 400);
  }
  
  public abstract float avS();
  
  public abstract float avT();
  
  public abstract float avU();
  
  public final void pn(int paramInt)
  {
    Log.i(this.TAG, "setParentWidth: ".concat(String.valueOf(paramInt)));
    if (paramInt <= 0) {
      return;
    }
    this.hbc = paramInt;
    updateSize();
  }
  
  protected final void updateSize()
  {
    float f = this.hbc - avT() * 2.0F;
    if (f < avS() * 2.0F)
    {
      this.att = 1;
      return;
    }
    int i = (int)((f - avS()) / (avS() + avU())) + 1;
    this.hbd = ((int)((f - avS() * i) / (i - 1)));
    this.hbe = ((int)((this.hbc - avS() * i - this.hbd * i) / 2.0F));
    this.hbf = (this.hbd / 2);
    Log.i(this.TAG, "updateSize: " + avS() + ", " + avT() + ", " + avU() + ", " + this.att + ", " + this.hbd + ", " + this.hbe + ", " + this.hbf);
    this.att = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.o
 * JD-Core Version:    0.7.0.1
 */