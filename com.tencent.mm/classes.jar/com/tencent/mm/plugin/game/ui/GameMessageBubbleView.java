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
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.d;
import com.tencent.mm.plugin.game.model.o.f;
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
  View urA;
  private TextView urB;
  private ImageView urC;
  private o urD;
  private final long urE = 500L;
  private long urF = 0L;
  
  public GameMessageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void daf()
  {
    AppMethodBeat.i(42279);
    ((e)g.ab(e.class)).cWG();
    this.urD = r.cZb();
    if (this.urD == null)
    {
      this.urA.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.urD.cYU();
    if ((this.urD.field_msgType == 100) && ((bt.isNullOrNil(this.urD.ubO.mDesc)) || (bt.isNullOrNil(this.urD.ubO.ucK)) || (bt.isNullOrNil(this.urD.ubO.ucL)) || (!this.urD.ubP.containsKey(this.urD.ubO.ucL))))
    {
      ad.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
      this.urA.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.urB.setText(this.urD.ubO.mDesc);
    q.aIJ().loadImage(this.urD.ubO.ucK, this.urC);
    this.urA.setOnClickListener(this);
    setVisibility(0);
    AppMethodBeat.o(42279);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42280);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (System.currentTimeMillis() - this.urF <= 500L)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if (this.urD == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    ((e)g.ab(e.class)).cWG();
    r.cZc();
    if (this.urD.field_msgType == 100)
    {
      if (!bt.isNullOrNil(this.urD.ubO.ucL))
      {
        paramView = (o.f)this.urD.ubP.get(this.urD.ubO.ucL);
        if (paramView != null)
        {
          i = p.a(this.mContext, this.urD, paramView, this.urD.field_appId, 1007);
          if (i != 0) {
            com.tencent.mm.game.report.f.a(this.mContext, 10, 1007, 1, i, 0, this.urD.field_appId, 0, this.urD.ucz, this.urD.field_gameMsgId, this.urD.ucA, com.tencent.mm.game.report.f.a(null, null, this.urD.ucB, null));
          }
          if (paramView.mJumpType != 4)
          {
            this.urD.field_isRead = true;
            ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().update(this.urD, new String[0]);
          }
        }
      }
      this.urF = System.currentTimeMillis();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if ((this.urD != null) && (this.urD.ubR != 3))
    {
      this.urD.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().update(this.urD, new String[0]);
    }
    int i = 0;
    switch (this.urD.ubR)
    {
    default: 
      ad.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.urD.ubR);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    case 1: 
      paramView = this.urD.ubD;
      if (!bt.isNullOrNil(paramView)) {
        i = c.B(this.mContext, paramView, "game_center_bubble");
      }
    case 2: 
      for (;;)
      {
        com.tencent.mm.game.report.f.a(this.mContext, 10, 1007, 1, i, 0, this.urD.field_appId, 0, this.urD.field_msgType, this.urD.field_gameMsgId, this.urD.ucA, com.tencent.mm.game.report.f.a(null, null, this.urD.ucB, null));
        this.urF = System.currentTimeMillis();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42280);
        return;
        if (!bt.isNullOrNil(this.urD.field_appId))
        {
          paramView = new Bundle();
          paramView.putCharSequence("game_app_id", this.urD.field_appId);
          paramView.putInt("game_report_from_scene", 1007);
          i = c.a(this.mContext, this.urD.field_appId, null, paramView);
        }
        else
        {
          ad.e("MicroMsg.GameMessageHeaderView", "message type : " + this.urD.field_msgType + " ,message.field_appId is null.");
        }
      }
    }
    localObject = new Intent();
    if (((com.tencent.mm.game.report.a.b)g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qqu, 0) == 1)
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
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
      this.urC = ((ImageView)findViewById(2131300515));
      this.urB = ((TextView)findViewById(2131300514));
      this.urA = findViewById(2131300516);
      setVisibility(8);
      this.mHasInit = true;
    }
    AppMethodBeat.o(42278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageBubbleView
 * JD-Core Version:    0.7.0.1
 */