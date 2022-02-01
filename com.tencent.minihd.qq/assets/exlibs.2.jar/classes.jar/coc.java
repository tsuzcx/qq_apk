import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class coc
  implements Runnable
{
  coc(coa paramcoa, AppRuntime paramAppRuntime, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    int i = 0;
    Object localObject1 = new JSONArray();
    EntityManager localEntityManager = ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a().createEntityManager();
    Object localObject3 = localEntityManager.a(TroopBarUploadItemEntity.class);
    int k;
    JSONObject localJSONObject1;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      k = 0;
      int j = 0;
      while (((Iterator)localObject3).hasNext())
      {
        TroopBarUploadItemEntity localTroopBarUploadItemEntity = (TroopBarUploadItemEntity)((Iterator)localObject3).next();
        if (localTroopBarUploadItemEntity.mState == 4)
        {
          j = 1;
        }
        else if ((localTroopBarUploadItemEntity.mState == 3) || (localTroopBarUploadItemEntity.mState == 6))
        {
          k = 1;
        }
        else
        {
          JSONObject localJSONObject2;
          if ((localTroopBarUploadItemEntity.mState == 2) || (localTroopBarUploadItemEntity.mState == 1) || (localTroopBarUploadItemEntity.mState == 0)) {
            localJSONObject2 = new JSONObject();
          }
          for (;;)
          {
            try
            {
              localJSONObject2.put("bid", localTroopBarUploadItemEntity.mBid);
              localJSONObject2.put("pid", localTroopBarUploadItemEntity.mPid);
              if (!TextUtils.isEmpty(localTroopBarUploadItemEntity.mCid)) {
                localJSONObject2.put("cid", localTroopBarUploadItemEntity.mCid);
              }
              localJSONObject2.put("title", localTroopBarUploadItemEntity.mTitle);
              if (!TextUtils.isEmpty(localTroopBarUploadItemEntity.mVideoPath))
              {
                String str = TroopMemberApiService.a(this.jdField_a_of_type_Coa.a, localTroopBarUploadItemEntity.mVideoPath);
                if (!TextUtils.isEmpty(str)) {
                  localJSONObject2.put("video_pic", "data:img/jpg;base64," + str);
                }
              }
              localJSONObject2.put("time", localTroopBarUploadItemEntity.mTime);
              localJSONObject2.put("content", localTroopBarUploadItemEntity.mContent);
              ((JSONArray)localObject1).put(localJSONObject2);
              i = 1;
            }
            catch (JSONException localJSONException3)
            {
              localJSONException3.printStackTrace();
            }
          }
        }
      }
      localJSONObject1 = new JSONObject();
      if (j == 0) {}
    }
    for (;;)
    {
      try
      {
        localJSONObject1.put("status", 2);
        if (((JSONArray)localObject1).length() > 0) {
          localJSONObject1.put("info", localObject1);
        }
        localObject3 = localJSONObject1.toString();
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("tribe", 2, "entity status:" + localJSONObject1.optInt("status"));
          localObject1 = localObject3;
        }
        localEntityManager.a();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("data", (String)localObject1);
        ((Bundle)localObject3).putString("method", "getUploadInfo");
        ((Bundle)localObject3).putString("callback", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq", -1));
        this.jdField_a_of_type_Coa.a.a(14, (Bundle)localObject3);
        return;
        if (k != 0)
        {
          localJSONObject1.put("status", 3);
          continue;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
        if (i != 0)
        {
          localJSONObject1.put("status", 1);
          continue;
        }
        localJSONObject1.put("status", 0);
        continue;
      }
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("status", 0);
        localObject3 = ((JSONObject)localObject2).toString();
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("tribe", 2, "entityList is null");
        localObject2 = localObject3;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     coc
 * JD-Core Version:    0.7.0.1
 */