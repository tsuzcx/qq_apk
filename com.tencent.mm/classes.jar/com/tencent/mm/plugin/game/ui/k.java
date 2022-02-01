package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  protected int rXI = 0;
  
  private void a(Context paramContext, com.tencent.mm.plugin.game.model.c paramc)
  {
    AppMethodBeat.i(42196);
    int i = 0;
    if (paramc.type == 1) {
      i = com.tencent.mm.plugin.game.f.c.ax(paramContext, paramc.rUV);
    }
    for (;;)
    {
      a(paramContext, paramc, i);
      AppMethodBeat.o(42196);
      return;
      if (paramc.type == 0) {
        if ((paramc.cCJ()) && (!bt.isNullOrNil(paramc.rVm.rZo)) && (!h.a(paramContext, paramc)))
        {
          i = com.tencent.mm.plugin.game.f.c.ax(paramContext, paramc.rVm.rZo);
        }
        else
        {
          if ((bt.isNullOrNil(paramc.eom)) || (paramc.eop != 4)) {
            break;
          }
          ad.i("MicroMsg.GameItemClickListener", "Download via Google Play");
          r.bK(paramContext, paramc.eom);
          i = 25;
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("game_app_id", paramc.field_appId);
    if (paramc.dvS == 1601) {
      localBundle.putInt("game_report_from_scene", this.rXI);
    }
    for (;;)
    {
      i = com.tencent.mm.plugin.game.f.c.a(paramContext, paramc.field_appId, paramc.rUV, localBundle);
      break;
      localBundle.putInt("game_report_from_scene", paramc.dvS);
    }
  }
  
  private void a(Context paramContext, com.tencent.mm.plugin.game.model.c paramc, int paramInt)
  {
    AppMethodBeat.i(42197);
    e.a(paramContext, paramc.scene, paramc.dvS, paramc.position, paramInt, paramc.field_appId, this.rXI, paramc.dcC, paramc.rVj);
    AppMethodBeat.o(42197);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42195);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c)))
    {
      AppMethodBeat.o(42195);
      return;
    }
    com.tencent.mm.plugin.game.model.c localc = (com.tencent.mm.plugin.game.model.c)paramView.getTag();
    a(paramView.getContext(), localc);
    AppMethodBeat.o(42195);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42194);
    paramAdapterView = paramAdapterView.getAdapter().getItem(paramInt);
    if ((paramAdapterView == null) || (!(paramAdapterView instanceof com.tencent.mm.plugin.game.model.c)))
    {
      AppMethodBeat.o(42194);
      return;
    }
    paramAdapterView = (com.tencent.mm.plugin.game.model.c)paramAdapterView;
    if (bt.isNullOrNil(paramAdapterView.field_appId))
    {
      AppMethodBeat.o(42194);
      return;
    }
    a(paramView.getContext(), paramAdapterView);
    AppMethodBeat.o(42194);
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.rXI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.k
 * JD-Core Version:    0.7.0.1
 */