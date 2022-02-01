package cooperation.qlink;

import java.io.Serializable;

public class QlAndQQInterface$InsertFMFileInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean bSend;
  public String filePath;
  public int fileType = -1;
  public long sessionId;
  public String thumbPath;
  public String uin;
  
  public QlAndQQInterface$InsertFMFileInfo(String paramString1, boolean paramBoolean, long paramLong, String paramString2, String paramString3)
  {
    this.uin = paramString1;
    this.bSend = paramBoolean;
    this.sessionId = paramLong;
    this.filePath = paramString2;
    this.thumbPath = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.QlAndQQInterface.InsertFMFileInfo
 * JD-Core Version:    0.7.0.1
 */