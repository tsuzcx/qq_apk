import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class imx
  extends FMObserver
{
  public imx(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QfileFileAssistantActivity.b(this.a)) {
      return;
    }
    this.a.runOnUiThread(new imy(this, paramBoolean));
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (!QfileFileAssistantActivity.b(this.a)) {
      FMToastUtil.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     imx
 * JD-Core Version:    0.7.0.1
 */