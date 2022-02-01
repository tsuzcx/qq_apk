import Wallet.RspRealApplication;
import com.tencent.mobileqq.app.QWalletHomeObserver;
import cooperation.qwallet.plugin.ipc.RealEventReq;

public class maj
  extends QWalletHomeObserver
{
  public maj(RealEventReq paramRealEventReq) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2) {
      return;
    }
    if (((paramBoolean) || (paramObject != null)) && ((paramObject instanceof RspRealApplication)) && (((RspRealApplication)paramObject).ret == 0))
    {
      this.a.a((RspRealApplication)paramObject);
      return;
    }
    this.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     maj
 * JD-Core Version:    0.7.0.1
 */