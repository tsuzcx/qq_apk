package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends r
{
  private List<String> hSb;
  private ArrayList<String> pJO;
  
  public d(o paramo, ArrayList<String> paramArrayList)
  {
    super(paramo, null, true, true);
    AppMethodBeat.i(63549);
    this.pJO = paramArrayList;
    aNm();
    AppMethodBeat.o(63549);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(63550);
    Log.i("MicroMsg.AASelectInitAdapter", "resetData");
    if (this.hSb == null) {
      this.hSb = new ArrayList();
    }
    this.hSb.clear();
    Iterator localIterator = this.pJO.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.hSb.add(str);
    }
    AppMethodBeat.o(63550);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63552);
    int i = this.hSb.size();
    AppMethodBeat.o(63552);
    return i;
  }
  
  public final a yk(int paramInt)
  {
    AppMethodBeat.i(63551);
    Object localObject = (String)this.hSb.get(paramInt);
    h.baF();
    au localau = ((n)h.ax(n.class)).bzA().JE((String)localObject);
    if ((localau != null) && (Util.isNullOrNil(localau.field_username))) {
      localau.setUsername((String)localObject);
    }
    localObject = new c(paramInt);
    ((a)localObject).contact = localau;
    ((a)localObject).afey = true;
    AppMethodBeat.o(63551);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.d
 * JD-Core Version:    0.7.0.1
 */