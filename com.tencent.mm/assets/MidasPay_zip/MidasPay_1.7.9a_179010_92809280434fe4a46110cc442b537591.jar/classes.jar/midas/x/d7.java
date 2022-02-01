package midas.x;

import java.util.ArrayList;

public class d7<T>
  implements h7
{
  public ArrayList<T> a;
  public int b;
  
  public d7(ArrayList<T> paramArrayList)
  {
    this(paramArrayList, 4);
  }
  
  public d7(ArrayList<T> paramArrayList, int paramInt)
  {
    this.a = paramArrayList;
    this.b = paramInt;
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return this.a.get(paramInt).toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.d7
 * JD-Core Version:    0.7.0.1
 */