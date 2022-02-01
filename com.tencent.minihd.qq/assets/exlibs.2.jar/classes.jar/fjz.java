import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class fjz
  extends Dialog
{
  private Context a;
  
  public fjz(Context paramContext)
  {
    super(paramContext, 16973835);
    this.a = paramContext;
  }
  
  private void a()
  {
    Object localObject1 = findViewById(2131296742);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.a;
      if (!(localObject2 instanceof Activity)) {
        break label84;
      }
    }
    for (int i = ((Activity)localObject2).getWindow().getDecorView().getWidth();; i = ((Rect)localObject2).width())
    {
      localObject1 = getWindow();
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).gravity = 53;
      ((WindowManager.LayoutParams)localObject2).width = i;
      ((WindowManager.LayoutParams)localObject2).dimAmount = 0.0F;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 0;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      ((Window)localObject1).addFlags(2);
      return;
      label84:
      localObject2 = new Rect();
      ((View)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fjz
 * JD-Core Version:    0.7.0.1
 */