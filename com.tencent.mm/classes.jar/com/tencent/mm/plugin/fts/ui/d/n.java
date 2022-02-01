package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.s;
import com.tencent.mm.plugin.fts.ui.a.t;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.dvs;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.fts.a.d.b
  implements com.tencent.mm.al.g
{
  String query;
  public long rqH;
  private int rqs;
  private int rqu;
  long rty;
  long rxi;
  private com.tencent.mm.plugin.fts.ui.c.c rxj;
  private cok rxk;
  private ap rxl;
  
  public n(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112221);
    this.rqs = 2147483647;
    this.rqu = 2147483647;
    this.rxl = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(112220);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112220);
          return;
          if (paramAnonymousMessage.obj.equals(Long.valueOf(n.this.rxi)))
          {
            n.this.rqH = System.currentTimeMillis();
            ad.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "cancel Time %d", new Object[] { Long.valueOf(n.this.rqH - n.this.rty) });
            n.this.rqr.a(n.this, n.this.query);
            n.this.cxr();
            n.this.clearData();
          }
        }
      }
    };
    AppMethodBeat.o(112221);
  }
  
  public final int DF(int paramInt)
  {
    AppMethodBeat.i(112224);
    int i;
    if ((this.rxk != null) && (this.rxk.CAD.size() > 0))
    {
      this.rqs = paramInt;
      i = paramInt + 1 + this.rxk.CAD.size();
      if (this.rxk.Dwd)
      {
        this.rqu = i;
        i += 1;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "updateHeaderPosition curPos %d oriPos %d headerPosition %d morePosition %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.rqs), Integer.valueOf(this.rqu) });
      AppMethodBeat.o(112224);
      return i;
      this.rqu = 2147483647;
      continue;
      this.rqs = 2147483647;
      this.rqu = 2147483647;
      i = paramInt;
    }
  }
  
  public final a DG(int paramInt)
  {
    AppMethodBeat.i(112226);
    Object localObject;
    if (paramInt == this.rqs) {
      localObject = new k(paramInt);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((a)localObject).oEL = -20;
        ((a)localObject).kme = this.kme;
        ((a)localObject).rqz = false;
        ((a)localObject).roS = h.bc(this.query, false);
      }
      if (localObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "createDataItem position %d %s %d %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(this.rqs), Integer.valueOf(this.rqu) });
        AppMethodBeat.o(112226);
        return localObject;
        if (paramInt == this.rqu)
        {
          localObject = new t(paramInt);
          ((t)localObject).rwo = ((dwd)this.rxk.CAD.get(0));
          ((t)localObject).rwB = this.rxk.Eiq;
          ((t)localObject).rqI = true;
          ((t)localObject).rqB = 2;
          break;
        }
        if (paramInt != this.rqs + 1) {
          break label229;
        }
        localObject = new s(paramInt);
        ((s)localObject).rwo = ((dwd)this.rxk.CAD.get(0));
        ((s)localObject).rqI = true;
        ((s)localObject).rqB = 1;
        break;
      }
      label229:
      localObject = null;
    }
  }
  
  public final void a(String paramString, ap paramap, HashSet<String> paramHashSet, long paramLong)
  {
    AppMethodBeat.i(112222);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prb, com.tencent.mm.util.c.fgV()) == 0)
    {
      this.rqr.a(this, paramString);
      AppMethodBeat.o(112222);
      return;
    }
    this.query = paramString;
    if (this.rxj != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.rxj);
      com.tencent.mm.kernel.g.aeS().b(2599, this);
      this.rxj = null;
    }
    paramap = new coj();
    paramap.CLI = paramString;
    paramap.Efv = paramLong;
    paramap.EfA = e.rob;
    paramap.Eio = true;
    paramap.Ein = 25L;
    this.rxi = paramLong;
    paramString = aa.bCk();
    if (paramString != null)
    {
      paramap.Eip = new dvs();
      paramap.Eip.COJ = paramString.COJ;
      paramap.Eip.COI = paramString.COI;
    }
    this.rxj = new com.tencent.mm.plugin.fts.ui.c.c(paramap);
    com.tencent.mm.kernel.g.aeS().a(2599, this);
    com.tencent.mm.kernel.g.aeS().a(this.rxj, 0);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prc, 500);
    this.rty = System.currentTimeMillis();
    this.rxl.removeMessages(1);
    paramString = this.rxl.obtainMessage(1, Long.valueOf(paramLong));
    this.rxl.sendMessageDelayed(paramString, i);
    AppMethodBeat.o(112222);
  }
  
  public final void clearData()
  {
    this.rxi = 0L;
    this.query = null;
    this.rxk = null;
    this.rqs = 2147483647;
    this.rqu = 2147483647;
  }
  
  public final int cxq()
  {
    AppMethodBeat.i(112228);
    if ((this.rxk != null) && (this.rxk.CAD.size() > 0)) {
      try
      {
        boolean bool = "HOME".equals(new JSONObject(((dwd)this.rxk.CAD.get(0)).EJU).optString("content_type", ""));
        if (bool)
        {
          AppMethodBeat.o(112228);
          return 2;
        }
        AppMethodBeat.o(112228);
        return 1;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(112228);
    return 0;
  }
  
  public final void cxr()
  {
    AppMethodBeat.i(112223);
    if (this.rxj != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.rxj);
      com.tencent.mm.kernel.g.aeS().b(2599, this);
      this.rxj = null;
    }
    this.rxl.removeMessages(1);
    AppMethodBeat.o(112223);
  }
  
  public final LinkedList<Integer> cxs()
  {
    AppMethodBeat.i(112225);
    LinkedList localLinkedList = new LinkedList();
    if (this.rqs != 2147483647) {
      localLinkedList.add(Integer.valueOf(this.rqs));
    }
    AppMethodBeat.o(112225);
    return localLinkedList;
  }
  
  public final int cxt()
  {
    int i = 0;
    AppMethodBeat.i(112227);
    if (this.rxk != null)
    {
      if (this.rxk.CAD.size() > 0)
      {
        if (this.rxk.Dwd) {
          i = 1;
        }
        AppMethodBeat.o(112227);
        return i + 1;
      }
      AppMethodBeat.o(112227);
      return 0;
    }
    AppMethodBeat.o(112227);
    return 0;
  }
  
  public final long cxu()
  {
    return this.rqH;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(112229);
    if (paramn.equals(this.rxj))
    {
      this.rxl.removeMessages(1);
      this.rqH = System.currentTimeMillis();
      com.tencent.mm.kernel.g.aeS().b(2599, this);
      paramString = this.rxj.rxe;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.rxk = paramString;
        ad.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "onSceneEnd Count %d TotalCount %d ContinueFlag %s SearchTime %d", new Object[] { Integer.valueOf(this.rxk.mAK), Integer.valueOf(this.rxk.mBk), Boolean.valueOf(this.rxk.Dwd), Long.valueOf(this.rqH - this.rty) });
      }
      this.rqr.a(this, this.query);
    }
    AppMethodBeat.o(112229);
  }
  
  public final List<com.tencent.mm.plugin.fts.a.a.c> qR(long paramLong)
  {
    AppMethodBeat.i(112230);
    ArrayList localArrayList = new ArrayList();
    if ((this.rxk != null) && (this.rxk.CAD.size() > 0)) {
      if (cxq() != 2) {
        break label241;
      }
    }
    label241:
    for (int i = 26;; i = 25)
    {
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (this.rqs + 1);
      localc.roO = (this.rqH - paramLong);
      localc.drI = String.valueOf(((dwd)this.rxk.CAD.get(0)).hashCode());
      localc.drT = i;
      localc.roQ = ((dwd)this.rxk.CAD.get(0)).EJQ;
      localArrayList.add(localc);
      if (this.rxk.Dwd)
      {
        localc = new com.tencent.mm.plugin.fts.a.a.c();
        localc.position = this.rqu;
        localc.roO = (this.rqH - paramLong);
        localc.drI = String.valueOf(this.rxk.hashCode());
        localc.drT = i;
        localc.roQ = ((dwd)this.rxk.CAD.get(0)).EJQ;
        localArrayList.add(localc);
      }
      AppMethodBeat.o(112230);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.n
 * JD-Core Version:    0.7.0.1
 */