package android.arch.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ViewModelStore
{
  final HashMap<String, ViewModel> dz = new HashMap();
  
  final void a(String paramString, ViewModel paramViewModel)
  {
    paramString = (ViewModel)this.dz.put(paramString, paramViewModel);
    if (paramString != null) {
      paramString.af();
    }
  }
  
  public final void clear()
  {
    Iterator localIterator = this.dz.values().iterator();
    while (localIterator.hasNext()) {
      ((ViewModel)localIterator.next()).af();
    }
    this.dz.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelStore
 * JD-Core Version:    0.7.0.1
 */