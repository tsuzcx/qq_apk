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
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.cn;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public class GameFeedImageTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private int lxZ = 0;
  private GameFeedTitleDescView uAd;
  private GameRoundImageView uAh;
  private LinearLayout uAl;
  private GameRoundImageView uAm;
  private GameRoundImageView uAn;
  private GameRoundImageView uAo;
  private TextView uAp;
  private GameFeedSubscriptView uAq;
  private int uAr = 0;
  private int uAs;
  private d uwS;
  
  public GameFeedImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42107);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((this.uwS == null) || (this.uwS.ulY == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42107);
      return;
    }
    if (!bu.isNullOrNil(this.uwS.ulY.uqf))
    {
      int i = c.aD(getContext(), this.uwS.ulY.uqf);
      f.a(getContext(), 10, 1024, this.uwS.position, i, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.ak(this.uwS.ulY.ura, "clickType", "card"));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedImageTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42107);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42105);
    super.onFinishInflate();
    this.uAd = ((GameFeedTitleDescView)findViewById(2131300441));
    this.uAh = ((GameRoundImageView)findViewById(2131297217));
    this.uAl = ((LinearLayout)findViewById(2131304854));
    this.uAm = ((GameRoundImageView)findViewById(2131300110));
    this.uAn = ((GameRoundImageView)findViewById(2131304460));
    this.uAo = ((GameRoundImageView)findViewById(2131305770));
    this.uAp = ((TextView)findViewById(2131302472));
    this.uAq = ((GameFeedSubscriptView)findViewById(2131305528));
    setOnClickListener(this);
    this.lxZ = (c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
    this.uAr = ((this.lxZ - com.tencent.mm.cb.a.fromDPToPix(getContext(), 10) * 2) / 3);
    this.uAs = com.tencent.mm.cb.a.fromDPToPix(getContext(), 105);
    if (this.uAr < this.uAs) {
      this.uAs = this.uAr;
    }
    ViewGroup.LayoutParams localLayoutParams = this.uAm.getLayoutParams();
    localLayoutParams.width = this.uAs;
    localLayoutParams.height = this.uAs;
    this.uAm.setLayoutParams(localLayoutParams);
    this.uAn.setLayoutParams(localLayoutParams);
    this.uAo.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(42105);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42106);
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.urX == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42106);
      return;
    }
    this.uwS = paramd;
    paramd = paramd.ulY;
    setVisibility(0);
    this.uAd.b(paramd.urX.Title, paramd.urX.hFS, null);
    int i;
    if (!bu.ht(paramd.urX.uuu))
    {
      i = paramd.urX.uuu.size();
      if (i == 1)
      {
        this.uAl.setVisibility(8);
        this.uAh.setVisibility(0);
        e.ddh().a(this.uAh, (String)paramd.urX.uuu.get(0), getResources().getDimensionPixelSize(2131165425), getResources().getDimensionPixelSize(2131165424), c.getScreenWidth(getContext()) - getPaddingLeft() - getPaddingRight());
      }
    }
    for (;;)
    {
      this.uAq.setData(paramd);
      if (!this.uwS.uma)
      {
        com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1024, this.uwS.position, this.uwS.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uwS.ulY.ura));
        this.uwS.uma = true;
      }
      AppMethodBeat.o(42106);
      return;
      this.uAh.setVisibility(8);
      this.uAl.setVisibility(0);
      this.uAp.setVisibility(8);
      Object localObject = new e.a.a();
      ((e.a.a)localObject).uHh = true;
      localObject = ((e.a.a)localObject).ddi();
      e.ddh().a(this.uAm, (String)paramd.urX.uuu.get(0), (e.a)localObject);
      e.ddh().a(this.uAn, (String)paramd.urX.uuu.get(1), (e.a)localObject);
      if (i > 2)
      {
        e.ddh().a(this.uAo, (String)paramd.urX.uuu.get(2), (e.a)localObject);
        this.uAo.setVisibility(0);
        if (i > 3)
        {
          this.uAp.setVisibility(0);
          this.uAp.setText(String.format("共%d张", new Object[] { Integer.valueOf(i) }));
        }
      }
      else
      {
        this.uAo.setVisibility(4);
        continue;
        this.uAh.setVisibility(8);
        this.uAl.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedImageTextView
 * JD-Core Version:    0.7.0.1
 */