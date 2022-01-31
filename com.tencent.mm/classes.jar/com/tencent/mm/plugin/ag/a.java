package com.tencent.mm.plugin.ag;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends ContentObserver
{
  private boolean edT = false;
  private ContentResolver fiK;
  private boolean fiL = false;
  private boolean fiM = false;
  public String[] fiZ;
  private Context mContext;
  public a.a oiY;
  private long oiZ = 0L;
  
  public a(Context paramContext)
  {
    super(ah.fetchFreeHandler());
    this.mContext = paramContext;
  }
  
  private static String aF(int paramInt, String paramString)
  {
    for (;;)
    {
      int i = paramInt;
      if (paramInt >= paramString.length()) {
        return null;
      }
      while ((i < paramString.length()) && (!Character.isDigit(paramString.charAt(i)))) {
        i += 1;
      }
      paramInt = i + 1;
      while ((paramInt < paramString.length()) && (Character.isDigit(paramString.charAt(paramInt)))) {
        paramInt += 1;
      }
      String str = paramString.substring(i, paramInt);
      y.v("MicroMsg.SmsVerifyObserver", "verify number from sms:" + str);
      if (str.length() == 6) {
        return str;
      }
      paramInt += 1;
    }
  }
  
  public final void onChange(boolean paramBoolean)
  {
    Object localObject = null;
    super.onChange(paramBoolean);
    label422:
    label423:
    label430:
    for (;;)
    {
      int i;
      try
      {
        if ((this.fiL) || (this.edT)) {
          break label422;
        }
        if (this.fiM) {
          return;
        }
        Uri localUri = Uri.parse("content://sms/inbox");
        this.fiK = this.mContext.getContentResolver();
        String str = "( ";
        if (this.fiZ != null)
        {
          i = 0;
          localObject = str;
          if (i < this.fiZ.length)
          {
            if (i == this.fiZ.length - 1)
            {
              localObject = (String)localObject + " body like \"%" + this.fiZ[i] + "%\" ) ";
              break label423;
            }
            localObject = (String)localObject + "body like \"%" + this.fiZ[i] + "%\" or ";
            break label423;
          }
          localObject = (String)localObject + " and date > " + this.oiZ + " ";
          y.v("MicroMsg.SmsVerifyObserver", "sql where:" + (String)localObject);
        }
        if ((localObject == null) || (((String)localObject).equals(""))) {
          break label422;
        }
        localObject = this.fiK.query(localUri, new String[] { "body", "_id", "date" }, (String)localObject, null, "date desc");
        if (localObject == null) {
          break label422;
        }
        i = -1;
        long l1 = 0L;
        if (((Cursor)localObject).moveToNext())
        {
          long l2 = ((Cursor)localObject).getLong(2);
          if (l2 > l1)
          {
            i = ((Cursor)localObject).getPosition();
            l1 = l2;
            break label430;
          }
        }
        else
        {
          if (i >= 0)
          {
            ((Cursor)localObject).moveToPosition(i);
            str = aF(0, ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("body")));
            if ((!bk.bl(str)) && (str.length() == 6))
            {
              if (this.oiY != null) {
                this.oiY.tS(str);
              }
              this.fiM = true;
            }
          }
          ((Cursor)localObject).close();
          return;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.SmsVerifyObserver", localException, "", new Object[0]);
        return;
      }
      break label430;
      return;
      i += 1;
    }
  }
  
  public final void start()
  {
    this.fiL = false;
    this.fiM = false;
    this.edT = false;
    y.i("MicroMsg.SmsVerifyObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a((Activity)this.mContext, "android.permission.READ_SMS", 128, "", "")), bk.csb(), this.mContext });
    for (;;)
    {
      int i;
      try
      {
        Uri localUri = Uri.parse("content://sms/inbox");
        this.fiK = this.mContext.getContentResolver();
        Object localObject = "( ";
        if (this.fiZ != null)
        {
          i = 0;
          if (i < this.fiZ.length)
          {
            if (i == this.fiZ.length - 1)
            {
              localObject = (String)localObject + " body like \"%" + this.fiZ[i] + "%\" ) ";
              break label335;
            }
            localObject = (String)localObject + "body like \"%" + this.fiZ[i] + "%\" or ";
            break label335;
          }
          y.v("MicroMsg.SmsVerifyObserver", "sql where:" + (String)localObject);
          localObject = this.fiK.query(localUri, new String[] { "date" }, (String)localObject, null, "date desc limit 1");
          if ((localObject != null) && (((Cursor)localObject).getCount() > 0))
          {
            ((Cursor)localObject).moveToFirst();
            l = ((Cursor)localObject).getLong(0);
            if (localObject != null) {
              ((Cursor)localObject).close();
            }
            this.oiZ = l;
            this.mContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
          }
        }
        else
        {
          localObject = "";
          continue;
        }
        long l = 0L;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.SmsVerifyObserver", localException, "", new Object[0]);
        return;
      }
      continue;
      label335:
      i += 1;
    }
  }
  
  public final void stop()
  {
    if (this.mContext != null) {}
    try
    {
      this.mContext.getContentResolver().unregisterContentObserver(this);
      this.edT = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SmsVerifyObserver", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ag.a
 * JD-Core Version:    0.7.0.1
 */