package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f$b
{
  public String Mcq;
  public f.a ahhH;
  public String appid;
  public String coverUrl;
  public String musicId;
  public String nRx;
  public String oOZ;
  public String rDl;
  public String rDm;
  public String songName;
  
  static b dd(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229078);
    b localb = new b();
    localb.musicId = ((String)paramMap.get("musicId"));
    localb.songName = ((String)paramMap.get("songName"));
    localb.rDl = ((String)paramMap.get("singer"));
    localb.nRx = ((String)paramMap.get("dataUrl"));
    localb.appid = ((String)paramMap.get("appid"));
    localb.rDm = ((String)paramMap.get("webUrl"));
    localb.coverUrl = ((String)paramMap.get("coverUrl"));
    localb.ahhH = f.a.dc((Map)paramMap.get("duration"));
    localb.oOZ = ((String)paramMap.get("mid"));
    localb.Mcq = ((String)paramMap.get("lyric"));
    AppMethodBeat.o(229078);
    return localb;
  }
  
  final Map<String, Object> jRw()
  {
    AppMethodBeat.i(229085);
    HashMap localHashMap = new HashMap();
    localHashMap.put("musicId", this.musicId);
    localHashMap.put("songName", this.songName);
    localHashMap.put("singer", this.rDl);
    localHashMap.put("dataUrl", this.nRx);
    localHashMap.put("appid", this.appid);
    localHashMap.put("webUrl", this.rDm);
    localHashMap.put("coverUrl", this.coverUrl);
    if (this.ahhH == null) {}
    for (Object localObject = null;; localObject = this.ahhH.jRw())
    {
      localHashMap.put("duration", localObject);
      localHashMap.put("mid", this.oOZ);
      localHashMap.put("lyric", this.Mcq);
      AppMethodBeat.o(229085);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.c.f.b
 * JD-Core Version:    0.7.0.1
 */