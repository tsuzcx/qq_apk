package com.tencent.luggage.webview.a;

import android.text.TextUtils;
import android.util.Pair;
import java.util.LinkedList;
import java.util.regex.Pattern;

public final class b
{
  public final LinkedList<Pair<c, Pattern>> bjT = new LinkedList();
  
  public final void a(c paramc)
  {
    Object localObject = paramc.qx();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (localObject = null;; localObject = Pattern.compile((String)localObject))
    {
      this.bjT.add(new Pair(paramc, localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.webview.a.b
 * JD-Core Version:    0.7.0.1
 */