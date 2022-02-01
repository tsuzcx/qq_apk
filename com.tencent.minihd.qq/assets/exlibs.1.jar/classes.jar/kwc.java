import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class kwc
  implements MediaPlayer.OnErrorListener
{
  public kwc(int paramInt, VipFunCallMediaListener paramVipFunCallMediaListener, VideoView paramVideoView, boolean paramBoolean) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VipFunCallManager.a, 2, "playing onError what=" + paramInt1 + ", extra=" + paramInt2 + ", funcallid=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener.a(paramInt1, paramInt2, this.jdField_a_of_type_Int);
    }
    paramMediaPlayer = VipFunCallManager.a(this.jdField_a_of_type_Int, VipFunCallManager.b);
    if (TextUtils.isEmpty(paramMediaPlayer)) {}
    RelativeLayout localRelativeLayout;
    do
    {
      do
      {
        do
        {
          return true;
        } while (!new File(paramMediaPlayer).exists());
        paramMediaPlayer = VipFunCallManager.a(paramMediaPlayer);
      } while ((paramMediaPlayer == null) || (this.jdField_a_of_type_AndroidWidgetVideoView == null));
      if (this.jdField_a_of_type_Boolean == true)
      {
        this.jdField_a_of_type_AndroidWidgetVideoView.setBackgroundDrawable(paramMediaPlayer);
        return true;
      }
      this.jdField_a_of_type_AndroidWidgetVideoView.setVisibility(8);
      localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetVideoView.getParent();
    } while (localRelativeLayout == null);
    localRelativeLayout.setBackgroundDrawable(paramMediaPlayer);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kwc
 * JD-Core Version:    0.7.0.1
 */