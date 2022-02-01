package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;

public class GameRankHeadView
  extends LinearLayout
  implements View.OnClickListener
{
  private com.tencent.mm.plugin.game.model.c CLp;
  k.a CUR;
  private l CUT;
  private TextView CUq;
  private TextView CZL;
  private ImageView CZM;
  private TextView jMg;
  
  public GameRankHeadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void dFV()
  {
    AppMethodBeat.i(42343);
    if (h.a(getContext(), this.CLp))
    {
      int i = com.tencent.mm.plugin.game.d.c.aKt(this.CLp.field_packageName);
      if (this.CLp.versionCode > i)
      {
        this.CUq.setText(g.i.CoL);
        AppMethodBeat.o(42343);
        return;
      }
      this.CUq.setText(g.i.CoJ);
      AppMethodBeat.o(42343);
      return;
    }
    switch (this.CLp.status)
    {
    default: 
      this.CUq.setText(g.i.CoG);
      AppMethodBeat.o(42343);
      return;
    }
    if (this.CUT == null)
    {
      this.CUq.setVisibility(8);
      this.CZM.setVisibility(8);
      AppMethodBeat.o(42343);
      return;
    }
    this.CUq.setVisibility(0);
    this.CZM.setVisibility(0);
    switch (this.CUT.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42343);
      return;
      this.CUq.setText(g.i.CoG);
      AppMethodBeat.o(42343);
      return;
      this.CUq.setText(g.i.CoH);
      AppMethodBeat.o(42343);
      return;
      this.CUq.setText(g.i.CoF);
      AppMethodBeat.o(42343);
      return;
      this.CUq.setText(g.i.CoI);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42345);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = new d(getContext());
    localObject = new l(this.CLp);
    paramView.a(this.CLp, (l)localObject);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42345);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42342);
    super.onFinishInflate();
    this.jMg = ((TextView)findViewById(g.e.CiX));
    this.CZL = ((TextView)findViewById(g.e.CiJ));
    this.CUq = ((TextView)findViewById(g.e.CiW));
    this.CZM = ((ImageView)findViewById(g.e.game_more_icon));
    Log.i("MicroMsg.GameRankHeadView", "initView finished");
    AppMethodBeat.o(42342);
  }
  
  public void setData(GameDetailRankUI.a parama)
  {
    AppMethodBeat.i(42344);
    this.jMg.setText(parama.CUK);
    this.CZL.setText(parama.CUL);
    this.CLp = parama.CUM;
    this.CLp.fSl = 1203;
    this.CLp.position = 2;
    if (this.CUT == null) {
      this.CUT = new l(this.CLp);
    }
    this.CUT.gC(getContext());
    this.CUT.cQV();
    dFV();
    if (this.CUR != null) {
      k.a(this.CUR);
    }
    for (;;)
    {
      this.CUq.setOnClickListener(this);
      AppMethodBeat.o(42344);
      return;
      this.CUR = new k.a()
      {
        public final void f(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(42341);
          if (GameRankHeadView.a(GameRankHeadView.this) != null)
          {
            GameRankHeadView.b(GameRankHeadView.this).gC(GameRankHeadView.this.getContext());
            GameRankHeadView.b(GameRankHeadView.this).cQV();
            if (paramAnonymousBoolean) {
              GameRankHeadView.c(GameRankHeadView.this);
            }
          }
          AppMethodBeat.o(42341);
        }
      };
      k.a(this.CUR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView
 * JD-Core Version:    0.7.0.1
 */