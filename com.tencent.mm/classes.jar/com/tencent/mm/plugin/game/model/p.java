package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class p
  implements View.OnClickListener
{
  public int CKU;
  private Context mContext;
  
  public p(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public p(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.CKU = paramInt;
  }
  
  private static int a(Context paramContext, o paramo, int paramInt)
  {
    AppMethodBeat.i(41460);
    if (paramo != null)
    {
      paramo.field_isRead = true;
      ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().update(paramo, new String[0]);
    }
    paramo = new Intent();
    int i;
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vuR, 0) == 1)
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
      paramo = new com.tencent.mm.hellhoundlib.b.a().bm(paramo);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramo.aFh(), "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramo.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "dealMsgJumpMsgCenter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/game/model/GameMessage;I)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(41460);
      return 6;
      i = 0;
      break;
      label160:
      paramo.setClassName(paramContext, "com.tencent.mm.plugin.game.ui.GameMessageUI");
    }
  }
  
  public static int a(Context paramContext, o paramo, o.h paramh, String paramString, int paramInt)
  {
    AppMethodBeat.i(41456);
    int i = 0;
    switch (paramh.mJumpType)
    {
    case 6: 
    default: 
      Log.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + paramh.mJumpType);
      paramInt = i;
    }
    for (;;)
    {
      AppMethodBeat.o(41456);
      return paramInt;
      paramInt = h(paramContext, paramString, paramInt);
      continue;
      paramInt = aV(paramContext, paramString);
      continue;
      paramInt = i(paramContext, paramString, paramInt);
      continue;
      paramInt = a(paramContext, paramo, paramInt);
      continue;
      paramInt = aW(paramContext, paramh.vnr);
      continue;
      gD(paramContext);
      paramInt = i;
    }
  }
  
  private static int aV(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41457);
    if (com.tencent.mm.pluginsdk.model.app.h.u(paramContext, paramString))
    {
      e.at(paramContext, paramString);
      AppMethodBeat.o(41457);
      return 3;
    }
    AppMethodBeat.o(41457);
    return 0;
  }
  
  private static int aW(Context paramContext, String paramString)
  {
    AppMethodBeat.i(41461);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41461);
      return 0;
    }
    int i = com.tencent.mm.plugin.game.d.c.aY(paramContext, paramString);
    AppMethodBeat.o(41461);
    return i;
  }
  
  private static int gD(Context paramContext)
  {
    AppMethodBeat.i(203918);
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
    com.tencent.mm.by.c.b(paramContext, "game", ".media.GamePublishGalleryUI", localIntent);
    AppMethodBeat.o(203918);
    return 6;
  }
  
  private static int h(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(41458);
    if (com.tencent.mm.pluginsdk.model.app.h.u(paramContext, paramString))
    {
      e.at(paramContext, paramString);
      AppMethodBeat.o(41458);
      return 3;
    }
    paramInt = i(paramContext, paramString, paramInt);
    AppMethodBeat.o(41458);
    return paramInt;
  }
  
  private static int i(Context paramContext, String paramString, int paramInt)
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
    paramInt = com.tencent.mm.plugin.game.d.c.b(paramContext, paramString, null, localBundle);
    AppMethodBeat.o(41459);
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41455);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      Log.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    paramView = (a)paramView.getTag();
    if (paramView.CKV == null)
    {
      Log.e("MicroMsg.GameMessageClickListener", "message is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    if (paramView.CKv == null)
    {
      Log.e("MicroMsg.GameMessageClickListener", "jumpId is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    localObject = (o.h)paramView.CKV.CJk.get(paramView.CKv);
    if (localObject == null)
    {
      Log.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41455);
      return;
    }
    int i = a(this.mContext, paramView.CKV, (o.h)localObject, paramView.CKV.field_appId, paramView.fSl);
    if (i != 0)
    {
      localObject = g.a(null, null, paramView.CKV.CJY, null);
      g.a(this.mContext, 13, paramView.fSl, paramView.position, i, 0, paramView.CKV.field_appId, this.CKU, paramView.CKV.CJW, paramView.CKV.field_gameMsgId, paramView.CKV.CJX, (String)localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/model/GameMessageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41455);
  }
  
  public static final class a
  {
    public o CKV;
    public String CKv;
    public int fSl;
    public int position;
    
    public a(o paramo, String paramString, int paramInt)
    {
      this.CKV = paramo;
      this.CKv = paramString;
      this.fSl = 1301;
      this.position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.p
 * JD-Core Version:    0.7.0.1
 */