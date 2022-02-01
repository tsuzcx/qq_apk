import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizonEmoticonTabs.EmoticonTabChangeListener;

public class igc
  implements HorizonEmoticonTabs.EmoticonTabChangeListener
{
  public igc(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    EmoticonMainPanel.a(this.a, EmoticonMainPanel.a(this.a));
    if (EmoticonMainPanel.g == 2) {
      this.a.a(1, paramInt2);
    }
    while (EmoticonMainPanel.h == paramInt2) {
      return;
    }
    EmoticonMainPanel.g = 1;
    EmoticonMainPanel.a(this.a, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     igc
 * JD-Core Version:    0.7.0.1
 */