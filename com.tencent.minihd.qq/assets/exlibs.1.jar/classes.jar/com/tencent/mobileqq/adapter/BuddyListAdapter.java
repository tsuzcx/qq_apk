package com.tencent.mobileqq.adapter;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.TraceUtils;
import hey;
import hez;
import hfa;
import hfb;
import hfc;
import hfd;
import hfe;
import hff;
import hfg;
import hfh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BuddyListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final hfg jdField_a_of_type_Hfg = new hfg(null);
  private static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString = "BuddyListAdapter";
  private static final int c = 0;
  private static final int d = 1;
  private int jdField_a_of_type_Int = 0;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  public String a;
  public ArrayList a;
  private final boolean jdField_a_of_type_Boolean;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new hfc(this);
  private final ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private final int e;
  private final int f;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  
  public BuddyListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(49));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840085);
    paramExpandableListView.post(new hey(this));
    this.e = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.f = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).group_id != -1006) {
      return 0;
    }
    return 1;
  }
  
  private int a(Groups paramGroups, int paramInt)
  {
    int j = getChildrenCount(paramInt);
    if ((j == 1) && (PublicAccountInfo.isLooker((PublicAccountInfo)getChild(paramInt, 0)))) {
      return 0;
    }
    return j;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject1;
    Friends localFriends;
    label297:
    label311:
    Object localObject2;
    if ((paramView == null) || ((paramView.getTag() instanceof hfh)))
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903189, paramViewGroup, false);
      localObject1 = new hfd();
      ((hfd)localObject1).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296551));
      ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297264));
      ((hfd)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297265));
      ((hfd)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297267));
      ((hfd)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297268));
      ((hfd)localObject1).e = ((TextView)localView.findViewById(2131297269));
      ((hfd)localObject1).c = ((ImageView)localView.findViewById(2131297263));
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      localView.setTag(localObject1);
      paramView = getChild(paramInt1, paramInt2);
      localFriends = (Friends)paramView;
      ((hfd)localObject1).jdField_a_of_type_JavaLangObject = paramView;
      ((hfd)localObject1).jdField_b_of_type_JavaLangString = localFriends.uin;
      ((hfd)localObject1).jdField_a_of_type_Int = paramInt1;
      ((hfd)localObject1).jdField_b_of_type_Int = paramInt2;
      a((FacePreloadBaseAdapter.ViewHolder)localObject1, null);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.g == -1) && (this.jdField_a_of_type_JavaLangString.equals(((hfd)localObject1).jdField_b_of_type_JavaLangString))) {
        a(this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2);
      }
      paramViewGroup = null;
      if (!AppConstants.Y.equals(localFriends.uin)) {
        break label580;
      }
      ((hfd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (localFriends.status != 0) {
        break label562;
      }
      paramInt1 = 1;
      paramView = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 0) {
        break label567;
      }
      paramInt2 = 2131368420;
      paramViewGroup = paramView.getString(paramInt2);
      localObject2 = ((hfd)localObject1).jdField_d_of_type_AndroidWidgetImageView;
      if (paramInt1 == 0) {
        break label574;
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label336:
      ((ImageView)localObject2).setImageDrawable(paramView);
      paramView = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getString(2131362098));
      ((hfd)localObject1).e.setText(paramView);
      ((hfd)localObject1).c.setVisibility(8);
      ((hfd)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((hfd)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427934));
    }
    for (;;)
    {
      localObject2 = ContactUtils.a(localFriends);
      ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      ((hfd)localObject1).e.setVisibility(0);
      ((hfd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = new StringBuilder((String)localObject2);
      ((StringBuilder)localObject1).append("，").append(paramViewGroup).append("，");
      if (!TextUtils.isEmpty(paramView)) {
        ((StringBuilder)localObject1).append("，个性签名， ").append(paramView);
      }
      localView.setContentDescription((CharSequence)localObject1);
      return localView;
      localObject1 = (hfd)paramView.getTag();
      ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      ((hfd)localObject1).e.setCompoundDrawables(null, null, null, null);
      localView = paramView;
      break;
      label562:
      paramInt1 = 0;
      break label297;
      label567:
      paramInt2 = 2131368418;
      break label311;
      label574:
      paramView = null;
      break label336;
      label580:
      if (AppConstants.at.equals(localFriends.uin))
      {
        ((hfd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (localFriends.status == 0)
        {
          paramInt1 = 1;
          label613:
          paramView = this.jdField_a_of_type_AndroidContentContext;
          if (paramInt1 == 0) {
            break label747;
          }
          paramInt2 = 2131368420;
          label627:
          paramViewGroup = paramView.getString(paramInt2);
          localObject2 = ((hfd)localObject1).jdField_d_of_type_AndroidWidgetImageView;
          if (paramInt1 == 0) {
            break label754;
          }
        }
        label747:
        label754:
        for (paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;; paramView = null)
        {
          ((ImageView)localObject2).setImageDrawable(paramView);
          paramView = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getString(2131362099));
          ((hfd)localObject1).e.setText(paramView);
          ((hfd)localObject1).c.setVisibility(8);
          ((hfd)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          ((hfd)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427934));
          break;
          paramInt1 = 0;
          break label613;
          paramInt2 = 2131368418;
          break label627;
        }
      }
      if (AppConstants.Z.equals(localFriends.uin))
      {
        ((hfd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((hfd)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramView = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getString(2131362094));
        ((hfd)localObject1).e.setText(paramView);
        ((hfd)localObject1).c.setVisibility(8);
        ((hfd)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        ((hfd)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427934));
      }
      else if (AppConstants.X.equals(localFriends.uin))
      {
        ((hfd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((hfd)localObject1).jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramView = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getString(2131362096));
        ((hfd)localObject1).e.setText(paramView);
        ((hfd)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        ((hfd)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        ((hfd)localObject1).c.setVisibility(8);
        ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427934));
      }
      else
      {
        int n = ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        label1101:
        label1115:
        label1132:
        int k;
        int j;
        switch (n)
        {
        case 5: 
        case 6: 
        default: 
          paramViewGroup = paramView.a(localFriends.getLastLoginType());
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131368420);
          }
          if ((n == 0) || (n == 6))
          {
            paramInt2 = 1;
            localObject2 = ((hfd)localObject1).jdField_d_of_type_AndroidWidgetImageView;
            if (paramInt2 == 0) {
              break label1424;
            }
            paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            ((ImageView)localObject2).setImageDrawable(paramViewGroup);
            paramViewGroup = a(localFriends, (hfd)localObject1);
            k = 1;
            ((hfd)localObject1).c.setVisibility(0);
            paramInt1 = 0;
            if (paramInt2 != 0) {
              break label1443;
            }
            int m = localFriends.netTypeIconId;
            paramInt1 = m;
            j = k;
            if (n == 8)
            {
              paramInt1 = m;
              j = k;
              if ((localFriends.abilityBits & 1L) == 0L)
              {
                if (localFriends.netTypeIconIdIphoneOrWphoneNoWifi == 0) {
                  break label1430;
                }
                paramInt1 = localFriends.netTypeIconIdIphoneOrWphoneNoWifi;
                j = k;
              }
            }
            label1225:
            if (j != 0)
            {
              paramInt1 = ContactUtils.a(paramInt1);
              ((hfd)localObject1).c.setBackgroundResource(paramInt1);
            }
            localObject2 = ((hfd)localObject1).c;
            if (j == 0) {
              break label1449;
            }
            paramInt1 = 0;
            label1258:
            ((ImageView)localObject2).setVisibility(paramInt1);
            if ((paramInt2 != 0) || ((!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
              break label1455;
            }
            ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427999));
          }
          break;
        }
        for (;;)
        {
          if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label1479;
          }
          ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.f);
          ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842003, 0);
          localObject2 = paramViewGroup;
          paramViewGroup = paramView;
          paramView = (View)localObject2;
          break;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131368415);
          break label1101;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131368416);
          break label1101;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131368418);
          break label1101;
          paramInt2 = 0;
          break label1115;
          label1424:
          paramViewGroup = null;
          break label1132;
          label1430:
          paramInt1 = localFriends.netTypeIconId;
          j = k;
          break label1225;
          label1443:
          j = 0;
          break label1225;
          label1449:
          paramInt1 = 8;
          break label1258;
          label1455:
          ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427934));
        }
        label1479:
        if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
        {
          ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.f);
          ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842130, 0);
          localObject2 = paramViewGroup;
          paramViewGroup = paramView;
          paramView = (View)localObject2;
        }
        else
        {
          ((hfd)localObject1).jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          localObject2 = paramViewGroup;
          paramViewGroup = paramView;
          paramView = (View)localObject2;
        }
      }
    }
  }
  
  private void a(List paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Hfg);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BuddyListAdapter", 2, "", paramList);
    }
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int j = 0;
    ExpandableListView localExpandableListView = this.jdField_a_of_type_ComTencentWidgetExpandableListView;
    int k = 0;
    if (k <= paramInt1)
    {
      if (paramInt1 == k)
      {
        localExpandableListView.c(k);
        j += paramInt2 + 2;
      }
      for (;;)
      {
        k += 1;
        break;
        if (localExpandableListView.e(k)) {
          j += getChildrenCount(k) + 1;
        } else {
          j += 1;
        }
      }
    }
    return j;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || ((paramView.getTag() instanceof hfd)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903417, paramViewGroup, false);
      paramViewGroup = new hfh();
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296551));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298151));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297264));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298149));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131298148));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298150));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131297269));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
        break label475;
      }
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    label475:
    for (;;)
    {
      Object localObject = getChild(paramInt1, paramInt2);
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_b_of_type_JavaLangString = Long.toString(localPublicAccountInfo.uin);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427934));
      if (PublicAccountInfo.isLooker(localPublicAccountInfo))
      {
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.e.setVisibility(8);
        paramView.setContentDescription(paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.getText());
        return paramView;
        paramViewGroup = (hfh)paramView.getTag();
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      else
      {
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(localPublicAccountInfo.name);
        if (localPublicAccountInfo.certifiedGrade > 0L)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838652);
        }
        for (;;)
        {
          paramViewGroup.e.setText(localPublicAccountInfo.summary);
          a(paramViewGroup, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  private boolean b()
  {
    int j = ((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9)).a();
    return (j == 1) || (j == 2);
  }
  
  private void e()
  {
    int k = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int j = 0;
    while (j < k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(j).getTag();
      if ((localObject != null) && ((localObject instanceof hfd)))
      {
        localObject = (hfd)localObject;
        if ((TextUtils.isEmpty(((hfd)localObject).e.getText().toString())) && ((((hfd)localObject).jdField_a_of_type_JavaLangObject instanceof Friends))) {
          a((Friends)((hfd)localObject).jdField_a_of_type_JavaLangObject, (hfd)localObject);
        }
      }
      j += 1;
    }
  }
  
  private void f()
  {
    int k = 0;
    Groups localGroups = new Groups();
    localGroups.group_id = -1007;
    localGroups.group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131368529);
    localGroups.group_friend_count = 1;
    localGroups.group_online_friend_count = 1;
    localGroups.seqid = 0;
    localGroups.sqqOnLine_count = 0;
    this.jdField_b_of_type_JavaUtilArrayList.add(localGroups);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new Friends();
    ((Friends)localObject).uin = AppConstants.Y;
    ((Friends)localObject).remark = this.jdField_a_of_type_AndroidContentContext.getString(2131362046);
    ((Friends)localObject).name = this.jdField_a_of_type_AndroidContentContext.getString(2131362046);
    if (b()) {}
    for (int j = 10;; j = 0)
    {
      ((Friends)localObject).status = ((byte)j);
      ((Friends)localObject).groupid = -1007;
      ((Friends)localObject).memberLevel = 0;
      ((Friends)localObject).isMqqOnLine = false;
      ((Friends)localObject).sqqOnLineState = 0;
      localArrayList.add(localObject);
      j = k;
      if (((Friends)localObject).status != 0) {
        j = 1;
      }
      localObject = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localArrayList);
      this.jdField_a_of_type_AndroidUtilSparseIntArray.put(localGroups.group_id, j);
      c();
      return;
    }
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    f();
    Object localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((FriendManager)localObject1).a();
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((List)localObject1).size() != 0) {}
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("group list is ");
          if (localObject1 != null) {
            break label386;
          }
          localObject2 = "null";
          label95:
          QLog.d("BuddyListAdapter", 2, (String)localObject2);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
      }
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      if (localObject1 == null) {
        break label569;
      }
    }
    label386:
    label560:
    label563:
    label569:
    for (localObject1 = ((FriendsManager)localObject1).c();; localObject1 = null)
    {
      localObject3 = ((List)localObject2).iterator();
      Groups localGroups;
      while (((Iterator)localObject3).hasNext())
      {
        localGroups = (Groups)((Iterator)localObject3).next();
        if ((localGroups.group_id != -1003) && (localGroups.group_id != -1004) && (localGroups.group_id != -1006))
        {
          this.jdField_b_of_type_JavaUtilArrayList.add(localGroups);
          if (localObject1 == null) {
            break label563;
          }
        }
      }
      for (localObject2 = (List)((ConcurrentHashMap)localObject1).get(String.valueOf(localGroups.group_id));; localObject2 = null)
      {
        if (localObject2 == null) {}
        Object localObject5;
        for (localObject2 = new ArrayList();; localObject2 = new ArrayList((Collection)localObject2))
        {
          if ((((List)localObject2).size() == 0) && (localGroups.group_id == -1006)) {
            ((List)localObject2).add(PublicAccountInfo.createLooker(this.jdField_a_of_type_AndroidContentContext));
          }
          if (localGroups.group_id == -1006) {
            break label462;
          }
          localObject4 = new ArrayList();
          localObject5 = ((List)localObject2).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((ArrayList)localObject4).add(new hfe((Friends)((Iterator)localObject5).next(), -1));
          }
          if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "FriendManager is null");
          }
          localObject1 = null;
          break;
          localObject2 = "empty";
          break label95;
        }
        a((List)localObject4);
        ((List)localObject2).clear();
        Object localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((List)localObject2).add(((hfe)((Iterator)localObject4).next()).a);
        }
        label462:
        localObject4 = ((List)localObject2).iterator();
        int j = 0;
        label473:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Friends)((Iterator)localObject4).next();
          int k = ContactUtils.a(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
          if ((k == 0) || (k == 6)) {
            break label560;
          }
          j += 1;
        }
        for (;;)
        {
          break label473;
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(localGroups.group_id, j);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject2);
          break;
          return;
        }
      }
    }
  }
  
  public int a()
  {
    return 2130903183;
  }
  
  SpannableString a(Friends paramFriends, hfd paramhfd)
  {
    int m = 1;
    int n = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null)) {
      return null;
    }
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramFriends.uin);
    int j;
    boolean bool;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent)))
    {
      j = 1;
      if (localExtensionInfo == null) {
        break label380;
      }
      if (this.jdField_a_of_type_Int == 0) {
        break label221;
      }
      bool = true;
    }
    label68:
    label90:
    label105:
    label239:
    label245:
    label380:
    for (paramFriends = localExtensionInfo.getRichStatus(bool);; paramFriends = null)
    {
      int k;
      Object localObject;
      if ((paramFriends != null) && (!paramFriends.a()))
      {
        k = 1;
        if ((k == 0) || (TextUtils.isEmpty(paramFriends.c))) {
          break label233;
        }
        if ((j == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (k != 0))) {
          break label245;
        }
        paramFriends = new SpannableString(localExtensionInfo.feedContent);
        paramhfd.e.setCompoundDrawables(null, null, null, null);
        paramhfd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = paramhfd.jdField_b_of_type_AndroidWidgetImageView;
        if (!localExtensionInfo.feedHasPhoto) {
          break label239;
        }
      }
      for (j = n;; j = 8)
      {
        ((ImageView)localObject).setVisibility(j);
        if (localExtensionInfo == null)
        {
          paramhfd.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramhfd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        paramhfd.e.setText(paramFriends);
        return paramFriends;
        j = 0;
        break;
        bool = false;
        break label68;
        k = 0;
        break label90;
        m = 0;
        break label105;
      }
      if (m != 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramFriends.jdField_b_of_type_Int, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        j = this.e;
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * j), j);
        paramhfd.e.setCompoundDrawables((Drawable)localObject, null, null, null);
      }
      for (;;)
      {
        paramFriends = paramFriends.a(null);
        paramhfd.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramhfd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        if (k == 0)
        {
          paramFriends = RichStatus.a();
          paramhfd.e.setCompoundDrawables(null, null, null, null);
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject = (hff)paramView.getTag();
    if (localObject == null)
    {
      localObject = new hff();
      paramView.findViewById(2131297233).setVisibility(0);
      ((hff)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297234));
      ((hff)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297235));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      localObject = (Groups)getGroup(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject).group_name);
      if (((Groups)localObject).group_id == -1006)
      {
        paramInt = a((Groups)localObject, paramInt);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText("" + paramInt);
        return;
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("( %d/%d )", new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(((Groups)localObject).group_id)), Integer.valueOf(getChildrenCount(paramInt)) }));
      return;
    }
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.a(paramAbsListView, paramInt);
    if (paramInt == 0) {
      e();
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString)
  {
    int j = 0;
    for (;;)
    {
      List localList;
      int k;
      if (j < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(j)).group_id);
        k = 0;
      }
      while ((localList != null) && (k < localList.size()))
      {
        Object localObject = localList.get(k);
        if (((localObject instanceof Friends)) && (((Friends)localObject).uin.equals(paramString)))
        {
          a(paramString, j, k);
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.post(new hfa(this));
          return;
        }
        k += 1;
      }
      j += 1;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ExpandableListView localExpandableListView = this.jdField_a_of_type_ComTencentWidgetExpandableListView;
    this.g = paramInt1;
    this.h = paramInt2;
    if (paramString != null) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    paramInt1 = b(paramInt1, paramInt2);
    if (this.i != paramInt1)
    {
      localExpandableListView.post(new hez(this, localExpandableListView, paramInt1));
      this.i = paramInt1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(-1007);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    localObject = ((List)localObject).iterator();
    int j = 0;
    int k;
    if (((Iterator)localObject).hasNext())
    {
      Friends localFriends = (Friends)((Iterator)localObject).next();
      if ((localFriends.uin.equals(AppConstants.Y)) || (localFriends.uin.equals(AppConstants.Z)))
      {
        if (paramBoolean)
        {
          k = 10;
          label102:
          localFriends.status = ((byte)k);
        }
      }
      else
      {
        if (localFriends.status == 0) {
          break label141;
        }
        j += 1;
      }
    }
    label141:
    for (;;)
    {
      break;
      k = 0;
      break label102;
      this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-1007, j);
      return;
    }
  }
  
  public void b()
  {
    super.notifyDataSetChanged();
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = -1;
    this.h = -1;
    this.i = -1;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.e();
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.requestLayout();
    }
  }
  
  public void c()
  {
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(-1007);
    int j = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(-1007);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      DeviceInfo localDeviceInfo = (DeviceInfo)localIterator.next();
      if (localDeviceInfo.isAdmin == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("smartdevice::baseim.server_list", 2, "share device[" + localDeviceInfo.name + "] is not binded");
        }
      }
      else
      {
        Friends localFriends = new Friends();
        localFriends.uin = AppConstants.at;
        int k;
        label159:
        label190:
        int m;
        if (localDeviceInfo.userStatus == 10)
        {
          k = 1;
          if (localDeviceInfo.productId == 1000000344) {
            k = 1;
          }
          if (!TextUtils.isEmpty(localDeviceInfo.remark)) {
            break label311;
          }
          localObject = localDeviceInfo.name;
          localFriends.remark = ((String)localObject);
          localFriends.name = String.valueOf(localDeviceInfo.din);
          localFriends.signature = localDeviceInfo.serialNum;
          if (k == 0) {
            break label321;
          }
          m = 10;
          label227:
          localFriends.status = ((byte)m);
          localFriends.groupid = -1007;
          localFriends.memberLevel = 0;
          localFriends.isMqqOnLine = false;
          localFriends.sqqOnLineState = 0;
          localFriends.alias = localDeviceInfo.type;
          if (k == 0) {
            break label326;
          }
          localArrayList2.add(localFriends);
          label284:
          if (k == 0) {
            break label339;
          }
          j += 1;
        }
        label311:
        label321:
        label326:
        label339:
        for (;;)
        {
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(-1007, j);
          break;
          k = 0;
          break label159;
          localObject = localDeviceInfo.remark;
          break label190;
          m = 0;
          break label227;
          localArrayList1.add(localFriends);
          break label284;
        }
      }
    }
    Object localObject = localArrayList2.iterator();
    while (((Iterator)localObject).hasNext()) {
      localList.add((Friends)((Iterator)localObject).next());
    }
    localObject = localArrayList1.iterator();
    while (((Iterator)localObject).hasNext()) {
      localList.add((Friends)((Iterator)localObject).next());
    }
  }
  
  public void d()
  {
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(-1007);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    int j = 0;
    if (j < localList.size()) {
      if (!((Friends)localList.get(j)).uin.equals(AppConstants.Z)) {}
    }
    for (;;)
    {
      if (((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).c()) {
        if (j == -1)
        {
          Friends localFriends = new Friends();
          localFriends.uin = AppConstants.Z;
          localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131362097);
          localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131362097);
          if (!b()) {
            break label190;
          }
          j = 10;
          label138:
          localFriends.status = ((byte)j);
          localFriends.groupid = -1007;
          localFriends.memberLevel = 0;
          localFriends.isMqqOnLine = false;
          localFriends.sqqOnLineState = 0;
          localList.add(localFriends);
        }
      }
      for (;;)
      {
        a(b());
        return;
        j += 1;
        break;
        label190:
        j = 0;
        break label138;
        if (j != -1) {
          localList.remove(j);
        }
      }
      j = -1;
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).group_id)).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    if ((localObject instanceof Friends))
    {
      localObject = (Friends)localObject;
      try
      {
        l = Long.parseLong(((Friends)localObject).uin);
        return l;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable));
        }
      }
    }
    while (!(localThrowable instanceof PublicAccountInfo))
    {
      long l;
      return 0L;
    }
    return ((PublicAccountInfo)localThrowable).uin;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.a("getChildView");
    if (a(paramInt1, paramInt2) == 0) {}
    for (paramView = a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);; paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup))
    {
      TraceUtils.a();
      return paramView;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).group_id)).size();
  }
  
  public Object getGroup(int paramInt)
  {
    try
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.get(paramInt) != null) {
        return this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
      }
      Object localObject1 = new Object();
      QLog.d("BuddyListAdapter", 1, "buddylistadapter getGroup is null" + paramInt);
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new Object();
      QLog.d("BuddyListAdapter", 1, "buddylistadapter getGroup is null" + paramInt);
      return localObject2;
    }
  }
  
  public int getGroupCount()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return ((Groups)getGroup(paramInt)).group_id;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    Groups localGroups;
    if (paramView != null)
    {
      localObject = (hff)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localGroups = (Groups)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
      if (localGroups.group_id == -1006) {
        break label268;
      }
    }
    label153:
    try
    {
      TextView localTextView = paramView.jdField_b_of_type_AndroidWidgetTextView;
      if (!this.jdField_a_of_type_Boolean) {
        break label260;
      }
      localObject = "( %d / %d )";
      label75:
      localTextView.setText(String.format((String)localObject, new Object[] { Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(localGroups.group_id)), Integer.valueOf(getChildrenCount(paramInt)) }));
    }
    catch (Exception localException)
    {
      label118:
      break label118;
    }
    if (paramBoolean)
    {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841853);
      if (paramInt == this.g) {
        a(null, this.g, this.h);
      }
      if (!paramBoolean) {
        break label350;
      }
      paramViewGroup.setContentDescription("");
    }
    for (;;)
    {
      paramViewGroup.setOnLongClickListener(this);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903183, paramViewGroup, false);
      paramView = new hff();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297234));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297235));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297233));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
      break;
      label260:
      localObject = "( %d/%d )";
      break label75;
      label268:
      if (localGroups.group_id == -1006)
      {
        int j = a(localGroups, paramInt);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText("" + j);
        break label118;
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(getChildrenCount(paramInt)));
      break label118;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841854);
      break label153;
      label350:
      paramViewGroup.setContentDescription("");
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    b(false);
    g();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (hff)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.e(paramView.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.d(paramView.jdField_a_of_type_Int);
    }
    for (;;)
    {
      if (getGroupId(paramView.jdField_a_of_type_Int) == -1007L)
      {
        paramView = new Intent();
        paramView.setAction("SmartDevice_clickOnDeviceList");
        BaseApplicationImpl.a().sendBroadcast(paramView);
      }
      return;
      try
      {
        this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramView.jdField_a_of_type_Int);
        ((QzoneContactsFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(85)).a();
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131368009));
    BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_b_of_type_AndroidViewView$OnClickListener, new hfb(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */