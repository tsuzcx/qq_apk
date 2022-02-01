package com.tencent.mm.plugin.emoji.magicemoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.v;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/util/MagicEmojiFileUtil;", "", "()V", "EMOJI_MAGIC_CONFIG", "", "EMOJI_MAGIC_WXA_BR_PKG", "EMOJI_MAGIC_WXA_PKG", "TAG", "TEMP_FOLDER", "dumpProfiler", "", "data", "getMagicEmojiConfigInfo", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiPkgInfo;", "filePath", "readMagicEmojiPkgInfo", "file", "Lcom/tencent/mm/vfs/VFSFile;", "updateMagicEmoji", "", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b xKn;
  
  static
  {
    AppMethodBeat.i(270016);
    xKn = new b();
    AppMethodBeat.o(270016);
  }
  
  private static com.tencent.mm.plugin.emoji.magicemoji.bean.c O(u paramu)
  {
    AppMethodBeat.i(270001);
    if (!paramu.jKS())
    {
      AppMethodBeat.o(270001);
      return null;
    }
    try
    {
      paramu = new JSONObject(y.bEn(ah.v(paramu.jKT())));
      String str = paramu.getString("appId");
      int i = paramu.getInt("version");
      Log.i("MicroMsg.MagicEmojiFileUtil", "read magic emoji pkg info, appId:" + str + " version:" + i);
      s.s(str, "appId");
      paramu = new com.tencent.mm.plugin.emoji.magicemoji.bean.c(str, i);
      AppMethodBeat.o(270001);
      return paramu;
    }
    catch (IOException paramu)
    {
      Log.printErrStackTrace("MicroMsg.MagicEmojiFileUtil", (Throwable)paramu, "read magic emoji pkg info failed", new Object[0]);
      AppMethodBeat.o(270001);
      return null;
    }
    catch (JSONException paramu)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MagicEmojiFileUtil", (Throwable)paramu, "read magic emoji pkg info failed", new Object[0]);
      }
    }
  }
  
  public static int anW(String paramString)
  {
    AppMethodBeat.i(269979);
    if (paramString == null)
    {
      AppMethodBeat.o(269979);
      return 0;
    }
    paramString = anX(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(269979);
      return 0;
    }
    Object localObject = (x)h.ax(x.class);
    if (localObject == null)
    {
      AppMethodBeat.o(269979);
      return 0;
    }
    localObject = ((x)localObject).VK(paramString.appId);
    String str;
    if ((localObject == null) || (((bh)localObject).field_version < paramString.version))
    {
      localObject = com.tencent.mm.emoji.f.c.moq;
      str = s.X(com.tencent.mm.emoji.f.c.aWC(), "/temp/");
      localObject = s.X(str, "magicemoji.wxapkg.br");
      str = s.X(str, "magicemoji.wxapkg");
      if (((m)h.ax(m.class)).cM((String)localObject, str))
      {
        localObject = (x)h.ax(x.class);
        if (localObject == null)
        {
          paramString = null;
          if (!s.p(Boolean.TRUE, paramString)) {
            break label203;
          }
          ((com.tencent.mm.plugin.emoji.magicemoji.a.e)h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.e.class)).dyG();
          Log.i("MicroMsg.MagicEmojiFileUtil", "insert magic emoji pkg success");
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(269979);
      return 0;
      paramString = Boolean.valueOf(((x)localObject).v(paramString.appId, paramString.version, str));
      break;
      label203:
      Log.e("MicroMsg.MagicEmojiFileUtil", s.X("insert magic emoji pkg failed, ok = ", paramString));
      continue;
      Log.e("MicroMsg.MagicEmojiFileUtil", "magic emoji pkg br decompress failed");
      continue;
      int i = paramString.version;
      int j = ((bh)localObject).field_version;
      Log.i("MicroMsg.MagicEmojiFileUtil", "magic emoji version " + i + " should bigger than " + j);
    }
  }
  
  public static com.tencent.mm.plugin.emoji.magicemoji.bean.c anX(String paramString)
  {
    AppMethodBeat.i(269991);
    s.u(paramString, "filePath");
    com.tencent.mm.emoji.f.c localc = com.tencent.mm.emoji.f.c.moq;
    if (!com.tencent.mm.emoji.f.c.az(paramString, "temp"))
    {
      AppMethodBeat.o(269991);
      return null;
    }
    paramString = com.tencent.mm.emoji.f.c.moq;
    paramString = O(new u(s.X(com.tencent.mm.emoji.f.c.aWC(), "/temp"), "magicemoji.json"));
    AppMethodBeat.o(269991);
    return paramString;
  }
  
  public static void anY(String paramString)
  {
    AppMethodBeat.i(270010);
    s.u(paramString, "data");
    Object localObject = new u(s.X(com.tencent.mm.loader.i.b.bmz(), "appbrand/trace/me.cpuprofiler"));
    try
    {
      v.i((u)localObject, paramString);
      AppMethodBeat.o(270010);
      return;
    }
    finally
    {
      localObject = e.xKw;
      e.aoa(s.X("dump file data failed for ", paramString.getMessage()));
      AppMethodBeat.o(270010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.d.b
 * JD-Core Version:    0.7.0.1
 */