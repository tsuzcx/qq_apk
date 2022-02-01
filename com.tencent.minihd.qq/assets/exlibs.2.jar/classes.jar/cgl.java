import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchActivity.SearchAsociatedWordAdapter;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.lebasearch.SearchResultAdapter;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class cgl
  implements SearchProtocol.SearchObserver
{
  public cgl(SearchActivity paramSearchActivity) {}
  
  public void a(int paramInt, SearchProtocol.WordItem paramWordItem)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSearch", 2, "home hot word = " + paramWordItem.word);
      }
      SearchActivity.a(this.a, paramWordItem);
      SearchActivity.a(this.a);
    }
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList.add(0, SearchActivity.a(this.a).getText().toString());
      if (SearchActivity.b(this.a).a() != null) {
        break label79;
      }
      paramArrayList = new SearchActivity.SearchAsociatedWordAdapter(this.a, paramArrayList);
      SearchActivity.b(this.a).setAdapter(paramArrayList);
    }
    for (;;)
    {
      this.a.c(3);
      return;
      label79:
      if ((SearchActivity.b(this.a).a() instanceof HeaderViewListAdapter)) {
        ((SearchActivity.SearchAsociatedWordAdapter)((HeaderViewListAdapter)SearchActivity.b(this.a).a()).getWrappedAdapter()).a(paramArrayList);
      } else {
        ((SearchActivity.SearchAsociatedWordAdapter)SearchActivity.b(this.a).a()).a(paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSearch", 2, "hot words size: " + paramList.size());
      }
      SearchActivity.a(this.a, paramList);
      SearchActivity.a(this.a, true);
    }
  }
  
  public void a(int paramInt, JSONArray paramJSONArray)
  {
    this.a.a(false);
    if ((paramInt == 0) && (paramJSONArray != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSearch", 2, "results: " + paramJSONArray.toString());
      }
      SizeMeasure.b(this.a.getBaseContext());
      if (paramJSONArray.length() == 0) {
        break label175;
      }
      if (SearchActivity.a(this.a) != null) {
        break label161;
      }
      SearchActivity.a(this.a, new SearchResultAdapter(this.a, SearchActivity.a(this.a), paramJSONArray, this.a));
      SearchActivity.a(this.a).setAdapter(SearchActivity.a(this.a));
      SearchActivity.a(this.a).post(new cgm(this));
    }
    for (;;)
    {
      this.a.c(2);
      this.a.a(paramInt);
      return;
      label161:
      SearchActivity.a(this.a).a(paramJSONArray);
      break;
      label175:
      this.a.a(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgl
 * JD-Core Version:    0.7.0.1
 */