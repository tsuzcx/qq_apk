import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import java.util.List;

public class law
  extends Handler
{
  public law(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3: 
        paramMessage = (GetAppInfoProto.GetAppinfoResponse)paramMessage.obj;
      }
    } while (!paramMessage.iconsURL.has());
    int i = 0;
    int j = 0;
    int m = 0;
    label58:
    GetAppInfoProto.MsgIconsurl localMsgIconsurl;
    if (i < paramMessage.iconsURL.get().size()) {
      localMsgIconsurl = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
    }
    for (;;)
    {
      try
      {
        k = Integer.parseInt(localMsgIconsurl.size.get());
        if (k >= 100)
        {
          paramMessage = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
          if (paramMessage == null) {
            break;
          }
          ThreadManager.a(new lax(this, paramMessage));
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int k = 0;
        continue;
        int n = m;
        if (k > m)
        {
          j = i;
          n = k;
        }
        i += 1;
        m = n;
      }
      break label58;
      paramMessage = (Bitmap)paramMessage.obj;
      Bitmap localBitmap = AuthorityUtil.a(this.a, paramMessage, 50, 50);
      paramMessage.recycle();
      if (localBitmap == null) {
        break;
      }
      this.a.b.setImageBitmap(localBitmap);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     law
 * JD-Core Version:    0.7.0.1
 */