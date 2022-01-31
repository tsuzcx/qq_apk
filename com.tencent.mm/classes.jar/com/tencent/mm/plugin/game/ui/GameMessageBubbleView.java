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
import com.tencent.mm.as.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.o.b;
import com.tencent.mm.plugin.game.model.o.d;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class GameMessageBubbleView
  extends LinearLayout
  implements View.OnClickListener
{
  View ldO;
  private TextView ldP;
  private ImageView ldQ;
  private com.tencent.mm.plugin.game.model.o ldR;
  private final long ldS = 500L;
  private long ldT = 0L;
  private Context mContext;
  private boolean mHasInit = false;
  
  public GameMessageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void bao()
  {
    ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
    this.ldR = r.aZr();
    if (this.ldR == null)
    {
      this.ldO.setOnClickListener(null);
      setVisibility(8);
      return;
    }
    this.ldR.aZm();
    if ((this.ldR.field_msgType == 100) && ((bk.bl(this.ldR.kPh.dkv)) || (bk.bl(this.ldR.kPh.kPS)) || (bk.bl(this.ldR.kPh.kPT)) || (!this.ldR.kPi.containsKey(this.ldR.kPh.kPT))))
    {
      y.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
      this.ldO.setOnClickListener(null);
      setVisibility(8);
      return;
    }
    this.ldP.setText(this.ldR.kPh.dkv);
    com.tencent.mm.as.o.ON().a(this.ldR.kPh.kPS, this.ldQ);
    this.ldO.setOnClickListener(this);
    setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.ldT <= 500L) {}
    while (this.ldR == null) {
      return;
    }
    ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
    r.aZs();
    int i;
    if (this.ldR.field_msgType == 100)
    {
      if (!bk.bl(this.ldR.kPh.kPT))
      {
        paramView = (o.d)this.ldR.kPi.get(this.ldR.kPh.kPT);
        if (paramView != null)
        {
          i = p.a(this.mContext, this.ldR, paramView, this.ldR.field_appId, 1007);
          if (i != 0) {
            com.tencent.mm.plugin.game.e.b.a(this.mContext, 10, 1007, 1, i, 0, this.ldR.field_appId, 0, this.ldR.kPM, this.ldR.field_gameMsgId, this.ldR.kPN, null);
          }
          if (paramView.kPV != 4)
          {
            this.ldR.field_isRead = true;
            ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().c(this.ldR, new String[0]);
          }
        }
      }
      this.ldT = System.currentTimeMillis();
      return;
    }
    if ((this.ldR != null) && (this.ldR.kPk != 3))
    {
      this.ldR.field_isRead = true;
      ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().c(this.ldR, new String[0]);
    }
    switch (this.ldR.kPk)
    {
    default: 
      y.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.ldR.kPk);
      return;
    case 1: 
      paramView = this.ldR.kOW;
      if (!bk.bl(paramView)) {
        i = com.tencent.mm.plugin.game.f.c.o(this.mContext, paramView, "game_center_bubble");
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.game.e.b.a(this.mContext, 10, 1007, 1, i, 0, this.ldR.field_appId, 0, this.ldR.field_msgType, this.ldR.field_gameMsgId, this.ldR.kPN, null);
      this.ldT = System.currentTimeMillis();
      return;
      if (!bk.bl(this.ldR.field_appId))
      {
        paramView = new Bundle();
        paramView.putCharSequence("game_app_id", this.ldR.field_appId);
        paramView.putInt("game_report_from_scene", 1007);
        i = com.tencent.mm.plugin.game.f.c.b(this.mContext, this.ldR.field_appId, null, paramView);
      }
      else
      {
        y.e("MicroMsg.GameMessageHeaderView", "message type : " + this.ldR.field_msgType + " ,message.field_appId is null.");
        i = 0;
        continue;
        paramView = new Intent(this.mContext, GameMessageUI.class);
        paramView.putExtra("game_report_from_scene", 1007);
        this.mContext.startActivity(paramView);
        i = 6;
        continue;
        i = 0;
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (!this.mHasInit)
    {
      this.ldQ = ((ImageView)findViewById(g.e.game_msg_bubble_icon));
      this.ldP = ((TextView)findViewById(g.e.game_msg_bubble_desc));
      this.ldO = findViewById(g.e.game_msg_bubble_layout);
      setVisibility(8);
      this.mHasInit = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageBubbleView
 * JD-Core Version:    0.7.0.1
 */