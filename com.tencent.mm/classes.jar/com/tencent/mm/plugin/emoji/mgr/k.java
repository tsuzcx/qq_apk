package com.tencent.mm.plugin.emoji.mgr;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bw;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3SingleProductAlbumUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
{
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(269920);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiStoreV3SingleProductAlbumUI.class);
    localIntent.putExtra("set_id", paramInt1);
    localIntent.putExtra("set_title", paramString1);
    localIntent.putExtra("set_desc", paramString2);
    localIntent.putExtra("set_iconURL", paramString3);
    localIntent.putExtra("headurl", paramString4);
    localIntent.putExtra("entrance_scene", paramInt2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startV3SingleProductAlbumUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startV3SingleProductAlbumUI", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(269920);
  }
  
  private static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(108539);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiStoreTopicUI.class);
    localIntent.putExtra("topic_id", paramInt);
    localIntent.putExtra("topic_name", paramString1);
    localIntent.putExtra("topic_ad_url", paramString4);
    localIntent.putExtra("topic_icon_url", paramString3);
    localIntent.putExtra("topic_desc", paramString2);
    if (paramBoolean) {
      localIntent.putExtra("extra_scence", 15);
    }
    for (;;)
    {
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmotionList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmotionList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108539);
      return;
      localIntent.putExtra("extra_scence", 3);
    }
  }
  
  private static void a(Context paramContext, anj paramanj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108536);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiStoreDetailUI.class);
    localIntent.putExtra("extra_id", paramanj.ProductID);
    localIntent.putExtra("extra_name", paramanj.hAP);
    localIntent.putExtra("extra_description", paramanj.IGG);
    localIntent.putExtra("preceding_scence", paramInt2);
    localIntent.putExtra("call_by", 1);
    localIntent.putExtra("download_entrance_scene", paramInt1);
    localIntent.putExtra("check_clickflag", true);
    paramanj = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramanj.aYi(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailByBannerSet", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;ZII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramanj.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailByBannerSet", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;ZII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108536);
  }
  
  public static void a(Context paramContext, anj paramanj, boolean paramBoolean)
  {
    AppMethodBeat.i(108537);
    if (paramanj == null)
    {
      Log.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
      AppMethodBeat.o(108537);
      return;
    }
    switch (paramanj.Zue)
    {
    default: 
      Log.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", new Object[] { Integer.valueOf(paramanj.Zue) });
      AppMethodBeat.o(108537);
      return;
    case 0: 
      Log.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
      h.OAn.b(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramanj.hjP), paramanj.hAP, Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(108537);
      return;
    case 4: 
      a(paramContext, paramanj.hjP, paramanj.hAP, paramanj.IGG, paramanj.IHo, paramanj.akjV, 10001);
      h.OAn.b(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramanj.hjP), paramanj.hAP, Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(108537);
      return;
    case 3: 
      a(paramContext, paramanj.hjP, paramanj.hAP, paramanj.IGG, paramanj.IHo, paramanj.akjV, paramBoolean);
      h.OAn.b(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramanj.hjP), paramanj.hAP, Integer.valueOf(0), Integer.valueOf(2) });
      AppMethodBeat.o(108537);
      return;
    case 2: 
      z(paramContext, paramanj.akjU, paramanj.hAP);
      h.OAn.b(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramanj.hjP), paramanj.hAP, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(108537);
      return;
    }
    if (paramBoolean) {
      a(paramContext, paramanj, 15, 8);
    }
    for (;;)
    {
      h.OAn.b(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramanj.hjP), paramanj.hAP, Integer.valueOf(0), Integer.valueOf(4) });
      AppMethodBeat.o(108537);
      return;
      a(paramContext, paramanj, 3, 5);
    }
  }
  
  public static void a(Context paramContext, cjb paramcjb, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    AppMethodBeat.i(108534);
    a(paramContext, paramcjb, paramInt1, paramInt2, paramInt3, paramString, paramInt4, null);
    AppMethodBeat.o(108534);
  }
  
  public static void a(Context paramContext, cjb paramcjb, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, bw parambw)
  {
    AppMethodBeat.i(108535);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiStoreDetailUI.class);
    if (paramcjb != null)
    {
      localIntent.putExtra("extra_id", paramcjb.ProductID);
      localIntent.putExtra("extra_name", paramcjb.Zul);
      localIntent.putExtra("extra_copyright", paramcjb.akki);
      localIntent.putExtra("extra_coverurl", paramcjb.ZtY);
      localIntent.putExtra("extra_description", paramcjb.akka);
      localIntent.putExtra("extra_price", paramcjb.akkc);
      localIntent.putExtra("extra_type", paramcjb.akkd);
      localIntent.putExtra("extra_flag", paramcjb.akke);
      localIntent.putExtra("preceding_scence", paramInt4);
      localIntent.putExtra("call_by", 1);
      localIntent.putExtra("check_clickflag", false);
      localIntent.putExtra("download_entrance_scene", paramInt1);
      localIntent.putExtra("extra_pack_wecoin_price", paramcjb.akkv);
      localIntent.putExtra("extra_wecoin_price", paramcjb.akkw);
      if (parambw != null) {
        localIntent.putExtra("action_report", parambw.aIE());
      }
      if (paramInt2 != -1) {
        localIntent.putExtra("extra_status", paramInt2);
      }
      if (paramInt3 != -1) {
        localIntent.putExtra("extra_progress", -1);
      }
      if (!Util.isNullOrNil(paramString)) {
        localIntent.putExtra("to_talker_name", paramString);
      }
    }
    for (;;)
    {
      paramcjb = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramcjb.aYi(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailBySummary", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionSummary;ZIIILjava/lang/String;ILcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramcjb.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailBySummary", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionSummary;ZIIILjava/lang/String;ILcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108535);
      return;
      Log.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
    }
  }
  
  private static void z(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108540);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("title", paramString2);
    c.pFn.h(localIntent, paramContext);
    AppMethodBeat.o(108540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.k
 * JD-Core Version:    0.7.0.1
 */