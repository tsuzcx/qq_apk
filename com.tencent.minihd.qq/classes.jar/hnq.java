import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.FowardIntent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class hnq
  extends BroadcastReceiver
{
  public hnq(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(QQAppInterface.e(this.a).getPackageName()))) {
      if (QLog.isColorLevel()) {
        QLog.d(QQAppInterface.b, 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + (String)localObject);
      }
    }
    label517:
    label750:
    label888:
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (((String)localObject).equals("tencent.video.v2q.VideoFlowSize"))
              {
                l = paramIntent.getLongExtra("size", 0L);
                if (QLog.isColorLevel()) {
                  QLog.d(QQAppInterface.b, 2, "ACTION_VIDEO_FLOW_SIZE: " + l);
                }
                this.a.a(this.a.getAccount(), new String[] { "param_XGVideoFlow", "param_XGFlow", "param_Flow" }, l);
                return;
              }
              String str1;
              boolean bool;
              if (((String)localObject).equals("tencent.video.v2q.replyMsg"))
              {
                i = paramIntent.getIntExtra("uinType", 0);
                localObject = paramIntent.getStringExtra("friendUin");
                str1 = paramIntent.getStringExtra("friendName");
                String str2 = paramIntent.getStringExtra("extraUin");
                String str3 = paramIntent.getStringExtra("replyMsg");
                bool = paramIntent.getBooleanExtra("isDiyMsg", false);
                if (QLog.isColorLevel()) {
                  QLog.d(QQAppInterface.b, 2, "ACTION_MSG_REPLY uinType: " + i + ", friendUin: " + (String)localObject + ", friendNick: " + str1 + ", extraUin: " + str2 + ", replyMsg: " + str3 + ", isDiyMsg: " + bool);
                }
                if (bool)
                {
                  paramContext = new FowardIntent(paramContext, null, ChatActivity.class);
                  paramContext.putExtra("uintype", i);
                  paramContext.putExtra("uinname", str1);
                  if (i == 1006)
                  {
                    paramContext.putExtra("uin", str2);
                    paramContext.addFlags(268435456);
                    paramContext.addFlags(67108864);
                    if (!QQUtils.a(this.a.a())) {
                      break label517;
                    }
                    paramContext.putExtra("ext_panel_onresume", 2);
                  }
                  for (;;)
                  {
                    paramContext.putExtra("enter_ext_panel", 1);
                    this.a.a().startActivity(paramContext);
                    return;
                    if (i == 1000)
                    {
                      paramContext.putExtra("uin", (String)localObject);
                      paramIntent = ((FriendManager)this.a.getManager(8)).a(str2);
                      paramContext.putExtra("troop_uin", paramIntent.troopcode);
                      paramContext.putExtra("troop_code", paramIntent.troopuin);
                      break;
                    }
                    if (i == 1004)
                    {
                      paramContext.putExtra("uin", (String)localObject);
                      paramContext.putExtra("troop_uin", str2);
                      break;
                    }
                    paramContext.putExtra("uin", (String)localObject);
                    break;
                    paramContext.putExtra("ext_panel_onresume", 1);
                  }
                }
                new Handler(Looper.getMainLooper()).postDelayed(new hnr(this, i, str1, str2, (String)localObject, paramContext, str3), 300L);
                return;
              }
              if (((String)localObject).equals("tencent.video.v2q.leaveMsg"))
              {
                bool = paramIntent.getBooleanExtra("isPtt", false);
                i = paramIntent.getIntExtra("uinType", 0);
                localObject = paramIntent.getStringExtra("friendUin");
                str1 = paramIntent.getStringExtra("friendName");
                paramIntent = paramIntent.getStringExtra("extraUin");
                if (QLog.isColorLevel()) {
                  QLog.d(QQAppInterface.b, 2, "ACTION_MSG_LEAVE uinType: " + i + ", friendUin: " + (String)localObject + ", friendNick: " + str1 + ", extraUin: " + paramIntent + ", isPtt: " + bool);
                }
                paramContext = new FowardIntent(paramContext, null, ChatActivity.class);
                paramContext.putExtra("uintype", i);
                paramContext.putExtra("uinname", str1);
                if (i == 1006)
                {
                  paramContext.putExtra("uin", paramIntent);
                  if (!QQUtils.a(this.a.a())) {
                    break label888;
                  }
                  paramContext.putExtra("ext_panel_onresume", 2);
                  if (!bool) {
                    break label899;
                  }
                  paramContext.putExtra("enter_ext_panel", 4);
                }
                for (;;)
                {
                  paramContext.addFlags(268435456);
                  paramContext.addFlags(67108864);
                  this.a.a().startActivity(paramContext);
                  return;
                  if (i == 1000)
                  {
                    paramContext.putExtra("uin", (String)localObject);
                    paramIntent = ((FriendManager)this.a.getManager(8)).a(paramIntent);
                    paramContext.putExtra("troop_uin", paramIntent.troopuin);
                    paramContext.putExtra("troop_code", paramIntent.troopcode);
                    break;
                  }
                  if (i == 1004)
                  {
                    paramContext.putExtra("uin", (String)localObject);
                    paramContext.putExtra("troop_uin", paramIntent);
                    break;
                  }
                  paramContext.putExtra("uin", (String)localObject);
                  break;
                  paramContext.putExtra("ext_panel_onresume", 1);
                  break label750;
                  paramContext.putExtra("enter_ext_panel", 1);
                }
              }
              if (((String)localObject).equals(""))
              {
                if (QLog.isColorLevel()) {
                  QLog.d(QQAppInterface.b, 2, "ACTION_GAUDIO_TROOP_CARD");
                }
                paramContext = paramIntent.getStringExtra("troopUin");
                paramIntent = paramIntent.getStringExtra("memberUin");
                localObject = new FowardIntent(this.a.a(), null, TroopMemberCardActivity.class);
                ((Intent)localObject).addFlags(268435456);
                ((Intent)localObject).putExtra("troopUin", paramContext);
                ((Intent)localObject).putExtra("memberUin", paramIntent);
                ((Intent)localObject).putExtra("fromFlag", 0);
                this.a.a().startActivity((Intent)localObject);
                return;
              }
              if (((String)localObject).equals(""))
              {
                if (QLog.isColorLevel()) {
                  QLog.i(QQAppInterface.b, 2, "ACTION_BIND_CONTACT from qav");
                }
                paramContext = new Intent(paramContext, BindNumberActivity.class);
                paramContext.putExtra("kNeedUnbind", true);
                paramContext.putExtra("key_is_first_activity", false);
                paramContext.addFlags(268435456);
                this.a.a().startActivity(paramContext);
                return;
              }
              if (((String)localObject).equals(""))
              {
                if (QLog.isColorLevel()) {
                  QLog.i(QQAppInterface.b, 2, "ACTION_OPEN_CONTACT_LIST from qav");
                }
                paramContext = new Intent(paramContext, PhoneFrameActivity.class);
                paramContext.putExtra("key_req_type", 0);
                paramContext.addFlags(268435456);
                this.a.a().startActivity(paramContext);
                return;
              }
              if (!((String)localObject).equals("tencent.video.v2q.AnnimateDownloadStart")) {
                break;
              }
              i = paramIntent.getIntExtra("key_fun_call_id", 0);
            } while (i <= 0);
            paramContext = (VipFunCallManager)this.a.getManager(79);
            if (!VipFunCallManager.a()) {
              break;
            }
          } while (paramContext == null);
          paramContext.a(i, VipFunCallManager.a(), false, 0);
          return;
        } while (paramContext == null);
        paramContext.a(i, "");
        return;
        if (((String)localObject).equals("tencent.av.v2q.CheckChatAbility"))
        {
          paramContext = this.a.a().getString(2131363038);
          paramIntent = this.a.a().getString(2131363034);
          paramContext = DialogUtil.a(this.a.a().getApplicationContext(), 230, paramIntent, paramContext, 2131365736, 2131363043, new hns(this), null);
          paramContext.getWindow().setType(2003);
          paramContext.show();
          new Handler(Looper.getMainLooper()).postDelayed(new hnt(this, paramContext), 5000L);
          return;
        }
        if (!((String)localObject).equals("tencent.video.v2q.commingRingDownload")) {
          break;
        }
        l = paramIntent.getLongExtra("comming_ring_down_key", 0L);
      } while (l <= 0L);
      ((ColorRingManager)this.a.getManager(44)).a(l, 3, false, 0, "comering");
      int i = ((SVIPHandler)this.a.a(12)).f();
      ReportController.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, 0, "" + i, "", "", "");
      return;
    } while (!((String)localObject).equals("chatbgBroadcast"));
    label899:
    localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("friendUin");
    ChatBackground.b(paramContext, this.a.getAccount(), paramIntent, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnq
 * JD-Core Version:    0.7.0.1
 */