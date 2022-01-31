package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k
{
  private static void a(Context paramContext, ve paramve, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiStoreDetailUI.class);
    localIntent.putExtra("extra_id", paramve.syc);
    localIntent.putExtra("extra_name", paramve.bGw);
    localIntent.putExtra("extra_description", paramve.kRN);
    localIntent.putExtra("preceding_scence", paramInt2);
    localIntent.putExtra("call_by", 1);
    localIntent.putExtra("download_entrance_scene", paramInt1);
    localIntent.putExtra("check_clickflag", true);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, ve paramve, boolean paramBoolean)
  {
    if (paramve == null)
    {
      y.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
      return;
    }
    int i;
    String str1;
    String str2;
    Object localObject;
    String str3;
    Intent localIntent;
    switch (paramve.sRV)
    {
    default: 
      y.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", new Object[] { Integer.valueOf(paramve.sRV) });
      return;
    case 0: 
      y.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
      h.nFQ.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramve.bxH), paramve.bGw, Integer.valueOf(0), Integer.valueOf(0) });
      return;
    case 4: 
      i = paramve.bxH;
      str1 = paramve.bGw;
      str2 = paramve.kRN;
      localObject = paramve.kSy;
      str3 = paramve.sRU;
      localIntent = new Intent();
      localIntent.putExtra("set_id", i);
      localIntent.putExtra("headurl", str3);
      localIntent.putExtra("set_title", str1);
      localIntent.putExtra("set_iconURL", (String)localObject);
      localIntent.putExtra("set_desc", str2);
      localIntent.setClass(paramContext, EmojiStoreV2SingleProductUI.class);
      paramContext.startActivity(localIntent);
      h.nFQ.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramve.bxH), paramve.bGw, Integer.valueOf(0), Integer.valueOf(1) });
      return;
    case 3: 
      i = paramve.bxH;
      str1 = paramve.bGw;
      str2 = paramve.kRN;
      localObject = paramve.kSy;
      str3 = paramve.sRU;
      localIntent = new Intent();
      localIntent.setClass(paramContext, EmojiStoreTopicUI.class);
      localIntent.putExtra("topic_id", i);
      localIntent.putExtra("topic_name", str1);
      localIntent.putExtra("topic_ad_url", str3);
      localIntent.putExtra("topic_icon_url", (String)localObject);
      localIntent.putExtra("topic_desc", str2);
      if (paramBoolean) {
        localIntent.putExtra("extra_scence", 15);
      }
      for (;;)
      {
        paramContext.startActivity(localIntent);
        h.nFQ.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramve.bxH), paramve.bGw, Integer.valueOf(0), Integer.valueOf(2) });
        return;
        localIntent.putExtra("extra_scence", 3);
      }
    case 2: 
      str1 = paramve.sRT;
      str2 = paramve.bGw;
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", str1);
      ((Intent)localObject).putExtra("title", str2);
      b.eUR.j((Intent)localObject, paramContext);
      h.nFQ.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramve.bxH), paramve.bGw, Integer.valueOf(0), Integer.valueOf(3) });
      return;
    }
    if (paramBoolean) {
      a(paramContext, paramve, 15, 8);
    }
    for (;;)
    {
      h.nFQ.f(13223, new Object[] { Integer.valueOf(1), Integer.valueOf(paramve.bxH), paramve.bGw, Integer.valueOf(0), Integer.valueOf(4) });
      return;
      a(paramContext, paramve, 3, 5);
    }
  }
  
  public static void a(Context paramContext, vn paramvn, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, EmojiStoreDetailUI.class);
    if (paramvn != null)
    {
      localIntent.putExtra("extra_id", paramvn.syc);
      localIntent.putExtra("extra_name", paramvn.sSc);
      localIntent.putExtra("extra_copyright", paramvn.sSm);
      localIntent.putExtra("extra_coverurl", paramvn.sSk);
      localIntent.putExtra("extra_description", paramvn.sSd);
      localIntent.putExtra("extra_price", paramvn.sSf);
      localIntent.putExtra("extra_type", paramvn.sSg);
      localIntent.putExtra("extra_flag", paramvn.sSh);
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
      if (!bk.bl(paramString)) {
        localIntent.putExtra("to_talker_name", paramString);
      }
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      y.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.k
 * JD-Core Version:    0.7.0.1
 */