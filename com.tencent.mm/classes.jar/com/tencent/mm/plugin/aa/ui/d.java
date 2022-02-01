package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends r
{
  private List<String> fMr;
  private ArrayList<String> mNg;
  
  public d(o paramo, ArrayList<String> paramArrayList)
  {
    super(paramo, null, true, true);
    AppMethodBeat.i(63549);
    this.mNg = paramArrayList;
    ate();
    AppMethodBeat.o(63549);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(63550);
    Log.i("MicroMsg.AASelectInitAdapter", "resetData");
    if (this.fMr == null) {
      this.fMr = new ArrayList();
    }
    this.fMr.clear();
    Iterator localIterator = this.mNg.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.fMr.add(str);
    }
    AppMethodBeat.o(63550);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63552);
    int i = this.fMr.size();
    AppMethodBeat.o(63552);
    return i;
  }
  
  public final a ye(int paramInt)
  {
    AppMethodBeat.i(63551);
    Object localObject = (String)this.fMr.get(paramInt);
    h.aHH();
    as localas = ((n)h.ae(n.class)).bbL().RG((String)localObject);
    if ((localas != null) && (Util.isNullOrNil(localas.field_username))) {
      localas.setUsername((String)localObject);
    }
    localObject = new c(paramInt);
    ((a)localObject).contact = localas;
    ((a)localObject).XsX = true;
    AppMethodBeat.o(63551);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.d
 * JD-Core Version:    0.7.0.1
 */