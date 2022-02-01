import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.List;

public class esl
  extends BaseAdapter
{
  public List a;
  
  public esl(QQLSActivity paramQQLSActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (!(paramViewGroup instanceof esp)) {}
    }
    for (paramViewGroup = (esp)paramViewGroup;; paramViewGroup = null)
    {
      Object localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130903943, null);
        localObject = new esp();
        ((esp)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300155));
        ((esp)localObject).jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        ((esp)localObject).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(10);
        ((esp)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        paramView.setTag(localObject);
      }
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        return paramView;
      }
      paramViewGroup = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a;
      ((esp)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
      return paramView;
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((List)((ArrayList)paramList).clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
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
    int j = 0;
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        i = j;
        if (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() == 1012) {
          i = 1;
        }
      }
    }
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1) {
      paramView = a(paramInt, paramView, paramViewGroup);
    }
    Object localObject1;
    do
    {
      return paramView;
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if ((paramView.getTag() instanceof eso)) {}
      }
      else
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130903942, null);
        paramView = new eso();
        localObject1 = (TextView)paramViewGroup.findViewById(2131300155);
        localObject2 = (ImageView)paramViewGroup.findViewById(2131300154);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setMaxLines(10);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
        paramViewGroup.setTag(paramView);
      }
      paramView = paramViewGroup;
    } while (paramInt >= this.jdField_a_of_type_JavaUtilList.size());
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2 = (eso)paramViewGroup.getTag();
    if (localMessageRecord.istroop == 7000)
    {
      paramView = (SubAccountManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(59);
      if (paramView == null) {
        break label886;
      }
    }
    label883:
    label886:
    for (paramView = paramView.c(localMessageRecord.frienduin);; paramView = null)
    {
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = localMessageRecord.frienduin;
      }
      paramView = (String)localObject1 + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
      for (;;)
      {
        localObject1 = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject1 = "";
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a.size() > 0) && (((String)localObject1).equals("")) && ((localMessageRecord.msgtype == -2016) || (localMessageRecord.msgtype == -2009) || (localMessageRecord.msgtype == -2026)))
        {
          localObject1 = localMessageRecord.msg;
          ((eso)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-570319);
          ((eso)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        for (;;)
        {
          ((eso)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(new QQText((CharSequence)localObject1, 5, 16, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a()));
          return paramViewGroup;
          if ((localMessageRecord.istroop == 1001) || (localMessageRecord.istroop == 1010))
          {
            localObject1 = ((FriendManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(8)).a(localMessageRecord.senderuin);
            paramView = (View)localObject1;
            if (localObject1 == null) {
              paramView = "";
            }
            Object localObject3;
            if (localMessageRecord.frienduin.equals(AppConstants.aA))
            {
              ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131300141)).setText(BaseApplicationImpl.a().getString(2131370001));
              localObject1 = BaseApplicationImpl.a().getString(2131370002);
              ((DragTextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131300145)).setVisibility(8);
              localObject3 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
              paramView = (View)localObject1;
              if (((String)localObject3).length() <= 0) {
                break label883;
              }
              localObject3 = ((String)localObject3).split("\\|");
              paramView = (View)localObject1;
              if (localObject3.length < 4) {
                break label883;
              }
              ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131300141)).setText(localObject3[2]);
              paramView = localObject3[3];
              break;
            }
            if (localMessageRecord.frienduin.equals(AppConstants.az))
            {
              ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131300141)).setText(BaseApplicationImpl.a().getString(2131370003));
              localObject1 = BaseApplicationImpl.a().getString(2131370004);
              ((DragTextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131300145)).setVisibility(8);
              localObject3 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
              paramView = (View)localObject1;
              if (((String)localObject3).length() <= 0) {
                break label883;
              }
              localObject3 = ((String)localObject3).split("\\|");
              paramView = (View)localObject1;
              if (localObject3.length < 4) {
                break label883;
              }
              ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131300141)).setText(localObject3[2]);
              paramView = localObject3[3];
              break;
            }
            paramView = paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
            break;
          }
          if (AnonymousChatHelper.a(localMessageRecord))
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131363837) + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
            break;
          }
          paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
          break;
          ((eso)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4210755);
          ((eso)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     esl
 * JD-Core Version:    0.7.0.1
 */