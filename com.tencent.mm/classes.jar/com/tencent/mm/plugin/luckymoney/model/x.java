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
import com.tencent.mm.a.f;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ah.i;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.am.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class x
{
  private static f<String, Bitmap> myy;
  public static int ooF;
  
  static
  {
    AppMethodBeat.i(42386);
    ooF = 2147483647;
    myy = new com.tencent.mm.memory.a.b(10, x.class);
    AppMethodBeat.o(42386);
  }
  
  public static boolean J(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(42377);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.w("MicroMsg.LuckyMoneyUtil", bo.nullAsNil(paramString1) + ", " + bo.nullAsNil(paramString2));
      AppMethodBeat.o(42377);
      return false;
    }
    bi localbi = new bi();
    localbi.setContent(paramString1);
    localbi.setStatus(2);
    localbi.kj(paramString2);
    localbi.fQ(bf.py(paramString2));
    localbi.hL(1);
    if (paramInt == 3) {
      localbi.setType(469762097);
    }
    long l;
    for (;;)
    {
      l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z(localbi);
      if (l >= 0L) {
        break;
      }
      ab.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.g.Ml() + "insert msg failed :" + l);
      AppMethodBeat.o(42377);
      return false;
      localbi.setType(436207665);
    }
    com.tencent.mm.af.j localj;
    if (localbi.bCn())
    {
      com.tencent.mm.modelstat.b.fRu.a(localbi, com.tencent.mm.af.k.k(localbi));
      localbi.setMsgId(l);
      localj = new com.tencent.mm.af.j();
      localj.field_xml = localbi.field_content;
      paramString2 = bo.apU(paramString1);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = j.b.ab(paramString2, localbi.field_reserved);
        paramString1 = paramString2;
        if (paramString2 != null)
        {
          localj.field_title = paramString2.title;
          localj.field_description = paramString2.description;
          paramString1 = paramString2;
        }
      }
      localj.field_type = 2001;
      localj.field_msgId = l;
      if ((paramString1 != null) && (paramString1.type == 2001) && (paramString1.showType == 1))
      {
        if ((TextUtils.isEmpty(paramString1.fik)) || (TextUtils.isEmpty(paramString1.fil)) || (paramString1.fim <= 0)) {
          break label463;
        }
        ab.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
        paramString2 = new am();
        paramString2.cnM = new am.a();
        paramString2.cnM.cnO = paramString1.fil;
        paramString2.cnM.cnN = paramString1.fik;
        paramString2.cnM.cnP = paramString1.fim;
        com.tencent.mm.sdk.b.a.ymk.l(paramString2);
      }
      label411:
      paramString1 = com.tencent.mm.plugin.s.a.cad().nx(l);
      if ((paramString1 == null) || (paramString1.field_msgId != l)) {
        break label474;
      }
      com.tencent.mm.plugin.s.a.cad().update(localj, new String[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(42377);
      return true;
      com.tencent.mm.modelstat.b.fRu.j(localbi);
      break;
      label463:
      ab.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
      break label411;
      label474:
      if (!com.tencent.mm.plugin.s.a.cad().insert(localj)) {
        ab.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
      }
    }
  }
  
  public static String St(String paramString)
  {
    AppMethodBeat.i(42369);
    Object localObject = com.tencent.mm.ah.o.adg().rj(paramString);
    if (localObject != null)
    {
      paramString = ((com.tencent.mm.ah.h)localObject).acY();
      AppMethodBeat.o(42369);
      return paramString;
    }
    com.tencent.mm.kernel.g.RM();
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
    if ((localObject == null) || (!((aq)localObject).field_username.equals(paramString)))
    {
      AppMethodBeat.o(42369);
      return null;
    }
    if (((aq)localObject).dqB == 4)
    {
      AppMethodBeat.o(42369);
      return null;
    }
    com.tencent.mm.kernel.g.RM();
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arA(paramString);
    if (bo.ce(paramString))
    {
      AppMethodBeat.o(42369);
      return null;
    }
    try
    {
      paramString = ((bdt)new bdt().parseFrom(paramString)).wJr;
      AppMethodBeat.o(42369);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[] { bo.l(paramString) });
        paramString = null;
      }
    }
  }
  
  public static String Su(String paramString)
  {
    AppMethodBeat.i(42380);
    if ((bo.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.RG()))
    {
      AppMethodBeat.o(42380);
      return "";
    }
    com.tencent.mm.kernel.g.RM();
    File localFile = new File(String.format("%s/%s/", new Object[] { com.tencent.mm.kernel.g.RL().eHR, "LuckyMoney" }));
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    paramString = new File(localFile, paramString).getAbsolutePath();
    AppMethodBeat.o(42380);
    return paramString;
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42365);
    if (paramTextView == null)
    {
      AppMethodBeat.o(42365);
      return;
    }
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramString, paramTextView.getTextSize()));
    AppMethodBeat.o(42365);
  }
  
  public static void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(42373);
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.0F, 0.96F, 0.0F, 0.96F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(300L);
    localScaleAnimation1.setInterpolator(new OvershootInterpolator());
    localScaleAnimation1.setFillAfter(true);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setFillAfter(true);
    localScaleAnimation1.setAnimationListener(new x.2(paramView, localScaleAnimation2));
    if (paramAnimationListener != null) {
      localScaleAnimation2.setAnimationListener(paramAnimationListener);
    }
    if (paramView != null) {
      paramView.startAnimation(localScaleAnimation1);
    }
    AppMethodBeat.o(42373);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(42360);
    a(paramImageView, paramString1, paramString2, false);
    AppMethodBeat.o(42360);
  }
  
  private static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(42359);
    ab.i("MicroMsg.LuckyMoneyUtil", "load url: %s", new Object[] { paramString1 });
    if (paramImageView != null) {
      paramImageView.setImageBitmap(null);
    }
    com.tencent.mm.at.a.a.c.a locala;
    if (!bo.isNullOrNil(paramString1))
    {
      locala = new com.tencent.mm.at.a.a.c.a();
      com.tencent.mm.plugin.luckymoney.b.a.bMG();
      locala.eNP = com.tencent.mm.plugin.luckymoney.b.a.bMI();
      locala.eNM = true;
      locala.eOe = true;
      locala.eOk = paramBoolean;
      if (paramBoolean) {
        locala.eOl = 0.0F;
      }
      if (bo.isNullOrNil(paramString2)) {
        break label128;
      }
      locala.cqq = paramString2;
    }
    label128:
    for (locala.eNU = true;; locala.eNU = false)
    {
      paramString2 = locala.ahY();
      com.tencent.mm.at.o.ahG().a(paramString1, paramImageView, paramString2);
      AppMethodBeat.o(42359);
      return;
    }
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(42366);
    if ((paramInt1 == 0) && (paramInt2 > 1))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramMMActivity, SelectLuckyMoneyContactUI.class);
      localIntent.putExtra("key_friends_num", paramInt2);
      if (paramBoolean) {
        localIntent.putExtra("scene_from", 5);
      }
      paramMMActivity.startActivityForResult(localIntent, 2);
      AppMethodBeat.o(42366);
      return;
    }
    a(paramMMActivity, 2, paramBoolean);
    AppMethodBeat.o(42366);
  }
  
  public static void a(MMActivity paramMMActivity, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(42367);
    Intent localIntent = new Intent();
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("Select_Conv_Type", 3);
    if (paramBoolean) {
      localIntent.putExtra("scene_from", 5);
    }
    d.b(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    AppMethodBeat.o(42367);
  }
  
  public static boolean a(Activity paramActivity, int paramInt1, m paramm, Bundle paramBundle, boolean paramBoolean, com.tencent.mm.wallet_core.c.a parama, int paramInt2)
  {
    AppMethodBeat.i(42378);
    ab.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
    if (paramInt1 != 416)
    {
      ab.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
      AppMethodBeat.o(42378);
      return false;
    }
    paramBoolean = a(paramActivity, paramm, paramBundle, paramBoolean, parama, paramInt2);
    AppMethodBeat.o(42378);
    return paramBoolean;
  }
  
  private static boolean a(Activity paramActivity, m paramm, Bundle paramBundle, boolean paramBoolean, com.tencent.mm.wallet_core.c.a parama, int paramInt)
  {
    AppMethodBeat.i(42379);
    Object localObject = "";
    String str2 = "";
    String str3 = "";
    String str1 = "";
    if ((paramm != null) && ((paramm instanceof z)))
    {
      paramm = ((z)paramm).rr;
      if (paramm != null)
      {
        paramm = (avi)paramm.fsW.fta;
        if (paramm.xkL != null) {
          paramm = aa.b(paramm.xkL);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramm = new JSONObject(paramm);
        if (paramm == null) {
          break label339;
        }
        ab.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
        localObject = paramm;
        if (paramm.has("real_name_info")) {
          localObject = paramm.optJSONObject("real_name_info");
        }
        paramm = ((JSONObject)localObject).optString("guide_flag", "");
        String str4 = ((JSONObject)localObject).optString("guide_wording");
        str2 = ((JSONObject)localObject).optString("left_button_wording", paramActivity.getString(2131296888));
        str3 = ((JSONObject)localObject).optString("right_button_wording", paramActivity.getString(2131297018));
        str1 = ((JSONObject)localObject).optString("upload_credit_url", "");
        localObject = str4;
        if (!"1".equals(paramm)) {
          break label246;
        }
        ab.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramBundle, parama, paramInt);
        AppMethodBeat.o(42379);
        return paramBoolean;
      }
      catch (JSONException paramm)
      {
        ab.printErrStackTrace("MicroMsg.LuckyMoneyUtil", paramm, "", new Object[0]);
      }
      paramm = null;
      continue;
      label246:
      if (("2".equals(paramm)) && (!bo.isNullOrNil(str1)))
      {
        ab.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, (String)localObject, str1, str2, str3, paramBoolean, null);
        AppMethodBeat.o(42379);
        return paramBoolean;
      }
      ab.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + paramm + ";upload_credit_url=null?" + bo.isNullOrNil(str1));
      AppMethodBeat.o(42379);
      return false;
      label339:
      paramm = "";
    }
  }
  
  public static void b(Button paramButton)
  {
    AppMethodBeat.i(42374);
    c(paramButton);
    AppMethodBeat.o(42374);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(42363);
    if (paramImageView == null)
    {
      AppMethodBeat.o(42363);
      return;
    }
    if (!bo.isNullOrNil(paramString2)) {}
    for (;;)
    {
      a.b.a(paramImageView, paramString2, 0.1F, false);
      AppMethodBeat.o(42363);
      return;
      paramString2 = com.tencent.mm.ah.o.adi().qX(paramString1);
    }
  }
  
  public static String bNq()
  {
    AppMethodBeat.i(42368);
    com.tencent.mm.kernel.g.RM();
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyw, null);
    AppMethodBeat.o(42368);
    return str;
  }
  
  public static void c(Button paramButton)
  {
    AppMethodBeat.i(42375);
    if (paramButton == null)
    {
      AppMethodBeat.o(42375);
      return;
    }
    paramButton.setBackgroundResource(2130838853);
    paramButton = (AnimationDrawable)paramButton.getBackground();
    if (paramButton != null) {
      paramButton.start();
    }
    AppMethodBeat.o(42375);
  }
  
  public static String cj(List<as> paramList)
  {
    AppMethodBeat.i(42381);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
      AppMethodBeat.o(42381);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      as localas = (as)paramList.get(i);
      if (localas != null)
      {
        if (i != 0) {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(localas.type);
        localStringBuilder.append("|");
        localStringBuilder.append(localas.name);
      }
      i += 1;
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(42381);
    return paramList;
  }
  
  public static void d(Button paramButton)
  {
    AppMethodBeat.i(42376);
    if (paramButton == null)
    {
      AppMethodBeat.o(42376);
      return;
    }
    if (!(paramButton.getBackground() instanceof AnimationDrawable))
    {
      AppMethodBeat.o(42376);
      return;
    }
    paramButton = (AnimationDrawable)paramButton.getBackground();
    if (paramButton != null) {
      paramButton.stop();
    }
    AppMethodBeat.o(42376);
  }
  
  public static void dr(View paramView)
  {
    AppMethodBeat.i(42372);
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.4F, 0.96F, 0.4F, 0.96F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(200L);
    localScaleAnimation1.setInterpolator(new OvershootInterpolator());
    localScaleAnimation1.setFillAfter(true);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.96F, 1.0F, 0.96F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setFillAfter(true);
    localScaleAnimation1.setAnimationListener(new x.1(paramView, localScaleAnimation2));
    if (paramView != null) {
      paramView.startAnimation(localScaleAnimation1);
    }
    AppMethodBeat.o(42372);
  }
  
  public static int eu(Context paramContext)
  {
    AppMethodBeat.i(42371);
    if (ooF == 2147483647) {
      ooF = paramContext.getResources().getColor(2131690228);
    }
    int i = ooF;
    AppMethodBeat.o(42371);
    return i;
  }
  
  public static Dialog ev(Context paramContext)
  {
    AppMethodBeat.i(42385);
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, 3, 2131493306, paramContext.getString(2131301086), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(42385);
    return paramContext;
  }
  
  public static void fd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42382);
    if ((!bo.isNullOrNil(paramString1)) && (!bo.isNullOrNil(paramString2)))
    {
      bi localbi = new bi();
      localbi.hL(0);
      localbi.kj(paramString2);
      localbi.setStatus(3);
      localbi.setContent(paramString1);
      localbi.fQ(bf.x(paramString2, System.currentTimeMillis() / 1000L));
      localbi.setType(10000);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z(localbi);
    }
    AppMethodBeat.o(42382);
  }
  
  public static void i(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42361);
    a(paramImageView, paramString, null, false);
    AppMethodBeat.o(42361);
  }
  
  public static String j(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(42357);
    Object localObject = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(42357);
      return "";
    }
    long l = paramLong - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = new SimpleDateFormat("HH:mm").format(new Date(paramLong));
      AppMethodBeat.o(42357);
      return paramContext;
    }
    localObject = new Time();
    ((Time)localObject).set(paramLong);
    paramContext = com.tencent.mm.pluginsdk.f.g.a(paramContext.getString(2131300033, new Object[] { " " }), (Time)localObject).toString();
    AppMethodBeat.o(42357);
    return paramContext;
  }
  
  public static void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42358);
    a(paramImageView, paramString, null, true);
    AppMethodBeat.o(42358);
  }
  
  public static void m(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42362);
    if (paramImageView == null)
    {
      AppMethodBeat.o(42362);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!bo.isNullOrNil(paramString))
    {
      Object localObject = new com.tencent.mm.at.a.a.c.a();
      com.tencent.mm.plugin.luckymoney.b.a.bMG();
      ((com.tencent.mm.at.a.a.c.a)localObject).eNP = com.tencent.mm.plugin.luckymoney.b.a.bMI();
      ((com.tencent.mm.at.a.a.c.a)localObject).eNM = true;
      ((com.tencent.mm.at.a.a.c.a)localObject).eOe = true;
      ((com.tencent.mm.at.a.a.c.a)localObject).eOk = false;
      ((com.tencent.mm.at.a.a.c.a)localObject).eNY = 2130839424;
      localObject = ((com.tencent.mm.at.a.a.c.a)localObject).ahY();
      com.tencent.mm.at.o.ahG().a(paramString, paramImageView, (com.tencent.mm.at.a.a.c)localObject);
    }
    AppMethodBeat.o(42362);
  }
  
  public static void n(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42364);
    if (paramImageView == null)
    {
      AppMethodBeat.o(42364);
      return;
    }
    paramImageView.setImageBitmap(null);
    if (!bo.isNullOrNil(paramString))
    {
      Object localObject = new com.tencent.mm.at.a.a.c.a();
      com.tencent.mm.plugin.luckymoney.b.a.bMG();
      ((com.tencent.mm.at.a.a.c.a)localObject).eNP = com.tencent.mm.plugin.luckymoney.b.a.bMI();
      ((com.tencent.mm.at.a.a.c.a)localObject).eNM = true;
      ((com.tencent.mm.at.a.a.c.a)localObject).eOe = true;
      ((com.tencent.mm.at.a.a.c.a)localObject).eOk = true;
      ((com.tencent.mm.at.a.a.c.a)localObject).fHt = 1;
      ((com.tencent.mm.at.a.a.c.a)localObject).eNY = 2130839357;
      localObject = ((com.tencent.mm.at.a.a.c.a)localObject).ahY();
      com.tencent.mm.at.o.ahG().a(paramString, paramImageView, (com.tencent.mm.at.a.a.c)localObject);
    }
    AppMethodBeat.o(42364);
  }
  
  public static String nD(String paramString)
  {
    AppMethodBeat.i(42370);
    com.tencent.mm.kernel.g.RM();
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
    if ((localad == null) || (!localad.field_username.equals(paramString)))
    {
      AppMethodBeat.o(42370);
      return null;
    }
    paramString = localad.field_nickname;
    AppMethodBeat.o(42370);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x
 * JD-Core Version:    0.7.0.1
 */