import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.BaseApplication;

public class jse
  implements IStatusListener
{
  public jse(EditActivity paramEditActivity) {}
  
  @TargetApi(9)
  public void a(int paramInt, RichStatus paramRichStatus)
  {
    EditActivity.b(this.a, false);
    this.a.b = false;
    if (paramInt == 100)
    {
      paramRichStatus = this.a.app.a().getSharedPreferences(this.a.app.a(), 0).edit();
      paramRichStatus.putBoolean("tipsbar_clicked", false);
      if (Build.VERSION.SDK_INT <= 8) {
        paramRichStatus.commit();
      }
      for (;;)
      {
        this.a.a(2131368786);
        this.a.setResult(-1);
        this.a.finish();
        return;
        paramRichStatus.apply();
      }
    }
    if (paramInt == -210006)
    {
      this.a.a(16);
      return;
    }
    if (paramInt == -210007)
    {
      this.a.a(18);
      return;
    }
    if (paramInt == -210008)
    {
      this.a.a(19);
      return;
    }
    this.a.a(17);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jse
 * JD-Core Version:    0.7.0.1
 */