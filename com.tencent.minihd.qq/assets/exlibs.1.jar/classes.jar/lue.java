import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.tencent.widget.pulltorefresh.library.OverscrollHelper;
import com.tencent.widget.pulltorefresh.library.PullToRefreshWebView;

@TargetApi(9)
public final class lue
  extends WebView
{
  static final float jdField_a_of_type_Float = 1.5F;
  static final int jdField_a_of_type_Int = 2;
  
  public lue(PullToRefreshWebView paramPullToRefreshWebView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  private int a()
  {
    float f = ((WebView)this.a.a).getContentHeight();
    return (int)Math.max(0.0D, Math.floor(((WebView)this.a.a).getScale() * f) - (getHeight() - getPaddingBottom() - getPaddingTop()));
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    OverscrollHelper.a(this.a, paramInt1, paramInt3, paramInt2, paramInt4, a(), 2, 1.5F, paramBoolean);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lue
 * JD-Core Version:    0.7.0.1
 */