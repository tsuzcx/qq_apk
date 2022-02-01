import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import com.tencent.mobileqq.activity.phone.BindNumberBusinessActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class gpp
  extends ContactBindObserver
{
  public gpp(BindNumberBusinessActivity paramBindNumberBusinessActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.a();
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0)) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindNumberBusinessActivity.b(this.a));
      BindNumberBusinessActivity.b(this.a, null);
      return;
      if (i == 107)
      {
        Intent localIntent = new Intent(this.a, RebindActivity.class);
        localIntent.putExtra("k_uin", paramBundle.getString("k_uin"));
        localIntent.putExtra("k_number", this.a.c);
        localIntent.putExtra("k_country_code", this.a.b);
        localIntent.putExtra("kBindType", BindNumberBusinessActivity.a(this.a));
        if ((localIntent != null) && (!this.a.isFinishing()))
        {
          localIntent.addFlags(536870912);
          this.a.startActivityForResult(localIntent, 2);
        }
      }
      else if (i == 106)
      {
        this.a.setResult(-1);
        this.a.finish();
      }
      else
      {
        this.a.a(a(i));
        this.a.finish();
        continue;
        this.a.b(2131366990);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gpp
 * JD-Core Version:    0.7.0.1
 */