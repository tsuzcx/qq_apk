package com.tencent.mm.plugin.collect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

final class CollectMainUI$14$1
  implements n.c
{
  CollectMainUI$14$1(CollectMainUI.14 param14) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(142004);
    a.bhw();
    if (a.bhy()) {
      paraml.add(0, 1, 0, 2131298445);
    }
    while (this.kSF.gEz != null)
    {
      int i = 0;
      while (i < this.kSF.gEz.size())
      {
        bda localbda = (bda)this.kSF.gEz.get(i);
        if (!bo.isNullOrNil(localbda.cyA)) {
          paraml.add(0, i + 1 + 1, 0, localbda.cyA);
        }
        i += 1;
      }
      paraml.add(0, 1, 0, 2131298455);
    }
    AppMethodBeat.o(142004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.14.1
 * JD-Core Version:    0.7.0.1
 */