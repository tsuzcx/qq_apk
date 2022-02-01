import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.XListView;

class aj
  implements Runnable
{
  aj(aa paramaa, String paramString) {}
  
  public void run()
  {
    LiteActivity.a(this.jdField_a_of_type_Aa.a).notifyDataSetChanged();
    ((ClipboardManager)LiteActivity.a(this.jdField_a_of_type_Aa.a).getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", this.jdField_a_of_type_JavaLangString));
    LiteActivity.a(this.jdField_a_of_type_Aa.a.a, LiteActivity.a(this.jdField_a_of_type_Aa.a));
    LiteActivity.a(LiteActivity.a(this.jdField_a_of_type_Aa.a));
    this.jdField_a_of_type_Aa.a.app.a().a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aj
 * JD-Core Version:    0.7.0.1
 */