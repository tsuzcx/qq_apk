package midas.x;

import java.util.ArrayList;

public class gz<T>
  implements hd
{
  private ArrayList<T> a;
  private int b;
  
  public gz(ArrayList<T> paramArrayList)
  {
    this(paramArrayList, 4);
  }
  
  public gz(ArrayList<T> paramArrayList, int paramInt)
  {
    this.a = paramArrayList;
    this.b = paramInt;
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return this.a.get(paramInt).toString();
    }
    return null;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.gz
 * JD-Core Version:    0.7.0.1
 */