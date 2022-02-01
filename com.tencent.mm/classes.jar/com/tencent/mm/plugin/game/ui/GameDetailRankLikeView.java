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
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.x;
import com.tencent.mm.game.report.f;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.game.d.dy;
import com.tencent.mm.plugin.game.d.dz;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;

public class GameDetailRankLikeView
  extends LinearLayout
  implements View.OnClickListener
{
  String mAppId;
  private int udq;
  aa umO;
  aa.a umP;
  private Drawable umQ;
  private Drawable umR;
  private Animation umS;
  private ImageView umT;
  private TextView umU;
  
  public GameDetailRankLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void nm(boolean paramBoolean)
  {
    AppMethodBeat.i(41989);
    if (paramBoolean)
    {
      this.umT.setImageDrawable(this.umQ);
      AppMethodBeat.o(41989);
      return;
    }
    this.umT.setImageDrawable(this.umR);
    AppMethodBeat.o(41989);
  }
  
  private void setCount(int paramInt)
  {
    AppMethodBeat.i(41990);
    if (paramInt > 99)
    {
      this.umU.setText("99+");
      AppMethodBeat.o(41990);
      return;
    }
    if (paramInt == 0)
    {
      this.umU.setText("");
      AppMethodBeat.o(41990);
      return;
    }
    this.umU.setText(String.valueOf(paramInt));
    AppMethodBeat.o(41990);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41991);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    if (u.aAm().equals(this.umP.dDy)) {
      if (this.umP.udB > 0)
      {
        localObject1 = new Intent(getContext(), GameDetailRankLikedUI.class);
        ((Intent)localObject1).putExtra("extra_appdi", this.mAppId);
        paramView = getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41991);
      return;
      if (!this.umP.udC)
      {
        this.umP.udC = true;
        paramView = this.umP;
        paramView.udB += 1;
        this.umO.cZu();
        paramView = this.mAppId;
        localObject1 = this.umP.dDy;
        Object localObject2 = new b.a();
        ((b.a)localObject2).hNM = new dy();
        ((b.a)localObject2).hNN = new dz();
        ((b.a)localObject2).uri = "/cgi-bin/mmgame-bin/upfriend";
        ((b.a)localObject2).funcId = 1330;
        localObject2 = ((b.a)localObject2).aDC();
        dy localdy = (dy)((com.tencent.mm.al.b)localObject2).hNK.hNQ;
        localdy.gsT = paramView;
        localdy.uki = ((String)localObject1);
        x.a((com.tencent.mm.al.b)localObject2, new GameDetailRankLikeView.1(this));
        f.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.udq, null);
        qY();
        this.umT.startAnimation(this.umS);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41987);
    super.onFinishInflate();
    this.umQ = getContext().getResources().getDrawable(2131232567);
    this.umR = getContext().getResources().getDrawable(2131232566);
    this.umS = AnimationUtils.loadAnimation(getContext(), 2130772124);
    inflate(getContext(), 2131494286, this);
    setOnClickListener(this);
    this.umT = ((ImageView)findViewById(2131301413));
    this.umU = ((TextView)findViewById(2131301415));
    AppMethodBeat.o(41987);
  }
  
  final void qY()
  {
    AppMethodBeat.i(41988);
    if (this.umP != null)
    {
      nm(this.umP.udC);
      setCount(this.umP.udB);
      AppMethodBeat.o(41988);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(41988);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.udq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView
 * JD-Core Version:    0.7.0.1
 */