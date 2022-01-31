package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;

public final class h
{
  private final String TAG = "MicroMsg.emoji.PayOrDownloadComponent";
  public Context hxz;
  public com.tencent.mm.plugin.emoji.a.a.a iYq;
  public boolean iYr = false;
  public Fragment iYs;
  public int iYt;
  public long iYu = 0L;
  public String iYv = "";
  public h.b iYw;
  private String iYx;
  private com.tencent.mm.plugin.emoji.h.c iYy = new com.tencent.mm.plugin.emoji.h.c(2003);
  public String iYz;
  private Context ze = ae.getContext();
  
  private void AR(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(f.h.emoji_play_failed);
    }
    com.tencent.mm.ui.base.h.a(this.hxz, str, "", new h.1(this));
  }
  
  private String getString(int paramInt)
  {
    return this.ze.getString(paramInt);
  }
  
  private void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.iYw != null) {
      this.iYw.i(paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public final void a(com.tencent.mm.plugin.emoji.a.a parama)
  {
    if ((parama == null) || (parama.iUv == null) || (this.iYq == null) || (this.iYq.iVI == null)) {}
    label86:
    label255:
    do
    {
      vn localvn;
      Object localObject3;
      String str2;
      Object localObject2;
      String str1;
      int i;
      com.tencent.mm.plugin.emoji.a.a.c localc;
      boolean bool1;
      do
      {
        do
        {
          boolean bool2;
          do
          {
            do
            {
              return;
              localvn = parama.iUv.iVU;
            } while (localvn == null);
            localObject3 = localvn.syc;
            str2 = localvn.sSc;
            localObject2 = localvn.sSn;
            str1 = localvn.sSo;
            i = parama.aGH();
            if (parama.iUv == null)
            {
              localObject1 = null;
              ((Integer)localObject1).intValue();
              localc = this.iYq.iVI;
              bool1 = localc.iVR;
              bool2 = parama.iUv.iVY;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                break label255;
              }
            }
            for (localObject1 = "";; localObject1 = localObject2)
            {
              y.i("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { localObject3, localObject1, Integer.valueOf(i) });
              this.iYx = ((String)localObject3);
              switch (i)
              {
              case 1: 
              case 2: 
              case 6: 
              case 8: 
              default: 
                y.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
                return;
                localObject1 = Integer.valueOf(parama.iUv.iVW);
                break label86;
              }
            }
            parama = new r((String)localObject3, 2);
            g.DO().dJT.a(parama, 0);
            return;
          } while (this.iYq == null);
          this.iYq.bt((String)localObject3, 3);
          return;
          if (bool2)
          {
            if (this.iYs != null)
            {
              i = 1;
              if (i == 0) {
                break label438;
              }
              parama = this.iYy;
              localObject1 = this.iYs;
              y.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("MMActivity.OverrideEnterAnimation", f.a.fast_faded_in);
              ((Intent)localObject2).putExtra("MMActivity.OverrideExitAnimation", f.a.push_down_out);
              d.a((Fragment)localObject1, ".ui.transmit.SelectConversationUI", (Intent)localObject2, parama.hcT);
              ((Fragment)localObject1).getActivity().overridePendingTransition(f.a.push_up_in, f.a.fast_faded_out);
            }
            for (;;)
            {
              this.iYy.jjP = ((String)localObject3);
              com.tencent.mm.plugin.report.service.h.nFQ.f(12069, new Object[] { Integer.valueOf(1), localObject3 });
              return;
              i = 0;
              break;
              this.iYy.x((Activity)this.hxz);
            }
          }
        } while (!parama.iUv.iWa);
        Object localObject1 = parama.iUv.iVU.syc;
        parama = parama.iUv.iVU.sSc;
        localObject2 = this.iYz;
        if (this.hxz != null)
        {
          if (this.iYt == 9) {}
          for (i = 3;; i = 4)
          {
            localObject3 = new Intent();
            ((Intent)localObject3).setClass(this.hxz, EmojiStoreV2RewardUI.class);
            ((Intent)localObject3).putExtra("extra_id", (String)localObject1);
            ((Intent)localObject3).putExtra("extra_name", parama);
            ((Intent)localObject3).putExtra("name", (String)localObject2);
            ((Intent)localObject3).putExtra("scene", this.iYt);
            ((Intent)localObject3).putExtra("pageType", i);
            ((Intent)localObject3).putExtra("searchID", this.iYu);
            this.hxz.startActivity((Intent)localObject3);
            com.tencent.mm.plugin.report.service.h.nFQ.f(12738, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(this.iYt), Integer.valueOf(0) });
            return;
          }
        }
        y.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
        return;
      } while (this.iYr);
      parama = new Intent();
      parama.putExtra("key_product_id", (String)localObject3);
      if (bool1)
      {
        parama.putExtra("key_currency_type", "");
        parama.putExtra("key_price", (String)localObject2);
      }
      for (;;)
      {
        d.b(this.hxz, "wallet_index", ".ui.WalletIapUI", parama, 2001);
        this.iYr = true;
        com.tencent.mm.plugin.report.service.h.nFQ.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.iYt), "", localObject3, Long.valueOf(this.iYu), this.iYv });
        return;
        parama.putExtra("key_currency_type", str1);
        parama.putExtra("key_price", (String)localObject2);
      }
      if (com.tencent.mm.plugin.emoji.h.a.d(localvn))
      {
        com.tencent.mm.plugin.emoji.f.b.aHY();
        com.tencent.mm.plugin.emoji.f.b.aHZ();
        return;
      }
      i((String)localObject3, null, str2, localvn.kSy);
      if (this.iYq != null) {
        this.iYq.bu((String)localObject3, 0);
      }
      y.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { localObject3 });
      com.tencent.mm.plugin.report.service.h.nFQ.f(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(this.iYt), "", localObject3, Long.valueOf(this.iYu), this.iYv });
      return;
      if (e.a(localvn)) {
        i = 3;
      }
      for (;;)
      {
        this.iYq.bt((String)localObject3, i);
        return;
        if ((e.b(localvn)) || ((!bool1) && (TextUtils.isEmpty(localvn.sSf))))
        {
          i = 3;
        }
        else if (bool1)
        {
          parama = localc.Ao((String)localObject3);
          if (TextUtils.isEmpty(parama.uAQ)) {
            i = parama.uAO;
          } else {
            i = 4;
          }
        }
        else
        {
          i = 4;
        }
      }
      parama = localc.Ao((String)localObject3);
    } while (parama == null);
    label438:
    switch (parama.uAP)
    {
    default: 
      parama = getString(f.h.emoji_unknow);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.b(this.hxz, parama, null, true);
      return;
      parama = getString(f.h.emoji_google_no_install);
      continue;
      parama = getString(f.h.emoji_no_on_sale);
      continue;
      parama = getString(f.h.emoji_timeout);
    }
    y.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    String str1 = "";
    int i = 0;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_err_code", 0);
      y.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:" + i);
      str1 = paramIntent.getStringExtra("key_err_msg");
      y.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:" + str1);
    }
    this.iYr = false;
    if (paramInt2 != -1) {
      if (paramInt1 == 2001)
      {
        if (!q.Gv()) {
          break label146;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 6L, 1L, false);
      }
    }
    label146:
    do
    {
      do
      {
        return;
        com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 2L, 1L, false);
        return;
        switch (paramInt1)
        {
        case 2002: 
        default: 
          y.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
          return;
        case 2003: 
          str1 = this.iYy.jjP;
        }
      } while (bk.bl(str1));
      com.tencent.mm.plugin.emoji.h.c.a(paramIntent, str1, (Activity)this.hxz);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12069, new Object[] { Integer.valueOf(3), str1 });
      return;
    } while ((this.iYq == null) || (this.iYq.iVI == null));
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
        ar localar = this.iYq.iVI.Ao(str2);
        if (this.iYx.equals(str2))
        {
          i = 1;
          i(str2, str3, localar.jfG, null);
          this.iYq.bu(this.iYx, 0);
          com.tencent.mm.ui.base.h.bC(this.hxz, str1);
          y.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          paramInt1 = i;
          if (localArrayList.size() <= 1) {
            break label476;
          }
          y.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
          paramInt1 = i;
          if (this.iYw == null) {
            break label476;
          }
          this.iYw.aHM();
          paramInt1 = 1;
        }
        label476:
        for (;;)
        {
          paramInt2 += 1;
          break;
          this.iYq.bt(this.iYx, 5);
        }
      }
      if (paramInt1 == 0) {
        AR(str1);
      }
      if (q.Gv())
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 4L, 1L, false);
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 0L, 1L, false);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      paramIntent = this.iYq.iVI.Ao(this.iYx);
      i(this.iYx, null, paramIntent.jfG, null);
      this.iYq.bu(this.iYx, 0);
      y.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.iYx });
      AR(str1);
      if (q.Gv())
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 7L, 1L, false);
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 3L, 1L, false);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (q.Gv()) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 6L, 1L, false);
      }
      for (;;)
      {
        y.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
        return;
        com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 2L, 1L, false);
      }
    }
    if ((this.iYx == null) || (this.iYq == null) || (this.iYq.iVI == null))
    {
      AR(str1);
      if (!q.Gv()) {
        break label798;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 5L, 1L, false);
    }
    for (;;)
    {
      y.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      return;
      this.iYq.iVI.Am(this.iYx);
      paramIntent = this.iYq.Ak(this.iYx);
      if (paramIntent == null) {
        break;
      }
      paramIntent.aGM();
      break;
      label798:
      com.tencent.mm.plugin.report.service.h.nFQ.a(166L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.h
 * JD-Core Version:    0.7.0.1
 */