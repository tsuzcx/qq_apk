import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class dei
  extends TroopObserver
{
  public dei(AddFriendActivity paramAddFriendActivity) {}
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2, List paramList)
  {
    this.a.removeObserver(this.a.a);
    if ((paramInt1 == 0) && (paramList != null) && (paramList.size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.obj = paramList;
      localMessage.arg1 = paramInt2;
      if (paramBoolean) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        localMessage.arg2 = paramInt1;
        AddFriendActivity.a(this.a).sendMessageDelayed(localMessage, 300L);
        return;
      }
    }
    AddFriendActivity.b(this.a);
    if (paramInt1 == 0)
    {
      this.a.a(2131368000);
      return;
    }
    if (paramInt1 == 68)
    {
      this.a.a(2131368000);
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.a.a(2131366980);
      return;
    }
    this.a.a(2131366984);
  }
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    this.a.removeObserver(this.a.a);
    if ((paramBoolean1) && (paramByte == 0) && (paramTroopInfo != null) && (Utils.a(paramTroopInfo.troopuin, this.a.c)))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3;
      if (paramBoolean2) {}
      for (paramByte = 1;; paramByte = 0)
      {
        localMessage.arg1 = paramByte;
        localMessage.obj = paramTroopInfo;
        AddFriendActivity.a(this.a).sendMessageDelayed(localMessage, 300L);
        return;
      }
    }
    AddFriendActivity.b(this.a);
    if (!paramBoolean1)
    {
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        this.a.a(2131366980);
        return;
      }
      this.a.a(2131366984);
      return;
    }
    if (paramByte == 2)
    {
      this.a.a(2131367472);
      return;
    }
    if (paramByte == 3)
    {
      this.a.a(2131367473);
      return;
    }
    if (paramByte == 4)
    {
      this.a.a(2131367474);
      return;
    }
    this.a.a(2131367471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dei
 * JD-Core Version:    0.7.0.1
 */