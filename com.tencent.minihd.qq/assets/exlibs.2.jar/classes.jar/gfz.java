import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.ItemViewHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class gfz
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  private gfz(ClassificationSearchFragment paramClassificationSearchFragment) {}
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 0) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    }
    gfy localgfy;
    do
    {
      do
      {
        return paramView;
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2130903812, null);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          paramView = new SearchBaseFragment.ItemViewHolder();
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296657));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296660));
          paramView.d = ((TextView)paramViewGroup.findViewById(2131299720));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131299719));
          paramView.c = ((TextView)paramViewGroup.findViewById(2131296664));
          paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
          paramView.jdField_b_of_type_Int = ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          paramViewGroup.setTag(paramView);
        }
        paramView = (SearchBaseFragment.ItemViewHolder)paramViewGroup.getTag();
        paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
        paramViewGroup.setContentDescription(ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment, paramView, (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt)));
        return paramViewGroup;
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2130903377, null);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          paramView = new gfy();
          paramViewGroup.setTag(paramView);
          paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296735));
          paramViewGroup.findViewById(2131297996).setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297997));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.b();
        localgfy = (gfy)paramViewGroup.getTag();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 3) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = true;
          localgfy.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localgfy.jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请稍后再试");
          return paramViewGroup;
        }
        paramView = paramViewGroup;
      } while (!NetworkUtil.e(BaseApplicationImpl.getContext()));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = false;
      localgfy.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localgfy.jdField_a_of_type_AndroidWidgetTextView.setText("载入中，请稍候...");
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.c, true);
      return paramViewGroup;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int == 2)
      {
        localgfy.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localgfy.jdField_a_of_type_AndroidWidgetTextView.setText("载入中，请稍候...");
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 4);
    localgfy.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    localgfy.jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请检查网络连接");
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfz
 * JD-Core Version:    0.7.0.1
 */