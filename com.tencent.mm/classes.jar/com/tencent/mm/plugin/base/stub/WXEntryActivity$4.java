package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g.a;
import java.lang.ref.WeakReference;

final class WXEntryActivity$4
  implements g.a
{
  WXEntryActivity$4(WXEntryActivity paramWXEntryActivity, f paramf, m paramm) {}
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(153507);
    f localf = paramf;
    if (paramf == null) {
      localf = this.jMp;
    }
    if (WXEntryActivity.c(this.jMo).get() != null)
    {
      WXEntryActivity.d((WXEntryActivity)WXEntryActivity.c(this.jMo).get());
      WXEntryActivity.a((WXEntryActivity)WXEntryActivity.c(this.jMo).get(), this.ckS, localf);
    }
    this.jMo.finish();
    AppMethodBeat.o(153507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.4
 * JD-Core Version:    0.7.0.1
 */