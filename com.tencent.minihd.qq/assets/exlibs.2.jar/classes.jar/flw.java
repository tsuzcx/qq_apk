import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.ListItem;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class flw
  extends FacePreloadBaseAdapter
{
  public flw(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
  }
  
  protected Object a(int paramInt)
  {
    return null;
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a.a != null) && (paramInt >= 0) && (paramInt < this.a.a.size())) {
      return this.a.a.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (UncommonlyUsedContactsActivity.ListItem)getItem(paramInt);
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      paramViewGroup = (flx)paramView.getTag();
      localView = paramView;
    }
    Object localObject2;
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131299844);
      localObject2 = localView.findViewById(2131297301);
      if (((UncommonlyUsedContactsActivity.ListItem)localObject1).c != 0) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString);
      paramView.setFocusable(true);
      paramView.setContentDescription(((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_b_of_type_Int = 0;
      paramViewGroup.jdField_b_of_type_JavaLangString = "";
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      return localView;
      localView = this.a.getLayoutInflater().inflate(2130903858, null);
      paramViewGroup = new flx(this.a, null);
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296551));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298883));
      paramViewGroup.c = ((TextView)localView.findViewById(2131298048));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131299005));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297505));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setTag(paramViewGroup);
    }
    ((View)localObject2).setVisibility(0);
    paramView.setVisibility(8);
    localObject1 = ((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataFriends;
    paramViewGroup.jdField_b_of_type_JavaLangString = ((Friends)localObject1).uin;
    if (!TextUtils.isEmpty(((Friends)localObject1).remark))
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).remark);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).remark);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).recommReason);
      if (((Friends)localObject1).age == 0) {
        break label737;
      }
      paramViewGroup.c.setText(String.valueOf(((Friends)localObject1).age));
      label350:
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      paramViewGroup.jdField_b_of_type_Int = 1;
      paramView = (UncommonlyUsedContactsActivity.ListItem)this.a.a.get(paramInt);
      switch (((Friends)localObject1).gender)
      {
      default: 
        paramViewGroup.c.setBackgroundResource(2130840435);
        paramInt = 0;
        label415:
        paramViewGroup.c.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
        if ((((Friends)localObject1).age == 0) && (paramInt == 0))
        {
          paramViewGroup.c.setVisibility(8);
          label447:
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((Friends)localObject1).uin));
          localObject2 = paramViewGroup.c;
          if (paramInt != 0) {
            break label789;
          }
          paramView = String.valueOf(((Friends)localObject1).age);
        }
        break;
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setContentDescription(paramView);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).recommReason);
      localView.setOnClickListener(this.a);
      return localView;
      if (!TextUtils.isEmpty(((Friends)localObject1).smartRemark))
      {
        if (!TextUtils.isEmpty(((Friends)localObject1).name))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
          label547:
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((Friends)localObject1).smartRemark + ")");
          localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
            break label641;
          }
        }
        label641:
        for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
        {
          ((TextView)localObject2).setContentDescription(paramView);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).smartRemark);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
          break label547;
        }
      }
      if (!TextUtils.isEmpty(((Friends)localObject1).name))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
        label673:
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
          break label728;
        }
      }
      label728:
      for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
      {
        ((TextView)localObject2).setContentDescription(paramView);
        break;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
        break label673;
      }
      label737:
      paramViewGroup.c.setText(null);
      break label350;
      paramInt = 2130838484;
      paramViewGroup.c.setBackgroundResource(2130840435);
      break label415;
      paramInt = 2130838479;
      paramViewGroup.c.setBackgroundResource(2130840431);
      break label415;
      paramViewGroup.c.setVisibility(0);
      break label447;
      label789:
      if (((Friends)localObject1).gender == 1) {
        paramView = "男" + ((Friends)localObject1).age;
      } else {
        paramView = "女" + ((Friends)localObject1).age;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     flw
 * JD-Core Version:    0.7.0.1
 */