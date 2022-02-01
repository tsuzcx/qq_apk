package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.ba;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bh;
import java.util.ArrayList;

public final class o
{
  private final String TAG;
  private Context mAppContext;
  private akh uBa;
  public com.tencent.mm.plugin.emoji.a.a.a uEH;
  public boolean uEI;
  public Context uEJ;
  public Fragment uEK;
  public int uEL;
  public long uEM;
  public String uEN;
  public b uEO;
  private String uEP;
  private com.tencent.mm.plugin.emoji.i.c uEQ;
  public String uER;
  public ba uES;
  public boolean uET;
  
  public o()
  {
    AppMethodBeat.i(108633);
    this.TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    this.uEI = false;
    this.uEM = 0L;
    this.uEN = "";
    this.uET = false;
    this.mAppContext = MMApplicationContext.getContext();
    this.uEQ = new com.tencent.mm.plugin.emoji.i.c(2003);
    AppMethodBeat.o(108633);
  }
  
  private void auK(String paramString)
  {
    AppMethodBeat.i(108637);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(i.h.emoji_play_failed);
    }
    com.tencent.mm.ui.base.h.d(this.uEJ, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(108637);
  }
  
  private void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(257967);
    if (this.uEO != null) {
      this.uEO.d(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
    AppMethodBeat.o(257967);
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
    if ((parama == null) || (parama.uzy == null) || (this.uEH == null) || (this.uEH.uAO == null))
    {
      AppMethodBeat.o(108634);
      return;
    }
    akh localakh = parama.uzy.uBa;
    this.uBa = localakh;
    if (localakh == null)
    {
      AppMethodBeat.o(108634);
      return;
    }
    String str1 = localakh.ProductID;
    String str3 = localakh.Suv;
    Object localObject2 = localakh.VHC;
    String str2 = localakh.SuH;
    int i = parama.cTE();
    Object localObject1;
    com.tencent.mm.plugin.emoji.a.a.c localc;
    boolean bool1;
    boolean bool2;
    if (parama.uzy == null)
    {
      localObject1 = null;
      ((Integer)localObject1).intValue();
      localc = this.uEH.uAO;
      bool1 = localc.uAX;
      bool2 = parama.uzy.uBe;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label284;
      }
      localObject1 = "";
      label150:
      Log.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { str1, localObject1, Integer.valueOf(i) });
      this.uEP = str1;
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
            localObject1 = Integer.valueOf(parama.uzy.uBc);
            break;
            localObject1 = localObject2;
            break label150;
            parama = new r(str1, 2);
            com.tencent.mm.kernel.h.aHF().kcd.a(parama, 0);
            AppMethodBeat.o(108634);
            return;
            if (this.uEH != null) {
              this.uEH.dw(str1, 3);
            }
            AppMethodBeat.o(108634);
            return;
            if (bool2)
            {
              if (this.uEK != null)
              {
                i = 1;
                if (i == 0) {
                  break label482;
                }
                parama = this.uEQ;
                localObject1 = this.uEK;
                Log.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("MMActivity.OverrideEnterAnimation", i.a.fast_faded_in);
                ((Intent)localObject2).putExtra("MMActivity.OverrideExitAnimation", i.a.push_down_out);
                com.tencent.mm.by.c.a((Fragment)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, parama.qVk);
                ((Fragment)localObject1).getActivity().overridePendingTransition(i.a.push_up_in, i.a.fast_faded_out);
              }
              for (;;)
              {
                this.uEQ.uQY = str1;
                com.tencent.mm.plugin.report.service.h.IzE.a(12069, new Object[] { Integer.valueOf(1), str1 });
                AppMethodBeat.o(108634);
                return;
                i = 0;
                break;
                this.uEQ.O((Activity)this.uEJ);
              }
            }
          } while (!parama.uzy.uBg);
          localObject1 = parama.uzy.uBa.ProductID;
          localObject2 = parama.uzy.uBa.Suv;
          str1 = this.uER;
          if (this.uEJ != null)
          {
            if (this.uEL == 9) {}
            for (i = 3;; i = 4)
            {
              parama = new Intent();
              parama.setClass(this.uEJ, EmojiStoreV2RewardUI.class);
              parama.putExtra("extra_id", (String)localObject1);
              parama.putExtra("extra_name", (String)localObject2);
              parama.putExtra("name", str1);
              parama.putExtra("scene", this.uEL);
              parama.putExtra("pageType", i);
              parama.putExtra("searchID", this.uEM);
              localObject2 = this.uEJ;
              parama = new com.tencent.mm.hellhoundlib.b.a().bm(parama);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, parama.aFh(), "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)parama.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/emoji/model/PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.IzE.a(12738, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(this.uEL), Integer.valueOf(0) });
              AppMethodBeat.o(108634);
              return;
            }
          }
          Log.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
          AppMethodBeat.o(108634);
          return;
        } while (this.uEI);
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
          com.tencent.mm.by.c.b(this.uEJ, "wallet_index", ".ui.WalletIapUI", parama, 2001);
          this.uEI = true;
          com.tencent.mm.plugin.report.service.h.IzE.a(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.uEL), "", str1, Long.valueOf(this.uEM), this.uEN });
          AppMethodBeat.o(108634);
          return;
          parama.putExtra("key_currency_type", str2);
          parama.putExtra("key_price", (String)localObject2);
        }
        if (com.tencent.mm.plugin.emoji.i.a.g(localakh))
        {
          com.tencent.mm.plugin.emoji.f.a.cUV();
          com.tencent.mm.plugin.emoji.f.a.cUW();
          AppMethodBeat.o(108634);
          return;
        }
        d(str1, null, str3, localakh.CNj, localakh.VHD);
        if (this.uEH != null) {
          this.uEH.dx(str1, 0);
        }
        Log.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str1 });
        com.tencent.mm.plugin.report.service.h.IzE.a(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(this.uEL), "", str1, Long.valueOf(this.uEM), this.uEN });
      } while (this.uES == null);
      this.uES.gly = 2;
      this.uES.jy(localakh.ProductID);
      localObject2 = this.uES;
      if (this.uET) {}
      for (localObject1 = localakh.VHR;; localObject1 = localakh.VHP)
      {
        ((ba)localObject2).jz((String)localObject1);
        this.uES.jA(String.valueOf(parama.mPosition + 1));
        this.uES.bpa();
        AppMethodBeat.o(108634);
        return;
      }
    case -1: 
      if (e.a(localakh)) {
        i = 3;
      }
      for (;;)
      {
        this.uEH.dw(str1, i);
        AppMethodBeat.o(108634);
        return;
        if ((e.b(localakh)) || ((!bool1) && (TextUtils.isEmpty(localakh.Tex))))
        {
          i = 3;
        }
        else if (bool1)
        {
          parama = localc.atY(str1);
          if (TextUtils.isEmpty(parama.VFu)) {
            i = parama.VFq;
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
      label482:
      parama = localc.atY(str1);
      if (parama != null) {
        switch (parama.VFr)
        {
        default: 
          parama = getString(i.h.emoji_unknow);
        }
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.c(this.uEJ, parama, null, true);
        AppMethodBeat.o(108634);
        return;
        parama = getString(i.h.emoji_google_no_install);
        continue;
        parama = getString(i.h.emoji_no_on_sale);
        continue;
        parama = getString(i.h.emoji_timeout);
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
    this.uEI = false;
    if (paramInt2 != -1)
    {
      if (paramInt1 == 2001)
      {
        if (z.bdp())
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 6L, 1L, false);
          AppMethodBeat.o(108636);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 2L, 1L, false);
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
      str1 = this.uEQ.uQY;
      if (Util.isNullOrNil(str1))
      {
        AppMethodBeat.o(108636);
        return;
      }
      this.uEQ.a(paramIntent, str1, (Activity)this.uEJ);
      com.tencent.mm.plugin.report.service.h.IzE.a(12069, new Object[] { Integer.valueOf(3), str1 });
      AppMethodBeat.o(108636);
      return;
    }
    if ((this.uEH == null) || (this.uEH.uAO == null))
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
        bh localbh = this.uEH.uAO.atY(str2);
        if (this.uEP.equals(str2))
        {
          paramIntent = null;
          if (this.uBa != null) {
            paramIntent = this.uBa.VHD;
          }
          d(str2, str3, localbh.uMF, null, paramIntent);
          this.uEH.dx(this.uEP, 0);
          com.tencent.mm.ui.base.h.cO(this.uEJ, str1);
          Log.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          if (((ArrayList)localObject).size() > 1)
          {
            Log.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
            if (this.uEO != null) {
              this.uEO.cUJ();
            }
          }
          paramInt2 = 1;
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          this.uEH.dw(this.uEP, 5);
        }
      }
      if (paramInt2 == 0) {
        auK(str1);
      }
      if (z.bdp())
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 4L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 0L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      localObject = this.uEH.uAO.atY(this.uEP);
      paramIntent = null;
      if (this.uBa != null) {
        paramIntent = this.uBa.VHD;
      }
      d(this.uEP, null, ((bh)localObject).uMF, null, paramIntent);
      this.uEH.dx(this.uEP, 0);
      Log.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.uEP });
      auK(str1);
      if (z.bdp())
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 7L, 1L, false);
        AppMethodBeat.o(108636);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 3L, 1L, false);
      AppMethodBeat.o(108636);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (z.bdp()) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 6L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
        AppMethodBeat.o(108636);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 2L, 1L, false);
      }
    }
    if ((this.uEP == null) || (this.uEH == null) || (this.uEH.uAO == null))
    {
      auK(str1);
      if (!z.bdp()) {
        break label899;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 5L, 1L, false);
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      AppMethodBeat.o(108636);
      return;
      this.uEH.uAO.atW(this.uEP);
      paramIntent = this.uEH.atU(this.uEP);
      if (paramIntent == null) {
        break;
      }
      paramIntent.cTJ();
      break;
      label899:
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(166L, 1L, 1L, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.emoji.a.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void cUJ();
    
    public abstract void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.o
 * JD-Core Version:    0.7.0.1
 */