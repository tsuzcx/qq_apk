import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NeighborComm.RespHeader;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.maproam.Utils;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.sso.roam.Roam.RoamRspHead;

public class jfm
  extends LBSObserver
{
  public jfm(VipMapRoamActivity paramVipMapRoamActivity) {}
  
  protected void a(boolean paramBoolean, RespHeader paramRespHeader, RespGetEncounterV2 paramRespGetEncounterV2, ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "onUpdateGetEncounter isSuccess=" + paramBoolean);
    }
    paramToServiceMsg.extraData.getInt("gender");
    boolean bool = paramToServiceMsg.extraData.getBoolean("first");
    long l = paramToServiceMsg.extraData.getLong("requestId");
    paramToServiceMsg.getUin();
    if (l != this.a.jdField_a_of_type_Long) {
      return;
    }
    this.a.jdField_c_of_type_Boolean = false;
    if ((paramBoolean) && (paramRespGetEncounterV2 != null))
    {
      this.a.n = 0;
      this.a.app.b(true, true);
      paramRespHeader = paramRespGetEncounterV2.vEncounterInfos;
      if (bool)
      {
        this.a.jdField_a_of_type_JavaUtilList = new ArrayList(100);
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.a.jdField_a_of_type_JavaUtilList, true);
      }
      if (paramRespHeader != null) {
        this.a.jdField_a_of_type_JavaUtilList.addAll(paramRespHeader);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
      this.a.jdField_b_of_type_Long = System.currentTimeMillis();
      if (paramRespGetEncounterV2.stUserData.lNextGrid != -1L)
      {
        this.a.jdField_c_of_type_AndroidViewView.setVisibility(4);
        this.a.d.setVisibility(0);
        paramRespHeader = this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a;
        if ((!this.a.jdField_a_of_type_JavaUtilList.isEmpty()) || (paramRespHeader == null)) {
          break label559;
        }
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
        if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.a()) {
          break label503;
        }
        paramToServiceMsg = (TextView)paramRespHeader.findViewById(2131297963);
        paramToServiceMsg.setText(this.a.getString(2131369571));
        paramToServiceMsg.setTextColor(this.a.getResources().getColor(2131427972));
        paramRespHeader.findViewById(2131297967).setVisibility(4);
        paramRespHeader.setOnClickListener(null);
        label352:
        this.a.h();
        VipMapRoamActivity.a(this.a, false);
        if ((!StringUtil.b(paramRespGetEncounterV2.strSecurityTips)) && (!StringUtil.b(paramRespGetEncounterV2.strSecurityDetailUrl))) {
          this.a.a(paramRespGetEncounterV2.strSecurityTips, paramRespGetEncounterV2.strSecurityDetailUrl);
        }
        if (1 == this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a()) {
          this.a.g();
        }
        paramRespGetEncounterV2 = this.a.app;
        if (!VipUtils.a(this.a.app)) {
          break label596;
        }
        paramRespHeader = "1";
        label447:
        VipUtils.a(paramRespGetEncounterV2, "Vip_MapRoam", "0X8004A2F", "0X8004A2F", 0, 0, new String[] { paramRespHeader });
      }
    }
    for (;;)
    {
      this.a.b(paramBoolean, bool);
      return;
      this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.a.d.setVisibility(4);
      break;
      label503:
      paramToServiceMsg = (TextView)paramRespHeader.findViewById(2131297963);
      paramToServiceMsg.setText("当前筛选条件下找不到附近的人");
      paramToServiceMsg.setTextColor(this.a.getResources().getColor(2131427934));
      paramRespHeader.findViewById(2131297967).setVisibility(0);
      paramRespHeader.setOnClickListener(this.a);
      break label352;
      label559:
      if ((this.a.jdField_b_of_type_AndroidViewView == null) || (this.a.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
        break label352;
      }
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
      break label352;
      label596:
      paramRespHeader = "0";
      break label447;
      if (paramRespHeader != null)
      {
        int i = paramRespHeader.eReplyCode;
        this.a.n = i;
        this.a.e = paramRespHeader.strResult;
        if (i == 100500)
        {
          paramRespGetEncounterV2 = this.a.app;
          if (VipUtils.a(this.a.app))
          {
            paramRespHeader = "1";
            label665:
            VipUtils.a(paramRespGetEncounterV2, "Vip_MapRoam", "0X8004A30", "0X8004A30", 0, 0, new String[] { paramRespHeader });
            if (!TextUtils.isEmpty(this.a.e)) {
              break label747;
            }
          }
          label747:
          for (paramRespHeader = this.a.getResources().getString(2131369318);; paramRespHeader = this.a.e)
          {
            Utils.a(this.a.getApplication(), 2131365995, paramRespHeader, new jfn(this), null);
            break;
            paramRespHeader = "0";
            break label665;
          }
        }
        if (i == 100501) {
          QQToast.a(this.a.getApplication(), this.a.e, 0).b(this.a.getTitleBarHeight());
        } else {
          VipMapRoamActivity.b(this.a, 1, 2131369320);
        }
      }
      else
      {
        if (!NetworkUtil.e(this.a.getApplication()))
        {
          QQToast.a(this.a.getApplication(), this.a.getString(2131365730), 0).b(this.a.getTitleBarHeight());
          return;
        }
        VipMapRoamActivity.c(this.a, 1, 2131369320);
      }
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Roam.RoamRspHead)))
    {
      paramObject = (Roam.RoamRspHead)paramObject;
      if (paramObject != null)
      {
        this.a.n = paramObject.result.get();
        this.a.e = paramObject.msg.get();
        if (QLog.isColorLevel()) {
          QLog.d("VipMapRoamActivity", 2, "onGetRoamQualify respHead:isSuccess=true,result=" + this.a.n + ",msg=" + this.a.e);
        }
        if ((this.a.n == 0) && (!TextUtils.isEmpty(this.a.e))) {
          QQToast.a(this.a.getApplication(), this.a.e, 1).b(this.a.getTitleBarHeight());
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VipMapRoamActivity", 2, "onGetRoamQualify data is null or not RoamRspHead,isSuccess=" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jfm
 * JD-Core Version:    0.7.0.1
 */