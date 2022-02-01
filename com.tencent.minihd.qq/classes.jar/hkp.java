import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class hkp
  extends HotChatObserver
{
  private hkp(HotChatManager paramHotChatManager) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, Common.WifiPOIInfo paramWifiPOIInfo, List paramList)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "<<---onGetHotChatList isSuc = " + paramBoolean1 + ", switchShell = " + paramBoolean);
    }
    if (!paramBoolean2) {}
    do
    {
      do
      {
        return;
        if (paramBoolean == null) {}
        for (paramBoolean2 = HotChatManager.a(HotChatManager.a(this.a), true);; paramBoolean2 = paramBoolean.booleanValue())
        {
          HotChatManager.c(HotChatManager.a(this.a), paramBoolean2);
          if (QLog.isColorLevel()) {
            QLog.d("HotChatManager", 2, "onGetHotChatList tabShellSwitch = " + paramBoolean2);
          }
          if (HotChatManager.a(this.a) != null)
          {
            HotChatManager.a(this.a).c(HotChatManager.a(this.a));
            HotChatManager.a(this.a, null);
          }
          if (paramWifiPOIInfo != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("HotChatManager", 2, "onGetHotChatList wifiHotChatInfo null ");
          }
          this.a.a(true);
          HotChatRecentUserMgr.a(HotChatManager.a(this.a));
          return;
        }
      } while (!paramBoolean1);
      paramList = this.a.b();
      paramBoolean = HotChatInfo.createHotChat(paramWifiPOIInfo, true);
      paramBoolean.state = 5;
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "currentUnJoinedWifiHotChat = " + paramBoolean);
      }
      if (paramList == null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HotChatManager", 2, "<<---onGetHotChatList curWifiHotChat.name = " + paramList.name + ", curWifiHotChat.uuid = " + paramList.uuid + ", hc.uuid = " + paramBoolean.uuid);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "<<---onGetHotChatList curWifiHotChat = null ");
    }
    if (this.a.e(paramBoolean.name))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetHotChatList - pre deleted");
      }
      this.a.a(true);
      HotChatRecentUserMgr.a(HotChatManager.a(this.a));
      return;
    }
    paramList = HotChatManager.a(this.a).a().a();
    HotChatRecentUserMgr.a(HotChatManager.a(this.a));
    EntityManager localEntityManager;
    boolean bool1;
    if (((HotChatManager.a(this.a)) && ((paramBoolean.troopUin == null) || (paramBoolean.troopUin.length() <= 1))) || ((HotChatManager.b(this.a)) && (paramBoolean.troopUin != null) && (paramBoolean.troopUin.length() > 1)))
    {
      localEntityManager = HotChatManager.a(this.a).a().createEntityManager();
      if ((HotChatManager.a(this.a) == null) || (!paramBoolean.uuid.equals(HotChatManager.a(this.a).uuid))) {
        break label806;
      }
      HotChatManager.a(this.a).state = 5;
      HotChatManager.a(this.a).name = paramBoolean.name;
      HotChatManager.a(this.a).memberCount = paramBoolean.memberCount;
      HotChatManager.a(this.a).troopCode = paramBoolean.troopCode;
      HotChatManager.a(this.a).troopUin = paramBoolean.troopUin;
      HotChatManager.a(this.a).signature = paramBoolean.signature;
      HotChatManager.a(this.a).uuid = paramBoolean.uuid;
      localEntityManager.a(HotChatManager.a(this.a));
      localEntityManager.a();
      if (!paramWifiPOIInfo.uint32_msg_tab_switch_off.has()) {
        break label886;
      }
      if (paramWifiPOIInfo.uint32_msg_tab_switch_off.get() != 1) {
        break label853;
      }
      bool1 = true;
      label637:
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetHotChatList tabShellSwitchSingleOff = " + bool1);
      }
      paramBoolean1 = bool2;
      if (bool1)
      {
        paramBoolean1 = bool2;
        if (!paramBoolean2) {}
      }
    }
    label741:
    label873:
    label886:
    for (paramBoolean1 = true;; paramBoolean1 = paramBoolean2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetHotChatList notShowWiFiShellMsgTab = " + paramBoolean1);
      }
      if (HotChatManager.c(HotChatManager.a(this.a)))
      {
        paramBoolean1 = HotChatManager.b(HotChatManager.a(this.a));
        if (QLog.isColorLevel()) {
          QLog.d("HotChatManager", 2, "onGetHotChatList notShowWiFiShellMsgTab = " + paramBoolean1);
        }
        this.a.a(true);
        if (paramBoolean1) {
          break label873;
        }
        paramList.a(HotChatInfo.createRecentUser(paramBoolean, true));
      }
      for (;;)
      {
        HotChatRecentUserMgr.b(HotChatManager.a(this.a));
        return;
        if (HotChatManager.a(this.a) != null) {
          localEntityManager.b(HotChatManager.a(this.a));
        }
        HotChatManager.a(this.a, paramBoolean);
        localEntityManager.b(HotChatManager.a(this.a));
        break;
        bool1 = false;
        break label637;
        HotChatManager.b(HotChatManager.a(this.a), paramBoolean1);
        break label741;
        HotChatRecentUserMgr.a(HotChatManager.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hkp
 * JD-Core Version:    0.7.0.1
 */