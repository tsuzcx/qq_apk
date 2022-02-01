import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.widget.XListView;

public class jfp
  implements IIconListener
{
  public jfp(VipMapRoamActivity paramVipMapRoamActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramInt2 == 200))
    {
      int i = this.a.a.getChildCount();
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        paramBitmap = this.a.a.getChildAt(paramInt2).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof PeopleAroundAdapter.ViewHolder)))
        {
          paramBitmap = (PeopleAroundAdapter.ViewHolder)paramBitmap;
          if ((paramBitmap.jdField_b_of_type_Int == paramInt1) && (paramBitmap.jdField_b_of_type_AndroidWidgetTextView != null)) {
            this.a.a(paramBitmap.jdField_b_of_type_AndroidWidgetTextView, paramInt1);
          }
        }
        paramInt2 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jfp
 * JD-Core Version:    0.7.0.1
 */