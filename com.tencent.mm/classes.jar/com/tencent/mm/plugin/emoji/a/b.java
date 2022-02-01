package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.z;

public final class b
{
  private final String TAG;
  public View jja;
  public Context mContext;
  public String oXi;
  public ImageView oXj;
  public ImageView oXk;
  public TextView oel;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(108295);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.jja = z.jD(this.mContext).inflate(2131493814, null);
    cbC();
    AppMethodBeat.o(108295);
  }
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108296);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.jja = paramView;
    cbC();
    AppMethodBeat.o(108296);
  }
  
  private void cbC()
  {
    AppMethodBeat.i(108297);
    if (this.jja == null)
    {
      ac.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
      AppMethodBeat.o(108297);
      return;
    }
    this.oXj = ((ImageView)this.jja.findViewById(2131301154));
    this.oel = ((TextView)this.jja.findViewById(2131301198));
    this.oXk = ((ImageView)this.jja.findViewById(2131301152));
    AppMethodBeat.o(108297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */