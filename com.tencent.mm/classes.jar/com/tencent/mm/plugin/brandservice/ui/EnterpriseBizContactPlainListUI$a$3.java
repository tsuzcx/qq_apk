package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.b.b;

final class EnterpriseBizContactPlainListUI$a$3
  implements b.b
{
  EnterpriseBizContactPlainListUI$a$3(EnterpriseBizContactPlainListUI.a parama) {}
  
  public final int aqn()
  {
    AppMethodBeat.i(13988);
    int i = this.jUD.getCount();
    AppMethodBeat.o(13988);
    return i;
  }
  
  public final String mS(int paramInt)
  {
    AppMethodBeat.i(13987);
    if ((paramInt < 0) || (paramInt >= this.jUD.getCount()))
    {
      ab.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
      AppMethodBeat.o(13987);
      return null;
    }
    Object localObject = (me)this.jUD.getItem(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(13987);
      return null;
    }
    localObject = ((me)localObject).userName;
    AppMethodBeat.o(13987);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a.3
 * JD-Core Version:    0.7.0.1
 */