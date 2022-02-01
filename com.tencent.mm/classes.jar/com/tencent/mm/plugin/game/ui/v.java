package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class v
  implements View.OnClickListener
{
  private Context mContext;
  private int mPosition;
  private int mScene;
  private int rXI;
  private int sni;
  
  public v(Context paramContext)
  {
    this.mContext = paramContext;
    this.mScene = 13;
  }
  
  public final void fP(int paramInt1, int paramInt2)
  {
    this.rXI = paramInt1;
    this.sni = 1301;
    this.mPosition = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42415);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(42415);
      return;
    }
    int i;
    if ((paramView.getTag() instanceof o))
    {
      paramView = (o)paramView.getTag();
      if (!bt.gL(paramView.rWc))
      {
        String str = ((o.i)paramView.rWc.get(0)).rXm;
        if (!bt.isNullOrNil(str))
        {
          i = c.ax(this.mContext, str);
          str = e.a(null, null, paramView.rWS, null);
          e.a(this.mContext, this.mScene, this.sni, this.mPosition, i, 0, paramView.field_appId, this.rXI, paramView.field_msgType, paramView.field_gameMsgId, paramView.rWR, str);
          AppMethodBeat.o(42415);
          return;
        }
        ad.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
      }
      AppMethodBeat.o(42415);
      return;
    }
    if ((paramView.getTag() instanceof String))
    {
      paramView = (String)paramView.getTag();
      if (bt.isNullOrNil(paramView))
      {
        AppMethodBeat.o(42415);
        return;
      }
      i = c.ax(this.mContext, paramView);
      e.a(this.mContext, this.mScene, this.sni, this.mPosition, i, this.rXI, null);
    }
    AppMethodBeat.o(42415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.v
 * JD-Core Version:    0.7.0.1
 */