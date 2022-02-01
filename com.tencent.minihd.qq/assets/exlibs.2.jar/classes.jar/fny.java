import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class fny
  extends GridListView.GridListAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b = false;
  
  public fny(VisitorsActivity paramVisitorsActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private View a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903358, paramViewGroup, false);
    fnw localfnw = new fnw();
    localfnw.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131297919));
    localfnw.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296551));
    localfnw.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297920));
    localfnw.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297264));
    localfnw.c = ((TextView)paramViewGroup.findViewById(2131297922));
    localfnw.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297921));
    localfnw.d = ((TextView)paramViewGroup.findViewById(2131297923));
    paramViewGroup.setTag(localfnw);
    return paramViewGroup;
  }
  
  private void a(int paramInt, fnw paramfnw)
  {
    CardProfile localCardProfile = (CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    String str = String.valueOf(localCardProfile.getLEctID());
    Object localObject = StringUtil.e(String.valueOf(localCardProfile.getStrNick()));
    paramfnw.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (localCardProfile.getBAge() > 0)
    {
      paramfnw.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localCardProfile.getBAge()));
      localObject = paramfnw.jdField_b_of_type_AndroidWidgetTextView;
      if (localCardProfile.getBSex() != 0) {
        break label254;
      }
      i = 2130838484;
      label85:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (localCardProfile.getBSex() != 0) {
        break label260;
      }
      paramfnw.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840435);
      label111:
      if (localCardProfile.getBConstellation() != 0) {
        break label272;
      }
      paramfnw.c.setVisibility(8);
      label128:
      a(paramfnw, localCardProfile);
      PeopleAroundAdapter.a(localCardProfile.stVipInfo, paramfnw.jdField_b_of_type_AndroidWidgetImageView, paramfnw.jdField_a_of_type_AndroidWidgetTextView);
      localObject = (RelativeLayout.LayoutParams)paramfnw.d.getLayoutParams();
      if (paramfnw.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label307;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramfnw.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramfnw.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a.put(str, paramfnw.jdField_a_of_type_AndroidWidgetImageView);
      paramfnw.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, localCardProfile.getWFace(), paramfnw.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramfnw.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label254:
      i = 2130838479;
      break label85;
      label260:
      paramfnw.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840431);
      break label111;
      label272:
      paramfnw.c.setText(ProfileCardUtil.a(localCardProfile.getBConstellation()));
      paramfnw.c.setBackgroundResource(2130840447);
      paramfnw.c.setVisibility(0);
      break label128;
      label307:
      if (paramfnw.c.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramfnw.c.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramfnw.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
      }
    }
  }
  
  private void a(fnw paramfnw, CardProfile paramCardProfile)
  {
    TextView localTextView = paramfnw.d;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramfnw.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      localLayoutParams.addRule(3, paramfnw.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams(localLayoutParams);
      paramCardProfile = paramCardProfile.getRichStatus();
      if ((paramCardProfile == null) || (paramCardProfile.a())) {
        break label157;
      }
      if (TextUtils.isEmpty(paramCardProfile.c)) {
        break label146;
      }
      VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity, localTextView, paramCardProfile.b);
    }
    for (;;)
    {
      paramfnw.jdField_a_of_type_Int = paramCardProfile.b;
      localTextView.setText(paramCardProfile.a(null));
      localTextView.setVisibility(0);
      return;
      if (paramfnw.c.getVisibility() == 0)
      {
        localLayoutParams.addRule(3, paramfnw.c.getId());
        break;
      }
      localLayoutParams.addRule(3, paramfnw.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
      label146:
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    label157:
    paramfnw.jdField_a_of_type_Int = 0;
    localTextView.setVisibility(8);
  }
  
  private void a(fnx paramfnx)
  {
    int j = 8;
    Object localObject = paramfnx.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131368842;
      ((TextView)localObject).setText(i);
      localObject = paramfnx.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label73;
      }
      i = 0;
      label40:
      ((ProgressBar)localObject).setVisibility(i);
      paramfnx = paramfnx.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label79;
      }
    }
    label73:
    label79:
    for (int i = j;; i = 0)
    {
      paramfnx.setVisibility(i);
      return;
      i = 2131366569;
      break;
      i = 8;
      break label40;
    }
  }
  
  private View b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903377, null);
    fnx localfnx = new fnx();
    localfnx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297997));
    localfnx.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296735));
    localfnx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297996));
    paramViewGroup.setTag(localfnx);
    return paramViewGroup;
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramArrayList.clone());
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public int b(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i == 0) {
      return 0;
    }
    return i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      return -1L;
    }
    return ((CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).lEctID;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 0;
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
    {
      if (this.b) {
        i = 1;
      }
    }
    else {
      return i;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      if (paramInt > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = paramInt;
      }
      localView = paramView;
      if (paramView == null) {
        localView = a(paramViewGroup, paramInt);
      }
      a(paramInt, (fnw)localView.getTag());
      return localView;
    case 1: 
      localView = paramView;
      if (paramView == null) {
        localView = b(paramViewGroup, paramInt);
      }
      a((fnx)localView.getTag());
      return localView;
    }
    View localView = paramView;
    if (paramView == null)
    {
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903968, null);
    }
    ((TextView)localView.findViewById(2131300293)).setText(this.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      return !this.jdField_a_of_type_Boolean;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fny
 * JD-Core Version:    0.7.0.1
 */