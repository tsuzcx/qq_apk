import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.widget.PullRefreshHeader;

class dsm
  implements Runnable
{
  dsm(dsl paramdsl, boolean paramBoolean) {}
  
  public void run()
  {
    Conversation.a(this.jdField_a_of_type_Dsl.a, true);
    PullRefreshHeader localPullRefreshHeader;
    if (Conversation.b(this.jdField_a_of_type_Dsl.a))
    {
      Conversation.a(this.jdField_a_of_type_Dsl.a, 800L);
      localPullRefreshHeader = Conversation.a(this.jdField_a_of_type_Dsl.a);
      if (!this.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dsm
 * JD-Core Version:    0.7.0.1
 */