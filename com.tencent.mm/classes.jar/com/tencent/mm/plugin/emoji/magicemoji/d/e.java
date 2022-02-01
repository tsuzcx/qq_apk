package com.tencent.mm.plugin.emoji.magicemoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.threadpool.i;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/util/MagicEmojiUtils;", "", "()V", "TAG", "", "readFileAsUtf8String", "fs", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystem;", "path", "reportForStartupErrCode", "", "errCode", "Lcom/tencent/mm/plugin/emoji/magicemoji/util/ConstantsMagicEmoji$StartupErrCode;", "reportKey", "key", "", "showErrToastInDevEnv", "msg", "workerThreadWithLock", "obj", "block", "Lkotlin/Function0;", "wrapForCanStartCheck", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e xKw;
  
  static
  {
    AppMethodBeat.i(270024);
    xKw = new e();
    AppMethodBeat.o(270024);
  }
  
  public static void AQ(int paramInt)
  {
    AppMethodBeat.i(270002);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(a.xKa, paramInt);
    AppMethodBeat.o(270002);
  }
  
  public static String a(w paramw, String paramString)
  {
    AppMethodBeat.i(269987);
    if (paramw == null)
    {
      Log.e("MagicEmojiUtils", "hy: can not read without fs");
      AppMethodBeat.o(269987);
      return "";
    }
    k localk = new k();
    paramw = paramw.b(paramString, localk);
    s.s(paramw, "fs.readFile(path, pBB)");
    if (paramw != r.qML)
    {
      Log.e("MagicEmojiUtils", "hy: no file found");
      AppMethodBeat.o(269987);
      return "";
    }
    paramw = com.tencent.mm.plugin.appbrand.af.d.s((ByteBuffer)localk.value);
    s.s(paramw, "arrayOfByteBuffer(pBB.value)");
    paramString = StandardCharsets.UTF_8;
    s.s(paramString, "UTF_8");
    paramw = new String(paramw, paramString);
    AppMethodBeat.o(269987);
    return paramw;
  }
  
  public static void a(Object paramObject, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(270011);
    s.u(paramObject, "obj");
    s.u(parama, "block");
    com.tencent.threadpool.h.ahAA.bn(new e..ExternalSyntheticLambda0(paramObject, parama));
    AppMethodBeat.o(270011);
  }
  
  public static void aoa(String paramString)
  {
    AppMethodBeat.i(269975);
    s.u(paramString, "msg");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()) || (a.xJU))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e.b(paramString));
      AppMethodBeat.o(269975);
      return;
    }
    Log.e("MagicEmojiUtils", "hy: error in magic emoji: %s", new Object[] { paramString });
    AppMethodBeat.o(269975);
  }
  
  public static void b(a.c paramc)
  {
    AppMethodBeat.i(269996);
    s.u(paramc, "errCode");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AQ(6);
      AppMethodBeat.o(269996);
      return;
    case 1: 
      AQ(0);
      AppMethodBeat.o(269996);
      return;
    case 2: 
      AQ(1);
      AppMethodBeat.o(269996);
      return;
    case 3: 
      AQ(2);
      AppMethodBeat.o(269996);
      return;
    case 4: 
      AQ(3);
      AppMethodBeat.o(269996);
      return;
    case 5: 
      AQ(4);
      AppMethodBeat.o(269996);
      return;
    case 6: 
      AQ(5);
      AppMethodBeat.o(269996);
      return;
    case 7: 
      AQ(7);
      AppMethodBeat.o(269996);
      return;
    }
    AQ(8);
    AppMethodBeat.o(269996);
  }
  
  private static final void b(Object paramObject, kotlin.g.a.a parama)
  {
    AppMethodBeat.i(270018);
    s.u(paramObject, "$obj");
    s.u(parama, "$block");
    try
    {
      parama.invoke();
      parama = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(270018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.d.e
 * JD-Core Version:    0.7.0.1
 */