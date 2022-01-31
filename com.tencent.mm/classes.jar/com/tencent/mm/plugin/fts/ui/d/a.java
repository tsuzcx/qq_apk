package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean naG;
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(62051);
    paramContext = (String)g.RL().Ru().get(6, null);
    if ((paramContext != null) && (paramContext.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.naG = bool;
      ab.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", new Object[] { Boolean.valueOf(this.naG) });
      AppMethodBeat.o(62051);
      return;
    }
  }
  
  private int[] bDb()
  {
    AppMethodBeat.i(62053);
    ArrayList localArrayList = new ArrayList();
    if (this.naG) {
      localArrayList.add(Integer.valueOf(16));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(62053);
    return arrayOfInt;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62052);
    String str = this.query;
    ArrayList localArrayList = new ArrayList();
    if (this.naG)
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
    paramak = i.a(str, arrayOfInt, bDb(), -1, paramHashSet, com.tencent.mm.plugin.fts.a.c.b.mTt, this, paramak);
    paramak = ((n)g.G(n.class)).search(9, paramak);
    AppMethodBeat.o(62052);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62055);
    int i = paramInt - parama.mTy - 1;
    Object localObject2 = null;
    Object localObject1;
    if ((i < parama.mTC.size()) && (i >= 0))
    {
      localObject1 = (l)parama.mTC.get(i);
      if ((((l)localObject1).type != 131073) && (((l)localObject1).type != 131074)) {
        break label177;
      }
    }
    label177:
    for (parama = ((com.tencent.mm.plugin.fts.ui.a)((n)g.G(n.class)).createFTSUIUnit(33, this.context, this.mTx, this.ibk)).a(((l)localObject1).type, paramInt, (l)localObject1, parama);; parama = null)
    {
      localObject1 = parama;
      for (;;)
      {
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).mTJ = (i + 1);
        }
        AppMethodBeat.o(62055);
        return localObject1;
        localObject1 = localObject2;
        if (!parama.mTz)
        {
          localObject1 = localObject2;
          if (paramInt == 0)
          {
            localObject1 = new com.tencent.mm.plugin.fts.ui.a.a(paramInt);
            ((com.tencent.mm.plugin.fts.ui.a.a)localObject1).mRX = parama.mRX;
          }
        }
      }
    }
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62054);
    paramHashSet = paramj.mSW;
    this.mVO.clear();
    e.a locala = new e.a();
    locala.businessType = -4;
    locala.mTz = false;
    locala.mTF = 1;
    locala.mRX = paramj.mRX;
    locala.mTC = new LinkedList();
    this.mVO.add(locala);
    if (bU(paramHashSet))
    {
      paramHashSet = d.a(paramHashSet, c.mQO);
      if (bU(paramHashSet))
      {
        locala = new e.a();
        locala.businessType = -11;
        locala.mTC = paramHashSet;
        locala.mRX = paramj.mRX;
        this.mVO.add(locala);
      }
    }
    AppMethodBeat.o(62054);
  }
  
  public final int getType()
  {
    return 8192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.a
 * JD-Core Version:    0.7.0.1
 */