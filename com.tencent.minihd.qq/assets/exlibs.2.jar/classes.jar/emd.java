import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;

class emd
  implements Runnable
{
  emd(emc paramemc) {}
  
  public void run()
  {
    if (NearbyActivity.a(this.a.a) != null)
    {
      this.a.a.a = true;
      if (NearbyActivity.a(this.a.a) != null) {
        NearbyActivity.a(this.a.a).a(NearbyActivity.a(this.a.a), false);
      }
    }
    NearbyActivity.a(this.a.a, true, NearbyActivity.a(this.a.a));
    this.a.a.a(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     emd
 * JD-Core Version:    0.7.0.1
 */