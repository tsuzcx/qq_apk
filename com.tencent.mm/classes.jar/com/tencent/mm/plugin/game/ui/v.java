package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class v
  implements View.OnClickListener
{
  private Context mContext;
  private int mPosition;
  private int mScene;
  private int tfA;
  private int tvb;
  
  public v(Context paramContext)
  {
    this.mContext = paramContext;
    this.mScene = 13;
  }
  
  public final void fW(int paramInt1, int paramInt2)
  {
    this.tfA = paramInt1;
    this.tvb = 1301;
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
      if (!bs.gY(paramView.tdU))
      {
        String str = ((o.i)paramView.tdU.get(0)).tfe;
        if (!bs.isNullOrNil(str))
        {
          i = c.ay(this.mContext, str);
          str = e.a(null, null, paramView.teK, null);
          e.a(this.mContext, this.mScene, this.tvb, this.mPosition, i, 0, paramView.field_appId, this.tfA, paramView.field_msgType, paramView.field_gameMsgId, paramView.teJ, str);
          AppMethodBeat.o(42415);
          return;
        }
        ac.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
      }
      AppMethodBeat.o(42415);
      return;
    }
    if ((paramView.getTag() instanceof String))
    {
      paramView = (String)paramView.getTag();
      if (bs.isNullOrNil(paramView))
      {
        AppMethodBeat.o(42415);
        return;
      }
      i = c.ay(this.mContext, paramView);
      e.a(this.mContext, this.mScene, this.tvb, this.mPosition, i, this.tfA, null);
    }
    AppMethodBeat.o(42415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.v
 * JD-Core Version:    0.7.0.1
 */