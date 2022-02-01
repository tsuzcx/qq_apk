package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  private int gwE;
  public com.tencent.mm.plugin.card.base.b pQV;
  private MMActivity pQZ;
  public List<com.tencent.mm.plugin.card.model.b> pRa;
  public com.tencent.mm.plugin.card.model.b pRb;
  private ArrayList<us> pRc;
  
  public f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(112618);
    this.gwE = 3;
    this.pRa = new ArrayList();
    this.pQZ = paramMMActivity;
    AppMethodBeat.o(112618);
  }
  
  private boolean cts()
  {
    AppMethodBeat.i(112620);
    if ((l.EH(this.gwE)) || (l.EI(this.gwE)) || (this.gwE == 23))
    {
      if ((this.pQV.isAcceptable()) && (this.pQV.csQ().LeU != null) && (!TextUtils.isEmpty(this.pQV.csQ().LeU.text)) && (!TextUtils.isEmpty(this.pQV.csQ().KZR)))
      {
        AppMethodBeat.o(112620);
        return true;
      }
    }
    else if ((this.gwE == 6) && (this.pQV.csN()) && (this.pQV.csQ().LeU != null) && (!TextUtils.isEmpty(this.pQV.csQ().LeU.text)) && (!TextUtils.isEmpty(this.pQV.csQ().KZR)))
    {
      AppMethodBeat.o(112620);
      return true;
    }
    AppMethodBeat.o(112620);
    return false;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(112623);
    String str = this.pQZ.getString(paramInt);
    AppMethodBeat.o(112623);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, ArrayList<us> paramArrayList, int paramInt)
  {
    this.pQV = paramb;
    this.pRc = paramArrayList;
    this.gwE = paramInt;
  }
  
  public final List<com.tencent.mm.plugin.card.model.b> ctr()
  {
    AppMethodBeat.i(112619);
    this.pRa.clear();
    if ((this.pQV.csR().LcD != null) && (!Util.isNullOrNil(this.pQV.csR().LcD.title)))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).pSi = 1;
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.pQV.csR().LcD.title;
      ((com.tencent.mm.plugin.card.model.b)localObject1).pWf = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_card_gift";
      ((com.tencent.mm.plugin.card.model.b)localObject1).qGB = this.pQV.csR().LcD.qGB;
      this.pRa.add(localObject1);
    }
    if ((this.pQV.csR().Lcm != null) && (this.pQV.csR().Lcm.size() > 0))
    {
      localObject1 = l.cX(this.pQV.csR().Lcm);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.card.model.b)((List)localObject1).get(0)).pSj = false;
        this.pRa.addAll((Collection)localObject1);
      }
    }
    int i;
    if (((this.gwE == 6) && (this.pQV.csR().Lcq <= 0)) || ((l.EJ(this.gwE)) && (this.pQV.csM()) && (this.pQV.csv()) && (this.pQV.csD())))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).pSi = 1;
      if (!Util.isNullOrNil(this.pQV.csQ().Lfl))
      {
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.pQV.csQ().Lfl;
        ((com.tencent.mm.plugin.card.model.b)localObject1).pWf = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_gift";
        this.pRa.add(localObject1);
      }
    }
    else
    {
      if ((this.pQV.csR().status != 0) && (this.pQV.csR().status != 1)) {
        this.pQV.csR();
      }
      if ((this.gwE != 3) && (this.gwE == 6)) {
        this.pQV.csR();
      }
      localObject2 = this.pQV.csQ().LeS;
      if (this.pQV.csR().Lcw != null) {
        TextUtils.isEmpty(this.pQV.csR().Lcw.title);
      }
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      if (!this.pQV.csB()) {
        break label1076;
      }
      i = 0;
      label479:
      ((com.tencent.mm.plugin.card.model.b)localObject1).pSj = false;
      ((com.tencent.mm.plugin.card.model.b)localObject1).pSi = 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getTitle());
      ((StringBuilder)localObject2).append(getString(2131756994));
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = ((StringBuilder)localObject2).toString();
      ((com.tencent.mm.plugin.card.model.b)localObject1).pRY = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).pWf = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_detail";
      if (i != 0) {
        this.pRa.add(localObject1);
      }
      if ((!this.pQV.csz()) || (this.pQV.csQ().LeF <= 0))
      {
        if ((!this.pQV.csx()) || (this.pQV.csQ().LeF <= 0))
        {
          if (this.pQV.csQ().LeF <= 0) {
            break label925;
          }
          Log.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.pQV.csQ().LeF);
          if ((this.pQV.csQ().LeF > 0) && (this.pRc != null) && (this.pRc.size() > 0))
          {
            localObject1 = (us)this.pRc.get(0);
            if ((localObject1 == null) || (((us)localObject1).DWG >= 50000.0F)) {
              break label1124;
            }
            localObject2 = new com.tencent.mm.plugin.card.model.b();
            ((com.tencent.mm.plugin.card.model.b)localObject2).pSi = 2;
            ((com.tencent.mm.plugin.card.model.b)localObject2).title = ((us)localObject1).name;
            ((com.tencent.mm.plugin.card.model.b)localObject2).pRY = this.pQZ.getString(2131757166, new Object[] { l.f(this.pQZ, ((us)localObject1).DWG), ((us)localObject1).iUO });
            ((com.tencent.mm.plugin.card.model.b)localObject2).pWf = "";
            ((com.tencent.mm.plugin.card.model.b)localObject2).url = "card://jump_shop";
            ((com.tencent.mm.plugin.card.model.b)localObject2).pSm = ((us)localObject1).pSm;
            ((com.tencent.mm.plugin.card.model.b)localObject2).ixw = this.pQV.csQ().ixw;
            this.pRa.add(localObject2);
          }
        }
        label826:
        if ((this.pQV.csQ().LeF <= 0) || (this.pRc != null)) {
          break label1170;
        }
        localObject1 = new com.tencent.mm.plugin.card.model.b();
        ((com.tencent.mm.plugin.card.model.b)localObject1).pSi = 1;
        if (TextUtils.isEmpty(this.pQV.csQ().Lfd)) {
          break label1156;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.pQV.csQ().Lfd;
        ((com.tencent.mm.plugin.card.model.b)localObject1).pRY = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).pWf = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
        this.pRa.add(localObject1);
      }
    }
    label925:
    label1076:
    label1124:
    while ((this.pQV.csQ().LeF <= 0) || (this.pRc == null) || (this.pRc.size() <= 0)) {
      for (;;)
      {
        if (((!this.pQV.csB()) || (this.pQV.csR().status != 3)) && (!TextUtils.isEmpty(this.pQV.csQ().KZR))) {
          this.pRa.add(ctu());
        }
        if (!this.pQV.csx()) {
          break label1493;
        }
        localObject1 = this.pRa.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.tencent.mm.plugin.card.model.b)((Iterator)localObject1).next()).pSl = true;
        }
        if (this.pQV.csB())
        {
          ((com.tencent.mm.plugin.card.model.b)localObject1).title = MMApplicationContext.getResources().getString(2131757107);
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = MMApplicationContext.getContext().getString(2131757106);
        break;
        if ((localObject2 != null) && (((agy)localObject2).LqB != null) && (((agy)localObject2).LqB.size() > 0) && (!TextUtils.isEmpty((CharSequence)((agy)localObject2).LqB.get(0))))
        {
          i = 0;
          break label479;
        }
        i = 1;
        break label479;
        if (localObject1 == null) {
          break label826;
        }
        Log.e("MicroMsg.CardDetailDataMgr", "distance:" + ((us)localObject1).DWG);
        break label826;
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756965);
      }
    }
    label1156:
    label1170:
    Object localObject1 = new com.tencent.mm.plugin.card.model.b();
    ((com.tencent.mm.plugin.card.model.b)localObject1).pSi = 1;
    Object localObject2 = (us)this.pRc.get(0);
    if (!TextUtils.isEmpty(this.pQV.csQ().Lfd))
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.pQV.csQ().Lfd;
      label1261:
      if ((!this.pQV.csx()) || (((us)localObject2).DWG >= 2000.0F)) {
        break label1484;
      }
      if ((this.pQV.csQ().LeF <= 1) && ((this.pRc == null) || (this.pRc.size() <= 1))) {
        break label1466;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).pRY = this.pQZ.getString(2131757102, new Object[] { l.f(this.pQZ, ((us)localObject2).DWG) });
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).pWf = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
      this.pRa.add(localObject1);
      break;
      if ((!this.pQV.csx()) && (((us)localObject2).DWG < 5000.0F))
      {
        if ((this.pQV.csQ().LeF == 1) || (this.pRc.size() == 1))
        {
          Log.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756972);
        break label1261;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756965);
      break label1261;
      label1466:
      ((com.tencent.mm.plugin.card.model.b)localObject1).pRY = l.f(this.pQZ, ((us)localObject2).DWG);
      continue;
      label1484:
      ((com.tencent.mm.plugin.card.model.b)localObject1).pRY = "";
    }
    label1493:
    localObject1 = this.pRa;
    AppMethodBeat.o(112619);
    return localObject1;
  }
  
  public final boolean ctt()
  {
    if (this.pRb == null) {
      return false;
    }
    return this.pRb.edw;
  }
  
  public final com.tencent.mm.plugin.card.model.b ctu()
  {
    AppMethodBeat.i(112621);
    com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
    localb.pSi = 1;
    localb.pSk = cts();
    if ((localb.pSk) || (TextUtils.isEmpty(this.pQV.csQ().LeN))) {
      if (ab.IS(this.pQV.csQ().KZR))
      {
        localb.title = getString(2131757105);
        localb.pSk = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.pQV.csQ().LeP)) {
        localb.pRY = this.pQV.csQ().LeP;
      }
      localb.pWf = "";
      localb.url = "card://jump_service";
      this.pRb = localb;
      localb = this.pRb;
      AppMethodBeat.o(112621);
      return localb;
      localb.title = getString(2131757104);
      if ((this.pQV.csQ().LeU != null) && (this.pQV.csQ().LeU.LOA == 1))
      {
        localb.edw = true;
      }
      else
      {
        localb.edw = false;
        continue;
        localb.title = this.pQV.csQ().LeN;
      }
    }
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(112622);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.pQV.csQ().pTn)) {
      ((StringBuilder)localObject).append(this.pQV.csQ().pTn);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(112622);
      return localObject;
      if (this.pQV.csx()) {
        ((StringBuilder)localObject).append(getString(2131757100));
      } else if (this.pQV.csy()) {
        ((StringBuilder)localObject).append(getString(2131756989));
      } else if (this.pQV.csz()) {
        ((StringBuilder)localObject).append(getString(2131756970));
      } else if (this.pQV.csA()) {
        ((StringBuilder)localObject).append(getString(2131756999));
      } else if (this.pQV.csB()) {
        ((StringBuilder)localObject).append(getString(2131757069));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.f
 * JD-Core Version:    0.7.0.1
 */