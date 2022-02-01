import android.database.DataSetObservable;
import android.database.DataSetObserver;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;

public class ltf
  extends DataSetObservable
{
  public ltf(XBaseAdapter paramXBaseAdapter) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      synchronized (this.mObservers)
      {
        i = this.mObservers.size() - 1;
        if (i >= 0)
        {
          DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
          if ((localDataSetObserver instanceof lte)) {
            ((lte)localDataSetObserver).a(paramInt1, paramInt2);
          } else {
            localDataSetObserver.onChanged();
          }
        }
      }
      return;
      i -= 1;
    }
  }
  
  public void a(int... paramVarArgs)
  {
    for (;;)
    {
      int i;
      synchronized (this.mObservers)
      {
        i = this.mObservers.size() - 1;
        if (i >= 0)
        {
          DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
          if ((localDataSetObserver instanceof lte)) {
            ((lte)localDataSetObserver).a(paramVarArgs);
          } else {
            localDataSetObserver.onChanged();
          }
        }
      }
      return;
      i -= 1;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      synchronized (this.mObservers)
      {
        i = this.mObservers.size() - 1;
        if (i >= 0)
        {
          DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
          if ((localDataSetObserver instanceof lte)) {
            ((lte)localDataSetObserver).b(paramInt1, paramInt2);
          } else {
            localDataSetObserver.onChanged();
          }
        }
      }
      return;
      i -= 1;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    if (i >= 0)
    {
      DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
      if ((localDataSetObserver instanceof lte)) {
        ((lte)localDataSetObserver).c(paramInt1, paramInt2);
      }
      for (;;)
      {
        i -= 1;
        break;
        localDataSetObserver.onChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ltf
 * JD-Core Version:    0.7.0.1
 */