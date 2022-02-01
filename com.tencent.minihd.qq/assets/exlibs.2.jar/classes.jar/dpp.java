import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.HashMap;
import java.util.List;

public class dpp
  extends BaseAdapter
{
  private FriendsManagerImp jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = null;
  
  public dpp(ChatSettingForHotChat paramChatSettingForHotChat)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = ((FriendsManagerImp)paramChatSettingForHotChat.app.getManager(8));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new RelativeLayout(paramViewGroup.getContext());
      paramView = new ImageView(paramViewGroup.getContext());
      paramView.setId(2131296551);
      paramView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ((RelativeLayout)localObject).addView(paramView);
    }
    ((View)localObject).setVisibility(0);
    ((View)localObject).setFocusable(false);
    ImageView localImageView = (ImageView)((View)localObject).findViewById(2131296551);
    localImageView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    localImageView.setImageResource(2130840087);
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.jdField_a_of_type_JavaUtilList.get(paramInt);
    String str = (String)localHashMap.get("memberUin");
    paramViewGroup = (String)localHashMap.get("memberName");
    if (TextUtils.isEmpty(str)) {
      localImageView.setImageDrawable(ImageUtil.b());
    }
    for (;;)
    {
      ((View)localObject).requestLayout();
      return localObject;
      paramView = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup))
      {
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp != null)
        {
          Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.c(str);
          paramView = paramViewGroup;
          if (localFriends != null)
          {
            paramView = paramViewGroup;
            if (localFriends.isFriend()) {
              paramView = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.b(str);
            }
          }
        }
      }
      paramViewGroup = paramView;
      if (TextUtils.isEmpty(paramView)) {
        paramViewGroup = str;
      }
      if (localHashMap.containsKey("faceId")) {
        ((Short)localHashMap.get("faceId")).shortValue();
      }
      localImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat.app.b(str));
      localImageView.setTag(str);
      localImageView.setTag(2131296529, paramViewGroup);
      localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForHotChat);
      localImageView.setContentDescription(paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpp
 * JD-Core Version:    0.7.0.1
 */