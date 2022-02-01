package com.tencent.mm.i;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class g
{
  public boolean allow_mobile_net_download = false;
  public int certificateVerifyPolicy = 2;
  public int connectionCount = 1;
  public String customHeader = "";
  public boolean dDS;
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
  public boolean field_isColdSnsData = false;
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
  public a fnH;
  public int fnI = -1;
  public int fnJ = -1;
  public String fnK = "";
  public int fnL = 0;
  public int fnM = 0;
  public String[] fnN = null;
  public boolean fnO = true;
  public boolean fnP = false;
  public boolean fnQ = false;
  public String fnR = "";
  public Map<String, String> fnS = null;
  public boolean fnT = false;
  public boolean fnU = false;
  public boolean fnV = false;
  public int fnW;
  public int fnX = 1;
  public b fnY;
  public boolean is_resume_task = false;
  public int lastError = 0;
  public long preloadMinSize = 0L;
  public int snsVersion = 0;
  public byte[] thumbnailBuffer;
  
  public final boolean UF()
  {
    return this.fnX == 2;
  }
  
  public final boolean UG()
  {
    return this.fnX == 3;
  }
  
  public final boolean UH()
  {
    return this.fnX == 1;
  }
  
  public final boolean UI()
  {
    return this.fnX == 4;
  }
  
  public final boolean UJ()
  {
    return this.fnX == 6;
  }
  
  public final boolean UK()
  {
    return this.fnX == 8;
  }
  
  public final boolean ccl()
  {
    return this.fnX == 7;
  }
  
  public static abstract interface a
  {
    public abstract int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean);
    
    public abstract void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream);
    
    public abstract byte[] f(String paramString, byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.g
 * JD-Core Version:    0.7.0.1
 */