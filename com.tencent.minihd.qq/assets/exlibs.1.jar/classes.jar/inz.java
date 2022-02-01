import android.media.MediaScannerConnection;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

class inz
  implements View.OnClickListener
{
  inz(iny paraminy, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((paramView instanceof QfileLocalImageExpandableListAdapter.ImageHolder))
    {
      paramView = (FileInfo)((QfileLocalImageExpandableListAdapter.ImageHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if ((!FileUtil.a(paramView.d())) || (FileUtil.c(paramView.d())))
      {
        FileManagerUtil.d(paramView.d());
        this.jdField_a_of_type_Iny.a.a(paramView);
        MediaScannerConnection.scanFile(this.jdField_a_of_type_Iny.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity, new String[] { paramView.d() }, null, null);
        QfileBaseLocalFileTabView.a(this.jdField_a_of_type_Iny.a);
      }
    }
    else
    {
      do
      {
        return;
        if ((paramView instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder))
        {
          paramView = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
      return;
    }
    FMToastUtil.a(2131362403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     inz
 * JD-Core Version:    0.7.0.1
 */