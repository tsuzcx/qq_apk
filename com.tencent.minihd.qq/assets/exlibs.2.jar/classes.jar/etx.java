import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.SVIPObserver;

public class etx
  extends SVIPObserver
{
  public etx(QQSettingMe paramQQSettingMe) {}
  
  public void a()
  {
    QQSettingMe.a(this.a).setLength(0);
    QQSettingMe.a(this.a).append(QQSettingMe.a(this.a));
    this.a.a.runOnUiThread(new ety(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     etx
 * JD-Core Version:    0.7.0.1
 */