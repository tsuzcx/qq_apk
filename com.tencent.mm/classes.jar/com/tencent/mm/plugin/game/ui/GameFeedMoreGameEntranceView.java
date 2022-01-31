package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.cn;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedMoreGameEntranceView
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView md;
  private d nvA;
  
  public GameFeedMoreGameEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111941);
    if ((this.nvA == null) || (this.nvA.nmr == null))
    {
      AppMethodBeat.o(111941);
      return;
    }
    if (!bo.isNullOrNil(this.nvA.nmr.npR))
    {
      int i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nvA.nmr.npR);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nvA.position, i, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), a.V(this.nvA.nmr.nqt, "clickType", "card"));
    }
    AppMethodBeat.o(111941);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111939);
    super.onFinishInflate();
    this.md = ((TextView)findViewById(2131824428));
    setOnClickListener(this);
    AppMethodBeat.o(111939);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111940);
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nrq == null))
    {
      setVisibility(8);
      AppMethodBeat.o(111940);
      return;
    }
    this.nvA = paramd;
    setVisibility(0);
    this.md.setText(paramd.nmr.nrq.Desc);
    if (!this.nvA.nmt)
    {
      a.a(getContext(), 10, 1024, this.nvA.position, this.nvA.nmr.fKw, GameIndexListView.getSourceScene(), a.lR(this.nvA.nmr.nqt));
      this.nvA.nmt = true;
    }
    AppMethodBeat.o(111940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMoreGameEntranceView
 * JD-Core Version:    0.7.0.1
 */