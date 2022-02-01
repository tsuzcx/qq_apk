package com.tencent.mm.plugin.luckymoney.model;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.aq.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.q;
import com.tencent.mm.wallet_core.d.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class z
{
  private static com.tencent.mm.b.f<String, Bitmap> qfR;
  public static int teJ;
  
  static
  {
    AppMethodBeat.i(65274);
    teJ = 2147483647;
    qfR = new com.tencent.mm.memory.a.b(10, z.class);
    AppMethodBeat.o(65274);
  }
  
  public static boolean V(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(65267);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.w("MicroMsg.LuckyMoneyUtil", bt.nullAsNil(paramString1) + ", " + bt.nullAsNil(paramString2));
      AppMethodBeat.o(65267);
      return false;
    }
    bl localbl = new bl();
    localbl.setContent(paramString1);
    localbl.setStatus(2);
    localbl.nY(paramString2);
    localbl.kY(bi.uj(paramString2));
    localbl.jV(1);
    if (paramInt == 3) {
      localbl.setType(469762097);
    }
    long l;
    for (;;)
    {
      l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(localbl);
      if (l >= 0L) {
        break;
      }
      ad.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.f.XJ() + "insert msg failed :" + l);
      AppMethodBeat.o(65267);
      return false;
      localbl.setType(436207665);
    }
    com.tencent.mm.ai.k localk;
    if (localbl.cxB())
    {
      com.tencent.mm.modelstat.b.huc.b(localbl, com.tencent.mm.ai.l.r(localbl));
      localbl.setMsgId(l);
      localk = new com.tencent.mm.ai.k();
      localk.field_xml = localbl.field_content;
      paramString2 = bt.aGg(paramString1);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.ar(paramString2, localbl.field_reserved);
        paramString1 = paramString2;
        if (paramString2 != null)
        {
          localk.field_title = paramString2.title;
          localk.field_description = paramString2.description;
          paramString1 = paramString2;
        }
      }
      localk.field_type = 2001;
      localk.field_msgId = l;
      if ((paramString1 != null) && (paramString1.type == 2001) && (paramString1.dcz == 1))
      {
        if ((TextUtils.isEmpty(paramString1.gIR)) || (TextUtils.isEmpty(paramString1.gIS)) || (paramString1.gIT <= 0)) {
          break label463;
        }
        ad.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
        paramString2 = new aq();
        paramString2.dcJ = new aq.a();
        paramString2.dcJ.dcL = paramString1.gIS;
        paramString2.dcJ.dcK = paramString1.gIR;
        paramString2.dcJ.dcM = paramString1.gIT;
        com.tencent.mm.sdk.b.a.ESL.l(paramString2);
      }
      label411:
      paramString1 = com.tencent.mm.plugin.s.a.cZR().vk(l);
      if ((paramString1 == null) || (paramString1.field_msgId != l)) {
        break label474;
      }
      com.tencent.mm.plugin.s.a.cZR().update(localk, new String[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(65267);
      return true;
      com.tencent.mm.modelstat.b.huc.q(localbl);
      break;
      label463:
      ad.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
      break label411;
      label474:
      if (!com.tencent.mm.plugin.s.a.cZR().insert(localk)) {
        ad.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
      }
    }
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(65255);
    if (paramTextView == null)
    {
      AppMethodBeat.o(65255);
      return;
    }
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, paramString, paramTextView.getTextSize()));
    AppMethodBeat.o(65255);
  }
  
  public static void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(65263);
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.0F, 0.96F, 0.0F, 0.96F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(300L);
    localScaleAnimation1.setInterpolator(new OvershootInterpolator());
    localScaleAnimation1.setFillAfter(true);
    final ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setFillAfter(true);
    localScaleAnimation1.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(65246);
        this.nJo.startAnimation(localScaleAnimation2);
        AppMethodBeat.o(65246);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    if (paramAnimationListener != null) {
      localScaleAnimation2.setAnimationListener(paramAnimationListener);
    }
    if (paramView != null) {
      paramView.startAnimation(localScaleAnimation1);
    }
    AppMethodBeat.o(65263);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65250);
    a(paramImageView, paramString1, paramString2, false);
    AppMethodBeat.o(65250);
  }
  
  private static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(65249);
    ad.i("MicroMsg.LuckyMoneyUtil", "load url: %s", new Object[] { paramString1 });
    if (paramImageView != null) {
      paramImageView.setImageBitmap(null);
    }
    c.a locala;
    if (!bt.isNullOrNil(paramString1))
    {
      locala = new c.a();
      com.tencent.mm.plugin.luckymoney.b.a.cKP();
      locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.cKR();
      locala.hjU = true;
      locala.gjA = true;
      locala.gkG = paramBoolean;
      if (paramBoolean) {
        locala.hkm = 0.0F;
      }
      if (bt.isNullOrNil(paramString2)) {
        break label128;
      }
      locala.md5 = paramString2;
    }
    label128:
    for (locala.hjY = true;; locala.hjY = false)
    {
      paramString2 = locala.azc();
      o.ayJ().a(paramString1, paramImageView, paramString2);
      AppMethodBeat.o(65249);
      return;
    }
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(65256);
    if ((paramInt1 == 0) && (paramInt2 > 1))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramMMActivity, SelectLuckyMoneyContactUI.class);
      localIntent.putExtra("key_friends_num", paramInt2);
      if (paramBoolean) {
        localIntent.putExtra("scene_from", 5);
      }
      paramMMActivity.startActivityForResult(localIntent, 2);
      AppMethodBeat.o(65256);
      return;
    }
    a(paramMMActivity, 2, paramBoolean);
    AppMethodBeat.o(65256);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(65257);
    Intent localIntent = new Intent();
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("Select_Conv_Type", 3);
    if (paramBoolean) {
      localIntent.putExtra("scene_from", 5);
    }
    com.tencent.mm.bs.d.c(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    AppMethodBeat.o(65257);
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, n paramn, Bundle paramBundle, boolean paramBoolean, d.a parama, int paramInt2)
  {
    AppMethodBeat.i(65268);
    ad.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
    if (paramInt1 != 416)
    {
      ad.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
      AppMethodBeat.o(65268);
      return false;
    }
    paramBoolean = a(paramActivity, paramn, paramBundle, paramBoolean, parama, paramInt2);
    AppMethodBeat.o(65268);
    return paramBoolean;
  }
  
  private static boolean a(Activity paramActivity, n paramn, Bundle paramBundle, boolean paramBoolean, d.a parama, int paramInt)
  {
    AppMethodBeat.i(65269);
    Object localObject = "";
    String str2 = "";
    String str3 = "";
    String str1 = "";
    if ((paramn != null) && ((paramn instanceof ab)))
    {
      paramn = ((ab)paramn).rr;
      if (paramn != null)
      {
        paramn = (bgn)paramn.gUT.gUX;
        if (paramn.DEv != null) {
          paramn = com.tencent.mm.platformtools.z.b(paramn.DEv);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramn = new JSONObject(paramn);
        if (paramn == null) {
          break label339;
        }
        ad.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
        localObject = paramn;
        if (paramn.has("real_name_info")) {
          localObject = paramn.optJSONObject("real_name_info");
        }
        paramn = ((JSONObject)localObject).optString("guide_flag", "");
        String str4 = ((JSONObject)localObject).optString("guide_wording");
        str2 = ((JSONObject)localObject).optString("left_button_wording", paramActivity.getString(2131755691));
        str3 = ((JSONObject)localObject).optString("right_button_wording", paramActivity.getString(2131755835));
        str1 = ((JSONObject)localObject).optString("upload_credit_url", "");
        localObject = str4;
        if (!"1".equals(paramn)) {
          break label246;
        }
        ad.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramBundle, parama, paramInt);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      catch (JSONException paramn)
      {
        ad.printErrStackTrace("MicroMsg.LuckyMoneyUtil", paramn, "", new Object[0]);
      }
      paramn = null;
      continue;
      label246:
      if (("2".equals(paramn)) && (!bt.isNullOrNil(str1)))
      {
        ad.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, (String)localObject, str1, str2, str3, paramBoolean, null);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      ad.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + paramn + ";upload_credit_url=null?" + bt.isNullOrNil(str1));
      AppMethodBeat.o(65269);
      return false;
      label339:
      paramn = "";
    }
  }
  
  public static String afo(String paramString)
  {
    AppMethodBeat.i(65259);
    Object localObject = p.auF().we(paramString);
    if (localObject != null)
    {
      paramString = ((i)localObject).auy();
      AppMethodBeat.o(65259);
      return paramString;
    }
    com.tencent.mm.kernel.g.afC();
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if ((localObject == null) || (!((com.tencent.mm.g.c.au)localObject).field_username.equals(paramString)))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    if (((com.tencent.mm.g.c.au)localObject).evo == 4)
    {
      AppMethodBeat.o(65259);
      return null;
    }
    com.tencent.mm.kernel.g.afC();
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aId(paramString);
    if (bt.cw(paramString))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    try
    {
      paramString = ((bqj)new bqj().parseFrom(paramString)).CVw;
      AppMethodBeat.o(65259);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[] { bt.m(paramString) });
        paramString = null;
      }
    }
  }
  
  public static String afp(String paramString)
  {
    AppMethodBeat.i(65270);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.afw()))
    {
      AppMethodBeat.o(65270);
      return "";
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(String.format("%s/%s/", new Object[] { com.tencent.mm.kernel.g.afB().gcW, "LuckyMoney" }));
    if ((!locale.exists()) || (!locale.isDirectory())) {
      locale.mkdirs();
    }
    paramString = q.B(new com.tencent.mm.vfs.e(locale, paramString).fhU());
    AppMethodBeat.o(65270);
    return paramString;
  }
  
  public static void b(Button paramButton)
  {
    AppMethodBeat.i(65264);
    c(paramButton);
    AppMethodBeat.o(65264);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65253);
    if (paramImageView == null)
    {
      AppMethodBeat.o(65253);
      return;
    }
    if (!bt.isNullOrNil(paramString2)) {}
    for (;;)
    {
      a.b.a(paramImageView, paramString2, 0.1F, false);
      AppMethodBeat.o(65253);
      return;
      paramString2 = p.auH().vS(paramString1);
    }
  }
  
  public static void c(Button paramButton)
  {
    AppMethodBeat.i(65265);
    if (paramButton == null)
    {
      AppMethodBeat.o(65265);
      return;
    }
    paramButton.setBackgroundResource(2131232309);
    paramButton = (AnimationDrawable)paramButton.getBackground();
    if (paramButton != null) {
      paramButton.start();
    }
    AppMethodBeat.o(65265);
  }
  
  public static String cLy()
  {
    AppMethodBeat.i(65258);
    com.tencent.mm.kernel.g.afC();
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FgR, null);
    AppMethodBeat.o(65258);
    return str;
  }
  
  public static void d(Button paramButton)
  {
    AppMethodBeat.i(65266);
    if (paramButton == null)
    {
      AppMethodBeat.o(65266);
      return;
    }
    if (!(paramButton.getBackground() instanceof AnimationDrawable))
    {
      AppMethodBeat.o(65266);
      return;
    }
    paramButton = (AnimationDrawable)paramButton.getBackground();
    if (paramButton != null) {
      paramButton.stop();
    }
    AppMethodBeat.o(65266);
  }
  
  public static void dZ(View paramView)
  {
    AppMethodBeat.i(65262);
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.4F, 0.98F, 0.4F, 0.98F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(200L);
    localScaleAnimation1.setInterpolator(new OvershootInterpolator());
    localScaleAnimation1.setFillAfter(true);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.98F, 1.0F, 0.98F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(50L);
    localScaleAnimation2.setFillAfter(true);
    localScaleAnimation1.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(65245);
        AppMethodBeat.o(65245);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    if (paramView != null) {
      paramView.startAnimation(localScaleAnimation1);
    }
    AppMethodBeat.o(65262);
  }
  
  public static String ec(List<au> paramList)
  {
    AppMethodBeat.i(65271);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
      AppMethodBeat.o(65271);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      au localau = (au)paramList.get(i);
      if (localau != null)
      {
        if (i != 0) {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(localau.type);
        localStringBuilder.append("|");
        localStringBuilder.append(localau.name);
      }
      i += 1;
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(65271);
    return paramList;
  }
  
  public static int fq(Context paramContext)
  {
    AppMethodBeat.i(65261);
    if (teJ == 2147483647) {
      teJ = paramContext.getResources().getColor(2131100566);
    }
    int i = teJ;
    AppMethodBeat.o(65261);
    return i;
  }
  
  public static Dialog fr(Context paramContext)
  {
    AppMethodBeat.i(65273);
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, 3, 2131820985, paramContext.getString(2131760709), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(65273);
    return paramContext;
  }
  
  public static void hf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65272);
    if ((!bt.isNullOrNil(paramString1)) && (!bt.isNullOrNil(paramString2)))
    {
      bl localbl = new bl();
      localbl.jV(0);
      localbl.nY(paramString2);
      localbl.setStatus(3);
      localbl.setContent(paramString1);
      localbl.kY(bi.y(paramString2, System.currentTimeMillis() / 1000L));
      localbl.setType(10000);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(localbl);
    }
    AppMethodBeat.o(65272);
  }
  
  public static void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65251);
    a(paramImageView, paramString, null, false);
    AppMethodBeat.o(65251);
  }
  
  public static String m(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(65247);
    Object localObject = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(65247);
      return "";
    }
    long l = paramLong - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = new SimpleDateFormat("HH:mm").format(new Date(paramLong));
      AppMethodBeat.o(65247);
      return paramContext;
    }
    localObject = new Time();
    ((Time)localObject).set(paramLong);
    paramContext = com.tencent.mm.pluginsdk.g.g.a(paramContext.getString(2131759500, new Object[] { " " }), (Time)localObject).toString();
    AppMethodBeat.o(65247);
    return paramContext;
  }
  
  public static void m(TextView paramTextView)
  {
    AppMethodBeat.i(163577);
    paramTextView.setShadowLayer(8.0F, 0.0F, 0.0F, aj.getContext().getResources().getColor(2131100019));
    AppMethodBeat.o(163577);
  }
  
  public static void o(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65248);
    a(paramImageView, paramString, null, true);
    AppMethodBeat.o(65248);
  }
  
  public static void p(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65254);
    if (paramImageView == null)
    {
      AppMethodBeat.o(65254);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!bt.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      com.tencent.mm.plugin.luckymoney.b.a.cKP();
      ((c.a)localObject).prefixPath = com.tencent.mm.plugin.luckymoney.b.a.cKR();
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).gjA = true;
      ((c.a)localObject).gkG = true;
      ((c.a)localObject).hjX = 1;
      ((c.a)localObject).hkf = 2131232967;
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(paramString, paramImageView, (c)localObject);
    }
    AppMethodBeat.o(65254);
  }
  
  public static String sg(String paramString)
  {
    AppMethodBeat.i(65260);
    com.tencent.mm.kernel.g.afC();
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if ((localaf == null) || (!localaf.field_username.equals(paramString)))
    {
      AppMethodBeat.o(65260);
      return null;
    }
    paramString = localaf.field_nickname;
    AppMethodBeat.o(65260);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.z
 * JD-Core Version:    0.7.0.1
 */