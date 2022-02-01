import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;

class kmx
  implements Runnable
{
  kmx(kmw paramkmw, TroopUploadingThread.UploadState paramUploadState) {}
  
  public void run()
  {
    AvatarWallAdapter.m = 0;
    this.jdField_a_of_type_Kmw.a.n = 0;
    int i = this.jdField_a_of_type_Kmw.a.b - this.jdField_a_of_type_Kmw.a.j;
    if (i >= 8) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 1) {
            break;
          }
          this.jdField_a_of_type_Kmw.a.a(i, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.c);
        } while (this.jdField_a_of_type_Kmw.a.a(this.jdField_a_of_type_Kmw.a.g));
        this.jdField_a_of_type_Kmw.a.d = false;
        this.jdField_a_of_type_Kmw.a.b();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 2);
      str = this.jdField_a_of_type_Kmw.a.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.b);
    } while (str == null);
    this.jdField_a_of_type_Kmw.a.a(str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kmx
 * JD-Core Version:    0.7.0.1
 */