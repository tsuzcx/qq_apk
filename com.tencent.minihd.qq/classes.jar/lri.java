import com.tencent.widget.AdapterView;

public class lri
  implements Runnable
{
  private lri(AdapterView paramAdapterView) {}
  
  public void run()
  {
    if (this.a.q)
    {
      if (this.a.a() != null) {
        this.a.post(this);
      }
      return;
    }
    AdapterView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     lri
 * JD-Core Version:    0.7.0.1
 */