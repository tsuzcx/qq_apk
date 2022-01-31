package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17901);
    a.a(this.jIq, com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().jHK);
    if ((2 == a.b(this.jIq)) || (3 == a.b(this.jIq)) || (5 == a.b(this.jIq)) || (6 == a.b(this.jIq)))
    {
      ab.d(a.access$200(), "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().jHK), Integer.valueOf(a.c(this.jIq)) });
      a.d(this.jIq);
      AppMethodBeat.o(17901);
      return;
    }
    if (4 == a.b(this.jIq))
    {
      ab.d(a.access$200(), "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().jHK), Integer.valueOf(a.c(this.jIq)) });
      a.e(this.jIq);
      AppMethodBeat.o(17901);
      return;
    }
    AppMethodBeat.o(17901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a.2
 * JD-Core Version:    0.7.0.1
 */