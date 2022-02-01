package com.tencent.mm.plugin.gamelive;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;", "", "scenePosition", "", "(Ljava/lang/String;II)V", "getScenePosition", "()I", "PrePareScene_Origin", "PrePareScene_GameStart", "PrePareScene_FinderStart", "Companion", "plugin-gamelive_release"})
public enum PluginGameLive$d
{
  public static final a DkZ;
  final int DkY;
  
  static
  {
    AppMethodBeat.i(208076);
    d locald1 = new d("PrePareScene_Origin", 0, 0);
    DkU = locald1;
    d locald2 = new d("PrePareScene_GameStart", 1, 1);
    DkV = locald2;
    d locald3 = new d("PrePareScene_FinderStart", 2, 2);
    DkW = locald3;
    DkX = new d[] { locald1, locald2, locald3 };
    DkZ = new a((byte)0);
    AppMethodBeat.o(208076);
  }
  
  private PluginGameLive$d(int paramInt)
  {
    this.DkY = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene$Companion;", "", "()V", "getScene", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;", "scenePositionT", "", "plugin-gamelive_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.PluginGameLive.d
 * JD-Core Version:    0.7.0.1
 */