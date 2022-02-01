import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import protocol.KQQConfig.GetResourceRespInfo;

public class eeq
  extends ConfigObserver
{
  public eeq(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  protected void a(boolean paramBoolean, GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramBoolean) {
      this.a.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eeq
 * JD-Core Version:    0.7.0.1
 */