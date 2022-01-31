package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.protocal.protobuf.bvc;

final class d$2
  implements d.a
{
  d$2(d paramd) {}
  
  public final void f(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(42090);
    paramIntent = new Intent().putExtra("sendId", this.okc.ojZ.xxB);
    if (paramInt == -1) {
      paramIntent.putExtra("result_share_msg", true);
    }
    for (;;)
    {
      d locald = this.okc;
      locald.oka = false;
      if (locald.ojY != null) {
        locald.ojY.e(-1, paramIntent);
      }
      AppMethodBeat.o(42090);
      return;
      paramIntent.putExtra("result_share_msg", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d.2
 * JD-Core Version:    0.7.0.1
 */