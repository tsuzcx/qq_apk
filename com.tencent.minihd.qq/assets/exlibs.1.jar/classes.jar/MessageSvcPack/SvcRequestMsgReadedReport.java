package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestMsgReadedReport
  extends JceStruct
{
  static ArrayList cache_vMsgKey;
  static byte[] cache_vSyncCookie;
  public boolean bPbReadedReport = false;
  public byte cVerifyType = 0;
  public ArrayList vMsgKey = null;
  public byte[] vSyncCookie = null;
  
  public SvcRequestMsgReadedReport() {}
  
  public SvcRequestMsgReadedReport(byte paramByte, byte[] paramArrayOfByte, ArrayList paramArrayList, boolean paramBoolean)
  {
    this.cVerifyType = paramByte;
    this.vSyncCookie = paramArrayOfByte;
    this.vMsgKey = paramArrayList;
    this.bPbReadedReport = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 0, true);
    if (cache_vSyncCookie == null)
    {
      cache_vSyncCookie = (byte[])new byte[1];
      ((byte[])cache_vSyncCookie)[0] = 0;
    }
    this.vSyncCookie = ((byte[])paramJceInputStream.read(cache_vSyncCookie, 1, true));
    if (cache_vMsgKey == null)
    {
      cache_vMsgKey = new ArrayList();
      UinPairReadInfo localUinPairReadInfo = new UinPairReadInfo();
      cache_vMsgKey.add(localUinPairReadInfo);
    }
    this.vMsgKey = ((ArrayList)paramJceInputStream.read(cache_vMsgKey, 2, true));
    this.bPbReadedReport = paramJceInputStream.read(this.bPbReadedReport, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cVerifyType, 0);
    paramJceOutputStream.write(this.vSyncCookie, 1);
    paramJceOutputStream.write(this.vMsgKey, 2);
    paramJceOutputStream.write(this.bPbReadedReport, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MessageSvcPack.SvcRequestMsgReadedReport
 * JD-Core Version:    0.7.0.1
 */