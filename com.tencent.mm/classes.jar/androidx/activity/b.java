package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b
{
  private CopyOnWriteArrayList<a> ew = new CopyOnWriteArrayList();
  public boolean mEnabled;
  
  public b(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  final void a(a parama)
  {
    this.ew.add(parama);
  }
  
  final void b(a parama)
  {
    this.ew.remove(parama);
  }
  
  public abstract void handleOnBackPressed();
  
  public final boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  public final void remove()
  {
    Iterator localIterator = this.ew.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cancel();
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.activity.b
 * JD-Core Version:    0.7.0.1
 */