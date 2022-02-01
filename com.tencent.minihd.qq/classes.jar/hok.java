import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QzoneWrapperActivity;
import com.tencent.mobileqq.activity.SettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQTabActivity;
import mqq.app.BasePadActivity;

public class hok
  extends BroadcastReceiver
{
  public hok(QQTabActivity paramQQTabActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Log.i("app2", "Profile receive  action=" + paramContext);
    if (paramContext.equals("activty_clear_top"))
    {
      paramContext = this.a.b();
      paramIntent.setAction(null);
      if ((paramContext instanceof BasePadActivity)) {
        ((BasePadActivity)paramContext).clearTop(paramIntent);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            if (!"fragment_on_recieve".equals(paramContext)) {
                              break;
                            }
                            paramContext = this.a.b();
                          } while (!(paramContext instanceof BasePadActivity));
                          ((BasePadActivity)paramContext).doOnRecieve(paramIntent);
                          return;
                          if ("new_task_activity_result".equals(paramContext))
                          {
                            int i = paramIntent.getIntExtra("requestCode", 0);
                            int j = paramIntent.getIntExtra("resultCode", 0);
                            paramIntent.removeExtra("requestCode");
                            paramIntent.removeExtra("resultCode");
                            this.a.doOnActivityResult(i, j, paramIntent);
                            return;
                          }
                          if (!"top_fragment_anim".equals(paramContext)) {
                            break;
                          }
                          paramContext = this.a.b();
                        } while (!(paramContext instanceof BasePadActivity));
                        bool1 = paramIntent.getBooleanExtra("enter", false);
                      } while (!paramIntent.getBooleanExtra("open_fragment_no_anim_once", false));
                      ((BasePadActivity)paramContext).startTopFragmentEnterAnim(bool1);
                      return;
                    } while (!"Common_BroadcastReceiver".equals(paramContext));
                    paramContext = this.a.b();
                    paramIntent.setAction(null);
                    if (!paramIntent.getBooleanExtra("friend_forward_photo", false)) {
                      break;
                    }
                  } while (!(paramContext instanceof BaseActivity));
                  this.a.a(1);
                  ((BaseActivity)this.a.b()).forward(paramIntent);
                  return;
                  if (!paramIntent.getBooleanExtra("forward_location", false)) {
                    break;
                  }
                } while (!(paramContext instanceof BaseActivity));
                ((BaseActivity)paramContext).openAIO(paramIntent);
                return;
                if (!paramIntent.getBooleanExtra("select_member", false)) {
                  break;
                }
              } while (!(paramContext instanceof BaseActivity));
              if (paramIntent.getBooleanExtra("select_clear_stack", true))
              {
                ((BaseActivity)paramContext).openAIO(paramIntent);
                return;
              }
              ((BaseActivity)paramContext).openAIOTop(paramIntent);
              return;
              if (!paramIntent.getBooleanExtra("action_notify_finish", false)) {
                break;
              }
            } while (!(paramContext instanceof BasePadActivity));
            ((BasePadActivity)paramContext).rightPanelEmpty();
            return;
            if (paramIntent.getBooleanExtra("open_profile_card_from_scanner", false))
            {
              ProfileActivity.b(paramContext, (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("param_all_in_one"));
              return;
            }
            if (paramIntent.getBooleanExtra("open_troop_info_from_scanner", false))
            {
              ChatSettingForTroop.a(paramContext, paramIntent.getExtras(), 2);
              return;
            }
            if (!paramIntent.getBooleanExtra("send_hb_success", false)) {
              break;
            }
          } while (!(paramContext instanceof SettingMe));
          ((SettingMe)paramContext).a();
          return;
          if (!paramIntent.getBooleanExtra("com.tencent.intent.action.QZONE_GOTO_ABOUT_ME", false)) {
            break;
          }
          this.a.a(4);
          paramContext = this.a.b();
        } while (!(paramContext instanceof QzoneWrapperActivity));
        ((QzoneWrapperActivity)paramContext).b();
        return;
        if (!paramIntent.getBooleanExtra("show_shadow_on_page", false)) {
          break;
        }
      } while (!(paramContext instanceof BaseActivity));
      boolean bool1 = paramIntent.getBooleanExtra("shadow_anim", false);
      boolean bool2 = paramIntent.getBooleanExtra("shadow_visible", false);
      ((BaseActivity)paramContext).setShadowInLeftVisible(bool2, bool1);
      return;
    } while ((!paramIntent.getBooleanExtra("send_emoji_to_friend", false)) || (!(paramContext instanceof BaseActivity)));
    ((BaseActivity)paramContext).openAIO(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hok
 * JD-Core Version:    0.7.0.1
 */