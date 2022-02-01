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
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f
  extends k
{
  public String tvc;
  public ab tzs;
  
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112184);
    this.tCT = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.tvc = this.tvc;
    paramHashSet.tvj = this;
    paramHashSet.handler = paramap;
    paramHashSet.jQN = 3;
    paramap = ((n)g.ad(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112184);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112187);
    int i = paramInt - parama.tvN;
    if (parama.tvO) {
      i -= 1;
    }
    for (;;)
    {
      m localm = null;
      Object localObject = localm;
      if (i < parama.lKC.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (m)parama.lKC.get(i);
          if (!localm.tuh.equals("create_talker_message​")) {
            break label139;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvU = false;
          ((i)localObject).tvc = this.tvc;
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
        AppMethodBeat.o(112187);
        return localObject;
        label139:
        if (localm.tuh.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new d(i);
          ((d)localObject).kjY = localm;
          ((d)localObject).tun = parama.tun;
          ((d)localObject).tzs = this.tzs;
          ((d)localObject).gf(localm.type, localm.tug);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112185);
    paramHashSet = paramk.tvl;
    Object localObject;
    if (dT(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (m)paramHashSet.get(0);
        if (((m)localObject).tuh.equals("create_talker_message​"))
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
      paramk = new m();
      paramk.tuh = "no_result​";
      ((e.a)localObject).lKC = new ArrayList();
      ((e.a)localObject).lKC.add(paramk);
    }
    for (;;)
    {
      this.txY.add(localObject);
      AppMethodBeat.o(112185);
      return;
      label213:
      ((e.a)localObject).lKC = paramHashSet;
    }
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112186);
    e locale = new e(paramInt);
    locale.talker = this.tvc;
    locale.count = parama.lKC.size();
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