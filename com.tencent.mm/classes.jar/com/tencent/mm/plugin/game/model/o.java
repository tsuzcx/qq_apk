package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class o
  implements View.OnClickListener
{
  private Context mContext;
  public int nok;
  
  public o(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public o(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.nok = paramInt;
  }
  
  private static int a(Context paramContext, n paramn, int paramInt)
  {
    AppMethodBeat.i(111297);
    if (paramn != null)
    {
      paramn.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bES().update(paramn, new String[0]);
    }
    paramn = new Intent();
    paramn.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameMessageUI");
    paramn.putExtra("game_report_from_scene", paramInt);
    paramContext.startActivity(paramn);
    AppMethodBeat.o(111297);
    return 6;
  }
  
  public static int a(Context paramContext, n paramn, n.e parame, String paramString, int paramInt)
  {
    AppMethodBeat.i(111293);
    int i = 0;
    switch (parame.mJumpType)
    {
    default: 
      ab.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + parame.mJumpType);
      paramInt = i;
    }
    for (;;)
    {
      AppMethodBeat.o(111293);
      return paramInt;
      paramInt = i(paramContext, paramString, paramInt);
      continue;
      paramInt = au(paramContext, paramString);
      continue;
      paramInt = j(paramContext, paramString, paramInt);
      continue;
      paramInt = a(paramContext, paramn, paramInt);
      continue;
      paramInt = av(paramContext, parame.lMw);
    }
  }
  
  private static int au(Context paramContext, String paramString)
  {
    AppMethodBeat.i(111294);
    if (com.tencent.mm.pluginsdk.model.app.g.u(paramContext, paramString))
    {
      e.aj(paramContext, paramString);
      AppMethodBeat.o(111294);
      return 3;
    }
    AppMethodBeat.o(111294);
    return 0;
  }
  
  private static int av(Context paramContext, String paramString)
  {
    AppMethodBeat.i(111298);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111298);
      return 0;
    }
    int i = com.tencent.mm.plugin.game.f.c.ax(paramContext, paramString);
    AppMethodBeat.o(111298);
    return i;
  }
  
  private static int i(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(111295);
    if (com.tencent.mm.pluginsdk.model.app.g.u(paramContext, paramString))
    {
      e.aj(paramContext, paramString);
      AppMethodBeat.o(111295);
      return 3;
    }
    paramInt = j(paramContext, paramString, paramInt);
    AppMethodBeat.o(111295);
    return paramInt;
  }
  
  private static int j(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(111296);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111296);
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("game_app_id", paramString);
    localBundle.putInt("game_report_from_scene", paramInt);
    paramInt = com.tencent.mm.plugin.game.f.c.b(paramContext, paramString, null, localBundle);
    AppMethodBeat.o(111296);
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111292);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof o.a)))
    {
      ab.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
      AppMethodBeat.o(111292);
      return;
    }
    paramView = (o.a)paramView.getTag();
    if (paramView.nol == null)
    {
      ab.e("MicroMsg.GameMessageClickListener", "message is null");
      AppMethodBeat.o(111292);
      return;
    }
    if (paramView.nof == null)
    {
      ab.e("MicroMsg.GameMessageClickListener", "jumpId is null");
      AppMethodBeat.o(111292);
      return;
    }
    n.e locale = (n.e)paramView.nol.nne.get(paramView.nof);
    if (locale == null)
    {
      ab.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
      AppMethodBeat.o(111292);
      return;
    }
    int i = a(this.mContext, paramView.nol, locale, paramView.nol.field_appId, paramView.cFj);
    if (i != 0) {
      com.tencent.mm.game.report.c.a(this.mContext, 13, paramView.cFj, paramView.position, i, 0, paramView.nol.field_appId, this.nok, paramView.nol.nnL, paramView.nol.field_gameMsgId, paramView.nol.nnM, null);
    }
    AppMethodBeat.o(111292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.o
 * JD-Core Version:    0.7.0.1
 */