package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  private List<String> jWf;
  
  public e(n paramn, String paramString)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63553);
    this.chatroomName = paramString;
    and();
    AppMethodBeat.o(63553);
  }
  
  private void bmF()
  {
    AppMethodBeat.i(213013);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.jWf != null) && (this.jWf.size() > 0))
    {
      Iterator localIterator = this.jWf.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (as.bjp(str)) {
          localArrayList1.add(str);
        } else {
          localArrayList2.add(str);
        }
      }
      if (localArrayList1.size() > 0)
      {
        this.jWf.clear();
        this.jWf.addAll(localArrayList2);
        this.jWf.addAll(localArrayList1);
      }
    }
    AppMethodBeat.o(213013);
  }
  
  public final void and()
  {
    AppMethodBeat.i(63554);
    Log.i("MicroMsg.AASelectInitAdapter", "resetData");
    this.jWf = i.SA(this.chatroomName);
    if (ab.Iz(this.chatroomName)) {
      bmF();
    }
    AppMethodBeat.o(63554);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63556);
    int i = this.jWf.size();
    AppMethodBeat.o(63556);
    return i;
  }
  
  public final a va(int paramInt)
  {
    AppMethodBeat.i(63555);
    Object localObject = (String)this.jWf.get(paramInt);
    g.aAi();
    localObject = ((l)g.af(l.class)).aSN().Kn((String)localObject);
    c localc = new c(paramInt);
    localc.dFl = this.chatroomName;
    localc.contact = ((as)localObject);
    localc.PWh = true;
    AppMethodBeat.o(63555);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.e
 * JD-Core Version:    0.7.0.1
 */