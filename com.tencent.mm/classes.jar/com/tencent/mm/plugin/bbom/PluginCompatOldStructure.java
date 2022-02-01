package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.model.c;

public class PluginCompatOldStructure
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.bbom.a.b
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(22433);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      new m.1().alone();
      new m.2().alone();
      new m.3().alone();
      new m.4().alone();
      com.tencent.mm.by.b.b("profile", null);
      com.tencent.mm.by.b.b("setting", null);
      com.tencent.mm.by.b.b("subapp", null);
      com.tencent.mm.by.b.b("sandbox", null);
      com.tencent.mm.by.b.b("nearby", null);
      com.tencent.mm.by.b.b("brandservice", null);
      com.tencent.mm.by.b.b("favorite", new com.tencent.mm.plugin.favorite.a());
      com.tencent.mm.by.b.b("scanner", null);
      com.tencent.mm.by.b.b("shake", null);
      com.tencent.mm.by.b.b("voip", null);
      com.tencent.mm.by.b.b("radar", null);
      com.tencent.mm.by.b.b("ext", null);
      com.tencent.mm.by.b.b("emoji", new c());
      com.tencent.mm.by.b.b("account", null);
      com.tencent.mm.by.b.b("qqmail", null);
      com.tencent.mm.by.b.b("readerapp", null);
      com.tencent.mm.by.b.b("talkroom", null);
      com.tencent.mm.by.b.b("bottle", null);
      com.tencent.mm.by.b.b("masssend", null);
      com.tencent.mm.by.b.b("chatroom", null);
      com.tencent.mm.by.b.b("location", null);
      com.tencent.mm.by.b.b("clean", null);
      com.tencent.mm.by.b.b("card", null);
      com.tencent.mm.by.b.b("search", new f());
      com.tencent.mm.by.b.b("translate", null);
      com.tencent.mm.by.b.b("extqlauncher", null);
      com.tencent.mm.by.b.b("nearlife", null);
      com.tencent.mm.by.b.b("webview", null);
      com.tencent.mm.by.b.b("exdevice", null);
      com.tencent.mm.by.b.b("pwdgroup", null);
      com.tencent.mm.by.b.b("gallery", null);
      com.tencent.mm.by.b.b("label", null);
      com.tencent.mm.by.b.b("address", null);
      com.tencent.mm.by.b.b("backup", null);
      com.tencent.mm.by.b.b("record", null);
      com.tencent.mm.by.b.b("webwx", null);
      com.tencent.mm.by.b.b("extaccessories", null);
      com.tencent.mm.by.b.b("voiceprint", null);
      com.tencent.mm.by.b.b("wear", null);
      com.tencent.mm.by.b.b("auto", null);
      com.tencent.mm.by.b.b("gai", null);
      com.tencent.mm.by.b.b("nfc", null);
      com.tencent.mm.by.b.b("tmassistant", null);
      com.tencent.mm.by.b.b("nfc_open", null);
      com.tencent.mm.by.b.b("ipcall", null);
      com.tencent.mm.by.b.b("voip_cs", null);
      com.tencent.mm.by.b.b("multitalk", null);
      com.tencent.mm.by.b.b("wenote", new com.tencent.mm.plugin.wenote.model.a());
      com.tencent.mm.by.b.b("dbbackup", null);
      com.tencent.mm.by.b.b("soter_mp", null);
      com.tencent.mm.by.b.b("sl_warpgate", null);
      com.tencent.mm.by.b.b("aa", null);
      com.tencent.mm.by.b.b("sport", null);
      com.tencent.mm.by.b.b("fps_lighter", null);
      com.tencent.mm.by.b.b("mmsight", null);
      com.tencent.mm.by.b.b("login_exdevice", null);
      com.tencent.mm.by.b.b("finder", null);
      com.tencent.mm.by.b.b("finder_live", null);
      com.tencent.mm.by.b.b("groupcollect", null);
      com.tencent.mm.by.b.b("editor", null);
      com.tencent.mm.by.b.b("teenmode", null);
      com.tencent.mm.by.b.b("kidswatch", null);
    }
    AppMethodBeat.o(22433);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(22432);
    super.dependency();
    AppMethodBeat.o(22432);
  }
  
  public void execute(g paramg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginCompatOldStructure
 * JD-Core Version:    0.7.0.1
 */