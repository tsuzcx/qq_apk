import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;

public class dpd
  extends QvipSpecialCareObserver
{
  public dpd(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onSpecialSoundEvent(Object paramObject)
  {
    if (paramObject != null) {
      ((Integer)paramObject).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpd
 * JD-Core Version:    0.7.0.1
 */