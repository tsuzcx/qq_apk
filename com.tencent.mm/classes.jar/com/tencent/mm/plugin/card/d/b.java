package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class b
{
  public static void I(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(113750);
    vm localvm = new vm();
    localvm.dJF.userName = paramString1;
    localvm.dJF.dJH = bt.bI(paramString2, "");
    if (paramInt > 0) {
      localvm.dJF.aDD = paramInt;
    }
    localvm.dJF.scene = 1028;
    com.tencent.mm.sdk.b.a.IbL.l(localvm);
    AppMethodBeat.o(113750);
  }
  
  public static boolean P(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(215409);
    boolean bool = d(paramString1, paramString2, paramString3, 1028, 0);
    AppMethodBeat.o(215409);
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
    d.b(paramMMActivity, "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(113744);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, MMActivity.a parama)
  {
    AppMethodBeat.i(113745);
    Intent localIntent = new Intent();
    localIntent.putExtra("select_is_ret", false);
    localIntent.putExtra("Select_Conv_Type", 3);
    d.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt, parama);
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
    localIntent.putExtra("key_card_id", paramb.bTS());
    localIntent.putExtra("key_user_card_id", paramb.bTR());
    localIntent.putExtra("key_card_code", paramb.bTO().code);
    d.b(paramMMActivity, "offline", ".ui.WalletOfflineEntranceUI", localIntent);
    g.yhR.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    g.yhR.f(19671, new Object[] { Integer.valueOf(1), paramb.bTR() });
    AppMethodBeat.o(113747);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(221189);
    a(paramMMActivity, paramString, 0);
    AppMethodBeat.o(221189);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(113743);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("stastic_scene", paramInt);
    d.b(paramMMActivity, "webview", ".ui.tools.WebViewUI", localIntent);
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
    d.b(paramMMActivity, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(113742);
  }
  
  public static void a(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(113737);
    Object localObject = new Intent(paramMMActivity, CardNewMsgUI.class);
    ((Intent)localObject).putExtra("from_menu", paramBoolean);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "goCardNewMsgUI", "(Lcom/tencent/mm/ui/MMActivity;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramMMActivity, "com/tencent/mm/plugin/card/util/CardActivityHelper", "goCardNewMsgUI", "(Lcom/tencent/mm/ui/MMActivity;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ad.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
    g.yhR.f(11324, new Object[] { "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113737);
  }
  
  public static boolean a(String paramString, aaf paramaaf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113748);
    if (paramaaf == null)
    {
      ad.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
      AppMethodBeat.o(113748);
      return false;
    }
    boolean bool = d(paramString, paramaaf.FRk, paramaaf.FRl, paramInt1, paramInt2);
    AppMethodBeat.o(113748);
    return bool;
  }
  
  public static void ac(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113738);
    if (TextUtils.isEmpty(paramString))
    {
      ad.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(113738);
      return;
    }
    if (paramContext == null)
    {
      ad.e("MicroMsg.CardActivityHelper", "context is null, err");
      AppMethodBeat.o(113738);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("force_get_contact", true);
    d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(113738);
  }
  
  public static void ad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113739);
    if (TextUtils.isEmpty(paramString))
    {
      ad.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(113739);
      return;
    }
    if (w.zD(paramString))
    {
      ae(paramContext, paramString);
      AppMethodBeat.o(113739);
      return;
    }
    ac(paramContext, paramString);
    AppMethodBeat.o(113739);
  }
  
  private static void ae(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113740);
    if (TextUtils.isEmpty(paramString))
    {
      ad.v("MicroMsg.CardActivityHelper", "username is null");
      AppMethodBeat.o(113740);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    d.f(paramContext, ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(113740);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(113746);
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_BRAND_NAME", paramString);
    d.b(paramMMActivity, "card", ".ui.CardShowWaringTransparentUI", localIntent);
    AppMethodBeat.o(113746);
  }
  
  public static boolean d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113749);
    if (bt.isNullOrNil(paramString2))
    {
      ad.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
      AppMethodBeat.o(113749);
      return false;
    }
    vm localvm = new vm();
    localvm.dJF.userName = paramString2;
    localvm.dJF.dJH = bt.bI(paramString3, "");
    localvm.dJF.dJI = paramInt2;
    if (paramInt1 == 26) {}
    for (localvm.dJF.scene = 1029;; localvm.dJF.scene = 1028)
    {
      localvm.dJF.dkh = paramString1;
      localvm.dJF.dJL = true;
      com.tencent.mm.sdk.b.a.IbL.l(localvm);
      ad.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", new Object[] { localvm.dJF.userName, localvm.dJF.dJH, Integer.valueOf(localvm.dJF.scene), Integer.valueOf(localvm.dJF.dJI) });
      AppMethodBeat.o(113749);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.b
 * JD-Core Version:    0.7.0.1
 */