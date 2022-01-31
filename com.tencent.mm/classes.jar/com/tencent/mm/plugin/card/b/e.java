package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  public CardInfo kkN;
  public Map<String, Object> kln;
  
  public e()
  {
    AppMethodBeat.i(87671);
    this.kln = new HashMap();
    this.kkN = null;
    this.kln.clear();
    AppMethodBeat.o(87671);
  }
  
  public final Object getValue(String paramString)
  {
    AppMethodBeat.i(87673);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(87673);
      return null;
    }
    if (this.kln.containsKey(paramString))
    {
      paramString = this.kln.get(paramString);
      AppMethodBeat.o(87673);
      return paramString;
    }
    AppMethodBeat.o(87673);
    return null;
  }
  
  public final void putValue(String paramString, Object paramObject)
  {
    AppMethodBeat.i(87672);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(87672);
      return;
    }
    this.kln.put(paramString, paramObject);
    AppMethodBeat.o(87672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.e
 * JD-Core Version:    0.7.0.1
 */