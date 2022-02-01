import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;

class jjx
  implements Runnable
{
  jjx(jjw paramjjw) {}
  
  public void run()
  {
    if (NearbyProfileEditPanel.b(this.a.a) != null)
    {
      NearbyProfileEditPanel.b(this.a.a).setVisibility(0);
      NearbyProfileEditPanel.a(this.a.a, null);
      if (!jjw.a(this.a)) {
        NearbyProfileEditPanel.a(this.a.a).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jjx
 * JD-Core Version:    0.7.0.1
 */