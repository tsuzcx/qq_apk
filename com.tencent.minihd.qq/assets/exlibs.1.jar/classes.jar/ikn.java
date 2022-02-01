import android.view.View;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class ikn
  implements AdapterView.OnItemClickListener
{
  public ikn(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FileInfo)this.a.a.get(paramInt);
    if (paramAdapterView.a()) {
      LocalFileBrowserActivity.a(this.a, paramAdapterView.d(), true);
    }
    while (!this.a.h()) {
      return;
    }
    if (FMDataCache.a(paramAdapterView)) {
      FMDataCache.b(paramAdapterView);
    }
    for (;;)
    {
      this.a.k();
      LocalFileBrowserActivity.a(this.a);
      return;
      if (this.a.d) {
        FMDataCache.b();
      }
      FMDataCache.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ikn
 * JD-Core Version:    0.7.0.1
 */