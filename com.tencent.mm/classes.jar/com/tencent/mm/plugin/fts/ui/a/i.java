package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.sdk.platformtools.bk;

public final class i
  extends a
{
  public boolean kDj;
  public CharSequence kDk;
  private i.b kDl = new i.b(this);
  private i.a kDm = new i.a(this);
  public String kwY;
  
  public i(int paramInt)
  {
    super(19, paramInt);
    this.kxT = false;
  }
  
  public final a.b BD()
  {
    return this.kDl;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    parama = TextUtils.ellipsize(this.kwi.kwJ[0], b.c.kAg, 200.0F, TextUtils.TruncateAt.MIDDLE);
    paramVarArgs = TextUtils.ellipsize(this.kwi.kwJ[1], b.c.kAg, 400.0F, TextUtils.TruncateAt.MIDDLE);
    if (bk.bl(this.kwY))
    {
      this.kDk = TextUtils.concat(new CharSequence[] { paramContext.getString(n.g.search_talker_message_info_1), f.d(parama, parama.length()), paramContext.getString(n.g.search_talker_message_info_2), f.d(paramVarArgs, paramVarArgs.length()), paramContext.getString(n.g.search_talker_message_info_3) });
      return;
    }
    this.kDk = TextUtils.concat(new CharSequence[] { paramContext.getString(n.g.search_talker_message_info_4), f.d(parama, parama.length()), paramContext.getString(n.g.search_talker_message_info_2), f.d(paramVarArgs, paramVarArgs.length()), paramContext.getString(n.g.search_talker_message_info_3) });
  }
  
  protected final a.a afK()
  {
    return this.kDm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i
 * JD-Core Version:    0.7.0.1
 */