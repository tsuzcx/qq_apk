import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class lrt
{
  public static final int a = 1;
  private static ArrayList a = new ArrayList(5);
  public static final int b = 2;
  private static final int g = 5;
  public int c;
  public int d;
  public int e;
  public int f;
  
  private static lrt a()
  {
    synchronized (a)
    {
      if (a.size() > 0)
      {
        locallrt = (lrt)a.remove(0);
        locallrt.b();
        return locallrt;
      }
      lrt locallrt = new lrt();
      return locallrt;
    }
  }
  
  public static lrt a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static lrt a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static lrt a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    lrt locallrt = a();
    locallrt.f = paramInt1;
    locallrt.c = paramInt2;
    locallrt.d = paramInt3;
    locallrt.e = paramInt4;
    return locallrt;
  }
  
  public static lrt a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    lrt locallrt = a();
    locallrt.c = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      locallrt.f = 1;
      locallrt.d = ExpandableListView.d(paramLong);
      return locallrt;
    }
    locallrt.f = 2;
    return locallrt;
  }
  
  private void b()
  {
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
  }
  
  public long a()
  {
    if (this.f == 1) {
      return ExpandableListView.b(this.c, this.d);
    }
    return ExpandableListView.c(this.c);
  }
  
  public void a()
  {
    synchronized (a)
    {
      if (a.size() < 5) {
        a.add(this);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lrt
 * JD-Core Version:    0.7.0.1
 */