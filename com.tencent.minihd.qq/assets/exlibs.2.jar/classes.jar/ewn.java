import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RecommendedGatherListActivity;
import com.tencent.mobileqq.adapter.BaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ewn
  extends BaseFacePreloadExpandableListAdapter
{
  public ewn(RecommendedGatherListActivity paramRecommendedGatherListActivity, Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
  }
  
  public int a()
  {
    return 2130903857;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (ewl)getChild(paramInt1, paramInt2);
    View localView;
    Friends localFriends;
    label274:
    if ((paramView != null) && (paramView.getTag() != null))
    {
      paramViewGroup = (ewm)paramView.getTag();
      localView = paramView;
      localView.findViewById(2131297301).setVisibility(0);
      localFriends = ((ewl)localObject).jdField_a_of_type_ComTencentMobileqqDataFriends;
      paramViewGroup.jdField_b_of_type_JavaLangString = localFriends.uin;
      a(paramViewGroup, null);
      paramViewGroup.jdField_a_of_type_JavaLangString = String.valueOf(localFriends.groupid);
      if (TextUtils.isEmpty(localFriends.remark)) {
        break label465;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFriends.remark);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localFriends.remark);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(localFriends.recommReason);
      if (localFriends.age == 0) {
        break label698;
      }
      paramViewGroup.c.setText(String.valueOf(localFriends.age));
      label165:
      paramViewGroup.jdField_a_of_type_Int = paramInt2;
      if (!((ewl)localObject).jdField_a_of_type_Boolean) {
        break label710;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838502);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("已选定");
      label199:
      switch (localFriends.gender)
      {
      default: 
        paramViewGroup.c.setBackgroundResource(2130840435);
        paramInt1 = 0;
        label240:
        paramViewGroup.c.setCompoundDrawablesWithIntrinsicBounds(paramInt1, 0, 0, 0);
        if ((localFriends.age == 0) && (paramInt1 == 0))
        {
          paramViewGroup.c.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = paramViewGroup.c;
          if (paramInt1 != 0) {
            break label777;
          }
          paramView = String.valueOf(localFriends.age);
        }
        break;
      }
    }
    for (;;)
    {
      ((TextView)localObject).setContentDescription(paramView);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(localFriends.recommReason);
      localView.setOnClickListener(this.a);
      return localView;
      localView = this.a.getLayoutInflater().inflate(2130903858, paramViewGroup, false);
      paramViewGroup = new ewm(this.a, null);
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296551));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297505));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298883));
      paramViewGroup.c = ((TextView)localView.findViewById(2131298048));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131299005));
      localView.setTag(paramViewGroup);
      break;
      label465:
      label500:
      TextView localTextView;
      if (!TextUtils.isEmpty(localFriends.smartRemark))
      {
        if (!TextUtils.isEmpty(localFriends.name))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFriends.name);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("(" + localFriends.smartRemark + ")");
          localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(localFriends.name)) {
            break label598;
          }
        }
        label598:
        for (paramView = localFriends.uin;; paramView = localFriends.name)
        {
          localTextView.setContentDescription(paramView);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(localFriends.smartRemark);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFriends.uin);
          break label500;
        }
      }
      if (!TextUtils.isEmpty(localFriends.name))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFriends.name);
        label631:
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(localFriends.name)) {
          break label689;
        }
      }
      label689:
      for (paramView = localFriends.uin;; paramView = localFriends.name)
      {
        localTextView.setContentDescription(paramView);
        break;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFriends.uin);
        break label631;
      }
      label698:
      paramViewGroup.c.setText(null);
      break label165;
      label710:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838500);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("未选定");
      break label199;
      paramInt1 = 2130838484;
      paramViewGroup.c.setBackgroundResource(2130840435);
      break label240;
      paramInt1 = 2130838479;
      paramViewGroup.c.setBackgroundResource(2130840431);
      break label240;
      paramViewGroup.c.setVisibility(0);
      break label274;
      label777:
      if (localFriends.gender == 1) {
        paramView = "男" + localFriends.age;
      } else {
        paramView = "女" + localFriends.age;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    ewj localewj = (ewj)paramView.getTag();
    if (localewj == null)
    {
      localewj = new ewj(this.a, null);
      paramView.findViewById(2131297233).setVisibility(0);
      localewj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297234));
      localewj.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299843));
      localewj.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ewo(this));
      localewj.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new ewp(this));
      paramView.setTag(localewj);
    }
    for (;;)
    {
      ewk localewk = (ewk)getGroup(paramInt);
      localewj.jdField_a_of_type_AndroidWidgetTextView.setText(localewk.jdField_b_of_type_JavaLangString);
      paramView.setContentDescription(localewk.jdField_b_of_type_JavaLangString);
      localewj.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localewk.jdField_a_of_type_Int));
      if (((ewk)RecommendedGatherListActivity.a(this.a).get(localewk.jdField_a_of_type_Int)).jdField_a_of_type_Boolean)
      {
        localewj.jdField_b_of_type_AndroidWidgetTextView.setText("取消选择");
        localewj.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("取消选择");
        return;
      }
      localewj.jdField_b_of_type_AndroidWidgetTextView.setText("选择");
      localewj.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("选择");
      return;
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((ArrayList)RecommendedGatherListActivity.a(this.a).get(((ewk)RecommendedGatherListActivity.a(this.a).get(paramInt1)).jdField_a_of_type_JavaLangString)).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    if ((localObject instanceof Friends))
    {
      localObject = (Friends)localObject;
      try
      {
        long l = Long.parseLong(((Friends)localObject).uin);
        return l;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RecommendedGatherListActivity", 2, QLog.getStackTraceString(localThrowable));
        }
      }
    }
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt1, paramInt2, paramView, paramViewGroup);
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((ArrayList)RecommendedGatherListActivity.a(this.a).get(((ewk)RecommendedGatherListActivity.a(this.a).get(paramInt)).jdField_a_of_type_JavaLangString)).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return RecommendedGatherListActivity.a(this.a).get(paramInt);
  }
  
  public int getGroupCount()
  {
    return RecommendedGatherListActivity.a(this.a).size();
  }
  
  public long getGroupId(int paramInt)
  {
    return Long.valueOf(((ewk)getGroup(paramInt)).jdField_a_of_type_JavaLangString).longValue();
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (ewj)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (ewk)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((ewk)localObject).jdField_b_of_type_JavaLangString);
      if (!((ewk)localObject).jdField_a_of_type_Boolean) {
        break label186;
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText("取消选择");
      paramView.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("取消选择");
    }
    for (;;)
    {
      paramView.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(paramView.jdField_a_of_type_Int));
      paramView.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.a);
      paramViewGroup.setContentDescription(((ewk)localObject).jdField_b_of_type_JavaLangString);
      paramViewGroup.setOnClickListener(this.a);
      return paramViewGroup;
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903857, paramViewGroup, false);
      paramView = new ewj(this.a, null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297234));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131299843));
      paramViewGroup.setTag(paramView);
      break;
      label186:
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText("选择");
      paramView.jdField_b_of_type_AndroidWidgetTextView.setContentDescription("选择");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ewn
 * JD-Core Version:    0.7.0.1
 */