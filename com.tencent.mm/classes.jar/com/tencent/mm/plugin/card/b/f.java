package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.vb;
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
  private int jaR;
  public com.tencent.mm.plugin.card.base.b tmU;
  private MMActivity tmY;
  public List<com.tencent.mm.plugin.card.model.b> tmZ;
  public com.tencent.mm.plugin.card.model.b tna;
  private ArrayList<uu> tnb;
  
  public f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(112618);
    this.jaR = 3;
    this.tmZ = new ArrayList();
    this.tmY = paramMMActivity;
    AppMethodBeat.o(112618);
  }
  
  private boolean cGU()
  {
    AppMethodBeat.i(112620);
    if ((l.Ii(this.jaR)) || (l.Ij(this.jaR)) || (this.jaR == 23))
    {
      if ((this.tmU.cGo()) && (this.tmU.cGs().Sgi != null) && (!TextUtils.isEmpty(this.tmU.cGs().Sgi.text)) && (!TextUtils.isEmpty(this.tmU.cGs().Sba)))
      {
        AppMethodBeat.o(112620);
        return true;
      }
    }
    else if ((this.jaR == 6) && (this.tmU.cGp()) && (this.tmU.cGs().Sgi != null) && (!TextUtils.isEmpty(this.tmU.cGs().Sgi.text)) && (!TextUtils.isEmpty(this.tmU.cGs().Sba)))
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
    String str = this.tmY.getString(paramInt);
    AppMethodBeat.o(112623);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, ArrayList<uu> paramArrayList, int paramInt)
  {
    this.tmU = paramb;
    this.tnb = paramArrayList;
    this.jaR = paramInt;
  }
  
  public final List<com.tencent.mm.plugin.card.model.b> cGT()
  {
    AppMethodBeat.i(112619);
    this.tmZ.clear();
    if ((this.tmU.cGt().SdQ != null) && (!Util.isNullOrNil(this.tmU.cGt().SdQ.title)))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).toh = 1;
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.tmU.cGt().SdQ.title;
      ((com.tencent.mm.plugin.card.model.b)localObject1).tsf = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_card_gift";
      ((com.tencent.mm.plugin.card.model.b)localObject1).ufC = this.tmU.cGt().SdQ.ufC;
      this.tmZ.add(localObject1);
    }
    if ((this.tmU.cGt().Sdz != null) && (this.tmU.cGt().Sdz.size() > 0))
    {
      localObject1 = l.cU(this.tmU.cGt().Sdz);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.card.model.b)((List)localObject1).get(0)).toi = false;
        this.tmZ.addAll((Collection)localObject1);
      }
    }
    int i;
    if (((this.jaR == 6) && (this.tmU.cGt().SdD <= 0)) || ((l.Ik(this.jaR)) && (this.tmU.cGn()) && (this.tmU.cFW()) && (this.tmU.cGe())))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).toh = 1;
      if (!Util.isNullOrNil(this.tmU.cGs().Sgz))
      {
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.tmU.cGs().Sgz;
        ((com.tencent.mm.plugin.card.model.b)localObject1).tsf = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_gift";
        this.tmZ.add(localObject1);
      }
    }
    else
    {
      if ((this.tmU.cGt().status != 0) && (this.tmU.cGt().status != 1)) {
        this.tmU.cGt();
      }
      if ((this.jaR != 3) && (this.jaR == 6)) {
        this.tmU.cGt();
      }
      localObject2 = this.tmU.cGs().Sgg;
      if (this.tmU.cGt().SdJ != null) {
        TextUtils.isEmpty(this.tmU.cGt().SdJ.title);
      }
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      if (!this.tmU.cGc()) {
        break label1077;
      }
      i = 0;
      label479:
      ((com.tencent.mm.plugin.card.model.b)localObject1).toi = false;
      ((com.tencent.mm.plugin.card.model.b)localObject1).toh = 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getTitle());
      ((StringBuilder)localObject2).append(getString(a.g.tka));
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = ((StringBuilder)localObject2).toString();
      ((com.tencent.mm.plugin.card.model.b)localObject1).tnY = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).tsf = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_detail";
      if (i != 0) {
        this.tmZ.add(localObject1);
      }
      if ((!this.tmU.cGa()) || (this.tmU.cGs().SfT <= 0))
      {
        if ((!this.tmU.cFY()) || (this.tmU.cGs().SfT <= 0))
        {
          if (this.tmU.cGs().SfT <= 0) {
            break label926;
          }
          Log.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.tmU.cGs().SfT);
          if ((this.tmU.cGs().SfT > 0) && (this.tnb != null) && (this.tnb.size() > 0))
          {
            localObject1 = (uu)this.tnb.get(0);
            if ((localObject1 == null) || (((uu)localObject1).KjR >= 50000.0F)) {
              break label1125;
            }
            localObject2 = new com.tencent.mm.plugin.card.model.b();
            ((com.tencent.mm.plugin.card.model.b)localObject2).toh = 2;
            ((com.tencent.mm.plugin.card.model.b)localObject2).title = ((uu)localObject1).name;
            ((com.tencent.mm.plugin.card.model.b)localObject2).tnY = this.tmY.getString(a.g.tlL, new Object[] { l.f(this.tmY, ((uu)localObject1).KjR), ((uu)localObject1).lLg });
            ((com.tencent.mm.plugin.card.model.b)localObject2).tsf = "";
            ((com.tencent.mm.plugin.card.model.b)localObject2).url = "card://jump_shop";
            ((com.tencent.mm.plugin.card.model.b)localObject2).tol = ((uu)localObject1).tol;
            ((com.tencent.mm.plugin.card.model.b)localObject2).lmL = this.tmU.cGs().lmL;
            this.tmZ.add(localObject2);
          }
        }
        label827:
        if ((this.tmU.cGs().SfT <= 0) || (this.tnb != null)) {
          break label1171;
        }
        localObject1 = new com.tencent.mm.plugin.card.model.b();
        ((com.tencent.mm.plugin.card.model.b)localObject1).toh = 1;
        if (TextUtils.isEmpty(this.tmU.cGs().Sgr)) {
          break label1157;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.tmU.cGs().Sgr;
        ((com.tencent.mm.plugin.card.model.b)localObject1).tnY = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).tsf = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
        this.tmZ.add(localObject1);
      }
    }
    label926:
    label1077:
    label1125:
    while ((this.tmU.cGs().SfT <= 0) || (this.tnb == null) || (this.tnb.size() <= 0)) {
      for (;;)
      {
        if (((!this.tmU.cGc()) || (this.tmU.cGt().status != 3)) && (!TextUtils.isEmpty(this.tmU.cGs().Sba))) {
          this.tmZ.add(cGW());
        }
        if (!this.tmU.cFY()) {
          break label1494;
        }
        localObject1 = this.tmZ.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.tencent.mm.plugin.card.model.b)((Iterator)localObject1).next()).tok = true;
        }
        if (this.tmU.cGc())
        {
          ((com.tencent.mm.plugin.card.model.b)localObject1).title = MMApplicationContext.getResources().getString(a.g.tld);
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = MMApplicationContext.getContext().getString(a.g.tlc);
        break;
        if ((localObject2 != null) && (((ahk)localObject2).SrZ != null) && (((ahk)localObject2).SrZ.size() > 0) && (!TextUtils.isEmpty((CharSequence)((ahk)localObject2).SrZ.get(0))))
        {
          i = 0;
          break label479;
        }
        i = 1;
        break label479;
        if (localObject1 == null) {
          break label827;
        }
        Log.e("MicroMsg.CardDetailDataMgr", "distance:" + ((uu)localObject1).KjR);
        break label827;
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(a.g.tjH);
      }
    }
    label1157:
    label1171:
    Object localObject1 = new com.tencent.mm.plugin.card.model.b();
    ((com.tencent.mm.plugin.card.model.b)localObject1).toh = 1;
    Object localObject2 = (uu)this.tnb.get(0);
    if (!TextUtils.isEmpty(this.tmU.cGs().Sgr))
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.tmU.cGs().Sgr;
      label1262:
      if ((!this.tmU.cFY()) || (((uu)localObject2).KjR >= 2000.0F)) {
        break label1485;
      }
      if ((this.tmU.cGs().SfT <= 1) && ((this.tnb == null) || (this.tnb.size() <= 1))) {
        break label1467;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).tnY = this.tmY.getString(a.g.tkY, new Object[] { l.f(this.tmY, ((uu)localObject2).KjR) });
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).tsf = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
      this.tmZ.add(localObject1);
      break;
      if ((!this.tmU.cFY()) && (((uu)localObject2).KjR < 5000.0F))
      {
        if ((this.tmU.cGs().SfT == 1) || (this.tnb.size() == 1))
        {
          Log.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(a.g.tjM);
        break label1262;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(a.g.tjH);
      break label1262;
      label1467:
      ((com.tencent.mm.plugin.card.model.b)localObject1).tnY = l.f(this.tmY, ((uu)localObject2).KjR);
      continue;
      label1485:
      ((com.tencent.mm.plugin.card.model.b)localObject1).tnY = "";
    }
    label1494:
    localObject1 = this.tmZ;
    AppMethodBeat.o(112619);
    return localObject1;
  }
  
  public final boolean cGV()
  {
    if (this.tna == null) {
      return false;
    }
    return this.tna.fXF;
  }
  
  public final com.tencent.mm.plugin.card.model.b cGW()
  {
    AppMethodBeat.i(112621);
    com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
    localb.toh = 1;
    localb.toj = cGU();
    if ((localb.toj) || (TextUtils.isEmpty(this.tmU.cGs().Sgb))) {
      if (ab.Ql(this.tmU.cGs().Sba))
      {
        localb.title = getString(a.g.tlb);
        localb.toj = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.tmU.cGs().Sgd)) {
        localb.tnY = this.tmU.cGs().Sgd;
      }
      localb.tsf = "";
      localb.url = "card://jump_service";
      this.tna = localb;
      localb = this.tna;
      AppMethodBeat.o(112621);
      return localb;
      localb.title = getString(a.g.tla);
      if ((this.tmU.cGs().Sgi != null) && (this.tmU.cGs().Sgi.SWY == 1))
      {
        localb.fXF = true;
      }
      else
      {
        localb.fXF = false;
        continue;
        localb.title = this.tmU.cGs().Sgb;
      }
    }
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(112622);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.tmU.cGs().tpo)) {
      ((StringBuilder)localObject).append(this.tmU.cGs().tpo);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(112622);
      return localObject;
      if (this.tmU.cFY()) {
        ((StringBuilder)localObject).append(getString(a.g.tiT));
      } else if (this.tmU.cFZ()) {
        ((StringBuilder)localObject).append(getString(a.g.thV));
      } else if (this.tmU.cGa()) {
        ((StringBuilder)localObject).append(getString(a.g.tjK));
      } else if (this.tmU.cGb()) {
        ((StringBuilder)localObject).append(getString(a.g.tkd));
      } else if (this.tmU.cGc()) {
        ((StringBuilder)localObject).append(getString(a.g.tiJ));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.f
 * JD-Core Version:    0.7.0.1
 */