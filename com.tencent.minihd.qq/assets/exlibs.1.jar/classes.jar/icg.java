import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;
import com.tencent.mobileqq.dating.DatingUserCenterAdapter;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class icg
  extends DatingObserver
{
  public icg(DatingUserCenterActivity paramDatingUserCenterActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, DatingInfo paramDatingInfo, byte[] paramArrayOfByte, String paramString2)
  {
    if (paramInt == 1)
    {
      if (!paramBoolean) {
        break label282;
      }
      if (DatingUserCenterActivity.a(this.a) != 1) {
        break label187;
      }
      if (!this.a.isResume()) {
        break label67;
      }
      this.a.a(1, 2131369725, 500);
      DatingUserCenterActivity.a(this.a).postDelayed(new ich(this, paramString1), 1000L);
    }
    label67:
    while (DatingUserCenterActivity.a(this.a) != 1) {
      for (;;)
      {
        return;
        this.a.e();
        if ((DatingUserCenterActivity.b(this.a) != null) && (!DatingUserCenterActivity.b(this.a).isEmpty()) && (!TextUtils.isEmpty(paramString1)))
        {
          paramDatingInfo = DatingUserCenterActivity.b(this.a).iterator();
          while (paramDatingInfo.hasNext())
          {
            paramArrayOfByte = (DatingInfo)paramDatingInfo.next();
            if ((paramArrayOfByte != null) && (paramString1.equals(paramArrayOfByte.datingId))) {
              paramDatingInfo.remove();
            }
          }
          DatingUserCenterActivity.a(this.a, 1, DatingUserCenterActivity.b(this.a), true, true);
          return;
          if ((DatingUserCenterActivity.b(this.a) != null) && (!DatingUserCenterActivity.b(this.a).isEmpty()) && (!TextUtils.isEmpty(paramString1)))
          {
            paramDatingInfo = DatingUserCenterActivity.b(this.a).iterator();
            while (paramDatingInfo.hasNext())
            {
              paramArrayOfByte = (DatingInfo)paramDatingInfo.next();
              if ((paramArrayOfByte != null) && (paramString1.equals(paramArrayOfByte.datingId))) {
                paramDatingInfo.remove();
              }
            }
          }
        }
      }
    }
    label187:
    if (this.a.isResume())
    {
      this.a.a(2, 2131369799, 500);
      return;
    }
    label282:
    this.a.e();
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      DatingUserCenterActivity.a(this.a);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList, String paramString)
  {
    if (paramBoolean) {
      DatingUserCenterActivity.a(this.a);
    }
  }
  
  public void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    int i;
    if (paramBoolean)
    {
      if (paramInt4 == 4099)
      {
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          if (DatingUserCenterActivity.b(this.a) == null) {
            DatingUserCenterActivity.b(this.a, new ArrayList());
          }
          DatingUserCenterActivity.b(this.a).addAll(paramList);
        }
        if (DatingUserCenterActivity.a(this.a) == 1) {
          DatingUserCenterActivity.a(this.a, 1, DatingUserCenterActivity.b(this.a), true, true);
        }
        DatingUserCenterActivity.a(this.a)[1] = (paramInt3 * 1000L);
        DatingUserCenterActivity.a(this.a)[1] = paramInt1;
        DatingUserCenterActivity.a(this.a, "server_stamp_of_joined", paramInt3);
        paramList = DatingUserCenterActivity.c(this.a);
        if (paramInt2 != 0) {
          break label248;
        }
        i = 1;
        label148:
        paramList[1] = i;
      }
    }
    else
    {
      if (paramInt4 != 4099) {
        break label254;
      }
      DatingUserCenterActivity.d(this.a)[1] = 0;
    }
    for (;;)
    {
      if (DatingUserCenterActivity.a(this.a) == 1) {
        DatingUserCenterActivity.a(this.a, DatingUserCenterActivity.d(this.a)[1], DatingUserCenterActivity.c(this.a)[1]);
      }
      DatingUserCenterActivity.b(this.a);
      return;
      DatingUserCenterActivity.b(this.a, paramList);
      ((com.tencent.mobileqq.dating.DatingManager)this.a.app.getManager(67)).a[1] = true;
      break;
      label248:
      i = 0;
      break label148;
      label254:
      if (paramInt4 == 4098)
      {
        if ((DatingUserCenterActivity.a(this.a) == 1) && (DatingUserCenterActivity.e(this.a)[1] != 0))
        {
          paramList = DatingUserCenterActivity.a(this.a);
          if (!paramBoolean) {
            break label334;
          }
        }
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          paramList.a(paramInt1);
          DatingUserCenterActivity.a(this.a).sendEmptyMessageDelayed(4098, 300L);
          DatingUserCenterActivity.e(this.a)[1] = 0;
          break;
        }
      }
      label334:
      if (paramInt4 == 4097)
      {
        if (DatingUserCenterActivity.a(this.a) == 1)
        {
          DatingUserCenterActivity.c(this.a);
          if (!paramBoolean) {
            this.a.a(2, 2131369721, 500);
          }
        }
        DatingUserCenterActivity.a(this.a)[1] = 0;
        paramList = DatingUserCenterActivity.b(this.a);
        i = j;
        if (!paramBoolean) {
          i = 1;
        }
        paramList[1] = i;
      }
      else if (paramInt4 != 4100) {}
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      DatingUserCenterActivity.b(this.a);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, ArrayList paramArrayList, String paramString)
  {
    if (paramBoolean) {
      DatingUserCenterActivity.b(this.a);
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean) {
      DatingUserCenterActivity.a(this.a, paramString1, paramString2);
    }
  }
  
  public void b(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    label155:
    int i;
    if (paramBoolean)
    {
      if (paramInt4 == 4099)
      {
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          if (DatingUserCenterActivity.a(this.a) == null) {
            DatingUserCenterActivity.a(this.a, new ArrayList());
          }
          DatingUserCenterActivity.a(this.a).addAll(paramList);
        }
        if (DatingUserCenterActivity.a(this.a) == 0)
        {
          if ((paramInt4 != 4097) || (this.a.getIntent() == null) || (TextUtils.isEmpty(this.a.getIntent().getStringExtra("new_id")))) {
            break label307;
          }
          DatingUserCenterActivity.a(this.a).a(true);
          DatingUserCenterActivity.a(this.a, 0, DatingUserCenterActivity.a(this.a), true, true);
          DatingUserCenterActivity.a(this.a).sendEmptyMessageDelayed(4101, 500L);
        }
        DatingUserCenterActivity.a(this.a)[0] = (paramInt3 * 1000L);
        DatingUserCenterActivity.a(this.a)[0] = paramInt1;
        paramList = DatingUserCenterActivity.c(this.a);
        if (paramInt2 != 0) {
          break label327;
        }
        i = 1;
        label197:
        paramList[0] = i;
        DatingUserCenterActivity.a(this.a, "server_stamp_of_published", paramInt3);
      }
    }
    else
    {
      if (paramInt4 != 4099) {
        break label333;
      }
      DatingUserCenterActivity.d(this.a)[0] = 0;
    }
    label307:
    label327:
    label333:
    do
    {
      if (DatingUserCenterActivity.a(this.a) == 0) {
        DatingUserCenterActivity.a(this.a, DatingUserCenterActivity.d(this.a)[0], DatingUserCenterActivity.c(this.a)[0]);
      }
      DatingUserCenterActivity.a(this.a);
      return;
      DatingUserCenterActivity.a(this.a, paramList);
      ((com.tencent.mobileqq.dating.DatingManager)this.a.app.getManager(67)).a[0] = true;
      break;
      DatingUserCenterActivity.a(this.a, 0, DatingUserCenterActivity.a(this.a), true, true);
      break label155;
      i = 0;
      break label197;
      if (paramInt4 == 4098)
      {
        if ((DatingUserCenterActivity.a(this.a) == 0) && (DatingUserCenterActivity.e(this.a)[0] != 0))
        {
          paramList = DatingUserCenterActivity.a(this.a);
          if (!paramBoolean) {
            break label412;
          }
        }
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          paramList.a(paramInt1);
          DatingUserCenterActivity.a(this.a).sendEmptyMessageDelayed(4098, 300L);
          DatingUserCenterActivity.e(this.a)[0] = 0;
          break;
        }
      }
    } while (paramInt4 != 4097);
    label412:
    if (DatingUserCenterActivity.a(this.a) == 0)
    {
      DatingUserCenterActivity.d(this.a);
      if (!paramBoolean) {
        this.a.a(2, 2131369721, 500);
      }
    }
    DatingUserCenterActivity.a(this.a)[0] = 0;
    paramList = DatingUserCenterActivity.b(this.a);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramList[0] = paramBoolean;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icg
 * JD-Core Version:    0.7.0.1
 */