import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mobileqq.dating.DatingItemBuilder;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;
import com.tencent.mobileqq.dating.DatingUserCenterAdapter;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class icl
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public icl(DatingUserCenterActivity paramDatingUserCenterActivity) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.dating", 2, "onDecodeTaskCOmpleted. uin is:" + paramString);
    }
    if ((paramBitmap == null) || (DatingUserCenterActivity.a(this.a) != 1) || (DatingUserCenterActivity.a(this.a).a())) {}
    for (;;)
    {
      return;
      paramInt2 = DatingUserCenterActivity.a(this.a).getChildCount();
      DatingItemBuilder localDatingItemBuilder = DatingUserCenterActivity.a(this.a).a();
      paramBitmap = new BitmapDrawable(this.a.getResources(), paramBitmap);
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        View localView = DatingUserCenterActivity.a(this.a).getChildAt(paramInt1);
        if (localDatingItemBuilder.a(paramString, localView)) {
          localDatingItemBuilder.a(paramBitmap, localView);
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icl
 * JD-Core Version:    0.7.0.1
 */