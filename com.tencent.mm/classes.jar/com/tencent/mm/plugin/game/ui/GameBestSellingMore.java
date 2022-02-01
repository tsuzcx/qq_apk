package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bs;

public class GameBestSellingMore
  extends LinearLayout
  implements View.OnClickListener
{
  private d tmX;
  private TextView tmY;
  private ImageView tmZ;
  
  public GameBestSellingMore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41896);
    if ((this.tmX == null) || (this.tmX.tdg == null) || (this.tmX.tdg.tiL == null) || (bs.isNullOrNil(this.tmX.tdg.tiL.tjp)))
    {
      AppMethodBeat.o(41896);
      return;
    }
    int i = c.ay(getContext(), this.tmX.tdg.tiL.tjp);
    e.a(getContext(), 10, 1022, 999, i, null, GameIndexListView.getSourceScene(), a.tu(this.tmX.tdg.thP));
    AppMethodBeat.o(41896);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41894);
    super.onFinishInflate();
    this.tmY = ((TextView)findViewById(2131302471));
    this.tmZ = ((ImageView)findViewById(2131302470));
    setOnClickListener(this);
    AppMethodBeat.o(41894);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41895);
    this.tmX = paramd;
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiL == null) || (bs.isNullOrNil(paramd.tdg.tiL.tiU)))
    {
      this.tmY.setVisibility(8);
      this.tmZ.setVisibility(8);
      setPadding(0, 0, 0, 0);
      AppMethodBeat.o(41895);
      return;
    }
    setPadding(getResources().getDimensionPixelSize(2131165430), 0, getResources().getDimensionPixelSize(2131165430), getResources().getDimensionPixelSize(2131165430));
    this.tmY.setVisibility(0);
    this.tmZ.setVisibility(0);
    this.tmY.setText(paramd.tdg.tiL.tiU);
    AppMethodBeat.o(41895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingMore
 * JD-Core Version:    0.7.0.1
 */