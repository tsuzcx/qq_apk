package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.y;

final class UIEntryStub$1
  implements bi.a
{
  UIEntryStub$1(UIEntryStub paramUIEntryStub) {}
  
  public final void a(e parame)
  {
    if (parame == null) {
      this.hRY.finish();
    }
    do
    {
      return;
      y.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", new Object[] { Boolean.valueOf(UIEntryStub.a(this.hRY)) });
    } while (UIEntryStub.a(this.hRY));
    UIEntryStub.b(this.hRY);
    UIEntryStub.a(this.hRY, UIEntryStub.c(this.hRY).getExtras());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub.1
 * JD-Core Version:    0.7.0.1
 */