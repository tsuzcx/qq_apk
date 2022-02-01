package com.tencent.mm.i;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class g
{
  public boolean allow_mobile_net_download = false;
  public int certificateVerifyPolicy = 2;
  public int connectionCount = 1;
  public String customHeader = "";
  public String emojiExtinfo = "";
  public int expectImageFormat = 1;
  public int field_advideoflag = 0;
  public String field_aesKey = "";
  public int field_appType = 0;
  public int field_arg = 0;
  public String field_authKey;
  public boolean field_autostart = false;
  public int field_bzScene = 0;
  public int field_chattype = 0;
  public boolean field_enable_hitcheck = true;
  public String field_fake_bigfile_signature = "";
  public String field_fake_bigfile_signature_aeskey = "";
  public String field_fileId = "";
  public int field_fileType = 0;
  public String field_filemd5 = "";
  public boolean field_force_aeskeycdn = false;
  public String field_fullpath = "";
  public boolean field_isSilentTask = false;
  public boolean field_isStreamMedia = false;
  public int field_largesvideo = 0;
  public long field_lastProgressCallbackTime = 0L;
  public int field_limitrate = 0;
  public String field_mediaId = "";
  public int field_midFileLength = 0;
  public String field_midimgpath = "";
  public boolean field_needCompressImage = false;
  public boolean field_needStorage = false;
  public boolean field_onlycheckexist = false;
  public int field_preloadRatio = 30;
  public int field_priority = 0;
  public int field_requestVideoFormat = 1;
  public boolean field_sendmsg_viacdn = false;
  public String field_signalQuality = "";
  public int field_smallVideoFlag = 0;
  public String field_snsScene = "";
  public long field_startTime = 0L;
  public String field_svr_signature = "";
  public String field_talker = "";
  public String field_thumbpath = "";
  public int field_totalLen = 0;
  public boolean field_trysafecdn = false;
  public boolean field_use_multithread = false;
  public String field_videoFileId = "";
  public int field_videosource = 0;
  public String field_wxmsgparam = "";
  public byte[] fileBuffer;
  public boolean gbt;
  public int hDp = -1;
  public String hlsVideoFlag = "";
  public a iUG;
  public int iUH = -1;
  public int iUI = -1;
  public String iUJ = "";
  public int iUK = 0;
  public int iUL = 0;
  public String[] iUM = null;
  public boolean iUN = true;
  public boolean iUO = false;
  public boolean iUP = false;
  public String iUQ = "";
  public Map<String, String> iUR = null;
  public boolean iUS = false;
  public boolean iUT = false;
  public boolean iUU = false;
  public boolean iUV = false;
  public int iUW;
  public int iUX = 1;
  public g.b iUY;
  public int iUZ = 0;
  public boolean isColdSnsData = false;
  public boolean isHLSVideo = false;
  public boolean isHotSnsVideo = false;
  public boolean is_resume_task = false;
  public int lastError = 0;
  public long preloadMinSize = 0L;
  public int snsVersion = 0;
  public String taskName = "task_default";
  public byte[] thumbnailBuffer;
  
  public final boolean arN()
  {
    return this.iUX == 2;
  }
  
  public final boolean arO()
  {
    return this.iUX == 3;
  }
  
  public final boolean arP()
  {
    return this.iUX == 1;
  }
  
  public final boolean arQ()
  {
    return this.iUX == 4;
  }
  
  public final boolean arR()
  {
    return this.iUX == 5;
  }
  
  public final boolean arS()
  {
    return this.iUX == 6;
  }
  
  public final boolean arT()
  {
    return this.iUX == 8;
  }
  
  public final boolean arU()
  {
    return this.iUX == 7;
  }
  
  public final boolean arV()
  {
    return this.iUZ == 1;
  }
  
  public static abstract interface a
  {
    public abstract int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean);
    
    public abstract void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream);
    
    public abstract byte[] f(String paramString, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.i.g
 * JD-Core Version:    0.7.0.1
 */