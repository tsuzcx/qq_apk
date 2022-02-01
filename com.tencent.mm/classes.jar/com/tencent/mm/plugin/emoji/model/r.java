package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bw;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.g.b;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.j;
import java.util.ArrayList;

public final class r
{
  private final String TAG;
  private Context mAppContext;
  private cjb xHE;
  public com.tencent.mm.plugin.emoji.a.a.a xNj;
  public boolean xNk;
  public Context xNl;
  public Fragment xNm;
  public int xNn;
  public long xNo;
  public String xNp;
  public b xNq;
  private String xNr;
  private com.tencent.mm.plugin.emoji.g.e xNs;
  public String xNt;
  public bw xNu;
  public boolean xNv;
  
  public r()
  {
    AppMethodBeat.i(108633);
    this.TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    this.xNk = false;
    this.xNo = 0L;
    this.xNp = "";
    this.xNv = false;
    this.mAppContext = MMApplicationContext.getContext();
    this.xNs = new com.tencent.mm.plugin.emoji.g.e(2003);
    AppMethodBeat.o(108633);
  }
  
  private void aoJ(String paramString)
  {
    AppMethodBeat.i(108637);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(h.h.emoji_play_failed);
    }
    k.d(this.xNl, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(108637);
  }
  
  private void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(269867);
    if (this.xNq != null) {
      this.xNq.d(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
    AppMethodBeat.o(269867);
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(108638);
    String str = this.mAppContext.getString(paramInt);
    AppMethodBeat.o(108638);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108634);
    if ((parama == null) || (parama.xFY == null) || (this.xNj == null) || (this.xNj.xHr == null))
    {
      AppMethodBeat.o(108634);
      return;
    }
    cjb localcjb = parama.xFY.xHE;
    this.xHE = localcjb;
    if (localcjb == null)
    {
      AppMethodBeat.o(108634);
      return;
    }
    String str1 = localcjb.ProductID;
    String str3 = localcjb.Zul;
    Object localObject2 = localcjb.akkj;
    String str2 = localcjb.Zuw;
    int i = localcjb.akke;
    int j = localcjb.akkw;
    int k = parama.dxZ();
    Object localObject1;
    com.tencent.mm.plugin.emoji.a.a.c localc;
    boolean bool1;
    boolean bool2;
    if (parama.xFY == null)
    {
      localObject1 = null;
      ((Integer)localObject1).intValue();
      localc = this.xNj.xHr;
      bool1 = localc.xHB;
      bool2 = parama.xFY.xHJ;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label300;
      }
      localObject1 = "";
      label164:
      Log.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str1, localObject1, Integer.valueOf(k) });
      this.xNr = str1;
    }
    switch (k)
    {
    case 1: 
    case 2: 
    case 6: 
    case 8: 
    default: 
      Log.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
    case 9: 
    case 0: 
    case 7: 
    case 4: 
    case 12: 
    case 3: 
    case 5: 
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(108634);
            return;
            localObject1 = Integer.valueOf(parama.xFY.xHH);
            break;
            localObject1 = localObject2;
            break label164;
            parama = new com.tencent.mm.plugin.emoji.e.s(str1, 2);
            com.tencent.mm.kernel.h.baD().mCm.a(parama, 0);
            AppMethodBeat.o(108634);
            return;
            if (this.xNj != null) {
              this.xNj.dX(str1, 3);
            }
            AppMethodBeat.o(108634);
            return;
            if (bool2)
            {
              if (this.xNm != null)
              {
                i = 1;
                if (i == 0) {
                  break label433;
                }
                this.xNs.u(this.xNm);
              }
              for (;;)
              {
                this.xNs.ydM = str1;
                com.tencent.mm.plugin.report.service.h.OAn.b(12069, new Object[] { Integer.valueOf(1), str1 });
                AppMethodBeat.o(108634);
                return;
                i = 0;
                break;
                this.xNs.X((Activity)this.xNl);
              }
            }
          } while (!parama.xFY.xHL);
          localObject1 = parama.xFY.xHE.ProductID;
          localObject2 = parama.xFY.xHE.Zul;
          str1 = this.xNt;
          if (this.xNl != null)
          {
            if (this.xNn == 9) {}
            for (i = 3;; i = 4)
            {
              parama = new Intent();
              parama.setClass(this.xNl, EmojiStoreV2RewardUI.class);
              parama.putExtra("extra_id", (String)localObject1);
              parama.putExtra("extra_name", (String)localObject2);
              parama.putExtra("name", str1);
              parama.putExtra("scene", this.xNn);
              parama.putExtra("pageType", i);
              parama.putExtra("searchID", this.xNo);
              localObject2 = this.xNl;
              parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, parama.aYi(), "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)parama.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(this.xNn), Integer.valueOf(0) });
              AppMethodBeat.o(108634);
              return;
            }
          }
          Log.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
          AppMethodBeat.o(108634);
          return;
        } while (this.xNk);
        if (b.dDp())
        {
          b.ay(this.xNl, getString(h.h.emoji_wecoin_intercept_teen_mode_content));
          Log.i("MicroMsg.emoji.PayOrDownloadComponent", "Pay Intercept, TeenModeEnable, ProductId:%s, WeCoinNum:%s", new Object[] { str1, Integer.valueOf(j) });
          AppMethodBeat.o(108634);
          return;
        }
        if (b.KK(i))
        {
          if (b.dDq())
          {
            b.dDr();
            b.ga(this.xNl).dDn();
            AppMethodBeat.o(108634);
            return;
          }
          Log.i("MicroMsg.emoji.PayOrDownloadComponent", "onProductClick:productId %s, wecoinNum %s, currency %s", new Object[] { str1, Integer.valueOf(j), str2 });
          b.c(this.xNl, str1, str2, j, str3);
          b.dDr();
          this.xNk = true;
          com.tencent.mm.plugin.report.service.h.OAn.b(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.xNn), "", str1, Long.valueOf(this.xNo), this.xNp });
          AppMethodBeat.o(108634);
          return;
        }
        parama = new Intent();
        parama.putExtra("key_product_id", str1);
        Log.i("MicroMsg.emoji.PayOrDownloadComponent", "onProductClick: price %s, currency %s", new Object[] { localObject2, str2 });
        if (bool1)
        {
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", str2 + (String)localObject2);
        }
        for (;;)
        {
          com.tencent.mm.br.c.b(this.xNl, "wallet_index", ".ui.WalletIapUI", parama, 2001);
          this.xNk = true;
          com.tencent.mm.plugin.report.service.h.OAn.b(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.xNn), "", str1, Long.valueOf(this.xNo), this.xNp });
          AppMethodBeat.o(108634);
          return;
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", (String)localObject2);
        }
        if (com.tencent.mm.plugin.emoji.g.c.i(localcjb))
        {
          com.tencent.mm.plugin.emoji.e.a.dAs();
          com.tencent.mm.plugin.emoji.e.a.dAt();
          AppMethodBeat.o(108634);
          return;
        }
        d(str1, null, str3, localcjb.IHo, localcjb.akkk);
        if (this.xNj != null) {
          this.xNj.dY(str1, 0);
        }
        Log.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str1 });
        com.tencent.mm.plugin.report.service.h.OAn.b(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(this.xNn), "", str1, Long.valueOf(this.xNo), this.xNp });
      } while (this.xNu == null);
      this.xNu.ipB = 2;
      this.xNu.lg(localcjb.ProductID);
      localObject2 = this.xNu;
      if (this.xNv) {}
      for (localObject1 = localcjb.akkC;; localObject1 = localcjb.akkA)
      {
        ((bw)localObject2).lh((String)localObject1);
        this.xNu.li(String.valueOf(parama.mPosition + 1));
        this.xNu.bMH();
        AppMethodBeat.o(108634);
        return;
      }
    case -1: 
      if (com.tencent.mm.plugin.emoji.a.a.e.a(localcjb)) {
        i = 3;
      }
      for (;;)
      {
        this.xNj.dX(str1, i);
        AppMethodBeat.o(108634);
        return;
        if ((com.tencent.mm.plugin.emoji.a.a.e.b(localcjb)) || ((!bool1) && (TextUtils.isEmpty(localcjb.akkc))))
        {
          i = 3;
        }
        else if (bool1)
        {
          parama = localc.anQ(str1);
          if (TextUtils.isEmpty(parama.adjh)) {
            i = parama.adjd;
          } else {
            i = 4;
          }
        }
        else
        {
          i = 4;
        }
      }
    case 10: 
      label300:
      label433:
      parama = localc.anQ(str1);
      if (parama != null) {
        switch (parama.adje)
        {
        default: 
          parama = getString(h.h.emoji_unknow);
        }
      }
      for (;;)
      {
        k.c(this.xNl, parama, null, true);
        AppMethodBeat.o(108634);
        return;
        parama = getString(h.h.emoji_google_no_install);
        continue;
        parama = getString(h.h.emoji_no_on_sale);
        continue;
        parama = getString(h.h.emoji_timeout);
      }
    }
    Log.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
    AppMethodBeat.o(108634);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108636);
    Log.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    String str1 = "";
    int i = 0;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_err_code", 0);
      Log.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:".concat(String.valueOf(i)));
      str1 = paramIntent.getStringExtra("key_err_msg");
      Log.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:".concat(String.valueOf(str1)));
    }
    this.xNk = false;
    if (paramInt2 != -1)
    {
      if (paramInt1 == 2001)
      {
        if (z.bBh())
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 6L, 1L, false);
          AppMethodBeat.o(108636);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 2L, 1L, false);
      }
      AppMethodBeat.o(108636);
      return;
    }
    switch (paramInt1)
    {
    case 2002: 
    default: 
      Log.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
      AppMethodBeat.o(108636);
      return;
    case 2003: 
      str1 = this.xNs.ydM;
      if (Util.isNullOrNil(str1))
      {
        AppMethodBeat.o(108636);
        return;
      }
      this.xNs.a(paramIntent, str1, (Activity)this.xNl);
      com.tencent.mm.plugin.report.service.h.OAn.b(12069, new Object[] { Integer.valueOf(3), str1 });
      AppMethodBeat.o(108636);
      return;
    }
    if ((this.xNj == null) || (this.xNj.xHr == null))
    {
      AppMethodBeat.o(108636);
      return;
    }
    Object localObject;
    if ((paramIntent != null) && (i == 0))
    {
      localObject = paramIntent.getStringArrayListExtra("key_response_product_ids");
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_response_series_ids");
      paramInt2 = 0;
      i = ((ArrayList)localObject).size();
      paramInt1 = 0;
      if (paramInt1 < i)
      {
        String str2 = (String)((ArrayList)localObject).get(paramInt1);
        String str3 = (String)localArrayList.get(paramInt1);
        bj localbj = this.xNj.xHr.anQ(str2);
        if (this.xNr.equals(str2))
        {
          paramIntent = null;
          if (this.xHE != null) {
            paramIntent = this.xHE.akkk;
          }
          d(str2, str3, localbj.xVh, null, paramIntent);
          this.xNj.dY(this.xNr, 0);
          k.cZ(this.xNl, str1);
          Log.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          if (((ArrayList)localObject).size() > 1)
          {
            Log.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
            if (this.xNq != null) {
              this.xNq.dAg();
            }
          }
          paramInt2 = 1;
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          this.xNj.dX(this.xNr, 5);
        }
      }
      if (paramInt2 == 0) {
        aoJ(str1);
      }
      if (z.bBh())
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 4L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 0L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      localObject = this.xNj.xHr.anQ(this.xNr);
      paramIntent = null;
      if (this.xHE != null) {
        paramIntent = this.xHE.akkk;
      }
      d(this.xNr, null, ((bj)localObject).xVh, null, paramIntent);
      this.xNj.dY(this.xNr, 0);
      Log.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.xNr });
      aoJ(str1);
      if (z.bBh())
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 7L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 3L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (z.bBh()) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 6L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
        AppMethodBeat.o(108636);
        return;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 2L, 1L, false);
      }
    }
    if ((this.xNr == null) || (this.xNj == null) || (this.xNj.xHr == null))
    {
      aoJ(str1);
      if (!z.bBh()) {
        break label899;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 5L, 1L, false);
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      AppMethodBeat.o(108636);
      return;
      this.xNj.xHr.anO(this.xNr);
      paramIntent = this.xNj.anM(this.xNr);
      if (paramIntent == null) {
        break;
      }
      paramIntent.dye();
      break;
      label899:
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(166L, 1L, 1L, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.emoji.a.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
    
    public abstract void dAg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.r
 * JD-Core Version:    0.7.0.1
 */