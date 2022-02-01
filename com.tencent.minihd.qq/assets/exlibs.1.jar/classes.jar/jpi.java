import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import java.util.ArrayList;
import java.util.List;

public class jpi
  implements Runnable
{
  public jpi(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    if (this.a.app == null) {
      return;
    }
    int j;
    if (QCallDetailActivity.a(this.a, QCallDetailActivity.a(this.a)))
    {
      ??? = MsgProxyUtils.n;
      j = ???.length;
      i = 0;
      if (i >= j) {
        break label350;
      }
      int k = ???[i];
      if (QCallDetailActivity.a(this.a) != k) {
        break label278;
      }
    }
    label91:
    label347:
    label350:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ??? = (PhoneContactManager)this.a.app.getManager(10);
        if (??? != null) {
          break label285;
        }
        ??? = null;
        if (??? != null) {
          QCallDetailActivity.a(this.a).a(((PhoneContact)???).mobileCode, 1006, QCallDetailActivity.a(this.a), QCallDetailActivity.a(this.a));
        }
      }
      if (QCallDetailActivity.a(this.a) == null) {
        break;
      }
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        synchronized (QCallDetailActivity.a(this.a))
        {
          List localList = QCallDetailActivity.a(this.a).a(QCallDetailActivity.a(this.a), QCallDetailActivity.a(this.a));
          if ((QCallDetailActivity.a(this.a) != null) && (localList != null) && (!localList.isEmpty()))
          {
            i = 20;
            j = 0;
            if ((j < i) && (j < localList.size()))
            {
              if (((QCallRecord)localList.get(j)).type != QCallRecord.TYPE_DATE) {
                break label347;
              }
              i += 1;
              localArrayList.add(localList.get(j));
              j += 1;
              continue;
              i += 1;
              break;
              ??? = ((PhoneContactManager)???).c(QCallDetailActivity.a(this.a));
              break label91;
            }
            bool = false;
            this.a.app.runOnUiThread(new jpj(this, localArrayList, bool));
            return;
          }
          boolean bool = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jpi
 * JD-Core Version:    0.7.0.1
 */