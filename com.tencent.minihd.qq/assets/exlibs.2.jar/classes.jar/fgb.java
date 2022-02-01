import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class fgb
  extends FriendListObserver
{
  public fgb(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void a()
  {
    this.a.e();
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if ((this.a.app.a() != null) && (this.a.app.a().equals(paramString)))
    {
      new Thread(new fgd(this, paramString)).start();
      return;
    }
    this.a.e();
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("head", 2, "ContactsActivity.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.a.sendEmptyMessage(1);
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    do
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      if (paramMap.hasNext())
      {
        String str = (String)((Map.Entry)paramMap.next()).getKey();
        int i = this.a.app.b(str);
        if ((i == 1) || (i == 4)) {
          TroopAssistantManager.a().c(str, this.a.app);
        }
        for (;;)
        {
          this.a.e();
          break;
          if (i == 3) {
            TroopAssistantManager.a().b(str, this.a.app);
          }
        }
      }
    } while (!this.a.isResume());
    if (paramBoolean)
    {
      QQToast.a(this.a.app.a(), 2130838252, this.a.getString(2131367043), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.app.a(), 2130838242, this.a.getString(2131367044), 0).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (paramBoolean) {
      new Thread(new fge(this)).start();
    }
  }
  
  void b(String paramString)
  {
    if (!paramString.equals(this.a.app.getAccount())) {
      return;
    }
    this.a.a.obtainMessage(1).sendToTarget();
    this.a.runOnUiThread(new fgc(this));
  }
  
  protected void c(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fgb
 * JD-Core Version:    0.7.0.1
 */