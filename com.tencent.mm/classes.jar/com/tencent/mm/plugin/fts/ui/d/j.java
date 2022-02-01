package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
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
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112200);
    this.xeL = false;
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.query = this.query;
    localj.wWX = paramHashSet;
    localj.wWZ = this;
    localj.handler = paramMMHandler;
    paramMMHandler = ((n)g.ah(n.class)).search(3, localj);
    AppMethodBeat.o(112200);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112202);
    int i = paramInt - parama.wXD;
    if (parama.wXE) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      if (i < parama.mWl.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.mWl.get(i);
          if (!localm.wVX.equals("create_talker_message​")) {
            break label130;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXK = false;
          this.xeL = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXM = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wWd = parama.wWd;
        }
        AppMethodBeat.o(112202);
        return localObject;
        label130:
        if (localm.wVX.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).lqW = localm;
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).gE(localm.type, localm.wVW);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112201);
    paramHashSet = paramk.wXb;
    Object localObject;
    if (eP(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramHashSet.get(0);
        if (((com.tencent.mm.plugin.fts.a.a.m)localObject).wVX.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.wXE = false;
          locala.mWl = new ArrayList();
          locala.mWl.add(localObject);
          locala.wWd = paramk.wWd;
          locala.businessType = -2;
          this.wZO.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).wWd = paramk.wWd;
      if (paramHashSet.size() != 0) {
        break label213;
      }
      ((e.a)localObject).wXE = false;
      paramk = new com.tencent.mm.plugin.fts.a.a.m();
      paramk.wVX = "no_result​";
      ((e.a)localObject).mWl = new ArrayList();
      ((e.a)localObject).mWl.add(paramk);
    }
    for (;;)
    {
      this.wZO.add(localObject);
      AppMethodBeat.o(112201);
      return;
      label213:
      ((e.a)localObject).mWl = paramHashSet;
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