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
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedAddTopicView
  extends LinearLayout
  implements View.OnClickListener
{
  private d sfe;
  private GameFeedTitleDescView sir;
  private TextView sis;
  
  public GameFeedAddTopicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42096);
    if ((this.sfe == null) || (this.sfe.rVo == null))
    {
      AppMethodBeat.o(42096);
      return;
    }
    if (!bt.isNullOrNil(this.sfe.rVo.rZo))
    {
      int i = c.ax(getContext(), this.sfe.rVo.rZo);
      e.a(getContext(), 10, 1024, this.sfe.position, i, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), a.ad(this.sfe.rVo.rZW, "clickType", "card"));
    }
    AppMethodBeat.o(42096);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42094);
    super.onFinishInflate();
    this.sir = ((GameFeedTitleDescView)findViewById(2131300441));
    this.sis = ((TextView)findViewById(2131296466));
    setOnClickListener(this);
    AppMethodBeat.o(42094);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42095);
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saS == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42095);
      return;
    }
    this.sfe = paramd;
    setVisibility(0);
    this.sir.b(paramd.rVo.saS.Title, paramd.rVo.saS.Desc, null);
    this.sis.setText(paramd.rVo.saS.saj);
    if (!this.sfe.rVq)
    {
      a.a(getContext(), 10, 1024, this.sfe.position, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), a.qh(this.sfe.rVo.rZW));
      this.sfe.rVq = true;
    }
    AppMethodBeat.o(42095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedAddTopicView
 * JD-Core Version:    0.7.0.1
 */