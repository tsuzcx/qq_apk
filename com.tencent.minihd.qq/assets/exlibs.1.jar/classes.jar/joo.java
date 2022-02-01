import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class joo
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 1000L;
  private long b = 0L;
  
  public joo(QzonePhotoView paramQzonePhotoView) {}
  
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
          do
          {
            return;
            this.b = l;
          } while ((paramView == null) || (!(paramView.getTag() instanceof DataTag)));
          paramView = (DataTag)paramView.getTag();
        } while (paramView == null);
        i = paramView.J;
        String str = QzonePhotoView.a(this.a).a.a;
        switch (i)
        {
        default: 
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCard.QzonePhotoView", 2, "View.OnClickListener click type is photo wall view");
        }
        if (QzonePhotoView.a(this.a))
        {
          this.a.a();
          return;
        }
      } while ((this.a.a == null) || (this.a.a.size() == 0));
      paramView = paramView.a;
      if (paramView == null)
      {
        this.a.a();
        return;
      }
    } while (!(paramView instanceof Integer));
    int i = ((Integer)paramView).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "mPhotoList size = " + this.a.a.size() + ", pos = " + i);
    }
    this.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     joo
 * JD-Core Version:    0.7.0.1
 */