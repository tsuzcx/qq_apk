package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class v
  implements View.OnClickListener
{
  private int IFc;
  private int IVo;
  private Context mContext;
  private int mPosition;
  private int mScene;
  
  public v(Context paramContext)
  {
    this.mContext = paramContext;
    this.mScene = 13;
  }
  
  public final void jh(int paramInt1, int paramInt2)
  {
    this.IFc = paramInt1;
    this.IVo = 1301;
    this.mPosition = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42415);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
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
      if (!Util.isNullOrNil(paramView.IDq))
      {
        localObject = ((o.l)paramView.IDq.get(0)).IEE;
        if (Util.isNullOrNil((String)localObject)) {
          break label189;
        }
        i = c.ba(this.mContext, (String)localObject);
        localObject = g.a(null, null, paramView.IEi, null);
        g.a(this.mContext, this.mScene, this.IVo, this.mPosition, i, 0, paramView.field_appId, this.IFc, paramView.field_msgType, paramView.field_gameMsgId, paramView.mNoticeId, (String)localObject);
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
        i = c.ba(this.mContext, paramView);
        g.a(this.mContext, this.mScene, this.IVo, this.mPosition, i, this.IFc, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.v
 * JD-Core Version:    0.7.0.1
 */