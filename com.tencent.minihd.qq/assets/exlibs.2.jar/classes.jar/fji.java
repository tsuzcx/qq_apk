import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class fji
  implements View.OnClickListener
{
  public fji(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    String str;
    label270:
    do
    {
      int i;
      do
      {
        do
        {
          boolean bool1;
          do
          {
            do
            {
              do
              {
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("TroopMemberListActivity", 2, "mOnKickOutBtnClickListener onclick");
                }
                i = paramView.getId();
                str = (String)paramView.getTag();
                if (i != 2131302311) {
                  break label270;
                }
                paramView = paramView.findViewById(2131302312);
                bool1 = bool2;
                if (paramView.getTag() != null)
                {
                  bool1 = bool2;
                  if ((paramView.getTag() instanceof Boolean)) {
                    bool1 = ((Boolean)paramView.getTag()).booleanValue();
                  }
                }
                paramView = this.a.a(str, bool1);
                if (!bool1) {
                  break;
                }
              } while (this.a.s.equals(str));
              if (paramView != null) {
                paramView.a.a(true);
              }
              if (!TextUtils.isEmpty(this.a.s))
              {
                paramView = this.a.a(this.a.s, bool1);
                if (paramView != null) {
                  paramView.a.b(true);
                }
              }
              this.a.s = str;
              return;
            } while (this.a.r.equals(str));
            if (paramView != null) {
              paramView.a.a(true);
            }
            if (!TextUtils.isEmpty(this.a.r))
            {
              paramView = this.a.a(this.a.r, bool1);
              if (paramView != null) {
                paramView.a.b(true);
              }
            }
            this.a.r = str;
            return;
            if (i != 2131302357) {
              break label397;
            }
            paramView = paramView.findViewById(2131302358);
            bool1 = bool3;
            if (paramView.getTag() != null)
            {
              bool1 = bool3;
              if ((paramView.getTag() instanceof Boolean)) {
                bool1 = ((Boolean)paramView.getTag()).booleanValue();
              }
            }
            if (!bool1) {
              break;
            }
            paramView = this.a.a(this.a.s, bool1);
          } while (paramView == null);
          paramView.a.b(true);
          this.a.s = "";
          return;
          paramView = this.a.a(this.a.r, bool1);
        } while (paramView == null);
        paramView.a.b(true);
        this.a.r = "";
        return;
      } while ((i != 2131302314) || (!this.a.b));
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "delBtn onClick, uin=" + str);
      }
      if (NetworkUtil.e(BaseApplication.getContext())) {
        break;
      }
    } while (!this.a.isResume());
    label397:
    QQToast.a(this.a, this.a.getString(2131367328), 0).b(this.a.getTitleBarHeight());
    return;
    if (this.a.t == 1)
    {
      this.a.e(str);
      return;
    }
    paramView = new Dialog(this.a, 2131558902);
    paramView.setContentView(2130903294);
    ((TextView)paramView.findViewById(2131297367)).setText(this.a.getString(2131365827));
    TextView localTextView = (TextView)paramView.findViewById(2131296606);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131297592);
    if ((localTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localCheckBox.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localTextView.setText(this.a.getString(2131365835));
    localCheckBox.setText(this.a.getString(2131365836));
    localTextView = (TextView)paramView.findViewById(2131297370);
    Object localObject = (TextView)paramView.findViewById(2131297371);
    localTextView.setText(17039360);
    ((TextView)localObject).setText(17039370);
    localTextView.setOnClickListener(new fjj(this, paramView));
    ((TextView)localObject).setOnClickListener(new fjk(this, str, localCheckBox, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fji
 * JD-Core Version:    0.7.0.1
 */