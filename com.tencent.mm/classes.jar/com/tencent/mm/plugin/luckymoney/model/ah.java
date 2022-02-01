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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.bd;
import com.tencent.mm.autogen.a.bd.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;
import com.tencent.mm.wallet_core.e.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ah
{
  private static com.tencent.mm.b.f<String, Bitmap> AiW;
  private static HashMap<String, Long> KtJ;
  public static int KtK;
  
  static
  {
    AppMethodBeat.i(65274);
    KtJ = new HashMap();
    KtK = 2147483647;
    AiW = new com.tencent.mm.memory.a.b(10, ah.class);
    AppMethodBeat.o(65274);
  }
  
  public static String ID(String paramString)
  {
    AppMethodBeat.i(65260);
    h.baF();
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    if ((localau == null) || (!localau.field_username.equals(paramString)))
    {
      AppMethodBeat.o(65260);
      return null;
    }
    paramString = localau.field_nickname;
    AppMethodBeat.o(65260);
    return paramString;
  }
  
  public static boolean IH(String paramString)
  {
    AppMethodBeat.i(284001);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yXh, false);
    Log.i("MicroMsg.LuckyMoneyUtil", "union luckymoney logic：OpenUnionLuckyMoney switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      bool = ab.IH(paramString);
      AppMethodBeat.o(284001);
      return bool;
    }
    AppMethodBeat.o(284001);
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
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, paramString, paramTextView.getTextSize()));
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
        ah.this.startAnimation(localScaleAnimation2);
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
      paramString2 = q.bFG().LF(paramString1);
    }
  }
  
  private static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(65249);
    Log.i("MicroMsg.LuckyMoneyUtil", "load url: %s", new Object[] { paramString1 });
    if (paramImageView != null) {
      paramImageView.setImageBitmap(null);
    }
    com.tencent.mm.modelimage.loader.a.c.a locala;
    if (!Util.isNullOrNil(paramString1))
    {
      locala = new com.tencent.mm.modelimage.loader.a.c.a();
      com.tencent.mm.plugin.luckymoney.app.a.fWk();
      locala.prefixPath = com.tencent.mm.plugin.luckymoney.app.a.fWo();
      locala.oKp = true;
      locala.nqa = true;
      locala.nrc = paramBoolean;
      if (paramBoolean) {
        locala.oKI = 0.0F;
      }
      if (Util.isNullOrNil(paramString2)) {
        break label125;
      }
      locala.md5 = paramString2;
    }
    label125:
    for (locala.oKt = true;; locala.oKt = false)
    {
      paramString2 = locala.bKx();
      r.bKe().a(paramString1, paramImageView, paramString2);
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
    com.tencent.mm.br.c.d(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    AppMethodBeat.o(65257);
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, com.tencent.mm.am.p paramp, Bundle paramBundle, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener, e.a parama, int paramInt2)
  {
    AppMethodBeat.i(283985);
    Log.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
    if (paramInt1 != 416)
    {
      Log.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
      AppMethodBeat.o(283985);
      return false;
    }
    paramBoolean = a(paramActivity, paramp, paramBundle, paramBoolean, parama, paramInt2);
    AppMethodBeat.o(283985);
    return paramBoolean;
  }
  
  private static boolean a(Activity paramActivity, com.tencent.mm.am.p paramp, Bundle paramBundle, boolean paramBoolean, e.a parama, int paramInt)
  {
    AppMethodBeat.i(65269);
    Object localObject = "";
    String str2 = "";
    String str3 = "";
    String str1 = "";
    if ((paramp != null) && ((paramp instanceof aj)))
    {
      paramp = ((aj)paramp).rr;
      if (paramp != null)
      {
        paramp = (daj)c.c.b(paramp.otC);
        if (paramp.aaFS != null) {
          paramp = w.b(paramp.aaFS);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramp = new JSONObject(paramp);
        if (paramp == null) {
          break label339;
        }
        Log.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
        localObject = paramp;
        if (paramp.has("real_name_info")) {
          localObject = paramp.optJSONObject("real_name_info");
        }
        paramp = ((JSONObject)localObject).optString("guide_flag", "");
        String str4 = ((JSONObject)localObject).optString("guide_wording");
        str2 = ((JSONObject)localObject).optString("left_button_wording", paramActivity.getString(a.i.app_cancel));
        str3 = ((JSONObject)localObject).optString("right_button_wording", paramActivity.getString(a.i.app_ok));
        str1 = ((JSONObject)localObject).optString("upload_credit_url", "");
        localObject = str4;
        if (!"1".equals(paramp)) {
          break label246;
        }
        Log.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramBundle, parama, paramInt);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      catch (JSONException paramp)
      {
        Log.printErrStackTrace("MicroMsg.LuckyMoneyUtil", paramp, "", new Object[0]);
      }
      paramp = null;
      continue;
      label246:
      if (("2".equals(paramp)) && (!Util.isNullOrNil(str1)))
      {
        Log.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, (String)localObject, str1, str2, str3, paramBoolean, null);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      Log.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + paramp + ";upload_credit_url=null?" + Util.isNullOrNil(str1));
      AppMethodBeat.o(65269);
      return false;
      label339:
      paramp = "";
    }
  }
  
  public static long aKB(String paramString)
  {
    AppMethodBeat.i(283936);
    try
    {
      long l = ((Long)KtJ.get(paramString)).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.LuckyMoneyUtil", paramString, "", new Object[0]);
      return -1L;
    }
    finally
    {
      AppMethodBeat.o(283936);
    }
  }
  
  public static String aKC(String paramString)
  {
    AppMethodBeat.i(65259);
    Object localObject = q.bFE().LS(paramString);
    if (localObject != null)
    {
      paramString = ((j)localObject).bFx();
      AppMethodBeat.o(65259);
      return paramString;
    }
    h.baF();
    localObject = ((n)h.ax(n.class)).bzA().JE(paramString);
    if ((localObject == null) || (!((az)localObject).field_username.equals(paramString)))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    if (((az)localObject).jZY == 4)
    {
      AppMethodBeat.o(65259);
      return null;
    }
    h.baF();
    paramString = ((n)h.ax(n.class)).bzA().bxA(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    try
    {
      paramString = ((dph)new dph().parseFrom(paramString)).ZhP;
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
  
  public static String aKD(String paramString)
  {
    AppMethodBeat.i(65270);
    if ((Util.isNullOrNil(paramString)) || (!h.baz()))
    {
      AppMethodBeat.o(65270);
      return "";
    }
    h.baF();
    u localu = new u(String.format("%s/%s/", new Object[] { h.baE().mCJ, "LuckyMoney" }));
    if ((!localu.jKS()) || (!localu.isDirectory())) {
      localu.jKY();
    }
    paramString = com.tencent.mm.vfs.ah.v(new u(localu, paramString).jKT());
    AppMethodBeat.o(65270);
    return paramString;
  }
  
  public static boolean an(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(65267);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.w("MicroMsg.LuckyMoneyUtil", Util.nullAsNil(paramString1) + ", " + Util.nullAsNil(paramString2));
      AppMethodBeat.o(65267);
      return false;
    }
    cc localcc = new cc();
    localcc.setContent(paramString1);
    localcc.setStatus(2);
    localcc.BS(paramString2);
    localcc.setCreateTime(br.JN(paramString2));
    localcc.pI(1);
    if (paramInt == 3) {
      localcc.setType(469762097);
    }
    long l;
    for (;;)
    {
      l = ((n)h.ax(n.class)).gaZ().ba(localcc);
      if (l >= 0L) {
        break;
      }
      Log.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.f.aPX() + "insert msg failed :" + l);
      AppMethodBeat.o(65267);
      return false;
      localcc.setType(436207665);
    }
    com.tencent.mm.message.k localk;
    if (localcc.fxR())
    {
      com.tencent.mm.modelstat.b.oUZ.d(localcc, com.tencent.mm.message.l.v(localcc));
      localcc.setMsgId(l);
      localk = new com.tencent.mm.message.k();
      localk.field_xml = localcc.field_content;
      paramString2 = Util.processXml(paramString1);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.aP(paramString2, localcc.field_reserved);
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
      if ((paramString1 != null) && (paramString1.type == 2001) && (paramString1.hAN == 1))
      {
        if ((TextUtils.isEmpty(paramString1.nSO)) || (TextUtils.isEmpty(paramString1.nSP)) || (paramString1.nSQ <= 0)) {
          break label469;
        }
        Log.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
        paramString2 = new bd();
        paramString2.hBd = new bd.a();
        paramString2.hBd.hBf = paramString1.nSP;
        paramString2.hBd.hBe = paramString1.nSO;
        paramString2.hBd.hBg = paramString1.nSQ;
        paramString2.publish();
      }
      label416:
      paramString1 = com.tencent.mm.plugin.openapi.a.gxo().rI(l);
      if ((paramString1 == null) || (paramString1.field_msgId != l)) {
        break label480;
      }
      com.tencent.mm.plugin.openapi.a.gxo().update(localk, new String[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(65267);
      return true;
      com.tencent.mm.modelstat.b.oUZ.u(localcc);
      break;
      label469:
      Log.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
      break label416;
      label480:
      if (!com.tencent.mm.plugin.openapi.a.gxo().insert(localk)) {
        Log.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
      }
    }
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(369810);
    a(paramImageView, paramString1, paramString2, false);
    AppMethodBeat.o(369810);
  }
  
  public static void c(String paramString, Long paramLong)
  {
    AppMethodBeat.i(283933);
    try
    {
      KtJ.put(paramString, paramLong);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LuckyMoneyUtil", paramString, "", new Object[0]);
      }
    }
    finally
    {
      AppMethodBeat.o(283933);
    }
  }
  
  public static void e(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(283951);
    if (paramImageView == null)
    {
      AppMethodBeat.o(283951);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = new com.tencent.mm.modelimage.loader.a.c.a();
      com.tencent.mm.plugin.luckymoney.app.a.fWk();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).prefixPath = com.tencent.mm.plugin.luckymoney.app.a.fWo();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = true;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nqa = true;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nrc = true;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKs = 1;
      if (paramInt != 0) {
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKB = paramInt;
      }
      localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx();
      r.bKe().a(paramString, paramImageView, (com.tencent.mm.modelimage.loader.a.c)localObject);
    }
    AppMethodBeat.o(283951);
  }
  
  public static String fXi()
  {
    AppMethodBeat.i(65258);
    h.baF();
    String str = (String)h.baE().ban().get(at.a.acIP, null);
    AppMethodBeat.o(65258);
    return str;
  }
  
  public static boolean fXj()
  {
    AppMethodBeat.i(284005);
    if (((Integer)h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue() == 8)
    {
      AppMethodBeat.o(284005);
      return true;
    }
    AppMethodBeat.o(284005);
    return false;
  }
  
  public static boolean fXk()
  {
    AppMethodBeat.i(284006);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yXi, true);
    Log.i("MicroMsg.LuckyMoneyUtil", "openNewStyleConfig：%s ", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(284006);
    return bool;
  }
  
  public static void hZ(View paramView)
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
  
  public static int iM(Context paramContext)
  {
    AppMethodBeat.i(65261);
    if (KtK == 2147483647) {
      KtK = paramContext.getResources().getColor(a.c.lucky_money_err_color);
    }
    int i = KtK;
    AppMethodBeat.o(65261);
    return i;
  }
  
  public static Dialog iN(Context paramContext)
  {
    AppMethodBeat.i(65273);
    paramContext = com.tencent.mm.ui.base.k.a(paramContext, 3, a.j.LuckyMoneyNoAnimDialog, paramContext.getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(65273);
    return paramContext;
  }
  
  public static String iR(List<bi> paramList)
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
      bi localbi = (bi)paramList.get(i);
      if (localbi != null)
      {
        if (i != 0) {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(localbi.type);
        localStringBuilder.append("|");
        localStringBuilder.append(localbi.name);
      }
      i += 1;
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(65271);
    return paramList;
  }
  
  public static void kb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65272);
    if ((!Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(paramString2)))
    {
      cc localcc = new cc();
      localcc.pI(0);
      localcc.BS(paramString2);
      localcc.setStatus(3);
      localcc.setContent(paramString1);
      localcc.setCreateTime(br.D(paramString2, System.currentTimeMillis() / 1000L));
      localcc.setType(10000);
      ((n)h.ax(n.class)).gaZ().ba(localcc);
    }
    AppMethodBeat.o(65272);
  }
  
  public static void m(ImageView paramImageView)
  {
    AppMethodBeat.i(283972);
    n(paramImageView);
    AppMethodBeat.o(283972);
  }
  
  public static void n(ImageView paramImageView)
  {
    AppMethodBeat.i(283974);
    if (paramImageView == null)
    {
      AppMethodBeat.o(283974);
      return;
    }
    paramImageView.setImageResource(a.e.festival_lucky_money_open_btn_ani);
    paramImageView = (AnimationDrawable)paramImageView.getDrawable();
    if (paramImageView != null) {
      paramImageView.start();
    }
    AppMethodBeat.o(283974);
  }
  
  public static void o(ImageView paramImageView)
  {
    AppMethodBeat.i(283976);
    if (paramImageView == null)
    {
      AppMethodBeat.o(283976);
      return;
    }
    if (!(paramImageView.getDrawable() instanceof AnimationDrawable))
    {
      AppMethodBeat.o(283976);
      return;
    }
    paramImageView = (AnimationDrawable)paramImageView.getDrawable();
    if (paramImageView != null) {
      paramImageView.stop();
    }
    AppMethodBeat.o(283976);
  }
  
  public static void p(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65251);
    a(paramImageView, paramString, null, false);
    AppMethodBeat.o(65251);
  }
  
  public static String s(Context paramContext, long paramLong)
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
    paramContext = com.tencent.mm.pluginsdk.platformtools.e.a(paramContext.getString(a.i.fmt_datetime, new Object[] { " " }), (Time)localObject).toString();
    AppMethodBeat.o(65247);
    return paramContext;
  }
  
  public static void s(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65248);
    a(paramImageView, paramString, null, true);
    AppMethodBeat.o(65248);
  }
  
  public static boolean uX(int paramInt)
  {
    AppMethodBeat.i(284003);
    boolean bool = ab.uX(paramInt);
    AppMethodBeat.o(284003);
    return bool;
  }
  
  public static void z(TextView paramTextView)
  {
    AppMethodBeat.i(163577);
    paramTextView.setShadowLayer(8.0F, 0.0F, 0.0F, MMApplicationContext.getContext().getResources().getColor(a.c.black_per30));
    AppMethodBeat.o(163577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ah
 * JD-Core Version:    0.7.0.1
 */