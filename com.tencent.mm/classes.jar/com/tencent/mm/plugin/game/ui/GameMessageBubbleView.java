package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o.c;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public class GameMessageBubbleView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context mContext;
  private boolean mHasInit = false;
  View sli;
  private TextView slj;
  private ImageView slk;
  private com.tencent.mm.plugin.game.model.o sll;
  private final long slm = 500L;
  private long sln = 0L;
  
  public GameMessageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void cEq()
  {
    AppMethodBeat.i(42279);
    ((d)g.ab(d.class)).cBc();
    this.sll = r.cDm();
    if (this.sll == null)
    {
      this.sli.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.sll.cDf();
    if ((this.sll.field_msgType == 100) && ((bt.isNullOrNil(this.sll.rWg.mDesc)) || (bt.isNullOrNil(this.sll.rWg.rXa)) || (bt.isNullOrNil(this.sll.rWg.rXb)) || (!this.sll.rWh.containsKey(this.sll.rWg.rXb))))
    {
      ad.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
      this.sli.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.slj.setText(this.sll.rWg.mDesc);
    com.tencent.mm.aw.o.ayJ().loadImage(this.sll.rWg.rXa, this.slk);
    this.sli.setOnClickListener(this);
    setVisibility(0);
    AppMethodBeat.o(42279);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42280);
    if (System.currentTimeMillis() - this.sln <= 500L)
    {
      AppMethodBeat.o(42280);
      return;
    }
    if (this.sll == null)
    {
      AppMethodBeat.o(42280);
      return;
    }
    ((d)g.ab(d.class)).cBc();
    r.cDn();
    if (this.sll.field_msgType == 100)
    {
      if (!bt.isNullOrNil(this.sll.rWg.rXb))
      {
        paramView = (o.e)this.sll.rWh.get(this.sll.rWg.rXb);
        if (paramView != null)
        {
          i = p.a(this.mContext, this.sll, paramView, this.sll.field_appId, 1007);
          if (i != 0) {
            com.tencent.mm.game.report.e.a(this.mContext, 10, 1007, 1, i, 0, this.sll.field_appId, 0, this.sll.rWQ, this.sll.field_gameMsgId, this.sll.rWR, com.tencent.mm.game.report.e.a(null, null, this.sll.rWS, null));
          }
          if (paramView.mJumpType != 4)
          {
            this.sll.field_isRead = true;
            ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().update(this.sll, new String[0]);
          }
        }
      }
      this.sln = System.currentTimeMillis();
      AppMethodBeat.o(42280);
      return;
    }
    if ((this.sll != null) && (this.sll.rWj != 3))
    {
      this.sll.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().update(this.sll, new String[0]);
    }
    int i = 0;
    switch (this.sll.rWj)
    {
    default: 
      ad.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.sll.rWj);
      AppMethodBeat.o(42280);
      return;
    case 1: 
      paramView = this.sll.rVV;
      if (!bt.isNullOrNil(paramView)) {
        i = c.A(this.mContext, paramView, "game_center_bubble");
      }
    case 2: 
      for (;;)
      {
        com.tencent.mm.game.report.e.a(this.mContext, 10, 1007, 1, i, 0, this.sll.field_appId, 0, this.sll.field_msgType, this.sll.field_gameMsgId, this.sll.rWR, com.tencent.mm.game.report.e.a(null, null, this.sll.rWS, null));
        this.sln = System.currentTimeMillis();
        AppMethodBeat.o(42280);
        return;
        if (!bt.isNullOrNil(this.sll.field_appId))
        {
          paramView = new Bundle();
          paramView.putCharSequence("game_app_id", this.sll.field_appId);
          paramView.putInt("game_report_from_scene", 1007);
          i = c.a(this.mContext, this.sll.field_appId, null, paramView);
        }
        else
        {
          ad.e("MicroMsg.GameMessageHeaderView", "message type : " + this.sll.field_msgType + " ,message.field_appId is null.");
        }
      }
    }
    Object localObject = new Intent();
    if (((b)g.ab(b.class)).a(b.a.pjn, 0) == 1)
    {
      i = 1;
      label599:
      if (i == 0) {
        break label714;
      }
      ((Intent)localObject).setClass(this.mContext, GameMsgCenterUI.class);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("game_report_from_scene", 1007);
      paramView = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      i = 6;
      break;
      i = 0;
      break label599;
      label714:
      ((Intent)localObject).setClass(this.mContext, GameMessageUI.class);
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42278);
    super.onFinishInflate();
    if (!this.mHasInit)
    {
      this.slk = ((ImageView)findViewById(2131300515));
      this.slj = ((TextView)findViewById(2131300514));
      this.sli = findViewById(2131300516);
      setVisibility(8);
      this.mHasInit = true;
    }
    AppMethodBeat.o(42278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageBubbleView
 * JD-Core Version:    0.7.0.1
 */