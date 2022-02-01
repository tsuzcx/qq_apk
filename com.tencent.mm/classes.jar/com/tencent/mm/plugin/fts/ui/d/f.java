package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.d;
import com.tencent.mm.plugin.fts.ui.a.e;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f
  extends k
{
  public String BIN;
  public ah BNi;
  
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112184);
    this.BQU = false;
    paramHashSet = new j();
    paramHashSet.query = getQuery();
    paramHashSet.BIN = this.BIN;
    paramHashSet.BIU = this;
    paramHashSet.handler = paramMMHandler;
    paramHashSet.nRn = 3;
    paramMMHandler = ((n)h.ag(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112184);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112187);
    int i = paramInt - parama.BJz;
    if (parama.BJA) {
      i -= 1;
    }
    for (;;)
    {
      m localm = null;
      Object localObject = localm;
      if (i < parama.pWR.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (m)parama.pWR.get(i);
          if (!localm.BHS.equals("create_talker_message​")) {
            break label139;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJG = false;
          ((i)localObject).BIN = this.BIN;
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
        AppMethodBeat.o(112187);
        return localObject;
        label139:
        if (localm.BHS.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new d(i);
          ((d)localObject).olG = localm;
          ((d)localObject).BHY = parama.BHY;
          ((d)localObject).BNi = this.BNi;
          ((d)localObject).hx(localm.type, localm.BHR);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112185);
    paramHashSet = paramk.BIW;
    Object localObject;
    if (ff(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (m)paramHashSet.get(0);
        if (((m)localObject).BHS.equals("create_talker_message​"))
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
      paramk = new m();
      paramk.BHS = "no_result​";
      ((e.a)localObject).pWR = new ArrayList();
      ((e.a)localObject).pWR.add(paramk);
    }
    for (;;)
    {
      this.BLN.add(localObject);
      AppMethodBeat.o(112185);
      return;
      label213:
      ((e.a)localObject).pWR = paramHashSet;
    }
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112186);
    e locale = new e(paramInt);
    locale.talker = this.BIN;
    locale.count = parama.pWR.size();
    AppMethodBeat.o(112186);
    return locale;
  }
  
  public final int getType()
  {
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.f
 * JD-Core Version:    0.7.0.1
 */