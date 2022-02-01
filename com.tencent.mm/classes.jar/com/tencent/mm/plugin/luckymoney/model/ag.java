package com.tencent.mm.plugin.luckymoney.model;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.am.j;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.ax.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ag
{
  public static int EAN;
  private static com.tencent.mm.b.f<String, Bitmap> wMz;
  
  static
  {
    AppMethodBeat.i(65274);
    EAN = 2147483647;
    wMz = new com.tencent.mm.memory.a.b(10, ag.class);
    AppMethodBeat.o(65274);
  }
  
  public static String PI(String paramString)
  {
    AppMethodBeat.i(65260);
    com.tencent.mm.kernel.h.aHH();
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if ((localas == null) || (!localas.field_username.equals(paramString)))
    {
      AppMethodBeat.o(65260);
      return null;
    }
    paramString = localas.field_nickname;
    AppMethodBeat.o(65260);
    return paramString;
  }
  
  public static boolean PS(String paramString)
  {
    AppMethodBeat.i(256735);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHi, false);
    Log.i("MicroMsg.LuckyMoneyUtil", "union luckymoney logic：OpenUnionLuckyMoney switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      bool = ab.PS(paramString);
      AppMethodBeat.o(256735);
      return bool;
    }
    AppMethodBeat.o(256735);
    return false;
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(65255);
    if (paramTextView == null)
    {
      AppMethodBeat.o(65255);
      return;
    }
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, paramString, paramTextView.getTextSize()));
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
        this.tHb.startAnimation(localScaleAnimation2);
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
    AppMethodBeat.i(65253);
    if (paramImageView == null)
    {
      AppMethodBeat.o(65253);
      return;
    }
    if (!Util.isNullOrNil(paramString2)) {}
    for (;;)
    {
      a.b.a(paramImageView, paramString2, 0.1F, false);
      AppMethodBeat.o(65253);
      return;
      paramString2 = com.tencent.mm.am.q.bhR().TD(paramString1);
    }
  }
  
  private static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(65249);
    Log.i("MicroMsg.LuckyMoneyUtil", "load url: %s", new Object[] { paramString1 });
    if (paramImageView != null) {
      paramImageView.setImageBitmap(null);
    }
    c.a locala;
    if (!Util.isNullOrNil(paramString1))
    {
      locala = new c.a();
      com.tencent.mm.plugin.luckymoney.b.a.eNR();
      locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eNV();
      locala.lRD = true;
      locala.kOl = true;
      locala.kPz = paramBoolean;
      if (paramBoolean) {
        locala.lRW = 0.0F;
      }
      if (Util.isNullOrNil(paramString2)) {
        break label125;
      }
      locala.md5 = paramString2;
    }
    label125:
    for (locala.lRH = true;; locala.lRH = false)
    {
      paramString2 = locala.bmL();
      com.tencent.mm.ay.q.bml().a(paramString1, paramImageView, paramString2);
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
    com.tencent.mm.by.c.d(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    AppMethodBeat.o(65257);
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, com.tencent.mm.an.q paramq, Bundle paramBundle, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener, d.a parama, int paramInt2)
  {
    AppMethodBeat.i(256728);
    Log.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
    if (paramInt1 != 416)
    {
      Log.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
      AppMethodBeat.o(256728);
      return false;
    }
    paramBoolean = a(paramActivity, paramq, paramBundle, paramBoolean, parama, paramInt2);
    AppMethodBeat.o(256728);
    return paramBoolean;
  }
  
  private static boolean a(Activity paramActivity, com.tencent.mm.an.q paramq, Bundle paramBundle, boolean paramBoolean, d.a parama, int paramInt)
  {
    AppMethodBeat.i(65269);
    Object localObject = "";
    String str2 = "";
    String str3 = "";
    String str1 = "";
    if ((paramq != null) && ((paramq instanceof ai)))
    {
      paramq = ((ai)paramq).rr;
      if (paramq != null)
      {
        paramq = (ckc)d.c.b(paramq.lBS);
        if (paramq.TrG != null) {
          paramq = z.b(paramq.TrG);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramq = new JSONObject(paramq);
        if (paramq == null) {
          break label339;
        }
        Log.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
        localObject = paramq;
        if (paramq.has("real_name_info")) {
          localObject = paramq.optJSONObject("real_name_info");
        }
        paramq = ((JSONObject)localObject).optString("guide_flag", "");
        String str4 = ((JSONObject)localObject).optString("guide_wording");
        str2 = ((JSONObject)localObject).optString("left_button_wording", paramActivity.getString(a.i.app_cancel));
        str3 = ((JSONObject)localObject).optString("right_button_wording", paramActivity.getString(a.i.app_ok));
        str1 = ((JSONObject)localObject).optString("upload_credit_url", "");
        localObject = str4;
        if (!"1".equals(paramq)) {
          break label246;
        }
        Log.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramBundle, parama, paramInt);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      catch (JSONException paramq)
      {
        Log.printErrStackTrace("MicroMsg.LuckyMoneyUtil", paramq, "", new Object[0]);
      }
      paramq = null;
      continue;
      label246:
      if (("2".equals(paramq)) && (!Util.isNullOrNil(str1)))
      {
        Log.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, (String)localObject, str1, str2, str3, paramBoolean, null);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      Log.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + paramq + ";upload_credit_url=null?" + Util.isNullOrNil(str1));
      AppMethodBeat.o(65269);
      return false;
      label339:
      paramq = "";
    }
  }
  
  public static String aNF(String paramString)
  {
    AppMethodBeat.i(65259);
    Object localObject = com.tencent.mm.am.q.bhP().TS(paramString);
    if (localObject != null)
    {
      paramString = ((j)localObject).bhI();
      AppMethodBeat.o(65259);
      return paramString;
    }
    com.tencent.mm.kernel.h.aHH();
    localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if ((localObject == null) || (!((com.tencent.mm.f.c.ax)localObject).field_username.equals(paramString)))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    if (((com.tencent.mm.f.c.ax)localObject).hDc == 4)
    {
      AppMethodBeat.o(65259);
      return null;
    }
    com.tencent.mm.kernel.h.aHH();
    paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwn(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    try
    {
      paramString = ((cyb)new cyb().parseFrom(paramString)).SjJ;
      AppMethodBeat.o(65259);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        paramString = null;
      }
    }
  }
  
  public static String aNG(String paramString)
  {
    AppMethodBeat.i(65270);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.h.aHB()))
    {
      AppMethodBeat.o(65270);
      return "";
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(String.format("%s/%s/", new Object[] { com.tencent.mm.kernel.h.aHG().kcB, "LuckyMoney" }));
    if ((!localq.ifE()) || (!localq.isDirectory())) {
      localq.ifL();
    }
    paramString = new com.tencent.mm.vfs.q(localq, paramString).bOF();
    AppMethodBeat.o(65270);
    return paramString;
  }
  
  public static boolean ag(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(65267);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.w("MicroMsg.LuckyMoneyUtil", Util.nullAsNil(paramString1) + ", " + Util.nullAsNil(paramString2));
      AppMethodBeat.o(65267);
      return false;
    }
    ca localca = new ca();
    localca.setContent(paramString1);
    localca.setStatus(2);
    localca.Jm(paramString2);
    localca.setCreateTime(bq.RP(paramString2));
    localca.pJ(1);
    if (paramInt == 3) {
      localca.setType(469762097);
    }
    long l;
    for (;;)
    {
      l = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(localca);
      if (l >= 0L) {
        break;
      }
      Log.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.f.avD() + "insert msg failed :" + l);
      AppMethodBeat.o(65267);
      return false;
      localca.setType(436207665);
    }
    com.tencent.mm.aj.k localk;
    if (localca.erk())
    {
      com.tencent.mm.modelstat.b.mcf.d(localca, com.tencent.mm.aj.l.v(localca));
      localca.setMsgId(l);
      localk = new com.tencent.mm.aj.k();
      localk.field_xml = localca.field_content;
      paramString2 = Util.processXml(paramString1);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.aG(paramString2, localca.field_reserved);
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
      if ((paramString1 != null) && (paramString1.type == 2001) && (paramString1.fwp == 1))
      {
        if ((TextUtils.isEmpty(paramString1.lnK)) || (TextUtils.isEmpty(paramString1.lnL)) || (paramString1.lnM <= 0)) {
          break label472;
        }
        Log.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
        paramString2 = new com.tencent.mm.f.a.ax();
        paramString2.fwD = new ax.a();
        paramString2.fwD.fwF = paramString1.lnL;
        paramString2.fwD.fwE = paramString1.lnK;
        paramString2.fwD.fwG = paramString1.lnM;
        EventCenter.instance.publish(paramString2);
      }
      label419:
      paramString1 = com.tencent.mm.plugin.ab.a.fmA().NR(l);
      if ((paramString1 == null) || (paramString1.field_msgId != l)) {
        break label483;
      }
      com.tencent.mm.plugin.ab.a.fmA().update(localk, new String[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(65267);
      return true;
      com.tencent.mm.modelstat.b.mcf.u(localca);
      break;
      label472:
      Log.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
      break label419;
      label483:
      if (!com.tencent.mm.plugin.ab.a.fmA().insert(localk)) {
        Log.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
      }
    }
  }
  
  public static void b(Button paramButton)
  {
    AppMethodBeat.i(65264);
    c(paramButton);
    AppMethodBeat.o(65264);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(293235);
    a(paramImageView, paramString1, paramString2, false);
    AppMethodBeat.o(293235);
  }
  
  public static void c(Button paramButton)
  {
    AppMethodBeat.i(65265);
    if (paramButton == null)
    {
      AppMethodBeat.o(65265);
      return;
    }
    paramButton.setBackgroundResource(a.e.festival_lucky_money_open_btn_ani);
    paramButton = (AnimationDrawable)paramButton.getBackground();
    if (paramButton != null) {
      paramButton.start();
    }
    AppMethodBeat.o(65265);
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
  
  public static void e(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(256715);
    if (paramImageView == null)
    {
      AppMethodBeat.o(256715);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      com.tencent.mm.plugin.luckymoney.b.a.eNR();
      ((c.a)localObject).prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eNV();
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).kOl = true;
      ((c.a)localObject).kPz = true;
      ((c.a)localObject).lRG = 1;
      if (paramInt != 0) {
        ((c.a)localObject).lRP = paramInt;
      }
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(paramString, paramImageView, (com.tencent.mm.ay.a.a.c)localObject);
    }
    AppMethodBeat.o(256715);
  }
  
  public static String eOH()
  {
    AppMethodBeat.i(65258);
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vhv, null);
    AppMethodBeat.o(65258);
    return str;
  }
  
  public static String fT(List<bh> paramList)
  {
    AppMethodBeat.i(65271);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
      AppMethodBeat.o(65271);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      bh localbh = (bh)paramList.get(i);
      if (localbh != null)
      {
        if (i != 0) {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(localbh.type);
        localStringBuilder.append("|");
        localStringBuilder.append(localbh.name);
      }
      i += 1;
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(65271);
    return paramList;
  }
  
  public static void fm(View paramView)
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
  
  public static int hr(Context paramContext)
  {
    AppMethodBeat.i(65261);
    if (EAN == 2147483647) {
      EAN = paramContext.getResources().getColor(a.c.lucky_money_err_color);
    }
    int i = EAN;
    AppMethodBeat.o(65261);
    return i;
  }
  
  public static Dialog hs(Context paramContext)
  {
    AppMethodBeat.i(65273);
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, 3, a.j.LuckyMoneyNoAnimDialog, paramContext.getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(65273);
    return paramContext;
  }
  
  public static void iN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65272);
    if ((!Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(paramString2)))
    {
      ca localca = new ca();
      localca.pJ(0);
      localca.Jm(paramString2);
      localca.setStatus(3);
      localca.setContent(paramString1);
      localca.setCreateTime(bq.z(paramString2, System.currentTimeMillis() / 1000L));
      localca.setType(10000);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(localca);
    }
    AppMethodBeat.o(65272);
  }
  
  public static void o(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65251);
    a(paramImageView, paramString, null, false);
    AppMethodBeat.o(65251);
  }
  
  public static String q(Context paramContext, long paramLong)
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
    paramContext = com.tencent.mm.pluginsdk.j.e.a(paramContext.getString(a.i.fmt_datetime, new Object[] { " " }), (Time)localObject).toString();
    AppMethodBeat.o(65247);
    return paramContext;
  }
  
  public static void r(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65248);
    a(paramImageView, paramString, null, true);
    AppMethodBeat.o(65248);
  }
  
  public static boolean uK(int paramInt)
  {
    AppMethodBeat.i(256738);
    boolean bool = ab.uK(paramInt);
    AppMethodBeat.o(256738);
    return bool;
  }
  
  public static void y(TextView paramTextView)
  {
    AppMethodBeat.i(163577);
    paramTextView.setShadowLayer(8.0F, 0.0F, 0.0F, MMApplicationContext.getContext().getResources().getColor(a.c.black_per30));
    AppMethodBeat.o(163577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ag
 * JD-Core Version:    0.7.0.1
 */