import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.util.FaceDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class jsz
  extends SignatureObserver
{
  public jsz(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    int i;
    long l;
    if ((this.a.isResume()) && (paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
    {
      paramObject = (Bundle)paramObject;
      i = paramObject.getInt("unReadNum");
      l = paramObject.getLong("lastUin");
      if ((i != 0) && (0L != l)) {}
    }
    else
    {
      return;
    }
    paramObject = (LinearLayout)this.a.findViewById(2131302226);
    TextView localTextView = (TextView)this.a.findViewById(2131302228);
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.a.app, 1, l + "");
    if (localFaceDrawable != null) {
      ((ImageView)this.a.findViewById(2131302227)).setImageDrawable(localFaceDrawable);
    }
    localTextView.setText(i + " 条新消息");
    paramObject.setVisibility(0);
  }
  
  protected void d(boolean paramBoolean, Object arg2)
  {
    int i = 0;
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      ??? = (Bundle)???;
      paramBoolean = ???.getBoolean("firstFlag", false);
      localObject1 = ???.getString("feedid");
      boolean bool = ???.getBoolean("overFlag", true);
      localObject3 = ???.getStringArrayList("uins");
      StatusHistoryActivity.a(this.a).put(localObject1, Boolean.valueOf(bool));
      ??? = (ArrayList)StatusHistoryActivity.b(this.a).get(localObject1);
      if (localObject3 != null) {}
    }
    else
    {
      return;
    }
    StatusHistoryActivity.b(this.a).put(localObject1, ???);
    for (;;)
    {
      RichStatus localRichStatus;
      synchronized (StatusHistoryActivity.a(this.a))
      {
        if (i >= StatusHistoryActivity.a(this.a).size()) {
          break label243;
        }
        localRichStatus = (RichStatus)StatusHistoryActivity.a(this.a).get(i);
        if (!localRichStatus.f.equals(localObject1)) {
          break label296;
        }
        if (paramBoolean) {
          localRichStatus.a = null;
        }
        if (localRichStatus.a != null)
        {
          localObject1 = ((ArrayList)localObject3).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label243;
          }
          localObject3 = (String)((Iterator)localObject1).next();
          if (localRichStatus.a.contains(localObject3)) {
            continue;
          }
          localRichStatus.a.add(localObject3);
        }
      }
      localRichStatus.a = ((List)localObject3);
      label243:
      if (this.a.a != null)
      {
        this.a.a.removeMessages(1);
        Message localMessage = this.a.a.obtainMessage(1);
        this.a.a.sendMessageDelayed(localMessage, 500L);
      }
      return;
      label296:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsz
 * JD-Core Version:    0.7.0.1
 */