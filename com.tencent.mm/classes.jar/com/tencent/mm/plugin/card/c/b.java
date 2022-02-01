package com.tencent.mm.plugin.card.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.a.zp.a;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class b
{
  public static void S(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(113750);
    zp localzp = new zp();
    localzp.icM.userName = paramString1;
    localzp.icM.icO = Util.nullAs(paramString2, "");
    if (paramInt > 0) {
      localzp.icM.appVersion = paramInt;
    }
    localzp.icM.scene = 1028;
    localzp.publish();
    AppMethodBeat.o(113750);
  }
  
  public static boolean V(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(293749);
    boolean bool = f(paramString1, paramString2, paramString3, 1028, 0);
    AppMethodBeat.o(293749);
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
    localIntent.putExtra("key_card_id", paramb.djP());
    localIntent.putExtra("key_user_card_id", paramb.djO());
    localIntent.putExtra("key_card_code", paramb.djL().code);
    c.b(paramMMActivity, "offline", ".ui.WalletOfflineEntranceUI", localIntent);
    h.OAn.b(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    h.OAn.b(19671, new Object[] { Integer.valueOf(1), paramb.djO() });
    AppMethodBeat.o(113747);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(113746);
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_BRAND_NAME", paramString);
    c.b(paramMMActivity, "card", ".ui.CardShowWaringTransparentUI", localIntent);
    AppMethodBeat.o(113746);
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "goCardNewMsgUI", "(Lcom/tencent/mm/ui/MMActivity;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramMMActivity, "com/tencent/mm/plugin/card/util/CardActivityHelper", "goCardNewMsgUI", "(Lcom/tencent/mm/ui/MMActivity;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Log.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
    h.OAn.b(11324, new Object[] { "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113737);
  }
  
  public static boolean a(String paramString, aek paramaek, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113748);
    if (paramaek == null)
    {
      Log.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
      AppMethodBeat.o(113748);
      return false;
    }
    boolean bool = f(paramString, paramaek.Zdw, paramaek.Zdx, paramInt1, paramInt2);
    AppMethodBeat.o(113748);
    return bool;
  }
  
  public static void an(Context paramContext, String paramString)
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
  
  public static void ao(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113739);
    if (TextUtils.isEmpty(paramString))
    {
      Log.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(113739);
      return;
    }
    if (ab.IR(paramString))
    {
      ap(paramContext, paramString);
      AppMethodBeat.o(113739);
      return;
    }
    an(paramContext, paramString);
    AppMethodBeat.o(113739);
  }
  
  private static void ap(Context paramContext, String paramString)
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
    c.g(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(113740);
  }
  
  public static boolean f(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113749);
    if (Util.isNullOrNil(paramString2))
    {
      Log.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
      AppMethodBeat.o(113749);
      return false;
    }
    zp localzp = new zp();
    localzp.icM.userName = paramString2;
    localzp.icM.icO = Util.nullAs(paramString3, "");
    localzp.icM.icP = paramInt2;
    if (paramInt1 == 26) {}
    for (localzp.icM.scene = 1029;; localzp.icM.scene = 1028)
    {
      localzp.icM.hzx = paramString1;
      localzp.icM.icT = true;
      localzp.publish();
      Log.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", new Object[] { localzp.icM.userName, localzp.icM.icO, Integer.valueOf(localzp.icM.scene), Integer.valueOf(localzp.icM.icP) });
      AppMethodBeat.o(113749);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.b
 * JD-Core Version:    0.7.0.1
 */