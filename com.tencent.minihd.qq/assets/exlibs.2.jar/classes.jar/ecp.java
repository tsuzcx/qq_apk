import com.tencent.mobileqq.activity.FriendProfileImageModel.InfoUpdateListener;
import com.tencent.mobileqq.activity.FriendProfileImagePortraits;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.service.lbs.LbsPortraitUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ecp
  extends CardObserver
{
  public ecp(FriendProfileImagePortraits paramFriendProfileImagePortraits) {}
  
  protected void onAddPortrait(boolean paramBoolean, String paramString, int paramInt, Card paramCard)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener.e();
    }
  }
  
  protected void onDeletePortrait(boolean paramBoolean, Card paramCard, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "onDeletePortrait() isSuccess: " + paramBoolean);
    }
    if (!paramCard.uin.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          default: 
            return;
          case 0: 
            paramCard = HexUtil.a(paramArrayOfByte);
            this.a.a(paramCard);
          }
        } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener == null);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener.f();
        return;
        LbsPortraitUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), this.a.b, 0);
      } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener == null);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener.g();
      return;
      LbsPortraitUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), this.a.b, 0);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener == null);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$InfoUpdateListener.f();
  }
  
  protected void onGotPagedAlbumKeys(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong, byte[] paramArrayOfByte)
  {
    if ((!paramBoolean) || (this.a.b == null) || (!this.a.b.equals(paramString))) {
      return;
    }
    this.a.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ecp
 * JD-Core Version:    0.7.0.1
 */