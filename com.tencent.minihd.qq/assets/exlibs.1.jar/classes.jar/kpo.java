import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.util.FaceDrawable;

public class kpo
  extends DiscussionObserver
{
  private kpo(FaceDrawable paramFaceDrawable) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean2)
    {
      FaceDrawable.a(this.a, paramBoolean1, 101, paramString, FaceDrawable.a(this.a));
      return;
    }
    FaceDrawable.a(this.a, paramBoolean1, 101, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kpo
 * JD-Core Version:    0.7.0.1
 */