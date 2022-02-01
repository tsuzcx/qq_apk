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
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ae;

public class GameRankHeadView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView gqi;
  private TextView uDC;
  private ImageView uDD;
  private com.tencent.mm.plugin.game.model.c uoT;
  k.a uyI;
  private l uyK;
  private TextView uyi;
  
  public GameRankHeadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void dcH()
  {
    AppMethodBeat.i(42343);
    if (h.a(getContext(), this.uoT))
    {
      int i = com.tencent.mm.plugin.game.f.c.anq(this.uoT.field_packageName);
      if (this.uoT.versionCode > i)
      {
        this.uyi.setText(2131759855);
        AppMethodBeat.o(42343);
        return;
      }
      this.uyi.setText(2131759853);
      AppMethodBeat.o(42343);
      return;
    }
    switch (this.uoT.status)
    {
    default: 
      this.uyi.setText(2131759850);
      AppMethodBeat.o(42343);
      return;
    }
    if (this.uyK == null)
    {
      this.uyi.setVisibility(8);
      this.uDD.setVisibility(8);
      AppMethodBeat.o(42343);
      return;
    }
    this.uyi.setVisibility(0);
    this.uDD.setVisibility(0);
    switch (this.uyK.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42343);
      return;
      this.uyi.setText(2131759850);
      AppMethodBeat.o(42343);
      return;
      this.uyi.setText(2131759851);
      AppMethodBeat.o(42343);
      return;
      this.uyi.setText(2131759849);
      AppMethodBeat.o(42343);
      return;
      this.uyi.setText(2131759852);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42345);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    paramView = new d(getContext());
    localObject = new l(this.uoT);
    paramView.a(this.uoT, (l)localObject);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42345);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42342);
    super.onFinishInflate();
    this.gqi = ((TextView)findViewById(2131300423));
    this.uDC = ((TextView)findViewById(2131300408));
    this.uyi = ((TextView)findViewById(2131300422));
    this.uDD = ((ImageView)findViewById(2131300512));
    ae.i("MicroMsg.GameRankHeadView", "initView finished");
    AppMethodBeat.o(42342);
  }
  
  public void setData(GameDetailRankUI.a parama)
  {
    AppMethodBeat.i(42344);
    this.gqi.setText(parama.uyB);
    this.uDC.setText(parama.uyC);
    this.uoT = parama.uyD;
    this.uoT.dGL = 1203;
    this.uoT.position = 2;
    if (this.uyK == null) {
      this.uyK = new l(this.uoT);
    }
    this.uyK.fC(getContext());
    this.uyK.ceA();
    dcH();
    if (this.uyI != null) {
      k.a(this.uyI);
    }
    for (;;)
    {
      this.uyi.setOnClickListener(this);
      AppMethodBeat.o(42344);
      return;
      this.uyI = new k.a()
      {
        public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(42341);
          if (GameRankHeadView.a(GameRankHeadView.this) != null)
          {
            GameRankHeadView.b(GameRankHeadView.this).fC(GameRankHeadView.this.getContext());
            GameRankHeadView.b(GameRankHeadView.this).ceA();
            if (paramAnonymousBoolean) {
              GameRankHeadView.c(GameRankHeadView.this);
            }
          }
          AppMethodBeat.o(42341);
        }
      };
      k.a(this.uyI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView
 * JD-Core Version:    0.7.0.1
 */