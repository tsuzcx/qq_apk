import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingCacheDel;
import com.tencent.mobileqq.dating.DatingCacheMng;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class iat
  implements Runnable
{
  public iat(DatingDetailActivity paramDatingDetailActivity) {}
  
  public void run()
  {
    if (this.a.app == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "init app is null");
      }
      return;
    }
    DatingManager localDatingManager = (DatingManager)this.a.app.getManager(67);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localDatingManager != null)
    {
      if (!localDatingManager.a().a(1, this.a.i).booleanValue()) {
        break label178;
      }
      this.a.w = 2;
      localObject1 = localObject2;
    }
    while (this.a.w == 2)
    {
      this.a.g = true;
      this.a.c = false;
      DatingUtil.a("DatingDetailActivity_init", new Object[] { Integer.valueOf(this.a.x), Integer.valueOf(this.a.w), this.a.i });
      this.a.runOnUiThread(new iau(this, localObject1));
      return;
      label178:
      if (localDatingManager.a().a(2, this.a.i).booleanValue())
      {
        this.a.w = 2;
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = localDatingManager.a().a(this.a.i, true, false, true);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((DatingInfo)localObject2).nLimit == 2)
          {
            this.a.w = 2;
            localObject1 = localObject2;
          }
        }
      }
    }
    if ((this.a.x == 1001) || (this.a.x == 1002) || (this.a.x == 1009)) {
      localObject1 = null;
    }
    for (;;)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (localDatingManager != null)
        {
          long l2 = NetConnInfoCenter.getServerTimeMillis();
          long l1 = l2;
          if (l2 == 0L) {
            l1 = System.currentTimeMillis();
          }
          l1 = Math.abs(localObject1.lastUpdateTime - l1);
          if ((l1 >= 0L) && (l1 <= 180000L)) {
            break label620;
          }
          bool1 = true;
          label382:
          if (bool1) {
            break label625;
          }
          bool2 = true;
          label388:
          localObject1.isInit = bool2;
          localObject1.lastFrom = this.a.x;
        }
      }
      this.a.app.a(this.a.a, true);
      localObject2 = this.a;
      if (!bool1)
      {
        bool2 = true;
        label436:
        ((DatingDetailActivity)localObject2).g = bool2;
        if ((!bool1) || (!NetworkUtil.e(this.a.getApplicationContext()))) {
          break label715;
        }
      }
      label538:
      label556:
      label703:
      label709:
      label715:
      for (bool2 = this.a.a();; bool2 = false)
      {
        int i;
        if ((this.a.x == 1006) && ((!this.a.g) || (localObject1 == null) || (!localObject1.isInCache(2, Integer.valueOf(this.a.y)))))
        {
          this.a.a(2, Integer.valueOf(this.a.y), 10, 10, false);
          if (localObject1 != null)
          {
            if (this.a.z != 0) {
              break label703;
            }
            bool3 = true;
            localObject1.isGetList = bool3;
          }
          i = this.a.x;
          if (localObject1 != null) {
            break label709;
          }
        }
        for (boolean bool3 = true;; bool3 = false)
        {
          DatingUtil.a("DatingDetailActivity_init", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          break;
          label620:
          bool1 = false;
          break label382;
          label625:
          bool2 = false;
          break label388;
          bool2 = false;
          break label436;
          if ((this.a.x != 1007) || ((this.a.g) && (localObject1 != null) && (localObject1.isInCache(1, this.a.j)))) {
            break label538;
          }
          this.a.a(1, this.a.j, 10, 10, false);
          break label538;
          bool3 = false;
          break label556;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iat
 * JD-Core Version:    0.7.0.1
 */