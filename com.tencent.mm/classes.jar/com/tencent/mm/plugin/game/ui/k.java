package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.y;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.protobuf.ck;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  protected int CKU = 0;
  
  private void a(Context paramContext, com.tencent.mm.plugin.game.model.c paramc)
  {
    AppMethodBeat.i(42196);
    int i = 0;
    if (paramc.type == 1) {
      i = com.tencent.mm.plugin.game.d.c.aY(paramContext, paramc.CHY);
    }
    for (;;)
    {
      a(paramContext, paramc, i);
      AppMethodBeat.o(42196);
      return;
      if (paramc.type == 0) {
        if ((paramc.exW()) && (!Util.isNullOrNil(paramc.CIp.CMD)) && (!h.a(paramContext, paramc)))
        {
          i = com.tencent.mm.plugin.game.d.c.aY(paramContext, paramc.CIp.CMD);
        }
        else
        {
          if ((Util.isNullOrNil(paramc.hrJ)) || (paramc.hrM != 4)) {
            break;
          }
          Log.i("MicroMsg.GameItemClickListener", "Download via Google Play");
          r.cw(paramContext, paramc.hrJ);
          i = 25;
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("game_app_id", paramc.field_appId);
    if (paramc.fSl == 1601) {
      localBundle.putInt("game_report_from_scene", this.CKU);
    }
    for (;;)
    {
      i = com.tencent.mm.plugin.game.d.c.b(paramContext, paramc.field_appId, paramc.CHY, localBundle);
      break;
      localBundle.putInt("game_report_from_scene", paramc.fSl);
    }
  }
  
  private void a(Context paramContext, com.tencent.mm.plugin.game.model.c paramc, int paramInt)
  {
    AppMethodBeat.i(42197);
    g.a(paramContext, paramc.scene, paramc.fSl, paramc.position, paramInt, paramc.field_appId, this.CKU, paramc.fwt, paramc.CIm);
    AppMethodBeat.o(42197);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42195);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c)))
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42195);
      return;
    }
    localObject = (com.tencent.mm.plugin.game.model.c)paramView.getTag();
    a(paramView.getContext(), (com.tencent.mm.plugin.game.model.c)localObject);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42195);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42194);
    b localb = new b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    a.c("com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    paramAdapterView = paramAdapterView.getAdapter().getItem(paramInt);
    if ((paramAdapterView == null) || (!(paramAdapterView instanceof com.tencent.mm.plugin.game.model.c)))
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42194);
      return;
    }
    paramAdapterView = (com.tencent.mm.plugin.game.model.c)paramAdapterView;
    if (Util.isNullOrNil(paramAdapterView.field_appId))
    {
      a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42194);
      return;
    }
    a(paramView.getContext(), paramAdapterView);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(42194);
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.CKU = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.k
 * JD-Core Version:    0.7.0.1
 */