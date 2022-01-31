package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean kEn;
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    paramContext = (String)g.DP().Dz().get(6, null);
    if ((paramContext != null) && (paramContext.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.kEn = bool;
      y.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", new Object[] { Boolean.valueOf(this.kEn) });
      return;
    }
  }
  
  private int[] aWu()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.kEn) {
      localArrayList.add(Integer.valueOf(16));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  protected final com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    String str = this.bVk;
    ArrayList localArrayList = new ArrayList();
    if (this.kEn)
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
    paramah = i.a(str, arrayOfInt, aWu(), -1, paramHashSet, com.tencent.mm.plugin.fts.a.c.b.kxE, this, paramah);
    return ((n)g.t(n.class)).search(9, paramah);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    int i = paramInt - parama.kxK - 1;
    Object localObject2 = null;
    Object localObject1;
    if ((i < parama.kxO.size()) && (i >= 0))
    {
      localObject1 = (l)parama.kxO.get(i);
      if ((((l)localObject1).type != 131073) && (((l)localObject1).type != 131074)) {
        break label167;
      }
    }
    label167:
    for (parama = ((com.tencent.mm.plugin.fts.ui.a)((n)g.t(n.class)).createFTSUIUnit(33, this.context, this.kxI, this.kxJ)).a(((l)localObject1).type, paramInt, (l)localObject1, parama);; parama = null)
    {
      localObject1 = parama;
      for (;;)
      {
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).kxW = (i + 1);
        }
        return localObject1;
        localObject1 = localObject2;
        if (!parama.kxL)
        {
          localObject1 = localObject2;
          if (paramInt == 0)
          {
            localObject1 = new com.tencent.mm.plugin.fts.ui.a.a(paramInt);
            ((com.tencent.mm.plugin.fts.ui.a.a)localObject1).kwi = parama.kwi;
          }
        }
      }
    }
  }
  
  protected final void a(j paramj, HashSet<String> paramHashSet)
  {
    paramHashSet = paramj.kxh;
    this.kzW.clear();
    e.a locala = new e.a();
    locala.businessType = -4;
    locala.kxL = false;
    locala.kxR = 1;
    locala.kwi = paramj.kwi;
    locala.kxO = new LinkedList();
    this.kzW.add(locala);
    if (bA(paramHashSet))
    {
      paramHashSet = d.a(paramHashSet, c.kvb);
      if (bA(paramHashSet))
      {
        locala = new e.a();
        locala.businessType = -11;
        locala.kxO = paramHashSet;
        locala.kwi = paramj.kwi;
        this.kzW.add(locala);
      }
    }
  }
  
  public final int getType()
  {
    return 8192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.a
 * JD-Core Version:    0.7.0.1
 */