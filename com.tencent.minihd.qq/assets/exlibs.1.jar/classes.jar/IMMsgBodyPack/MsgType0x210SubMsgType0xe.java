package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgType0x210SubMsgType0xe
  extends JceStruct
{
  public String str_msg = "";
  public long uint32_code = 0L;
  public long uint32_dst_app_id = 0L;
  public long uint32_dst_inst_id = 0L;
  public long uint32_operate = 0L;
  public long uint32_seq = 0L;
  public long uint32_src_app_id = 0L;
  public long uint32_src_inst_id = 0L;
  public long uint64_dst_uin = 0L;
  public long uint64_sessionid = 0L;
  
  public MsgType0x210SubMsgType0xe() {}
  
  public MsgType0x210SubMsgType0xe(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString)
  {
    this.uint32_src_app_id = paramLong1;
    this.uint32_src_inst_id = paramLong2;
    this.uint32_dst_app_id = paramLong3;
    this.uint32_dst_inst_id = paramLong4;
    this.uint64_dst_uin = paramLong5;
    this.uint64_sessionid = paramLong6;
    this.uint32_operate = paramLong7;
    this.uint32_seq = paramLong8;
    this.uint32_code = paramLong9;
    this.str_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uint32_src_app_id = paramJceInputStream.read(this.uint32_src_app_id, 0, false);
    this.uint32_src_inst_id = paramJceInputStream.read(this.uint32_src_inst_id, 1, false);
    this.uint32_dst_app_id = paramJceInputStream.read(this.uint32_dst_app_id, 2, false);
    this.uint32_dst_inst_id = paramJceInputStream.read(this.uint32_dst_inst_id, 3, false);
    this.uint64_dst_uin = paramJceInputStream.read(this.uint64_dst_uin, 4, false);
    this.uint64_sessionid = paramJceInputStream.read(this.uint64_sessionid, 5, false);
    this.uint32_operate = paramJceInputStream.read(this.uint32_operate, 6, false);
    this.uint32_seq = paramJceInputStream.read(this.uint32_seq, 7, false);
    this.uint32_code = paramJceInputStream.read(this.uint32_code, 8, false);
    this.str_msg = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uint32_src_app_id, 0);
    paramJceOutputStream.write(this.uint32_src_inst_id, 1);
    paramJceOutputStream.write(this.uint32_dst_app_id, 2);
    paramJceOutputStream.write(this.uint32_dst_inst_id, 3);
    paramJceOutputStream.write(this.uint64_dst_uin, 4);
    paramJceOutputStream.write(this.uint64_sessionid, 5);
    paramJceOutputStream.write(this.uint32_operate, 6);
    paramJceOutputStream.write(this.uint32_seq, 7);
    paramJceOutputStream.write(this.uint32_code, 8);
    if (this.str_msg != null) {
      paramJceOutputStream.write(this.str_msg, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0xe
 * JD-Core Version:    0.7.0.1
 */