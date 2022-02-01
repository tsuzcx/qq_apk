package midas.x;

public class ka
  extends jr
{
  private kf a;
  
  public ka(kf paramkf)
  {
    this.a = paramkf;
  }
  
  public void a(jn paramjn, jo paramjo)
  {
    super.a(paramjn, paramjo);
    if (paramjn == null) {
      return;
    }
    if (paramjo == null) {
      return;
    }
    if (this.a == null) {
      return;
    }
    if (!(paramjn instanceof jy)) {
      return;
    }
    paramjo.a(new jz(this.a.f(), paramjo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ka
 * JD-Core Version:    0.7.0.1
 */