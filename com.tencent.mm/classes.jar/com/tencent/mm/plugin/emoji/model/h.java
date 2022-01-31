package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;

public final class h
{
  private final String TAG;
  public Context jpJ;
  public String lhA;
  public h.b lhB;
  private String lhC;
  private com.tencent.mm.plugin.emoji.h.c lhD;
  public String lhE;
  public com.tencent.mm.plugin.emoji.a.a.a lhv;
  public boolean lhw;
  public Fragment lhx;
  public int lhy;
  public long lhz;
  private Context zF;
  
  public h()
  {
    AppMethodBeat.i(53054);
    this.TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    this.lhw = false;
    this.lhz = 0L;
    this.lhA = "";
    this.zF = ah.getContext();
    this.lhD = new com.tencent.mm.plugin.emoji.h.c(2003);
    AppMethodBeat.o(53054);
  }
  
  private void KT(String paramString)
  {
    AppMethodBeat.i(53058);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131299162);
    }
    com.tencent.mm.ui.base.h.a(this.jpJ, str, "", new h.1(this));
    AppMethodBeat.o(53058);
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(53059);
    String str = this.zF.getString(paramInt);
    AppMethodBeat.o(53059);
    return str;
  }
  
  private void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(53056);
    if (this.lhB != null) {
      this.lhB.i(paramString1, paramString2, paramString3, paramString4);
    }
    AppMethodBeat.o(53056);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(53055);
    if ((parama == null) || (parama.ldz == null) || (this.lhv == null) || (this.lhv.leO == null))
    {
      AppMethodBeat.o(53055);
      return;
    }
    EmotionSummary localEmotionSummary = parama.ldz.lfa;
    if (localEmotionSummary == null)
    {
      AppMethodBeat.o(53055);
      return;
    }
    Object localObject3 = localEmotionSummary.ProductID;
    String str2 = localEmotionSummary.PackName;
    Object localObject2 = localEmotionSummary.PriceNum;
    String str1 = localEmotionSummary.PriceType;
    int i = parama.bkt();
    Object localObject1;
    com.tencent.mm.plugin.emoji.a.a.c localc;
    boolean bool1;
    boolean bool2;
    if (parama.ldz == null)
    {
      localObject1 = null;
      ((Integer)localObject1).intValue();
      localc = this.lhv.leO;
      bool1 = localc.leX;
      bool2 = parama.ldz.lfe;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label276;
      }
      localObject1 = "";
      label144:
      ab.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { localObject3, localObject1, Integer.valueOf(i) });
      this.lhC = ((String)localObject3);
    }
    switch (i)
    {
    case 1: 
    case 2: 
    case 6: 
    case 8: 
    default: 
      ab.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
    case 9: 
    case 0: 
    case 7: 
    case 4: 
    case 12: 
      do
      {
        do
        {
          AppMethodBeat.o(53055);
          return;
          localObject1 = Integer.valueOf(parama.ldz.lfc);
          break;
          localObject1 = localObject2;
          break label144;
          parama = new q((String)localObject3, 2);
          g.RK().eHt.a(parama, 0);
          AppMethodBeat.o(53055);
          return;
          if (this.lhv != null) {
            this.lhv.bX((String)localObject3, 3);
          }
          AppMethodBeat.o(53055);
          return;
          if (bool2)
          {
            if (this.lhx != null)
            {
              i = 1;
              if (i == 0) {
                break label470;
              }
              parama = this.lhD;
              localObject1 = this.lhx;
              ab.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
              ((Intent)localObject2).putExtra("MMActivity.OverrideExitAnimation", 2131034228);
              d.a((Fragment)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, parama.iMG);
              ((Fragment)localObject1).getActivity().overridePendingTransition(2131034230, 2131034182);
            }
            for (;;)
            {
              this.lhD.lsI = ((String)localObject3);
              com.tencent.mm.plugin.report.service.h.qsU.e(12069, new Object[] { Integer.valueOf(1), localObject3 });
              AppMethodBeat.o(53055);
              return;
              i = 0;
              break;
              this.lhD.A((Activity)this.jpJ);
            }
          }
        } while (!parama.ldz.lfg);
        localObject1 = parama.ldz.lfa.ProductID;
        parama = parama.ldz.lfa.PackName;
        localObject2 = this.lhE;
        if (this.jpJ != null)
        {
          if (this.lhy == 9) {}
          for (i = 3;; i = 4)
          {
            localObject3 = new Intent();
            ((Intent)localObject3).setClass(this.jpJ, EmojiStoreV2RewardUI.class);
            ((Intent)localObject3).putExtra("extra_id", (String)localObject1);
            ((Intent)localObject3).putExtra("extra_name", parama);
            ((Intent)localObject3).putExtra("name", (String)localObject2);
            ((Intent)localObject3).putExtra("scene", this.lhy);
            ((Intent)localObject3).putExtra("pageType", i);
            ((Intent)localObject3).putExtra("searchID", this.lhz);
            this.jpJ.startActivity((Intent)localObject3);
            com.tencent.mm.plugin.report.service.h.qsU.e(12738, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(this.lhy), Integer.valueOf(0) });
            AppMethodBeat.o(53055);
            return;
          }
        }
        ab.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
        AppMethodBeat.o(53055);
        return;
      } while (this.lhw);
      parama = new Intent();
      parama.putExtra("key_product_id", (String)localObject3);
      ab.i("MicroMsg.emoji.PayOrDownloadComponent", "onProductClick: price %s, currency %s", new Object[] { localObject2, str1 });
      if (bool1)
      {
        parama.putExtra("key_currency_type", str1);
        parama.putExtra("key_price", str1 + (String)localObject2);
      }
      for (;;)
      {
        d.b(this.jpJ, "wallet_index", ".ui.WalletIapUI", parama, 2001);
        this.lhw = true;
        com.tencent.mm.plugin.report.service.h.qsU.e(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.lhy), "", localObject3, Long.valueOf(this.lhz), this.lhA });
        AppMethodBeat.o(53055);
        return;
        parama.putExtra("key_currency_type", str1);
        parama.putExtra("key_price", (String)localObject2);
      }
    case 3: 
    case 5: 
      if (com.tencent.mm.plugin.emoji.h.a.g(localEmotionSummary))
      {
        com.tencent.mm.plugin.emoji.f.a.blw();
        com.tencent.mm.plugin.emoji.f.a.blx();
        AppMethodBeat.o(53055);
        return;
      }
      i((String)localObject3, null, str2, localEmotionSummary.IconUrl);
      if (this.lhv != null) {
        this.lhv.bY((String)localObject3, 0);
      }
      ab.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { localObject3 });
      com.tencent.mm.plugin.report.service.h.qsU.e(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(this.lhy), "", localObject3, Long.valueOf(this.lhz), this.lhA });
      AppMethodBeat.o(53055);
      return;
    case -1: 
      if (e.a(localEmotionSummary)) {
        i = 3;
      }
      for (;;)
      {
        this.lhv.bX((String)localObject3, i);
        AppMethodBeat.o(53055);
        return;
        if ((e.b(localEmotionSummary)) || ((!bool1) && (TextUtils.isEmpty(localEmotionSummary.PackPrice))))
        {
          i = 3;
        }
        else if (bool1)
        {
          parama = localc.Km((String)localObject3);
          if (TextUtils.isEmpty(parama.yNb)) {
            i = parama.yMX;
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
      parama = localc.Km((String)localObject3);
      if (parama != null) {
        switch (parama.yMY)
        {
        default: 
          parama = getString(2131299286);
        }
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.b(this.jpJ, parama, null, true);
        AppMethodBeat.o(53055);
        return;
        parama = getString(2131299145);
        continue;
        parama = getString(2131299153);
        continue;
        parama = getString(2131299281);
      }
    }
    ab.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
    AppMethodBeat.o(53055);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53057);
    ab.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    String str1 = "";
    int i = 0;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_err_code", 0);
      ab.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:".concat(String.valueOf(i)));
      str1 = paramIntent.getStringExtra("key_err_msg");
      ab.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:".concat(String.valueOf(str1)));
    }
    this.lhw = false;
    if (paramInt2 != -1)
    {
      if (paramInt1 == 2001)
      {
        if (r.ZA())
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 6L, 1L, false);
          AppMethodBeat.o(53057);
          return;
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 2L, 1L, false);
      }
      AppMethodBeat.o(53057);
      return;
    }
    switch (paramInt1)
    {
    case 2002: 
    default: 
      ab.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
      AppMethodBeat.o(53057);
      return;
    case 2003: 
      str1 = this.lhD.lsI;
      if (bo.isNullOrNil(str1))
      {
        AppMethodBeat.o(53057);
        return;
      }
      com.tencent.mm.plugin.emoji.h.c.a(paramIntent, str1, (Activity)this.jpJ);
      com.tencent.mm.plugin.report.service.h.qsU.e(12069, new Object[] { Integer.valueOf(3), str1 });
      AppMethodBeat.o(53057);
      return;
    }
    if ((this.lhv == null) || (this.lhv.leO == null))
    {
      AppMethodBeat.o(53057);
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
        ar localar = this.lhv.leO.Km(str2);
        if (this.lhC.equals(str2))
        {
          i = 1;
          i(str2, str3, localar.loz, null);
          this.lhv.bY(this.lhC, 0);
          com.tencent.mm.ui.base.h.bO(this.jpJ, str1);
          ab.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          paramInt1 = i;
          if (localArrayList.size() <= 1) {
            break label506;
          }
          ab.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
          paramInt1 = i;
          if (this.lhB == null) {
            break label506;
          }
          this.lhB.blm();
          paramInt1 = 1;
        }
        label506:
        for (;;)
        {
          paramInt2 += 1;
          break;
          this.lhv.bX(this.lhC, 5);
        }
      }
      if (paramInt1 == 0) {
        KT(str1);
      }
      if (r.ZA())
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 4L, 1L, false);
        AppMethodBeat.o(53057);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 0L, 1L, false);
      AppMethodBeat.o(53057);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      paramIntent = this.lhv.leO.Km(this.lhC);
      i(this.lhC, null, paramIntent.loz, null);
      this.lhv.bY(this.lhC, 0);
      ab.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.lhC });
      KT(str1);
      if (r.ZA())
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 7L, 1L, false);
        AppMethodBeat.o(53057);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 3L, 1L, false);
      AppMethodBeat.o(53057);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (r.ZA()) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 6L, 1L, false);
      }
      for (;;)
      {
        ab.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
        AppMethodBeat.o(53057);
        return;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 2L, 1L, false);
      }
    }
    if ((this.lhC == null) || (this.lhv == null) || (this.lhv.leO == null))
    {
      KT(str1);
      if (!r.ZA()) {
        break label864;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 5L, 1L, false);
    }
    for (;;)
    {
      ab.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      AppMethodBeat.o(53057);
      return;
      this.lhv.leO.Kk(this.lhC);
      paramIntent = this.lhv.Ki(this.lhC);
      if (paramIntent == null) {
        break;
      }
      paramIntent.bky();
      break;
      label864:
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(166L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.h
 * JD-Core Version:    0.7.0.1
 */