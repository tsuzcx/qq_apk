package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.modelsimple.h;

final class JsApiScanCode$GetA8KeyTask$1
  implements w.a
{
  JsApiScanCode$GetA8KeyTask$1(JsApiScanCode.GetA8KeyTask paramGetA8KeyTask, h paramh) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.ghB.actionCode = -1;
      JsApiScanCode.GetA8KeyTask.a(this.ghB);
      return 0;
    }
    this.ghB.actionCode = this.ghA.Qh();
    switch (this.ghB.actionCode)
    {
    }
    for (this.ghB.ghy = "";; this.ghB.ghy = this.ghA.Qf())
    {
      JsApiScanCode.GetA8KeyTask.b(this.ghB);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.GetA8KeyTask.1
 * JD-Core Version:    0.7.0.1
 */