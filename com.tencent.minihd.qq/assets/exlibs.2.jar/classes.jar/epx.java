import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.MessageObserver;

public class epx
  extends MessageObserver
{
  public epx(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString))) {
      this.a.a(paramBoolean, false);
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString))) {
      this.a.a(paramBoolean, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     epx
 * JD-Core Version:    0.7.0.1
 */