import android.content.Intent;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class gfg
  extends AnimateUtils.AnimationAdapter
{
  gfg(gff paramgff) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a = true;
    paramAnimation = new Intent(this.a.a, SearchContactsActivity.class);
    paramAnimation.putExtra("from_key", this.a.a.a());
    this.a.a.startActivity(paramAnimation);
    this.a.a.overridePendingTransition(0, 0);
    ThreadPriorityManager.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfg
 * JD-Core Version:    0.7.0.1
 */