import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import java.util.List;

public class dtu
  implements DragFrameLayout.OnDragModeChangedListener
{
  private final int jdField_a_of_type_Int = -2147483648;
  private List jdField_a_of_type_JavaUtilList;
  
  private dtu(Conversation paramConversation) {}
  
  public void a(int paramInt, List paramList) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((paramDragFrameLayout.a() == -1) && (Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation) != null)) {
      Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation).sendEmptyMessage(10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtu
 * JD-Core Version:    0.7.0.1
 */