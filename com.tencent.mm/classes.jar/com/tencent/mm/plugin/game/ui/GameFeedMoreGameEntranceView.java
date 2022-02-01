package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.cn;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bs;

public class GameFeedMoreGameEntranceView
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView Up;
  private d tmX;
  
  public GameFeedMoreGameEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42118);
    if ((this.tmX == null) || (this.tmX.tdg == null))
    {
      AppMethodBeat.o(42118);
      return;
    }
    if (!bs.isNullOrNil(this.tmX.tdg.thh))
    {
      int i = c.ay(getContext(), this.tmX.tdg.thh);
      e.a(getContext(), 10, 1024, this.tmX.position, i, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), a.ae(this.tmX.tdg.thP, "clickType", "card"));
    }
    AppMethodBeat.o(42118);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42116);
    super.onFinishInflate();
    this.Up = ((TextView)findViewById(2131302471));
    setOnClickListener(this);
    AppMethodBeat.o(42116);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42117);
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiN == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42117);
      return;
    }
    this.tmX = paramd;
    setVisibility(0);
    this.Up.setText(paramd.tdg.tiN.Desc);
    if (!this.tmX.tdi)
    {
      a.a(getContext(), 10, 1024, this.tmX.position, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), a.tu(this.tmX.tdg.thP));
      this.tmX.tdi = true;
    }
    AppMethodBeat.o(42117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMoreGameEntranceView
 * JD-Core Version:    0.7.0.1
 */