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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ae;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean sFY;
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112163);
    paramContext = (String)g.agR().agA().get(6, null);
    if ((paramContext != null) && (paramContext.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.sFY = bool;
      ac.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", new Object[] { Boolean.valueOf(this.sFY) });
      AppMethodBeat.o(112163);
      return;
    }
  }
  
  private int[] cLy()
  {
    AppMethodBeat.i(112165);
    ArrayList localArrayList = new ArrayList();
    if (this.sFY) {
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
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112164);
    String str = this.query;
    ArrayList localArrayList = new ArrayList();
    if (this.sFY)
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
    paramao = j.a(str, arrayOfInt, cLy(), -1, paramHashSet, com.tencent.mm.plugin.fts.a.c.b.szh, this, paramao);
    paramao = ((n)g.ad(n.class)).search(9, paramao);
    AppMethodBeat.o(112164);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112167);
    int i = paramInt - parama.szm - 1;
    Object localObject2 = null;
    Object localObject1;
    if ((i < parama.lnk.size()) && (i >= 0))
    {
      localObject1 = (m)parama.lnk.get(i);
      if ((((m)localObject1).type != 131073) && (((m)localObject1).type != 131074)) {
        break label177;
      }
    }
    label177:
    for (parama = ((com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(33, this.context, this.szl, this.kNw)).a(((m)localObject1).type, paramInt, (m)localObject1, parama);; parama = null)
    {
      localObject1 = parama;
      for (;;)
      {
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).szv = (i + 1);
        }
        AppMethodBeat.o(112167);
        return localObject1;
        localObject1 = localObject2;
        if (!parama.szn)
        {
          localObject1 = localObject2;
          if (paramInt == 0)
          {
            localObject1 = new com.tencent.mm.plugin.fts.ui.a.a(paramInt);
            ((com.tencent.mm.plugin.fts.ui.a.a)localObject1).sxM = parama.sxM;
          }
        }
      }
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112166);
    paramHashSet = paramk.syK;
    this.sBx.clear();
    e.a locala = new e.a();
    locala.businessType = -4;
    locala.szn = false;
    locala.szr = 1;
    locala.sxM = paramk.sxM;
    locala.lnk = new LinkedList();
    this.sBx.add(locala);
    if (dJ(paramHashSet))
    {
      paramHashSet = d.a(paramHashSet, c.swz);
      if (dJ(paramHashSet))
      {
        locala = new e.a();
        locala.businessType = -11;
        locala.lnk = paramHashSet;
        locala.sxM = paramk.sxM;
        this.sBx.add(locala);
      }
    }
    AppMethodBeat.o(112166);
  }
  
  public final int getType()
  {
    return 8192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.a
 * JD-Core Version:    0.7.0.1
 */