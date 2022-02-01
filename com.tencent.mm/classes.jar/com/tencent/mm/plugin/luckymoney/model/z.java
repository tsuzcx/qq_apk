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
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.ar.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
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
  private static com.tencent.mm.b.f<String, Bitmap> qOt;
  public static int umY;
  
  static
  {
    AppMethodBeat.i(65274);
    umY = 2147483647;
    qOt = new com.tencent.mm.memory.a.b(10, z.class);
    AppMethodBeat.o(65274);
  }
  
  public static boolean W(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(65267);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      ac.w("MicroMsg.LuckyMoneyUtil", bs.nullAsNil(paramString1) + ", " + bs.nullAsNil(paramString2));
      AppMethodBeat.o(65267);
      return false;
    }
    bo localbo = new bo();
    localbo.setContent(paramString1);
    localbo.setStatus(2);
    localbo.re(paramString2);
    localbo.oA(bi.yp(paramString2));
    localbo.jT(1);
    if (paramInt == 3) {
      localbo.setType(469762097);
    }
    long l;
    for (;;)
    {
      l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(localbo);
      if (l >= 0L) {
        break;
      }
      ac.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.f.YG() + "insert msg failed :" + l);
      AppMethodBeat.o(65267);
      return false;
      localbo.setType(436207665);
    }
    com.tencent.mm.ah.k localk;
    if (localbo.cKN())
    {
      com.tencent.mm.modelstat.b.hUE.b(localbo, com.tencent.mm.ah.l.r(localbo));
      localbo.setMsgId(l);
      localk = new com.tencent.mm.ah.k();
      localk.field_xml = localbo.field_content;
      paramString2 = bs.aLx(paramString1);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.az(paramString2, localbo.field_reserved);
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
      if ((paramString1 != null) && (paramString1.type == 2001) && (paramString1.cZX == 1))
      {
        if ((TextUtils.isEmpty(paramString1.hjr)) || (TextUtils.isEmpty(paramString1.hjs)) || (paramString1.hjt <= 0)) {
          break label463;
        }
        ac.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
        paramString2 = new ar();
        paramString2.dah = new ar.a();
        paramString2.dah.daj = paramString1.hjs;
        paramString2.dah.dai = paramString1.hjr;
        paramString2.dah.dak = paramString1.hjt;
        com.tencent.mm.sdk.b.a.GpY.l(paramString2);
      }
      label411:
      paramString1 = com.tencent.mm.plugin.s.a.dnz().zN(l);
      if ((paramString1 == null) || (paramString1.field_msgId != l)) {
        break label474;
      }
      com.tencent.mm.plugin.s.a.dnz().update(localk, new String[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(65267);
      return true;
      com.tencent.mm.modelstat.b.hUE.q(localbo);
      break;
      label463:
      ac.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
      break label411;
      label474:
      if (!com.tencent.mm.plugin.s.a.dnz().insert(localk)) {
        ac.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
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
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setFillAfter(true);
    localScaleAnimation1.setAnimationListener(new z.2(paramView, localScaleAnimation2));
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
    ac.i("MicroMsg.LuckyMoneyUtil", "load url: %s", new Object[] { paramString1 });
    if (paramImageView != null) {
      paramImageView.setImageBitmap(null);
    }
    c.a locala;
    if (!bs.isNullOrNil(paramString1))
    {
      locala = new c.a();
      com.tencent.mm.plugin.luckymoney.b.a.cYv();
      locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.cYx();
      locala.hKx = true;
      locala.gKm = true;
      locala.gLt = paramBoolean;
      if (paramBoolean) {
        locala.hKP = 0.0F;
      }
      if (bs.isNullOrNil(paramString2)) {
        break label128;
      }
      locala.md5 = paramString2;
    }
    label128:
    for (locala.hKB = true;; locala.hKB = false)
    {
      paramString2 = locala.aFT();
      o.aFB().a(paramString1, paramImageView, paramString2);
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
    com.tencent.mm.br.d.c(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    AppMethodBeat.o(65257);
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, n paramn, Bundle paramBundle, boolean paramBoolean, d.a parama, int paramInt2)
  {
    AppMethodBeat.i(65268);
    ac.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
    if (paramInt1 != 416)
    {
      ac.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
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
        paramn = (bkf)paramn.hvs.hvw;
        if (paramn.EZQ != null) {
          paramn = com.tencent.mm.platformtools.z.b(paramn.EZQ);
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
        ac.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
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
        ac.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramBundle, parama, paramInt);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      catch (JSONException paramn)
      {
        ac.printErrStackTrace("MicroMsg.LuckyMoneyUtil", paramn, "", new Object[0]);
      }
      paramn = null;
      continue;
      label246:
      if (("2".equals(paramn)) && (!bs.isNullOrNil(str1)))
      {
        ac.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, (String)localObject, str1, str2, str3, paramBoolean, null);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      ac.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + paramn + ";upload_credit_url=null?" + bs.isNullOrNil(str1));
      AppMethodBeat.o(65269);
      return false;
      label339:
      paramn = "";
    }
  }
  
  public static String aki(String paramString)
  {
    AppMethodBeat.i(65259);
    Object localObject = p.aBw().Ak(paramString);
    if (localObject != null)
    {
      paramString = ((i)localObject).aBp();
      AppMethodBeat.o(65259);
      return paramString;
    }
    com.tencent.mm.kernel.g.agS();
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if ((localObject == null) || (!((av)localObject).field_username.equals(paramString)))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    if (((av)localObject).exK == 4)
    {
      AppMethodBeat.o(65259);
      return null;
    }
    com.tencent.mm.kernel.g.agS();
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNy(paramString);
    if (bs.cv(paramString))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    try
    {
      paramString = ((bva)new bva().parseFrom(paramString)).Eog;
      AppMethodBeat.o(65259);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[] { bs.m(paramString) });
        paramString = null;
      }
    }
  }
  
  public static String akj(String paramString)
  {
    AppMethodBeat.i(65270);
    if ((bs.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.agM()))
    {
      AppMethodBeat.o(65270);
      return "";
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(String.format("%s/%s/", new Object[] { com.tencent.mm.kernel.g.agR().ghC, "LuckyMoney" }));
    if ((!locale.exists()) || (!locale.isDirectory())) {
      locale.mkdirs();
    }
    paramString = q.B(new com.tencent.mm.vfs.e(locale, paramString).fxV());
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
    if (!bs.isNullOrNil(paramString2)) {}
    for (;;)
    {
      a.b.a(paramImageView, paramString2, 0.1F, false);
      AppMethodBeat.o(65253);
      return;
      paramString2 = p.aBy().zY(paramString1);
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
  
  public static String cZe()
  {
    AppMethodBeat.i(65258);
    com.tencent.mm.kernel.g.agS();
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEF, null);
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
  
  public static String eg(List<au> paramList)
  {
    AppMethodBeat.i(65271);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
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
  
  public static void ei(View paramView)
  {
    AppMethodBeat.i(65262);
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.4F, 0.98F, 0.4F, 0.98F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(200L);
    localScaleAnimation1.setInterpolator(new OvershootInterpolator());
    localScaleAnimation1.setFillAfter(true);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.98F, 1.0F, 0.98F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(50L);
    localScaleAnimation2.setFillAfter(true);
    localScaleAnimation1.setAnimationListener(new z.1());
    if (paramView != null) {
      paramView.startAnimation(localScaleAnimation1);
    }
    AppMethodBeat.o(65262);
  }
  
  public static int fC(Context paramContext)
  {
    AppMethodBeat.i(65261);
    if (umY == 2147483647) {
      umY = paramContext.getResources().getColor(2131100566);
    }
    int i = umY;
    AppMethodBeat.o(65261);
    return i;
  }
  
  public static Dialog fD(Context paramContext)
  {
    AppMethodBeat.i(65273);
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, 3, 2131820985, paramContext.getString(2131760709), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(65273);
    return paramContext;
  }
  
  public static void hy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65272);
    if ((!bs.isNullOrNil(paramString1)) && (!bs.isNullOrNil(paramString2)))
    {
      bo localbo = new bo();
      localbo.jT(0);
      localbo.re(paramString2);
      localbo.setStatus(3);
      localbo.setContent(paramString1);
      localbo.oA(bi.z(paramString2, System.currentTimeMillis() / 1000L));
      localbo.setType(10000);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(localbo);
    }
    AppMethodBeat.o(65272);
  }
  
  public static void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65251);
    a(paramImageView, paramString, null, false);
    AppMethodBeat.o(65251);
  }
  
  public static void m(TextView paramTextView)
  {
    AppMethodBeat.i(163577);
    paramTextView.setShadowLayer(8.0F, 0.0F, 0.0F, com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getColor(2131100019));
    AppMethodBeat.o(163577);
  }
  
  public static String n(Context paramContext, long paramLong)
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
    if (!bs.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      com.tencent.mm.plugin.luckymoney.b.a.cYv();
      ((c.a)localObject).prefixPath = com.tencent.mm.plugin.luckymoney.b.a.cYx();
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).gKm = true;
      ((c.a)localObject).gLt = true;
      ((c.a)localObject).hKA = 1;
      ((c.a)localObject).hKI = 2131232967;
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(paramString, paramImageView, (c)localObject);
    }
    AppMethodBeat.o(65254);
  }
  
  public static String wj(String paramString)
  {
    AppMethodBeat.i(65260);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.storage.ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if ((localai == null) || (!localai.field_username.equals(paramString)))
    {
      AppMethodBeat.o(65260);
      return null;
    }
    paramString = localai.field_nickname;
    AppMethodBeat.o(65260);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.z
 * JD-Core Version:    0.7.0.1
 */