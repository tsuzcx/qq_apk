import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.ShopListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class cat
  implements AbsListView.OnScrollListener
{
  public cat(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.t() == paramAbsListView.b() - 1) && (this.a.a.a)) {
      this.a.a.a();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cat
 * JD-Core Version:    0.7.0.1
 */