package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.modelsimple.j;

final class JsApiScanCode$GetA8KeyTask$1
  implements w.a
{
  JsApiScanCode$GetA8KeyTask$1(JsApiScanCode.GetA8KeyTask paramGetA8KeyTask, j paramj) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(130557);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.hzL.actionCode = -1;
      JsApiScanCode.GetA8KeyTask.a(this.hzL);
      AppMethodBeat.o(130557);
      return 0;
    }
    this.hzL.actionCode = this.gSt.ajn();
    switch (this.hzL.actionCode)
    {
    }
    for (this.hzL.hzJ = "";; this.hzL.hzJ = this.gSt.ajl())
    {
      JsApiScanCode.GetA8KeyTask.b(this.hzL);
      AppMethodBeat.o(130557);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.GetA8KeyTask.1
 * JD-Core Version:    0.7.0.1
 */