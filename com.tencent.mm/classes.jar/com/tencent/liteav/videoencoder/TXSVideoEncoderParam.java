package com.tencent.liteav.videoencoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public class TXSVideoEncoderParam
{
  public boolean annexb = false;
  public boolean appendSpsPps = true;
  public boolean bLimitFps = false;
  public boolean bMultiRef = false;
  public long baseFrameIndex = 0L;
  public long baseGopIndex = 0L;
  public int bitrate = 0;
  public boolean enableBFrame = false;
  public boolean enableBlackList = true;
  public boolean enableEGL14 = false;
  public JSONArray encFmt = null;
  public int encodeType = 0;
  public int encoderMode = 1;
  public int encoderProfile = 1;
  public boolean forceSetBitrateMode = false;
  public int fps = 20;
  public boolean fullIFrame = false;
  public Object glContext = null;
  public int gop = 3;
  public int height = 0;
  public boolean isH265EncoderEnabled = false;
  public boolean realTime = false;
  public boolean record = false;
  public int streamType = 0;
  public boolean syncOutput = false;
  public int usageType = 0;
  public int width = 0;
  
  public String toString()
  {
    AppMethodBeat.i(229479);
    String str = "TXSVideoEncoderParam{width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", gop=" + this.gop + ", encoderProfile=" + this.encoderProfile + ", encoderMode=" + this.encoderMode + ", enableBFrame=" + this.enableBFrame + ", glContext=" + this.glContext + ", realTime=" + this.realTime + ", annexb=" + this.annexb + ", appendSpsPps=" + this.appendSpsPps + ", fullIFrame=" + this.fullIFrame + ", syncOutput=" + this.syncOutput + ", enableEGL14=" + this.enableEGL14 + ", enableBlackList=" + this.enableBlackList + ", record=" + this.record + ", baseFrameIndex=" + this.baseFrameIndex + ", baseGopIndex=" + this.baseGopIndex + ", streamType=" + this.streamType + ", bMultiRef=" + this.bMultiRef + ", bitrate=" + this.bitrate + ", bLimitFps=" + this.bLimitFps + ", encodeType=" + this.encodeType + ", forceSetBitrateMode=" + this.forceSetBitrateMode + ", encFmt=" + this.encFmt + ", isH265EncoderEnabled=" + this.isH265EncoderEnabled + ", usageType=" + this.usageType + '}';
    AppMethodBeat.o(229479);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.TXSVideoEncoderParam
 * JD-Core Version:    0.7.0.1
 */