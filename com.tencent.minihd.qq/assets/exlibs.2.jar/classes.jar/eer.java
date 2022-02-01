import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;

public class eer
  extends UniPayHandler.UniPayUpdateListener
{
  public eer(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void update()
  {
    this.a.runOnUiThread(new ees(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eer
 * JD-Core Version:    0.7.0.1
 */