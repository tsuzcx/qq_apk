import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class gsf
  extends BaseAdapter
{
  public gsf(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public String a(int paramInt)
  {
    if ((CameraPreviewActivity.a(this.a) != null) && (paramInt < CameraPreviewActivity.a(this.a).size()) && (paramInt >= 0)) {
      return (String)CameraPreviewActivity.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (CameraPreviewActivity.a(this.a) != null) {
      return CameraPreviewActivity.a(this.a).size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2130903410, null);
      paramViewGroup = new gsh();
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131298132));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = a(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("CameraPreviewActivity", 2, "getView path = " + str);
      }
      if (str != null)
      {
        Object localObject = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("CameraPreviewActivity", 2, "getView path = " + str + ",exist = " + ((File)localObject).exists());
        }
        if (((File)localObject).exists()) {}
        try
        {
          localObject = URLDrawable.getDrawable(((File)localObject).toURL(), CameraPreviewActivity.a(this.a), CameraPreviewActivity.b(this.a), CameraPreviewActivity.a(this.a), null, true);
          if (((URLDrawable)localObject).getStatus() == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CameraPreviewActivity", 2, "getView path = " + str + ",URLDrawable Successed");
            }
            paramViewGroup.a.setImageDrawable((Drawable)localObject);
            return paramView;
            paramViewGroup = (gsh)paramView.getTag();
          }
          else
          {
            ((URLDrawable)localObject).startDownload();
            if (QLog.isColorLevel()) {
              QLog.d("CameraPreviewActivity", 2, "getView path = " + str + ",URLDrawable startDownload");
            }
            ((URLDrawable)localObject).setURLDrawableListener(new gsg(this, str, paramViewGroup.a, (URLDrawable)localObject));
            return paramView;
          }
        }
        catch (MalformedURLException paramViewGroup)
        {
          paramViewGroup.printStackTrace();
          return paramView;
        }
      }
    }
    paramViewGroup.a.setImageDrawable(null);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gsf
 * JD-Core Version:    0.7.0.1
 */