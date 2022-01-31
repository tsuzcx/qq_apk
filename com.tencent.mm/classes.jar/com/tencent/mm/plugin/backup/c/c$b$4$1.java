package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.y;

final class c$b$4$1
  implements f
{
  c$b$4$1(c.b.4 param4, boolean paramBoolean, af paramaf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramm = ((aa)((d)paramm).hLW).hRe;
    y.i(this.hGI.hGz.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[] { Boolean.valueOf(this.hGG), this.hGH, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, this.hGI.hGz.hGr, paramm });
    if ((this.hGG) && (this.hGI.hGz.hGr.equals(paramm))) {
      this.hGH.open();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.4.1
 * JD-Core Version:    0.7.0.1
 */