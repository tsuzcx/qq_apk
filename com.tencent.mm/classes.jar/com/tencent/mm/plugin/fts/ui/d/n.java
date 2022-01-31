package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.os.Looper;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.s;
import com.tencent.mm.plugin.fts.ui.a.t;
import com.tencent.mm.plugin.fts.ui.c.c;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.dbe;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.LinkedList;

public final class n
  extends b
  implements f
{
  private int mTA;
  private int mTy;
  public long mVN;
  long mWI;
  long naI;
  private c naJ;
  private byi naK;
  private ak naL;
  String query;
  
  public n(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(152180);
    this.mTy = 2147483647;
    this.mTA = 2147483647;
    this.naL = new n.1(this, Looper.getMainLooper());
    AppMethodBeat.o(152180);
  }
  
  public final void a(String paramString, ak paramak, HashSet<String> paramHashSet, long paramLong)
  {
    AppMethodBeat.i(152181);
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWg, 0) == 0)
    {
      this.mTx.a(this, paramString);
      AppMethodBeat.o(152181);
      return;
    }
    this.query = paramString;
    if (this.naJ != null)
    {
      com.tencent.mm.kernel.g.Rc().a(this.naJ);
      com.tencent.mm.kernel.g.Rc().b(2599, this);
      this.naJ = null;
    }
    paramak = new byh();
    paramak.xHR = paramString;
    paramak.xIh = paramLong;
    paramak.xIm = e.mRk;
    paramak.xKE = true;
    paramak.xKD = 25L;
    this.naI = paramLong;
    paramString = aa.acv();
    if (paramString != null)
    {
      paramak.xKF = new dav();
      paramak.xKF.wDi = paramString.wDi;
      paramak.xKF.wDh = paramString.wDh;
    }
    this.naJ = new c(paramak);
    com.tencent.mm.kernel.g.Rc().a(2599, this);
    com.tencent.mm.kernel.g.Rc().a(this.naJ, 0);
    int i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWh, 500);
    this.mWI = System.currentTimeMillis();
    this.naL.removeMessages(1);
    paramString = this.naL.obtainMessage(1, Long.valueOf(paramLong));
    this.naL.sendMessageDelayed(paramString, i);
    AppMethodBeat.o(152181);
  }
  
  public final void bCd()
  {
    AppMethodBeat.i(152182);
    if (this.naJ != null)
    {
      com.tencent.mm.kernel.g.Rc().a(this.naJ);
      com.tencent.mm.kernel.g.Rc().b(2599, this);
      this.naJ = null;
    }
    this.naL.removeMessages(1);
    AppMethodBeat.o(152182);
  }
  
  public final LinkedList<Integer> bCe()
  {
    AppMethodBeat.i(152184);
    LinkedList localLinkedList = new LinkedList();
    if (this.mTy != 2147483647) {
      localLinkedList.add(Integer.valueOf(this.mTy));
    }
    AppMethodBeat.o(152184);
    return localLinkedList;
  }
  
  public final int bCf()
  {
    AppMethodBeat.i(152186);
    if (this.naK != null)
    {
      if (this.naK.wrp.size() > 0)
      {
        AppMethodBeat.o(152186);
        return 1;
      }
      AppMethodBeat.o(152186);
      return 0;
    }
    AppMethodBeat.o(152186);
    return 0;
  }
  
  public final long bCg()
  {
    return this.mVN;
  }
  
  public final void clearData()
  {
    this.naI = 0L;
    this.query = null;
    this.naK = null;
    this.mTy = 2147483647;
    this.mTA = 2147483647;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(152187);
    if (paramm.equals(this.naJ))
    {
      this.naL.removeMessages(1);
      this.mVN = System.currentTimeMillis();
      com.tencent.mm.kernel.g.Rc().b(2599, this);
      paramString = this.naJ.naE;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.naK = paramString;
        d.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "onSceneEnd Count %d TotalCount %d ContinueFlag %s SearchTime %d", new Object[] { Integer.valueOf(this.naK.jJu), Integer.valueOf(this.naK.jJU), Boolean.valueOf(this.naK.xKI), Long.valueOf(this.mVN - this.mWI) });
      }
      this.mTx.a(this, this.query);
    }
    AppMethodBeat.o(152187);
  }
  
  public final int wt(int paramInt)
  {
    AppMethodBeat.i(152183);
    int i;
    if ((this.naK != null) && (this.naK.wrp.size() > 0))
    {
      this.mTy = paramInt;
      i = paramInt + 1 + this.naK.wrp.size();
      if (this.naK.xKI)
      {
        this.mTA = i;
        i += 1;
      }
    }
    for (;;)
    {
      d.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "updateHeaderPosition curPos %d oriPos %d headerPosition %d morePosition %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.mTy), Integer.valueOf(this.mTA) });
      AppMethodBeat.o(152183);
      return i;
      this.mTA = 2147483647;
      continue;
      this.mTy = 2147483647;
      this.mTA = 2147483647;
      i = paramInt;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a wu(int paramInt)
  {
    AppMethodBeat.i(152185);
    Object localObject;
    if (paramInt == this.mTy) {
      localObject = new k(paramInt);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).lox = -20;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).ibk = this.ibk;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTH = false;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mRX = com.tencent.mm.plugin.fts.a.a.g.aU(this.query, false);
      }
      if (localObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        d.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "createDataItem position %d %s %d %d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(this.mTy), Integer.valueOf(this.mTA) });
        AppMethodBeat.o(152185);
        return localObject;
        if (paramInt == this.mTA)
        {
          localObject = new t(paramInt);
          ((t)localObject).nab = this.naK.xKG;
          break;
        }
        if (paramInt != this.mTy + 1) {
          break label204;
        }
        localObject = new s(paramInt);
        ((s)localObject).mZR = ((dbe)this.naK.wrp.get(0));
        ((s)localObject).mTP = true;
        ((s)localObject).mTJ = 1;
        break;
      }
      label204:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.n
 * JD-Core Version:    0.7.0.1
 */