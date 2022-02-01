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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public class GameMessageBubbleView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context mContext;
  private boolean mHasInit = false;
  View ttb;
  private TextView ttc;
  private ImageView ttd;
  private com.tencent.mm.plugin.game.model.o tte;
  private final long ttf = 500L;
  private long ttg = 0L;
  
  public GameMessageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void cRA()
  {
    AppMethodBeat.i(42279);
    ((d)g.ab(d.class)).cOl();
    this.tte = r.cQw();
    if (this.tte == null)
    {
      this.ttb.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.tte.cQp();
    if ((this.tte.field_msgType == 100) && ((bs.isNullOrNil(this.tte.tdY.mDesc)) || (bs.isNullOrNil(this.tte.tdY.teS)) || (bs.isNullOrNil(this.tte.tdY.teT)) || (!this.tte.tdZ.containsKey(this.tte.tdY.teT))))
    {
      ac.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
      this.ttb.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.ttc.setText(this.tte.tdY.mDesc);
    com.tencent.mm.av.o.aFB().loadImage(this.tte.tdY.teS, this.ttd);
    this.ttb.setOnClickListener(this);
    setVisibility(0);
    AppMethodBeat.o(42279);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42280);
    if (System.currentTimeMillis() - this.ttg <= 500L)
    {
      AppMethodBeat.o(42280);
      return;
    }
    if (this.tte == null)
    {
      AppMethodBeat.o(42280);
      return;
    }
    ((d)g.ab(d.class)).cOl();
    r.cQx();
    if (this.tte.field_msgType == 100)
    {
      if (!bs.isNullOrNil(this.tte.tdY.teT))
      {
        paramView = (o.e)this.tte.tdZ.get(this.tte.tdY.teT);
        if (paramView != null)
        {
          i = p.a(this.mContext, this.tte, paramView, this.tte.field_appId, 1007);
          if (i != 0) {
            com.tencent.mm.game.report.e.a(this.mContext, 10, 1007, 1, i, 0, this.tte.field_appId, 0, this.tte.teI, this.tte.field_gameMsgId, this.tte.teJ, com.tencent.mm.game.report.e.a(null, null, this.tte.teK, null));
          }
          if (paramView.mJumpType != 4)
          {
            this.tte.field_isRead = true;
            ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().update(this.tte, new String[0]);
          }
        }
      }
      this.ttg = System.currentTimeMillis();
      AppMethodBeat.o(42280);
      return;
    }
    if ((this.tte != null) && (this.tte.teb != 3))
    {
      this.tte.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().update(this.tte, new String[0]);
    }
    int i = 0;
    switch (this.tte.teb)
    {
    default: 
      ac.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.tte.teb);
      AppMethodBeat.o(42280);
      return;
    case 1: 
      paramView = this.tte.tdN;
      if (!bs.isNullOrNil(paramView)) {
        i = c.z(this.mContext, paramView, "game_center_bubble");
      }
    case 2: 
      for (;;)
      {
        com.tencent.mm.game.report.e.a(this.mContext, 10, 1007, 1, i, 0, this.tte.field_appId, 0, this.tte.field_msgType, this.tte.field_gameMsgId, this.tte.teJ, com.tencent.mm.game.report.e.a(null, null, this.tte.teK, null));
        this.ttg = System.currentTimeMillis();
        AppMethodBeat.o(42280);
        return;
        if (!bs.isNullOrNil(this.tte.field_appId))
        {
          paramView = new Bundle();
          paramView.putCharSequence("game_app_id", this.tte.field_appId);
          paramView.putInt("game_report_from_scene", 1007);
          i = c.a(this.mContext, this.tte.field_appId, null, paramView);
        }
        else
        {
          ac.e("MicroMsg.GameMessageHeaderView", "message type : " + this.tte.field_msgType + " ,message.field_appId is null.");
        }
      }
    }
    Object localObject = new Intent();
    if (((b)g.ab(b.class)).a(b.a.pME, 0) == 1)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
      this.ttd = ((ImageView)findViewById(2131300515));
      this.ttc = ((TextView)findViewById(2131300514));
      this.ttb = findViewById(2131300516);
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