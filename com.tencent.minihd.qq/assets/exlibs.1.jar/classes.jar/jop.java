import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.qphone.base.util.QLog;

public class jop
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 1000L;
  private long b = 0L;
  
  public jop(VipPhotoViewForSimple paramVipPhotoViewForSimple) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.b) < 1000L) {}
    do
    {
      do
      {
        do
        {
          return;
          this.b = l;
        } while ((paramView == null) || (!(paramView.getTag() instanceof DataTag)));
        paramView = (DataTag)paramView.getTag();
      } while (paramView == null);
      i = paramView.J;
      String str = VipPhotoViewForSimple.a(this.a).a.a;
      switch (i)
      {
      default: 
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.VipPhotoViewForSimple", 2, "View.OnClickListener click type is photo wall view");
      }
      if (VipPhotoViewForSimple.a(this.a))
      {
        this.a.a();
        return;
      }
      paramView = paramView.a;
      if (paramView == null)
      {
        this.a.a();
        return;
      }
    } while (!(paramView instanceof Integer));
    int i = ((Integer)paramView).intValue();
    this.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jop
 * JD-Core Version:    0.7.0.1
 */