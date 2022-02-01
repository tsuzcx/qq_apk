import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.widget.XListView;

class fgc
  implements Runnable
{
  fgc(fgb paramfgb) {}
  
  public void run()
  {
    if ((this.a.a.a.a() instanceof BaseAdapter)) {
      ((BaseAdapter)this.a.a.a.a()).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fgc
 * JD-Core Version:    0.7.0.1
 */