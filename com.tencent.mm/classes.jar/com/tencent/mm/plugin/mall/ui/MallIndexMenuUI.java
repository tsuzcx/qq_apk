package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ut;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.mmdata.rpt.rn;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.ecl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.i;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class MallIndexMenuUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private static final String KKT;
  private int KJh;
  private List<ecl> KLp;
  private HashMap<String, eck> KLq;
  private boolean KLr;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(262466);
    KKT = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf1";
    AppMethodBeat.o(262466);
  }
  
  public MallIndexMenuUI()
  {
    AppMethodBeat.i(66069);
    this.KLq = new HashMap();
    AppMethodBeat.o(66069);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66074);
    if (paramInt1 == 1)
    {
      com.tencent.mm.kernel.h.baF();
      this.KJh = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (z.bBj())
        {
          finish();
          AppMethodBeat.o(66074);
          return;
        }
        finish();
        paramIntent = new ut();
        paramIntent.hYw.context = getContext();
        paramIntent.publish();
      }
    }
    AppMethodBeat.o(66074);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66070);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    this.KLr = getIntent().getBooleanExtra("key_default_show_currency", false);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acUB, Boolean.FALSE);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66068);
        MallIndexMenuUI.this.finish();
        AppMethodBeat.o(66068);
        return true;
      }
    });
    this.screen = getPreferenceScreen();
    setMMTitle(a.i.mall_menu_ui_title);
    com.tencent.mm.kernel.h.aZW().a(1754, this);
    paramBundle = new com.tencent.mm.plugin.mall.a.h();
    com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
    AppMethodBeat.o(66070);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66071);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(1754, this);
    AppMethodBeat.o(66071);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(66072);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.MallIndexMenuUI", "onPreferenceTreeClick, key: %s", new Object[] { paramf });
    eck localeck = (eck)this.KLq.get(paramf);
    Object localObject;
    if (localeck != null)
    {
      paramf = new JSONObject();
      com.tencent.mm.kernel.h.baF();
      localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUA, "");
      if (Util.isNullOrNil((String)localObject)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        paramf = (com.tencent.mm.ui.base.preference.f)localObject;
        if (paramf.optInt(localeck.name, 0) != 1) {
          break label1221;
        }
        paramf.remove(localeck.name);
        paramf.remove(String.format("%s_expiretime", new Object[] { localeck.name }));
        if (paramf.length() > 0) {
          break label298;
        }
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUA, "");
        if ((paramPreference instanceof IconPreference))
        {
          ((IconPreference)paramPreference).aeD(8);
          ((IconPreference)paramPreference).afx(8);
          ((IconPreference)paramPreference).aBf(8);
          ((IconPreference)paramPreference).LF(false);
        }
        i = 1;
        switch (localeck.jump_type)
        {
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(66072);
          return true;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MallIndexMenuUI", localException, "parse redDotConfig json failed: %s", new Object[] { localException.getMessage() });
      }
      continue;
      label298:
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUA, paramf.toString());
      continue;
      Log.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", new Object[] { localeck.VsH });
      if (!Util.isNullOrNil(localeck.VsH)) {
        i.p(this, localeck.VsH, false);
      }
      paramf = com.tencent.mm.plugin.report.service.h.OAn;
      if (i != 0) {}
      for (int i = 1;; i = 0)
      {
        paramf.b(14872, new Object[] { Integer.valueOf(1), Integer.valueOf(i), localeck.VsH, "", Integer.valueOf(0) });
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", new Object[] { localeck.VcU, localeck.VcU });
      if (!Util.isNullOrNil(localeck.VcU))
      {
        paramf = new zp();
        paramf.icM.userName = localeck.VcU;
        paramf.icM.icO = Util.nullAs(localeck.VcV, "");
        paramf.icM.scene = 1066;
        paramf.icM.icP = 0;
        paramf.publish();
      }
      paramf = com.tencent.mm.plugin.report.service.h.OAn;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.b(14872, new Object[] { Integer.valueOf(2), Integer.valueOf(i), "", localeck.VcU, Integer.valueOf(0) });
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
      c.ai(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
      paramf = com.tencent.mm.plugin.report.service.h.OAn;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.b(14872, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
      paramf = new Intent();
      paramf.putExtra("wallet_lock_jsapi_scene", 1);
      c.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramf);
      paramf = com.tencent.mm.plugin.report.service.h.OAn;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.b(14872, new Object[] { Integer.valueOf(4), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        new rn();
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
      c.g(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      paramf = com.tencent.mm.plugin.report.service.h.OAn;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.b(14872, new Object[] { Integer.valueOf(5), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type honey pay");
      c.ai(this, "honey_pay", ".ui.HoneyPayMainUI");
      paramf = com.tencent.mm.plugin.report.service.h.OAn;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.b(14872, new Object[] { Integer.valueOf(8), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      if ("pay_my_msg".equals(paramf))
      {
        paramf = u.iiC().ijp();
        boolean bool;
        if ((paramf.VJX & 0x10000) > 0)
        {
          bool = true;
          Log.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramf.VJX) });
          if (!bool) {
            break label1030;
          }
          i.bC(this, "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
        }
        for (;;)
        {
          i.aGA(20);
          AppMethodBeat.o(66072);
          return true;
          bool = false;
          break;
          label1030:
          a.b(this, "ShowOrdersInfoProcess", null);
        }
      }
      if ("pay_manage".equals(paramf))
      {
        if (z.bBi()) {
          c.ai(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
        }
        for (;;)
        {
          i.aGA(21);
          AppMethodBeat.o(66072);
          return true;
          c.ai(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
        }
      }
      if ("pay_security".equals(paramf))
      {
        c.ai(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
        i.aGA(22);
        paramf = new rn();
        paramf.iPe = 11L;
        paramf.jvX = 1L;
        paramf.bMH();
      }
      do
      {
        AppMethodBeat.o(66072);
        return false;
        if ("pay_help_center".equals(paramf))
        {
          if (z.bBi()) {}
          for (paramf = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";; paramf = KKT)
          {
            i.bC(this, paramf);
            i.aGA(23);
            AppMethodBeat.o(66072);
            return true;
          }
        }
      } while (!"pay_wallet_switch".equals(paramf));
      c.g(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      AppMethodBeat.o(66072);
      return true;
      label1221:
      i = 0;
    }
  }
  
  /* Error */
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    // Byte code:
    //   0: ldc_w 504
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 243
    //   8: ldc_w 506
    //   11: iconst_2
    //   12: anewarray 247	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: iload_2
    //   25: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 252	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: iload_1
    //   33: ifne +7 -> 40
    //   36: iload_2
    //   37: ifeq +18 -> 55
    //   40: ldc 243
    //   42: ldc_w 508
    //   45: invokestatic 511	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 504
    //   51: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: aload 4
    //   57: checkcast 220	com/tencent/mm/plugin/mall/a/h
    //   60: getfield 515	com/tencent/mm/plugin/mall/a/h:KJl	Lcom/tencent/mm/protocal/protobuf/cpo;
    //   63: astore 9
    //   65: aload 9
    //   67: getfield 520	com/tencent/mm/protocal/protobuf/cpo:title	Ljava/lang/String;
    //   70: astore_3
    //   71: aload 9
    //   73: getfield 524	com/tencent/mm/protocal/protobuf/cpo:aawj	Ljava/util/LinkedList;
    //   76: astore 4
    //   78: aload 9
    //   80: getfield 524	com/tencent/mm/protocal/protobuf/cpo:aawj	Ljava/util/LinkedList;
    //   83: ifnull +772 -> 855
    //   86: aload 9
    //   88: getfield 524	com/tencent/mm/protocal/protobuf/cpo:aawj	Ljava/util/LinkedList;
    //   91: invokevirtual 529	java/util/LinkedList:size	()I
    //   94: istore_1
    //   95: ldc 243
    //   97: ldc_w 531
    //   100: iconst_3
    //   101: anewarray 247	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_3
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload 4
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: iload_1
    //   116: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aastore
    //   120: invokestatic 252	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: ldc 243
    //   125: ldc_w 533
    //   128: iconst_1
    //   129: anewarray 247	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload 9
    //   136: aastore
    //   137: invokestatic 252	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload 9
    //   142: ifnull +1365 -> 1507
    //   145: aload_0
    //   146: getfield 202	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   149: invokeinterface 538 1 0
    //   154: aload 9
    //   156: getfield 520	com/tencent/mm/protocal/protobuf/cpo:title	Ljava/lang/String;
    //   159: invokestatic 273	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   162: ifne +12 -> 174
    //   165: aload_0
    //   166: aload 9
    //   168: getfield 520	com/tencent/mm/protocal/protobuf/cpo:title	Ljava/lang/String;
    //   171: invokevirtual 540	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:setMMTitle	(Ljava/lang/String;)V
    //   174: new 259	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 260	org/json/JSONObject:<init>	()V
    //   181: astore_3
    //   182: invokestatic 85	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   185: pop
    //   186: invokestatic 89	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   189: invokevirtual 95	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   192: getstatic 263	com/tencent/mm/storage/at$a:acUA	Lcom/tencent/mm/storage/at$a;
    //   195: ldc_w 265
    //   198: invokevirtual 113	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: checkcast 267	java/lang/String
    //   204: astore 4
    //   206: aload 4
    //   208: invokestatic 273	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   211: ifne +651 -> 862
    //   214: new 259	org/json/JSONObject
    //   217: dup
    //   218: aload 4
    //   220: invokespecial 274	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   223: astore 4
    //   225: aload 4
    //   227: astore_3
    //   228: aload 9
    //   230: getfield 524	com/tencent/mm/protocal/protobuf/cpo:aawj	Ljava/util/LinkedList;
    //   233: ifnull +1228 -> 1461
    //   236: aload 9
    //   238: getfield 524	com/tencent/mm/protocal/protobuf/cpo:aawj	Ljava/util/LinkedList;
    //   241: invokevirtual 529	java/util/LinkedList:size	()I
    //   244: ifle +1217 -> 1461
    //   247: aload_0
    //   248: aload 9
    //   250: getfield 524	com/tencent/mm/protocal/protobuf/cpo:aawj	Ljava/util/LinkedList;
    //   253: putfield 542	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:KLp	Ljava/util/List;
    //   256: iconst_1
    //   257: istore_2
    //   258: aload 9
    //   260: getfield 524	com/tencent/mm/protocal/protobuf/cpo:aawj	Ljava/util/LinkedList;
    //   263: invokevirtual 546	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   266: astore 4
    //   268: iconst_0
    //   269: istore_1
    //   270: aload 4
    //   272: invokeinterface 551 1 0
    //   277: ifeq +1184 -> 1461
    //   280: aload 4
    //   282: invokeinterface 555 1 0
    //   287: checkcast 557	com/tencent/mm/protocal/protobuf/ecl
    //   290: astore 9
    //   292: aload 9
    //   294: getfield 560	com/tencent/mm/protocal/protobuf/ecl:UeP	Ljava/util/LinkedList;
    //   297: ifnull +1220 -> 1517
    //   300: aload 9
    //   302: getfield 560	com/tencent/mm/protocal/protobuf/ecl:UeP	Ljava/util/LinkedList;
    //   305: invokevirtual 529	java/util/LinkedList:size	()I
    //   308: ifle +1209 -> 1517
    //   311: iload_2
    //   312: ifne +31 -> 343
    //   315: aload 9
    //   317: getfield 561	com/tencent/mm/protocal/protobuf/ecl:title	Ljava/lang/String;
    //   320: invokestatic 273	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   323: ifeq +20 -> 343
    //   326: aload_0
    //   327: getfield 202	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   330: new 563	com/tencent/mm/ui/base/preference/PreferenceSmallCategory
    //   333: dup
    //   334: aload_0
    //   335: invokespecial 566	com/tencent/mm/ui/base/preference/PreferenceSmallCategory:<init>	(Landroid/content/Context;)V
    //   338: invokeinterface 570 2 0
    //   343: aload 9
    //   345: getfield 561	com/tencent/mm/protocal/protobuf/ecl:title	Ljava/lang/String;
    //   348: invokestatic 273	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   351: ifne +34 -> 385
    //   354: new 572	com/tencent/mm/ui/base/preference/PreferenceTitleCategory
    //   357: dup
    //   358: aload_0
    //   359: invokespecial 573	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:<init>	(Landroid/content/Context;)V
    //   362: astore 10
    //   364: aload 10
    //   366: aload 9
    //   368: getfield 561	com/tencent/mm/protocal/protobuf/ecl:title	Ljava/lang/String;
    //   371: invokevirtual 577	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:setTitle	(Ljava/lang/CharSequence;)V
    //   374: aload_0
    //   375: getfield 202	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   378: aload 10
    //   380: invokeinterface 570 2 0
    //   385: invokestatic 583	java/lang/System:currentTimeMillis	()J
    //   388: lstore 5
    //   390: aload 9
    //   392: getfield 560	com/tencent/mm/protocal/protobuf/ecl:UeP	Ljava/util/LinkedList;
    //   395: invokevirtual 546	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   398: astore 9
    //   400: aload 9
    //   402: invokeinterface 551 1 0
    //   407: ifeq +1049 -> 1456
    //   410: aload 9
    //   412: invokeinterface 555 1 0
    //   417: checkcast 257	com/tencent/mm/protocal/protobuf/eck
    //   420: astore 10
    //   422: ldc 243
    //   424: ldc_w 585
    //   427: iconst_1
    //   428: anewarray 247	java/lang/Object
    //   431: dup
    //   432: iconst_0
    //   433: aload 10
    //   435: getfield 277	com/tencent/mm/protocal/protobuf/eck:name	Ljava/lang/String;
    //   438: aastore
    //   439: invokestatic 252	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: new 587	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference
    //   445: dup
    //   446: aload_0
    //   447: invokespecial 588	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:<init>	(Landroid/content/Context;)V
    //   450: astore 11
    //   452: aload 10
    //   454: getfield 589	com/tencent/mm/protocal/protobuf/eck:title	Ljava/lang/String;
    //   457: invokestatic 273	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   460: ifne +13 -> 473
    //   463: aload 11
    //   465: aload 10
    //   467: getfield 589	com/tencent/mm/protocal/protobuf/eck:title	Ljava/lang/String;
    //   470: invokevirtual 590	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setTitle	(Ljava/lang/CharSequence;)V
    //   473: aload 10
    //   475: getfield 593	com/tencent/mm/protocal/protobuf/eck:desc	Ljava/lang/String;
    //   478: invokestatic 273	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   481: ifne +30 -> 511
    //   484: aload 11
    //   486: iconst_0
    //   487: invokevirtual 594	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aBf	(I)V
    //   490: aload 11
    //   492: aload 10
    //   494: getfield 593	com/tencent/mm/protocal/protobuf/eck:desc	Ljava/lang/String;
    //   497: iconst_m1
    //   498: aload_0
    //   499: invokevirtual 598	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getResources	()Landroid/content/res/Resources;
    //   502: getstatic 603	com/tencent/mm/plugin/wxpay/a$c:desc_text_color	I
    //   505: invokevirtual 609	android/content/res/Resources:getColor	(I)I
    //   508: invokevirtual 613	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:bd	(Ljava/lang/String;II)V
    //   511: aload 10
    //   513: getfield 616	com/tencent/mm/protocal/protobuf/eck:nQG	Ljava/lang/String;
    //   516: invokestatic 273	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   519: ifne +13 -> 532
    //   522: aload 11
    //   524: aload 10
    //   526: getfield 616	com/tencent/mm/protocal/protobuf/eck:nQG	Ljava/lang/String;
    //   529: putfield 619	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:iconUrl	Ljava/lang/String;
    //   532: aload 11
    //   534: aload 10
    //   536: getfield 277	com/tencent/mm/protocal/protobuf/eck:name	Ljava/lang/String;
    //   539: invokevirtual 622	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setKey	(Ljava/lang/String;)V
    //   542: aload_3
    //   543: ldc_w 287
    //   546: iconst_1
    //   547: anewarray 247	java/lang/Object
    //   550: dup
    //   551: iconst_0
    //   552: aload 10
    //   554: getfield 277	com/tencent/mm/protocal/protobuf/eck:name	Ljava/lang/String;
    //   557: aastore
    //   558: invokestatic 291	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   561: lconst_0
    //   562: invokevirtual 626	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   565: lstore 7
    //   567: ldc 243
    //   569: ldc_w 628
    //   572: iconst_1
    //   573: anewarray 247	java/lang/Object
    //   576: dup
    //   577: iconst_0
    //   578: lload 7
    //   580: invokestatic 633	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   583: aastore
    //   584: invokestatic 252	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   587: aload_3
    //   588: aload 10
    //   590: getfield 277	com/tencent/mm/protocal/protobuf/eck:name	Ljava/lang/String;
    //   593: iconst_0
    //   594: invokevirtual 281	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   597: iconst_1
    //   598: if_icmpne +267 -> 865
    //   601: iconst_1
    //   602: istore_2
    //   603: iload_2
    //   604: ifeq +910 -> 1514
    //   607: lload 7
    //   609: lconst_0
    //   610: lcmp
    //   611: ifle +903 -> 1514
    //   614: lload 5
    //   616: lload 7
    //   618: lcmp
    //   619: iflt +895 -> 1514
    //   622: ldc 243
    //   624: ldc_w 635
    //   627: invokestatic 380	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: iconst_0
    //   631: istore_2
    //   632: aload_3
    //   633: aload 10
    //   635: getfield 277	com/tencent/mm/protocal/protobuf/eck:name	Ljava/lang/String;
    //   638: iconst_0
    //   639: invokevirtual 639	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   642: pop
    //   643: iload_2
    //   644: ifeq +107 -> 751
    //   647: aload 10
    //   649: getfield 643	com/tencent/mm/protocal/protobuf/eck:abib	Lcom/tencent/mm/protocal/protobuf/eoe;
    //   652: ifnull +353 -> 1005
    //   655: ldc_w 645
    //   658: aload 10
    //   660: getfield 643	com/tencent/mm/protocal/protobuf/eck:abib	Lcom/tencent/mm/protocal/protobuf/eoe;
    //   663: getfield 650	com/tencent/mm/protocal/protobuf/eoe:type	Ljava/lang/String;
    //   666: invokevirtual 429	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   669: ifeq +228 -> 897
    //   672: aload 11
    //   674: iconst_0
    //   675: invokevirtual 594	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aBf	(I)V
    //   678: aload 11
    //   680: iconst_1
    //   681: invokevirtual 651	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:LF	(Z)V
    //   684: aload 10
    //   686: getfield 643	com/tencent/mm/protocal/protobuf/eck:abib	Lcom/tencent/mm/protocal/protobuf/eoe;
    //   689: getfield 654	com/tencent/mm/protocal/protobuf/eoe:wording	Ljava/lang/String;
    //   692: invokestatic 273	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   695: ifne +56 -> 751
    //   698: ldc 243
    //   700: ldc_w 656
    //   703: iconst_1
    //   704: anewarray 247	java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: aload 10
    //   711: getfield 643	com/tencent/mm/protocal/protobuf/eck:abib	Lcom/tencent/mm/protocal/protobuf/eoe;
    //   714: getfield 654	com/tencent/mm/protocal/protobuf/eoe:wording	Ljava/lang/String;
    //   717: aastore
    //   718: invokestatic 252	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   721: aload 11
    //   723: aload 10
    //   725: getfield 643	com/tencent/mm/protocal/protobuf/eck:abib	Lcom/tencent/mm/protocal/protobuf/eoe;
    //   728: getfield 654	com/tencent/mm/protocal/protobuf/eoe:wording	Ljava/lang/String;
    //   731: iconst_m1
    //   732: aload_0
    //   733: invokevirtual 598	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getResources	()Landroid/content/res/Resources;
    //   736: getstatic 603	com/tencent/mm/plugin/wxpay/a$c:desc_text_color	I
    //   739: invokevirtual 609	android/content/res/Resources:getColor	(I)I
    //   742: invokevirtual 613	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:bd	(Ljava/lang/String;II)V
    //   745: aload 11
    //   747: iconst_0
    //   748: invokevirtual 594	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aBf	(I)V
    //   751: aload 11
    //   753: bipush 8
    //   755: invokevirtual 659	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aBi	(I)V
    //   758: aload 10
    //   760: getfield 277	com/tencent/mm/protocal/protobuf/eck:name	Ljava/lang/String;
    //   763: invokestatic 273	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   766: ifne +248 -> 1014
    //   769: aload_0
    //   770: getfield 74	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:KLq	Ljava/util/HashMap;
    //   773: aload 10
    //   775: getfield 277	com/tencent/mm/protocal/protobuf/eck:name	Ljava/lang/String;
    //   778: aload 10
    //   780: invokevirtual 662	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   783: pop
    //   784: aload_0
    //   785: getfield 202	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   788: aload 11
    //   790: invokeinterface 570 2 0
    //   795: iload_1
    //   796: iconst_1
    //   797: iadd
    //   798: istore_1
    //   799: aload 10
    //   801: getfield 311	com/tencent/mm/protocal/protobuf/eck:jump_type	I
    //   804: tableswitch	default:+48 -> 852, 1:+261->1065, 2:+327->1131, 3:+393->1197, 4:+457->1261, 5:+521->1325, 6:+48->852, 7:+48->852, 8:+585->1389
    //   853: impdep1
    //   854: istore_1
    //   855: iconst_0
    //   856: istore_1
    //   857: goto -762 -> 95
    //   860: astore 4
    //   862: goto -634 -> 228
    //   865: iconst_0
    //   866: istore_2
    //   867: goto -264 -> 603
    //   870: astore 12
    //   872: ldc 243
    //   874: aload 12
    //   876: ldc_w 664
    //   879: iconst_1
    //   880: anewarray 247	java/lang/Object
    //   883: dup
    //   884: iconst_0
    //   885: aload 12
    //   887: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   890: aastore
    //   891: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   894: goto -251 -> 643
    //   897: ldc_w 666
    //   900: aload 10
    //   902: getfield 643	com/tencent/mm/protocal/protobuf/eck:abib	Lcom/tencent/mm/protocal/protobuf/eoe;
    //   905: getfield 650	com/tencent/mm/protocal/protobuf/eoe:type	Ljava/lang/String;
    //   908: invokevirtual 429	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   911: ifeq +27 -> 938
    //   914: aload 11
    //   916: aload_0
    //   917: getstatic 669	com/tencent/mm/plugin/wxpay/a$i:app_new	I
    //   920: invokevirtual 672	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getString	(I)Ljava/lang/String;
    //   923: getstatic 677	com/tencent/mm/plugin/wxpay/a$e:new_tips_bg	I
    //   926: invokevirtual 681	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:gv	(Ljava/lang/String;I)V
    //   929: aload 11
    //   931: iconst_0
    //   932: invokevirtual 682	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:afx	(I)V
    //   935: goto -251 -> 684
    //   938: ldc_w 684
    //   941: aload 10
    //   943: getfield 643	com/tencent/mm/protocal/protobuf/eck:abib	Lcom/tencent/mm/protocal/protobuf/eoe;
    //   946: getfield 650	com/tencent/mm/protocal/protobuf/eoe:type	Ljava/lang/String;
    //   949: invokevirtual 429	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   952: ifeq -268 -> 684
    //   955: aload 11
    //   957: new 33	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 685	java/lang/StringBuilder:<init>	()V
    //   964: aload 10
    //   966: getfield 643	com/tencent/mm/protocal/protobuf/eck:abib	Lcom/tencent/mm/protocal/protobuf/eoe;
    //   969: getfield 688	com/tencent/mm/protocal/protobuf/eoe:number	I
    //   972: invokevirtual 691	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   975: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: aload_0
    //   979: invokevirtual 138	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   982: aload 10
    //   984: getfield 643	com/tencent/mm/protocal/protobuf/eck:abib	Lcom/tencent/mm/protocal/protobuf/eoe;
    //   987: getfield 688	com/tencent/mm/protocal/protobuf/eoe:number	I
    //   990: invokestatic 696	com/tencent/mm/ui/tools/v:bC	(Landroid/content/Context;I)I
    //   993: invokevirtual 681	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:gv	(Ljava/lang/String;I)V
    //   996: aload 11
    //   998: iconst_0
    //   999: invokevirtual 682	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:afx	(I)V
    //   1002: goto -318 -> 684
    //   1005: aload 11
    //   1007: iconst_0
    //   1008: invokevirtual 697	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aeD	(I)V
    //   1011: goto -260 -> 751
    //   1014: aload_0
    //   1015: getfield 74	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:KLq	Ljava/util/HashMap;
    //   1018: new 33	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 685	java/lang/StringBuilder:<init>	()V
    //   1025: iload_1
    //   1026: invokevirtual 691	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1029: aload 10
    //   1031: getfield 277	com/tencent/mm/protocal/protobuf/eck:name	Ljava/lang/String;
    //   1034: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload 10
    //   1039: getfield 311	com/tencent/mm/protocal/protobuf/eck:jump_type	I
    //   1042: invokevirtual 691	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1045: aload 10
    //   1047: getfield 589	com/tencent/mm/protocal/protobuf/eck:title	Ljava/lang/String;
    //   1050: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: aload 10
    //   1058: invokevirtual 662	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1061: pop
    //   1062: goto -278 -> 784
    //   1065: getstatic 338	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1068: astore 11
    //   1070: iload_2
    //   1071: ifeq +55 -> 1126
    //   1074: iconst_1
    //   1075: istore_2
    //   1076: aload 11
    //   1078: sipush 14872
    //   1081: iconst_5
    //   1082: anewarray 247	java/lang/Object
    //   1085: dup
    //   1086: iconst_0
    //   1087: iconst_1
    //   1088: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1091: aastore
    //   1092: dup
    //   1093: iconst_1
    //   1094: iload_2
    //   1095: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1098: aastore
    //   1099: dup
    //   1100: iconst_2
    //   1101: aload 10
    //   1103: getfield 326	com/tencent/mm/protocal/protobuf/eck:VsH	Ljava/lang/String;
    //   1106: aastore
    //   1107: dup
    //   1108: iconst_3
    //   1109: ldc_w 265
    //   1112: aastore
    //   1113: dup
    //   1114: iconst_4
    //   1115: iconst_1
    //   1116: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1119: aastore
    //   1120: invokevirtual 341	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1123: goto -723 -> 400
    //   1126: iconst_0
    //   1127: istore_2
    //   1128: goto -52 -> 1076
    //   1131: getstatic 338	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1134: astore 11
    //   1136: iload_2
    //   1137: ifeq +55 -> 1192
    //   1140: iconst_1
    //   1141: istore_2
    //   1142: aload 11
    //   1144: sipush 14872
    //   1147: iconst_5
    //   1148: anewarray 247	java/lang/Object
    //   1151: dup
    //   1152: iconst_0
    //   1153: iconst_2
    //   1154: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1157: aastore
    //   1158: dup
    //   1159: iconst_1
    //   1160: iload_2
    //   1161: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1164: aastore
    //   1165: dup
    //   1166: iconst_2
    //   1167: ldc_w 265
    //   1170: aastore
    //   1171: dup
    //   1172: iconst_3
    //   1173: aload 10
    //   1175: getfield 346	com/tencent/mm/protocal/protobuf/eck:VcU	Ljava/lang/String;
    //   1178: aastore
    //   1179: dup
    //   1180: iconst_4
    //   1181: iconst_1
    //   1182: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1185: aastore
    //   1186: invokevirtual 341	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1189: goto -789 -> 400
    //   1192: iconst_0
    //   1193: istore_2
    //   1194: goto -52 -> 1142
    //   1197: getstatic 338	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1200: astore 10
    //   1202: iload_2
    //   1203: ifeq +53 -> 1256
    //   1206: iconst_1
    //   1207: istore_2
    //   1208: aload 10
    //   1210: sipush 14872
    //   1213: iconst_5
    //   1214: anewarray 247	java/lang/Object
    //   1217: dup
    //   1218: iconst_0
    //   1219: iconst_3
    //   1220: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1223: aastore
    //   1224: dup
    //   1225: iconst_1
    //   1226: iload_2
    //   1227: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1230: aastore
    //   1231: dup
    //   1232: iconst_2
    //   1233: ldc_w 265
    //   1236: aastore
    //   1237: dup
    //   1238: iconst_3
    //   1239: ldc_w 265
    //   1242: aastore
    //   1243: dup
    //   1244: iconst_4
    //   1245: iconst_1
    //   1246: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1249: aastore
    //   1250: invokevirtual 341	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1253: goto -853 -> 400
    //   1256: iconst_0
    //   1257: istore_2
    //   1258: goto -50 -> 1208
    //   1261: getstatic 338	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1264: astore 10
    //   1266: iload_2
    //   1267: ifeq +53 -> 1320
    //   1270: iconst_1
    //   1271: istore_2
    //   1272: aload 10
    //   1274: sipush 14872
    //   1277: iconst_5
    //   1278: anewarray 247	java/lang/Object
    //   1281: dup
    //   1282: iconst_0
    //   1283: iconst_4
    //   1284: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1287: aastore
    //   1288: dup
    //   1289: iconst_1
    //   1290: iload_2
    //   1291: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1294: aastore
    //   1295: dup
    //   1296: iconst_2
    //   1297: ldc_w 265
    //   1300: aastore
    //   1301: dup
    //   1302: iconst_3
    //   1303: ldc_w 265
    //   1306: aastore
    //   1307: dup
    //   1308: iconst_4
    //   1309: iconst_1
    //   1310: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1313: aastore
    //   1314: invokevirtual 341	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1317: goto -917 -> 400
    //   1320: iconst_0
    //   1321: istore_2
    //   1322: goto -50 -> 1272
    //   1325: getstatic 338	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1328: astore 10
    //   1330: iload_2
    //   1331: ifeq +53 -> 1384
    //   1334: iconst_1
    //   1335: istore_2
    //   1336: aload 10
    //   1338: sipush 14872
    //   1341: iconst_5
    //   1342: anewarray 247	java/lang/Object
    //   1345: dup
    //   1346: iconst_0
    //   1347: iconst_5
    //   1348: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1351: aastore
    //   1352: dup
    //   1353: iconst_1
    //   1354: iload_2
    //   1355: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1358: aastore
    //   1359: dup
    //   1360: iconst_2
    //   1361: ldc_w 265
    //   1364: aastore
    //   1365: dup
    //   1366: iconst_3
    //   1367: ldc_w 265
    //   1370: aastore
    //   1371: dup
    //   1372: iconst_4
    //   1373: iconst_1
    //   1374: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1377: aastore
    //   1378: invokevirtual 341	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1381: goto -981 -> 400
    //   1384: iconst_0
    //   1385: istore_2
    //   1386: goto -50 -> 1336
    //   1389: getstatic 338	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1392: astore 11
    //   1394: iload_2
    //   1395: ifeq +56 -> 1451
    //   1398: iconst_1
    //   1399: istore_2
    //   1400: aload 11
    //   1402: sipush 14872
    //   1405: iconst_5
    //   1406: anewarray 247	java/lang/Object
    //   1409: dup
    //   1410: iconst_0
    //   1411: bipush 8
    //   1413: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1416: aastore
    //   1417: dup
    //   1418: iconst_1
    //   1419: iload_2
    //   1420: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1423: aastore
    //   1424: dup
    //   1425: iconst_2
    //   1426: aload 10
    //   1428: getfield 326	com/tencent/mm/protocal/protobuf/eck:VsH	Ljava/lang/String;
    //   1431: aastore
    //   1432: dup
    //   1433: iconst_3
    //   1434: ldc_w 265
    //   1437: aastore
    //   1438: dup
    //   1439: iconst_4
    //   1440: iconst_1
    //   1441: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1444: aastore
    //   1445: invokevirtual 341	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1448: goto -596 -> 852
    //   1451: iconst_0
    //   1452: istore_2
    //   1453: goto -53 -> 1400
    //   1456: iconst_0
    //   1457: istore_2
    //   1458: goto -1188 -> 270
    //   1461: aload_3
    //   1462: invokevirtual 294	org/json/JSONObject:length	()I
    //   1465: ifle +42 -> 1507
    //   1468: ldc 243
    //   1470: ldc_w 699
    //   1473: iconst_1
    //   1474: anewarray 247	java/lang/Object
    //   1477: dup
    //   1478: iconst_0
    //   1479: aload_3
    //   1480: invokevirtual 321	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1483: aastore
    //   1484: invokestatic 252	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1487: invokestatic 85	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1490: pop
    //   1491: invokestatic 89	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1494: invokevirtual 95	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1497: getstatic 263	com/tencent/mm/storage/at$a:acUA	Lcom/tencent/mm/storage/at$a;
    //   1500: aload_3
    //   1501: invokevirtual 321	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1504: invokevirtual 189	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   1507: ldc_w 504
    //   1510: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1513: return
    //   1514: goto -871 -> 643
    //   1517: goto -59 -> 1458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1520	0	this	MallIndexMenuUI
    //   0	1520	1	paramInt1	int
    //   0	1520	2	paramInt2	int
    //   0	1520	3	paramString	String
    //   0	1520	4	paramp	com.tencent.mm.am.p
    //   388	227	5	l1	long
    //   565	52	7	l2	long
    //   63	348	9	localObject1	Object
    //   362	1065	10	localObject2	Object
    //   450	951	11	localObject3	Object
    //   870	16	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   214	225	860	org/json/JSONException
    //   632	643	870	java/lang/Exception
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexMenuUI
 * JD-Core Version:    0.7.0.1
 */