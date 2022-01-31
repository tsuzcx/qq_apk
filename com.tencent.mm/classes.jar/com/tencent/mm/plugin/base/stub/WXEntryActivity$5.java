package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import java.lang.ref.WeakReference;

final class WXEntryActivity$5
  implements w.a
{
  WXEntryActivity$5(WXEntryActivity paramWXEntryActivity, m paramm) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(153508);
    if ((WXEntryActivity.c(this.jMo).get() == null) || (((WXEntryActivity)WXEntryActivity.c(this.jMo).get()).isFinishing()))
    {
      AppMethodBeat.o(153508);
      return 0;
    }
    WXEntryActivity.d((WXEntryActivity)WXEntryActivity.c(this.jMo).get());
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      WXEntryActivity.a((WXEntryActivity)WXEntryActivity.c(this.jMo).get(), paramInt1, paramInt2, paramString);
      AppMethodBeat.o(153508);
      return 0;
    }
    WXEntryActivity.a((WXEntryActivity)WXEntryActivity.c(this.jMo).get(), this.jMq, paramb);
    AppMethodBeat.o(153508);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.5
 * JD-Core Version:    0.7.0.1
 */