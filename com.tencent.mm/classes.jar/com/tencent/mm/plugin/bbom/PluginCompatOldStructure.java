package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;

public class PluginCompatOldStructure
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.bbom.a.b
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22433);
    if (((h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
    {
      new m.1().alone();
      new m.2().alone();
      new m.3().alone();
      new m.4().alone();
      c.b("profile", null);
      c.b("setting", null);
      c.b("subapp", null);
      c.b("sandbox", null);
      c.b("nearby", null);
      c.b("brandservice", null);
      c.b("favorite", new com.tencent.mm.plugin.favorite.a());
      c.b("scanner", null);
      c.b("shake", null);
      c.b("voip", null);
      c.b("radar", null);
      c.b("ext", null);
      c.b("emoji", new com.tencent.mm.plugin.emoji.model.b());
      c.b("account", null);
      c.b("qqmail", null);
      c.b("readerapp", null);
      c.b("talkroom", null);
      c.b("bottle", null);
      c.b("masssend", null);
      c.b("chatroom", null);
      c.b("location", null);
      c.b("clean", null);
      c.b("card", null);
      c.b("search", new f());
      c.b("translate", null);
      c.b("extqlauncher", null);
      c.b("nearlife", null);
      c.b("webview", null);
      c.b("exdevice", null);
      c.b("freewifi", null);
      c.b("pwdgroup", null);
      c.b("gallery", null);
      c.b("label", null);
      c.b("address", null);
      c.b("backup", null);
      c.b("record", null);
      c.b("webwx", null);
      c.b("notification", new com.tencent.mm.plugin.notification.d.a());
      c.b("extaccessories", null);
      c.b("voiceprint", null);
      c.b("wear", null);
      c.b("auto", null);
      c.b("gai", null);
      c.b("nfc", null);
      c.b("tmassistant", null);
      c.b("nfc_open", null);
      c.b("ipcall", null);
      c.b("voip_cs", null);
      c.b("multitalk", null);
      c.b("wenote", new com.tencent.mm.plugin.wenote.model.a());
      c.b("dbbackup", null);
      c.b("soter_mp", null);
      c.b("sl_warpgate", null);
      c.b("aa", null);
      c.b("sport", null);
      c.b("fps_lighter", null);
      c.b("mmsight", null);
      c.b("login_exdevice", null);
      c.b("finder", null);
      c.b("groupcollect", null);
      c.b("editor", null);
      c.b("gamelife", null);
    }
    AppMethodBeat.o(22433);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(22432);
    super.dependency();
    AppMethodBeat.o(22432);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginCompatOldStructure
 * JD-Core Version:    0.7.0.1
 */