package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g.c;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.ak.i
{
  public int gVP;
  public List<WeakReference<a>> pQG;
  public com.tencent.mm.plugin.card.d.c pRd;
  public MTimerHandler pRe;
  
  public g()
  {
    AppMethodBeat.i(112625);
    this.pQG = new ArrayList();
    this.pRe = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112624);
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
        g localg = g.this;
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
        if (localg.pQG != null)
        {
          int i = 0;
          while (i < localg.pQG.size())
          {
            Object localObject = (WeakReference)localg.pQG.get(i);
            if (localObject != null)
            {
              localObject = (g.a)((WeakReference)localObject).get();
              if (localObject != null) {
                ((g.a)localObject).ctv();
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
  
  private void Q(LinkedList<cxh> paramLinkedList)
  {
    AppMethodBeat.i(112636);
    com.tencent.mm.kernel.g.aAg().hqi.a(1275, this);
    paramLinkedList = new ah(paramLinkedList);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramLinkedList, 0);
    AppMethodBeat.o(112636);
  }
  
  private void a(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112642);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112642);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      Object localObject = (WeakReference)this.pQG.get(i);
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
  
  private void a(dgv paramdgv)
  {
    AppMethodBeat.i(112638);
    if (paramdgv == null)
    {
      AppMethodBeat.o(112638);
      return;
    }
    String str = paramdgv.eaO;
    Object localObject;
    if (am.cuf().ajl(str) == null)
    {
      localObject = b(paramdgv);
      am.cuf().insert((IAutoDBItem)localObject);
    }
    for (;;)
    {
      localObject = am.cue().ajm(str);
      if ((!((List)localObject).isEmpty()) && (am.cue().gC(str)) && (this.pRd != null)) {
        a(str, (List)localObject, this.pRd);
      }
      paramdgv = paramdgv.MLq.iterator();
      while (paramdgv.hasNext())
      {
        localObject = (dgu)paramdgv.next();
        k localk = new k();
        localk.field_card_id = str;
        localk.field_code_id = ((dgu)localObject).pTM;
        localk.field_code = e.fy(str, ((dgu)localObject).data);
        am.cue().insert(localk);
      }
      localObject = b(paramdgv);
      am.cuf().update((IAutoDBItem)localObject, new String[0]);
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
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", i);
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
      com.tencent.mm.kernel.g.aAg().hqi.a(1382, this);
      com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
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
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
      AppMethodBeat.o(112634);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList.add(b(paramString, ((k)paramList.next()).field_code_id, paramc));
    }
    Q(localLinkedList);
    AppMethodBeat.o(112634);
  }
  
  public static boolean a(com.tencent.mm.plugin.card.model.i parami)
  {
    AppMethodBeat.i(112630);
    if (System.currentTimeMillis() - parami.field_fetch_time > parami.field_expire_time_interval * 1000)
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(parami.field_fetch_time), Integer.valueOf(parami.field_expire_time_interval) });
      AppMethodBeat.o(112630);
      return true;
    }
    AppMethodBeat.o(112630);
    return false;
  }
  
  private static com.tencent.mm.plugin.card.model.i b(dgv paramdgv)
  {
    AppMethodBeat.i(112639);
    com.tencent.mm.plugin.card.model.i locali = new com.tencent.mm.plugin.card.model.i();
    locali.field_card_id = paramdgv.eaO;
    locali.field_lower_bound = paramdgv.MLl;
    locali.field_expire_time_interval = paramdgv.MLo;
    locali.field_need_insert_show_timestamp = paramdgv.MLm;
    locali.field_show_expire_interval = paramdgv.MLp;
    locali.field_show_timestamp_encrypt_key = paramdgv.MLn;
    locali.field_fetch_time = System.currentTimeMillis();
    AppMethodBeat.o(112639);
    return locali;
  }
  
  private static cxh b(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112637);
    cxh localcxh = new cxh();
    localcxh.eaO = paramString1;
    localcxh.pTM = paramString2;
    localcxh.MBP = new Long(System.currentTimeMillis() / 1000L).intValue();
    if (paramc == null) {}
    for (int i = -1;; i = paramc.action)
    {
      localcxh.MBQ = i;
      AppMethodBeat.o(112637);
      return localcxh;
    }
  }
  
  private void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112644);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112644);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      Object localObject = (WeakReference)this.pQG.get(i);
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
    if ((paramb.csR() != null) && (paramb.csR().LcG))
    {
      AppMethodBeat.o(112632);
      return true;
    }
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
    AppMethodBeat.o(112632);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112641);
    if (this.pQG == null) {
      this.pQG = new ArrayList();
    }
    this.pQG.add(new WeakReference(parama));
    AppMethodBeat.o(112641);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, r paramr)
  {
    AppMethodBeat.i(112627);
    if (!e(paramb))
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
      ak(2, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
      ak(-1, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (this.gVP >= 3)
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.gVP + ",cannot request!");
      AppMethodBeat.o(112627);
      return;
    }
    a(paramb.csU(), paramr);
    this.gVP += 1;
    AppMethodBeat.o(112627);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(112628);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
    Object localObject1 = am.ctQ().ctG();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      AppMethodBeat.o(112628);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      CardInfo localCardInfo = (CardInfo)((Iterator)localObject1).next();
      if (localCardInfo == null)
      {
        Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      }
      else if (paramr == null)
      {
        Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
      }
      else
      {
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[] { localCardInfo.csU(), Integer.valueOf(paramr.scene) });
        if (!e(localCardInfo))
        {
          Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[] { localCardInfo.csU() });
        }
        else
        {
          Object localObject2 = localCardInfo.csU();
          com.tencent.mm.plugin.card.model.i locali = am.cuf().ajl((String)localObject2);
          int i;
          if (locali == null) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label356;
            }
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[] { localCardInfo.csU(), Integer.valueOf(paramr.scene) });
            break;
            localObject2 = am.cue().ajm((String)localObject2);
            if (((List)localObject2).isEmpty())
            {
              i = 1;
            }
            else if (((List)localObject2).size() < locali.field_lower_bound)
            {
              this.pRd = com.tencent.mm.plugin.card.d.c.qkU;
              i = 1;
            }
            else if (a(locali))
            {
              this.pRd = com.tencent.mm.plugin.card.d.c.qkO;
              i = 1;
            }
            else
            {
              i = 0;
            }
          }
          label356:
          Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
          a(localCardInfo.csU(), paramr);
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
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(paramc.action) });
    Q(localLinkedList);
    AppMethodBeat.o(112635);
  }
  
  public final void ak(int paramInt, String paramString)
  {
    AppMethodBeat.i(112643);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112643);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      Object localObject = (WeakReference)this.pQG.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).aM(paramInt, paramString);
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
    Object localObject1 = am.cue();
    if (paramg.pTG)
    {
      paramg = am.cue().ajm(str);
      localObject2 = ((com.tencent.mm.plugin.card.model.l)localObject1).ajo(str);
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[] { str });
      if (((com.tencent.mm.plugin.card.model.l)localObject1).gC(str))
      {
        if (localObject2 != null)
        {
          Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[] { str });
          b(com.tencent.mm.plugin.card.d.c.qkT);
        }
        a(str, paramg, com.tencent.mm.plugin.card.d.c.qkT);
      }
      AppMethodBeat.o(112629);
      return;
    }
    Object localObject2 = paramg.pTH;
    if (localObject2 == null)
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[] { str });
      AppMethodBeat.o(112629);
      return;
    }
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[] { str, Integer.valueOf(((List)localObject2).size()) });
    paramg = ((com.tencent.mm.plugin.card.model.l)localObject1).ajo(str);
    localObject1 = new LinkedList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      g.c localc = (g.c)((Iterator)localObject2).next();
      if (am.cue().fr(str, localc.pTM)) {
        ((LinkedList)localObject1).add(b(str, localc.pTM, com.tencent.mm.plugin.card.d.c.qkT));
      }
    }
    if (paramg != null)
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[] { str, paramg.field_code_id });
      b(com.tencent.mm.plugin.card.d.c.qkT);
    }
    if (!((LinkedList)localObject1).isEmpty()) {
      Q((LinkedList)localObject1);
    }
    AppMethodBeat.o(112629);
  }
  
  public final void ctj()
  {
    AppMethodBeat.i(112631);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
    if (!this.pRe.stopped()) {
      this.pRe.stopTimer();
    }
    AppMethodBeat.o(112631);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112640);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(",NetSceneBase=");
    if (paramq != null) {}
    for (Object localObject = paramq.getClass();; localObject = "")
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label170;
      }
      if (!(paramq instanceof ae)) {
        break label150;
      }
      paramString = ((ae)paramq).pUr;
      if (paramString != null) {
        break;
      }
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
      AppMethodBeat.o(112640);
      return;
    }
    a(paramString);
    a(this.pRd);
    com.tencent.mm.kernel.g.aAg().hqi.b(1382, this);
    AppMethodBeat.o(112640);
    return;
    label150:
    com.tencent.mm.kernel.g.aAg().hqi.b(1275, this);
    AppMethodBeat.o(112640);
    return;
    label170:
    localObject = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(" cmd:");
    if (paramq != null)
    {
      paramInt1 = paramq.getType();
      localStringBuilder = ((StringBuilder)localObject).append(paramInt1).append("  NetSceneBase=");
      if (paramq == null) {
        break label293;
      }
    }
    label293:
    for (localObject = paramq.getClass();; localObject = "")
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if (!(paramq instanceof ae)) {
        break label301;
      }
      ak(paramInt2, paramString);
      com.tencent.mm.kernel.g.aAg().hqi.b(1382, this);
      AppMethodBeat.o(112640);
      return;
      paramInt1 = 0;
      break;
    }
    label301:
    com.tencent.mm.kernel.g.aAg().hqi.b(1275, this);
    AppMethodBeat.o(112640);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112626);
    this.gVP = 0;
    ctj();
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
    com.tencent.mm.kernel.g.aAg().hqi.b(1382, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1275, this);
    AppMethodBeat.o(112626);
  }
  
  public static abstract interface a
  {
    public abstract void aM(int paramInt, String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.d.c paramc);
    
    public abstract void c(com.tencent.mm.plugin.card.d.c paramc);
    
    public abstract void ctv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g
 * JD-Core Version:    0.7.0.1
 */