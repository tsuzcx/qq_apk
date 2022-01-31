package com.tencent.mm.at;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class i
  implements com.tencent.mm.ai.f, com.tencent.mm.ai.g
{
  private static Set<Integer> fEY;
  private Queue<e> ckH;
  private boolean ckL;
  int ckM;
  private long ckN;
  g.a ckQ;
  private ap ckR;
  private LinkedList<l> fEZ;
  public i.a fFa;
  private boolean fFb;
  private l.a fFc;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(78305);
    fEY = new HashSet();
    AppMethodBeat.o(78305);
  }
  
  public i()
  {
    AppMethodBeat.i(78294);
    this.fEZ = new LinkedList();
    this.fFa = null;
    this.fFb = false;
    this.fFc = new i.1(this);
    this.ckH = new LinkedList();
    this.running = false;
    this.ckM = 0;
    this.ckN = 0L;
    this.ckL = false;
    this.ckQ = new g.a();
    com.tencent.mm.kernel.g.RM();
    this.ckR = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new i.5(this), false);
    if (com.tencent.mm.kernel.g.RK().eHt != null) {
      com.tencent.mm.kernel.g.RK().eHt.a(110, this);
    }
    this.fEZ.clear();
    this.fFb = false;
    AppMethodBeat.o(78294);
  }
  
  private void ET()
  {
    AppMethodBeat.i(78300);
    this.ckH.clear();
    this.running = false;
    ab.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.ckQ.Mm());
    AppMethodBeat.o(78300);
  }
  
  private void a(l paraml)
  {
    AppMethodBeat.i(78297);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new i.2(this, paraml));
    AppMethodBeat.o(78297);
  }
  
  public static boolean lx(int paramInt)
  {
    AppMethodBeat.i(78292);
    if ((com.tencent.mm.sdk.a.b.dsf()) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE)) {
      ab.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bo.dtY().toString() });
    }
    boolean bool = fEY.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(78292);
    return bool;
  }
  
  public static boolean ly(int paramInt)
  {
    AppMethodBeat.i(78293);
    if ((com.tencent.mm.sdk.a.b.dsf()) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE)) {
      ab.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bo.dtY().toString() });
    }
    boolean bool = fEY.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(78293);
    return bool;
  }
  
  public static void lz(int paramInt)
  {
    AppMethodBeat.i(78298);
    ab.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    e locale = o.ahC().lv(paramInt);
    if ((locale == null) || (locale.fDL <= 0L))
    {
      AppMethodBeat.o(78298);
      return;
    }
    Object localObject = o.ahC().lw((int)locale.fDL);
    if (localObject != null)
    {
      ((e)localObject).setStatus(-1);
      ((e)localObject).bsY = 264;
      o.ahC().a((int)((e)localObject).fDL, (e)localObject);
    }
    for (localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(((e)localObject).fDU); ((dd)localObject).field_msgId != locale.fDU; localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(locale.fDU))
    {
      AppMethodBeat.o(78298);
      return;
      locale.setStatus(-1);
      locale.bsY = 264;
      o.ahC().a(paramInt, locale);
    }
    ((bi)localObject).setStatus(5);
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 31L, 1L, true);
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a((int)((dd)localObject).field_msgId, (bi)localObject);
    AppMethodBeat.o(78298);
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(78302);
    paramm = (l)paramm;
    if ((this.fFa != null) && (paramm != null) && (paramm.cmQ != null)) {
      this.fFa.a(paramm.cmQ.field_msgId, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78302);
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(78295);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (r.g(str, paramString2, paramBoolean)) {}
      for (int i = 1;; i = 0)
      {
        ab.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
        a(new l(paramString1, paramString2, str, i, this, paramInt, this.fFc));
        break;
      }
    }
    AppMethodBeat.o(78295);
  }
  
  public final void a(ArrayList<Integer> paramArrayList, String paramString1, String paramString2, ArrayList<String> paramArrayList1, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(78296);
    Iterator localIterator = paramArrayList1.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramArrayList.size() <= i)
      {
        ab.w("MicroMsg.ImgService", "Wrong! origImgPath:%s size:%s", new Object[] { str, Integer.valueOf(paramArrayList.size()) });
        AppMethodBeat.o(78296);
        return;
      }
      int k = ((Integer)paramArrayList.get(i)).intValue();
      if (r.g(str, paramString2, paramBoolean)) {}
      for (int j = 1;; j = 0)
      {
        paramArrayList1 = "";
        e locale = o.ahC().lv(k);
        if (locale != null) {
          paramArrayList1 = locale.fDX;
        }
        paramArrayList1 = new l(k, paramString1, paramString2, str, j, this, paramInt, paramArrayList1, "");
        paramArrayList1.fFJ = new l.b(paramArrayList1, this.fFc);
        a(paramArrayList1);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(78296);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(78299);
    ab.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    i.a locala;
    long l;
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      if ((this.fFa != null) && (paramString != null) && (paramString.cmQ != null))
      {
        locala = this.fFa;
        l = paramString.cmQ.field_msgId;
        if (paramString.cmQ.field_status == 5) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      locala.k(l, bool);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RO().ac(new i.3(this, paramm));
      AppMethodBeat.o(78299);
      return;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(78301);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new i.4(this));
    AppMethodBeat.o(78301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.at.i
 * JD-Core Version:    0.7.0.1
 */