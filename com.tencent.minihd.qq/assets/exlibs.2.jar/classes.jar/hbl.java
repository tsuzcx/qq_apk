import QQService.EVIPSPEC;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.ViewHolder;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.ViewHolderLayoutParams;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class hbl
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  
  public hbl(SpecailCareListActivity paramSpecailCareListActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramSpecailCareListActivity.getSystemService("layout_inflater"));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_JavaUtilArrayList.size();
    if (i > 0) {
      return i;
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_JavaUtilArrayList.size()) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_JavaUtilArrayList.size() == 0) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (getItemViewType(paramInt) == 1)
    {
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904026, paramViewGroup, false);
      }
      paramView = ((View)localObject1).getLayoutParams();
      paramView.height = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
      paramView.width = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
      paramInt = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getManager(49)).c();
      paramView = (Button)((View)localObject1).findViewById(2131300550);
      if (QLog.isColorLevel()) {
        QLog.d("SpecialCare", 2, "getView  friends count = " + paramInt);
      }
      paramViewGroup = (TextView)((View)localObject1).findViewById(2131297963);
      localObject2 = (TextView)((View)localObject1).findViewById(2131297967);
      if (paramInt <= 0)
      {
        ((TextView)localObject2).setVisibility(8);
        paramView.setVisibility(8);
        paramView = (View)localObject1;
        return paramView;
      }
      ((TextView)localObject2).setVisibility(0);
      paramView.setVisibility(0);
      paramViewGroup.setText(2131369158);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      return localObject1;
    }
    if (paramView != null)
    {
      localObject1 = (SpecailCareListActivity.ViewHolder)paramView.getTag();
      label210:
      if (localObject1 != null) {
        break label1639;
      }
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904030, paramViewGroup, false);
      localObject1 = new SpecailCareListActivity.ViewHolder();
      paramViewGroup.setTag(localObject1);
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131300557));
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296551));
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297264));
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297265));
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297269));
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297263));
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131300558));
      ((SpecailCareListActivity.ViewHolder)localObject1).d = ((ImageView)paramViewGroup.findViewById(2131297211));
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams = new SpecailCareListActivity.ViewHolderLayoutParams();
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.a = ((RelativeLayout.LayoutParams)((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.getLayoutParams());
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.b = ((RelativeLayout.LayoutParams)((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.c = ((RelativeLayout.LayoutParams)((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.d = ((RelativeLayout.LayoutParams)((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.getLayoutParams());
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.e = ((RelativeLayout.LayoutParams)((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams());
      }
      localObject2 = (Friends)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)localObject2);
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_JavaLangString = ((Friends)localObject2).uin;
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setTag(((Friends)localObject2).uin);
      ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, ((Friends)localObject2).uin, 3000);
      label618:
      int m;
      if (paramView == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(((Friends)localObject2).uin, 1, true);
        }
        ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)ImageUtil.a());
        m = ContactUtils.a(((Friends)localObject2).detalStatusFlag, ((Friends)localObject2).iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.a(1);
        switch (m)
        {
        case 5: 
        case 6: 
        default: 
          paramView = paramView.a(((Friends)localObject2).getLastLoginType());
          if (paramView == null) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131368420);
          }
          break;
        }
      }
      for (;;)
      {
        label721:
        int j;
        label736:
        boolean bool2;
        boolean bool1;
        if ((m == 0) || (m == 6))
        {
          j = 1;
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText("[" + paramView + "]");
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((Friends)localObject2, (SpecailCareListActivity.ViewHolder)localObject1);
          bool2 = true;
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          i = 0;
          if (j != 0) {
            break label1327;
          }
          int k = ((Friends)localObject2).netTypeIconId;
          i = k;
          bool1 = bool2;
          if (m == 8)
          {
            i = k;
            bool1 = bool2;
            if ((((Friends)localObject2).abilityBits & 1L) == 0L)
            {
              if (((Friends)localObject2).netTypeIconIdIphoneOrWphoneNoWifi == 0) {
                break label1313;
              }
              i = ((Friends)localObject2).netTypeIconIdIphoneOrWphoneNoWifi;
              bool1 = bool2;
            }
          }
          label863:
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_Boolean = bool1;
          if (bool1)
          {
            i = ContactUtils.a(i);
            ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(i);
          }
          if ((j != 0) || ((!((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1333;
          }
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131427999));
          label951:
          if (!((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label1357;
          }
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.g);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842003, 0);
        }
        for (;;)
        {
          paramView = ContactUtils.a((Friends)localObject2);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c) {
            break label1415;
          }
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          ((SpecailCareListActivity.ViewHolder)localObject1).d.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams != null)
          {
            ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.a);
            ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.b);
            ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.c);
            ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.d);
            ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_b_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.e);
          }
          paramView = paramViewGroup;
          if (getItemViewType(paramInt) == 1) {
            break;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getDimensionPixelSize(2131493499);
          if (paramInt != 0) {
            break label1583;
          }
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130837958);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.setPadding(((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), i, ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
          return paramViewGroup;
          localObject1 = null;
          break label210;
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramView));
          break label618;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131368415);
          break label721;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131368416);
          break label721;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131368418);
          break label721;
          j = 0;
          break label736;
          label1313:
          i = ((Friends)localObject2).netTypeIconId;
          bool1 = bool2;
          break label863;
          label1327:
          bool1 = false;
          break label863;
          label1333:
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131427934));
          break label951;
          label1357:
          if (((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
          {
            ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.g);
            ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842130, 0);
          }
          else
          {
            ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          }
        }
        label1415:
        ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView = ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView;
        if (bool1) {}
        for (int i = 0;; i = 8)
        {
          paramView.setVisibility(i);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject1).d.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams == null) {
            break;
          }
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.a);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.b);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.c);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.d);
          ((SpecailCareListActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolderLayoutParams.e);
          break;
        }
        label1583:
        ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130837952);
        ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.setPadding(((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), ((SpecailCareListActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
        return paramViewGroup;
      }
      label1639:
      paramViewGroup = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbl
 * JD-Core Version:    0.7.0.1
 */