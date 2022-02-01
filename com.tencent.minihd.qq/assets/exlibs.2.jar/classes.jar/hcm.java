import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.widget.doyen.WidgetDoyen;
import com.tencent.widget.widget.adapters.AbstractWheelAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class hcm
  extends AbstractWheelAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  final FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams = new FrameLayout.LayoutParams(-2, -2);
  private List jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public hcm(WidgetDoyen paramWidgetDoyen, Context paramContext, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_ArrayOfInt.length);
    paramWidgetDoyen = this.jdField_a_of_type_ArrayOfInt;
    int j = paramWidgetDoyen.length;
    int i = 0;
    while (i < j)
    {
      int k = paramWidgetDoyen[i];
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(a(k)));
      i += 1;
    }
  }
  
  private Bitmap a(int paramInt)
  {
    return BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfInt.length;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (paramView = (ImageView)paramView;; paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext))
    {
      paramView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
      Bitmap localBitmap = (Bitmap)((WeakReference)this.jdField_a_of_type_JavaUtilList.get(paramInt)).get();
      paramViewGroup = localBitmap;
      if (localBitmap == null)
      {
        paramViewGroup = a(this.jdField_a_of_type_ArrayOfInt[paramInt]);
        this.jdField_a_of_type_JavaUtilList.set(paramInt, new WeakReference(paramViewGroup));
      }
      paramView.setImageBitmap(paramViewGroup);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcm
 * JD-Core Version:    0.7.0.1
 */