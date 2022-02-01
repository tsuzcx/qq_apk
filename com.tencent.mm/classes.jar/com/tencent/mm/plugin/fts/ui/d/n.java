package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.s;
import com.tencent.mm.plugin.fts.ui.a.t;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.eje;
import com.tencent.mm.protocal.protobuf.ejp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
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
  private int tGE;
  private int tGG;
  public long tGT;
  long tJJ;
  long tKg;
  private com.tencent.mm.plugin.fts.ui.c.c tNL;
  private czv tNM;
  private aq tNN;
  
  public n(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112221);
    this.tGE = 2147483647;
    this.tGG = 2147483647;
    this.tNN = new aq(Looper.getMainLooper())
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
          if (paramAnonymousMessage.obj.equals(Long.valueOf(n.this.tKg)))
          {
            n.this.tGT = System.currentTimeMillis();
            ae.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "cancel Time %d", new Object[] { Long.valueOf(n.this.tGT - n.this.tJJ) });
            n.this.tGD.a(n.this, n.this.query);
            n.this.cVx();
            n.this.clearData();
          }
        }
      }
    };
    AppMethodBeat.o(112221);
  }
  
  public final int Hn(int paramInt)
  {
    AppMethodBeat.i(112224);
    int i;
    if ((this.tNM != null) && (this.tNM.FQQ.size() > 0))
    {
      this.tGE = paramInt;
      i = paramInt + 1 + this.tNM.FQQ.size();
      if (this.tNM.GUq)
      {
        this.tGG = i;
        i += 1;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "updateHeaderPosition curPos %d oriPos %d headerPosition %d morePosition %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.tGE), Integer.valueOf(this.tGG) });
      AppMethodBeat.o(112224);
      return i;
      this.tGG = 2147483647;
      continue;
      this.tGE = 2147483647;
      this.tGG = 2147483647;
      i = paramInt;
    }
  }
  
  public final a Ho(int paramInt)
  {
    AppMethodBeat.i(112226);
    Object localObject;
    if (paramInt == this.tGE) {
      localObject = new k(paramInt);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((a)localObject).pSr = -20;
        ((a)localObject).lox = this.lox;
        ((a)localObject).tGL = false;
        ((a)localObject).tFe = h.bq(this.query, false);
      }
      if (localObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "createDataItem position %d %s %d %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(this.tGE), Integer.valueOf(this.tGG) });
        AppMethodBeat.o(112226);
        return localObject;
        if (paramInt == this.tGG)
        {
          localObject = new t(paramInt);
          ((t)localObject).tMP = ((ejp)this.tNM.FQQ.get(0));
          ((t)localObject).tNe = this.tNM.HJp;
          ((t)localObject).tGU = true;
          ((t)localObject).tGN = 2;
          break;
        }
        if (paramInt != this.tGE + 1) {
          break label229;
        }
        localObject = new s(paramInt);
        ((s)localObject).tMP = ((ejp)this.tNM.FQQ.get(0));
        ((s)localObject).tGU = true;
        ((s)localObject).tGN = 1;
        break;
      }
      label229:
      localObject = null;
    }
  }
  
  public final void a(String paramString, aq paramaq, HashSet<String> paramHashSet, long paramLong)
  {
    AppMethodBeat.i(112222);
    paramaq = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
    paramHashSet = b.a.qGA;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (paramaq.a(paramHashSet, com.tencent.mm.util.c.fSe()) == 0)
    {
      this.tGD.a(this, paramString);
      AppMethodBeat.o(112222);
      return;
    }
    this.query = paramString;
    if (this.tNL != null)
    {
      g.ajj().a(this.tNL);
      g.ajj().b(2599, this);
      this.tNL = null;
    }
    paramaq = new czu();
    paramaq.Gdj = paramString;
    paramaq.HGk = paramLong;
    paramaq.HGp = e.tEn;
    paramaq.HJn = true;
    paramaq.HJm = 25L;
    this.tKg = paramLong;
    paramString = ad.bOD();
    if (paramString != null)
    {
      paramaq.HJo = new eje();
      paramaq.HJo.Gha = paramString.Gha;
      paramaq.HJo.GgZ = paramString.GgZ;
    }
    this.tNL = new com.tencent.mm.plugin.fts.ui.c.c(paramaq);
    g.ajj().a(2599, this);
    g.ajj().a(this.tNL, 0);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGB, 500);
    this.tJJ = System.currentTimeMillis();
    this.tNN.removeMessages(1);
    paramString = this.tNN.obtainMessage(1, Long.valueOf(paramLong));
    this.tNN.sendMessageDelayed(paramString, i);
    AppMethodBeat.o(112222);
  }
  
  public final long cVA()
  {
    return this.tGT;
  }
  
  public final int cVw()
  {
    AppMethodBeat.i(112228);
    if ((this.tNM != null) && (this.tNM.FQQ.size() > 0)) {
      try
      {
        boolean bool = "HOME".equals(new JSONObject(((ejp)this.tNM.FQQ.get(0)).ImA).optString("content_type", ""));
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
  
  public final void cVx()
  {
    AppMethodBeat.i(112223);
    if (this.tNL != null)
    {
      g.ajj().a(this.tNL);
      g.ajj().b(2599, this);
      this.tNL = null;
    }
    this.tNN.removeMessages(1);
    AppMethodBeat.o(112223);
  }
  
  public final LinkedList<Integer> cVy()
  {
    AppMethodBeat.i(112225);
    LinkedList localLinkedList = new LinkedList();
    if (this.tGE != 2147483647) {
      localLinkedList.add(Integer.valueOf(this.tGE));
    }
    AppMethodBeat.o(112225);
    return localLinkedList;
  }
  
  public final int cVz()
  {
    int i = 0;
    AppMethodBeat.i(112227);
    if (this.tNM != null)
    {
      if (this.tNM.FQQ.size() > 0)
      {
        if (this.tNM.GUq) {
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
  
  public final void clearData()
  {
    this.tKg = 0L;
    this.query = null;
    this.tNM = null;
    this.tGE = 2147483647;
    this.tGG = 2147483647;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(112229);
    if (paramn.equals(this.tNL))
    {
      this.tNN.removeMessages(1);
      this.tGT = System.currentTimeMillis();
      g.ajj().b(2599, this);
      paramString = this.tNL.tNH;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.tNM = paramString;
        ae.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "onSceneEnd Count %d TotalCount %d ContinueFlag %s SearchTime %d", new Object[] { Integer.valueOf(this.tNM.nID), Integer.valueOf(this.tNM.nJd), Boolean.valueOf(this.tNM.GUq), Long.valueOf(this.tGT - this.tJJ) });
      }
      this.tGD.a(this, this.query);
    }
    AppMethodBeat.o(112229);
  }
  
  public final List<com.tencent.mm.plugin.fts.a.a.c> xU(long paramLong)
  {
    AppMethodBeat.i(112230);
    ArrayList localArrayList = new ArrayList();
    if ((this.tNM != null) && (this.tNM.FQQ.size() > 0)) {
      if (cVw() != 2) {
        break label241;
      }
    }
    label241:
    for (int i = 26;; i = 25)
    {
      com.tencent.mm.plugin.fts.a.a.c localc = new com.tencent.mm.plugin.fts.a.a.c();
      localc.position = (this.tGE + 1);
      localc.tFa = (this.tGT - paramLong);
      localc.dCl = String.valueOf(((ejp)this.tNM.FQQ.get(0)).hashCode());
      localc.dCw = i;
      localc.tFc = ((ejp)this.tNM.FQQ.get(0)).Imw;
      localArrayList.add(localc);
      if (this.tNM.GUq)
      {
        localc = new com.tencent.mm.plugin.fts.a.a.c();
        localc.position = this.tGG;
        localc.tFa = (this.tGT - paramLong);
        localc.dCl = String.valueOf(this.tNM.hashCode());
        localc.dCw = i;
        localc.tFc = ((ejp)this.tNM.FQQ.get(0)).Imw;
        localArrayList.add(localc);
      }
      AppMethodBeat.o(112230);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.n
 * JD-Core Version:    0.7.0.1
 */