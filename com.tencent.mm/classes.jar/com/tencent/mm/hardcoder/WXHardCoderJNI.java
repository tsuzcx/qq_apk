package com.tencent.mm.hardcoder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.format.Time;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class WXHardCoderJNI
{
  public static final long ACTION_ALLOC_MEMORY = 65536L;
  public static final long ACTION_ANIMATION = 2L;
  public static final long ACTION_DECODE_PIC = 64L;
  public static final long ACTION_DECODE_STREAM = 1024L;
  public static final long ACTION_DECODE_VIDEO = 256L;
  public static final long ACTION_DEXO2OAT = 1L;
  public static final long ACTION_ENCODE_PIC = 128L;
  public static final long ACTION_ENCODE_STREAM = 2048L;
  public static final long ACTION_ENCODE_VIDEO = 512L;
  public static final long ACTION_INIT_LISTVIEW = 16L;
  public static final long ACTION_NET_RX = 131072L;
  public static final long ACTION_NET_TX = 262144L;
  public static final long ACTION_ONCREATE = 4L;
  public static final long ACTION_ONDESTROY = 8L;
  public static final long ACTION_QUERY_SQL = 4096L;
  public static final long ACTION_READ_FILE = 16384L;
  public static final long ACTION_SCROLL_LISTVIEW = 32L;
  public static final long ACTION_WRITE_FILE = 32768L;
  public static final long ACTION_WRITE_SQL = 8192L;
  public static final long FLAG_ALBUM_SCROLL = 16384L;
  public static final long FLAG_ALL = -1L;
  public static final long FLAG_BOOT = 2L;
  public static final long FLAG_DB = 256L;
  public static final long FLAG_DECODE_PIC = 512L;
  public static final long FLAG_ENCODE_VIDEO = 4096L;
  public static final long FLAG_ENTER_CHATTING = 32L;
  public static final long FLAG_GIF_DROP_FRAME = 2048L;
  public static final long FLAG_GIF_INIT = 1024L;
  public static final long FLAG_MEDIA_GALLERY_SCROLL = 32768L;
  public static final long FLAG_QUIT_CHATTING = 64L;
  public static final long FLAG_RECEIVE_MSG = 4L;
  public static final long FLAG_SEND_MSG = 8L;
  public static final long FLAG_SEND_PIC_MSG = 16L;
  public static final long FLAG_SNS_MSG_SCROLL = 131072L;
  public static final long FLAG_SNS_SCROLL = 8192L;
  public static final long FLAG_SNS_USER_SCROLL = 65536L;
  public static final long FLAG_UPDATE_CHATROOM = 128L;
  public static final boolean HC_ENABLE_FOR_TEST = false;
  public static final String KEY_HC_ALBUM_SCROLL_ACTION = "KEY_HC_ALBUM_SCROLL_ACTION";
  public static final String KEY_HC_ALBUM_SCROLL_CPU = "KEY_HC_ALBUM_SCROLL_CPU";
  public static final String KEY_HC_ALBUM_SCROLL_DELEY = "KEY_HC_ALBUM_SCROLL_DELEY";
  public static final String KEY_HC_ALBUM_SCROLL_ENABLE = "KEY_HCALBUM_SCROLL_ENABLE";
  public static final String KEY_HC_ALBUM_SCROLL_IO = "KEY_HC_ALBUM_SCROLL_IO";
  public static final String KEY_HC_ALBUM_SCROLL_THR = "KEY_HC_ALBUM_SCROLL_THR";
  public static final String KEY_HC_ALBUM_SCROLL_TIMEOUT = "KEY_HC_ALBUM_SCROLL_TIMEOUT";
  public static final String KEY_HC_BEGIN_TIME_HOUR = "KEY_HC_BEGIN_TIME_HOUR";
  public static final String KEY_HC_BEGIN_TIME_MIN = "KEY_HC_BEGIN_TIME_MIN";
  public static final String KEY_HC_BG_ENABLE = "KEY_HC_BG_ENABLE";
  public static final String KEY_HC_BOOT_ACTION = "KEY_HC_BOOT_ACTION";
  public static final String KEY_HC_BOOT_CPU = "KEY_HC_BOOT_CPU";
  public static final String KEY_HC_BOOT_DELEY = "KEY_HC_BOOT_DELEY";
  public static final String KEY_HC_BOOT_ENABLE = "KEY_HC_BOOT_ENABLE";
  public static final String KEY_HC_BOOT_IO = "KEY_HC_BOOT_IO";
  public static final String KEY_HC_BOOT_THR = "KEY_HC_BOOT_THR";
  public static final String KEY_HC_BOOT_TIMEOUT = "KEY_HC_BOOT_TIMEOUT";
  public static final String KEY_HC_DB_ACTION_QUERY = "KEY_HC_DB_ACTION_QUERY";
  public static final String KEY_HC_DB_ACTION_WRITE = "KEY_HC_DB_ACTION_WRITE";
  public static final String KEY_HC_DB_CPU = "KEY_HC_DB_CPU";
  public static final String KEY_HC_DB_DELEY_QUERY = "KEY_HC_DB_DELEY_QUERY";
  public static final String KEY_HC_DB_DELEY_WRITE = "KEY_HC_DB_DELEY_WRITE";
  public static final String KEY_HC_DB_ENABLE = "KEY_HC_DB_ENABLE";
  public static final String KEY_HC_DB_IO = "KEY_HC_DB_IO";
  public static final String KEY_HC_DB_THR = "KEY_HC_DB_THR";
  public static final String KEY_HC_DB_TIMEOUT = "KEY_HC_DB_TIMEOUT";
  public static final String KEY_HC_DB_TIMEOUT_BUSY = "KEY_HC_DB_TIMEOUT_BUSY";
  public static final String KEY_HC_DEBUG = "KEY_HC_DEBUG";
  public static final String KEY_HC_DECODE_PIC_ACTION = "KEY_HC_DECODE_PIC_ACTION";
  public static final String KEY_HC_DECODE_PIC_CPU = "KEY_HC_DECODE_PIC_CPU";
  public static final String KEY_HC_DECODE_PIC_DELEY = "KEY_HC_DECODE_PIC_DELEY";
  public static final String KEY_HC_DECODE_PIC_ENABLE = "KEY_HC_DECODE_PIC_ENABLE";
  public static final String KEY_HC_DECODE_PIC_IO = "KEY_HC_DECODE_PIC_IO";
  public static final String KEY_HC_DECODE_PIC_THR = "KEY_HC_DECODE_PIC_THR";
  public static final String KEY_HC_DECODE_PIC_TIMEOUT = "KEY_HC_DECODE_PIC_TIMEOUT";
  public static final String KEY_HC_ENABLE = "KEY_HC_ENABLE";
  public static final String KEY_HC_ENCODE_VIDEO_ACTION = "KEY_HC_ENCODE_VIDEO_ACTION";
  public static final String KEY_HC_ENCODE_VIDEO_CPU = "KEY_HC_ENCODE_VIDEO_CPU";
  public static final String KEY_HC_ENCODE_VIDEO_DELEY = "KEY_HC_ENCODE_VIDEO_DELEY";
  public static final String KEY_HC_ENCODE_VIDEO_ENABLE = "KEY_HC_ENCODE_VIDEO_ENABLE";
  public static final String KEY_HC_ENCODE_VIDEO_IO = "KEY_HC_ENCODE_VIDEO_IO";
  public static final String KEY_HC_ENCODE_VIDEO_THR = "KEY_HC_ENCODE_VIDEO_THR";
  public static final String KEY_HC_ENCODE_VIDEO_TIMEOUT = "KEY_HC_ENCODE_VIDEO_TIMEOUT";
  public static final String KEY_HC_END_TIME_HOUR = "KEY_HC_END_TIME_HOUR";
  public static final String KEY_HC_END_TIME_MIN = "KEY_HC_END_TIME_MIN";
  public static final String KEY_HC_ENTER_CHATTING_ACTION = "KEY_HC_ENTER_CHATTING_ACTION";
  public static final String KEY_HC_ENTER_CHATTING_CPU = "KEY_HC_ENTER_CHATTING_CPU";
  public static final String KEY_HC_ENTER_CHATTING_DELEY = "KEY_HC_ENTER_CHATTING_DELEY";
  public static final String KEY_HC_ENTER_CHATTING_ENABLE = "KEY_HC_ENTER_CHATTING_ENABLE";
  public static final String KEY_HC_ENTER_CHATTING_IO = "KEY_HC_ENTER_CHATTING_IO";
  public static final String KEY_HC_ENTER_CHATTING_THR = "KEY_HC_ENTER_CHATTING_THR";
  public static final String KEY_HC_ENTER_CHATTING_TIMEOUT = "KEY_HC_ENTER_CHATTING_TIMEOUT";
  public static final String KEY_HC_GIF_ACTION = "KEY_HC_GIF_ACTION";
  public static final String KEY_HC_GIF_CPU = "KEY_HC_GIF_CPU";
  public static final String KEY_HC_GIF_DELEY = "KEY_HC_GIF_DELEY";
  public static final String KEY_HC_GIF_ENABLE = "KEY_HC_GIF_ENABLE";
  public static final String KEY_HC_GIF_FRAME_ACTION = "KEY_HC_GIF_FRAME_ACTION";
  public static final String KEY_HC_GIF_FRAME_CPU = "KEY_HC_GIF_FRAME_CPU";
  public static final String KEY_HC_GIF_FRAME_DELEY = "KEY_HC_GIF_FRAME_DELEY";
  public static final String KEY_HC_GIF_FRAME_ENABLE = "KEY_HC_GIF_FRAME_ENABLE";
  public static final String KEY_HC_GIF_FRAME_IO = "KEY_HC_GIF_FRAME_IO";
  public static final String KEY_HC_GIF_FRAME_THR = "KEY_HC_GIF_FRAME_THR";
  public static final String KEY_HC_GIF_FRAME_TIMEOUT = "KEY_HC_GIF_FRAME_TIMEOUT";
  public static final String KEY_HC_GIF_IO = "KEY_HC_GIF_IO";
  public static final String KEY_HC_GIF_THR = "KEY_HC_GIF_THR";
  public static final String KEY_HC_GIF_TIMEOUT = "KEY_HC_GIF_TIMEOUT";
  public static final String KEY_HC_KV_FT = "KEY_HC_KV_FT";
  public static final String KEY_HC_KV_PER = "KEY_HC_KV_PER";
  public static final String KEY_HC_MEDIA_GALLERY_SCROLL_ACTION = "KEY_HC_MEDIA_GALLERY_SCROLL_ACTION";
  public static final String KEY_HC_MEDIA_GALLERY_SCROLL_CPU = "KEY_HC_MEDIA_GALLERY_SCROLL_CPU";
  public static final String KEY_HC_MEDIA_GALLERY_SCROLL_DELEY = "KEY_HC_MEDIA_GALLERY_SCROLL_DELEY";
  public static final String KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE = "KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE";
  public static final String KEY_HC_MEDIA_GALLERY_SCROLL_IO = "KEY_HC_MEDIA_GALLERY_SCROLL_IO";
  public static final String KEY_HC_MEDIA_GALLERY_SCROLL_THR = "KEY_HC_MEDIA_GALLERY_SCROLL_THR";
  public static final String KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT = "KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT";
  public static final String KEY_HC_QUIT_CHATTING_ACTION = "KEY_HC_QUIT_CHATTING_ACTION";
  public static final String KEY_HC_QUIT_CHATTING_CPU = "KEY_HC_QUIT_CHATTING_CPU";
  public static final String KEY_HC_QUIT_CHATTING_DELEY = "KEY_HC_QUIT_CHATTING_DELEY";
  public static final String KEY_HC_QUIT_CHATTING_ENABLE = "KEY_HC_QUIT_CHATTING_ENABLE";
  public static final String KEY_HC_QUIT_CHATTING_IO = "KEY_HC_QUIT_CHATTING_IO";
  public static final String KEY_HC_QUIT_CHATTING_THR = "KEY_HC_QUIT_CHATTING_THR";
  public static final String KEY_HC_QUIT_CHATTING_TIMEOUT = "KEY_HC_QUIT_CHATTING_TIMEOUT";
  public static final String KEY_HC_RECEIVE_MSG_ACTION = "KEY_HC_RECEIVE_MSG_ACTION";
  public static final String KEY_HC_RECEIVE_MSG_CPU = "KEY_HC_RECEIVE_MSG_CPU";
  public static final String KEY_HC_RECEIVE_MSG_DELEY = "KEY_HC_RECEIVE_MSG_DELEY";
  public static final String KEY_HC_RECEIVE_MSG_ENABLE = "KEY_HC_RECEIVE_MSG_ENABLE";
  public static final String KEY_HC_RECEIVE_MSG_IO = "KEY_HC_RECEIVE_MSG_IO";
  public static final String KEY_HC_RECEIVE_MSG_THR = "KEY_HC_RECEIVE_MSG_THR";
  public static final String KEY_HC_RECEIVE_MSG_TIMEOUT = "KEY_HC_RECEIVE_MSG_TIMEOUT";
  public static final String KEY_HC_RETRY_INTERVAL = "KEY_HC_RETRY_INTERVAL";
  public static final String KEY_HC_SEND_MSG_ACTION = "KEY_HC_SEND_MSG_ACTION";
  public static final String KEY_HC_SEND_MSG_CPU = "KEY_HC_SEND_MSG_CPU";
  public static final String KEY_HC_SEND_MSG_DELEY = "KEY_HC_SEND_MSG_DELEY";
  public static final String KEY_HC_SEND_MSG_ENABLE = "KEY_HC_SEND_MSG_ENABLE";
  public static final String KEY_HC_SEND_MSG_IO = "KEY_HC_SEND_MSG_IO";
  public static final String KEY_HC_SEND_MSG_THR = "KEY_HC_SEND_MSG_THR";
  public static final String KEY_HC_SEND_MSG_TIMEOUT = "KEY_HC_SEND_MSG_TIMEOUT";
  public static final String KEY_HC_SEND_PIC_MSG_ACTION = "KEY_HC_SEND_PIC_MSG_ACTION";
  public static final String KEY_HC_SEND_PIC_MSG_CPU = "KEY_HC_SEND_PIC_MSG_CPU";
  public static final String KEY_HC_SEND_PIC_MSG_DELEY = "KEY_HC_SEND_PIC_MSG_DELEY";
  public static final String KEY_HC_SEND_PIC_MSG_ENABLE = "KEY_HC_SEND_PIC_MSG_ENABLE";
  public static final String KEY_HC_SEND_PIC_MSG_IO = "KEY_HC_SEND_PIC_MSG_IO";
  public static final String KEY_HC_SEND_PIC_MSG_THR = "KEY_HC_SEND_PIC_MSG_THR";
  public static final String KEY_HC_SEND_PIC_MSG_TIMEOUT = "KEY_HC_SEND_PIC_MSG_TIMEOUT";
  public static final String KEY_HC_SNS_MSG_SCROLL_ACTION = "KEY_HC_SNS_MSG_SCROLL_ACTION";
  public static final String KEY_HC_SNS_MSG_SCROLL_CPU = "KEY_HC_SNS_MSG_SCROLL_CPU";
  public static final String KEY_HC_SNS_MSG_SCROLL_DELEY = "KEY_HC_SNS_MSG_SCROLL_DELEY";
  public static final String KEY_HC_SNS_MSG_SCROLL_ENABLE = "KEY_HC_SNS_MSG_SCROLL_ENABLE";
  public static final String KEY_HC_SNS_MSG_SCROLL_IO = "KEY_HC_SNS_MSG_SCROLL_IO";
  public static final String KEY_HC_SNS_MSG_SCROLL_THR = "KEY_HC_SNS_MSG_SCROLL_THR";
  public static final String KEY_HC_SNS_MSG_SCROLL_TIMEOUT = "KEY_HC_SNS_MSG_SCROLL_TIMEOUT";
  public static final String KEY_HC_SNS_SCROLL_ACTION = "KEY_HC_SNS_SCROLL_ACTION";
  public static final String KEY_HC_SNS_SCROLL_CPU = "KEY_HC_SNS_SCROLL_CPU";
  public static final String KEY_HC_SNS_SCROLL_DELEY = "KEY_HC_SNS_SCROLL_DELEY";
  public static final String KEY_HC_SNS_SCROLL_ENABLE = "KEY_HC_SNS_SCROLL_ENABLE";
  public static final String KEY_HC_SNS_SCROLL_IO = "KEY_HC_SNS_SCROLL_IO";
  public static final String KEY_HC_SNS_SCROLL_THR = "KEY_HC_SNS_SCROLL_THR";
  public static final String KEY_HC_SNS_SCROLL_TIMEOUT = "KEY_HC_SNS_SCROLL_TIMEOUT";
  public static final String KEY_HC_SNS_USER_SCROLL_ACTION = "KEY_HC_SNS_USER_SCROLL_ACTION";
  public static final String KEY_HC_SNS_USER_SCROLL_CPU = "KEY_HC_SNS_USER_SCROLL_CPU";
  public static final String KEY_HC_SNS_USER_SCROLL_DELEY = "KEY_HC_SNS_USER_SCROLL_DELEY";
  public static final String KEY_HC_SNS_USER_SCROLL_ENABLE = "KEY_HC_SNS_USER_SCROLL_ENABLE";
  public static final String KEY_HC_SNS_USER_SCROLL_IO = "KEY_HC_SNS_USER_SCROLL_IO";
  public static final String KEY_HC_SNS_USER_SCROLL_THR = "KEY_HC_SNS_USER_SCROLL_THR";
  public static final String KEY_HC_SNS_USER_SCROLL_TIMEOUT = "KEY_HC_SNS_USER_SCROLL_TIMEOUT";
  public static final String KEY_HC_SWITCH_ENABLE = "KEY_HC_SWITCH_ENABLE";
  public static final String KEY_HC_TIMEOUT_MARGIN = "KEY_HC_TIMEOUT_MARGIN";
  public static final String KEY_HC_TIME_LIMIT = "KEY_HC_TIME_LIMIT";
  public static final String KEY_HC_UIN_HASH = "KEY_HC_UIN_HASH";
  public static final String KEY_HC_UPDATE_CHATROOM_ACTION = "KEY_HC_UPDATE_CHATROOM_ACTION";
  public static final String KEY_HC_UPDATE_CHATROOM_CPU = "KEY_HC_UPDATE_CHATROOM_CPU";
  public static final String KEY_HC_UPDATE_CHATROOM_DELEY = "KEY_HC_UPDATE_CHATROOM_DELEY";
  public static final String KEY_HC_UPDATE_CHATROOM_ENABLE = "KEY_HC_UPDATE_CHATROOM_ENABLE";
  public static final String KEY_HC_UPDATE_CHATROOM_IO = "KEY_HC_UPDATE_CHATROOM_IO";
  public static final String KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT = "KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT";
  public static final String KEY_HC_UPDATE_CHATROOM_THR = "KEY_HC_UPDATE_CHATROOM_THR";
  public static final String KEY_HC_UPDATE_CHATROOM_TIMEOUT = "KEY_HC_UPDATE_CHATROOM_TIMEOUT";
  public static int RELOAD_SCENE_ABTEST = 0;
  public static int RELOAD_SCENE_DAY_RECEIVER = 0;
  public static int RELOAD_SCENE_INIT = 0;
  public static int RELOAD_SCENE_POST_RESET = 0;
  public static int RELOAD_SCENE_SETTING = 0;
  public static final int SCENE_ALBUM_SCROLL = 702;
  public static final int SCENE_BOOT = 101;
  public static final int SCENE_DB = 501;
  public static final int SCENE_DECODE_PIC = 601;
  public static final int SCENE_ENCODE_VIDEO = 603;
  public static final int SCENE_ENTER_CHATTING = 301;
  public static final int SCENE_GIF = 602;
  public static final Map<Integer, Integer> SCENE_ID_MAP;
  public static final int SCENE_MEDIA_GALLERY_SCROLL = 703;
  public static final int SCENE_QUIT_CHATTING = 302;
  public static final int SCENE_RECEIVE_MSG = 201;
  public static final int SCENE_SEND_MSG = 202;
  public static final int SCENE_SEND_PIC_MSG = 203;
  public static final int SCENE_SNS_MSG_SCROLL = 705;
  public static final int SCENE_SNS_SCROLL = 701;
  public static final int SCENE_SNS_USER_SCROLL = 704;
  public static final int SCENE_UPDATE_CHATROOM = 401;
  public static final String SETTING_SP_FILE = "hardcoder_setting";
  public static final String SETTING_UI_ACTION = "com.tencent.mm.action.HARDCODER_SETTING";
  public static final boolean SETTING_UI_ENABLE = false;
  private static final String TAG = "MicroMsg.WXHardCoderJNI";
  public static HashMap<Long, String> flagKeyMap;
  public static boolean foreground = false;
  public static long hcAlbumScrollAction = 0L;
  public static int hcAlbumScrollCPU = 0;
  public static int hcAlbumScrollDelay = 0;
  public static boolean hcAlbumScrollEnable = false;
  public static int hcAlbumScrollIO = 0;
  public static boolean hcAlbumScrollThr = false;
  public static int hcAlbumScrollTimeout = 0;
  public static int hcBeginTimeHour = 0;
  public static int hcBeginTimeMin = 0;
  public static boolean hcBgEnable = false;
  public static long hcBootAction = 0L;
  public static int hcBootCPU = 0;
  public static int hcBootDelay = 0;
  public static boolean hcBootEnable = false;
  public static int hcBootIO = 0;
  public static boolean hcBootThr = false;
  public static int hcBootTimeout = 0;
  public static long hcDBActionQuery = 0L;
  public static long hcDBActionWrite = 0L;
  public static int hcDBCPU = 0;
  public static int hcDBDelayQuery = 0;
  public static int hcDBDelayWrite = 0;
  public static boolean hcDBEnable = false;
  public static int hcDBIO = 0;
  public static boolean hcDBThr = false;
  public static int hcDBTimeout = 0;
  public static int hcDBTimeoutBusy = 0;
  public static long hcDecodePicAction = 0L;
  public static int hcDecodePicCPU = 0;
  public static int hcDecodePicDelay = 0;
  public static boolean hcDecodePicEnable = false;
  public static int hcDecodePicIO = 0;
  public static boolean hcDecodePicThr = false;
  public static int hcDecodePicTimeout = 0;
  public static long hcEncodeVideoAction = 0L;
  public static int hcEncodeVideoCPU = 0;
  public static int hcEncodeVideoDelay = 0;
  public static boolean hcEncodeVideoEnable = false;
  public static int hcEncodeVideoIO = 0;
  public static boolean hcEncodeVideoThr = false;
  public static int hcEncodeVideoTimeout = 0;
  public static int hcEndTimeHour = 0;
  public static int hcEndTimeMin = 0;
  public static long hcEnterChattingAction = 0L;
  public static int hcEnterChattingCPU = 0;
  public static int hcEnterChattingDelay = 0;
  public static boolean hcEnterChattingEnable = false;
  public static int hcEnterChattingIO = 0;
  public static boolean hcEnterChattingThr = false;
  public static int hcEnterChattingTimeout = 0;
  public static long hcGifAction = 0L;
  public static int hcGifCPU = 0;
  public static int hcGifDelay = 0;
  public static boolean hcGifEnable = false;
  public static long hcGifFrameAction = 0L;
  public static int hcGifFrameCPU = 0;
  public static int hcGifFrameDelay = 0;
  public static boolean hcGifFrameEnable = false;
  public static int hcGifFrameIO = 0;
  public static boolean hcGifFrameThr = false;
  public static int hcGifFrameTimeout = 0;
  public static int hcGifIO = 0;
  public static boolean hcGifThr = false;
  public static int hcGifTimeout = 0;
  public static boolean hcKVFtReport = false;
  public static boolean hcKVPerReport = false;
  public static long hcMediaGalleryScrollAction = 0L;
  public static int hcMediaGalleryScrollCPU = 0;
  public static int hcMediaGalleryScrollDelay = 0;
  public static boolean hcMediaGalleryScrollEnable = false;
  public static int hcMediaGalleryScrollIO = 0;
  public static boolean hcMediaGalleryScrollThr = false;
  public static int hcMediaGalleryScrollTimeout = 0;
  public static long hcQuitChattingAction = 0L;
  public static int hcQuitChattingCPU = 0;
  public static int hcQuitChattingDelay = 0;
  public static boolean hcQuitChattingEnable = false;
  public static int hcQuitChattingIO = 0;
  public static boolean hcQuitChattingThr = false;
  public static int hcQuitChattingTimeout = 0;
  public static long hcReceiveMsgAction = 0L;
  public static int hcReceiveMsgCPU = 0;
  public static int hcReceiveMsgDelay = 0;
  public static boolean hcReceiveMsgEnable = false;
  public static int hcReceiveMsgIO = 0;
  public static boolean hcReceiveMsgThr = false;
  public static int hcReceiveMsgTimeout = 0;
  public static int hcRetryInterval = 0;
  public static long hcSNSMsgScrollAction = 0L;
  public static int hcSNSMsgScrollCPU = 0;
  public static int hcSNSMsgScrollDelay = 0;
  public static boolean hcSNSMsgScrollEnable = false;
  public static int hcSNSMsgScrollIO = 0;
  public static boolean hcSNSMsgScrollThr = false;
  public static int hcSNSMsgScrollTimeout = 0;
  public static long hcSNSScrollAction = 0L;
  public static int hcSNSScrollCPU = 0;
  public static int hcSNSScrollDelay = 0;
  public static boolean hcSNSScrollEnable = false;
  public static int hcSNSScrollIO = 0;
  public static boolean hcSNSScrollThr = false;
  public static int hcSNSScrollTimeout = 0;
  public static long hcSNSUserScrollAction = 0L;
  public static int hcSNSUserScrollCPU = 0;
  public static int hcSNSUserScrollDelay = 0;
  public static boolean hcSNSUserScrollEnable = false;
  public static int hcSNSUserScrollIO = 0;
  public static boolean hcSNSUserScrollThr = false;
  public static int hcSNSUserScrollTimeout = 0;
  public static long hcSendMsgAction = 0L;
  public static int hcSendMsgCPU = 0;
  public static int hcSendMsgDelay = 0;
  public static boolean hcSendMsgEnable = false;
  public static int hcSendMsgIO = 0;
  public static boolean hcSendMsgThr = false;
  public static int hcSendMsgTimeout = 0;
  public static long hcSendPicMsgAction = 0L;
  public static int hcSendPicMsgCPU = 0;
  public static int hcSendPicMsgDelay = 0;
  public static boolean hcSendPicMsgEnable = false;
  public static int hcSendPicMsgIO = 0;
  public static boolean hcSendPicMsgThr = false;
  public static int hcSendPicMsgTimeout = 0;
  public static boolean hcSwitchEnable = false;
  private static boolean hcSwitchOn = false;
  public static boolean hcTimeLimit = false;
  public static int hcTimeoutMargin = 0;
  public static int hcUinHash = 0;
  public static long hcUpdateChatroomAction = 0L;
  public static int hcUpdateChatroomCPU = 0;
  public static int hcUpdateChatroomDelay = 0;
  public static boolean hcUpdateChatroomEnable = false;
  public static int hcUpdateChatroomIO = 0;
  public static long hcUpdateChatroomMemberCount = 0L;
  public static boolean hcUpdateChatroomThr = false;
  public static int hcUpdateChatroomTimeout = 0;
  public static final long sHCALBUMSCROLLACTION = 96L;
  public static final int sHCALBUMSCROLLCPU = 3;
  public static final int sHCALBUMSCROLLDELAY = 0;
  public static final boolean sHCALBUMSCROLLENABLE = true;
  public static final int sHCALBUMSCROLLIO = 2;
  public static final boolean sHCALBUMSCROLLTHR = false;
  public static final int sHCALBUMSCROLLTIMEOUT = 1500;
  public static final int sHCBEGINHOUR = 8;
  public static final int sHCBEGINMIN = 0;
  public static final boolean sHCBGENABLE = true;
  public static final long sHCBOOTACTION = 4L;
  public static final int sHCBOOTCPU = 1;
  public static final int sHCBOOTDELAY = 0;
  public static final boolean sHCBOOTENABLE = true;
  public static final int sHCBOOTIO = 0;
  public static final boolean sHCBOOTTHR = false;
  public static final int sHCBOOTTIMEOUT = 5000;
  public static final long sHCDBACTION_QUERY = 4096L;
  public static final long sHCDBACTION_WRITE = 12288L;
  public static final int sHCDBCPU = 2;
  public static final int sHCDBDELAY_QUERY = 100;
  public static final int sHCDBDELAY_WRITE = 200;
  public static final boolean sHCDBENABLE = false;
  public static final int sHCDBIO = 2;
  public static final boolean sHCDBTHR = false;
  public static final int sHCDBTIMEOUT = 500;
  public static final int sHCDBTIMEOUT_BUSY = 5000;
  public static final long sHCDECODEPICACTION = 16448L;
  public static final int sHCDECODEPICCPU = 2;
  public static final int sHCDECODEPICDELAY = 100;
  public static final boolean sHCDECODEPICENABLE = false;
  public static final int sHCDECODEPICIO = 2;
  public static final boolean sHCDECODEPICTHR = false;
  public static final int sHCDECODEPICTIMEOUT = 500;
  public static final boolean sHCENABLE = true;
  public static final long sHCENCODEVIDEOACTION = 81984L;
  public static final int sHCENCODEVIDEOCPU = 1;
  public static final int sHCENCODEVIDEODELAY = 0;
  public static final boolean sHCENCODEVIDEOENABLE = true;
  public static final int sHCENCODEVIDEOIO = 1;
  public static final boolean sHCENCODEVIDEOTHR = false;
  public static final int sHCENCODEVIDEOTIMEOUT = 20000;
  public static final int sHCENDHOUR = 23;
  public static final int sHCENDMIN = 0;
  public static final long sHCENTERCHATTINGACTION = 12294L;
  public static final int sHCENTERCHATTINGCPU = 2;
  public static final int sHCENTERCHATTINGDELAY = 0;
  public static final boolean sHCENTERCHATTINGENABLE = true;
  public static final int sHCENTERCHATTINGIO = 2;
  public static final boolean sHCENTERCHATTINGTHR = false;
  public static final int sHCENTERCHATTINGTIMEOUT = 1000;
  public static final long sHCGIFACTION = 81984L;
  public static final int sHCGIFCPU = 3;
  public static final int sHCGIFDELAY = 0;
  public static final boolean sHCGIFENABLE = true;
  public static final long sHCGIFFRAMEACTION = 65600L;
  public static final int sHCGIFFRAMECPU = 2;
  public static final int sHCGIFFRAMEDELAY = 0;
  public static final boolean sHCGIFFRAMEENABLE = true;
  public static final int sHCGIFFRAMEIO = 0;
  public static final boolean sHCGIFFRAMETHR = false;
  public static final int sHCGIFFRAMETIMEOUT = 1000;
  public static final int sHCGIFIO = 2;
  public static final boolean sHCGIFTHR = false;
  public static final int sHCGIFTIMEOUT = 500;
  public static final long sHCMEDIAGALLERYSCROLLACTION = 96L;
  public static final int sHCMEDIAGALLERYSCROLLCPU = 3;
  public static final int sHCMEDIAGALLERYSCROLLDELAY = 0;
  public static final boolean sHCMEDIAGALLERYSCROLLENABLE = true;
  public static final int sHCMEDIAGALLERYSCROLLIO = 2;
  public static final boolean sHCMEDIAGALLERYSCROLLTHR = false;
  public static final int sHCMEDIAGALLERYSCROLLTIMEOUT = 1500;
  public static final long sHCQUITCHATTINGACTION = 8194L;
  public static final int sHCQUITCHATTINGCPU = 2;
  public static final int sHCQUITCHATTINGDELAY = 0;
  public static final boolean sHCQUITCHATTINGENABLE = true;
  public static final int sHCQUITCHATTINGIO = 2;
  public static final boolean sHCQUITCHATTINGTHR = false;
  public static final int sHCQUITCHATTINGTIMEOUT = 800;
  public static final long sHCRECEIVEMSGACTION = 127040L;
  public static final int sHCRECEIVEMSGCPU = 2;
  public static final int sHCRECEIVEMSGDELAY = 500;
  public static final boolean sHCRECEIVEMSGENABLE = true;
  public static final int sHCRECEIVEMSGIO = 2;
  public static final boolean sHCRECEIVEMSGTHR = true;
  public static final int sHCRECEIVEMSGTIMEOUT = 1000;
  public static boolean sHCREPORT = false;
  public static final long sHCSENDMSGACTION = 12288L;
  public static final int sHCSENDMSGCPU = 3;
  public static final int sHCSENDMSGDELAY = 0;
  public static final boolean sHCSENDMSGENABLE = true;
  public static final int sHCSENDMSGIO = 0;
  public static final boolean sHCSENDMSGTHR = true;
  public static final int sHCSENDMSGTIMEOUT = 1000;
  public static final long sHCSENDPICMSGACTION = 123072L;
  public static final int sHCSENDPICMSGCPU = 1;
  public static final int sHCSENDPICMSGDELAY = 0;
  public static final boolean sHCSENDPICMSGENABLE = true;
  public static final int sHCSENDPICMSGIO = 2;
  public static final boolean sHCSENDPICMSGTHR = true;
  public static final int sHCSENDPICMSGTIMEOUT = 500;
  public static final long sHCSNSMSGSCROLLACTION = 96L;
  public static final int sHCSNSMSGSCROLLCPU = 3;
  public static final int sHCSNSMSGSCROLLDELAY = 0;
  public static final boolean sHCSNSMSGSCROLLENABLE = true;
  public static final int sHCSNSMSGSCROLLIO = 2;
  public static final boolean sHCSNSMSGSCROLLTHR = false;
  public static final int sHCSNSMSGSCROLLTIMEOUT = 1500;
  public static final long sHCSNSSCROLLACTION = 96L;
  public static final int sHCSNSSCROLLCPU = 3;
  public static final int sHCSNSSCROLLDELAY = 0;
  public static final boolean sHCSNSSCROLLENABLE = true;
  public static final int sHCSNSSCROLLIO = 2;
  public static final boolean sHCSNSSCROLLTHR = false;
  public static final int sHCSNSSCROLLTIMEOUT = 1500;
  public static final long sHCSNSUSERSCROLLACTION = 96L;
  public static final int sHCSNSUSERSCROLLCPU = 3;
  public static final int sHCSNSUSERSCROLLDELAY = 0;
  public static final boolean sHCSNSUSERSCROLLENABLE = true;
  public static final int sHCSNSUSERSCROLLIO = 2;
  public static final boolean sHCSNSUSERSCROLLTHR = false;
  public static final int sHCSNSUSERSCROLLTIMEOUT = 1500;
  public static final boolean sHCSWITCHENABLE = true;
  public static final boolean sHCTIMELIMIT = false;
  public static final int sHCUINHASH = 0;
  public static final long sHCUPDATECHATROOMACTION = 127040L;
  public static final int sHCUPDATECHATROOMCPU = 2;
  public static final int sHCUPDATECHATROOMDELAY = 0;
  public static final boolean sHCUPDATECHATROOMENABLE = true;
  public static final int sHCUPDATECHATROOMIO = 2;
  public static final int sHCUPDATECHATROOMMEMBERCOUNT = 50;
  public static final boolean sHCUPDATECHATROOMTHR = true;
  public static final int sHCUPDATECHATROOMTIMEOUT = 1000;
  public static final int sRETRYINTERVAL = 30;
  public static final int sTIMEOUTMARGIN = 0;
  private static HardCoderJNI.SceneReportCallback sceneReportCallback = new HardCoderJNI.SceneReportCallback()
  {
    public final void sceneReport(int paramAnonymousInt, long paramAnonymousLong)
    {
      HardCoderJNI.reportInfo(new g(paramAnonymousInt));
    }
  };
  
  static
  {
    HashMap localHashMap = new HashMap();
    SCENE_ID_MAP = localHashMap;
    localHashMap.clear();
    SCENE_ID_MAP.put(Integer.valueOf(101), Integer.valueOf(1));
    SCENE_ID_MAP.put(Integer.valueOf(201), Integer.valueOf(2));
    SCENE_ID_MAP.put(Integer.valueOf(202), Integer.valueOf(3));
    SCENE_ID_MAP.put(Integer.valueOf(203), Integer.valueOf(4));
    SCENE_ID_MAP.put(Integer.valueOf(301), Integer.valueOf(5));
    SCENE_ID_MAP.put(Integer.valueOf(302), Integer.valueOf(6));
    SCENE_ID_MAP.put(Integer.valueOf(401), Integer.valueOf(7));
    SCENE_ID_MAP.put(Integer.valueOf(501), Integer.valueOf(8));
    SCENE_ID_MAP.put(Integer.valueOf(601), Integer.valueOf(9));
    SCENE_ID_MAP.put(Integer.valueOf(602), Integer.valueOf(10));
    SCENE_ID_MAP.put(Integer.valueOf(603), Integer.valueOf(11));
    SCENE_ID_MAP.put(Integer.valueOf(701), Integer.valueOf(12));
    SCENE_ID_MAP.put(Integer.valueOf(702), Integer.valueOf(13));
    SCENE_ID_MAP.put(Integer.valueOf(703), Integer.valueOf(14));
    SCENE_ID_MAP.put(Integer.valueOf(704), Integer.valueOf(15));
    SCENE_ID_MAP.put(Integer.valueOf(705), Integer.valueOf(16));
    foreground = false;
    hcBgEnable = true;
    hcRetryInterval = 30;
    hcUinHash = 0;
    hcTimeoutMargin = 0;
    sHCREPORT = false;
    hcKVPerReport = false;
    hcKVFtReport = sHCREPORT;
    hcSwitchEnable = true;
    hcSwitchOn = true;
    hcTimeLimit = false;
    hcBeginTimeHour = 8;
    hcBeginTimeMin = 0;
    hcEndTimeHour = 23;
    hcEndTimeMin = 0;
    hcBootEnable = true;
    hcBootDelay = 0;
    hcBootCPU = 1;
    hcBootIO = 0;
    hcBootThr = false;
    hcBootTimeout = 5000;
    hcBootAction = 4L;
    hcEnterChattingEnable = true;
    hcEnterChattingDelay = 0;
    hcEnterChattingCPU = 2;
    hcEnterChattingIO = 2;
    hcEnterChattingThr = false;
    hcEnterChattingTimeout = 1000;
    hcEnterChattingAction = 12294L;
    hcQuitChattingEnable = true;
    hcQuitChattingDelay = 0;
    hcQuitChattingCPU = 2;
    hcQuitChattingIO = 2;
    hcQuitChattingThr = false;
    hcQuitChattingTimeout = 800;
    hcQuitChattingAction = 8194L;
    hcSendMsgEnable = true;
    hcSendMsgDelay = 0;
    hcSendMsgCPU = 3;
    hcSendMsgIO = 0;
    hcSendMsgThr = true;
    hcSendMsgTimeout = 1000;
    hcSendMsgAction = 12288L;
    hcSendPicMsgEnable = true;
    hcSendPicMsgDelay = 0;
    hcSendPicMsgCPU = 1;
    hcSendPicMsgIO = 2;
    hcSendPicMsgThr = true;
    hcSendPicMsgTimeout = 500;
    hcSendPicMsgAction = 123072L;
    hcReceiveMsgEnable = true;
    hcReceiveMsgDelay = 500;
    hcReceiveMsgCPU = 2;
    hcReceiveMsgIO = 2;
    hcReceiveMsgThr = true;
    hcReceiveMsgTimeout = 1000;
    hcReceiveMsgAction = 127040L;
    hcUpdateChatroomEnable = true;
    hcUpdateChatroomDelay = 0;
    hcUpdateChatroomCPU = 2;
    hcUpdateChatroomIO = 2;
    hcUpdateChatroomThr = true;
    hcUpdateChatroomTimeout = 1000;
    hcUpdateChatroomAction = 127040L;
    hcUpdateChatroomMemberCount = 50L;
    hcDBEnable = false;
    hcDBDelayQuery = 100;
    hcDBDelayWrite = 200;
    hcDBCPU = 2;
    hcDBIO = 2;
    hcDBThr = false;
    hcDBTimeout = 500;
    hcDBTimeoutBusy = 5000;
    hcDBActionQuery = 4096L;
    hcDBActionWrite = 12288L;
    hcEncodeVideoEnable = true;
    hcEncodeVideoDelay = 0;
    hcEncodeVideoCPU = 1;
    hcEncodeVideoIO = 1;
    hcEncodeVideoThr = false;
    hcEncodeVideoTimeout = 20000;
    hcEncodeVideoAction = 81984L;
    hcDecodePicEnable = false;
    hcDecodePicDelay = 100;
    hcDecodePicCPU = 2;
    hcDecodePicIO = 2;
    hcDecodePicThr = false;
    hcDecodePicTimeout = 500;
    hcDecodePicAction = 16448L;
    hcGifEnable = true;
    hcGifDelay = 0;
    hcGifCPU = 3;
    hcGifIO = 2;
    hcGifThr = false;
    hcGifTimeout = 500;
    hcGifAction = 81984L;
    hcGifFrameEnable = true;
    hcGifFrameDelay = 0;
    hcGifFrameCPU = 2;
    hcGifFrameIO = 0;
    hcGifFrameThr = false;
    hcGifFrameTimeout = 1000;
    hcGifFrameAction = 65600L;
    hcSNSScrollEnable = true;
    hcSNSScrollDelay = 0;
    hcSNSScrollCPU = 3;
    hcSNSScrollIO = 2;
    hcSNSScrollThr = false;
    hcSNSScrollTimeout = 1500;
    hcSNSScrollAction = 96L;
    hcSNSUserScrollEnable = true;
    hcSNSUserScrollDelay = 0;
    hcSNSUserScrollCPU = 3;
    hcSNSUserScrollIO = 2;
    hcSNSUserScrollThr = false;
    hcSNSUserScrollTimeout = 1500;
    hcSNSUserScrollAction = 96L;
    hcSNSMsgScrollEnable = true;
    hcSNSMsgScrollDelay = 0;
    hcSNSMsgScrollCPU = 3;
    hcSNSMsgScrollIO = 2;
    hcSNSMsgScrollThr = false;
    hcSNSMsgScrollTimeout = 1500;
    hcSNSMsgScrollAction = 96L;
    hcMediaGalleryScrollEnable = true;
    hcMediaGalleryScrollDelay = 0;
    hcMediaGalleryScrollCPU = 3;
    hcMediaGalleryScrollIO = 2;
    hcMediaGalleryScrollThr = false;
    hcMediaGalleryScrollTimeout = 1500;
    hcMediaGalleryScrollAction = 96L;
    hcAlbumScrollEnable = true;
    hcAlbumScrollDelay = 0;
    hcAlbumScrollCPU = 3;
    hcAlbumScrollIO = 2;
    hcAlbumScrollThr = false;
    hcAlbumScrollTimeout = 1500;
    hcAlbumScrollAction = 96L;
    flagKeyMap = new HashMap();
    RELOAD_SCENE_INIT = 0;
    RELOAD_SCENE_SETTING = 1;
    RELOAD_SCENE_POST_RESET = 2;
    RELOAD_SCENE_DAY_RECEIVER = 3;
    RELOAD_SCENE_ABTEST = 4;
    flagKeyMap.put(Long.valueOf(2L), "KEY_HC_BOOT_ENABLE");
    flagKeyMap.put(Long.valueOf(4L), "KEY_HC_RECEIVE_MSG_ENABLE");
    flagKeyMap.put(Long.valueOf(8L), "KEY_HC_SEND_MSG_ENABLE");
    flagKeyMap.put(Long.valueOf(16L), "KEY_HC_SEND_PIC_MSG_ENABLE");
    flagKeyMap.put(Long.valueOf(32L), "KEY_HC_ENTER_CHATTING_ENABLE");
    flagKeyMap.put(Long.valueOf(64L), "KEY_HC_QUIT_CHATTING_ENABLE");
    flagKeyMap.put(Long.valueOf(128L), "KEY_HC_UPDATE_CHATROOM_ENABLE");
    flagKeyMap.put(Long.valueOf(256L), "KEY_HC_DB_ENABLE");
    flagKeyMap.put(Long.valueOf(512L), "KEY_HC_DECODE_PIC_ENABLE");
    flagKeyMap.put(Long.valueOf(1024L), "KEY_HC_GIF_ENABLE");
    flagKeyMap.put(Long.valueOf(2048L), "KEY_HC_GIF_FRAME_ENABLE");
    flagKeyMap.put(Long.valueOf(4096L), "KEY_HC_ENCODE_VIDEO_ENABLE");
    flagKeyMap.put(Long.valueOf(8192L), "KEY_HC_SNS_SCROLL_ENABLE");
    flagKeyMap.put(Long.valueOf(16384L), "KEY_HCALBUM_SCROLL_ENABLE");
    flagKeyMap.put(Long.valueOf(32768L), "KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE");
    flagKeyMap.put(Long.valueOf(65536L), "KEY_HC_SNS_USER_SCROLL_ENABLE");
    flagKeyMap.put(Long.valueOf(131072L), "KEY_HC_SNS_MSG_SCROLL_ENABLE");
    reloadSPConfig(RELOAD_SCENE_INIT);
  }
  
  public static boolean checkHardCoderEnv()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    String str3 = readServerAddr(false);
    y.i("MicroMsg.WXHardCoderJNI", "checkHardCoderEnv manufacture[%s] model[%s] remote[%s]", new Object[] { str1, str2, str3 });
    return !bk.bl(str3);
  }
  
  public static boolean getCheckEnv()
  {
    return HardCoderJNI.checkEnv;
  }
  
  public static boolean getDebug()
  {
    return HardCoderJNI.hcDebug;
  }
  
  public static boolean getEnable()
  {
    return HardCoderJNI.hcEnable;
  }
  
  public static int initHardCoder()
  {
    if (!ae.cqV())
    {
      y.w("MicroMsg.WXHardCoderJNI", "initHardCoder error process[%s]  ret -1 stack[%s]", new Object[] { ae.getProcessName(), bk.csb() });
      return -1;
    }
    if (!isHCEnable())
    {
      y.i("MicroMsg.WXHardCoderJNI", "initHardCoder isHCEnable false  hcEnable hcSwitchEnable hcSwitchOn checkEnv[%b, %b, %b, %b] ret -2", new Object[] { Boolean.valueOf(HardCoderJNI.hcEnable), Boolean.valueOf(hcSwitchEnable), Boolean.valueOf(hcSwitchOn), Boolean.valueOf(HardCoderJNI.checkEnv) });
      return -3;
    }
    HardCoderJNI.TICK_RATE = HardCoderJNI.getTickRate();
    HardCoderJNI.setDebug(HardCoderJNI.hcDebug);
    HardCoderJNI.setHCEnable(isHCEnable());
    y.i("MicroMsg.WXHardCoderJNI", "initHardCoder hcDebug[%b] hcEnable[%b] checkEnv[%b] TICK_RATE[%d]", new Object[] { Boolean.valueOf(HardCoderJNI.hcDebug), Boolean.valueOf(HardCoderJNI.hcEnable), Boolean.valueOf(HardCoderJNI.checkEnv), Integer.valueOf(HardCoderJNI.TICK_RATE) });
    return HardCoderJNI.initHardCoder(readServerAddr(false), 0, ae.getPackageName() + ".hardcoder.client.sock", true);
  }
  
  public static void initHardCoderParams(i parami)
  {
    h.a(parami);
    c.a(new m());
    HardCoderJNI.setSceneReportCallback(sceneReportCallback);
  }
  
  private static boolean isActiveTime()
  {
    if (!hcTimeLimit) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    do
    {
      do
      {
        do
        {
          return true;
          Time localTime = new Time();
          localTime.setToNow();
          i = localTime.hour;
          j = localTime.minute;
          k = hcBeginTimeHour;
          m = hcBeginTimeMin;
          n = hcEndTimeHour;
          i1 = hcEndTimeMin;
          if ((k == n) && (m == i1)) {
            return false;
          }
          if ((k != n) || (m >= i1)) {
            break;
          }
        } while ((i == k) && (j > m) && (j < i1));
        return false;
        if (n <= k) {
          break;
        }
      } while (((i > k) && (i < n)) || ((i == k) && (j > m)) || ((i == n) && (j < i1)));
      return false;
    } while (((n >= k) && ((k != n) || (m <= i1))) || ((i > k) && (i <= 23)) || ((i == k) && (j > m)) || ((i == n) && (j < i1)) || ((i > 0) && (i < n)));
    return false;
  }
  
  public static boolean isHCEnable()
  {
    return ((HardCoderJNI.checkEnv & HardCoderJNI.hcEnable)) && ((!hcSwitchEnable) || (hcSwitchOn));
  }
  
  public static int isRunning()
  {
    return HardCoderJNI.isRunning();
  }
  
  public static void onData(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    h.a(paramInt1, paramLong, paramInt2, paramInt3, paramInt4);
    HardCoderJNI.onData(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramArrayOfByte);
  }
  
  public static String readServerAddr(boolean paramBoolean)
  {
    int i = 2;
    try
    {
      String str = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop persist.sys.hardcoder.name").getInputStream())).readLine();
      y.i("MicroMsg.WXHardCoderJNI", "readServerAddr Read prop[%s] result[%s] stack[%s]", new Object[] { "persist.sys.hardcoder.name", str, bk.csb() });
      if (paramBoolean)
      {
        if (bk.bl(str)) {
          i = 1;
        }
        HardCoderJNI.reportInfo(new g(true, i, 1, false));
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.WXHardCoderJNI", localThrowable, "readServerAddr", new Object[0]);
      if (paramBoolean) {
        HardCoderJNI.reportInfo(new g(true, 3, 1, false));
      }
    }
    return "";
  }
  
  public static int registerANRCallback(HardCoderJNI.Callback paramCallback)
  {
    if (!HardCoderJNI.checkEnv) {
      return -2;
    }
    return HardCoderJNI.registerANRCallback(paramCallback);
  }
  
  public static void reloadSPConfig(int paramInt)
  {
    if (!ae.cqV())
    {
      y.i("MicroMsg.WXHardCoderJNI", "reloadSPConfig but not mm return stack[%s]", new Object[] { bk.csb() });
      return;
    }
    HardCoderJNI.initHCPerfManager(new HardCoderJNI.HCPerfManagerThread()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable, String paramAnonymousString, int paramAnonymousInt)
      {
        return e.c(paramAnonymousRunnable, paramAnonymousString, paramAnonymousInt);
      }
    }, ae.getContext());
    setDebug(false);
    HardCoderJNI.checkEnv = checkHardCoderEnv();
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("hardcoder_setting", 0);
    HardCoderJNI.hcEnable = localSharedPreferences.getBoolean("KEY_HC_ENABLE", true);
    if (HardCoderJNI.checkEnv) {
      HardCoderJNI.setHCEnable(HardCoderJNI.hcEnable);
    }
    hcBgEnable = localSharedPreferences.getBoolean("KEY_HC_BG_ENABLE", true);
    hcUinHash = localSharedPreferences.getInt("KEY_HC_UIN_HASH", 0);
    boolean bool = localSharedPreferences.getBoolean("KEY_HC_SWITCH_ENABLE", true);
    hcSwitchEnable = bool;
    hcSwitchOn = bool;
    int i;
    if ((HardCoderJNI.hcEnable) && (hcSwitchEnable))
    {
      if (Calendar.getInstance().get(5) % 2 != 1) {
        break label2199;
      }
      bool = true;
      hcSwitchOn = bool;
      if (HardCoderJNI.checkEnv)
      {
        HardCoderJNI.setHCEnable(hcSwitchOn);
        if (!hcSwitchOn) {
          break label2204;
        }
        i = 8;
        label180:
        reportIDKey(true, i, 1, false);
      }
    }
    HardCoderJNI.hcDebug = localSharedPreferences.getBoolean("KEY_HC_DEBUG", false);
    y.i("MicroMsg.WXHardCoderJNI", "reloadSPConfig scene:%d hcDebug:%b hcEnable:%b hcUinHash:%d hcSwitchEnable:%b hcSwitchOn:%b checkEnv:%b stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(HardCoderJNI.hcDebug), Boolean.valueOf(HardCoderJNI.hcEnable), Integer.valueOf(hcUinHash), Boolean.valueOf(hcSwitchEnable), Boolean.valueOf(hcSwitchOn), Boolean.valueOf(HardCoderJNI.checkEnv), bk.csb() });
    hcRetryInterval = localSharedPreferences.getInt("KEY_HC_RETRY_INTERVAL", 30);
    if (localSharedPreferences.getInt("KEY_HC_KV_PER", 0) < hcUinHash)
    {
      bool = true;
      label313:
      hcKVPerReport = bool;
      if (localSharedPreferences.getInt("KEY_HC_KV_FT", 0) >= hcUinHash) {
        break label2215;
      }
    }
    label2199:
    label2204:
    label2215:
    for (bool = true;; bool = false)
    {
      hcKVFtReport = bool;
      hcTimeoutMargin = localSharedPreferences.getInt("KEY_HC_TIMEOUT_MARGIN", 0);
      hcTimeLimit = localSharedPreferences.getBoolean("KEY_HC_TIME_LIMIT", false);
      hcBeginTimeHour = localSharedPreferences.getInt("KEY_HC_BEGIN_TIME_HOUR", 8);
      hcBeginTimeMin = localSharedPreferences.getInt("KEY_HC_BEGIN_TIME_MIN", 0);
      hcEndTimeHour = localSharedPreferences.getInt("KEY_HC_END_TIME_HOUR", 23);
      hcEndTimeMin = localSharedPreferences.getInt("KEY_HC_END_TIME_MIN", 0);
      hcBootEnable = localSharedPreferences.getBoolean("KEY_HC_BOOT_ENABLE", true);
      hcBootDelay = localSharedPreferences.getInt("KEY_HC_BOOT_DELEY", 0);
      hcBootCPU = localSharedPreferences.getInt("KEY_HC_BOOT_CPU", 1);
      hcBootIO = localSharedPreferences.getInt("KEY_HC_BOOT_IO", 0);
      hcBootThr = localSharedPreferences.getBoolean("KEY_HC_BOOT_THR", false);
      hcBootTimeout = localSharedPreferences.getInt("KEY_HC_BOOT_TIMEOUT", 5000);
      hcBootAction = localSharedPreferences.getLong("KEY_HC_BOOT_ACTION", 4L);
      hcEnterChattingEnable = localSharedPreferences.getBoolean("KEY_HC_ENTER_CHATTING_ENABLE", true);
      hcEnterChattingDelay = localSharedPreferences.getInt("KEY_HC_ENTER_CHATTING_DELEY", 0);
      hcEnterChattingCPU = localSharedPreferences.getInt("KEY_HC_ENTER_CHATTING_CPU", 2);
      hcEnterChattingIO = localSharedPreferences.getInt("KEY_HC_ENTER_CHATTING_IO", 2);
      hcEnterChattingThr = localSharedPreferences.getBoolean("KEY_HC_ENTER_CHATTING_THR", false);
      hcEnterChattingTimeout = localSharedPreferences.getInt("KEY_HC_ENTER_CHATTING_TIMEOUT", 1000);
      hcEnterChattingAction = localSharedPreferences.getLong("KEY_HC_ENTER_CHATTING_ACTION", 12294L);
      hcQuitChattingEnable = localSharedPreferences.getBoolean("KEY_HC_QUIT_CHATTING_ENABLE", true);
      hcQuitChattingDelay = localSharedPreferences.getInt("KEY_HC_QUIT_CHATTING_DELEY", 0);
      hcQuitChattingCPU = localSharedPreferences.getInt("KEY_HC_QUIT_CHATTING_CPU", 2);
      hcQuitChattingIO = localSharedPreferences.getInt("KEY_HC_QUIT_CHATTING_IO", 2);
      hcQuitChattingThr = localSharedPreferences.getBoolean("KEY_HC_QUIT_CHATTING_THR", false);
      hcQuitChattingTimeout = localSharedPreferences.getInt("KEY_HC_QUIT_CHATTING_TIMEOUT", 800);
      hcQuitChattingAction = localSharedPreferences.getLong("KEY_HC_QUIT_CHATTING_ACTION", 8194L);
      hcSendMsgEnable = localSharedPreferences.getBoolean("KEY_HC_SEND_MSG_ENABLE", true);
      hcSendMsgDelay = localSharedPreferences.getInt("KEY_HC_SEND_MSG_DELEY", 0);
      hcSendMsgCPU = localSharedPreferences.getInt("KEY_HC_SEND_MSG_CPU", 3);
      hcSendMsgIO = localSharedPreferences.getInt("KEY_HC_SEND_MSG_IO", 0);
      hcSendMsgThr = localSharedPreferences.getBoolean("KEY_HC_SEND_MSG_THR", true);
      hcSendMsgTimeout = localSharedPreferences.getInt("KEY_HC_SEND_MSG_TIMEOUT", 1000);
      hcSendMsgAction = localSharedPreferences.getLong("KEY_HC_SEND_MSG_ACTION", 12288L);
      hcSendPicMsgEnable = localSharedPreferences.getBoolean("KEY_HC_SEND_PIC_MSG_ENABLE", true);
      hcSendPicMsgDelay = localSharedPreferences.getInt("KEY_HC_SEND_PIC_MSG_DELEY", 0);
      hcSendPicMsgCPU = localSharedPreferences.getInt("KEY_HC_SEND_PIC_MSG_CPU", 1);
      hcSendPicMsgIO = localSharedPreferences.getInt("KEY_HC_SEND_PIC_MSG_IO", 2);
      hcSendPicMsgThr = localSharedPreferences.getBoolean("KEY_HC_SEND_PIC_MSG_THR", true);
      hcSendPicMsgTimeout = localSharedPreferences.getInt("KEY_HC_SEND_PIC_MSG_TIMEOUT", 500);
      hcSendPicMsgAction = localSharedPreferences.getLong("KEY_HC_SEND_PIC_MSG_ACTION", 123072L);
      hcReceiveMsgEnable = localSharedPreferences.getBoolean("KEY_HC_RECEIVE_MSG_ENABLE", true);
      hcReceiveMsgDelay = localSharedPreferences.getInt("KEY_HC_RECEIVE_MSG_DELEY", 500);
      hcReceiveMsgCPU = localSharedPreferences.getInt("KEY_HC_RECEIVE_MSG_CPU", 2);
      hcReceiveMsgIO = localSharedPreferences.getInt("KEY_HC_RECEIVE_MSG_IO", 2);
      hcReceiveMsgThr = localSharedPreferences.getBoolean("KEY_HC_RECEIVE_MSG_THR", true);
      hcReceiveMsgTimeout = localSharedPreferences.getInt("KEY_HC_RECEIVE_MSG_TIMEOUT", 1000);
      hcReceiveMsgAction = localSharedPreferences.getLong("KEY_HC_RECEIVE_MSG_ACTION", 127040L);
      hcUpdateChatroomEnable = localSharedPreferences.getBoolean("KEY_HC_UPDATE_CHATROOM_ENABLE", true);
      hcUpdateChatroomDelay = localSharedPreferences.getInt("KEY_HC_UPDATE_CHATROOM_DELEY", 0);
      hcUpdateChatroomCPU = localSharedPreferences.getInt("KEY_HC_UPDATE_CHATROOM_CPU", 2);
      hcUpdateChatroomIO = localSharedPreferences.getInt("KEY_HC_UPDATE_CHATROOM_IO", 2);
      hcUpdateChatroomThr = localSharedPreferences.getBoolean("KEY_HC_UPDATE_CHATROOM_THR", true);
      hcUpdateChatroomTimeout = localSharedPreferences.getInt("KEY_HC_UPDATE_CHATROOM_TIMEOUT", 1000);
      hcUpdateChatroomAction = localSharedPreferences.getLong("KEY_HC_UPDATE_CHATROOM_ACTION", 127040L);
      hcUpdateChatroomMemberCount = localSharedPreferences.getLong("KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT", 50L);
      hcDBEnable = localSharedPreferences.getBoolean("KEY_HC_DB_ENABLE", false);
      hcDBDelayQuery = localSharedPreferences.getInt("KEY_HC_DB_DELEY_QUERY", 100);
      hcDBDelayWrite = localSharedPreferences.getInt("KEY_HC_DB_DELEY_WRITE", 200);
      hcDBCPU = localSharedPreferences.getInt("KEY_HC_DB_CPU", 2);
      hcDBIO = localSharedPreferences.getInt("KEY_HC_DB_IO", 2);
      hcDBThr = localSharedPreferences.getBoolean("KEY_HC_DB_THR", false);
      hcDBTimeout = localSharedPreferences.getInt("KEY_HC_DB_TIMEOUT", 500);
      hcDBTimeoutBusy = localSharedPreferences.getInt("KEY_HC_DB_TIMEOUT_BUSY", 5000);
      hcDBActionQuery = localSharedPreferences.getLong("KEY_HC_DB_ACTION_QUERY", 4096L);
      hcDBActionWrite = localSharedPreferences.getLong("KEY_HC_DB_ACTION_WRITE", 12288L);
      hcEncodeVideoEnable = localSharedPreferences.getBoolean("KEY_HC_ENCODE_VIDEO_ENABLE", true);
      hcEncodeVideoDelay = localSharedPreferences.getInt("KEY_HC_ENCODE_VIDEO_DELEY", 0);
      hcEncodeVideoCPU = localSharedPreferences.getInt("KEY_HC_ENCODE_VIDEO_CPU", 1);
      hcEncodeVideoIO = localSharedPreferences.getInt("KEY_HC_ENCODE_VIDEO_IO", 1);
      hcEncodeVideoThr = localSharedPreferences.getBoolean("KEY_HC_ENCODE_VIDEO_THR", false);
      hcEncodeVideoTimeout = localSharedPreferences.getInt("KEY_HC_ENCODE_VIDEO_TIMEOUT", 20000);
      hcEncodeVideoAction = localSharedPreferences.getLong("KEY_HC_ENCODE_VIDEO_ACTION", 81984L);
      hcDecodePicEnable = localSharedPreferences.getBoolean("KEY_HC_DECODE_PIC_ENABLE", false);
      hcDecodePicDelay = localSharedPreferences.getInt("KEY_HC_DECODE_PIC_DELEY", 100);
      hcDecodePicCPU = localSharedPreferences.getInt("KEY_HC_DECODE_PIC_CPU", 2);
      hcDecodePicIO = localSharedPreferences.getInt("KEY_HC_DECODE_PIC_IO", 2);
      hcDecodePicThr = localSharedPreferences.getBoolean("KEY_HC_DECODE_PIC_THR", false);
      hcDecodePicTimeout = localSharedPreferences.getInt("KEY_HC_DECODE_PIC_TIMEOUT", 500);
      hcDecodePicAction = localSharedPreferences.getLong("KEY_HC_DECODE_PIC_ACTION", 16448L);
      hcGifEnable = localSharedPreferences.getBoolean("KEY_HC_GIF_ENABLE", true);
      hcGifDelay = localSharedPreferences.getInt("KEY_HC_GIF_DELEY", 0);
      hcGifCPU = localSharedPreferences.getInt("KEY_HC_GIF_CPU", 3);
      hcGifIO = localSharedPreferences.getInt("KEY_HC_GIF_IO", 2);
      hcGifThr = localSharedPreferences.getBoolean("KEY_HC_GIF_THR", false);
      hcGifTimeout = localSharedPreferences.getInt("KEY_HC_GIF_TIMEOUT", 500);
      hcGifAction = localSharedPreferences.getLong("KEY_HC_GIF_ACTION", 81984L);
      hcGifFrameEnable = localSharedPreferences.getBoolean("KEY_HC_GIF_FRAME_ENABLE", true);
      hcGifFrameDelay = localSharedPreferences.getInt("KEY_HC_GIF_FRAME_DELEY", 0);
      hcGifFrameCPU = localSharedPreferences.getInt("KEY_HC_GIF_FRAME_CPU", 2);
      hcGifFrameIO = localSharedPreferences.getInt("KEY_HC_GIF_FRAME_IO", 0);
      hcGifFrameThr = localSharedPreferences.getBoolean("KEY_HC_GIF_FRAME_THR", false);
      hcGifFrameTimeout = localSharedPreferences.getInt("KEY_HC_GIF_FRAME_TIMEOUT", 1000);
      hcGifFrameAction = localSharedPreferences.getLong("KEY_HC_GIF_FRAME_ACTION", 65600L);
      hcSNSScrollEnable = localSharedPreferences.getBoolean("KEY_HC_SNS_SCROLL_ENABLE", true);
      hcSNSScrollDelay = localSharedPreferences.getInt("KEY_HC_SNS_SCROLL_DELEY", 0);
      hcSNSScrollCPU = localSharedPreferences.getInt("KEY_HC_SNS_SCROLL_CPU", 3);
      hcSNSScrollIO = localSharedPreferences.getInt("KEY_HC_SNS_SCROLL_IO", 2);
      hcSNSScrollThr = localSharedPreferences.getBoolean("KEY_HC_SNS_SCROLL_THR", false);
      hcSNSScrollTimeout = localSharedPreferences.getInt("KEY_HC_SNS_SCROLL_TIMEOUT", 1500);
      hcSNSScrollAction = localSharedPreferences.getLong("KEY_HC_SNS_SCROLL_ACTION", 96L);
      hcSNSUserScrollEnable = localSharedPreferences.getBoolean("KEY_HC_SNS_USER_SCROLL_ENABLE", true);
      hcSNSUserScrollDelay = localSharedPreferences.getInt("KEY_HC_SNS_USER_SCROLL_DELEY", 0);
      hcSNSUserScrollCPU = localSharedPreferences.getInt("KEY_HC_SNS_USER_SCROLL_CPU", 3);
      hcSNSUserScrollIO = localSharedPreferences.getInt("KEY_HC_SNS_USER_SCROLL_IO", 2);
      hcSNSUserScrollThr = localSharedPreferences.getBoolean("KEY_HC_SNS_USER_SCROLL_THR", false);
      hcSNSUserScrollTimeout = localSharedPreferences.getInt("KEY_HC_SNS_USER_SCROLL_TIMEOUT", 1500);
      hcSNSUserScrollAction = localSharedPreferences.getLong("KEY_HC_SNS_USER_SCROLL_ACTION", 96L);
      hcSNSMsgScrollEnable = localSharedPreferences.getBoolean("KEY_HC_SNS_MSG_SCROLL_ENABLE", true);
      hcSNSMsgScrollDelay = localSharedPreferences.getInt("KEY_HC_SNS_MSG_SCROLL_DELEY", 0);
      hcSNSMsgScrollCPU = localSharedPreferences.getInt("KEY_HC_SNS_MSG_SCROLL_CPU", 3);
      hcSNSMsgScrollIO = localSharedPreferences.getInt("KEY_HC_SNS_MSG_SCROLL_IO", 2);
      hcSNSMsgScrollThr = localSharedPreferences.getBoolean("KEY_HC_SNS_MSG_SCROLL_THR", false);
      hcSNSMsgScrollTimeout = localSharedPreferences.getInt("KEY_HC_SNS_MSG_SCROLL_TIMEOUT", 1500);
      hcSNSMsgScrollAction = localSharedPreferences.getLong("KEY_HC_SNS_MSG_SCROLL_ACTION", 96L);
      hcMediaGalleryScrollEnable = localSharedPreferences.getBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE", true);
      hcMediaGalleryScrollDelay = localSharedPreferences.getInt("KEY_HC_MEDIA_GALLERY_SCROLL_DELEY", 0);
      hcMediaGalleryScrollCPU = localSharedPreferences.getInt("KEY_HC_MEDIA_GALLERY_SCROLL_CPU", 3);
      hcMediaGalleryScrollIO = localSharedPreferences.getInt("KEY_HC_MEDIA_GALLERY_SCROLL_IO", 2);
      hcMediaGalleryScrollThr = localSharedPreferences.getBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_THR", false);
      hcMediaGalleryScrollTimeout = localSharedPreferences.getInt("KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT", 1500);
      hcMediaGalleryScrollAction = localSharedPreferences.getLong("KEY_HC_MEDIA_GALLERY_SCROLL_ACTION", 96L);
      hcAlbumScrollEnable = localSharedPreferences.getBoolean("KEY_HCALBUM_SCROLL_ENABLE", true);
      hcAlbumScrollDelay = localSharedPreferences.getInt("KEY_HC_ALBUM_SCROLL_DELEY", 0);
      hcAlbumScrollCPU = localSharedPreferences.getInt("KEY_HC_ALBUM_SCROLL_CPU", 3);
      hcAlbumScrollIO = localSharedPreferences.getInt("KEY_HC_ALBUM_SCROLL_IO", 2);
      hcAlbumScrollThr = localSharedPreferences.getBoolean("KEY_HC_ALBUM_SCROLL_THR", false);
      hcAlbumScrollTimeout = localSharedPreferences.getInt("KEY_HC_ALBUM_SCROLL_TIMEOUT", 1500);
      hcAlbumScrollAction = localSharedPreferences.getLong("KEY_HC_ALBUM_SCROLL_ACTION", 96L);
      y.i("MicroMsg.WXHardCoderJNI", "reloadSPConfig Boot[%b] EnterChatting[%b] QuitChatting[%b] SendMsg[%b] SendPicMsg[%b] ReceiveMsg[%b] UpdateChatroom[%b] DB[%b] EncodeVideo[%b] DecodePic[%b] Gif[%b] GifFrame[%b] SNS[%b] MediaGallery[%b] Album[%b] SNSUser[%b] SNSMsg[%b]", new Object[] { Boolean.valueOf(hcBootEnable), Boolean.valueOf(hcEnterChattingEnable), Boolean.valueOf(hcQuitChattingEnable), Boolean.valueOf(hcSendMsgEnable), Boolean.valueOf(hcSendPicMsgEnable), Boolean.valueOf(hcReceiveMsgEnable), Boolean.valueOf(hcUpdateChatroomEnable), Boolean.valueOf(hcDBEnable), Boolean.valueOf(hcEncodeVideoEnable), Boolean.valueOf(hcDecodePicEnable), Boolean.valueOf(hcGifEnable), Boolean.valueOf(hcGifFrameEnable), Boolean.valueOf(hcSNSScrollEnable), Boolean.valueOf(hcMediaGalleryScrollEnable), Boolean.valueOf(hcAlbumScrollEnable), Boolean.valueOf(hcSNSUserScrollEnable), Boolean.valueOf(hcSNSMsgScrollEnable) });
      return;
      bool = false;
      break;
      i = 9;
      break label180;
      bool = false;
      break label313;
    }
  }
  
  public static void reportFPS(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3)
  {
    HardCoderJNI.reportInfo(new f(paramInt1, paramLong1, paramInt2, paramLong2, paramLong3));
  }
  
  public static void reportIDKey(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    HardCoderJNI.reportInfo(new g(paramBoolean1, paramInt1, paramInt2, paramBoolean2));
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    HardCoderJNI.hcDebug = paramBoolean;
  }
  
  public static void setEnable(boolean paramBoolean)
  {
    HardCoderJNI.hcEnable = paramBoolean;
  }
  
  public static void setHCNativeDebug(boolean paramBoolean)
  {
    HardCoderJNI.setDebug(paramBoolean);
  }
  
  public static void setHCNativeEnable(boolean paramBoolean)
  {
    HardCoderJNI.setHCEnable(paramBoolean);
  }
  
  public static void setRetryConnectInterval(int paramInt)
  {
    HardCoderJNI.setRetryConnectInterval(paramInt);
  }
  
  public static int startPerformance(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, String paramString)
  {
    if (!paramBoolean) {
      return -3;
    }
    if ((!hcBgEnable) && (!foreground)) {
      return -4;
    }
    return HardCoderJNI.startPerformance(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5 + hcTimeoutMargin, paramInt6, paramLong, android.os.Process.myTid(), paramString);
  }
  
  public static int startTraceCpuLoad(int paramInt)
  {
    if (!HardCoderJNI.checkEnv) {
      return -2;
    }
    return HardCoderJNI.startTraceCpuLoad(paramInt);
  }
  
  public static int stopPerformace(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      return -3;
    }
    return HardCoderJNI.stopPerformace(paramInt);
  }
  
  public static int terminateApp(int paramInt, long paramLong)
  {
    return HardCoderJNI.terminateApp(paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.WXHardCoderJNI
 * JD-Core Version:    0.7.0.1
 */