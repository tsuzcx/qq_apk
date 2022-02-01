package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ProfUsrQryReq
  extends JceStruct
{
  static ArrayList cache_vUin;
  public byte cGetDateNick = 0;
  public byte cGetSig = 0;
  public byte cGetSpecialFlag = 0;
  public int iAppId = 0;
  public int iGetLevel = 0;
  public int iGetXManInfo = 0;
  public int iReloadFlag = 0;
  public int iRetIncomPlete = 0;
  public String strSessionKey = "";
  public ArrayList vUin = null;
  
  public ProfUsrQryReq() {}
  
  public ProfUsrQryReq(int paramInt1, String paramString, ArrayList paramArrayList, int paramInt2, int paramInt3, byte paramByte1, int paramInt4, int paramInt5, byte paramByte2, byte paramByte3)
  {
    this.iAppId = paramInt1;
    this.strSessionKey = paramString;
    this.vUin = paramArrayList;
    this.iRetIncomPlete = paramInt2;
    this.iReloadFlag = paramInt3;
    this.cGetSig = paramByte1;
    this.iGetLevel = paramInt4;
    this.iGetXManInfo = paramInt5;
    this.cGetSpecialFlag = paramByte2;
    this.cGetDateNick = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 1, true);
    this.strSessionKey = paramJceInputStream.readString(2, true);
    if (cache_vUin == null)
    {
      cache_vUin = new ArrayList();
      cache_vUin.add(Long.valueOf(0L));
    }
    this.vUin = ((ArrayList)paramJceInputStream.read(cache_vUin, 3, true));
    this.iRetIncomPlete = paramJceInputStream.read(this.iRetIncomPlete, 4, false);
    this.iReloadFlag = paramJceInputStream.read(this.iReloadFlag, 5, false);
    this.cGetSig = paramJceInputStream.read(this.cGetSig, 6, false);
    this.iGetLevel = paramJceInputStream.read(this.iGetLevel, 7, false);
    this.iGetXManInfo = paramJceInputStream.read(this.iGetXManInfo, 8, false);
    this.cGetSpecialFlag = paramJceInputStream.read(this.cGetSpecialFlag, 9, false);
    this.cGetDateNick = paramJceInputStream.read(this.cGetDateNick, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 1);
    paramJceOutputStream.write(this.strSessionKey, 2);
    paramJceOutputStream.write(this.vUin, 3);
    paramJceOutputStream.write(this.iRetIncomPlete, 4);
    paramJceOutputStream.write(this.iReloadFlag, 5);
    paramJceOutputStream.write(this.cGetSig, 6);
    paramJceOutputStream.write(this.iGetLevel, 7);
    paramJceOutputStream.write(this.iGetXManInfo, 8);
    paramJceOutputStream.write(this.cGetSpecialFlag, 9);
    paramJceOutputStream.write(this.cGetDateNick, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.ProfUsrQryReq
 * JD-Core Version:    0.7.0.1
 */