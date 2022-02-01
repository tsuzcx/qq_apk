import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;

public class ian
  extends BaseAdapter
{
  private String jdField_a_of_type_JavaLangString = null;
  private List jdField_a_of_type_JavaUtilList = null;
  
  public ian(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  private void a()
  {
    Iterator localIterator;
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        appoint_define.LocaleInfo localLocaleInfo = (appoint_define.LocaleInfo)localIterator.next();
        if ((localLocaleInfo.str_name != null) && (this.jdField_a_of_type_JavaLangString.equals(localLocaleInfo.str_name.get()))) {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private boolean a(appoint_define.LocaleInfo paramLocaleInfo1, appoint_define.LocaleInfo paramLocaleInfo2)
  {
    paramLocaleInfo1 = paramLocaleInfo1.str_name.get();
    paramLocaleInfo2 = paramLocaleInfo2.str_name.get();
    if ((paramLocaleInfo1 == null) || (paramLocaleInfo2 == null)) {
      return false;
    }
    return paramLocaleInfo1.equals(paramLocaleInfo2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
    notifyDataSetChanged();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        j = this.jdField_a_of_type_JavaUtilList.size();
      }
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_JavaLangString != null)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      int i = paramInt;
      if (this.jdField_a_of_type_JavaLangString != null) {
        i = paramInt - 1;
      }
      return (appoint_define.LocaleInfo)localList.get(i);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.getLayoutInflater().inflate(2130903875, paramViewGroup, false);
      localView.setTag(new iao(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity, (TextView)localView.findViewById(2131299927), (TextView)localView.findViewById(2131299926), (ImageView)localView.findViewById(2131299924)));
    }
    if (getCount() == 1) {
      localView.setBackgroundResource(2130838151);
    }
    for (;;)
    {
      paramView = (iao)localView.getTag();
      if ((paramInt != 0) || (this.jdField_a_of_type_JavaLangString == null)) {
        break label246;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      paramView.b.setText("故乡");
      localView.setContentDescription(this.jdField_a_of_type_JavaLangString + " 你的故乡 连按两次选为目的地");
      if (DatingDestinationActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity) != 2) {
        break;
      }
      paramView.b.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return localView;
      if (paramInt == 0) {
        localView.setBackgroundResource(2130838156);
      } else if (paramInt == getCount() - 1) {
        localView.setBackgroundResource(2130838153);
      } else {
        localView.setBackgroundResource(2130838155);
      }
    }
    paramView.b.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return localView;
    label246:
    paramViewGroup = (appoint_define.LocaleInfo)getItem(paramInt);
    paramView.b.setVisibility(8);
    paramView.b.setText("");
    String str = paramViewGroup.str_name.get();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localView.setContentDescription(str + " 连按两次选为目的地");
    if ((DatingDestinationActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity) == 3) && (a(paramViewGroup, DatingDestinationActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity))))
    {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return localView;
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ian
 * JD-Core Version:    0.7.0.1
 */