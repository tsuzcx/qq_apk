package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;

public final class o
  extends f
{
  private o.a kDL = new o.a(this);
  
  public o(int paramInt)
  {
    super(paramInt);
  }
  
  public final a.b BD()
  {
    return this.kDL;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    String str = this.kCT.kwg;
    boolean bool2;
    boolean bool1;
    switch (this.kCT.kwf)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      parama = null;
      bool2 = false;
      bool1 = false;
    case 3: 
      for (;;)
      {
        this.kCQ = str;
        if (bk.bl(paramVarArgs)) {
          break;
        }
        this.kCP = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kCT.kwi, bool2, bool1, b.c.kAc, paramVarArgs + "(", ")")).kwz;
        this.kCP = TextUtils.concat(new CharSequence[] { "\"", this.kCP, paramContext.getString(n.g.search_talker_message_info_3) });
        return;
        bool1 = true;
        bool2 = true;
        parama = com.tencent.mm.plugin.fts.a.d.Cy(str);
        paramVarArgs = null;
      }
    case 7: 
      label132:
      label169:
      label172:
      bool1 = true;
      label186:
      bool2 = true;
    }
    for (;;)
    {
      parama = ((j)g.r(j.class)).Fw().abl(str).field_nickname;
      paramVarArgs = com.tencent.mm.plugin.fts.a.d.Cy(str);
      break;
      this.kCP = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kCT.kwi, bool2, bool1, 400.0F, b.c.kAc)).kwz;
      break label132;
      bool1 = false;
      break label169;
      bool2 = false;
      bool1 = false;
      break label172;
      bool1 = false;
      break label186;
      bool2 = false;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.o
 * JD-Core Version:    0.7.0.1
 */