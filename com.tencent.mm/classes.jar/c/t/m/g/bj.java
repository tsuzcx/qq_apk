package c.t.m.g;

import android.text.TextUtils;

public abstract class bj
{
  private bj.a a;
  
  public bj(String paramString)
  {
    paramString = "halley_schedule_" + m.b() + "_" + m.h() + "_" + paramString + ".db";
    this.a = new bj.a(m.a(), paramString);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null)) {
        this.a.a(paramString, paramArrayOfByte);
      }
      return;
    }
    finally {}
  }
  
  public final byte[] a(String paramString)
  {
    try
    {
      paramString = this.a.a(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.g.bj
 * JD-Core Version:    0.7.0.1
 */