package com.tencent.mm.plugin.flutter.e.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorEmojiGroupInfoListFetcher;", "", "()V", "bitmapToByteArray", "", "bitmap", "Landroid/graphics/Bitmap;", "getAllGroupInfo", "", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getCustomEmojiBase64FromMd5", "md5", "", "getDesignerInfo", "Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "productId", "getDownloadCustomEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getEmojiAsBase64", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/EmojiInfo;", "getEmojiGifFromMd5", "getEmojiInfoList", "getEmojinName", "getGifSizeFromMd5", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/GifSize;", "getSystemEmojiMd5List", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showEmojiGroupDetail", "", "Companion", "plugin-flutter_release"})
public final class h
{
  private static h wKa;
  public static final a wKb;
  
  static
  {
    AppMethodBeat.i(241085);
    wKb = new a((byte)0);
    AppMethodBeat.o(241085);
  }
  
  /* Error */
  public static byte[] ab(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc 75
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +135 -> 141
    //   9: new 77	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 78	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_1
    //   17: aload_0
    //   18: getstatic 84	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   21: bipush 100
    //   23: aload_1
    //   24: checkcast 86	java/io/OutputStream
    //   27: invokevirtual 92	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 95	java/io/ByteArrayOutputStream:flush	()V
    //   35: aload_1
    //   36: invokevirtual 98	java/io/ByteArrayOutputStream:close	()V
    //   39: aload_1
    //   40: invokevirtual 102	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   43: astore_0
    //   44: aload_0
    //   45: ldc 104
    //   47: invokestatic 110	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   50: aload_1
    //   51: astore_2
    //   52: aload_0
    //   53: astore_1
    //   54: aload_2
    //   55: ifnull +13 -> 68
    //   58: aload_2
    //   59: invokevirtual 95	java/io/ByteArrayOutputStream:flush	()V
    //   62: aload_2
    //   63: invokevirtual 98	java/io/ByteArrayOutputStream:close	()V
    //   66: aload_0
    //   67: astore_1
    //   68: ldc 75
    //   70: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_1
    //   74: areturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: ifnull +17 -> 96
    //   82: aload_1
    //   83: invokevirtual 95	java/io/ByteArrayOutputStream:flush	()V
    //   86: aload_1
    //   87: invokevirtual 98	java/io/ByteArrayOutputStream:close	()V
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -24 -> 68
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_1
    //   98: goto -30 -> 68
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +11 -> 116
    //   108: aload_1
    //   109: invokevirtual 95	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_1
    //   113: invokevirtual 98	java/io/ByteArrayOutputStream:close	()V
    //   116: ldc 75
    //   118: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: athrow
    //   123: astore_1
    //   124: goto -8 -> 116
    //   127: astore_0
    //   128: goto -24 -> 104
    //   131: astore_0
    //   132: goto -54 -> 78
    //   135: astore_1
    //   136: aload_0
    //   137: astore_1
    //   138: goto -70 -> 68
    //   141: aconst_null
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_0
    //   145: goto -93 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramBitmap	android.graphics.Bitmap
    //   16	97	1	localObject1	Object
    //   123	1	1	localIOException1	java.io.IOException
    //   135	1	1	localIOException2	java.io.IOException
    //   137	1	1	localBitmap	android.graphics.Bitmap
    //   51	92	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	17	75	java/io/IOException
    //   82	90	95	java/io/IOException
    //   9	17	101	finally
    //   108	116	123	java/io/IOException
    //   17	50	127	finally
    //   17	50	131	java/io/IOException
    //   58	66	135	java/io/IOException
  }
  
  public static List<EmojiInfo> axq(String paramString)
  {
    AppMethodBeat.i(241075);
    paramString = j.auL().EQ(paramString);
    p.g(paramString, "EmojiStorageCache.getIns…tEmojiInfoList(productId)");
    paramString = (List)paramString;
    AppMethodBeat.o(241075);
    return paramString;
  }
  
