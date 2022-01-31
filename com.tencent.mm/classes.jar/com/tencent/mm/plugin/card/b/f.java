package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.adv;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  private int ejF;
  private MMActivity jpX;
  public com.tencent.mm.plugin.card.base.b klk;
  public List<com.tencent.mm.plugin.card.model.b> klo;
  public com.tencent.mm.plugin.card.model.b klp;
  private ArrayList<oz> klq;
  
  public f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(87674);
    this.ejF = 3;
    this.klo = new ArrayList();
    this.jpX = paramMMActivity;
    AppMethodBeat.o(87674);
  }
  
  private boolean bbF()
  {
    AppMethodBeat.i(87676);
    if ((l.tt(this.ejF)) || (l.tu(this.ejF)) || (this.ejF == 23))
    {
      if ((this.klk.isAcceptable()) && (this.klk.bbd().wGt != null) && (!TextUtils.isEmpty(this.klk.bbd().wGt.text)) && (!TextUtils.isEmpty(this.klk.bbd().wFW)))
      {
        AppMethodBeat.o(87676);
        return true;
      }
    }
    else if ((this.ejF == 6) && (this.klk.bba()) && (this.klk.bbd().wGt != null) && (!TextUtils.isEmpty(this.klk.bbd().wGt.text)) && (!TextUtils.isEmpty(this.klk.bbd().wFW)))
    {
      AppMethodBeat.o(87676);
      return true;
    }
    AppMethodBeat.o(87676);
    return false;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(87679);
    String str = this.jpX.getString(paramInt);
    AppMethodBeat.o(87679);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, ArrayList<oz> paramArrayList, int paramInt)
  {
    this.klk = paramb;
    this.klq = paramArrayList;
    this.ejF = paramInt;
  }
  
  public final List<com.tencent.mm.plugin.card.model.b> bbE()
  {
    AppMethodBeat.i(87675);
    this.klo.clear();
    if ((this.klk.bbe().wEf != null) && (!bo.isNullOrNil(this.klk.bbe().wEf.title)))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).kmx = 1;
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.klk.bbe().wEf.title;
      ((com.tencent.mm.plugin.card.model.b)localObject1).kqb = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_card_gift";
      ((com.tencent.mm.plugin.card.model.b)localObject1).kWy = this.klk.bbe().wEf.kWy;
      this.klo.add(localObject1);
    }
    if ((this.klk.bbe().wDO != null) && (this.klk.bbe().wDO.size() > 0))
    {
      localObject1 = l.bg(this.klk.bbe().wDO);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.card.model.b)((List)localObject1).get(0)).kmy = false;
        this.klo.addAll((Collection)localObject1);
      }
    }
    int i;
    if (((this.ejF == 6) && (this.klk.bbe().wDS <= 0)) || ((l.tv(this.ejF)) && (this.klk.isNormal()) && (this.klk.baJ()) && (this.klk.baR())))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).kmx = 1;
      if (!bo.isNullOrNil(this.klk.bbd().wGL))
      {
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.klk.bbd().wGL;
        ((com.tencent.mm.plugin.card.model.b)localObject1).kqb = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_gift";
        this.klo.add(localObject1);
      }
    }
    else
    {
      if ((this.klk.bbe().status != 0) && (this.klk.bbe().status != 1)) {
        this.klk.bbe();
      }
      if ((this.ejF != 3) && (this.ejF == 6)) {
        this.klk.bbe();
      }
      localObject2 = this.klk.bbd().wGr;
      if (this.klk.bbe().wDY != null) {
        TextUtils.isEmpty(this.klk.bbe().wDY.title);
      }
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      if (!this.klk.baP()) {
        break label1041;
      }
      i = 0;
      label479:
      ((com.tencent.mm.plugin.card.model.b)localObject1).kmy = false;
      ((com.tencent.mm.plugin.card.model.b)localObject1).kmx = 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getTitle());
      ((StringBuilder)localObject2).append(getString(2131297897));
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = ((StringBuilder)localObject2).toString();
      ((com.tencent.mm.plugin.card.model.b)localObject1).kmn = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).kqb = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_detail";
      if (i != 0) {
        this.klo.add(localObject1);
      }
      if ((!this.klk.baN()) || (this.klk.bbd().wGd <= 0))
      {
        if ((!this.klk.baL()) || (this.klk.bbd().wGd <= 0))
        {
          if (this.klk.bbd().wGd <= 0) {
            break label925;
          }
          ab.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.klk.bbd().wGd);
          if ((this.klk.bbd().wGd > 0) && (this.klq != null) && (this.klq.size() > 0))
          {
            localObject1 = (oz)this.klq.get(0);
            if ((localObject1 == null) || (((oz)localObject1).rqZ >= 50000.0F)) {
              break label1089;
            }
            localObject2 = new com.tencent.mm.plugin.card.model.b();
            ((com.tencent.mm.plugin.card.model.b)localObject2).kmx = 2;
            ((com.tencent.mm.plugin.card.model.b)localObject2).title = ((oz)localObject1).name;
            ((com.tencent.mm.plugin.card.model.b)localObject2).kmn = this.jpX.getString(2131298054, new Object[] { l.g(this.jpX, ((oz)localObject1).rqZ), ((oz)localObject1).fBq });
            ((com.tencent.mm.plugin.card.model.b)localObject2).kqb = "";
            ((com.tencent.mm.plugin.card.model.b)localObject2).url = "card://jump_shop";
            ((com.tencent.mm.plugin.card.model.b)localObject2).kmA = ((oz)localObject1).kmA;
            ((com.tencent.mm.plugin.card.model.b)localObject2).color = this.klk.bbd().color;
            this.klo.add(localObject2);
          }
        }
        label826:
        if ((this.klk.bbd().wGd <= 0) || (this.klq != null)) {
          break label1135;
        }
        localObject1 = new com.tencent.mm.plugin.card.model.b();
        ((com.tencent.mm.plugin.card.model.b)localObject1).kmx = 1;
        if (TextUtils.isEmpty(this.klk.bbd().wGC)) {
          break label1121;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.klk.bbd().wGC;
        ((com.tencent.mm.plugin.card.model.b)localObject1).kmn = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).kqb = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
        this.klo.add(localObject1);
      }
    }
    label925:
    label1089:
    label1121:
    label1135:
    while ((this.klk.bbd().wGd <= 0) || (this.klq == null) || (this.klq.size() <= 0)) {
      for (;;)
      {
        if (((!this.klk.baP()) || (this.klk.bbe().status != 3)) && (!TextUtils.isEmpty(this.klk.bbd().wFW))) {
          this.klo.add(bbH());
        }
        localObject1 = this.klo;
        AppMethodBeat.o(87675);
        return localObject1;
        if (this.klk.baP())
        {
          ((com.tencent.mm.plugin.card.model.b)localObject1).title = ah.getResources().getString(2131297995);
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = ah.getContext().getString(2131297994);
        break;
        if ((localObject2 != null) && (((ye)localObject2).wPk != null) && (((ye)localObject2).wPk.size() > 0) && (!TextUtils.isEmpty((CharSequence)((ye)localObject2).wPk.get(0))))
        {
          i = 0;
          break label479;
        }
        i = 1;
        break label479;
        if (localObject1 == null) {
          break label826;
        }
        ab.e("MicroMsg.CardDetailDataMgr", "distance:" + ((oz)localObject1).rqZ);
        break label826;
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131297868);
      }
    }
    label1041:
    Object localObject1 = new com.tencent.mm.plugin.card.model.b();
    ((com.tencent.mm.plugin.card.model.b)localObject1).kmx = 1;
    Object localObject2 = (oz)this.klq.get(0);
    if (!TextUtils.isEmpty(this.klk.bbd().wGC))
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.klk.bbd().wGC;
      label1226:
      if ((!this.klk.baL()) || (((oz)localObject2).rqZ >= 2000.0F)) {
        break label1449;
      }
      if ((this.klk.bbd().wGd <= 1) && ((this.klq == null) || (this.klq.size() <= 1))) {
        break label1431;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).kmn = this.jpX.getString(2131297990, new Object[] { l.g(this.jpX, ((oz)localObject2).rqZ) });
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).kqb = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
      this.klo.add(localObject1);
      break;
      if ((!this.klk.baL()) && (((oz)localObject2).rqZ < 5000.0F))
      {
        if ((this.klk.bbd().wGd == 1) || (this.klq.size() == 1))
        {
          ab.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131297875);
        break label1226;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(2131297868);
      break label1226;
      label1431:
      ((com.tencent.mm.plugin.card.model.b)localObject1).kmn = l.g(this.jpX, ((oz)localObject2).rqZ);
      continue;
      label1449:
      ((com.tencent.mm.plugin.card.model.b)localObject1).kmn = "";
    }
  }
  
  public final boolean bbG()
  {
    if (this.klp == null) {
      return false;
    }
    return this.klp.cJz;
  }
  
  public final com.tencent.mm.plugin.card.model.b bbH()
  {
    AppMethodBeat.i(87677);
    com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
    localb.kmx = 1;
    localb.kmz = bbF();
    if ((localb.kmz) || (TextUtils.isEmpty(this.klk.bbd().wGm))) {
      if (t.nT(this.klk.bbd().wFW))
      {
        localb.title = getString(2131297993);
        localb.kmz = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.klk.bbd().wGo)) {
        localb.kmn = this.klk.bbd().wGo;
      }
      localb.kqb = "";
      localb.url = "card://jump_service";
      this.klp = localb;
      localb = this.klp;
      AppMethodBeat.o(87677);
      return localb;
      localb.title = getString(2131297992);
      if ((this.klk.bbd().wGt != null) && (this.klk.bbd().wGt.wWN == 1))
      {
        localb.cJz = true;
      }
      else
      {
        localb.cJz = false;
        continue;
        localb.title = this.klk.bbd().wGm;
      }
    }
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(87678);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.klk.bbd().knv)) {
      ((StringBuilder)localObject).append(this.klk.bbd().knv);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(87678);
      return localObject;
      if (this.klk.baL()) {
        ((StringBuilder)localObject).append(getString(2131297988));
      } else if (this.klk.baM()) {
        ((StringBuilder)localObject).append(getString(2131297892));
      } else if (this.klk.baN()) {
        ((StringBuilder)localObject).append(getString(2131297873));
      } else if (this.klk.baO()) {
        ((StringBuilder)localObject).append(getString(2131297902));
      } else if (this.klk.baP()) {
        ((StringBuilder)localObject).append(getString(2131297957));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.f
 * JD-Core Version:    0.7.0.1
 */