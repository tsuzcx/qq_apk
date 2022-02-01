package android.arch.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ViewModelStore
{
  public final HashMap<String, ViewModel> mMap = new HashMap();
  
  final void a(String paramString, ViewModel paramViewModel)
  {
    paramString = (ViewModel)this.mMap.put(paramString, paramViewModel);
    if (paramString != null) {
      paramString.onCleared();
    }
  }
  
  public final void clear()
  {
    Iterator localIterator = this.mMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ViewModel)localIterator.next()).onCleared();
    }
    this.mMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelStore
 * JD-Core Version:    0.7.0.1
 */