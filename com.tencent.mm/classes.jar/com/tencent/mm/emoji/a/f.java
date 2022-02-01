package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.emoji.c.a.a;
import com.tencent.mm.emoji.f.c;
import com.tencent.mm.emoji.f.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiEggUtil;", "", "()V", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String TAG;
  private static final String hCS;
  public static final a mfZ;
  private static final String mga;
  private static long mgb;
  private static b mgc;
  
  static
  {
    AppMethodBeat.i(242327);
    mfZ = new a((byte)0);
    TAG = "MicroMsg.EmojiEggUtil";
    c localc = c.moq;
    mga = s.X(c.aWC(), "panel/");
    hCS = "emoji-anim.xml";
    mgc = new b();
    a.aUr();
    AppMethodBeat.o(242327);
  }
  
  public static final String s(cc paramcc)
  {
    AppMethodBeat.i(242303);
    paramcc = a.s(paramcc);
    AppMethodBeat.o(242303);
    return paramcc;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiEggUtil$Companion;", "", "()V", "PatMsgJoint", "", "TAG", "animConfig", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "getAnimConfig", "()Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "setAnimConfig", "(Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;)V", "assetDir", "configName", "lastCheckTick", "", "localDir", "versionName", "checkAnimUpdate", "", "getAnimItem", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "key", "getEmojiAnimVersion", "", "getMsgContent", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "getPatMsgContentList", "", "getScreenEffectVersion", "initAnimConfig", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int El(String paramString)
    {
      AppMethodBeat.i(242317);
      s.u(paramString, "key");
      Iterator localIterator = ((Iterable)f.aUn().mfy).iterator();
      Object localObject;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!s.p(((b.a)localObject).key, paramString));
      for (paramString = localObject;; paramString = null)
      {
        paramString = (b.a)paramString;
        if (paramString != null) {
          break;
        }
        AppMethodBeat.o(242317);
        return 0;
      }
      paramString = paramString.mfA;
      if (paramString == null)
      {
        AppMethodBeat.o(242317);
        return 0;
      }
      int i = paramString.version;
      AppMethodBeat.o(242317);
      return i;
    }
    
    public static void aUr()
    {
      AppMethodBeat.i(242308);
      int i = d.Ex(s.X(f.aUo(), "config.conf"));
      int j = d.Ex("assets:///panel/config.conf");
      Object localObject1 = s.X(f.aUo(), f.aUp());
      Object localObject2 = s.X("assets:///panel/", f.aUp());
      if ((i > 0) && (i >= j) && (y.ZC((String)localObject1)))
      {
        localObject2 = a.mhz;
        a.a.a((String)localObject1, (a)f.aUn());
      }
      for (;;)
      {
        Log.i(f.access$getTAG$cp(), "initAnimConfig: version:" + i + ", " + j + "; content " + f.aUn().mfy.size());
        AppMethodBeat.o(242308);
        return;
        localObject1 = a.mhz;
        a.a.a((String)localObject2, (a)f.aUn());
      }
    }
    
    public static void aUs()
    {
      AppMethodBeat.i(242315);
      if (!MMApplicationContext.isMainProcess())
      {
        AppMethodBeat.o(242315);
        return;
      }
      if (!h.baz())
      {
        AppMethodBeat.o(242315);
        return;
      }
      if (Util.ticksToNow(f.aUq()) > 1800000L)
      {
        f.hu(Util.currentTicks());
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().f(37, 7, -1, false);
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(37);
        Log.i(f.access$getTAG$cp(), "checkAnimUpdate: " + f.aUn().mfy.size() + ", " + f.aUq());
      }
      AppMethodBeat.o(242315);
    }
    
    public static String s(cc paramcc)
    {
      AppMethodBeat.i(242300);
      s.u(paramcc, "msgInfo");
      Object localObject2 = paramcc.field_content;
      Object localObject1 = localObject2;
      if (au.bwE(paramcc.field_talker)) {
        localObject1 = br.JH((String)localObject2);
      }
      if (!paramcc.jbR())
      {
        localObject2 = localObject1;
        if (!paramcc.jbS()) {}
      }
      else
      {
        paramcc = k.b.aP((String)localObject1, paramcc.field_reserved);
        if (paramcc != null) {
          break label71;
        }
      }
      label71:
      for (localObject2 = null;; localObject2 = paramcc.title)
      {
        AppMethodBeat.o(242300);
        return localObject2;
      }
    }
    
    public static List<String> t(cc paramcc)
    {
      AppMethodBeat.i(242306);
      s.u(paramcc, "msgInfo");
      LinkedList localLinkedList = new LinkedList();
      Object localObject;
      if (paramcc.jbQ())
      {
        localObject = paramcc.field_content;
        if (!au.bwE(paramcc.field_talker)) {
          break label158;
        }
      }
      label158:
      for (paramcc = br.JH((String)localObject);; paramcc = (cc)localObject)
      {
        paramcc = ((com.tencent.mm.plugin.patmsg.a.b)h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).aRl(paramcc).Ksg;
        s.s(paramcc, "patContent.recordList");
        localObject = (Iterable)paramcc;
        paramcc = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramcc.add(((ebe)((Iterator)localObject).next()).nVS);
        }
        localLinkedList.addAll((Collection)paramcc);
        paramcc = (List)localLinkedList;
        AppMethodBeat.o(242306);
        return paramcc;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */