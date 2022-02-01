package com.hilive.mediasdk;

public class SdkInfo
{
  public static final int kRatioBase = 10000;
  public static final int kTimeBase = 1000000;
  
  public static class ErrCode
  {
    public static final int kErrCodeEnd = 699;
    public static final int kErrCodeFailed = 601;
    public static final int kErrCodeFormatNotSupport = 609;
    public static final int kErrCodeInitDecoderFailed = 613;
    public static final int kErrCodeInitDemuxFailed = 611;
    public static final int kErrCodeInitEncoderFailed = 612;
    public static final int kErrCodeInitMuxerFailed = 610;
    public static final int kErrCodeInitResamplerFailed = 614;
    public static final int kErrCodeInterrupt = 606;
    public static final int kErrCodeMarshalFailed = 605;
    public static final int kErrCodeNoMedia = 615;
    public static final int kErrCodeNotFound = 608;
    public static final int kErrCodeNotSupport = 616;
    public static final int kErrCodeParmasInvalid = 607;
    public static final int kErrCodeRequestNotSupport = 603;
    public static final int kErrCodeSdkNotReady = 602;
    public static final int kErrCodeSuccess = 0;
    public static final int kErrCodeUnmarshalFailed = 604;
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
    public static final int kRequestEventEditorCreateContainer = 200;
    public static final int kRequestEventEditorCreateTrack = 202;
    public static final int kRequestEventEditorExport = 205;
    public static final int kRequestEventEditorGetTrack = 201;
    public static final int kRequestEventEditorRemoveContainer = 206;
    public static final int kRequestEventEditorRemoveTrack = 204;
    public static final int kRequestEventEditorUpdateTrack = 203;
    public static final int kRequestEventLoaderCreateContainer = 500;
    public static final int kRequestEventLoaderRemoveContainer = 503;
    public static final int kRequestEventLoaderStart = 501;
    public static final int kRequestEventLoaderStop = 502;
    public static final int kRequestEventPlayerCreateContainer = 400;
    public static final int kRequestEventPlayerRemoveContainer = 404;
    public static final int kRequestEventPlayerSeek = 402;
    public static final int kRequestEventPlayerStart = 401;
    public static final int kRequestEventPlayerStop = 403;
    public static final int kRequestEventRecorderAudio = 303;
    public static final int kRequestEventRecorderCreateContainer = 300;
    public static final int kRequestEventRecorderRemoveContainer = 306;
    public static final int kRequestEventRecorderStart = 301;
    public static final int kRequestEventRecorderStop = 305;
    public static final int kRequestEventRecorderUpdate = 302;
    public static final int kRequestEventRecorderVideo = 304;
    public static final int kRequestEventTypeAnalysis = 101;
    public static final int kRequestEventTypeRemux = 102;
    public static final int kRequestEventTypeTest = 100;
    public static final int kRequestEventTypeUnknow = 0;
  }
  
  public static class ResponseEventType
  {
    public static final int kResponseEventEditorCreateContainer = 200;
    public static final int kResponseEventEditorCreateTrack = 202;
    public static final int kResponseEventEditorExport = 205;
    public static final int kResponseEventEditorGetTrack = 201;
    public static final int kResponseEventEditorRemoveContainer = 206;
    public static final int kResponseEventEditorRemoveTrack = 204;
    public static final int kResponseEventEditorUpdateTrack = 203;
    public static final int kResponseEventLoaderCreateContainer = 500;
    public static final int kResponseEventLoaderRemoveContainer = 503;
    public static final int kResponseEventLoaderStart = 501;
    public static final int kResponseEventLoaderStop = 502;
    public static final int kResponseEventPlayerCreateContainer = 400;
    public static final int kResponseEventPlayerRemoveContainer = 404;
    public static final int kResponseEventPlayerSeek = 402;
    public static final int kResponseEventPlayerStart = 401;
    public static final int kResponseEventPlayerStop = 403;
    public static final int kResponseEventRecorderCreateContainer = 300;
    public static final int kResponseEventRecorderRemoveContainer = 304;
    public static final int kResponseEventRecorderStart = 301;
    public static final int kResponseEventRecorderStop = 303;
    public static final int kResponseEventRecorderUpdate = 302;
    public static final int kResponseEventTypeAnalysis = 101;
    public static final int kResponseEventTypeRemux = 102;
    public static final int kResponseEventTypeTest = 100;
    public static final int kResponseEventTypeUnknow = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.hilive.mediasdk.SdkInfo
 * JD-Core Version:    0.7.0.1
 */