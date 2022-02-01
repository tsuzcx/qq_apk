package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  public Map<String, Object> owN;
  public CardInfo own;
  
  public e()
  {
    AppMethodBeat.i(112615);
    this.owN = new HashMap();
    this.own = null;
    this.owN.clear();
    AppMethodBeat.o(112615);
  }
  
  public final Object getValue(String paramString)
  {
    AppMethodBeat.i(112617);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(112617);
      return null;
    }
    if (this.owN.containsKey(paramString))
    {
      paramString = this.owN.get(paramString);
      AppMethodBeat.o(112617);
      return paramString;
    }
    AppMethodBeat.o(112617);
    return null;
  }
  
  public final void putValue(String paramString, Object paramObject)
  {
    AppMethodBeat.i(112616);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(112616);
      return;
    }
    this.owN.put(paramString, paramObject);
    AppMethodBeat.o(112616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.e
 * JD-Core Version:    0.7.0.1
 */