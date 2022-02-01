package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean HCD;
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112163);
    paramContext = (String)h.baE().ban().d(6, null);
    if ((paramContext != null) && (paramContext.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.HCD = bool;
      Log.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", new Object[] { Boolean.valueOf(this.HCD) });
      AppMethodBeat.o(112163);
      return;
    }
  }
  
  private int[] fze()
  {
    AppMethodBeat.i(112165);
    ArrayList localArrayList = new ArrayList();
    if (this.HCD) {
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
  
  public final com.tencent.mm.plugin.fts.a.a.c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112164);
    String str = getQuery();
    ArrayList localArrayList = new ArrayList();
    if (this.HCD)
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
    paramMMHandler = l.a(str, arrayOfInt, fze(), -1, paramHashSet, b.Hue, this, paramMMHandler);
    paramMMHandler = ((n)h.az(n.class)).search(9, paramMMHandler);
    AppMethodBeat.o(112164);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112167);
    int i = paramInt - parama.Huj - 1;
    Object localObject2 = null;
    Object localObject1;
    if ((i < parama.tbH.size()) && (i >= 0))
    {
      localObject1 = (o)parama.tbH.get(i);
      if ((((o)localObject1).type != 131073) && (((o)localObject1).type != 131074)) {
        break label177;
      }
    }
    label177:
    for (parama = ((com.tencent.mm.plugin.fts.ui.a)((n)h.az(n.class)).createFTSUIUnit(33, getContext(), fxE(), fxF())).a(((o)localObject1).type, paramInt, (o)localObject1, parama);; parama = null)
    {
      localObject1 = parama;
      for (;;)
      {
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).Hur = (i + 1);
        }
        AppMethodBeat.o(112167);
        return localObject1;
        localObject1 = localObject2;
        if (!parama.Huk)
        {
          localObject1 = localObject2;
          if (paramInt == 0)
          {
            localObject1 = new com.tencent.mm.plugin.fts.ui.b.a(paramInt);
            ((com.tencent.mm.plugin.fts.ui.b.a)localObject1).FWt = parama.FWt;
          }
        }
      }
    }
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112166);
    paramHashSet = paramm.HtF;
    this.HwJ.clear();
    e.a locala = new e.a();
    locala.businessType = -4;
    locala.Huk = false;
    locala.Hun = 1;
    locala.FWt = paramm.FWt;
    locala.tbH = new LinkedList();
    this.HwJ.add(locala);
    if (hS(paramHashSet))
    {
      paramHashSet = d.b(paramHashSet, com.tencent.mm.plugin.fts.a.c.Hrq);
      if (hS(paramHashSet))
      {
        locala = new e.a();
        locala.businessType = -11;
        locala.tbH = paramHashSet;
        locala.FWt = paramm.FWt;
        this.HwJ.add(locala);
      }
    }
    AppMethodBeat.o(112166);
  }
  
  public final int getType()
  {
    return 8192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.a
 * JD-Core Version:    0.7.0.1
 */