import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class lwn
  extends WeakReference
{
  public Object a;
  
  public lwn(Object paramObject1, Object paramObject2, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject2, paramReferenceQueue);
    this.a = paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lwn
 * JD-Core Version:    0.7.0.1
 */