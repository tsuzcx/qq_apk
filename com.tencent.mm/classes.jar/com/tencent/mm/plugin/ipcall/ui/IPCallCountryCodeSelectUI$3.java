package com.tencent.mm.plugin.ipcall.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallCountryCodeSelectUI$3
  implements IPCallCountryCodeScrollbar.a
{
  IPCallCountryCodeSelectUI$3(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI) {}
  
  public final void lf(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(22114);
    int j = paramString.charAt(0);
    if ("↑".equals(paramString))
    {
      IPCallCountryCodeSelectUI.b(this.nSK).setSelection(0);
      AppMethodBeat.o(22114);
      return;
    }
    paramString = IPCallCountryCodeSelectUI.c(this.nSK).nSp;
    if (paramString == null)
    {
      AppMethodBeat.o(22114);
      return;
    }
    do
    {
      i += 1;
      if (i >= paramString.length) {
        break;
      }
    } while (paramString[i] != j);
    IPCallCountryCodeSelectUI.b(this.nSK).setSelection(i + IPCallCountryCodeSelectUI.b(this.nSK).getHeaderViewsCount());
    AppMethodBeat.o(22114);
    return;
    AppMethodBeat.o(22114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.3
 * JD-Core Version:    0.7.0.1
 */