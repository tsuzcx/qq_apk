import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class jjc
  implements IphonePickerView.PickerViewAdapter
{
  public jjc(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 4;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    int i = 3;
    if (paramInt2 < 0) {}
    for (paramInt1 = 0;; paramInt1 = paramInt2)
    {
      if (paramInt1 > 3) {
        paramInt1 = i;
      }
      for (;;)
      {
        switch (paramInt1)
        {
        default: 
          return "";
        case 0: 
          return "保密";
        case 1: 
          return "单身";
        case 2: 
          return "恋爱中";
        }
        return "已婚";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jjc
 * JD-Core Version:    0.7.0.1
 */