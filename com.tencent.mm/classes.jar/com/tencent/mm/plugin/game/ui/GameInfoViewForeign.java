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
import com.tencent.mm.sdk.platformtools.ae;

public class GameInfoViewForeign
  extends RelativeLayout
{
  private int dxl;
  private Context mContext;
  private TextView uBh;
  private int uBi;
  private View.OnClickListener uBj;
  private int uoy;
  
  public GameInfoViewForeign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42179);
    this.uoy = 0;
    this.dxl = 0;
    this.uBi = 2;
    this.uBj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42178);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof String))) {
          paramAnonymousView = (String)paramAnonymousView.getTag();
        }
        for (int i = c.B(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView, "game_center_msgcenter");; i = c.B(GameInfoViewForeign.a(GameInfoViewForeign.this), paramAnonymousView.url, "game_center_msgcenter"))
        {
          paramAnonymousView = com.tencent.mm.game.report.f.an("resource", "5");
          com.tencent.mm.game.report.f.a(GameInfoViewForeign.a(GameInfoViewForeign.this), 10, 1001, GameInfoViewForeign.b(GameInfoViewForeign.this), i, 0, null, GameInfoViewForeign.c(GameInfoViewForeign.this), 0, null, null, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42178);
          return;
          paramAnonymousView = com.tencent.mm.plugin.game.model.a.dbg();
          if (paramAnonymousView.dEu != 2) {
            break;
          }
        }
        localObject = new Intent();
        if (((com.tencent.mm.game.report.a.b)g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qxc, 0) == 1)
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
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameInfoViewForeign$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
  
  public final void dcJ()
  {
    AppMethodBeat.i(42181);
    this.dxl = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().dbS();
    if ((this.dxl > 0) && (this.dxl <= 99))
    {
      this.uBh.setVisibility(0);
      this.uBh.setText(this.dxl);
      AppMethodBeat.o(42181);
      return;
    }
    if (this.dxl > 99)
    {
      this.uBh.setVisibility(0);
      this.uBh.setText("99+");
      this.uBh.setTextSize(1, 9.0F);
      AppMethodBeat.o(42181);
      return;
    }
    this.uBh.setVisibility(4);
    AppMethodBeat.o(42181);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42180);
    super.onFinishInflate();
    setOnClickListener(this.uBj);
    this.uBh = ((TextView)findViewById(2131300522));
    dcJ();
    ae.i("MicroMsg.GameInfoViewForeign", "initView finished");
    AppMethodBeat.o(42180);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.uoy = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInfoViewForeign
 * JD-Core Version:    0.7.0.1
 */