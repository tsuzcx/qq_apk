import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class du
  implements View.OnClickListener
{
  public du(PrinterSessionAdapter paramPrinterSessionAdapter, PrinterItemMsgRecord paramPrinterItemMsgRecord, Context paramContext) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (2131302483 == paramView.getId())
    {
      paramView = new dv(this);
      dw localdw = new dw(this);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131362060), this.jdField_a_of_type_AndroidContentContext.getString(2131362090), 2131365736, 2131362063, paramView, localdw).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     du
 * JD-Core Version:    0.7.0.1
 */