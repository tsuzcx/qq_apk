import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import cooperation.qzone.UploadServerSetting;
import cooperation.qzone.UploadServerSetting.ConfigItem;

public class mbk
  implements AdapterView.OnItemClickListener
{
  public mbk(UploadServerSetting paramUploadServerSetting) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.a = ((BaseAdapter)paramAdapterView.getAdapter());
    paramAdapterView = (UploadServerSetting.ConfigItem)paramAdapterView.getItemAtPosition(paramInt);
    if (paramAdapterView == null) {
      return;
    }
    paramInt = paramAdapterView.b;
    if (paramAdapterView.b == 5)
    {
      this.a.a();
      return;
    }
    this.a.a(paramAdapterView);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadServerSetting", 2, "ShareAlbum update upload server");
      }
      IUploadService.UploadServiceCreator.getInstance().setTestServer(paramInt);
      return;
    }
    catch (Exception paramAdapterView)
    {
      paramAdapterView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbk
 * JD-Core Version:    0.7.0.1
 */