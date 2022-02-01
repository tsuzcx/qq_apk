import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.LinkedList;

public class jjf
  implements View.OnClickListener
{
  public jjf(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(NearbyProfileEditPanel.a(this.a), 2131367328, 0).b(NearbyProfileEditPanel.a(this.a).getTitleBarHeight());
      return;
    }
    if (NearbyProfileEditPanel.a(this.a).a.size() <= 1)
    {
      paramView = DialogUtil.a(NearbyProfileEditPanel.a(this.a), "交友相册需要至少一张照片\n仅陌生人可见，秀出精彩的自己！", 0, 0, null, null);
      paramView.setNegativeButton(2131365736, new jjg(this, paramView));
      paramView.setPositiveButton("立即上传", new jjh(this, paramView));
      paramView.show();
      return;
    }
    paramView = NearbyProfileEditPanel.a(this.a).getText().toString();
    if (!StringUtil.b(paramView))
    {
      if (StringUtil.e(paramView).length() == 0) {
        QQToast.a(NearbyProfileEditPanel.a(this.a), "交友昵称不允许全为空格", 0).b(NearbyProfileEditPanel.a(this.a).getTitleBarHeight());
      }
    }
    else
    {
      QQToast.a(NearbyProfileEditPanel.a(this.a), "交友昵称不允许为空", 0).b(NearbyProfileEditPanel.a(this.a).getTitleBarHeight());
      return;
    }
    this.a.a();
    if (NearbyProfileEditPanel.a(this.a).size() > 0)
    {
      NearbyProfileEditPanel.b(this.a);
      return;
    }
    NearbyProfileEditPanel.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jjf
 * JD-Core Version:    0.7.0.1
 */