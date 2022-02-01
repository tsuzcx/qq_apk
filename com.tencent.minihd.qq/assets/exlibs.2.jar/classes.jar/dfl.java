import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;

public class dfl
  extends CardObserver
{
  public dfl(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      Object localObject;
      String str;
      TextView localTextView;
      if ((paramBoolean) && (paramObject != null) && (paramObject.uin != null) && (paramObject.uin.equals(AddFriendVerifyActivity.a(this.a))))
      {
        localObject = (FriendManager)this.a.app.getManager(8);
        str = ((FriendManager)localObject).d(paramObject.uin);
        localObject = ((FriendManager)localObject).c(paramObject.uin);
        localTextView = AddFriendVerifyActivity.c(this.a);
        if (!AddFriendVerifyActivity.a(this.a)) {
          break label125;
        }
        if (!((String)localObject).equals(paramObject.uin)) {
          localTextView.setText((CharSequence)localObject);
        }
      }
      return;
      label125:
      localTextView.setText(String.format("%s(%s)", new Object[] { localObject, str }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfl
 * JD-Core Version:    0.7.0.1
 */