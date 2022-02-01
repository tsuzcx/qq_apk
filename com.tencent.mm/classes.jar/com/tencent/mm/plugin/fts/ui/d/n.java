package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.s;
import com.tencent.mm.plugin.fts.ui.c.d;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.protocal.protobuf.fdw;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.fts.a.d.b
  implements i
{
  String query;
  private int wXD;
  private int wXF;
  public long wXS;
  long xaI;
  long xbf;
  private d xeM;
  private dsz xeN;
  private MMHandler xeO;
  
  public n(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112221);
    this.wXD = 2147483647;
    this.wXF = 2147483647;
    this.xeO = new MMHandler(Looper.getMainLooper())
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
          if (paramAnonymousMessage.obj.equals(Long.valueOf(n.this.xbf)))
          {
            n.this.wXS = System.currentTimeMillis();
            Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "cancel Time %d", new Object[] { Long.valueOf(n.this.wXS - n.this.xaI) });
            n.this.wXC.a(n.this, n.this.query);
            n.this.dOG();
            n.this.clearData();
          }
        }
      }
    };
    AppMethodBeat.o(112221);
  }
  
  public final List<com.tencent.mm.plugin.fts.a.a.c> GE(long paramLong)
  {
    AppMethodBeat.i(112230);
    ArrayList localArrayList = new ArrayList();
    if ((this.xeN != null) && (this.xeN.KKx.size() > 0)) {
      if (dOF() != 2) {
        break label239;
      }
    }
    label239:
    for (int i = 26;; i = 25)
    {
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (this.wXD + 1);
      localc.wVZ = (this.wXS - paramLong);
      localc.dUb = String.valueOf(((fei)this.xeN.KKx.get(0)).hashCode());
      localc.dUm = i;
      localc.wWb = ((fei)this.xeN.KKx.get(0)).MUT;
      localArrayList.add(localc);
      if (this.xeN.LYI)
      {
        localc = new com.tencent.mm.plugin.fts.a.a.c();
        localc.position = this.wXF;
        localc.wVZ = (this.wXS - paramLong);
        localc.dUb = String.valueOf(this.xeN.hashCode());
        localc.dUm = i;
        localc.wWb = ((fei)this.xeN.KKx.get(0)).MUT;
        localArrayList.add(localc);
      }
      AppMethodBeat.o(112230);
      return localArrayList;
    }
  }
  
  public final int Nn(int paramInt)
  {
    AppMethodBeat.i(112224);
    int i;
    if ((this.xeN != null) && (this.xeN.KKx.size() > 0))
    {
      this.wXD = paramInt;
      i = paramInt + 1 + this.xeN.KKx.size();
      if (this.xeN.LYI)
      {
        this.wXF = i;
        i += 1;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "updateHeaderPosition curPos %d oriPos %d headerPosition %d morePosition %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.wXD), Integer.valueOf(this.wXF) });
      AppMethodBeat.o(112224);
      return i;
      this.wXF = 2147483647;
      continue;
      this.wXD = 2147483647;
      this.wXF = 2147483647;
      i = paramInt;
    }
  }
  
  public final a No(int paramInt)
  {
    AppMethodBeat.i(112226);
    Object localObject;
    if (paramInt == this.wXD) {
      localObject = new k(paramInt);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((a)localObject).rjr = -20;
        ((a)localObject).mve = this.mve;
        ((a)localObject).wXK = false;
        ((a)localObject).wWd = h.bE(this.query, false);
      }
      if (localObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "createDataItem position %d %s %d %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(this.wXD), Integer.valueOf(this.wXF) });
        AppMethodBeat.o(112226);
        return localObject;
        if (paramInt == this.wXF)
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.t(paramInt);
          ((com.tencent.mm.plugin.fts.ui.a.t)localObject).xdP = ((fei)this.xeN.KKx.get(0));
          ((com.tencent.mm.plugin.fts.ui.a.t)localObject).xee = this.xeN.MVd;
          ((com.tencent.mm.plugin.fts.ui.a.t)localObject).wXT = true;
          ((com.tencent.mm.plugin.fts.ui.a.t)localObject).wXM = 2;
          break;
        }
        if (paramInt != this.wXD + 1) {
          break label229;
        }
        localObject = new s(paramInt);
        ((s)localObject).xdP = ((fei)this.xeN.KKx.get(0));
        ((s)localObject).wXT = true;
        ((s)localObject).wXM = 1;
        break;
      }
      label229:
      localObject = null;
    }
  }
  
  public final void a(String paramString, MMHandler paramMMHandler, HashSet<String> paramHashSet, long paramLong)
  {
    AppMethodBeat.i(112222);
    paramMMHandler = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
    paramHashSet = b.a.rZR;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (paramMMHandler.a(paramHashSet, com.tencent.mm.util.c.hdd()) == 0)
    {
      this.wXC.a(this, paramString);
      AppMethodBeat.o(112222);
      return;
    }
    this.query = paramString;
    if (this.xeM != null)
    {
      g.azz().a(this.xeM);
      g.azz().b(2599, this);
      this.xeM = null;
    }
    paramMMHandler = new dsy();
    paramMMHandler.KXA = paramString;
    paramMMHandler.MRu = paramLong;
    paramMMHandler.MRz = e.wVm;
    paramMMHandler.MVb = true;
    paramMMHandler.MVa = 25L;
    this.xbf = paramLong;
    paramString = ai.clJ();
    if (paramString != null)
    {
      paramMMHandler.MVc = new fdw();
      paramMMHandler.MVc.LbD = paramString.LbD;
      paramMMHandler.MVc.LbC = paramString.LbC;
    }
    this.xeM = new d(paramMMHandler);
    g.azz().a(2599, this);
    g.azz().a(this.xeM, 0);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZS, 500);
    this.xaI = System.currentTimeMillis();
    this.xeO.removeMessages(1);
    paramString = this.xeO.obtainMessage(1, Long.valueOf(paramLong));
    this.xeO.sendMessageDelayed(paramString, i);
    AppMethodBeat.o(112222);
  }
  
  public final void clearData()
  {
    this.xbf = 0L;
    this.query = null;
    this.xeN = null;
    this.wXD = 2147483647;
    this.wXF = 2147483647;
  }
  
  public final int dOF()
  {
    AppMethodBeat.i(112228);
    if ((this.xeN != null) && (this.xeN.KKx.size() > 0)) {
      try
      {
        boolean bool = "HOME".equals(new JSONObject(((fei)this.xeN.KKx.get(0)).NzC).optString("content_type", ""));
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
  
  public final void dOG()
  {
    AppMethodBeat.i(112223);
    if (this.xeM != null)
    {
      g.azz().a(this.xeM);
      g.azz().b(2599, this);
      this.xeM = null;
    }
    this.xeO.removeMessages(1);
    AppMethodBeat.o(112223);
  }
  
  public final LinkedList<Integer> dOH()
  {
    AppMethodBeat.i(112225);
    LinkedList localLinkedList = new LinkedList();
    if (this.wXD != 2147483647) {
      localLinkedList.add(Integer.valueOf(this.wXD));
    }
    AppMethodBeat.o(112225);
    return localLinkedList;
  }
  
  public final int dOI()
  {
    int i = 0;
    AppMethodBeat.i(112227);
    if (this.xeN != null)
    {
      if (this.xeN.KKx.size() > 0)
      {
        if (this.xeN.LYI) {
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
  
  public final long dOJ()
  {
    return this.wXS;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112229);
    if (paramq.equals(this.xeM))
    {
      this.xeO.removeMessages(1);
      this.wXS = System.currentTimeMillis();
      g.azz().b(2599, this);
      paramString = this.xeM.xeI;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.xeN = paramString;
        Log.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "onSceneEnd Count %d TotalCount %d ContinueFlag %s SearchTime %d", new Object[] { Integer.valueOf(this.xeN.oTz), Integer.valueOf(this.xeN.oTY), Boolean.valueOf(this.xeN.LYI), Long.valueOf(this.wXS - this.xaI) });
      }
      this.wXC.a(this, this.query);
    }
    AppMethodBeat.o(112229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.n
 * JD-Core Version:    0.7.0.1
 */