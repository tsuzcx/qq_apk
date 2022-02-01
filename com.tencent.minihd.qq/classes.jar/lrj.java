import android.database.DataSetObserver;
import com.tencent.widget.AdapterViewPagerAdapter;

public class lrj
  extends DataSetObserver
{
  public lrj(AdapterViewPagerAdapter paramAdapterViewPagerAdapter) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     lrj
 * JD-Core Version:    0.7.0.1
 */