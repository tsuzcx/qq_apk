package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelvideo/VideoParseInfo;", "", "()V", "fileuploadtoken", "", "getFileuploadtoken", "()Ljava/lang/String;", "setFileuploadtoken", "(Ljava/lang/String;)V", "hadClicked", "", "getHadClicked", "()Z", "setHadClicked", "(Z)V", "hitRawMd5", "", "getHitRawMd5", "()I", "setHitRawMd5", "(I)V", "isPlaceHolder", "setPlaceHolder", "overwriteNewMsgId", "", "getOverwriteNewMsgId", "()J", "setOverwriteNewMsgId", "(J)V", "rawVideoAesKey", "getRawVideoAesKey", "setRawVideoAesKey", "rawVideoFileId", "getRawVideoFileId", "setRawVideoFileId", "rawVideoLength", "getRawVideoLength", "setRawVideoLength", "rawVideoMd5", "getRawVideoMd5", "setRawVideoMd5", "videoFileId", "getVideoFileId", "setVideoFileId", "reset", "", "Companion", "plugin-videologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
{
  private static final f<Integer, ae> lNS;
  public static final a pbN;
  public long nVD;
  String nVE = "";
  public boolean pbO;
  public String pbP = "";
  public String pbQ = "";
  public String pbR = "";
  public String pbS = "";
  public int pbT;
  public boolean pbU;
  
  static
  {
    AppMethodBeat.i(241192);
    pbN = new a((byte)0);
    lNS = (f)new c(100);
    AppMethodBeat.o(241192);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelvideo/VideoParseInfo$Companion;", "", "()V", "TAG", "", "cache", "Lcom/tencent/mm/algorithm/LRUMap;", "", "Lcom/tencent/mm/modelvideo/VideoParseInfo;", "get", "values", "", "key", "parseContent", "xml", "plugin-videologic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static ae Qv(String paramString)
    {
      AppMethodBeat.i(241209);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(241209);
        return null;
      }
      s.checkNotNull(paramString);
      int i = n.a((CharSequence)paramString, '<', 0, false, 6);
      Object localObject1;
      if (i > 0)
      {
        localObject1 = paramString.substring(i);
        s.s(localObject1, "(this as java.lang.String).substring(startIndex)");
      }
      for (;;)
      {
        i = s.X("parse_", paramString).hashCode();
        paramString = (ae)ae.bOH().get(Integer.valueOf(i));
        if (paramString != null)
        {
          AppMethodBeat.o(241209);
          return paramString;
        }
        paramString = new ae();
        localObject1 = XmlParser.parseXml((String)localObject1, "msg", null);
        for (;;)
        {
          try
          {
            Object localObject2 = ae.pbN;
            paramString.nVD = Util.getLong(f((Map)localObject1, "overwritenewmsgid"), 0L);
            localObject2 = ae.pbN;
            localObject2 = f((Map)localObject1, "fileuploadtoken");
            s.u(localObject2, "<set-?>");
            paramString.nVE = ((String)localObject2);
            localObject2 = ae.pbN;
            localObject2 = f((Map)localObject1, "rawmd5");
            s.u(localObject2, "<set-?>");
            paramString.pbP = ((String)localObject2);
            localObject2 = ae.pbN;
            localObject2 = f((Map)localObject1, "cdnrawvideourl");
            s.u(localObject2, "<set-?>");
            paramString.pbQ = ((String)localObject2);
            localObject2 = ae.pbN;
            localObject2 = f((Map)localObject1, "cdnrawvideoaeskey");
            s.u(localObject2, "<set-?>");
            paramString.pbS = ((String)localObject2);
            localObject2 = ae.pbN;
            paramString.pbT = Util.getInt(f((Map)localObject1, "rawlength"), 0);
            localObject2 = ae.pbN;
            if (Util.getInt(f((Map)localObject1, "isplaceholder"), 0) != 1) {
              continue;
            }
            bool = true;
            paramString.pbO = bool;
            localObject2 = ae.pbN;
            localObject1 = f((Map)localObject1, "cdnvideourl");
            s.u(localObject1, "<set-?>");
            paramString.pbR = ((String)localObject1);
          }
          catch (Exception localException)
          {
            boolean bool;
            Log.e("MicroMsg.VideoParseInfo", "parsing video msg xml failed", new Object[] { localException });
            continue;
          }
          ae.bOH().put(Integer.valueOf(i), paramString);
          AppMethodBeat.o(241209);
          return paramString;
          bool = false;
        }
        String str = paramString;
      }
    }
    
    private static String f(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(241211);
      if (paramMap == null) {}
      for (paramMap = null;; paramMap = (String)paramMap.get(s.X(".msg.videomsg.$", paramString)))
      {
        paramMap = Util.nullAsNil(paramMap);
        s.s(paramMap, "nullAsNil(values?.get(\".msg.videomsg.\\$$key\"))");
        AppMethodBeat.o(241211);
        return paramMap;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.ae
 * JD-Core Version:    0.7.0.1
 */