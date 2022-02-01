import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.ArrayList;

class ikw
  implements View.OnClickListener
{
  ikw(ikv paramikv, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = (LocalFileAdapter.LocalFileItemHolder)this.jdField_a_of_type_AndroidViewView.getTag();
    this.jdField_a_of_type_Ikv.a.b = paramView.a;
    paramView = (FileInfo)this.jdField_a_of_type_Ikv.a.a.get(this.jdField_a_of_type_Ikv.a.b);
    if ((!FileUtil.a(paramView.d())) || (FileUtil.c(paramView.d())))
    {
      FileManagerUtil.d(paramView.d());
      this.jdField_a_of_type_Ikv.a.a.remove(this.jdField_a_of_type_Ikv.a.b);
      LocalFileBrowserActivity.a(this.jdField_a_of_type_Ikv.a);
      return;
    }
    FMToastUtil.a(2131362403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ikw
 * JD-Core Version:    0.7.0.1
 */