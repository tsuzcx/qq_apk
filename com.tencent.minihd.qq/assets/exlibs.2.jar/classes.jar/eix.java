import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mobileqq.activity.LoginActivity;
import java.util.List;

class eix
  extends Filter
{
  eix(eiw parameiw) {}
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = new Filter.FilterResults();
    paramCharSequence.values = LoginActivity.a(this.a.a);
    paramCharSequence.count = LoginActivity.a(this.a.a).size();
    return paramCharSequence;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    if (paramFilterResults.count > 0)
    {
      this.a.notifyDataSetChanged();
      return;
    }
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eix
 * JD-Core Version:    0.7.0.1
 */