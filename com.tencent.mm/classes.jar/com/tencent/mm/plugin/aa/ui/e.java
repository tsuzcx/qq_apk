package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends q
{
  private String chatroomName;
  private List<String> iYA;
  
  public e(n paramn, String paramString)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63553);
    this.chatroomName = paramString;
    Zq();
    AppMethodBeat.o(63553);
  }
  
  private void aRZ()
  {
    AppMethodBeat.i(189741);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.iYA != null) && (this.iYA.size() > 0))
    {
      Iterator localIterator = this.iYA.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (an.aUq(str)) {
          localArrayList1.add(str);
        } else {
          localArrayList2.add(str);
        }
      }
      if (localArrayList1.size() > 0)
      {
        this.iYA.clear();
        this.iYA.addAll(localArrayList2);
        this.iYA.addAll(localArrayList1);
      }
    }
    AppMethodBeat.o(189741);
  }
  
  public final void Zq()
  {
    AppMethodBeat.i(63554);
    ae.i("MicroMsg.AASelectInitAdapter", "resetData");
    this.iYA = i.JC(this.chatroomName);
    if (x.zW(this.chatroomName)) {
      aRZ();
    }
    AppMethodBeat.o(63554);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63556);
    int i = this.iYA.size();
    AppMethodBeat.o(63556);
    return i;
  }
  
  public final a rk(int paramInt)
  {
    AppMethodBeat.i(63555);
    Object localObject = (String)this.iYA.get(paramInt);
    g.ajS();
    localObject = ((l)g.ab(l.class)).azF().BH((String)localObject);
    c localc = new c(paramInt);
    localc.dnW = this.chatroomName;
    localc.contact = ((an)localObject);
    localc.KJj = true;
    AppMethodBeat.o(63555);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.e
 * JD-Core Version:    0.7.0.1
 */