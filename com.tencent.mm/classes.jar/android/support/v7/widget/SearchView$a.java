package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

final class SearchView$a
{
  Method ajU;
  Method ajV;
  private Method ajW;
  
  SearchView$a()
  {
    try
    {
      this.ajU = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      this.ajU.setAccessible(true);
      try
      {
        label27:
        this.ajV = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        this.ajV.setAccessible(true);
        try
        {
          label50:
          this.ajW = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
          this.ajW.setAccessible(true);
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
    if (this.ajW != null) {}
    try
    {
      this.ajW.invoke(paramAutoCompleteTextView, new Object[] { Boolean.valueOf(true) });
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.SearchView.a
 * JD-Core Version:    0.7.0.1
 */