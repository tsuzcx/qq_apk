package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.d;
import com.tencent.mm.plugin.fts.ui.a.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f
  extends k
{
  public String mSN;
  public u mWV;
  
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62070);
    this.naH = false;
    paramHashSet = new com.tencent.mm.plugin.fts.a.a.i();
    paramHashSet.query = this.query;
    paramHashSet.mSN = this.mSN;
    paramHashSet.mSU = this;
    paramHashSet.handler = paramak;
    paramHashSet.hdl = 3;
    paramak = ((n)g.G(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(62070);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62073);
    int i = paramInt - parama.mTy;
    if (parama.mTz) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.l locall = null;
      Object localObject = locall;
      if (i < parama.mTC.size())
      {
        localObject = locall;
        if (i >= 0)
        {
          locall = (com.tencent.mm.plugin.fts.a.a.l)parama.mTC.get(i);
          if (!locall.mRV.equals("create_talker_message​")) {
            break label139;
          }
          localObject = new com.tencent.mm.plugin.fts.ui.a.i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTH = false;
          ((com.tencent.mm.plugin.fts.ui.a.i)localObject).mSN = this.mSN;
          this.naH = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mRX = parama.mRX;
        }
        AppMethodBeat.o(62073);
        return localObject;
        label139:
        if (locall.mRV.equals("no_result​"))
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.l(paramInt);
        }
        else
        {
          localObject = new d(i);
          ((d)localObject).hrL = locall;
          ((d)localObject).mRX = parama.mRX;
          ((d)localObject).mWV = this.mWV;
          ((d)localObject).es(locall.type, locall.mRU);
        }
      }
    }
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62071);
    paramHashSet = paramj.mSW;
    Object localObject;
    if (bU(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.l)paramHashSet.get(0);
        if (((com.tencent.mm.plugin.fts.a.a.l)localObject).mRV.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.mTz = false;
          locala.mTC = new ArrayList();
          locala.mTC.add(localObject);
          locala.mRX = paramj.mRX;
          locala.businessType = -2;
          this.mVO.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).mRX = paramj.mRX;
      if (paramHashSet.size() != 0) {
        break label213;
      }
      ((e.a)localObject).mTz = false;
      paramj = new com.tencent.mm.plugin.fts.a.a.l();
      paramj.mRV = "no_result​";
      ((e.a)localObject).mTC = new ArrayList();
      ((e.a)localObject).mTC.add(paramj);
    }
    for (;;)
    {
      this.mVO.add(localObject);
      AppMethodBeat.o(62071);
      return;
      label213:
      ((e.a)localObject).mTC = paramHashSet;
    }
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.k b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62072);
    e locale = new e(paramInt);
    locale.talker = this.mSN;
    locale.count = parama.mTC.size();
    AppMethodBeat.o(62072);
    return locale;
  }
  
  public final int getType()
  {
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.f
 * JD-Core Version:    0.7.0.1
 */