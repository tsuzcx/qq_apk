package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean rxg;
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112163);
    paramContext = (String)g.afB().afk().get(6, null);
    if ((paramContext != null) && (paramContext.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.rxg = bool;
      ad.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", new Object[] { Boolean.valueOf(this.rxg) });
      AppMethodBeat.o(112163);
      return;
    }
  }
  
  private int[] cym()
  {
    AppMethodBeat.i(112165);
    ArrayList localArrayList = new ArrayList();
    if (this.rxg) {
      localArrayList.add(Integer.valueOf(16));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(112165);
    return arrayOfInt;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112164);
    String str = this.query;
    ArrayList localArrayList = new ArrayList();
    if (this.rxg)
    {
      localArrayList.add(Integer.valueOf(131073));
      localArrayList.add(Integer.valueOf(131074));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    paramap = j.a(str, arrayOfInt, cym(), -1, paramHashSet, com.tencent.mm.plugin.fts.a.c.b.rqn, this, paramap);
    paramap = ((n)g.ad(n.class)).search(9, paramap);
    AppMethodBeat.o(112164);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112167);
    int i = paramInt - parama.rqs - 1;
    Object localObject2 = null;
    Object localObject1;
    if ((i < parama.kLN.size()) && (i >= 0))
    {
      localObject1 = (m)parama.kLN.get(i);
      if ((((m)localObject1).type != 131073) && (((m)localObject1).type != 131074)) {
        break label177;
      }
    }
    label177:
    for (parama = ((com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(33, this.context, this.rqr, this.kme)).a(((m)localObject1).type, paramInt, (m)localObject1, parama);; parama = null)
    {
      localObject1 = parama;
      for (;;)
      {
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).rqB = (i + 1);
        }
        AppMethodBeat.o(112167);
        return localObject1;
        localObject1 = localObject2;
        if (!parama.rqt)
        {
          localObject1 = localObject2;
          if (paramInt == 0)
          {
            localObject1 = new com.tencent.mm.plugin.fts.ui.a.a(paramInt);
            ((com.tencent.mm.plugin.fts.ui.a.a)localObject1).roS = parama.roS;
          }
        }
      }
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112166);
    paramHashSet = paramk.rpQ;
    this.rsD.clear();
    e.a locala = new e.a();
    locala.businessType = -4;
    locala.rqt = false;
    locala.rqx = 1;
    locala.roS = paramk.roS;
    locala.kLN = new LinkedList();
    this.rsD.add(locala);
    if (dF(paramHashSet))
    {
      paramHashSet = d.a(paramHashSet, c.rnF);
      if (dF(paramHashSet))
      {
        locala = new e.a();
        locala.businessType = -11;
        locala.kLN = paramHashSet;
        locala.roS = paramk.roS;
        this.rsD.add(locala);
      }
    }
    AppMethodBeat.o(112166);
  }
  
  public final int getType()
  {
    return 8192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.a
 * JD-Core Version:    0.7.0.1
 */