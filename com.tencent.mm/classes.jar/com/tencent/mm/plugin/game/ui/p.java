package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  extends b
{
  public p(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.kQh = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (paramView == null)
    {
      y.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
      paramView = null;
      if (paramView != null) {
        break label84;
      }
      y.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
    }
    label84:
    do
    {
      do
      {
        return;
        if (!(paramView instanceof Long))
        {
          y.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
          paramView = null;
          break;
        }
        paramView = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().eP(((Long)paramView).longValue());
        if (paramView != null) {
          paramView.aZm();
        }
        break;
        switch (paramView.field_msgType)
        {
        case 7: 
        case 8: 
        case 9: 
        default: 
          i = a(this.mContext, paramView);
          com.tencent.mm.plugin.game.e.b.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.kQh, paramView.field_msgType, paramView.field_gameMsgId, paramView.kPN, null);
          return;
        case 10: 
        case 11: 
          if (!bk.bl(paramView.kOV))
          {
            i = com.tencent.mm.plugin.game.f.c.an(this.mContext, paramView.kOV);
            com.tencent.mm.plugin.game.e.b.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.kQh, paramView.field_msgType, paramView.field_gameMsgId, paramView.kPN, null);
            return;
          }
          i = a(this.mContext, paramView);
          com.tencent.mm.plugin.game.e.b.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.kQh, paramView.field_msgType, paramView.field_gameMsgId, paramView.kPN, null);
          return;
        }
      } while (bk.bl(paramView.kPx));
      i = com.tencent.mm.plugin.game.f.c.an(this.mContext, paramView.kPx);
      com.tencent.mm.plugin.game.e.b.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.kQh, paramView.field_msgType, paramView.field_gameMsgId, paramView.kPN, null);
      return;
    } while (bk.bl(paramView.kPA));
    int i = com.tencent.mm.plugin.game.f.c.an(this.mContext, paramView.kPA);
    com.tencent.mm.plugin.game.e.b.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.kQh, paramView.field_msgType, paramView.field_gameMsgId, paramView.kPN, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.p
 * JD-Core Version:    0.7.0.1
 */