package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  private List<String> iCx;
  
  public e(n paramn, String paramString)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63553);
    this.chatroomName = paramString;
    WN();
    AppMethodBeat.o(63553);
  }
  
  private void aOo()
  {
    AppMethodBeat.i(207003);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.iCx != null) && (this.iCx.size() > 0))
    {
      Iterator localIterator = this.iCx.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (ai.aNc(str)) {
          localArrayList1.add(str);
        } else {
          localArrayList2.add(str);
        }
      }
      if (localArrayList1.size() > 0)
      {
        this.iCx.clear();
        this.iCx.addAll(localArrayList2);
        this.iCx.addAll(localArrayList1);
      }
    }
    AppMethodBeat.o(207003);
  }
  
  public final void WN()
  {
    AppMethodBeat.i(63554);
    ac.i("MicroMsg.AASelectInitAdapter", "resetData");
    this.iCx = i.FO(this.chatroomName);
    if (w.wr(this.chatroomName)) {
      aOo();
    }
    AppMethodBeat.o(63554);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63556);
    int i = this.iCx.size();
    AppMethodBeat.o(63556);
    return i;
  }
  
  public final a qH(int paramInt)
  {
    AppMethodBeat.i(63555);
    Object localObject = (String)this.iCx.get(paramInt);
    g.agS();
    localObject = ((k)g.ab(k.class)).awB().aNt((String)localObject);
    c localc = new c(paramInt);
    localc.dby = this.chatroomName;
    localc.contact = ((ai)localObject);
    localc.Iwh = true;
    AppMethodBeat.o(63555);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.e
 * JD-Core Version:    0.7.0.1
 */