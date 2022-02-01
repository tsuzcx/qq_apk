package com.weiyun.sdk;

public class ErrorCode
{
  public static final int ERR_114DNS_ERROR = -30025;
  public static final int ERR_ADDRESS_IS_EMPTY = -10012;
  public static final int ERR_ASYNCHRONOUS_CLOSE = -30019;
  public static final int ERR_CHANNEL_CLOSED = -30022;
  public static final int ERR_CHANNEL_NOT_YET_CONNECTED = -30021;
  public static final int ERR_CLOSED_BY_INTERRUPT = -30020;
  public static final int ERR_CLOSE_CONN_ERROR = -30017;
  public static final int ERR_CREATE_DIR_FAIL = -10007;
  public static final int ERR_FETCH_ADDRESS_FAIL = -10011;
  public static final int ERR_FILE_MODIFIED = -10009;
  public static final int ERR_FILE_NOT_ACCESS = -10008;
  public static final int ERR_FILE_SEEK_FAILED = -10016;
  public static final int ERR_FILE_SIZE_EXCEED = -10015;
  public static final int ERR_FILE_TYPE_NOT_SUPPORT = -10010;
  public static final int ERR_HTTP_EMPTY_BODY = -29001;
  public static final int ERR_HTTP_EMPTY_PART = -29005;
  public static final int ERR_INVALID_CMD = -28001;
  public static final int ERR_INVALID_PARAMETER = -10001;
  public static final int ERR_INVALID_RECV_BUFFER = -28003;
  public static final int ERR_INVALID_URL = -29002;
  public static final int ERR_LOCAL_FILE_NOT_EXIST = -10006;
  public static final int ERR_NETWORK_EXCEPTION = -30091;
  public static final int ERR_NETWORK_NOT_AVAILABLE = -10004;
  public static final int ERR_NETWORK_TIMEOUT = -30090;
  public static final int ERR_NO_NETWORK = -10003;
  public static final int ERR_NV_TIMEOUT = -30024;
  public static final int ERR_OFFSET_IS_WRONG = -10013;
  public static final int ERR_OTHER_NETWORK_ERROR = -30023;
  public static final int ERR_PART_DOWNLOAD_SUCC = -10020;
  public static final int ERR_QQDISK_ADD_UPLOAD_TASK_FAIL = -10025;
  public static final int ERR_QQDISK_DOWNLOAD_DIR = -10032;
  public static final int ERR_QQDISK_DOWNLOAD_LACK_SPACE = -10031;
  public static final int ERR_QQDISK_DOWNLOAD_UNABLE_OVERWRITE = -10033;
  public static final int ERR_QQDISK_INVALID_RSP = -10024;
  public static final int ERR_QQDISK_NO_LOGIN = -10026;
  public static final int ERR_QQDISK_SERVER_ERROR = -10023;
  public static final int ERR_QQDISK_TOO_MANY_FILES = -10027;
  public static final int ERR_QQDISK_UPLOAD_DIR = -10030;
  public static final int ERR_QQDISK_UPLOAD_LACK_SPACE = -10029;
  public static final int ERR_QQDISK_UPLOAD_TO_ROOT = -10028;
  public static final int ERR_QQ_NOT_NETWORK = 9004;
  public static final int ERR_READ_HTTP_CONTENT = -29003;
  public static final int ERR_RECV_EMPTY_BUFFER = -28002;
  public static final int ERR_RECV_EMPTY_PB_BODY = -28004;
  public static final int ERR_REMOTE_FILE_NOT_EXIST = -10005;
  public static final int ERR_SOCKET_ADDRESS_FAMILY = -30009;
  public static final int ERR_SOCKET_BIND_ERROR = -30008;
  public static final int ERR_SOCKET_BROKEN_PIPE = -30006;
  public static final int ERR_SOCKET_CLOSED = -30003;
  public static final int ERR_SOCKET_CONNECT_FAIL = -30010;
  public static final int ERR_SOCKET_CONNECT_TIMEOUT = -30028;
  public static final int ERR_SOCKET_CONN_REFUSED = -30011;
  public static final int ERR_SOCKET_CONTENT_LENGTH_WRONG = -29006;
  public static final int ERR_SOCKET_END_OF_FILE = -30016;
  public static final int ERR_SOCKET_ERROR = -30018;
  public static final int ERR_SOCKET_ETIMEDOUT = -30001;
  public static final int ERR_SOCKET_MALFORMED_URL = -30026;
  public static final int ERR_SOCKET_NO_ROUT_TO_HOST = -30015;
  public static final int ERR_SOCKET_PORT_UNREACHABLE = -30014;
  public static final int ERR_SOCKET_PROTOCOL = -30013;
  public static final int ERR_SOCKET_READ_HTTP_HEAD_TIMEOUT = -30029;
  public static final int ERR_SOCKET_READ_TIMEOUT = -30002;
  public static final int ERR_SOCKET_RESET = -30004;
  public static final int ERR_SOCKET_RESET_BY_PEER = -30005;
  public static final int ERR_SOCKET_TOO_MANY_OPEN_FILES = -30007;
  public static final int ERR_SOCKET_UNEXCEPTED_END_OF_STREAM = -30027;
  public static final int ERR_SOCKET_UNKNOWN_HOST = -30012;
  public static final int ERR_UNKOWN_EXCEPTION = -10014;
  public static final int ERR_USER_CANCELED = -10002;
  public static final int ERR_XERRNO_THUMBNAIL_NOT_EXIST = -29004;
  public static final int HTTP_ERROR_BASE = -30000;
  public static final int HTTP_ERROR_END = -29000;
  public static final int NETWORK_ERROR_END = -30000;
  public static final int SUCC = 0;
  
  public static boolean isHttpError(int paramInt)
  {
    return (paramInt > -30000) && (paramInt < -29000);
  }
  
  public static boolean isNetworkError(int paramInt)
  {
    return paramInt < -30000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.ErrorCode
 * JD-Core Version:    0.7.0.1
 */