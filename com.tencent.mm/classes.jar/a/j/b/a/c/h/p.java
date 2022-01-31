package a.j.b.a.c.h;

public enum p
{
  static
  {
    p.b localb = new p.b("PLAIN");
    Cvv = localb;
    p.a locala = new p.a("HTML");
    Cvw = locala;
    Cvx = new p[] { localb, locala };
  }
  
  protected p() {}
  
  public abstract String escape(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.h.p
 * JD-Core Version:    0.7.0.1
 */