import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizonEmoticonTabs.EmoticonTabChangeListener;

public class igd
  implements HorizonEmoticonTabs.EmoticonTabChangeListener
{
  public igd(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    EmoticonMainPanel.a(this.a, EmoticonMainPanel.b(this.a));
    if (EmoticonMainPanel.g == 1) {
      this.a.a(2, paramInt2);
    }
    while (EmoticonMainPanel.i == paramInt2) {
      return;
    }
    EmoticonMainPanel.g = 2;
    EmoticonMainPanel.a(this.a, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     igd
 * JD-Core Version:    0.7.0.1
 */