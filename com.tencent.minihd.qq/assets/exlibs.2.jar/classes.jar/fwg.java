import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class fwg
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 200L;
  private long b = 0L;
  
  public fwg(RichStatItemBuilder paramRichStatItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.jdField_a_of_type_AndroidContentContext.getResources();
    if (!NetworkUtil.e(this.a.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, ((Resources)localObject).getString(2131365730), 0).b(((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
    }
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.b) < 200L)
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, ((Resources)localObject).getString(2131369948), 0).b(((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
        return;
      }
      this.b = l;
      localObject = (RichStatItemBuilder.Holder)paramView.getTag();
      try
      {
        if (((RichStatItemBuilder.Holder)localObject).d.getText() == null) {}
        int j;
        int k;
        for (paramView = "0";; paramView = ((RichStatItemBuilder.Holder)localObject).d.getText().toString())
        {
          j = Integer.parseInt(paramView);
          if (((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_Int != 0) {
            break label329;
          }
          ((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_Int = 1;
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_on", 0, 0, "", "", "", "");
          i = 8;
          j += 1;
          k = 1;
          ((RichStatItemBuilder.Holder)localObject).d.setText(j + "");
          paramView = RichStatItemBuilder.a(this.a).a(((RichStatItemBuilder.Holder)localObject).b, i);
          if (paramView != null) {
            ((RichStatItemBuilder.Holder)localObject).d.setCompoundDrawablesWithIntrinsicBounds(paramView, null, null, null);
          }
          paramView = (SignatureHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43);
          if (paramView == null) {
            break;
          }
          paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_JavaLangString, 255, k);
          return;
        }
        label329:
        ((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_Int = 0;
        int i = j - 1;
        if (i > 0) {}
        for (;;)
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_off", 0, 0, "", "", "", "");
          int m = 7;
          j = i;
          k = 0;
          i = m;
          break;
          i = 0;
        }
        return;
      }
      catch (Exception paramView) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fwg
 * JD-Core Version:    0.7.0.1
 */