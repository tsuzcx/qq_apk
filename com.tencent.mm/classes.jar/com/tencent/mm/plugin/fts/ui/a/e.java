package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n.g;

public final class e
  extends k
{
  public int count;
  private e.a kCL = new e.a(this);
  e.b kCM = new e.b(this);
  public String talker;
  
  public e(int paramInt)
  {
    super(paramInt);
  }
  
  public final a.b BD()
  {
    return this.kCL;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    parama = TextUtils.ellipsize(d.Cy(this.talker), b.c.kAg, 500.0F, TextUtils.TruncateAt.MIDDLE);
    this.kDu = paramContext.getString(n.g.search_talker_message_header, new Object[] { parama });
  }
  
  protected final a.a afK()
  {
    return this.kCM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.e
 * JD-Core Version:    0.7.0.1
 */