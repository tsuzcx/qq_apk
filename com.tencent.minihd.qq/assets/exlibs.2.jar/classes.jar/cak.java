import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.POI;
import com.tencent.biz.coupon.CouponActivity;

public class cak
  implements View.OnClickListener
{
  public cak(PoiMapActivity paramPoiMapActivity, String paramString1, String paramString2, PoiMapActivity.POI paramPOI, String paramString3) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPoiMapActivity, CouponActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.startActivity(paramView);
    if ((this.jdField_a_of_type_ComTencentBizPoiMapActivity.a != null) && (this.jdField_a_of_type_ComTencentBizPoiMapActivity.l < this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.length) && (!TextUtils.isEmpty(this.b))) {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", this.b, this.jdField_a_of_type_ComTencentBizPoiMapActivity$POI.c, this.c, "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cak
 * JD-Core Version:    0.7.0.1
 */