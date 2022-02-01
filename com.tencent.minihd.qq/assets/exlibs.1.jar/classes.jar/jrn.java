import android.view.View;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class jrn
  implements ActionSheet.OnButtonClickListener
{
  public jrn(EditActivity paramEditActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.a.dismiss();
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (System.currentTimeMillis() - this.a.b <= 1300L);
      this.a.e();
      return;
    }
    EditActivity.a(this.a).e = null;
    EditActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jrn
 * JD-Core Version:    0.7.0.1
 */