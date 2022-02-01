import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.dating.DatingStranger;
import com.tencent.mobileqq.dating.DetailHost;
import com.tencent.mobileqq.dating.DetailModel;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iav
  extends DatingObserver
{
  public iav(DatingDetailActivity paramDatingDetailActivity) {}
  
  protected void a(String paramString)
  {
    this.a.runOnUiThread(new ibb(this, paramString));
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!Utils.a(this.a.i, paramString1)) {}
    label188:
    label195:
    label245:
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel instanceof DetailHost)) {}
      for (paramString1 = (DetailHost)this.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel;; paramString1 = null)
      {
        if ((paramString1 == null) || (paramString1.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger == null) || (paramLong1 != paramString1.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.jdField_a_of_type_Long)) {
          break label245;
        }
        paramString1.jdField_a_of_type_Long = paramLong2;
        paramString1.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        int i = 0;
        if (paramInt == 1)
        {
          i = 2;
          if (paramBoolean) {
            break label195;
          }
          if (i != 6) {
            break;
          }
          paramArrayOfByte = paramString2;
          if (TextUtils.isEmpty(paramString2))
          {
            paramArrayOfByte = this.a.getString(2131369805);
            if (paramString1.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.b != 1) {
              break label188;
            }
          }
        }
        for (paramString1 = "她";; paramString1 = "他")
        {
          paramArrayOfByte = String.format(paramArrayOfByte, new Object[] { paramString1 });
          a(paramArrayOfByte);
          return;
          if (paramInt == 2)
          {
            i = 6;
            break;
          }
          if (paramInt != 0) {
            break;
          }
          i = 7;
          break;
        }
        this.a.e();
        paramString1 = Message.obtain();
        paramString1.what = 2;
        paramString1.arg1 = i;
        paramString1.obj = paramArrayOfByte;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, DatingInfo paramDatingInfo, byte[] paramArrayOfByte, String paramString2)
  {
    if (!Utils.a(this.a.i, paramString1)) {}
    while ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    int i;
    if (paramInt == 0)
    {
      i = 3;
      if (paramBoolean) {
        break label85;
      }
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        if (paramInt != 0) {
          break label72;
        }
      }
    }
    label72:
    for (paramString1 = this.a.getString(2131369796);; paramString1 = this.a.getString(2131369799))
    {
      a(paramString1);
      return;
      i = 4;
      break;
    }
    label85:
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel != null) && (paramArrayOfByte != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a.detailSigC2C = paramArrayOfByte;
    }
    paramString1 = Message.obtain();
    paramString1.what = 2;
    paramString1.arg1 = i;
    paramString1.obj = paramDatingInfo;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
  }
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList, List paramList, String paramString)
  {
    Object localObject = null;
    if (paramInt != 0) {}
    for (;;)
    {
      return;
      if ((paramArrayList == null) || (paramArrayList.size() < 1)) {}
      for (paramArrayList = null; Utils.a(this.a.i, paramArrayList); paramArrayList = (String)paramArrayList.get(0))
      {
        if (paramBoolean) {
          break label79;
        }
        paramArrayList = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramArrayList = this.a.getString(2131369802);
        }
        a(paramArrayList);
        return;
      }
    }
    label79:
    paramArrayList = localObject;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      do
      {
        paramArrayList = localObject;
        if (!paramList.hasNext()) {
          break;
        }
        paramArrayList = (DatingInfo)paramList.next();
      } while ((paramArrayList == null) || (!this.a.i.equals(paramArrayList.datingId)));
    }
    paramList = Message.obtain();
    paramList.what = 2;
    paramList.arg1 = 5;
    paramList.obj = paramArrayList;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, DatingInfo paramDatingInfo, String paramString3)
  {
    if (!Utils.a(this.a.i, paramString1)) {
      return;
    }
    paramString1 = this.a;
    paramString1.z &= 0xFFFFFFFD;
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    this.a.runOnUiThread(new iba(this, paramBoolean, paramDatingInfo, paramString2, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString, DatingInfo paramDatingInfo, int paramInt)
  {
    if (!Utils.a(this.a.i, paramString)) {
      return;
    }
    this.a.runOnUiThread(new iaw(this, paramBoolean, paramDatingInfo, paramInt));
    this.a.c = false;
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
  }
  
  public void a(boolean paramBoolean, String paramString1, DatingInfo paramDatingInfo, String paramString2, int paramInt)
  {
    if (!Utils.a(this.a.i, paramString1)) {
      return;
    }
    this.a.runOnUiThread(new iay(this, paramBoolean, paramDatingInfo, paramInt, paramString2));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (!Utils.a(this.a.i, paramString1)) {
      return;
    }
    this.a.runOnUiThread(new iaz(this, paramBoolean, paramString2, paramString3));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt1, int paramInt2, DatingInfo paramDatingInfo)
  {
    if (!Utils.a(this.a.i, paramString)) {
      return;
    }
    if (paramBoolean2)
    {
      paramString = this.a;
      paramString.z &= 0xFFFFFFFE;
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    }
    for (;;)
    {
      this.a.runOnUiThread(new iax(this, paramBoolean2, paramBoolean1, paramDatingInfo, paramInt2, paramInt1));
      return;
      paramString = this.a;
      paramString.z &= 0xFFFFFFFB;
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iav
 * JD-Core Version:    0.7.0.1
 */