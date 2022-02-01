import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NeighborComm.RespHeader;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.NearbyBannerMgr;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class emi
  extends LBSObserver
{
  public emi(NearbyActivity paramNearbyActivity) {}
  
  protected void a(boolean paramBoolean, RespHeader paramRespHeader, RespGetEncounterV2 paramRespGetEncounterV2, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.extraData.getInt("gender");
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("first");
    int i = paramToServiceMsg.extraData.getInt("classChild");
    long l = paramToServiceMsg.extraData.getLong("requestId");
    Object localObject2 = paramToServiceMsg.getUin();
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("showPortraitGuide", false);
    Object localObject1;
    if (paramRespHeader != null)
    {
      localObject1 = Integer.valueOf(paramRespHeader.eReplyCode);
      DatingUtil.b("onUpdateGetEncounter isSuccess:", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Integer.valueOf(i), localObject1, Long.valueOf(l), Long.valueOf(NearbyActivity.a(this.a)) });
      if (l == NearbyActivity.a(this.a)) {
        break label160;
      }
    }
    label1041:
    label1052:
    for (;;)
    {
      return;
      localObject1 = "null";
      break;
      label160:
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_Boolean = true;
      }
      NearbyActivity.a(this.a, false);
      if ((paramBoolean) && (paramRespGetEncounterV2 != null))
      {
        ThreadManager.a().post(new emj(this));
        NearbyActivity.a(this.a, NearbyActivity.a(this.a));
        this.a.p = paramRespGetEncounterV2.stUserData.iLat;
        this.a.q = paramRespGetEncounterV2.stUserData.iLon;
        this.a.jdField_a_of_type_Long = (MessageCache.a() * 1000L);
        NearbyActivity.a(this.a, System.currentTimeMillis());
        if (paramRespGetEncounterV2.stUserData.lNextGrid != -1L)
        {
          NearbyActivity.b(this.a, true);
          paramRespHeader = paramRespGetEncounterV2.vEncounterInfos;
          if (!bool1) {
            break label968;
          }
          NearbyActivity.a(this.a).clear();
          if (paramRespHeader != null) {
            NearbyActivity.a(this.a).addAll(paramRespHeader);
          }
          if (!NearbyActivity.a(this.a).isEmpty())
          {
            paramRespHeader = new ArrayList(NearbyActivity.a(this.a));
            if (this.a.m == 0) {
              ThreadManager.a().post(new emk(this, (String)localObject2, paramRespHeader));
            }
          }
          if (NearbyActivity.a(this.a) != null) {
            NearbyActivity.a(this.a).a(paramRespGetEncounterV2.entrance_list, 0);
          }
          label424:
          paramRespHeader = null;
          localObject1 = paramRespGetEncounterV2.neighbor_banners;
          if ((NearbyActivity.a(this.a) != null) || (localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break label989;
          }
          ThreadManager.a().post(new eml(this, (List)localObject1, bool1));
          label476:
          if ((paramRespHeader != null) && (paramRespHeader.size() != NearbyActivity.a(this.a).size()))
          {
            NearbyActivity.a(this.a).clear();
            NearbyActivity.a(this.a).addAll(paramRespHeader);
          }
          if ((QLog.isColorLevel()) && (NearbyActivity.a(this.a).getCount() > 0))
          {
            paramRespHeader = NearbyActivity.a(this.a).getItem(0);
            if ((paramRespHeader instanceof RespEncounterInfo))
            {
              paramRespHeader = (RespEncounterInfo)paramRespHeader;
              if (paramRespHeader != null) {
                QLog.d("Q.nearby", 2, "onUpdateGetEncounter myself info: tinyId=" + paramRespHeader.tiny_id + " lEctID=" + paramRespHeader.lEctID);
              }
            }
          }
          if ((!StringUtil.b(paramRespGetEncounterV2.strSecurityTips)) && (!StringUtil.b(paramRespGetEncounterV2.strSecurityDetailUrl)))
          {
            paramRespHeader = DialogUtil.a(this.a, 230);
            paramRespHeader.setTitle("温馨提示");
            paramRespHeader.getMessageTextView().setVisibility(8);
            localObject1 = paramRespHeader.getMessageTextView_Plain_Text();
            ((TextView)localObject1).setVisibility(0);
            localObject2 = new SpannableString(paramRespGetEncounterV2.strSecurityTips + "了解更多");
            ((SpannableString)localObject2).setSpan(new URLSpan(paramRespGetEncounterV2.strSecurityDetailUrl), paramRespGetEncounterV2.strSecurityTips.length(), ((SpannableString)localObject2).length(), 18);
            ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), paramRespGetEncounterV2.strSecurityTips.length(), ((SpannableString)localObject2).length(), 33);
            ((TextView)localObject1).setText((CharSequence)localObject2);
            ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
            paramRespHeader.setNegativeButton(2131365737, new emm(this, paramRespHeader));
            paramRespHeader.show();
          }
          label805:
          NearbyActivity.a(this.a, bool1, NearbyActivity.b(this.a));
          if ((paramBoolean) || (paramToServiceMsg == null) || (paramToServiceMsg.extraData == null) || (paramToServiceMsg.extraData.getBoolean("isLbsInfoNull", false) != true)) {
            break label1041;
          }
          ThreadManager.b(new emn(this));
        }
      }
      for (;;)
      {
        if ((!paramBoolean) || (!bool1) || (!bool2) || (NearbyActivity.b(this.a))) {
          break label1052;
        }
        NearbyActivity.c(this.a, this.a.app.getPreferences().getBoolean("nearby_people_portrait_guide_ok", false));
        if ((!NearbyActivity.b(this.a)) && (!this.a.jdField_a_of_type_ComTencentWidgetXListView.q())) {
          NearbyActivity.c(this.a);
        }
        NearbyActivity.c(this.a, true);
        return;
        NearbyActivity.b(this.a, false);
        break;
        label968:
        if (paramRespHeader == null) {
          break label424;
        }
        NearbyActivity.a(this.a).addAll(paramRespHeader);
        break label424;
        label989:
        if (NearbyActivity.a(this.a) == null) {
          break label476;
        }
        paramRespHeader = NearbyActivity.a(this.a).a((List)localObject1, bool1, bool1);
        break label476;
        if ((paramRespHeader == null) || (paramRespHeader.eReplyCode != 7)) {
          break label805;
        }
        NearbyActivity.b(this.a, true);
        return;
        NearbyActivity.a(this.a, paramBoolean, bool1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     emi
 * JD-Core Version:    0.7.0.1
 */