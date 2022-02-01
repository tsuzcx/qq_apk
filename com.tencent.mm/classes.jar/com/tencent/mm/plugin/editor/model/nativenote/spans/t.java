package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import java.util.ArrayList;

public abstract class t<V, C extends h<V>>
{
  protected static boolean e(int paramInt, int... paramVarArgs)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < 2)
      {
        int j = paramVarArgs[i];
        if ((paramInt & j) == j) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected abstract ArrayList<Object> a(Spannable paramSpannable, g paramg, q paramq);
  
  public abstract void a(WXRTEditText paramWXRTEditText, V paramV);
  
  public abstract int cEq();
  
  protected abstract g r(WXRTEditText paramWXRTEditText);
  
  public final boolean s(WXRTEditText paramWXRTEditText)
  {
    g localg = r(paramWXRTEditText);
    return !a(paramWXRTEditText.getText(), localg, q.qTC).isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.t
 * JD-Core Version:    0.7.0.1
 */