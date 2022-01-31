package com.tencent.kinda.framework.widget.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

class KindaActionSheetImpl$1
  implements n.c
{
  KindaActionSheetImpl$1(KindaActionSheetImpl paramKindaActionSheetImpl) {}
  
  public void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(144710);
    Iterator localIterator = KindaActionSheetImpl.access$000(this.this$0).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paraml.add(0, i, 0, (String)localIterator.next());
      i += 1;
    }
    AppMethodBeat.o(144710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaActionSheetImpl.1
 * JD-Core Version:    0.7.0.1
 */