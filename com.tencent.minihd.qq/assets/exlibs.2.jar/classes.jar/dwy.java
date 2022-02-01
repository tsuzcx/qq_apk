import android.os.Handler;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;

public class dwy
  extends CardObserver
{
  public dwy(EditTagActivity paramEditTagActivity) {}
  
  protected void onTagsUpdate(boolean paramBoolean, Card paramCard)
  {
    if (paramBoolean) {
      this.a.d(2131367496);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      return;
      this.a.d(2131367497);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dwy
 * JD-Core Version:    0.7.0.1
 */