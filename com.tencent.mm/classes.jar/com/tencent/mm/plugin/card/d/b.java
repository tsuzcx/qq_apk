package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.a;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class b
{
  public static void a(MMActivity paramMMActivity, float paramFloat1, float paramFloat2, String paramString)
  {
    AppMethodBeat.i(88816);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kwebmap_slat", paramFloat1);
    localIntent.putExtra("kwebmap_lng", paramFloat2);
    localIntent.putExtra("Kwebmap_locaion", paramString);
    d.b(paramMMActivity, "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(88816);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(88817);
    Intent localIntent = new Intent();
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("Select_Conv_Type", 3);
    d.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt, parama);
    AppMethodBeat.o(88817);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, String paramString, boolean paramBoolean, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88819);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("key_expire_time", paramInt);
    localIntent.putExtra("key_begin_time", System.currentTimeMillis());
    localIntent.putExtra("key_card_tips", paramString);
    localIntent.putExtra("key_is_mark", paramBoolean);
    localIntent.putExtra("key_card_id", paramb.bbi());
    localIntent.putExtra("key_user_card_id", paramb.bbh());
    localIntent.putExtra("key_card_code", paramb.bbe().code);
    d.b(paramMMActivity, "offline", ".ui.WalletOfflineEntranceUI", localIntent);
    h.qsU.e(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    AppMethodBeat.o(88819);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(156815);
    a(paramMMActivity, paramString, 0);
    AppMethodBeat.o(156815);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(88815);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("stastic_scene", paramInt);
    d.b(paramMMActivity, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(88815);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(88814);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("stastic_scene", 0);
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("title", paramString2);
    d.b(paramMMActivity, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(88814);
  }
  
  public static void a(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(88809);
    Intent localIntent = new Intent(paramMMActivity, CardNewMsgUI.class);
    localIntent.putExtra("from_menu", paramBoolean);
    paramMMActivity.startActivity(localIntent);
    ab.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
    h.qsU.e(11324, new Object[] { "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(88809);
  }
  
  public static boolean a(String paramString, uo paramuo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88820);
    if (paramuo == null)
    {
      ab.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
      AppMethodBeat.o(88820);
      return false;
    }
    boolean bool = d(paramString, paramuo.wFL, paramuo.wFM, paramInt1, paramInt2);
    AppMethodBeat.o(88820);
    return bool;
  }
  
  public static void ad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88810);
    if (TextUtils.isEmpty(paramString))
    {
      ab.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(88810);
      return;
    }
    if (paramContext == null)
    {
      ab.e("MicroMsg.CardActivityHelper", "context is null, err");
      AppMethodBeat.o(88810);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(88810);
  }
  
  public static void ae(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88811);
    if (TextUtils.isEmpty(paramString))
    {
      ab.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(88811);
      return;
    }
    if (t.nT(paramString))
    {
      af(paramContext, paramString);
      AppMethodBeat.o(88811);
      return;
    }
    ad(paramContext, paramString);
    AppMethodBeat.o(88811);
  }
  
  private static void af(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88812);
    if (TextUtils.isEmpty(paramString))
    {
      ab.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(88812);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    d.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(88812);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(88818);
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_BRAND_NAME", paramString);
    d.b(paramMMActivity, "card", ".ui.CardShowWaringTransparentUI", localIntent);
    AppMethodBeat.o(88818);
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88821);
    if (bo.isNullOrNil(paramString2))
    {
      ab.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
      AppMethodBeat.o(88821);
      return false;
    }
    so localso = new so();
    localso.cIQ.userName = paramString2;
    localso.cIQ.cIS = bo.bf(paramString3, "");
    localso.cIQ.cIT = paramInt2;
    if (paramInt1 == 26) {}
    for (localso.cIQ.scene = 1029;; localso.cIQ.scene = 1028)
    {
      localso.cIQ.cmF = paramString1;
      localso.cIQ.cIW = true;
      a.ymk.l(localso);
      ab.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", new Object[] { localso.cIQ.userName, localso.cIQ.cIS, Integer.valueOf(localso.cIQ.scene), Integer.valueOf(localso.cIQ.cIT) });
      AppMethodBeat.o(88821);
      return true;
    }
  }
  
  public static void x(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(88822);
    so localso = new so();
    localso.cIQ.userName = paramString1;
    localso.cIQ.cIS = bo.bf(paramString2, "");
    if (paramInt > 0) {
      localso.cIQ.bDc = paramInt;
    }
    localso.cIQ.scene = 1028;
    a.ymk.l(localso);
    AppMethodBeat.o(88822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.b
 * JD-Core Version:    0.7.0.1
 */