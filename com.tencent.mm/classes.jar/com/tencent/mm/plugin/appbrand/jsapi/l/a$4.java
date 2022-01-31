package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity.a;

final class a$4
  implements MMActivity.a
{
  a$4(a parama, b.a parama1) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != (this.gzl.hashCode() & 0xFFFF)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt2 != -1) {
            break;
          }
        } while (this.gzk == null);
        this.gzk.a(1, null, null);
        return;
        if (paramInt2 != 2) {
          break;
        }
      } while (this.gzk == null);
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getStringExtra("key_result_errmsg");; paramIntent = "")
      {
        this.gzk.a(2, paramIntent, null);
        return;
      }
    } while (this.gzk == null);
    this.gzk.a(3, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a.4
 * JD-Core Version:    0.7.0.1
 */