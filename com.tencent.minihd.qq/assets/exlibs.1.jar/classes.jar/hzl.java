import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DateEventMsg;
import com.tencent.mobileqq.dating.DateEventManager;
import com.tencent.mobileqq.dating.DateEventMsgActivity;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class hzl
  implements Runnable
{
  public hzl(DateEventMsgActivity paramDateEventMsgActivity) {}
  
  public void run()
  {
    int j = 0;
    DatingUtil.a("DateEventMsgActivity", new Object[] { "initData" });
    Object localObject1 = this.a.getIntent();
    int i;
    label44:
    Object localObject2;
    if (localObject1 == null)
    {
      i = 0;
      if (i != 2) {
        break label121;
      }
      this.a.b("0X8004F14");
      localObject2 = (DatingManager)this.a.app.getManager(67);
      if (localObject2 != null) {
        break label155;
      }
      localObject1 = null;
      label68:
      if (localObject1 != null) {
        break label164;
      }
      DatingUtil.b("date event entry", new Object[] { "dem is null", localObject2 });
      localObject1 = null;
    }
    for (;;)
    {
      this.a.runOnUiThread(new hzm(this, (List)localObject1));
      return;
      i = ((Intent)localObject1).getIntExtra("from", 0);
      break;
      label121:
      if (i == 1)
      {
        this.a.b("0X8004F15");
        break label44;
      }
      if (!QLog.isColorLevel()) {
        break label44;
      }
      QLog.i("Q.dating", 2, "DateEventMsgActivity clkActionReport invalidate");
      break label44;
      label155:
      localObject1 = ((DatingManager)localObject2).a();
      break label68;
      label164:
      localObject1 = ((DateEventManager)localObject1).a();
      if (localObject1 == null) {
        i = 0;
      }
      while (j < i)
      {
        localObject2 = (DateEventMsg)((List)localObject1).get(j);
        if (localObject2 != null) {
          ((DateEventMsg)localObject2).pareseTime();
        }
        j += 1;
        continue;
        i = ((List)localObject1).size();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzl
 * JD-Core Version:    0.7.0.1
 */