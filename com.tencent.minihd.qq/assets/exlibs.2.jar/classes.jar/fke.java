import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class fke
  extends MessageObserver
{
  public fke(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void a(String paramString)
  {
    if ((TroopRequestActivity.a(this.a) != null) && (TroopRequestActivity.a(this.a).isShowing()))
    {
      TroopRequestActivity.a(this.a).dismiss();
      paramString = this.a.getString(2131365893);
      QQToast.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l2 = GroupSystemMsgController.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if (!paramBoolean)
      {
        if (TroopRequestActivity.a(this.a) != null) {
          TroopRequestActivity.a(this.a).dismiss();
        }
        if (SystemMsgUtils.a(GroupSystemMsgController.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4)) {
          this.a.finish();
        }
        return;
      }
      if (TroopRequestActivity.a(this.a) != null) {
        TroopRequestActivity.a(this.a).dismiss();
      }
      this.a.finish();
      SystemMsgUtils.a(GroupSystemMsgController.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    this.a.a(2130838252, this.a.getString(2131367038));
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.a(2130838252, this.a.getString(2131367039));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fke
 * JD-Core Version:    0.7.0.1
 */