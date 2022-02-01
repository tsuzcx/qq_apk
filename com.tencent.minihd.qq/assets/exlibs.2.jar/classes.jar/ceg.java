import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.coupon.CouponActivity;

public class ceg
  implements View.OnClickListener
{
  public ceg(CouponActivity paramCouponActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a & 0x4) != 0)
    {
      paramView = new Intent();
      paramView.putExtra("isNeedFinish", true);
      paramView.putExtra("toPage", 1);
      this.a.setResult(-1, paramView);
      this.a.finish();
      return;
    }
    paramView = new Intent(this.a, CouponActivity.class);
    paramView.putExtra("url", "https://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
    paramView.putExtra("source", "2");
    paramView.putExtra("from", this.a.a & 0xC | 0x5);
    this.a.startActivityForResult(paramView, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ceg
 * JD-Core Version:    0.7.0.1
 */