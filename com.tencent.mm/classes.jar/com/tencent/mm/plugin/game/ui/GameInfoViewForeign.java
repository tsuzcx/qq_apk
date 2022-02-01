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
import com.tencent.mm.sdk.platformtools.ad;

public class GameInfoViewForeign
  extends RelativeLayout
{
  private int dmL;
  private Context mContext;
  private int rXI;
  private TextView sjv;
  private int sjw;
  private View.OnClickListener sjx;
  
  public GameInfoViewForeign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42179);
    this.rXI = 0;
    this.dmL = 0;
    this.sjw = 2;
    this.sjx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42178);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof String))) {
          paramAnonymousView = (String)paramAnonymousView.getTag();
        }
        for (int i = c.A(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView, "game_center_msgcenter");; i = c.A(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView.url, "game_center_msgcenter"))
        {
          paramAnonymousView = com.tencent.mm.game.report.e.ai("resource", "5");
          com.tencent.mm.game.report.e.a(GameInfoViewForeign.a(GameInfoViewForeign.this), 10, 1001, GameInfoViewForeign.b(GameInfoViewForeign.this), i, 0, null, GameInfoViewForeign.c(GameInfoViewForeign.this), 0, null, null, paramAnonymousView);
          AppMethodBeat.o(42178);
          return;
          paramAnonymousView = com.tencent.mm.plugin.game.model.a.cCH();
          if (paramAnonymousView.dtM != 2) {
            break;
          }
        }
        Object localObject = new Intent();
        if (((b)g.ab(b.class)).a(b.a.pjn, 0) == 1)
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
  
  public final void cEj()
  {
    AppMethodBeat.i(42181);
    this.dmL = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().cDt();
    if ((this.dmL > 0) && (this.dmL <= 99))
    {
      this.sjv.setVisibility(0);
      this.sjv.setText(this.dmL);
      AppMethodBeat.o(42181);
      return;
    }
    if (this.dmL > 99)
    {
      this.sjv.setVisibility(0);
      this.sjv.setText("99+");
      this.sjv.setTextSize(1, 9.0F);
      AppMethodBeat.o(42181);
      return;
    }
    this.sjv.setVisibility(4);
    AppMethodBeat.o(42181);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42180);
    super.onFinishInflate();
    setOnClickListener(this.sjx);
    this.sjv = ((TextView)findViewById(2131300522));
    cEj();
    ad.i("MicroMsg.GameInfoViewForeign", "initView finished");
    AppMethodBeat.o(42180);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.rXI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInfoViewForeign
 * JD-Core Version:    0.7.0.1
 */