package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;

public final class b
{
  private final String TAG;
  public Context mContext;
  public View nBk;
  public TextView txT;
  public String uzW;
  public ImageView uzX;
  public ImageView uzY;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(258058);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.nBk = ad.kS(this.mContext).inflate(paramInt, null);
    cTK();
    AppMethodBeat.o(258058);
  }
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108296);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.nBk = paramView;
    cTK();
    AppMethodBeat.o(108296);
  }
  
  private void cTK()
  {
    AppMethodBeat.i(108297);
    if (this.nBk == null)
    {
      Log.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
      AppMethodBeat.o(108297);
      return;
    }
    this.uzX = ((ImageView)this.nBk.findViewById(i.e.item_icon));
    this.txT = ((TextView)this.nBk.findViewById(i.e.item_title));
    this.uzY = ((ImageView)this.nBk.findViewById(i.e.item_fg));
    AppMethodBeat.o(108297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */