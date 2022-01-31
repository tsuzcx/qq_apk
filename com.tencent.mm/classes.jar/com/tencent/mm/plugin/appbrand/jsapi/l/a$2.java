package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class a$2
  implements MMActivity.a
{
  a$2(a parama, b.a parama1) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != (this.gzl.hashCode() & 0xFFFF)) {}
    do
    {
      HashMap localHashMap;
      do
      {
        return;
        if (paramInt2 != -1) {
          break;
        }
        localHashMap = new HashMap();
        String str = bk.aM(paramIntent.getStringExtra("token"), "");
        paramIntent = bk.aM(paramIntent.getStringExtra("bind_serial"), "");
        localHashMap.put("token", str);
        localHashMap.put("bindSerial", paramIntent);
      } while (this.gzk == null);
      this.gzk.a(1, null, localHashMap);
      return;
    } while (this.gzk == null);
    this.gzk.a(2, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a.2
 * JD-Core Version:    0.7.0.1
 */