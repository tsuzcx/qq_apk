import com.tencent.component.network.downloader.a;

public class cud
  extends a
{
  public String b(String paramString)
  {
    String str = null;
    int i;
    if (a.a(paramString, "http://")) {
      i = paramString.indexOf("/", "http://".length());
    }
    for (;;)
    {
      if (i != -1) {
        str = paramString.substring(i);
      }
      return str;
      if (a.a(paramString, "https://")) {
        i = paramString.indexOf("/", "https://".length());
      } else {
        i = paramString.indexOf("/");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cud
 * JD-Core Version:    0.7.0.1
 */