package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.List;

public final class e
  extends q
{
  private String chatroomName;
  private List<String> ico;
  
  public e(n paramn, String paramString)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(63553);
    this.chatroomName = paramString;
    VP();
    AppMethodBeat.o(63553);
  }
  
  public final void VP()
  {
    AppMethodBeat.i(63554);
    ad.i("MicroMsg.AASelectInitAdapter", "resetData");
    this.ico = i.BL(this.chatroomName);
    AppMethodBeat.o(63554);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63556);
    int i = this.ico.size();
    AppMethodBeat.o(63556);
    return i;
  }
  
  public final a pU(int paramInt)
  {
    AppMethodBeat.i(63555);
    Object localObject = (String)this.ico.get(paramInt);
    g.afC();
    localObject = ((k)g.ab(k.class)).apM().aHY((String)localObject);
    c localc = new c(paramInt);
    localc.dec = this.chatroomName;
    localc.contact = ((af)localObject);
    localc.GVT = true;
    AppMethodBeat.o(63555);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.e
 * JD-Core Version:    0.7.0.1
 */