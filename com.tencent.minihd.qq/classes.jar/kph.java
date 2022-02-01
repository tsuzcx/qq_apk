import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class kph
  extends WeakReference
{
  private final String a;
  
  public kph(String paramString, Object paramObject, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject, paramReferenceQueue);
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     kph
 * JD-Core Version:    0.7.0.1
 */