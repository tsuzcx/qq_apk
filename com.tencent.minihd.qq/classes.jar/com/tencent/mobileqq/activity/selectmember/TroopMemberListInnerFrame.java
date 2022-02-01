package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gym;
import gyn;
import gyo;
import gyq;
import gyr;
import gys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class TroopMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final int jdField_b_of_type_Int = 2;
  private static final int jdField_c_of_type_Int = 3;
  private static final String jdField_c_of_type_JavaLangString = "TroopMemberListInnerFrame";
  private static final int jdField_d_of_type_Int = 4;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  public FriendsManagerImp a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gyo(this);
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public gyr a;
  String jdField_a_of_type_JavaLangString = "";
  public LinkedHashMap a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public int[] a;
  public String[] a;
  public String b;
  List jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  
  public TroopMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new gym(this);
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new gym(this);
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new gym(this);
  }
  
  private Object[] a(String arg1)
  {
    Object localObject4;
    int i;
    Object localObject5;
    Object localObject6;
    for (;;)
    {
      try
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        Object localObject1 = ((EntityManager)localObject4).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { ??? }, null, null, null, null);
        ((EntityManager)localObject4).a();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("read troop members from database, troop uin: ").append(???).append(" member count: ");
          if (localObject1 == null)
          {
            i = 0;
            QLog.d("TroopMemberListInnerFrame", 2, i);
          }
        }
        else
        {
          localObject4 = new LinkedHashMap();
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break label789;
          }
          synchronized (this.jdField_a_of_type_JavaUtilList)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject6 = (TroopMemberInfo)((Iterator)localObject1).next();
            if ((((String)localObject5).equalsIgnoreCase(((TroopMemberInfo)localObject6).memberuin)) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(((TroopMemberInfo)localObject6).memberuin)) || (!Utils.c(((TroopMemberInfo)localObject6).memberuin))) {
              continue;
            }
            ((TroopMemberInfo)localObject6).displayedNamePinyinFirst = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a((TroopMemberInfo)localObject6), 2);
            this.jdField_a_of_type_JavaUtilList.add(localObject6);
          }
        }
        i = localObject2.size();
      }
      finally {}
      i -= 1;
    }
    Object localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
    label352:
    label357:
    char c1;
    if (((Iterator)localObject3).hasNext())
    {
      localObject5 = (TroopMemberInfo)((Iterator)localObject3).next();
      if (((TroopMemberInfo)localObject5).displayedNamePinyinFirst != null)
      {
        if (((TroopMemberInfo)localObject5).displayedNamePinyinFirst.length() == 0) {
          break label754;
        }
        for (;;)
        {
          i = ???.charAt(0);
          if ((65 > i) || (i > 90)) {
            break label760;
          }
          ??? = ???.toUpperCase();
          if (((LinkedHashMap)localObject4).get(???) == null) {
            ((LinkedHashMap)localObject4).put(???, new ArrayList());
          }
          ((List)((LinkedHashMap)localObject4).get(???)).add(localObject5);
          break;
          ??? = ((TroopMemberInfo)localObject5).displayedNamePinyinFirst.substring(0, 1);
        }
      }
    }
    else
    {
      ??? = ((LinkedHashMap)localObject4).keySet().iterator();
      while (???.hasNext()) {
        Collections.sort((List)((LinkedHashMap)localObject4).get((String)???.next()), new gyq(this, null));
      }
      localObject5 = new LinkedHashMap();
      c1 = 'A';
      label478:
      if (c1 <= 'Z')
      {
        if (((LinkedHashMap)localObject4).get(String.valueOf(c1)) == null) {
          break label781;
        }
        ((LinkedHashMap)localObject5).put(String.valueOf(c1), ((LinkedHashMap)localObject4).get(String.valueOf(c1)));
        break label781;
      }
      if (((LinkedHashMap)localObject4).get("#") != null) {
        ((LinkedHashMap)localObject5).put("#", ((LinkedHashMap)localObject4).get("#"));
      }
      ((LinkedHashMap)localObject4).clear();
      localObject6 = new int[((LinkedHashMap)localObject5).keySet().size()];
      String[] arrayOfString = new String[((LinkedHashMap)localObject5).keySet().size()];
      ??? = ((LinkedHashMap)localObject5).keySet().iterator();
      if (localObject6.length == 0)
      {
        ??? = new Object[0];
        label599:
        return ???;
      }
      localObject6[0] = 0;
      i = 1;
      while (i < localObject6.length)
      {
        int j = localObject6[i];
        int k = localObject6[(i - 1)];
        localObject6[i] = (((List)((LinkedHashMap)localObject5).get(???.next())).size() + k + 1 + j);
        i += 1;
      }
      Iterator localIterator = ((LinkedHashMap)localObject5).keySet().iterator();
      i = 0;
      for (;;)
      {
        ??? = arrayOfString;
        localObject3 = localObject6;
        localObject4 = localObject5;
        if (!localIterator.hasNext()) {
          break;
        }
        arrayOfString[i] = ((String)localIterator.next());
        i += 1;
      }
    }
    for (;;)
    {
      localObject5 = new Object[3];
      localObject5[0] = localObject4;
      localObject5[1] = localObject3;
      localObject5[2] = ???;
      ??? = (String)localObject5;
      break label599;
      label754:
      ??? = "#";
      break;
      label760:
      if ((97 <= i) && (i <= 122)) {
        break label352;
      }
      ??? = "#";
      break label357;
      label781:
      c1 = (char)(c1 + '\001');
      break label478;
      label789:
      localObject3 = new int[0];
      ??? = new String[0];
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a(paramString);
      if (localObject == null) {
        break label155;
      }
    }
    label155:
    for (Object localObject = ((TroopInfo)localObject).troopcode;; localObject = "0")
    {
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g();
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131365730), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidViewView.getHeight());
        }
      }
      else {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame", 2, "get troop members from server, troopUin: " + paramString + " troopCode: " + (String)localObject);
      }
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(true, paramString, (String)localObject);
      return;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131297502));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131302098));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131427375);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
  }
  
  private void h()
  {
    gyn localgyn = new gyn(this);
    long l1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences("last_update_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getLong("key_last_update_time" + this.jdField_b_of_type_JavaLangString, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "troop member last update time: " + l1 + " current time: " + l2 + " time difference: " + l3);
    }
    if ((l1 == 0L) || ((l1 > 0L) && (l3 > 300000L))) {
      b(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localgyn);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List a()
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList = SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 30064771072L, 0, this.jdField_a_of_type_JavaUtilList, true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b);
      return this.jdField_b_of_type_JavaUtilList;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130904403);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    g();
    this.jdField_a_of_type_Gyr = new gyr(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Gyr);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.s() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.s() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Gyr.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Gyr.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("group_uin");
    this.d = paramBundle.getString("group_name");
    if (((this.d == null) || (this.d.length() == 0)) && (this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp != null))
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a(this.jdField_b_of_type_JavaLangString);
      if (paramBundle != null) {
        this.d = paramBundle.troopname;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, "", this.d);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0))
      {
        if (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f();
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_b_of_type_Boolean = false;
        h();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, "群", this.d);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Gyr.notifyDataSetChanged();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Gyr != null) {
      this.jdField_a_of_type_Gyr.b();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Gyr.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    gys localgys = (gys)paramView.getTag();
    if ((localgys != null) && (localgys.a != null) && (localgys.c != null) && (localgys.a.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localgys.jdField_b_of_type_JavaLangString, localgys.c.getText().toString(), 1, this.jdField_b_of_type_JavaLangString);
      localgys.a.setChecked(bool);
      if (localgys.a.isChecked()) {
        paramView.setContentDescription(localgys.c.getText().toString() + "已选中,双击取消");
      }
    }
    else
    {
      return;
    }
    paramView.setContentDescription(localgys.c.getText().toString() + "未选中,双击选中");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */