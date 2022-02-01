package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.z;

public final class b
{
  private final String TAG;
  public View jCI;
  public Context mContext;
  public TextView oHF;
  public String pAS;
  public ImageView pAT;
  public ImageView pAU;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(108295);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.jCI = z.jO(this.mContext).inflate(2131493814, null);
    cgg();
    AppMethodBeat.o(108295);
  }
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108296);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.jCI = paramView;
    cgg();
    AppMethodBeat.o(108296);
  }
  
  private void cgg()
  {
    AppMethodBeat.i(108297);
    if (this.jCI == null)
    {
      ad.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
      AppMethodBeat.o(108297);
      return;
    }
    this.pAT = ((ImageView)this.jCI.findViewById(2131301154));
    this.oHF = ((TextView)this.jCI.findViewById(2131301198));
    this.pAU = ((ImageView)this.jCI.findViewById(2131301152));
    AppMethodBeat.o(108297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */