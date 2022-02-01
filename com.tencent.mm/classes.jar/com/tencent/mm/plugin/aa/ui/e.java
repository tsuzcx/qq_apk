package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private List<String> iVH;
  
  public e(n paramn, String paramString)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63553);
    this.chatroomName = paramString;
    Zh();
    AppMethodBeat.o(63553);
  }
  
  private void aRA()
  {
    AppMethodBeat.i(198907);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.iVH != null) && (this.iVH.size() > 0))
    {
      Iterator localIterator = this.iVH.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (am.aSQ(str)) {
          localArrayList1.add(str);
        } else {
          localArrayList2.add(str);
        }
      }
      if (localArrayList1.size() > 0)
      {
        this.iVH.clear();
        this.iVH.addAll(localArrayList2);
        this.iVH.addAll(localArrayList1);
      }
    }
    AppMethodBeat.o(198907);
  }
  
  public final void Zh()
  {
    AppMethodBeat.i(63554);
    ad.i("MicroMsg.AASelectInitAdapter", "resetData");
    this.iVH = i.Jd(this.chatroomName);
    if (w.zm(this.chatroomName)) {
      aRA();
    }
    AppMethodBeat.o(63554);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63556);
    int i = this.iVH.size();
    AppMethodBeat.o(63556);
    return i;
  }
  
  public final a rh(int paramInt)
  {
    AppMethodBeat.i(63555);
    Object localObject = (String)this.iVH.get(paramInt);
    g.ajD();
    localObject = ((l)g.ab(l.class)).azp().Bf((String)localObject);
    c localc = new c(paramInt);
    localc.dmU = this.chatroomName;
    localc.contact = ((am)localObject);
    localc.KmP = true;
    AppMethodBeat.o(63555);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.e
 * JD-Core Version:    0.7.0.1
 */