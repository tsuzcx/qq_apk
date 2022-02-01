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
    this.tCT = false;
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.query = this.query;
    localj.tvh = paramHashSet;
    localj.tvj = this;
    localj.handler = paramap;
    paramap = ((n)g.ad(n.class)).search(3, localj);
    AppMethodBeat.o(112200);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112202);
    int i = paramInt - parama.tvN;
    if (parama.tvO) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      if (i < parama.lKC.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lKC.get(i);
          if (!localm.tuh.equals("create_talker_message​")) {
            break label130;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvU = false;
          this.tCT = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvW = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tun = parama.tun;
        }
        AppMethodBeat.o(112202);
        return localObject;
        label130:
        if (localm.tuh.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).kjY = localm;
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).gf(localm.type, localm.tug);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112201);
    paramHashSet = paramk.tvl;
    Object localObject;
    if (dT(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramHashSet.get(0);
        if (((com.tencent.mm.plugin.fts.a.a.m)localObject).tuh.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.tvO = false;
          locala.lKC = new ArrayList();
          locala.lKC.add(localObject);
          locala.tun = paramk.tun;
          locala.businessType = -2;
          this.txY.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).tun = paramk.tun;
      if (paramHashSet.size() != 0) {
        break label213;
      }
      ((e.a)localObject).tvO = false;
      paramk = new com.tencent.mm.plugin.fts.a.a.m();
      paramk.tuh = "no_result​";
      ((e.a)localObject).lKC = new ArrayList();
      ((e.a)localObject).lKC.add(paramk);
    }
    for (;;)
    {
      this.txY.add(localObject);
      AppMethodBeat.o(112201);
      return;
      label213:
      ((e.a)localObject).lKC = paramHashSet;
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