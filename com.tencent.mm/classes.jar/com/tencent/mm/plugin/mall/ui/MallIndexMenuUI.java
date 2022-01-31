package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.nu;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bdt;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class MallIndexMenuUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private int lYn;
  private List<bdu> lZJ;
  private HashMap<String, bdt> lZK = new HashMap();
  private boolean lZL;
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    y.i("MicroMsg.MallIndexMenuUI", "onPreferenceTreeClick, key: %s", new Object[] { paramf });
    bdt localbdt = (bdt)this.lZK.get(paramf);
    Object localObject;
    if (localbdt != null)
    {
      paramf = new JSONObject();
      g.DQ();
      localObject = (String)g.DP().Dz().get(ac.a.uyB, "");
      if (bk.bl((String)localObject)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        paramf = (com.tencent.mm.ui.base.preference.f)localObject;
        if (paramf.optInt(localbdt.name, 0) != 1) {
          break label1201;
        }
        paramf.remove(localbdt.name);
        paramf.remove(String.format("%s_expiretime", new Object[] { localbdt.name }));
        if (paramf.length() > 0) {
          break label284;
        }
        g.DQ();
        g.DP().Dz().c(ac.a.uyB, "");
        if ((paramPreference instanceof IconPreference))
        {
          ((IconPreference)paramPreference).Gv(8);
          ((IconPreference)paramPreference).Gt(8);
          ((IconPreference)paramPreference).Gu(8);
          ((IconPreference)paramPreference).ne(false);
        }
        i = 1;
        switch (localbdt.qho)
        {
        case 6: 
        case 7: 
        default: 
          return true;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MallIndexMenuUI", localException, "parse redDotConfig json failed: %s", new Object[] { localException.getMessage() });
      }
      continue;
      label284:
      g.DQ();
      g.DP().Dz().c(ac.a.uyB, paramf.toString());
      continue;
      y.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", new Object[] { localbdt.qhp });
      if (!bk.bl(localbdt.qhp)) {
        com.tencent.mm.wallet_core.ui.e.l(this, localbdt.qhp, false);
      }
      paramf = h.nFQ;
      if (i != 0) {}
      for (int i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(1), Integer.valueOf(i), localbdt.qhp, "", Integer.valueOf(0) });
        return true;
      }
      y.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", new Object[] { localbdt.qhq, localbdt.qhq });
      if (!bk.bl(localbdt.qhq))
      {
        paramf = new rc();
        paramf.caq.userName = localbdt.qhq;
        paramf.caq.cas = bk.aM(localbdt.qhr, "");
        paramf.caq.scene = 1066;
        paramf.caq.cat = 0;
        com.tencent.mm.sdk.b.a.udP.m(paramf);
      }
      paramf = h.nFQ;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(2), Integer.valueOf(i), "", localbdt.qhq, Integer.valueOf(0) });
        return true;
      }
      y.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
      com.tencent.mm.br.d.x(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
      paramf = h.nFQ;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        return true;
      }
      y.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
      paramf = new Intent();
      paramf.putExtra("wallet_lock_jsapi_scene", 1);
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramf);
      paramf = h.nFQ;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(4), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        new aa();
        return true;
      }
      y.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
      com.tencent.mm.br.d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      paramf = h.nFQ;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(5), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        return true;
      }
      y.i("MicroMsg.MallIndexMenuUI", "jump type honey pay");
      com.tencent.mm.br.d.x(this, "honey_pay", ".ui.HoneyPayMainUI");
      paramf = h.nFQ;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(8), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        return true;
      }
      if ("pay_my_msg".equals(paramf))
      {
        paramf = o.bVs().bVR();
        boolean bool;
        if ((paramf.qza & 0x10000) > 0)
        {
          bool = true;
          y.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramf.qza) });
          if (!bool) {
            break label1011;
          }
          paramf = new Intent();
          paramf.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.ui.e.Jc(20);
          return true;
          bool = false;
          break;
          label1011:
          com.tencent.mm.wallet_core.a.b(this, "ShowOrdersInfoProcess", null);
        }
      }
      if ("pay_manage".equals(paramf))
      {
        if (q.Gw()) {
          com.tencent.mm.br.d.x(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.ui.e.Jc(21);
          return true;
          com.tencent.mm.br.d.x(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
        }
      }
      if ("pay_security".equals(paramf))
      {
        com.tencent.mm.br.d.x(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
        com.tencent.mm.wallet_core.ui.e.Jc(22);
        paramf = new aa();
        paramf.ckr = 11L;
        paramf.cks = 1L;
        paramf.QX();
      }
      do
      {
        return false;
        if ("pay_help_center".equals(paramf))
        {
          paramPreference = new Intent();
          if (q.Gw()) {}
          for (paramf = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";; paramf = "https://kf.qq.com/touch/scene_product.html?scene_id=kf1")
          {
            paramPreference.putExtra("rawUrl", paramf);
            com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
            com.tencent.mm.wallet_core.ui.e.Jc(23);
            return true;
          }
        }
      } while (!"pay_wallet_switch".equals(paramf));
      com.tencent.mm.br.d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      return true;
      label1201:
      i = 0;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      g.DQ();
      this.lYn = ((Integer)g.DP().Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (!q.Gx()) {
          break label51;
        }
        finish();
      }
    }
    return;
    label51:
    finish();
    paramIntent = new nu();
    paramIntent.bXx.context = this.mController.uMN;
    com.tencent.mm.sdk.b.a.udP.m(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    ta(this.mController.czv());
    this.lZL = getIntent().getBooleanExtra("key_default_show_currency", false);
    g.DQ();
    g.DP().Dz().c(ac.a.uyC, Boolean.valueOf(false));
    setBackBtn(new MallIndexMenuUI.1(this));
    this.dnn = this.vdd;
    setMMTitle(a.i.mall_menu_ui_title);
    g.Dk().a(1754, this);
    paramBundle = new com.tencent.mm.plugin.mall.a.d();
    g.Dk().a(paramBundle, 0);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g.Dk().b(1754, this);
  }
  
  /* Error */
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    // Byte code:
    //   0: ldc 40
    //   2: ldc_w 482
    //   5: iconst_2
    //   6: anewarray 44	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: iload_1
    //   12: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: iload_2
    //   19: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic 50	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: iload_1
    //   27: ifne +7 -> 34
    //   30: iload_2
    //   31: ifeq +12 -> 43
    //   34: ldc 40
    //   36: ldc_w 484
    //   39: invokestatic 487	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: return
    //   43: aload 4
    //   45: checkcast 467	com/tencent/mm/plugin/mall/a/d
    //   48: getfield 491	com/tencent/mm/plugin/mall/a/d:lYp	Lcom/tencent/mm/protocal/c/air;
    //   51: astore 9
    //   53: aload 9
    //   55: getfield 496	com/tencent/mm/protocal/c/air:title	Ljava/lang/String;
    //   58: astore_3
    //   59: aload 9
    //   61: getfield 500	com/tencent/mm/protocal/c/air:tfI	Ljava/util/LinkedList;
    //   64: astore 4
    //   66: aload 9
    //   68: getfield 500	com/tencent/mm/protocal/c/air:tfI	Ljava/util/LinkedList;
    //   71: ifnull +760 -> 831
    //   74: aload 9
    //   76: getfield 500	com/tencent/mm/protocal/c/air:tfI	Ljava/util/LinkedList;
    //   79: invokevirtual 505	java/util/LinkedList:size	()I
    //   82: istore_1
    //   83: ldc 40
    //   85: ldc_w 507
    //   88: iconst_3
    //   89: anewarray 44	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_3
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload 4
    //   100: aastore
    //   101: dup
    //   102: iconst_2
    //   103: iload_1
    //   104: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: invokestatic 50	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: ldc 40
    //   113: ldc_w 509
    //   116: iconst_1
    //   117: anewarray 44	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload 9
    //   124: aastore
    //   125: invokestatic 50	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload 9
    //   130: ifnull -88 -> 42
    //   133: aload_0
    //   134: getfield 448	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:dnn	Lcom/tencent/mm/ui/base/preference/f;
    //   137: invokeinterface 514 1 0
    //   142: aload 9
    //   144: getfield 496	com/tencent/mm/protocal/c/air:title	Ljava/lang/String;
    //   147: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   150: ifne +12 -> 162
    //   153: aload_0
    //   154: aload 9
    //   156: getfield 496	com/tencent/mm/protocal/c/air:title	Ljava/lang/String;
    //   159: invokevirtual 516	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:setMMTitle	(Ljava/lang/String;)V
    //   162: new 58	org/json/JSONObject
    //   165: dup
    //   166: invokespecial 59	org/json/JSONObject:<init>	()V
    //   169: astore_3
    //   170: invokestatic 65	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   173: pop
    //   174: invokestatic 69	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   177: invokevirtual 75	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   180: getstatic 81	com/tencent/mm/storage/ac$a:uyB	Lcom/tencent/mm/storage/ac$a;
    //   183: ldc 83
    //   185: invokevirtual 88	com/tencent/mm/storage/z:get	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 90	java/lang/String
    //   191: astore 4
    //   193: aload 4
    //   195: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   198: ifne +640 -> 838
    //   201: new 58	org/json/JSONObject
    //   204: dup
    //   205: aload 4
    //   207: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   210: astore 4
    //   212: aload 4
    //   214: astore_3
    //   215: aload 9
    //   217: getfield 500	com/tencent/mm/protocal/c/air:tfI	Ljava/util/LinkedList;
    //   220: ifnull +1196 -> 1416
    //   223: aload 9
    //   225: getfield 500	com/tencent/mm/protocal/c/air:tfI	Ljava/util/LinkedList;
    //   228: invokevirtual 505	java/util/LinkedList:size	()I
    //   231: ifle +1185 -> 1416
    //   234: aload_0
    //   235: aload 9
    //   237: getfield 500	com/tencent/mm/protocal/c/air:tfI	Ljava/util/LinkedList;
    //   240: putfield 518	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:lZJ	Ljava/util/List;
    //   243: iconst_1
    //   244: istore_2
    //   245: aload 9
    //   247: getfield 500	com/tencent/mm/protocal/c/air:tfI	Ljava/util/LinkedList;
    //   250: invokevirtual 522	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   253: astore 4
    //   255: iconst_0
    //   256: istore_1
    //   257: aload 4
    //   259: invokeinterface 527 1 0
    //   264: ifeq +1152 -> 1416
    //   267: aload 4
    //   269: invokeinterface 531 1 0
    //   274: checkcast 533	com/tencent/mm/protocal/c/bdu
    //   277: astore 9
    //   279: aload 9
    //   281: getfield 536	com/tencent/mm/protocal/c/bdu:tzd	Ljava/util/LinkedList;
    //   284: ifnull +1182 -> 1466
    //   287: aload 9
    //   289: getfield 536	com/tencent/mm/protocal/c/bdu:tzd	Ljava/util/LinkedList;
    //   292: invokevirtual 505	java/util/LinkedList:size	()I
    //   295: ifle +1171 -> 1466
    //   298: iload_2
    //   299: ifne +31 -> 330
    //   302: aload 9
    //   304: getfield 537	com/tencent/mm/protocal/c/bdu:title	Ljava/lang/String;
    //   307: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   310: ifeq +20 -> 330
    //   313: aload_0
    //   314: getfield 448	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:dnn	Lcom/tencent/mm/ui/base/preference/f;
    //   317: new 539	com/tencent/mm/ui/base/preference/PreferenceSmallCategory
    //   320: dup
    //   321: aload_0
    //   322: invokespecial 542	com/tencent/mm/ui/base/preference/PreferenceSmallCategory:<init>	(Landroid/content/Context;)V
    //   325: invokeinterface 545 2 0
    //   330: aload 9
    //   332: getfield 537	com/tencent/mm/protocal/c/bdu:title	Ljava/lang/String;
    //   335: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   338: ifne +34 -> 372
    //   341: new 547	com/tencent/mm/ui/base/preference/PreferenceTitleCategory
    //   344: dup
    //   345: aload_0
    //   346: invokespecial 548	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:<init>	(Landroid/content/Context;)V
    //   349: astore 10
    //   351: aload 10
    //   353: aload 9
    //   355: getfield 537	com/tencent/mm/protocal/c/bdu:title	Ljava/lang/String;
    //   358: invokevirtual 552	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:setTitle	(Ljava/lang/CharSequence;)V
    //   361: aload_0
    //   362: getfield 448	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:dnn	Lcom/tencent/mm/ui/base/preference/f;
    //   365: aload 10
    //   367: invokeinterface 545 2 0
    //   372: invokestatic 558	java/lang/System:currentTimeMillis	()J
    //   375: lstore 5
    //   377: aload 9
    //   379: getfield 536	com/tencent/mm/protocal/c/bdu:tzd	Ljava/util/LinkedList;
    //   382: invokevirtual 522	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   385: astore 9
    //   387: aload 9
    //   389: invokeinterface 527 1 0
    //   394: ifeq +1017 -> 1411
    //   397: aload 9
    //   399: invokeinterface 531 1 0
    //   404: checkcast 56	com/tencent/mm/protocal/c/bdt
    //   407: astore 10
    //   409: ldc 40
    //   411: ldc_w 560
    //   414: iconst_1
    //   415: anewarray 44	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: aload 10
    //   422: getfield 102	com/tencent/mm/protocal/c/bdt:name	Ljava/lang/String;
    //   425: aastore
    //   426: invokestatic 50	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: new 562	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference
    //   432: dup
    //   433: aload_0
    //   434: invokespecial 563	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:<init>	(Landroid/content/Context;)V
    //   437: astore 11
    //   439: aload 10
    //   441: getfield 564	com/tencent/mm/protocal/c/bdt:title	Ljava/lang/String;
    //   444: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   447: ifne +13 -> 460
    //   450: aload 11
    //   452: aload 10
    //   454: getfield 564	com/tencent/mm/protocal/c/bdt:title	Ljava/lang/String;
    //   457: invokevirtual 565	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setTitle	(Ljava/lang/CharSequence;)V
    //   460: aload 10
    //   462: getfield 568	com/tencent/mm/protocal/c/bdt:desc	Ljava/lang/String;
    //   465: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   468: ifne +26 -> 494
    //   471: aload 11
    //   473: iconst_0
    //   474: invokevirtual 569	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:Gu	(I)V
    //   477: aload 11
    //   479: aload 10
    //   481: getfield 568	com/tencent/mm/protocal/c/bdt:desc	Ljava/lang/String;
    //   484: iconst_m1
    //   485: ldc_w 571
    //   488: invokestatic 577	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   491: invokevirtual 581	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:ap	(Ljava/lang/String;II)V
    //   494: aload 10
    //   496: getfield 584	com/tencent/mm/protocal/c/bdt:ilp	Ljava/lang/String;
    //   499: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   502: ifne +13 -> 515
    //   505: aload 11
    //   507: aload 10
    //   509: getfield 584	com/tencent/mm/protocal/c/bdt:ilp	Ljava/lang/String;
    //   512: putfield 587	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:iconUrl	Ljava/lang/String;
    //   515: aload 11
    //   517: aload 10
    //   519: getfield 102	com/tencent/mm/protocal/c/bdt:name	Ljava/lang/String;
    //   522: invokevirtual 590	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setKey	(Ljava/lang/String;)V
    //   525: aload_3
    //   526: ldc 112
    //   528: iconst_1
    //   529: anewarray 44	java/lang/Object
    //   532: dup
    //   533: iconst_0
    //   534: aload 10
    //   536: getfield 102	com/tencent/mm/protocal/c/bdt:name	Ljava/lang/String;
    //   539: aastore
    //   540: invokestatic 116	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   543: lconst_0
    //   544: invokevirtual 594	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   547: lstore 7
    //   549: ldc 40
    //   551: ldc_w 596
    //   554: iconst_1
    //   555: anewarray 44	java/lang/Object
    //   558: dup
    //   559: iconst_0
    //   560: lload 7
    //   562: invokestatic 601	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   565: aastore
    //   566: invokestatic 50	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   569: aload_3
    //   570: aload 10
    //   572: getfield 102	com/tencent/mm/protocal/c/bdt:name	Ljava/lang/String;
    //   575: iconst_0
    //   576: invokevirtual 106	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   579: iconst_1
    //   580: if_icmpne +261 -> 841
    //   583: iconst_1
    //   584: istore_2
    //   585: iload_2
    //   586: ifeq +877 -> 1463
    //   589: lload 7
    //   591: lconst_0
    //   592: lcmp
    //   593: ifle +870 -> 1463
    //   596: lload 5
    //   598: lload 7
    //   600: lcmp
    //   601: iflt +862 -> 1463
    //   604: ldc 40
    //   606: ldc_w 603
    //   609: invokestatic 231	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: iconst_0
    //   613: istore_2
    //   614: aload_3
    //   615: aload 10
    //   617: getfield 102	com/tencent/mm/protocal/c/bdt:name	Ljava/lang/String;
    //   620: iconst_0
    //   621: invokevirtual 607	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   624: pop
    //   625: iload_2
    //   626: ifeq +103 -> 729
    //   629: aload 10
    //   631: getfield 611	com/tencent/mm/protocal/c/bdt:tzc	Lcom/tencent/mm/protocal/c/bju;
    //   634: ifnull +335 -> 969
    //   637: ldc_w 613
    //   640: aload 10
    //   642: getfield 611	com/tencent/mm/protocal/c/bdt:tzc	Lcom/tencent/mm/protocal/c/bju;
    //   645: getfield 618	com/tencent/mm/protocal/c/bju:type	Ljava/lang/String;
    //   648: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   651: ifeq +222 -> 873
    //   654: aload 11
    //   656: iconst_0
    //   657: invokevirtual 569	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:Gu	(I)V
    //   660: aload 11
    //   662: iconst_1
    //   663: invokevirtual 619	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:ne	(Z)V
    //   666: aload 10
    //   668: getfield 611	com/tencent/mm/protocal/c/bdt:tzc	Lcom/tencent/mm/protocal/c/bju;
    //   671: getfield 622	com/tencent/mm/protocal/c/bju:bQZ	Ljava/lang/String;
    //   674: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   677: ifne +52 -> 729
    //   680: ldc 40
    //   682: ldc_w 624
    //   685: iconst_1
    //   686: anewarray 44	java/lang/Object
    //   689: dup
    //   690: iconst_0
    //   691: aload 10
    //   693: getfield 611	com/tencent/mm/protocal/c/bdt:tzc	Lcom/tencent/mm/protocal/c/bju;
    //   696: getfield 622	com/tencent/mm/protocal/c/bju:bQZ	Ljava/lang/String;
    //   699: aastore
    //   700: invokestatic 50	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   703: aload 11
    //   705: aload 10
    //   707: getfield 611	com/tencent/mm/protocal/c/bdt:tzc	Lcom/tencent/mm/protocal/c/bju;
    //   710: getfield 622	com/tencent/mm/protocal/c/bju:bQZ	Ljava/lang/String;
    //   713: iconst_m1
    //   714: ldc_w 571
    //   717: invokestatic 577	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   720: invokevirtual 581	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:ap	(Ljava/lang/String;II)V
    //   723: aload 11
    //   725: iconst_0
    //   726: invokevirtual 569	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:Gu	(I)V
    //   729: aload 11
    //   731: bipush 8
    //   733: invokevirtual 627	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:Gy	(I)V
    //   736: aload 10
    //   738: getfield 102	com/tencent/mm/protocal/c/bdt:name	Ljava/lang/String;
    //   741: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   744: ifne +234 -> 978
    //   747: aload_0
    //   748: getfield 27	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:lZK	Ljava/util/HashMap;
    //   751: aload 10
    //   753: getfield 102	com/tencent/mm/protocal/c/bdt:name	Ljava/lang/String;
    //   756: aload 10
    //   758: invokevirtual 630	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   761: pop
    //   762: aload_0
    //   763: getfield 448	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:dnn	Lcom/tencent/mm/ui/base/preference/f;
    //   766: aload 11
    //   768: invokeinterface 545 2 0
    //   773: iload_1
    //   774: iconst_1
    //   775: iadd
    //   776: istore_1
    //   777: aload 10
    //   779: getfield 143	com/tencent/mm/protocal/c/bdt:qho	I
    //   782: tableswitch	default:+46 -> 828, 1:+247->1029, 2:+312->1094, 3:+377->1159, 4:+439->1221, 5:+501->1283, 6:+46->828, 7:+46->828, 8:+563->1345
    //   829: impdep1
    //   830: dstore_0
    //   831: iconst_0
    //   832: istore_1
    //   833: goto -750 -> 83
    //   836: astore 4
    //   838: goto -623 -> 215
    //   841: iconst_0
    //   842: istore_2
    //   843: goto -258 -> 585
    //   846: astore 12
    //   848: ldc 40
    //   850: aload 12
    //   852: ldc_w 632
    //   855: iconst_1
    //   856: anewarray 44	java/lang/Object
    //   859: dup
    //   860: iconst_0
    //   861: aload 12
    //   863: invokevirtual 149	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   866: aastore
    //   867: invokestatic 153	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   870: goto -245 -> 625
    //   873: ldc_w 634
    //   876: aload 10
    //   878: getfield 611	com/tencent/mm/protocal/c/bdt:tzc	Lcom/tencent/mm/protocal/c/bju;
    //   881: getfield 618	com/tencent/mm/protocal/c/bju:type	Ljava/lang/String;
    //   884: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   887: ifeq +27 -> 914
    //   890: aload 11
    //   892: aload_0
    //   893: getstatic 637	com/tencent/mm/plugin/wxpay/a$i:app_new	I
    //   896: invokevirtual 641	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getString	(I)Ljava/lang/String;
    //   899: getstatic 646	com/tencent/mm/plugin/wxpay/a$e:new_tips_bg	I
    //   902: invokevirtual 650	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:dD	(Ljava/lang/String;I)V
    //   905: aload 11
    //   907: iconst_0
    //   908: invokevirtual 651	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:Gt	(I)V
    //   911: goto -245 -> 666
    //   914: ldc_w 653
    //   917: aload 10
    //   919: getfield 611	com/tencent/mm/protocal/c/bdt:tzc	Lcom/tencent/mm/protocal/c/bju;
    //   922: getfield 618	com/tencent/mm/protocal/c/bju:type	Ljava/lang/String;
    //   925: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   928: ifeq -262 -> 666
    //   931: aload 11
    //   933: new 655	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 656	java/lang/StringBuilder:<init>	()V
    //   940: aload 10
    //   942: getfield 611	com/tencent/mm/protocal/c/bdt:tzc	Lcom/tencent/mm/protocal/c/bju;
    //   945: getfield 659	com/tencent/mm/protocal/c/bju:number	I
    //   948: invokevirtual 663	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   951: invokevirtual 664	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: getstatic 667	com/tencent/mm/plugin/wxpay/a$e:unread_count_shape	I
    //   957: invokevirtual 650	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:dD	(Ljava/lang/String;I)V
    //   960: aload 11
    //   962: iconst_0
    //   963: invokevirtual 651	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:Gt	(I)V
    //   966: goto -300 -> 666
    //   969: aload 11
    //   971: iconst_0
    //   972: invokevirtual 668	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:Gv	(I)V
    //   975: goto -246 -> 729
    //   978: aload_0
    //   979: getfield 27	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:lZK	Ljava/util/HashMap;
    //   982: new 655	java/lang/StringBuilder
    //   985: dup
    //   986: invokespecial 656	java/lang/StringBuilder:<init>	()V
    //   989: iload_1
    //   990: invokevirtual 663	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   993: aload 10
    //   995: getfield 102	com/tencent/mm/protocal/c/bdt:name	Ljava/lang/String;
    //   998: invokevirtual 671	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: aload 10
    //   1003: getfield 143	com/tencent/mm/protocal/c/bdt:qho	I
    //   1006: invokevirtual 663	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1009: aload 10
    //   1011: getfield 564	com/tencent/mm/protocal/c/bdt:title	Ljava/lang/String;
    //   1014: invokevirtual 671	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: invokevirtual 664	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1020: aload 10
    //   1022: invokevirtual 630	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1025: pop
    //   1026: goto -264 -> 762
    //   1029: getstatic 173	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1032: astore 11
    //   1034: iload_2
    //   1035: ifeq +54 -> 1089
    //   1038: iconst_1
    //   1039: istore_2
    //   1040: aload 11
    //   1042: sipush 14872
    //   1045: iconst_5
    //   1046: anewarray 44	java/lang/Object
    //   1049: dup
    //   1050: iconst_0
    //   1051: iconst_1
    //   1052: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1055: aastore
    //   1056: dup
    //   1057: iconst_1
    //   1058: iload_2
    //   1059: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1062: aastore
    //   1063: dup
    //   1064: iconst_2
    //   1065: aload 10
    //   1067: getfield 161	com/tencent/mm/protocal/c/bdt:qhp	Ljava/lang/String;
    //   1070: aastore
    //   1071: dup
    //   1072: iconst_3
    //   1073: ldc 83
    //   1075: aastore
    //   1076: dup
    //   1077: iconst_4
    //   1078: iconst_1
    //   1079: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1082: aastore
    //   1083: invokevirtual 183	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   1086: goto -699 -> 387
    //   1089: iconst_0
    //   1090: istore_2
    //   1091: goto -51 -> 1040
    //   1094: getstatic 173	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1097: astore 11
    //   1099: iload_2
    //   1100: ifeq +54 -> 1154
    //   1103: iconst_1
    //   1104: istore_2
    //   1105: aload 11
    //   1107: sipush 14872
    //   1110: iconst_5
    //   1111: anewarray 44	java/lang/Object
    //   1114: dup
    //   1115: iconst_0
    //   1116: iconst_2
    //   1117: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1120: aastore
    //   1121: dup
    //   1122: iconst_1
    //   1123: iload_2
    //   1124: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1127: aastore
    //   1128: dup
    //   1129: iconst_2
    //   1130: ldc 83
    //   1132: aastore
    //   1133: dup
    //   1134: iconst_3
    //   1135: aload 10
    //   1137: getfield 188	com/tencent/mm/protocal/c/bdt:qhq	Ljava/lang/String;
    //   1140: aastore
    //   1141: dup
    //   1142: iconst_4
    //   1143: iconst_1
    //   1144: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1147: aastore
    //   1148: invokevirtual 183	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   1151: goto -764 -> 387
    //   1154: iconst_0
    //   1155: istore_2
    //   1156: goto -51 -> 1105
    //   1159: getstatic 173	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1162: astore 10
    //   1164: iload_2
    //   1165: ifeq +51 -> 1216
    //   1168: iconst_1
    //   1169: istore_2
    //   1170: aload 10
    //   1172: sipush 14872
    //   1175: iconst_5
    //   1176: anewarray 44	java/lang/Object
    //   1179: dup
    //   1180: iconst_0
    //   1181: iconst_3
    //   1182: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1185: aastore
    //   1186: dup
    //   1187: iconst_1
    //   1188: iload_2
    //   1189: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1192: aastore
    //   1193: dup
    //   1194: iconst_2
    //   1195: ldc 83
    //   1197: aastore
    //   1198: dup
    //   1199: iconst_3
    //   1200: ldc 83
    //   1202: aastore
    //   1203: dup
    //   1204: iconst_4
    //   1205: iconst_1
    //   1206: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1209: aastore
    //   1210: invokevirtual 183	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   1213: goto -826 -> 387
    //   1216: iconst_0
    //   1217: istore_2
    //   1218: goto -48 -> 1170
    //   1221: getstatic 173	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1224: astore 10
    //   1226: iload_2
    //   1227: ifeq +51 -> 1278
    //   1230: iconst_1
    //   1231: istore_2
    //   1232: aload 10
    //   1234: sipush 14872
    //   1237: iconst_5
    //   1238: anewarray 44	java/lang/Object
    //   1241: dup
    //   1242: iconst_0
    //   1243: iconst_4
    //   1244: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1247: aastore
    //   1248: dup
    //   1249: iconst_1
    //   1250: iload_2
    //   1251: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1254: aastore
    //   1255: dup
    //   1256: iconst_2
    //   1257: ldc 83
    //   1259: aastore
    //   1260: dup
    //   1261: iconst_3
    //   1262: ldc 83
    //   1264: aastore
    //   1265: dup
    //   1266: iconst_4
    //   1267: iconst_1
    //   1268: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1271: aastore
    //   1272: invokevirtual 183	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   1275: goto -888 -> 387
    //   1278: iconst_0
    //   1279: istore_2
    //   1280: goto -48 -> 1232
    //   1283: getstatic 173	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1286: astore 10
    //   1288: iload_2
    //   1289: ifeq +51 -> 1340
    //   1292: iconst_1
    //   1293: istore_2
    //   1294: aload 10
    //   1296: sipush 14872
    //   1299: iconst_5
    //   1300: anewarray 44	java/lang/Object
    //   1303: dup
    //   1304: iconst_0
    //   1305: iconst_5
    //   1306: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1309: aastore
    //   1310: dup
    //   1311: iconst_1
    //   1312: iload_2
    //   1313: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1316: aastore
    //   1317: dup
    //   1318: iconst_2
    //   1319: ldc 83
    //   1321: aastore
    //   1322: dup
    //   1323: iconst_3
    //   1324: ldc 83
    //   1326: aastore
    //   1327: dup
    //   1328: iconst_4
    //   1329: iconst_1
    //   1330: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1333: aastore
    //   1334: invokevirtual 183	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   1337: goto -950 -> 387
    //   1340: iconst_0
    //   1341: istore_2
    //   1342: goto -48 -> 1294
    //   1345: getstatic 173	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1348: astore 11
    //   1350: iload_2
    //   1351: ifeq +55 -> 1406
    //   1354: iconst_1
    //   1355: istore_2
    //   1356: aload 11
    //   1358: sipush 14872
    //   1361: iconst_5
    //   1362: anewarray 44	java/lang/Object
    //   1365: dup
    //   1366: iconst_0
    //   1367: bipush 8
    //   1369: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1372: aastore
    //   1373: dup
    //   1374: iconst_1
    //   1375: iload_2
    //   1376: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1379: aastore
    //   1380: dup
    //   1381: iconst_2
    //   1382: aload 10
    //   1384: getfield 161	com/tencent/mm/protocal/c/bdt:qhp	Ljava/lang/String;
    //   1387: aastore
    //   1388: dup
    //   1389: iconst_3
    //   1390: ldc 83
    //   1392: aastore
    //   1393: dup
    //   1394: iconst_4
    //   1395: iconst_1
    //   1396: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1399: aastore
    //   1400: invokevirtual 183	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   1403: goto -575 -> 828
    //   1406: iconst_0
    //   1407: istore_2
    //   1408: goto -52 -> 1356
    //   1411: iconst_0
    //   1412: istore_2
    //   1413: goto -1156 -> 257
    //   1416: aload_3
    //   1417: invokevirtual 120	org/json/JSONObject:length	()I
    //   1420: ifle -1378 -> 42
    //   1423: ldc 40
    //   1425: ldc_w 673
    //   1428: iconst_1
    //   1429: anewarray 44	java/lang/Object
    //   1432: dup
    //   1433: iconst_0
    //   1434: aload_3
    //   1435: invokevirtual 156	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1438: aastore
    //   1439: invokestatic 50	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1442: invokestatic 65	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   1445: pop
    //   1446: invokestatic 69	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   1449: invokevirtual 75	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   1452: getstatic 81	com/tencent/mm/storage/ac$a:uyB	Lcom/tencent/mm/storage/ac$a;
    //   1455: aload_3
    //   1456: invokevirtual 156	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1459: invokevirtual 124	com/tencent/mm/storage/z:c	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)V
    //   1462: return
    //   1463: goto -838 -> 625
    //   1466: goto -53 -> 1413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1469	0	this	MallIndexMenuUI
    //   0	1469	1	paramInt1	int
    //   0	1469	2	paramInt2	int
    //   0	1469	3	paramString	String
    //   0	1469	4	paramm	com.tencent.mm.ah.m
    //   375	222	5	l1	long
    //   547	52	7	l2	long
    //   51	347	9	localObject1	Object
    //   349	1034	10	localObject2	Object
    //   437	920	11	localObject3	Object
    //   846	16	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   201	212	836	org/json/JSONException
    //   614	625	846	java/lang/Exception
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexMenuUI
 * JD-Core Version:    0.7.0.1
 */