package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.a.xw.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class b
{
  public static void L(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(113750);
    xw localxw = new xw();
    localxw.fWN.userName = paramString1;
    localxw.fWN.fWP = Util.nullAs(paramString2, "");
    if (paramInt > 0) {
      localxw.fWN.appVersion = paramInt;
    }
    localxw.fWN.scene = 1028;
    EventCenter.instance.publish(localxw);
    AppMethodBeat.o(113750);
  }
  
  public static boolean S(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(251627);
    boolean bool = e(paramString1, paramString2, paramString3, 1028, 0);
    AppMethodBeat.o(251627);
    return bool;
  }
  
  public static void a(MMActivity paramMMActivity, float paramFloat1, float paramFloat2, String paramString)
  {
    AppMethodBeat.i(113744);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 2);
    localIntent.putExtra("kwebmap_slat", paramFloat1);
    localIntent.putExtra("kwebmap_lng", paramFloat2);
    localIntent.putExtra("Kwebmap_locaion", paramString);
    c.b(paramMMActivity, "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(113744);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(113745);
    Intent localIntent = new Intent();
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("Select_Conv_Type", 3);
    c.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt, parama);
    AppMethodBeat.o(113745);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, String paramString, boolean paramBoolean, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113747);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", 3);
    localIntent.putExtra("key_expire_time", paramInt);
    localIntent.putExtra("key_begin_time", System.currentTimeMillis());
    localIntent.putExtra("key_card_tips", paramString);
    localIntent.putExtra("key_is_mark", paramBoolean);
    localIntent.putExtra("key_card_id", paramb.cGx());
    localIntent.putExtra("key_user_card_id", paramb.cGw());
    localIntent.putExtra("key_card_code", paramb.cGt().code);
    c.b(paramMMActivity, "offline", ".ui.WalletOfflineEntranceUI", localIntent);
    h.IzE.a(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    h.IzE.a(19671, new Object[] { Integer.valueOf(1), paramb.cGw() });
    AppMethodBeat.o(113747);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(292868);
    a(paramMMActivity, paramString, 0);
    AppMethodBeat.o(292868);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(113743);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("stastic_scene", paramInt);
    c.b(paramMMActivity, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(113743);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(113742);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("stastic_scene", 0);
    localIntent.putExtra("rawUrl", paramString1);
    localIntent.putExtra("title", paramString2);
    c.b(paramMMActivity, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(113742);
  }
  
  public static void a(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(113737);
    Object localObject = new Intent(paramMMActivity, CardNewMsgUI.class);
    ((Intent)localObject).putExtra("from_menu", paramBoolean);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "goCardNewMsgUI", "(Lcom/tencent/mm/ui/MMActivity;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramMMActivity, "com/tencent/mm/plugin/card/util/CardActivityHelper", "goCardNewMsgUI", "(Lcom/tencent/mm/ui/MMActivity;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Log.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
    h.IzE.a(11324, new Object[] { "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113737);
  }
  
  public static boolean a(String paramString, acg paramacg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113748);
    if (paramacg == null)
    {
      Log.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
      AppMethodBeat.o(113748);
      return false;
    }
    boolean bool = e(paramString, paramacg.SfB, paramacg.SfC, paramInt1, paramInt2);
    AppMethodBeat.o(113748);
    return bool;
  }
  
  public static void am(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113738);
    if (TextUtils.isEmpty(paramString))
    {
      Log.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(113738);
      return;
    }
    if (paramContext == null)
    {
      Log.e("MicroMsg.CardActivityHelper", "context is null, err");
      AppMethodBeat.o(113738);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(113738);
  }
  
  public static void an(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113739);
    if (TextUtils.isEmpty(paramString))
    {
      Log.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(113739);
      return;
    }
    if (ab.Ql(paramString))
    {
      ao(paramContext, paramString);
      AppMethodBeat.o(113739);
      return;
    }
    am(paramContext, paramString);
    AppMethodBeat.o(113739);
  }
  
  private static void ao(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113740);
    if (TextUtils.isEmpty(paramString))
    {
      Log.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(113740);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    c.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(113740);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(113746);
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_BRAND_NAME", paramString);
    c.b(paramMMActivity, "card", ".ui.CardShowWaringTransparentUI", localIntent);
    AppMethodBeat.o(113746);
  }
  
  public static boolean e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113749);
    if (Util.isNullOrNil(paramString2))
    {
      Log.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
      AppMethodBeat.o(113749);
      return false;
    }
    xw localxw = new xw();
    localxw.fWN.userName = paramString2;
    localxw.fWN.fWP = Util.nullAs(paramString3, "");
    localxw.fWN.fWQ = paramInt2;
    if (paramInt1 == 26) {}
    for (localxw.fWN.scene = 1029;; localxw.fWN.scene = 1028)
    {
      localxw.fWN.fvd = paramString1;
      localxw.fWN.fWU = true;
      EventCenter.instance.publish(localxw);
      Log.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", new Object[] { localxw.fWN.userName, localxw.fWN.fWP, Integer.valueOf(localxw.fWN.scene), Integer.valueOf(localxw.fWN.fWQ) });
      AppMethodBeat.o(113749);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.b
 * JD-Core Version:    0.7.0.1
 */