import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;

class gch
  extends AsyncTask
{
  gch(gcg paramgcg) {}
  
  protected TroopGagMgr.SelfGagInfo a(Void... paramVarArgs)
  {
    TroopChatPie.c(this.a.a);
    return ((TroopGagMgr)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
  }
  
  protected void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo)
  {
    TroopChatPie.a(this.a.a, paramSelfGagInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gch
 * JD-Core Version:    0.7.0.1
 */