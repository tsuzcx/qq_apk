package cooperation.qwallet.plugin.ipc;

import java.io.Serializable;

public class QWalletRedTouchInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String buffer;
  public String path;
  public String type;
  
  public QWalletRedTouchInfo(String paramString1, String paramString2, String paramString3)
  {
    this.path = paramString1;
    this.type = paramString2;
    this.buffer = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.QWalletRedTouchInfo
 * JD-Core Version:    0.7.0.1
 */