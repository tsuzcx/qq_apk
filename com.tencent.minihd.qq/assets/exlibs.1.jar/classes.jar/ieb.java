import android.content.res.Resources;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingConfigItem;
import com.tencent.mobileqq.data.DatingSubjectItem;
import com.tencent.mobileqq.data.PublishDatingOption;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ieb
  implements Runnable
{
  public ieb(PublicDatingActivity paramPublicDatingActivity) {}
  
  public void run()
  {
    DatingManager localDatingManager = (DatingManager)this.a.app.getManager(67);
    if (localDatingManager == null)
    {
      this.a.finish();
      return;
    }
    if (((PublicDatingActivity.a(this.a).equals("web")) || (PublicDatingActivity.a(this.a).equals("guide"))) && (!localDatingManager.a()))
    {
      this.a.runOnUiThread(new iec(this));
      return;
    }
    PublicDatingActivity.a(this.a, localDatingManager.a());
    PublicDatingActivity.a(this.a, localDatingManager.a().id);
    PublicDatingActivity.a(this.a, localDatingManager.a().contentStr);
    PublicDatingActivity.a(this.a, localDatingManager.a());
    if (QLog.isColorLevel()) {
      QLog.d("Q.dating", 2, "init theme|minTimeRequest:" + PublicDatingActivity.a(this.a));
    }
    Iterator localIterator = PublicDatingActivity.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (DatingSubjectItem)localIterator.next();
      int i = ((DatingSubjectItem)localObject).id;
      PublishDatingOption localPublishDatingOption = new PublishDatingOption();
      localPublishDatingOption.themeId = i;
      localPublishDatingOption.themeName = ((DatingSubjectItem)localObject).name;
      localPublishDatingOption.maxTimeRequest = ((DatingSubjectItem)localObject).deadline;
      localPublishDatingOption.maxTimeReqErr = ((DatingSubjectItem)localObject).errMsg;
      int j = localDatingManager.b();
      if (i == 5)
      {
        localPublishDatingOption.time = PublicDatingActivity.a(this.a, i);
        localPublishDatingOption.partCountId = 0;
        localPublishDatingOption.genderId = 0;
        localPublishDatingOption.vehicleId = 7;
        localPublishDatingOption.introduce = this.a.getResources().getString(2131369940);
        localPublishDatingOption.introKey = PublicDatingActivity.a(this.a, i);
        localPublishDatingOption.introId = 0;
        if (localDatingManager != null)
        {
          localObject = localDatingManager.a();
          if (localObject != null)
          {
            localPublishDatingOption.depLocal = ((appoint_define.LocaleInfo)localObject);
            localPublishDatingOption.depLocalState = 1;
            PublicDatingActivity.b(this.a, false);
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.dating", 4, "init theme|" + localPublishDatingOption.toString());
        }
        PublicDatingActivity.a(this.a).put(Integer.valueOf(i), localPublishDatingOption);
      }
      else
      {
        localPublishDatingOption.time = PublicDatingActivity.a(this.a, i);
        if (j == 2) {
          localPublishDatingOption.genderId = 1;
        }
        for (localPublishDatingOption.payTypeId = 1;; localPublishDatingOption.payTypeId = 0)
        {
          localPublishDatingOption.introduce = this.a.getResources().getString(2131369940);
          localPublishDatingOption.introKey = PublicDatingActivity.a(this.a, i);
          localPublishDatingOption.introId = 0;
          break;
          localPublishDatingOption.genderId = 2;
        }
      }
    }
    this.a.runOnUiThread(new iee(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ieb
 * JD-Core Version:    0.7.0.1
 */