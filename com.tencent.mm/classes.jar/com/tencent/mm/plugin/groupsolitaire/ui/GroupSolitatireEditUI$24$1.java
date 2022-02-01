package com.tencent.mm.plugin.groupsolitaire.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;

final class GroupSolitatireEditUI$24$1
  implements b.a
{
  GroupSolitatireEditUI$24$1(GroupSolitatireEditUI.24 param24) {}
  
  public final void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(110454);
    if (paramBoolean)
    {
      ad.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitaire time :%s", new Object[] { String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      GroupSolitatireEditUI.a(this.srY.srR, String.format(Locale.US, "%04d/%02d/%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      this.srY.srR.EQ(1);
    }
    AppMethodBeat.o(110454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.24.1
 * JD-Core Version:    0.7.0.1
 */