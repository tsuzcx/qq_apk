package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "", "()V", "TAG", "", "contentPadding", "", "getContentPadding", "()I", "setContentPadding", "(I)V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "itemSpace", "getItemSpace", "setItemSpace", "minSpaceSize", "getMinSpaceSize", "parentWidth", "spanCount", "getSpanCount", "setSpanCount", "titlePadding", "getTitlePadding", "setTitlePadding", "setParentWidth", "", "width", "updateSize", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class o
{
  private final String TAG = "MicroMsg.PanelSizeResolver";
  private int aMZ;
  public int contentPadding;
  private int itemSpace;
  int mls;
  public int spanCount;
  
  public o()
  {
    Context localContext = MMApplicationContext.getContext();
    localContext.getResources();
    this.aMZ = a.fromDPToPix(localContext, 400);
  }
  
  public abstract float aVN();
  
  public abstract float aVO();
  
  public abstract float aVP();
  
  public final void rI(int paramInt)
  {
    Log.i(this.TAG, s.X("setParentWidth: ", Integer.valueOf(paramInt)));
    if (paramInt <= 0) {
      return;
    }
    this.aMZ = paramInt;
    updateSize();
  }
  
  protected final void updateSize()
  {
    float f = this.aMZ - aVO() * 2.0F;
    if (f < aVN() * 2.0F)
    {
      this.spanCount = 1;
      return;
    }
    int i = (int)((f - aVN()) / (aVN() + aVP())) + 1;
    this.itemSpace = ((int)((f - aVN() * i) / (i - 1)));
    this.contentPadding = ((int)((this.aMZ - aVN() * i - this.itemSpace * i) / 2.0F));
    this.mls = (this.itemSpace / 2);
    Log.i(this.TAG, "updateSize: " + aVN() + ", " + aVO() + ", " + aVP() + ", " + this.spanCount + ", " + this.itemSpace + ", " + this.contentPadding + ", " + this.mls);
    this.spanCount = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.o
 * JD-Core Version:    0.7.0.1
 */