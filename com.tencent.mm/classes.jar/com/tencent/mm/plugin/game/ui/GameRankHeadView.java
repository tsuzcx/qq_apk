package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ac;

public class GameRankHeadView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView fUk;
  private com.tencent.mm.plugin.game.model.c tfV;
  k.a toP;
  private l toR;
  private TextView ton;
  private TextView ttK;
  private ImageView ttL;
  
  public GameRankHeadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void cRr()
  {
    AppMethodBeat.i(42343);
    if (h.a(getContext(), this.tfV))
    {
      int i = com.tencent.mm.plugin.game.f.c.ahP(this.tfV.field_packageName);
      if (this.tfV.versionCode > i)
      {
        this.ton.setText(2131759855);
        AppMethodBeat.o(42343);
        return;
      }
      this.ton.setText(2131759853);
      AppMethodBeat.o(42343);
      return;
    }
    switch (this.tfV.status)
    {
    default: 
      this.ton.setText(2131759850);
      AppMethodBeat.o(42343);
      return;
    }
    if (this.toR == null)
    {
      this.ton.setVisibility(8);
      this.ttL.setVisibility(8);
      AppMethodBeat.o(42343);
      return;
    }
    this.ton.setVisibility(0);
    this.ttL.setVisibility(0);
    switch (this.toR.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42343);
      return;
      this.ton.setText(2131759850);
      AppMethodBeat.o(42343);
      return;
      this.ton.setText(2131759851);
      AppMethodBeat.o(42343);
      return;
      this.ton.setText(2131759849);
      AppMethodBeat.o(42343);
      return;
      this.ton.setText(2131759852);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42345);
    paramView = new d(getContext());
    l locall = new l(this.tfV);
    paramView.a(this.tfV, locall);
    AppMethodBeat.o(42345);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42342);
    super.onFinishInflate();
    this.fUk = ((TextView)findViewById(2131300423));
    this.ttK = ((TextView)findViewById(2131300408));
    this.ton = ((TextView)findViewById(2131300422));
    this.ttL = ((ImageView)findViewById(2131300512));
    ac.i("MicroMsg.GameRankHeadView", "initView finished");
    AppMethodBeat.o(42342);
  }
  
  public void setData(GameDetailRankUI.a parama)
  {
    AppMethodBeat.i(42344);
    this.fUk.setText(parama.toI);
    this.ttK.setText(parama.toJ);
    this.tfV = parama.toK;
    this.tfV.dtF = 1203;
    this.tfV.position = 2;
    if (this.toR == null) {
      this.toR = new l(this.tfV);
    }
    this.toR.fu(getContext());
    this.toR.bYH();
    cRr();
    if (this.toP != null) {
      k.a(this.toP);
    }
    for (;;)
    {
      this.ton.setOnClickListener(this);
      AppMethodBeat.o(42344);
      return;
      this.toP = new k.a()
      {
        public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(42341);
          if (GameRankHeadView.a(GameRankHeadView.this) != null)
          {
            GameRankHeadView.b(GameRankHeadView.this).fu(GameRankHeadView.this.getContext());
            GameRankHeadView.b(GameRankHeadView.this).bYH();
            if (paramAnonymousBoolean) {
              GameRankHeadView.c(GameRankHeadView.this);
            }
          }
          AppMethodBeat.o(42341);
        }
      };
      k.a(this.toP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView
 * JD-Core Version:    0.7.0.1
 */