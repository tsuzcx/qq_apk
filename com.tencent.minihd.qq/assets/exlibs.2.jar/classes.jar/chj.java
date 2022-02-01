import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.lebasearch.SearchResultAdapter;
import com.tencent.biz.lebasearch.SearchResultAdapter.OnResultItemClickedListener;

public class chj
  implements View.OnClickListener
{
  public chj(SearchResultAdapter paramSearchResultAdapter) {}
  
  public void onClick(View paramView)
  {
    if ((SearchResultAdapter.a(this.a) != null) && (paramView.getTag() != null)) {
      SearchResultAdapter.a(this.a).a((chk)paramView.getTag());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chj
 * JD-Core Version:    0.7.0.1
 */