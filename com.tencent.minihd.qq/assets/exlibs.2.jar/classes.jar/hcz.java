import com.tencent.mobileqq.activity.widget.qqmusic.business.radio.GuessYouLikeManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.RadioSongListInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.SonginfoUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import java.util.ArrayList;

public class hcz
  implements OnResultListener
{
  public hcz(GuessYouLikeManager paramGuessYouLikeManager) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(CommonResponse paramCommonResponse)
  {
    MLog.b("liwei", "onSuccess");
    QQPlayerService.a(103);
    paramCommonResponse = (RadioSongListInfo)paramCommonResponse.a();
    if ((paramCommonResponse == null) || (paramCommonResponse.a() == null) || (paramCommonResponse.a().size() == 0))
    {
      MLog.d("liwei", "songListInfo == null");
      return;
    }
    GuessYouLikeManager.a(this.a, paramCommonResponse.a());
    paramCommonResponse = SonginfoUtil.a(GuessYouLikeManager.a(this.a), 1);
    QQPlayerService.a(GuessYouLikeManager.a(this.a), QQPlayerService.a(6, ""), paramCommonResponse, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcz
 * JD-Core Version:    0.7.0.1
 */