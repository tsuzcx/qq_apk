import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MusicSharePlayActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public class jxb
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  public jxb(StructMsgForAudioShare paramStructMsgForAudioShare) {}
  
  public void onClick(View paramView)
  {
    Resources localResources = paramView.getContext().getResources();
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = l;
      if ((paramView.getTag() instanceof AbsShareMsg)) {
        break label42;
      }
    }
    label42:
    do
    {
      for (;;)
      {
        return;
        Object localObject = (AbsShareMsg)paramView.getTag();
        Context localContext = paramView.getContext();
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)((BaseApplicationImpl)localContext.getApplicationContext()).getAppRuntime(((AbsShareMsg)localObject).currentAccountUin);
          if (localQQAppInterface != null) {
            MediaPlayerManager.a(localQQAppInterface).a(true);
          }
          if ((localObject != null) && (((AbsShareMsg)localObject).mMsgServiceID == 2))
          {
            localObject = (StructMsgForAudioShare)localObject;
            if (QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare))
            {
              QQPlayerService.c(localContext);
              paramView.setContentDescription(localResources.getString(2131369275));
              return;
            }
          }
        }
        catch (AccountNotMatchException localAccountNotMatchException)
        {
          SongInfo localSongInfo;
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("StructMsg", 4, localAccountNotMatchException.getStackTrace().toString());
            }
            localSongInfo = null;
          }
          if (localSongInfo.d())
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQPlayerService", 2, "Video Chatting is going on, don't play music.");
            }
          }
          else
          {
            localSongInfo = new SongInfo();
            localSongInfo.a = ((StructMsgForAudioShare)localObject).mContentSrc;
            localSongInfo.b = ((StructMsgForAudioShare)localObject).mContentTitle;
            localSongInfo.c = ((StructMsgForAudioShare)localObject).mContentSummary;
            localSongInfo.d = ((StructMsgForAudioShare)localObject).mContentCover;
            localSongInfo.e = ((StructMsgForAudioShare)localObject).mMsgUrl;
            QQPlayerService.a(new Intent(localContext, MusicSharePlayActivity.class));
            QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare);
            QQPlayerService.a(localContext, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.getToken(), localSongInfo);
            paramView.setContentDescription(localResources.getString(2131369274));
            return;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQPlayerService", 2, "msg is null or serviceId not audio_share");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jxb
 * JD-Core Version:    0.7.0.1
 */