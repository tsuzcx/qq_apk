package android.support.v4.view;

import android.database.DataSetObserver;

final class ViewPager$e
  extends DataSetObserver
{
  ViewPager$e(ViewPager paramViewPager) {}
  
  public final void onChanged()
  {
    this.Ha.dataSetChanged();
  }
  
  public final void onInvalidated()
  {
    this.Ha.dataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPager.e
 * JD-Core Version:    0.7.0.1
 */