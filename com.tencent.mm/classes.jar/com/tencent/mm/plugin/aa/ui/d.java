package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends q
{
  private List<String> dBf;
  private ArrayList<String> iYo;
  
  public d(n paramn, ArrayList<String> paramArrayList)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63549);
    this.iYo = paramArrayList;
    Zq();
    AppMethodBeat.o(63549);
  }
  
  public final void Zq()
  {
    AppMethodBeat.i(63550);
    ae.i("MicroMsg.AASelectInitAdapter", "resetData");
    if (this.dBf == null) {
      this.dBf = new ArrayList();
    }
    this.dBf.clear();
    Iterator localIterator = this.iYo.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.dBf.add(str);
    }
    AppMethodBeat.o(63550);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63552);
    int i = this.dBf.size();
    AppMethodBeat.o(63552);
    return i;
  }
  
  public final a rk(int paramInt)
  {
    AppMethodBeat.i(63551);
    Object localObject = (String)this.dBf.get(paramInt);
    g.ajS();
    an localan = ((l)g.ab(l.class)).azF().BH((String)localObject);
    if ((localan != null) && (bu.isNullOrNil(localan.field_username))) {
      localan.setUsername((String)localObject);
    }
    localObject = new c(paramInt);
    ((a)localObject).contact = localan;
    ((a)localObject).KJj = true;
    AppMethodBeat.o(63551);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.d
 * JD-Core Version:    0.7.0.1
 */