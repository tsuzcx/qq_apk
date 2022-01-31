package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity.a;

final class c$3$1
  implements MMActivity.a
{
  c$3$1(c.3 param3) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (this.gqa.gpU != null) {
        this.gqa.gpU.a(true, "ok", paramIntent);
      }
      this.gqa.gpY.ahD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.c.3.1
 * JD-Core Version:    0.7.0.1
 */