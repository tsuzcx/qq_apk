package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class GetEmosmList
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "getEmosmList start int QQInitHandler...");
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)this.a.a.getManager(13);
    Object localObject1 = this.a.a.getApplication().getSharedPreferences("mobileQQ", 0);
    if (!Boolean.valueOf(((SharedPreferences)localObject1).getBoolean("emosm_has_set_emosmpackage_valid_" + this.a.a.a(), false)).booleanValue())
    {
      Object localObject2 = localEmoticonManager.b();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject2).next();
          localEmoticonPackage.valid = true;
          localEmoticonManager.a(localEmoticonPackage);
        }
      }
      ((SharedPreferences)localObject1).edit().putBoolean("emosm_has_set_emosmpackage_valid_" + this.a.a.a(), true).commit();
    }
    localObject1 = Boolean.valueOf(((SharedPreferences)localObject1).getBoolean("emosm_has_download_emosmpackage_tag_" + this.a.a.a(), false));
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "oidbFlag oidbFlag int oidbFlag..." + localObject1);
    }
    if (((Boolean)localObject1).booleanValue()) {
      localEmoticonManager.b();
    }
    for (;;)
    {
      localEmoticonManager.g();
      return 7;
      ((EmosmHandler)this.a.a.a(11)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmosmList
 * JD-Core Version:    0.7.0.1
 */