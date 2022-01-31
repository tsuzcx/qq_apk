package android.arch.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ViewModelStore
{
  final HashMap<String, ViewModel> dw = new HashMap();
  
  final void a(String paramString, ViewModel paramViewModel)
  {
    paramString = (ViewModel)this.dw.put(paramString, paramViewModel);
    if (paramString != null) {
      paramString.au();
    }
  }
  
  public final void clear()
  {
    Iterator localIterator = this.dw.values().iterator();
    while (localIterator.hasNext()) {
      ((ViewModel)localIterator.next()).au();
    }
    this.dw.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelStore
 * JD-Core Version:    0.7.0.1
 */