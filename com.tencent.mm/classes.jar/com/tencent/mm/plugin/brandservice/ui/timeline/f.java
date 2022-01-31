package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  int cnU;
  HashMap<String, f.a> jWA;
  int jWy;
  int jWz;
  
  public f(int paramInt)
  {
    AppMethodBeat.i(14174);
    this.jWA = new HashMap();
    this.cnU = paramInt;
    AppMethodBeat.o(14174);
  }
  
  static int a(q paramq, String paramString)
  {
    AppMethodBeat.i(14176);
    if ((paramq.field_appMsgStatInfoProto == null) || (bo.isNullOrNil(paramString)) || (bo.es(paramq.field_appMsgStatInfoProto.wqW)))
    {
      AppMethodBeat.o(14176);
      return 0;
    }
    paramq = paramq.field_appMsgStatInfoProto.wqW.iterator();
    et localet;
    do
    {
      if (!paramq.hasNext()) {
        break;
      }
      localet = (et)paramq.next();
    } while (!bo.isEqual(localet.url, paramString));
    for (int i = localet.wqV;; i = 0)
    {
      AppMethodBeat.o(14176);
      return i;
    }
  }
  
  static void a(f.a parama, String paramString)
  {
    AppMethodBeat.i(14177);
    if (((j)g.E(j.class)).YA().arw(paramString).Oa())
    {
      parama.wze = 1;
      parama.wzi = 1;
      AppMethodBeat.o(14177);
      return;
    }
    parama.wze = 0;
    parama.wzi = 0;
    AppMethodBeat.o(14177);
  }
  
  public final void a(q paramq, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14180);
    b.a("BrandServiceWorkerThread", new f.4(this, paramq, paramInt1, paramInt2, paramInt3), 0L);
    AppMethodBeat.o(14180);
  }
  
  public final void a(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(14178);
    paramq = (f.a)this.jWA.get(Long.valueOf(paramq.field_msgId));
    if (paramq == null)
    {
      AppMethodBeat.o(14178);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramq.wyy = i;
      AppMethodBeat.o(14178);
      return;
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14182);
    int i = paramInt3;
    if (paramInt3 <= 0) {
      i = (int)(System.currentTimeMillis() / 1000L);
    }
    h.qsU.e(15721, new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.cnU), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(14182);
  }
  
  public final void c(q paramq, int paramInt)
  {
    AppMethodBeat.i(14175);
    b.a("BrandServiceWorkerThread", new f.1(this, paramq, paramInt, paramq.field_status, paramq.field_isRead), 0L);
    AppMethodBeat.o(14175);
  }
  
  public final void d(q paramq, int paramInt)
  {
    AppMethodBeat.i(14179);
    a(paramq, 0, paramInt, -1);
    AppMethodBeat.o(14179);
  }
  
  public final void sg(int paramInt)
  {
    AppMethodBeat.i(14181);
    a("", 0L, 0, paramInt, -1);
    AppMethodBeat.o(14181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f
 * JD-Core Version:    0.7.0.1
 */