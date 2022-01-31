package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.c;
import com.tencent.mm.plugin.fts.ui.a.o;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l
  extends k
{
  public String kwZ;
  
  public l(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    this.kEo = false;
    paramHashSet = new i();
    paramHashSet.bVk = this.bVk;
    paramHashSet.kxe = e.kxH;
    paramHashSet.kwZ = this.kwZ;
    paramHashSet.kxf = this;
    paramHashSet.handler = paramah;
    paramHashSet.kwX = 10;
    return ((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).search(3, paramHashSet);
  }
  
  protected com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    p localp = null;
    if (parama.kxL) {}
    Object localObject;
    for (int i = paramInt - parama.kxK - 1;; i = paramInt - parama.kxK)
    {
      localObject = localp;
      if (i >= 0)
      {
        localObject = localp;
        if (i < parama.kxO.size())
        {
          localObject = (com.tencent.mm.plugin.fts.a.a.l)parama.kxO.get(i);
          if (!((com.tencent.mm.plugin.fts.a.a.l)localObject).kwg.equals("no_result​")) {
            break;
          }
          localObject = new com.tencent.mm.plugin.fts.ui.a.l(paramInt);
        }
      }
      return localObject;
    }
    localp = new p(paramInt);
    localp.fYx = ((com.tencent.mm.plugin.fts.a.a.l)localObject);
    localp.kCT = parama.kxQ;
    localp.kwi = localp.fYx.kwi;
    localp.kxU = -14;
    localp.showType = 2;
    localp.cU(((com.tencent.mm.plugin.fts.a.a.l)localObject).type, ((com.tencent.mm.plugin.fts.a.a.l)localObject).kwf);
    return localp;
  }
  
  protected final void a(j paramj, HashSet<String> paramHashSet)
  {
    switch (paramj.aYY)
    {
    default: 
      return;
    }
    if (paramj.kxh.size() > 0)
    {
      int i = 0;
      label39:
      if (i < paramj.kxh.size())
      {
        paramHashSet = new e.a();
        paramHashSet.kxL = true;
        paramHashSet.kxQ = ((com.tencent.mm.plugin.fts.a.a.l)paramj.kxh.get(i));
        paramHashSet.kwi = paramj.kwi;
        paramHashSet.kxO = ((List)paramHashSet.kxQ.userData);
        if ((paramHashSet.kxO.size() <= 3) || (i == paramj.kxh.size() - 1)) {
          break label160;
        }
        paramHashSet.kxP = true;
      }
      for (paramHashSet.kxN = true;; paramHashSet.kxN = false)
      {
        this.kzW.add(paramHashSet);
        i += 1;
        break label39;
        break;
        label160:
        paramHashSet.kxP = false;
      }
    }
    paramHashSet = new e.a();
    paramHashSet.businessType = -2;
    paramHashSet.kwi = paramj.kwi;
    paramHashSet.kxL = false;
    paramj = new com.tencent.mm.plugin.fts.a.a.l();
    paramj.kwg = "no_result​";
    paramHashSet.kxO = new ArrayList();
    paramHashSet.kxO.add(paramj);
    this.kzW.add(paramHashSet);
  }
  
  public final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    boolean bool = false;
    super.a(paramView, parama, paramBoolean);
    int i;
    if ((parama instanceof c)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.kzW.size())
      {
        paramView = (e.a)this.kzW.get(i);
        if (paramView.kxM == parama.position)
        {
          paramBoolean = bool;
          if (!paramView.kxP) {
            paramBoolean = true;
          }
          paramView.kxP = paramBoolean;
        }
      }
      else
      {
        return true;
      }
      i += 1;
    }
  }
  
  protected int aWv()
  {
    return 2;
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.k b(int paramInt, e.a parama)
  {
    o localo = new o(paramInt);
    localo.kCT = parama.kxQ;
    localo.kwi = localo.kCT.kwi;
    return localo;
  }
  
  protected final com.tencent.mm.plugin.fts.ui.a.n c(int paramInt, e.a parama)
  {
    c localc = new c(paramInt);
    localc.kCB = n.g.fts_header_message;
    localc.kCC = parama.kxP;
    return localc;
  }
  
  public int getType()
  {
    return 176;
  }
  
  public final int rx(int paramInt)
  {
    int k = this.kzW.size();
    int j = 0;
    if (j < k)
    {
      e.a locala = (e.a)this.kzW.get(j);
      locala.kxK = paramInt;
      int i = paramInt;
      if (locala.kxL) {
        i = paramInt + 1;
      }
      if (locala.kxO.size() > 3) {
        if (locala.kxP)
        {
          i += 3;
          label80:
          locala.kxM = i;
          paramInt = i;
          if (locala.kxN) {
            paramInt = i + 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i += locala.kxO.size();
        break label80;
        paramInt = i + locala.kxO.size();
        locala.kxM = paramInt;
      }
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.l
 * JD-Core Version:    0.7.0.1
 */