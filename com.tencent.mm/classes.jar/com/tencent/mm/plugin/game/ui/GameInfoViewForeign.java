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
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI;
import com.tencent.mm.sdk.platformtools.Log;

public class GameInfoViewForeign
  extends RelativeLayout
{
  private int dOS;
  private Context mContext;
  private int xGR;
  private TextView xTf;
  private int xTg;
  private View.OnClickListener xTh;
  
  public GameInfoViewForeign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42179);
    this.xGR = 0;
    this.dOS = 0;
    this.xTg = 2;
    this.xTh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42178);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof String))) {
          paramAnonymousView = (String)paramAnonymousView.getTag();
        }
        for (int i = c.D(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView, "game_center_msgcenter");; i = c.D(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView.url, "game_center_msgcenter"))
        {
          paramAnonymousView = com.tencent.mm.game.report.f.ap("resource", "5");
          com.tencent.mm.game.report.f.a(GameInfoViewForeign.a(GameInfoViewForeign.this), 10, 1001, GameInfoViewForeign.b(GameInfoViewForeign.this), i, 0, null, GameInfoViewForeign.c(GameInfoViewForeign.this), 0, null, null, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42178);
          return;
          paramAnonymousView = com.tencent.mm.plugin.game.model.a.dUN();
          if (paramAnonymousView.cSx != 2) {
            break;
          }
        }
        localObject = new Intent();
        if (((com.tencent.mm.game.report.a.b)g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.rOP, 0) == 1)
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
  
  public final void dWq()
  {
    AppMethodBeat.i(42181);
    this.dOS = ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().dVz();
    if ((this.dOS > 0) && (this.dOS <= 99))
    {
      this.xTf.setVisibility(0);
      this.xTf.setText(this.dOS);
      AppMethodBeat.o(42181);
      return;
    }
    if (this.dOS > 99)
    {
      this.xTf.setVisibility(0);
      this.xTf.setText("99+");
      this.xTf.setTextSize(1, 9.0F);
      AppMethodBeat.o(42181);
      return;
    }
    this.xTf.setVisibility(4);
    AppMethodBeat.o(42181);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42180);
    super.onFinishInflate();
    setOnClickListener(this.xTh);
    this.xTf = ((TextView)findViewById(2131302049));
    dWq();
    Log.i("MicroMsg.GameInfoViewForeign", "initView finished");
    AppMethodBeat.o(42180);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.xGR = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInfoViewForeign
 * JD-Core Version:    0.7.0.1
 */