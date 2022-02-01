import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;

public class ira
  implements ProtoReqManager.IProtoRespBack
{
  public ira(FileTransferHandler paramFileTransferHandler) {}
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500" == paramProtoReq.a) {
      FileTransferHandler.a(this.a, paramProtoReq, paramProtoResp);
    }
    do
    {
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800" == paramProtoReq.a)
      {
        FileTransferHandler.b(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200" == paramProtoReq.a)
      {
        FileTransferHandler.c(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000" == paramProtoReq.a)
      {
        FileTransferHandler.d(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700" == paramProtoReq.a)
      {
        FileTransferHandler.e(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100" == paramProtoReq.a)
      {
        FileTransferHandler.f(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100" == paramProtoReq.a)
      {
        FileTransferHandler.g(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900" == paramProtoReq.a)
      {
        FileTransferHandler.h(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("GTalkFileAppSvr.CMD_DISCUSS_FILE" == paramProtoReq.a)
      {
        FileTransferHandler.i(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600" == paramProtoReq.a)
      {
        FileTransferHandler.j(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700" == paramProtoReq.a)
      {
        FileTransferHandler.k(this.a, paramProtoReq, paramProtoResp);
        return;
      }
    } while ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800" != paramProtoReq.a);
    FileTransferHandler.l(this.a, paramProtoReq, paramProtoResp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ira
 * JD-Core Version:    0.7.0.1
 */