package android.support.v7.widget;

import android.database.DataSetObserver;

final class ActivityChooserView$1
  extends DataSetObserver
{
  ActivityChooserView$1(ActivityChooserView paramActivityChooserView) {}
  
  public final void onChanged()
  {
    super.onChanged();
    this.ZI.Zs.notifyDataSetChanged();
  }
  
  public final void onInvalidated()
  {
    super.onInvalidated();
    this.ZI.Zs.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.1
 * JD-Core Version:    0.7.0.1
 */