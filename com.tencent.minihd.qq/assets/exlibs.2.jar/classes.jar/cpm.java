import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Ad;

public class cpm
  implements Animation.AnimationListener
{
  public cpm(Ad paramAd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.setVisibility(0);
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(null);
    this.a.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.clearAnimation();
    if (!this.a.a) {
      ((AbsoluteLayout.LayoutParams)this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getLayoutParams()).y = 0;
    }
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.setOnCustomScroolChangeListener(null);
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.scrollBy(0, -1);
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.scrollBy(0, 1);
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.setOnCustomScroolChangeListener(Ad.a(this.a));
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.setDrawingCacheEnabled(false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.setVisibility(8);
    this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cpm
 * JD-Core Version:    0.7.0.1
 */