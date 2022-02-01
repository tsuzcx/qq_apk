import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;

public class fud
  implements FileManagerUtil.TipsClickedInterface
{
  public fud(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void a(View paramView)
  {
    paramView = new Intent((Activity)this.a.jdField_a_of_type_AndroidContentContext, FMActivity.class);
    paramView.putExtra("tab_tab_type", 0);
    paramView.putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    FileManagerReporter.a("0X800506C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fud
 * JD-Core Version:    0.7.0.1
 */