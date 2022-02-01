import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class jta
  implements AdapterView.OnItemClickListener
{
  public jta(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!NetworkUtil.e(this.a))
    {
      QQToast.a(this.a, this.a.getString(2131365730), 0).b(this.a.getTitleBarHeight());
      return;
    }
    paramAdapterView = (StatusHistoryActivity.ItemViewHolder)paramAdapterView.getTag();
    if (((String)paramAdapterView.b.get(paramInt)).equals(StatusHistoryActivity.a))
    {
      paramAdapterView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.a = false;
      paramView = (SignatureHandler)this.a.app.a(43);
      if ((paramView != null) && (!((Boolean)StatusHistoryActivity.a(this.a).get(paramAdapterView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f)).booleanValue())) {
        paramView.a(StatusHistoryActivity.a(this.a), paramAdapterView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.f, 255, false);
      }
      paramAdapterView.b.clear();
      if (paramAdapterView.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramView = paramAdapterView.jdField_a_of_type_JavaUtilList.iterator();
        while (paramView.hasNext())
        {
          String str = (String)paramView.next();
          paramAdapterView.b.add(str);
        }
      }
      paramAdapterView.jdField_a_of_type_Jtc.notifyDataSetChanged();
      this.a.a(false, 0L);
      return;
    }
    paramView = new Intent(this.a, FriendProfileCardActivity.class);
    paramView.putExtra("AllInOne", new ProfileActivity.AllInOne((String)paramAdapterView.b.get(paramInt), 5));
    this.a.startActivity(paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "signiture", "his_clk_frdpp", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jta
 * JD-Core Version:    0.7.0.1
 */