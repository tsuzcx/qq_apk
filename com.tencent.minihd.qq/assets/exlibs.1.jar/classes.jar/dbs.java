import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.qphone.base.util.QLog;

public class dbs
  implements Runnable
{
  public dbs(LiteTransferWrapper paramLiteTransferWrapper) {}
  
  public void run()
  {
    if ((LiteTransferWrapper.access$000(this.a) == null) || (LiteTransferWrapper.access$100(this.a) == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTTransferWrapper", 2, "litetransfer callback is null, do nothing");
      }
    }
    while (LiteTransferWrapper.access$200(this.a) != 0L) {
      return;
    }
    LiteTransferWrapper.access$202(this.a, this.a.createOperator(LiteTransferWrapper.access$000(this.a), LiteTransferWrapper.access$100(this.a)));
    this.a.checkPathExist();
    this.a.SetProxyToJni();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbs
 * JD-Core Version:    0.7.0.1
 */