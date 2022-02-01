import com.tencent.mobileqq.richstatus.ActionInfo;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class jsd
  implements IActionListener
{
  public jsd(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 102) && (EditActivity.a(this.a).b != 0) && (" ".equals(EditActivity.a(this.a).c)))
    {
      ActionInfo localActionInfo = EditActivity.a(this.a).a(EditActivity.a(this.a).b);
      if (localActionInfo != null)
      {
        EditActivity.a(this.a).c = localActionInfo.d;
        EditActivity.a(this.a, false, this.a.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsd
 * JD-Core Version:    0.7.0.1
 */