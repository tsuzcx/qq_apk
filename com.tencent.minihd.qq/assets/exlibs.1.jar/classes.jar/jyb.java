import android.os.Handler;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class jyb
  extends SubAccountBindObserver
{
  public jyb(SubAccountProtocManager paramSubAccountProtocManager) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("SubAccountProtocManager.onGetBindSubAccount() isSucc=").append(paramBoolean).append(" data.mSubUin=");
      if (paramSubAccountBackProtocData != null) {
        break label174;
      }
    }
    label174:
    for (??? = "data is null";; ??? = paramSubAccountBackProtocData.c)
    {
      QLog.d("SUB_ACCOUNT", 2, (String)???);
      if ((!SubAccountProtocManager.a(this.a)) && (SubAccountProtocManager.a(this.a) != null)) {
        SubAccountProtocManager.a(this.a).postDelayed(SubAccountProtocManager.a(this.a), 100L);
      }
      if (paramSubAccountBackProtocData == null) {
        break label186;
      }
      if (paramSubAccountBackProtocData.a()) {
        SubAccountControll.a(SubAccountProtocManager.a(this.a), paramSubAccountBackProtocData.a(), 2);
      }
      if (!paramSubAccountBackProtocData.b()) {
        break;
      }
      ??? = paramSubAccountBackProtocData.b();
      if (??? == null) {
        break;
      }
      ??? = ((ArrayList)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (String)((Iterator)???).next();
        SubAccountControll.c(SubAccountProtocManager.a(this.a), (String)localObject2);
      }
    }
    paramSubAccountBackProtocData.a();
    synchronized (SubAccountProtocManager.c())
    {
      label186:
      SubAccountProtocManager.c(this.a, false);
      SubAccountProtocManager.d(this.a, true);
      if ((paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.b)) {
        SubAccountControll.a(SubAccountProtocManager.a(this.a), paramSubAccountBackProtocData.c, false);
      }
      return;
    }
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData arg2)
  {
    synchronized ()
    {
      SubAccountProtocManager.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData arg2)
  {
    synchronized ()
    {
      SubAccountProtocManager.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jyb
 * JD-Core Version:    0.7.0.1
 */