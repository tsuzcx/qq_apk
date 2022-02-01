import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import NearbyGroup.RspActivity;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NearbyGroup.RspTopic;
import NearbyGroup.XiaoQuInfo;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class kdj
  extends LBSObserver
{
  public kdj(NearbyTroopsView paramNearbyTroopsView) {}
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.d()))
    {
      break label25;
      break label25;
    }
    label25:
    while ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null)) {
      return;
    }
    if (paramBoolean2) {
      this.a.a(paramBoolean1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyTroopsActivity", 2, "onGetGroups==>isSuccess:" + paramBoolean1 + "|mHasCache:" + this.a.h + "|iFilterId:" + paramInt);
    }
    if (!paramBoolean1)
    {
      if (this.a.h)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(2);
        return;
      }
      if (!this.a.h)
      {
        this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.c = false;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d(2);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
      }
    }
    if (paramRspGetNearbyGroup == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "onGetGroups==>isSuccess:" + paramBoolean1 + "|rsp == null");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(2);
      return;
    }
    Object localObject3 = paramRspGetNearbyGroup.vGroupInfo;
    Object localObject2 = paramRspGetNearbyGroup.vXiaoQuInfo;
    Object localObject1 = paramRspGetNearbyGroup.vGroupArea;
    if ((paramRspGetNearbyGroup.dwFlag & 0x1) != 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.a.j = true;
      if (paramBoolean2)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        if (localObject2 == null) {
          break label641;
        }
        this.a.b = new ArrayList(((ArrayList)localObject2).size());
        label339:
        if (localObject1 == null) {
          break label658;
        }
      }
    }
    label641:
    label658:
    for (this.a.jdField_c_of_type_JavaUtilArrayList = new ArrayList(((ArrayList)localObject1).size());; this.a.jdField_c_of_type_JavaUtilArrayList = new ArrayList())
    {
      this.a.e = paramRspGetNearbyGroup.iLat;
      this.a.f = paramRspGetNearbyGroup.iLon;
      if ((this.a.e != 0) && (this.a.f != 0))
      {
        if (this.a.jdField_a_of_type_Boolean) {
          NearbyTroopsView.b(this.a);
        }
        this.a.jdField_d_of_type_Boolean = true;
      }
      this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.b, this.a.jdField_c_of_type_JavaUtilArrayList);
      if (NearbyTroopsView.d(this.a))
      {
        this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        NearbyTroopsView.d(this.a, false);
      }
      if (localObject3 == null) {
        break label675;
      }
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        GroupInfo localGroupInfo = (GroupInfo)((Iterator)localObject3).next();
        if ((this.a.a(localGroupInfo.dwGroupFlagExt)) && (paramBoolean2))
        {
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localGroupInfo);
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "CliOper", "", "", "Open_group", "Open_group_exp", 45, 0, "", "", "", "");
        }
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.a.j = false;
      break;
      this.a.b = new ArrayList();
      break label339;
    }
    label675:
    if ((localObject2 != null) && (paramBoolean2))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (XiaoQuInfo)((Iterator)localObject2).next();
        this.a.b.add(localObject3);
      }
    }
    if (localObject1 != null) {
      if ((this.a.C != 1) || (((ArrayList)localObject1).size() <= 0) || (((ArrayList)localObject1).get(0) == null) || (!((GroupArea)((ArrayList)localObject1).get(0)).strAreaName.equals(this.a.r))) {
        break label1500;
      }
    }
    label937:
    label1323:
    label1492:
    label1500:
    for (int i = 1;; i = 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label937;
        }
        localObject2 = (GroupArea)((Iterator)localObject1).next();
        if (this.a.jdField_c_of_type_JavaUtilArrayList == null) {
          break;
        }
        this.a.jdField_c_of_type_JavaUtilArrayList.add(new GroupAreaWrapper((GroupArea)localObject2));
        if ((i != 0) && (((GroupArea)localObject2).strAreaName.equals(this.a.r)))
        {
          localObject3 = (GroupAreaWrapper)this.a.jdField_c_of_type_JavaUtilArrayList.get(0);
          this.a.jdField_c_of_type_JavaUtilArrayList.set(0, new GroupAreaWrapper((GroupArea)localObject2));
          this.a.jdField_c_of_type_JavaUtilArrayList.set(this.a.jdField_c_of_type_JavaUtilArrayList.size() - 1, localObject3);
        }
      }
      if ((paramRspGetNearbyGroup.stRspAct != null) && (paramRspGetNearbyGroup.stRspTopic != null) && (paramRspGetNearbyGroup.stRspAct.shShowPos > paramRspGetNearbyGroup.stRspTopic.shShowPos))
      {
        this.a.a(paramRspGetNearbyGroup.stRspAct);
        this.a.a(paramRspGetNearbyGroup.stRspTopic);
        label996:
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter;
        if (paramRspGetNearbyGroup.iCompletedFlag != 0) {
          break label1310;
        }
        paramBoolean1 = true;
        label1015:
        ((NearbyTroopsExpandableListViewAdapter)localObject1).c = paramBoolean1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.jdField_d_of_type_Boolean = false;
        if ((!paramBoolean2) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0) || (this.a.jdField_c_of_type_JavaUtilArrayList.size() != 0) || (this.a.b.size() != 0)) {
          break label1323;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyTroopsActivity", 2, "onGetGroups==>isFirst && mOpenTroopListData.size() == 0 && mGroupAreaWrapperListData.size() == 0&& mXiaoquTroops.size() == 0");
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp_blank", 0, 0, "", "", "", "");
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
        i = this.a.jdField_a_of_type_Int;
        if (!this.a.k) {
          break label1315;
        }
      }
      for (paramRspGetNearbyGroup = "0";; paramRspGetNearbyGroup = "1")
      {
        ReportController.b((QQAppInterface)localObject1, "P_CliOper", "Grp_nearby", "", "grp", "exp", 0, 0, String.valueOf(i), String.valueOf(paramInt), "0", paramRspGetNearbyGroup);
        if (paramInt == 0)
        {
          if (this.a.h) {
            break;
          }
          if (this.a.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
            this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          if (this.a.jdField_d_of_type_AndroidViewView != null) {
            this.a.jdField_d_of_type_AndroidViewView.setVisibility(8);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d(1);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
        return;
        this.a.a(paramRspGetNearbyGroup.stRspTopic);
        this.a.a(paramRspGetNearbyGroup.stRspAct);
        break label996;
        paramBoolean1 = false;
        break label1015;
      }
      this.a.a(paramRspGetNearbyGroup);
      this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.b, this.a.jdField_c_of_type_JavaUtilArrayList);
      if (paramBoolean2)
      {
        this.a.f();
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
        i = this.a.jdField_a_of_type_Int;
        if (!this.a.k) {
          break label1492;
        }
      }
      for (paramRspGetNearbyGroup = "0";; paramRspGetNearbyGroup = "1")
      {
        ReportController.b((QQAppInterface)localObject1, "P_CliOper", "Grp_nearby", "", "grp", "exp", 0, 0, String.valueOf(i), String.valueOf(paramInt), "1", paramRspGetNearbyGroup);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(paramBoolean2);
        if (!paramBoolean2) {
          break;
        }
        new Thread(new kdk(this)).start();
        return;
      }
    }
  }
  
  protected void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.d())) {}
    while ((this.a == null) || (!paramBoolean1) || (paramRspGetAreaList == null) || (paramRspGetAreaList.vGroupArea != null)) {
      return;
    }
  }
  
  protected void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.d())) {}
    label25:
    do
    {
      Object localObject2;
      do
      {
        int i;
        int j;
        GroupAreaWrapper localGroupAreaWrapper;
        do
        {
          do
          {
            Iterator localIterator;
            do
            {
              do
              {
                ;;;
                break label25;
                while ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null) || (!paramBoolean) || (paramRspGetGroupInArea == null)) {}
                localObject1 = paramRspGetGroupInArea.stGroupArea;
              } while ((localObject1 == null) || (((GroupArea)localObject1).vGroupInfo == null) || (((GroupArea)localObject1).vGroupInfo.size() == 0) || (this.a.jdField_c_of_type_JavaUtilArrayList == null) || (this.a.jdField_c_of_type_JavaUtilArrayList.size() == 0));
              i = ((GroupArea)localObject1).iLat;
              j = ((GroupArea)localObject1).iLon;
              localObject2 = ((GroupArea)localObject1).strAreaName;
              localIterator = this.a.jdField_c_of_type_JavaUtilArrayList.iterator();
            } while (!localIterator.hasNext());
            localGroupAreaWrapper = (GroupAreaWrapper)localIterator.next();
          } while ((localGroupAreaWrapper.type != 0) || (localGroupAreaWrapper.groupArea == null));
          paramRspGetGroupInArea = localGroupAreaWrapper.groupArea;
        } while ((paramRspGetGroupInArea.iLat != i) || (paramRspGetGroupInArea.iLon != j) || (!paramRspGetGroupInArea.strAreaName.equals(localObject2)));
        localGroupAreaWrapper.isMoreClick = false;
      } while ((paramRspGetGroupInArea.vGroupInfo == null) || (paramRspGetGroupInArea.vGroupInfo.size() == 0));
      Object localObject1 = ((GroupArea)localObject1).vGroupInfo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupInfo)((Iterator)localObject1).next();
        paramRspGetGroupInArea.vGroupInfo.add(localObject2);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.b, this.a.jdField_c_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdj
 * JD-Core Version:    0.7.0.1
 */