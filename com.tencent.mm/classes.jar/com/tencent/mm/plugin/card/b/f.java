package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  private int fRv;
  public com.tencent.mm.plugin.card.base.b oDm;
  private MMActivity oDq;
  public List<com.tencent.mm.plugin.card.model.b> oDr;
  public com.tencent.mm.plugin.card.model.b oDs;
  private ArrayList<tn> oDt;
  
  public f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(112618);
    this.fRv = 3;
    this.oDr = new ArrayList();
    this.oDq = paramMMActivity;
    AppMethodBeat.o(112618);
  }
  
  private boolean bVE()
  {
    AppMethodBeat.i(112620);
    if ((l.AZ(this.fRv)) || (l.Ba(this.fRv)) || (this.fRv == 23))
    {
      if ((this.oDm.isAcceptable()) && (this.oDm.bVc().Gkr != null) && (!TextUtils.isEmpty(this.oDm.bVc().Gkr.text)) && (!TextUtils.isEmpty(this.oDm.bVc().GjV)))
      {
        AppMethodBeat.o(112620);
        return true;
      }
    }
    else if ((this.fRv == 6) && (this.oDm.bUZ()) && (this.oDm.bVc().Gkr != null) && (!TextUtils.isEmpty(this.oDm.bVc().Gkr.text)) && (!TextUtils.isEmpty(this.oDm.bVc().GjV)))
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
    String str = this.oDq.getString(paramInt);
    AppMethodBeat.o(112623);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, ArrayList<tn> paramArrayList, int paramInt)
  {
    this.oDm = paramb;
    this.oDt = paramArrayList;
    this.fRv = paramInt;
  }
  
  public final List<com.tencent.mm.plugin.card.model.b> bVD()
  {
    AppMethodBeat.i(112619);
    this.oDr.clear();
    if ((this.oDm.bVd().Gia != null) && (!bu.isNullOrNil(this.oDm.bVd().Gia.title)))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).oEz = 1;
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.oDm.bVd().Gia.title;
      ((com.tencent.mm.plugin.card.model.b)localObject1).oIr = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_card_gift";
      ((com.tencent.mm.plugin.card.model.b)localObject1).pqW = this.oDm.bVd().Gia.pqW;
      this.oDr.add(localObject1);
    }
    if ((this.oDm.bVd().GhJ != null) && (this.oDm.bVd().GhJ.size() > 0))
    {
      localObject1 = l.cI(this.oDm.bVd().GhJ);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.card.model.b)((List)localObject1).get(0)).oEA = false;
        this.oDr.addAll((Collection)localObject1);
      }
    }
    int i;
    if (((this.fRv == 6) && (this.oDm.bVd().GhN <= 0)) || ((l.Bb(this.fRv)) && (this.oDm.bUY()) && (this.oDm.bUH()) && (this.oDm.bUP())))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).oEz = 1;
      if (!bu.isNullOrNil(this.oDm.bVc().GkJ))
      {
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.oDm.bVc().GkJ;
        ((com.tencent.mm.plugin.card.model.b)localObject1).oIr = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_gift";
        this.oDr.add(localObject1);
      }
    }
    else
    {
      if ((this.oDm.bVd().status != 0) && (this.oDm.bVd().status != 1)) {
        this.oDm.bVd();
      }
      if ((this.fRv != 3) && (this.fRv == 6)) {
        this.oDm.bVd();
      }
      localObject2 = this.oDm.bVc().Gkp;
      if (this.oDm.bVd().GhT != null) {
        TextUtils.isEmpty(this.oDm.bVd().GhT.title);
      }
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      if (!this.oDm.bUN()) {
        break label1076;
      }
      i = 0;
      label479:
      ((com.tencent.mm.plugin.card.model.b)localObject1).oEA = false;
      ((com.tencent.mm.plugin.card.model.b)localObject1).oEz = 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getTitle());
      ((StringBuilder)localObject2).append(getString(2131756829));
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = ((StringBuilder)localObject2).toString();
      ((com.tencent.mm.plugin.card.model.b)localObject1).oEp = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).oIr = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_detail";
      if (i != 0) {
        this.oDr.add(localObject1);
      }
      if ((!this.oDm.bUL()) || (this.oDm.bVc().Gkc <= 0))
      {
        if ((!this.oDm.bUJ()) || (this.oDm.bVc().Gkc <= 0))
        {
          if (this.oDm.bVc().Gkc <= 0) {
            break label925;
          }
          ae.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.oDm.bVc().Gkc);
          if ((this.oDm.bVc().Gkc > 0) && (this.oDt != null) && (this.oDt.size() > 0))
          {
            localObject1 = (tn)this.oDt.get(0);
            if ((localObject1 == null) || (((tn)localObject1).zOO >= 50000.0F)) {
              break label1124;
            }
            localObject2 = new com.tencent.mm.plugin.card.model.b();
            ((com.tencent.mm.plugin.card.model.b)localObject2).oEz = 2;
            ((com.tencent.mm.plugin.card.model.b)localObject2).title = ((tn)localObject1).name;
            ((com.tencent.mm.plugin.card.model.b)localObject2).oEp = this.oDq.getString(2131756996, new Object[] { l.f(this.oDq, ((tn)localObject1).zOO), ((tn)localObject1).hZQ });
            ((com.tencent.mm.plugin.card.model.b)localObject2).oIr = "";
            ((com.tencent.mm.plugin.card.model.b)localObject2).url = "card://jump_shop";
            ((com.tencent.mm.plugin.card.model.b)localObject2).oED = ((tn)localObject1).oED;
            ((com.tencent.mm.plugin.card.model.b)localObject2).hDr = this.oDm.bVc().hDr;
            this.oDr.add(localObject2);
          }
        }
        label826:
        if ((this.oDm.bVc().Gkc <= 0) || (this.oDt != null)) {
          break label1170;
        }
        localObject1 = new com.tencent.mm.plugin.card.model.b();
        ((com.tencent.mm.plugin.card.model.b)localObject1).oEz = 1;
        if (TextUtils.isEmpty(this.oDm.bVc().GkA)) {
          break label1156;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.oDm.bVc().GkA;
        ((com.tencent.mm.plugin.card.model.b)localObject1).oEp = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).oIr = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
        this.oDr.add(localObject1);
      }
    }
    label925:
    label1076:
    label1124:
    while ((this.oDm.bVc().Gkc <= 0) || (this.oDt == null) || (this.oDt.size() <= 0)) {
      for (;;)
      {
        if (((!this.oDm.bUN()) || (this.oDm.bVd().status != 3)) && (!TextUtils.isEmpty(this.oDm.bVc().GjV))) {
          this.oDr.add(bVG());
        }
        if (!this.oDm.bUJ()) {
          break label1493;
        }
        localObject1 = this.oDr.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.tencent.mm.plugin.card.model.b)((Iterator)localObject1).next()).oEC = true;
        }
        if (this.oDm.bUN())
        {
          ((com.tencent.mm.plugin.card.model.b)localObject1).title = ak.getResources().getString(2131756937);
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = ak.getContext().getString(2131756936);
        break;
        if ((localObject2 != null) && (((aeu)localObject2).GuW != null) && (((aeu)localObject2).GuW.size() > 0) && (!TextUtils.isEmpty((CharSequence)((aeu)localObject2).GuW.get(0))))
        {
          i = 0;
          break label479;
        }
        i = 1;
        break label479;
        if (localObject1 == null) {
          break label826;
        }
        ae.e("MicroMsg.CardDetailDataMgr", "distance:" + ((tn)localObject1).zOO);
        break label826;
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756800);
      }
    }
    label1156:
    label1170:
    Object localObject1 = new com.tencent.mm.plugin.card.model.b();
    ((com.tencent.mm.plugin.card.model.b)localObject1).oEz = 1;
    Object localObject2 = (tn)this.oDt.get(0);
    if (!TextUtils.isEmpty(this.oDm.bVc().GkA))
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.oDm.bVc().GkA;
      label1261:
      if ((!this.oDm.bUJ()) || (((tn)localObject2).zOO >= 2000.0F)) {
        break label1484;
      }
      if ((this.oDm.bVc().Gkc <= 1) && ((this.oDt == null) || (this.oDt.size() <= 1))) {
        break label1466;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).oEp = this.oDq.getString(2131756932, new Object[] { l.f(this.oDq, ((tn)localObject2).zOO) });
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).oIr = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
      this.oDr.add(localObject1);
      break;
      if ((!this.oDm.bUJ()) && (((tn)localObject2).zOO < 5000.0F))
      {
        if ((this.oDm.bVc().Gkc == 1) || (this.oDt.size() == 1))
        {
          ae.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756807);
        break label1261;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756800);
      break label1261;
      label1466:
      ((com.tencent.mm.plugin.card.model.b)localObject1).oEp = l.f(this.oDq, ((tn)localObject2).zOO);
      continue;
      label1484:
      ((com.tencent.mm.plugin.card.model.b)localObject1).oEp = "";
    }
    label1493:
    localObject1 = this.oDr;
    AppMethodBeat.o(112619);
    return localObject1;
  }
  
  public final boolean bVF()
  {
    if (this.oDs == null) {
      return false;
    }
    return this.oDs.dLH;
  }
  
  public final com.tencent.mm.plugin.card.model.b bVG()
  {
    AppMethodBeat.i(112621);
    com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
    localb.oEz = 1;
    localb.oEB = bVE();
    if ((localb.oEB) || (TextUtils.isEmpty(this.oDm.bVc().Gkk))) {
      if (x.An(this.oDm.bVc().GjV))
      {
        localb.title = getString(2131756935);
        localb.oEB = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.oDm.bVc().Gkm)) {
        localb.oEp = this.oDm.bVc().Gkm;
      }
      localb.oIr = "";
      localb.url = "card://jump_service";
      this.oDs = localb;
      localb = this.oDs;
      AppMethodBeat.o(112621);
      return localb;
      localb.title = getString(2131756934);
      if ((this.oDm.bVc().Gkr != null) && (this.oDm.bVc().Gkr.GKG == 1))
      {
        localb.dLH = true;
      }
      else
      {
        localb.dLH = false;
        continue;
        localb.title = this.oDm.bVc().Gkk;
      }
    }
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(112622);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.oDm.bVc().oFF)) {
      ((StringBuilder)localObject).append(this.oDm.bVc().oFF);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(112622);
      return localObject;
      if (this.oDm.bUJ()) {
        ((StringBuilder)localObject).append(getString(2131756930));
      } else if (this.oDm.bUK()) {
        ((StringBuilder)localObject).append(getString(2131756824));
      } else if (this.oDm.bUL()) {
        ((StringBuilder)localObject).append(getString(2131756805));
      } else if (this.oDm.bUM()) {
        ((StringBuilder)localObject).append(getString(2131756834));
      } else if (this.oDm.bUN()) {
        ((StringBuilder)localObject).append(getString(2131756899));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.f
 * JD-Core Version:    0.7.0.1
 */