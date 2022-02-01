package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.te;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.b.a.nv;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.g;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class MallIndexMenuUI
  extends MMPreference
  implements i
{
  private static final String EQv;
  private int EOJ;
  private List<dkb> EQR;
  private HashMap<String, dka> EQS;
  private boolean EQT;
  private com.tencent.mm.ui.base.preference.f screen;
  
  static
  {
    AppMethodBeat.i(186612);
    EQv = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf1";
    AppMethodBeat.o(186612);
  }
  
  public MallIndexMenuUI()
  {
    AppMethodBeat.i(66069);
    this.EQS = new HashMap();
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
      com.tencent.mm.kernel.h.aHH();
      this.EOJ = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (z.bdr())
        {
          finish();
          AppMethodBeat.o(66074);
          return;
        }
        finish();
        paramIntent = new te();
        paramIntent.fSz.context = getContext();
        EventCenter.instance.publish(paramIntent);
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
    this.EQT = getIntent().getBooleanExtra("key_default_show_currency", false);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsW, Boolean.FALSE);
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
    com.tencent.mm.kernel.h.aGY().a(1754, this);
    paramBundle = new com.tencent.mm.plugin.mall.a.h();
    com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
    AppMethodBeat.o(66070);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66071);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(1754, this);
    AppMethodBeat.o(66071);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(66072);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.MallIndexMenuUI", "onPreferenceTreeClick, key: %s", new Object[] { paramf });
    dka localdka = (dka)this.EQS.get(paramf);
    Object localObject;
    if (localdka != null)
    {
      paramf = new JSONObject();
      com.tencent.mm.kernel.h.aHH();
      localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VsV, "");
      if (Util.isNullOrNil((String)localObject)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        paramf = (com.tencent.mm.ui.base.preference.f)localObject;
        if (paramf.optInt(localdka.name, 0) != 1) {
          break label1224;
        }
        paramf.remove(localdka.name);
        paramf.remove(String.format("%s_expiretime", new Object[] { localdka.name }));
        if (paramf.length() > 0) {
          break label298;
        }
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsV, "");
        if ((paramPreference instanceof IconPreference))
        {
          ((IconPreference)paramPreference).aak(8);
          ((IconPreference)paramPreference).abe(8);
          ((IconPreference)paramPreference).auD(8);
          ((IconPreference)paramPreference).FT(false);
        }
        i = 1;
        switch (localdka.jump_type)
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
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsV, paramf.toString());
      continue;
      Log.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", new Object[] { localdka.ODt });
      if (!Util.isNullOrNil(localdka.ODt)) {
        g.p(this, localdka.ODt, false);
      }
      paramf = com.tencent.mm.plugin.report.service.h.IzE;
      if (i != 0) {}
      for (int i = 1;; i = 0)
      {
        paramf.a(14872, new Object[] { Integer.valueOf(1), Integer.valueOf(i), localdka.ODt, "", Integer.valueOf(0) });
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", new Object[] { localdka.Ooe, localdka.Ooe });
      if (!Util.isNullOrNil(localdka.Ooe))
      {
        paramf = new xw();
        paramf.fWN.userName = localdka.Ooe;
        paramf.fWN.fWP = Util.nullAs(localdka.Oof, "");
        paramf.fWN.scene = 1066;
        paramf.fWN.fWQ = 0;
        EventCenter.instance.publish(paramf);
      }
      paramf = com.tencent.mm.plugin.report.service.h.IzE;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.a(14872, new Object[] { Integer.valueOf(2), Integer.valueOf(i), "", localdka.Ooe, Integer.valueOf(0) });
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
      c.ad(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
      paramf = com.tencent.mm.plugin.report.service.h.IzE;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.a(14872, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
      paramf = new Intent();
      paramf.putExtra("wallet_lock_jsapi_scene", 1);
      c.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramf);
      paramf = com.tencent.mm.plugin.report.service.h.IzE;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.a(14872, new Object[] { Integer.valueOf(4), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        new nv();
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
      c.f(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      paramf = com.tencent.mm.plugin.report.service.h.IzE;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.a(14872, new Object[] { Integer.valueOf(5), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      Log.i("MicroMsg.MallIndexMenuUI", "jump type honey pay");
      c.ad(this, "honey_pay", ".ui.HoneyPayMainUI");
      paramf = com.tencent.mm.plugin.report.service.h.IzE;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.a(14872, new Object[] { Integer.valueOf(8), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      if ("pay_my_msg".equals(paramf))
      {
        paramf = u.gJo().gJY();
        boolean bool;
        if ((paramf.OTR & 0x10000) > 0)
        {
          bool = true;
          Log.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramf.OTR) });
          if (!bool) {
            break label1033;
          }
          g.bA(this, "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
        }
        for (;;)
        {
          g.azK(20);
          AppMethodBeat.o(66072);
          return true;
          bool = false;
          break;
          label1033:
          a.b(this, "ShowOrdersInfoProcess", null);
        }
      }
      if ("pay_manage".equals(paramf))
      {
        if (z.bdq()) {
          c.ad(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
        }
        for (;;)
        {
          g.azK(21);
          AppMethodBeat.o(66072);
          return true;
          c.ad(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
        }
      }
      if ("pay_security".equals(paramf))
      {
        c.ad(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
        g.azK(22);
        paramf = new nv();
        paramf.gCd = 11L;
        paramf.han = 1L;
        paramf.bpa();
      }
      do
      {
        AppMethodBeat.o(66072);
        return false;
        if ("pay_help_center".equals(paramf))
        {
          if (z.bdq()) {}
          for (paramf = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";; paramf = EQv)
          {
            g.bA(this, paramf);
            g.azK(23);
            AppMethodBeat.o(66072);
            return true;
          }
        }
      } while (!"pay_wallet_switch".equals(paramf));
      c.f(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      AppMethodBeat.o(66072);
      return true;
      label1224:
      i = 0;
    }
  }
  
  /* Error */
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    // Byte code:
    //   0: ldc_w 510
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 250
    //   8: ldc_w 512
    //   11: iconst_2
    //   12: anewarray 254	java/lang/Object
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
    //   29: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: iload_1
    //   33: ifne +7 -> 40
    //   36: iload_2
    //   37: ifeq +18 -> 55
    //   40: ldc 250
    //   42: ldc_w 514
    //   45: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 510
    //   51: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: aload 4
    //   57: checkcast 227	com/tencent/mm/plugin/mall/a/h
    //   60: getfield 521	com/tencent/mm/plugin/mall/a/h:EON	Lcom/tencent/mm/protocal/protobuf/caf;
    //   63: astore 9
    //   65: aload 9
    //   67: getfield 526	com/tencent/mm/protocal/protobuf/caf:title	Ljava/lang/String;
    //   70: astore_3
    //   71: aload 9
    //   73: getfield 530	com/tencent/mm/protocal/protobuf/caf:TiL	Ljava/util/LinkedList;
    //   76: astore 4
    //   78: aload 9
    //   80: getfield 530	com/tencent/mm/protocal/protobuf/caf:TiL	Ljava/util/LinkedList;
    //   83: ifnull +772 -> 855
    //   86: aload 9
    //   88: getfield 530	com/tencent/mm/protocal/protobuf/caf:TiL	Ljava/util/LinkedList;
    //   91: invokevirtual 535	java/util/LinkedList:size	()I
    //   94: istore_1
    //   95: ldc 250
    //   97: ldc_w 537
    //   100: iconst_3
    //   101: anewarray 254	java/lang/Object
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
    //   120: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: ldc 250
    //   125: ldc_w 539
    //   128: iconst_1
    //   129: anewarray 254	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload 9
    //   136: aastore
    //   137: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload 9
    //   142: ifnull +1353 -> 1495
    //   145: aload_0
    //   146: getfield 209	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   149: invokeinterface 544 1 0
    //   154: aload 9
    //   156: getfield 526	com/tencent/mm/protocal/protobuf/caf:title	Ljava/lang/String;
    //   159: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   162: ifne +12 -> 174
    //   165: aload_0
    //   166: aload 9
    //   168: getfield 526	com/tencent/mm/protocal/protobuf/caf:title	Ljava/lang/String;
    //   171: invokevirtual 546	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:setMMTitle	(Ljava/lang/String;)V
    //   174: new 266	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 267	org/json/JSONObject:<init>	()V
    //   181: astore_3
    //   182: invokestatic 85	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   185: pop
    //   186: invokestatic 89	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   189: invokevirtual 95	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   192: getstatic 270	com/tencent/mm/storage/ar$a:VsV	Lcom/tencent/mm/storage/ar$a;
    //   195: ldc_w 272
    //   198: invokevirtual 113	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: checkcast 274	java/lang/String
    //   204: astore 4
    //   206: aload 4
    //   208: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   211: ifne +651 -> 862
    //   214: new 266	org/json/JSONObject
    //   217: dup
    //   218: aload 4
    //   220: invokespecial 281	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   223: astore 4
    //   225: aload 4
    //   227: astore_3
    //   228: aload 9
    //   230: getfield 530	com/tencent/mm/protocal/protobuf/caf:TiL	Ljava/util/LinkedList;
    //   233: ifnull +1216 -> 1449
    //   236: aload 9
    //   238: getfield 530	com/tencent/mm/protocal/protobuf/caf:TiL	Ljava/util/LinkedList;
    //   241: invokevirtual 535	java/util/LinkedList:size	()I
    //   244: ifle +1205 -> 1449
    //   247: aload_0
    //   248: aload 9
    //   250: getfield 530	com/tencent/mm/protocal/protobuf/caf:TiL	Ljava/util/LinkedList;
    //   253: putfield 548	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:EQR	Ljava/util/List;
    //   256: iconst_1
    //   257: istore_2
    //   258: aload 9
    //   260: getfield 530	com/tencent/mm/protocal/protobuf/caf:TiL	Ljava/util/LinkedList;
    //   263: invokevirtual 552	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   266: astore 4
    //   268: iconst_0
    //   269: istore_1
    //   270: aload 4
    //   272: invokeinterface 557 1 0
    //   277: ifeq +1172 -> 1449
    //   280: aload 4
    //   282: invokeinterface 561 1 0
    //   287: checkcast 563	com/tencent/mm/protocal/protobuf/dkb
    //   290: astore 9
    //   292: aload 9
    //   294: getfield 566	com/tencent/mm/protocal/protobuf/dkb:Nrf	Ljava/util/LinkedList;
    //   297: ifnull +1208 -> 1505
    //   300: aload 9
    //   302: getfield 566	com/tencent/mm/protocal/protobuf/dkb:Nrf	Ljava/util/LinkedList;
    //   305: invokevirtual 535	java/util/LinkedList:size	()I
    //   308: ifle +1197 -> 1505
    //   311: iload_2
    //   312: ifne +31 -> 343
    //   315: aload 9
    //   317: getfield 567	com/tencent/mm/protocal/protobuf/dkb:title	Ljava/lang/String;
    //   320: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   323: ifeq +20 -> 343
    //   326: aload_0
    //   327: getfield 209	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   330: new 569	com/tencent/mm/ui/base/preference/PreferenceSmallCategory
    //   333: dup
    //   334: aload_0
    //   335: invokespecial 572	com/tencent/mm/ui/base/preference/PreferenceSmallCategory:<init>	(Landroid/content/Context;)V
    //   338: invokeinterface 575 2 0
    //   343: aload 9
    //   345: getfield 567	com/tencent/mm/protocal/protobuf/dkb:title	Ljava/lang/String;
    //   348: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   351: ifne +34 -> 385
    //   354: new 577	com/tencent/mm/ui/base/preference/PreferenceTitleCategory
    //   357: dup
    //   358: aload_0
    //   359: invokespecial 578	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:<init>	(Landroid/content/Context;)V
    //   362: astore 10
    //   364: aload 10
    //   366: aload 9
    //   368: getfield 567	com/tencent/mm/protocal/protobuf/dkb:title	Ljava/lang/String;
    //   371: invokevirtual 582	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:setTitle	(Ljava/lang/CharSequence;)V
    //   374: aload_0
    //   375: getfield 209	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   378: aload 10
    //   380: invokeinterface 575 2 0
    //   385: invokestatic 588	java/lang/System:currentTimeMillis	()J
    //   388: lstore 5
    //   390: aload 9
    //   392: getfield 566	com/tencent/mm/protocal/protobuf/dkb:Nrf	Ljava/util/LinkedList;
    //   395: invokevirtual 552	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   398: astore 9
    //   400: aload 9
    //   402: invokeinterface 557 1 0
    //   407: ifeq +1037 -> 1444
    //   410: aload 9
    //   412: invokeinterface 561 1 0
    //   417: checkcast 264	com/tencent/mm/protocal/protobuf/dka
    //   420: astore 10
    //   422: ldc 250
    //   424: ldc_w 590
    //   427: iconst_1
    //   428: anewarray 254	java/lang/Object
    //   431: dup
    //   432: iconst_0
    //   433: aload 10
    //   435: getfield 284	com/tencent/mm/protocal/protobuf/dka:name	Ljava/lang/String;
    //   438: aastore
    //   439: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: new 592	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference
    //   445: dup
    //   446: aload_0
    //   447: invokespecial 593	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:<init>	(Landroid/content/Context;)V
    //   450: astore 11
    //   452: aload 10
    //   454: getfield 594	com/tencent/mm/protocal/protobuf/dka:title	Ljava/lang/String;
    //   457: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   460: ifne +13 -> 473
    //   463: aload 11
    //   465: aload 10
    //   467: getfield 594	com/tencent/mm/protocal/protobuf/dka:title	Ljava/lang/String;
    //   470: invokevirtual 595	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setTitle	(Ljava/lang/CharSequence;)V
    //   473: aload 10
    //   475: getfield 598	com/tencent/mm/protocal/protobuf/dka:desc	Ljava/lang/String;
    //   478: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   481: ifne +30 -> 511
    //   484: aload 11
    //   486: iconst_0
    //   487: invokevirtual 599	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:auD	(I)V
    //   490: aload 11
    //   492: aload 10
    //   494: getfield 598	com/tencent/mm/protocal/protobuf/dka:desc	Ljava/lang/String;
    //   497: iconst_m1
    //   498: aload_0
    //   499: invokevirtual 603	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getResources	()Landroid/content/res/Resources;
    //   502: getstatic 608	com/tencent/mm/plugin/wxpay/a$c:desc_text_color	I
    //   505: invokevirtual 614	android/content/res/Resources:getColor	(I)I
    //   508: invokevirtual 618	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aU	(Ljava/lang/String;II)V
    //   511: aload 10
    //   513: getfield 621	com/tencent/mm/protocal/protobuf/dka:llI	Ljava/lang/String;
    //   516: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   519: ifne +13 -> 532
    //   522: aload 11
    //   524: aload 10
    //   526: getfield 621	com/tencent/mm/protocal/protobuf/dka:llI	Ljava/lang/String;
    //   529: putfield 624	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:iconUrl	Ljava/lang/String;
    //   532: aload 11
    //   534: aload 10
    //   536: getfield 284	com/tencent/mm/protocal/protobuf/dka:name	Ljava/lang/String;
    //   539: invokevirtual 627	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setKey	(Ljava/lang/String;)V
    //   542: aload_3
    //   543: ldc_w 294
    //   546: iconst_1
    //   547: anewarray 254	java/lang/Object
    //   550: dup
    //   551: iconst_0
    //   552: aload 10
    //   554: getfield 284	com/tencent/mm/protocal/protobuf/dka:name	Ljava/lang/String;
    //   557: aastore
    //   558: invokestatic 298	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   561: lconst_0
    //   562: invokevirtual 631	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   565: lstore 7
    //   567: ldc 250
    //   569: ldc_w 633
    //   572: iconst_1
    //   573: anewarray 254	java/lang/Object
    //   576: dup
    //   577: iconst_0
    //   578: lload 7
    //   580: invokestatic 638	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   583: aastore
    //   584: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   587: aload_3
    //   588: aload 10
    //   590: getfield 284	com/tencent/mm/protocal/protobuf/dka:name	Ljava/lang/String;
    //   593: iconst_0
    //   594: invokevirtual 288	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   597: iconst_1
    //   598: if_icmpne +267 -> 865
    //   601: iconst_1
    //   602: istore_2
    //   603: iload_2
    //   604: ifeq +898 -> 1502
    //   607: lload 7
    //   609: lconst_0
    //   610: lcmp
    //   611: ifle +891 -> 1502
    //   614: lload 5
    //   616: lload 7
    //   618: lcmp
    //   619: iflt +883 -> 1502
    //   622: ldc 250
    //   624: ldc_w 640
    //   627: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: iconst_0
    //   631: istore_2
    //   632: aload_3
    //   633: aload 10
    //   635: getfield 284	com/tencent/mm/protocal/protobuf/dka:name	Ljava/lang/String;
    //   638: iconst_0
    //   639: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   642: pop
    //   643: iload_2
    //   644: ifeq +107 -> 751
    //   647: aload 10
    //   649: getfield 648	com/tencent/mm/protocal/protobuf/dka:TRC	Lcom/tencent/mm/protocal/protobuf/dvi;
    //   652: ifnull +341 -> 993
    //   655: ldc_w 650
    //   658: aload 10
    //   660: getfield 648	com/tencent/mm/protocal/protobuf/dka:TRC	Lcom/tencent/mm/protocal/protobuf/dvi;
    //   663: getfield 655	com/tencent/mm/protocal/protobuf/dvi:type	Ljava/lang/String;
    //   666: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   669: ifeq +228 -> 897
    //   672: aload 11
    //   674: iconst_0
    //   675: invokevirtual 599	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:auD	(I)V
    //   678: aload 11
    //   680: iconst_1
    //   681: invokevirtual 656	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:FT	(Z)V
    //   684: aload 10
    //   686: getfield 648	com/tencent/mm/protocal/protobuf/dka:TRC	Lcom/tencent/mm/protocal/protobuf/dvi;
    //   689: getfield 659	com/tencent/mm/protocal/protobuf/dvi:wording	Ljava/lang/String;
    //   692: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   695: ifne +56 -> 751
    //   698: ldc 250
    //   700: ldc_w 661
    //   703: iconst_1
    //   704: anewarray 254	java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: aload 10
    //   711: getfield 648	com/tencent/mm/protocal/protobuf/dka:TRC	Lcom/tencent/mm/protocal/protobuf/dvi;
    //   714: getfield 659	com/tencent/mm/protocal/protobuf/dvi:wording	Ljava/lang/String;
    //   717: aastore
    //   718: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   721: aload 11
    //   723: aload 10
    //   725: getfield 648	com/tencent/mm/protocal/protobuf/dka:TRC	Lcom/tencent/mm/protocal/protobuf/dvi;
    //   728: getfield 659	com/tencent/mm/protocal/protobuf/dvi:wording	Ljava/lang/String;
    //   731: iconst_m1
    //   732: aload_0
    //   733: invokevirtual 603	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getResources	()Landroid/content/res/Resources;
    //   736: getstatic 608	com/tencent/mm/plugin/wxpay/a$c:desc_text_color	I
    //   739: invokevirtual 614	android/content/res/Resources:getColor	(I)I
    //   742: invokevirtual 618	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aU	(Ljava/lang/String;II)V
    //   745: aload 11
    //   747: iconst_0
    //   748: invokevirtual 599	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:auD	(I)V
    //   751: aload 11
    //   753: bipush 8
    //   755: invokevirtual 664	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:auG	(I)V
    //   758: aload 10
    //   760: getfield 284	com/tencent/mm/protocal/protobuf/dka:name	Ljava/lang/String;
    //   763: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   766: ifne +236 -> 1002
    //   769: aload_0
    //   770: getfield 74	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:EQS	Ljava/util/HashMap;
    //   773: aload 10
    //   775: getfield 284	com/tencent/mm/protocal/protobuf/dka:name	Ljava/lang/String;
    //   778: aload 10
    //   780: invokevirtual 667	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   783: pop
    //   784: aload_0
    //   785: getfield 209	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   788: aload 11
    //   790: invokeinterface 575 2 0
    //   795: iload_1
    //   796: iconst_1
    //   797: iadd
    //   798: istore_1
    //   799: aload 10
    //   801: getfield 318	com/tencent/mm/protocal/protobuf/dka:jump_type	I
    //   804: tableswitch	default:+48 -> 852, 1:+249->1053, 2:+315->1119, 3:+381->1185, 4:+445->1249, 5:+509->1313, 6:+48->852, 7:+48->852, 8:+573->1377
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
    //   872: ldc 250
    //   874: aload 12
    //   876: ldc_w 669
    //   879: iconst_1
    //   880: anewarray 254	java/lang/Object
    //   883: dup
    //   884: iconst_0
    //   885: aload 12
    //   887: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   890: aastore
    //   891: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   894: goto -251 -> 643
    //   897: ldc_w 671
    //   900: aload 10
    //   902: getfield 648	com/tencent/mm/protocal/protobuf/dka:TRC	Lcom/tencent/mm/protocal/protobuf/dvi;
    //   905: getfield 655	com/tencent/mm/protocal/protobuf/dvi:type	Ljava/lang/String;
    //   908: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   911: ifeq +27 -> 938
    //   914: aload 11
    //   916: aload_0
    //   917: getstatic 674	com/tencent/mm/plugin/wxpay/a$i:app_new	I
    //   920: invokevirtual 677	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getString	(I)Ljava/lang/String;
    //   923: getstatic 682	com/tencent/mm/plugin/wxpay/a$e:new_tips_bg	I
    //   926: invokevirtual 686	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:fC	(Ljava/lang/String;I)V
    //   929: aload 11
    //   931: iconst_0
    //   932: invokevirtual 687	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:abe	(I)V
    //   935: goto -251 -> 684
    //   938: ldc_w 689
    //   941: aload 10
    //   943: getfield 648	com/tencent/mm/protocal/protobuf/dka:TRC	Lcom/tencent/mm/protocal/protobuf/dvi;
    //   946: getfield 655	com/tencent/mm/protocal/protobuf/dvi:type	Ljava/lang/String;
    //   949: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   952: ifeq -268 -> 684
    //   955: aload 11
    //   957: new 33	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 690	java/lang/StringBuilder:<init>	()V
    //   964: aload 10
    //   966: getfield 648	com/tencent/mm/protocal/protobuf/dka:TRC	Lcom/tencent/mm/protocal/protobuf/dvi;
    //   969: getfield 693	com/tencent/mm/protocal/protobuf/dvi:number	I
    //   972: invokevirtual 696	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   975: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: getstatic 699	com/tencent/mm/plugin/wxpay/a$e:unread_count_shape	I
    //   981: invokevirtual 686	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:fC	(Ljava/lang/String;I)V
    //   984: aload 11
    //   986: iconst_0
    //   987: invokevirtual 687	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:abe	(I)V
    //   990: goto -306 -> 684
    //   993: aload 11
    //   995: iconst_0
    //   996: invokevirtual 700	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aak	(I)V
    //   999: goto -248 -> 751
    //   1002: aload_0
    //   1003: getfield 74	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:EQS	Ljava/util/HashMap;
    //   1006: new 33	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 690	java/lang/StringBuilder:<init>	()V
    //   1013: iload_1
    //   1014: invokevirtual 696	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1017: aload 10
    //   1019: getfield 284	com/tencent/mm/protocal/protobuf/dka:name	Ljava/lang/String;
    //   1022: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: aload 10
    //   1027: getfield 318	com/tencent/mm/protocal/protobuf/dka:jump_type	I
    //   1030: invokevirtual 696	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1033: aload 10
    //   1035: getfield 594	com/tencent/mm/protocal/protobuf/dka:title	Ljava/lang/String;
    //   1038: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: aload 10
    //   1046: invokevirtual 667	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1049: pop
    //   1050: goto -266 -> 784
    //   1053: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1056: astore 11
    //   1058: iload_2
    //   1059: ifeq +55 -> 1114
    //   1062: iconst_1
    //   1063: istore_2
    //   1064: aload 11
    //   1066: sipush 14872
    //   1069: iconst_5
    //   1070: anewarray 254	java/lang/Object
    //   1073: dup
    //   1074: iconst_0
    //   1075: iconst_1
    //   1076: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1079: aastore
    //   1080: dup
    //   1081: iconst_1
    //   1082: iload_2
    //   1083: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1086: aastore
    //   1087: dup
    //   1088: iconst_2
    //   1089: aload 10
    //   1091: getfield 333	com/tencent/mm/protocal/protobuf/dka:ODt	Ljava/lang/String;
    //   1094: aastore
    //   1095: dup
    //   1096: iconst_3
    //   1097: ldc_w 272
    //   1100: aastore
    //   1101: dup
    //   1102: iconst_4
    //   1103: iconst_1
    //   1104: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1107: aastore
    //   1108: invokevirtual 348	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   1111: goto -711 -> 400
    //   1114: iconst_0
    //   1115: istore_2
    //   1116: goto -52 -> 1064
    //   1119: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1122: astore 11
    //   1124: iload_2
    //   1125: ifeq +55 -> 1180
    //   1128: iconst_1
    //   1129: istore_2
    //   1130: aload 11
    //   1132: sipush 14872
    //   1135: iconst_5
    //   1136: anewarray 254	java/lang/Object
    //   1139: dup
    //   1140: iconst_0
    //   1141: iconst_2
    //   1142: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1145: aastore
    //   1146: dup
    //   1147: iconst_1
    //   1148: iload_2
    //   1149: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_2
    //   1155: ldc_w 272
    //   1158: aastore
    //   1159: dup
    //   1160: iconst_3
    //   1161: aload 10
    //   1163: getfield 353	com/tencent/mm/protocal/protobuf/dka:Ooe	Ljava/lang/String;
    //   1166: aastore
    //   1167: dup
    //   1168: iconst_4
    //   1169: iconst_1
    //   1170: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1173: aastore
    //   1174: invokevirtual 348	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   1177: goto -777 -> 400
    //   1180: iconst_0
    //   1181: istore_2
    //   1182: goto -52 -> 1130
    //   1185: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1188: astore 10
    //   1190: iload_2
    //   1191: ifeq +53 -> 1244
    //   1194: iconst_1
    //   1195: istore_2
    //   1196: aload 10
    //   1198: sipush 14872
    //   1201: iconst_5
    //   1202: anewarray 254	java/lang/Object
    //   1205: dup
    //   1206: iconst_0
    //   1207: iconst_3
    //   1208: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1211: aastore
    //   1212: dup
    //   1213: iconst_1
    //   1214: iload_2
    //   1215: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1218: aastore
    //   1219: dup
    //   1220: iconst_2
    //   1221: ldc_w 272
    //   1224: aastore
    //   1225: dup
    //   1226: iconst_3
    //   1227: ldc_w 272
    //   1230: aastore
    //   1231: dup
    //   1232: iconst_4
    //   1233: iconst_1
    //   1234: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1237: aastore
    //   1238: invokevirtual 348	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   1241: goto -841 -> 400
    //   1244: iconst_0
    //   1245: istore_2
    //   1246: goto -50 -> 1196
    //   1249: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1252: astore 10
    //   1254: iload_2
    //   1255: ifeq +53 -> 1308
    //   1258: iconst_1
    //   1259: istore_2
    //   1260: aload 10
    //   1262: sipush 14872
    //   1265: iconst_5
    //   1266: anewarray 254	java/lang/Object
    //   1269: dup
    //   1270: iconst_0
    //   1271: iconst_4
    //   1272: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1275: aastore
    //   1276: dup
    //   1277: iconst_1
    //   1278: iload_2
    //   1279: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1282: aastore
    //   1283: dup
    //   1284: iconst_2
    //   1285: ldc_w 272
    //   1288: aastore
    //   1289: dup
    //   1290: iconst_3
    //   1291: ldc_w 272
    //   1294: aastore
    //   1295: dup
    //   1296: iconst_4
    //   1297: iconst_1
    //   1298: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1301: aastore
    //   1302: invokevirtual 348	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   1305: goto -905 -> 400
    //   1308: iconst_0
    //   1309: istore_2
    //   1310: goto -50 -> 1260
    //   1313: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1316: astore 10
    //   1318: iload_2
    //   1319: ifeq +53 -> 1372
    //   1322: iconst_1
    //   1323: istore_2
    //   1324: aload 10
    //   1326: sipush 14872
    //   1329: iconst_5
    //   1330: anewarray 254	java/lang/Object
    //   1333: dup
    //   1334: iconst_0
    //   1335: iconst_5
    //   1336: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1339: aastore
    //   1340: dup
    //   1341: iconst_1
    //   1342: iload_2
    //   1343: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1346: aastore
    //   1347: dup
    //   1348: iconst_2
    //   1349: ldc_w 272
    //   1352: aastore
    //   1353: dup
    //   1354: iconst_3
    //   1355: ldc_w 272
    //   1358: aastore
    //   1359: dup
    //   1360: iconst_4
    //   1361: iconst_1
    //   1362: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1365: aastore
    //   1366: invokevirtual 348	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   1369: goto -969 -> 400
    //   1372: iconst_0
    //   1373: istore_2
    //   1374: goto -50 -> 1324
    //   1377: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1380: astore 11
    //   1382: iload_2
    //   1383: ifeq +56 -> 1439
    //   1386: iconst_1
    //   1387: istore_2
    //   1388: aload 11
    //   1390: sipush 14872
    //   1393: iconst_5
    //   1394: anewarray 254	java/lang/Object
    //   1397: dup
    //   1398: iconst_0
    //   1399: bipush 8
    //   1401: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1404: aastore
    //   1405: dup
    //   1406: iconst_1
    //   1407: iload_2
    //   1408: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1411: aastore
    //   1412: dup
    //   1413: iconst_2
    //   1414: aload 10
    //   1416: getfield 333	com/tencent/mm/protocal/protobuf/dka:ODt	Ljava/lang/String;
    //   1419: aastore
    //   1420: dup
    //   1421: iconst_3
    //   1422: ldc_w 272
    //   1425: aastore
    //   1426: dup
    //   1427: iconst_4
    //   1428: iconst_1
    //   1429: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1432: aastore
    //   1433: invokevirtual 348	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   1436: goto -584 -> 852
    //   1439: iconst_0
    //   1440: istore_2
    //   1441: goto -53 -> 1388
    //   1444: iconst_0
    //   1445: istore_2
    //   1446: goto -1176 -> 270
    //   1449: aload_3
    //   1450: invokevirtual 301	org/json/JSONObject:length	()I
    //   1453: ifle +42 -> 1495
    //   1456: ldc 250
    //   1458: ldc_w 702
    //   1461: iconst_1
    //   1462: anewarray 254	java/lang/Object
    //   1465: dup
    //   1466: iconst_0
    //   1467: aload_3
    //   1468: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1471: aastore
    //   1472: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1475: invokestatic 85	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   1478: pop
    //   1479: invokestatic 89	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1482: invokevirtual 95	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   1485: getstatic 270	com/tencent/mm/storage/ar$a:VsV	Lcom/tencent/mm/storage/ar$a;
    //   1488: aload_3
    //   1489: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1492: invokevirtual 196	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1495: ldc_w 510
    //   1498: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1501: return
    //   1502: goto -859 -> 643
    //   1505: goto -59 -> 1446
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1508	0	this	MallIndexMenuUI
    //   0	1508	1	paramInt1	int
    //   0	1508	2	paramInt2	int
    //   0	1508	3	paramString	String
    //   0	1508	4	paramq	com.tencent.mm.an.q
    //   388	227	5	l1	long
    //   565	52	7	l2	long
    //   63	348	9	localObject1	Object
    //   362	1053	10	localObject2	Object
    //   450	939	11	localObject3	Object
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexMenuUI
 * JD-Core Version:    0.7.0.1
 */