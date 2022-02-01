import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.widget.Gallery;

class ecg
  implements Runnable
{
  ecg(ecf paramecf) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Int != this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b()) {
      this.a.a.jdField_a_of_type_Int = this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b();
    }
    View localView;
    do
    {
      return;
      localView = this.a.a.jdField_a_of_type_ComTencentWidgetGallery.a();
    } while (localView == null);
    this.a.a.jdField_a_of_type_AndroidViewView = localView;
    this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
    this.a.a.a(this.a.a.jdField_a_of_type_ComTencentWidgetGallery, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ecg
 * JD-Core Version:    0.7.0.1
 */