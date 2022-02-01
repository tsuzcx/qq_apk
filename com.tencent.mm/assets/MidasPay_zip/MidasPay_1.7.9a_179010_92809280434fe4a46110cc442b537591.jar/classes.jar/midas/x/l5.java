package midas.x;

import android.text.TextUtils;

public class l5
{
  public m5 a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public l5(m5 paramm5, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramm5;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public boolean a()
  {
    Object localObject2 = this.a;
    if (!((m5)localObject2).d) {
      return true;
    }
    Object localObject1 = ((m5)localObject2).b;
    localObject2 = ((m5)localObject2).c;
    String str = this.c;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(this.e);
      localObject2 = localStringBuilder.toString();
      try
      {
        localObject1 = u5.a(a.r().d, (String)localObject1, (String)localObject2);
        if (localObject1 != null) {
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.l5
 * JD-Core Version:    0.7.0.1
 */