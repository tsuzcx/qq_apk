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
    int j = paramg.avh;
    int m = paramg.Pc;
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
    } while (paramq == q.qTB);
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
    Object[] arrayOfObject = paramSpannable.getSpans(Math.max(0, paramg.avh - 1), Math.min(paramSpannable.length(), paramg.Pc + 1), CharacterStyle.class);
    int j = arrayOfObject.length;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((dd(localObject)) && (a(paramSpannable, paramg, localObject, paramq))) {
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
      Iterator localIterator = a(paramWXRTEditText, localg, q.qTC).iterator();
      j = i;
      if (!localIterator.hasNext()) {
        break label233;
      }
      localObject = localIterator.next();
      boolean bool = cEs().equals(paramV);
      k = paramWXRTEditText.getSpanStart(localObject);
      i = j;
      if (k < localg.avh)
      {
        if (!bool) {
          break label176;
        }
        localg.fy(localg.avh - k, 0);
        i = 34;
      }
      label116:
      j = paramWXRTEditText.getSpanEnd(localObject);
      if (j > localg.Pc)
      {
        if (!bool) {
          break label206;
        }
        localg.fy(0, j - localg.Pc);
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
      cEs();
      paramWXRTEditText.setSpan(cEr(), k, localg.avh, 33);
      i = j;
      break label116;
      label206:
      cEs();
      paramWXRTEditText.setSpan(cEr(), localg.Pc, j, 34);
    }
    label233:
    if (paramV != null) {
      paramWXRTEditText.setSpan(cEr(), localg.avh, localg.Pc, j);
    }
  }
  
  protected abstract h<V> cEr();
  
  protected abstract V cEs();
  
  public abstract boolean dd(Object paramObject);
  
  protected final g r(WXRTEditText paramWXRTEditText)
  {
    return new g(paramWXRTEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.e
 * JD-Core Version:    0.7.0.1
 */