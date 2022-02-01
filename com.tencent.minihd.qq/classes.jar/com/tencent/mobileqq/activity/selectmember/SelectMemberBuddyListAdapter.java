package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.BaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.ExpandableListView;
import gyf;
import gyg;
import gyh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SelectMemberBuddyListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener
{
  private static final gyh jdField_a_of_type_Gyh = new gyh(null);
  private final Context jdField_a_of_type_AndroidContentContext;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SelectMemberActivity jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private ExpandableListView b;
  
  public SelectMemberBuddyListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = ((SelectMemberActivity)paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramExpandableListView;
    b();
  }
  
  private List a()
  {
    ArrayList localArrayList = new ArrayList();
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localObject1 != null)
    {
      Object localObject2 = ((RecentUserProxy)localObject1).b();
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (RecentUser)((Iterator)localObject2).next();
          if (localObject3 != null) {
            try
            {
              if ((((RecentUser)localObject3).type == 0) && (Long.parseLong(((RecentUser)localObject3).uin) >= 10000L) && (!((RecentUser)localObject3).uin.equals(localObject1)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(((RecentUser)localObject3).uin)))
              {
                localObject3 = localFriendsManagerImp.a(((RecentUser)localObject3).uin);
                if ((localObject3 != null) && (((Friends)localObject3).isFriend())) {
                  localArrayList.add(localObject3);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
      }
    }
    return localArrayList;
  }
  
  private List a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1 = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    String str;
    if ((localObject2 != null) && (localObject1 != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      Object localObject3 = ((ContactFacade)localObject1).a(String.valueOf(paramInt));
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Entity)((Iterator)localObject3).next();
          if (localObject4 != null)
          {
            localObject4 = (Friends)localObject4;
            if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k) || (!((Friends)localObject4).uin.equals(str))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(((Friends)localObject4).uin))) {
              localArrayList.add(localObject4);
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k) && (paramInt == 0))
      {
        localObject2 = ((FriendManager)localObject2).c();
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break label359;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        do
        {
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = ((ContactFacade)localObject1).a(String.valueOf(((Groups)((Iterator)localObject2).next()).group_id));
            } while ((localObject3 == null) || (((List)localObject3).size() <= 0));
            localObject3 = ((List)localObject3).iterator();
          }
        } while (!((Friends)((Iterator)localObject3).next()).uin.equals(str));
      }
    }
    label359:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        localObject1 = new Friends();
        ((Friends)localObject1).uin = str;
        ((Friends)localObject1).name = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        ((Friends)localObject1).mCompareSpell = ChnToSpell.a(ContactSorter.b((Friends)localObject1), 1);
        localArrayList.add(localObject1);
      }
      return localArrayList;
    }
  }
  
  private void a(List paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Gyh);
      return;
    }
    catch (Exception paramList) {}
  }
  
  private void b()
  {
    Object localObject2 = new Groups();
    ((Groups)localObject2).group_id = -1;
    ((Groups)localObject2).group_name = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131368400);
    Object localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject1 != null) {}
    for (localObject1 = ((FriendManager)localObject1).c();; localObject1 = null)
    {
      Groups localGroups;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        ((ArrayList)localObject1).add(0, localObject2);
        Iterator localIterator1 = ((ArrayList)localObject1).iterator();
        if (localIterator1.hasNext())
        {
          localGroups = (Groups)localIterator1.next();
          this.jdField_a_of_type_JavaUtilList.add(localGroups);
          if (localGroups.group_id == -1) {
            localObject2 = a();
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject2);
        break;
        localObject2 = a(localGroups.group_id);
        Object localObject3 = new ArrayList();
        Iterator localIterator2 = ((List)localObject2).iterator();
        while (localIterator2.hasNext()) {
          ((ArrayList)localObject3).add(new gyf((Friends)localIterator2.next(), -1));
        }
        a((List)localObject3);
        ((List)localObject2).clear();
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ((List)localObject2).add(((gyf)((Iterator)localObject3).next()).a);
          continue;
          ((ArrayList)localObject1).remove(0);
          return;
        }
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).group_id)).get(paramInt2);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Friends localFriends;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904416, paramViewGroup, false);
      paramViewGroup = new SelectMemberBuddyListAdapter.SelectBuddyChildTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297504));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131297505));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131296551));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296582));
      paramView.findViewById(2131297503).setVisibility(8);
      paramView.setOnClickListener(this);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      Object localObject = getChild(paramInt1, paramInt2);
      localFriends = (Friends)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_b_of_type_JavaLangString = localFriends.uin;
      a(paramViewGroup, null);
      paramViewGroup.d.setImageDrawable(null);
      localObject = ContactUtils.a(localFriends);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramViewGroup.jdField_b_of_type_JavaLangString)) {
        break label272;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.contains(localFriends.uin))) {
        break label284;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      return paramView;
      paramViewGroup = (SelectMemberBuddyListAdapter.SelectBuddyChildTag)paramView.getTag();
      break;
      label272:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    label284:
    paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilList.get(paramInt)).group_id)).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (gyg)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = (Groups)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject).group_name);
      if (!paramBoolean) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841853);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904414, paramViewGroup, false);
      paramView = new gyg();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297234));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297233));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841854);
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof SelectMemberBuddyListAdapter.SelectBuddyChildTag))
    {
      paramView = (SelectMemberBuddyListAdapter.SelectBuddyChildTag)paramView.getTag();
      if ((paramView != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramView.jdField_b_of_type_AndroidWidgetTextView != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramView.jdField_b_of_type_JavaLangString, paramView.jdField_b_of_type_AndroidWidgetTextView.getText().toString(), 0, "-1");
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      }
      return;
    }
    paramView = (gyg)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.e(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.d(paramView.jdField_a_of_type_Int);
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramView.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberBuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */