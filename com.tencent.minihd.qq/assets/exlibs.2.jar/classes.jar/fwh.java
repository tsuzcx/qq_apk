import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import mqq.app.MobileQQ;

public class fwh
  implements URLDrawable.URLDrawableListener
{
  public fwh(RichStatItemBuilder paramRichStatItemBuilder, RichStatItemBuilder.Holder paramHolder) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a.getApplication().getResources(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a, RichStatItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder), RichStatItemBuilder.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a, false);
    paramURLDrawable = ((SignatureManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a.getManager(56)).a(Integer.toString(RichStatItemBuilder.a().d));
    if (!TextUtils.isEmpty(paramURLDrawable.p)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.c.setTextColor(Color.parseColor(paramURLDrawable.p));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fwh
 * JD-Core Version:    0.7.0.1
 */