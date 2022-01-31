package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;

final class c$1
  implements Preference.a
{
  c$1(c paramc) {}
  
  public final boolean a(Preference paramPreference, Object paramObject)
  {
    paramPreference = (String)paramObject;
    int i = -1;
    if ("male".equalsIgnoreCase(paramPreference)) {
      i = 1;
    }
    for (;;)
    {
      if (i > 0)
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().o(12290, Integer.valueOf(i));
      }
      return false;
      if ("female".equalsIgnoreCase(paramPreference)) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.c.1
 * JD-Core Version:    0.7.0.1
 */