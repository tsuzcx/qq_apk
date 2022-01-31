package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class v
  implements View.OnClickListener
{
  private Context mContext;
  private int mPosition;
  private int mScene;
  private int nDJ;
  private int nok;
  
  public v(Context paramContext)
  {
    this.mContext = paramContext;
    this.mScene = 13;
  }
  
  public final void ev(int paramInt1, int paramInt2)
  {
    this.nok = paramInt1;
    this.nDJ = 1301;
    this.mPosition = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112217);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(112217);
      return;
    }
    int i;
    if ((paramView.getTag() instanceof n))
    {
      paramView = (n)paramView.getTag();
      if (!bo.es(paramView.nmZ))
      {
        String str = ((n.i)paramView.nmZ.get(0)).nod;
        if (!bo.isNullOrNil(str))
        {
          i = com.tencent.mm.plugin.game.f.c.ax(this.mContext, str);
          com.tencent.mm.game.report.c.a(this.mContext, this.mScene, this.nDJ, this.mPosition, i, 0, paramView.field_appId, this.nok, paramView.field_msgType, paramView.field_gameMsgId, paramView.nnM, null);
          AppMethodBeat.o(112217);
          return;
        }
        ab.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
      }
      AppMethodBeat.o(112217);
      return;
    }
    if ((paramView.getTag() instanceof String))
    {
      paramView = (String)paramView.getTag();
      if (bo.isNullOrNil(paramView))
      {
        AppMethodBeat.o(112217);
        return;
      }
      i = com.tencent.mm.plugin.game.f.c.ax(this.mContext, paramView);
      com.tencent.mm.game.report.c.a(this.mContext, this.mScene, this.nDJ, this.mPosition, i, this.nok, null);
    }
    AppMethodBeat.o(112217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.v
 * JD-Core Version:    0.7.0.1
 */