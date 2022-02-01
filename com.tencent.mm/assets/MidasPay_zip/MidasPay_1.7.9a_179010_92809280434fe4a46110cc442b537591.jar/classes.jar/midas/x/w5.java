package midas.x;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.io.PrintStream;
import java.util.List;

public class w5
  extends ContentObserver
{
  public Handler a;
  public ContentResolver b;
  
  public w5(ContentResolver paramContentResolver, Handler paramHandler)
  {
    super(paramHandler);
    this.b = paramContentResolver;
    this.a = paramHandler;
  }
  
  public void onChange(boolean paramBoolean)
  {
    List localList = i6.a(Uri.parse("content://sms/inbox"), this.b);
    if (localList.size() > 0)
    {
      Message localMessage = this.a.obtainMessage();
      localMessage.obj = ((y5)localList.get(0)).a;
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time=");
      localStringBuilder.append(((y5)localList.get(0)).b);
      localPrintStream.println(localStringBuilder.toString());
      this.a.sendMessage(localMessage);
    }
    super.onChange(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.w5
 * JD-Core Version:    0.7.0.1
 */