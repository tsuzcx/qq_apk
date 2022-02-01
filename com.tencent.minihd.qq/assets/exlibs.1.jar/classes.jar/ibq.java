import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.dating.DatingFilterActivity;
import com.tencent.mobileqq.dating.DatingFilters;

public class ibq
  implements IphonePickerView.PickerViewAdapter
{
  public ibq(DatingFilterActivity paramDatingFilterActivity) {}
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    if (this.a.a == 0) {
      return DatingFilters.a.length;
    }
    if (this.a.a == 2) {
      return DatingFilters.c.length;
    }
    return DatingFilters.b.length;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (this.a.a == 0) {
      return DatingFilters.a[paramInt2];
    }
    if (this.a.a == 2) {
      return DatingFilters.c[paramInt2];
    }
    return DatingFilters.b[paramInt2];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibq
 * JD-Core Version:    0.7.0.1
 */