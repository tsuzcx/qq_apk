import Wallet.RspH5Config;
import com.tencent.mobileqq.app.QWalletHomeObserver;
import cooperation.qwallet.plugin.ipc.PersonalInfoReq;

public class mah
  extends QWalletHomeObserver
{
  public mah(PersonalInfoReq paramPersonalInfoReq) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 3) {
      return;
    }
    if (((paramBoolean) || (paramObject != null)) && ((paramObject instanceof RspH5Config)))
    {
      RspH5Config localRspH5Config = (RspH5Config)paramObject;
      if (localRspH5Config.ret == 0)
      {
        this.a.b((RspH5Config)paramObject);
        this.a.a(localRspH5Config);
        return;
      }
    }
    this.a.b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mah
 * JD-Core Version:    0.7.0.1
 */