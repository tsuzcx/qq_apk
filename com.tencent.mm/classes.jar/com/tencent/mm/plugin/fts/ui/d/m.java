package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class m
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean naG;
  
  public m(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(62099);
    this.naG = false;
    paramb = (String)g.RL().Ru().get(6, null);
    if ((paramb != null) && (paramb.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.naG = bool;
      this.naG &= bo.hl(paramContext);
      AppMethodBeat.o(62099);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62100);
    i locali = new i();
    int[] arrayOfInt;
    if (this.naG)
    {
      arrayOfInt = new int[6];
      int[] tmp27_26 = arrayOfInt;
      tmp27_26[0] = 131072;
      int[] tmp32_27 = tmp27_26;
      tmp32_27[1] = 131075;
      int[] tmp37_32 = tmp32_27;
      tmp37_32[2] = 131073;
      int[] tmp42_37 = tmp37_32;
      tmp42_37[3] = 131074;
      int[] tmp47_42 = tmp42_37;
      tmp47_42[4] = 262144;
      int[] tmp52_47 = tmp47_42;
      tmp52_47[5] = 131076;
      tmp52_47;
    }
    for (;;)
    {
      locali.mSP = arrayOfInt;
      locali.mSR = 3;
      locali.mSU = this;
      locali.handler = paramak;
      locali.scene = 0;
      locali.mSS = paramHashSet;
      if (!this.query.startsWith("@@")) {
        break;
      }
      locali.query = this.query.substring(2);
      paramak = ((n)g.G(n.class)).search(10000, locali);
      AppMethodBeat.o(62100);
      return paramak;
      arrayOfInt = new int[4];
      int[] tmp150_149 = arrayOfInt;
      tmp150_149[0] = 131072;
      int[] tmp155_150 = tmp150_149;
      tmp155_150[1] = 131075;
      int[] tmp160_155 = tmp155_150;
      tmp160_155[2] = 262144;
      int[] tmp165_160 = tmp160_155;
      tmp165_160[3] = 131076;
      tmp165_160;
    }
    locali.query = this.query;
    paramak = ((n)g.G(n.class)).search(1, locali);
    AppMethodBeat.o(62100);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62102);
    int i = paramInt - parama.mTy - 1;
    l locall;
    Object localObject;
    if ((i < parama.mTC.size()) && (i >= 0))
    {
      locall = (l)parama.mTC.get(i);
      if (locall.type == 131075) {
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.G(n.class)).createFTSUIUnit(48, this.context, this.mTx, this.ibk);
      }
    }
    for (;;)
    {
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.fts.ui.a)localObject).a(locall.type, paramInt, locall, parama);; localObject = null)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
          if (i == parama.mTC.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTH = false;
          }
        }
        AppMethodBeat.o(62102);
        return localObject;
        if ((locall.type == 131072) || (locall.type == 131073) || (locall.type == 131074))
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.G(n.class)).createFTSUIUnit(32, this.context, this.mTx, this.ibk);
          break;
        }
        if (locall.type == 262144)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.G(n.class)).createFTSUIUnit(64, this.context, this.mTx, this.ibk);
          break;
        }
        if (locall.type != 131076) {
          break label312;
        }
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.G(n.class)).createFTSUIUnit(96, this.context, this.mTx, this.ibk);
        break;
      }
      label312:
      localObject = null;
    }
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62101);
    Iterator localIterator = paramj.mSW.iterator();
    while (localIterator.hasNext()) {
      paramHashSet.add(((l)localIterator.next()).mRV);
    }
    if (bU(paramj.mSW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -8;
      paramHashSet.mTC = bV(paramj.mSW);
      paramHashSet.mTB = false;
      paramHashSet.mRX = paramj.mRX;
      this.mVO.add(paramHashSet);
    }
    d.bT(paramj.mSW);
    AppMethodBeat.o(62101);
  }
  
  public final int getType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.m
 * JD-Core Version:    0.7.0.1
 */