import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.search.ContactsSearchableCircleBuddy;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XListView;

public class gxl
  implements ConversationSearchAdapter.SearchResultCallBack
{
  public gxl(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(int paramInt)
  {
    if (1 == paramInt)
    {
      if (SelectMemberActivity.a(this.a).getCount() != 0) {
        break label83;
      }
      SelectMemberActivity.a(this.a).setVisibility(0);
      this.a.a.setVisibility(8);
    }
    for (;;)
    {
      if (ContactsSearchableCircleBuddy.a) {
        ReportController.b(this.a.app, "CliOper", "", "", "Network_circle", "Search_circle_exp", 82, 0, "", "", "", "");
      }
      ContactsSearchableCircleBuddy.a = false;
      return;
      label83:
      SelectMemberActivity.a(this.a).setVisibility(8);
      this.a.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gxl
 * JD-Core Version:    0.7.0.1
 */