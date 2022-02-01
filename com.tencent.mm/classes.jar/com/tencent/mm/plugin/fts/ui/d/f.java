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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f
  extends k
{
  public String rpH;
  public w rtK;
  
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112184);
    this.rxh = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.rpH = this.rpH;
    paramHashSet.rpO = this;
    paramHashSet.handler = paramap;
    paramHashSet.iWB = 3;
    paramap = ((n)g.ad(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112184);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112187);
    int i = paramInt - parama.rqs;
    if (parama.rqt) {
      i -= 1;
    }
    for (;;)
    {
      m localm = null;
      Object localObject = localm;
      if (i < parama.kLN.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (m)parama.kLN.get(i);
          if (!localm.roN.equals("create_talker_message​")) {
            break label139;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqz = false;
          ((i)localObject).rpH = this.rpH;
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
        AppMethodBeat.o(112187);
        return localObject;
        label139:
        if (localm.roN.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new d(i);
          ((d)localObject).jpy = localm;
          ((d)localObject).roS = parama.roS;
          ((d)localObject).rtK = this.rtK;
          ((d)localObject).fI(localm.type, localm.roM);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112185);
    paramHashSet = paramk.rpQ;
    Object localObject;
    if (dF(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (m)paramHashSet.get(0);
        if (((m)localObject).roN.equals("create_talker_message​"))
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
      paramk = new m();
      paramk.roN = "no_result​";
      ((e.a)localObject).kLN = new ArrayList();
      ((e.a)localObject).kLN.add(paramk);
    }
    for (;;)
    {
      this.rsD.add(localObject);
      AppMethodBeat.o(112185);
      return;
      label213:
      ((e.a)localObject).kLN = paramHashSet;
    }
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112186);
    e locale = new e(paramInt);
    locale.talker = this.rpH;
    locale.count = parama.kLN.size();
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