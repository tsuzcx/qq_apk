package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.y;

public final class b
{
  private final String TAG;
  public View iIW;
  public Context mContext;
  public TextView nBl;
  public String otH;
  public ImageView otI;
  public ImageView otJ;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(108295);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.iIW = y.js(this.mContext).inflate(2131493814, null);
    bUp();
    AppMethodBeat.o(108295);
  }
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108296);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.iIW = paramView;
    bUp();
    AppMethodBeat.o(108296);
  }
  
  private void bUp()
  {
    AppMethodBeat.i(108297);
    if (this.iIW == null)
    {
      ad.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
      AppMethodBeat.o(108297);
      return;
    }
    this.otI = ((ImageView)this.iIW.findViewById(2131301154));
    this.nBl = ((TextView)this.iIW.findViewById(2131301198));
    this.otJ = ((ImageView)this.iIW.findViewById(2131301152));
    AppMethodBeat.o(108297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */