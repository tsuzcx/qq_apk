package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  implements f, k.a, com.tencent.mm.plugin.card.base.d
{
  public WeakReference<Context> mContextRef;
  public List<WeakReference<a>> oCX;
  public HashMap<a, Boolean> oDj;
  public HashMap<String, Boolean> oDk;
  public HashMap<String, Boolean> oDl;
  public com.tencent.mm.plugin.card.base.b oDm;
  public boolean oDn;
  public String oDo;
  
  public d()
  {
    AppMethodBeat.i(112598);
    this.oCX = new ArrayList();
    this.oDj = new HashMap();
    this.oDk = new HashMap();
    this.oDl = new HashMap();
    this.oDm = null;
    this.oDn = false;
    AppMethodBeat.o(112598);
  }
  
  private void YW(String paramString)
  {
    AppMethodBeat.i(112609);
    ae.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112609);
      return;
    }
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < this.oCX.size())
    {
      localObject = (WeakReference)this.oCX.get(j);
      if (localObject == null) {
        break label216;
      }
      localObject = (a)((WeakReference)localObject).get();
      Boolean localBoolean = (Boolean)this.oDj.get(localObject);
      if ((localObject == null) || (localBoolean == null) || (!localBoolean.booleanValue())) {
        break label216;
      }
      ((a)localObject).YX(paramString);
      i = 1;
    }
    label216:
    for (;;)
    {
      j += 1;
      break;
      localObject = (Boolean)this.oDk.get(this.oDm.bVg());
      if (i != 0)
      {
        ae.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
        this.oDo = "";
        AppMethodBeat.o(112609);
        return;
      }
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        ae.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
        this.oDo = paramString;
        this.oDl.put(this.oDm.bVg(), Boolean.TRUE);
      }
      AppMethodBeat.o(112609);
      return;
    }
  }
  
  /* Error */
  private void bVA()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 127
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 60	com/tencent/mm/plugin/card/b/d:oDn	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 69
    //   16: ldc 129
    //   18: invokestatic 76	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 127
    //   23: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 69
    //   31: ldc 131
    //   33: invokestatic 76	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 60	com/tencent/mm/plugin/card/b/d:oDn	Z
    //   41: new 133	com/tencent/mm/plugin/card/sharecard/model/d
    //   44: dup
    //   45: aload_0
    //   46: getfield 58	com/tencent/mm/plugin/card/b/d:oDm	Lcom/tencent/mm/plugin/card/base/b;
    //   49: invokeinterface 109 1 0
    //   54: ldc 113
    //   56: ldc 113
    //   58: invokespecial 136	com/tencent/mm/plugin/card/sharecard/model/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   61: astore_1
    //   62: invokestatic 142	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   65: getfield 148	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   68: aload_1
    //   69: iconst_0
    //   70: invokevirtual 153	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
    //   73: pop
    //   74: ldc 127
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
  
  private void bVx()
  {
    AppMethodBeat.i(112611);
    ae.i("MicroMsg.CardConsumedMgr", "doVibrate()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112611);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).bVB();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112611);
  }
  
  private void bVy()
  {
    AppMethodBeat.i(112612);
    ae.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112612);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).bVC();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112612);
  }
  
  private void bVz()
  {
    AppMethodBeat.i(112613);
    ae.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
    bVA();
    AppMethodBeat.o(112613);
  }
  
  private void c(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112610);
    ae.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112610);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
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
    if (this.oCX == null) {
      this.oCX = new ArrayList();
    }
    this.oCX.add(new WeakReference(parama));
    AppMethodBeat.o(112600);
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112603);
    if (this.oDj == null) {
      this.oDj = new HashMap();
    }
    this.oDj.put(parama, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(112603);
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(112607);
    ae.i("MicroMsg.CardConsumedMgr", "onChange()");
    ae.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if (this.oDm == null)
    {
      ae.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
      bVy();
      AppMethodBeat.o(112607);
      return;
    }
    ae.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if ((this.oDm.bUH()) && (paramg.field_card_id != null) && (paramg.field_card_id.equals(this.oDm.bVg())) && (paramg.oFY == 3))
    {
      ae.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
      bVy();
      AppMethodBeat.o(112607);
      return;
    }
    if (!this.oDm.bUI())
    {
      ae.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
      bVy();
      AppMethodBeat.o(112607);
      return;
    }
    int i;
    Object localObject;
    if ((paramg.oFY == 3) || ((paramg.field_card_id != null) && (paramg.field_card_id.equals(this.oDm.bVg())) && (!TextUtils.isEmpty(paramg.field_consumed_box_id))))
    {
      long l1 = System.currentTimeMillis();
      ae.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
      if ((paramg.field_card_id == null) || (!paramg.field_card_id.equals(this.oDm.bVg()))) {
        break label652;
      }
      paramg = am.bWk().Zv(this.oDm.bVg());
      if ((paramg != null) && (paramg.bVd() != null))
      {
        i = this.oDm.bVd().status;
        ae.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramg.bVd().status), Integer.valueOf(((ShareCardInfo)this.oDm).field_status) });
        if (paramg.bVd().status == i) {
          break label585;
        }
        bVx();
      }
      c(this.oDm);
      paramg = (Boolean)this.oDk.get(this.oDm.bVg());
      if ((paramg != null) && (paramg.booleanValue())) {
        break label769;
      }
      paramg = (Context)this.mContextRef.get();
      ae.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.oDm.bVg());
      com.tencent.mm.plugin.card.sharecard.a.b.a(paramg, this.oDm);
      this.oDk.put(this.oDm.bVg(), Boolean.TRUE);
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
      com.tencent.mm.plugin.report.service.g.yxI.b(paramg, true);
    }
    for (;;)
    {
      bVz();
      AppMethodBeat.o(112607);
      return;
      label585:
      if (i == 1) {
        break;
      }
      ae.i("MicroMsg.CardConsumedMgr", "share card oldState status is ".concat(String.valueOf(i)));
      paramg = this.oDm.bVd();
      paramg.status = 1;
      ((ShareCardInfo)this.oDm).field_status = 1;
      this.oDm.a(paramg);
      l.h(this.oDm);
      break;
      label652:
      if (paramg.field_card_id == null) {
        break;
      }
      paramg = am.bWk().Zv(paramg.field_card_id);
      if ((paramg != null) && (paramg.bVd() != null))
      {
        ae.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[] { Integer.valueOf(paramg.bVd().status), Integer.valueOf(paramg.field_status) });
        if (paramg.bVd().status == 1) {
          break;
        }
        localObject = paramg.bVd();
        ((st)localObject).status = 1;
        paramg.field_status = 1;
        paramg.a((st)localObject);
        l.h(paramg);
        break;
      }
      ae.w("MicroMsg.CardConsumedMgr", "tempCard is null");
      break;
      label769:
      ae.i("MicroMsg.CardConsumedMgr", "consumed:" + paramg.booleanValue());
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112601);
    if (this.oCX == null)
    {
      AppMethodBeat.o(112601);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      WeakReference localWeakReference = (WeakReference)this.oCX.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.oCX.remove(localWeakReference);
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
    this.oDm = paramb;
    if ((this.oDn) && (this.oDm != null) && (paramb.bVg() != null) && (!paramb.bVg().equals(this.oDm.bVg()))) {
      this.oDn = false;
    }
    if (this.oCX == null)
    {
      AppMethodBeat.o(112602);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        Boolean localBoolean = (Boolean)this.oDj.get(localObject);
        if ((localObject != null) && (localBoolean != null) && (!localBoolean.booleanValue())) {
          ((a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112602);
  }
  
  public final void bVn()
  {
    AppMethodBeat.i(112605);
    ae.i("MicroMsg.CardConsumedMgr", "onDBchange()");
    if (this.oDm == null)
    {
      ae.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
      AppMethodBeat.o(112605);
      return;
    }
    Object localObject1;
    label222:
    Object localObject2;
    if (this.oDm.bUI())
    {
      localObject1 = am.bWk().Zv(this.oDm.bVg());
      if ((localObject1 != null) && (((com.tencent.mm.plugin.card.base.b)localObject1).bVd() != null) && (this.oDm != null) && (this.oDm.bVd() != null))
      {
        int i = this.oDm.bVd().status;
        ae.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.card.base.b)localObject1).bVd().status), Boolean.valueOf(this.oDn), Boolean.valueOf(this.oDm.bUI()) });
        if ((!this.oDm.bUI()) || (!(this.oDm instanceof ShareCardInfo))) {
          break label555;
        }
        ae.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[] { Integer.valueOf(((ShareCardInfo)this.oDm).field_status) });
        if (((com.tencent.mm.plugin.card.base.b)localObject1).bVd().status != i)
        {
          bVx();
          if ((!this.oDm.bUI()) || (this.oDn) || (((com.tencent.mm.plugin.card.base.b)localObject1).bVd().status != 1)) {
            break label607;
          }
          ae.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
          localObject2 = (Boolean)this.oDk.get(this.oDm.bVg());
          if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
            break label578;
          }
          ae.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
          long l1 = System.currentTimeMillis();
          localObject2 = (Context)this.mContextRef.get();
          ae.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.oDm.bVg());
          com.tencent.mm.plugin.card.sharecard.a.b.a((Context)localObject2, this.oDm);
          this.oDk.put(this.oDm.bVg(), Boolean.TRUE);
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
          com.tencent.mm.plugin.report.service.g.yxI.b((ArrayList)localObject2, true);
          label502:
          bVz();
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
      this.oDm = ((com.tencent.mm.plugin.card.base.b)localObject1);
      c(this.oDm);
      AppMethodBeat.o(112605);
      return;
      localObject1 = am.bWc().Zf(this.oDm.bVg());
      break;
      label555:
      if (!this.oDm.bUI()) {
        break label222;
      }
      ae.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
      break label222;
      label578:
      ae.i("MicroMsg.CardConsumedMgr", "consumed:" + ((Boolean)localObject2).booleanValue());
      break label502;
      label607:
      if ((this.oDm.bUI()) && (this.oDn))
      {
        ae.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
      }
      else
      {
        ae.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
        bVy();
      }
    }
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(112604);
    if (this.oDj == null) {
      this.oDj = new HashMap();
    }
    this.oDj.remove(parama);
    AppMethodBeat.o(112604);
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(112606);
    bVx();
    AppMethodBeat.o(112606);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112608);
    ae.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramn;
        if (!TextUtils.isEmpty(paramString.oGs)) {
          YW(paramString.oGs);
        }
        for (;;)
        {
          this.oDn = false;
          ae.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
          bVy();
          AppMethodBeat.o(112608);
          return;
          ae.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
        }
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
    {
      this.oDn = false;
      ae.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
      bVy();
      AppMethodBeat.o(112608);
      return;
    }
    AppMethodBeat.o(112608);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112599);
    com.tencent.mm.kernel.g.ajQ().gDv.b(910, this);
    am.bWj().b(this);
    b localb = am.bWb();
    int i;
    if (localb.oCX != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < localb.oCX.size())
      {
        WeakReference localWeakReference = (WeakReference)localb.oCX.get(i);
        if (localWeakReference != null)
        {
          com.tencent.mm.plugin.card.base.d locald = (com.tencent.mm.plugin.card.base.d)localWeakReference.get();
          if ((locald != null) && (locald.equals(this))) {
            localb.oCX.remove(localWeakReference);
          }
        }
      }
      else
      {
        this.oCX.clear();
        this.oDj.clear();
        this.oDl.clear();
        this.oDn = false;
        AppMethodBeat.o(112599);
        return;
      }
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void YX(String paramString);
    
    public abstract void bVB();
    
    public abstract void bVC();
    
    public abstract void d(com.tencent.mm.plugin.card.base.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.d
 * JD-Core Version:    0.7.0.1
 */