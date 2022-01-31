package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements f
{
  List<WeakReference<c.a>> kkV;
  String kkW;
  public LinkedList<String> kkX;
  public int kkY;
  private int kkZ;
  private int kla;
  private int klb;
  private int klc;
  private boolean kld;
  private ap kle;
  private ap klf;
  
  public c()
  {
    AppMethodBeat.i(87639);
    this.kkV = new ArrayList();
    this.kkW = "";
    this.kkX = new LinkedList();
    this.klc = 60;
    this.kld = false;
    this.kle = new ap(new c.1(this), false);
    this.klf = new ap(new c.2(this), false);
    AppMethodBeat.o(87639);
  }
  
  private void Hy(String paramString)
  {
    AppMethodBeat.i(87644);
    ab.i("MicroMsg.CardCodeMgr", "onFail()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87644);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (c.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((c.a)localObject).Hy(paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87644);
  }
  
  private void bbs()
  {
    AppMethodBeat.i(87648);
    ac localac = new ac(this.kkW);
    g.RK().eHt.a(localac, 0);
    AppMethodBeat.o(87648);
  }
  
  private void bbu()
  {
    AppMethodBeat.i(87651);
    ab.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
    if (!this.kle.dtj()) {
      this.kle.stopTimer();
    }
    AppMethodBeat.o(87651);
  }
  
  private void onSuccess()
  {
    AppMethodBeat.i(87643);
    ab.i("MicroMsg.CardCodeMgr", "onSuccess()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87643);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (c.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((c.a)localObject).onSuccess();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87643);
  }
  
  public final void Hz(String paramString)
  {
    AppMethodBeat.i(87647);
    if (this.kld)
    {
      ab.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
      AppMethodBeat.o(87647);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
      AppMethodBeat.o(87647);
      return;
    }
    ab.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id ".concat(String.valueOf(paramString)));
    this.kld = true;
    this.kkW = paramString;
    bbs();
    AppMethodBeat.o(87647);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(87641);
    if (this.kkV == null) {
      this.kkV = new ArrayList();
    }
    this.kkV.add(new WeakReference(parama));
    AppMethodBeat.o(87641);
  }
  
  public final void b(c.a parama)
  {
    AppMethodBeat.i(87642);
    if (this.kkV == null)
    {
      AppMethodBeat.o(87642);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.kkV.get(i);
      if (localWeakReference != null)
      {
        c.a locala = (c.a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.kkV.remove(localWeakReference);
          AppMethodBeat.o(87642);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87642);
  }
  
  public final void bbt()
  {
    AppMethodBeat.i(87650);
    bbu();
    ab.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.kkZ);
    if ((this.kkZ > 0) && (!TextUtils.isEmpty(this.kkW)))
    {
      ap localap = this.kle;
      long l = this.kkZ * 1000;
      localap.ag(l, l);
      ab.i("MicroMsg.CardCodeMgr", "start request code timer!");
      AppMethodBeat.o(87650);
      return;
    }
    ab.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
    AppMethodBeat.o(87650);
  }
  
  public final void bbv()
  {
    AppMethodBeat.i(87652);
    bbw();
    ab.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.klb);
    if (this.klb > 0)
    {
      localap = this.klf;
      l = this.klb * 1000;
      localap.ag(l, l);
      ab.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
      AppMethodBeat.o(87652);
      return;
    }
    ap localap = this.klf;
    long l = this.klc * 1000;
    localap.ag(l, l);
    ab.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    AppMethodBeat.o(87652);
  }
  
  public final void bbw()
  {
    AppMethodBeat.i(87653);
    ab.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
    if (!this.klf.dtj()) {
      this.klf.stopTimer();
    }
    AppMethodBeat.o(87653);
  }
  
  public final String getCode()
  {
    AppMethodBeat.i(87645);
    if ((this.kkX == null) || (this.kkX.size() == 0))
    {
      ab.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(87645);
      return "";
    }
    if (this.kkY >= this.kkX.size())
    {
      ab.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      Hz(this.kkW);
      AppMethodBeat.o(87645);
      return "";
    }
    if (this.kla >= this.kkX.size() - this.kkY)
    {
      ab.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
      Hz(this.kkW);
    }
    ab.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.kkY + " request_count:" + this.kla + " codes size:" + this.kkX.size());
    Object localObject = this.kkX;
    int i = this.kkY;
    this.kkY = (i + 1);
    localObject = (String)((LinkedList)localObject).get(i);
    AppMethodBeat.o(87645);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(87646);
    if ((this.kkX == null) || (this.kkX.size() == 0))
    {
      ab.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(87646);
      return true;
    }
    if (this.kkY >= this.kkX.size())
    {
      ab.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      AppMethodBeat.o(87646);
      return true;
    }
    AppMethodBeat.o(87646);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(87649);
    ab.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof ac))
      {
        this.kld = false;
        ab.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.kkW);
        paramString = (ac)paramm;
        this.kkZ = paramString.kkZ;
        this.kla = paramString.kla;
        this.klb = paramString.klb;
        if (paramString.kkX != null)
        {
          this.kkX.clear();
          this.kkX.addAll(paramString.kkX);
          this.kkY = 0;
        }
        onSuccess();
        bbt();
        if (this.klb != 0) {
          bbv();
        }
        AppMethodBeat.o(87649);
      }
    }
    else if ((paramm instanceof ac))
    {
      this.kld = false;
      ab.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.kkW);
      Hy(paramString);
    }
    AppMethodBeat.o(87649);
  }
  
  public final void release()
  {
    AppMethodBeat.i(87640);
    g.RK().eHt.b(577, this);
    this.kkX.clear();
    this.kld = false;
    this.kkW = "";
    this.kkY = 0;
    this.kkZ = 0;
    this.kla = 0;
    this.klb = 0;
    bbu();
    bbw();
    AppMethodBeat.o(87640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c
 * JD-Core Version:    0.7.0.1
 */