import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;

public class gkt
  extends CardObserver
{
  public gkt(BaseFloatChatPie paramBaseFloatChatPie) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null)) {}
      switch (this.a.a.jdField_a_of_type_Int)
      {
      default: 
        if ((this.a.a.jdField_a_of_type_JavaLangString != null) && (this.a.a.jdField_a_of_type_JavaLangString.equals(paramObject.uin)))
        {
          this.a.r();
          this.a.b.setText(this.a.a.d);
        }
        return;
      }
      this.a.a(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gkt
 * JD-Core Version:    0.7.0.1
 */