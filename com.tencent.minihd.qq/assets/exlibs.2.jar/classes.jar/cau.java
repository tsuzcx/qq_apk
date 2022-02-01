import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.ShopListAdapter;
import com.tencent.biz.PoiMapActivity.Shops;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class cau
  implements AdapterView.OnItemClickListener
{
  public cau(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.a.a(paramInt);
    if (paramAdapterView == null) {
      return;
    }
    paramView = new Intent(this.a, CouponActivity.class);
    paramView.putExtra("url", paramAdapterView.g);
    this.a.startActivity(paramView);
    if (!TextUtils.isEmpty(PoiMapActivity.a(this.a))) {
      this.a.a("rec_locate", "click_shangjia", paramAdapterView.h, "", "", "");
    }
    for (;;)
    {
      if (paramAdapterView.b != 0) {
        this.a.a("rec_locate", "view_share_tuan", paramAdapterView.h, "", "", "");
      }
      if (paramAdapterView.c == 0) {
        break;
      }
      this.a.a("rec_locate", "click_quan", paramAdapterView.h, "", "", "");
      return;
      this.a.a("rec_locate", "click_near_food", paramAdapterView.h, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cau
 * JD-Core Version:    0.7.0.1
 */