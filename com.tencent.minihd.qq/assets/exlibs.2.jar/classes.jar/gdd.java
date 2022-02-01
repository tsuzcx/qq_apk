import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;

public class gdd
  implements TroopFileError.TroopFileErrorFilter
{
  public String a;
  
  public gdd(String paramString)
  {
    this.a = paramString;
  }
  
  public long a()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdd
 * JD-Core Version:    0.7.0.1
 */