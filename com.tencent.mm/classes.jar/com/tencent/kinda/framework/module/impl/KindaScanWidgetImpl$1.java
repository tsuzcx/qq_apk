package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;

class KindaScanWidgetImpl$1
  extends c<pw>
{
  KindaScanWidgetImpl$1(KindaScanWidgetImpl paramKindaScanWidgetImpl)
  {
    AppMethodBeat.i(144532);
    this.__eventId = pw.class.getName().hashCode();
    AppMethodBeat.o(144532);
  }
  
  public boolean callback(pw parampw)
  {
    AppMethodBeat.i(144533);
    if ((parampw.cGr.action == 1) && (!bo.isNullOrNil(parampw.cGr.cardNum)) && (KindaScanWidgetImpl.access$000(this.this$0) != null)) {
      KindaScanWidgetImpl.access$000(this.this$0).call(KindaScanWidgetImpl.access$100(this.this$0, parampw.cGr.cardNum));
    }
    KindaScanWidgetImpl.access$200(this.this$0).dead();
    AppMethodBeat.o(144533);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaScanWidgetImpl.1
 * JD-Core Version:    0.7.0.1
 */