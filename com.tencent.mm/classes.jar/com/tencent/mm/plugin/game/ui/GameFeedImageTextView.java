package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.ca;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e.a;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public class GameFeedImageTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private int kWB = 0;
  private d tmX;
  private GameFeedTitleDescView tqk;
  private GameRoundImageView tqo;
  private LinearLayout tqs;
  private GameRoundImageView tqt;
  private GameRoundImageView tqu;
  private GameRoundImageView tqv;
  private TextView tqw;
  private GameFeedSubscriptView tqx;
  private int tqy = 0;
  private int tqz;
  
  public GameFeedImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42107);
    if ((this.tmX == null) || (this.tmX.tdg == null))
    {
      AppMethodBeat.o(42107);
      return;
    }
    if (!bs.isNullOrNil(this.tmX.tdg.thh))
    {
      int i = c.ay(getContext(), this.tmX.tdg.thh);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.tmX.position, i, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ae(this.tmX.tdg.thP, "clickType", "card"));
    }
    AppMethodBeat.o(42107);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42105);
    super.onFinishInflate();
    this.tqk = ((GameFeedTitleDescView)findViewById(2131300441));
    this.tqo = ((GameRoundImageView)findViewById(2131297217));
    this.tqs = ((LinearLayout)findViewById(2131304854));
    this.tqt = ((GameRoundImageView)findViewById(2131300110));
    this.tqu = ((GameRoundImageView)findViewById(2131304460));
    this.tqv = ((GameRoundImageView)findViewById(2131305770));
    this.tqw = ((TextView)findViewById(2131302472));
    this.tqx = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    this.kWB = (c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    this.tqy = ((this.kWB - com.tencent.mm.cc.a.fromDPToPix(getContext(), 10) * 2) / 3);
    this.tqz = com.tencent.mm.cc.a.fromDPToPix(getContext(), 105);
    if (this.tqy < this.tqz) {
      this.tqz = this.tqy;
    }
    ViewGroup.LayoutParams localLayoutParams = this.tqt.getLayoutParams();
    localLayoutParams.width = this.tqz;
    localLayoutParams.height = this.tqz;
    this.tqt.setLayoutParams(localLayoutParams);
    this.tqu.setLayoutParams(localLayoutParams);
    this.tqv.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(42105);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42106);
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiF == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42106);
      return;
    }
    this.tmX = paramd;
    paramd = paramd.tdg;
    setVisibility(0);
    this.tqk.b(paramd.tiF.Title, paramd.tiF.hkR, null);
    int i;
    if (!bs.gY(paramd.tiF.tkQ))
    {
      i = paramd.tiF.tkQ.size();
      if (i == 1)
      {
        this.tqs.setVisibility(8);
        this.tqo.setVisibility(0);
        com.tencent.mm.plugin.game.f.e.cRL().a(this.tqo, (String)paramd.tiF.tkQ.get(0), getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      }
    }
    for (;;)
    {
      this.tqx.setData(paramd);
      if (!this.tmX.tdi)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.tmX.position, this.tmX.tdg.hOf, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.tu(this.tmX.tdg.thP));
        this.tmX.tdi = true;
      }
      AppMethodBeat.o(42106);
      return;
      this.tqo.setVisibility(8);
      this.tqs.setVisibility(0);
      this.tqw.setVisibility(8);
      Object localObject = new e.a.a();
      ((e.a.a)localObject).tww = true;
      localObject = ((e.a.a)localObject).cRM();
      com.tencent.mm.plugin.game.f.e.cRL().a(this.tqt, (String)paramd.tiF.tkQ.get(0), (e.a)localObject);
      com.tencent.mm.plugin.game.f.e.cRL().a(this.tqu, (String)paramd.tiF.tkQ.get(1), (e.a)localObject);
      if (i > 2)
      {
        com.tencent.mm.plugin.game.f.e.cRL().a(this.tqv, (String)paramd.tiF.tkQ.get(2), (e.a)localObject);
        this.tqv.setVisibility(0);
        if (i > 3)
        {
          this.tqw.setVisibility(0);
          this.tqw.setText(String.format("共%d张", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        this.tqv.setVisibility(4);
        continue;
        this.tqo.setVisibility(8);
        this.tqs.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedImageTextView
 * JD-Core Version:    0.7.0.1
 */