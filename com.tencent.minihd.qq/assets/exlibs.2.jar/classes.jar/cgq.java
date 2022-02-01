import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.widgets.ActiveSearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

public class cgq
  implements ActiveSearchTipsContainer.OnTipClickListener
{
  public cgq(SearchActivity paramSearchActivity) {}
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      SearchActivity.a(this.a, 3);
      this.a.a(paramString);
      SearchProtocol.a(this.a.app, this.a, SearchActivity.a(this.a), paramString, SearchActivity.a(this.a));
      this.a.c(paramString);
      this.a.a(true);
      Iterator localIterator = SearchActivity.b(this.a).iterator();
      while (localIterator.hasNext())
      {
        SearchProtocol.WordItem localWordItem = (SearchProtocol.WordItem)localIterator.next();
        if (paramString.equals(localWordItem.word))
        {
          SearchActivity.a(this.a, localWordItem.id);
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004AB4", "0X8004AB4", 0, 0, localWordItem.id, null, null, null);
          ReportController.b(null, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "1", null, null, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgq
 * JD-Core Version:    0.7.0.1
 */