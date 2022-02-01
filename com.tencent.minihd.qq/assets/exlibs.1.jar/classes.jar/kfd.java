import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.troop.activity.QLifeCommentActivity;
import com.tencent.qphone.base.util.QLog;

public class kfd
  extends SosoInterface.OnLocationListener
{
  public kfd(QLifeCommentActivity paramQLifeCommentActivity, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QLifeCommentActivity", 2, "onLocationFinish() errCode=" + paramInt);
    }
    QLifeCommentActivity.a(this.a, paramSosoLbsInfo.a.a);
    QLifeCommentActivity.b(this.a, paramSosoLbsInfo.a.b);
    QLifeCommentActivity.a(this.a, QLifeCommentActivity.a(this.a), QLifeCommentActivity.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kfd
 * JD-Core Version:    0.7.0.1
 */