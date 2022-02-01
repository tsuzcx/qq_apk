import android.content.Intent;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.activity.TroopDisbandActivity.MemberGridAdapter;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class fgp
  extends TroopObserver
{
  public fgp(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if (paramInt == 9)
    {
      Object localObject = this.a;
      ((TroopDisbandActivity)localObject).jdField_d_of_type_Int &= 0xFFFFFFFE;
      if (paramByte == 8)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
        }
        localObject = DialogUtil.a(this.a, 230);
        ((QQCustomDialog)localObject).setTitle(this.a.getString(2131363965));
        ((QQCustomDialog)localObject).setMessage(this.a.getString(2131363966));
        ((QQCustomDialog)localObject).setNegativeButton(this.a.getString(2131363963), new fgq(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).setPositiveButton(this.a.getString(2131367782), new fgr(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).show();
      }
    }
    else
    {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131367799, 1500);
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (!Utils.a(paramString, this.a.b)) {}
    while (paramInt != 9) {
      return;
    }
    paramString = this.a;
    paramString.jdField_d_of_type_Int &= 0xFFFFFFFE;
    if (paramByte == 0)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      }
      paramString = new Intent();
      paramString.putExtra("isNeedFinish", true);
      paramString.putExtra("fin_tip_msg", this.a.getString(2131367798));
      this.a.setResult(-1, paramString);
      this.a.finish();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131367799, 1500);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.b)) {}
    Object localObject;
    label132:
    label190:
    label320:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder(150);
          ((StringBuilder)localObject).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
          QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
        }
        switch (paramInt1)
        {
        default: 
          return;
        case 4: 
          if (paramBoolean)
          {
            if (paramList == null)
            {
              paramInt1 = 0;
              paramInt2 = 0;
              if (paramInt2 >= paramInt1) {
                break label320;
              }
              paramString = (oidb_0x899.memberlist)paramList.get(paramInt2);
              if ((paramString != null) && (paramString.uint64_member_uin.has())) {
                break label190;
              }
            }
            do
            {
              paramInt2 += 1;
              break label132;
              paramInt1 = paramList.size();
              break;
              localObject = String.valueOf(paramString.uint64_member_uin.get());
            } while ((this.a.jdField_a_of_type_JavaUtilArrayList.contains(localObject)) || (localObject == null) || ("".equals(((String)localObject).trim())) || (Utils.a(this.a.e, localObject)));
            if (paramString.uint32_uin_flag.has()) {}
            for (int i = paramString.uint32_uin_flag.get();; i = 0)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.add((String)localObject + "|" + String.valueOf(i));
              break;
            }
          }
          if (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break label564;
          }
          paramList = (TroopHandler)this.a.app.a(19);
          if ((paramList == null) || (!paramBoolean) || (paramLong2 <= 0L) || (this.a.jdField_a_of_type_Long != 0L)) {
            break label419;
          }
          this.a.jdField_a_of_type_Long = paramLong2;
          paramList.a(paramLong1, this.a.jdField_a_of_type_Long, 4, null, 0, 0);
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.troopdisband.", 2, "handle_oidb_0x899_0|need get another package");
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      }
      paramList = this.a;
      paramList.jdField_d_of_type_Int &= 0xFFFFFFFD;
      paramList = new Intent(this.a, TroopTransferActivity.class);
      paramList.putExtra("leftViewText", this.a.getString(2131367052));
      paramList.putStringArrayListExtra("troopVipMembers", this.a.jdField_a_of_type_JavaUtilArrayList);
      paramList.putExtra("troop_uin", this.a.b);
      paramList.putExtra("troop_code", this.a.jdField_d_of_type_JavaLangString);
      paramList.putExtra("uinname", this.a.c);
      this.a.startActivityForResult(paramList, 0);
      return;
      if (paramBoolean)
      {
        paramList = this.a;
        paramList.jdField_d_of_type_Int &= 0xFFFFFFFD;
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131367722, 1500);
        return;
      }
      paramList = this.a;
      paramList.jdField_d_of_type_Int &= 0xFFFFFFFD;
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131367726, 1500);
      return;
    } while (!paramBoolean);
    label419:
    label564:
    if (paramList == null)
    {
      paramInt1 = 0;
      if ((paramInt1 > 0) && (paramInt1 < 6))
      {
        paramString = (FriendManager)this.a.app.getManager(8);
        localObject = this.a;
        if (paramString != null) {
          break label842;
        }
      }
    }
    label842:
    for (paramString = null;; paramString = paramString.a(this.a.b))
    {
      ((TroopDisbandActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum != paramInt1)) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum = paramList.size();
      }
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, false);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$MemberGridAdapter.b(paramList);
      return;
      paramInt1 = paramList.size();
      break;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.disband", 2, "onGetTroopInfoResult, isSuc=" + paramBoolean + ", groupUin : " + paramString);
    }
    TroopDisbandActivity localTroopDisbandActivity;
    if ((paramBoolean) && (Utils.a(paramString, this.a.b)))
    {
      paramString = (FriendManager)this.a.app.getManager(8);
      localTroopDisbandActivity = this.a;
      if (paramString != null) {
        break label108;
      }
    }
    label108:
    for (paramString = null;; paramString = paramString.a(this.a.b))
    {
      localTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, false);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    TroopInfo localTroopInfo = null;
    int i = 0;
    label21:
    if ((localTroopInfo == null) && (i < paramArrayList.size()))
    {
      localTroopInfo = (TroopInfo)paramArrayList.get(i);
      if (localTroopInfo != null) {
        break label56;
      }
    }
    label56:
    while (!Utils.a(localTroopInfo.troopuin, this.a.b))
    {
      i += 1;
      break label21;
      break;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
    this.a.a(localTroopInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fgp
 * JD-Core Version:    0.7.0.1
 */