package cooperation.qwallet.plugin.ipc;

import Wallet.H5Info;
import Wallet.RspH5Config;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletHomeObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.MD5;
import cooperation.qwallet.plugin.QWalletHelper;
import mae;
import maf;
import mag;
import mah;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonalInfoReq
  extends BaseReq
{
  public static final int a = 1;
  public static final int b = 2;
  public QWalletHomeObserver a = new mah(this);
  public int c;
  
  public H5Info a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    H5Info localH5Info = new H5Info();
    localH5Info.id = paramJSONObject.optInt("id");
    localH5Info.beginDate = paramJSONObject.optLong("beginDate");
    localH5Info.endDate = paramJSONObject.optLong("endDate");
    localH5Info.title = paramJSONObject.optString("title");
    localH5Info.url = paramJSONObject.optString("url");
    localH5Info.PV = paramJSONObject.optString("PV");
    localH5Info.description = paramJSONObject.optString("description");
    return localH5Info;
  }
  
  public String a(String paramString)
  {
    return MD5.toMD5("qwallet_home_personalInfo_" + paramString);
  }
  
  public JSONObject a(H5Info paramH5Info)
  {
    if (paramH5Info == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramH5Info.id);
      localJSONObject.put("beginDate", paramH5Info.beginDate);
      localJSONObject.put("endDate", paramH5Info.endDate);
      localJSONObject.put("title", paramH5Info.title);
      localJSONObject.put("url", paramH5Info.url);
      localJSONObject.put("PV", paramH5Info.PV);
      localJSONObject.put("description", paramH5Info.description);
      return localJSONObject;
    }
    catch (JSONException paramH5Info)
    {
      paramH5Info.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = QWalletHelper.a();
    if (localQQAppInterface == null)
    {
      b(null);
      return;
    }
    switch (this.c)
    {
    default: 
      b(null);
      return;
    case 1: 
      a(localQQAppInterface);
      return;
    }
    b(localQQAppInterface);
  }
  
  public void a(RspH5Config paramRspH5Config)
  {
    ThreadManager.a().post(new mae(this, paramRspH5Config));
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putInt("_qwallet_ipc_PersonalInfoReq_personalInfoReqType", this.c);
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.a().post(new maf(this, paramQQAppInterface));
  }
  
  public void b(RspH5Config paramRspH5Config)
  {
    Object localObject = QWalletHelper.a();
    if (localObject != null) {
      ((QQAppInterface)localObject).c(this.a);
    }
    localObject = new PersonalInfoResp();
    ((PersonalInfoResp)localObject).jdField_a_of_type_WalletRspH5Config = paramRspH5Config;
    ((PersonalInfoResp)localObject).jdField_a_of_type_Int = this.c;
    paramRspH5Config = new Bundle();
    ((PersonalInfoResp)localObject).a(paramRspH5Config);
    super.a(paramRspH5Config);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.c = paramBundle.getInt("_qwallet_ipc_PersonalInfoReq_personalInfoReqType");
  }
  
  protected void b(QQAppInterface paramQQAppInterface)
  {
    SosoInterface.a(new mag(this, 1, true, 0L, false, false, "PersonalInfoReq", paramQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.PersonalInfoReq
 * JD-Core Version:    0.7.0.1
 */