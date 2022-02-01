package com.tencent.mm.plugin.gamelive;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;", "", "scenePosition", "", "(Ljava/lang/String;II)V", "getScenePosition", "()I", "PrePareScene_Origin", "PrePareScene_GameStart", "PrePareScene_FinderStart", "Companion", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum PluginGameLive$d
{
  public static final a Jee;
  final int Jef;
  
  static
  {
    AppMethodBeat.i(277253);
    Jeg = new d("PrePareScene_Origin", 0, 0);
    Jeh = new d("PrePareScene_GameStart", 1, 1);
    Jei = new d("PrePareScene_FinderStart", 2, 2);
    Jej = new d[] { Jeg, Jeh, Jei };
    Jee = new a((byte)0);
    AppMethodBeat.o(277253);
  }
  
  private PluginGameLive$d(int paramInt)
  {
    this.Jef = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene$Companion;", "", "()V", "getScene", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;", "scenePositionT", "", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.PluginGameLive.d
 * JD-Core Version:    0.7.0.1
 */