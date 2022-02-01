import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;

public class drd
  implements TroopCardAppInfoHelper.IGetAppInfoCB
{
  public drd(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a() {}
  
  public void a(ArrayList paramArrayList)
  {
    if ((this.a.isFinishing()) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.a.app.getManager(36);
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        TroopAppInfo localTroopAppInfo = (TroopAppInfo)localIterator.next();
        localTroopInfoManager.a(Long.valueOf(localTroopAppInfo.appId), localTroopAppInfo);
        localArrayList.add(Long.valueOf(localTroopAppInfo.appId));
      }
      localTroopInfoManager.a(this.a.a.c, localArrayList);
    } while (ChatSettingForTroop.a(this.a));
    ChatSettingForTroop.a(this.a);
    ChatSettingForTroop.a(this.a, paramArrayList);
    ChatSettingForTroop.a(this.a, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drd
 * JD-Core Version:    0.7.0.1
 */