import android.text.TextUtils;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class iho
  implements Runnable
{
  public iho(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, NearFieldTroopHandler paramNearFieldTroopHandler) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b == 1) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.e)) {}
    }
    do
    {
      long l;
      do
      {
        return;
        l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.e).longValue();
      } while (this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopHandler.a(l, 1));
      Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.z = 2;
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopHandler.a(0L, 1))
      {
        Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.z = 2;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.app.a(), false));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.y = 2;
    Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iho
 * JD-Core Version:    0.7.0.1
 */