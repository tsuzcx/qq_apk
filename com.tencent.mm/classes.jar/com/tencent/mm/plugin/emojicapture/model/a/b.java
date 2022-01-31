package com.tencent.mm.plugin.emojicapture.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "", "()V", "iconPath", "", "getIconPath", "()Ljava/lang/String;", "setIconPath", "(Ljava/lang/String;)V", "lensId", "getLensId", "setLensId", "name", "getName", "setName", "resPath", "getResPath", "setResPath", "subType", "", "getSubType", "()I", "setSubType", "(I)V", "tipIcons", "Ljava/util/LinkedList;", "getTipIcons", "()Ljava/util/LinkedList;", "setTipIcons", "(Ljava/util/LinkedList;)V", "tips", "getTips", "setTips", "title", "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "valid", "", "getValid", "()Z", "setValid", "(Z)V", "version", "getVersion", "setVersion", "isTipsValid", "toString", "plugin-emojicapture_release"})
public final class b
{
  public boolean aeE;
  public String fhT;
  public String hPe;
  public String kqb;
  public String lsW;
  public String ltJ;
  public LinkedList<String> ltK;
  public String name;
  int subType;
  public String title;
  int version;
  
  public b()
  {
    AppMethodBeat.i(2638);
    this.lsW = "";
    this.hPe = "";
    this.ltJ = "";
    this.name = "";
    this.title = "";
    this.fhT = "";
    this.kqb = "";
    this.ltK = new LinkedList();
    AppMethodBeat.o(2638);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2637);
    String str = "EmojiStickerInfo(subType=" + this.subType + ", version=" + this.version + ", valid=" + this.aeE + ", lensId='" + this.lsW + "', iconPath='" + this.hPe + "', resPath='" + this.ltJ + "', name='" + this.name + "', title='" + this.title + "', titleColor='" + this.fhT + "', tips='" + this.kqb + "', tipIcons=" + this.ltK + ')';
    AppMethodBeat.o(2637);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.b
 * JD-Core Version:    0.7.0.1
 */