package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class n
{
  private final DataSetObservable Ft = new DataSetObservable();
  private DataSetObserver Fu;
  
  public int F(Object paramObject)
  {
    return -1;
  }
  
  final void a(DataSetObserver paramDataSetObserver)
  {
    try
    {
      this.Fu = paramDataSetObserver;
      return;
    }
    finally {}
  }
  
  public void a(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public abstract boolean a(View paramView, Object paramObject);
  
  public float ax(int paramInt)
  {
    return 1.0F;
  }
  
  public Object b(ViewGroup paramViewGroup, int paramInt)
  {
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  public void cc() {}
  
  public Parcelable cd()
  {
    return null;
  }
  
  public CharSequence dj()
  {
    return null;
  }
  
  public void e(ViewGroup paramViewGroup) {}
  
  public abstract int getCount();
  
  public void j(Object paramObject) {}
  
  public void notifyDataSetChanged()
  {
    try
    {
      if (this.Fu != null) {
        this.Fu.onChanged();
      }
      this.Ft.notifyChanged();
      return;
    }
    finally {}
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.Ft.registerObserver(paramDataSetObserver);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.Ft.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.n
 * JD-Core Version:    0.7.0.1
 */