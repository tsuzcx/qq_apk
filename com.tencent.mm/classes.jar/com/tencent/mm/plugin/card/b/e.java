package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  public CardInfo ijN = null;
  public Map<String, Object> ikn = new HashMap();
  
  public e()
  {
    this.ikn.clear();
  }
  
  public final Object getValue(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.ikn.containsKey(paramString)) {
      return null;
    }
    return this.ikn.get(paramString);
  }
  
  public final void putValue(String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.ikn.put(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.e
 * JD-Core Version:    0.7.0.1
 */