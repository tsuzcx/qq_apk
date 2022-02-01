package com.tencent.mobileqq.activity.widget.qqmusic.business.vkey;

public class VkeyPair
{
  public static final String a = "vkey";
  public static final String b = "guid";
  public static final String c = ",_,";
  private String d;
  private String e;
  private String f;
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramString1 != null)
    {
      localObject1 = localObject2;
      if (paramString1.contains(",_,"))
      {
        localObject1 = localObject2;
        if (paramString2 != null)
        {
          i = paramString1.indexOf(",_,");
          if (!"vkey".equals(paramString2)) {
            break label54;
          }
          localObject1 = paramString1.substring(0, i);
        }
      }
    }
    label54:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (!"guid".equals(paramString2));
    return paramString1.substring(",_,".length() + i, paramString1.length());
  }
  
  public String a()
  {
    return this.f;
  }
  
  public void a()
  {
    this.d = null;
    this.e = null;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean a()
  {
    return (this.d != null) && (this.e != null);
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public String toString()
  {
    if (a()) {
      return this.d + ",_," + this.e;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.VkeyPair
 * JD-Core Version:    0.7.0.1
 */