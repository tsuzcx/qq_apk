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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ac;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f
  extends k
{
  public String tFT;
  public ac tKj;
  
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112184);
    this.tNK = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.tFT = this.tFT;
    paramHashSet.tGa = this;
    paramHashSet.handler = paramaq;
    paramHashSet.jUf = 3;
    paramaq = ((n)g.ad(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112184);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112187);
    int i = paramInt - parama.tGE;
    if (parama.tGF) {
      i -= 1;
    }
    for (;;)
    {
      m localm = null;
      Object localObject = localm;
      if (i < parama.lPc.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (m)parama.lPc.get(i);
          if (!localm.tEY.equals("create_talker_message​")) {
            break label139;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGL = false;
          ((i)localObject).tFT = this.tFT;
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
        AppMethodBeat.o(112187);
        return localObject;
        label139:
        if (localm.tEY.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new d(i);
          ((d)localObject).kno = localm;
          ((d)localObject).tFe = parama.tFe;
          ((d)localObject).tKj = this.tKj;
          ((d)localObject).gf(localm.type, localm.tEX);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112185);
    paramHashSet = paramk.tGc;
    Object localObject;
    if (dX(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (m)paramHashSet.get(0);
        if (((m)localObject).tEY.equals("create_talker_message​"))
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
      paramk = new m();
      paramk.tEY = "no_result​";
      ((e.a)localObject).lPc = new ArrayList();
      ((e.a)localObject).lPc.add(paramk);
    }
    for (;;)
    {
      this.tIP.add(localObject);
      AppMethodBeat.o(112185);
      return;
      label213:
      ((e.a)localObject).lPc = paramHashSet;
    }
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112186);
    e locale = new e(paramInt);
    locale.talker = this.tFT;
    locale.count = parama.lPc.size();
    AppMethodBeat.o(112186);
    return locale;
  }
  
  public final int getType()
  {
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.f
 * JD-Core Version:    0.7.0.1
 */