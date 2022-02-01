import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;

public class fyv
  implements View.OnClickListener
{
  public fyv(AIOImageListScene paramAIOImageListScene) {}
  
  public void onClick(View paramView)
  {
    AIOImageListScene.a(this.a, ((TextView)paramView).getText().toString());
    AIOImageListScene.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fyv
 * JD-Core Version:    0.7.0.1
 */