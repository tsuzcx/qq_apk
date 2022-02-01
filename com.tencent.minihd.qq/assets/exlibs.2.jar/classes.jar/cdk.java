import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

public final class cdk
  implements AsyncBack
{
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (QLog.isColorLevel())) {
      QLog.i("HtmlCheckUpdate", 2, "CODE_SUCCESS");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdk
 * JD-Core Version:    0.7.0.1
 */