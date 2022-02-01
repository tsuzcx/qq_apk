import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;

class dse
  implements Runnable
{
  dse(dsd paramdsd) {}
  
  public void run()
  {
    boolean bool3 = true;
    int i;
    boolean bool4;
    boolean bool1;
    if (this.a.a.a.a(11) == 2)
    {
      i = 1;
      bool4 = PhoneNumLoginImpl.a().a(this.a.a.app);
      if (!bool4) {
        break label122;
      }
      if (i != 0) {
        break label165;
      }
      PhoneNumLoginImpl.a().a(this.a.a.app);
      bool1 = false;
    }
    for (;;)
    {
      label69:
      boolean bool2;
      if ((bool4) && (i == 0))
      {
        bool2 = true;
        label80:
        if ((bool4) || (!bool1) || (i == 0)) {
          break label160;
        }
      }
      label160:
      for (bool1 = bool3;; bool1 = false)
      {
        this.a.a.runOnUiThread(new dsf(this, bool2, bool1));
        return;
        i = 0;
        break;
        label122:
        bool1 = PhoneNumLoginImpl.a().a(this.a.a.app, this.a.a.app.a());
        break label69;
        bool2 = false;
        break label80;
      }
      label165:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dse
 * JD-Core Version:    0.7.0.1
 */