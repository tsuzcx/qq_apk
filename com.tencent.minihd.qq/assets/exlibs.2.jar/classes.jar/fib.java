import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class fib
  extends TroopObserver
{
  public fib(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onTroopManagerFailed, reqtype:" + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 9)) {
      this.a.a(1, this.a.getString(2131367799));
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onTroopManagerSuccess, reqtype:_eResignGroupReq result:" + paramByte + " troopUin:" + paramString);
      }
      if (paramByte == 0) {
        this.a.a(5, 2131367798, 1000);
      }
    }
    while (paramInt != 9)
    {
      return;
      this.a.a(1, this.a.getString(2131367799));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onTroopManagerSuccess, reqtype:_eDeleteGroupReq result:" + paramByte + " troopUin:" + paramString);
    }
    if (paramByte == 0)
    {
      this.a.a(5, 2131367798, 1000);
      return;
    }
    this.a.a(1, this.a.getString(2131367799));
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      this.a.a(2, this.a.getString(2131365829));
      this.a.a(1);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.a.a(1, this.a.getString(2131365830));
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      }
      TroopMemberCardActivity.a(this.a);
      ((TroopGagMgr)this.a.app.getManager(47)).a(this.a.c, this.a.e);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        l = ((Long)paramObject[0]).longValue();
        i = ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(this.a.c))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + this.a.c);
          }
        }
        else if (paramObject == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: cardInfo==null");
        }
      }
    }
    catch (Exception paramObject)
    {
      long l;
      int i;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard:" + paramObject.toString());
        return;
        l = paramObject.memberUin;
        if (l != Long.parseLong(this.a.e))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + this.a.e);
          }
        }
        else {
          this.a.a(i, paramObject);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong)
  {
    if (paramBoolean)
    {
      this.a.a(2, this.a.getString(2131367880));
      this.a.a(0);
    }
    for (;;)
    {
      paramString = this.a.jdField_a_of_type_ArrayOfAndroidViewView[4];
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned = this.a.a(this.a.c, this.a.e);
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield = this.a.b(this.a.c, this.a.e);
      this.a.d();
      return;
      if (paramInt == 4) {
        this.a.a(1, this.a.getString(2131367879));
      } else {
        this.a.a(1, this.a.getString(2131367881));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fib
 * JD-Core Version:    0.7.0.1
 */