package midas.x;

import java.util.ArrayList;

public class go<T>
  implements gs
{
  private ArrayList<T> a;
  private int b;
  
  public go(ArrayList<T> paramArrayList)
  {
    this(paramArrayList, 4);
  }
  
  public go(ArrayList<T> paramArrayList, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.go
 * JD-Core Version:    0.7.0.1
 */