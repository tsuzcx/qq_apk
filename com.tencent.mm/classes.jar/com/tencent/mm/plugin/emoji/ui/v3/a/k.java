package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "", "()V", "TAG", "", "contentPadding", "", "getContentPadding", "()I", "setContentPadding", "(I)V", "edgeSize", "", "getEdgeSize", "()F", "itemSize", "getItemSize", "itemSpace", "getItemSpace", "setItemSpace", "minSpaceSize", "getMinSpaceSize", "parentWidth", "getParentWidth", "setParentWidth", "spanCount", "getSpanCount", "setSpanCount", "titlePadding", "getTitlePadding", "setTitlePadding", "updateParentWidth", "", "width", "updateSize", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class k
{
  private final String TAG = "MicroMsg.EmojiStoreV3ItemSizeResolver";
  private int aMZ = MMApplicationContext.getResources().getDisplayMetrics().widthPixels;
  private int contentPadding;
  public int itemSpace;
  public int mls;
  public int spanCount;
  
  public final void KH(int paramInt)
  {
    this.contentPadding = paramInt;
  }
  
  public final void KI(int paramInt)
  {
    Log.i(this.TAG, s.X("setParentWidth: ", Integer.valueOf(paramInt)));
    if (paramInt <= 0) {
      return;
    }
    this.aMZ = paramInt;
    updateSize();
  }
  
  public abstract float aVN();
  
  public abstract float aVO();
  
  public abstract float aVP();
  
  public void updateSize()
  {
    float f = this.aMZ - aVO() * 2.0F;
    if (f < aVN() * 2.0F)
    {
      this.spanCount = 1;
      return;
    }
    int i = (int)((aVP() + f) / (aVN() + aVP()));
    this.itemSpace = ((int)((f - aVN() * i) / (i - 1)));
    this.contentPadding = ((int)((this.aMZ - aVN() * i - this.itemSpace * i) / 2.0F));
    Log.i(this.TAG, "updateSize: " + aVN() + ", " + aVO() + ", " + aVP() + ", " + this.spanCount + ", " + this.itemSpace + ", " + this.contentPadding);
    this.spanCount = i;
  }
  
  public final int wR()
  {
    return this.aMZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.k
 * JD-Core Version:    0.7.0.1
 */