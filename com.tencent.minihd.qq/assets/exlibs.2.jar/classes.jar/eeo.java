import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class eeo
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View a;
  eep jdField_a_of_type_Eep;
  
  public eeo(HotChatListActivity paramHotChatListActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramHotChatListActivity.jdField_a_of_type_AndroidContentContext);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.b) || (!this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.c)) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.c) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.b) || (!this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.c))
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903588, null);
      paramView = (TextView)paramViewGroup.findViewById(2131298893);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.b) {
        paramView.setText(2131369499);
      }
      paramView = paramViewGroup;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.c)
      {
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
          paramView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297591);
          paramView.setCompoundDrawables(null, null, null, null);
          paramView.setText("\n当前网络不可用，请检查网络设置。");
          ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297590)).setImageResource(2130839226);
          paramView = this.jdField_a_of_type_AndroidViewView;
        }
      }
      return paramView;
    }
    String str;
    int i;
    int j;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903587, null);
      this.jdField_a_of_type_Eep = new eep(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity);
      this.jdField_a_of_type_Eep.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296551));
      this.jdField_a_of_type_Eep.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      this.jdField_a_of_type_Eep.b = ((TextView)paramView.findViewById(2131298883));
      paramView.setTag(this.jdField_a_of_type_Eep);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Eep.jdField_a_of_type_Int = paramInt;
      paramViewGroup = (Common.WifiPOIInfo)this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = paramViewGroup.bytes_name.get().toStringUtf8();
      i = paramViewGroup.uint32_visitor_num.get();
      j = paramViewGroup.uint32_face_id.get();
      if (!paramViewGroup.hot_theme_group_flag.has()) {
        break label521;
      }
    }
    label521:
    for (paramInt = paramViewGroup.hot_theme_group_flag.get();; paramInt = 0)
    {
      switch (paramInt)
      {
      default: 
        if (j == 2)
        {
          paramInt = 2130839225;
          label357:
          this.jdField_a_of_type_Eep.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
          this.jdField_a_of_type_Eep.jdField_a_of_type_AndroidWidgetTextView.setText(str);
          if (i <= 0) {
            break label506;
          }
          this.jdField_a_of_type_Eep.b.setText("(" + i + ")");
        }
        break;
      }
      for (;;)
      {
        paramView.setContentDescription(str + "热聊," + i + "位成员");
        return paramView;
        this.jdField_a_of_type_Eep = ((eep)paramView.getTag());
        break;
        paramInt = 2130839235;
        break label357;
        if (j == 1)
        {
          paramInt = 2130839227;
          break label357;
        }
        if (j == 3)
        {
          paramInt = 2130839230;
          break label357;
        }
        paramInt = 2130839227;
        break label357;
        label506:
        this.jdField_a_of_type_Eep.b.setText("");
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.b) || ((!this.jdField_a_of_type_ComTencentMobileqqActivityHotChatListActivity.c) && (this.jdField_a_of_type_AndroidViewView != null))) {
      return false;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eeo
 * JD-Core Version:    0.7.0.1
 */