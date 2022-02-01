package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI;
import com.tencent.mm.sdk.platformtools.ad;

public class GameInfoViewForeign
  extends RelativeLayout
{
  private int dwg;
  private Context mContext;
  private int udq;
  private TextView upL;
  private int upM;
  private View.OnClickListener upN;
  
  public GameInfoViewForeign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42179);
    this.udq = 0;
    this.dwg = 0;
    this.upM = 2;
    this.upN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42178);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof String))) {
          paramAnonymousView = (String)paramAnonymousView.getTag();
        }
        for (int i = c.B(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView, "game_center_msgcenter");; i = c.B(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView.url, "game_center_msgcenter"))
        {
          paramAnonymousView = com.tencent.mm.game.report.f.am("resource", "5");
          com.tencent.mm.game.report.f.a(GameInfoViewForeign.a(GameInfoViewForeign.this), 10, 1001, GameInfoViewForeign.b(GameInfoViewForeign.this), i, 0, null, GameInfoViewForeign.c(GameInfoViewForeign.this), 0, null, null, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42178);
          return;
          paramAnonymousView = com.tencent.mm.plugin.game.model.a.cYw();
          if (paramAnonymousView.dDp != 2) {
            break;
          }
        }
        localObject = new Intent();
        if (((com.tencent.mm.game.report.a.b)g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qqu, 0) == 1)
        {
          i = 1;
          label198:
          if (i == 0) {
            break label305;
          }
          ((Intent)localObject).setClass(GameInfoViewForeign.a(GameInfoViewForeign.this), GameMsgCenterUI.class);
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("game_report_from_scene", 1001);
          paramAnonymousView = GameInfoViewForeign.a(GameInfoViewForeign.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          i = 6;
          break;
          i = 0;
          break label198;
          label305:
          ((Intent)localObject).setClass(GameInfoViewForeign.a(GameInfoViewForeign.this), GameMessageUI.class);
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(42179);
  }
  
  public final void cZY()
  {
    AppMethodBeat.i(42181);
    this.dwg = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().cZi();
    if ((this.dwg > 0) && (this.dwg <= 99))
    {
      this.upL.setVisibility(0);
      this.upL.setText(this.dwg);
      AppMethodBeat.o(42181);
      return;
    }
    if (this.dwg > 99)
    {
      this.upL.setVisibility(0);
      this.upL.setText("99+");
      this.upL.setTextSize(1, 9.0F);
      AppMethodBeat.o(42181);
      return;
    }
    this.upL.setVisibility(4);
    AppMethodBeat.o(42181);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42180);
    super.onFinishInflate();
    setOnClickListener(this.upN);
    this.upL = ((TextView)findViewById(2131300522));
    cZY();
    ad.i("MicroMsg.GameInfoViewForeign", "initView finished");
    AppMethodBeat.o(42180);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.udq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInfoViewForeign
 * JD-Core Version:    0.7.0.1
 */