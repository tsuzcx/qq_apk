package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePushListener;

final class a$1
  implements ITXLivePushListener
{
  a$1(a parama) {}
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(139783);
    if (this.bGK.xt()) {
      this.bGK.bGB.d(this.bGK.getId(), paramBundle);
    }
    AppMethodBeat.o(139783);
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(139782);
    if (this.bGK.xt()) {
      this.bGK.bGB.b(this.bGK.getId(), paramInt, paramBundle);
    }
    AppMethodBeat.o(139782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */