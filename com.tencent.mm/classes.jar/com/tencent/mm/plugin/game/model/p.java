package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class p
  implements View.OnClickListener
{
  private Context mContext;
  public int uoy;
  
  public p(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public p(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.uoy = paramInt;
  }
  
  private static int a(Context paramContext, o paramo, int paramInt)
  {
    AppMethodBeat.i(41460);
    if (paramo != null)
    {
      paramo.field_isRead = true;
      ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().update(paramo, new String[0]);
    }
    paramo = new Intent();
    int i;
    if (((com.tencent.mm.game.report.a.b)g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qxc, 0) == 1)
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
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramo.ahE(), "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramo.mt(0));
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
      ae.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + paramg.mJumpType);
      paramInt = i;
    }
    for (;;)
    {
      AppMethodBeat.o(41456);
      return paramInt;
      paramInt = i(paramContext, paramString, paramInt);
      continue;
      paramInt = aA(paramContext, paramString);
      continue;
      paramInt = j(paramContext, paramString, paramInt);
      continue;
      paramInt = a(paramContext, paramo, paramInt);
      continue;
      paramInt = aB(paramContext, paramg.qqC);
      continue;
      fD(paramContext);
      paramInt = i;
    }
  }
  
  private static int aA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41457);
    if (h.s(paramContext, paramString))
    {
      e.ak(paramContext, paramString);
      AppMethodBeat.o(41457);
      return 3;
    }
    AppMethodBeat.o(41457);
    return 0;
  }
  
  private static int aB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41461);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41461);
      return 0;
    }
    int i = c.aD(paramContext, paramString);
    AppMethodBeat.o(41461);
    return i;
  }
  
  private static int fD(Context paramContext)
  {
    AppMethodBeat.i(195644);
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
    d.b(paramContext, "game", ".media.GamePublishGalleryUI", localIntent);
    AppMethodBeat.o(195644);
    return 6;
  }
  
  private static int i(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(41458);
    if (h.s(paramContext, paramString))
    {
      e.ak(paramContext, paramString);
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
    if (bu.isNullOrNil(paramString))
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ae.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    paramView = (a)paramView.getTag();
    if (paramView.uoz == null)
    {
      ae.e("MicroMsg.GameMessageClickListener", "message is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    if (paramView.uob == null)
    {
      ae.e("MicroMsg.GameMessageClickListener", "jumpId is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    localObject = (o.g)paramView.uoz.umR.get(paramView.uob);
    if (localObject == null)
    {
      ae.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    int i = a(this.mContext, paramView.uoz, (o.g)localObject, paramView.uoz.field_appId, paramView.dGL);
    if (i != 0)
    {
      localObject = com.tencent.mm.game.report.f.a(null, null, paramView.uoz.unF, null);
      com.tencent.mm.game.report.f.a(this.mContext, 13, paramView.dGL, paramView.position, i, 0, paramView.uoz.field_appId, this.uoy, paramView.uoz.unD, paramView.uoz.field_gameMsgId, paramView.uoz.unE, (String)localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41455);
  }
  
  public static final class a
  {
    public int dGL;
    public int position;
    public String uob;
    public o uoz;
    
    public a(o paramo, String paramString, int paramInt)
    {
      this.uoz = paramo;
      this.uob = paramString;
      this.dGL = 1301;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.p
 * JD-Core Version:    0.7.0.1
 */