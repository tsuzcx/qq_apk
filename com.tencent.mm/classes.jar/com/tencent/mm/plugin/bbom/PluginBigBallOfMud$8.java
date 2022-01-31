package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.l.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.bi;

final class PluginBigBallOfMud$8
  implements a
{
  PluginBigBallOfMud$8(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final String A(String paramString, int paramInt)
  {
    if (f.eW(paramString)) {
      return e.lv(((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramInt).czr);
    }
    return bf.HS();
  }
  
  public final void c(bi parambi)
  {
    if (f.eW(parambi.field_talker)) {
      parambi.cY(e.HR());
    }
  }
  
  public final String d(bi parambi)
  {
    if (f.eW(parambi.field_talker)) {
      return e.lv(parambi.czr);
    }
    return null;
  }
  
  public final boolean eW(String paramString)
  {
    return f.eW(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.8
 * JD-Core Version:    0.7.0.1
 */