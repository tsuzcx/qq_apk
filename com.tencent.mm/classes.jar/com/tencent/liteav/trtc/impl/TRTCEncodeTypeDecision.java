package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.basic.util.g.a;
import com.tencent.liteav.videodecoder.e;
import com.tencent.liteav.videoencoder.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TRTCEncodeTypeDecision
{
  public static final int CODEC_ABILITY_VALUE_SUPPORT_264 = 3;
  public static final int CODEC_ABILITY_VALUE_SUPPORT_264_DECODE = 2;
  public static final int CODEC_ABILITY_VALUE_SUPPORT_264_ENCODE = 1;
  private static final int CODEC_ABILITY_VALUE_SUPPORT_265_DECODE_BITMASK = 3;
  private static final int CODEC_ABILITY_VALUE_SUPPORT_265_ENCODE_BITMASK = 2;
  private static final String TAG = "TRTCH265Decision";
  private static boolean sLifeCycleEnableH265Decoder = true;
  private static boolean sLifeCycleEnableH265Encode = true;
  private boolean mEnableH265EncodeByPrivateAPI = false;
  private boolean mEnableH265EncodeByServer = false;
  private TRTCCloudImpl mTrtcCloud;
  
  public TRTCEncodeTypeDecision(TRTCCloudImpl paramTRTCCloudImpl)
  {
    this.mTrtcCloud = paramTRTCCloudImpl;
  }
  
  public static int getEnterRoomCodecSupportValue()
  {
    AppMethodBeat.i(225245);
    int j = getH265DecoderValue();
    if (c.a(1920, 1080, 20)) {}
    for (int i = 1;; i = 0)
    {
      i = i << 2 | j | 0x3;
      TXCLog.i("TRTCH265Decision", "codecability codecSupport : ".concat(String.valueOf(i)));
      AppMethodBeat.o(225245);
      return i;
    }
  }
  
  public static int getH265DecoderValue()
  {
    int j = 1;
    AppMethodBeat.i(225248);
    if ((sLifeCycleEnableH265Decoder) && (e.a(1920, 1080, 20)))
    {
      i = 1;
      if (i == 0) {
        break label49;
      }
    }
    label49:
    for (int i = j;; i = 0)
    {
      AppMethodBeat.o(225248);
      return i << 3;
      i = 0;
      break;
    }
  }
  
  public static boolean isAppLifeCycleEnableH265Decoder()
  {
    return sLifeCycleEnableH265Decoder;
  }
  
  public static boolean isAppLifeCycleEnableH265Encoder()
  {
    return sLifeCycleEnableH265Encode;
  }
  
  public static void setAppLifeCycleEnableH265Decoder(boolean paramBoolean)
  {
    sLifeCycleEnableH265Decoder = paramBoolean;
  }
  
  public static void setAppLifeCycleEnableH265Encoder(boolean paramBoolean)
  {
    sLifeCycleEnableH265Encode = paramBoolean;
  }
  
  public int getExpectVideoCodecType(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(225229);
    int i = g.a.a.a();
    if (paramInt == 1)
    {
      boolean bool2 = c.a(1920, 1080, 20);
      if ((!this.mEnableH265EncodeByPrivateAPI) || (!isAppLifeCycleEnableH265Encoder()) || (!bool2)) {
        break label100;
      }
      if (!bool1) {
        break label105;
      }
    }
    label100:
    label105:
    for (paramInt = g.a.b.a();; paramInt = g.a.a.a())
    {
      TXCLog.i("TRTCH265Decision", "enableH265 = " + bool1 + " expectCodecType=" + paramInt);
      i = paramInt;
      AppMethodBeat.o(225229);
      return i;
      bool1 = false;
      break;
    }
  }
  
  public boolean isVideoEncoderCodecUsingH265()
  {
    AppMethodBeat.i(225234);
    boolean bool2 = c.a(1920, 1080, 20);
    if ((this.mEnableH265EncodeByPrivateAPI) && (this.mEnableH265EncodeByServer) && (isAppLifeCycleEnableH265Encoder()) && (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      TXCLog.i("TRTCH265Decision", "codecability getVideoEncoderCodec: " + this.mEnableH265EncodeByServer + " ,mEnableHighQualityEncode=" + this.mEnableH265EncodeByPrivateAPI + ", TRTCH265Decision.isAppLifeCycleEnableH265Encoder()= " + isAppLifeCycleEnableH265Encoder() + " supportEncoder = " + bool2);
      AppMethodBeat.o(225234);
      return bool1;
    }
  }
  
  public boolean isVideoEncoderStartCodecUsingH265()
  {
    boolean bool2 = true;
    AppMethodBeat.i(225241);
    g.a locala = g.a.a(g.a().b("key_last_encode_type", g.a.a.a()));
    boolean bool3 = c.a(1920, 1080, 20);
    boolean bool1;
    if ((this.mEnableH265EncodeByPrivateAPI) && (isAppLifeCycleEnableH265Encoder()) && (bool3))
    {
      bool1 = true;
      if (!bool1) {
        break label143;
      }
      if (locala != g.a.b) {
        break label138;
      }
      bool1 = bool2;
    }
    label138:
    label143:
    for (;;)
    {
      TXCLog.i("TRTCH265Decision", "getVideoEncoderStartCodec enableH265 = " + bool1 + " , lastEncodeType=" + locala.a() + " mEnableH265EncodeByPrivateAPI=" + this.mEnableH265EncodeByPrivateAPI + " supportEncoder=" + bool3);
      AppMethodBeat.o(225241);
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public void setEnableH265EncodeByPrivateAPI(boolean paramBoolean)
  {
    AppMethodBeat.i(225210);
    setEnableH265EncodeByPrivateAPI(paramBoolean, ModifyCodecReason.REASON_NO_NEED_CARE);
    AppMethodBeat.o(225210);
  }
  
  public void setEnableH265EncodeByPrivateAPI(boolean paramBoolean, ModifyCodecReason paramModifyCodecReason)
  {
    AppMethodBeat.i(225215);
    this.mEnableH265EncodeByPrivateAPI = paramBoolean;
    TXCLog.i("TRTCH265Decision", "setEnableH265EncodeByPrivateAPI: enableH265EncodeByPrivateAPI= " + paramBoolean + ", reason =" + paramModifyCodecReason);
    if (paramModifyCodecReason == ModifyCodecReason.REASON_ENCODE_ERROR)
    {
      setAppLifeCycleEnableH265Encoder(false);
      this.mTrtcCloud.notifyCurrentEncodeType(false);
      AppMethodBeat.o(225215);
      return;
    }
    if ((paramModifyCodecReason == ModifyCodecReason.REASON_DECODE_ERROR) && (!a.a())) {
      setAppLifeCycleEnableH265Decoder(false);
    }
    AppMethodBeat.o(225215);
  }
  
  public void setEnableH265EncodeByServer(boolean paramBoolean)
  {
    AppMethodBeat.i(225218);
    setEnableH265EncodeByServer(paramBoolean, ModifyCodecReason.REASON_NO_NEED_CARE);
    AppMethodBeat.o(225218);
  }
  
  public void setEnableH265EncodeByServer(boolean paramBoolean, ModifyCodecReason paramModifyCodecReason)
  {
    AppMethodBeat.i(225222);
    if (this.mEnableH265EncodeByServer != paramBoolean)
    {
      if (paramModifyCodecReason == ModifyCodecReason.REASON_QOS)
      {
        if (paramBoolean)
        {
          AppMethodBeat.o(225222);
          return;
        }
        if (isVideoEncoderCodecUsingH265()) {
          this.mTrtcCloud.notifyCurrentEncodeType(false);
        }
      }
      this.mEnableH265EncodeByServer = paramBoolean;
      if (paramModifyCodecReason == ModifyCodecReason.REASON_ENTERROOM_RESPOND)
      {
        paramBoolean = isVideoEncoderCodecUsingH265();
        if (!paramBoolean) {
          break label129;
        }
      }
    }
    label129:
    for (g.a locala = g.a.b;; locala = g.a.a)
    {
      g.a().a("key_last_encode_type", locala.a());
      this.mTrtcCloud.notifyCurrentEncodeType(paramBoolean);
      TXCLog.i("TRTCH265Decision", "setEnableH265EncodeByServer: enableH265EncodeByServer= " + this.mEnableH265EncodeByServer + ", reason =" + paramModifyCodecReason);
      AppMethodBeat.o(225222);
      return;
    }
  }
  
  public static enum ModifyCodecReason
  {
    private int value;
    
    static
    {
      AppMethodBeat.i(222905);
      REASON_NO_NEED_CARE = new ModifyCodecReason("REASON_NO_NEED_CARE", 0, 0);
      REASON_ENCODE_ERROR = new ModifyCodecReason("REASON_ENCODE_ERROR", 1, 1);
      REASON_ENTERROOM_RESPOND = new ModifyCodecReason("REASON_ENTERROOM_RESPOND", 2, 2);
      REASON_QOS = new ModifyCodecReason("REASON_QOS", 3, 3);
      REASON_DECODE_ERROR = new ModifyCodecReason("REASON_DECODE_ERROR", 4, 4);
      $VALUES = new ModifyCodecReason[] { REASON_NO_NEED_CARE, REASON_ENCODE_ERROR, REASON_ENTERROOM_RESPOND, REASON_QOS, REASON_DECODE_ERROR };
      AppMethodBeat.o(222905);
    }
    
    private ModifyCodecReason(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCEncodeTypeDecision
 * JD-Core Version:    0.7.0.1
 */