package com.tencent.mm.plugin.ad.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.hc;
import com.tencent.mm.h.a.lc;
import com.tencent.mm.h.a.oz;
import com.tencent.mm.h.a.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.plugin.scanner.a.q;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.scanner.util.r.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.c.aan;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class c
{
  private static void a(c.a parama, int paramInt1, String paramString, int paramInt2)
  {
    y.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    hc localhc = new hc();
    localhc.bOW.actionCode = paramInt1;
    localhc.bOW.result = paramString;
    localhc.bOW.context = parama.getContext();
    paramString = new Bundle();
    paramString.putInt("pay_channel", paramInt2);
    localhc.bOW.bOY = paramString;
    localhc.bFJ = new c.4(parama, localhc);
    a.udP.a(localhc, Looper.myLooper());
  }
  
  public static boolean a(c.a parama, com.tencent.mm.modelsimple.h paramh, DialogInterface.OnClickListener paramOnClickListener, String paramString, int paramInt1, int paramInt2, Runnable paramRunnable, Bundle paramBundle)
  {
    if ((parama == null) || (parama.getContext() == null))
    {
      y.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
      return false;
    }
    int i = paramh.Qh();
    int j = ((aan)paramh.dmK.ecE.ecN).sLZ;
    y.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    y.i("MicroMsg.scanner.GetA8KeyRedirect", "source=" + paramInt1);
    Intent localIntent = new Intent();
    localIntent.putExtra("geta8key_scene", paramInt1);
    localIntent.putExtra("KPublisherId", "qrcode");
    localIntent.putExtra("prePublishId", "qrcode");
    i.Ez(wr(paramInt1));
    switch (i)
    {
    case 5: 
    case 13: 
    case 19: 
    default: 
      y.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + paramh.Qh());
      return false;
    case 1: 
      y.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + paramh.getContent());
      localIntent.putExtra("data", paramh.getContent());
      localIntent.putExtra("showShare", false);
      if (paramInt2 == 2) {
        localIntent.putExtra("stastic_scene", 13);
      }
      for (;;)
      {
        localIntent.putExtra("pay_channel", wr(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramh.Qn());
        com.tencent.mm.plugin.scanner.b.eUR.j(localIntent, parama.getContext());
        new ah(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        return true;
        if (paramInt2 == 1) {
          localIntent.putExtra("stastic_scene", 14);
        } else {
          localIntent.putExtra("stastic_scene", 11);
        }
      }
    case 2: 
      y.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + paramh.Qf());
      paramRunnable = parama.getContext();
      paramBundle = parama.getContext();
      i = R.l.qrcode_alert_notmm_tip;
      if (!bk.bl(paramString)) {}
      for (;;)
      {
        com.tencent.mm.ui.base.h.a(paramRunnable, paramBundle.getString(i, new Object[] { paramString }), parama.getContext().getString(R.l.app_tip), new c.1(localIntent, paramh, paramInt2, paramInt1, parama), paramOnClickListener);
        return true;
        paramString = paramh.Qf();
      }
    case 7: 
      y.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[] { paramh.Qg(), paramh.Qf(), paramh.Qj() });
      localIntent.putExtra("title", paramh.getTitle());
      localIntent.putExtra("rawUrl", paramh.Qf());
      localIntent.putExtra("k_share_url", paramh.Qj());
      if (paramInt2 == 2)
      {
        localIntent.putExtra("stastic_scene", 13);
        paramInt2 = wr(paramInt1);
        y.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : " + paramInt2);
        localIntent.putExtra("pay_channel", wr(paramInt1));
        localIntent.putExtra("geta8key_session_id", paramh.Qn());
        localIntent.putExtra("geta8key_cookie", paramh.Qo());
        paramh = paramh.Qm();
        if (bk.dk(paramh)) {
          break label964;
        }
        paramOnClickListener = paramh.iterator();
        while (paramOnClickListener.hasNext())
        {
          paramString = (apm)paramOnClickListener.next();
          if ((paramString == null) || (bk.bl(paramString.sCH)) || (bk.bl(paramString.nFs))) {
            y.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
          }
        }
      }
      break;
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        paramOnClickListener = new String[paramh.size()];
        paramString = new String[paramh.size()];
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 < paramh.size())
          {
            Object localObject = (apm)paramh.get(paramInt1);
            paramBundle = ((apm)localObject).sCH;
            localObject = ((apm)localObject).nFs;
            y.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[] { Integer.valueOf(paramInt1), paramBundle, localObject });
            paramOnClickListener[paramInt1] = paramBundle;
            paramString[paramInt1] = localObject;
            paramInt1 += 1;
            continue;
            if (paramInt2 == 1)
            {
              localIntent.putExtra("stastic_scene", 14);
              break;
            }
            localIntent.putExtra("stastic_scene", 11);
            break;
          }
        }
        localIntent.putExtra("geta8key_result_http_header_key_list", paramOnClickListener);
        localIntent.putExtra("geta8key_result_http_header_value_list", paramString);
        localIntent.putExtra("k_has_http_header", true);
      }
      label964:
      com.tencent.mm.plugin.scanner.b.eUR.j(localIntent, parama.getContext());
      new ah(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      return true;
      y.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + paramh.Qf());
      localIntent.putExtra("rawUrl", paramh.Qf());
      localIntent.putExtra("pay_channel", wr(paramInt1));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("isWebwx", false);
      localIntent.putExtra("geta8key_session_id", paramh.Qn());
      localIntent.putExtra("geta8key_cookie", paramh.Qo());
      com.tencent.mm.plugin.scanner.b.eUR.j(localIntent, parama.getContext());
      return true;
      return false;
      paramString = paramh.Qf();
      y.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: " + paramString);
      if ((paramString == null) || (paramString.length() == 0))
      {
        y.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
        return false;
      }
      paramh = parama.getContext().getString(R.l.qrcode_alert_app_tip);
      if (paramString.startsWith("http")) {
        paramh = parama.getContext().getString(R.l.qrcode_alert_notmm_tip, new Object[] { paramString });
      }
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = new Intent("android.intent.action.VIEW", paramString);
        paramString.addFlags(268435456);
        if (bk.i(parama.getContext(), paramString))
        {
          com.tencent.mm.ui.base.h.a(parama.getContext(), paramh, parama.getContext().getString(R.l.app_tip), false, new c.2(parama, paramString), paramOnClickListener);
          return true;
        }
      }
      return false;
      paramh = paramh.getContent();
      y.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: " + paramh);
      if (!bk.bl(paramh)) {
        paramString = new q();
      }
      try
      {
        paramString.LX(paramh);
        paramString = new Intent(parama.getContext(), VcardContactUI.class);
        parama.getContext().startActivity(paramString);
        parama.im(false);
        return true;
      }
      catch (XmlPullParserException paramString)
      {
        y.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paramh);
        y.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
        com.tencent.mm.ui.base.h.a(parama.getContext(), parama.getContext().getString(R.l.qrcode_not_recognized_tip), parama.getContext().getString(R.l.app_tip), false, paramOnClickListener);
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          y.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + paramString.getMessage() + " " + paramh);
          y.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", paramString, "", new Object[0]);
        }
      }
      y.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + paramh.Qf());
      com.tencent.mm.pluginsdk.wallet.h.a(parama.getContext(), 1, paramh.Qf(), wr(paramInt1), null);
      new ah(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      return true;
      paramOnClickListener = new Bundle();
      paramOnClickListener.putInt("key_scene", 5);
      return com.tencent.mm.plugin.scanner.b.eUR.b(parama.getContext(), paramh.Qf(), paramOnClickListener);
      a(parama, i, paramh.Qf(), wr(paramInt1));
      new ah(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
      return true;
      a(parama, i, paramh.Qf(), wr(paramInt1));
      return true;
      paramOnClickListener = paramh.Qf();
      paramh = paramOnClickListener;
      if (paramOnClickListener != null) {
        paramh = paramOnClickListener.replace("wxpd://", "");
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_product_id", paramh);
      paramOnClickListener.putExtra("key_product_scene", 7);
      d.b(parama.getContext(), "product", ".ui.MallProductUI", paramOnClickListener);
      return true;
      paramOnClickListener = new Intent();
      paramOnClickListener.setClass(parama.getContext(), ProductUI.class);
      paramOnClickListener.putExtra("key_ProductUI_getProductInfoScene", 5);
      paramOnClickListener.putExtra("key_Qrcode_Url", paramh.Qf());
      parama.getContext().startActivity(paramOnClickListener);
      return true;
      paramOnClickListener = paramh.Qf();
      parama = new Intent().setClassName(ae.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
      paramh = bk.B(ae.getContext(), parama);
      if (paramh != null) {
        parama = paramh;
      }
      for (;;)
      {
        ae.getContext().startService(parama.putExtra("url", paramOnClickListener).putExtra("isFromWifi", true));
        y.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
        return true;
      }
      paramh = r.Mj(paramh.Qf());
      if (paramh == null) {
        y.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
      }
      for (;;)
      {
        return false;
        if (r.oN(paramh.ilo)) {
          break;
        }
        r.aG(parama.getContext(), parama.getContext().getString(R.l.card_not_support_card_type));
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_card_id", paramh.iln);
      paramOnClickListener.putExtra("key_card_ext", paramh.bZd);
      paramOnClickListener.putExtra("key_from_scene", 0);
      if (paramInt2 == 2) {
        paramOnClickListener.putExtra("key_stastic_scene", 13);
      }
      for (;;)
      {
        d.b(parama.getContext(), "card", ".ui.CardDetailUI", paramOnClickListener);
        y.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
        break;
        if (paramInt2 == 1) {
          paramOnClickListener.putExtra("key_stastic_scene", 14);
        } else {
          paramOnClickListener.putExtra("key_stastic_scene", 11);
        }
      }
      paramh = paramh.Qf();
      paramOnClickListener = r.Mk(paramh);
      if ((paramOnClickListener == null) || (paramOnClickListener.size() == 0)) {
        y.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
      }
      for (;;)
      {
        return false;
        if (r.N(paramOnClickListener)) {
          break;
        }
        r.aG(parama.getContext(), parama.getContext().getString(R.l.card_not_support_card_type));
      }
      paramOnClickListener = new Intent();
      paramOnClickListener.putExtra("key_from_scene", 0);
      paramOnClickListener.putExtra("src_username", "");
      paramOnClickListener.putExtra("js_url", "");
      paramOnClickListener.putExtra("key_in_card_list", paramh);
      if (paramInt2 == 2) {
        paramOnClickListener.putExtra("key_stastic_scene", 13);
      }
      for (;;)
      {
        d.b(parama.getContext(), "card", ".ui.CardAddEntranceUI", paramOnClickListener);
        y.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
        break;
        if (paramInt2 == 1) {
          paramOnClickListener.putExtra("key_stastic_scene", 14);
        } else {
          paramOnClickListener.putExtra("key_stastic_scene", 11);
        }
      }
      paramRunnable = new Intent();
      paramRunnable.putExtra("free_wifi_url", paramh.Qf());
      paramString = (aao)paramh.dmK.ecF.ecN;
      if ((paramString == null) || (paramString.ssn == null))
      {
        y.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
        paramString = null;
        paramRunnable.putExtra("free_wifi_mid", paramString);
        paramString = (aao)paramh.dmK.ecF.ecN;
        if ((paramString != null) && (paramString.SSID != null)) {
          break label2423;
        }
        y.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
        paramString = null;
        label2330:
        paramRunnable.putExtra("free_wifi_ssid", paramString);
        paramRunnable.putExtra("free_wifi_source", 1);
        paramRunnable.putExtra("free_wifi_ap_key", paramh.Qf());
        au.Hx();
        if (com.tencent.mm.model.c.Dz().get(303104, null) == null) {
          break label2431;
        }
        com.tencent.mm.ui.base.h.a(parama.getContext(), R.l.free_wifi_dialog_tips, R.l.app_tip, R.l.free_wifi_intro_continue, R.l.app_cancel, new c.3(parama, paramRunnable), paramOnClickListener);
      }
      for (;;)
      {
        return true;
        paramString = paramString.ssn;
        break;
        label2423:
        paramString = paramString.SSID;
        break label2330;
        label2431:
        d.b(parama.getContext(), "freewifi", ".ui.FreeWifiEntryUI", paramRunnable);
        parama.im(false);
      }
      y.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + paramh.Qf());
      parama = new u(paramh.Qf());
      au.Dk().a(parama, 0);
      return true;
      parama = new oz();
      parama.bYC.bYD = paramString;
      a.udP.m(parama);
      return true;
      parama = paramh.Qf();
      if (bk.bl(parama))
      {
        y.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
        return true;
      }
      y.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[] { parama });
      paramh = new x();
      paramh.bFW.url = parama;
      a.udP.m(paramh);
      y.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
      return true;
      paramh = paramh.Qf();
      y.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: " + paramh);
      paramOnClickListener = parama.getContext();
      y.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: " + paramh);
      paramString = Uri.parse(paramh);
      if ((paramString.getQueryParameter("search_query") != null) && (paramString.getQueryParameter("search_query").length() > 0))
      {
        paramOnClickListener = paramString.getQueryParameter("search_query");
        paramRunnable = paramString.getQueryParameter("appid");
        paramBundle = paramString.getQueryParameter("search_extInfo");
        paramInt1 = bk.getInt(paramString.getQueryParameter("debug"), 0);
        paramInt2 = bk.getInt(paramString.getQueryParameter("version"), 0);
        paramString = new lc();
        paramString.bUc.scene = 1;
        paramString.bUc.appId = paramRunnable;
        paramString.bUc.type = paramInt1;
        paramString.bUc.version = paramInt2;
        paramString.bUc.bUd = paramOnClickListener;
        paramString.bUc.url = paramh;
        paramString.bUc.bUe = paramBundle;
        a.udP.m(paramString);
        paramString = aa.bZt();
        paramString.putExtra("ftsbizscene", 99999);
        paramString.putExtra("ftsQuery", paramOnClickListener);
        paramString.putExtra("ftsqrcodestring", paramh);
        paramh = aa.b(300, false, 262144);
        paramh.put("query", paramOnClickListener);
        paramOnClickListener = aa.Bm(bk.ZR((String)paramh.get("scene")));
        paramh.put("sessionid", paramOnClickListener);
        paramString.putExtra("rawUrl", aa.v(paramh));
        paramString.putExtra("key_session_id", paramOnClickListener);
        d.b(ae.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", paramString);
        parama.im(false);
        return true;
      }
      if (paramInt2 == 2)
      {
        if (j == 22) {}
        for (paramInt1 = 1048;; paramInt1 = 1012)
        {
          ((e)g.r(e.class)).b(paramOnClickListener, paramh, paramInt1, paramBundle);
          break;
        }
      }
      if (paramInt2 == 1)
      {
        if (j == 22) {}
        for (paramInt1 = 1049;; paramInt1 = 1013) {
          break;
        }
      }
      if (j == 22) {}
      for (paramInt1 = 1047;; paramInt1 = 1011) {
        break;
      }
    }
  }
  
  protected static int wr(int paramInt)
  {
    if ((paramInt == 30) || (paramInt == 37) || (paramInt == 38) || (paramInt == 40)) {
      return 13;
    }
    if ((paramInt == 4) || (paramInt == 47)) {
      return 12;
    }
    if (paramInt == 34) {
      return 24;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a.c
 * JD-Core Version:    0.7.0.1
 */