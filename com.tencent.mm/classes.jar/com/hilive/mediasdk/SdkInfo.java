package com.hilive.mediasdk;

public class SdkInfo
{
  public static final int kRatioBase = 10000;
  public static final int kTimeBase = 1000000;
  
  public static class EncodeMode
  {
    public static final int kEncodeModeCBR = 2;
    public static final int kEncodeModeCQ = 0;
    public static final int kEncodeModeVBR = 1;
  }
  
  public static class ErrCode
  {
    public static final int kErrCodeEnd = 699;
    public static final int kErrCodeFailed = 601;
    public static final int kErrCodeFormatUnSupport = 609;
    public static final int kErrCodeInterrupt = 606;
    public static final int kErrCodeIoError = 617;
    public static final int kErrCodeNoTrack = 615;
    public static final int kErrCodeNotFound = 608;
    public static final int kErrCodeNotSupport = 616;
    public static final int kErrCodeParmasInvalid = 607;
    public static final int kErrCodeRequestUnSupport = 603;
    public static final int kErrCodeSdkNotReady = 602;
    public static final int kErrCodeSuccess = 0;
  }
  
  public static class MediaConfigKey
  {
    public static final int kConfigAutoRotate = 103;
    public static final int kConfigAvSyncDiscard = 53;
    public static final int kConfigCache = 50;
    public static final int kConfigEncodeMode = 104;
    public static final int kConfigHwDecoder = 51;
    public static final int kConfigHwEncoder = 52;
    public static final int kConfigLogLvl = 7;
    public static final int kConfigSwitchCode = 102;
    public static final int kConfigTraceAll = 1;
    public static final int kConfigTraceDecoder = 3;
    public static final int kConfigTraceFfmpeg = 6;
    public static final int kConfigTraceFormatter = 4;
    public static final int kConfigTraceFrames = 5;
    public static final int kConfigTraceParser = 2;
    public static final int kConfigTransitionCode = 101;
  }
  
  public static class MediaFormat
  {
    public static final int MFMT_AUDIO_DBL = 104;
    public static final int MFMT_AUDIO_DBLP = 108;
    public static final int MFMT_AUDIO_FLT = 103;
    public static final int MFMT_AUDIO_FLTP = 107;
    public static final int MFMT_AUDIO_S16 = 101;
    public static final int MFMT_AUDIO_S16P = 105;
    public static final int MFMT_AUDIO_S32 = 102;
    public static final int MFMT_AUDIO_S32P = 106;
    public static final int MFMT_NONE = -1;
    public static final int MFMT_VIDEO_ABGR32 = 55;
    public static final int MFMT_VIDEO_ARGB32 = 54;
    public static final int MFMT_VIDEO_BGR24 = 51;
    public static final int MFMT_VIDEO_BGRA32 = 53;
    public static final int MFMT_VIDEO_NV12 = 2;
    public static final int MFMT_VIDEO_NV21 = 3;
    public static final int MFMT_VIDEO_RGB24 = 50;
    public static final int MFMT_VIDEO_RGBA32 = 52;
    public static final int MFMT_VIDEO_YUV420P = 1;
    public static final int MFMT_VIDEO_YUVJ420P = 4;
  }
  
  public static class MediaLogLvl
  {
    public static final int kMediaLogDebug = 4;
    public static final int kMediaLogError = 1;
    public static final int kMediaLogInfo = 3;
    public static final int kMediaLogTrace = 5;
    public static final int kMediaLogWarn = 2;
  }
  
  public static class MediaType
  {
    public static final int MT_AUDIO = 0;
    public static final int MT_UNKNOW = -1;
    public static final int MT_VIDEO = 1;
  }
  
  public static class NotifyEventType
  {
    public static final int kNotifyEventLoaderProcess = 400;
    public static final int kNotifyEventPlayerBuffSize = 301;
    public static final int kNotifyEventPlayerPlayEnd = 302;
    public static final int kNotifyEventPlayerStats = 300;
    public static final int kNotifyEventRecorderStats = 200;
    public static final int kNotifyEventRecorderTimeUpdate = 201;
    public static final int kNotifyEventTypeLogTrace = 100;
    public static final int kNotifyEventTypeUnknow = 0;
  }
  
  public static class RequestEventType
  {
    public static final int kRequestEventEditorAddTrack = 202;
    public static final int kRequestEventEditorCreate = 200;
    public static final int kRequestEventEditorDelTrack = 204;
    public static final int kRequestEventEditorExport = 205;
    public static final int kRequestEventEditorGetTrack = 201;
    public static final int kRequestEventEditorRemove = 206;
    public static final int kRequestEventEditorUpdateTrack = 203;
    public static final int kRequestEventLoaderCreate = 500;
    public static final int kRequestEventLoaderRemove = 503;
    public static final int kRequestEventLoaderStart = 501;
    public static final int kRequestEventLoaderStop = 502;
    public static final int kRequestEventReaderCreate = 400;
    public static final int kRequestEventReaderRemove = 405;
    public static final int kRequestEventReaderSeek = 402;
    public static final int kRequestEventReaderStart = 401;
    public static final int kRequestEventReaderStop = 404;
    public static final int kRequestEventReaderWait = 403;
    public static final int kRequestEventTypeAnalysis = 101;
    public static final int kRequestEventTypeRemux = 102;
    public static final int kRequestEventTypeTest = 100;
    public static final int kRequestEventTypeUnknow = 0;
    public static final int kRequestEventWriterCreate = 300;
    public static final int kRequestEventWriterRemove = 304;
    public static final int kRequestEventWriterStart = 301;
    public static final int kRequestEventWriterStop = 303;
    public static final int kRequestEventWriterUpdate = 302;
  }
  
  public static class ResponseEventType
  {
    public static final int kResponseEventEditorAddTrack = 202;
    public static final int kResponseEventEditorCreate = 200;
    public static final int kResponseEventEditorDelTrack = 204;
    public static final int kResponseEventEditorExport = 205;
    public static final int kResponseEventEditorGetTrack = 201;
    public static final int kResponseEventEditorRemove = 206;
    public static final int kResponseEventEditorUpdateTrack = 203;
    public static final int kResponseEventLoaderCreate = 500;
    public static final int kResponseEventLoaderRemove = 503;
    public static final int kResponseEventLoaderStart = 501;
    public static final int kResponseEventLoaderStop = 502;
    public static final int kResponseEventReaderCreate = 400;
    public static final int kResponseEventReaderRemove = 404;
    public static final int kResponseEventReaderSeek = 402;
    public static final int kResponseEventReaderStart = 401;
    public static final int kResponseEventReaderStop = 403;
    public static final int kResponseEventTypeAnalysis = 101;
    public static final int kResponseEventTypeRemux = 102;
    public static final int kResponseEventTypeTest = 100;
    public static final int kResponseEventTypeUnknow = 0;
    public static final int kResponseEventWriterCreate = 300;
    public static final int kResponseEventWriterRemove = 304;
    public static final int kResponseEventWriterStart = 301;
    public static final int kResponseEventWriterStop = 303;
    public static final int kResponseEventWriterUpdate = 302;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.hilive.mediasdk.SdkInfo
 * JD-Core Version:    0.7.0.1
 */