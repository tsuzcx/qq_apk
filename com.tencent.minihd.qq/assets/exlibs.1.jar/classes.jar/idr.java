import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class idr
  extends HotChatObserver
{
  public idr(NearbyTransitActivity paramNearbyTransitActivity) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1)
  {
    DatingUtil.a("NearbyTransitActivity", new Object[] { "onJoinHotChat", Boolean.valueOf(NearbyTransitActivity.a(this.a)), Boolean.valueOf(paramBoolean), paramString1 });
    if (NearbyTransitActivity.a(this.a)) {
      return;
    }
    NearbyTransitActivity.a(this.a).removeMessages(2);
    NearbyTransitActivity.a(this.a).removeMessages(5);
    if (this.a.a != null) {
      this.a.a.a();
    }
    paramBoolean1 = Message.obtain();
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1))) {
      paramBoolean1.what = 3;
    }
    for (paramBoolean1.obj = new Object[] { paramString1, paramString2, paramString4 };; paramBoolean1.obj = paramString1)
    {
      NearbyTransitActivity.a(this.a).sendMessage(paramBoolean1);
      return;
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = "加入热聊失败，请稍后再试。";
      }
      paramBoolean1.what = 1;
    }
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    if (!Utils.a(paramString, NearbyTransitActivity.a(this.a))) {}
    do
    {
      return;
      DatingUtil.a("NearbyTransitActivity", new Object[] { "onQuickJoinHotChat", Boolean.valueOf(NearbyTransitActivity.a(this.a)), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString, paramHotChatInfo, paramWifiPOIInfo });
    } while (NearbyTransitActivity.a(this.a));
    NearbyTransitActivity.a(this.a).removeMessages(2);
    if (this.a.a != null) {
      this.a.a.a();
    }
    paramString = Message.obtain();
    if (paramBoolean) {
      if ((paramHotChatInfo != null) && ((paramInt == 1) || (paramInt == 2)))
      {
        paramString.what = 3;
        paramString.obj = new Object[] { paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name };
      }
    }
    for (;;)
    {
      NearbyTransitActivity.a(this.a).sendMessage(paramString);
      return;
      if ((paramWifiPOIInfo != null) && (paramInt == 3))
      {
        paramString.what = 4;
        paramString.obj = paramWifiPOIInfo;
      }
      else
      {
        paramString.what = 1;
        paramString.obj = "加入热聊失败，请稍后再试。";
        continue;
        paramString.what = 1;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          paramString.obj = "加入热聊失败，请稍后再试。";
          break;
        case 2: 
          paramString.obj = "该热聊不存在，换个热聊试试吧。";
          break;
        case 5: 
          paramString.obj = "该热聊已经满员，换个热聊试试吧。";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idr
 * JD-Core Version:    0.7.0.1
 */