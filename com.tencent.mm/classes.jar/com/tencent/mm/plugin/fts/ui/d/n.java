package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.s;
import com.tencent.mm.plugin.fts.ui.a.t;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.ehn;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.fts.a.d.b
  implements f
{
  String query;
  private com.tencent.mm.plugin.fts.ui.c.c tCU;
  private czb tCV;
  private ap tCW;
  private int tvN;
  private int tvP;
  public long twc;
  long tyS;
  long tzp;
  
  public n(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112221);
    this.tvN = 2147483647;
    this.tvP = 2147483647;
    this.tCW = new ap(Looper.getMainLooper())
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
          if (paramAnonymousMessage.obj.equals(Long.valueOf(n.this.tzp)))
          {
            n.this.twc = System.currentTimeMillis();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "cancel Time %d", new Object[] { Long.valueOf(n.this.twc - n.this.tyS) });
            n.this.tvM.a(n.this, n.this.query);
            n.this.cSS();
            n.this.clearData();
          }
        }
      }
    };
    AppMethodBeat.o(112221);
  }
  
  public final int GQ(int paramInt)
  {
    AppMethodBeat.i(112224);
    int i;
    if ((this.tCV != null) && (this.tCV.Fys.size() > 0))
    {
      this.tvN = paramInt;
      i = paramInt + 1 + this.tCV.Fys.size();
      if (this.tCV.GAQ)
      {
        this.tvP = i;
        i += 1;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "updateHeaderPosition curPos %d oriPos %d headerPosition %d morePosition %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.tvN), Integer.valueOf(this.tvP) });
      AppMethodBeat.o(112224);
      return i;
      this.tvP = 2147483647;
      continue;
      this.tvN = 2147483647;
      this.tvP = 2147483647;
      i = paramInt;
    }
  }
  
  public final a GR(int paramInt)
  {
    AppMethodBeat.i(112226);
    Object localObject;
    if (paramInt == this.tvN) {
      localObject = new k(paramInt);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((a)localObject).pLM = -20;
        ((a)localObject).ljZ = this.ljZ;
        ((a)localObject).tvU = false;
        ((a)localObject).tun = h.bn(this.query, false);
      }
      if (localObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "createDataItem position %d %s %d %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(this.tvN), Integer.valueOf(this.tvP) });
        AppMethodBeat.o(112226);
        return localObject;
        if (paramInt == this.tvP)
        {
          localObject = new t(paramInt);
          ((t)localObject).tBY = ((ehy)this.tCV.Fys.get(0));
          ((t)localObject).tCn = this.tCV.HpN;
          ((t)localObject).twd = true;
          ((t)localObject).tvW = 2;
          break;
        }
        if (paramInt != this.tvN + 1) {
          break label229;
        }
        localObject = new s(paramInt);
        ((s)localObject).tBY = ((ehy)this.tCV.Fys.get(0));
        ((s)localObject).twd = true;
        ((s)localObject).tvW = 1;
        break;
      }
      label229:
      localObject = null;
    }
  }
  
  public final void a(String paramString, ap paramap, HashSet<String> paramHashSet, long paramLong)
  {
    AppMethodBeat.i(112222);
    paramap = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
    paramHashSet = b.a.qzu;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (paramap.a(paramHashSet, com.tencent.mm.util.c.fNJ()) == 0)
    {
      this.tvM.a(this, paramString);
      AppMethodBeat.o(112222);
      return;
    }
    this.query = paramString;
    if (this.tCU != null)
    {
      g.aiU().a(this.tCU);
      g.aiU().b(2599, this);
      this.tCU = null;
    }
    paramap = new cza();
    paramap.FKK = paramString;
    paramap.HmK = paramLong;
    paramap.HmP = e.ttw;
    paramap.HpL = true;
    paramap.HpK = 25L;
    this.tzp = paramLong;
    paramString = com.tencent.mm.plugin.websearch.api.ad.bNG();
    if (paramString != null)
    {
      paramap.HpM = new ehn();
      paramap.HpM.FOB = paramString.FOB;
      paramap.HpM.FOA = paramString.FOA;
    }
    this.tCU = new com.tencent.mm.plugin.fts.ui.c.c(paramap);
    g.aiU().a(2599, this);
    g.aiU().a(this.tCU, 0);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzv, 500);
    this.tyS = System.currentTimeMillis();
    this.tCW.removeMessages(1);
    paramString = this.tCW.obtainMessage(1, Long.valueOf(paramLong));
    this.tCW.sendMessageDelayed(paramString, i);
    AppMethodBeat.o(112222);
  }
  
  public final int cSR()
  {
    AppMethodBeat.i(112228);
    if ((this.tCV != null) && (this.tCV.Fys.size() > 0)) {
      try
      {
        boolean bool = "HOME".equals(new JSONObject(((ehy)this.tCV.Fys.get(0)).HSt).optString("content_type", ""));
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
  
  public final void cSS()
  {
    AppMethodBeat.i(112223);
    if (this.tCU != null)
    {
      g.aiU().a(this.tCU);
      g.aiU().b(2599, this);
      this.tCU = null;
    }
    this.tCW.removeMessages(1);
    AppMethodBeat.o(112223);
  }
  
  public final LinkedList<Integer> cST()
  {
    AppMethodBeat.i(112225);
    LinkedList localLinkedList = new LinkedList();
    if (this.tvN != 2147483647) {
      localLinkedList.add(Integer.valueOf(this.tvN));
    }
    AppMethodBeat.o(112225);
    return localLinkedList;
  }
  
  public final int cSU()
  {
    int i = 0;
    AppMethodBeat.i(112227);
    if (this.tCV != null)
    {
      if (this.tCV.Fys.size() > 0)
      {
        if (this.tCV.GAQ) {
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
  
  public final long cSV()
  {
    return this.twc;
  }
  
  public final void clearData()
  {
    this.tzp = 0L;
    this.query = null;
    this.tCV = null;
    this.tvN = 2147483647;
    this.tvP = 2147483647;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(112229);
    if (paramn.equals(this.tCU))
    {
      this.tCW.removeMessages(1);
      this.twc = System.currentTimeMillis();
      g.aiU().b(2599, this);
      paramString = this.tCU.tCQ;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.tCV = paramString;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "onSceneEnd Count %d TotalCount %d ContinueFlag %s SearchTime %d", new Object[] { Integer.valueOf(this.tCV.nDi), Integer.valueOf(this.tCV.nDI), Boolean.valueOf(this.tCV.GAQ), Long.valueOf(this.twc - this.tyS) });
      }
      this.tvM.a(this, this.query);
    }
    AppMethodBeat.o(112229);
  }
  
  public final List<com.tencent.mm.plugin.fts.a.a.c> xA(long paramLong)
  {
    AppMethodBeat.i(112230);
    ArrayList localArrayList = new ArrayList();
    if ((this.tCV != null) && (this.tCV.Fys.size() > 0)) {
      if (cSR() != 2) {
        break label241;
      }
    }
    label241:
    for (int i = 26;; i = 25)
    {
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (this.tvN + 1);
      localc.tuj = (this.twc - paramLong);
      localc.dBg = String.valueOf(((ehy)this.tCV.Fys.get(0)).hashCode());
      localc.dBr = i;
      localc.tul = ((ehy)this.tCV.Fys.get(0)).HSp;
      localArrayList.add(localc);
      if (this.tCV.GAQ)
      {
        localc = new com.tencent.mm.plugin.fts.a.a.c();
        localc.position = this.tvP;
        localc.tuj = (this.twc - paramLong);
        localc.dBg = String.valueOf(this.tCV.hashCode());
        localc.dBr = i;
        localc.tul = ((ehy)this.tCV.Fys.get(0)).HSp;
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