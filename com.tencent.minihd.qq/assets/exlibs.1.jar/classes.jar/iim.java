import android.os.Message;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendConstants;
import com.tencent.mobileqq.facetoface.Face2FaceUserData;
import com.tencent.mobileqq.facetoface.NearbyUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class iim
  extends LBSObserver
{
  public iim(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  protected void a(NearbyUser paramNearbyUser, boolean paramBoolean, int paramInt)
  {
    super.a(paramNearbyUser, paramBoolean, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserPush, pushTime=" + paramInt + "from_type=" + this.a.jdField_b_of_type_Int);
    }
    if (paramNearbyUser == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserPush, nearbyUser=null!!");
      }
      if ((this.a.jdField_b_of_type_Int == 0) && (paramNearbyUser != null) && (!this.a.a(paramNearbyUser, this.a.jdField_a_of_type_JavaUtilList)))
      {
        this.a.jdField_a_of_type_JavaUtilList.add(paramNearbyUser);
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserPush, mhasShowList=" + this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "mNeedShowList.size()" + this.a.d.size());
        }
        if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != this.a.d.size()) {
          break label267;
        }
        Face2FaceAddFriendActivity.a(this.a, paramNearbyUser);
      }
    }
    for (;;)
    {
      paramNearbyUser = this.a;
      paramNearbyUser.D += 1;
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserPush, nearbyUser=" + paramNearbyUser.e);
      break;
      label267:
      Message localMessage = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      localMessage.what = 10;
      localMessage.obj = paramNearbyUser;
      Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(10, this.a.a());
    }
  }
  
  protected void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2)
  {
    super.a(paramBoolean, paramList, paramInt1, paramInt2);
    if (paramBoolean)
    {
      this.a.y = 1;
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserList heartBeatTime=" + paramInt2 + "from_type=" + this.a.jdField_b_of_type_Int + "reqInterval=" + paramInt1 + "好友列表返回isSuccess=" + paramBoolean);
      }
      if (paramList == null) {
        break label241;
      }
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserList size=" + paramList.size());
      }
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 2;
      }
      long l = System.currentTimeMillis() - Face2FaceAddFriendConstants.c;
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserList interval=" + l + "leaveFaceTofaceTime=" + Face2FaceAddFriendConstants.c);
      }
      if ((l > i * 1000) || (Face2FaceAddFriendConstants.c == 0L)) {
        break label259;
      }
      Face2FaceAddFriendActivity.a(this.a, i * 1000 - l);
      return;
      this.a.y = 2;
      break;
      label241:
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetFaceToFaceNearbyUserList is null");
      }
    }
    label259:
    if (paramInt2 > 0) {
      Face2FaceAddFriendActivity.B = paramInt2 * 1000;
    }
    if (!this.a.jdField_b_of_type_Boolean) {
      Face2FaceAddFriendActivity.c(this.a);
    }
    this.a.jdField_b_of_type_Boolean = true;
    if ((this.a.jdField_b_of_type_Int == 0) && (paramList != null) && (paramList.size() > 0)) {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      Face2FaceUserData localFace2FaceUserData;
      if (paramList.hasNext())
      {
        localFace2FaceUserData = (Face2FaceUserData)paramList.next();
        if (!this.a.jdField_a_of_type_JavaUtilList.contains(localFace2FaceUserData)) {}
      }
      else
      {
        Face2FaceAddFriendActivity.d(this.a);
        return;
      }
      this.a.jdField_a_of_type_JavaUtilList.add(localFace2FaceUserData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iim
 * JD-Core Version:    0.7.0.1
 */