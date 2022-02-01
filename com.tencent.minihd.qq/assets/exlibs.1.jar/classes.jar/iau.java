import android.os.Handler;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingDetailActivity;

class iau
  implements Runnable
{
  iau(iat paramiat, DatingInfo paramDatingInfo) {}
  
  public void run()
  {
    int i = 2;
    int j = 1;
    if ((!this.jdField_a_of_type_Iat.a.g) && (!this.jdField_a_of_type_Iat.a.c))
    {
      this.jdField_a_of_type_Iat.a.a(2, this.jdField_a_of_type_Iat.a.getString(2131369808), 0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo != null) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_Iat.a.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo, i);
      }
      return;
      i = 1;
      continue;
      if ((!this.jdField_a_of_type_Iat.a.g) && (this.jdField_a_of_type_Iat.a.c))
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo == null)
        {
          this.jdField_a_of_type_Iat.a.a.sendEmptyMessageDelayed(9, 400L);
          i = -1;
        }
      }
      else
      {
        i = j;
        if (!this.jdField_a_of_type_Iat.a.g) {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iau
 * JD-Core Version:    0.7.0.1
 */