package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.a.rc.a;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class b
{
  public static void a(MMActivity paramMMActivity, float paramFloat1, float paramFloat2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kwebmap_slat", paramFloat1);
    localIntent.putExtra("kwebmap_lng", paramFloat2);
    localIntent.putExtra("Kwebmap_locaion", paramString);
    d.b(paramMMActivity, "location", ".ui.RedirectUI", localIntent);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, MMActivity.a parama)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("Select_Conv_Type", 3);
    d.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt, parama);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, String paramString, boolean paramBoolean, com.tencent.mm.plugin.card.base.b paramb)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("key_expire_time", paramInt);
    localIntent.putExtra("key_begin_time", System.currentTimeMillis());
    localIntent.putExtra("key_card_tips", paramString);
    localIntent.putExtra("key_is_mark", paramBoolean);
    localIntent.putExtra("key_card_id", paramb.azC());
    localIntent.putExtra("key_user_card_id", paramb.azB());
    localIntent.putExtra("key_card_code", paramb.azy().code);
    d.b(paramMMActivity, "offline", ".ui.WalletOfflineEntranceUI", localIntent);
    h.nFQ.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
  }
  
  public static void a(MMActivity paramMMActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_BRAND_NAME", paramString);
    d.b(paramMMActivity, "card", ".ui.CardShowWaringTransparentUI", localIntent);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("stastic_scene", paramInt);
    d.b(paramMMActivity, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("stastic_scene", 0);
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("title", paramString2);
    d.b(paramMMActivity, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  public static void a(MMActivity paramMMActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramMMActivity, CardNewMsgUI.class);
    localIntent.putExtra("from_menu", paramBoolean);
    paramMMActivity.startActivity(localIntent);
    y.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
    h.nFQ.f(11324, new Object[] { "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
  }
  
  public static boolean a(String paramString, ra paramra, int paramInt1, int paramInt2)
  {
    if (paramra == null)
    {
      y.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
      return false;
    }
    return d(paramString, paramra.sIf, paramra.sIg, paramInt1, paramInt2);
  }
  
  public static void aa(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.v("MicroMsg.CardActivityHelper", "username is null");
      return;
    }
    if (paramContext == null)
    {
      y.e("MicroMsg.CardActivityHelper", "context is null, err");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
  }
  
  public static void ab(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.v("MicroMsg.CardActivityHelper", "username is null");
      return;
    }
    if (s.hk(paramString))
    {
      if (TextUtils.isEmpty(paramString))
      {
        y.v("MicroMsg.CardActivityHelper", "username is null");
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("Chat_User", paramString);
      localIntent.putExtra("finish_direct", true);
      d.e(paramContext, ".ui.chatting.ChattingUI", localIntent);
      return;
    }
    aa(paramContext, paramString);
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (bk.bl(paramString2))
    {
      y.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
      return false;
    }
    rc localrc = new rc();
    localrc.caq.userName = paramString2;
    localrc.caq.cas = bk.aM(paramString3, "");
    localrc.caq.cat = paramInt2;
    if (paramInt1 == 26) {}
    for (localrc.caq.scene = 1029;; localrc.caq.scene = 1028)
    {
      localrc.caq.bFv = paramString1;
      localrc.caq.cax = true;
      a.udP.m(localrc);
      y.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", new Object[] { localrc.caq.userName, localrc.caq.cas, Integer.valueOf(localrc.caq.scene), Integer.valueOf(localrc.caq.cat) });
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.b
 * JD-Core Version:    0.7.0.1
 */