package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class v
  implements View.OnClickListener
{
  private int fzn;
  private int kQh;
  private int lfO;
  private Context mContext;
  private int mPosition;
  
  public v(Context paramContext)
  {
    this.mContext = paramContext;
    this.fzn = 13;
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    this.kQh = paramInt1;
    this.lfO = 1301;
    this.mPosition = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!(paramView.getTag() instanceof o)) {
            break;
          }
          paramView = (o)paramView.getTag();
        } while (bk.dk(paramView.kPd));
        String str = ((o.h)paramView.kPd.get(0)).kQc;
        if (!bk.bl(str))
        {
          i = c.an(this.mContext, str);
          b.a(this.mContext, this.fzn, this.lfO, this.mPosition, i, 0, paramView.field_appId, this.kQh, paramView.field_msgType, paramView.field_gameMsgId, paramView.kPN, null);
          return;
        }
        y.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
        return;
      } while (!(paramView.getTag() instanceof String));
      paramView = (String)paramView.getTag();
    } while (bk.bl(paramView));
    int i = c.an(this.mContext, paramView);
    b.a(this.mContext, this.fzn, this.lfO, this.mPosition, i, this.kQh, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.v
 * JD-Core Version:    0.7.0.1
 */