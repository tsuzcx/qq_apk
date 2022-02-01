import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.DatingCacheMng;
import com.tencent.mobileqq.dating.DatingFeedActivity;
import com.tencent.mobileqq.dating.DatingFeedAdapter;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class ibh
  extends DatingObserver
{
  public ibh(DatingFeedActivity paramDatingFeedActivity) {}
  
  public void a()
  {
    DatingFeedActivity.a(this.a);
  }
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList, List paramList, String paramString)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      return;
      if ((paramArrayList == null) || (paramArrayList.size() < 1)) {}
      for (paramArrayList = null; (paramBoolean) && (!TextUtils.isEmpty(paramArrayList)); paramArrayList = (String)paramArrayList.get(0))
      {
        DatingFeedActivity.a(this.a).a(paramArrayList);
        ((DatingManager)this.a.app.getManager(67)).a().a(paramArrayList, 0);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString, boolean paramBoolean4, boolean paramBoolean5)
  {
    int i;
    if (paramList == null)
    {
      i = 0;
      DatingUtil.a("onGetDatingFeeds", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(i), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), paramArrayOfByte, paramString, Boolean.valueOf(paramBoolean4), Boolean.valueOf(paramBoolean5) });
      if (!paramBoolean5) {
        break label270;
      }
      if (DatingFeedActivity.a(this.a) != null)
      {
        if (!paramBoolean1) {
          break label246;
        }
        DatingFeedActivity.a(this.a).a(0);
        if (DatingFeedActivity.a(this.a) != null) {
          DatingFeedActivity.a(this.a).sendEmptyMessageDelayed(1, 800L);
        }
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        break label281;
      }
      paramList = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramList = this.a.getResources().getString(2131369764);
      }
      this.a.a(paramList);
      if ((DatingFeedActivity.a(this.a) != null) && (DatingFeedActivity.a(this.a).isEmpty())) {
        DatingFeedActivity.a(this.a, null);
      }
      if (!paramBoolean4) {
        DatingFeedActivity.a(this.a, DatingFeedActivity.a(this.a));
      }
      DatingFeedActivity.c(this.a, false);
      DatingFeedActivity.d(this.a, false);
      return;
      i = paramList.size();
      break;
      label246:
      DatingFeedActivity.a(this.a).a(1);
      DatingFeedActivity.a(this.a).B();
      continue;
      label270:
      DatingFeedActivity.a(this.a);
    }
    label281:
    if (paramBoolean4)
    {
      DatingFeedActivity.a(this.a).a(paramList);
      label297:
      DatingFeedActivity.b(this.a, paramBoolean2);
      if (DatingFeedActivity.a(this.a) != null)
      {
        if (DatingFeedActivity.b(this.a)) {
          break label461;
        }
        DatingFeedActivity.a(this.a).c();
      }
    }
    for (;;)
    {
      if (paramArrayOfByte != null) {
        DatingFeedActivity.a(this.a, paramArrayOfByte);
      }
      ThreadManager.a().post(new ibi(this));
      break;
      DatingFeedActivity.a(this.a, paramList);
      DatingFeedActivity.a(this.a, DatingFeedActivity.b(this.a));
      DatingFeedActivity.a(this.a, DatingFeedActivity.b(this.a));
      DatingFeedActivity.a(this.a, paramBoolean3);
      DatingFeedActivity.a(this.a, System.currentTimeMillis());
      paramList = (DatingManager)this.a.app.getManager(67);
      if (paramList == null) {
        break label297;
      }
      paramList.a(DatingFeedActivity.a(this.a));
      break label297;
      label461:
      DatingFeedActivity.a(this.a).b();
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean) {
      DatingFeedActivity.a(this.a, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibh
 * JD-Core Version:    0.7.0.1
 */