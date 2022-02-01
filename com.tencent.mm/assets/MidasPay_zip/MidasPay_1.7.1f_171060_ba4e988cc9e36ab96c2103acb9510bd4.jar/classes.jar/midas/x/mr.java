package midas.x;

public final class mr
{
  private mk a;
  private mj b;
  private ml c;
  private int d = -1;
  private mn e;
  
  public static boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }
  
  public mn a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(mj parammj)
  {
    this.b = parammj;
  }
  
  public void a(mk parammk)
  {
    this.a = parammk;
  }
  
  public void a(ml paramml)
  {
    this.c = paramml;
  }
  
  public void a(mn parammn)
  {
    this.e = parammn;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("<<\n");
    localStringBuilder.append(" mode: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n ecLevel: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n version: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(this.d);
    if (this.e == null)
    {
      localStringBuilder.append("\n matrix: null\n");
    }
    else
    {
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(this.e);
    }
    localStringBuilder.append(">>\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.mr
 * JD-Core Version:    0.7.0.1
 */