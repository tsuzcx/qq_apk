package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;

public final class b
{
  private final String TAG;
  public View kHq;
  public Context mContext;
  public String qXi;
  public ImageView qXj;
  public ImageView qXk;
  public TextView qbV;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(108295);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.kHq = aa.jQ(this.mContext).inflate(2131493968, null);
    cFi();
    AppMethodBeat.o(108295);
  }
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108296);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.kHq = paramView;
    cFi();
    AppMethodBeat.o(108296);
  }
  
  private void cFi()
  {
    AppMethodBeat.i(108297);
    if (this.kHq == null)
    {
      Log.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
      AppMethodBeat.o(108297);
      return;
    }
    this.qXj = ((ImageView)this.kHq.findViewById(2131302812));
    this.qbV = ((TextView)this.kHq.findViewById(2131302870));
    this.qXk = ((ImageView)this.kHq.findViewById(2131302809));
    AppMethodBeat.o(108297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */