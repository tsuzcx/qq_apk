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
import com.tencent.mm.sdk.platformtools.ad;

public class GameRankHeadView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView fQp;
  private com.tencent.mm.plugin.game.model.c rYd;
  k.a sgV;
  private l sgX;
  private TextView sgu;
  private TextView slR;
  private ImageView slS;
  
  public GameRankHeadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void cEh()
  {
    AppMethodBeat.i(42343);
    if (h.a(getContext(), this.rYd))
    {
      int i = com.tencent.mm.plugin.game.f.c.acX(this.rYd.field_packageName);
      if (this.rYd.versionCode > i)
      {
        this.sgu.setText(2131759855);
        AppMethodBeat.o(42343);
        return;
      }
      this.sgu.setText(2131759853);
      AppMethodBeat.o(42343);
      return;
    }
    switch (this.rYd.status)
    {
    default: 
      this.sgu.setText(2131759850);
      AppMethodBeat.o(42343);
      return;
    }
    if (this.sgX == null)
    {
      this.sgu.setVisibility(8);
      this.slS.setVisibility(8);
      AppMethodBeat.o(42343);
      return;
    }
    this.sgu.setVisibility(0);
    this.slS.setVisibility(0);
    switch (this.sgX.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42343);
      return;
      this.sgu.setText(2131759850);
      AppMethodBeat.o(42343);
      return;
      this.sgu.setText(2131759851);
      AppMethodBeat.o(42343);
      return;
      this.sgu.setText(2131759849);
      AppMethodBeat.o(42343);
      return;
      this.sgu.setText(2131759852);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42345);
    paramView = new d(getContext());
    l locall = new l(this.rYd);
    paramView.a(this.rYd, locall);
    AppMethodBeat.o(42345);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42342);
    super.onFinishInflate();
    this.fQp = ((TextView)findViewById(2131300423));
    this.slR = ((TextView)findViewById(2131300408));
    this.sgu = ((TextView)findViewById(2131300422));
    this.slS = ((ImageView)findViewById(2131300512));
    ad.i("MicroMsg.GameRankHeadView", "initView finished");
    AppMethodBeat.o(42342);
  }
  
  public void setData(GameDetailRankUI.a parama)
  {
    AppMethodBeat.i(42344);
    this.fQp.setText(parama.sgO);
    this.slR.setText(parama.sgP);
    this.rYd = parama.sgQ;
    this.rYd.dvS = 1203;
    this.rYd.position = 2;
    if (this.sgX == null) {
      this.sgX = new l(this.rYd);
    }
    this.sgX.fh(getContext());
    this.sgX.bRs();
    cEh();
    if (this.sgV != null) {
      k.a(this.sgV);
    }
    for (;;)
    {
      this.sgu.setOnClickListener(this);
      AppMethodBeat.o(42344);
      return;
      this.sgV = new k.a()
      {
        public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(42341);
          if (GameRankHeadView.a(GameRankHeadView.this) != null)
          {
            GameRankHeadView.b(GameRankHeadView.this).fh(GameRankHeadView.this.getContext());
            GameRankHeadView.b(GameRankHeadView.this).bRs();
            if (paramAnonymousBoolean) {
              GameRankHeadView.c(GameRankHeadView.this);
            }
          }
          AppMethodBeat.o(42341);
        }
      };
      k.a(this.sgV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView
 * JD-Core Version:    0.7.0.1
 */