package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class v
  implements View.OnClickListener
{
  private Context mContext;
  private int mPosition;
  private int mScene;
  private int xGR;
  private int xWQ;
  
  public v(Context paramContext)
  {
    this.mContext = paramContext;
    this.mScene = 13;
  }
  
  public final void gL(int paramInt1, int paramInt2)
  {
    this.xGR = paramInt1;
    this.xWQ = 1301;
    this.mPosition = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42415);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (paramView.getTag() == null)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42415);
      return;
    }
    int i;
    if ((paramView.getTag() instanceof o))
    {
      paramView = (o)paramView.getTag();
      if (!Util.isNullOrNil(paramView.xFe))
      {
        localObject = ((o.k)paramView.xFe.get(0)).xGq;
        if (Util.isNullOrNil((String)localObject)) {
          break label189;
        }
        i = c.aQ(this.mContext, (String)localObject);
        localObject = f.a(null, null, paramView.xFX, null);
        f.a(this.mContext, this.mScene, this.xWQ, this.mPosition, i, 0, paramView.field_appId, this.xGR, paramView.field_msgType, paramView.field_gameMsgId, paramView.xFW, (String)localObject);
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42415);
      return;
      label189:
      Log.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
      continue;
      if ((paramView.getTag() instanceof String))
      {
        paramView = (String)paramView.getTag();
        if (Util.isNullOrNil(paramView))
        {
          a.a(this, "com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42415);
          return;
        }
        i = c.aQ(this.mContext, paramView);
        f.a(this.mContext, this.mScene, this.xWQ, this.mPosition, i, this.xGR, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.v
 * JD-Core Version:    0.7.0.1
 */