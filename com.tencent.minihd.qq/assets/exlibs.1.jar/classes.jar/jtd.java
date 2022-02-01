import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class jtd
  extends StatusObserver
{
  private jtd(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList paramArrayList, boolean paramBoolean3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onGetHistory.issuccess=").append(paramBoolean1).append(",start=").append(paramInt1).append(",end=").append(paramInt2).append(",over=").append(paramBoolean2).append(",datasize=");
      if (paramArrayList != null) {
        break label308;
      }
    }
    label308:
    for (int i = 0;; i = paramArrayList.size())
    {
      QLog.d("Q.richstatus.history", 2, i + ",isaddfromcard=" + paramBoolean3);
      StatusHistoryActivity.a(this.a, paramBoolean1);
      if (!paramBoolean1) {
        break label461;
      }
      StatusHistoryActivity.a(this.a, false);
      if ((paramBoolean3) && (paramArrayList != null) && (paramArrayList.size() == 1)) {
        StatusHistoryActivity.a(this.a, true);
      }
      this.a.app.c(true, true);
      if (paramInt1 != 0) {
        break label361;
      }
      if ((paramInt2 == 2147483647) && (StatusHistoryActivity.a(this.a).size() > 0)) {
        StatusHistoryActivity.a(this.a).clear();
      }
      if (StatusHistoryActivity.a(this.a).size() <= 0) {
        break;
      }
      localObject = paramArrayList.iterator();
      RichStatus localRichStatus1 = (RichStatus)StatusHistoryActivity.a(this.a).get(StatusHistoryActivity.a(this.a).size() - 1);
      while (((Iterator)localObject).hasNext())
      {
        RichStatus localRichStatus2 = (RichStatus)((Iterator)localObject).next();
        if ((localRichStatus2.jdField_a_of_type_Long <= localRichStatus1.jdField_a_of_type_Long) && ((localRichStatus2.jdField_a_of_type_Long != localRichStatus1.jdField_a_of_type_Long) || (!Arrays.equals(localRichStatus2.a(), localRichStatus1.a())))) {
          break;
        }
        ((Iterator)localObject).remove();
      }
    }
    StatusHistoryActivity.a(this.a).addAll(StatusHistoryActivity.a(this.a).size(), paramArrayList);
    paramArrayList = this.a;
    if (!paramBoolean2)
    {
      paramInt1 = 1;
      StatusHistoryActivity.a(paramArrayList, paramInt1);
      label361:
      if (this.a.b)
      {
        if (this.a.a()) {
          this.a.a(StatusHistoryActivity.a(this.a));
        }
        this.a.b = false;
      }
      if (StatusHistoryActivity.a(this.a).size() != 0) {
        break label482;
      }
      paramArrayList = this.a;
      if (!paramBoolean1) {
        break label477;
      }
      paramInt1 = 3;
      label428:
      StatusHistoryActivity.a(paramArrayList, paramInt1);
    }
    for (;;)
    {
      StatusHistoryActivity.a(this.a).notifyDataSetChanged();
      this.a.a(true, 1000L);
      return;
      paramInt1 = 0;
      break;
      label461:
      if (paramInt1 != 0) {
        break label361;
      }
      StatusHistoryActivity.a(this.a, 3);
      break label361;
      label477:
      paramInt1 = 2;
      break label428;
      label482:
      StatusHistoryActivity.a(this.a).setVisible(false, false);
      ((RelativeLayout)StatusHistoryActivity.a(this.a).findViewById(2131302206)).setVisibility(0);
    }
  }
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.history", 2, "onDeleteStatus. isSuccess=" + paramBoolean + ",key=" + paramArrayOfByte + ",errorCode=" + paramInt);
    }
    if ((StatusHistoryActivity.a(this.a) != null) && (StatusHistoryActivity.a(this.a).isShowing())) {
      StatusHistoryActivity.a(this.a).dismiss();
    }
    if (paramBoolean) {
      if (paramArrayOfByte != null)
      {
        Iterator localIterator = StatusHistoryActivity.a(this.a).iterator();
        while (localIterator.hasNext())
        {
          RichStatus localRichStatus = (RichStatus)localIterator.next();
          if ((localRichStatus != null) && (Arrays.equals(localRichStatus.jdField_a_of_type_ArrayOfByte, paramArrayOfByte))) {
            localIterator.remove();
          }
        }
        if (StatusHistoryActivity.a(this.a).size() == 0) {
          StatusHistoryActivity.a(this.a, 3);
        }
        if (StatusHistoryActivity.a(this.a) != null)
        {
          StatusHistoryActivity.a(this.a).notifyDataSetChanged();
          this.a.a(true, 1000L);
        }
      }
    }
    for (;;)
    {
      StatusHistoryActivity.a(this.a, null);
      StatusHistoryActivity.b(this.a, false);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2131369280, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jtd
 * JD-Core Version:    0.7.0.1
 */