package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends q
{
  private List<String> dAa;
  private ArrayList<String> iVv;
  
  public d(n paramn, ArrayList<String> paramArrayList)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63549);
    this.iVv = paramArrayList;
    Zh();
    AppMethodBeat.o(63549);
  }
  
  public final void Zh()
  {
    AppMethodBeat.i(63550);
    ad.i("MicroMsg.AASelectInitAdapter", "resetData");
    if (this.dAa == null) {
      this.dAa = new ArrayList();
    }
    this.dAa.clear();
    Iterator localIterator = this.iVv.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.dAa.add(str);
    }
    AppMethodBeat.o(63550);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63552);
    int i = this.dAa.size();
    AppMethodBeat.o(63552);
    return i;
  }
  
  public final a rh(int paramInt)
  {
    AppMethodBeat.i(63551);
    Object localObject = (String)this.dAa.get(paramInt);
    g.ajD();
    am localam = ((l)g.ab(l.class)).azp().Bf((String)localObject);
    if ((localam != null) && (bt.isNullOrNil(localam.field_username))) {
      localam.setUsername((String)localObject);
    }
    localObject = new c(paramInt);
    ((a)localObject).contact = localam;
    ((a)localObject).KmP = true;
    AppMethodBeat.o(63551);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.d
 * JD-Core Version:    0.7.0.1
 */