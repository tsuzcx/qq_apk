import android.os.Bundle;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;

public class kwg
  extends VipFunCallObserver
{
  public kwg(VipFunCallPreviewActivity paramVipFunCallPreviewActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    int i = paramObject.getInt("ret");
    int j = paramObject.getInt("fun_call_id");
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return;
      }
      this.a.runOnUiThread(this.a.a);
      return;
    }
    if (i == 1005011) {
      paramInt = 2;
    }
    for (;;)
    {
      this.a.runOnUiThread(this.a.b);
      this.a.a(paramInt, j);
      return;
      paramInt = i;
      if (i == 1005012) {
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kwg
 * JD-Core Version:    0.7.0.1
 */