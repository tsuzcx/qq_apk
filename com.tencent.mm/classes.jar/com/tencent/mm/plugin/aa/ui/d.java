package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends q
{
  private List<String> dSU;
  private ArrayList<String> jVT;
  
  public d(n paramn, ArrayList<String> paramArrayList)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63549);
    this.jVT = paramArrayList;
    and();
    AppMethodBeat.o(63549);
  }
  
  public final void and()
  {
    AppMethodBeat.i(63550);
    Log.i("MicroMsg.AASelectInitAdapter", "resetData");
    if (this.dSU == null) {
      this.dSU = new ArrayList();
    }
    this.dSU.clear();
    Iterator localIterator = this.jVT.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.dSU.add(str);
    }
    AppMethodBeat.o(63550);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63552);
    int i = this.dSU.size();
    AppMethodBeat.o(63552);
    return i;
  }
  
  public final a va(int paramInt)
  {
    AppMethodBeat.i(63551);
    Object localObject = (String)this.dSU.get(paramInt);
    g.aAi();
    as localas = ((l)g.af(l.class)).aSN().Kn((String)localObject);
    if ((localas != null) && (Util.isNullOrNil(localas.field_username))) {
      localas.setUsername((String)localObject);
    }
    localObject = new c(paramInt);
    ((a)localObject).contact = localas;
    ((a)localObject).PWh = true;
    AppMethodBeat.o(63551);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.d
 * JD-Core Version:    0.7.0.1
 */