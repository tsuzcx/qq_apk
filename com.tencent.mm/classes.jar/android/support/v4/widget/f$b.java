package android.support.v4.widget;

import android.database.DataSetObserver;

final class f$b
  extends DataSetObserver
{
  f$b(f paramf) {}
  
  public final void onChanged()
  {
    this.JS.JK = true;
    this.JS.notifyDataSetChanged();
  }
  
  public final void onInvalidated()
  {
    this.JS.JK = false;
    this.JS.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.widget.f.b
 * JD-Core Version:    0.7.0.1
 */