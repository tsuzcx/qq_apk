import Wallet.H5Info;
import Wallet.RspH5Config;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.ipc.PersonalInfoReq;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mae
  implements Runnable
{
  public mae(PersonalInfoReq paramPersonalInfoReq, RspH5Config paramRspH5Config) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      try
      {
        if (this.jdField_a_of_type_WalletRspH5Config == null) {
          return;
        }
        Object localObject1 = this.jdField_a_of_type_WalletRspH5Config.msg;
        if (QWalletHelper.a() != null)
        {
          localObject1 = QWalletHelper.a().a();
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("ret", this.jdField_a_of_type_WalletRspH5Config.ret);
          ((JSONObject)localObject2).put("msg", this.jdField_a_of_type_WalletRspH5Config.msg);
          ((JSONObject)localObject2).put("refreshPeriod", this.jdField_a_of_type_WalletRspH5Config.refreshPeriod);
          Object localObject3 = new JSONArray();
          if (this.jdField_a_of_type_WalletRspH5Config.vecH5Info != null)
          {
            int i = 0;
            if (i < this.jdField_a_of_type_WalletRspH5Config.vecH5Info.size())
            {
              JSONArray localJSONArray = new JSONArray();
              j = 0;
              if (j < ((ArrayList)this.jdField_a_of_type_WalletRspH5Config.vecH5Info.get(i)).size())
              {
                JSONObject localJSONObject = this.jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq.a((H5Info)((ArrayList)this.jdField_a_of_type_WalletRspH5Config.vecH5Info.get(i)).get(j));
                if (localJSONObject == null) {
                  break label341;
                }
                localJSONArray.put(localJSONObject);
                break label341;
              }
              ((JSONArray)localObject3).put(localJSONArray);
              i += 1;
              continue;
            }
          }
          if (((JSONArray)localObject3).length() > 0) {
            ((JSONObject)localObject2).put("vecH5Info", localObject3);
          }
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = this.jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq.a((String)localObject1);
          localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), (String)localObject1);
          try
          {
            if (((File)localObject1).exists()) {
              ((File)localObject1).delete();
            }
            localObject3 = ((File)localObject1).getParentFile();
            if ((localObject3 != null) && (!((File)localObject3).exists())) {
              ((File)localObject3).mkdirs();
            }
            localObject1 = new FileOutputStream((File)localObject1);
            ((FileOutputStream)localObject1).write(((String)localObject2).getBytes("utf-8"));
            ((FileOutputStream)localObject1).flush();
            ((FileOutputStream)localObject1).close();
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return;
          }
        }
        continue;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      label341:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mae
 * JD-Core Version:    0.7.0.1
 */