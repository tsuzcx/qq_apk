import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

public class jyw
  implements ShareAppLogHelper.OnGetLocalLogListener
{
  public jyw(ShareAppLogActivity paramShareAppLogActivity) {}
  
  public void a(int paramInt)
  {
    ShareAppLogActivity.a(this.a);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230).setTitle("警告").setMessage(ShareAppLogActivity.a(this.a).a(paramInt));
    localQQCustomDialog.setPositiveButton("继续", new jyx(this));
    localQQCustomDialog.setNegativeButton("取消", new jyy(this));
    localQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    try
    {
      ShareAppLogActivity.a(this.a, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QQToast.a(this.a.getApplicationContext(), "发送失败!", 0).a();
      return;
    }
    finally
    {
      ShareAppLogActivity.a(this.a);
    }
  }
  
  public void b(int paramInt)
  {
    ShareAppLogActivity.a(this.a);
    QQToast.a(this.a.getApplicationContext(), ShareAppLogActivity.a(this.a).a(paramInt), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jyw
 * JD-Core Version:    0.7.0.1
 */