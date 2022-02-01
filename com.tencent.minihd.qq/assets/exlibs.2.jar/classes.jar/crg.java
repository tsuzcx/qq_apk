import com.tencent.biz.widgets.XChooserActivity;

public class crg
  implements Runnable
{
  public crg(XChooserActivity paramXChooserActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     crg
 * JD-Core Version:    0.7.0.1
 */