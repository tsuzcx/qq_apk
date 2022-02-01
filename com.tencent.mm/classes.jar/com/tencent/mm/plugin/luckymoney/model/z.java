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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.at.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.w;
import com.tencent.mm.wallet_core.d.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class z
{
  private static com.tencent.mm.b.f<String, Bitmap> rGD;
  public static int vBJ;
  
  static
  {
    AppMethodBeat.i(65274);
    vBJ = 2147483647;
    rGD = new com.tencent.mm.memory.a.b(10, z.class);
    AppMethodBeat.o(65274);
  }
  
  public static boolean Z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(65267);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.w("MicroMsg.LuckyMoneyUtil", bu.nullAsNil(paramString1) + ", " + bu.nullAsNil(paramString2));
      AppMethodBeat.o(65267);
      return false;
    }
    bv localbv = new bv();
    localbv.setContent(paramString1);
    localbv.setStatus(2);
    localbv.ui(paramString2);
    localbv.qN(bl.BQ(paramString2));
    localbv.kt(1);
    if (paramInt == 3) {
      localbv.setType(469762097);
    }
    long l;
    for (;;)
    {
      l = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(localbv);
      if (l >= 0L) {
        break;
      }
      ae.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.f.abr() + "insert msg failed :" + l);
      AppMethodBeat.o(65267);
      return false;
      localbv.setType(436207665);
    }
    com.tencent.mm.ah.k localk;
    if (localbv.cVH())
    {
      com.tencent.mm.modelstat.b.iqT.b(localbv, com.tencent.mm.ah.l.r(localbv));
      localbv.setMsgId(l);
      localk = new com.tencent.mm.ah.k();
      localk.field_xml = localbv.field_content;
      paramString2 = bu.aSA(paramString1);
      paramString1 = null;
      if (paramString2 != null)
      {
        paramString2 = k.b.aB(paramString2, localbv.field_reserved);
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
      if ((paramString1 != null) && (paramString1.type == 2001) && (paramString1.dmr == 1))
      {
        if ((TextUtils.isEmpty(paramString1.hEo)) || (TextUtils.isEmpty(paramString1.hEp)) || (paramString1.hEq <= 0)) {
          break label463;
        }
        ae.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
        paramString2 = new at();
        paramString2.dmD = new at.a();
        paramString2.dmD.dmF = paramString1.hEp;
        paramString2.dmD.dmE = paramString1.hEo;
        paramString2.dmD.dmG = paramString1.hEq;
        com.tencent.mm.sdk.b.a.IvT.l(paramString2);
      }
      label411:
      paramString1 = com.tencent.mm.plugin.s.a.dBh().yb(l);
      if ((paramString1 == null) || (paramString1.field_msgId != l)) {
        break label474;
      }
      com.tencent.mm.plugin.s.a.dBh().update(localk, new String[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(65267);
      return true;
      com.tencent.mm.modelstat.b.iqT.q(localbv);
      break;
      label463:
      ae.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
      break label411;
      label474:
      if (!com.tencent.mm.plugin.s.a.dBh().insert(localk)) {
        ae.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(l)));
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
        this.oWl.startAnimation(localScaleAnimation2);
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
    ae.i("MicroMsg.LuckyMoneyUtil", "load url: %s", new Object[] { paramString1 });
    if (paramImageView != null) {
      paramImageView.setImageBitmap(null);
    }
    c.a locala;
    if (!bu.isNullOrNil(paramString1))
    {
      locala = new c.a();
      com.tencent.mm.plugin.luckymoney.b.a.dkG();
      locala.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.dkI();
      locala.igk = true;
      locala.hgL = true;
      locala.hhW = paramBoolean;
      if (paramBoolean) {
        locala.igC = 0.0F;
      }
      if (bu.isNullOrNil(paramString2)) {
        break label128;
      }
      locala.md5 = paramString2;
    }
    label128:
    for (locala.igo = true;; locala.igo = false)
    {
      paramString2 = locala.aJu();
      q.aJb().a(paramString1, paramImageView, paramString2);
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
    ae.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
    if (paramInt1 != 416)
    {
      ae.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
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
        paramn = (bph)paramn.hQE.hQJ;
        if (paramn.HcQ != null) {
          paramn = com.tencent.mm.platformtools.z.b(paramn.HcQ);
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
        ae.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
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
        ae.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramBundle, parama, paramInt);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      catch (JSONException paramn)
      {
        ae.printErrStackTrace("MicroMsg.LuckyMoneyUtil", paramn, "", new Object[0]);
      }
      paramn = null;
      continue;
      label246:
      if (("2".equals(paramn)) && (!bu.isNullOrNil(str1)))
      {
        ae.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
        paramBoolean = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, (String)localObject, str1, str2, str3, paramBoolean, null);
        AppMethodBeat.o(65269);
        return paramBoolean;
      }
      ae.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + paramn + ";upload_credit_url=null?" + bu.isNullOrNil(str1));
      AppMethodBeat.o(65269);
      return false;
      label339:
      paramn = "";
    }
  }
  
  public static String aqa(String paramString)
  {
    AppMethodBeat.i(65259);
    Object localObject = p.aEN().DL(paramString);
    if (localObject != null)
    {
      paramString = ((com.tencent.mm.aj.i)localObject).aEH();
      AppMethodBeat.o(65259);
      return paramString;
    }
    g.ajS();
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if ((localObject == null) || (!((aw)localObject).field_username.equals(paramString)))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    if (((aw)localObject).eQU == 4)
    {
      AppMethodBeat.o(65259);
      return null;
    }
    g.ajS();
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUQ(paramString);
    if (bu.cF(paramString))
    {
      AppMethodBeat.o(65259);
      return null;
    }
    try
    {
      paramString = ((caj)new caj().parseFrom(paramString)).GnO;
      AppMethodBeat.o(65259);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[] { bu.o(paramString) });
        paramString = null;
      }
    }
  }
  
  public static String aqb(String paramString)
  {
    AppMethodBeat.i(65270);
    if ((bu.isNullOrNil(paramString)) || (!g.ajM()))
    {
      AppMethodBeat.o(65270);
      return "";
    }
    g.ajS();
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(String.format("%s/%s/", new Object[] { g.ajR().gDT, "LuckyMoney" }));
    if ((!localk.exists()) || (!localk.isDirectory())) {
      localk.mkdirs();
    }
    paramString = w.B(new com.tencent.mm.vfs.k(localk, paramString).fTh());
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
    if (!bu.isNullOrNil(paramString2)) {}
    for (;;)
    {
      a.b.a(paramImageView, paramString2, 0.1F, false);
      AppMethodBeat.o(65253);
      return;
      paramString2 = p.aEP().Dz(paramString1);
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
  
  public static String dlp()
  {
    AppMethodBeat.i(65258);
    g.ajS();
    String str = (String)g.ajR().ajA().get(am.a.ILu, null);
    AppMethodBeat.o(65258);
    return str;
  }
  
  public static void eq(View paramView)
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
  
  public static String ex(List<au> paramList)
  {
    AppMethodBeat.i(65271);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
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
  
  public static int fN(Context paramContext)
  {
    AppMethodBeat.i(65261);
    if (vBJ == 2147483647) {
      vBJ = paramContext.getResources().getColor(2131100566);
    }
    int i = vBJ;
    AppMethodBeat.o(65261);
    return i;
  }
  
  public static Dialog fO(Context paramContext)
  {
    AppMethodBeat.i(65273);
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, 3, 2131820985, paramContext.getString(2131760709), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(65273);
    return paramContext;
  }
  
  public static void hR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65272);
    if ((!bu.isNullOrNil(paramString1)) && (!bu.isNullOrNil(paramString2)))
    {
      bv localbv = new bv();
      localbv.kt(0);
      localbv.ui(paramString2);
      localbv.setStatus(3);
      localbv.setContent(paramString1);
      localbv.qN(bl.B(paramString2, System.currentTimeMillis() / 1000L));
      localbv.setType(10000);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(localbv);
    }
    AppMethodBeat.o(65272);
  }
  
  public static void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(65251);
    a(paramImageView, paramString, null, false);
    AppMethodBeat.o(65251);
  }
  
  public static void l(TextView paramTextView)
  {
    AppMethodBeat.i(163577);
    paramTextView.setShadowLayer(8.0F, 0.0F, 0.0F, ak.getContext().getResources().getColor(2131100019));
    AppMethodBeat.o(163577);
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
    paramContext = com.tencent.mm.pluginsdk.i.h.a(paramContext.getString(2131759500, new Object[] { " " }), (Time)localObject).toString();
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
    if (!bu.isNullOrNil(paramString))
    {
      Object localObject = new c.a();
      com.tencent.mm.plugin.luckymoney.b.a.dkG();
      ((c.a)localObject).prefixPath = com.tencent.mm.plugin.luckymoney.b.a.dkI();
      ((c.a)localObject).igk = true;
      ((c.a)localObject).hgL = true;
      ((c.a)localObject).hhW = true;
      ((c.a)localObject).ign = 1;
      ((c.a)localObject).igv = 2131232967;
      localObject = ((c.a)localObject).aJu();
      q.aJb().a(paramString, paramImageView, (c)localObject);
    }
    AppMethodBeat.o(65254);
  }
  
  public static String zO(String paramString)
  {
    AppMethodBeat.i(65260);
    g.ajS();
    an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if ((localan == null) || (!localan.field_username.equals(paramString)))
    {
      AppMethodBeat.o(65260);
      return null;
    }
    paramString = localan.field_nickname;
    AppMethodBeat.o(65260);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.z
 * JD-Core Version:    0.7.0.1
 */