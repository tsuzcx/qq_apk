package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.a.l;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class j
  extends k
{
  public j(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112200);
    this.sFZ = false;
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.query = this.query;
    localj.syG = paramHashSet;
    localj.syI = this;
    localj.handler = paramao;
    paramao = ((n)g.ad(n.class)).search(3, localj);
    AppMethodBeat.o(112200);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112202);
    int i = paramInt - parama.szm;
    if (parama.szn) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      if (i < parama.lnk.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lnk.get(i);
          if (!localm.sxG.equals("create_talker_message​")) {
            break label130;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szt = false;
          this.sFZ = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szv = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).sxM = parama.sxM;
        }
        AppMethodBeat.o(112202);
        return localObject;
        label130:
        if (localm.sxG.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).jPN = localm;
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).fP(localm.type, localm.sxF);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112201);
    paramHashSet = paramk.syK;
    Object localObject;
    if (dJ(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramHashSet.get(0);
        if (((com.tencent.mm.plugin.fts.a.a.m)localObject).sxG.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.szn = false;
          locala.lnk = new ArrayList();
          locala.lnk.add(localObject);
          locala.sxM = paramk.sxM;
          locala.businessType = -2;
          this.sBx.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).sxM = paramk.sxM;
      if (paramHashSet.size() != 0) {
        break label213;
      }
      ((e.a)localObject).szn = false;
      paramk = new com.tencent.mm.plugin.fts.a.a.m();
      paramk.sxG = "no_result​";
      ((e.a)localObject).lnk = new ArrayList();
      ((e.a)localObject).lnk.add(paramk);
    }
    for (;;)
    {
      this.sBx.add(localObject);
      AppMethodBeat.o(112201);
      return;
      label213:
      ((e.a)localObject).lnk = paramHashSet;
    }
  }
  
  public final int getType()
  {
    return 4176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.j
 * JD-Core Version:    0.7.0.1
 */