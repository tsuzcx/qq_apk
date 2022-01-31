package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class MallIndexMenuUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private int oxO;
  private List<blo> ozG;
  private HashMap<String, bln> ozH;
  private boolean ozI;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public MallIndexMenuUI()
  {
    AppMethodBeat.i(43171);
    this.ozH = new HashMap();
    AppMethodBeat.o(43171);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(43176);
    if (paramInt1 == 1)
    {
      com.tencent.mm.kernel.g.RM();
      this.oxO = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
      if (paramInt2 == -1)
      {
        if (r.ZC())
        {
          finish();
          AppMethodBeat.o(43176);
          return;
        }
        finish();
        paramIntent = new ou();
        paramIntent.cFt.context = getContext();
        com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
      }
    }
    AppMethodBeat.o(43176);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43172);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    this.ozI = getIntent().getBooleanExtra("key_default_show_currency", false);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIM, Boolean.FALSE);
    setBackBtn(new MallIndexMenuUI.1(this));
    this.screen = getPreferenceScreen();
    setMMTitle(2131301447);
    com.tencent.mm.kernel.g.Rc().a(1754, this);
    paramBundle = new com.tencent.mm.plugin.mall.a.g();
    com.tencent.mm.kernel.g.Rc().a(paramBundle, 0);
    AppMethodBeat.o(43172);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43173);
    super.onDestroy();
    com.tencent.mm.kernel.g.Rc().b(1754, this);
    AppMethodBeat.o(43173);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(43174);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.MallIndexMenuUI", "onPreferenceTreeClick, key: %s", new Object[] { paramf });
    bln localbln = (bln)this.ozH.get(paramf);
    Object localObject;
    if (localbln != null)
    {
      paramf = new JSONObject();
      com.tencent.mm.kernel.g.RM();
      localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIL, "");
      if (bo.isNullOrNil((String)localObject)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        paramf = (com.tencent.mm.ui.base.preference.f)localObject;
        if (paramf.optInt(localbln.name, 0) != 1) {
          break label1259;
        }
        paramf.remove(localbln.name);
        paramf.remove(String.format("%s_expiretime", new Object[] { localbln.name }));
        if (paramf.length() > 0) {
          break label298;
        }
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIL, "");
        if ((paramPreference instanceof IconPreference))
        {
          ((IconPreference)paramPreference).ON(8);
          ((IconPreference)paramPreference).OL(8);
          ((IconPreference)paramPreference).OM(8);
          ((IconPreference)paramPreference).qI(false);
        }
        i = 1;
        switch (localbln.pdt)
        {
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(43174);
          return true;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MallIndexMenuUI", localException, "parse redDotConfig json failed: %s", new Object[] { localException.getMessage() });
      }
      continue;
      label298:
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIL, paramf.toString());
      continue;
      ab.i("MicroMsg.MallIndexMenuUI", "jump type h5, url: %s", new Object[] { localbln.uaJ });
      if (!bo.isNullOrNil(localbln.uaJ)) {
        com.tencent.mm.wallet_core.ui.e.m(this, localbln.uaJ, false);
      }
      paramf = h.qsU;
      if (i != 0) {}
      for (int i = 1;; i = 0)
      {
        paramf.e(14872, new Object[] { Integer.valueOf(1), Integer.valueOf(i), localbln.uaJ, "", Integer.valueOf(0) });
        break;
      }
      ab.i("MicroMsg.MallIndexMenuUI", "jump type tiny app, username: %s, path: %s", new Object[] { localbln.ugl, localbln.ugl });
      if (!bo.isNullOrNil(localbln.ugl))
      {
        paramf = new so();
        paramf.cIQ.userName = localbln.ugl;
        paramf.cIQ.cIS = bo.bf(localbln.uaL, "");
        paramf.cIQ.scene = 1066;
        paramf.cIQ.cIT = 0;
        com.tencent.mm.sdk.b.a.ymk.l(paramf);
      }
      paramf = h.qsU;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.e(14872, new Object[] { Integer.valueOf(2), Integer.valueOf(i), "", localbln.ugl, Integer.valueOf(0) });
        break;
      }
      ab.i("MicroMsg.MallIndexMenuUI", "jump type payment management");
      d.H(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
      paramf = h.qsU;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.e(14872, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      ab.i("MicroMsg.MallIndexMenuUI", "jump type payment security");
      paramf = new Intent();
      paramf.putExtra("wallet_lock_jsapi_scene", 1);
      d.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", paramf);
      paramf = h.qsU;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.e(14872, new Object[] { Integer.valueOf(4), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        new bt();
        break;
      }
      ab.i("MicroMsg.MallIndexMenuUI", "jump type wallet switch");
      d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      paramf = h.qsU;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.e(14872, new Object[] { Integer.valueOf(5), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      ab.i("MicroMsg.MallIndexMenuUI", "jump type honey pay");
      d.H(this, "honey_pay", ".ui.HoneyPayMainUI");
      paramf = h.qsU;
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        paramf.e(14872, new Object[] { Integer.valueOf(8), Integer.valueOf(i), "", "", Integer.valueOf(0) });
        break;
      }
      if ("pay_my_msg".equals(paramf))
      {
        paramf = t.cTN().cUt();
        boolean bool;
        if ((paramf.ulJ & 0x10000) > 0)
        {
          bool = true;
          ab.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramf.ulJ) });
          if (!bool) {
            break label1045;
          }
          paramf = new Intent();
          paramf.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
          d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.ui.e.RX(20);
          AppMethodBeat.o(43174);
          return true;
          bool = false;
          break;
          label1045:
          com.tencent.mm.wallet_core.a.b(this, "ShowOrdersInfoProcess", null);
        }
      }
      if ("pay_manage".equals(paramf))
      {
        if (r.ZB()) {
          d.H(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.ui.e.RX(21);
          AppMethodBeat.o(43174);
          return true;
          d.H(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
        }
      }
      if ("pay_security".equals(paramf))
      {
        d.H(this, "wallet", ".pwd.ui.WalletSecuritySettingUI");
        com.tencent.mm.wallet_core.ui.e.RX(22);
        paramf = new bt();
        paramf.cRI = 11L;
        paramf.cYT = 1L;
        paramf.ake();
      }
      do
      {
        AppMethodBeat.o(43174);
        return false;
        if ("pay_help_center".equals(paramf))
        {
          paramPreference = new Intent();
          if (r.ZB()) {}
          for (paramf = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";; paramf = "https://kf.qq.com/touch/scene_product.html?scene_id=kf1")
          {
            paramPreference.putExtra("rawUrl", paramf);
            d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
            com.tencent.mm.wallet_core.ui.e.RX(23);
            AppMethodBeat.o(43174);
            return true;
          }
        }
      } while (!"pay_wallet_switch".equals(paramf));
      d.c(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
      AppMethodBeat.o(43174);
      return true;
      label1259:
      i = 0;
    }
  }
  
  /* Error */
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    // Byte code:
    //   0: ldc_w 488
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 215
    //   8: ldc_w 490
    //   11: iconst_2
    //   12: anewarray 219	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: iload_2
    //   25: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: iload_1
    //   33: ifne +7 -> 40
    //   36: iload_2
    //   37: ifeq +18 -> 55
    //   40: ldc 215
    //   42: ldc_w 492
    //   45: invokestatic 494	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 488
    //   51: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: aload 4
    //   57: checkcast 191	com/tencent/mm/plugin/mall/a/g
    //   60: getfield 498	com/tencent/mm/plugin/mall/a/g:oxQ	Lcom/tencent/mm/protocal/protobuf/anw;
    //   63: astore 9
    //   65: aload 9
    //   67: getfield 503	com/tencent/mm/protocal/protobuf/anw:title	Ljava/lang/String;
    //   70: astore_3
    //   71: aload 9
    //   73: getfield 507	com/tencent/mm/protocal/protobuf/anw:xea	Ljava/util/LinkedList;
    //   76: astore 4
    //   78: aload 9
    //   80: getfield 507	com/tencent/mm/protocal/protobuf/anw:xea	Ljava/util/LinkedList;
    //   83: ifnull +760 -> 843
    //   86: aload 9
    //   88: getfield 507	com/tencent/mm/protocal/protobuf/anw:xea	Ljava/util/LinkedList;
    //   91: invokevirtual 512	java/util/LinkedList:size	()I
    //   94: istore_1
    //   95: ldc 215
    //   97: ldc_w 514
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
    //   116: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aastore
    //   120: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: ldc 215
    //   125: ldc_w 516
    //   128: iconst_1
    //   129: anewarray 219	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload 9
    //   136: aastore
    //   137: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload 9
    //   142: ifnull +1332 -> 1474
    //   145: aload_0
    //   146: getfield 175	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   149: invokeinterface 521 1 0
    //   154: aload 9
    //   156: getfield 503	com/tencent/mm/protocal/protobuf/anw:title	Ljava/lang/String;
    //   159: invokestatic 245	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   162: ifne +12 -> 174
    //   165: aload_0
    //   166: aload 9
    //   168: getfield 503	com/tencent/mm/protocal/protobuf/anw:title	Ljava/lang/String;
    //   171: invokevirtual 523	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:setMMTitle	(Ljava/lang/String;)V
    //   174: new 231	org/json/JSONObject
    //   177: dup
    //   178: invokespecial 232	org/json/JSONObject:<init>	()V
    //   181: astore_3
    //   182: invokestatic 49	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   185: pop
    //   186: invokestatic 53	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   189: invokevirtual 59	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   192: getstatic 235	com/tencent/mm/storage/ac$a:yIL	Lcom/tencent/mm/storage/ac$a;
    //   195: ldc 237
    //   197: invokevirtual 77	com/tencent/mm/storage/z:get	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: checkcast 239	java/lang/String
    //   203: astore 4
    //   205: aload 4
    //   207: invokestatic 245	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   210: ifne +640 -> 850
    //   213: new 231	org/json/JSONObject
    //   216: dup
    //   217: aload 4
    //   219: invokespecial 248	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   222: astore 4
    //   224: aload 4
    //   226: astore_3
    //   227: aload 9
    //   229: getfield 507	com/tencent/mm/protocal/protobuf/anw:xea	Ljava/util/LinkedList;
    //   232: ifnull +1196 -> 1428
    //   235: aload 9
    //   237: getfield 507	com/tencent/mm/protocal/protobuf/anw:xea	Ljava/util/LinkedList;
    //   240: invokevirtual 512	java/util/LinkedList:size	()I
    //   243: ifle +1185 -> 1428
    //   246: aload_0
    //   247: aload 9
    //   249: getfield 507	com/tencent/mm/protocal/protobuf/anw:xea	Ljava/util/LinkedList;
    //   252: putfield 525	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:ozG	Ljava/util/List;
    //   255: iconst_1
    //   256: istore_2
    //   257: aload 9
    //   259: getfield 507	com/tencent/mm/protocal/protobuf/anw:xea	Ljava/util/LinkedList;
    //   262: invokevirtual 529	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   265: astore 4
    //   267: iconst_0
    //   268: istore_1
    //   269: aload 4
    //   271: invokeinterface 534 1 0
    //   276: ifeq +1152 -> 1428
    //   279: aload 4
    //   281: invokeinterface 538 1 0
    //   286: checkcast 540	com/tencent/mm/protocal/protobuf/blo
    //   289: astore 9
    //   291: aload 9
    //   293: getfield 543	com/tencent/mm/protocal/protobuf/blo:xAl	Ljava/util/LinkedList;
    //   296: ifnull +1188 -> 1484
    //   299: aload 9
    //   301: getfield 543	com/tencent/mm/protocal/protobuf/blo:xAl	Ljava/util/LinkedList;
    //   304: invokevirtual 512	java/util/LinkedList:size	()I
    //   307: ifle +1177 -> 1484
    //   310: iload_2
    //   311: ifne +31 -> 342
    //   314: aload 9
    //   316: getfield 544	com/tencent/mm/protocal/protobuf/blo:title	Ljava/lang/String;
    //   319: invokestatic 245	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   322: ifeq +20 -> 342
    //   325: aload_0
    //   326: getfield 175	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   329: new 546	com/tencent/mm/ui/base/preference/PreferenceSmallCategory
    //   332: dup
    //   333: aload_0
    //   334: invokespecial 549	com/tencent/mm/ui/base/preference/PreferenceSmallCategory:<init>	(Landroid/content/Context;)V
    //   337: invokeinterface 552 2 0
    //   342: aload 9
    //   344: getfield 544	com/tencent/mm/protocal/protobuf/blo:title	Ljava/lang/String;
    //   347: invokestatic 245	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   350: ifne +34 -> 384
    //   353: new 554	com/tencent/mm/ui/base/preference/PreferenceTitleCategory
    //   356: dup
    //   357: aload_0
    //   358: invokespecial 555	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:<init>	(Landroid/content/Context;)V
    //   361: astore 10
    //   363: aload 10
    //   365: aload 9
    //   367: getfield 544	com/tencent/mm/protocal/protobuf/blo:title	Ljava/lang/String;
    //   370: invokevirtual 559	com/tencent/mm/ui/base/preference/PreferenceTitleCategory:setTitle	(Ljava/lang/CharSequence;)V
    //   373: aload_0
    //   374: getfield 175	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   377: aload 10
    //   379: invokeinterface 552 2 0
    //   384: invokestatic 565	java/lang/System:currentTimeMillis	()J
    //   387: lstore 5
    //   389: aload 9
    //   391: getfield 543	com/tencent/mm/protocal/protobuf/blo:xAl	Ljava/util/LinkedList;
    //   394: invokevirtual 529	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   397: astore 9
    //   399: aload 9
    //   401: invokeinterface 534 1 0
    //   406: ifeq +1017 -> 1423
    //   409: aload 9
    //   411: invokeinterface 538 1 0
    //   416: checkcast 229	com/tencent/mm/protocal/protobuf/bln
    //   419: astore 10
    //   421: ldc 215
    //   423: ldc_w 567
    //   426: iconst_1
    //   427: anewarray 219	java/lang/Object
    //   430: dup
    //   431: iconst_0
    //   432: aload 10
    //   434: getfield 251	com/tencent/mm/protocal/protobuf/bln:name	Ljava/lang/String;
    //   437: aastore
    //   438: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: new 569	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference
    //   444: dup
    //   445: aload_0
    //   446: invokespecial 570	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:<init>	(Landroid/content/Context;)V
    //   449: astore 11
    //   451: aload 10
    //   453: getfield 571	com/tencent/mm/protocal/protobuf/bln:title	Ljava/lang/String;
    //   456: invokestatic 245	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   459: ifne +13 -> 472
    //   462: aload 11
    //   464: aload 10
    //   466: getfield 571	com/tencent/mm/protocal/protobuf/bln:title	Ljava/lang/String;
    //   469: invokevirtual 572	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setTitle	(Ljava/lang/CharSequence;)V
    //   472: aload 10
    //   474: getfield 575	com/tencent/mm/protocal/protobuf/bln:desc	Ljava/lang/String;
    //   477: invokestatic 245	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   480: ifne +26 -> 506
    //   483: aload 11
    //   485: iconst_0
    //   486: invokevirtual 576	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:OM	(I)V
    //   489: aload 11
    //   491: aload 10
    //   493: getfield 575	com/tencent/mm/protocal/protobuf/bln:desc	Ljava/lang/String;
    //   496: iconst_m1
    //   497: ldc_w 578
    //   500: invokestatic 584	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   503: invokevirtual 588	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aG	(Ljava/lang/String;II)V
    //   506: aload 10
    //   508: getfield 591	com/tencent/mm/protocal/protobuf/bln:kmm	Ljava/lang/String;
    //   511: invokestatic 245	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   514: ifne +13 -> 527
    //   517: aload 11
    //   519: aload 10
    //   521: getfield 591	com/tencent/mm/protocal/protobuf/bln:kmm	Ljava/lang/String;
    //   524: putfield 594	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:iconUrl	Ljava/lang/String;
    //   527: aload 11
    //   529: aload 10
    //   531: getfield 251	com/tencent/mm/protocal/protobuf/bln:name	Ljava/lang/String;
    //   534: invokevirtual 597	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:setKey	(Ljava/lang/String;)V
    //   537: aload_3
    //   538: ldc_w 261
    //   541: iconst_1
    //   542: anewarray 219	java/lang/Object
    //   545: dup
    //   546: iconst_0
    //   547: aload 10
    //   549: getfield 251	com/tencent/mm/protocal/protobuf/bln:name	Ljava/lang/String;
    //   552: aastore
    //   553: invokestatic 265	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   556: lconst_0
    //   557: invokevirtual 601	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   560: lstore 7
    //   562: ldc 215
    //   564: ldc_w 603
    //   567: iconst_1
    //   568: anewarray 219	java/lang/Object
    //   571: dup
    //   572: iconst_0
    //   573: lload 7
    //   575: invokestatic 608	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   578: aastore
    //   579: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   582: aload_3
    //   583: aload 10
    //   585: getfield 251	com/tencent/mm/protocal/protobuf/bln:name	Ljava/lang/String;
    //   588: iconst_0
    //   589: invokevirtual 255	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   592: iconst_1
    //   593: if_icmpne +260 -> 853
    //   596: iconst_1
    //   597: istore_2
    //   598: iload_2
    //   599: ifeq +882 -> 1481
    //   602: lload 7
    //   604: lconst_0
    //   605: lcmp
    //   606: ifle +875 -> 1481
    //   609: lload 5
    //   611: lload 7
    //   613: lcmp
    //   614: iflt +867 -> 1481
    //   617: ldc 215
    //   619: ldc_w 610
    //   622: invokestatic 357	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   625: iconst_0
    //   626: istore_2
    //   627: aload_3
    //   628: aload 10
    //   630: getfield 251	com/tencent/mm/protocal/protobuf/bln:name	Ljava/lang/String;
    //   633: iconst_0
    //   634: invokevirtual 614	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   637: pop
    //   638: iload_2
    //   639: ifeq +103 -> 742
    //   642: aload 10
    //   644: getfield 618	com/tencent/mm/protocal/protobuf/bln:xAk	Lcom/tencent/mm/protocal/protobuf/bst;
    //   647: ifnull +334 -> 981
    //   650: ldc_w 620
    //   653: aload 10
    //   655: getfield 618	com/tencent/mm/protocal/protobuf/bln:xAk	Lcom/tencent/mm/protocal/protobuf/bst;
    //   658: getfield 625	com/tencent/mm/protocal/protobuf/bst:type	Ljava/lang/String;
    //   661: invokevirtual 406	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifeq +221 -> 885
    //   667: aload 11
    //   669: iconst_0
    //   670: invokevirtual 576	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:OM	(I)V
    //   673: aload 11
    //   675: iconst_1
    //   676: invokevirtual 626	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:qI	(Z)V
    //   679: aload 10
    //   681: getfield 618	com/tencent/mm/protocal/protobuf/bln:xAk	Lcom/tencent/mm/protocal/protobuf/bst;
    //   684: getfield 629	com/tencent/mm/protocal/protobuf/bst:cyA	Ljava/lang/String;
    //   687: invokestatic 245	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   690: ifne +52 -> 742
    //   693: ldc 215
    //   695: ldc_w 631
    //   698: iconst_1
    //   699: anewarray 219	java/lang/Object
    //   702: dup
    //   703: iconst_0
    //   704: aload 10
    //   706: getfield 618	com/tencent/mm/protocal/protobuf/bln:xAk	Lcom/tencent/mm/protocal/protobuf/bst;
    //   709: getfield 629	com/tencent/mm/protocal/protobuf/bst:cyA	Ljava/lang/String;
    //   712: aastore
    //   713: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   716: aload 11
    //   718: aload 10
    //   720: getfield 618	com/tencent/mm/protocal/protobuf/bln:xAk	Lcom/tencent/mm/protocal/protobuf/bst;
    //   723: getfield 629	com/tencent/mm/protocal/protobuf/bst:cyA	Ljava/lang/String;
    //   726: iconst_m1
    //   727: ldc_w 578
    //   730: invokestatic 584	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   733: invokevirtual 588	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:aG	(Ljava/lang/String;II)V
    //   736: aload 11
    //   738: iconst_0
    //   739: invokevirtual 576	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:OM	(I)V
    //   742: aload 11
    //   744: bipush 8
    //   746: invokevirtual 634	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:OQ	(I)V
    //   749: aload 10
    //   751: getfield 251	com/tencent/mm/protocal/protobuf/bln:name	Ljava/lang/String;
    //   754: invokestatic 245	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   757: ifne +233 -> 990
    //   760: aload_0
    //   761: getfield 34	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:ozH	Ljava/util/HashMap;
    //   764: aload 10
    //   766: getfield 251	com/tencent/mm/protocal/protobuf/bln:name	Ljava/lang/String;
    //   769: aload 10
    //   771: invokevirtual 637	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   774: pop
    //   775: aload_0
    //   776: getfield 175	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:screen	Lcom/tencent/mm/ui/base/preference/f;
    //   779: aload 11
    //   781: invokeinterface 552 2 0
    //   786: iload_1
    //   787: iconst_1
    //   788: iadd
    //   789: istore_1
    //   790: aload 10
    //   792: getfield 285	com/tencent/mm/protocal/protobuf/bln:pdt	I
    //   795: tableswitch	default:+45 -> 840, 1:+246->1041, 2:+311->1106, 3:+376->1171, 4:+438->1233, 5:+500->1295, 6:+45->840, 7:+45->840, 8:+562->1357
    //   841: impdep1
    //   842: dstore_0
    //   843: iconst_0
    //   844: istore_1
    //   845: goto -750 -> 95
    //   848: astore 4
    //   850: goto -623 -> 227
    //   853: iconst_0
    //   854: istore_2
    //   855: goto -257 -> 598
    //   858: astore 12
    //   860: ldc 215
    //   862: aload 12
    //   864: ldc_w 639
    //   867: iconst_1
    //   868: anewarray 219	java/lang/Object
    //   871: dup
    //   872: iconst_0
    //   873: aload 12
    //   875: invokevirtual 291	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   878: aastore
    //   879: invokestatic 295	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   882: goto -244 -> 638
    //   885: ldc_w 641
    //   888: aload 10
    //   890: getfield 618	com/tencent/mm/protocal/protobuf/bln:xAk	Lcom/tencent/mm/protocal/protobuf/bst;
    //   893: getfield 625	com/tencent/mm/protocal/protobuf/bst:type	Ljava/lang/String;
    //   896: invokevirtual 406	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   899: ifeq +27 -> 926
    //   902: aload 11
    //   904: aload_0
    //   905: ldc_w 642
    //   908: invokevirtual 646	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:getString	(I)Ljava/lang/String;
    //   911: ldc_w 647
    //   914: invokevirtual 651	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:eN	(Ljava/lang/String;I)V
    //   917: aload 11
    //   919: iconst_0
    //   920: invokevirtual 652	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:OL	(I)V
    //   923: goto -244 -> 679
    //   926: ldc_w 654
    //   929: aload 10
    //   931: getfield 618	com/tencent/mm/protocal/protobuf/bln:xAk	Lcom/tencent/mm/protocal/protobuf/bst;
    //   934: getfield 625	com/tencent/mm/protocal/protobuf/bst:type	Ljava/lang/String;
    //   937: invokevirtual 406	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   940: ifeq -261 -> 679
    //   943: aload 11
    //   945: new 656	java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial 657	java/lang/StringBuilder:<init>	()V
    //   952: aload 10
    //   954: getfield 618	com/tencent/mm/protocal/protobuf/bln:xAk	Lcom/tencent/mm/protocal/protobuf/bst;
    //   957: getfield 660	com/tencent/mm/protocal/protobuf/bst:number	I
    //   960: invokevirtual 664	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   963: invokevirtual 665	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: ldc_w 666
    //   969: invokevirtual 651	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:eN	(Ljava/lang/String;I)V
    //   972: aload 11
    //   974: iconst_0
    //   975: invokevirtual 652	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:OL	(I)V
    //   978: goto -299 -> 679
    //   981: aload 11
    //   983: iconst_0
    //   984: invokevirtual 667	com/tencent/mm/plugin/mall/ui/CdnImageIconPreference:ON	(I)V
    //   987: goto -245 -> 742
    //   990: aload_0
    //   991: getfield 34	com/tencent/mm/plugin/mall/ui/MallIndexMenuUI:ozH	Ljava/util/HashMap;
    //   994: new 656	java/lang/StringBuilder
    //   997: dup
    //   998: invokespecial 657	java/lang/StringBuilder:<init>	()V
    //   1001: iload_1
    //   1002: invokevirtual 664	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1005: aload 10
    //   1007: getfield 251	com/tencent/mm/protocal/protobuf/bln:name	Ljava/lang/String;
    //   1010: invokevirtual 670	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: aload 10
    //   1015: getfield 285	com/tencent/mm/protocal/protobuf/bln:pdt	I
    //   1018: invokevirtual 664	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1021: aload 10
    //   1023: getfield 571	com/tencent/mm/protocal/protobuf/bln:title	Ljava/lang/String;
    //   1026: invokevirtual 670	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 665	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: aload 10
    //   1034: invokevirtual 637	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1037: pop
    //   1038: goto -263 -> 775
    //   1041: getstatic 315	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1044: astore 11
    //   1046: iload_2
    //   1047: ifeq +54 -> 1101
    //   1050: iconst_1
    //   1051: istore_2
    //   1052: aload 11
    //   1054: sipush 14872
    //   1057: iconst_5
    //   1058: anewarray 219	java/lang/Object
    //   1061: dup
    //   1062: iconst_0
    //   1063: iconst_1
    //   1064: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1067: aastore
    //   1068: dup
    //   1069: iconst_1
    //   1070: iload_2
    //   1071: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1074: aastore
    //   1075: dup
    //   1076: iconst_2
    //   1077: aload 10
    //   1079: getfield 303	com/tencent/mm/protocal/protobuf/bln:uaJ	Ljava/lang/String;
    //   1082: aastore
    //   1083: dup
    //   1084: iconst_3
    //   1085: ldc 237
    //   1087: aastore
    //   1088: dup
    //   1089: iconst_4
    //   1090: iconst_1
    //   1091: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1094: aastore
    //   1095: invokevirtual 319	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   1098: goto -699 -> 399
    //   1101: iconst_0
    //   1102: istore_2
    //   1103: goto -51 -> 1052
    //   1106: getstatic 315	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1109: astore 11
    //   1111: iload_2
    //   1112: ifeq +54 -> 1166
    //   1115: iconst_1
    //   1116: istore_2
    //   1117: aload 11
    //   1119: sipush 14872
    //   1122: iconst_5
    //   1123: anewarray 219	java/lang/Object
    //   1126: dup
    //   1127: iconst_0
    //   1128: iconst_2
    //   1129: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1132: aastore
    //   1133: dup
    //   1134: iconst_1
    //   1135: iload_2
    //   1136: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1139: aastore
    //   1140: dup
    //   1141: iconst_2
    //   1142: ldc 237
    //   1144: aastore
    //   1145: dup
    //   1146: iconst_3
    //   1147: aload 10
    //   1149: getfield 324	com/tencent/mm/protocal/protobuf/bln:ugl	Ljava/lang/String;
    //   1152: aastore
    //   1153: dup
    //   1154: iconst_4
    //   1155: iconst_1
    //   1156: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1159: aastore
    //   1160: invokevirtual 319	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   1163: goto -764 -> 399
    //   1166: iconst_0
    //   1167: istore_2
    //   1168: goto -51 -> 1117
    //   1171: getstatic 315	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1174: astore 10
    //   1176: iload_2
    //   1177: ifeq +51 -> 1228
    //   1180: iconst_1
    //   1181: istore_2
    //   1182: aload 10
    //   1184: sipush 14872
    //   1187: iconst_5
    //   1188: anewarray 219	java/lang/Object
    //   1191: dup
    //   1192: iconst_0
    //   1193: iconst_3
    //   1194: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1197: aastore
    //   1198: dup
    //   1199: iconst_1
    //   1200: iload_2
    //   1201: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1204: aastore
    //   1205: dup
    //   1206: iconst_2
    //   1207: ldc 237
    //   1209: aastore
    //   1210: dup
    //   1211: iconst_3
    //   1212: ldc 237
    //   1214: aastore
    //   1215: dup
    //   1216: iconst_4
    //   1217: iconst_1
    //   1218: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1221: aastore
    //   1222: invokevirtual 319	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   1225: goto -826 -> 399
    //   1228: iconst_0
    //   1229: istore_2
    //   1230: goto -48 -> 1182
    //   1233: getstatic 315	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1236: astore 10
    //   1238: iload_2
    //   1239: ifeq +51 -> 1290
    //   1242: iconst_1
    //   1243: istore_2
    //   1244: aload 10
    //   1246: sipush 14872
    //   1249: iconst_5
    //   1250: anewarray 219	java/lang/Object
    //   1253: dup
    //   1254: iconst_0
    //   1255: iconst_4
    //   1256: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1259: aastore
    //   1260: dup
    //   1261: iconst_1
    //   1262: iload_2
    //   1263: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1266: aastore
    //   1267: dup
    //   1268: iconst_2
    //   1269: ldc 237
    //   1271: aastore
    //   1272: dup
    //   1273: iconst_3
    //   1274: ldc 237
    //   1276: aastore
    //   1277: dup
    //   1278: iconst_4
    //   1279: iconst_1
    //   1280: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1283: aastore
    //   1284: invokevirtual 319	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   1287: goto -888 -> 399
    //   1290: iconst_0
    //   1291: istore_2
    //   1292: goto -48 -> 1244
    //   1295: getstatic 315	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1298: astore 10
    //   1300: iload_2
    //   1301: ifeq +51 -> 1352
    //   1304: iconst_1
    //   1305: istore_2
    //   1306: aload 10
    //   1308: sipush 14872
    //   1311: iconst_5
    //   1312: anewarray 219	java/lang/Object
    //   1315: dup
    //   1316: iconst_0
    //   1317: iconst_5
    //   1318: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1321: aastore
    //   1322: dup
    //   1323: iconst_1
    //   1324: iload_2
    //   1325: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1328: aastore
    //   1329: dup
    //   1330: iconst_2
    //   1331: ldc 237
    //   1333: aastore
    //   1334: dup
    //   1335: iconst_3
    //   1336: ldc 237
    //   1338: aastore
    //   1339: dup
    //   1340: iconst_4
    //   1341: iconst_1
    //   1342: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1345: aastore
    //   1346: invokevirtual 319	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   1349: goto -950 -> 399
    //   1352: iconst_0
    //   1353: istore_2
    //   1354: goto -48 -> 1306
    //   1357: getstatic 315	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1360: astore 11
    //   1362: iload_2
    //   1363: ifeq +55 -> 1418
    //   1366: iconst_1
    //   1367: istore_2
    //   1368: aload 11
    //   1370: sipush 14872
    //   1373: iconst_5
    //   1374: anewarray 219	java/lang/Object
    //   1377: dup
    //   1378: iconst_0
    //   1379: bipush 8
    //   1381: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1384: aastore
    //   1385: dup
    //   1386: iconst_1
    //   1387: iload_2
    //   1388: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1391: aastore
    //   1392: dup
    //   1393: iconst_2
    //   1394: aload 10
    //   1396: getfield 303	com/tencent/mm/protocal/protobuf/bln:uaJ	Ljava/lang/String;
    //   1399: aastore
    //   1400: dup
    //   1401: iconst_3
    //   1402: ldc 237
    //   1404: aastore
    //   1405: dup
    //   1406: iconst_4
    //   1407: iconst_1
    //   1408: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1411: aastore
    //   1412: invokevirtual 319	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   1415: goto -575 -> 840
    //   1418: iconst_0
    //   1419: istore_2
    //   1420: goto -52 -> 1368
    //   1423: iconst_0
    //   1424: istore_2
    //   1425: goto -1156 -> 269
    //   1428: aload_3
    //   1429: invokevirtual 268	org/json/JSONObject:length	()I
    //   1432: ifle +42 -> 1474
    //   1435: ldc 215
    //   1437: ldc_w 672
    //   1440: iconst_1
    //   1441: anewarray 219	java/lang/Object
    //   1444: dup
    //   1445: iconst_0
    //   1446: aload_3
    //   1447: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1450: aastore
    //   1451: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1454: invokestatic 49	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   1457: pop
    //   1458: invokestatic 53	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   1461: invokevirtual 59	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   1464: getstatic 235	com/tencent/mm/storage/ac$a:yIL	Lcom/tencent/mm/storage/ac$a;
    //   1467: aload_3
    //   1468: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1471: invokevirtual 160	com/tencent/mm/storage/z:set	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)V
    //   1474: ldc_w 488
    //   1477: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1480: return
    //   1481: goto -843 -> 638
    //   1484: goto -59 -> 1425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1487	0	this	MallIndexMenuUI
    //   0	1487	1	paramInt1	int
    //   0	1487	2	paramInt2	int
    //   0	1487	3	paramString	String
    //   0	1487	4	paramm	com.tencent.mm.ai.m
    //   387	223	5	l1	long
    //   560	52	7	l2	long
    //   63	347	9	localObject1	Object
    //   361	1034	10	localObject2	Object
    //   449	920	11	localObject3	Object
    //   858	16	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   213	224	848	org/json/JSONException
    //   627	638	858	java/lang/Exception
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