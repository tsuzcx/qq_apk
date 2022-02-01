package midas.x;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.io.PrintStream;
import java.util.List;

public class fs
  extends ContentObserver
{
  Handler a;
  private ContentResolver b;
  
  public fs(ContentResolver paramContentResolver, Handler paramHandler)
  {
    super(paramHandler);
    this.b = paramContentResolver;
    this.a = paramHandler;
  }
  
  public void onChange(boolean paramBoolean)
  {
    List localList = ge.a(Uri.parse("content://sms/inbox"), this.b);
    if (localList.size() > 0)
    {
      Message localMessage = this.a.obtainMessage();
      localMessage.obj = ((fu)localList.get(0)).a;
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time=");
      localStringBuilder.append(((fu)localList.get(0)).c);
      localPrintStream.println(localStringBuilder.toString());
      this.a.sendMessage(localMessage);
    }
    super.onChange(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.fs
 * JD-Core Version:    0.7.0.1
 */