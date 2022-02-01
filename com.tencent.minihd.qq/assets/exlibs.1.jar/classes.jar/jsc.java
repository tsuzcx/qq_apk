import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.richstatus.EditActivity;

public class jsc
  implements AdapterView.OnItemClickListener
{
  public jsc(EditActivity paramEditActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.b) {
      return;
    }
    this.a.h();
    this.a.b(paramInt);
    EditActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsc
 * JD-Core Version:    0.7.0.1
 */