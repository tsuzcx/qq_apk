package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g.c;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements f
{
  public int giC;
  public com.tencent.mm.plugin.card.d.c owS;
  public av owT;
  public List<WeakReference<a>> owv;
  
  public g()
  {
    AppMethodBeat.i(112625);
    this.owv = new ArrayList();
    this.owT = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112624);
        ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
        g localg = g.this;
        ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
        if (localg.owv != null)
        {
          int i = 0;
          while (i < localg.owv.size())
          {
            Object localObject = (WeakReference)localg.owv.get(i);
            if (localObject != null)
            {
              localObject = (g.a)((WeakReference)localObject).get();
              if (localObject != null) {
                ((g.a)localObject).bUs();
              }
            }
            i += 1;
          }
        }
        AppMethodBeat.o(112624);
        return true;
      }
    }, false);
    AppMethodBeat.o(112625);
  }
  
  private void O(LinkedList<cgg> paramLinkedList)
  {
    AppMethodBeat.i(112636);
    com.tencent.mm.kernel.g.ajB().gAO.a(1275, this);
    paramLinkedList = new ah(paramLinkedList);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramLinkedList, 0);
    AppMethodBeat.o(112636);
  }
  
  private void a(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112642);
    ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112642);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      Object localObject = (WeakReference)this.owv.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).c(paramc);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112642);
  }
  
  private void a(coc paramcoc)
  {
    AppMethodBeat.i(112638);
    if (paramcoc == null)
    {
      AppMethodBeat.o(112638);
      return;
    }
    String str = paramcoc.dHX;
    Object localObject;
    if (am.bVc().Yp(str) == null)
    {
      localObject = b(paramcoc);
      am.bVc().insert((com.tencent.mm.sdk.e.c)localObject);
    }
    for (;;)
    {
      localObject = am.bVb().Yq(str);
      if ((!((List)localObject).isEmpty()) && (am.bVb().CA(str)) && (this.owS != null)) {
        a(str, (List)localObject, this.owS);
      }
      paramcoc = paramcoc.Hhf.iterator();
      while (paramcoc.hasNext())
      {
        localObject = (cob)paramcoc.next();
        k localk = new k();
        localk.field_card_id = str;
        localk.field_code_id = ((cob)localObject).ozE;
        localk.field_code = e.fd(str, ((cob)localObject).data);
        am.bVb().insert(localk);
      }
      localObject = b(paramcoc);
      am.bVc().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    }
    AppMethodBeat.o(112638);
  }
  
  private void a(String paramString, r paramr)
  {
    AppMethodBeat.i(112633);
    Object localObject = new StringBuilder("doNetSceneGetDynamicQrcode, cardId:").append(paramString).append(",scene :");
    if (paramr == null)
    {
      i = 0;
      ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", i);
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramString);
      if (paramr != null) {
        break label117;
      }
    }
    label117:
    for (int i = 0;; i = paramr.scene)
    {
      paramString = new ae((LinkedList)localObject, i);
      com.tencent.mm.kernel.g.ajB().gAO.a(1382, this);
      com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
      AppMethodBeat.o(112633);
      return;
      i = paramr.scene;
      break;
    }
  }
  
  private void a(String paramString, List<k> paramList, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112634);
    if (paramc == null)
    {
      ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
      AppMethodBeat.o(112634);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList.add(b(paramString, ((k)paramList.next()).field_code_id, paramc));
    }
    O(localLinkedList);
    AppMethodBeat.o(112634);
  }
  
  public static boolean a(i parami)
  {
    AppMethodBeat.i(112630);
    if (System.currentTimeMillis() - parami.field_fetch_time > parami.field_expire_time_interval * 1000)
    {
      ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(parami.field_fetch_time), Integer.valueOf(parami.field_expire_time_interval) });
      AppMethodBeat.o(112630);
      return true;
    }
    AppMethodBeat.o(112630);
    return false;
  }
  
  private static i b(coc paramcoc)
  {
    AppMethodBeat.i(112639);
    i locali = new i();
    locali.field_card_id = paramcoc.dHX;
    locali.field_lower_bound = paramcoc.Hha;
    locali.field_expire_time_interval = paramcoc.Hhd;
    locali.field_need_insert_show_timestamp = paramcoc.Hhb;
    locali.field_show_expire_interval = paramcoc.Hhe;
    locali.field_show_timestamp_encrypt_key = paramcoc.Hhc;
    locali.field_fetch_time = System.currentTimeMillis();
    AppMethodBeat.o(112639);
    return locali;
  }
  
  private static cgg b(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112637);
    cgg localcgg = new cgg();
    localcgg.dHX = paramString1;
    localcgg.ozE = paramString2;
    localcgg.GZs = new Long(System.currentTimeMillis() / 1000L).intValue();
    if (paramc == null) {}
    for (int i = -1;; i = paramc.action)
    {
      localcgg.GZt = i;
      AppMethodBeat.o(112637);
      return localcgg;
    }
  }
  
  private void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112644);
    ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112644);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      Object localObject = (WeakReference)this.owv.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).b(paramc);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112644);
  }
  
  private static boolean e(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112632);
    if (paramb == null)
    {
      AppMethodBeat.o(112632);
      return false;
    }
    if ((paramb.bTO() != null) && (paramb.bTO().FPE))
    {
      AppMethodBeat.o(112632);
      return true;
    }
    ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
    AppMethodBeat.o(112632);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112641);
    if (this.owv == null) {
      this.owv = new ArrayList();
    }
    this.owv.add(new WeakReference(parama));
    AppMethodBeat.o(112641);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, r paramr)
  {
    AppMethodBeat.i(112627);
    if (!e(paramb))
    {
      ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
      ah(2, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(aj.getContext()))
    {
      ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
      ah(-1, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (this.giC >= 3)
    {
      ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.giC + ",cannot request!");
      AppMethodBeat.o(112627);
      return;
    }
    a(paramb.bTR(), paramr);
    this.giC += 1;
    AppMethodBeat.o(112627);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(112628);
    ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
    Object localObject1 = am.bUN().bUD();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      AppMethodBeat.o(112628);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      CardInfo localCardInfo = (CardInfo)((Iterator)localObject1).next();
      if (localCardInfo == null)
      {
        ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      }
      else if (paramr == null)
      {
        ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
      }
      else
      {
        ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[] { localCardInfo.bTR(), Integer.valueOf(paramr.scene) });
        if (!e(localCardInfo))
        {
          ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[] { localCardInfo.bTR() });
        }
        else
        {
          Object localObject2 = localCardInfo.bTR();
          i locali = am.bVc().Yp((String)localObject2);
          int i;
          if (locali == null) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label356;
            }
            ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[] { localCardInfo.bTR(), Integer.valueOf(paramr.scene) });
            break;
            localObject2 = am.bVb().Yq((String)localObject2);
            if (((List)localObject2).isEmpty())
            {
              i = 1;
            }
            else if (((List)localObject2).size() < locali.field_lower_bound)
            {
              this.owS = com.tencent.mm.plugin.card.d.c.oPy;
              i = 1;
            }
            else if (a(locali))
            {
              this.owS = com.tencent.mm.plugin.card.d.c.oPs;
              i = 1;
            }
            else
            {
              i = 0;
            }
          }
          label356:
          ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
          a(localCardInfo.bTR(), paramr);
        }
      }
    }
    AppMethodBeat.o(112628);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112635);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(b(paramString1, paramString2, paramc));
    ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(paramc.action) });
    O(localLinkedList);
    AppMethodBeat.o(112635);
  }
  
  public final void ah(int paramInt, String paramString)
  {
    AppMethodBeat.i(112643);
    ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112643);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      Object localObject = (WeakReference)this.owv.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).aI(paramInt, paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112643);
  }
  
  public final void b(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(112629);
    String str = paramg.field_card_id;
    Object localObject1 = am.bVb();
    if (paramg.ozx)
    {
      paramg = am.bVb().Yq(str);
      localObject2 = ((com.tencent.mm.plugin.card.model.l)localObject1).Ys(str);
      ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[] { str });
      if (((com.tencent.mm.plugin.card.model.l)localObject1).CA(str))
      {
        if (localObject2 != null)
        {
          ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[] { str });
          b(com.tencent.mm.plugin.card.d.c.oPx);
        }
        a(str, paramg, com.tencent.mm.plugin.card.d.c.oPx);
      }
      AppMethodBeat.o(112629);
      return;
    }
    Object localObject2 = paramg.ozy;
    if (localObject2 == null)
    {
      ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[] { str });
      AppMethodBeat.o(112629);
      return;
    }
    ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[] { str, Integer.valueOf(((List)localObject2).size()) });
    paramg = ((com.tencent.mm.plugin.card.model.l)localObject1).Ys(str);
    localObject1 = new LinkedList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      g.c localc = (g.c)((Iterator)localObject2).next();
      if (am.bVb().eW(str, localc.ozE)) {
        ((LinkedList)localObject1).add(b(str, localc.ozE, com.tencent.mm.plugin.card.d.c.oPx));
      }
    }
    if (paramg != null)
    {
      ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[] { str, paramg.field_code_id });
      b(com.tencent.mm.plugin.card.d.c.oPx);
    }
    if (!((LinkedList)localObject1).isEmpty()) {
      O((LinkedList)localObject1);
    }
    AppMethodBeat.o(112629);
  }
  
  public final void bUg()
  {
    AppMethodBeat.i(112631);
    ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
    if (!this.owT.fkZ()) {
      this.owT.stopTimer();
    }
    AppMethodBeat.o(112631);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112640);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(",NetSceneBase=");
    if (paramn != null) {}
    for (Object localObject = paramn.getClass();; localObject = "")
    {
      ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label170;
      }
      if (!(paramn instanceof ae)) {
        break label150;
      }
      paramString = ((ae)paramn).oAj;
      if (paramString != null) {
        break;
      }
      ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
      AppMethodBeat.o(112640);
      return;
    }
    a(paramString);
    a(this.owS);
    com.tencent.mm.kernel.g.ajB().gAO.b(1382, this);
    AppMethodBeat.o(112640);
    return;
    label150:
    com.tencent.mm.kernel.g.ajB().gAO.b(1275, this);
    AppMethodBeat.o(112640);
    return;
    label170:
    localObject = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(" cmd:");
    if (paramn != null)
    {
      paramInt1 = paramn.getType();
      localStringBuilder = ((StringBuilder)localObject).append(paramInt1).append("  NetSceneBase=");
      if (paramn == null) {
        break label293;
      }
    }
    label293:
    for (localObject = paramn.getClass();; localObject = "")
    {
      ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if (!(paramn instanceof ae)) {
        break label301;
      }
      ah(paramInt2, paramString);
      com.tencent.mm.kernel.g.ajB().gAO.b(1382, this);
      AppMethodBeat.o(112640);
      return;
      paramInt1 = 0;
      break;
    }
    label301:
    com.tencent.mm.kernel.g.ajB().gAO.b(1275, this);
    AppMethodBeat.o(112640);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112626);
    this.giC = 0;
    bUg();
    ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
    com.tencent.mm.kernel.g.ajB().gAO.b(1382, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1275, this);
    AppMethodBeat.o(112626);
  }
  
  public static abstract interface a
  {
    public abstract void aI(int paramInt, String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.d.c paramc);
    
    public abstract void bUs();
    
    public abstract void c(com.tencent.mm.plugin.card.d.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g
 * JD-Core Version:    0.7.0.1
 */