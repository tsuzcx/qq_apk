import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.ims.AccountSecurityInfo.AccSecInfoRequire;
import com.tencent.mobileqq.activity.SecurityDetectActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import mqq.app.NewIntent;

public class ezj
  extends Handler
{
  private static final int b = 4;
  private int jdField_a_of_type_Int = 0;
  
  public ezj(SecurityDetectActivity paramSecurityDetectActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool1;
    Object localObject2;
    View localView;
    label324:
    int i;
    switch (paramMessage.what)
    {
    default: 
    case 9: 
      do
      {
        return;
        paramMessage = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302038);
      } while (paramMessage == null);
      if (this.jdField_a_of_type_Int >= 4)
      {
        paramMessage.setVisibility(4);
        return;
      }
      paramMessage.setVisibility(0);
      this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % 4);
      switch (this.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        sendEmptyMessageDelayed(9, 500L);
        return;
        paramMessage.setText(2131368935);
        continue;
        paramMessage.setText(2131368936);
        continue;
        paramMessage.setText(2131368937);
        continue;
        paramMessage.setText("");
      }
    case 1: 
      bool1 = JumpQqPimSecureUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity);
      boolean bool2 = JumpQqPimSecureUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity);
      if (!bool1)
      {
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, 2);
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302045);
        localObject2 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302044);
        localView = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302043);
        ((ProgressBar)localObject2).setVisibility(8);
        localView.setVisibility(0);
        if (SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) == 0) {
          break label492;
        }
        localView.setBackgroundResource(2130837623);
        ((TextView)localObject1).setText(2131368949);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131427999));
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setVisibility(8);
        ((TextView)localObject1).setVisibility(0);
        ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302046)).setVisibility(8);
        ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "qqpimsecure status " + SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity), 0, 0, "", "", "", "");
        if (paramMessage.arg1 != 1) {
          break label537;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label542;
        }
        ((ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302049)).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302048).setVisibility(8);
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendMessage(SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).obtainMessage(2, 1, 0));
        return;
        if (!bool2)
        {
          SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, 1);
          break;
        }
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, 0);
        break;
        localView.setBackgroundResource(2130837746);
        ((TextView)localObject1).setText(2131368948);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131427973));
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setVisibility(0);
        break label324;
      }
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(8, 1000L);
      return;
    case 2: 
      localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302050);
      localObject2 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302049);
      localView = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302048);
      ((ProgressBar)localObject2).setVisibility(8);
      localView.setVisibility(0);
      ((TextView)localObject1).setVisibility(0);
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, null, "security_scan_key", "qqsetting_security_scan_key", false));
      if (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity))
      {
        localView.setBackgroundResource(2130837623);
        ((TextView)localObject1).setText(2131368952);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131427999));
        ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302051)).setVisibility(8);
        if (paramMessage.arg1 != 1) {
          break label833;
        }
        i = 1;
        if (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity)) {
          break label838;
        }
        ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "login secure open", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (i == 0) {
          break label865;
        }
        ((ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302054)).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302053).setVisibility(8);
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendMessage(SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).obtainMessage(3, 1, 0));
        return;
        localView.setBackgroundResource(2130837746);
        ((TextView)localObject1).setText(2131368951);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131427973));
        break;
        i = 0;
        break label706;
        ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "login secure close", 0, 0, "", "", "", "");
      }
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(8, 1000L);
      return;
    case 3: 
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity;
      if (paramMessage.arg1 == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        SecurityDetectActivity.b((SecurityDetectActivity)localObject1, bool1);
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302053);
        localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302054);
        paramMessage.setVisibility(8);
        ((ProgressBar)localObject1).setVisibility(0);
        paramMessage = new AccountSecurityInfo.AccSecInfoRequire();
        paramMessage.str_version.set("5.9.3");
        paramMessage.u64_uin.set(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.getLongAccountUin());
        paramMessage.u32_client_type.set(0);
        paramMessage = paramMessage.toByteArray();
        localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, ProtoServlet.class);
        ((NewIntent)localObject1).putExtra("data", paramMessage);
        ((NewIntent)localObject1).putExtra("cmd", "DevLockSecSvc.AccountDetect");
        ((NewIntent)localObject1).setObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.startServlet((NewIntent)localObject1);
        return;
      }
    case 4: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302060);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
      paramMessage = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302061);
      if (paramMessage != null) {
        paramMessage.setVisibility(8);
      }
      paramMessage = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302062);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302064);
      if (paramMessage != null) {
        paramMessage.setVisibility(8);
      }
      paramMessage = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302065);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(5, 1000L);
      return;
    case 5: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302064);
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302065);
      paramMessage.setVisibility(0);
      ((ProgressBar)localObject1).setVisibility(8);
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302066)).setVisibility(0);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302068);
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302069);
      paramMessage.setVisibility(8);
      ((ProgressBar)localObject1).setVisibility(0);
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(6, 1000L);
      return;
    case 6: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302068);
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302069);
      paramMessage.setVisibility(0);
      ((ProgressBar)localObject1).setVisibility(8);
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302070)).setVisibility(0);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302072);
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302073);
      paramMessage.setVisibility(8);
      ((ProgressBar)localObject1).setVisibility(0);
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(7, 1000L);
      return;
    case 7: 
      label492:
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302072);
      label537:
      label542:
      label706:
      label838:
      label865:
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302073);
      label833:
      paramMessage.setVisibility(0);
      ((ProgressBar)localObject1).setVisibility(8);
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302074)).setVisibility(0);
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(8, 1000L);
      return;
    }
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getSharedPreferences("SecurityDetectActivity", 0).edit();
    paramMessage.putLong("PimscureStatus" + this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.getAccount(), SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity));
    paramMessage.putLong("AccountStatus" + this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.getAccount(), SecurityDetectActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity));
    paramMessage.putLong("LastDetectTime" + this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.getAccount(), System.currentTimeMillis());
    paramMessage.commit();
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources();
    Object localObject1 = paramMessage.getString(2131368940);
    SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131297004));
    SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setVisibility(8);
    SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302041));
    int j;
    if (SecurityDetectActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) != 0)
    {
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setImageResource(2130841614);
      localObject1 = (String)localObject1 + paramMessage.getString(2131368943);
      localObject2 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302039);
      i = 1;
      if (SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) != 0) {
        i = 2;
      }
      j = i;
      if (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity)) {
        j = i + 1;
      }
      ((TextView)localObject2).setText(String.format(paramMessage.getString(2131368939), new Object[] { Integer.valueOf(j) }));
      ((TextView)localObject2).setVisibility(0);
      paramMessage = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131299368);
      paramMessage.setText((CharSequence)localObject1);
      paramMessage.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131427999));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 4;
      SecurityDetectActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, false);
      return;
      if ((SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) != 0) || (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity)))
      {
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setImageResource(2130841615);
        localObject1 = (String)localObject1 + paramMessage.getString(2131368942);
        localObject2 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302039);
        i = 0;
        if (SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) != 0) {
          i = 1;
        }
        j = i;
        if (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity)) {
          j = i + 1;
        }
        ((TextView)localObject2).setText(String.format(paramMessage.getString(2131368939), new Object[] { Integer.valueOf(j) }));
        ((TextView)localObject2).setVisibility(0);
        paramMessage = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131299368);
        paramMessage.setText((CharSequence)localObject1);
        paramMessage.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131428007));
      }
      else
      {
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setImageResource(2130841612);
        paramMessage = (String)localObject1 + paramMessage.getString(2131368941);
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302039);
        ((TextView)localObject1).setText(2131368944);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131302040)).setVisibility(0);
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131299368);
        ((TextView)localObject1).setText(paramMessage);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131427983));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ezj
 * JD-Core Version:    0.7.0.1
 */