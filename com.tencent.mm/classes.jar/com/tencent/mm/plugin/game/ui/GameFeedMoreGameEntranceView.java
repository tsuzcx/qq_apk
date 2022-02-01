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
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedMoreGameEntranceView
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView Tu;
  private d sfe;
  
  public GameFeedMoreGameEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42118);
    if ((this.sfe == null) || (this.sfe.rVo == null))
    {
      AppMethodBeat.o(42118);
      return;
    }
    if (!bt.isNullOrNil(this.sfe.rVo.rZo))
    {
      int i = c.ax(getContext(), this.sfe.rVo.rZo);
      e.a(getContext(), 10, 1024, this.sfe.position, i, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), a.ad(this.sfe.rVo.rZW, "clickType", "card"));
    }
    AppMethodBeat.o(42118);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42116);
    super.onFinishInflate();
    this.Tu = ((TextView)findViewById(2131302471));
    setOnClickListener(this);
    AppMethodBeat.o(42116);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42117);
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saT == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42117);
      return;
    }
    this.sfe = paramd;
    setVisibility(0);
    this.Tu.setText(paramd.rVo.saT.Desc);
    if (!this.sfe.rVq)
    {
      a.a(getContext(), 10, 1024, this.sfe.position, this.sfe.rVo.hnC, GameIndexListView.getSourceScene(), a.qh(this.sfe.rVo.rZW));
      this.sfe.rVq = true;
    }
    AppMethodBeat.o(42117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedMoreGameEntranceView
 * JD-Core Version:    0.7.0.1
 */