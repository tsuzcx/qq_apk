package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class p
  implements View.OnClickListener
{
  private Context mContext;
  public int udq;
  
  public p(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public p(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.udq = paramInt;
  }
  
  private static int a(Context paramContext, o paramo, int paramInt)
  {
    AppMethodBeat.i(41460);
    if (paramo != null)
    {
      paramo.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().update(paramo, new String[0]);
    }
    paramo = new Intent();
    int i;
    if (((com.tencent.mm.game.report.a.b)g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qqu, 0) == 1)
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
      paramo = new com.tencent.mm.hellhoundlib.b.a().bc(paramo);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramo.ahp(), "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramo.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(41460);
      return 6;
      i = 0;
      break;
      label160:
      paramo.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameMessageUI");
    }
  }
  
  public static int a(Context paramContext, o paramo, o.f paramf, String paramString, int paramInt)
  {
    AppMethodBeat.i(41456);
    int i = 0;
    switch (paramf.mJumpType)
    {
    default: 
      ad.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + paramf.mJumpType);
      paramInt = i;
    }
    for (;;)
    {
      AppMethodBeat.o(41456);
      return paramInt;
      paramInt = j(paramContext, paramString, paramInt);
      continue;
      paramInt = ay(paramContext, paramString);
      continue;
      paramInt = k(paramContext, paramString, paramInt);
      continue;
      paramInt = a(paramContext, paramo, paramInt);
      continue;
      paramInt = az(paramContext, paramf.qjX);
    }
  }
  
  private static int ay(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41457);
    if (h.s(paramContext, paramString))
    {
      e.ai(paramContext, paramString);
      AppMethodBeat.o(41457);
      return 3;
    }
    AppMethodBeat.o(41457);
    return 0;
  }
  
  private static int az(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41461);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41461);
      return 0;
    }
    int i = c.aB(paramContext, paramString);
    AppMethodBeat.o(41461);
    return i;
  }
  
  private static int j(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(41458);
    if (h.s(paramContext, paramString))
    {
      e.ai(paramContext, paramString);
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
    if (bt.isNullOrNil(paramString))
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
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ad.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    paramView = (a)paramView.getTag();
    if (paramView.udr == null)
    {
      ad.e("MicroMsg.GameMessageClickListener", "message is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    if (paramView.ucW == null)
    {
      ad.e("MicroMsg.GameMessageClickListener", "jumpId is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    localObject = (o.f)paramView.udr.ubP.get(paramView.ucW);
    if (localObject == null)
    {
      ad.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    int i = a(this.mContext, paramView.udr, (o.f)localObject, paramView.udr.field_appId, paramView.dFG);
    if (i != 0)
    {
      localObject = com.tencent.mm.game.report.f.a(null, null, paramView.udr.ucB, null);
      com.tencent.mm.game.report.f.a(this.mContext, 13, paramView.dFG, paramView.position, i, 0, paramView.udr.field_appId, this.udq, paramView.udr.ucz, paramView.udr.field_gameMsgId, paramView.udr.ucA, (String)localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41455);
  }
  
  public static final class a
  {
    public int dFG;
    public int position;
    public String ucW;
    public o udr;
    
    public a(o paramo, String paramString, int paramInt)
    {
      this.udr = paramo;
      this.ucW = paramString;
      this.dFG = 1301;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.p
 * JD-Core Version:    0.7.0.1
 */