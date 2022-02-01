package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Spannable;
import android.text.style.CharacterStyle;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class e<V, C extends h<V>>
  extends t<V, C>
{
  private static boolean a(Spannable paramSpannable, g paramg, Object paramObject, q paramq)
  {
    int k = paramSpannable.getSpanStart(paramObject);
    int i = paramSpannable.getSpanEnd(paramObject);
    int j = paramg.avj;
    int m = paramg.OQ;
    int n = Math.max(k, j);
    int i1 = Math.min(i, m);
    if (n > i1) {}
    do
    {
      return false;
      if (n < i1) {
        return true;
      }
      if (((k > j) && (i < m)) || ((j > k) && (m < i))) {
        return true;
      }
    } while (paramq == q.pEk);
    k = paramSpannable.getSpanFlags(paramObject) & 0x33;
    if (i == j) {
      return e(k, new int[] { 34, 18 });
    }
    return e(k, new int[] { 17, 18 });
  }
  
  protected final ArrayList<Object> a(Spannable paramSpannable, g paramg, q paramq)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object[] arrayOfObject = paramSpannable.getSpans(Math.max(0, paramg.avj - 1), Math.min(paramSpannable.length(), paramg.OQ + 1), CharacterStyle.class);
    int j = arrayOfObject.length;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((cW(localObject)) && (a(paramSpannable, paramg, localObject, paramq))) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(WXRTEditText paramWXRTEditText, V paramV)
  {
    g localg = r(paramWXRTEditText);
    int i;
    int j;
    label41:
    Object localObject;
    int k;
    if (localg.isEmpty())
    {
      i = 18;
      paramWXRTEditText = paramWXRTEditText.getText();
      Iterator localIterator = a(paramWXRTEditText, localg, q.pEl).iterator();
      j = i;
      if (!localIterator.hasNext()) {
        break label233;
      }
      localObject = localIterator.next();
      boolean bool = cgE().equals(paramV);
      k = paramWXRTEditText.getSpanStart(localObject);
      i = j;
      if (k < localg.avj)
      {
        if (!bool) {
          break label176;
        }
        localg.fi(localg.avj - k, 0);
        i = 34;
      }
      label116:
      j = paramWXRTEditText.getSpanEnd(localObject);
      if (j > localg.OQ)
      {
        if (!bool) {
          break label206;
        }
        localg.fi(0, j - localg.OQ);
      }
    }
    for (;;)
    {
      paramWXRTEditText.removeSpan(localObject);
      j = i;
      break label41;
      i = 34;
      break;
      label176:
      cgE();
      paramWXRTEditText.setSpan(cgD(), k, localg.avj, 33);
      i = j;
      break label116;
      label206:
      cgE();
      paramWXRTEditText.setSpan(cgD(), localg.OQ, j, 34);
    }
    label233:
    if (paramV != null) {
      paramWXRTEditText.setSpan(cgD(), localg.avj, localg.OQ, j);
    }
  }
  
  public abstract boolean cW(Object paramObject);
  
  protected abstract h<V> cgD();
  
  protected abstract V cgE();
  
  protected final g r(WXRTEditText paramWXRTEditText)
  {
    return new g(paramWXRTEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.e
 * JD-Core Version:    0.7.0.1
 */