package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$a
  extends a
{
  public d$a(d paramd, Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  protected final void bkk()
  {
    AppMethodBeat.i(52734);
    this.ldC.setVisibility(8);
    this.ldE.setVisibility(8);
    this.ldD.setVisibility(0);
    this.ldF.setVisibility(8);
    this.ldJ.setVisibility(8);
    this.ldK.setVisibility(8);
    this.ldB.setVisibility(0);
    this.iJG.setVisibility(0);
    this.ldH.setVisibility(0);
    this.ldG.setVisibility(0);
    this.ldG.setBackgroundDrawable(null);
    this.ldI.setVisibility(0);
    AppMethodBeat.o(52734);
  }
  
  protected final int[] bkl()
  {
    AppMethodBeat.i(52735);
    int i = com.tencent.mm.cb.a.ao(this.mContext, 2131428381);
    AppMethodBeat.o(52735);
    return new int[] { i, i };
  }
  
  protected final int bkm()
  {
    AppMethodBeat.i(52736);
    int i = com.tencent.mm.cb.a.ao(this.mContext, 2131428382);
    AppMethodBeat.o(52736);
    return i;
  }
  
  protected final boolean bkv()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d.a
 * JD-Core Version:    0.7.0.1
 */