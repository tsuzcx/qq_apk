package com.tencent.mm.g;

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
  public String hlsVideoFlag = "";
  public int hyY = -1;
  public boolean ihD;
  public boolean isColdSnsData = false;
  public boolean isHLSVideo = false;
  public boolean isHotSnsVideo = false;
  public boolean is_resume_task = false;
  public int lastError = 0;
  public a lwL;
  public int lwM = -1;
  public int lwN = -1;
  public String lwO = "";
  public int lwP = 0;
  public int lwQ = 0;
  public String[] lwR = null;
  public boolean lwS = true;
  public boolean lwT = false;
  public boolean lwU = false;
  public String lwV = "";
  public Map<String, String> lwW = null;
  public boolean lwX = false;
  public boolean lwY = false;
  public boolean lwZ = false;
  public boolean lxa = false;
  public int lxb;
  public int lxc = 1;
  public b lxd;
  public int lxe = 0;
  public long preloadMinSize = 0L;
  public int snsVersion = 0;
  public String taskName = "task_default";
  public byte[] thumbnailBuffer;
  
  public final boolean aLJ()
  {
    return this.lxc == 2;
  }
  
  public final boolean aLK()
  {
    return this.lxc == 3;
  }
  
  public final boolean aLL()
  {
    return this.lxc == 1;
  }
  
  public final boolean aLM()
  {
    return this.lxc == 4;
  }
  
  public final boolean aLN()
  {
    return this.lxc == 5;
  }
  
  public final boolean aLO()
  {
    return this.lxc == 6;
  }
  
  public final boolean aLP()
  {
    return this.lxc == 8;
  }
  
  public final boolean aLQ()
  {
    return this.lxc == 7;
  }
  
  public final boolean aLR()
  {
    return this.lxe == 1;
  }
  
  public static abstract interface a
  {
    public abstract int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean);
    
    public abstract void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream);
    
    public abstract byte[] h(String paramString, byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void b(String paramString, d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.g
 * JD-Core Version:    0.7.0.1
 */