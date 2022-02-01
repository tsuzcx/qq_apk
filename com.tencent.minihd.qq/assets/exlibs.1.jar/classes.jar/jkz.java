import android.annotation.TargetApi;
import com.tencent.mobileqq.nearpeople.FlingBrandListener.FlingListener;
import com.tencent.mobileqq.nearpeople.TurnBrandCardView;
import com.tencent.mobileqq.nearpeople.TurnBrandView;
import com.tencent.mobileqq.nearpeople.TurnBrandView.onFlingListener;
import com.tencent.util.VersionUtils;

public class jkz
  implements FlingBrandListener.FlingListener
{
  public jkz(TurnBrandView paramTurnBrandView) {}
  
  public void a()
  {
    TurnBrandView.a(this.a).a();
  }
  
  public void a(Object paramObject)
  {
    TurnBrandView.a(this.a).a(paramObject);
  }
  
  @TargetApi(11)
  public void a(boolean paramBoolean1, boolean paramBoolean2, float paramFloat1, float paramFloat2)
  {
    paramFloat2 = Math.abs((float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2)) / (this.a.getWidth() / 3.0F);
    paramFloat1 = paramFloat2;
    if (paramFloat2 > 1.0F) {
      paramFloat1 = 1.0F;
    }
    int i = 1;
    if (i < 3)
    {
      TurnBrandCardView localTurnBrandCardView = TurnBrandView.a(this.a)[i];
      if (VersionUtils.e())
      {
        if (!paramBoolean1) {
          break label169;
        }
        localTurnBrandCardView.setInfoAlpha(localTurnBrandCardView.c() + (int)(20.0F * paramFloat1));
        localTurnBrandCardView.setScaleX(2.0F * paramFloat1 * TurnBrandView.a(this.a) / localTurnBrandCardView.getWidth() + 1.0F);
        localTurnBrandCardView.setScaleY(2.0F * paramFloat1 * TurnBrandView.b(this.a) / localTurnBrandCardView.getHeight() + 1.0F);
        localTurnBrandCardView.setTranslationY(-TurnBrandView.b(this.a) * paramFloat1 * 2.0F);
      }
      for (;;)
      {
        i += 1;
        break;
        label169:
        localTurnBrandCardView.setScaleX(1.0F);
        localTurnBrandCardView.setScaleY(1.0F);
        localTurnBrandCardView.setTranslationY(0.0F);
      }
    }
    if ((!paramBoolean1) && ((paramBoolean2) || (!VersionUtils.e()))) {
      this.a.requestLayout();
    }
  }
  
  public void b(Object paramObject)
  {
    TurnBrandView.a(this.a).b(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jkz
 * JD-Core Version:    0.7.0.1
 */