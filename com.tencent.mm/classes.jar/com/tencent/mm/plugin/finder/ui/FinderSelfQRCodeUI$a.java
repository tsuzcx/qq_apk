package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder_release"})
public final class FinderSelfQRCodeUI$a
  implements p.a
{
  public final void bv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190889);
    k.h(paramString1, "srcPath");
    k.h(paramString2, "destPath");
    Toast.makeText((Context)this.qPD, (CharSequence)this.qPD.getString(2131760319, new Object[] { paramString2 }), 1).show();
    AppMethodBeat.o(190889);
  }
  
  public final void bw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190890);
    k.h(paramString1, "srcPath");
    k.h(paramString2, "destPath");
    Toast.makeText((Context)this.qPD, (CharSequence)this.qPD.getString(2131762779), 1).show();
    AppMethodBeat.o(190890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI.a
 * JD-Core Version:    0.7.0.1
 */