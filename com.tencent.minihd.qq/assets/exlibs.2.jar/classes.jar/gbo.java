import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class gbo
  extends FriendListObserver
{
  public gbo(PublicAccountChatPie paramPublicAccountChatPie, ImageView paramImageView) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a().a))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a.b(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbo
 * JD-Core Version:    0.7.0.1
 */