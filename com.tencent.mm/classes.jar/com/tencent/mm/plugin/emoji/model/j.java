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
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ax;
import java.util.ArrayList;

public final class j
{
  private Context GX;
  private final String TAG;
  public Context mHB;
  public com.tencent.mm.plugin.emoji.a.a.a paX;
  public boolean paY;
  public Fragment paZ;
  public int pba;
  public long pbb;
  public String pbc;
  public b pbd;
  private String pbe;
  private com.tencent.mm.plugin.emoji.h.c pbf;
  public String pbg;
  public w pbh;
  public boolean pbi;
  
  public j()
  {
    AppMethodBeat.i(108633);
    this.TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    this.paY = false;
    this.pbb = 0L;
    this.pbc = "";
    this.pbi = false;
    this.GX = ai.getContext();
    this.pbf = new com.tencent.mm.plugin.emoji.h.c(2003);
    AppMethodBeat.o(108633);
  }
  
  private void Ym(String paramString)
  {
    AppMethodBeat.i(108637);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131758285);
    }
    com.tencent.mm.ui.base.h.d(this.mHB, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(108637);
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(108638);
    String str = this.GX.getString(paramInt);
    AppMethodBeat.o(108638);
    return str;
  }
  
  private void l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(108635);
    if (this.pbd != null) {
      this.pbd.l(paramString1, paramString2, paramString3, paramString4);
    }
    AppMethodBeat.o(108635);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    AppMethodBeat.i(108634);
    if ((parama == null) || (parama.oWK == null) || (this.paX == null) || (this.paX.oXZ == null))
    {
      AppMethodBeat.o(108634);
      return;
    }
    EmotionSummary localEmotionSummary = parama.oWK.oYl;
    if (localEmotionSummary == null)
    {
      AppMethodBeat.o(108634);
      return;
    }
    String str1 = localEmotionSummary.ProductID;
    String str3 = localEmotionSummary.PackName;
    Object localObject2 = localEmotionSummary.PriceNum;
    String str2 = localEmotionSummary.PriceType;
    int i = parama.cbw();
    Object localObject1;
    com.tencent.mm.plugin.emoji.a.a.c localc;
    boolean bool1;
    boolean bool2;
    if (parama.oWK == null)
    {
      localObject1 = null;
      ((Integer)localObject1).intValue();
      localc = this.paX.oXZ;
      bool1 = localc.oYi;
      bool2 = parama.oWK.oYp;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label276;
      }
      localObject1 = "";
      label144:
      ac.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str1, localObject1, Integer.valueOf(i) });
      this.pbe = str1;
    }
    switch (i)
    {
    case 1: 
    case 2: 
    case 6: 
    case 8: 
    default: 
      ac.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
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
            localObject1 = Integer.valueOf(parama.oWK.oYn);
            break;
            localObject1 = localObject2;
            break label144;
            parama = new com.tencent.mm.plugin.emoji.f.q(str1, 2);
            g.agQ().ghe.a(parama, 0);
            AppMethodBeat.o(108634);
            return;
            if (this.paX != null) {
              this.paX.cP(str1, 3);
            }
            AppMethodBeat.o(108634);
            return;
            if (bool2)
            {
              if (this.paZ != null)
              {
                i = 1;
                if (i == 0) {
                  break label470;
                }
                parama = this.pbf;
                localObject1 = this.paZ;
                ac.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
                ((Intent)localObject2).putExtra("MMActivity.OverrideExitAnimation", 2130772106);
                d.a((Fragment)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, parama.mbA);
                ((Fragment)localObject1).getActivity().overridePendingTransition(2130772108, 2130772048);
              }
              for (;;)
              {
                this.pbf.pmB = str1;
                com.tencent.mm.plugin.report.service.h.wUl.f(12069, new Object[] { Integer.valueOf(1), str1 });
                AppMethodBeat.o(108634);
                return;
                i = 0;
                break;
                this.pbf.O((Activity)this.mHB);
              }
            }
          } while (!parama.oWK.oYr);
          localObject1 = parama.oWK.oYl.ProductID;
          localObject2 = parama.oWK.oYl.PackName;
          str1 = this.pbg;
          if (this.mHB != null)
          {
            if (this.pba == 9) {}
            for (i = 3;; i = 4)
            {
              parama = new Intent();
              parama.setClass(this.mHB, EmojiStoreV2RewardUI.class);
              parama.putExtra("extra_id", (String)localObject1);
              parama.putExtra("extra_name", (String)localObject2);
              parama.putExtra("name", str1);
              parama.putExtra("scene", this.pba);
              parama.putExtra("pageType", i);
              parama.putExtra("searchID", this.pbb);
              localObject2 = this.mHB;
              parama = new com.tencent.mm.hellhoundlib.b.a().ba(parama);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, parama.aeD(), "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)parama.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.wUl.f(12738, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(this.pba), Integer.valueOf(0) });
              AppMethodBeat.o(108634);
              return;
            }
          }
          ac.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
          AppMethodBeat.o(108634);
          return;
        } while (this.paY);
        parama = new Intent();
        parama.putExtra("key_product_id", str1);
        ac.i("MicroMsg.emoji.PayOrDownloadComponent", "onProductClick: price %s, currency %s", new Object[] { localObject2, str2 });
        if (bool1)
        {
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", str2 + (String)localObject2);
        }
        for (;;)
        {
          d.b(this.mHB, "wallet_index", ".ui.WalletIapUI", parama, 2001);
          this.paY = true;
          com.tencent.mm.plugin.report.service.h.wUl.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.pba), "", str1, Long.valueOf(this.pbb), this.pbc });
          AppMethodBeat.o(108634);
          return;
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", (String)localObject2);
        }
        if (com.tencent.mm.plugin.emoji.h.a.g(localEmotionSummary))
        {
          com.tencent.mm.plugin.emoji.f.a.cct();
          com.tencent.mm.plugin.emoji.f.a.ccu();
          AppMethodBeat.o(108634);
          return;
        }
        l(str1, null, str3, localEmotionSummary.IconUrl);
        if (this.paX != null) {
          this.paX.cQ(str1, 0);
        }
        ac.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str1 });
        com.tencent.mm.plugin.report.service.h.wUl.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(this.pba), "", str1, Long.valueOf(this.pbb), this.pbc });
      } while (this.pbh == null);
      this.pbh.dHA = 2;
      this.pbh.fS(localEmotionSummary.ProductID);
      localObject2 = this.pbh;
      if (this.pbi) {}
      for (localObject1 = localEmotionSummary.ExptDesc;; localObject1 = localEmotionSummary.Introduce)
      {
        ((w)localObject2).fT((String)localObject1);
        this.pbh.fU(String.valueOf(parama.mPosition + 1));
        this.pbh.aHZ();
        AppMethodBeat.o(108634);
        return;
      }
    case -1: 
      if (e.a(localEmotionSummary)) {
        i = 3;
      }
      for (;;)
      {
        this.paX.cP(str1, i);
        AppMethodBeat.o(108634);
        return;
        if ((e.b(localEmotionSummary)) || ((!bool1) && (TextUtils.isEmpty(localEmotionSummary.PackPrice))))
        {
          i = 3;
        }
        else if (bool1)
        {
          parama = localc.XE(str1);
          if (TextUtils.isEmpty(parama.GXN)) {
            i = parama.GXJ;
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
      parama = localc.XE(str1);
      if (parama != null) {
        switch (parama.GXK)
        {
        default: 
          parama = getString(2131758412);
        }
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.c(this.mHB, parama, null, true);
        AppMethodBeat.o(108634);
        return;
        parama = getString(2131758261);
        continue;
        parama = getString(2131758270);
        continue;
        parama = getString(2131758407);
      }
    }
    ac.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
    AppMethodBeat.o(108634);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108636);
    ac.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    String str1 = "";
    int i = 0;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_err_code", 0);
      ac.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:".concat(String.valueOf(i)));
      str1 = paramIntent.getStringExtra("key_err_msg");
      ac.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:".concat(String.valueOf(str1)));
    }
    this.paY = false;
    if (paramInt2 != -1)
    {
      if (paramInt1 == 2001)
      {
        if (u.axK())
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 6L, 1L, false);
          AppMethodBeat.o(108636);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 2L, 1L, false);
      }
      AppMethodBeat.o(108636);
      return;
    }
    switch (paramInt1)
    {
    case 2002: 
    default: 
      ac.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
      AppMethodBeat.o(108636);
      return;
    case 2003: 
      str1 = this.pbf.pmB;
      if (bs.isNullOrNil(str1))
      {
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.emoji.h.c.a(paramIntent, str1, (Activity)this.mHB);
      com.tencent.mm.plugin.report.service.h.wUl.f(12069, new Object[] { Integer.valueOf(3), str1 });
      AppMethodBeat.o(108636);
      return;
    }
    if ((this.paX == null) || (this.paX.oXZ == null))
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
        ax localax = this.paX.oXZ.XE(str2);
        if (this.pbe.equals(str2))
        {
          i = 1;
          l(str2, str3, localax.pio, null);
          this.paX.cQ(this.pbe, 0);
          com.tencent.mm.ui.base.h.cg(this.mHB, str1);
          ac.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          paramInt1 = i;
          if (localArrayList.size() <= 1) {
            break label506;
          }
          ac.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
          paramInt1 = i;
          if (this.pbd == null) {
            break label506;
          }
          this.pbd.cci();
          paramInt1 = 1;
        }
        label506:
        for (;;)
        {
          paramInt2 += 1;
          break;
          this.paX.cP(this.pbe, 5);
        }
      }
      if (paramInt1 == 0) {
        Ym(str1);
      }
      if (u.axK())
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 4L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 0L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      paramIntent = this.paX.oXZ.XE(this.pbe);
      l(this.pbe, null, paramIntent.pio, null);
      this.paX.cQ(this.pbe, 0);
      ac.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.pbe });
      Ym(str1);
      if (u.axK())
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 7L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 3L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (u.axK()) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 6L, 1L, false);
      }
      for (;;)
      {
        ac.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
        AppMethodBeat.o(108636);
        return;
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 2L, 1L, false);
      }
    }
    if ((this.pbe == null) || (this.paX == null) || (this.paX.oXZ == null))
    {
      Ym(str1);
      if (!u.axK()) {
        break label864;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 5L, 1L, false);
    }
    for (;;)
    {
      ac.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      AppMethodBeat.o(108636);
      return;
      this.paX.oXZ.XC(this.pbe);
      paramIntent = this.paX.XA(this.pbe);
      if (paramIntent == null) {
        break;
      }
      paramIntent.cbB();
      break;
      label864:
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(166L, 1L, 1L, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.emoji.a.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void cci();
    
    public abstract void l(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.j
 * JD-Core Version:    0.7.0.1
 */