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
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.au;
import java.util.ArrayList;

public final class j
{
  private Context FZ;
  private final String TAG;
  public Context mfC;
  public int oxA;
  public long oxB;
  public String oxC;
  public b oxD;
  private String oxE;
  private com.tencent.mm.plugin.emoji.h.c oxF;
  public String oxG;
  public com.tencent.mm.g.b.a.u oxH;
  public boolean oxI;
  public com.tencent.mm.plugin.emoji.a.a.a oxx;
  public boolean oxy;
  public Fragment oxz;
  
  public j()
  {
    AppMethodBeat.i(108633);
    this.TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    this.oxy = false;
    this.oxB = 0L;
    this.oxC = "";
    this.oxI = false;
    this.FZ = aj.getContext();
    this.oxF = new com.tencent.mm.plugin.emoji.h.c(2003);
    AppMethodBeat.o(108633);
  }
  
  private void Ua(String paramString)
  {
    AppMethodBeat.i(108637);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131758285);
    }
    com.tencent.mm.ui.base.h.d(this.mfC, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(108637);
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(108638);
    String str = this.FZ.getString(paramInt);
    AppMethodBeat.o(108638);
    return str;
  }
  
  private void j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(108635);
    if (this.oxD != null) {
      this.oxD.j(paramString1, paramString2, paramString3, paramString4);
    }
    AppMethodBeat.o(108635);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108634);
    if ((parama == null) || (parama.otj == null) || (this.oxx == null) || (this.oxx.ouz == null))
    {
      AppMethodBeat.o(108634);
      return;
    }
    EmotionSummary localEmotionSummary = parama.otj.ouL;
    if (localEmotionSummary == null)
    {
      AppMethodBeat.o(108634);
      return;
    }
    String str1 = localEmotionSummary.ProductID;
    String str3 = localEmotionSummary.PackName;
    Object localObject2 = localEmotionSummary.PriceNum;
    String str2 = localEmotionSummary.PriceType;
    int i = parama.bUi();
    Object localObject1;
    com.tencent.mm.plugin.emoji.a.a.c localc;
    boolean bool1;
    boolean bool2;
    if (parama.otj == null)
    {
      localObject1 = null;
      ((Integer)localObject1).intValue();
      localc = this.oxx.ouz;
      bool1 = localc.ouI;
      bool2 = parama.otj.ouP;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label276;
      }
      localObject1 = "";
      label144:
      ad.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str1, localObject1, Integer.valueOf(i) });
      this.oxE = str1;
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
            localObject1 = Integer.valueOf(parama.otj.ouN);
            break;
            localObject1 = localObject2;
            break label144;
            parama = new com.tencent.mm.plugin.emoji.f.q(str1, 2);
            g.afA().gcy.a(parama, 0);
            AppMethodBeat.o(108634);
            return;
            if (this.oxx != null) {
              this.oxx.cK(str1, 3);
            }
            AppMethodBeat.o(108634);
            return;
            if (bool2)
            {
              if (this.oxz != null)
              {
                i = 1;
                if (i == 0) {
                  break label470;
                }
                parama = this.oxF;
                localObject1 = this.oxz;
                ad.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
                ((Intent)localObject2).putExtra("MMActivity.OverrideExitAnimation", 2130772106);
                d.a((Fragment)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, parama.lzE);
                ((Fragment)localObject1).getActivity().overridePendingTransition(2130772108, 2130772048);
              }
              for (;;)
              {
                this.oxF.oJb = str1;
                com.tencent.mm.plugin.report.service.h.vKh.f(12069, new Object[] { Integer.valueOf(1), str1 });
                AppMethodBeat.o(108634);
                return;
                i = 0;
                break;
                this.oxF.O((Activity)this.mfC);
              }
            }
          } while (!parama.otj.ouR);
          localObject1 = parama.otj.ouL.ProductID;
          localObject2 = parama.otj.ouL.PackName;
          str1 = this.oxG;
          if (this.mfC != null)
          {
            if (this.oxA == 9) {}
            for (i = 3;; i = 4)
            {
              parama = new Intent();
              parama.setClass(this.mfC, EmojiStoreV2RewardUI.class);
              parama.putExtra("extra_id", (String)localObject1);
              parama.putExtra("extra_name", (String)localObject2);
              parama.putExtra("name", str1);
              parama.putExtra("scene", this.oxA);
              parama.putExtra("pageType", i);
              parama.putExtra("searchID", this.oxB);
              localObject2 = this.mfC;
              parama = new com.tencent.mm.hellhoundlib.b.a().bd(parama);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, parama.adn(), "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)parama.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.vKh.f(12738, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(this.oxA), Integer.valueOf(0) });
              AppMethodBeat.o(108634);
              return;
            }
          }
          ad.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
          AppMethodBeat.o(108634);
          return;
        } while (this.oxy);
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
          d.b(this.mfC, "wallet_index", ".ui.WalletIapUI", parama, 2001);
          this.oxy = true;
          com.tencent.mm.plugin.report.service.h.vKh.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.oxA), "", str1, Long.valueOf(this.oxB), this.oxC });
          AppMethodBeat.o(108634);
          return;
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", (String)localObject2);
        }
        if (com.tencent.mm.plugin.emoji.h.a.g(localEmotionSummary))
        {
          com.tencent.mm.plugin.emoji.f.a.bVg();
          com.tencent.mm.plugin.emoji.f.a.bVh();
          AppMethodBeat.o(108634);
          return;
        }
        j(str1, null, str3, localEmotionSummary.IconUrl);
        if (this.oxx != null) {
          this.oxx.cL(str1, 0);
        }
        ad.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str1 });
        com.tencent.mm.plugin.report.service.h.vKh.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(this.oxA), "", str1, Long.valueOf(this.oxB), this.oxC });
      } while (this.oxH == null);
      this.oxH.dJy = 2;
      this.oxH.gb(localEmotionSummary.ProductID);
      localObject2 = this.oxH;
      if (this.oxI) {}
      for (localObject1 = localEmotionSummary.ExptDesc;; localObject1 = localEmotionSummary.Introduce)
      {
        ((com.tencent.mm.g.b.a.u)localObject2).gc((String)localObject1);
        this.oxH.gd(String.valueOf(parama.mPosition + 1));
        this.oxH.aBj();
        AppMethodBeat.o(108634);
        return;
      }
    case -1: 
      if (e.a(localEmotionSummary)) {
        i = 3;
      }
      for (;;)
      {
        this.oxx.cK(str1, i);
        AppMethodBeat.o(108634);
        return;
        if ((e.b(localEmotionSummary)) || ((!bool1) && (TextUtils.isEmpty(localEmotionSummary.PackPrice))))
        {
          i = 3;
        }
        else if (bool1)
        {
          parama = localc.Ts(str1);
          if (TextUtils.isEmpty(parama.FyM)) {
            i = parama.FyI;
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
      parama = localc.Ts(str1);
      if (parama != null) {
        switch (parama.FyJ)
        {
        default: 
          parama = getString(2131758412);
        }
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.c(this.mfC, parama, null, true);
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
    this.oxy = false;
    if (paramInt2 != -1)
    {
      if (paramInt1 == 2001)
      {
        if (com.tencent.mm.model.u.aqU())
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 6L, 1L, false);
          AppMethodBeat.o(108636);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 2L, 1L, false);
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
      str1 = this.oxF.oJb;
      if (bt.isNullOrNil(str1))
      {
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.emoji.h.c.a(paramIntent, str1, (Activity)this.mfC);
      com.tencent.mm.plugin.report.service.h.vKh.f(12069, new Object[] { Integer.valueOf(3), str1 });
      AppMethodBeat.o(108636);
      return;
    }
    if ((this.oxx == null) || (this.oxx.ouz == null))
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
        au localau = this.oxx.ouz.Ts(str2);
        if (this.oxE.equals(str2))
        {
          i = 1;
          j(str2, str3, localau.oEN, null);
          this.oxx.cL(this.oxE, 0);
          com.tencent.mm.ui.base.h.cf(this.mfC, str1);
          ad.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          paramInt1 = i;
          if (localArrayList.size() <= 1) {
            break label506;
          }
          ad.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
          paramInt1 = i;
          if (this.oxD == null) {
            break label506;
          }
          this.oxD.bUV();
          paramInt1 = 1;
        }
        label506:
        for (;;)
        {
          paramInt2 += 1;
          break;
          this.oxx.cK(this.oxE, 5);
        }
      }
      if (paramInt1 == 0) {
        Ua(str1);
      }
      if (com.tencent.mm.model.u.aqU())
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 4L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 0L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      paramIntent = this.oxx.ouz.Ts(this.oxE);
      j(this.oxE, null, paramIntent.oEN, null);
      this.oxx.cL(this.oxE, 0);
      ad.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.oxE });
      Ua(str1);
      if (com.tencent.mm.model.u.aqU())
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 7L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 3L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (com.tencent.mm.model.u.aqU()) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 6L, 1L, false);
      }
      for (;;)
      {
        ad.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
        AppMethodBeat.o(108636);
        return;
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 2L, 1L, false);
      }
    }
    if ((this.oxE == null) || (this.oxx == null) || (this.oxx.ouz == null))
    {
      Ua(str1);
      if (!com.tencent.mm.model.u.aqU()) {
        break label864;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 5L, 1L, false);
    }
    for (;;)
    {
      ad.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      AppMethodBeat.o(108636);
      return;
      this.oxx.ouz.Tq(this.oxE);
      paramIntent = this.oxx.To(this.oxE);
      if (paramIntent == null) {
        break;
      }
      paramIntent.bUn();
      break;
      label864:
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(166L, 1L, 1L, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.emoji.a.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void bUV();
    
    public abstract void j(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.j
 * JD-Core Version:    0.7.0.1
 */