package midas.x;

public class sb
  extends jb
{
  public zb a;
  
  public sb(zb paramzb)
  {
    this.a = paramzb;
  }
  
  public void a(fb paramfb, gb paramgb)
  {
    super.a(paramfb, paramgb);
    if (paramfb == null) {
      return;
    }
    if (paramgb == null) {
      return;
    }
    zb localzb = this.a;
    if (localzb == null) {
      return;
    }
    if (!(paramfb instanceof qb)) {
      return;
    }
    paramgb.a(new rb(localzb.b(), paramgb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.sb
 * JD-Core Version:    0.7.0.1
 */