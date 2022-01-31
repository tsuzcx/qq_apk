package com.tencent.mm.plugin.freewifi.model;

import android.util.SparseArray;
import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.freewifi.d.b;
import com.tencent.mm.sdk.platformtools.bk;

final class a$1
  implements f
{
  a$1(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    paramString = ((b)paramm).mac;
    if (com.tencent.mm.plugin.freewifi.m.isEmpty(paramString)) {
      return;
    }
    if (paramInt2 == -30011)
    {
      this.kon.kol.put(paramString.hashCode(), Long.valueOf(bk.UY()));
      return;
    }
    this.kon.kol.remove(paramString.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.a.1
 * JD-Core Version:    0.7.0.1
 */