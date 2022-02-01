package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends q
{
  private List<String> dqB;
  private ArrayList<String> ice;
  
  public d(n paramn, ArrayList<String> paramArrayList)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63549);
    this.ice = paramArrayList;
    VP();
    AppMethodBeat.o(63549);
  }
  
  public final void VP()
  {
    AppMethodBeat.i(63550);
    ad.i("MicroMsg.AASelectInitAdapter", "resetData");
    if (this.dqB == null) {
      this.dqB = new ArrayList();
    }
    this.dqB.clear();
    Iterator localIterator = this.ice.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.dqB.add(str);
    }
    AppMethodBeat.o(63550);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63552);
    int i = this.dqB.size();
    AppMethodBeat.o(63552);
    return i;
  }
  
  public final a pU(int paramInt)
  {
    AppMethodBeat.i(63551);
    Object localObject = (String)this.dqB.get(paramInt);
    g.afC();
    af localaf = ((k)g.ab(k.class)).apM().aHY((String)localObject);
    if ((localaf != null) && (bt.isNullOrNil(localaf.field_username))) {
      localaf.setUsername((String)localObject);
    }
    localObject = new c(paramInt);
    ((a)localObject).contact = localaf;
    ((a)localObject).GVT = true;
    AppMethodBeat.o(63551);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.d
 * JD-Core Version:    0.7.0.1
 */