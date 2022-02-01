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
import com.tencent.mm.ay.q;
import com.tencent.mm.game.report.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.o.h;
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
  View CZc;
  private TextView CZd;
  private ImageView CZe;
  private o CZf;
  private final long CZg = 500L;
  private long CZh = 0L;
  private Context mContext;
  private boolean mHasInit = false;
  
  public GameMessageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void ezD()
  {
    AppMethodBeat.i(42279);
    ((e)h.ae(e.class)).evn();
    this.CZf = r.eyA();
    if (this.CZf == null)
    {
      this.CZc.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.CZf.eyt();
    if ((this.CZf.field_msgType == 100) && ((Util.isNullOrNil(this.CZf.CJj.mDesc)) || (Util.isNullOrNil(this.CZf.CJj.CKj)) || (Util.isNullOrNil(this.CZf.CJj.CKk)) || (!this.CZf.CJk.containsKey(this.CZf.CJj.CKk))))
    {
      Log.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
      this.CZc.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(42279);
      return;
    }
    this.CZd.setText(this.CZf.CJj.mDesc);
    q.bml().loadImage(this.CZf.CJj.CKj, this.CZe);
    this.CZc.setOnClickListener(this);
    setVisibility(0);
    AppMethodBeat.o(42279);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42280);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (System.currentTimeMillis() - this.CZh <= 500L)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if (this.CZf == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    ((e)h.ae(e.class)).evn().eyB();
    if (this.CZf.field_msgType == 100)
    {
      if (!Util.isNullOrNil(this.CZf.CJj.CKk))
      {
        paramView = (o.h)this.CZf.CJk.get(this.CZf.CJj.CKk);
        if (paramView != null)
        {
          i = p.a(this.mContext, this.CZf, paramView, this.CZf.field_appId, 1007);
          if (i != 0) {
            g.a(this.mContext, 10, 1007, 1, i, 0, this.CZf.field_appId, 0, this.CZf.CJW, this.CZf.field_gameMsgId, this.CZf.CJX, g.a(null, null, this.CZf.CJY, null));
          }
          if (paramView.mJumpType != 4)
          {
            this.CZf.field_isRead = true;
            ((f)h.ae(f.class)).evo().update(this.CZf, new String[0]);
          }
        }
      }
      this.CZh = System.currentTimeMillis();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    }
    if ((this.CZf != null) && (this.CZf.CJm != 3))
    {
      this.CZf.field_isRead = true;
      ((f)h.ae(f.class)).evo().update(this.CZf, new String[0]);
    }
    int i = 0;
    switch (this.CZf.CJm)
    {
    default: 
      Log.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.CZf.CJm);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42280);
      return;
    case 1: 
      paramView = this.CZf.CIY;
      if (!Util.isNullOrNil(paramView)) {
        i = c.I(this.mContext, paramView, "game_center_bubble");
      }
    case 2: 
      for (;;)
      {
        g.a(this.mContext, 10, 1007, 1, i, 0, this.CZf.field_appId, 0, this.CZf.field_msgType, this.CZf.field_gameMsgId, this.CZf.CJX, g.a(null, null, this.CZf.CJY, null));
        this.CZh = System.currentTimeMillis();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42280);
        return;
        if (!Util.isNullOrNil(this.CZf.field_appId))
        {
          paramView = new Bundle();
          paramView.putCharSequence("game_app_id", this.CZf.field_appId);
          paramView.putInt("game_report_from_scene", 1007);
          i = c.b(this.mContext, this.CZf.field_appId, null, paramView);
        }
        else
        {
          Log.e("MicroMsg.GameMessageHeaderView", "message type : " + this.CZf.field_msgType + " ,message.field_appId is null.");
        }
      }
    }
    localObject = new Intent();
    if (((com.tencent.mm.game.report.a.b)h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vuR, 0) == 1)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/ui/GameMessageBubbleView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
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
      this.CZe = ((ImageView)findViewById(g.e.CjW));
      this.CZd = ((TextView)findViewById(g.e.CjV));
      this.CZc = findViewById(g.e.CjX);
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