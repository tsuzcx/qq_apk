import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;

public class kbn
  extends BroadcastReceiver
{
  public kbn(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("key_photo_delete_action".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("key_photo_delete_position", -1);
      this.a.a(i, 9);
    }
    do
    {
      do
      {
        do
        {
          return;
          if ("key_audio_delete_action".equals(paramContext))
          {
            this.a.a(0);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
            TroopBarUtils.a(this.a.ad, this.a.ae, "del_record", this.a.af, this.a.ac, "", "");
            return;
          }
          if ("key_music_delete_action".equals(paramContext))
          {
            this.a.a(0);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = null;
            TroopBarUtils.a(this.a.ad, this.a.ae, "del_music", this.a.af, this.a.ac, "", "");
            return;
          }
          if ("key_video_delete_action".equals(paramContext))
          {
            this.a.a(0);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = null;
            return;
          }
          if ("key_audio_play_action".equals(paramContext))
          {
            TroopBarUtils.a(this.a.ad, this.a.ae, "preview_record", this.a.af, this.a.ac, "", "");
            return;
          }
          if ("key_video_play_action".equals(paramContext))
          {
            TroopBarUtils.a(this.a.ad, this.a.ae, "Clk_preview", this.a.af, this.a.ac, "", "");
            return;
          }
          if (!"key_video_time_overflow".equals(paramContext)) {
            break;
          }
        } while (!TroopBarPublishActivity.ah.equals(paramIntent.getStringExtra("className")));
        TroopBarUtils.a(this.a.ad, this.a.ae, "more_choose", this.a.af, this.a.ac, "0", "");
        return;
        if (!"key_video_size_overflow".equals(paramContext)) {
          break;
        }
      } while (!TroopBarPublishActivity.ah.equals(paramIntent.getStringExtra("className")));
      TroopBarUtils.a(this.a.ad, this.a.ae, "more_choose", this.a.af, this.a.ac, "1", "");
      return;
      if ("key_video_select_apply_click".equals(paramContext))
      {
        TroopBarUtils.a(this.a.ad, this.a.ae, "Clk_use", this.a.af, this.a.ac, "", "");
        return;
      }
    } while ((!"key_video_select_confirm_ok_click".equals(paramContext)) || (!TroopBarPublishActivity.ah.equals(paramIntent.getStringExtra("className"))));
    TroopBarUtils.a(this.a.ad, this.a.ae, "Clk_choose", this.a.af, this.a.ac, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kbn
 * JD-Core Version:    0.7.0.1
 */