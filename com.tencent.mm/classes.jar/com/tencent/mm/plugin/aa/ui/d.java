package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends q
{
  private List<String> dom;
  private ArrayList<String> iCl;
  
  public d(n paramn, ArrayList<String> paramArrayList)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63549);
    this.iCl = paramArrayList;
    WN();
    AppMethodBeat.o(63549);
  }
  
  public final void WN()
  {
    AppMethodBeat.i(63550);
    ac.i("MicroMsg.AASelectInitAdapter", "resetData");
    if (this.dom == null) {
      this.dom = new ArrayList();
    }
    this.dom.clear();
    Iterator localIterator = this.iCl.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.dom.add(str);
    }
    AppMethodBeat.o(63550);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63552);
    int i = this.dom.size();
    AppMethodBeat.o(63552);
    return i;
  }
  
  public final a qH(int paramInt)
  {
    AppMethodBeat.i(63551);
    Object localObject = (String)this.dom.get(paramInt);
    g.agS();
    ai localai = ((k)g.ab(k.class)).awB().aNt((String)localObject);
    if ((localai != null) && (bs.isNullOrNil(localai.field_username))) {
      localai.setUsername((String)localObject);
    }
    localObject = new c(paramInt);
    ((a)localObject).contact = localai;
    ((a)localObject).Iwh = true;
    AppMethodBeat.o(63551);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.d
 * JD-Core Version:    0.7.0.1
 */