package com.tencent.mm.plugin.luckymoney.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
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
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ag.i;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ak;
import com.tencent.mm.h.a.ak.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
{
  private static com.tencent.mm.a.f<String, Bitmap> kdO = new com.tencent.mm.a.f(10);
  public static int lQP = 2147483647;
  
  public static boolean C(String paramString1, String paramString2, int paramInt)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.w("MicroMsg.LuckyMoneyUtil", bk.pm(paramString1) + ", " + bk.pm(paramString2));
      return false;
    }
    bi localbi = new bi();
    localbi.setContent(paramString1);
    localbi.setStatus(2);
    localbi.ec(paramString2);
    localbi.bg(com.tencent.mm.model.bd.iK(paramString2));
    localbi.fA(1);
    if (paramInt == 3) {
      localbi.setType(469762097);
    }
    long l;
    for (;;)
    {
      l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T(localbi);
      if (l >= 0L) {
        break;
      }
      y.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.g.zI() + "insert msg failed :" + l);
      return false;
      localbi.setType(436207665);
    }
    com.tencent.mm.ae.g localg;
    if (localbi.aVK())
    {
      com.tencent.mm.modelstat.b.eBD.a(localbi, com.tencent.mm.ae.h.g(localbi));
      localbi.setMsgId(l);
      localg = new com.tencent.mm.ae.g();
      localg.field_xml = localbi.field_content;
      paramString2 = bk.ZQ(paramString1);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = g.a.M(paramString2, localbi.field_reserved);
        paramString1 = paramString2;
        if (paramString2 != null)
        {
          localg.field_title = paramString2.title;
          localg.field_description = paramString2.description;
          paramString1 = paramString2;
        }
      }
      localg.field_type = 2001;
      localg.field_msgId = l;
      if ((paramString1 != null) && (paramString1.type == 2001) && (paramString1.showType == 1))
      {
        if ((TextUtils.isEmpty(paramString1.dSl)) || (TextUtils.isEmpty(paramString1.dSm)) || (paramString1.dSn <= 0)) {
          break label443;
        }
        y.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
        paramString2 = new ak();
        paramString2.bGz = new ak.a();
        paramString2.bGz.bGB = paramString1.dSm;
        paramString2.bGz.bGA = paramString1.dSl;
        paramString2.bGz.bGC = paramString1.dSn;
        com.tencent.mm.sdk.b.a.udP.m(paramString2);
      }
      label396:
      paramString1 = com.tencent.mm.plugin.z.a.bro().gZ(l);
      if ((paramString1 == null) || (paramString1.field_msgId != l)) {
        break label454;
      }
      com.tencent.mm.plugin.z.a.bro().c(localg, new String[0]);
    }
    for (;;)
    {
      return true;
      com.tencent.mm.modelstat.b.eBD.f(localbi);
      break;
      label443:
      y.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
      break label396;
      label454:
      if (!com.tencent.mm.plugin.z.a.bro().b(localg)) {
        y.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:" + l);
      }
    }
  }
  
  public static String GN(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = com.tencent.mm.ag.o.Kh().kp(paramString);
    if (localObject1 != null) {
      localObject1 = ((com.tencent.mm.ag.h)localObject1).JY();
    }
    do
    {
      ad localad;
      do
      {
        do
        {
          do
          {
            return localObject1;
            com.tencent.mm.kernel.g.DQ();
            localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
            localObject1 = localObject2;
          } while (localad == null);
          localObject1 = localObject2;
        } while (!localad.field_username.equals(paramString));
        localObject1 = localObject2;
      } while (localad.cCq == 4);
      com.tencent.mm.kernel.g.DQ();
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abp(paramString);
      localObject1 = localObject2;
    } while (bk.bE(paramString));
    try
    {
      paramString = ((axd)new axd().aH(paramString)).sLE;
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[] { bk.j(paramString) });
        paramString = null;
      }
    }
  }
  
  public static String GO(String paramString)
  {
    if ((bk.bl(paramString)) || (!com.tencent.mm.kernel.g.DK())) {
      return "";
    }
    com.tencent.mm.kernel.g.DQ();
    File localFile = new File(String.format("%s/%s/", new Object[] { com.tencent.mm.kernel.g.DP().dKt, "LuckyMoney" }));
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    return new File(localFile, paramString).getAbsolutePath();
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(paramContext, paramString, paramTextView.getTextSize()));
  }
  
  public static void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.0F, 0.96F, 0.0F, 0.96F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(300L);
    localScaleAnimation1.setInterpolator(new OvershootInterpolator());
    localScaleAnimation1.setFillAfter(true);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setFillAfter(true);
    localScaleAnimation1.setAnimationListener(new o.1(paramView, localScaleAnimation2));
    if (paramAnimationListener != null) {
      localScaleAnimation2.setAnimationListener(paramAnimationListener);
    }
    if (paramView != null) {
      paramView.startAnimation(localScaleAnimation1);
    }
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2)
  {
    if (paramImageView == null) {
      return;
    }
    if (!bk.bl(paramString2)) {}
    for (;;)
    {
      a.b.a(paramImageView, paramString2, 0.1F, false);
      return;
      paramString2 = com.tencent.mm.ag.o.Kj().ke(paramString1);
    }
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    com.tencent.mm.as.a.a.c.a locala;
    if (paramImageView != null)
    {
      paramImageView.setImageBitmap(null);
      if (!bk.bl(paramString1))
      {
        locala = new com.tencent.mm.as.a.a.c.a();
        com.tencent.mm.plugin.luckymoney.a.a.bfg();
        locala.eri = com.tencent.mm.plugin.luckymoney.a.a.bfi();
        locala.erf = true;
        locala.erC = true;
        locala.erD = paramBoolean;
        if (paramBoolean) {
          locala.erE = 0.0F;
        }
        if (bk.bl(paramString2)) {
          break label100;
        }
        locala.bIW = paramString2;
      }
    }
    label100:
    for (locala.ern = true;; locala.ern = false)
    {
      paramString2 = locala.OV();
      com.tencent.mm.as.o.ON().a(paramString1, paramImageView, paramString2);
      return;
    }
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 == 0) && (paramInt2 > 1))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramMMActivity, SelectLuckyMoneyContactUI.class);
      localIntent.putExtra("key_friends_num", paramInt2);
      if (paramBoolean) {
        localIntent.putExtra("scene_from", 5);
      }
      paramMMActivity.startActivityForResult(localIntent, 2);
      return;
    }
    a(paramMMActivity, 2, paramBoolean);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("Select_Conv_Type", 3);
    if (paramBoolean) {
      localIntent.putExtra("scene_from", 5);
    }
    d.c(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt);
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, m paramm, Bundle paramBundle, boolean paramBoolean, com.tencent.mm.wallet_core.c.a parama, int paramInt2)
  {
    y.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
    if (paramInt1 != 416)
    {
      y.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
      return false;
    }
    return a(paramActivity, paramm, paramBundle, paramBoolean, parama, paramInt2);
  }
  
  private static boolean a(Activity paramActivity, m paramm, Bundle paramBundle, boolean paramBoolean, com.tencent.mm.wallet_core.c.a parama, int paramInt)
  {
    Object localObject = "";
    String str2 = "";
    String str3 = "";
    String str1 = "";
    if ((paramm != null) && ((paramm instanceof q)))
    {
      paramm = ((q)paramm).dmK;
      if (paramm != null)
      {
        paramm = (apj)paramm.ecF.ecN;
        if (paramm.tls != null) {
          paramm = com.tencent.mm.platformtools.aa.b(paramm.tls);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramm = new JSONObject(paramm);
        if (paramm == null) {
          break label311;
        }
        y.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
        localObject = paramm;
        if (paramm.has("real_name_info")) {
          localObject = paramm.optJSONObject("real_name_info");
        }
        paramm = ((JSONObject)localObject).optString("guide_flag", "");
        String str4 = ((JSONObject)localObject).optString("guide_wording");
        str2 = ((JSONObject)localObject).optString("left_button_wording", paramActivity.getString(a.i.app_cancel));
        str3 = ((JSONObject)localObject).optString("right_button_wording", paramActivity.getString(a.i.app_ok));
        str1 = ((JSONObject)localObject).optString("upload_credit_url", "");
        localObject = str4;
        if (!"1".equals(paramm)) {
          break label232;
        }
        y.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramBundle, parama, paramInt);
      }
      catch (JSONException paramm)
      {
        y.printErrStackTrace("MicroMsg.LuckyMoneyUtil", paramm, "", new Object[0]);
      }
      paramm = null;
      continue;
      label232:
      if (("2".equals(paramm)) && (!bk.bl(str1)))
      {
        y.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, (String)localObject, str1, str2, str3, paramBoolean, null);
      }
      y.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + paramm + ";upload_credit_url=null?" + bk.bl(str1));
      return false;
      label311:
      paramm = "";
    }
  }
  
  public static Bitmap aJ(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      localObject = (Bitmap)kdO.get(paramString);
      if (localObject != null) {
        return localObject;
      }
    }
    if (!com.tencent.mm.compatible.util.f.zF())
    {
      y.e("MicroMsg.LuckyMoneyUtil", "sdcard is not avail!");
      return BitmapFactory.decodeResource(ae.getContext().getResources(), a.e.nosdcard_chatting_bg);
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    int i;
    int j;
    if ((com.tencent.mm.sdk.platformtools.aa.bD(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!com.tencent.mm.sdk.platformtools.aa.bC(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
        break label190;
      }
      j = 1;
    }
    for (;;)
    {
      label145:
      if ((i != 0) || (j != 0))
      {
        i = ((BitmapFactory.Options)localObject).outHeight;
        j = ((BitmapFactory.Options)localObject).outWidth;
        for (;;)
        {
          if (j * i > 2764800)
          {
            j >>= 1;
            i >>= 1;
            continue;
            i = 0;
            break;
            label190:
            j = 0;
            break label145;
          }
        }
        j = Math.max(1, j);
        i = Math.max(1, i);
        y.w("MicroMsg.LuckyMoneyUtil", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int m = BackwardSupportUtil.ExifHelper.YS(paramString);
      if ((m == 90) || (m == 270)) {}
      for (;;)
      {
        if ((MMNativeJpeg.IsJpegFile(paramString)) && (MMNativeJpeg.isProgressive(paramString)))
        {
          localObject = MMNativeJpeg.decodeAsBitmap(paramString);
          if (localObject == null) {
            y.i("MicroMsg.LuckyMoneyUtil", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
          }
        }
        for (;;)
        {
          if (localObject != null) {
            break label368;
          }
          y.e("MicroMsg.LuckyMoneyUtil", "getSuitableBmp fail, temBmp is null, filePath = " + paramString);
          return null;
          bool = false;
          break;
          localObject = com.tencent.mm.sdk.platformtools.c.e(paramString, j, i, false);
        }
        label368:
        localBitmap = com.tencent.mm.sdk.platformtools.c.b((Bitmap)localObject, m);
        localObject = localBitmap;
        if (!paramBoolean) {
          break;
        }
        kdO.put(paramString, localBitmap);
        return localBitmap;
        int k = j;
        j = i;
        i = k;
      }
      i = 960;
      j = 960;
    }
  }
  
  public static void b(Button paramButton)
  {
    c(paramButton);
  }
  
  public static String bL(List<ai> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      y.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      ai localai = (ai)paramList.get(i);
      if (localai != null)
      {
        if (i != 0) {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(localai.type);
        localStringBuilder.append("|");
        localStringBuilder.append(localai.name);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String bfL()
  {
    com.tencent.mm.kernel.g.DQ();
    return (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uoA, null);
  }
  
  public static void c(Button paramButton)
  {
    if (paramButton == null) {}
    do
    {
      return;
      paramButton.setBackgroundResource(a.e.festival_lucky_money_open_btn_ani);
      paramButton = (AnimationDrawable)paramButton.getBackground();
    } while (paramButton == null);
    paramButton.start();
  }
  
  public static void d(Button paramButton)
  {
    if (paramButton == null) {}
    do
    {
      do
      {
        return;
      } while (!(paramButton.getBackground() instanceof AnimationDrawable));
      paramButton = (AnimationDrawable)paramButton.getBackground();
    } while (paramButton == null);
    paramButton.stop();
  }
  
  public static void d(ImageView paramImageView, String paramString, int paramInt)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      paramImageView.setImageBitmap(null);
    } while (bk.bl(paramString));
    Object localObject = new com.tencent.mm.as.a.a.c.a();
    com.tencent.mm.plugin.luckymoney.a.a.bfg();
    ((com.tencent.mm.as.a.a.c.a)localObject).eri = com.tencent.mm.plugin.luckymoney.a.a.bfi();
    ((com.tencent.mm.as.a.a.c.a)localObject).erf = true;
    ((com.tencent.mm.as.a.a.c.a)localObject).erC = true;
    ((com.tencent.mm.as.a.a.c.a)localObject).erD = false;
    if (paramInt != 0) {
      ((com.tencent.mm.as.a.a.c.a)localObject).eru = paramInt;
    }
    localObject = ((com.tencent.mm.as.a.a.c.a)localObject).OV();
    com.tencent.mm.as.o.ON().a(paramString, paramImageView, (com.tencent.mm.as.a.a.c)localObject);
  }
  
  public static int dI(Context paramContext)
  {
    if (lQP == 2147483647) {
      lQP = paramContext.getResources().getColor(a.c.lucky_money_err_color);
    }
    return lQP;
  }
  
  public static void dL(String paramString1, String paramString2)
  {
    if ((!bk.bl(paramString1)) && (!bk.bl(paramString2)))
    {
      bi localbi = new bi();
      localbi.fA(0);
      localbi.ec(paramString2);
      localbi.setStatus(3);
      localbi.setContent(paramString1);
      localbi.bg(com.tencent.mm.model.bd.o(paramString2, System.currentTimeMillis() / 1000L));
      localbi.setType(10000);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T(localbi);
    }
  }
  
  public static void e(ImageView paramImageView, String paramString, int paramInt)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      paramImageView.setImageBitmap(null);
    } while (bk.bl(paramString));
    Object localObject = new com.tencent.mm.as.a.a.c.a();
    com.tencent.mm.plugin.luckymoney.a.a.bfg();
    ((com.tencent.mm.as.a.a.c.a)localObject).eri = com.tencent.mm.plugin.luckymoney.a.a.bfi();
    ((com.tencent.mm.as.a.a.c.a)localObject).erf = true;
    ((com.tencent.mm.as.a.a.c.a)localObject).erC = true;
    ((com.tencent.mm.as.a.a.c.a)localObject).erD = true;
    ((com.tencent.mm.as.a.a.c.a)localObject).erk = 1;
    if (paramInt != 0) {
      ((com.tencent.mm.as.a.a.c.a)localObject).eru = paramInt;
    }
    localObject = ((com.tencent.mm.as.a.a.c.a)localObject).OV();
    com.tencent.mm.as.o.ON().a(paramString, paramImageView, (com.tencent.mm.as.a.a.c)localObject);
  }
  
  public static void g(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, null, false);
  }
  
  public static String gU(String paramString)
  {
    com.tencent.mm.kernel.g.DQ();
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
    if ((localad == null) || (!localad.field_username.equals(paramString))) {
      return null;
    }
    return localad.field_nickname;
  }
  
  public static String i(Context paramContext, long paramLong)
  {
    Object localObject = new GregorianCalendar();
    if (paramLong < 3600000L) {
      return "";
    }
    long l = paramLong - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L)) {
      return new SimpleDateFormat("HH:mm:ss").format(new Date(paramLong));
    }
    localObject = new Time();
    ((Time)localObject).set(paramLong);
    return com.tencent.mm.pluginsdk.f.g.a(paramContext.getString(a.i.fmt_datetime, new Object[] { " " }), (Time)localObject).toString();
  }
  
  public static void i(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.o
 * JD-Core Version:    0.7.0.1
 */