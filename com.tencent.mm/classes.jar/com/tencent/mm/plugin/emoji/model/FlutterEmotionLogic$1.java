package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jz;
import com.tencent.mm.autogen.a.jz.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.emoji.e.p;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.gog;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class FlutterEmotionLogic$1
  extends IListener<jz>
{
  private boolean a(final jz paramjz)
  {
    AppMethodBeat.i(269894);
    if (paramjz.hLC.hLD)
    {
      AppMethodBeat.o(269894);
      return false;
    }
    Object localObject1 = paramjz.hLC.hLE.method;
    int i = -1;
    switch (((String)localObject1).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(269894);
      return false;
      if (!((String)localObject1).equals("loadFirstMainDataFromCache")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject1).equals("loadFirstPersonDataFromCache")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject1).equals("loadMoreMainEmotionData")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject1).equals("loadMorePersonEmotionData")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject1).equals("getEmotionDetailData")) {
        break;
      }
      i = 4;
      break;
      if (!((String)localObject1).equals("getEmotionRewardData")) {
        break;
      }
      i = 5;
      break;
      if (!((String)localObject1).equals("getEmotionPrivacyUrl")) {
        break;
      }
      i = 6;
      break;
      if (!((String)localObject1).equals("getEmotionComplaintUrl")) {
        break;
      }
      i = 7;
      break;
      if (!((String)localObject1).equals("startWebSearch")) {
        break;
      }
      i = 8;
      break;
      if (!((String)localObject1).equals("getEmotionDownloadList")) {
        break;
      }
      i = 9;
      break;
      if (!((String)localObject1).equals("getEmotionDownloadProgressMap")) {
        break;
      }
      i = 10;
      break;
      if (!((String)localObject1).equals("startToDownloadEmotion")) {
        break;
      }
      i = 11;
      break;
      if (!((String)localObject1).equals("getShareTimelineSessionId")) {
        break;
      }
      i = 12;
      break;
      o.dzT();
      localObject1 = s.getEmojiStorageMgr().adjx.azj(5);
      if ((localObject1 != null) && (((gog)localObject1).Zvf.size() > 0) && (((gog)localObject1).akla.size() > 0))
      {
        paramjz.hLC.result = o.b((gog)localObject1).toString();
        paramjz.hLC.hLF.run();
        continue;
      }
      paramjz.hLC.result = null;
      paramjz.hLC.hLF.run();
      continue;
      o.dzU();
      localObject1 = s.getEmojiStorageMgr().adjx.azj(9);
      if ((localObject1 != null) && (((gog)localObject1).Zvf.size() > 0) && (((gog)localObject1).akla.size() > 0))
      {
        paramjz.hLC.result = o.b((gog)localObject1).toString();
        paramjz.hLC.hLF.run();
        continue;
      }
      paramjz.hLC.result = null;
      paramjz.hLC.hLF.run();
      continue;
      if (o.dzV() != null)
      {
        com.tencent.mm.kernel.h.aZW().b(411, this.xNd);
        com.tencent.mm.kernel.h.aZW().a(o.dzV());
      }
      new o.b(this.xNd, 5, o.dzX());
      o.dzW();
      o.dzV().xNh = paramjz;
      com.tencent.mm.kernel.h.aZW().a(411, this.xNd);
      com.tencent.mm.kernel.h.aZW().a(o.dzV(), 0);
      continue;
      if (o.dzY() != null)
      {
        com.tencent.mm.kernel.h.aZW().b(411, this.xNd);
        com.tencent.mm.kernel.h.aZW().a(o.dzY());
      }
      new o.b(this.xNd, 9, o.dAa());
      o.dzZ();
      o.dzY().xNh = paramjz;
      com.tencent.mm.kernel.h.aZW().a(411, this.xNd);
      com.tencent.mm.kernel.h.aZW().a(o.dzY(), 0);
      continue;
      if (o.dAb() != null)
      {
        com.tencent.mm.kernel.h.aZW().b(412, this.xNd);
        com.tencent.mm.kernel.h.aZW().a(o.dAb());
      }
      localObject1 = (String)paramjz.hLC.hLE.argument("productId");
      i = ((Integer)paramjz.hLC.hLE.argument("version")).intValue();
      new o.a(this.xNd, (String)localObject1, i);
      o.dAc();
      o.dAb().xNh = paramjz;
      com.tencent.mm.kernel.h.aZW().a(412, this.xNd);
      com.tencent.mm.kernel.h.aZW().a(o.dAb(), 0);
      continue;
      if (o.dAd() != null)
      {
        com.tencent.mm.kernel.h.aZW().b(822, this.xNd);
        com.tencent.mm.kernel.h.aZW().a(o.dAd());
      }
      localObject1 = (String)paramjz.hLC.hLE.argument("productId");
      new o.c(this.xNd, (String)localObject1, p.xOO);
      o.dAe();
      o.dAd().xNh = paramjz;
      com.tencent.mm.kernel.h.aZW().a(822, this.xNd);
      com.tencent.mm.kernel.h.aZW().a(o.dAd(), 0);
      continue;
      paramjz.hLC.result = (MMApplicationContext.getContext().getString(h.h.emoji_privacy_doc) + LocaleUtil.getApplicationLanguage());
      paramjz.hLC.hLF.run();
      continue;
      paramjz.hLC.result = (MMApplicationContext.getContext().getString(h.h.emoji_complaints_doc) + LocaleUtil.getApplicationLanguage());
      paramjz.hLC.hLF.run();
      continue;
      ((i)com.tencent.mm.kernel.h.ax(i.class)).a(MMApplicationContext.getContext(), new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(269877);
          int i = ((Integer)paramjz.hLC.hLE.argument("scene")).intValue();
          Intent localIntent = aj.ipS();
          aj.f(localIntent, 24);
          localIntent.putExtra("ftsneedkeyboard", true);
          localIntent.putExtra("key_load_js_without_delay", true);
          localIntent.putExtra("ftsInitToSearch", true);
          com.tencent.mm.br.c.b(paramjz.hLC.context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
          com.tencent.mm.plugin.report.service.h.OAn.b(13054, new Object[] { Integer.valueOf(i), Integer.valueOf(0), "" });
          AppMethodBeat.o(269877);
        }
      });
      paramjz.hLC.result = "{}";
      paramjz.hLC.hLF.run();
      continue;
      Object localObject2 = s.getEmojiStorageMgr().adjv.jcZ();
      localObject1 = new JSONObject();
      localObject2 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          o.a(localEntry.getValue(), localJSONObject);
          ((JSONObject)localObject1).put((String)localEntry.getKey(), localJSONObject);
        }
        catch (Exception localException2) {}
      }
      paramjz.hLC.result = ((JSONObject)localObject1).toString();
      paramjz.hLC.hLF.run();
      continue;
      localObject2 = s.dAq().xMS;
      localObject1 = new JSONObject();
      try
      {
        o.a((Map)localObject2, (JSONObject)localObject1);
        label1275:
        paramjz.hLC.result = ((JSONObject)localObject1).toString();
        paramjz.hLC.hLF.run();
        continue;
        paramjz = new com.tencent.mm.plugin.emoji.e.h((String)paramjz.hLC.hLE.argument("ProductID"), null, (String)paramjz.hLC.hLE.argument("PackName"));
        com.tencent.mm.kernel.h.aZW().a(paramjz, 0);
        continue;
        localObject1 = ad.Jo("emoje_stroe");
        ad.bCb().M((String)localObject1, true).q("prePublishId", "emoje_stroe");
        paramjz.hLC.result = ((String)localObject1);
        paramjz.hLC.hLF.run();
      }
      catch (Exception localException1)
      {
        break label1275;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.FlutterEmotionLogic.1
 * JD-Core Version:    0.7.0.1
 */