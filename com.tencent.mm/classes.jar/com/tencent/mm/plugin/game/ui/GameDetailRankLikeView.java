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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.model.aa.a;
import com.tencent.mm.plugin.game.protobuf.eh;
import com.tencent.mm.plugin.game.protobuf.ei;

public class GameDetailRankLikeView
  extends LinearLayout
  implements View.OnClickListener
{
  String mAppId;
  private int xGR;
  com.tencent.mm.plugin.game.model.aa xQk;
  aa.a xQl;
  private Drawable xQm;
  private Drawable xQn;
  private Animation xQo;
  private ImageView xQp;
  private TextView xQq;
  
  public GameDetailRankLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void pW(boolean paramBoolean)
  {
    AppMethodBeat.i(41989);
    if (paramBoolean)
    {
      this.xQp.setImageDrawable(this.xQm);
      AppMethodBeat.o(41989);
      return;
    }
    this.xQp.setImageDrawable(this.xQn);
    AppMethodBeat.o(41989);
  }
  
  private void setCount(int paramInt)
  {
    AppMethodBeat.i(41990);
    if (paramInt > 99)
    {
      this.xQq.setText("99+");
      AppMethodBeat.o(41990);
      return;
    }
    if (paramInt == 0)
    {
      this.xQq.setText("");
      AppMethodBeat.o(41990);
      return;
    }
    this.xQq.setText(String.valueOf(paramInt));
    AppMethodBeat.o(41990);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41991);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
    if (z.aTY().equals(this.xQl.dWq)) {
      if (this.xQl.xHc > 0)
      {
        localObject1 = new Intent(getContext(), GameDetailRankLikedUI.class);
        ((Intent)localObject1).putExtra("extra_appdi", this.mAppId);
        paramView = getContext();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailRankLikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41991);
      return;
      if (!this.xQl.xHd)
      {
        this.xQl.xHd = true;
        paramView = this.xQl;
        paramView.xHc += 1;
        this.xQk.dVM();
        paramView = this.mAppId;
        localObject1 = this.xQl.dWq;
        Object localObject2 = new d.a();
        ((d.a)localObject2).iLN = new eh();
        ((d.a)localObject2).iLO = new ei();
        ((d.a)localObject2).uri = "/cgi-bin/mmgame-bin/upfriend";
        ((d.a)localObject2).funcId = 1330;
        localObject2 = ((d.a)localObject2).aXF();
        eh localeh = (eh)((d)localObject2).iLK.iLR;
        localeh.hik = paramView;
        localeh.xNG = ((String)localObject1);
        com.tencent.mm.ak.aa.a((d)localObject2, new GameDetailRankLikeView.1(this));
        f.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.xGR, null);
        rb();
        this.xQp.startAnimation(this.xQo);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41987);
    super.onFinishInflate();
    this.xQm = getContext().getResources().getDrawable(2131232956);
    this.xQn = getContext().getResources().getDrawable(2131232955);
    this.xQo = AnimationUtils.loadAnimation(getContext(), 2130772148);
    inflate(getContext(), 2131494848, this);
    setOnClickListener(this);
    this.xQp = ((ImageView)findViewById(2131303172));
    this.xQq = ((TextView)findViewById(2131303176));
    AppMethodBeat.o(41987);
  }
  
  final void rb()
  {
    AppMethodBeat.i(41988);
    if (this.xQl != null)
    {
      pW(this.xQl.xHd);
      setCount(this.xQl.xHc);
      AppMethodBeat.o(41988);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(41988);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.xGR = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView
 * JD-Core Version:    0.7.0.1
 */