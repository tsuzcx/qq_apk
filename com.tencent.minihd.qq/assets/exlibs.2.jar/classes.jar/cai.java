import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;
import com.tencent.biz.JoinGroupTransitActivity;

public class cai
  implements JoinGroupHandler.IJoinGroupCB
{
  public cai(JoinGroupTransitActivity paramJoinGroupTransitActivity) {}
  
  public void a()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(1);
  }
  
  public void b()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(2);
  }
  
  public void c()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cai
 * JD-Core Version:    0.7.0.1
 */