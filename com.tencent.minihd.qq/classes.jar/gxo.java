import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class gxo
  extends Handler
{
  public gxo(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          this.a.jdField_a_of_type_AndroidWidgetHorizontalScrollView.scrollTo(this.a.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width, 0);
          return;
        } while ((this.a.jdField_a_of_type_AndroidAppDialog == null) || (!this.a.jdField_a_of_type_AndroidAppDialog.isShowing()));
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        QQToast.a(this.a, 2, 2131368409, 1500).b(this.a.getTitleBarHeight());
        postDelayed(new gxp(this), 1500L);
        return;
      } while ((this.a.jdField_a_of_type_AndroidAppDialog == null) || (!this.a.jdField_a_of_type_AndroidAppDialog.isShowing()));
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      String str = (String)paramMessage.obj;
      paramMessage = str;
      if (str == null) {
        paramMessage = this.a.getString(2131368410);
      }
      QQToast.a(this.a, 1, paramMessage, 1500).b(this.a.getTitleBarHeight());
      return;
      paramMessage = (List)paramMessage.obj;
    } while ((paramMessage == null) || (SelectMemberActivity.a(this.a) == null));
    SelectMemberActivity.a(this.a).a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gxo
 * JD-Core Version:    0.7.0.1
 */