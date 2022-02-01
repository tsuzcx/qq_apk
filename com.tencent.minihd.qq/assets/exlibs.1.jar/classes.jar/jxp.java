import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement.ElementClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;

public class jxp
  implements View.OnClickListener
{
  public jxp(StructMsgItemButton paramStructMsgItemButton) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.a.jdField_c_of_type_Long < 1000L) {}
    Object localObject2;
    Object localObject1;
    Context localContext;
    do
    {
      do
      {
        do
        {
          return;
          this.a.jdField_c_of_type_Long = SystemClock.uptimeMillis();
          localObject2 = paramView.getTag();
        } while ((localObject2 == null) || (!StructMsgItemButton.class.isInstance(localObject2)));
        localObject1 = ((ViewGroup)paramView.getParent().getParent()).getTag(2131296309);
      } while ((localObject1 == null) || (!StructMsgForGeneralShare.class.isInstance(localObject1)));
      localObject1 = (StructMsgForGeneralShare)localObject1;
      localObject2 = (StructMsgItemButton)localObject2;
      localContext = paramView.getContext();
    } while (!ChatActivity.class.isInstance(localContext));
    new AbsStructMsgElement.ElementClickHandler(((ChatActivity)localContext).a(), paramView).a(((StructMsgItemButton)localObject2).jdField_c_of_type_JavaLangString, ((StructMsgItemButton)localObject2).b, ((StructMsgItemButton)localObject2).d, ((StructMsgItemButton)localObject2).e, ((StructMsgForGeneralShare)localObject1).msgId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jxp
 * JD-Core Version:    0.7.0.1
 */