  public static byte[] axr(String paramString)
  {
    AppMethodBeat.i(241078);
    p.h(paramString, "md5");
    paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amm(paramString);
    com.tencent.mm.kernel.b.a locala = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
    p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString = ((com.tencent.mm.plugin.emoji.b.d)locala).getEmojiMgr().a(paramString);
    AppMethodBeat.o(241078);
    return paramString;
  }
  
  public static d axs(String paramString)
  {
    AppMethodBeat.i(241079);
    p.h(paramString, "md5");
    paramString = MMGIFJNIFactory.Companion.getDecoder(paramString);
    d locald = new d();
    locald.irm = Integer.valueOf(paramString.aus());
    locald.irl = Integer.valueOf(paramString.aur());
    AppMethodBeat.o(241079);
    return locald;
  }
  
  public static void axt(String paramString)
  {
    AppMethodBeat.i(241080);
    if (paramString != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("preceding_scence", 3);
      localIntent.putExtra("download_entrance_scene", 16);
      localIntent.putExtra("from_popup", true);
      localIntent.putExtra("extra_id", paramString);
      c.b(MMApplicationContext.getContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
      paramString = g.ah(PluginFlutter.class);
      p.g(paramString, "MMKernel.plugin(PluginFlutter::class.java)");
      paramString = ((PluginFlutter)paramString).getFlutterEngineMgr();
      p.g(paramString, "MMKernel.plugin(PluginFl…ss.java).flutterEngineMgr");
      paramString = paramString.dLs();
      p.g(paramString, "MMKernel.plugin(PluginFl…ngineMgr.currentContainer");
      paramString.getActivity().overridePendingTransition(2130772169, 2130772166);
    }
    AppMethodBeat.o(241080);
  }
  
  public static byte[] axu(String paramString)
  {
    AppMethodBeat.i(241081);
    paramString = ab(((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amm(paramString).A((Context)((com.tencent.mm.kernel.b.h)g.aAe().azG()).aAZ(), 480));
    AppMethodBeat.o(241081);
    return paramString;
  }
  
  public static String axv(String paramString)
  {
    AppMethodBeat.i(241082);
    p.h(paramString, "md5");
    com.tencent.mm.kernel.b.a locala = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
    p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString = ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().amp(paramString);
    AppMethodBeat.o(241082);
    return paramString;
  }
  
  public static PersonalDesigner axw(String paramString)
  {
    AppMethodBeat.i(241083);
    paramString = j.auL().ER(paramString);
    AppMethodBeat.o(241083);
    return paramString;
  }
  
  public static List<EmojiGroupInfo> dLS()
  {
    AppMethodBeat.i(241074);
    Object localObject = j.auL();
    p.g(localObject, "EmojiStorageCache.getInstance()");
    localObject = ((j)localObject).auP();
    p.g(localObject, "EmojiStorageCache.getInstance().emojiGroupInfoList");
    localObject = (List)localObject;
    AppMethodBeat.o(241074);
    return localObject;
  }
  
  public static List<EmojiInfo> dLT()
  {
    AppMethodBeat.i(241076);
    Object localObject = j.auL().auO();
    p.g(localObject, "EmojiStorageCache.getIns….getDownloadCustomEmoji()");
    localObject = (List)localObject;
    AppMethodBeat.o(241076);
    return localObject;
  }
  
  public static ArrayList<String> dLU()
  {
    AppMethodBeat.i(241077);
    Object localObject = j.auL().dT(true);
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (localEmojiInfo.field_catalog == EmojiGroupInfo.Uun)
      {
        p.g(localEmojiInfo, "emojiInfo");
        localArrayList.add(localEmojiInfo.getMd5());
      }
    }
    AppMethodBeat.o(241077);
    return localArrayList;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorEmojiGroupInfoListFetcher$Companion;", "", "()V", "mInstance", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorEmojiGroupInfoListFetcher;", "getInstance", "plugin-flutter_release"})
  public static final class a
  {
    public static h dLW()
    {
      AppMethodBeat.i(241073);
      if (h.dLV() == null) {
        h.a(new h((byte)0));
      }
      h localh = h.dLV();
      if (localh == null) {
        p.hyc();
      }
      AppMethodBeat.o(241073);
      return localh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.h
 * JD-Core Version:    0.7.0.1
 */