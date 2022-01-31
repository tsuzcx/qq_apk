package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.p;
import java.util.List;

public final class d
  extends p
{
  private String chatroomName;
  private List<String> gpY;
  
  public d(m paramm, String paramString)
  {
    super(paramm, null, true, true);
    AppMethodBeat.i(40767);
    this.chatroomName = paramString;
    ab.i("MicroMsg.AASelectInitAdapter", "resetData");
    this.gpY = h.wG(this.chatroomName);
    AppMethodBeat.o(40767);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(40769);
    int i = this.gpY.size();
    AppMethodBeat.o(40769);
    return i;
  }
  
  public final a mM(int paramInt)
  {
    AppMethodBeat.i(40768);
    Object localObject = (String)this.gpY.get(paramInt);
    g.RM();
    localObject = ((j)g.E(j.class)).YA().arw((String)localObject);
    c localc = new c(paramInt);
    localc.cpf = this.chatroomName;
    localc.contact = ((ad)localObject);
    localc.Adl = true;
    AppMethodBeat.o(40768);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.d
 * JD-Core Version:    0.7.0.1
 */