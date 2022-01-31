package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  protected int nok = 0;
  
  private void a(Context paramContext, com.tencent.mm.plugin.game.model.c paramc)
  {
    AppMethodBeat.i(112008);
    int i = 0;
    if (paramc.type == 1) {
      i = com.tencent.mm.plugin.game.f.c.ax(paramContext, paramc.nlW);
    }
    for (;;)
    {
      a(paramContext, paramc, i);
      AppMethodBeat.o(112008);
      return;
      if (paramc.type == 0) {
        if ((paramc.bFQ()) && (!bo.isNullOrNil(paramc.nmp.npR)) && (!g.a(paramContext, paramc)))
        {
          i = com.tencent.mm.plugin.game.f.c.ax(paramContext, paramc.nmp.npR);
        }
        else
        {
          if ((bo.isNullOrNil(paramc.djP)) || (paramc.djS != 4)) {
            break;
          }
          ab.i("MicroMsg.GameItemClickListener", "Download via Google Play");
          q.bw(paramContext, paramc.djP);
          i = 25;
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("game_app_id", paramc.field_appId);
    if (paramc.cFj == 1601) {
      localBundle.putInt("game_report_from_scene", this.nok);
    }
    for (;;)
    {
      i = com.tencent.mm.plugin.game.f.c.b(paramContext, paramc.field_appId, paramc.nlW, localBundle);
      break;
      localBundle.putInt("game_report_from_scene", paramc.cFj);
    }
  }
  
  private void a(Context paramContext, com.tencent.mm.plugin.game.model.c paramc, int paramInt)
  {
    AppMethodBeat.i(112009);
    com.tencent.mm.game.report.c.a(paramContext, paramc.scene, paramc.cFj, paramc.position, paramInt, paramc.field_appId, this.nok, paramc.cnG, paramc.nml);
    AppMethodBeat.o(112009);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112007);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c)))
    {
      AppMethodBeat.o(112007);
      return;
    }
    com.tencent.mm.plugin.game.model.c localc = (com.tencent.mm.plugin.game.model.c)paramView.getTag();
    a(paramView.getContext(), localc);
    AppMethodBeat.o(112007);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(112006);
    paramAdapterView = paramAdapterView.getAdapter().getItem(paramInt);
    if ((paramAdapterView == null) || (!(paramAdapterView instanceof com.tencent.mm.plugin.game.model.c)))
    {
      AppMethodBeat.o(112006);
      return;
    }
    paramAdapterView = (com.tencent.mm.plugin.game.model.c)paramAdapterView;
    if (bo.isNullOrNil(paramAdapterView.field_appId))
    {
      AppMethodBeat.o(112006);
      return;
    }
    a(paramView.getContext(), paramAdapterView);
    AppMethodBeat.o(112006);
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.nok = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.k
 * JD-Core Version:    0.7.0.1
 */