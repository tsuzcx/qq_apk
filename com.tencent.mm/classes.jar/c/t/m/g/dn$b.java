package c.t.m.g;

final class dn$b
  implements Runnable
{
  ea a;
  private dg b;
  
  public dn$b(dg paramdg)
  {
    this.b = paramdg;
  }
  
  public final void run()
  {
    dg localdg = this.b;
    ea localea = this.a;
    if (localea != null)
    {
      localea.a(en.b(localdg));
      localdg.b(localea);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     c.t.m.g.dn.b
 * JD-Core Version:    0.7.0.1
 */