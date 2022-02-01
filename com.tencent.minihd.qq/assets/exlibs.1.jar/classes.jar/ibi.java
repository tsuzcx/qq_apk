import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingFeedActivity;

class ibi
  implements Runnable
{
  ibi(ibh paramibh) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.a.getSharedPreferences("dating_pref" + this.a.a.app.a(), 0).edit();
    localEditor.putBoolean("feed_has_more", DatingFeedActivity.b(this.a.a));
    if (DatingFeedActivity.a(this.a.a) != null) {
      localEditor.putString("feed_cookie", Base64.encodeToString(DatingFeedActivity.a(this.a.a), 0));
    }
    localEditor.putBoolean("feed_have_published", DatingFeedActivity.c(this.a.a));
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibi
 * JD-Core Version:    0.7.0.1
 */