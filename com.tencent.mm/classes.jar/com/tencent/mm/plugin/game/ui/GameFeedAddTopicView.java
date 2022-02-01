package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.q;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bs;

public class GameFeedAddTopicView
  extends LinearLayout
  implements View.OnClickListener
{
  private d tmX;
  private GameFeedTitleDescView tqk;
  private TextView tql;
  
  public GameFeedAddTopicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42096);
    if ((this.tmX == null) || (this.tmX.tdg == null))
    {
      AppMethodBeat.o(42096);
      return;
    }
    if (!bs.isNullOrNil(this.tmX.tdg.thh))
    {
      int i = c.ay(getContext(), this.tmX.tdg.thh);
      e.a(getContext(), 10, 1024, this.tmX.position, i, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), a.ae(this.tmX.tdg.thP, "clickType", "card"));
    }
    AppMethodBeat.o(42096);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42094);
    super.onFinishInflate();
    this.tqk = ((GameFeedTitleDescView)findViewById(2131300441));
    this.tql = ((TextView)findViewById(2131296466));
    setOnClickListener(this);
    AppMethodBeat.o(42094);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42095);
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiM == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42095);
      return;
    }
    this.tmX = paramd;
    setVisibility(0);
    this.tqk.b(paramd.tdg.tiM.Title, paramd.tdg.tiM.Desc, null);
    this.tql.setText(paramd.tdg.tiM.tic);
    if (!this.tmX.tdi)
    {
      a.a(getContext(), 10, 1024, this.tmX.position, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), a.tu(this.tmX.tdg.thP));
      this.tmX.tdi = true;
    }
    AppMethodBeat.o(42095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedAddTopicView
 * JD-Core Version:    0.7.0.1
 */