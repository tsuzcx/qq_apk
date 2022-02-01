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
import com.tencent.mm.sdk.platformtools.ad;

public class GameRankHeadView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView gnM;
  private com.tencent.mm.plugin.game.model.c udL;
  private TextView umL;
  k.a unm;
  private l uno;
  private TextView usj;
  private ImageView usk;
  
  public GameRankHeadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void cZW()
  {
    AppMethodBeat.i(42343);
    if (h.a(getContext(), this.udL))
    {
      int i = com.tencent.mm.plugin.game.f.c.ams(this.udL.field_packageName);
      if (this.udL.versionCode > i)
      {
        this.umL.setText(2131759855);
        AppMethodBeat.o(42343);
        return;
      }
      this.umL.setText(2131759853);
      AppMethodBeat.o(42343);
      return;
    }
    switch (this.udL.status)
    {
    default: 
      this.umL.setText(2131759850);
      AppMethodBeat.o(42343);
      return;
    }
    if (this.uno == null)
    {
      this.umL.setVisibility(8);
      this.usk.setVisibility(8);
      AppMethodBeat.o(42343);
      return;
    }
    this.umL.setVisibility(0);
    this.usk.setVisibility(0);
    switch (this.uno.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42343);
      return;
      this.umL.setText(2131759850);
      AppMethodBeat.o(42343);
      return;
      this.umL.setText(2131759851);
      AppMethodBeat.o(42343);
      return;
      this.umL.setText(2131759849);
      AppMethodBeat.o(42343);
      return;
      this.umL.setText(2131759852);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42345);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = new d(getContext());
    localObject = new l(this.udL);
    paramView.a(this.udL, (l)localObject);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42345);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42342);
    super.onFinishInflate();
    this.gnM = ((TextView)findViewById(2131300423));
    this.usj = ((TextView)findViewById(2131300408));
    this.umL = ((TextView)findViewById(2131300422));
    this.usk = ((ImageView)findViewById(2131300512));
    ad.i("MicroMsg.GameRankHeadView", "initView finished");
    AppMethodBeat.o(42342);
  }
  
  public void setData(GameDetailRankUI.a parama)
  {
    AppMethodBeat.i(42344);
    this.gnM.setText(parama.unf);
    this.usj.setText(parama.ung);
    this.udL = parama.unh;
    this.udL.dFG = 1203;
    this.udL.position = 2;
    if (this.uno == null) {
      this.uno = new l(this.udL);
    }
    this.uno.fy(getContext());
    this.uno.cdl();
    cZW();
    if (this.unm != null) {
      k.a(this.unm);
    }
    for (;;)
    {
      this.umL.setOnClickListener(this);
      AppMethodBeat.o(42344);
      return;
      this.unm = new k.a()
      {
        public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(42341);
          if (GameRankHeadView.a(GameRankHeadView.this) != null)
          {
            GameRankHeadView.b(GameRankHeadView.this).fy(GameRankHeadView.this.getContext());
            GameRankHeadView.b(GameRankHeadView.this).cdl();
            if (paramAnonymousBoolean) {
              GameRankHeadView.c(GameRankHeadView.this);
            }
          }
          AppMethodBeat.o(42341);
        }
      };
      k.a(this.unm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView
 * JD-Core Version:    0.7.0.1
 */