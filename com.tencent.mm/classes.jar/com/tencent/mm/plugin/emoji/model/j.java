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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.z;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bb;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public final class j
{
  private Context IR;
  private final String TAG;
  public Context nhZ;
  public com.tencent.mm.plugin.emoji.a.a.a pEH;
  public boolean pEI;
  public Fragment pEJ;
  public int pEK;
  public long pEL;
  public String pEM;
  public b pEN;
  private String pEO;
  private com.tencent.mm.plugin.emoji.h.c pEP;
  public String pEQ;
  public z pER;
  public boolean pES;
  
  public j()
  {
    AppMethodBeat.i(108633);
    this.TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    this.pEI = false;
    this.pEL = 0L;
    this.pEM = "";
    this.pES = false;
    this.IR = aj.getContext();
    this.pEP = new com.tencent.mm.plugin.emoji.h.c(2003);
    AppMethodBeat.o(108633);
  }
  
  private void abS(String paramString)
  {
    AppMethodBeat.i(108637);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131758285);
    }
    h.d(this.nhZ, str, "", new DialogInterface.OnClickListener()
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
    if (this.pEN != null) {
      this.pEN.k(paramString1, paramString2, paramString3, paramString4);
    }
    AppMethodBeat.o(108635);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108634);
    if ((parama == null) || (parama.pAu == null) || (this.pEH == null) || (this.pEH.pBJ == null))
    {
      AppMethodBeat.o(108634);
      return;
    }
    EmotionSummary localEmotionSummary = parama.pAu.pBV;
    if (localEmotionSummary == null)
    {
      AppMethodBeat.o(108634);
      return;
    }
    String str1 = localEmotionSummary.ProductID;
    String str3 = localEmotionSummary.PackName;
    Object localObject2 = localEmotionSummary.PriceNum;
    String str2 = localEmotionSummary.PriceType;
    int i = parama.cga();
    Object localObject1;
    com.tencent.mm.plugin.emoji.a.a.c localc;
    boolean bool1;
    boolean bool2;
    if (parama.pAu == null)
    {
      localObject1 = null;
      ((Integer)localObject1).intValue();
      localc = this.pEH.pBJ;
      bool1 = localc.pBS;
      bool2 = parama.pAu.pBZ;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label276;
      }
      localObject1 = "";
      label144:
      ad.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str1, localObject1, Integer.valueOf(i) });
      this.pEO = str1;
    }
    switch (i)
    {
    case 1: 
    case 2: 
    case 6: 
    case 8: 
    default: 
      ad.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
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
            localObject1 = Integer.valueOf(parama.pAu.pBX);
            break;
            localObject1 = localObject2;
            break label144;
            parama = new com.tencent.mm.plugin.emoji.f.q(str1, 2);
            com.tencent.mm.kernel.g.ajB().gAO.a(parama, 0);
            AppMethodBeat.o(108634);
            return;
            if (this.pEH != null) {
              this.pEH.cS(str1, 3);
            }
            AppMethodBeat.o(108634);
            return;
            if (bool2)
            {
              if (this.pEJ != null)
              {
                i = 1;
                if (i == 0) {
                  break label470;
                }
                parama = this.pEP;
                localObject1 = this.pEJ;
                ad.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
                ((Intent)localObject2).putExtra("MMActivity.OverrideExitAnimation", 2130772106);
                d.a((Fragment)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, parama.mBI);
                ((Fragment)localObject1).getActivity().overridePendingTransition(2130772108, 2130772048);
              }
              for (;;)
              {
                this.pEP.pQb = str1;
                com.tencent.mm.plugin.report.service.g.yhR.f(12069, new Object[] { Integer.valueOf(1), str1 });
                AppMethodBeat.o(108634);
                return;
                i = 0;
                break;
                this.pEP.O((Activity)this.nhZ);
              }
            }
          } while (!parama.pAu.pCb);
          localObject1 = parama.pAu.pBV.ProductID;
          localObject2 = parama.pAu.pBV.PackName;
          str1 = this.pEQ;
          if (this.nhZ != null)
          {
            if (this.pEK == 9) {}
            for (i = 3;; i = 4)
            {
              parama = new Intent();
              parama.setClass(this.nhZ, EmojiStoreV2RewardUI.class);
              parama.putExtra("extra_id", (String)localObject1);
              parama.putExtra("extra_name", (String)localObject2);
              parama.putExtra("name", str1);
              parama.putExtra("scene", this.pEK);
              parama.putExtra("pageType", i);
              parama.putExtra("searchID", this.pEL);
              localObject2 = this.nhZ;
              parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, parama.ahp(), "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)parama.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.g.yhR.f(12738, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(this.pEK), Integer.valueOf(0) });
              AppMethodBeat.o(108634);
              return;
            }
          }
          ad.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
          AppMethodBeat.o(108634);
          return;
        } while (this.pEI);
        parama = new Intent();
        parama.putExtra("key_product_id", str1);
        ad.i("MicroMsg.emoji.PayOrDownloadComponent", "onProductClick: price %s, currency %s", new Object[] { localObject2, str2 });
        if (bool1)
        {
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", str2 + (String)localObject2);
        }
        for (;;)
        {
          d.b(this.nhZ, "wallet_index", ".ui.WalletIapUI", parama, 2001);
          this.pEI = true;
          com.tencent.mm.plugin.report.service.g.yhR.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.pEK), "", str1, Long.valueOf(this.pEL), this.pEM });
          AppMethodBeat.o(108634);
          return;
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", (String)localObject2);
        }
        if (com.tencent.mm.plugin.emoji.h.a.g(localEmotionSummary))
        {
          com.tencent.mm.plugin.emoji.f.a.cgX();
          com.tencent.mm.plugin.emoji.f.a.cgY();
          AppMethodBeat.o(108634);
          return;
        }
        k(str1, null, str3, localEmotionSummary.IconUrl);
        if (this.pEH != null) {
          this.pEH.cT(str1, 0);
        }
        ad.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str1 });
        com.tencent.mm.plugin.report.service.g.yhR.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(this.pEK), "", str1, Long.valueOf(this.pEL), this.pEM });
      } while (this.pER == null);
      this.pER.dUD = 2;
      this.pER.gU(localEmotionSummary.ProductID);
      localObject2 = this.pER;
      if (this.pES) {}
      for (localObject1 = localEmotionSummary.ExptDesc;; localObject1 = localEmotionSummary.Introduce)
      {
        ((z)localObject2).gV((String)localObject1);
        this.pER.gW(String.valueOf(parama.mPosition + 1));
        this.pER.aLk();
        AppMethodBeat.o(108634);
        return;
      }
    case -1: 
      if (e.a(localEmotionSummary)) {
        i = 3;
      }
      for (;;)
      {
        this.pEH.cS(str1, i);
        AppMethodBeat.o(108634);
        return;
        if ((e.b(localEmotionSummary)) || ((!bool1) && (TextUtils.isEmpty(localEmotionSummary.PackPrice))))
        {
          i = 3;
        }
        else if (bool1)
        {
          parama = localc.abl(str1);
          if (TextUtils.isEmpty(parama.ILb)) {
            i = parama.IKX;
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
      parama = localc.abl(str1);
      if (parama != null) {
        switch (parama.IKY)
        {
        default: 
          parama = getString(2131758412);
        }
      }
      for (;;)
      {
        h.c(this.nhZ, parama, null, true);
        AppMethodBeat.o(108634);
        return;
        parama = getString(2131758261);
        continue;
        parama = getString(2131758270);
        continue;
        parama = getString(2131758407);
      }
    }
    ad.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
    AppMethodBeat.o(108634);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108636);
    ad.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    String str1 = "";
    int i = 0;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_err_code", 0);
      ad.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:".concat(String.valueOf(i)));
      str1 = paramIntent.getStringExtra("key_err_msg");
      ad.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:".concat(String.valueOf(str1)));
    }
    this.pEI = false;
    if (paramInt2 != -1)
    {
      if (paramInt1 == 2001)
      {
        if (u.aAA())
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 6L, 1L, false);
          AppMethodBeat.o(108636);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 2L, 1L, false);
      }
      AppMethodBeat.o(108636);
      return;
    }
    switch (paramInt1)
    {
    case 2002: 
    default: 
      ad.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
      AppMethodBeat.o(108636);
      return;
    case 2003: 
      str1 = this.pEP.pQb;
      if (bt.isNullOrNil(str1))
      {
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.emoji.h.c.a(paramIntent, str1, (Activity)this.nhZ);
      com.tencent.mm.plugin.report.service.g.yhR.f(12069, new Object[] { Integer.valueOf(3), str1 });
      AppMethodBeat.o(108636);
      return;
    }
    if ((this.pEH == null) || (this.pEH.pBJ == null))
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
        bb localbb = this.pEH.pBJ.abl(str2);
        if (this.pEO.equals(str2))
        {
          i = 1;
          k(str2, str3, localbb.pLO, null);
          this.pEH.cT(this.pEO, 0);
          h.cl(this.nhZ, str1);
          ad.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          paramInt1 = i;
          if (localArrayList.size() <= 1) {
            break label506;
          }
          ad.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
          paramInt1 = i;
          if (this.pEN == null) {
            break label506;
          }
          this.pEN.cgM();
          paramInt1 = 1;
        }
        label506:
        for (;;)
        {
          paramInt2 += 1;
          break;
          this.pEH.cS(this.pEO, 5);
        }
      }
      if (paramInt1 == 0) {
        abS(str1);
      }
      if (u.aAA())
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 4L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 0L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      paramIntent = this.pEH.pBJ.abl(this.pEO);
      k(this.pEO, null, paramIntent.pLO, null);
      this.pEH.cT(this.pEO, 0);
      ad.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.pEO });
      abS(str1);
      if (u.aAA())
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 7L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 3L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (u.aAA()) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 6L, 1L, false);
      }
      for (;;)
      {
        ad.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
        AppMethodBeat.o(108636);
        return;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 2L, 1L, false);
      }
    }
    if ((this.pEO == null) || (this.pEH == null) || (this.pEH.pBJ == null))
    {
      abS(str1);
      if (!u.aAA()) {
        break label864;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 5L, 1L, false);
    }
    for (;;)
    {
      ad.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      AppMethodBeat.o(108636);
      return;
      this.pEH.pBJ.abj(this.pEO);
      paramIntent = this.pEH.abh(this.pEO);
      if (paramIntent == null) {
        break;
      }
      paramIntent.cgf();
      break;
      label864:
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(166L, 1L, 1L, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.emoji.a.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void cgM();
    
    public abstract void k(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.j
 * JD-Core Version:    0.7.0.1
 */