package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class d
  extends com.tencent.mm.plugin.fts.ui.a
{
  public d(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112176);
    j localj = new j();
    localj.query = getQuery();
    localj.BIP = new int[] { 131072, 131081 };
    localj.BIT = b.BJu;
    localj.BIS = paramHashSet;
    localj.BIU = this;
    localj.handler = paramMMHandler;
    localj.nRn = 16;
    paramMMHandler = ((n)h.ag(n.class)).search(2, localj);
    AppMethodBeat.o(112176);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112178);
    int i = paramInt - parama.BJz - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.pWR.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.pWR.get(i);
        localObject = new r(paramInt);
        ((r)localObject).olG = localm;
        ((r)localObject).BHY = parama.BHY;
        ((r)localObject).hx(localm.type, localm.BHR);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJI = (i + 1);
    }
    AppMethodBeat.o(112178);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112177);
    if (ff(paramk.BIW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -4;
      paramHashSet.pWR = paramk.BIW;
      paramHashSet.BHY = paramk.BHY;
      paramHashSet.xcp = false;
      this.BLN.add(paramHashSet);
    }
    AppMethodBeat.o(112177);
  }
  
  public final int getType()
  {
    return 4112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.d
 * JD-Core Version:    0.7.0.1
 */