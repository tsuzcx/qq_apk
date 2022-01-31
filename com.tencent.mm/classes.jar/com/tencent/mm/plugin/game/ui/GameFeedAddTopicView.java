package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.o;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedAddTopicView
  extends LinearLayout
  implements View.OnClickListener
{
  private d nvA;
  private GameFeedTitleDescView nyR;
  private TextView nyS;
  
  public GameFeedAddTopicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111924);
    if ((this.nvA == null) || (this.nvA.nmr == null))
    {
      AppMethodBeat.o(111924);
      return;
    }
    if (!bo.isNullOrNil(this.nvA.nmr.npR))
    {
      int i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.npR);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nvA.position, i, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), a.V(this.nvA.nmr.nqt, "clickType", "card"));
    }
    AppMethodBeat.o(111924);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111922);
    super.onFinishInflate();
    this.nyR = ((GameFeedTitleDescView)findViewById(2131824608));
    this.nyS = ((TextView)findViewById(2131824609));
    setOnClickListener(this);
    AppMethodBeat.o(111922);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111923);
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nrp == null))
    {
      setVisibility(8);
      AppMethodBeat.o(111923);
      return;
    }
    this.nvA = paramd;
    setVisibility(0);
    this.nyR.b(paramd.nmr.nrp.Title, paramd.nmr.nrp.Desc, null);
    this.nyS.setText(paramd.nmr.nrp.nqG);
    if (!this.nvA.nmt)
    {
      a.a(getContext(), 10, 1024, this.nvA.position, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), a.lR(this.nvA.nmr.nqt));
      this.nvA.nmt = true;
    }
    AppMethodBeat.o(111923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedAddTopicView
 * JD-Core Version:    0.7.0.1
 */