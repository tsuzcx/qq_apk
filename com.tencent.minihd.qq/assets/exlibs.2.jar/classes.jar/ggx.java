import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.ItemViewHolder;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;

public class ggx
  extends BaseAdapter
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private ggx(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ggw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      localView = paramView;
      if (paramView == null) {
        localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130903814, paramViewGroup, false);
      }
      paramView = (TextView)localView.findViewById(2131299721);
      paramView.setText(((ggw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((ggw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      localView.setFocusable(true);
      localView.setContentDescription(paramView.getText() + "搜索结果");
      return localView;
    case 2: 
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130903812, null);
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        paramView = new SearchBaseFragment.ItemViewHolder();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296657));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296660));
        paramView.d = ((TextView)paramViewGroup.findViewById(2131299720));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131299719));
        paramView.c = ((TextView)paramViewGroup.findViewById(2131296664));
        paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((ggw)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        paramView.jdField_b_of_type_Int = ((ggw)getItem(paramInt)).jdField_b_of_type_Int;
        paramViewGroup.setTag(paramView);
      }
      paramView = (SearchBaseFragment.ItemViewHolder)paramViewGroup.getTag();
      paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((ggw)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
      paramView.jdField_b_of_type_Int = ((ggw)getItem(paramInt)).jdField_b_of_type_Int;
      paramViewGroup.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(paramView, (ggw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)));
      return paramViewGroup;
    }
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130903813, paramViewGroup, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a = new ggv(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    }
    localView.setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a);
    localView.setContentDescription("查看更多" + this.jdField_a_of_type_JavaLangString + "搜索结果按钮");
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ggx
 * JD-Core Version:    0.7.0.1
 */