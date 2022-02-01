package com.tencent.mm.plugin.card.mgr;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private int lCR;
  public com.tencent.mm.plugin.card.model.b wrA;
  private ArrayList<wl> wrB;
  public com.tencent.mm.plugin.card.base.b wru;
  private MMActivity wry;
  public List<com.tencent.mm.plugin.card.model.b> wrz;
  
  public e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(112618);
    this.lCR = 3;
    this.wrz = new ArrayList();
    this.wry = paramMMActivity;
    AppMethodBeat.o(112618);
  }
  
  private boolean dkl()
  {
    AppMethodBeat.i(112620);
    if ((l.IL(this.lCR)) || (l.IM(this.lCR)) || (this.lCR == 23))
    {
      if ((this.wru.djG()) && (this.wru.djK().Zed != null) && (!TextUtils.isEmpty(this.wru.djK().Zed.text)) && (!TextUtils.isEmpty(this.wru.djK().YYZ)))
      {
        AppMethodBeat.o(112620);
        return true;
      }
    }
    else if ((this.lCR == 6) && (this.wru.djH()) && (this.wru.djK().Zed != null) && (!TextUtils.isEmpty(this.wru.djK().Zed.text)) && (!TextUtils.isEmpty(this.wru.djK().YYZ)))
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
    String str = this.wry.getString(paramInt);
    AppMethodBeat.o(112623);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, ArrayList<wl> paramArrayList, int paramInt)
  {
    this.wru = paramb;
    this.wrB = paramArrayList;
    this.lCR = paramInt;
  }
  
  public final List<com.tencent.mm.plugin.card.model.b> dkk()
  {
    AppMethodBeat.i(112619);
    this.wrz.clear();
    if ((this.wru.djL().ZbK != null) && (!Util.isNullOrNil(this.wru.djL().ZbK.title)))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).wsI = 1;
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.wru.djL().ZbK.title;
      ((com.tencent.mm.plugin.card.model.b)localObject1).lym = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_card_gift";
      ((com.tencent.mm.plugin.card.model.b)localObject1).icon_url = this.wru.djL().ZbK.icon_url;
      this.wrz.add(localObject1);
    }
    if ((this.wru.djL().Zbt != null) && (this.wru.djL().Zbt.size() > 0))
    {
      localObject1 = l.eP(this.wru.djL().Zbt);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.card.model.b)((List)localObject1).get(0)).wsJ = false;
        this.wrz.addAll((Collection)localObject1);
      }
    }
    int i;
    if (((this.lCR == 6) && (this.wru.djL().Zbx <= 0)) || ((l.IN(this.lCR)) && (this.wru.djF()) && (this.wru.djo()) && (this.wru.djw())))
    {
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      ((com.tencent.mm.plugin.card.model.b)localObject1).wsI = 1;
      if (!Util.isNullOrNil(this.wru.djK().Zeu))
      {
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.wru.djK().Zeu;
        ((com.tencent.mm.plugin.card.model.b)localObject1).lym = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_gift";
        this.wrz.add(localObject1);
      }
    }
    else
    {
      if ((this.wru.djL().status != 0) && (this.wru.djL().status != 1)) {
        this.wru.djL();
      }
      if ((this.lCR != 3) && (this.lCR == 6)) {
        this.wru.djL();
      }
      localObject2 = this.wru.djK().Zeb;
      if (this.wru.djL().ZbD != null) {
        TextUtils.isEmpty(this.wru.djL().ZbD.title);
      }
      localObject1 = new com.tencent.mm.plugin.card.model.b();
      if (!this.wru.dju()) {
        break label1077;
      }
      i = 0;
      label479:
      ((com.tencent.mm.plugin.card.model.b)localObject1).wsJ = false;
      ((com.tencent.mm.plugin.card.model.b)localObject1).wsI = 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getTitle());
      ((StringBuilder)localObject2).append(getString(a.g.woy));
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = ((StringBuilder)localObject2).toString();
      ((com.tencent.mm.plugin.card.model.b)localObject1).wsz = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).lym = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_detail";
      if (i != 0) {
        this.wrz.add(localObject1);
      }
      if ((!this.wru.djs()) || (this.wru.djK().ZdO <= 0))
      {
        if ((!this.wru.djq()) || (this.wru.djK().ZdO <= 0))
        {
          if (this.wru.djK().ZdO <= 0) {
            break label926;
          }
          Log.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.wru.djK().ZdO);
          if ((this.wru.djK().ZdO > 0) && (this.wrB != null) && (this.wrB.size() > 0))
          {
            localObject1 = (wl)this.wrB.get(0);
            if ((localObject1 == null) || (((wl)localObject1).TG >= 50000.0F)) {
              break label1134;
            }
            localObject2 = new com.tencent.mm.plugin.card.model.b();
            ((com.tencent.mm.plugin.card.model.b)localObject2).wsI = 2;
            ((com.tencent.mm.plugin.card.model.b)localObject2).title = ((wl)localObject1).name;
            ((com.tencent.mm.plugin.card.model.b)localObject2).wsz = this.wry.getString(a.g.wqk, new Object[] { l.f(this.wry, ((wl)localObject1).TG), ((wl)localObject1).oDI });
            ((com.tencent.mm.plugin.card.model.b)localObject2).lym = "";
            ((com.tencent.mm.plugin.card.model.b)localObject2).url = "card://jump_shop";
            ((com.tencent.mm.plugin.card.model.b)localObject2).wsM = ((wl)localObject1).wsM;
            ((com.tencent.mm.plugin.card.model.b)localObject2).nRQ = this.wru.djK().nRQ;
            this.wrz.add(localObject2);
          }
        }
        label827:
        if ((this.wru.djK().ZdO <= 0) || (this.wrB != null)) {
          break label1180;
        }
        localObject1 = new com.tencent.mm.plugin.card.model.b();
        ((com.tencent.mm.plugin.card.model.b)localObject1).wsI = 1;
        if (TextUtils.isEmpty(this.wru.djK().Zem)) {
          break label1166;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.wru.djK().Zem;
        ((com.tencent.mm.plugin.card.model.b)localObject1).wsz = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).lym = "";
        ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
        this.wrz.add(localObject1);
      }
    }
    label926:
    label1077:
    label1134:
    while ((this.wru.djK().ZdO <= 0) || (this.wrB == null) || (this.wrB.size() <= 0)) {
      for (;;)
      {
        if (((!this.wru.dju()) || (this.wru.djL().status != 3)) && (!TextUtils.isEmpty(this.wru.djK().YYZ))) {
          this.wrz.add(dkn());
        }
        if (!this.wru.djq()) {
          break label1503;
        }
        localObject1 = this.wrz.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((com.tencent.mm.plugin.card.model.b)((Iterator)localObject1).next()).wsL = true;
        }
        if (this.wru.dju())
        {
          ((com.tencent.mm.plugin.card.model.b)localObject1).title = MMApplicationContext.getResources().getString(a.g.wpC);
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = MMApplicationContext.getContext().getString(a.g.wpB);
        break;
        if ((localObject2 != null) && (((akb)localObject2).Zrh != null) && (((akb)localObject2).Zrh.size() > 0) && (!TextUtils.isEmpty((CharSequence)((akb)localObject2).Zrh.get(0))))
        {
          i = 0;
          break label479;
        }
        if (localObject2 == null)
        {
          i = 0;
          break label479;
        }
        i = 1;
        break label479;
        if (localObject1 == null) {
          break label827;
        }
        Log.e("MicroMsg.CardDetailDataMgr", "distance:" + ((wl)localObject1).TG);
        break label827;
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(a.g.woe);
      }
    }
    label1166:
    label1180:
    Object localObject1 = new com.tencent.mm.plugin.card.model.b();
    ((com.tencent.mm.plugin.card.model.b)localObject1).wsI = 1;
    Object localObject2 = (wl)this.wrB.get(0);
    if (!TextUtils.isEmpty(this.wru.djK().Zem))
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = this.wru.djK().Zem;
      label1271:
      if ((!this.wru.djq()) || (((wl)localObject2).TG >= 2000.0F)) {
        break label1494;
      }
      if ((this.wru.djK().ZdO <= 1) && ((this.wrB == null) || (this.wrB.size() <= 1))) {
        break label1476;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).wsz = this.wry.getString(a.g.wpx, new Object[] { l.f(this.wry, ((wl)localObject2).TG) });
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.model.b)localObject1).lym = "";
      ((com.tencent.mm.plugin.card.model.b)localObject1).url = "card://jump_shop_list";
      this.wrz.add(localObject1);
      break;
      if ((!this.wru.djq()) && (((wl)localObject2).TG < 5000.0F))
      {
        if ((this.wru.djK().ZdO == 1) || (this.wrB.size() == 1))
        {
          Log.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
          break;
        }
        ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(a.g.woj);
        break label1271;
      }
      ((com.tencent.mm.plugin.card.model.b)localObject1).title = getString(a.g.woe);
      break label1271;
      label1476:
      ((com.tencent.mm.plugin.card.model.b)localObject1).wsz = l.f(this.wry, ((wl)localObject2).TG);
      continue;
      label1494:
      ((com.tencent.mm.plugin.card.model.b)localObject1).wsz = "";
    }
    label1503:
    localObject1 = this.wrz;
    AppMethodBeat.o(112619);
    return localObject1;
  }
  
  public final boolean dkm()
  {
    if (this.wrA == null) {
      return false;
    }
    return this.wrA.idG;
  }
  
  public final com.tencent.mm.plugin.card.model.b dkn()
  {
    AppMethodBeat.i(112621);
    com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
    localb.wsI = 1;
    localb.wsK = dkl();
    if ((localb.wsK) || (TextUtils.isEmpty(this.wru.djK().ZdW))) {
      if (ab.IR(this.wru.djK().YYZ))
      {
        localb.title = getString(a.g.wpA);
        localb.wsK = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.wru.djK().ZdY)) {
        localb.wsz = this.wru.djK().ZdY;
      }
      localb.lym = "";
      localb.url = "card://jump_service";
      this.wrA = localb;
      localb = this.wrA;
      AppMethodBeat.o(112621);
      return localb;
      localb.title = getString(a.g.wpz);
      if ((this.wru.djK().Zed != null) && (this.wru.djK().Zed.aaiP == 1))
      {
        localb.idG = true;
      }
      else
      {
        localb.idG = false;
        continue;
        localb.title = this.wru.djK().ZdW;
      }
    }
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(112622);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(this.wru.djK().wtN)) {
      ((StringBuilder)localObject).append(this.wru.djK().wtN);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(112622);
      return localObject;
      if (this.wru.djq()) {
        ((StringBuilder)localObject).append(getString(a.g.wnq));
      } else if (this.wru.djr()) {
        ((StringBuilder)localObject).append(getString(a.g.wou));
      } else if (this.wru.djs()) {
        ((StringBuilder)localObject).append(getString(a.g.woh));
      } else if (this.wru.djt()) {
        ((StringBuilder)localObject).append(getString(a.g.woB));
      } else if (this.wru.dju()) {
        ((StringBuilder)localObject).append(getString(a.g.wng));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.e
 * JD-Core Version:    0.7.0.1
 */