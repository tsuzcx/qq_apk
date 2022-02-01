package com.tencent.mm.plugin.card.mgr;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public CardInfo wqY;
  public Map<String, Object> wrx;
  
  public d()
  {
    AppMethodBeat.i(112615);
    this.wrx = new HashMap();
    this.wqY = null;
    this.wrx.clear();
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
    if (this.wrx.containsKey(paramString))
    {
      paramString = this.wrx.get(paramString);
      AppMethodBeat.o(112617);
      return paramString;
    }
    AppMethodBeat.o(112617);
    return null;
  }
  
  public final void z(String paramString, Object paramObject)
  {
    AppMethodBeat.i(112616);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(112616);
      return;
    }
    this.wrx.put(paramString, paramObject);
    AppMethodBeat.o(112616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.d
 * JD-Core Version:    0.7.0.1
 */