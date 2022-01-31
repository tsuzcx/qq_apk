package com.tencent.mm.plugin.emojicapture.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.emojicapture.model.c.g;
import com.tencent.mm.plugin.emojicapture.model.c.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerResHelper;", "Lcom/tencent/mm/plugin/emojicapture/api/IEmojiStickerRes;", "()V", "assetsRoot", "", "getAssetsRoot", "()Ljava/lang/String;", "compressConfigFile", "getCompressConfigFile", "configFile", "getConfigFile", "configFilePath", "getConfigFilePath", "itemConfigFile", "getItemConfigFile", "localRoot", "getLocalRoot", "localStickerRes", "getLocalStickerRes", "localStickerTmp", "getLocalStickerTmp", "tempConfigPath", "getTempConfigPath", "typePrefix", "getTypePrefix", "versionFile", "getVersionFile", "zipFile", "getZipFile", "checkAssetsVersion", "", "checkResUpdate", "", "copyResFromAssets", "getItemConfig", "Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceFileConfig;", "subType", "", "getItemConfigTemp", "itemConfigFilePath", "itemConfigTempFilePath", "itemDirPath", "unCompressFromTemp", "unCompressItem", "fromFolder", "toFolder", "unCompressSubType", "plugin-emojicapture_release"})
public final class e
  implements com.tencent.mm.plugin.emojicapture.api.a
{
  private static final String ltT = "assets:///sticker/";
  private static final String ltU;
  static final String ltV;
  static final String ltW;
  private static final String ltX = "compress.zip";
  private static final String ltY = "version.txt";
  static final String ltZ = "59_";
  private static final String lua = "EmoticonLensConfigFile.xml";
  private static final String lub;
  private static final String luc;
  private static final String lud = "EmoticonLensResouceCompreConfigFile.xml";
  private static final String lue = "EmoticonLensResouceAllFileConfigFile.xml";
  public static final e luf;
  
  static
  {
    AppMethodBeat.i(2651);
    luf = new e();
    ltT = "assets:///sticker/";
    ltU = b.eQw + "sticker/";
    ltV = ltU + "res/";
    ltW = ltU + "compress/";
    ltX = "compress.zip";
    ltY = "version.txt";
    ltZ = "59_";
    lua = "EmoticonLensConfigFile.xml";
    lub = ltV + "59_0/" + lua;
    luc = ltW + "59_0/" + lua;
    lud = "EmoticonLensResouceCompreConfigFile.xml";
    lue = "EmoticonLensResouceAllFileConfigFile.xml";
    AppMethodBeat.o(2651);
  }
  
  public static String boC()
  {
    return ltU;
  }
  
  public static String boD()
  {
    return ltW;
  }
  
  public static String boE()
  {
    return luc;
  }
  
  public static void boF()
  {
    AppMethodBeat.i(2647);
    ab.i(f.Ot(), "copyResFromAssets: ");
    long l = bo.yB();
    com.tencent.mm.vfs.e.cO(ltU);
    ab.i(f.Ot(), "copyResFromAssets: cost " + bo.av(l));
    AppMethodBeat.o(2647);
  }
  
  static void dQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2648);
    com.tencent.mm.vfs.e.cO(paramString2);
    com.tencent.mm.vfs.e.iF(paramString1, paramString2);
    paramString1 = paramString2 + File.separator + lud;
    if (com.tencent.mm.vfs.e.cN(paramString1))
    {
      Object localObject = new com.tencent.mm.plugin.emojicapture.model.c.f();
      a.a locala = com.tencent.mm.emoji.a.a.ewm;
      a.a.a(paramString1, (com.tencent.mm.emoji.a.a)localObject);
      paramString1 = ((Iterable)((com.tencent.mm.plugin.emojicapture.model.c.f)localObject).lvB).iterator();
      while (paramString1.hasNext())
      {
        localObject = (g)paramString1.next();
        com.tencent.mm.vfs.e.C(paramString2 + ((g)localObject).lvC, paramString2 + ((g)localObject).lvD);
      }
    }
    AppMethodBeat.o(2648);
  }
  
  public static String uI(int paramInt)
  {
    AppMethodBeat.i(2649);
    String str = ltV + ltZ + paramInt + '/' + lue;
    AppMethodBeat.o(2649);
    return str;
  }
  
  public static h uJ(int paramInt)
  {
    AppMethodBeat.i(2650);
    String str = ltW + ltZ + paramInt + '/' + lue;
    h localh = new h();
    a.a locala = com.tencent.mm.emoji.a.a.ewm;
    a.a.a(str, (com.tencent.mm.emoji.a.a)localh);
    AppMethodBeat.o(2650);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.e
 * JD-Core Version:    0.7.0.1
 */