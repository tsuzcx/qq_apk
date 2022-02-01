import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class fuh
  extends ClickableSpan
{
  public fuh(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a.getString(2131367629) + " " + this.jdField_a_of_type_JavaLangString;
    paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a, 230).setTitle(paramView).setMessage(this.b);
    paramView.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a.getString(2131367631), new fuj(this)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.a.getString(2131365736), new fui(this));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fuh
 * JD-Core Version:    0.7.0.1
 */