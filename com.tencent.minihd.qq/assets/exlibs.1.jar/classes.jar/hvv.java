import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.TaskHttpDownload;

public class hvv
  implements Runnable
{
  public hvv(WordMatchManager paramWordMatchManager, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 2) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a, 1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.e)
        {
          ThreadManager.a(new WordMatchManager.TaskHttpDownload(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager, 3));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(true);
        return;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.e)
        {
          ThreadManager.a(new WordMatchManager.TaskHttpDownload(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager, 4));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(true);
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hvv
 * JD-Core Version:    0.7.0.1
 */