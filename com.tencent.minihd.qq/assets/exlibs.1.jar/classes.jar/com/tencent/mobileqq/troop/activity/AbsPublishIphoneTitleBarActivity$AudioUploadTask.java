package com.tencent.mobileqq.troop.activity;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class AbsPublishIphoneTitleBarActivity$AudioUploadTask
  extends Thread
{
  protected Handler a;
  protected AudioInfo a;
  protected String a;
  protected WeakReference a;
  protected boolean a;
  
  public AbsPublishIphoneTitleBarActivity$AudioUploadTask(AbsPublishIphoneTitleBarActivity paramAbsPublishIphoneTitleBarActivity, BaseActivity paramBaseActivity, Handler paramHandler, String paramString, AudioInfo paramAudioInfo)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (paramAudioInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = new AudioInfo(paramAudioInfo);
    }
  }
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label42;
      }
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "PreUploadTask activity is null!");
      }
    }
    label42:
    label342:
    do
    {
      do
      {
        for (;;)
        {
          return;
          localObject1 = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null) || (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("IphoneTitleBarActivity", 2, "Audio is null!");
            }
          }
          else
          {
            Object localObject2 = ((BaseActivity)localObject1).getAppRuntime();
            localObject1 = ((AppRuntime)localObject2).getAccount();
            localObject2 = ((TicketManager)((AppRuntime)localObject2).getManager(2)).getSkey((String)localObject1);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              HashMap localHashMap1 = new HashMap();
              localHashMap1.put("type", "1");
              localHashMap1.put("name", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
              localHashMap1.put("fileName", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
              HashMap localHashMap2 = new HashMap();
              localHashMap2.put("file", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
              HashMap localHashMap3 = new HashMap();
              localHashMap3.put("Connection", "keep-alive");
              localHashMap3.put("Referer", "https://www.qq.com");
              localObject1 = HttpUtil.a(this.jdField_a_of_type_JavaLangString, (String)localObject1, (String)localObject2, localHashMap1, localHashMap2, localHashMap3);
              if (localObject1 == null) {
                break label342;
              }
              try
              {
                localObject1 = new JSONObject((String)localObject1);
                if (((JSONObject)localObject1).optInt("retcode", -1) == 0)
                {
                  localObject1 = ((JSONObject)localObject1).optJSONObject("result");
                  if ((localObject1 != null) && (((JSONObject)localObject1).optInt("retcode") == 0))
                  {
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
                      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.url = ((JSONObject)localObject1).optString("url");
                    }
                    localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1003);
                    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
                    return;
                  }
                }
              }
              catch (JSONException localJSONException) {}
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("IphoneTitleBarActivity", 2, localJSONException.getMessage());
      return;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "scalePublishImage failed: path = " + this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishIphoneTitleBarActivity.AudioUploadTask
 * JD-Core Version:    0.7.0.1
 */