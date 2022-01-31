package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
{
  private static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(52991);
    Intent localIntent = new Intent();
    localIntent.putExtra("set_id", paramInt);
    localIntent.putExtra("headurl", paramString4);
    localIntent.putExtra("set_title", paramString1);
    localIntent.putExtra("set_iconURL", paramString3);
    localIntent.putExtra("set_desc", paramString2);
    localIntent.setClass(paramContext, EmojiStoreV2SingleProductUI.class);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(52991);
  }
  
  private static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(52992);
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
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(52992);
      return;
      localIntent.putExtra("extra_scence", 3);
    }
  }
  
  private static void a(Context paramContext, EmotionBannerSet paramEmotionBannerSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52989);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiStoreDetailUI.class);
    localIntent.putExtra("extra_id", paramEmotionBannerSet.ProductID);
    localIntent.putExtra("extra_name", paramEmotionBannerSet.Title);
    localIntent.putExtra("extra_description", paramEmotionBannerSet.Desc);
    localIntent.putExtra("preceding_scence", paramInt2);
    localIntent.putExtra("call_by", 1);
    localIntent.putExtra("download_entrance_scene", paramInt1);
    localIntent.putExtra("check_clickflag", true);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(52989);
  }
  
  public static void a(Context paramContext, EmotionBannerSet paramEmotionBannerSet, boolean paramBoolean)
  {
    AppMethodBeat.i(52990);
    if (paramEmotionBannerSet == null)
    {
      ab.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
      AppMethodBeat.o(52990);
      return;
    }
    switch (paramEmotionBannerSet.SetType)
    {
    default: 
      ab.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", new Object[] { Integer.valueOf(paramEmotionBannerSet.SetType) });
      AppMethodBeat.o(52990);
      return;
    case 0: 
      ab.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
      h.qsU.e(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(52990);
      return;
    case 4: 
      a(paramContext, paramEmotionBannerSet.ID, paramEmotionBannerSet.Title, paramEmotionBannerSet.Desc, paramEmotionBannerSet.IconUrl, paramEmotionBannerSet.SecondUrl);
      h.qsU.e(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(52990);
      return;
    case 3: 
      a(paramContext, paramEmotionBannerSet.ID, paramEmotionBannerSet.Title, paramEmotionBannerSet.Desc, paramEmotionBannerSet.IconUrl, paramEmotionBannerSet.SecondUrl, paramBoolean);
      h.qsU.e(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(2) });
      AppMethodBeat.o(52990);
      return;
    case 2: 
      s(paramContext, paramEmotionBannerSet.LocateUrl, paramEmotionBannerSet.Title);
      h.qsU.e(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(52990);
      return;
    }
    if (paramBoolean) {
      a(paramContext, paramEmotionBannerSet, 15, 8);
    }
    for (;;)
    {
      h.qsU.e(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramEmotionBannerSet.ID), paramEmotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(4) });
      AppMethodBeat.o(52990);
      return;
      a(paramContext, paramEmotionBannerSet, 3, 5);
    }
  }
  
  public static void a(Context paramContext, EmotionSummary paramEmotionSummary, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    AppMethodBeat.i(52988);
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
      if (paramInt2 != -1) {
        localIntent.putExtra("extra_status", paramInt2);
      }
      if (paramInt3 != -1) {
        localIntent.putExtra("extra_progress", -1);
      }
      if (!bo.isNullOrNil(paramString)) {
        localIntent.putExtra("to_talker_name", paramString);
      }
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(52988);
      return;
      ab.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
    }
  }
  
  private static void s(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(52993);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("title", paramString2);
    b.gmO.i(localIntent, paramContext);
    AppMethodBeat.o(52993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.m
 * JD-Core Version:    0.7.0.1
 */