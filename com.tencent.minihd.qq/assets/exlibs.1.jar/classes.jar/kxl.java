import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ContextMenuTextView;

public class kxl
  implements View.OnClickListener
{
  public kxl(ContextMenuTextView paramContextMenuTextView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131302484)
    {
      paramView = ContextMenuTextView.a(this.a);
      ContextMenuTextView.a(this.a);
      ((ClipboardManager)paramView.getSystemService("clipboard")).setText(this.a.getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kxl
 * JD-Core Version:    0.7.0.1
 */