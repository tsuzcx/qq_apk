package com.tencent.mm.plugin.card.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.g.c;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.bcg;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bgy;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements f
{
  public List<WeakReference<g.a>> fKm = new ArrayList();
  public com.tencent.mm.plugin.card.d.c ikr;
  public int iks;
  public com.tencent.mm.sdk.platformtools.am ikt = new com.tencent.mm.sdk.platformtools.am(new g.1(this), false);
  
  private void I(LinkedList<bcg> paramLinkedList)
  {
    com.tencent.mm.kernel.g.DO().dJT.a(1275, this);
    paramLinkedList = new ah(paramLinkedList);
    com.tencent.mm.kernel.g.DO().dJT.a(paramLinkedList, 0);
  }
  
  private void a(com.tencent.mm.plugin.card.d.c paramc)
  {
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (g.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((g.a)localObject).c(paramc);
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(bgy parambgy)
  {
    if (parambgy == null) {
      return;
    }
    String str = parambgy.bZc;
    Object localObject;
    if (com.tencent.mm.plugin.card.model.am.aAH().yj(str) == null)
    {
      localObject = b(parambgy);
      com.tencent.mm.plugin.card.model.am.aAH().b((com.tencent.mm.sdk.e.c)localObject);
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.card.model.am.aAG().yk(str);
      if ((!((List)localObject).isEmpty()) && (com.tencent.mm.plugin.card.model.am.aAG().jJ(str)) && (this.ikr != null)) {
        a(str, (List)localObject, this.ikr);
      }
      parambgy = parambgy.tBF.iterator();
      while (parambgy.hasNext())
      {
        localObject = (bgx)parambgy.next();
        k localk = new k();
        localk.field_card_id = str;
        localk.field_code_id = ((bgx)localObject).inb;
        localk.field_code = e.cz(str, ((bgx)localObject).data);
        com.tencent.mm.plugin.card.model.am.aAG().b(localk);
      }
      break;
      localObject = b(parambgy);
      com.tencent.mm.plugin.card.model.am.aAH().c((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    }
  }
  
  private void a(String paramString, q paramq)
  {
    Object localObject = new StringBuilder("doNetSceneGetDynamicQrcode, cardId:").append(paramString).append(",scene :");
    if (paramq == null)
    {
      i = 0;
      y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", i);
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramString);
      if (paramq != null) {
        break label107;
      }
    }
    label107:
    for (int i = 0;; i = paramq.scene)
    {
      paramString = new com.tencent.mm.plugin.card.model.ae((LinkedList)localObject, i);
      com.tencent.mm.kernel.g.DO().dJT.a(1382, this);
      com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
      return;
      i = paramq.scene;
      break;
    }
  }
  
  private void a(String paramString, List<k> paramList, com.tencent.mm.plugin.card.d.c paramc)
  {
    if (paramc == null)
    {
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList.add(b(paramString, ((k)paramList.next()).field_code_id, paramc));
    }
    I(localLinkedList);
  }
  
  public static boolean a(i parami)
  {
    if (System.currentTimeMillis() - parami.field_fetch_time > parami.field_expire_time_interval * 1000)
    {
      y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(parami.field_fetch_time), Integer.valueOf(parami.field_expire_time_interval) });
      return true;
    }
    return false;
  }
  
  private static i b(bgy parambgy)
  {
    i locali = new i();
    locali.field_card_id = parambgy.bZc;
    locali.field_lower_bound = parambgy.tBA;
    locali.field_expire_time_interval = parambgy.tBD;
    locali.field_need_insert_show_timestamp = parambgy.tBB;
    locali.field_show_expire_interval = parambgy.tBE;
    locali.field_show_timestamp_encrypt_key = parambgy.tBC;
    locali.field_fetch_time = System.currentTimeMillis();
    return locali;
  }
  
  private static bcg b(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    bcg localbcg = new bcg();
    localbcg.bZc = paramString1;
    localbcg.inb = paramString2;
    localbcg.txJ = new Long(System.currentTimeMillis() / 1000L).intValue();
    if (paramc == null) {}
    for (int i = -1;; i = paramc.action)
    {
      localbcg.txK = i;
      return localbcg;
    }
  }
  
  private void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (g.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((g.a)localObject).b(paramc);
          }
        }
        i += 1;
      }
    }
  }
  
  private static boolean e(com.tencent.mm.plugin.card.base.b paramb)
  {
    if (paramb == null) {
      return false;
    }
    if ((paramb.azy() != null) && (paramb.azy().sHM)) {
      return true;
    }
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
    return false;
  }
  
  public final void U(int paramInt, String paramString)
  {
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (g.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((g.a)localObject).V(paramInt, paramString);
          }
        }
        i += 1;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, q paramq)
  {
    if (!e(paramb))
    {
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
      U(2, "");
      return;
    }
    if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(com.tencent.mm.sdk.platformtools.ae.getContext()))
    {
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
      U(-1, "");
      return;
    }
    if (this.iks >= 3)
    {
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.iks + ",cannot request!");
      return;
    }
    a(paramb.azB(), paramq);
    this.iks += 1;
  }
  
  public final void a(q paramq)
  {
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[] { Integer.valueOf(paramq.scene) });
    Object localObject1 = com.tencent.mm.plugin.card.model.am.aAs().aAh();
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", new Object[] { Integer.valueOf(paramq.scene) });
    }
    for (;;)
    {
      return;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        CardInfo localCardInfo = (CardInfo)((Iterator)localObject1).next();
        if (localCardInfo == null)
        {
          y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", new Object[] { Integer.valueOf(paramq.scene) });
        }
        else if (paramq == null)
        {
          y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
        }
        else
        {
          y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[] { localCardInfo.azB(), Integer.valueOf(paramq.scene) });
          if (!e(localCardInfo))
          {
            y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[] { localCardInfo.azB() });
          }
          else
          {
            Object localObject2 = localCardInfo.azB();
            i locali = com.tencent.mm.plugin.card.model.am.aAH().yj((String)localObject2);
            int i;
            if (locali == null) {
              i = 1;
            }
            for (;;)
            {
              if (i != 0) {
                break label344;
              }
              y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[] { localCardInfo.azB(), Integer.valueOf(paramq.scene) });
              break;
              localObject2 = com.tencent.mm.plugin.card.model.am.aAG().yk((String)localObject2);
              if (((List)localObject2).isEmpty())
              {
                i = 1;
              }
              else if (((List)localObject2).size() < locali.field_lower_bound)
              {
                this.ikr = com.tencent.mm.plugin.card.d.c.iyX;
                i = 1;
              }
              else if (a(locali))
              {
                this.ikr = com.tencent.mm.plugin.card.d.c.iyR;
                i = 1;
              }
              else
              {
                i = 0;
              }
            }
            label344:
            y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[] { Integer.valueOf(paramq.scene) });
            a(localCardInfo.azB(), paramq);
          }
        }
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(b(paramString1, paramString2, paramc));
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(paramc.action) });
    I(localLinkedList);
  }
  
  public final void azO()
  {
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
    if (!this.ikt.crl()) {
      this.ikt.stopTimer();
    }
  }
  
  public final void b(com.tencent.mm.plugin.card.model.g paramg)
  {
    String str = paramg.field_card_id;
    Object localObject1 = com.tencent.mm.plugin.card.model.am.aAG();
    Object localObject2;
    if (paramg.imT)
    {
      paramg = com.tencent.mm.plugin.card.model.am.aAG().yk(str);
      localObject2 = ((com.tencent.mm.plugin.card.model.l)localObject1).ym(str);
      y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[] { str });
      if (((com.tencent.mm.plugin.card.model.l)localObject1).jJ(str))
      {
        if (localObject2 != null)
        {
          y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[] { str });
          b(com.tencent.mm.plugin.card.d.c.iyW);
        }
        a(str, paramg, com.tencent.mm.plugin.card.d.c.iyW);
      }
    }
    do
    {
      return;
      localObject2 = paramg.imU;
      if (localObject2 == null)
      {
        y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[] { str });
        return;
      }
      y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[] { str, Integer.valueOf(((List)localObject2).size()) });
      paramg = ((com.tencent.mm.plugin.card.model.l)localObject1).ym(str);
      localObject1 = new LinkedList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        g.c localc = (g.c)((Iterator)localObject2).next();
        if (com.tencent.mm.plugin.card.model.am.aAG().cs(str, localc.inb)) {
          ((LinkedList)localObject1).add(b(str, localc.inb, com.tencent.mm.plugin.card.d.c.iyW));
        }
      }
      if (paramg != null)
      {
        y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[] { str, paramg.field_code_id });
        b(com.tencent.mm.plugin.card.d.c.iyW);
      }
    } while (((LinkedList)localObject1).isEmpty());
    I((LinkedList)localObject1);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(",NetSceneBase=");
    if (paramm != null) {}
    for (Object localObject = paramm.getClass();; localObject = "")
    {
      y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label146;
      }
      if (!(paramm instanceof com.tencent.mm.plugin.card.model.ae)) {
        break label132;
      }
      paramString = ((com.tencent.mm.plugin.card.model.ae)paramm).inI;
      if (paramString != null) {
        break;
      }
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
      return;
    }
    a(paramString);
    a(this.ikr);
    com.tencent.mm.kernel.g.DO().dJT.b(1382, this);
    return;
    label132:
    com.tencent.mm.kernel.g.DO().dJT.b(1275, this);
    return;
    label146:
    localObject = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(" cmd:");
    if (paramm != null)
    {
      paramInt1 = paramm.getType();
      localStringBuilder = ((StringBuilder)localObject).append(paramInt1).append("  NetSceneBase=");
      if (paramm == null) {
        break label263;
      }
    }
    label263:
    for (localObject = paramm.getClass();; localObject = "")
    {
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if (!(paramm instanceof com.tencent.mm.plugin.card.model.ae)) {
        break label271;
      }
      U(paramInt2, paramString);
      com.tencent.mm.kernel.g.DO().dJT.b(1382, this);
      return;
      paramInt1 = 0;
      break;
    }
    label271:
    com.tencent.mm.kernel.g.DO().dJT.b(1275, this);
  }
  
  public final void release()
  {
    this.iks = 0;
    azO();
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
    com.tencent.mm.kernel.g.DO().dJT.b(1382, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1275, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g
 * JD-Core Version:    0.7.0.1
 */