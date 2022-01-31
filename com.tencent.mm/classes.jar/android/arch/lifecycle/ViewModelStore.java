package android.arch.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ViewModelStore
{
  final HashMap<String, ViewModel> cJ = new HashMap();
  
  public final void clear()
  {
    Iterator localIterator = this.cJ.values().iterator();
    while (localIterator.hasNext()) {
      ((ViewModel)localIterator.next()).onCleared();
    }
    this.cJ.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelStore
 * JD-Core Version:    0.7.0.1
 */