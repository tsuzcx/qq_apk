package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.fts.ui.n.g;

public final class h
  extends a
{
  CharSequence kDf;
  private h.b kDg = new h.b(this, (byte)0);
  h.a kDh = new h.a(this, (byte)0);
  
  public h(int paramInt)
  {
    super(17, paramInt);
  }
  
  public final a.b BD()
  {
    return this.kDg;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    parama = new SpannableStringBuilder();
    paramVarArgs = this.kwi.kwI;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      SpannableString localSpannableString = new SpannableString(localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.kzY), 0, localObject.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.kDf = TextUtils.concat(new CharSequence[] { paramContext.getString(n.g.select_create_desc_prefix), parama.subSequence(0, parama.length() - 1), paramContext.getString(n.g.select_create_desc_postfix) });
  }
  
  protected final a.a afK()
  {
    return this.kDh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.h
 * JD-Core Version:    0.7.0.1
 */