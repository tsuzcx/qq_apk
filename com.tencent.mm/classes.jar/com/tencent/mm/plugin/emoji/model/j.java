package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.z;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public final class j
{
  private Context IR;
  private final String TAG;
  public Context nnh;
  public com.tencent.mm.plugin.emoji.a.a.a pLl;
  public boolean pLm;
  public Fragment pLn;
  public int pLo;
  public long pLp;
  public String pLq;
  public b pLr;
  private String pLs;
  private com.tencent.mm.plugin.emoji.h.c pLt;
  public String pLu;
  public z pLv;
  public boolean pLw;
  
  public j()
  {
    AppMethodBeat.i(108633);
    this.TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    this.pLm = false;
    this.pLp = 0L;
    this.pLq = "";
    this.pLw = false;
    this.IR = ak.getContext();
    this.pLt = new com.tencent.mm.plugin.emoji.h.c(2003);
    AppMethodBeat.o(108633);
  }
  
  private void acJ(String paramString)
  {
    AppMethodBeat.i(108637);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131758285);
    }
    h.d(this.nnh, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(108637);
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(108638);
    String str = this.IR.getString(paramInt);
    AppMethodBeat.o(108638);
    return str;
  }
  
  private void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(108635);
    if (this.pLr != null) {
      this.pLr.k(paramString1, paramString2, paramString3, paramString4);
    }
    AppMethodBeat.o(108635);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108634);
    if ((parama == null) || (parama.pGY == null) || (this.pLl == null) || (this.pLl.pIn == null))
    {
      AppMethodBeat.o(108634);
      return;
    }
    EmotionSummary localEmotionSummary = parama.pGY.pIz;
    if (localEmotionSummary == null)
    {
      AppMethodBeat.o(108634);
      return;
    }
    String str1 = localEmotionSummary.ProductID;
    String str3 = localEmotionSummary.PackName;
    Object localObject2 = localEmotionSummary.PriceNum;
    String str2 = localEmotionSummary.PriceType;
    int i = parama.chq();
    Object localObject1;
    com.tencent.mm.plugin.emoji.a.a.c localc;
    boolean bool1;
    boolean bool2;
    if (parama.pGY == null)
    {
      localObject1 = null;
      ((Integer)localObject1).intValue();
      localc = this.pLl.pIn;
      bool1 = localc.pIw;
      bool2 = parama.pGY.pID;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label276;
      }
      localObject1 = "";
      label144:
      ae.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str1, localObject1, Integer.valueOf(i) });
      this.pLs = str1;
    }
    switch (i)
    {
    case 1: 
    case 2: 
    case 6: 
    case 8: 
    default: 
      ae.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
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
            localObject1 = Integer.valueOf(parama.pGY.pIB);
            break;
            localObject1 = localObject2;
            break label144;
            parama = new com.tencent.mm.plugin.emoji.f.q(str1, 2);
            com.tencent.mm.kernel.g.ajQ().gDv.a(parama, 0);
            AppMethodBeat.o(108634);
            return;
            if (this.pLl != null) {
              this.pLl.cW(str1, 3);
            }
            AppMethodBeat.o(108634);
            return;
            if (bool2)
            {
              if (this.pLn != null)
              {
                i = 1;
                if (i == 0) {
                  break label470;
                }
                parama = this.pLt;
                localObject1 = this.pLn;
                ae.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
                ((Intent)localObject2).putExtra("MMActivity.OverrideExitAnimation", 2130772106);
                d.a((Fragment)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, parama.mGN);
                ((Fragment)localObject1).getActivity().overridePendingTransition(2130772108, 2130772048);
              }
              for (;;)
              {
                this.pLt.pWG = str1;
                com.tencent.mm.plugin.report.service.g.yxI.f(12069, new Object[] { Integer.valueOf(1), str1 });
                AppMethodBeat.o(108634);
                return;
                i = 0;
                break;
                this.pLt.P((Activity)this.nnh);
              }
            }
          } while (!parama.pGY.pIF);
          localObject1 = parama.pGY.pIz.ProductID;
          localObject2 = parama.pGY.pIz.PackName;
          str1 = this.pLu;
          if (this.nnh != null)
          {
            if (this.pLo == 9) {}
            for (i = 3;; i = 4)
            {
              parama = new Intent();
              parama.setClass(this.nnh, EmojiStoreV2RewardUI.class);
              parama.putExtra("extra_id", (String)localObject1);
              parama.putExtra("extra_name", (String)localObject2);
              parama.putExtra("name", str1);
              parama.putExtra("scene", this.pLo);
              parama.putExtra("pageType", i);
              parama.putExtra("searchID", this.pLp);
              localObject2 = this.nnh;
              parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, parama.ahE(), "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)parama.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.g.yxI.f(12738, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(this.pLo), Integer.valueOf(0) });
              AppMethodBeat.o(108634);
              return;
            }
          }
          ae.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
          AppMethodBeat.o(108634);
          return;
        } while (this.pLm);
        parama = new Intent();
        parama.putExtra("key_product_id", str1);
        ae.i("MicroMsg.emoji.PayOrDownloadComponent", "onProductClick: price %s, currency %s", new Object[] { localObject2, str2 });
        if (bool1)
        {
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", str2 + (String)localObject2);
        }
        for (;;)
        {
          d.b(this.nnh, "wallet_index", ".ui.WalletIapUI", parama, 2001);
          this.pLm = true;
          com.tencent.mm.plugin.report.service.g.yxI.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.pLo), "", str1, Long.valueOf(this.pLp), this.pLq });
          AppMethodBeat.o(108634);
          return;
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", (String)localObject2);
        }
        if (com.tencent.mm.plugin.emoji.h.a.g(localEmotionSummary))
        {
          com.tencent.mm.plugin.emoji.f.a.cin();
          com.tencent.mm.plugin.emoji.f.a.cio();
          AppMethodBeat.o(108634);
          return;
        }
        k(str1, null, str3, localEmotionSummary.IconUrl);
        if (this.pLl != null) {
          this.pLl.cX(str1, 0);
        }
        ae.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str1 });
        com.tencent.mm.plugin.report.service.g.yxI.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(this.pLo), "", str1, Long.valueOf(this.pLp), this.pLq });
      } while (this.pLv == null);
      this.pLv.dVT = 2;
      this.pLv.ha(localEmotionSummary.ProductID);
      localObject2 = this.pLv;
      if (this.pLw) {}
      for (localObject1 = localEmotionSummary.ExptDesc;; localObject1 = localEmotionSummary.Introduce)
      {
        ((z)localObject2).hb((String)localObject1);
        this.pLv.hc(String.valueOf(parama.mPosition + 1));
        this.pLv.aLH();
        AppMethodBeat.o(108634);
        return;
      }
    case -1: 
      if (e.a(localEmotionSummary)) {
        i = 3;
      }
      for (;;)
      {
        this.pLl.cW(str1, i);
        AppMethodBeat.o(108634);
        return;
        if ((e.b(localEmotionSummary)) || ((!bool1) && (TextUtils.isEmpty(localEmotionSummary.PackPrice))))
        {
          i = 3;
        }
        else if (bool1)
        {
          parama = localc.acc(str1);
          if (TextUtils.isEmpty(parama.JfI)) {
            i = parama.JfE;
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
      label276:
      label470:
      parama = localc.acc(str1);
      if (parama != null) {
        switch (parama.JfF)
        {
        default: 
          parama = getString(2131758412);
        }
      }
      for (;;)
      {
        h.c(this.nnh, parama, null, true);
        AppMethodBeat.o(108634);
        return;
        parama = getString(2131758261);
        continue;
        parama = getString(2131758270);
        continue;
        parama = getString(2131758407);
      }
    }
    ae.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
    AppMethodBeat.o(108634);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108636);
    ae.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    String str1 = "";
    int i = 0;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_err_code", 0);
      ae.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:".concat(String.valueOf(i)));
      str1 = paramIntent.getStringExtra("key_err_msg");
      ae.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:".concat(String.valueOf(str1)));
    }
    this.pLm = false;
    if (paramInt2 != -1)
    {
      if (paramInt1 == 2001)
      {
        if (v.aAQ())
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 6L, 1L, false);
          AppMethodBeat.o(108636);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 2L, 1L, false);
      }
      AppMethodBeat.o(108636);
      return;
    }
    switch (paramInt1)
    {
    case 2002: 
    default: 
      ae.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
      AppMethodBeat.o(108636);
      return;
    case 2003: 
      str1 = this.pLt.pWG;
      if (bu.isNullOrNil(str1))
      {
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.emoji.h.c.a(paramIntent, str1, (Activity)this.nnh);
      com.tencent.mm.plugin.report.service.g.yxI.f(12069, new Object[] { Integer.valueOf(3), str1 });
      AppMethodBeat.o(108636);
      return;
    }
    if ((this.pLl == null) || (this.pLl.pIn == null))
    {
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 0))
    {
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_response_product_ids");
      paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
      paramInt1 = 0;
      int j = localArrayList.size();
      paramInt2 = 0;
      if (paramInt2 < j)
      {
        String str2 = (String)localArrayList.get(paramInt2);
        String str3 = (String)paramIntent.get(paramInt2);
        bc localbc = this.pLl.pIn.acc(str2);
        if (this.pLs.equals(str2))
        {
          i = 1;
          k(str2, str3, localbc.pSt, null);
          this.pLl.cX(this.pLs, 0);
          h.cm(this.nnh, str1);
          ae.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          paramInt1 = i;
          if (localArrayList.size() <= 1) {
            break label506;
          }
          ae.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
          paramInt1 = i;
          if (this.pLr == null) {
            break label506;
          }
          this.pLr.cic();
          paramInt1 = 1;
        }
        label506:
        for (;;)
        {
          paramInt2 += 1;
          break;
          this.pLl.cW(this.pLs, 5);
        }
      }
      if (paramInt1 == 0) {
        acJ(str1);
      }
      if (v.aAQ())
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 4L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 0L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      paramIntent = this.pLl.pIn.acc(this.pLs);
      k(this.pLs, null, paramIntent.pSt, null);
      this.pLl.cX(this.pLs, 0);
      ae.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.pLs });
      acJ(str1);
      if (v.aAQ())
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 7L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 3L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (v.aAQ()) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 6L, 1L, false);
      }
      for (;;)
      {
        ae.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
        AppMethodBeat.o(108636);
        return;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 2L, 1L, false);
      }
    }
    if ((this.pLs == null) || (this.pLl == null) || (this.pLl.pIn == null))
    {
      acJ(str1);
      if (!v.aAQ()) {
        break label864;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 5L, 1L, false);
    }
    for (;;)
    {
      ae.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      AppMethodBeat.o(108636);
      return;
      this.pLl.pIn.aca(this.pLs);
      paramIntent = this.pLl.abY(this.pLs);
      if (paramIntent == null) {
        break;
      }
      paramIntent.chv();
      break;
      label864:
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 1L, 1L, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.emoji.a.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void cic();
    
    public abstract void k(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.j
 * JD-Core Version:    0.7.0.1
 */