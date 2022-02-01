import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;

public class maa
  implements Runnable
{
  public maa(QQWiFiPluginInstallActivity paramQQWiFiPluginInstallActivity) {}
  
  public void run()
  {
    QQWiFiPluginInstallActivity.a(this.a).setVisibility(8);
    Drawable localDrawable = this.a.getResources().getDrawable(2130838136);
    if (QQWiFiPluginInstallActivity.a(this.a).getDrawable() != localDrawable)
    {
      QQWiFiPluginInstallActivity.a(this.a).setImageDrawable(localDrawable);
      if ((localDrawable instanceof Animatable))
      {
        QQWiFiPluginInstallActivity.a(this.a).setVisibility(0);
        ((Animatable)localDrawable).start();
      }
    }
    QQWiFiPluginInstallActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     maa
 * JD-Core Version:    0.7.0.1
 */