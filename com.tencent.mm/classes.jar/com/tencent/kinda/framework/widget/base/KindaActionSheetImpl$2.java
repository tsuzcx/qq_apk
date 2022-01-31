package com.tencent.kinda.framework.widget.base;

import android.view.MenuItem;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

class KindaActionSheetImpl$2
  implements n.d
{
  KindaActionSheetImpl$2(KindaActionSheetImpl paramKindaActionSheetImpl) {}
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(144711);
    if (paramInt < KindaActionSheetImpl.access$100(this.this$0).size()) {
      ((VoidCallback)KindaActionSheetImpl.access$100(this.this$0).get(paramInt)).call();
    }
    AppMethodBeat.o(144711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaActionSheetImpl.2
 * JD-Core Version:    0.7.0.1
 */