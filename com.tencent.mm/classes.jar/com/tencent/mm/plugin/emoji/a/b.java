package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.z;

public final class b
{
  private final String TAG;
  public View jFG;
  public Context mContext;
  public TextView oOh;
  public String pHw;
  public ImageView pHx;
  public ImageView pHy;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(108295);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.jFG = z.jV(this.mContext).inflate(2131493814, null);
    chw();
    AppMethodBeat.o(108295);
  }
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108296);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.jFG = paramView;
    chw();
    AppMethodBeat.o(108296);
  }
  
  private void chw()
  {
    AppMethodBeat.i(108297);
    if (this.jFG == null)
    {
      ae.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
      AppMethodBeat.o(108297);
      return;
    }
    this.pHx = ((ImageView)this.jFG.findViewById(2131301154));
    this.oOh = ((TextView)this.jFG.findViewById(2131301198));
    this.pHy = ((ImageView)this.jFG.findViewById(2131301152));
    AppMethodBeat.o(108297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */