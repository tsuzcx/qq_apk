import android.os.Bundle;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;
import com.tencent.biz.addContactTroopView.AddContactTroopManage;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.BusinessObserver;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class cbx
  implements BusinessObserver
{
  public cbx(AddContactTroopHandler paramAddContactTroopHandler, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      try
      {
        Object localObject = paramBundle.getByteArray("data");
        if (localObject != null)
        {
          paramBundle = new popclassifc.RspBody();
          paramBundle.mergeFrom((byte[])localObject);
          localObject = (AddContactTroopManage)AddContactTroopHandler.a(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler).getManager(75);
          troopviewInfo.RspBody localRspBody = ((AddContactTroopManage)localObject).a();
          localRspBody.popRsb = new popclassifc.RspBody();
          localRspBody.popRsb.set(paramBundle);
          ((AddContactTroopManage)localObject).a(localRspBody);
          this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB.a();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cbx
 * JD-Core Version:    0.7.0.1
 */