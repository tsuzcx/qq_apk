import android.database.DataSetObserver;
import com.tencent.widget.PagerBaseAdapterWrapper;

public class lsp
  extends DataSetObserver
{
  public lsp(PagerBaseAdapterWrapper paramPagerBaseAdapterWrapper) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lsp
 * JD-Core Version:    0.7.0.1
 */