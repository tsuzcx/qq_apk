package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.emoji.f.e;

public final class b
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
  public View iUL;
  public String iUT;
  public ImageView iUU;
  public ImageView iUV;
  public TextView iuO;
  public Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.iUL = com.tencent.mm.ui.y.gt(this.mContext).inflate(paramInt, null);
    aGO();
  }
  
  public b(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.iUL = paramView;
    aGO();
  }
  
  private void aGO()
  {
    if (this.iUL == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
      return;
    }
    this.iUU = ((ImageView)this.iUL.findViewById(f.e.item_icon));
    this.iuO = ((TextView)this.iUL.findViewById(f.e.item_title));
    this.iUV = ((ImageView)this.iUL.findViewById(f.e.item_fg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */