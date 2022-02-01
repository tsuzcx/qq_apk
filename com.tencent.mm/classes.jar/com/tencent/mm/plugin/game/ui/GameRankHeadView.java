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
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;

public class GameRankHeadView
  extends LinearLayout
  implements View.OnClickListener
{
  private com.tencent.mm.plugin.game.model.c IFw;
  private TextView IOH;
  k.a IPj;
  private l IPl;
  private TextView IUb;
  private ImageView IUc;
  private TextView mll;
  
  public GameRankHeadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void exg()
  {
    AppMethodBeat.i(42343);
    if (h.a(getContext(), this.IFw))
    {
      int i = com.tencent.mm.plugin.game.d.c.aHj(this.IFw.field_packageName);
      if (this.IFw.versionCode > i)
      {
        this.IOH.setText(h.i.IaT);
        AppMethodBeat.o(42343);
        return;
      }
      this.IOH.setText(h.i.IaR);
      AppMethodBeat.o(42343);
      return;
    }
    switch (this.IFw.status)
    {
    default: 
      this.IOH.setText(h.i.IaO);
      AppMethodBeat.o(42343);
      return;
    }
    if (this.IPl == null)
    {
      this.IOH.setVisibility(8);
      this.IUc.setVisibility(8);
      AppMethodBeat.o(42343);
      return;
    }
    this.IOH.setVisibility(0);
    this.IUc.setVisibility(0);
    switch (this.IPl.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42343);
      return;
      this.IOH.setText(h.i.IaO);
      AppMethodBeat.o(42343);
      return;
      this.IOH.setText(h.i.IaP);
      AppMethodBeat.o(42343);
      return;
      this.IOH.setText(h.i.IaN);
      AppMethodBeat.o(42343);
      return;
      this.IOH.setText(h.i.IaQ);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42345);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = new d(getContext());
    localObject = new l(this.IFw);
    paramView.a(this.IFw, (l)localObject);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42345);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42342);
    super.onFinishInflate();
    this.mll = ((TextView)findViewById(h.e.HVf));
    this.IUb = ((TextView)findViewById(h.e.HUR));
    this.IOH = ((TextView)findViewById(h.e.HVe));
    this.IUc = ((ImageView)findViewById(h.e.game_more_icon));
    Log.i("MicroMsg.GameRankHeadView", "initView finished");
    AppMethodBeat.o(42342);
  }
  
  public void setData(GameDetailRankUI.a parama)
  {
    AppMethodBeat.i(42344);
    this.mll.setText(parama.IPc);
    this.IUb.setText(parama.IPd);
    this.IFw = parama.IPe;
    this.IFw.hYi = 1203;
    this.IFw.position = 2;
    if (this.IPl == null) {
      this.IPl = new l(this.IFw);
    }
    this.IPl.hV(getContext());
    this.IPl.dvo();
    exg();
    if (this.IPj != null) {
      k.a(this.IPj);
    }
    for (;;)
    {
      this.IOH.setOnClickListener(this);
      AppMethodBeat.o(42344);
      return;
      this.IPj = new k.a()
      {
        public final void f(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(42341);
          if (GameRankHeadView.a(GameRankHeadView.this) != null)
          {
            GameRankHeadView.b(GameRankHeadView.this).hV(GameRankHeadView.this.getContext());
            GameRankHeadView.b(GameRankHeadView.this).dvo();
            if (paramAnonymousBoolean) {
              GameRankHeadView.c(GameRankHeadView.this);
            }
          }
          AppMethodBeat.o(42341);
        }
      };
      k.a(this.IPj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView
 * JD-Core Version:    0.7.0.1
 */