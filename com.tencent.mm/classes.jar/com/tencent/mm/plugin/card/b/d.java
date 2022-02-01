package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  implements f, k.a, com.tencent.mm.plugin.card.base.d
{
  public WeakReference<Context> mContextRef;
  public HashMap<a, Boolean> owH;
  public HashMap<String, Boolean> owI;
  public HashMap<String, Boolean> owJ;
  public com.tencent.mm.plugin.card.base.b owK;
  public boolean owL;
  public String owM;
  public List<WeakReference<a>> owv;
  
  public d()
  {
    AppMethodBeat.i(112598);
    this.owv = new ArrayList();
    this.owH = new HashMap();
    this.owI = new HashMap();
    this.owJ = new HashMap();
    this.owK = null;
    this.owL = false;
    AppMethodBeat.o(112598);
  }
  
  private void Yf(String paramString)
  {
    AppMethodBeat.i(112609);
    ad.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112609);
      return;
    }
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < this.owv.size())
    {
      localObject = (WeakReference)this.owv.get(j);
      if (localObject == null) {
        break label216;
      }
      localObject = (a)((WeakReference)localObject).get();
      Boolean localBoolean = (Boolean)this.owH.get(localObject);
      if ((localObject == null) || (localBoolean == null) || (!localBoolean.booleanValue())) {
        break label216;
      }
      ((a)localObject).Yg(paramString);
      i = 1;
    }
    label216:
    for (;;)
    {
      j += 1;
      break;
      localObject = (Boolean)this.owI.get(this.owK.bTR());
      if (i != 0)
      {
        ad.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
        this.owM = "";
        AppMethodBeat.o(112609);
        return;
      }
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        ad.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
        this.owM = paramString;
        this.owJ.put(this.owK.bTR(), Boolean.TRUE);
      }
      AppMethodBeat.o(112609);
      return;
    }
  }
  
  private void bUi()
  {
    AppMethodBeat.i(112611);
    ad.i("MicroMsg.CardConsumedMgr", "doVibrate()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112611);
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
          ((a)localObject).bUm();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112611);
  }
  
  private void bUj()
  {
    AppMethodBeat.i(112612);
    ad.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112612);
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
          ((a)localObject).bUn();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112612);
  }
  
  private void bUk()
  {
    AppMethodBeat.i(112613);
    ad.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
    bUl();
    AppMethodBeat.o(112613);
  }
  
  /* Error */
  private void bUl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 60	com/tencent/mm/plugin/card/b/d:owL	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 69
    //   16: ldc 149
    //   18: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 147
    //   23: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 69
    //   31: ldc 151
    //   33: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 60	com/tencent/mm/plugin/card/b/d:owL	Z
    //   41: new 153	com/tencent/mm/plugin/card/sharecard/model/d
    //   44: dup
    //   45: aload_0
    //   46: getfield 58	com/tencent/mm/plugin/card/b/d:owK	Lcom/tencent/mm/plugin/card/base/b;
    //   49: invokeinterface 109 1 0
    //   54: ldc 113
    //   56: ldc 113
    //   58: invokespecial 156	com/tencent/mm/plugin/card/sharecard/model/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   61: astore_1
    //   62: invokestatic 162	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   65: getfield 168	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   68: aload_1
    //   69: iconst_0
    //   70: invokevirtual 173	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;I)Z
    //   73: pop
    //   74: ldc 147
    //   76: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -53 -> 26
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	d
    //   61	8	1	locald	com.tencent.mm.plugin.card.sharecard.model.d
    //   82	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	82	finally
    //   29	79	82	finally
  }
  
  private void c(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112610);
    ad.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112610);
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
          ((a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112610);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112600);
    if (this.owv == null) {
      this.owv = new ArrayList();
    }
    this.owv.add(new WeakReference(parama));
    AppMethodBeat.o(112600);
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112603);
    if (this.owH == null) {
      this.owH = new HashMap();
    }
    this.owH.put(parama, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(112603);
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(112607);
    ad.i("MicroMsg.CardConsumedMgr", "onChange()");
    ad.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if (this.owK == null)
    {
      ad.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
      bUj();
      AppMethodBeat.o(112607);
      return;
    }
    ad.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if ((this.owK.bTs()) && (paramg.field_card_id != null) && (paramg.field_card_id.equals(this.owK.bTR())) && (paramg.ozw == 3))
    {
      ad.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
      bUj();
      AppMethodBeat.o(112607);
      return;
    }
    if (!this.owK.bTt())
    {
      ad.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
      bUj();
      AppMethodBeat.o(112607);
      return;
    }
    int i;
    Object localObject;
    if ((paramg.ozw == 3) || ((paramg.field_card_id != null) && (paramg.field_card_id.equals(this.owK.bTR())) && (!TextUtils.isEmpty(paramg.field_consumed_box_id))))
    {
      long l1 = System.currentTimeMillis();
      ad.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
      if ((paramg.field_card_id == null) || (!paramg.field_card_id.equals(this.owK.bTR()))) {
        break label652;
      }
      paramg = am.bUV().YE(this.owK.bTR());
      if ((paramg != null) && (paramg.bTO() != null))
      {
        i = this.owK.bTO().status;
        ad.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramg.bTO().status), Integer.valueOf(((ShareCardInfo)this.owK).field_status) });
        if (paramg.bTO().status == i) {
          break label585;
        }
        bUi();
      }
      c(this.owK);
      paramg = (Boolean)this.owI.get(this.owK.bTR());
      if ((paramg != null) && (paramg.booleanValue())) {
        break label769;
      }
      paramg = (Context)this.mContextRef.get();
      ad.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.owK.bTR());
      com.tencent.mm.plugin.card.sharecard.a.b.a(paramg, this.owK);
      this.owI.put(this.owK.bTR(), Boolean.TRUE);
      long l2 = System.currentTimeMillis();
      paramg = new ArrayList();
      localObject = new IDKey();
      ((IDKey)localObject).SetID(281);
      ((IDKey)localObject).SetKey(30);
      ((IDKey)localObject).SetValue(1L);
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(281);
      localIDKey.SetKey(31);
      localIDKey.SetValue((int)(l2 - l1));
      paramg.add(localObject);
      paramg.add(localIDKey);
      com.tencent.mm.plugin.report.service.g.yhR.b(paramg, true);
    }
    for (;;)
    {
      bUk();
      AppMethodBeat.o(112607);
      return;
      label585:
      if (i == 1) {
        break;
      }
      ad.i("MicroMsg.CardConsumedMgr", "share card oldState status is ".concat(String.valueOf(i)));
      paramg = this.owK.bTO();
      paramg.status = 1;
      ((ShareCardInfo)this.owK).field_status = 1;
      this.owK.a(paramg);
      l.h(this.owK);
      break;
      label652:
      if (paramg.field_card_id == null) {
        break;
      }
      paramg = am.bUV().YE(paramg.field_card_id);
      if ((paramg != null) && (paramg.bTO() != null))
      {
        ad.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[] { Integer.valueOf(paramg.bTO().status), Integer.valueOf(paramg.field_status) });
        if (paramg.bTO().status == 1) {
          break;
        }
        localObject = paramg.bTO();
        ((sr)localObject).status = 1;
        paramg.field_status = 1;
        paramg.a((sr)localObject);
        l.h(paramg);
        break;
      }
      ad.w("MicroMsg.CardConsumedMgr", "tempCard is null");
      break;
      label769:
      ad.i("MicroMsg.CardConsumedMgr", "consumed:" + paramg.booleanValue());
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112601);
    if (this.owv == null)
    {
      AppMethodBeat.o(112601);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      WeakReference localWeakReference = (WeakReference)this.owv.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.owv.remove(localWeakReference);
          AppMethodBeat.o(112601);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112601);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112602);
    this.owK = paramb;
    if ((this.owL) && (this.owK != null) && (paramb.bTR() != null) && (!paramb.bTR().equals(this.owK.bTR()))) {
      this.owL = false;
    }
    if (this.owv == null)
    {
      AppMethodBeat.o(112602);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      Object localObject = (WeakReference)this.owv.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        Boolean localBoolean = (Boolean)this.owH.get(localObject);
        if ((localObject != null) && (localBoolean != null) && (!localBoolean.booleanValue())) {
          ((a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112602);
  }
  
  public final void bTY()
  {
    AppMethodBeat.i(112605);
    ad.i("MicroMsg.CardConsumedMgr", "onDBchange()");
    if (this.owK == null)
    {
      ad.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
      AppMethodBeat.o(112605);
      return;
    }
    Object localObject1;
    label222:
    Object localObject2;
    if (this.owK.bTt())
    {
      localObject1 = am.bUV().YE(this.owK.bTR());
      if ((localObject1 != null) && (((com.tencent.mm.plugin.card.base.b)localObject1).bTO() != null) && (this.owK != null) && (this.owK.bTO() != null))
      {
        int i = this.owK.bTO().status;
        ad.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.card.base.b)localObject1).bTO().status), Boolean.valueOf(this.owL), Boolean.valueOf(this.owK.bTt()) });
        if ((!this.owK.bTt()) || (!(this.owK instanceof ShareCardInfo))) {
          break label555;
        }
        ad.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[] { Integer.valueOf(((ShareCardInfo)this.owK).field_status) });
        if (((com.tencent.mm.plugin.card.base.b)localObject1).bTO().status != i)
        {
          bUi();
          if ((!this.owK.bTt()) || (this.owL) || (((com.tencent.mm.plugin.card.base.b)localObject1).bTO().status != 1)) {
            break label607;
          }
          ad.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
          localObject2 = (Boolean)this.owI.get(this.owK.bTR());
          if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
            break label578;
          }
          ad.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
          long l1 = System.currentTimeMillis();
          localObject2 = (Context)this.mContextRef.get();
          ad.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.owK.bTR());
          com.tencent.mm.plugin.card.sharecard.a.b.a((Context)localObject2, this.owK);
          this.owI.put(this.owK.bTR(), Boolean.TRUE);
          long l2 = System.currentTimeMillis();
          localObject2 = new ArrayList();
          IDKey localIDKey1 = new IDKey();
          localIDKey1.SetID(281);
          localIDKey1.SetKey(30);
          localIDKey1.SetValue(1L);
          IDKey localIDKey2 = new IDKey();
          localIDKey2.SetID(281);
          localIDKey2.SetKey(31);
          localIDKey2.SetValue((int)(l2 - l1));
          ((ArrayList)localObject2).add(localIDKey1);
          ((ArrayList)localObject2).add(localIDKey2);
          com.tencent.mm.plugin.report.service.g.yhR.b((ArrayList)localObject2, true);
          label502:
          bUk();
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
      this.owK = ((com.tencent.mm.plugin.card.base.b)localObject1);
      c(this.owK);
      AppMethodBeat.o(112605);
      return;
      localObject1 = am.bUN().Yo(this.owK.bTR());
      break;
      label555:
      if (!this.owK.bTt()) {
        break label222;
      }
      ad.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
      break label222;
      label578:
      ad.i("MicroMsg.CardConsumedMgr", "consumed:" + ((Boolean)localObject2).booleanValue());
      break label502;
      label607:
      if ((this.owK.bTt()) && (this.owL))
      {
        ad.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
      }
      else
      {
        ad.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
        bUj();
      }
    }
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(112604);
    if (this.owH == null) {
      this.owH = new HashMap();
    }
    this.owH.remove(parama);
    AppMethodBeat.o(112604);
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(112606);
    bUi();
    AppMethodBeat.o(112606);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112608);
    ad.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramn;
        if (!TextUtils.isEmpty(paramString.ozQ)) {
          Yf(paramString.ozQ);
        }
        for (;;)
        {
          this.owL = false;
          ad.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
          bUj();
          AppMethodBeat.o(112608);
          return;
          ad.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
        }
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
    {
      this.owL = false;
      ad.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
      bUj();
      AppMethodBeat.o(112608);
      return;
    }
    AppMethodBeat.o(112608);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112599);
    com.tencent.mm.kernel.g.ajB().gAO.b(910, this);
    am.bUU().b(this);
    b localb = am.bUM();
    int i;
    if (localb.owv != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < localb.owv.size())
      {
        WeakReference localWeakReference = (WeakReference)localb.owv.get(i);
        if (localWeakReference != null)
        {
          com.tencent.mm.plugin.card.base.d locald = (com.tencent.mm.plugin.card.base.d)localWeakReference.get();
          if ((locald != null) && (locald.equals(this))) {
            localb.owv.remove(localWeakReference);
          }
        }
      }
      else
      {
        this.owv.clear();
        this.owH.clear();
        this.owJ.clear();
        this.owL = false;
        AppMethodBeat.o(112599);
        return;
      }
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Yg(String paramString);
    
    public abstract void bUm();
    
    public abstract void bUn();
    
    public abstract void d(com.tencent.mm.plugin.card.base.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.d
 * JD-Core Version:    0.7.0.1
 */