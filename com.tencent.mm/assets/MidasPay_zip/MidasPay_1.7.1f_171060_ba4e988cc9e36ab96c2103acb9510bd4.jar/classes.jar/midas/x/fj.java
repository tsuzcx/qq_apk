package midas.x;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.io.PrintStream;
import java.util.List;

public class fj
  extends ContentObserver
{
  Handler a;
  private ContentResolver b;
  
  public fj(ContentResolver paramContentResolver, Handler paramHandler)
  {
    super(paramHandler);
    this.b = paramContentResolver;
    this.a = paramHandler;
  }
  
  public void onChange(boolean paramBoolean)
  {
    List localList = fu.a(Uri.parse("content://sms/inbox"), this.b);
    if (localList.size() > 0)
    {
      Message localMessage = this.a.obtainMessage();
      localMessage.obj = ((fl)localList.get(0)).a;
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time=");
      localStringBuilder.append(((fl)localList.get(0)).c);
      localPrintStream.println(localStringBuilder.toString());
      this.a.sendMessage(localMessage);
    }
    super.onChange(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fj
 * JD-Core Version:    0.7.0.1
 */