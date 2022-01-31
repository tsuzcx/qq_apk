package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.sdk.b.c;

class KindaPlatformUtil$1
  extends c<bd>
{
  KindaPlatformUtil$1(KindaPlatformUtil paramKindaPlatformUtil)
  {
    AppMethodBeat.i(144382);
    this.__eventId = bd.class.getName().hashCode();
    AppMethodBeat.o(144382);
  }
  
  public boolean callback(bd parambd)
  {
    AppMethodBeat.i(144383);
    if (KindaPlatformUtil.access$000(this.this$0) != null) {
      KindaPlatformUtil.access$000(this.this$0).call(this.this$0.currentLanguageCode());
    }
    AppMethodBeat.o(144383);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPlatformUtil.1
 * JD-Core Version:    0.7.0.1
 */