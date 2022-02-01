package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class v
  implements View.OnClickListener
{
  private Context mContext;
  private int mPosition;
  private int mScene;
  private int uET;
  private int uoy;
  
  public v(Context paramContext)
  {
    this.mContext = paramContext;
    this.mScene = 13;
  }
  
  public final void gm(int paramInt1, int paramInt2)
  {
    this.uoy = paramInt1;
    this.uET = 1301;
    this.mPosition = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42415);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
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
      if (!bu.ht(paramView.umM))
      {
        localObject = ((o.k)paramView.umM.get(0)).unZ;
        if (bu.isNullOrNil((String)localObject)) {
          break label189;
        }
        i = c.aD(this.mContext, (String)localObject);
        localObject = f.a(null, null, paramView.unF, null);
        f.a(this.mContext, this.mScene, this.uET, this.mPosition, i, 0, paramView.field_appId, this.uoy, paramView.field_msgType, paramView.field_gameMsgId, paramView.unE, (String)localObject);
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42415);
      return;
      label189:
      ae.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
      continue;
      if ((paramView.getTag() instanceof String))
      {
        paramView = (String)paramView.getTag();
        if (bu.isNullOrNil(paramView))
        {
          a.a(this, "com/tencent/mm/plugin/game/ui/GameURLClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42415);
          return;
        }
        i = c.aD(this.mContext, paramView);
        f.a(this.mContext, this.mScene, this.uET, this.mPosition, i, this.uoy, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.v
 * JD-Core Version:    0.7.0.1
 */