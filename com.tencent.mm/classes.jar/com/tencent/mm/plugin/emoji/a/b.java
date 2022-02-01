package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;

public final class b
{
  private final String TAG;
  public Context mContext;
  public View qAv;
  public TextView wCq;
  public ImageView xGA;
  public ImageView xGB;
  public String xGz;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(269934);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.qAv = af.mU(this.mContext).inflate(paramInt, null);
    dyf();
    AppMethodBeat.o(269934);
  }
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108296);
    this.TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    this.mContext = paramContext;
    this.qAv = paramView;
    dyf();
    AppMethodBeat.o(108296);
  }
  
  private void dyf()
  {
    AppMethodBeat.i(108297);
    if (this.qAv == null)
    {
      Log.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
      AppMethodBeat.o(108297);
      return;
    }
    this.xGA = ((ImageView)this.qAv.findViewById(h.e.item_icon));
    this.wCq = ((TextView)this.qAv.findViewById(h.e.item_title));
    this.xGB = ((ImageView)this.qAv.findViewById(h.e.item_fg));
    AppMethodBeat.o(108297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */