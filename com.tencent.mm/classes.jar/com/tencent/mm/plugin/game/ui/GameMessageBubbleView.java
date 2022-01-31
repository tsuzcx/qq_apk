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
import com.tencent.mm.at.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.c;
import com.tencent.mm.plugin.game.model.n.e;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class GameMessageBubbleView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context mContext;
  private boolean mHasInit = false;
  View nBJ;
  private TextView nBK;
  private ImageView nBL;
  private n nBM;
  private final long nBN = 500L;
  private long nBO = 0L;
  
  public GameMessageBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public final void bHu()
  {
    AppMethodBeat.i(112085);
    ((d)g.E(d.class)).bER();
    this.nBM = q.bGr();
    if (this.nBM == null)
    {
      this.nBJ.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(112085);
      return;
    }
    this.nBM.bGm();
    if ((this.nBM.field_msgType == 100) && ((bo.isNullOrNil(this.nBM.nnd.mDesc)) || (bo.isNullOrNil(this.nBM.nnd.nnT)) || (bo.isNullOrNil(this.nBM.nnd.nnU)) || (!this.nBM.nne.containsKey(this.nBM.nnd.nnU))))
    {
      ab.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
      this.nBJ.setOnClickListener(null);
      setVisibility(8);
      AppMethodBeat.o(112085);
      return;
    }
    this.nBK.setText(this.nBM.nnd.mDesc);
    com.tencent.mm.at.o.ahG().a(this.nBM.nnd.nnT, this.nBL);
    this.nBJ.setOnClickListener(this);
    setVisibility(0);
    AppMethodBeat.o(112085);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112086);
    if (System.currentTimeMillis() - this.nBO <= 500L)
    {
      AppMethodBeat.o(112086);
      return;
    }
    if (this.nBM == null)
    {
      AppMethodBeat.o(112086);
      return;
    }
    ((d)g.E(d.class)).bER();
    q.bGs();
    int i;
    if (this.nBM.field_msgType == 100)
    {
      if (!bo.isNullOrNil(this.nBM.nnd.nnU))
      {
        paramView = (n.e)this.nBM.nne.get(this.nBM.nnd.nnU);
        if (paramView != null)
        {
          i = com.tencent.mm.plugin.game.model.o.a(this.mContext, this.nBM, paramView, this.nBM.field_appId, 1007);
          if (i != 0) {
            com.tencent.mm.game.report.c.a(this.mContext, 10, 1007, 1, i, 0, this.nBM.field_appId, 0, this.nBM.nnL, this.nBM.field_gameMsgId, this.nBM.nnM, null);
          }
          if (paramView.mJumpType != 4)
          {
            this.nBM.field_isRead = true;
            ((e)g.E(e.class)).bES().update(this.nBM, new String[0]);
          }
        }
      }
      this.nBO = System.currentTimeMillis();
      AppMethodBeat.o(112086);
      return;
    }
    if ((this.nBM != null) && (this.nBM.nng != 3))
    {
      this.nBM.field_isRead = true;
      ((e)g.E(e.class)).bES().update(this.nBM, new String[0]);
    }
    switch (this.nBM.nng)
    {
    default: 
      ab.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.nBM.nng);
      AppMethodBeat.o(112086);
      return;
    case 1: 
      paramView = this.nBM.nmS;
      if (!bo.isNullOrNil(paramView)) {
        i = com.tencent.mm.plugin.game.f.c.t(this.mContext, paramView, "game_center_bubble");
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.game.report.c.a(this.mContext, 10, 1007, 1, i, 0, this.nBM.field_appId, 0, this.nBM.field_msgType, this.nBM.field_gameMsgId, this.nBM.nnM, null);
      this.nBO = System.currentTimeMillis();
      AppMethodBeat.o(112086);
      return;
      if (!bo.isNullOrNil(this.nBM.field_appId))
      {
        paramView = new Bundle();
        paramView.putCharSequence("game_app_id", this.nBM.field_appId);
        paramView.putInt("game_report_from_scene", 1007);
        i = com.tencent.mm.plugin.game.f.c.b(this.mContext, this.nBM.field_appId, null, paramView);
      }
      else
      {
        ab.e("MicroMsg.GameMessageHeaderView", "message type : " + this.nBM.field_msgType + " ,message.field_appId is null.");
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
    AppMethodBeat.i(112084);
    super.onFinishInflate();
    if (!this.mHasInit)
    {
      this.nBL = ((ImageView)findViewById(2131824464));
      this.nBK = ((TextView)findViewById(2131824465));
      this.nBJ = findViewById(2131824463);
      setVisibility(8);
      this.mHasInit = true;
    }
    AppMethodBeat.o(112084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageBubbleView
 * JD-Core Version:    0.7.0.1
 */