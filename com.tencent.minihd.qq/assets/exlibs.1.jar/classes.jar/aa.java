import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineObserver;

public class aa
  extends DataLineObserver
{
  public aa(LiteActivity paramLiteActivity) {}
  
  protected void a()
  {
    this.a.runOnUiThread(new ac(this));
  }
  
  @TargetApi(11)
  protected void a(int paramInt, String paramString)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.a.runOnUiThread(new ai(this, paramString));
      return;
    }
    this.a.runOnUiThread(new aj(this, paramString));
  }
  
  protected void a(long paramLong)
  {
    this.a.runOnUiThread(new ak(this));
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new ae(this, paramLong, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new af(this, paramLong1, paramBoolean2));
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    super.a(paramBoolean, paramLong);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new ad(this, paramBoolean, paramLong, paramString));
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new ah(this));
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new ag(this, paramLong1));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new ab(this, paramLong, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aa
 * JD-Core Version:    0.7.0.1
 */