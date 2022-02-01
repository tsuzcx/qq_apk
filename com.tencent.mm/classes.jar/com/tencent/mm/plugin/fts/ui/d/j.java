package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.a.l;
import com.tencent.mm.sdk.platformtools.ap;
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
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112200);
    this.rxh = false;
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.query = this.query;
    localj.rpM = paramHashSet;
    localj.rpO = this;
    localj.handler = paramap;
    paramap = ((n)g.ad(n.class)).search(3, localj);
    AppMethodBeat.o(112200);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112202);
    int i = paramInt - parama.rqs;
    if (parama.rqt) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      if (i < parama.kLN.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.kLN.get(i);
          if (!localm.roN.equals("create_talker_message​")) {
            break label130;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqz = false;
          this.rxh = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqB = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).roS = parama.roS;
        }
        AppMethodBeat.o(112202);
        return localObject;
        label130:
        if (localm.roN.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).jpy = localm;
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).fI(localm.type, localm.roM);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112201);
    paramHashSet = paramk.rpQ;
    Object localObject;
    if (dF(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramHashSet.get(0);
        if (((com.tencent.mm.plugin.fts.a.a.m)localObject).roN.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.rqt = false;
          locala.kLN = new ArrayList();
          locala.kLN.add(localObject);
          locala.roS = paramk.roS;
          locala.businessType = -2;
          this.rsD.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).roS = paramk.roS;
      if (paramHashSet.size() != 0) {
        break label213;
      }
      ((e.a)localObject).rqt = false;
      paramk = new com.tencent.mm.plugin.fts.a.a.m();
      paramk.roN = "no_result​";
      ((e.a)localObject).kLN = new ArrayList();
      ((e.a)localObject).kLN.add(paramk);
    }
    for (;;)
    {
      this.rsD.add(localObject);
      AppMethodBeat.o(112201);
      return;
      label213:
      ((e.a)localObject).kLN = paramHashSet;
    }
  }
  
  public final int getType()
  {
    return 4176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.j
 * JD-Core Version:    0.7.0.1
 */