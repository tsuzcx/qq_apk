package midas.x;

public final class te
{
  public me a;
  public le b;
  public ne c;
  public int d = -1;
  public pe e;
  
  public static boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }
  
  public pe a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(le paramle)
  {
    this.b = paramle;
  }
  
  public void a(me paramme)
  {
    this.a = paramme;
  }
  
  public void a(ne paramne)
  {
    this.c = paramne;
  }
  
  public void a(pe parampe)
  {
    this.e = parampe;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.te
 * JD-Core Version:    0.7.0.1
 */