package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;

public class GameRankHeadView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView gui;
  private TextView nCr;
  private ImageView nCs;
  private com.tencent.mm.plugin.game.model.c noI;
  private TextView nwT;
  j.a nxv;
  private k nxx;
  
  public GameRankHeadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void bHm()
  {
    AppMethodBeat.i(112146);
    if (g.a(getContext(), this.noI))
    {
      int i = com.tencent.mm.plugin.game.f.c.Qy(this.noI.field_packageName);
      if (this.noI.versionCode > i)
      {
        this.nwT.setText(2131300351);
        AppMethodBeat.o(112146);
        return;
      }
      this.nwT.setText(2131300349);
      AppMethodBeat.o(112146);
      return;
    }
    switch (this.noI.status)
    {
    default: 
      this.nwT.setText(2131300346);
      AppMethodBeat.o(112146);
      return;
    }
    if (this.nxx == null)
    {
      this.nwT.setVisibility(8);
      this.nCs.setVisibility(8);
      AppMethodBeat.o(112146);
      return;
    }
    this.nwT.setVisibility(0);
    this.nCs.setVisibility(0);
    switch (this.nxx.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112146);
      return;
      this.nwT.setText(2131300346);
      AppMethodBeat.o(112146);
      return;
      this.nwT.setText(2131300347);
      AppMethodBeat.o(112146);
      return;
      this.nwT.setText(2131300345);
      AppMethodBeat.o(112146);
      return;
      this.nwT.setText(2131300348);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112148);
    paramView = new d(getContext());
    k localk = new k(this.noI);
    paramView.a(this.noI, localk);
    AppMethodBeat.o(112148);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112145);
    super.onFinishInflate();
    this.gui = ((TextView)findViewById(2131824598));
    this.nCr = ((TextView)findViewById(2131824599));
    this.nwT = ((TextView)findViewById(2131824600));
    this.nCs = ((ImageView)findViewById(2131824601));
    ab.i("MicroMsg.GameRankHeadView", "initView finished");
    AppMethodBeat.o(112145);
  }
  
  public void setData(GameDetailRankUI.a parama)
  {
    AppMethodBeat.i(112147);
    this.gui.setText(parama.nxo);
    this.nCr.setText(parama.nxp);
    this.noI = parama.nxq;
    this.noI.cFj = 1203;
    this.noI.position = 2;
    if (this.nxx == null) {
      this.nxx = new k(this.noI);
    }
    this.nxx.em(getContext());
    this.nxx.bjZ();
    bHm();
    if (this.nxv != null) {
      j.a(this.nxv);
    }
    for (;;)
    {
      this.nwT.setOnClickListener(this);
      AppMethodBeat.o(112147);
      return;
      this.nxv = new GameRankHeadView.1(this);
      j.a(this.nxv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView
 * JD-Core Version:    0.7.0.1
 */