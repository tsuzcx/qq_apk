package midas.x;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.pay.ui.qdsafe.APSafeCenterWebActivity;
import com.pay.ui.qdsafe.APSafeCenterX5WebActivity;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class i6
{
  public static long a = ;
  
  public static List<y5> a(Uri paramUri, ContentResolver paramContentResolver)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      String str = String.valueOf(a - 30000L);
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data=");
      localStringBuilder.append(str);
      localPrintStream.println(localStringBuilder.toString());
      paramUri = paramContentResolver.query(paramUri, new String[] { "_id", "address", "person", "body", "date", "type" }, "read=? and date>?", new String[] { "0", str }, "date desc");
      if (paramUri != null)
      {
        int i = paramUri.getColumnIndex("person");
        int j = paramUri.getColumnIndex("address");
        int k = paramUri.getColumnIndex("body");
        int m = paramUri.getColumnIndex("date");
        int n = paramUri.getColumnIndex("type");
        while (paramUri.moveToNext())
        {
          paramContentResolver = new y5();
          paramUri.getString(i);
          paramContentResolver.b = paramUri.getString(m);
          paramUri.getString(j);
          paramContentResolver.a = paramUri.getString(k);
          paramUri.getString(n);
          localArrayList.add(paramContentResolver);
        }
        paramUri.close();
        return localArrayList;
      }
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
    return localArrayList;
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2)
  {
    Intent localIntent;
    if (h8.d(paramActivity)) {
      localIntent = new Intent(paramActivity, APSafeCenterX5WebActivity.class);
    } else {
      localIntent = new Intent(paramActivity, APSafeCenterWebActivity.class);
    }
    localIntent.putExtra("isOnlyMethod", false);
    localIntent.putExtra("requesturl", paramString1);
    localIntent.putExtra("count", paramInt);
    localIntent.putExtra("smsinfo", paramString2);
    paramActivity.startActivityForResult(localIntent, 100002);
  }
  
  public static enum a
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.i6
 * JD-Core Version:    0.7.0.1
 */