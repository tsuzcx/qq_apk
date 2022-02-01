import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.BindNumberDialogActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class gpr
  extends ContactBindObserver
{
  public gpr(BindNumberDialogActivity paramBindNumberDialogActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.a();
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0))
      {
        paramBundle = new Intent(this.a, BindVerifyActivity.class);
        paramBundle.putExtra("kBindType", this.a.jdField_b_of_type_Int);
        paramBundle.putExtra("k_number", this.a.c);
        paramBundle.putExtra("kShowAgree", true);
        if ((paramBundle != null) && (!this.a.isFinishing()))
        {
          paramBundle.addFlags(536870912);
          this.a.startActivityForResult(paramBundle, 2);
        }
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
      this.a.finish();
      return;
      if (i == 107)
      {
        Intent localIntent = new Intent(this.a, RebindActivity.class);
        localIntent.putExtra("k_uin", paramBundle.getString("k_uin"));
        localIntent.putExtra("k_number", this.a.c);
        localIntent.putExtra("k_country_code", this.a.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("kBindType", this.a.jdField_b_of_type_Int);
        paramBundle = localIntent;
        break;
      }
      if (i == 106)
      {
        this.a.a("已经绑定成功");
        paramBundle = null;
        break;
      }
      this.a.a(a(i));
      paramBundle = null;
      break;
      this.a.b(2131366990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gpr
 * JD-Core Version:    0.7.0.1
 */