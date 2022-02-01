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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bh;
import java.util.ArrayList;

public final class j
{
  private final String TAG;
  private Context mAppContext;
  public Context owO;
  private EmotionSummary qYl;
  public com.tencent.mm.plugin.emoji.a.a.a rbD;
  public boolean rbE;
  public Fragment rbF;
  public int rbG;
  public long rbH;
  public String rbI;
  public b rbJ;
  private String rbK;
  private com.tencent.mm.plugin.emoji.h.c rbL;
  public String rbM;
  public as rbN;
  public boolean rbO;
  
  public j()
  {
    AppMethodBeat.i(108633);
    this.TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    this.rbE = false;
    this.rbH = 0L;
    this.rbI = "";
    this.rbO = false;
    this.mAppContext = MMApplicationContext.getContext();
    this.rbL = new com.tencent.mm.plugin.emoji.h.c(2003);
    AppMethodBeat.o(108633);
  }
  
  private void amQ(String paramString)
  {
    AppMethodBeat.i(108637);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131758575);
    }
    com.tencent.mm.ui.base.h.d(this.owO, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(108637);
  }
  
  private void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(240148);
    if (this.rbJ != null) {
      this.rbJ.d(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
    AppMethodBeat.o(240148);
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
    if ((parama == null) || (parama.qWK == null) || (this.rbD == null) || (this.rbD.qXZ == null))
    {
      AppMethodBeat.o(108634);
      return;
    }
    EmotionSummary localEmotionSummary = parama.qWK.qYl;
    this.qYl = localEmotionSummary;
    if (localEmotionSummary == null)
    {
      AppMethodBeat.o(108634);
      return;
    }
    String str1 = localEmotionSummary.ProductID;
    String str3 = localEmotionSummary.PackName;
    Object localObject2 = localEmotionSummary.PriceNum;
    String str2 = localEmotionSummary.PriceType;
    int i = parama.cFc();
    Object localObject1;
    com.tencent.mm.plugin.emoji.a.a.c localc;
    boolean bool1;
    boolean bool2;
    if (parama.qWK == null)
    {
      localObject1 = null;
      ((Integer)localObject1).intValue();
      localc = this.rbD.qXZ;
      bool1 = localc.qYi;
      bool2 = parama.qWK.qYp;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label284;
      }
      localObject1 = "";
      label150:
      Log.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str1, localObject1, Integer.valueOf(i) });
      this.rbK = str1;
    }
    switch (i)
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
            localObject1 = Integer.valueOf(parama.qWK.qYn);
            break;
            localObject1 = localObject2;
            break label150;
            parama = new r(str1, 2);
            g.aAg().hqi.a(parama, 0);
            AppMethodBeat.o(108634);
            return;
            if (this.rbD != null) {
              this.rbD.dc(str1, 3);
            }
            AppMethodBeat.o(108634);
            return;
            if (bool2)
            {
              if (this.rbF != null)
              {
                i = 1;
                if (i == 0) {
                  break label478;
                }
                parama = this.rbL;
                localObject1 = this.rbF;
                Log.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
                ((Intent)localObject2).putExtra("MMActivity.OverrideExitAnimation", 2130772130);
                com.tencent.mm.br.c.a((Fragment)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, parama.nTL);
                ((Fragment)localObject1).getActivity().overridePendingTransition(2130772132, 2130772060);
              }
              for (;;)
              {
                this.rbL.rnF = str1;
                com.tencent.mm.plugin.report.service.h.CyF.a(12069, new Object[] { Integer.valueOf(1), str1 });
                AppMethodBeat.o(108634);
                return;
                i = 0;
                break;
                this.rbL.N((Activity)this.owO);
              }
            }
          } while (!parama.qWK.qYr);
          localObject1 = parama.qWK.qYl.ProductID;
          localObject2 = parama.qWK.qYl.PackName;
          str1 = this.rbM;
          if (this.owO != null)
          {
            if (this.rbG == 9) {}
            for (i = 3;; i = 4)
            {
              parama = new Intent();
              parama.setClass(this.owO, EmojiStoreV2RewardUI.class);
              parama.putExtra("extra_id", (String)localObject1);
              parama.putExtra("extra_name", (String)localObject2);
              parama.putExtra("name", str1);
              parama.putExtra("scene", this.rbG);
              parama.putExtra("pageType", i);
              parama.putExtra("searchID", this.rbH);
              localObject2 = this.owO;
              parama = new com.tencent.mm.hellhoundlib.b.a().bl(parama);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, parama.axQ(), "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)parama.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(this.rbG), Integer.valueOf(0) });
              AppMethodBeat.o(108634);
              return;
            }
          }
          Log.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
          AppMethodBeat.o(108634);
          return;
        } while (this.rbE);
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
          com.tencent.mm.br.c.b(this.owO, "wallet_index", ".ui.WalletIapUI", parama, 2001);
          this.rbE = true;
          com.tencent.mm.plugin.report.service.h.CyF.a(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.rbG), "", str1, Long.valueOf(this.rbH), this.rbI });
          AppMethodBeat.o(108634);
          return;
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", (String)localObject2);
        }
        if (com.tencent.mm.plugin.emoji.h.a.g(localEmotionSummary))
        {
          com.tencent.mm.plugin.emoji.f.a.cGm();
          com.tencent.mm.plugin.emoji.f.a.cGn();
          AppMethodBeat.o(108634);
          return;
        }
        d(str1, null, str3, localEmotionSummary.IconUrl, localEmotionSummary.PanelUrl);
        if (this.rbD != null) {
          this.rbD.dd(str1, 0);
        }
        Log.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str1 });
        com.tencent.mm.plugin.report.service.h.CyF.a(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(this.rbG), "", str1, Long.valueOf(this.rbH), this.rbI });
      } while (this.rbN == null);
      this.rbN.eqm = 2;
      this.rbN.ix(localEmotionSummary.ProductID);
      localObject2 = this.rbN;
      if (this.rbO) {}
      for (localObject1 = localEmotionSummary.ExptDesc;; localObject1 = localEmotionSummary.Introduce)
      {
        ((as)localObject2).iy((String)localObject1);
        this.rbN.iz(String.valueOf(parama.mPosition + 1));
        this.rbN.bfK();
        AppMethodBeat.o(108634);
        return;
      }
    case -1: 
      if (e.a(localEmotionSummary)) {
        i = 3;
      }
      for (;;)
      {
        this.rbD.dc(str1, i);
        AppMethodBeat.o(108634);
        return;
        if ((e.b(localEmotionSummary)) || ((!bool1) && (TextUtils.isEmpty(localEmotionSummary.PackPrice))))
        {
          i = 3;
        }
        else if (bool1)
        {
          parama = localc.ame(str1);
          if (TextUtils.isEmpty(parama.OpB)) {
            i = parama.Opx;
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
      label284:
      label478:
      parama = localc.ame(str1);
      if (parama != null) {
        switch (parama.Opy)
        {
        default: 
          parama = getString(2131758706);
        }
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.c(this.owO, parama, null, true);
        AppMethodBeat.o(108634);
        return;
        parama = getString(2131758549);
        continue;
        parama = getString(2131758558);
        continue;
        parama = getString(2131758701);
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
    this.rbE = false;
    if (paramInt2 != -1)
    {
      if (paramInt1 == 2001)
      {
        if (z.aUn())
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 6L, 1L, false);
          AppMethodBeat.o(108636);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 2L, 1L, false);
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
      str1 = this.rbL.rnF;
      if (Util.isNullOrNil(str1))
      {
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.emoji.h.c.a(paramIntent, str1, (Activity)this.owO);
      com.tencent.mm.plugin.report.service.h.CyF.a(12069, new Object[] { Integer.valueOf(3), str1 });
      AppMethodBeat.o(108636);
      return;
    }
    if ((this.rbD == null) || (this.rbD.qXZ == null))
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
        bh localbh = this.rbD.qXZ.ame(str2);
        if (this.rbK.equals(str2))
        {
          paramIntent = null;
          if (this.qYl != null) {
            paramIntent = this.qYl.PanelUrl;
          }
          d(str2, str3, localbh.rjt, null, paramIntent);
          this.rbD.dd(this.rbK, 0);
          com.tencent.mm.ui.base.h.cD(this.owO, str1);
          Log.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          if (((ArrayList)localObject).size() > 1)
          {
            Log.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
            if (this.rbJ != null) {
              this.rbJ.cGa();
            }
          }
          paramInt2 = 1;
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          this.rbD.dc(this.rbK, 5);
        }
      }
      if (paramInt2 == 0) {
        amQ(str1);
      }
      if (z.aUn())
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 4L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 0L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      localObject = this.rbD.qXZ.ame(this.rbK);
      paramIntent = null;
      if (this.qYl != null) {
        paramIntent = this.qYl.PanelUrl;
      }
      d(this.rbK, null, ((bh)localObject).rjt, null, paramIntent);
      this.rbD.dd(this.rbK, 0);
      Log.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.rbK });
      amQ(str1);
      if (z.aUn())
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 7L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 3L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (z.aUn()) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 6L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
        AppMethodBeat.o(108636);
        return;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 2L, 1L, false);
      }
    }
    if ((this.rbK == null) || (this.rbD == null) || (this.rbD.qXZ == null))
    {
      amQ(str1);
      if (!z.aUn()) {
        break label895;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 5L, 1L, false);
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      AppMethodBeat.o(108636);
      return;
      this.rbD.qXZ.amc(this.rbK);
      paramIntent = this.rbD.ama(this.rbK);
      if (paramIntent == null) {
        break;
      }
      paramIntent.cFh();
      break;
      label895:
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 1L, 1L, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.emoji.a.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void cGa();
    
    public abstract void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.j
 * JD-Core Version:    0.7.0.1
 */