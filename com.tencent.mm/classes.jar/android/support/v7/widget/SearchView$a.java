package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

final class SearchView$a
{
  private Method aww;
  private Method awx;
  private Method awy;
  
  SearchView$a()
  {
    try
    {
      this.aww = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      this.aww.setAccessible(true);
      try
      {
        label27:
        this.awx = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        this.awx.setAccessible(true);
        try
        {
          label50:
          this.awy = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
          this.awy.setAccessible(true);
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
    if (this.aww != null) {}
    try
    {
      this.aww.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  final void b(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.awx != null) {}
    try
    {
      this.awx.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  final void c(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.awy != null) {}
    try
    {
      this.awy.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.SearchView.a
 * JD-Core Version:    0.7.0.1
 */