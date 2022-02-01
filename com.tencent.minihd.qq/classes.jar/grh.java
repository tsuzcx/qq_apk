import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.RebindActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class grh
  extends ContactBindObserver
{
  public grh(RebindActivity paramRebindActivity) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.a();
    if (paramBoolean)
    {
      paramBundle = new Intent(this.a, BindVerifyActivity.class);
      paramBundle.putExtra("k_number", this.a.d);
      paramBundle.putExtra("kBindType", RebindActivity.a(this.a));
      this.a.startActivityForResult(paramBundle, 1);
      return;
    }
    this.a.b(2131366990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     grh
 * JD-Core Version:    0.7.0.1
 */