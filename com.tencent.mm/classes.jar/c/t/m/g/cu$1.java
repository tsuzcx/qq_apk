package c.t.m.g;

import java.io.File;

public final class cu$1
  implements Runnable
{
  public cu$1(cu paramcu) {}
  
  public final void run()
  {
    try
    {
      File localFile = new File(this.a.a);
      if ((!localFile.exists()) || (!localFile.isFile()) || (this.a.b == null)) {
        return;
      }
      if (this.a.b.length() == 0) {
        return;
      }
      byte[] arrayOfByte = j.a(localFile);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        j.a(this.a.b, arrayOfByte, new cx()
        {
          public final void a()
          {
            cu.1.this.delete();
            cq.a("DCUpload", "upload " + cu.1.this.getName() + " succeed.");
          }
          
          public final void a(String paramAnonymousString)
          {
            cq.b("DCUpload", "upload error," + paramAnonymousString);
          }
        }, 0);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      cq.a("DCUpload", "upload error", localThrowable);
      return;
    }
    localThrowable.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.cu.1
 * JD-Core Version:    0.7.0.1
 */