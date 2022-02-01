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
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.av.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.cpl;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.wallet_core.d.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class af
{
  private static com.tencent.mm.b.f<String, Bitmap> tgj;
  public static int yWJ;
  
  static
  {
    AppMethodBeat.i(65274);
    yWJ = 2147483647;
    tgj = new com.tencent.mm.memory.a.b(10, af.class);
    AppMethodBeat.o(65274);
  }
  
  public static boolean IA(String paramString)
  {
    AppMethodBeat.i(213314);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sae, false);
    Log.i("MicroMsg.LuckyMoneyUtil", "union luckymoney logic：OpenUnionLuckyMoney switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      bool = ab.IA(paramString);
      AppMethodBeat.o(213314);
      return bool;
    }
    AppMethodBeat.o(213314);
    return false;
  }
  
  public static String Ir(String paramString)
  {
    AppMethodBeat.i(65260);
    g.aAi();
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((localas == null) || (!localas.field_username.equals(paramString)))
    {
      AppMethodBeat.o(65260);
      return null;
    }
    paramString = localas.field_nickname;
    AppMethodBeat.o(65260);
    return paramString;
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
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setFillAfter(true);
    localScaleAnimation1.setAnimationListener(new af.2(paramView, localScaleAnimation2));
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
      paramString2 = p.aYD().Mj(paramString1);
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
      com.tencent.mm.plugin.luckymoney.b.a.eex();
      locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eeA();
      locala.jbf = true;
      locala.hZF = true;
      locala.iaT = paramBoolean;
      if (paramBoolean) {
        locala.jbx = 0.0F;
      }
      if (Util.isNullOrNil(paramString2)) {
        break label125;
      }
      locala.md5 = paramString2;
    }
    label125:
    for (locala.jbj = true;; locala.jbj = false)
    {
      paramString2 = locala.bdv();
      com.tencent.mm.av.q.bcV().a(paramString1, paramImageView, paramString2);
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
    com.tencent.mm.br.c.c(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    AppMethodBeat.o(65257);
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, com.tencent.mm.ak.q paramq, Bundle paramBundle, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener, d.a parama, int paramInt2)
  {
    AppMethodBeat.i(213313);
    Log.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
    if (paramInt1 != 416)
    {
      Log.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
      AppMethodBeat.o(213313);
      return false;
    }
    paramBoolean = a(paramActivity, paramq, paramBundle, paramBoolean, parama, paramInt2);
    AppMethodBeat.o(213313);
    return paramBoolean;
  }
  
  private static boolean a(Activity paramActivity, com.tencent.mm.ak.q paramq, Bundle paramBundle, boolean paramBoolean, d.a parama, int paramInt)
  {
    AppMethodBeat.i(65269);
    Object localObject = "";
    String str2 = "";
    String str3 = "";
    String str1 = "";
    if ((paramq != null) && ((paramq instanceof ah)))
    {
      paramq = ((ah)paramq).rr;
      if (paramq != null)
      {
        paramq = (cbz)paramq.iLL.iLR;
        if (paramq.MhT != null) {
          paramq = z.b(paramq.MhT);
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
        str2 = ((JSONObject)localObject).optString("left_button_wording", paramActivity.getString(2131755761));
        str3 = ((JSONObject)localObject).optString("right_button_wording", paramActivity.getString(2131755921));
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
  
  public static String aDw(String paramString)
  {
    AppMethodBeat.i(65259);
    Object localObject = p.aYB().Mx(paramString);
    if (localObject != null)
    {
      paramString = ((com.tencent.mm.aj.i)localObject).aYu();
      AppMethodBeat.o(65259);
      return paramString;
    }
    g.aAi();
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((localObject == null) || (!((ax)localObject).field_username.equals(paramString)))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    if (((ax)localObject).fuz == 4)
    {
      AppMethodBeat.o(65259);
      return null;
    }
    g.aAi();
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjP(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    try
    {
      paramString = ((cpl)new cpl().parseFrom(paramString)).Lis;
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
  
  public static String aDx(String paramString)
  {
    AppMethodBeat.i(65270);
    if ((Util.isNullOrNil(paramString)) || (!g.aAc()))
    {
      AppMethodBeat.o(65270);
      return "";
    }
    g.aAi();
    o localo = new o(String.format("%s/%s/", new Object[] { g.aAh().hqG, "LuckyMoney" }));
    if ((!localo.exists()) || (!localo.isDirectory())) {
      localo.mkdirs();
    }
    paramString = aa.z(new o(localo, paramString).her());
    AppMethodBeat.o(65270);
    return paramString;
  }
  
  public static boolean ac(String paramString1, String paramString2, int paramInt)
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
    localca.Cy(paramString2);
    localca.setCreateTime(bp.Kw(paramString2));
    localca.nv(1);
    if (paramInt == 3) {
      localca.setType(469762097);
    }
    long l;
    for (;;)
    {
      l = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
      if (l >= 0L) {
        break;
      }
      Log.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + l);
      AppMethodBeat.o(65267);
      return false;
      localca.setType(436207665);
    }
    k localk;
    if (localca.dOQ())
    {
      com.tencent.mm.modelstat.b.jmd.b(localca, com.tencent.mm.ag.l.t(localca));
      localca.setMsgId(l);
      localk = new k();
      localk.field_xml = localca.field_content;
      paramString2 = Util.processXml(paramString1);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.aD(paramString2, localca.field_reserved);
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
      if ((paramString1 != null) && (paramString1.type == 2001) && (paramString1.dDG == 1))
      {
        if ((TextUtils.isEmpty(paramString1.iyu)) || (TextUtils.isEmpty(paramString1.iyv)) || (paramString1.iyw <= 0)) {
          break label472;
        }
        Log.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
        paramString2 = new av();
        paramString2.dDS = new av.a();
        paramString2.dDS.dDU = paramString1.iyv;
        paramString2.dDS.dDT = paramString1.iyu;
        paramString2.dDS.dDV = paramString1.iyw;
        EventCenter.instance.publish(paramString2);
      }
      label419:
      paramString1 = com.tencent.mm.plugin.r.a.eAT().GL(l);
      if ((paramString1 == null) || (paramString1.field_msgId != l)) {
        break label483;
      }
      com.tencent.mm.plugin.r.a.eAT().update(localk, new String[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(65267);
      return true;
      com.tencent.mm.modelstat.b.jmd.s(localca);
      break;
      label472:
      Log.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
      break label419;
      label483:
      if (!com.tencent.mm.plugin.r.a.eAT().insert(localk)) {
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
    AppMethodBeat.i(258344);
    a(paramImageView, paramString1, paramString2, false);
    AppMethodBeat.o(258344);
  }
  
  public static void c(Button paramButton)
  {
    AppMethodBeat.i(65265);
    if (paramButton == null)
    {
      AppMethodBeat.o(65265);
      return;
    }
    paramButton.setBackgroundResource(2131232438);
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
  
  public static String efj()
  {
    AppMethodBeat.i(65258);
    g.aAi();
    String str = (String)g.aAh().azQ().get(ar.a.NTv, null);
    AppMethodBeat.o(65258);
    return str;
  }
  
  public static void eo(View paramView)
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
  
  public static String fr(List<bg> paramList)
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
      bg localbg = (bg)paramList.get(i);
      if (localbg != null)
      {
        if (i != 0) {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(localbg.type);
        localStringBuilder.append("|");
        localStringBuilder.append(localbg.name);
      }
      i += 1;
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(65271);
    return paramList;
  }
  
  public static int gt(Context paramContext)
  {
    AppMethodBeat.i(65261);
    if (yWJ == 2147483647) {
      yWJ = paramContext.getResources().getColor(2131100734);
    }
    int i = yWJ;
    AppMethodBeat.o(65261);
    return i;
  }
  
  public static Dialog gu(Context paramContext)
  {
    AppMethodBeat.i(65273);
    paramContext = h.a(paramContext, 3, 2131821007, paramContext.getString(2131762446), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(65273);
    return paramContext;
  }
  
  public static void iB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65272);
    if ((!Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(paramString2)))
    {
      ca localca = new ca();
      localca.nv(0);
      localca.Cy(paramString2);
      localca.setStatus(3);
      localca.setContent(paramString1);
      localca.setCreateTime(bp.C(paramString2, System.currentTimeMillis() / 1000L));
      localca.setType(10000);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
    }
    AppMethodBeat.o(65272);
  }
  
  public static String o(Context paramContext, long paramLong)
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
    paramContext = com.tencent.mm.pluginsdk.i.e.a(paramContext.getString(2131760815, new Object[] { " " }), (Time)localObject).toString();
    AppMethodBeat.o(65247);
    return paramContext;
  }
  
  public static void o(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65251);
    a(paramImageView, paramString, null, false);
    AppMethodBeat.o(65251);
  }
  
  public static void r(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65248);
    a(paramImageView, paramString, null, true);
    AppMethodBeat.o(65248);
  }
  
  public static boolean rQ(int paramInt)
  {
    AppMethodBeat.i(213315);
    boolean bool = ab.rQ(paramInt);
    AppMethodBeat.o(213315);
    return bool;
  }
  
  public static void s(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65254);
    if (paramImageView == null)
    {
      AppMethodBeat.o(65254);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      com.tencent.mm.plugin.luckymoney.b.a.eex();
      ((c.a)localObject).prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eeA();
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).hZF = true;
      ((c.a)localObject).iaT = true;
      ((c.a)localObject).jbi = 1;
      ((c.a)localObject).jbq = 2131233617;
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(paramString, paramImageView, (com.tencent.mm.av.a.a.c)localObject);
    }
    AppMethodBeat.o(65254);
  }
  
  public static void s(TextView paramTextView)
  {
    AppMethodBeat.i(163577);
    paramTextView.setShadowLayer(8.0F, 0.0F, 0.0F, MMApplicationContext.getContext().getResources().getColor(2131100045));
    AppMethodBeat.o(163577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.af
 * JD-Core Version:    0.7.0.1
 */