import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class esk
  extends XBaseAdapter
{
  CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public esk(QQLSActivity paramQQLSActivity) {}
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (!(paramViewGroup instanceof esn)) {}
    }
    for (paramViewGroup = (esn)paramViewGroup;; paramViewGroup = null)
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130903941, null);
        localObject = new esn();
        ((esn)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300141));
        ((esn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131300145));
        ((esn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a);
        ((esn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
        paramView.setTag(localObject);
      }
      ((esn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      ((esn)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.a);
      ((esn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      CustomWidgetUtil.a(((esn)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, 1, 0);
      return paramView;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll((List)paramArrayList.clone());
      notifyDataSetChanged();
    }
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
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) && (((RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a() == 1012)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    if (getItemViewType(paramInt) == 1)
    {
      paramView = a(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if ((paramView.getTag() instanceof esm)) {}
    }
    else
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130903940, null);
      paramView = new esm();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300141));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131300155));
      paramView.c = ((TextView)paramViewGroup.findViewById(2131300142));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131300145));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131300154));
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
    }
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    esm localesm = (esm)paramViewGroup.getTag();
    localesm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    paramInt = 0;
    if ((localRecentBaseData.a().equals(AppConstants.az)) || (localRecentBaseData.a().equals(AppConstants.aA))) {
      paramInt = 1;
    }
    int i;
    if (paramInt != 0)
    {
      paramInt = 0;
      i = 0;
      label228:
      if ((localRecentBaseData.a() != 0) && (localRecentBaseData.a() != 3000) && (localRecentBaseData.a() != 8)) {
        break label764;
      }
      if (i <= 0) {
        break label732;
      }
      localesm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.a(), localRecentBaseData.a());
      if ((paramView != null) && (paramView.size() > 0)) {
        break label529;
      }
      this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
      localesm.b.setTextColor(-4210755);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
      }
    }
    for (;;)
    {
      localesm.jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.a);
      localesm.b.setText(new QQText(this.jdField_a_of_type_JavaLangCharSequence, 5, 16, localRecentBaseData.a()));
      localesm.c.setText(localRecentBaseData.jdField_b_of_type_JavaLangString);
      if (localRecentBaseData.a() == 4000) {
        paramInt = ((NewFriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(33)).a();
      }
      localesm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      CustomWidgetUtil.a(localesm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, i + paramInt, 0);
      if (!localRecentBaseData.a().equals(AppConstants.aA))
      {
        paramView = paramViewGroup;
        if (!localRecentBaseData.a().equals(AppConstants.az)) {
          break;
        }
      }
      localesm.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      return paramViewGroup;
      paramInt = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.a(), localRecentBaseData.a());
      break label228;
      label529:
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + paramView.size());
      }
      Object localObject = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      long l1 = localRecentBaseData.a();
      long l2 = ((MessageRecord)paramView.get(paramView.size() - 1)).time;
      if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject).msgtype != -2016) && (((MessageRecord)localObject).msgtype != -2009) && (((MessageRecord)localObject).msgtype != -2026))
      {
        this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
        localesm.b.setTextColor(-4210755);
      }
      else
      {
        this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)paramView.get(paramView.size() - 1)).msg;
        localesm.b.setTextColor(-570319);
        continue;
        label732:
        localesm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
        localesm.b.setTextColor(-4210755);
        continue;
        label764:
        if ((localRecentBaseData.a() == 1001) || (localRecentBaseData.a() == 1010))
        {
          if (localRecentBaseData.a().equals(AppConstants.aA))
          {
            localRecentBaseData.a = BaseApplicationImpl.a().getString(2131370001);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.a().getString(2131370002);
            paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
            if (paramView.length() > 0)
            {
              paramView = paramView.split("\\|");
              if (paramView.length >= 4)
              {
                localRecentBaseData.a = paramView[2];
                this.jdField_a_of_type_JavaLangCharSequence = paramView[3];
              }
            }
          }
          for (;;)
          {
            localesm.b.setTextColor(-4210755);
            localesm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break;
            if (localRecentBaseData.a().equals(AppConstants.az))
            {
              localRecentBaseData.a = BaseApplicationImpl.a().getString(2131370003);
              this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.a().getString(2131370004);
              paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
              if (paramView.length() > 0)
              {
                paramView = paramView.split("\\|");
                if (paramView.length >= 4)
                {
                  localRecentBaseData.a = paramView[2];
                  this.jdField_a_of_type_JavaLangCharSequence = paramView[3];
                }
              }
            }
            else
            {
              QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
              localObject = ((FriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(8)).a(localMessage.senderuin);
              paramView = (View)localObject;
              if (localObject == null) {
                paramView = "";
              }
              this.jdField_a_of_type_JavaLangCharSequence = (paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessage, false));
            }
          }
        }
        this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
        localesm.b.setTextColor(-4210755);
        localesm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     esk
 * JD-Core Version:    0.7.0.1
 */