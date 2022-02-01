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
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public class GameMessageBubbleView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context mContext;
  private boolean mHasInit = false;
  View uCT;
  private TextView uCU;
  private ImageView uCV;
  private o uCW;
  private final long uCX = 500L;
  private long uCY = 0L;
  
  public GameMessageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void dcQ()
  {
    AppMethodBeat.i(42279);
    ((e)g.ab(e.class)).cZk();
    this.uCW = r.dbL();
    if (this.uCW == null)
    {
      this.uCT.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.uCW.dbE();
    if ((this.uCW.field_msgType == 100) && ((bu.isNullOrNil(this.uCW.umQ.mDesc)) || (bu.isNullOrNil(this.uCW.umQ.unP)) || (bu.isNullOrNil(this.uCW.umQ.unQ)) || (!this.uCW.umR.containsKey(this.uCW.umQ.unQ))))
    {
      ae.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
      this.uCT.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.uCU.setText(this.uCW.umQ.mDesc);
    q.aJb().loadImage(this.uCW.umQ.unP, this.uCV);
    this.uCT.setOnClickListener(this);
    setVisibility(0);
    AppMethodBeat.o(42279);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42280);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (System.currentTimeMillis() - this.uCY <= 500L)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if (this.uCW == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    ((e)g.ab(e.class)).cZk();
    r.dbM();
    if (this.uCW.field_msgType == 100)
    {
      if (!bu.isNullOrNil(this.uCW.umQ.unQ))
      {
        paramView = (o.g)this.uCW.umR.get(this.uCW.umQ.unQ);
        if (paramView != null)
        {
          i = p.a(this.mContext, this.uCW, paramView, this.uCW.field_appId, 1007);
          if (i != 0) {
            com.tencent.mm.game.report.f.a(this.mContext, 10, 1007, 1, i, 0, this.uCW.field_appId, 0, this.uCW.unD, this.uCW.field_gameMsgId, this.uCW.unE, com.tencent.mm.game.report.f.a(null, null, this.uCW.unF, null));
          }
          if (paramView.mJumpType != 4)
          {
            this.uCW.field_isRead = true;
            ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().update(this.uCW, new String[0]);
          }
        }
      }
      this.uCY = System.currentTimeMillis();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if ((this.uCW != null) && (this.uCW.umT != 3))
    {
      this.uCW.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().update(this.uCW, new String[0]);
    }
    int i = 0;
    switch (this.uCW.umT)
    {
    default: 
      ae.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.uCW.umT);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    case 1: 
      paramView = this.uCW.umF;
      if (!bu.isNullOrNil(paramView)) {
        i = c.B(this.mContext, paramView, "game_center_bubble");
      }
    case 2: 
      for (;;)
      {
        com.tencent.mm.game.report.f.a(this.mContext, 10, 1007, 1, i, 0, this.uCW.field_appId, 0, this.uCW.field_msgType, this.uCW.field_gameMsgId, this.uCW.unE, com.tencent.mm.game.report.f.a(null, null, this.uCW.unF, null));
        this.uCY = System.currentTimeMillis();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42280);
        return;
        if (!bu.isNullOrNil(this.uCW.field_appId))
        {
          paramView = new Bundle();
          paramView.putCharSequence("game_app_id", this.uCW.field_appId);
          paramView.putInt("game_report_from_scene", 1007);
          i = c.a(this.mContext, this.uCW.field_appId, null, paramView);
        }
        else
        {
          ae.e("MicroMsg.GameMessageHeaderView", "message type : " + this.uCW.field_msgType + " ,message.field_appId is null.");
        }
      }
    }
    localObject = new Intent();
    if (((com.tencent.mm.game.report.a.b)g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qxc, 0) == 1)
    {
      i = 1;
      label688:
      if (i == 0) {
        break label797;
      }
      ((Intent)localObject).setClass(this.mContext, GameMsgCenterUI.class);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("game_report_from_scene", 1007);
      paramView = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      i = 6;
      break;
      i = 0;
      break label688;
      label797:
      ((Intent)localObject).setClass(this.mContext, GameMessageUI.class);
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42278);
    super.onFinishInflate();
    if (!this.mHasInit)
    {
      this.uCV = ((ImageView)findViewById(2131300515));
      this.uCU = ((TextView)findViewById(2131300514));
      this.uCT = findViewById(2131300516);
      setVisibility(8);
      this.mHasInit = true;
    }
    AppMethodBeat.o(42278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageBubbleView
 * JD-Core Version:    0.7.0.1
 */