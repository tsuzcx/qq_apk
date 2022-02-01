package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$RspBody
  extends MessageMicro
{
  public static final int MSG_PTTSHORTVIDEODOWNLOAD_RESP_FIELD_NUMBER = 4;
  public static final int MSG_PTTSHORTVIDEOUPLOAD_RESP_FIELD_NUMBER = 3;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_cmd", "uint32_seq", "msg_PttShortVideoUpload_Resp", "msg_PttShortVideoDownload_Resp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, RspBody.class);
  public PttShortVideo.PttShortVideoDownloadResp msg_PttShortVideoDownload_Resp = new PttShortVideo.PttShortVideoDownloadResp();
  public PttShortVideo.PttShortVideoUploadResp msg_PttShortVideoUpload_Resp = new PttShortVideo.PttShortVideoUploadResp();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.RspBody
 * JD-Core Version:    0.7.0.1
 */