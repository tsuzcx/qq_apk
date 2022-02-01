import android.os.Bundle;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.widget.QQToast;

public class jrq
  extends SignatureObserver
{
  public jrq(EditActivity paramEditActivity) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      i = ((Integer)paramObject).intValue();
      QQToast.a(this.a, "get rank finish rank:" + i, 0).a();
      return;
    }
    int i = ((Integer)paramObject).intValue();
    QQToast.a(this.a, "get rank finish ret:" + i, 0).a();
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.isResume()) && (paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
    {
      paramObject = (Bundle)paramObject;
      int i = paramObject.getInt("unReadNum");
      long l = paramObject.getLong("lastUin");
      if ((i == 0) || (0L != l)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jrq
 * JD-Core Version:    0.7.0.1
 */