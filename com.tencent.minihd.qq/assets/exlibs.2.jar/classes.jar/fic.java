import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class fic
  extends TroopObserver
{
  public fic(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  protected void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onSetTroopAdminFail: errorCode=" + paramInt);
    }
    this.a.j();
    Object localObject;
    switch (paramInt)
    {
    case 5: 
    case 6: 
    default: 
      localObject = this.a.getString(2131365842);
      this.a.a(1, (String)localObject);
      return;
    case 4: 
      localObject = (FriendsManagerImp)this.a.app.getManager(8);
      if (localObject != null)
      {
        localObject = ((FriendsManagerImp)localObject).a(this.a.c);
        if (localObject == null) {
          break;
        }
      }
      break;
    }
    for (paramInt = ((TroopInfo)localObject).maxAdminNum;; paramInt = 0)
    {
      if (paramInt > 0)
      {
        localObject = String.format(this.a.getString(2131365846), new Object[] { Integer.valueOf(paramInt) });
        break;
      }
      localObject = this.a.getString(2131365847);
      break;
      localObject = this.a.getString(2131365848);
      break;
    }
  }
  
  protected void a(String paramString1, String paramString2, byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onSetTroopAdminSuccess: mTroopUin=" + paramString1 + " memberUin=" + paramString2 + " operation=" + paramByte);
    }
    TroopInfo localTroopInfo;
    if ((this.a.c.equals(paramString1)) && (this.a.e.equals(paramString2)))
    {
      paramString1 = (FriendsManagerImp)this.a.app.getManager(8);
      localTroopInfo = paramString1.a(this.a.c);
      if (localTroopInfo != null)
      {
        if (localTroopInfo.Administrator == null) {
          break label305;
        }
        if (localTroopInfo.Administrator.startsWith("|")) {
          localTroopInfo.Administrator = localTroopInfo.Administrator.substring(1);
        }
        if (localTroopInfo.Administrator.endsWith("|")) {
          localTroopInfo.Administrator = localTroopInfo.Administrator.substring(0, localTroopInfo.Administrator.length() - 1);
        }
        if (paramByte != 0) {
          break label315;
        }
        localTroopInfo.Administrator = localTroopInfo.Administrator.replace(paramString2 + "|", "").replace("|" + paramString2, "").replace(paramString2, "");
        label251:
        paramString1.b(localTroopInfo);
      }
      if (paramByte != 0) {
        break label355;
      }
      this.a.a(2, this.a.getString(2131365844));
      this.a.a.memberRole = 1;
    }
    for (;;)
    {
      this.a.a(2);
      this.a.j();
      return;
      label305:
      localTroopInfo.Administrator = "";
      break;
      label315:
      if (paramByte != 1) {
        break label251;
      }
      localTroopInfo.Administrator = (localTroopInfo.Administrator + "|" + paramString2);
      break label251;
      label355:
      if (paramByte == 1)
      {
        this.a.a(2, this.a.getString(2131365841));
        this.a.a.memberRole = 2;
        ReportController.b(this.a.app, "P_CliOper", "Grp_manage", "", "mber_card", "suc_setadmin", 0, 0, this.a.c, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fic
 * JD-Core Version:    0.7.0.1
 */