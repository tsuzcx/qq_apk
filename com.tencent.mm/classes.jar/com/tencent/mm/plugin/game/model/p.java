package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class p
  implements View.OnClickListener
{
  private Context mContext;
  public int xGR;
  
  public p(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public p(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.xGR = paramInt;
  }
  
  private static int a(Context paramContext, o paramo, int paramInt)
  {
    AppMethodBeat.i(41460);
    if (paramo != null)
    {
      paramo.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().update(paramo, new String[0]);
    }
    paramo = new Intent();
    int i;
    if (((com.tencent.mm.game.report.a.b)g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.rOP, 0) == 1)
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
      paramo = new com.tencent.mm.hellhoundlib.b.a().bl(paramo);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramo.axQ(), "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramo.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(41460);
      return 6;
      i = 0;
      break;
      label160:
      paramo.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameMessageUI");
    }
  }
  
  public static int a(Context paramContext, o paramo, o.g paramg, String paramString, int paramInt)
  {
    AppMethodBeat.i(41456);
    int i = 0;
    switch (paramg.mJumpType)
    {
    case 6: 
    default: 
      Log.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + paramg.mJumpType);
      paramInt = i;
    }
    for (;;)
    {
      AppMethodBeat.o(41456);
      return paramInt;
      paramInt = i(paramContext, paramString, paramInt);
      continue;
      paramInt = aN(paramContext, paramString);
      continue;
      paramInt = j(paramContext, paramString, paramInt);
      continue;
      paramInt = a(paramContext, paramo, paramInt);
      continue;
      paramInt = aO(paramContext, paramg.rHJ);
      continue;
      gj(paramContext);
      paramInt = i;
    }
  }
  
  private static int aN(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41457);
    if (h.s(paramContext, paramString))
    {
      e.at(paramContext, paramString);
      AppMethodBeat.o(41457);
      return 3;
    }
    AppMethodBeat.o(41457);
    return 0;
  }
  
  private static int aO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41461);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41461);
      return 0;
    }
    int i = com.tencent.mm.plugin.game.e.c.aQ(paramContext, paramString);
    AppMethodBeat.o(41461);
    return i;
  }
  
  private static int gj(Context paramContext)
  {
    AppMethodBeat.i(204163);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_can_select_video_and_pic", true);
    localIntent.putExtra("key_send_raw_image", false);
    localIntent.putExtra("max_select_count", 9);
    localIntent.putExtra("query_source_type", 15);
    localIntent.putExtra("query_media_type", 2);
    localIntent.putExtra("show_header_view", false);
    localIntent.addFlags(67108864);
    localIntent.putExtra("game_haowan_ignore_video_preview", true);
    localIntent.putExtra("game_haowan_force_select", true);
    localIntent.putExtra("game_straight_to_publish", true);
    localIntent.putExtra("game_media_default_type", 1);
    com.tencent.mm.br.c.b(paramContext, "game", ".media.GamePublishGalleryUI", localIntent);
    AppMethodBeat.o(204163);
    return 6;
  }
  
  private static int i(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(41458);
    if (h.s(paramContext, paramString))
    {
      e.at(paramContext, paramString);
      AppMethodBeat.o(41458);
      return 3;
    }
    paramInt = j(paramContext, paramString, paramInt);
    AppMethodBeat.o(41458);
    return paramInt;
  }
  
  private static int j(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(41459);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41459);
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("game_app_id", paramString);
    localBundle.putInt("game_report_from_scene", paramInt);
    paramInt = com.tencent.mm.plugin.game.e.c.b(paramContext, paramString, null, localBundle);
    AppMethodBeat.o(41459);
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41455);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      Log.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    paramView = (a)paramView.getTag();
    if (paramView.xGS == null)
    {
      Log.e("MicroMsg.GameMessageClickListener", "message is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    if (paramView.xGs == null)
    {
      Log.e("MicroMsg.GameMessageClickListener", "jumpId is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    localObject = (o.g)paramView.xGS.xFj.get(paramView.xGs);
    if (localObject == null)
    {
      Log.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    int i = a(this.mContext, paramView.xGS, (o.g)localObject, paramView.xGS.field_appId, paramView.dYu);
    if (i != 0)
    {
      localObject = com.tencent.mm.game.report.f.a(null, null, paramView.xGS.xFX, null);
      com.tencent.mm.game.report.f.a(this.mContext, 13, paramView.dYu, paramView.position, i, 0, paramView.xGS.field_appId, this.xGR, paramView.xGS.xFV, paramView.xGS.field_gameMsgId, paramView.xGS.xFW, (String)localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41455);
  }
  
  public static final class a
  {
    public int dYu;
    public int position;
    public o xGS;
    public String xGs;
    
    public a(o paramo, String paramString, int paramInt)
    {
      this.xGS = paramo;
      this.xGs = paramString;
      this.dYu = 1301;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.p
 * JD-Core Version:    0.7.0.1
 */