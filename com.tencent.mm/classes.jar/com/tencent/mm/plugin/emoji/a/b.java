package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;

public final class b
{
  private final String TAG;
  public TextView kvS;
  public View ldP;
  public String ldX;
  public ImageView ldY;
  public ImageView ldZ;
  public Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(52719);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.ldP = w.hM(this.mContext).inflate(2130969402, null);
    bkA();
    AppMethodBeat.o(52719);
  }
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(52720);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.ldP = paramView;
    bkA();
    AppMethodBeat.o(52720);
  }
  
  private void bkA()
  {
    AppMethodBeat.i(52721);
    if (this.ldP == null)
    {
      ab.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
      AppMethodBeat.o(52721);
      return;
    }
    this.ldY = ((ImageView)this.ldP.findViewById(2131823589));
    this.kvS = ((TextView)this.ldP.findViewById(2131823680));
    this.ldZ = ((ImageView)this.ldP.findViewById(2131823674));
    AppMethodBeat.o(52721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */