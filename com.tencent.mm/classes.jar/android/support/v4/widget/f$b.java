package android.support.v4.widget;

import android.database.DataSetObserver;

final class f$b
  extends DataSetObserver
{
  f$b(f paramf) {}
  
  public final void onChanged()
  {
    this.Jy.Jq = true;
    this.Jy.notifyDataSetChanged();
  }
  
  public final void onInvalidated()
  {
    this.Jy.Jq = false;
    this.Jy.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.widget.f.b
 * JD-Core Version:    0.7.0.1
 */