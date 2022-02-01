import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import java.util.Stack;

public class kyh
{
  private Stack jdField_a_of_type_JavaUtilStack = new Stack();
  
  public kyh(MixedMsgLinearLayout paramMixedMsgLinearLayout) {}
  
  public ChatThumbView a()
  {
    if (this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
      return null;
    }
    return (ChatThumbView)this.jdField_a_of_type_JavaUtilStack.pop();
  }
  
  public void a(ChatThumbView paramChatThumbView)
  {
    this.jdField_a_of_type_JavaUtilStack.push(paramChatThumbView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kyh
 * JD-Core Version:    0.7.0.1
 */