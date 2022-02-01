import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class jph
  extends DiscussionObserver
{
  public jph(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = (String)paramArrayOfObject[0];
    if ((QCallDetailActivity.a(this.a) != null) && (QCallDetailActivity.a(this.a).equals(paramArrayOfObject)) && (paramBoolean) && (QCallDetailActivity.a(this.a) == 3000)) {
      this.a.a(paramArrayOfObject);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((QCallDetailActivity.a(this.a) != null) && (QCallDetailActivity.a(this.a).equals(paramString)) && (QCallDetailActivity.a(this.a) == 3000)) {
      this.a.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jph
 * JD-Core Version:    0.7.0.1
 */