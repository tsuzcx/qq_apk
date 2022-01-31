package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
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

public class f
  extends k
{
  protected CharSequence kCP;
  protected String kCQ;
  protected CharSequence kCR;
  protected String kCS;
  public l kCT;
  private f.a kCU = new f.a(this);
  f.b kCV = new f.b(this);
  public String kwY;
  public int showType;
  
  public f(int paramInt)
  {
    super(paramInt);
  }
  
  public a.b BD()
  {
    return this.kCU;
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    String str = this.kCT.kwg;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    parama = null;
    switch (this.kCT.kwf)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      bool1 = false;
      bool3 = bool4;
      if (this.showType == 2)
      {
        this.kCQ = str;
        if (!bk.bl(paramVarArgs))
        {
          this.kCP = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kCT.kwi, bool3, bool1, b.c.kAc, paramVarArgs + "(", ")")).kwz;
          this.kCP = TextUtils.concat(new CharSequence[] { "\"", this.kCP, "\"" });
          this.kCR = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(com.tencent.mm.plugin.fts.a.d.Cy(this.kwY), b.c.kAe, 300.0F, TextUtils.TruncateAt.END), paramContext.getString(n.g.search_talker_message_info_3) });
          this.kCS = this.kwY;
          return;
        }
      }
      break;
    case 3: 
      label155:
      bool1 = true;
    }
    label242:
    for (bool3 = true;; bool3 = bool5)
    {
      parama = com.tencent.mm.plugin.fts.a.d.Cy(str);
      paramVarArgs = null;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = ((j)g.r(j.class)).Fw().abl(str).field_nickname;
      paramVarArgs = com.tencent.mm.plugin.fts.a.d.Cy(str);
      bool1 = bool2;
      break;
      this.kCP = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kCT.kwi, bool3, bool1, 400.0F, b.c.kAc)).kwz;
      break label155;
      this.kCP = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(com.tencent.mm.plugin.fts.a.d.Cy(this.kwY), b.c.kAe, 300.0F, TextUtils.TruncateAt.END), "\"" });
      this.kCQ = this.kwY;
      this.kCS = str;
      if (!bk.bl(paramVarArgs)) {}
      for (this.kCR = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kCT.kwi, bool3, bool1, b.c.kAc, paramVarArgs + "(", ")")).kwz;; this.kCR = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.kCT.kwi, bool3, bool1, 400.0F, b.c.kAc)).kwz)
      {
        this.kCR = TextUtils.concat(new CharSequence[] { "\"", this.kCR, paramContext.getString(n.g.search_talker_message_info_3) });
        return;
      }
      bool1 = false;
      break label242;
      bool1 = false;
    }
  }
  
  protected final a.a afK()
  {
    return this.kCV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.f
 * JD-Core Version:    0.7.0.1
 */