package midas.x;

public final class oc
{
  private nv a;
  private nu b;
  private nw c;
  private int d = -1;
  private ny e;
  
  public static boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }
  
  public ny a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(nu paramnu)
  {
    this.b = paramnu;
  }
  
  public void a(nv paramnv)
  {
    this.a = paramnv;
  }
  
  public void a(nw paramnw)
  {
    this.c = paramnw;
  }
  
  public void a(ny paramny)
  {
    this.e = paramny;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.oc
 * JD-Core Version:    0.7.0.1
 */