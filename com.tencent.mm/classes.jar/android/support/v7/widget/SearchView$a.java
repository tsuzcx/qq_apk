package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

final class SearchView$a
{
  private Method amk;
  private Method aml;
  private Method amm;
  
  SearchView$a()
  {
    try
    {
      this.amk = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      this.amk.setAccessible(true);
      try
      {
        label27:
        this.aml = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        this.aml.setAccessible(true);
        try
        {
          label50:
          this.amm = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
          this.amm.setAccessible(true);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException1) {}
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label50;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      break label27;
    }
  }
  
  final void a(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.amk != null) {}
    try
    {
      this.amk.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  final void b(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.aml != null) {}
    try
    {
      this.aml.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  final void c(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.amm != null) {}
    try
    {
      this.amm.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.SearchView.a
 * JD-Core Version:    0.7.0.1
 */