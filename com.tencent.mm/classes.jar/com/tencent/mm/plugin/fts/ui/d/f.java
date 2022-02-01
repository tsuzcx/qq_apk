package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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
  public String wWS;
  public ah xbi;
  
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112184);
    this.xeL = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.wWS = this.wWS;
    paramHashSet.wWZ = this;
    paramHashSet.handler = paramMMHandler;
    paramHashSet.kXb = 3;
    paramMMHandler = ((n)g.ah(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112184);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112187);
    int i = paramInt - parama.wXD;
    if (parama.wXE) {
      i -= 1;
    }
    for (;;)
    {
      m localm = null;
      Object localObject = localm;
      if (i < parama.mWl.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (m)parama.mWl.get(i);
          if (!localm.wVX.equals("create_talker_message​")) {
            break label139;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXK = false;
          ((i)localObject).wWS = this.wWS;
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
        AppMethodBeat.o(112187);
        return localObject;
        label139:
        if (localm.wVX.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new d(i);
          ((d)localObject).lqW = localm;
          ((d)localObject).wWd = parama.wWd;
          ((d)localObject).xbi = this.xbi;
          ((d)localObject).gE(localm.type, localm.wVW);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112185);
    paramHashSet = paramk.wXb;
    Object localObject;
    if (eP(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (m)paramHashSet.get(0);
        if (((m)localObject).wVX.equals("create_talker_message​"))
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
      paramk = new m();
      paramk.wVX = "no_result​";
      ((e.a)localObject).mWl = new ArrayList();
      ((e.a)localObject).mWl.add(paramk);
    }
    for (;;)
    {
      this.wZO.add(localObject);
      AppMethodBeat.o(112185);
      return;
      label213:
      ((e.a)localObject).mWl = paramHashSet;
    }
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112186);
    e locale = new e(paramInt);
    locale.talker = this.wWS;
    locale.count = parama.mWl.size();
    AppMethodBeat.o(112186);
    return locale;
  }
  
  public final int getType()
  {
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.f
 * JD-Core Version:    0.7.0.1
 */