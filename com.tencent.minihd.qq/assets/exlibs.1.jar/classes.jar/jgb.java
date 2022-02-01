import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.maproam.data.LocationDetail;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;
import java.util.List;

public class jgb
  extends BaseAdapter
{
  public boolean a;
  public boolean b = false;
  
  public jgb(RoamSearchDialog paramRoamSearchDialog) {}
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.size();
    if (this.b) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_JavaUtilList.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 8;
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      localObject = paramView;
      return localObject;
    case 0: 
      LocationDetail localLocationDetail = (LocationDetail)getItem(paramInt);
      if ((paramView == null) || (!(paramView instanceof RelativeLayout)))
      {
        paramView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidContentContext, 2130904095, null);
        paramViewGroup = new jga(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297001));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131300824));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLocationDetail.b);
        paramViewGroup.b.setText(localLocationDetail.c);
        if (TextUtils.isEmpty(localLocationDetail.b)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        localObject = paramView;
        if (!TextUtils.isEmpty(localLocationDetail.c)) {
          break;
        }
        paramViewGroup.b.setVisibility(8);
        return paramView;
        paramViewGroup = (jga)paramView.getTag();
      }
    }
    if ((paramView == null) || (!(paramView instanceof LinearLayout)))
    {
      paramView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog.jdField_a_of_type_AndroidContentContext, 2130903377, null);
      paramViewGroup = new jga(null);
      paramView.setTag(paramViewGroup);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131297997));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131296735));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297996));
      if ((paramView != null) && ((paramView instanceof LinearLayout))) {
        ((LinearLayout)paramView).setOrientation(0);
      }
      localObject = paramViewGroup.c;
      if (!this.jdField_a_of_type_Boolean) {
        break label382;
      }
      paramInt = 2131366571;
      label322:
      ((TextView)localObject).setText(paramInt);
      localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label388;
      }
      paramInt = 0;
      label343:
      ((ProgressBar)localObject).setVisibility(paramInt);
      paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label394;
      }
    }
    label388:
    label394:
    for (paramInt = i;; paramInt = 0)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (jga)paramView.getTag();
      break;
      label382:
      paramInt = 2131366569;
      break label322;
      paramInt = 8;
      break label343;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jgb
 * JD-Core Version:    0.7.0.1
 */