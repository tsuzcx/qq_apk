package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
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
  private int fsv;
  public com.tencent.mm.plugin.card.base.b nqp;
  private MMActivity nqt;
  public List<com.tencent.mm.plugin.card.model.b> nqu;
  public com.tencent.mm.plugin.card.model.b nqv;
  private ArrayList<rh> nqw;
  
  public f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(112618);
    this.fsv = 3;
    this.nqu = new ArrayList();
    this.nqt = paramMMActivity;
    AppMethodBeat.o(112618);
  }
  
  private boolean bIx()
  {
    AppMethodBeat.i(112620);
    if ((l.zn(this.fsv)) || (l.zo(this.fsv)) || (this.fsv == 23))
    {
      if ((this.nqp.isAcceptable()) && (this.nqp.bHV().CRY != null) && (!TextUtils.isEmpty(this.nqp.bHV().CRY.text)) && (!TextUtils.isEmpty(this.nqp.bHV().CRC)))
      {
        AppMethodBeat.o(112620);
        return true;
      }
    }
    else if ((this.fsv == 6) && (this.nqp.bHS()) && (this.nqp.bHV().CRY != null) && (!TextUtils.isEmpty(this.nqp.bHV().CRY.text)) && (!TextUtils.isEmpty(this.nqp.bHV().CRC)))
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
    String str = this.nqt.getString(paramInt);
    AppMethodBeat.o(112623);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, ArrayList<rh> paramArrayList, int paramInt)
  {
    this.nqp = paramb;
    this.nqw = paramArrayList;
    this.fsv = paramInt;
  }
  
  public final List<com.tencent.mm.plugin.card.model.b> bIw()
  {
    AppMethodBeat.i(112619);
    this.nqu.clear();
    if ((this.nqp.bHW().CPG != null) && (!bt.isNullOrNil(this.nqp.bHW().CPG.title)))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).nrC = 1;
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.nqp.bHW().CPG.title;
      ((com.tencent.mm.plugin.card.model.b)localObject1).nvv = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_card_gift";
      ((com.tencent.mm.plugin.card.model.b)localObject1).odo = this.nqp.bHW().CPG.odo;
      this.nqu.add(localObject1);
    }
    if ((this.nqp.bHW().CPp != null) && (this.nqp.bHW().CPp.size() > 0))
    {
      localObject1 = l.cC(this.nqp.bHW().CPp);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.card.model.b)((List)localObject1).get(0)).nrD = false;
        this.nqu.addAll((Collection)localObject1);
      }
    }
    int i;
    if (((this.fsv == 6) && (this.nqp.bHW().CPt <= 0)) || ((l.zp(this.fsv)) && (this.nqp.bHR()) && (this.nqp.bHA()) && (this.nqp.bHI())))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).nrC = 1;
      if (!bt.isNullOrNil(this.nqp.bHV().CSq))
      {
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.nqp.bHV().CSq;
        ((com.tencent.mm.plugin.card.model.b)localObject1).nvv = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_gift";
        this.nqu.add(localObject1);
      }
    }
    else
    {
      if ((this.nqp.bHW().status != 0) && (this.nqp.bHW().status != 1)) {
        this.nqp.bHW();
      }
      if ((this.fsv != 3) && (this.fsv == 6)) {
        this.nqp.bHW();
      }
      localObject2 = this.nqp.bHV().CRW;
      if (this.nqp.bHW().CPz != null) {
        TextUtils.isEmpty(this.nqp.bHW().CPz.title);
      }
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      if (!this.nqp.bHG()) {
        break label1076;
      }
      i = 0;
      label479:
      ((com.tencent.mm.plugin.card.model.b)localObject1).nrD = false;
      ((com.tencent.mm.plugin.card.model.b)localObject1).nrC = 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getTitle());
      ((StringBuilder)localObject2).append(getString(2131756829));
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = ((StringBuilder)localObject2).toString();
      ((com.tencent.mm.plugin.card.model.b)localObject1).nrs = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).nvv = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_detail";
      if (i != 0) {
        this.nqu.add(localObject1);
      }
      if ((!this.nqp.bHE()) || (this.nqp.bHV().CRJ <= 0))
      {
        if ((!this.nqp.bHC()) || (this.nqp.bHV().CRJ <= 0))
        {
          if (this.nqp.bHV().CRJ <= 0) {
            break label925;
          }
          ad.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.nqp.bHV().CRJ);
          if ((this.nqp.bHV().CRJ > 0) && (this.nqw != null) && (this.nqw.size() > 0))
          {
            localObject1 = (rh)this.nqw.get(0);
            if ((localObject1 == null) || (((rh)localObject1).wUu >= 50000.0F)) {
              break label1124;
            }
            localObject2 = new com.tencent.mm.plugin.card.model.b();
            ((com.tencent.mm.plugin.card.model.b)localObject2).nrC = 2;
            ((com.tencent.mm.plugin.card.model.b)localObject2).title = ((rh)localObject1).name;
            ((com.tencent.mm.plugin.card.model.b)localObject2).nrs = this.nqt.getString(2131756996, new Object[] { l.f(this.nqt, ((rh)localObject1).wUu), ((rh)localObject1).hdQ });
            ((com.tencent.mm.plugin.card.model.b)localObject2).nvv = "";
            ((com.tencent.mm.plugin.card.model.b)localObject2).url = "card://jump_shop";
            ((com.tencent.mm.plugin.card.model.b)localObject2).nrG = ((rh)localObject1).nrG;
            ((com.tencent.mm.plugin.card.model.b)localObject2).gHT = this.nqp.bHV().gHT;
            this.nqu.add(localObject2);
          }
        }
        label826:
        if ((this.nqp.bHV().CRJ <= 0) || (this.nqw != null)) {
          break label1170;
        }
        localObject1 = new com.tencent.mm.plugin.card.model.b();
        ((com.tencent.mm.plugin.card.model.b)localObject1).nrC = 1;
        if (TextUtils.isEmpty(this.nqp.bHV().CSh)) {
          break label1156;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.nqp.bHV().CSh;
        ((com.tencent.mm.plugin.card.model.b)localObject1).nrs = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).nvv = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
        this.nqu.add(localObject1);
      }
    }
    label925:
    label1076:
    label1124:
    while ((this.nqp.bHV().CRJ <= 0) || (this.nqw == null) || (this.nqw.size() <= 0)) {
      for (;;)
      {
        if (((!this.nqp.bHG()) || (this.nqp.bHW().status != 3)) && (!TextUtils.isEmpty(this.nqp.bHV().CRC))) {
          this.nqu.add(bIz());
        }
        if (!this.nqp.bHC()) {
          break label1493;
        }
        localObject1 = this.nqu.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.tencent.mm.plugin.card.model.b)((Iterator)localObject1).next()).nrF = true;
        }
        if (this.nqp.bHG())
        {
          ((com.tencent.mm.plugin.card.model.b)localObject1).title = aj.getResources().getString(2131756937);
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = aj.getContext().getString(2131756936);
        break;
        if ((localObject2 != null) && (((abm)localObject2).DbO != null) && (((abm)localObject2).DbO.size() > 0) && (!TextUtils.isEmpty((CharSequence)((abm)localObject2).DbO.get(0))))
        {
          i = 0;
          break label479;
        }
        i = 1;
        break label479;
        if (localObject1 == null) {
          break label826;
        }
        ad.e("MicroMsg.CardDetailDataMgr", "distance:" + ((rh)localObject1).wUu);
        break label826;
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756800);
      }
    }
    label1156:
    label1170:
    Object localObject1 = new com.tencent.mm.plugin.card.model.b();
    ((com.tencent.mm.plugin.card.model.b)localObject1).nrC = 1;
    Object localObject2 = (rh)this.nqw.get(0);
    if (!TextUtils.isEmpty(this.nqp.bHV().CSh))
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.nqp.bHV().CSh;
      label1261:
      if ((!this.nqp.bHC()) || (((rh)localObject2).wUu >= 2000.0F)) {
        break label1484;
      }
      if ((this.nqp.bHV().CRJ <= 1) && ((this.nqw == null) || (this.nqw.size() <= 1))) {
        break label1466;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).nrs = this.nqt.getString(2131756932, new Object[] { l.f(this.nqt, ((rh)localObject2).wUu) });
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).nvv = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
      this.nqu.add(localObject1);
      break;
      if ((!this.nqp.bHC()) && (((rh)localObject2).wUu < 5000.0F))
      {
        if ((this.nqp.bHV().CRJ == 1) || (this.nqw.size() == 1))
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
      ((com.tencent.mm.plugin.card.model.b)localObject1).nrs = l.f(this.nqt, ((rh)localObject2).wUu);
      continue;
      label1484:
      ((com.tencent.mm.plugin.card.model.b)localObject1).nrs = "";
    }
    label1493:
    localObject1 = this.nqu;
    AppMethodBeat.o(112619);
    return localObject1;
  }
  
  public final boolean bIy()
  {
    if (this.nqv == null) {
      return false;
    }
    return this.nqv.dAt;
  }
  
  public final com.tencent.mm.plugin.card.model.b bIz()
  {
    AppMethodBeat.i(112621);
    com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
    localb.nrC = 1;
    localb.nrE = bIx();
    if ((localb.nrE) || (TextUtils.isEmpty(this.nqp.bHV().CRR))) {
      if (w.sD(this.nqp.bHV().CRC))
      {
        localb.title = getString(2131756935);
        localb.nrE = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.nqp.bHV().CRT)) {
        localb.nrs = this.nqp.bHV().CRT;
      }
      localb.nvv = "";
      localb.url = "card://jump_service";
      this.nqv = localb;
      localb = this.nqv;
      AppMethodBeat.o(112621);
      return localb;
      localb.title = getString(2131756934);
      if ((this.nqp.bHV().CRY != null) && (this.nqp.bHV().CRY.Dnr == 1))
      {
        localb.dAt = true;
      }
      else
      {
        localb.dAt = false;
        continue;
        localb.title = this.nqp.bHV().CRR;
      }
    }
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(112622);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.nqp.bHV().nsJ)) {
      ((StringBuilder)localObject).append(this.nqp.bHV().nsJ);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(112622);
      return localObject;
      if (this.nqp.bHC()) {
        ((StringBuilder)localObject).append(getString(2131756930));
      } else if (this.nqp.bHD()) {
        ((StringBuilder)localObject).append(getString(2131756824));
      } else if (this.nqp.bHE()) {
        ((StringBuilder)localObject).append(getString(2131756805));
      } else if (this.nqp.bHF()) {
        ((StringBuilder)localObject).append(getString(2131756834));
      } else if (this.nqp.bHG()) {
        ((StringBuilder)localObject).append(getString(2131756899));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.f
 * JD-Core Version:    0.7.0.1
 */