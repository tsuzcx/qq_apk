package midas.x;

import android.text.TextUtils;

public class ez
{
  public fa a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public ez(fa paramfa, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramfa;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
  }
  
  public boolean a()
  {
    if (!this.a.e) {
      return true;
    }
    Object localObject = this.a.c;
    String str1 = this.a.d;
    String str2 = this.d;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (TextUtils.isEmpty(str2)) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(".");
      localStringBuilder.append(str2);
      localStringBuilder.append(".");
      localStringBuilder.append(this.f);
      str1 = localStringBuilder.toString();
      try
      {
        localObject = fh.a(a.a().d, (String)localObject, str1);
        if (localObject != null) {
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ez
 * JD-Core Version:    0.7.0.1
 */