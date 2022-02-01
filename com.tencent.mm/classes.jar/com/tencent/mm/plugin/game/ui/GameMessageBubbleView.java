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
import com.tencent.mm.game.report.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class GameMessageBubbleView
  extends LinearLayout
  implements View.OnClickListener
{
  View ITs;
  private TextView ITt;
  private ImageView ITu;
  private o ITv;
  private final long ITw = 500L;
  private long ITx = 0L;
  private Context mContext;
  private boolean mHasInit = false;
  
  public GameMessageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void fHB()
  {
    AppMethodBeat.i(42279);
    ((e)h.ax(e.class)).fCg();
    this.ITv = com.tencent.mm.plugin.game.model.r.fGw();
    if (this.ITv == null)
    {
      this.ITs.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.ITv.fGp();
    if ((this.ITv.field_msgType == 100) && ((Util.isNullOrNil(this.ITv.IDu.mDesc)) || (Util.isNullOrNil(this.ITv.IDu.IEu)) || (Util.isNullOrNil(this.ITv.IDu.IEv)) || (!this.ITv.IDv.containsKey(this.ITv.IDu.IEv))))
    {
      Log.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
      this.ITs.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.ITt.setText(this.ITv.IDu.mDesc);
    com.tencent.mm.modelimage.r.bKe().loadImage(this.ITv.IDu.IEu, this.ITu);
    this.ITs.setOnClickListener(this);
    setVisibility(0);
    AppMethodBeat.o(42279);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42280);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (System.currentTimeMillis() - this.ITx <= 500L)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if (this.ITv == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    ((e)h.ax(e.class)).fCg().fGx();
    if (this.ITv.field_msgType == 100)
    {
      if (!Util.isNullOrNil(this.ITv.IDu.IEv))
      {
        paramView = (o.h)this.ITv.IDv.get(this.ITv.IDu.IEv);
        if (paramView != null)
        {
          i = p.a(this.mContext, this.ITv, paramView, this.ITv.field_appId, 1007);
          if (i != 0) {
            g.a(this.mContext, 10, 1007, 1, i, 0, this.ITv.field_appId, 0, this.ITv.IEh, this.ITv.field_gameMsgId, this.ITv.mNoticeId, g.a(null, null, this.ITv.IEi, null));
          }
          if (paramView.mJumpType != 4)
          {
            this.ITv.field_isRead = true;
            ((f)h.ax(f.class)).fCh().update(this.ITv, new String[0]);
          }
        }
      }
      this.ITx = System.currentTimeMillis();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if ((this.ITv != null) && (this.ITv.IDx != 3))
    {
      this.ITv.field_isRead = true;
      ((f)h.ax(f.class)).fCh().update(this.ITv, new String[0]);
    }
    int i = 0;
    switch (this.ITv.IDx)
    {
    default: 
      Log.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.ITv.IDx);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    case 1: 
      paramView = this.ITv.IDj;
      if (!Util.isNullOrNil(paramView)) {
        i = c.I(this.mContext, paramView, "game_center_bubble");
      }
    case 2: 
      for (;;)
      {
        g.a(this.mContext, 10, 1007, 1, i, 0, this.ITv.field_appId, 0, this.ITv.field_msgType, this.ITv.field_gameMsgId, this.ITv.mNoticeId, g.a(null, null, this.ITv.IEi, null));
        this.ITx = System.currentTimeMillis();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42280);
        return;
        if (!Util.isNullOrNil(this.ITv.field_appId))
        {
          paramView = new Bundle();
          paramView.putCharSequence("game_app_id", this.ITv.field_appId);
          paramView.putInt("game_report_from_scene", 1007);
          i = c.b(this.mContext, this.ITv.field_appId, null, paramView);
        }
        else
        {
          Log.e("MicroMsg.GameMessageHeaderView", "message type : " + this.ITv.field_msgType + " ,message.field_appId is null.");
        }
      }
    }
    localObject = new Intent();
    if (((com.tencent.mm.game.report.a.b)h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yHL, 1) == 1)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      this.ITu = ((ImageView)findViewById(h.e.HWe));
      this.ITt = ((TextView)findViewById(h.e.HWd));
      this.ITs = findViewById(h.e.HWf);
      setVisibility(8);
      this.mHasInit = true;
    }
    AppMethodBeat.o(42278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageBubbleView
 * JD-Core Version:    0.7.0.1
 */