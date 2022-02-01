import android.widget.ProgressBar;
import android.widget.TextView;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;

class lzy
  implements Runnable
{
  lzy(lzx paramlzx, int paramInt) {}
  
  public void run()
  {
    int i = 80;
    int j = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int < 80) {
      if (this.jdField_a_of_type_Int * 5 <= 80) {}
    }
    for (;;)
    {
      QQWiFiPluginInstallActivity.a(this.jdField_a_of_type_Lzx.a).setText(String.format(QQWiFiPluginInstallActivity.a(this.jdField_a_of_type_Lzx.a), new Object[] { Integer.valueOf(i) }));
      QQWiFiPluginInstallActivity.a(this.jdField_a_of_type_Lzx.a).setProgress(i);
      return;
      i = this.jdField_a_of_type_Int * 5;
      continue;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lzy
 * JD-Core Version:    0.7.0.1
 */