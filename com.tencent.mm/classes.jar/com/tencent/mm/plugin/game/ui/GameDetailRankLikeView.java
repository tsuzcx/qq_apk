package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.x;
import com.tencent.mm.game.report.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.game.d.dk;
import com.tencent.mm.plugin.game.d.dl;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;

public class GameDetailRankLikeView
  extends LinearLayout
  implements View.OnClickListener
{
  String mAppId;
  private int tfA;
  aa tor;
  aa.a tos;
  private Drawable tot;
  private Drawable tou;
  private Animation tov;
  private ImageView tow;
  private TextView tox;
  
  public GameDetailRankLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void mS(boolean paramBoolean)
  {
    AppMethodBeat.i(41989);
    if (paramBoolean)
    {
      this.tow.setImageDrawable(this.tot);
      AppMethodBeat.o(41989);
      return;
    }
    this.tow.setImageDrawable(this.tou);
    AppMethodBeat.o(41989);
  }
  
  private void setCount(int paramInt)
  {
    AppMethodBeat.i(41990);
    if (paramInt > 99)
    {
      this.tox.setText("99+");
      AppMethodBeat.o(41990);
      return;
    }
    if (paramInt == 0)
    {
      this.tox.setText("");
      AppMethodBeat.o(41990);
      return;
    }
    this.tox.setText(String.valueOf(paramInt));
    AppMethodBeat.o(41990);
  }
  
  final void cRp()
  {
    AppMethodBeat.i(41988);
    if (this.tos != null)
    {
      mS(this.tos.tfM);
      setCount(this.tos.tfL);
      AppMethodBeat.o(41988);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(41988);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41991);
    Object localObject1;
    if (u.axw().equals(this.tos.drG))
    {
      if (this.tos.tfL > 0)
      {
        localObject1 = new Intent(getContext(), GameDetailRankLikedUI.class);
        ((Intent)localObject1).putExtra("extra_appdi", this.mAppId);
        paramView = getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(41991);
      }
    }
    else if (!this.tos.tfM)
    {
      this.tos.tfM = true;
      paramView = this.tos;
      paramView.tfL += 1;
      this.tor.cQO();
      paramView = this.mAppId;
      localObject1 = this.tos.drG;
      Object localObject2 = new b.a();
      ((b.a)localObject2).hvt = new dk();
      ((b.a)localObject2).hvu = new dl();
      ((b.a)localObject2).uri = "/cgi-bin/mmgame-bin/upfriend";
      ((b.a)localObject2).funcId = 1330;
      localObject2 = ((b.a)localObject2).aAz();
      dk localdk = (dk)((b)localObject2).hvr.hvw;
      localdk.fZx = paramView;
      localdk.tlJ = ((String)localObject1);
      x.a((b)localObject2, new GameDetailRankLikeView.1(this));
      e.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.tfA, null);
      cRp();
      this.tow.startAnimation(this.tov);
    }
    AppMethodBeat.o(41991);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41987);
    super.onFinishInflate();
    this.tot = getContext().getResources().getDrawable(2131232567);
    this.tou = getContext().getResources().getDrawable(2131232566);
    this.tov = AnimationUtils.loadAnimation(getContext(), 2130772124);
    inflate(getContext(), 2131494286, this);
    setOnClickListener(this);
    this.tow = ((ImageView)findViewById(2131301413));
    this.tox = ((TextView)findViewById(2131301415));
    AppMethodBeat.o(41987);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.tfA = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView
 * JD-Core Version:    0.7.0.1
 */