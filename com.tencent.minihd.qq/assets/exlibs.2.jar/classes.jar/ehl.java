import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.qphone.base.util.QLog;

public class ehl
  implements InputMethodRelativeLayout.onSizeChangedListenner
{
  public ehl(LoginActivity paramLoginActivity) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "onSizeChange isOpen:" + paramBoolean + " preH:" + paramInt1 + " curH:" + paramInt2);
    }
    LoginActivity.a(this.a);
    if (paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      LoginActivity.a(this.a).getLocationInWindow(arrayOfInt);
      paramInt1 = arrayOfInt[1];
      LoginActivity.a(this.a).getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1];
      paramInt2 = paramInt1 - i + LoginActivity.a(this.a).getHeight() - paramInt2;
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onSizeChange btnY:" + paramInt1 + " layoutY:" + i + " paddingY:" + paramInt2);
      }
      if (paramInt2 > 0) {
        LoginActivity.a(this.a).setPadding(LoginActivity.a(this.a).getPaddingLeft(), LoginActivity.a(this.a).getPaddingTop() - paramInt2, LoginActivity.a(this.a).getPaddingRight(), LoginActivity.a(this.a).getPaddingBottom());
      }
      LoginActivity.b(this.a).setVisibility(8);
      return;
    }
    LoginActivity.b(this.a).setVisibility(0);
    LoginActivity.a(this.a).setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehl
 * JD-Core Version:    0.7.0.1
 */