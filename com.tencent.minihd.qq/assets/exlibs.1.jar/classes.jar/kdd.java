import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.util.WeakReferenceHandler;

public class kdd
  implements TabBarView.OnTabChangeListener
{
  public kdd(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (NearbyTroopsActivity.a(this.a) != null) {
      NearbyTroopsActivity.a(this.a).g();
    }
    Object localObject;
    String str;
    if (NearbyTroopsActivity.a(this.a) != paramInt2)
    {
      if (NearbyTroopsActivity.a(this.a) != -1) {
        this.a.W = -1;
      }
      switch (NearbyTroopsActivity.a(this.a))
      {
      default: 
        localObject = "";
        switch (paramInt2)
        {
        default: 
          localObject = "";
          str = "";
          label124:
          RedDotTextView localRedDotTextView = NearbyTroopsActivity.a(this.a).a(paramInt2);
          if (localRedDotTextView != null) {
            if (localRedDotTextView.a())
            {
              paramInt1 = 0;
              label152:
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                if (NearbyTroopsActivity.a(this.a) != -1) {
                  ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", (String)localObject, "Clk_tab", 0, 0, String.valueOf(this.a.V), "", "", "");
                }
                ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", (String)localObject, "exp", 0, 0, String.valueOf(this.a.V), NearbyTroopsActivity.a(this.a).b() + "", "", paramInt1 + "");
              }
              i = paramInt1;
              if (this.a.b == 0)
              {
                i = paramInt1;
                if (!TextUtils.isEmpty(str))
                {
                  this.a.a.b(str);
                  i = paramInt1;
                  if (localRedDotTextView != null) {
                    localRedDotTextView.a(false);
                  }
                }
              }
            }
          }
          break;
        }
        break;
      }
    }
    for (int i = paramInt1;; i = 1)
    {
      NearbyTroopsActivity.a(this.a, paramInt2);
      this.a.startTitleProgress();
      localObject = Message.obtain();
      ((Message)localObject).arg1 = i;
      ((Message)localObject).what = 1229;
      NearbyTroopsActivity.a(this.a).sendMessageDelayed((Message)localObject, 200L);
      return;
      this.a.V = 0;
      this.a.W = NearbyTroopsActivity.a(this.a).b();
      break;
      this.a.V = 1;
      break;
      this.a.V = 2;
      break;
      if (NearbyTroopsActivity.a(this.a) != -1) {
        localObject = "grp";
      }
      str = "886.100170";
      break label124;
      localObject = "ac";
      str = "886.100171";
      break label124;
      localObject = "recom";
      str = "886.100172";
      break label124;
      paramInt1 = 1;
      break label152;
      paramInt1 = 1;
      break label152;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdd
 * JD-Core Version:    0.7.0.1
 */