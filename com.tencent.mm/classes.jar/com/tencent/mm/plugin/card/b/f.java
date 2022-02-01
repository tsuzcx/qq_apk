package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  private int fPp;
  public com.tencent.mm.plugin.card.base.b owK;
  private MMActivity owO;
  public List<com.tencent.mm.plugin.card.model.b> owP;
  public com.tencent.mm.plugin.card.model.b owQ;
  private ArrayList<tl> owR;
  
  public f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(112618);
    this.fPp = 3;
    this.owP = new ArrayList();
    this.owO = paramMMActivity;
    AppMethodBeat.o(112618);
  }
  
  private boolean bUp()
  {
    AppMethodBeat.i(112620);
    if ((l.AN(this.fPp)) || (l.AO(this.fPp)) || (this.fPp == 23))
    {
      if ((this.owK.isAcceptable()) && (this.owK.bTN().FRS != null) && (!TextUtils.isEmpty(this.owK.bTN().FRS.text)) && (!TextUtils.isEmpty(this.owK.bTN().FRw)))
      {
        AppMethodBeat.o(112620);
        return true;
      }
    }
    else if ((this.fPp == 6) && (this.owK.bTK()) && (this.owK.bTN().FRS != null) && (!TextUtils.isEmpty(this.owK.bTN().FRS.text)) && (!TextUtils.isEmpty(this.owK.bTN().FRw)))
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
    String str = this.owO.getString(paramInt);
    AppMethodBeat.o(112623);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, ArrayList<tl> paramArrayList, int paramInt)
  {
    this.owK = paramb;
    this.owR = paramArrayList;
    this.fPp = paramInt;
  }
  
  public final List<com.tencent.mm.plugin.card.model.b> bUo()
  {
    AppMethodBeat.i(112619);
    this.owP.clear();
    if ((this.owK.bTO().FPB != null) && (!bt.isNullOrNil(this.owK.bTO().FPB.title)))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).oxX = 1;
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.owK.bTO().FPB.title;
      ((com.tencent.mm.plugin.card.model.b)localObject1).oBP = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_card_gift";
      ((com.tencent.mm.plugin.card.model.b)localObject1).pkr = this.owK.bTO().FPB.pkr;
      this.owP.add(localObject1);
    }
    if ((this.owK.bTO().FPk != null) && (this.owK.bTO().FPk.size() > 0))
    {
      localObject1 = l.cF(this.owK.bTO().FPk);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.card.model.b)((List)localObject1).get(0)).oxY = false;
        this.owP.addAll((Collection)localObject1);
      }
    }
    int i;
    if (((this.fPp == 6) && (this.owK.bTO().FPo <= 0)) || ((l.AP(this.fPp)) && (this.owK.bTJ()) && (this.owK.bTs()) && (this.owK.bTA())))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).oxX = 1;
      if (!bt.isNullOrNil(this.owK.bTN().FSk))
      {
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.owK.bTN().FSk;
        ((com.tencent.mm.plugin.card.model.b)localObject1).oBP = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_gift";
        this.owP.add(localObject1);
      }
    }
    else
    {
      if ((this.owK.bTO().status != 0) && (this.owK.bTO().status != 1)) {
        this.owK.bTO();
      }
      if ((this.fPp != 3) && (this.fPp == 6)) {
        this.owK.bTO();
      }
      localObject2 = this.owK.bTN().FRQ;
      if (this.owK.bTO().FPu != null) {
        TextUtils.isEmpty(this.owK.bTO().FPu.title);
      }
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      if (!this.owK.bTy()) {
        break label1076;
      }
      i = 0;
      label479:
      ((com.tencent.mm.plugin.card.model.b)localObject1).oxY = false;
      ((com.tencent.mm.plugin.card.model.b)localObject1).oxX = 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getTitle());
      ((StringBuilder)localObject2).append(getString(2131756829));
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = ((StringBuilder)localObject2).toString();
      ((com.tencent.mm.plugin.card.model.b)localObject1).oxN = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).oBP = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_detail";
      if (i != 0) {
        this.owP.add(localObject1);
      }
      if ((!this.owK.bTw()) || (this.owK.bTN().FRD <= 0))
      {
        if ((!this.owK.bTu()) || (this.owK.bTN().FRD <= 0))
        {
          if (this.owK.bTN().FRD <= 0) {
            break label925;
          }
          ad.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.owK.bTN().FRD);
          if ((this.owK.bTN().FRD > 0) && (this.owR != null) && (this.owR.size() > 0))
          {
            localObject1 = (tl)this.owR.get(0);
            if ((localObject1 == null) || (((tl)localObject1).zxp >= 50000.0F)) {
              break label1124;
            }
            localObject2 = new com.tencent.mm.plugin.card.model.b();
            ((com.tencent.mm.plugin.card.model.b)localObject2).oxX = 2;
            ((com.tencent.mm.plugin.card.model.b)localObject2).title = ((tl)localObject1).name;
            ((com.tencent.mm.plugin.card.model.b)localObject2).oxN = this.owO.getString(2131756996, new Object[] { l.f(this.owO, ((tl)localObject1).zxp), ((tl)localObject1).hWY });
            ((com.tencent.mm.plugin.card.model.b)localObject2).oBP = "";
            ((com.tencent.mm.plugin.card.model.b)localObject2).url = "card://jump_shop";
            ((com.tencent.mm.plugin.card.model.b)localObject2).oyb = ((tl)localObject1).oyb;
            ((com.tencent.mm.plugin.card.model.b)localObject2).hAD = this.owK.bTN().hAD;
            this.owP.add(localObject2);
          }
        }
        label826:
        if ((this.owK.bTN().FRD <= 0) || (this.owR != null)) {
          break label1170;
        }
        localObject1 = new com.tencent.mm.plugin.card.model.b();
        ((com.tencent.mm.plugin.card.model.b)localObject1).oxX = 1;
        if (TextUtils.isEmpty(this.owK.bTN().FSb)) {
          break label1156;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.owK.bTN().FSb;
        ((com.tencent.mm.plugin.card.model.b)localObject1).oxN = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).oBP = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
        this.owP.add(localObject1);
      }
    }
    label925:
    label1076:
    label1124:
    while ((this.owK.bTN().FRD <= 0) || (this.owR == null) || (this.owR.size() <= 0)) {
      for (;;)
      {
        if (((!this.owK.bTy()) || (this.owK.bTO().status != 3)) && (!TextUtils.isEmpty(this.owK.bTN().FRw))) {
          this.owP.add(bUr());
        }
        if (!this.owK.bTu()) {
          break label1493;
        }
        localObject1 = this.owP.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.tencent.mm.plugin.card.model.b)((Iterator)localObject1).next()).oya = true;
        }
        if (this.owK.bTy())
        {
          ((com.tencent.mm.plugin.card.model.b)localObject1).title = aj.getResources().getString(2131756937);
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = aj.getContext().getString(2131756936);
        break;
        if ((localObject2 != null) && (((ael)localObject2).Gcp != null) && (((ael)localObject2).Gcp.size() > 0) && (!TextUtils.isEmpty((CharSequence)((ael)localObject2).Gcp.get(0))))
        {
          i = 0;
          break label479;
        }
        i = 1;
        break label479;
        if (localObject1 == null) {
          break label826;
        }
        ad.e("MicroMsg.CardDetailDataMgr", "distance:" + ((tl)localObject1).zxp);
        break label826;
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756800);
      }
    }
    label1156:
    label1170:
    Object localObject1 = new com.tencent.mm.plugin.card.model.b();
    ((com.tencent.mm.plugin.card.model.b)localObject1).oxX = 1;
    Object localObject2 = (tl)this.owR.get(0);
    if (!TextUtils.isEmpty(this.owK.bTN().FSb))
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.owK.bTN().FSb;
      label1261:
      if ((!this.owK.bTu()) || (((tl)localObject2).zxp >= 2000.0F)) {
        break label1484;
      }
      if ((this.owK.bTN().FRD <= 1) && ((this.owR == null) || (this.owR.size() <= 1))) {
        break label1466;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).oxN = this.owO.getString(2131756932, new Object[] { l.f(this.owO, ((tl)localObject2).zxp) });
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).oBP = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
      this.owP.add(localObject1);
      break;
      if ((!this.owK.bTu()) && (((tl)localObject2).zxp < 5000.0F))
      {
        if ((this.owK.bTN().FRD == 1) || (this.owR.size() == 1))
        {
          ad.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756807);
        break label1261;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756800);
      break label1261;
      label1466:
      ((com.tencent.mm.plugin.card.model.b)localObject1).oxN = l.f(this.owO, ((tl)localObject2).zxp);
      continue;
      label1484:
      ((com.tencent.mm.plugin.card.model.b)localObject1).oxN = "";
    }
    label1493:
    localObject1 = this.owP;
    AppMethodBeat.o(112619);
    return localObject1;
  }
  
  public final boolean bUq()
  {
    if (this.owQ == null) {
      return false;
    }
    return this.owQ.dKs;
  }
  
  public final com.tencent.mm.plugin.card.model.b bUr()
  {
    AppMethodBeat.i(112621);
    com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
    localb.oxX = 1;
    localb.oxZ = bUp();
    if ((localb.oxZ) || (TextUtils.isEmpty(this.owK.bTN().FRL))) {
      if (w.zD(this.owK.bTN().FRw))
      {
        localb.title = getString(2131756935);
        localb.oxZ = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.owK.bTN().FRN)) {
        localb.oxN = this.owK.bTN().FRN;
      }
      localb.oBP = "";
      localb.url = "card://jump_service";
      this.owQ = localb;
      localb = this.owQ;
      AppMethodBeat.o(112621);
      return localb;
      localb.title = getString(2131756934);
      if ((this.owK.bTN().FRS != null) && (this.owK.bTN().FRS.Gri == 1))
      {
        localb.dKs = true;
      }
      else
      {
        localb.dKs = false;
        continue;
        localb.title = this.owK.bTN().FRL;
      }
    }
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(112622);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.owK.bTN().ozd)) {
      ((StringBuilder)localObject).append(this.owK.bTN().ozd);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(112622);
      return localObject;
      if (this.owK.bTu()) {
        ((StringBuilder)localObject).append(getString(2131756930));
      } else if (this.owK.bTv()) {
        ((StringBuilder)localObject).append(getString(2131756824));
      } else if (this.owK.bTw()) {
        ((StringBuilder)localObject).append(getString(2131756805));
      } else if (this.owK.bTx()) {
        ((StringBuilder)localObject).append(getString(2131756834));
      } else if (this.owK.bTy()) {
        ((StringBuilder)localObject).append(getString(2131756899));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.f
 * JD-Core Version:    0.7.0.1
 */