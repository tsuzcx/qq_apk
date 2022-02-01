package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.sdk.b.c;

class KindaPlatformUtil$1
  extends c<bl>
{
  KindaPlatformUtil$1(KindaPlatformUtil paramKindaPlatformUtil)
  {
    AppMethodBeat.i(160756);
    this.__eventId = bl.class.getName().hashCode();
    AppMethodBeat.o(160756);
  }
  
  public boolean callback(bl parambl)
  {
    AppMethodBeat.i(18469);
    if (KindaPlatformUtil.access$000(this.this$0) != null) {
      KindaPlatformUtil.access$000(this.this$0).call(this.this$0.currentLanguageCode());
    }
    AppMethodBeat.o(18469);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPlatformUtil.1
 * JD-Core Version:    0.7.0.1
 */