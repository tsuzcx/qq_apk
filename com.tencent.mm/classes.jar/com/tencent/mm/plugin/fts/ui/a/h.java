package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.b;

public final class h
  extends a
{
  CharSequence mZb;
  private h.b mZc;
  h.a mZd;
  
  public h(int paramInt)
  {
    super(17, paramInt);
    AppMethodBeat.i(61993);
    this.mZc = new h.b(this, (byte)0);
    this.mZd = new h.a(this, (byte)0);
    AppMethodBeat.o(61993);
  }
  
  public final a.b Pr()
  {
    return this.mZc;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(61994);
    parama = new SpannableStringBuilder();
    paramVarArgs = this.mRX.mSy;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      SpannableString localSpannableString = new SpannableString(localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.mVQ), 0, localObject.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.mZb = TextUtils.concat(new CharSequence[] { paramContext.getString(2131303065), parama.subSequence(0, parama.length() - 1), paramContext.getString(2131303064) });
    AppMethodBeat.o(61994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.h
 * JD-Core Version:    0.7.0.1
 */