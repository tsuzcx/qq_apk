package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.mall.a.h;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class MallIndexMenuUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private com.tencent.mm.ui.base.preference.f screen;
  private int vPo;
  private List<ckf> vRv;
  private HashMap<String, cke> vRw;
  private boolean vRx;
  
  public MallIndexMenuUI()
  {
    AppMethodBeat.i(66069);
    this.vRw = new HashMap();
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
      com.tencent.mm.kernel.g.ajS();
      this.vPo = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (v.aAS())
        {
          finish();
          AppMethodBeat.o(66074);
          return;
        }
        finish();
        paramIntent = new rh();
        paramIntent.dGV.context = getContext();
        com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
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
    this.vRx = getIntent().getBooleanExtra("key_default_show_currency", false);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWt, Boolean.FALSE);
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
    setMMTitle(2131761094);
    com.tencent.mm.kernel.g.ajj().a(1754, this);
    paramBundle = new h();
    com.tencent.mm.kernel.g.ajj().a(paramBundle, 0);
    AppMethodBeat.o(66070);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66071);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(1754, this);
    AppMethodBeat.o(66071);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(66072);
    paramf = paramPreference.mKey;
    ae.i("MicroMsg.MallIndexMenuUI", "onPreferenceTreeClick, key: %s", new Object[] { paramf });
    cke localcke = (cke)this.vRw.get(paramf);
    Object localObject;
    if (localcke != null)
    {
      paramf = new JSONObject();
      com.tencent.mm.kernel.g.ajS();
      localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWs, "");
      if (bu.isNullOrNil((String)localObject)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        paramf = (com.tencent.mm.ui.base.preference.f)localObject;
        if (paramf.optInt(localcke.name, 0) != 1) {
          break label1213;
        }
        paramf.remove(localcke.name);
        paramf.remove(String.format("%s_expiretime", new Object[] { localcke.name }));
        if (paramf.length() > 0) {
          break label298;
        }
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWs, "");
        if ((paramPreference instanceof IconPreference))
        {
          ((IconPreference)paramPreference).acU(8);
          ((IconPreference)paramPreference).acS(8);
          ((IconPreference)paramPreference).acT(8);
          ((IconPreference)paramPreference).xM(false);
        }
        i = 1;
        switch (localcke.uIW)
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
        ae.printErrStackTrace("MicroMsg.MallIndexMenuUI", localException, "parse redDotConfig json failed: %s", new Object[] { localException.getMessage() });
      }
      continue;
      label298:
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWs, paramf.toString());
      continue;
      ae.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", new Object[] { localcke.DfC });
      if (!bu.isNullOrNil(localcke.DfC)) {
        com.tencent.mm.wallet_core.ui.f.p(this, localcke.DfC, false);
      }
      paramf = com.tencent.mm.plugin.report.service.g.yxI;
      if (i != 0) {}
      for (int i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(1), Integer.valueOf(i), localcke.DfC, "", Integer.valueOf(0) });
        break;
      }
      ae.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", new Object[] { localcke.CRv, localcke.CRv });
      if (!bu.isNullOrNil(localcke.CRv))
      {
        paramf = new vq();
        paramf.dKT.userName = localcke.CRv;
        paramf.dKT.dKV = bu.bI(localcke.CRw, "");
        paramf.dKT.scene = 1066;
        paramf.dKT.dKW = 0;
        com.tencent.mm.sdk.b.a.IvT.l(paramf);
      }
      paramf = com.tencent.mm.plugin.report.service.g.yxI;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(2), Integer.valueOf(i), "", localcke.CRv, Integer.valueOf(0) });
        break;
      }
      ae.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
      d.Q(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
      paramf = com.tencent.mm.plugin.report.service.g.yxI;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      ae.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
      paramf = new Intent();
      paramf.putExtra("wallet_lock_jsapi_scene", 1);
      d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramf);
      paramf = com.tencent.mm.plugin.report.service.g.yxI;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(4), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        new hi();
        break;
      }
      ae.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
      d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      paramf = com.tencent.mm.plugin.report.service.g.yxI;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(5), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      ae.i("MicroMsg.MallIndexMenuUI", "jump type honey pay");
      d.Q(this, "honey_pay", ".ui.HoneyPayMainUI");
      paramf = com.tencent.mm.plugin.report.service.g.yxI;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.f(14872, new Object[] { Integer.valueOf(8), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      if ("pay_my_msg".equals(paramf))
      {
        paramf = t.eJf().eJP();
        boolean bool;
        if ((paramf.Dst & 0x10000) > 0)
        {
          bool = true;
          ae.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramf.Dst) });
          if (!bool) {
            break label1022;
          }
          com.tencent.mm.wallet_core.ui.f.aY(this, "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.ui.f.aha(20);
          AppMethodBeat.o(66072);
          return true;
          bool = false;
          break;
          label1022:
          com.tencent.mm.wallet_core.a.b(this, "ShowOrdersInfoProcess", null);
        }
      }
      if ("pay_manage".equals(paramf))
      {
        if (v.aAR()) {
          d.Q(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.ui.f.aha(21);
          AppMethodBeat.o(66072);
          return true;
          d.Q(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
        }
      }
      if ("pay_security".equals(paramf))
      {
        d.Q(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
        com.tencent.mm.wallet_core.ui.f.aha(22);
        paramf = new hi();
        paramf.eeh = 11L;
        paramf.etC = 1L;
        paramf.aLH();
      }
      do
      {
        AppMethodBeat.o(66072);
        return false;
        if ("pay_help_center".equals(paramf))
        {
          if (v.aAR()) {}
          for (paramf = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";; paramf = "https://kf.qq.com/touch/scene_product.html?scene_id=kf1")
          {
            com.tencent.mm.wallet_core.ui.f.aY(this, paramf);
            com.tencent.mm.wallet_core.ui.f.aha(23);
            AppMethodBeat.o(66072);
            return true;
          }
        }
      } while (!"pay_wallet_switch".equals(paramf));
      d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      AppMethodBeat.o(66072);
      return true;
      label1213:
      i = 0;
    }
  }
  
  /* Error */
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    // Byte code:
    //   0: ldc_w 483
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 215
    //   8: ldc_w 485
    //   11: iconst_2
    //   12: anewarray 219	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: iload_2
    //   25: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: iload_1
    //   33: ifne +7 -> 40
    //   36: iload_2
    //   37: ifeq +18 -> 55
    //   40: ldc 215
    //   42: ldc_w 487
    //   45: invokestatic 490	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 483
    //   51: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: aload 4
    //   57: checkcast 191	com/tencent/mm/plugin/mall/a/h
    //   60: getfield 494	com/tencent/mm/plugin/mall/a/h:vPs	Lcom/tencent/mm/protocal/protobuf/bgn;
    //   63: astore 9
    //   65: aload 9
    //   67: getfield 499	com/tencent/mm/protocal/protobuf/bgn:title	Ljava/lang/String;
    //   70: astore_3
    //   71: aload 9
    //   73: getfield 503	com/tencent/mm/protocal/protobuf/bgn:GUZ	Ljava/util/LinkedList;
    //   76: astore 4
    //   78: aload 9
    //   80: getfield 503	com/tencent/mm/protocal/protobuf/bgn:GUZ	Ljava/util/LinkedList;
    //   83: ifnull +768 -> 851
    //   86: aload 9
    //   88: getfield 503	com/tencent/mm/protocal/protobuf/bgn:GUZ	Ljava/util/LinkedList;
    //   91: invokevirtual 508	java/util/LinkedList:size	()I
    //   94: istore_1
    //   95: ldc 215
    //   97: ldc_w 510
    //   100: iconst_3
    //   101: anewarray 219	java/lang/Object
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
    //   116: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aastore
    //   120: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: ldc 215
    //   125: ldc_w 512
    //   128: iconst_1
    //   129: anewarray 219	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload 9
    //   136: aastore
    //   137: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload 9
    //   142: ifnull +1340 -> 1482
    //   145: aload_0
    //   146: getfield 175	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   149: invokeinterface 517 1 0
    //   154: aload 9
    //   156: getfield 499	com/tencent/mm/protocal/protobuf/bgn:title	Ljava/lang/String;
    //   159: invokestatic 245	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   162: ifne +12 -> 174
    //   165: aload_0
    //   166: aload 9
    //   168: getfield 499	com/tencent/mm/protocal/protobuf/bgn:title	Ljava/lang/String;
    //   171: invokevirtual 519	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:setMMTitle	(Ljava/lang/String;)V
    //   174: new 231	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 232	org/json/JSONObject:<init>	()V
    //   181: astore_3
    //   182: invokestatic 51	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   185: pop
    //   186: invokestatic 55	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   189: invokevirtual 61	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   192: getstatic 235	com/tencent/mm/storage/am$a:IWs	Lcom/tencent/mm/storage/am$a;
    //   195: ldc 237
    //   197: invokevirtual 79	com/tencent/mm/storage/aj:get	(Lcom/tencent/mm/storage/am$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: checkcast 239	java/lang/String
    //   203: astore 4
    //   205: aload 4
    //   207: invokestatic 245	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   210: ifne +648 -> 858
    //   213: new 231	org/json/JSONObject
    //   216: dup
    //   217: aload 4
    //   219: invokespecial 248	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   222: astore 4
    //   224: aload 4
    //   226: astore_3
    //   227: aload 9
    //   229: getfield 503	com/tencent/mm/protocal/protobuf/bgn:GUZ	Ljava/util/LinkedList;
    //   232: ifnull +1204 -> 1436
    //   235: aload 9
    //   237: getfield 503	com/tencent/mm/protocal/protobuf/bgn:GUZ	Ljava/util/LinkedList;
    //   240: invokevirtual 508	java/util/LinkedList:size	()I
    //   243: ifle +1193 -> 1436
    //   246: aload_0
    //   247: aload 9
    //   249: getfield 503	com/tencent/mm/protocal/protobuf/bgn:GUZ	Ljava/util/LinkedList;
    //   252: putfield 521	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:vRv	Ljava/util/List;
    //   255: iconst_1
    //   256: istore_2
    //   257: aload 9
    //   259: getfield 503	com/tencent/mm/protocal/protobuf/bgn:GUZ	Ljava/util/LinkedList;
    //   262: invokevirtual 525	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   265: astore 4
    //   267: iconst_0
    //   268: istore_1
    //   269: aload 4
    //   271: invokeinterface 530 1 0
    //   276: ifeq +1160 -> 1436
    //   279: aload 4
    //   281: invokeinterface 534 1 0
    //   286: checkcast 536	com/tencent/mm/protocal/protobuf/ckf
    //   289: astore 9
    //   291: aload 9
    //   293: getfield 539	com/tencent/mm/protocal/protobuf/ckf:CbC	Ljava/util/LinkedList;
    //   296: ifnull +1196 -> 1492
    //   299: aload 9
    //   301: getfield 539	com/tencent/mm/protocal/protobuf/ckf:CbC	Ljava/util/LinkedList;
    //   304: invokevirtual 508	java/util/LinkedList:size	()I
    //   307: ifle +1185 -> 1492
    //   310: iload_2
    //   311: ifne +31 -> 342
    //   314: aload 9
    //   316: getfield 540	com/tencent/mm/protocal/protobuf/ckf:title	Ljava/lang/String;
    //   319: invokestatic 245	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   322: ifeq +20 -> 342
    //   325: aload_0
    //   326: getfield 175	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   329: new 542	com/tencent/mm/ui/base/preference/PreferenceSmallCategory
    //   332: dup
    //   333: aload_0
    //   334: invokespecial 545	com/tencent/mm/ui/base/preference/PreferenceSmallCategory:<init>	(Landroid/content/Context;)V
    //   337: invokeinterface 548 2 0
    //   342: aload 9
    //   344: getfield 540	com/tencent/mm/protocal/protobuf/ckf:title	Ljava/lang/String;
    //   347: invokestatic 245	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   350: ifne +34 -> 384
    //   353: new 550	com/tencent/mm/ui/base/preference/PreferenceTitleCategory
    //   356: dup
    //   357: aload_0
    //   358: invokespecial 551	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:<init>	(Landroid/content/Context;)V
    //   361: astore 10
    //   363: aload 10
    //   365: aload 9
    //   367: getfield 540	com/tencent/mm/protocal/protobuf/ckf:title	Ljava/lang/String;
    //   370: invokevirtual 555	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:setTitle	(Ljava/lang/CharSequence;)V
    //   373: aload_0
    //   374: getfield 175	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   377: aload 10
    //   379: invokeinterface 548 2 0
    //   384: invokestatic 561	java/lang/System:currentTimeMillis	()J
    //   387: lstore 5
    //   389: aload 9
    //   391: getfield 539	com/tencent/mm/protocal/protobuf/ckf:CbC	Ljava/util/LinkedList;
    //   394: invokevirtual 525	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   397: astore 9
    //   399: aload 9
    //   401: invokeinterface 530 1 0
    //   406: ifeq +1025 -> 1431
    //   409: aload 9
    //   411: invokeinterface 534 1 0
    //   416: checkcast 229	com/tencent/mm/protocal/protobuf/cke
    //   419: astore 10
    //   421: ldc 215
    //   423: ldc_w 563
    //   426: iconst_1
    //   427: anewarray 219	java/lang/Object
    //   430: dup
    //   431: iconst_0
    //   432: aload 10
    //   434: getfield 251	com/tencent/mm/protocal/protobuf/cke:name	Ljava/lang/String;
    //   437: aastore
    //   438: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: new 565	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference
    //   444: dup
    //   445: aload_0
    //   446: invokespecial 566	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:<init>	(Landroid/content/Context;)V
    //   449: astore 11
    //   451: aload 10
    //   453: getfield 567	com/tencent/mm/protocal/protobuf/cke:title	Ljava/lang/String;
    //   456: invokestatic 245	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   459: ifne +13 -> 472
    //   462: aload 11
    //   464: aload 10
    //   466: getfield 567	com/tencent/mm/protocal/protobuf/cke:title	Ljava/lang/String;
    //   469: invokevirtual 568	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setTitle	(Ljava/lang/CharSequence;)V
    //   472: aload 10
    //   474: getfield 571	com/tencent/mm/protocal/protobuf/cke:desc	Ljava/lang/String;
    //   477: invokestatic 245	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   480: ifne +30 -> 510
    //   483: aload 11
    //   485: iconst_0
    //   486: invokevirtual 572	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:acT	(I)V
    //   489: aload 11
    //   491: aload 10
    //   493: getfield 571	com/tencent/mm/protocal/protobuf/cke:desc	Ljava/lang/String;
    //   496: iconst_m1
    //   497: aload_0
    //   498: invokevirtual 576	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getResources	()Landroid/content/res/Resources;
    //   501: ldc_w 577
    //   504: invokevirtual 583	android/content/res/Resources:getColor	(I)I
    //   507: invokevirtual 587	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aX	(Ljava/lang/String;II)V
    //   510: aload 10
    //   512: getfield 590	com/tencent/mm/protocal/protobuf/cke:hCp	Ljava/lang/String;
    //   515: invokestatic 245	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   518: ifne +13 -> 531
    //   521: aload 11
    //   523: aload 10
    //   525: getfield 590	com/tencent/mm/protocal/protobuf/cke:hCp	Ljava/lang/String;
    //   528: putfield 593	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:iconUrl	Ljava/lang/String;
    //   531: aload 11
    //   533: aload 10
    //   535: getfield 251	com/tencent/mm/protocal/protobuf/cke:name	Ljava/lang/String;
    //   538: invokevirtual 596	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setKey	(Ljava/lang/String;)V
    //   541: aload_3
    //   542: ldc_w 261
    //   545: iconst_1
    //   546: anewarray 219	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload 10
    //   553: getfield 251	com/tencent/mm/protocal/protobuf/cke:name	Ljava/lang/String;
    //   556: aastore
    //   557: invokestatic 265	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   560: lconst_0
    //   561: invokevirtual 600	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   564: lstore 7
    //   566: ldc 215
    //   568: ldc_w 602
    //   571: iconst_1
    //   572: anewarray 219	java/lang/Object
    //   575: dup
    //   576: iconst_0
    //   577: lload 7
    //   579: invokestatic 607	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   582: aastore
    //   583: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   586: aload_3
    //   587: aload 10
    //   589: getfield 251	com/tencent/mm/protocal/protobuf/cke:name	Ljava/lang/String;
    //   592: iconst_0
    //   593: invokevirtual 255	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   596: iconst_1
    //   597: if_icmpne +264 -> 861
    //   600: iconst_1
    //   601: istore_2
    //   602: iload_2
    //   603: ifeq +886 -> 1489
    //   606: lload 7
    //   608: lconst_0
    //   609: lcmp
    //   610: ifle +879 -> 1489
    //   613: lload 5
    //   615: lload 7
    //   617: lcmp
    //   618: iflt +871 -> 1489
    //   621: ldc 215
    //   623: ldc_w 609
    //   626: invokestatic 357	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: iconst_0
    //   630: istore_2
    //   631: aload_3
    //   632: aload 10
    //   634: getfield 251	com/tencent/mm/protocal/protobuf/cke:name	Ljava/lang/String;
    //   637: iconst_0
    //   638: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   641: pop
    //   642: iload_2
    //   643: ifeq +107 -> 750
    //   646: aload 10
    //   648: getfield 617	com/tencent/mm/protocal/protobuf/cke:HwQ	Lcom/tencent/mm/protocal/protobuf/cta;
    //   651: ifnull +338 -> 989
    //   654: ldc_w 619
    //   657: aload 10
    //   659: getfield 617	com/tencent/mm/protocal/protobuf/cke:HwQ	Lcom/tencent/mm/protocal/protobuf/cta;
    //   662: getfield 624	com/tencent/mm/protocal/protobuf/cta:type	Ljava/lang/String;
    //   665: invokevirtual 406	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   668: ifeq +225 -> 893
    //   671: aload 11
    //   673: iconst_0
    //   674: invokevirtual 572	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:acT	(I)V
    //   677: aload 11
    //   679: iconst_1
    //   680: invokevirtual 625	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:xM	(Z)V
    //   683: aload 10
    //   685: getfield 617	com/tencent/mm/protocal/protobuf/cke:HwQ	Lcom/tencent/mm/protocal/protobuf/cta;
    //   688: getfield 628	com/tencent/mm/protocal/protobuf/cta:dyI	Ljava/lang/String;
    //   691: invokestatic 245	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   694: ifne +56 -> 750
    //   697: ldc 215
    //   699: ldc_w 630
    //   702: iconst_1
    //   703: anewarray 219	java/lang/Object
    //   706: dup
    //   707: iconst_0
    //   708: aload 10
    //   710: getfield 617	com/tencent/mm/protocal/protobuf/cke:HwQ	Lcom/tencent/mm/protocal/protobuf/cta;
    //   713: getfield 628	com/tencent/mm/protocal/protobuf/cta:dyI	Ljava/lang/String;
    //   716: aastore
    //   717: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   720: aload 11
    //   722: aload 10
    //   724: getfield 617	com/tencent/mm/protocal/protobuf/cke:HwQ	Lcom/tencent/mm/protocal/protobuf/cta;
    //   727: getfield 628	com/tencent/mm/protocal/protobuf/cta:dyI	Ljava/lang/String;
    //   730: iconst_m1
    //   731: aload_0
    //   732: invokevirtual 576	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getResources	()Landroid/content/res/Resources;
    //   735: ldc_w 577
    //   738: invokevirtual 583	android/content/res/Resources:getColor	(I)I
    //   741: invokevirtual 587	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aX	(Ljava/lang/String;II)V
    //   744: aload 11
    //   746: iconst_0
    //   747: invokevirtual 572	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:acT	(I)V
    //   750: aload 11
    //   752: bipush 8
    //   754: invokevirtual 633	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:acX	(I)V
    //   757: aload 10
    //   759: getfield 251	com/tencent/mm/protocal/protobuf/cke:name	Ljava/lang/String;
    //   762: invokestatic 245	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   765: ifne +233 -> 998
    //   768: aload_0
    //   769: getfield 36	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:vRw	Ljava/util/HashMap;
    //   772: aload 10
    //   774: getfield 251	com/tencent/mm/protocal/protobuf/cke:name	Ljava/lang/String;
    //   777: aload 10
    //   779: invokevirtual 636	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   782: pop
    //   783: aload_0
    //   784: getfield 175	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   787: aload 11
    //   789: invokeinterface 548 2 0
    //   794: iload_1
    //   795: iconst_1
    //   796: iadd
    //   797: istore_1
    //   798: aload 10
    //   800: getfield 285	com/tencent/mm/protocal/protobuf/cke:uIW	I
    //   803: tableswitch	default:+45 -> 848, 1:+246->1049, 2:+311->1114, 3:+376->1179, 4:+438->1241, 5:+500->1303, 6:+45->848, 7:+45->848, 8:+562->1365
    //   849: impdep1
    //   850: lstore_0
    //   851: iconst_0
    //   852: istore_1
    //   853: goto -758 -> 95
    //   856: astore 4
    //   858: goto -631 -> 227
    //   861: iconst_0
    //   862: istore_2
    //   863: goto -261 -> 602
    //   866: astore 12
    //   868: ldc 215
    //   870: aload 12
    //   872: ldc_w 638
    //   875: iconst_1
    //   876: anewarray 219	java/lang/Object
    //   879: dup
    //   880: iconst_0
    //   881: aload 12
    //   883: invokevirtual 291	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   886: aastore
    //   887: invokestatic 295	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   890: goto -248 -> 642
    //   893: ldc_w 640
    //   896: aload 10
    //   898: getfield 617	com/tencent/mm/protocal/protobuf/cke:HwQ	Lcom/tencent/mm/protocal/protobuf/cta;
    //   901: getfield 624	com/tencent/mm/protocal/protobuf/cta:type	Ljava/lang/String;
    //   904: invokevirtual 406	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   907: ifeq +27 -> 934
    //   910: aload 11
    //   912: aload_0
    //   913: ldc_w 641
    //   916: invokevirtual 645	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getString	(I)Ljava/lang/String;
    //   919: ldc_w 646
    //   922: invokevirtual 650	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:gF	(Ljava/lang/String;I)V
    //   925: aload 11
    //   927: iconst_0
    //   928: invokevirtual 651	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:acS	(I)V
    //   931: goto -248 -> 683
    //   934: ldc_w 653
    //   937: aload 10
    //   939: getfield 617	com/tencent/mm/protocal/protobuf/cke:HwQ	Lcom/tencent/mm/protocal/protobuf/cta;
    //   942: getfield 624	com/tencent/mm/protocal/protobuf/cta:type	Ljava/lang/String;
    //   945: invokevirtual 406	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   948: ifeq -265 -> 683
    //   951: aload 11
    //   953: new 655	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 656	java/lang/StringBuilder:<init>	()V
    //   960: aload 10
    //   962: getfield 617	com/tencent/mm/protocal/protobuf/cke:HwQ	Lcom/tencent/mm/protocal/protobuf/cta;
    //   965: getfield 659	com/tencent/mm/protocal/protobuf/cta:number	I
    //   968: invokevirtual 663	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   971: invokevirtual 664	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: ldc_w 665
    //   977: invokevirtual 650	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:gF	(Ljava/lang/String;I)V
    //   980: aload 11
    //   982: iconst_0
    //   983: invokevirtual 651	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:acS	(I)V
    //   986: goto -303 -> 683
    //   989: aload 11
    //   991: iconst_0
    //   992: invokevirtual 666	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:acU	(I)V
    //   995: goto -245 -> 750
    //   998: aload_0
    //   999: getfield 36	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:vRw	Ljava/util/HashMap;
    //   1002: new 655	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 656	java/lang/StringBuilder:<init>	()V
    //   1009: iload_1
    //   1010: invokevirtual 663	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1013: aload 10
    //   1015: getfield 251	com/tencent/mm/protocal/protobuf/cke:name	Ljava/lang/String;
    //   1018: invokevirtual 669	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: aload 10
    //   1023: getfield 285	com/tencent/mm/protocal/protobuf/cke:uIW	I
    //   1026: invokevirtual 663	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1029: aload 10
    //   1031: getfield 567	com/tencent/mm/protocal/protobuf/cke:title	Ljava/lang/String;
    //   1034: invokevirtual 669	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: invokevirtual 664	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: aload 10
    //   1042: invokevirtual 636	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: pop
    //   1046: goto -263 -> 783
    //   1049: getstatic 315	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   1052: astore 11
    //   1054: iload_2
    //   1055: ifeq +54 -> 1109
    //   1058: iconst_1
    //   1059: istore_2
    //   1060: aload 11
    //   1062: sipush 14872
    //   1065: iconst_5
    //   1066: anewarray 219	java/lang/Object
    //   1069: dup
    //   1070: iconst_0
    //   1071: iconst_1
    //   1072: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1075: aastore
    //   1076: dup
    //   1077: iconst_1
    //   1078: iload_2
    //   1079: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1082: aastore
    //   1083: dup
    //   1084: iconst_2
    //   1085: aload 10
    //   1087: getfield 303	com/tencent/mm/protocal/protobuf/cke:DfC	Ljava/lang/String;
    //   1090: aastore
    //   1091: dup
    //   1092: iconst_3
    //   1093: ldc 237
    //   1095: aastore
    //   1096: dup
    //   1097: iconst_4
    //   1098: iconst_1
    //   1099: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1102: aastore
    //   1103: invokevirtual 319	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   1106: goto -707 -> 399
    //   1109: iconst_0
    //   1110: istore_2
    //   1111: goto -51 -> 1060
    //   1114: getstatic 315	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   1117: astore 11
    //   1119: iload_2
    //   1120: ifeq +54 -> 1174
    //   1123: iconst_1
    //   1124: istore_2
    //   1125: aload 11
    //   1127: sipush 14872
    //   1130: iconst_5
    //   1131: anewarray 219	java/lang/Object
    //   1134: dup
    //   1135: iconst_0
    //   1136: iconst_2
    //   1137: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1140: aastore
    //   1141: dup
    //   1142: iconst_1
    //   1143: iload_2
    //   1144: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1147: aastore
    //   1148: dup
    //   1149: iconst_2
    //   1150: ldc 237
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_3
    //   1155: aload 10
    //   1157: getfield 324	com/tencent/mm/protocal/protobuf/cke:CRv	Ljava/lang/String;
    //   1160: aastore
    //   1161: dup
    //   1162: iconst_4
    //   1163: iconst_1
    //   1164: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1167: aastore
    //   1168: invokevirtual 319	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   1171: goto -772 -> 399
    //   1174: iconst_0
    //   1175: istore_2
    //   1176: goto -51 -> 1125
    //   1179: getstatic 315	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   1182: astore 10
    //   1184: iload_2
    //   1185: ifeq +51 -> 1236
    //   1188: iconst_1
    //   1189: istore_2
    //   1190: aload 10
    //   1192: sipush 14872
    //   1195: iconst_5
    //   1196: anewarray 219	java/lang/Object
    //   1199: dup
    //   1200: iconst_0
    //   1201: iconst_3
    //   1202: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1205: aastore
    //   1206: dup
    //   1207: iconst_1
    //   1208: iload_2
    //   1209: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1212: aastore
    //   1213: dup
    //   1214: iconst_2
    //   1215: ldc 237
    //   1217: aastore
    //   1218: dup
    //   1219: iconst_3
    //   1220: ldc 237
    //   1222: aastore
    //   1223: dup
    //   1224: iconst_4
    //   1225: iconst_1
    //   1226: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1229: aastore
    //   1230: invokevirtual 319	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   1233: goto -834 -> 399
    //   1236: iconst_0
    //   1237: istore_2
    //   1238: goto -48 -> 1190
    //   1241: getstatic 315	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   1244: astore 10
    //   1246: iload_2
    //   1247: ifeq +51 -> 1298
    //   1250: iconst_1
    //   1251: istore_2
    //   1252: aload 10
    //   1254: sipush 14872
    //   1257: iconst_5
    //   1258: anewarray 219	java/lang/Object
    //   1261: dup
    //   1262: iconst_0
    //   1263: iconst_4
    //   1264: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1267: aastore
    //   1268: dup
    //   1269: iconst_1
    //   1270: iload_2
    //   1271: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1274: aastore
    //   1275: dup
    //   1276: iconst_2
    //   1277: ldc 237
    //   1279: aastore
    //   1280: dup
    //   1281: iconst_3
    //   1282: ldc 237
    //   1284: aastore
    //   1285: dup
    //   1286: iconst_4
    //   1287: iconst_1
    //   1288: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1291: aastore
    //   1292: invokevirtual 319	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   1295: goto -896 -> 399
    //   1298: iconst_0
    //   1299: istore_2
    //   1300: goto -48 -> 1252
    //   1303: getstatic 315	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   1306: astore 10
    //   1308: iload_2
    //   1309: ifeq +51 -> 1360
    //   1312: iconst_1
    //   1313: istore_2
    //   1314: aload 10
    //   1316: sipush 14872
    //   1319: iconst_5
    //   1320: anewarray 219	java/lang/Object
    //   1323: dup
    //   1324: iconst_0
    //   1325: iconst_5
    //   1326: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1329: aastore
    //   1330: dup
    //   1331: iconst_1
    //   1332: iload_2
    //   1333: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1336: aastore
    //   1337: dup
    //   1338: iconst_2
    //   1339: ldc 237
    //   1341: aastore
    //   1342: dup
    //   1343: iconst_3
    //   1344: ldc 237
    //   1346: aastore
    //   1347: dup
    //   1348: iconst_4
    //   1349: iconst_1
    //   1350: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1353: aastore
    //   1354: invokevirtual 319	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   1357: goto -958 -> 399
    //   1360: iconst_0
    //   1361: istore_2
    //   1362: goto -48 -> 1314
    //   1365: getstatic 315	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   1368: astore 11
    //   1370: iload_2
    //   1371: ifeq +55 -> 1426
    //   1374: iconst_1
    //   1375: istore_2
    //   1376: aload 11
    //   1378: sipush 14872
    //   1381: iconst_5
    //   1382: anewarray 219	java/lang/Object
    //   1385: dup
    //   1386: iconst_0
    //   1387: bipush 8
    //   1389: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1392: aastore
    //   1393: dup
    //   1394: iconst_1
    //   1395: iload_2
    //   1396: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1399: aastore
    //   1400: dup
    //   1401: iconst_2
    //   1402: aload 10
    //   1404: getfield 303	com/tencent/mm/protocal/protobuf/cke:DfC	Ljava/lang/String;
    //   1407: aastore
    //   1408: dup
    //   1409: iconst_3
    //   1410: ldc 237
    //   1412: aastore
    //   1413: dup
    //   1414: iconst_4
    //   1415: iconst_1
    //   1416: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1419: aastore
    //   1420: invokevirtual 319	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   1423: goto -575 -> 848
    //   1426: iconst_0
    //   1427: istore_2
    //   1428: goto -52 -> 1376
    //   1431: iconst_0
    //   1432: istore_2
    //   1433: goto -1164 -> 269
    //   1436: aload_3
    //   1437: invokevirtual 268	org/json/JSONObject:length	()I
    //   1440: ifle +42 -> 1482
    //   1443: ldc 215
    //   1445: ldc_w 671
    //   1448: iconst_1
    //   1449: anewarray 219	java/lang/Object
    //   1452: dup
    //   1453: iconst_0
    //   1454: aload_3
    //   1455: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1458: aastore
    //   1459: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1462: invokestatic 51	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   1465: pop
    //   1466: invokestatic 55	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   1469: invokevirtual 61	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   1472: getstatic 235	com/tencent/mm/storage/am$a:IWs	Lcom/tencent/mm/storage/am$a;
    //   1475: aload_3
    //   1476: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1479: invokevirtual 162	com/tencent/mm/storage/aj:set	(Lcom/tencent/mm/storage/am$a;Ljava/lang/Object;)V
    //   1482: ldc_w 483
    //   1485: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1488: return
    //   1489: goto -847 -> 642
    //   1492: goto -59 -> 1433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1495	0	this	MallIndexMenuUI
    //   0	1495	1	paramInt1	int
    //   0	1495	2	paramInt2	int
    //   0	1495	3	paramString	String
    //   0	1495	4	paramn	com.tencent.mm.ak.n
    //   387	227	5	l1	long
    //   564	52	7	l2	long
    //   63	347	9	localObject1	Object
    //   361	1042	10	localObject2	Object
    //   449	928	11	localObject3	Object
    //   866	16	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   213	224	856	org/json/JSONException
    //   631	642	866	java/lang/Exception
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexMenuUI
 * JD-Core Version:    0.7.0.1
 */