import android.widget.TextView;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class iab
  extends DatingObserver
{
  public iab(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public void a(boolean paramBoolean, DatingConfig paramDatingConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "onGetConfig:" + paramBoolean);
    }
    if (paramBoolean) {
      DatingDestinationActivity.f(this.a);
    }
  }
  
  public void a(boolean paramBoolean1, List paramList1, List paramList2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (((paramList1 != null) && (paramList1.size() > 0)) || ((paramList2 != null) && (paramList2.size() > 0)))) {
      if (DatingDestinationActivity.a(this.a) != null)
      {
        if (DatingDestinationActivity.a(this.a) == null)
        {
          DatingDestinationActivity.a(this.a, new iap(this.a));
          DatingDestinationActivity.a(this.a).a(paramList1, paramList2);
          DatingDestinationActivity.a(this.a).setAdapter(DatingDestinationActivity.a(this.a));
        }
      }
      else
      {
        DatingDestinationActivity.a(this.a).setVisibility(8);
        DatingDestinationActivity.a(this.a).setVisibility(0);
        DatingDestinationActivity.a(this.a, DatingDestinationActivity.a(this.a));
        DatingDestinationActivity.b(this.a, paramByteStringMicro);
        DatingDestinationActivity.a(this.a, paramBoolean2);
        DatingDestinationActivity.d(this.a);
      }
    }
    for (;;)
    {
      DatingDestinationActivity.b(this.a, false);
      return;
      DatingDestinationActivity.a(this.a).b(paramList1, paramList2);
      break;
      if (DatingDestinationActivity.c(this.a))
      {
        DatingDestinationActivity.a(this.a).setText(this.a.getString(2131366465));
        DatingDestinationActivity.a(this.a).setVisibility(0);
      }
      else
      {
        DatingDestinationActivity.e(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iab
 * JD-Core Version:    0.7.0.1
 */