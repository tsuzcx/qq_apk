package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$a
  extends a
{
  public f$a(f paramf, Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  protected final void bkk()
  {
    AppMethodBeat.i(52743);
    this.ldC.setVisibility(8);
    bks();
    this.ldF.setVisibility(8);
    this.ldJ.setVisibility(8);
    this.ldK.setVisibility(8);
    this.ldB.setVisibility(0);
    this.iJG.setVisibility(0);
    this.ldH.setVisibility(0);
    this.ldG.setVisibility(0);
    this.ldI.setVisibility(0);
    AppMethodBeat.o(52743);
  }
  
  protected final int[] bkl()
  {
    AppMethodBeat.i(52744);
    int i = com.tencent.mm.cb.a.ao(this.mContext, 2131428377);
    AppMethodBeat.o(52744);
    return new int[] { i, i };
  }
  
  protected final int bkm()
  {
    AppMethodBeat.i(52745);
    int i = com.tencent.mm.cb.a.ao(this.mContext, 2131428376);
    AppMethodBeat.o(52745);
    return i;
  }
  
  protected final boolean bkv()
  {
    AppMethodBeat.i(52746);
    boolean bool = f.a(this.lem);
    AppMethodBeat.o(52746);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f.a
 * JD-Core Version:    0.7.0.1
 */