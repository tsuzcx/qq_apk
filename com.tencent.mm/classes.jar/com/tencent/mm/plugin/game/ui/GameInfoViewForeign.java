package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI;
import com.tencent.mm.sdk.platformtools.ac;

public class GameInfoViewForeign
  extends RelativeLayout
{
  private int dkt;
  private Context mContext;
  private int tfA;
  private TextView tro;
  private int trp;
  private View.OnClickListener trq;
  
  public GameInfoViewForeign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42179);
    this.tfA = 0;
    this.dkt = 0;
    this.trp = 2;
    this.trq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42178);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof String))) {
          paramAnonymousView = (String)paramAnonymousView.getTag();
        }
        for (int i = c.z(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView, "game_center_msgcenter");; i = c.z(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView.url, "game_center_msgcenter"))
        {
          paramAnonymousView = com.tencent.mm.game.report.e.al("resource", "5");
          com.tencent.mm.game.report.e.a(GameInfoViewForeign.a(GameInfoViewForeign.this), 10, 1001, GameInfoViewForeign.b(GameInfoViewForeign.this), i, 0, null, GameInfoViewForeign.c(GameInfoViewForeign.this), 0, null, null, paramAnonymousView);
          AppMethodBeat.o(42178);
          return;
          paramAnonymousView = com.tencent.mm.plugin.game.model.a.cPR();
          if (paramAnonymousView.drx != 2) {
            break;
          }
        }
        Object localObject = new Intent();
        if (((b)g.ab(b.class)).a(b.a.pME, 0) == 1)
        {
          i = 1;
          label157:
          if (i == 0) {
            break label264;
          }
          ((Intent)localObject).setClass(GameInfoViewForeign.a(GameInfoViewForeign.this), GameMsgCenterUI.class);
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("game_report_from_scene", 1001);
          paramAnonymousView = GameInfoViewForeign.a(GameInfoViewForeign.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          i = 6;
          break;
          i = 0;
          break label157;
          label264:
          ((Intent)localObject).setClass(GameInfoViewForeign.a(GameInfoViewForeign.this), GameMessageUI.class);
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(42179);
  }
  
  public final void cRt()
  {
    AppMethodBeat.i(42181);
    this.dkt = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().cQD();
    if ((this.dkt > 0) && (this.dkt <= 99))
    {
      this.tro.setVisibility(0);
      this.tro.setText(this.dkt);
      AppMethodBeat.o(42181);
      return;
    }
    if (this.dkt > 99)
    {
      this.tro.setVisibility(0);
      this.tro.setText("99+");
      this.tro.setTextSize(1, 9.0F);
      AppMethodBeat.o(42181);
      return;
    }
    this.tro.setVisibility(4);
    AppMethodBeat.o(42181);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42180);
    super.onFinishInflate();
    setOnClickListener(this.trq);
    this.tro = ((TextView)findViewById(2131300522));
    cRt();
    ac.i("MicroMsg.GameInfoViewForeign", "initView finished");
    AppMethodBeat.o(42180);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.tfA = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInfoViewForeign
 * JD-Core Version:    0.7.0.1
 */