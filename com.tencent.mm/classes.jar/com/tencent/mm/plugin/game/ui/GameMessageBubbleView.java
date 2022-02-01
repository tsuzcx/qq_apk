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
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class GameMessageBubbleView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context mContext;
  private boolean mHasInit = false;
  View xUR;
  private TextView xUS;
  private ImageView xUT;
  private o xUU;
  private final long xUV = 500L;
  private long xUW = 0L;
  
  public GameMessageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void dWx()
  {
    AppMethodBeat.i(42279);
    ((e)g.af(e.class)).dSJ();
    this.xUU = r.dVs();
    if (this.xUU == null)
    {
      this.xUR.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.xUU.dVl();
    if ((this.xUU.field_msgType == 100) && ((Util.isNullOrNil(this.xUU.xFi.mDesc)) || (Util.isNullOrNil(this.xUU.xFi.xGg)) || (Util.isNullOrNil(this.xUU.xFi.xGh)) || (!this.xUU.xFj.containsKey(this.xUU.xFi.xGh))))
    {
      Log.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
      this.xUR.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.xUS.setText(this.xUU.xFi.mDesc);
    q.bcV().loadImage(this.xUU.xFi.xGg, this.xUT);
    this.xUR.setOnClickListener(this);
    setVisibility(0);
    AppMethodBeat.o(42279);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42280);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (System.currentTimeMillis() - this.xUW <= 500L)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if (this.xUU == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    ((e)g.af(e.class)).dSJ();
    r.dVt();
    if (this.xUU.field_msgType == 100)
    {
      if (!Util.isNullOrNil(this.xUU.xFi.xGh))
      {
        paramView = (o.g)this.xUU.xFj.get(this.xUU.xFi.xGh);
        if (paramView != null)
        {
          i = p.a(this.mContext, this.xUU, paramView, this.xUU.field_appId, 1007);
          if (i != 0) {
            com.tencent.mm.game.report.f.a(this.mContext, 10, 1007, 1, i, 0, this.xUU.field_appId, 0, this.xUU.xFV, this.xUU.field_gameMsgId, this.xUU.xFW, com.tencent.mm.game.report.f.a(null, null, this.xUU.xFX, null));
          }
          if (paramView.mJumpType != 4)
          {
            this.xUU.field_isRead = true;
            ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().update(this.xUU, new String[0]);
          }
        }
      }
      this.xUW = System.currentTimeMillis();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if ((this.xUU != null) && (this.xUU.xFl != 3))
    {
      this.xUU.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().update(this.xUU, new String[0]);
    }
    int i = 0;
    switch (this.xUU.xFl)
    {
    default: 
      Log.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.xUU.xFl);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    case 1: 
      paramView = this.xUU.xEX;
      if (!Util.isNullOrNil(paramView)) {
        i = c.D(this.mContext, paramView, "game_center_bubble");
      }
    case 2: 
      for (;;)
      {
        com.tencent.mm.game.report.f.a(this.mContext, 10, 1007, 1, i, 0, this.xUU.field_appId, 0, this.xUU.field_msgType, this.xUU.field_gameMsgId, this.xUU.xFW, com.tencent.mm.game.report.f.a(null, null, this.xUU.xFX, null));
        this.xUW = System.currentTimeMillis();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42280);
        return;
        if (!Util.isNullOrNil(this.xUU.field_appId))
        {
          paramView = new Bundle();
          paramView.putCharSequence("game_app_id", this.xUU.field_appId);
          paramView.putInt("game_report_from_scene", 1007);
          i = c.b(this.mContext, this.xUU.field_appId, null, paramView);
        }
        else
        {
          Log.e("MicroMsg.GameMessageHeaderView", "message type : " + this.xUU.field_msgType + " ,message.field_appId is null.");
        }
      }
    }
    localObject = new Intent();
    if (((com.tencent.mm.game.report.a.b)g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.rOP, 0) == 1)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      this.xUT = ((ImageView)findViewById(2131302042));
      this.xUS = ((TextView)findViewById(2131302041));
      this.xUR = findViewById(2131302043);
      setVisibility(8);
      this.mHasInit = true;
    }
    AppMethodBeat.o(42278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageBubbleView
 * JD-Core Version:    0.7.0.1
 */