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
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.x;
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
  private int rXI;
  private Drawable sgA;
  private Animation sgB;
  private ImageView sgC;
  private TextView sgD;
  aa sgx;
  aa.a sgy;
  private Drawable sgz;
  
  public GameDetailRankLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void lZ(boolean paramBoolean)
  {
    AppMethodBeat.i(41989);
    if (paramBoolean)
    {
      this.sgC.setImageDrawable(this.sgz);
      AppMethodBeat.o(41989);
      return;
    }
    this.sgC.setImageDrawable(this.sgA);
    AppMethodBeat.o(41989);
  }
  
  private void setCount(int paramInt)
  {
    AppMethodBeat.i(41990);
    if (paramInt > 99)
    {
      this.sgD.setText("99+");
      AppMethodBeat.o(41990);
      return;
    }
    if (paramInt == 0)
    {
      this.sgD.setText("");
      AppMethodBeat.o(41990);
      return;
    }
    this.sgD.setText(String.valueOf(paramInt));
    AppMethodBeat.o(41990);
  }
  
  final void cEf()
  {
    AppMethodBeat.i(41988);
    if (this.sgy != null)
    {
      lZ(this.sgy.rXU);
      setCount(this.sgy.rXT);
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
    if (u.aqG().equals(this.sgy.dtV))
    {
      if (this.sgy.rXT > 0)
      {
        localObject1 = new Intent(getContext(), GameDetailRankLikedUI.class);
        ((Intent)localObject1).putExtra("extra_appdi", this.mAppId);
        paramView = getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(41991);
      }
    }
    else if (!this.sgy.rXU)
    {
      this.sgy.rXU = true;
      paramView = this.sgy;
      paramView.rXT += 1;
      this.sgx.cDE();
      paramView = this.mAppId;
      localObject1 = this.sgy.dtV;
      Object localObject2 = new b.a();
      ((b.a)localObject2).gUU = new dk();
      ((b.a)localObject2).gUV = new dl();
      ((b.a)localObject2).uri = "/cgi-bin/mmgame-bin/upfriend";
      ((b.a)localObject2).funcId = 1330;
      localObject2 = ((b.a)localObject2).atI();
      dk localdk = (dk)((b)localObject2).gUS.gUX;
      localdk.fVC = paramView;
      localdk.sdP = ((String)localObject1);
      x.a((b)localObject2, new GameDetailRankLikeView.1(this));
      e.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.rXI, null);
      cEf();
      this.sgC.startAnimation(this.sgB);
    }
    AppMethodBeat.o(41991);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41987);
    super.onFinishInflate();
    this.sgz = getContext().getResources().getDrawable(2131232567);
    this.sgA = getContext().getResources().getDrawable(2131232566);
    this.sgB = AnimationUtils.loadAnimation(getContext(), 2130772124);
    inflate(getContext(), 2131494286, this);
    setOnClickListener(this);
    this.sgC = ((ImageView)findViewById(2131301413));
    this.sgD = ((TextView)findViewById(2131301415));
    AppMethodBeat.o(41987);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.rXI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView
 * JD-Core Version:    0.7.0.1
 */