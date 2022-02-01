import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;

public class jss
  implements URLDrawable.URLDrawableListener
{
  public jss(StatusHistoryActivity paramStatusHistoryActivity, StatusHistoryActivity.ItemViewHolder paramItemViewHolder) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity.getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, StatusHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity.app, false);
    paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity.a.a(Integer.toString(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.d));
    if (!TextUtils.isEmpty(paramURLDrawable.p)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramURLDrawable.p));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jss
 * JD-Core Version:    0.7.0.1
 */