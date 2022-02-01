package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;

public class PluginCompatOldStructure
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.bbom.a.b
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22433);
    if (((h)com.tencent.mm.kernel.g.aAe().azG()).aBb())
    {
      new m.1().alone();
      new m.2().alone();
      new m.3().alone();
      new m.4().alone();
      com.tencent.mm.br.b.b("profile", null);
      com.tencent.mm.br.b.b("setting", null);
      com.tencent.mm.br.b.b("subapp", null);
      com.tencent.mm.br.b.b("sandbox", null);
      com.tencent.mm.br.b.b("nearby", null);
      com.tencent.mm.br.b.b("brandservice", null);
      com.tencent.mm.br.b.b("favorite", new com.tencent.mm.plugin.favorite.a());
      com.tencent.mm.br.b.b("scanner", null);
      com.tencent.mm.br.b.b("shake", null);
      com.tencent.mm.br.b.b("voip", null);
      com.tencent.mm.br.b.b("radar", null);
      com.tencent.mm.br.b.b("ext", null);
      com.tencent.mm.br.b.b("emoji", new com.tencent.mm.plugin.emoji.model.b());
      com.tencent.mm.br.b.b("account", null);
      com.tencent.mm.br.b.b("qqmail", null);
      com.tencent.mm.br.b.b("readerapp", null);
      com.tencent.mm.br.b.b("talkroom", null);
      com.tencent.mm.br.b.b("bottle", null);
      com.tencent.mm.br.b.b("masssend", null);
      com.tencent.mm.br.b.b("chatroom", null);
      com.tencent.mm.br.b.b("location", null);
      com.tencent.mm.br.b.b("clean", null);
      com.tencent.mm.br.b.b("card", null);
      com.tencent.mm.br.b.b("search", new f());
      com.tencent.mm.br.b.b("translate", null);
      com.tencent.mm.br.b.b("extqlauncher", null);
      com.tencent.mm.br.b.b("nearlife", null);
      com.tencent.mm.br.b.b("webview", null);
      com.tencent.mm.br.b.b("exdevice", null);
      com.tencent.mm.br.b.b("freewifi", null);
      com.tencent.mm.br.b.b("pwdgroup", null);
      com.tencent.mm.br.b.b("gallery", null);
      com.tencent.mm.br.b.b("label", null);
      com.tencent.mm.br.b.b("address", null);
      com.tencent.mm.br.b.b("backup", null);
      com.tencent.mm.br.b.b("record", null);
      com.tencent.mm.br.b.b("webwx", null);
      com.tencent.mm.br.b.b("extaccessories", null);
      com.tencent.mm.br.b.b("voiceprint", null);
      com.tencent.mm.br.b.b("wear", null);
      com.tencent.mm.br.b.b("auto", null);
      com.tencent.mm.br.b.b("gai", null);
      com.tencent.mm.br.b.b("nfc", null);
      com.tencent.mm.br.b.b("tmassistant", null);
      com.tencent.mm.br.b.b("nfc_open", null);
      com.tencent.mm.br.b.b("ipcall", null);
      com.tencent.mm.br.b.b("voip_cs", null);
      com.tencent.mm.br.b.b("multitalk", null);
      com.tencent.mm.br.b.b("wenote", new com.tencent.mm.plugin.wenote.model.a());
      com.tencent.mm.br.b.b("String pluginName = ConstantsPluginSDK.PLUGIN_NAME_MV;\n        String className = \".ui.MusicMvMainUI\";\n        if (!ExptSettingLogic.INSTANCE.openNewMusicPlayer()) {\n            pluginName = ConstantsPluginSDK.PLUGIN_NAME_MUSIC;\n            className = \".ui.MusicMainUI\";\n        }\n        PluginHelper.startActivity(context, pluginName, className, intent);dbbackup", null);
      com.tencent.mm.br.b.b("soter_mp", null);
      com.tencent.mm.br.b.b("sl_warpgate", null);
      com.tencent.mm.br.b.b("aa", null);
      com.tencent.mm.br.b.b("sport", null);
      com.tencent.mm.br.b.b("fps_lighter", null);
      com.tencent.mm.br.b.b("mmsight", null);
      com.tencent.mm.br.b.b("login_exdevice", null);
      com.tencent.mm.br.b.b("finder", null);
      com.tencent.mm.br.b.b("groupcollect", null);
      com.tencent.mm.br.b.b("editor", null);
      com.tencent.mm.br.b.b("teenmode", null);
      com.tencent.mm.br.b.b("kidswatch", null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginCompatOldStructure
 * JD-Core Version:    0.7.0.1
 */