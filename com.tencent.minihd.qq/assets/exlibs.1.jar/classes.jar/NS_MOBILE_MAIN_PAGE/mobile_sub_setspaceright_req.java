package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_setspaceright_req
  extends JceStruct
{
  static byte[] cache_allowGroupsId;
  static s_question cache_questions;
  public byte[] allowGroupsId = null;
  public long cur_seq = 0L;
  public s_question questions = null;
  public int rightval = 0;
  public long uin = 0L;
  
  public mobile_sub_setspaceright_req() {}
  
  public mobile_sub_setspaceright_req(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2, s_question params_question)
  {
    this.uin = paramLong1;
    this.rightval = paramInt;
    this.allowGroupsId = paramArrayOfByte;
    this.cur_seq = paramLong2;
    this.questions = params_question;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.rightval = paramJceInputStream.read(this.rightval, 1, true);
    if (cache_allowGroupsId == null)
    {
      cache_allowGroupsId = (byte[])new byte[1];
      ((byte[])cache_allowGroupsId)[0] = 0;
    }
    this.allowGroupsId = ((byte[])paramJceInputStream.read(cache_allowGroupsId, 2, false));
    this.cur_seq = paramJceInputStream.read(this.cur_seq, 3, false);
    if (cache_questions == null) {
      cache_questions = new s_question();
    }
    this.questions = ((s_question)paramJceInputStream.read(cache_questions, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.rightval, 1);
    if (this.allowGroupsId != null) {
      paramJceOutputStream.write(this.allowGroupsId, 2);
    }
    paramJceOutputStream.write(this.cur_seq, 3);
    if (this.questions != null) {
      paramJceOutputStream.write(this.questions, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_setspaceright_req
 * JD-Core Version:    0.7.0.1
 */