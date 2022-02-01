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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.x;
import com.tencent.mm.game.report.f;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.game.d.eh;
import com.tencent.mm.plugin.game.d.ei;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;

public class GameDetailRankLikeView
  extends LinearLayout
  implements View.OnClickListener
{
  String mAppId;
  private int uoy;
  aa uyl;
  aa.a uym;
  private Drawable uyn;
  private Drawable uyo;
  private Animation uyp;
  private ImageView uyq;
  private TextView uyr;
  
  public GameDetailRankLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void nq(boolean paramBoolean)
  {
    AppMethodBeat.i(41989);
    if (paramBoolean)
    {
      this.uyq.setImageDrawable(this.uyn);
      AppMethodBeat.o(41989);
      return;
    }
    this.uyq.setImageDrawable(this.uyo);
    AppMethodBeat.o(41989);
  }
  
  private void setCount(int paramInt)
  {
    AppMethodBeat.i(41990);
    if (paramInt > 99)
    {
      this.uyr.setText("99+");
      AppMethodBeat.o(41990);
      return;
    }
    if (paramInt == 0)
    {
      this.uyr.setText("");
      AppMethodBeat.o(41990);
      return;
    }
    this.uyr.setText(String.valueOf(paramInt));
    AppMethodBeat.o(41990);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41991);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    if (v.aAC().equals(this.uym.dED)) {
      if (this.uym.uoJ > 0)
      {
        localObject1 = new Intent(getContext(), GameDetailRankLikedUI.class);
        ((Intent)localObject1).putExtra("extra_appdi", this.mAppId);
        paramView = getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41991);
      return;
      if (!this.uym.uoK)
      {
        this.uym.uoK = true;
        paramView = this.uym;
        paramView.uoJ += 1;
        this.uyl.dcf();
        paramView = this.mAppId;
        localObject1 = this.uym.dED;
        Object localObject2 = new b.a();
        ((b.a)localObject2).hQF = new eh();
        ((b.a)localObject2).hQG = new ei();
        ((b.a)localObject2).uri = "/cgi-bin/mmgame-bin/upfriend";
        ((b.a)localObject2).funcId = 1330;
        localObject2 = ((b.a)localObject2).aDS();
        eh localeh = (eh)((com.tencent.mm.ak.b)localObject2).hQD.hQJ;
        localeh.gvv = paramView;
        localeh.uvF = ((String)localObject1);
        x.a((com.tencent.mm.ak.b)localObject2, new GameDetailRankLikeView.1(this));
        f.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.uoy, null);
        qY();
        this.uyq.startAnimation(this.uyp);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41987);
    super.onFinishInflate();
    this.uyn = getContext().getResources().getDrawable(2131232567);
    this.uyo = getContext().getResources().getDrawable(2131232566);
    this.uyp = AnimationUtils.loadAnimation(getContext(), 2130772124);
    inflate(getContext(), 2131494286, this);
    setOnClickListener(this);
    this.uyq = ((ImageView)findViewById(2131301413));
    this.uyr = ((TextView)findViewById(2131301415));
    AppMethodBeat.o(41987);
  }
  
  final void qY()
  {
    AppMethodBeat.i(41988);
    if (this.uym != null)
    {
      nq(this.uym.uoK);
      setCount(this.uym.uoJ);
      AppMethodBeat.o(41988);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(41988);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.uoy = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView
 * JD-Core Version:    0.7.0.1
 */