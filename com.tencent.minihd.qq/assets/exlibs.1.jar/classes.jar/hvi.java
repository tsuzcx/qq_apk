import android.os.Build.VERSION;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;

public class hvi
{
  final AbstractCollection a;
  
  public hvi(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.a = new ArrayDeque();
      return;
    }
    this.a = new ArrayBlockingQueue(30);
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public Object a()
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      if ((this.a instanceof ArrayDeque)) {
        return ((ArrayDeque)this.a).poll();
      }
    }
    else if ((this.a instanceof ArrayBlockingQueue)) {
      return ((ArrayBlockingQueue)this.a).poll();
    }
    return null;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      if ((this.a instanceof ArrayDeque)) {
        ((ArrayDeque)this.a).offer(paramObject);
      }
    }
    while (!(this.a instanceof ArrayBlockingQueue)) {
      return;
    }
    ((ArrayBlockingQueue)this.a).offer(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hvi
 * JD-Core Version:    0.7.0.1
 */