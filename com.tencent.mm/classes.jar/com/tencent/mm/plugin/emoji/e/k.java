package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.u;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
{
  private static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(108538);
    Intent localIntent = new Intent();
    localIntent.putExtra("set_id", paramInt);
    localIntent.putExtra("headurl", paramString4);
    localIntent.putExtra("set_title", paramString1);
    localIntent.putExtra("set_iconURL", paramString3);
    localIntent.putExtra("set_desc", paramString2);
    localIntent.setClass(paramContext, EmojiStoreV2SingleProductUI.class);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmojiList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmojiList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108538);
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
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmotionList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmotionList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108539);
      return;
      localIntent.putExtra("extra_scence", 3);
    }
  }
  
  private static void a(Context paramContext, EmotionBannerSet paramEmotionBannerSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108536);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiStoreDetailUI.class);
    localIntent.putExtra("extra_id", paramEmotionBannerSet.ProductID);
    localIntent.putExtra("extra_name", paramEmotionBannerSet.Title);
    localIntent.putExtra("extra_description", paramEmotionBannerSet.Desc);
    localIntent.putExtra("preceding_scence", paramInt2);
    localIntent.putExtra("call_by", 1);
    localIntent.putExtra("download_entrance_scene", paramInt1);
    localIntent.putExtra("check_clickflag", true);
    paramEmotionBannerSet = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramEmotionBannerSet.adn(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailByBannerSet", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;ZII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramEmotionBannerSet.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailByBannerSet", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;ZII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108536);
  }
  
  public static void a(Context paramContext, EmotionBannerSet paramEmotionBannerSet, boolean paramBoolean)
  {
    AppMethodBeat.i(108537);
    if (paramEmotionBannerSet == null)
    {
      ad.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
      AppMethodBeat.o(108537);
      return;
    }
    switch (paramEmotionBannerSet.SetType)
    {
    default: 
      ad.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", new Object[] { Integer.valueOf(paramEmotionBannerSet.SetType) });
      AppMethodBeat.o(108537);
      return;
    case 0: 
      ad.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
      h.vKh.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(108537);
      return;
    case 4: 
      a(paramContext, paramEmotionBannerSet.ID, paramEmotionBannerSet.Title, paramEmotionBannerSet.Desc, paramEmotionBannerSet.IconUrl, paramEmotionBannerSet.SecondUrl);
      h.vKh.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(108537);
      return;
    case 3: 
      a(paramContext, paramEmotionBannerSet.ID, paramEmotionBannerSet.Title, paramEmotionBannerSet.Desc, paramEmotionBannerSet.IconUrl, paramEmotionBannerSet.SecondUrl, paramBoolean);
      h.vKh.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(2) });
      AppMethodBeat.o(108537);
      return;
    case 2: 
      w(paramContext, paramEmotionBannerSet.LocateUrl, paramEmotionBannerSet.Title);
      h.vKh.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(108537);
      return;
    }
    if (paramBoolean) {
      a(paramContext, paramEmotionBannerSet, 15, 8);
    }
    for (;;)
    {
      h.vKh.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(4) });
      AppMethodBeat.o(108537);
      return;
      a(paramContext, paramEmotionBannerSet, 3, 5);
    }
  }
  
  public static void a(Context paramContext, EmotionSummary paramEmotionSummary, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    AppMethodBeat.i(108534);
    a(paramContext, paramEmotionSummary, paramInt1, paramInt2, paramInt3, paramString, paramInt4, null);
    AppMethodBeat.o(108534);
  }
  
  public static void a(Context paramContext, EmotionSummary paramEmotionSummary, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, u paramu)
  {
    AppMethodBeat.i(108535);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiStoreDetailUI.class);
    if (paramEmotionSummary != null)
    {
      localIntent.putExtra("extra_id", paramEmotionSummary.ProductID);
      localIntent.putExtra("extra_name", paramEmotionSummary.PackName);
      localIntent.putExtra("extra_copyright", paramEmotionSummary.PackCopyright);
      localIntent.putExtra("extra_coverurl", paramEmotionSummary.CoverUrl);
      localIntent.putExtra("extra_description", paramEmotionSummary.PackDesc);
      localIntent.putExtra("extra_price", paramEmotionSummary.PackPrice);
      localIntent.putExtra("extra_type", paramEmotionSummary.PackType);
      localIntent.putExtra("extra_flag", paramEmotionSummary.PackFlag);
      localIntent.putExtra("preceding_scence", paramInt4);
      localIntent.putExtra("call_by", 1);
      localIntent.putExtra("check_clickflag", false);
      localIntent.putExtra("download_entrance_scene", paramInt1);
      if (paramu != null) {
        localIntent.putExtra("action_report", paramu.PV());
      }
      if (paramInt2 != -1) {
        localIntent.putExtra("extra_status", paramInt2);
      }
      if (paramInt3 != -1) {
        localIntent.putExtra("extra_progress", -1);
      }
      if (!bt.isNullOrNil(paramString)) {
        localIntent.putExtra("to_talker_name", paramString);
      }
    }
    for (;;)
    {
      paramEmotionSummary = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramEmotionSummary.adn(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailBySummary", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionSummary;ZIIILjava/lang/String;ILcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramEmotionSummary.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailBySummary", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionSummary;ZIIILjava/lang/String;ILcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108535);
      return;
      ad.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
    }
  }
  
  private static void w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108540);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("title", paramString2);
    b.hYt.i(localIntent, paramContext);
    AppMethodBeat.o(108540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.k
 * JD-Core Version:    0.7.0.1
 */