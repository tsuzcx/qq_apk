package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
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
    this.BQU = false;
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.query = getQuery();
    localj.BIS = paramHashSet;
    localj.BIU = this;
    localj.handler = paramMMHandler;
    paramMMHandler = ((n)h.ag(n.class)).search(3, localj);
    AppMethodBeat.o(112200);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112202);
    int i = paramInt - parama.BJz;
    if (parama.BJA) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.m localm = null;
      Object localObject = localm;
      if (i < parama.pWR.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (com.tencent.mm.plugin.fts.a.a.m)parama.pWR.get(i);
          if (!localm.BHS.equals("create_talker_message​")) {
            break label130;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJG = false;
          this.BQU = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJI = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BHY = parama.BHY;
        }
        AppMethodBeat.o(112202);
        return localObject;
        label130:
        if (localm.BHS.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.m(paramInt);
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).olG = localm;
          ((com.tencent.mm.plugin.fts.ui.a.m)localObject).hx(localm.type, localm.BHR);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112201);
    paramHashSet = paramk.BIW;
    Object localObject;
    if (ff(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramHashSet.get(0);
        if (((com.tencent.mm.plugin.fts.a.a.m)localObject).BHS.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.BJA = false;
          locala.pWR = new ArrayList();
          locala.pWR.add(localObject);
          locala.BHY = paramk.BHY;
          locala.businessType = -2;
          this.BLN.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).BHY = paramk.BHY;
      if (paramHashSet.size() != 0) {
        break label213;
      }
      ((e.a)localObject).BJA = false;
      paramk = new com.tencent.mm.plugin.fts.a.a.m();
      paramk.BHS = "no_result​";
      ((e.a)localObject).pWR = new ArrayList();
      ((e.a)localObject).pWR.add(paramk);
    }
    for (;;)
    {
      this.BLN.add(localObject);
      AppMethodBeat.o(112201);
      return;
      label213:
      ((e.a)localObject).pWR = paramHashSet;
    }
  }
  
  public final int getType()
  {
    return 4176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.j
 * JD-Core Version:    0.7.0.1
 */