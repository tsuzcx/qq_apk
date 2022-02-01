import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.List;

public class hwp
  implements IphonePickerView.PickerViewAdapter
{
  public hwp(LocationSelectActivity paramLocationSelectActivity) {}
  
  public int a()
  {
    return this.a.j;
  }
  
  public int a(int paramInt)
  {
    if (this.a.a[paramInt] != null) {
      return ((List)this.a.a[paramInt]).size();
    }
    return 0;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (this.a.a[paramInt1] != null)
    {
      if (((BaseAddress)((List)this.a.a[paramInt1]).get(paramInt2)).b.equals("0")) {
        return "----";
      }
      return ((BaseAddress)((List)this.a.a[paramInt1]).get(paramInt2)).a;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hwp
 * JD-Core Version:    0.7.0.1
 */