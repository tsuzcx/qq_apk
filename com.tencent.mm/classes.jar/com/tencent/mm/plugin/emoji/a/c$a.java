package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.db;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.h.a;

public final class c$a
  extends a
{
  public c$a(c paramc, Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  protected final boolean a(h.a parama, View paramView)
  {
    AppMethodBeat.i(52723);
    bkt();
    boolean bool = super.a(parama, paramView);
    AppMethodBeat.o(52723);
    return bool;
  }
  
  protected final void b(h.a parama, View paramView)
  {
    AppMethodBeat.i(52724);
    super.b(parama, paramView);
    if (com.tencent.mm.plugin.emoji.h.a.Lj(getProductId()))
    {
      parama = new db();
      parama.cqw.cqx = getProductId();
      paramView = parama.cqw;
      if (!com.tencent.mm.plugin.emoji.h.a.bmI()) {
        break label98;
      }
    }
    label98:
    for (int i = 7;; i = 3)
    {
      paramView.status = i;
      parama.cqw.progress = getProgress();
      parama.cqw.cqy = this.ldz.lfd;
      com.tencent.mm.sdk.b.a.ymk.l(parama);
      AppMethodBeat.o(52724);
      return;
    }
  }
  
  protected final void bkk()
  {
    AppMethodBeat.i(52722);
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
    AppMethodBeat.o(52722);
  }
  
  protected final int[] bkl()
  {
    AppMethodBeat.i(52725);
    int i = this.mContext.getResources().getDimensionPixelSize(2131427498);
    AppMethodBeat.o(52725);
    return new int[] { i, i };
  }
  
  protected final int bkm()
  {
    return -1;
  }
  
  protected final boolean bkv()
  {
    return true;
  }
  
  public final void bky()
  {
    AppMethodBeat.i(52726);
    if (this.ldz == null)
    {
      AppMethodBeat.o(52726);
      return;
    }
    switch (bkt())
    {
    default: 
      this.ldF.setVisibility(8);
      this.ldG.setBackgroundResource(2130838050);
      this.ldG.setVisibility(0);
      this.ldI.setVisibility(0);
      this.ldI.setText(2131299260);
      this.ldI.setTextColor(this.mContext.getResources().getColorStateList(2131690741));
      this.ldJ.setVisibility(4);
      this.ldJ.setImageResource(2130838609);
      this.ldK.setVisibility(4);
      AppMethodBeat.o(52726);
      return;
    case 0: 
    case 3: 
      this.ldF.setVisibility(8);
      this.ldG.setBackgroundResource(2130838045);
      this.ldG.setVisibility(0);
      this.ldI.setVisibility(0);
      this.ldI.setText(2131299193);
      this.ldI.setTextColor(this.mContext.getResources().getColorStateList(2131690799));
      this.ldJ.setVisibility(4);
      this.ldJ.setImageResource(2130838609);
      this.ldK.setVisibility(4);
      AppMethodBeat.o(52726);
      return;
    }
    bkw();
    AppMethodBeat.o(52726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c.a
 * JD-Core Version:    0.7.0.1
 */