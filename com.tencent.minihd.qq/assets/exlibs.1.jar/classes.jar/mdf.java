import java.io.File;

public final class mdf
  extends Thread
{
  public mdf(String paramString) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.a);
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdf
 * JD-Core Version:    0.7.0.1
 */