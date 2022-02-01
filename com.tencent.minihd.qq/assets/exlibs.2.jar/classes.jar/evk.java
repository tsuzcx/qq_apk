import com.tencent.mobileqq.activity.QzoneWrapperActivity;
import com.tencent.mobileqq.observer.QZoneObserver;

public class evk
  extends QZoneObserver
{
  public evk(QzoneWrapperActivity paramQzoneWrapperActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramBoolean1) && (paramBoolean2) && (QzoneWrapperActivity.a(this.a) != null)) {
      QzoneWrapperActivity.a(this.a, QzoneWrapperActivity.a(this.a), this.a.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evk
 * JD-Core Version:    0.7.0.1
 */