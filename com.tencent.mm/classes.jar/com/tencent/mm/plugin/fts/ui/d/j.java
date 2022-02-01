package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.a.l;
import com.tencent.mm.sdk.platformtools.aq;
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
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112200);
    this.tNK = false;
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.query = this.query;
    localj.tFY = paramHashSet;
    localj.tGa = this;
    localj.handler = paramaq;
    paramaq = ((n)g.ad(n.class)).search(3, localj);
    AppMethodBeat.o(112200);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112202);
    int i = paramInt - parama.tGE;
    if (parama.tGF) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      if (i < parama.lPc.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lPc.get(i);
          if (!localm.tEY.equals("create_talker_message​")) {
            break label130;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGL = false;
          this.tNK = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGN = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tFe = parama.tFe;
        }
        AppMethodBeat.o(112202);
        return localObject;
        label130:
        if (localm.tEY.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).kno = localm;
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).gf(localm.type, localm.tEX);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112201);
    paramHashSet = paramk.tGc;
    Object localObject;
    if (dX(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramHashSet.get(0);
        if (((com.tencent.mm.plugin.fts.a.a.m)localObject).tEY.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.tGF = false;
          locala.lPc = new ArrayList();
          locala.lPc.add(localObject);
          locala.tFe = paramk.tFe;
          locala.businessType = -2;
          this.tIP.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).tFe = paramk.tFe;
      if (paramHashSet.size() != 0) {
        break label213;
      }
      ((e.a)localObject).tGF = false;
      paramk = new com.tencent.mm.plugin.fts.a.a.m();
      paramk.tEY = "no_result​";
      ((e.a)localObject).lPc = new ArrayList();
      ((e.a)localObject).lPc.add(paramk);
    }
    for (;;)
    {
      this.tIP.add(localObject);
      AppMethodBeat.o(112201);
      return;
      label213:
      ((e.a)localObject).lPc = paramHashSet;
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