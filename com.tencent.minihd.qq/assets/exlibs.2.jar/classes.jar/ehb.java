import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import java.io.File;

public class ehb
  extends DownloadIconsListener
{
  public ehb(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int k = 0;
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {}
    label235:
    label236:
    for (;;)
    {
      return;
      int m = LebaListMgrActivity.a(this.a).getCount();
      int j = 0;
      int i = k;
      if (j < m)
      {
        Object localObject = LebaListMgrActivity.a(this.a).getItem(j);
        if ((localObject != null) && ((localObject instanceof LebaViewItem)))
        {
          localObject = (LebaViewItem)localObject;
          if ((((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (paramString.equals(((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)))
          {
            ((LebaViewItem)localObject).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
            j = 1;
            localObject = LebaUtil.a(this.a, paramString, ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
            i = j;
            if (localObject == null) {
              break label235;
            }
            i = j;
            if (paramBitmap == null) {
              break label235;
            }
            i = j;
            if (BaseApplicationImpl.a == null) {
              break label235;
            }
            localObject = "LebaIcon://" + ((File)localObject).getAbsolutePath();
            if (BaseApplicationImpl.a.get(localObject) == null) {
              BaseApplicationImpl.a.put(localObject, paramBitmap);
            }
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label236;
        }
        this.a.runOnUiThread(new ehc(this, paramString));
        return;
        j += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehb
 * JD-Core Version:    0.7.0.1
 */