import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.observer.AccountObserver;

public final class mbc
  extends AccountObserver
{
  public mbc(String paramString, BusinessObserver paramBusinessObserver) {}
  
  public void onChangeToken(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap = (RespondCustomSig)paramHashMap.get("login.chgTok");
      if ((paramHashMap != null) && (paramHashMap.SigList != null)) {
        break label30;
      }
    }
    for (;;)
    {
      return;
      label30:
      int i = 0;
      while (i < paramHashMap.SigList.size())
      {
        Object localObject = (CustomSigContent)paramHashMap.SigList.get(i);
        if ((((CustomSigContent)localObject).sResult == 0) && (((CustomSigContent)localObject).ulSigType == 16L))
        {
          localObject = new String(((CustomSigContent)localObject).SigContent);
          OpenID localOpenID = new OpenID();
          localOpenID.appID = this.jdField_a_of_type_JavaLangString;
          localOpenID.openID = ((String)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(1, true, localOpenID);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbc
 * JD-Core Version:    0.7.0.1
 */