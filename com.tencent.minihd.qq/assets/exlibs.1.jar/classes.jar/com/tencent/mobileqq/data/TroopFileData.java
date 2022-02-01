package com.tencent.mobileqq.data;

import java.io.Serializable;

public class TroopFileData
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public String FromUin = null;
  public int bisID = 0;
  public String dspFileName = null;
  public String dspFileSize = null;
  public long entitySessionId;
  public String fileName = null;
  public String fileUrl = null;
  public long lastTime = 0L;
  public long lfileSize = 0L;
  public String uuid = null;
  
  public String toString()
  {
    return "TroopFileData{dspFileSize='" + this.dspFileSize + '\'' + ", dspFileName='" + this.dspFileName + '\'' + ", bisID=" + this.bisID + ", fileUrl='" + this.fileUrl + '\'' + ", fileName='" + this.fileName + '\'' + ", lfileSize=" + this.lfileSize + ", uuid='" + this.uuid + '\'' + ", FromUin='" + this.FromUin + '\'' + ", lastTime=" + this.lastTime + ", entitySessionId=" + this.entitySessionId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopFileData
 * JD-Core Version:    0.7.0.1
 */