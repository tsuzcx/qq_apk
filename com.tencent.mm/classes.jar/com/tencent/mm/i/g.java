package com.tencent.mm.i;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class g
{
  public boolean allow_mobile_net_download = false;
  public int certificateVerifyPolicy = 2;
  public int connectionCount = 1;
  public String customHeader = "";
  public boolean ehd;
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
  public int fuQ = -1;
  public int gqA = -1;
  public String gqB = "";
  public int gqC = 0;
  public int gqD = 0;
  public String[] gqE = null;
  public boolean gqF = true;
  public boolean gqG = false;
  public boolean gqH = false;
  public String gqI = "";
  public Map<String, String> gqJ = null;
  public boolean gqK = false;
  public boolean gqL = false;
  public boolean gqM = false;
  public boolean gqN = false;
  public int gqO;
  public int gqP = 1;
  public g.b gqQ;
  public a gqy;
  public int gqz = -1;
  public String hlsVideoFlag = "";
  public boolean isColdSnsData = false;
  public boolean isHLSVideo = false;
  public boolean isHotSnsVideo = false;
  public boolean is_resume_task = false;
  public int lastError = 0;
  public long preloadMinSize = 0L;
  public int snsVersion = 0;
  public String taskName = "task_default";
  public byte[] thumbnailBuffer;
  
  public final boolean alO()
  {
    return this.gqP == 2;
  }
  
  public final boolean alP()
  {
    return this.gqP == 3;
  }
  
  public final boolean alQ()
  {
    return this.gqP == 1;
  }
  
  public final boolean alR()
  {
    return this.gqP == 4;
  }
  
  public final boolean alS()
  {
    return this.gqP == 6;
  }
  
  public final boolean alT()
  {
    return this.gqP == 8;
  }
  
  public final boolean alU()
  {
    return this.gqP == 7;
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