package com.tencent.mobileqq.activity.recent;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import gvr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendAdapter
  extends PagerAdapter
{
  private static final int jdField_a_of_type_Int = 50;
  public static final String a = "RecommendAdapter";
  private static final int jdField_b_of_type_Int = 6;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new gvr(this);
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private List jdField_a_of_type_JavaUtilList = null;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131297249, 2131297250, 2131297251, 2131297252, 2131297253, 2131297254 };
  private final int[] jdField_b_of_type_ArrayOfInt;
  private final int[] c = { 2131297311, 2131297314, 2131297317, 2131297320, 2131297323, 2131297326 };
  private final int[] d = { 2131297310, 2131297313, 2131297316, 2131297319, 2131297322, 2131297325 };
  
  public RecommendAdapter(QQAppInterface paramQQAppInterface)
  {
    this.b = new int[] { 2131297309, 2131297312, 2131297315, 2131297318, 2131297321, 2131297324 };
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public void a()
  {
    a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(OnRecentUserOpsListener paramOnRecentUserOpsListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    a(null);
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(50);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|updateItem");
    }
    if (paramView == null) {
      return false;
    }
    int j = 0;
    if (j < 6)
    {
      Object localObject2 = paramView.findViewById(this.jdField_a_of_type_ArrayOfInt[j]);
      Object localObject1;
      ImageView localImageView;
      Bitmap localBitmap;
      label117:
      int i;
      if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0))
      {
        localObject1 = (String)((View)localObject2).getTag();
        localImageView = (ImageView)((View)localObject2).findViewWithTag("head");
        TextView localTextView = (TextView)((View)localObject2).findViewWithTag("name");
        localObject2 = (ImageView)((View)localObject2).findViewWithTag("icon");
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject1, (byte)3, true);
        if (localBitmap != null) {
          break label312;
        }
        localTextView.setText(ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1));
        localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).c((String)localObject1);
        if (localObject1 != null)
        {
          int m = ContactUtils.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType);
          int k = ((Friends)localObject1).netTypeIconId;
          i = k;
          if (m == 8)
          {
            i = k;
            if ((((Friends)localObject1).abilityBits & 1L) == 0L)
            {
              if (((Friends)localObject1).netTypeIconIdIphoneOrWphoneNoWifi == 0) {
                break label322;
              }
              i = ((Friends)localObject1).netTypeIconIdIphoneOrWphoneNoWifi;
            }
          }
          switch (i)
          {
          default: 
            label216:
            i = 2130840103;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          ((ImageView)localObject2).setImageResource(i);
        }
        j += 1;
        break;
        label312:
        localImageView.setImageBitmap(localBitmap);
        break label117;
        label322:
        i = ((Friends)localObject1).netTypeIconId;
        break label216;
        i = 2130840111;
        continue;
        i = 2130840103;
        continue;
        i = 2130840105;
        continue;
        i = 2130840107;
        continue;
        i = 2130842051;
        continue;
        i = 2130840109;
        continue;
        i = 2130842044;
        continue;
        i = 2130842047;
      }
    }
    return true;
  }
  
  public boolean a(View paramView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|updateItem uin: " + paramString);
    }
    if ((paramView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      localObject = paramView.findViewWithTag(paramString);
    } while (localObject == null);
    paramView = (ImageView)((View)localObject).findViewWithTag("head");
    Object localObject = (TextView)((View)localObject).findViewWithTag("name");
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, (byte)3, true);
    if (localBitmap == null) {}
    for (;;)
    {
      ((TextView)localObject).setText(ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
      return true;
      paramView.setImageBitmap(localBitmap);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int j = a() / 6;
    if (a() % 6 == 0) {}
    for (int i = 0;; i = 1) {
      return i + j;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendAdapter", 2, "RecommendAdapter|instantiateItem position: " + paramInt);
    }
    if (a() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendAdapter", 2, "RecommendAdapter|instantiateItem data list is empty!");
      }
      return null;
    }
    int j = a() / 6;
    int i;
    if (a() % 6 == 0)
    {
      i = 0;
      j += i;
      if (a() % 6 != 0) {
        break label609;
      }
      i = 6;
      label94:
      if (j <= 1) {
        break label752;
      }
    }
    label150:
    label471:
    label609:
    label743:
    label752:
    for (int k = paramInt * 6;; k = 0)
    {
      if ((j == 1) || (paramInt == j - 1)) {}
      for (;;)
      {
        View localView1 = View.inflate(paramViewGroup.getContext(), 2130903199, null);
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        int m = 0;
        paramInt = i;
        View localView2;
        ImageView localImageView1;
        TextView localTextView;
        ImageView localImageView2;
        String str;
        Object localObject;
        Friends localFriends;
        if (m < i)
        {
          localView2 = localView1.findViewById(this.jdField_a_of_type_ArrayOfInt[m]);
          localImageView1 = (ImageView)localView1.findViewById(this.b[m]);
          localTextView = (TextView)localView1.findViewById(this.c[m]);
          localImageView2 = (ImageView)localView1.findViewById(this.d[m]);
          str = ((Long)this.jdField_a_of_type_JavaUtilList.get(k + m)).toString();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, (byte)3, true);
          if (localObject == null)
          {
            localObject = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
            localTextView.setText((CharSequence)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("RecommendAdapter", 2, "RecommendAdater|instantiateItem uin: " + str + ", name: " + (String)localObject);
            }
            localFriends = localFriendsManager.c(str);
            if (localFriends == null) {
              break label688;
            }
            paramInt = ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
            j = localFriends.netTypeIconId;
            if ((paramInt != 8) || ((localFriends.abilityBits & 1L) != 0L)) {
              break label743;
            }
            if (localFriends.netTypeIconIdIphoneOrWphoneNoWifi == 0) {
              break label630;
            }
            j = localFriends.netTypeIconIdIphoneOrWphoneNoWifi;
          }
        }
        for (;;)
        {
          switch (j)
          {
          default: 
            paramInt = 2130840103;
            localImageView2.setImageResource(paramInt);
            if (QLog.isColorLevel()) {
              QLog.d("RecommendAdapter", 2, "RecommendAdater|instantiateItem networkType: " + j + ", resId: " + paramInt);
            }
            break;
          }
          for (;;)
          {
            localImageView1.setTag("head");
            localTextView.setTag("name");
            localImageView2.setTag("icon");
            localView2.setTag(str);
            localView2.setVisibility(0);
            localView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView2.setContentDescription("点击向" + (String)localObject + "发起QQ通话");
            m += 1;
            break label150;
            i = 1;
            break;
            i = a() % 6;
            break label94;
            localImageView1.setImageBitmap((Bitmap)localObject);
            break label263;
            label630:
            j = localFriends.netTypeIconId;
            break label393;
            paramInt = 2130840111;
            break label471;
            paramInt = 2130840103;
            break label471;
            paramInt = 2130840105;
            break label471;
            paramInt = 2130840107;
            break label471;
            paramInt = 2130842051;
            break label471;
            paramInt = 2130840109;
            break label471;
            paramInt = 2130842044;
            break label471;
            paramInt = 2130842047;
            break label471;
            if (QLog.isColorLevel()) {
              QLog.d("RecommendAdapter", 2, "RecommendAdater|instantiateItem cannot find friend!");
            }
          }
          while (paramInt < 6)
          {
            localView1.findViewById(this.jdField_a_of_type_ArrayOfInt[paramInt]).setVisibility(4);
            paramInt += 1;
          }
          paramViewGroup.addView(localView1);
          return localView1;
        }
        i = 6;
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecommendAdapter
 * JD-Core Version:    0.7.0.1
 */