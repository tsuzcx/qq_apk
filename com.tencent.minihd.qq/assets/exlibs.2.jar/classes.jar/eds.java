import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class eds
  implements View.OnClickListener
{
  public eds(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = VipUtils.a(this.a.app, null);
    int i;
    if ((k & 0x2) != 0)
    {
      i = 1;
      if ((k & 0x4) == 0) {
        break label92;
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0)) {
        break label97;
      }
      if (30 != this.a.a.size()) {
        break label145;
      }
      paramView = new QQToast(this.a);
      paramView.c(2000);
      paramView.b(2131368819);
      paramView.a();
      return;
      i = 0;
      break;
      label92:
      j = 0;
    }
    label97:
    if (16 == this.a.a.size())
    {
      paramView = new QQToast(this.a);
      paramView.c(2000);
      paramView.b(2131368818);
      paramView.a();
      return;
    }
    label145:
    GroupManagerActivity.a(this.a, DialogUtil.a(this.a, 2131368010, 2131368012, null, GroupManagerActivity.a(this.a), GroupManagerActivity.b(this.a)));
    GroupManagerActivity.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eds
 * JD-Core Version:    0.7.0.1
 */