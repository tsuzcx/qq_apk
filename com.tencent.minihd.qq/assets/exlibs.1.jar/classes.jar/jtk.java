import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.richstatus.ISameStatusListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.StatusObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class jtk
  extends StatusObserver
{
  public jtk(StatusManager paramStatusManager) {}
  
  @TargetApi(9)
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject3 = (FriendsManager)StatusManager.a(this.a).getManager(49);
    Object localObject2;
    Object localObject1;
    int i;
    if (localObject3 != null)
    {
      localObject2 = ((FriendsManager)localObject3).a(StatusManager.a(this.a).a());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = StatusManager.a(this.a).a();
      }
      if (paramBoolean)
      {
        localObject2 = paramBundle.getByteArray("k_rspbody");
        if (localObject2 != null)
        {
          localObject2 = ByteBuffer.wrap((byte[])localObject2);
          ((ByteBuffer)localObject2).get();
          i = ((ByteBuffer)localObject2).getInt();
          byte[] arrayOfByte = new byte[((ByteBuffer)localObject2).getShort()];
          ((ByteBuffer)localObject2).get(arrayOfByte);
          if (((ExtensionInfo)localObject1).timestamp != i)
          {
            ((ExtensionInfo)localObject1).setRichBuffer(arrayOfByte, i);
            ((FriendsManager)localObject3).a((ExtensionInfo)localObject1);
          }
        }
      }
      localObject1 = ((ExtensionInfo)localObject1).getRichStatus();
      if (paramBoolean)
      {
        localObject3 = StatusManager.a(this.a);
        if (((RichStatus)localObject1).d == 0)
        {
          localObject2 = "1";
          ReportController.b((QQAppInterface)localObject3, "CliOper", "", "", "signiture", "set_clk_save_succ", 0, 0, (String)localObject2, "", "", "");
          if (StatusManager.a(this.a) == null) {
            break label370;
          }
          localObject2 = StatusManager.a(this.a).a().getSharedPreferences(StatusManager.a(this.a).a(), 0).edit();
          ((SharedPreferences.Editor)localObject2).putInt("sig_tlp_id", ((RichStatus)localObject1).d);
          if (Build.VERSION.SDK_INT > 8) {
            break label363;
          }
          ((SharedPreferences.Editor)localObject2).commit();
        }
      }
    }
    for (;;)
    {
      label281:
      if ((!paramBoolean) && (paramBundle != null)) {}
      for (i = paramBundle.getInt("k_auth_code", -1);; i = 100)
      {
        StatusManager.a(this.a, null);
        if (StatusManager.b(this.a) != null)
        {
          paramBundle = StatusManager.b(this.a).iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              ((IStatusListener)paramBundle.next()).a(i, (RichStatus)localObject1);
              continue;
              localObject2 = "0";
              break;
              label363:
              ((SharedPreferences.Editor)localObject2).apply();
              label370:
              break label281;
            }
          }
        }
        return;
      }
      localObject1 = null;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onGetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label83:
    IStatusListener localIStatusListener;
    if (paramBoolean1)
    {
      StatusManager.c(this.a, 0L);
      StatusManager.a(this.a, paramBoolean2);
      if (StatusManager.b(this.a) == null) {
        return;
      }
      Iterator localIterator = StatusManager.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localIStatusListener = (IStatusListener)localIterator.next();
      if (!paramBoolean1) {
        break label162;
      }
    }
    label162:
    for (int i = 100;; i = -1)
    {
      localIStatusListener.a(i, paramBoolean2);
      break label83;
      StatusManager.c(this.a, System.currentTimeMillis() - 180000L + 60000L);
      paramBoolean2 = StatusManager.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetStatusMate ").append(paramBoolean1).append(" ").append(paramBoolean2).append(" ").append(paramInt).append(" ");
      if (paramArrayList != null)
      {
        i = paramArrayList.size();
        QLog.d("Q.richstatus.mate", 2, i);
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label124;
      }
      StatusManager.a(this.a, paramArrayOfByte);
    }
    for (;;)
    {
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          if (StatusManager.a(this.a) != null)
          {
            StatusManager.a(this.a, paramArrayList);
            return;
            i = -1;
            break;
            label124:
            if (!paramBoolean2) {
              continue;
            }
            StatusManager.a(this.a, null);
            continue;
          }
          if (StatusManager.b(this.a) == null) {
            StatusManager.b(this.a, new ArrayList());
          }
          paramArrayOfByte = this.a.a(StatusManager.b(this.a), paramArrayList, paramInt);
        }
      }
    }
    for (;;)
    {
      label184:
      if ((StatusManager.a(this.a) != null) && (StatusManager.a(this.a).length > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if (StatusManager.c(this.a) == null) {
          break label283;
        }
        paramArrayList = StatusManager.c(this.a).iterator();
        while (paramArrayList.hasNext()) {
          ((ISameStatusListener)paramArrayList.next()).a(paramBoolean1, paramBoolean2, paramInt, paramArrayOfByte, bool);
        }
        break;
        paramArrayOfByte = this.a.a(paramArrayList);
        break label184;
      }
      label283:
      break;
      paramArrayOfByte = paramArrayList;
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    StatusManager.a(this.a, null);
    if (StatusManager.b(this.a) != null)
    {
      paramBundle = StatusManager.b(this.a).iterator();
      if (paramBundle.hasNext())
      {
        IStatusListener localIStatusListener = (IStatusListener)paramBundle.next();
        if (paramBoolean) {}
        for (int i = 100;; i = -1)
        {
          localIStatusListener.a(i, RichStatus.a());
          break;
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onSetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label75:
    IStatusListener localIStatusListener;
    if (paramBoolean1)
    {
      StatusManager.a(this.a, paramBoolean2);
      if (StatusManager.b(this.a) == null) {
        return;
      }
      Iterator localIterator = StatusManager.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localIStatusListener = (IStatusListener)localIterator.next();
      if (!paramBoolean1) {
        break label135;
      }
    }
    label135:
    for (int i = 100;; i = -1)
    {
      localIStatusListener.b(i, paramBoolean2);
      break label75;
      paramBoolean2 = StatusManager.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jtk
 * JD-Core Version:    0.7.0.1
 */