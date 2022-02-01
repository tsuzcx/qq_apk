package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqFavorite
  extends JceStruct
{
  static int cache_cOpType;
  static int cache_emSource;
  static ReqHead cache_stHeader;
  public int cOpType = 0;
  public int emSource = 65535;
  public long lMID = 0L;
  public ReqHead stHeader = null;
  
  public ReqFavorite() {}
  
  public ReqFavorite(ReqHead paramReqHead, long paramLong, int paramInt1, int paramInt2)
  {
    this.stHeader = paramReqHead;
    this.lMID = paramLong;
    this.cOpType = paramInt1;
    this.emSource = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lMID = paramJceInputStream.read(this.lMID, 1, true);
    this.cOpType = paramJceInputStream.read(this.cOpType, 2, true);
    this.emSource = paramJceInputStream.read(this.emSource, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lMID, 1);
    paramJceOutputStream.write(this.cOpType, 2);
    paramJceOutputStream.write(this.emSource, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.ReqFavorite
 * JD-Core Version:    0.7.0.1
 */