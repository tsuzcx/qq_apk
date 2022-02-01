package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public final class p
  implements View.OnClickListener
{
  private Context mContext;
  public int tfA;
  
  public p(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public p(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.tfA = paramInt;
  }
  
  private static int a(Context paramContext, o paramo, int paramInt)
  {
    AppMethodBeat.i(41460);
    if (paramo != null)
    {
      paramo.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().update(paramo, new String[0]);
    }
    paramo = new Intent();
    int i;
    if (((b)g.ab(b.class)).a(b.a.pME, 0) == 1)
    {
      i = 1;
      if (i == 0) {
        break label160;
      }
      paramo.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI");
    }
    for (;;)
    {
      paramo.putExtra("game_report_from_scene", paramInt);
      paramo = new com.tencent.mm.hellhoundlib.b.a().ba(paramo);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramo.aeD(), "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramo.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(41460);
      return 6;
      i = 0;
      break;
      label160:
      paramo.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameMessageUI");
    }
  }
  
  public static int a(Context paramContext, o paramo, o.e parame, String paramString, int paramInt)
  {
    AppMethodBeat.i(41456);
    int i = 0;
    switch (parame.mJumpType)
    {
    default: 
      ac.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + parame.mJumpType);
      paramInt = i;
    }
    for (;;)
    {
      AppMethodBeat.o(41456);
      return paramInt;
      paramInt = j(paramContext, paramString, paramInt);
      continue;
      paramInt = av(paramContext, paramString);
      continue;
      paramInt = k(paramContext, paramString, paramInt);
      continue;
      paramInt = a(paramContext, paramo, paramInt);
      continue;
      paramInt = aw(paramContext, parame.pGs);
    }
  }
  
  private static int av(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41457);
    if (h.t(paramContext, paramString))
    {
      e.aj(paramContext, paramString);
      AppMethodBeat.o(41457);
      return 3;
    }
    AppMethodBeat.o(41457);
    return 0;
  }
  
  private static int aw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41461);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41461);
      return 0;
    }
    int i = c.ay(paramContext, paramString);
    AppMethodBeat.o(41461);
    return i;
  }
  
  private static int j(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(41458);
    if (h.t(paramContext, paramString))
    {
      e.aj(paramContext, paramString);
      AppMethodBeat.o(41458);
      return 3;
    }
    paramInt = k(paramContext, paramString, paramInt);
    AppMethodBeat.o(41458);
    return paramInt;
  }
  
  private static int k(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(41459);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41459);
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("game_app_id", paramString);
    localBundle.putInt("game_report_from_scene", paramInt);
    paramInt = c.a(paramContext, paramString, null, localBundle);
    AppMethodBeat.o(41459);
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41455);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ac.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
      AppMethodBeat.o(41455);
      return;
    }
    paramView = (a)paramView.getTag();
    if (paramView.tfB == null)
    {
      ac.e("MicroMsg.GameMessageClickListener", "message is null");
      AppMethodBeat.o(41455);
      return;
    }
    if (paramView.tfg == null)
    {
      ac.e("MicroMsg.GameMessageClickListener", "jumpId is null");
      AppMethodBeat.o(41455);
      return;
    }
    Object localObject = (o.e)paramView.tfB.tdZ.get(paramView.tfg);
    if (localObject == null)
    {
      ac.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
      AppMethodBeat.o(41455);
      return;
    }
    int i = a(this.mContext, paramView.tfB, (o.e)localObject, paramView.tfB.field_appId, paramView.dtF);
    if (i != 0)
    {
      localObject = com.tencent.mm.game.report.e.a(null, null, paramView.tfB.teK, null);
      com.tencent.mm.game.report.e.a(this.mContext, 13, paramView.dtF, paramView.position, i, 0, paramView.tfB.field_appId, this.tfA, paramView.tfB.teI, paramView.tfB.field_gameMsgId, paramView.tfB.teJ, (String)localObject);
    }
    AppMethodBeat.o(41455);
  }
  
  public static final class a
  {
    public int dtF;
    public int position;
    public o tfB;
    public String tfg;
    
    public a(o paramo, String paramString, int paramInt)
    {
      this.tfB = paramo;
      this.tfg = paramString;
      this.dtF = 1301;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.p
 * JD-Core Version:    0.7.0.1
 */