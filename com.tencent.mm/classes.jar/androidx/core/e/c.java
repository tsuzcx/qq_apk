package androidx.core.e;

import android.os.Build.VERSION;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class c
  implements Spannable
{
  private static Executor Pj;
  private static final Object sLock;
  public final Spannable bsh;
  public final c.a bsi;
  private final PrecomputedText bsj;
  
  static
  {
    AppMethodBeat.i(195448);
    sLock = new Object();
    Pj = null;
    AppMethodBeat.o(195448);
  }
  
  public char charAt(int paramInt)
  {
    AppMethodBeat.i(195529);
    char c = this.bsh.charAt(paramInt);
    AppMethodBeat.o(195529);
    return c;
  }
  
  public int getSpanEnd(Object paramObject)
  {
    AppMethodBeat.i(195490);
    int i = this.bsh.getSpanEnd(paramObject);
    AppMethodBeat.o(195490);
    return i;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    AppMethodBeat.i(195498);
    int i = this.bsh.getSpanFlags(paramObject);
    AppMethodBeat.o(195498);
    return i;
  }
  
  public int getSpanStart(Object paramObject)
  {
    AppMethodBeat.i(195482);
    int i = this.bsh.getSpanStart(paramObject);
    AppMethodBeat.o(195482);
    return i;
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    AppMethodBeat.i(195474);
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramClass = this.bsj.getSpans(paramInt1, paramInt2, paramClass);
      AppMethodBeat.o(195474);
      return paramClass;
    }
    paramClass = this.bsh.getSpans(paramInt1, paramInt2, paramClass);
    AppMethodBeat.o(195474);
    return paramClass;
  }
  
  public int length()
  {
    AppMethodBeat.i(195515);
    int i = this.bsh.length();
    AppMethodBeat.o(195515);
    return i;
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    AppMethodBeat.i(195507);
    paramInt1 = this.bsh.nextSpanTransition(paramInt1, paramInt2, paramClass);
    AppMethodBeat.o(195507);
    return paramInt1;
  }
  
  public void removeSpan(Object paramObject)
  {
    AppMethodBeat.i(195464);
    if ((paramObject instanceof MetricAffectingSpan))
    {
      paramObject = new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
      AppMethodBeat.o(195464);
      throw paramObject;
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.bsj.removeSpan(paramObject);
      AppMethodBeat.o(195464);
      return;
    }
    this.bsh.removeSpan(paramObject);
    AppMethodBeat.o(195464);
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195457);
    if ((paramObject instanceof MetricAffectingSpan))
    {
      paramObject = new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
      AppMethodBeat.o(195457);
      throw paramObject;
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.bsj.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(195457);
      return;
    }
    this.bsh.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(195457);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195539);
    CharSequence localCharSequence = this.bsh.subSequence(paramInt1, paramInt2);
    AppMethodBeat.o(195539);
    return localCharSequence;
  }
  
  public String toString()
  {
    AppMethodBeat.i(195549);
    String str = this.bsh.toString();
    AppMethodBeat.o(195549);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.e.c
 * JD-Core Version:    0.7.0.1
 */