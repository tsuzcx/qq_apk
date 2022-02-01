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
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;
import com.tencent.mm.plugin.game.protobuf.em;
import com.tencent.mm.plugin.game.protobuf.en;

public class GameDetailRankLikeView
  extends LinearLayout
  implements View.OnClickListener
{
  private int IFc;
  aa IOK;
  aa.a IOL;
  private Drawable IOM;
  private Drawable ION;
  private Animation IOO;
  private ImageView IOP;
  private TextView IOQ;
  String mAppId;
  
  public GameDetailRankLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void setCount(int paramInt)
  {
    AppMethodBeat.i(41990);
    if (paramInt > 99)
    {
      this.IOQ.setText("99+");
      AppMethodBeat.o(41990);
      return;
    }
    if (paramInt == 0)
    {
      this.IOQ.setText("");
      AppMethodBeat.o(41990);
      return;
    }
    this.IOQ.setText(String.valueOf(paramInt));
    AppMethodBeat.o(41990);
  }
  
  private void wz(boolean paramBoolean)
  {
    AppMethodBeat.i(41989);
    if (paramBoolean)
    {
      this.IOP.setImageDrawable(this.IOM);
      AppMethodBeat.o(41989);
      return;
    }
    this.IOP.setImageDrawable(this.ION);
    AppMethodBeat.o(41989);
  }
  
  final void Oi()
  {
    AppMethodBeat.i(41988);
    if (this.IOL != null)
    {
      wz(this.IOL.IFn);
      setCount(this.IOL.IFm);
      AppMethodBeat.o(41988);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(41988);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41991);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    if (com.tencent.mm.model.z.bAM().equals(this.IOL.hVQ)) {
      if (this.IOL.IFm > 0)
      {
        localObject1 = new Intent(getContext(), GameDetailRankLikedUI.class);
        ((Intent)localObject1).putExtra("extra_appdi", this.mAppId);
        paramView = getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41991);
      return;
      if (!this.IOL.IFn)
      {
        this.IOL.IFn = true;
        paramView = this.IOL;
        paramView.IFm += 1;
        this.IOK.fGQ();
        paramView = this.mAppId;
        localObject1 = this.IOL.hVQ;
        Object localObject2 = new c.a();
        ((c.a)localObject2).otE = new em();
        ((c.a)localObject2).otF = new en();
        ((c.a)localObject2).uri = "/cgi-bin/mmgame-bin/upfriend";
        ((c.a)localObject2).funcId = 1330;
        localObject2 = ((c.a)localObject2).bEF();
        em localem = (em)c.b.b(((c)localObject2).otB);
        localem.muA = paramView;
        localem.IMg = ((String)localObject1);
        com.tencent.mm.am.z.a((c)localObject2, new GameDetailRankLikeView.1(this));
        g.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.IFc, null);
        Oi();
        this.IOP.startAnimation(this.IOO);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41987);
    super.onFinishInflate();
    this.IOM = getContext().getResources().getDrawable(h.d.HTs);
    this.ION = getContext().getResources().getDrawable(h.d.HTr);
    this.IOO = AnimationUtils.loadAnimation(getContext(), h.a.HSG);
    inflate(getContext(), h.f.HZb, this);
    setOnClickListener(this);
    this.IOP = ((ImageView)findViewById(h.e.HWN));
    this.IOQ = ((TextView)findViewById(h.e.HWO));
    AppMethodBeat.o(41987);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.IFc = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView
 * JD-Core Version:    0.7.0.1
 */