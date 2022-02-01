package com.tencent.kinda.framework.app;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aeh;
import com.tencent.mm.autogen.a.aeh.a;
import com.tencent.mm.plugin.wallet_core.ui.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class KindaRealNameManagerImpl$1
  extends IListener<aeh>
{
  KindaRealNameManagerImpl$1(KindaRealNameManagerImpl paramKindaRealNameManagerImpl, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(226373);
    this.__eventId = aeh.class.getName().hashCode();
    AppMethodBeat.o(226373);
  }
  
  public boolean callback(aeh paramaeh)
  {
    AppMethodBeat.i(226376);
    if (KindaRealNameManagerImpl.access$000(this.this$0) != null)
    {
      Log.i("KindaRealNameManagerImpl", "privacyDutyIListener callback：%s", new Object[] { Boolean.valueOf(paramaeh.iiT.hCQ) });
      if (!paramaeh.iiT.hCQ) {
        break label66;
      }
      KindaRealNameManagerImpl.access$000(this.this$0).agree();
    }
    for (;;)
    {
      AppMethodBeat.o(226376);
      return true;
      label66:
      KindaRealNameManagerImpl.access$000(this.this$0).cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaRealNameManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */