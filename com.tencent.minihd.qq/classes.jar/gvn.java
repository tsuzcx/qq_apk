import android.support.v4.view.ViewPager;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;

class gvn
  implements Runnable
{
  private float jdField_a_of_type_Float;
  
  public gvn(gvl paramgvl, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void run()
  {
    try
    {
      if ((RecentCallHelper.a(this.jdField_a_of_type_Gvl.a) != null) && (RecentCallHelper.a(this.jdField_a_of_type_Gvl.a).getVisibility() == 0))
      {
        if ((RecentCallHelper.a(this.jdField_a_of_type_Gvl.a).isFakeDragging()) || (RecentCallHelper.a(this.jdField_a_of_type_Gvl.a).beginFakeDrag()))
        {
          RecentCallHelper.a(this.jdField_a_of_type_Gvl.a).fakeDragBy(this.jdField_a_of_type_Float);
          return;
        }
        RecentCallHelper.a(this.jdField_a_of_type_Gvl.a).endFakeDrag();
        this.jdField_a_of_type_Gvl.a.d = false;
        return;
      }
    }
    catch (Exception localException1) {}
    try
    {
      RecentCallHelper.a(this.jdField_a_of_type_Gvl.a).endFakeDrag();
      label118:
      this.jdField_a_of_type_Gvl.a.d = false;
      return;
      RecentCallHelper.a(this.jdField_a_of_type_Gvl.a).endFakeDrag();
      this.jdField_a_of_type_Gvl.a.d = false;
      return;
    }
    catch (Exception localException2)
    {
      break label118;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvn
 * JD-Core Version:    0.7.0.1
 */