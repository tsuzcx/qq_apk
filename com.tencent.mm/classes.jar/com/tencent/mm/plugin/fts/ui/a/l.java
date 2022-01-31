package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n.g;

public final class l
  extends a
{
  a.a kDA = new l.a(this);
  CharSequence kDy;
  private a.b kDz = new l.b(this);
  
  public l(int paramInt)
  {
    super(18, paramInt);
  }
  
  public final a.b BD()
  {
    return this.kDz;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    parama = TextUtils.ellipsize(this.kwi.kwG, b.c.kAg, 400.0F, TextUtils.TruncateAt.MIDDLE).toString();
    this.kDy = f.a(paramContext.getString(n.g.search_contact_no_result_pre), paramContext.getString(n.g.search_contact_no_result_post), d.b(parama, parama)).kwz;
  }
  
  protected final a.a afK()
  {
    return this.kDA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.l
 * JD-Core Version:    0.7.0.1
 */