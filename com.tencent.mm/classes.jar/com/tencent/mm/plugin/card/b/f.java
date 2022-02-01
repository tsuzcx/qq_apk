package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  private int fwc;
  public com.tencent.mm.plugin.card.base.b nTp;
  private MMActivity nTt;
  public List<com.tencent.mm.plugin.card.model.b> nTu;
  public com.tencent.mm.plugin.card.model.b nTv;
  private ArrayList<rr> nTw;
  
  public f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(112618);
    this.fwc = 3;
    this.nTu = new ArrayList();
    this.nTt = paramMMActivity;
    AppMethodBeat.o(112618);
  }
  
  private boolean bPK()
  {
    AppMethodBeat.i(112620);
    if ((l.Ae(this.fwc)) || (l.Af(this.fwc)) || (this.fwc == 23))
    {
      if ((this.nTp.isAcceptable()) && (this.nTp.bPi().EkJ != null) && (!TextUtils.isEmpty(this.nTp.bPi().EkJ.text)) && (!TextUtils.isEmpty(this.nTp.bPi().Ekn)))
      {
        AppMethodBeat.o(112620);
        return true;
      }
    }
    else if ((this.fwc == 6) && (this.nTp.bPf()) && (this.nTp.bPi().EkJ != null) && (!TextUtils.isEmpty(this.nTp.bPi().EkJ.text)) && (!TextUtils.isEmpty(this.nTp.bPi().Ekn)))
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
    String str = this.nTt.getString(paramInt);
    AppMethodBeat.o(112623);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, ArrayList<rr> paramArrayList, int paramInt)
  {
    this.nTp = paramb;
    this.nTw = paramArrayList;
    this.fwc = paramInt;
  }
  
  public final List<com.tencent.mm.plugin.card.model.b> bPJ()
  {
    AppMethodBeat.i(112619);
    this.nTu.clear();
    if ((this.nTp.bPj().Eir != null) && (!bs.isNullOrNil(this.nTp.bPj().Eir.title)))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).nUC = 1;
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.nTp.bPj().Eir.title;
      ((com.tencent.mm.plugin.card.model.b)localObject1).nYv = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_card_gift";
      ((com.tencent.mm.plugin.card.model.b)localObject1).oGN = this.nTp.bPj().Eir.oGN;
      this.nTu.add(localObject1);
    }
    if ((this.nTp.bPj().Eia != null) && (this.nTp.bPj().Eia.size() > 0))
    {
      localObject1 = l.cE(this.nTp.bPj().Eia);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.card.model.b)((List)localObject1).get(0)).nUD = false;
        this.nTu.addAll((Collection)localObject1);
      }
    }
    int i;
    if (((this.fwc == 6) && (this.nTp.bPj().Eie <= 0)) || ((l.Ag(this.fwc)) && (this.nTp.bPe()) && (this.nTp.bON()) && (this.nTp.bOV())))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).nUC = 1;
      if (!bs.isNullOrNil(this.nTp.bPi().Elb))
      {
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.nTp.bPi().Elb;
        ((com.tencent.mm.plugin.card.model.b)localObject1).nYv = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_gift";
        this.nTu.add(localObject1);
      }
    }
    else
    {
      if ((this.nTp.bPj().status != 0) && (this.nTp.bPj().status != 1)) {
        this.nTp.bPj();
      }
      if ((this.fwc != 3) && (this.fwc == 6)) {
        this.nTp.bPj();
      }
      localObject2 = this.nTp.bPi().EkH;
      if (this.nTp.bPj().Eik != null) {
        TextUtils.isEmpty(this.nTp.bPj().Eik.title);
      }
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      if (!this.nTp.bOT()) {
        break label1076;
      }
      i = 0;
      label479:
      ((com.tencent.mm.plugin.card.model.b)localObject1).nUD = false;
      ((com.tencent.mm.plugin.card.model.b)localObject1).nUC = 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getTitle());
      ((StringBuilder)localObject2).append(getString(2131756829));
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = ((StringBuilder)localObject2).toString();
      ((com.tencent.mm.plugin.card.model.b)localObject1).nUs = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).nYv = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_detail";
      if (i != 0) {
        this.nTu.add(localObject1);
      }
      if ((!this.nTp.bOR()) || (this.nTp.bPi().Eku <= 0))
      {
        if ((!this.nTp.bOP()) || (this.nTp.bPi().Eku <= 0))
        {
          if (this.nTp.bPi().Eku <= 0) {
            break label925;
          }
          ac.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.nTp.bPi().Eku);
          if ((this.nTp.bPi().Eku > 0) && (this.nTw != null) && (this.nTw.size() > 0))
          {
            localObject1 = (rr)this.nTw.get(0);
            if ((localObject1 == null) || (((rr)localObject1).yhi >= 50000.0F)) {
              break label1124;
            }
            localObject2 = new com.tencent.mm.plugin.card.model.b();
            ((com.tencent.mm.plugin.card.model.b)localObject2).nUC = 2;
            ((com.tencent.mm.plugin.card.model.b)localObject2).title = ((rr)localObject1).name;
            ((com.tencent.mm.plugin.card.model.b)localObject2).nUs = this.nTt.getString(2131756996, new Object[] { l.f(this.nTt, ((rr)localObject1).yhi), ((rr)localObject1).hEt });
            ((com.tencent.mm.plugin.card.model.b)localObject2).nYv = "";
            ((com.tencent.mm.plugin.card.model.b)localObject2).url = "card://jump_shop";
            ((com.tencent.mm.plugin.card.model.b)localObject2).nUG = ((rr)localObject1).nUG;
            ((com.tencent.mm.plugin.card.model.b)localObject2).hiu = this.nTp.bPi().hiu;
            this.nTu.add(localObject2);
          }
        }
        label826:
        if ((this.nTp.bPi().Eku <= 0) || (this.nTw != null)) {
          break label1170;
        }
        localObject1 = new com.tencent.mm.plugin.card.model.b();
        ((com.tencent.mm.plugin.card.model.b)localObject1).nUC = 1;
        if (TextUtils.isEmpty(this.nTp.bPi().EkS)) {
          break label1156;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.nTp.bPi().EkS;
        ((com.tencent.mm.plugin.card.model.b)localObject1).nUs = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).nYv = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
        this.nTu.add(localObject1);
      }
    }
    label925:
    label1076:
    label1124:
    while ((this.nTp.bPi().Eku <= 0) || (this.nTw == null) || (this.nTw.size() <= 0)) {
      for (;;)
      {
        if (((!this.nTp.bOT()) || (this.nTp.bPj().status != 3)) && (!TextUtils.isEmpty(this.nTp.bPi().Ekn))) {
          this.nTu.add(bPM());
        }
        if (!this.nTp.bOP()) {
          break label1493;
        }
        localObject1 = this.nTu.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.tencent.mm.plugin.card.model.b)((Iterator)localObject1).next()).nUF = true;
        }
        if (this.nTp.bOT())
        {
          ((com.tencent.mm.plugin.card.model.b)localObject1).title = ai.getResources().getString(2131756937);
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = ai.getContext().getString(2131756936);
        break;
        if ((localObject2 != null) && (((acl)localObject2).EuV != null) && (((acl)localObject2).EuV.size() > 0) && (!TextUtils.isEmpty((CharSequence)((acl)localObject2).EuV.get(0))))
        {
          i = 0;
          break label479;
        }
        i = 1;
        break label479;
        if (localObject1 == null) {
          break label826;
        }
        ac.e("MicroMsg.CardDetailDataMgr", "distance:" + ((rr)localObject1).yhi);
        break label826;
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756800);
      }
    }
    label1156:
    label1170:
    Object localObject1 = new com.tencent.mm.plugin.card.model.b();
    ((com.tencent.mm.plugin.card.model.b)localObject1).nUC = 1;
    Object localObject2 = (rr)this.nTw.get(0);
    if (!TextUtils.isEmpty(this.nTp.bPi().EkS))
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.nTp.bPi().EkS;
      label1261:
      if ((!this.nTp.bOP()) || (((rr)localObject2).yhi >= 2000.0F)) {
        break label1484;
      }
      if ((this.nTp.bPi().Eku <= 1) && ((this.nTw == null) || (this.nTw.size() <= 1))) {
        break label1466;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).nUs = this.nTt.getString(2131756932, new Object[] { l.f(this.nTt, ((rr)localObject2).yhi) });
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).nYv = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
      this.nTu.add(localObject1);
      break;
      if ((!this.nTp.bOP()) && (((rr)localObject2).yhi < 5000.0F))
      {
        if ((this.nTp.bPi().Eku == 1) || (this.nTw.size() == 1))
        {
          ac.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756807);
        break label1261;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131756800);
      break label1261;
      label1466:
      ((com.tencent.mm.plugin.card.model.b)localObject1).nUs = l.f(this.nTt, ((rr)localObject2).yhi);
      continue;
      label1484:
      ((com.tencent.mm.plugin.card.model.b)localObject1).nUs = "";
    }
    label1493:
    localObject1 = this.nTu;
    AppMethodBeat.o(112619);
    return localObject1;
  }
  
  public final boolean bPL()
  {
    if (this.nTv == null) {
      return false;
    }
    return this.nTv.dyf;
  }
  
  public final com.tencent.mm.plugin.card.model.b bPM()
  {
    AppMethodBeat.i(112621);
    com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
    localb.nUC = 1;
    localb.nUE = bPK();
    if ((localb.nUE) || (TextUtils.isEmpty(this.nTp.bPi().EkC))) {
      if (w.wG(this.nTp.bPi().Ekn))
      {
        localb.title = getString(2131756935);
        localb.nUE = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.nTp.bPi().EkE)) {
        localb.nUs = this.nTp.bPi().EkE;
      }
      localb.nYv = "";
      localb.url = "card://jump_service";
      this.nTv = localb;
      localb = this.nTv;
      AppMethodBeat.o(112621);
      return localb;
      localb.title = getString(2131756934);
      if ((this.nTp.bPi().EkJ != null) && (this.nTp.bPi().EkJ.EIr == 1))
      {
        localb.dyf = true;
      }
      else
      {
        localb.dyf = false;
        continue;
        localb.title = this.nTp.bPi().EkC;
      }
    }
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(112622);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.nTp.bPi().nVJ)) {
      ((StringBuilder)localObject).append(this.nTp.bPi().nVJ);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(112622);
      return localObject;
      if (this.nTp.bOP()) {
        ((StringBuilder)localObject).append(getString(2131756930));
      } else if (this.nTp.bOQ()) {
        ((StringBuilder)localObject).append(getString(2131756824));
      } else if (this.nTp.bOR()) {
        ((StringBuilder)localObject).append(getString(2131756805));
      } else if (this.nTp.bOS()) {
        ((StringBuilder)localObject).append(getString(2131756834));
      } else if (this.nTp.bOT()) {
        ((StringBuilder)localObject).append(getString(2131756899));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.f
 * JD-Core Version:    0.7.0.1
 */