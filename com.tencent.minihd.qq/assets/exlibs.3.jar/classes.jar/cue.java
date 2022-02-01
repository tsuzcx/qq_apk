import android.text.TextUtils;

public class cue
  extends cud
{
  private cue()
  {
    super(null);
  }
  
  public String b(String paramString)
  {
    paramString = super.b(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf('#');
    } while (i <= 0);
    return paramString.substring(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cue
 * JD-Core Version:    0.7.0.1
 */