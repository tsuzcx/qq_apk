package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
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
  private List<String> pJZ;
  
  public e(o paramo, String paramString)
  {
    super(paramo, null, true, true);
    AppMethodBeat.i(63553);
    this.chatroomName = paramString;
    aNm();
    AppMethodBeat.o(63553);
  }
  
  private void bVD()
  {
    AppMethodBeat.i(268621);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.pJZ != null) && (this.pJZ.size() > 0))
    {
      Iterator localIterator = this.pJZ.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (au.bwO(str)) {
          localArrayList1.add(str);
        } else {
          localArrayList2.add(str);
        }
      }
      if (localArrayList1.size() > 0)
      {
        this.pJZ.clear();
        this.pJZ.addAll(localArrayList2);
        this.pJZ.addAll(localArrayList1);
      }
    }
    AppMethodBeat.o(268621);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(63554);
    Log.i("MicroMsg.AASelectInitAdapter", "resetData");
    this.pJZ = j.SA(this.chatroomName);
    if (ab.IG(this.chatroomName)) {
      bVD();
    }
    AppMethodBeat.o(63554);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63556);
    int i = this.pJZ.size();
    AppMethodBeat.o(63556);
    return i;
  }
  
  public final a yk(int paramInt)
  {
    AppMethodBeat.i(63555);
    Object localObject = (String)this.pJZ.get(paramInt);
    h.baF();
    localObject = ((n)h.ax(n.class)).bzA().JE((String)localObject);
    c localc = new c(paramInt);
    localc.hCy = this.chatroomName;
    localc.contact = ((au)localObject);
    localc.afey = true;
    AppMethodBeat.o(63555);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.e
 * JD-Core Version:    0.7.0.1
 */