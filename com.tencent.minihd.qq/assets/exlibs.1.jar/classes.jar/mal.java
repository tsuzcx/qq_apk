import Wallet.RspPayApplication;
import com.tencent.mobileqq.app.QWalletHomeObserver;
import cooperation.qwallet.plugin.ipc.RecommendReq;

public class mal
  extends QWalletHomeObserver
{
  public mal(RecommendReq paramRecommendReq) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    if (((paramBoolean) || (paramObject != null)) && ((paramObject instanceof RspPayApplication)) && (((RspPayApplication)paramObject).ret == 0))
    {
      this.a.a((RspPayApplication)paramObject);
      return;
    }
    this.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mal
 * JD-Core Version:    0.7.0.1
 */