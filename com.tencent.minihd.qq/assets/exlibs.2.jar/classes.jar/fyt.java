import android.view.View;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;

public class fyt
  implements AdapterView.OnItemClickListener
{
  public fyt(AIOImageListScene paramAIOImageListScene) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    AIOImageInfo localAIOImageInfo = AIOImageListScene.a(this.a).a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + AIOImageListScene.a(this.a).s() + " LastVisiblePosition " + AIOImageListScene.b(this.a).t());
    }
    int i;
    if (AIOImageListScene.a(this.a)) {
      if (localAIOImageInfo.b() == 1)
      {
        i = 1;
        AIOImageListScene localAIOImageListScene = this.a;
        if (i != 0) {
          break label248;
        }
        label116:
        AIOImageListScene.a(localAIOImageListScene, localAIOImageInfo, bool);
        if (!AIOImageListScene.a(this.a, paramView, localAIOImageInfo)) {
          ((AbstractImageAdapter)paramAdapterView.a()).notifyDataSetChanged();
        }
        AIOImageListScene.d(this.a);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + AIOImageListScene.e(this.a).s() + " LastVisiblePosition " + AIOImageListScene.f(this.a).t() + " SelectedIndex = " + AIOImageListScene.a(this.a).b());
      }
      return;
      i = 0;
      break;
      label248:
      bool = false;
      break label116;
      AIOImageListScene.a(this.a).a(paramInt);
      AIOImageListScene.a(this.a).b(AIOImageListScene.c(this.a).s());
      AIOImageListScene.a(this.a).c(AIOImageListScene.d(this.a).t());
      this.a.n();
      AIOImageListScene.a(this.a, "Multi_Pic_big", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fyt
 * JD-Core Version:    0.7.0.1
 */