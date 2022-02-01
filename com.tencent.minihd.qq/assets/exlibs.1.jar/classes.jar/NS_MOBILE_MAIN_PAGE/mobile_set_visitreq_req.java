package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_set_visitreq_req
  extends JceStruct
{
  public String msg = "";
  public int op_type = 0;
  public long visit_uin = 0L;
  
  public mobile_set_visitreq_req() {}
  
  public mobile_set_visitreq_req(int paramInt, long paramLong, String paramString)
  {
    this.op_type = paramInt;
    this.visit_uin = paramLong;
    this.msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op_type = paramJceInputStream.read(this.op_type, 0, true);
    this.visit_uin = paramJceInputStream.read(this.visit_uin, 1, false);
    this.msg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op_type, 0);
    paramJceOutputStream.write(this.visit_uin, 1);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_set_visitreq_req
 * JD-Core Version:    0.7.0.1
 */