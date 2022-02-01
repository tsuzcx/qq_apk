package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends r
{
  private String chatroomName;
  private List<String> mNr;
  
  public e(o paramo, String paramString)
  {
    super(paramo, null, true, true);
    AppMethodBeat.i(63553);
    this.chatroomName = paramString;
    ate();
    AppMethodBeat.o(63553);
  }
  
  private void bwN()
  {
    AppMethodBeat.i(276125);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.mNr != null) && (this.mNr.size() > 0))
    {
      Iterator localIterator = this.mNr.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (as.bvK(str)) {
          localArrayList1.add(str);
        } else {
          localArrayList2.add(str);
        }
      }
      if (localArrayList1.size() > 0)
      {
        this.mNr.clear();
        this.mNr.addAll(localArrayList2);
        this.mNr.addAll(localArrayList1);
      }
    }
    AppMethodBeat.o(276125);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(63554);
    Log.i("MicroMsg.AASelectInitAdapter", "resetData");
    this.mNr = i.aag(this.chatroomName);
    if (ab.PR(this.chatroomName)) {
      bwN();
    }
    AppMethodBeat.o(63554);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63556);
    int i = this.mNr.size();
    AppMethodBeat.o(63556);
    return i;
  }
  
  public final a ye(int paramInt)
  {
    AppMethodBeat.i(63555);
    Object localObject = (String)this.mNr.get(paramInt);
    h.aHH();
    localObject = ((n)h.ae(n.class)).bbL().RG((String)localObject);
    c localc = new c(paramInt);
    localc.fxT = this.chatroomName;
    localc.contact = ((as)localObject);
    localc.XsX = true;
    AppMethodBeat.o(63555);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.e
 * JD-Core Version:    0.7.0.1
 */