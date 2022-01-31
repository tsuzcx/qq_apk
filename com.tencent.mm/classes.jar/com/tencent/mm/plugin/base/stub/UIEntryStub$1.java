package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;

final class UIEntryStub$1
  implements bk.a
{
  UIEntryStub$1(UIEntryStub paramUIEntryStub) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(18126);
    if (parame == null)
    {
      this.jLD.finish();
      AppMethodBeat.o(18126);
      return;
    }
    ab.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", new Object[] { Boolean.valueOf(UIEntryStub.a(this.jLD)) });
    if (!UIEntryStub.a(this.jLD))
    {
      UIEntryStub.b(this.jLD);
      UIEntryStub.a(this.jLD, UIEntryStub.c(this.jLD).getExtras());
    }
    AppMethodBeat.o(18126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub.1
 * JD-Core Version:    0.7.0.1
 */