import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

class ifx
  implements Runnable
{
  ifx(ifw paramifw) {}
  
  public void run()
  {
    if ((this.a.a.getVisibility() == 0) && (EmoticonMainPanel.g == 2))
    {
      this.a.a.b = false;
      this.a.a.a(2, EmoticonMainPanel.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifx
 * JD-Core Version:    0.7.0.1
 */