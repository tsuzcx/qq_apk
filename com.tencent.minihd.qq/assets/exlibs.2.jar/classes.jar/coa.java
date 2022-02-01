import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.apiproxy.QQMusicService;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class coa
  extends Handler
{
  public coa(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = TroopMemberApiService.a(this.a);
    if ((paramMessage == null) || (localObject2 == null) || (!(localObject2 instanceof QQAppInterface))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = paramMessage.getData();
    } while (localObject1 == null);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      this.a.b = paramMessage.replyTo;
      continue;
      this.a.b = null;
      continue;
      Object localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("seq", ((Bundle)localObject1).getInt("seq", -1));
      localObject1 = ((Bundle)localObject1).getString("video_url");
      boolean bool;
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (TroopInfoManager)((QQAppInterface)localObject2).getManager(36);
        if (localObject2 == null)
        {
          ((Bundle)localObject3).putBoolean("ret", false);
          this.a.a(4, (Bundle)localObject3);
        }
        else if (((TroopInfoManager)localObject2).a())
        {
          new cob(this, (TroopInfoManager)localObject2, (Bundle)localObject3, (String)localObject1).execute(new Void[0]);
        }
        else
        {
          if ((((TroopInfoManager)localObject2).b((String)localObject1)) && (((TroopInfoManager)localObject2).b())) {}
          for (bool = true;; bool = false)
          {
            ((Bundle)localObject3).putBoolean("ret", bool);
            this.a.a(4, (Bundle)localObject3);
            break;
          }
        }
      }
      else
      {
        ((Bundle)localObject3).putBoolean("ret", false);
        this.a.a(4, (Bundle)localObject3);
        continue;
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.f(((Bundle)localObject1).getString("video_url"));
          continue;
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(((AppRuntime)localObject2).getAccount());
          continue;
          localObject3 = ((Bundle)localObject1).getString("gcode");
          localObject1 = ((Bundle)localObject1).getString("anId");
          Object localObject4 = AnonymousChatHelper.a().a((String)localObject3, (String)localObject1);
          if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            this.a.a((String)localObject3, (String)localObject1, ((AppRuntime)localObject2).getAccount(), (String)localObject4);
            if (QLog.isDevelopLevel())
            {
              QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
              continue;
              this.a.a().a((AppRuntime)localObject2, (Bundle)localObject1);
              continue;
              if (this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null)
              {
                localObject2 = ((Bundle)localObject1).getString("methord_name");
                int i;
                int j;
                int k;
                int m;
                if ("getGroupInArea".equals(localObject2))
                {
                  localObject2 = ((Bundle)localObject1).getString("areaName");
                  i = ((Bundle)localObject1).getInt("lat");
                  j = ((Bundle)localObject1).getInt("lon");
                  k = ((Bundle)localObject1).getInt("startIndex");
                  m = ((Bundle)localObject1).getInt("count");
                  this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a((String)localObject2, i, j, k, m);
                }
                else if ("getNearbyTroops".equals(localObject2))
                {
                  bool = ((Bundle)localObject1).getBoolean("isFirst");
                  i = ((Bundle)localObject1).getInt("lat");
                  j = ((Bundle)localObject1).getInt("lon");
                  k = ((Bundle)localObject1).getInt("sortType");
                  localObject2 = ((Bundle)localObject1).getString("strGroupArea");
                  m = ((Bundle)localObject1).getInt("iFilterId");
                  this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(bool, i, j, k, (String)localObject2, m);
                }
                else if ("getAreaList".equals(localObject2))
                {
                  i = ((Bundle)localObject1).getInt("lat");
                  j = ((Bundle)localObject1).getInt("lon");
                  k = ((Bundle)localObject1).getInt("radius");
                  bool = ((Bundle)localObject1).getBoolean("isClickable");
                  this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(i, j, k, bool);
                  continue;
                  localObject3 = new Bundle();
                  ((Bundle)localObject3).putInt("seq", ((Bundle)localObject1).getInt("seq", -1));
                  localObject1 = ((Bundle)localObject1).getStringArray("paths");
                  if (((localObject2 instanceof QQAppInterface)) && (localObject1 != null) && (localObject1.length > 0))
                  {
                    localObject2 = (RedTouchManager)((AppRuntime)localObject2).getManager(35);
                    if (localObject2 != null)
                    {
                      localObject4 = new int[localObject1.length];
                      int[] arrayOfInt = new int[localObject1.length];
                      i = 0;
                      if (i < arrayOfInt.length)
                      {
                        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject2).a(localObject1[i]);
                        if (localAppInfo != null)
                        {
                          localObject4[i] = localAppInfo.iNewFlag.get();
                          arrayOfInt[i] = localAppInfo.type.get();
                        }
                        for (;;)
                        {
                          i += 1;
                          break;
                          localObject4[i] = 0;
                          arrayOfInt[i] = -1;
                        }
                      }
                      ((Bundle)localObject3).putIntArray("iNewFlags", (int[])localObject4);
                      ((Bundle)localObject3).putIntArray("types", arrayOfInt);
                    }
                  }
                  this.a.a(11, (Bundle)localObject3);
                  continue;
                  new Bundle().putInt("seq", ((Bundle)localObject1).getInt("seq", -1));
                  localObject1 = ((Bundle)localObject1).getString("path");
                  if ((localObject2 instanceof QQAppInterface))
                  {
                    localObject2 = (RedTouchManager)((AppRuntime)localObject2).getManager(35);
                    if (localObject2 != null)
                    {
                      ((RedTouchManager)localObject2).b((String)localObject1);
                      continue;
                      localObject2 = new Bundle();
                      ((Bundle)localObject2).putString("method", "changeAnonymousNick");
                      ((Bundle)localObject2).putInt("seq", ((Bundle)localObject1).getInt("seq", -1));
                      localObject3 = ((Bundle)localObject1).getString("troopUin");
                      long l = ((Bundle)localObject1).getLong("bubbleId");
                      i = ((Bundle)localObject1).getInt("headId");
                      localObject4 = ((Bundle)localObject1).getString("nickName");
                      j = ((Bundle)localObject1).getInt("expireTime");
                      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
                      {
                        AnonymousChatHelper.a().a((String)localObject3, l, i, (String)localObject4, j, "");
                        ((Bundle)localObject2).putBoolean("result", true);
                      }
                      for (;;)
                      {
                        this.a.a(13, (Bundle)localObject2);
                        break;
                        ((Bundle)localObject2).putBoolean("result", false);
                      }
                      localObject3 = ((Bundle)localObject1).getString("callback");
                      if (TextUtils.isEmpty((CharSequence)localObject3))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("trib", 2, "callback is null!");
                        }
                      }
                      else if (!(localObject2 instanceof QQAppInterface))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("trib", 2, "app is not QQAppInterface");
                        }
                      }
                      else
                      {
                        ThreadManager.a(new coc(this, (AppRuntime)localObject2, (String)localObject3, (Bundle)localObject1));
                        continue;
                        this.a.a((Bundle)localObject1);
                        continue;
                        if (!TroopMemberApiService.a((AppRuntime)localObject2, new cod(this, (Bundle)localObject1))) {
                          this.a.a(16, (Bundle)localObject1);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     coa
 * JD-Core Version:    0.7.0.1
 */