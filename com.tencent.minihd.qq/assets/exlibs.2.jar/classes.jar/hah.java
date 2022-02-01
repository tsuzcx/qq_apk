import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity.SpecialSoundAdapter;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;

public class hah
  extends QvipSpecialCareObserver
{
  public hah(QvipSpecialSoundActivity paramQvipSpecialSoundActivity) {}
  
  public void onSendErrorEvent(Object paramObject)
  {
    if (paramObject != null)
    {
      QvipSpecialSoundActivity.e(this.a);
      if (QvipSpecialSoundActivity.a(this.a) != null) {
        QvipSpecialSoundActivity.a(this.a).removeMessages(2);
      }
      if (((Integer)paramObject).intValue() == 10010)
      {
        QvipSpecialSoundActivity.a(this.a, this.a.getString(2131369149));
        QvipSpecialCareManager.a(null, 1, null, this.a.app);
      }
    }
    else
    {
      return;
    }
    QvipSpecialSoundActivity.a(this.a, this.a.getString(2131369150));
  }
  
  public void onSpecialSoundEvent(Object paramObject)
  {
    if (paramObject != null)
    {
      QvipSpecialSoundActivity.d(this.a);
      if (QvipSpecialSoundActivity.a(this.a) != null) {
        QvipSpecialSoundActivity.a(this.a).removeMessages(2);
      }
      switch (((Integer)paramObject).intValue())
      {
      }
    }
    do
    {
      do
      {
        return;
      } while (QvipSpecialSoundActivity.a(this.a) == null);
      QvipSpecialSoundActivity.b(this.a);
      QvipSpecialSoundActivity.a(this.a).notifyDataSetChanged();
      return;
      QvipSpecialSoundActivity.c(this.a);
    } while (QvipSpecialSoundActivity.a(this.a) == null);
    QvipSpecialSoundActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hah
 * JD-Core Version:    0.7.0.1
 */