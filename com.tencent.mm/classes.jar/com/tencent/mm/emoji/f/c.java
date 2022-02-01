package com.tencent.mm.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/util/EmojiFileUtil;", "", "()V", "MaxThumbSize", "", "TAG", "", "dataEmojiRoot", "getDataEmojiRoot", "()Ljava/lang/String;", "emojiGifRoot", "getEmojiGifRoot", "emojiResAnim", "getEmojiResAnim", "emojiResEgg", "getEmojiResEgg", "emojiResNewEmoji", "getEmojiResNewEmoji", "emojiResPanel", "getEmojiResPanel", "emojiSystemRoot", "getEmojiSystemRoot", "emojiTempRoot", "getEmojiTempRoot", "emojiThumbRoot", "getEmojiThumbRoot", "emojiThumbSuffix", "getEmojiThumbSuffix", "emojiVFSRoot", "getEmojiVFSRoot", "copyAndUnzipFile", "", "zipPath", "folderName", "getThumbPath", "md5", "removeAllGenerateThumb", "", "unzipFolder", "", "zipFileString", "outPathString", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c moq;
  private static final long mor;
  private static final String mos;
  private static final String mot;
  private static final String mou;
  
  static
  {
    AppMethodBeat.i(177058);
    moq = new c();
    TAG = "MicroMsg.EmojiFileUtil";
    mor = 62914560L;
    mos = aWA();
    mot = s.X(aWA(), "/temp/");
    mou = "_cover";
    AppMethodBeat.o(177058);
  }
  
  public static String Ew(String paramString)
  {
    AppMethodBeat.i(177056);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177056);
      return null;
    }
    paramString = mos + paramString + mou;
    AppMethodBeat.o(177056);
    return paramString;
  }
  
  /* Error */
  private static int aA(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 134
    //   2: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: new 136	java/util/zip/ZipInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokestatic 142	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: invokespecial 145	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 149	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +285 -> 314
    //   32: aload_3
    //   33: invokevirtual 154	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   36: astore 4
    //   38: aload 4
    //   40: ldc 156
    //   42: invokestatic 160	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   45: aload 4
    //   47: checkcast 162	java/lang/CharSequence
    //   50: ldc 164
    //   52: checkcast 162	java/lang/CharSequence
    //   55: invokestatic 169	kotlin/n/n:i	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   58: ifne -30 -> 28
    //   61: aload 4
    //   63: checkcast 162	java/lang/CharSequence
    //   66: ldc 171
    //   68: checkcast 162	java/lang/CharSequence
    //   71: invokestatic 169	kotlin/n/n:i	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   74: ifne -46 -> 28
    //   77: aload_3
    //   78: invokevirtual 175	java/util/zip/ZipEntry:isDirectory	()Z
    //   81: ifeq +65 -> 146
    //   84: aload 4
    //   86: iconst_0
    //   87: aload 4
    //   89: invokevirtual 181	java/lang/String:length	()I
    //   92: iconst_1
    //   93: isub
    //   94: invokevirtual 185	java/lang/String:substring	(II)Ljava/lang/String;
    //   97: astore_3
    //   98: aload_3
    //   99: ldc 187
    //   101: invokestatic 160	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   104: new 189	com/tencent/mm/vfs/u
    //   107: dup
    //   108: new 116	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   115: aload_1
    //   116: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: bipush 47
    //   121: invokevirtual 192	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   124: aload_3
    //   125: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 195	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 198	com/tencent/mm/vfs/u:jKY	()Z
    //   137: pop
    //   138: aload_0
    //   139: invokevirtual 149	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   142: astore_3
    //   143: goto -115 -> 28
    //   146: new 189	com/tencent/mm/vfs/u
    //   149: dup
    //   150: new 116	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   157: aload_1
    //   158: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: bipush 47
    //   163: invokevirtual 192	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   166: aload 4
    //   168: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 195	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   177: astore_3
    //   178: aload_3
    //   179: invokevirtual 202	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   182: astore 4
    //   184: aload 4
    //   186: invokestatic 206	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   189: aload 4
    //   191: invokevirtual 198	com/tencent/mm/vfs/u:jKY	()Z
    //   194: pop
    //   195: aload_3
    //   196: invokestatic 210	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   199: astore_3
    //   200: aload_3
    //   201: ldc 212
    //   203: invokestatic 160	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   206: sipush 1024
    //   209: newarray byte
    //   211: astore 4
    //   213: aload_0
    //   214: aload 4
    //   216: invokevirtual 216	java/util/zip/ZipInputStream:read	([B)I
    //   219: istore_2
    //   220: iload_2
    //   221: iconst_m1
    //   222: if_icmpeq +49 -> 271
    //   225: aload_3
    //   226: aload 4
    //   228: iconst_0
    //   229: iload_2
    //   230: invokevirtual 222	java/io/OutputStream:write	([BII)V
    //   233: goto -20 -> 213
    //   236: astore_3
    //   237: aload_0
    //   238: astore_1
    //   239: aload_1
    //   240: astore_0
    //   241: getstatic 77	com/tencent/mm/emoji/f/c:TAG	Ljava/lang/String;
    //   244: aload_3
    //   245: checkcast 224	java/lang/Throwable
    //   248: ldc 225
    //   250: iconst_0
    //   251: anewarray 4	java/lang/Object
    //   254: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: aload_1
    //   258: checkcast 233	java/io/Closeable
    //   261: invokestatic 239	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   264: ldc 134
    //   266: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: iconst_m1
    //   270: ireturn
    //   271: aload_3
    //   272: invokevirtual 242	java/io/OutputStream:close	()V
    //   275: goto -137 -> 138
    //   278: astore_3
    //   279: aload_0
    //   280: astore_1
    //   281: aload_1
    //   282: astore_0
    //   283: getstatic 77	com/tencent/mm/emoji/f/c:TAG	Ljava/lang/String;
    //   286: aload_3
    //   287: checkcast 224	java/lang/Throwable
    //   290: ldc 225
    //   292: iconst_0
    //   293: anewarray 4	java/lang/Object
    //   296: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: aload_1
    //   300: checkcast 233	java/io/Closeable
    //   303: invokestatic 239	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   306: ldc 134
    //   308: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: bipush 254
    //   313: ireturn
    //   314: aload_0
    //   315: checkcast 233	java/io/Closeable
    //   318: invokestatic 239	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   321: ldc 134
    //   323: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: iconst_0
    //   327: ireturn
    //   328: astore_1
    //   329: aconst_null
    //   330: astore_0
    //   331: aload_0
    //   332: checkcast 233	java/io/Closeable
    //   335: invokestatic 239	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   338: ldc 134
    //   340: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: aload_1
    //   344: athrow
    //   345: astore_1
    //   346: goto -15 -> 331
    //   349: astore_1
    //   350: goto -19 -> 331
    //   353: astore_3
    //   354: aload 5
    //   356: astore_1
    //   357: goto -76 -> 281
    //   360: astore_3
    //   361: aload 4
    //   363: astore_1
    //   364: goto -125 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramString1	String
    //   0	367	1	paramString2	String
    //   219	11	2	i	int
    //   27	199	3	localObject1	Object
    //   236	36	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   278	9	3	localIOException1	java.io.IOException
    //   353	1	3	localIOException2	java.io.IOException
    //   360	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   9	353	4	localObject2	Object
    //   6	349	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   23	28	236	java/io/FileNotFoundException
    //   32	138	236	java/io/FileNotFoundException
    //   138	143	236	java/io/FileNotFoundException
    //   146	213	236	java/io/FileNotFoundException
    //   213	220	236	java/io/FileNotFoundException
    //   225	233	236	java/io/FileNotFoundException
    //   271	275	236	java/io/FileNotFoundException
    //   23	28	278	java/io/IOException
    //   32	138	278	java/io/IOException
    //   138	143	278	java/io/IOException
    //   146	213	278	java/io/IOException
    //   213	220	278	java/io/IOException
    //   225	233	278	java/io/IOException
    //   271	275	278	java/io/IOException
    //   11	23	328	finally
    //   23	28	345	finally
    //   32	138	345	finally
    //   138	143	345	finally
    //   146	213	345	finally
    //   213	220	345	finally
    //   225	233	345	finally
    //   271	275	345	finally
    //   241	257	349	finally
    //   283	299	349	finally
    //   11	23	353	java/io/IOException
    //   11	23	360	java/io/FileNotFoundException
  }
  
  public static String aWA()
  {
    AppMethodBeat.i(242541);
    String str = s.X(((d)h.az(d.class)).getProvider().getAccPath(), "emoji/");
    AppMethodBeat.o(242541);
    return str;
  }
  
  public static String aWB()
  {
    return mot;
  }
  
  public static String aWC()
  {
    AppMethodBeat.i(242548);
    String str = s.X(b.bms(), "emoji/");
    AppMethodBeat.o(242548);
    return str;
  }
  
  public static String aWD()
  {
    AppMethodBeat.i(242549);
    String str = s.X(aWC(), "emoji_anim/");
    AppMethodBeat.o(242549);
    return str;
  }
  
  public static void aWE()
  {
    AppMethodBeat.i(177057);
    Object localObject = l.aUF().aUG();
    s.s(localObject, "emojiList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (Util.isNullOrNil(localEmojiInfo.field_thumbUrl)) {
        y.deleteFile(localEmojiInfo.kMo());
      }
    }
    AppMethodBeat.o(177057);
  }
  
  public static boolean az(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242557);
    s.u(paramString1, "zipPath");
    s.u(paramString2, "folderName");
    if (y.bEl(paramString1) > 0L)
    {
      Log.i(TAG, "copyAndUnzipFile start. zipPath:%s", new Object[] { paramString1 });
      paramString2 = new u(aWC(), paramString2);
      if (paramString2.jKS()) {
        y.ew(ah.v(paramString2.mUri), true);
      }
      paramString2.jKY();
      paramString2 = ah.v(paramString2.jKT());
      s.s(paramString2, "unzipFolder.absolutePath");
      if (aA(paramString1, paramString2) >= 0)
      {
        AppMethodBeat.o(242557);
        return true;
      }
      AppMethodBeat.o(242557);
      return false;
    }
    Log.i(TAG, "copyAndUnzipFile update file don't exist.");
    AppMethodBeat.o(242557);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */