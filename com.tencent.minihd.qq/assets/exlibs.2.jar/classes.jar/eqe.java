import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.CardObserver;

public class eqe
  extends CardObserver
{
  public eqe(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  protected void onCardLabelUpdate(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.setResult(-1);
      this.a.b(2131367496);
    }
    for (;;)
    {
      this.a.a = false;
      this.a.finish();
      return;
      this.a.b(2131367497);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eqe
 * JD-Core Version:    0.7.0.1
 */