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
import com.tencent.mm.sdk.platformtools.Log;

public class GameRankHeadView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView hbb;
  private com.tencent.mm.plugin.game.model.c xHm;
  k.a xQH;
  private l xQJ;
  private TextView xQh;
  private TextView xVA;
  private ImageView xVB;
  
  public GameRankHeadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void dWo()
  {
    AppMethodBeat.i(42343);
    if (h.a(getContext(), this.xHm))
    {
      int i = com.tencent.mm.plugin.game.e.c.aAH(this.xHm.field_packageName);
      if (this.xHm.versionCode > i)
      {
        this.xQh.setText(2131761190);
        AppMethodBeat.o(42343);
        return;
      }
      this.xQh.setText(2131761188);
      AppMethodBeat.o(42343);
      return;
    }
    switch (this.xHm.status)
    {
    default: 
      this.xQh.setText(2131761185);
      AppMethodBeat.o(42343);
      return;
    }
    if (this.xQJ == null)
    {
      this.xQh.setVisibility(8);
      this.xVB.setVisibility(8);
      AppMethodBeat.o(42343);
      return;
    }
    this.xQh.setVisibility(0);
    this.xVB.setVisibility(0);
    switch (this.xQJ.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42343);
      return;
      this.xQh.setText(2131761185);
      AppMethodBeat.o(42343);
      return;
      this.xQh.setText(2131761186);
      AppMethodBeat.o(42343);
      return;
      this.xQh.setText(2131761184);
      AppMethodBeat.o(42343);
      return;
      this.xQh.setText(2131761187);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42345);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = new d(getContext());
    localObject = new l(this.xHm);
    paramView.a(this.xHm, (l)localObject);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameRankHeadView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42345);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42342);
    super.onFinishInflate();
    this.hbb = ((TextView)findViewById(2131301946));
    this.xVA = ((TextView)findViewById(2131301931));
    this.xQh = ((TextView)findViewById(2131301945));
    this.xVB = ((ImageView)findViewById(2131302039));
    Log.i("MicroMsg.GameRankHeadView", "initView finished");
    AppMethodBeat.o(42342);
  }
  
  public void setData(GameDetailRankUI.a parama)
  {
    AppMethodBeat.i(42344);
    this.hbb.setText(parama.xQA);
    this.xVA.setText(parama.xQB);
    this.xHm = parama.xQC;
    this.xHm.dYu = 1203;
    this.xHm.position = 2;
    if (this.xQJ == null) {
      this.xQJ = new l(this.xHm);
    }
    this.xQJ.gi(getContext());
    this.xQJ.cCq();
    dWo();
    if (this.xQH != null) {
      k.a(this.xQH);
    }
    for (;;)
    {
      this.xQh.setOnClickListener(this);
      AppMethodBeat.o(42344);
      return;
      this.xQH = new k.a()
      {
        public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(42341);
          if (GameRankHeadView.a(GameRankHeadView.this) != null)
          {
            GameRankHeadView.b(GameRankHeadView.this).gi(GameRankHeadView.this.getContext());
            GameRankHeadView.b(GameRankHeadView.this).cCq();
            if (paramAnonymousBoolean) {
              GameRankHeadView.c(GameRankHeadView.this);
            }
          }
          AppMethodBeat.o(42341);
        }
      };
      k.a(this.xQH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView
 * JD-Core Version:    0.7.0.1
 */