package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory;", "", "()V", "Companion", "plugin-emojisdk_release"})
public final class MMGIFJNIFactory
{
  public static final Companion Companion;
  private static final String TAG = "MicroMsg.MMGIFJNIFactory";
  
  static
  {
    AppMethodBeat.i(105375);
    Companion = new Companion(null);
    TAG = "MicroMsg.MMGIFJNIFactory";
    AppMethodBeat.o(105375);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;", "", "()V", "TAG", "", "decodeThumb", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "byteArray", "", "getDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "md5", "isValid", "", "decoder", "plugin-emojisdk_release"})
  public static final class Companion
  {
    public final Bitmap decodeThumb(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(177050);
      p.h(paramEmojiInfo, "emojiInfo");
      paramEmojiInfo = ((Companion)this).getDecoder(paramEmojiInfo);
      if (((Companion)this).isValid(paramEmojiInfo))
      {
        paramEmojiInfo.auo();
        Bitmap localBitmap = paramEmojiInfo.getFrame();
        paramEmojiInfo.destroy();
        AppMethodBeat.o(177050);
        return localBitmap;
      }
      AppMethodBeat.o(177050);
      return null;
    }
    
    public final Bitmap decodeThumb(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(199866);
      paramArrayOfByte = ((Companion)this).getDecoder(paramArrayOfByte);
      if (((Companion)this).isValid(paramArrayOfByte))
      {
        paramArrayOfByte.auo();
        Bitmap localBitmap = paramArrayOfByte.getFrame();
        paramArrayOfByte.destroy();
        AppMethodBeat.o(199866);
        return localBitmap;
      }
      AppMethodBeat.o(199866);
      return null;
    }
    
    public final d getDecoder(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(105374);
      p.h(paramEmojiInfo, "emojiInfo");
      for (;;)
      {
        try
        {
          if ((paramEmojiInfo.getGroup() != EmojiGroupInfo.Uun) && (paramEmojiInfo.getGroup() != EmojiInfo.Uuu) && (paramEmojiInfo.getGroup() != EmojiInfo.Uut)) {
            continue;
          }
          localObject = (d)new e(paramEmojiInfo.A(MMApplicationContext.getContext(), 300));
          paramEmojiInfo = (EmojiInfo)localObject;
        }
        catch (MMGIFException localMMGIFException)
        {
          Object localObject;
          Log.w(MMGIFJNIFactory.access$getTAG$cp(), "decode error: " + localMMGIFException.getErrorCode());
          if (localMMGIFException.getErrorCode() != 103) {
            continue;
          }
          a locala = com.tencent.mm.kernel.g.ah(PluginEmoji.class);
          p.g(locala, "MMKernel.plugin(PluginEmoji::class.java)");
          paramEmojiInfo = ((PluginEmoji)locala).getProvider().a(paramEmojiInfo);
          if (paramEmojiInfo == null) {
            continue;
          }
          paramEmojiInfo = (d)new e(paramEmojiInfo);
          continue;
          AppMethodBeat.o(105374);
          return paramEmojiInfo;
          paramEmojiInfo = null;
          continue;
        }
        if (paramEmojiInfo != null) {
          continue;
        }
        paramEmojiInfo = (d)new b();
        AppMethodBeat.o(105374);
        return paramEmojiInfo;
        if (paramEmojiInfo.hRB())
        {
          localObject = EmojiInfo.bD(MMApplicationContext.getContext(), paramEmojiInfo.getName());
          p.g(localObject, "EmojiInfo.getEmojiFile(M…ontext(), emojiInfo.name)");
          localObject = (d)new f((InputStream)localObject);
          paramEmojiInfo = (EmojiInfo)localObject;
        }
        else
        {
          localObject = com.tencent.mm.kernel.g.ah(PluginEmoji.class);
          p.g(localObject, "MMKernel.plugin(PluginEmoji::class.java)");
          localObject = ((PluginEmoji)localObject).getProvider().a(paramEmojiInfo);
          if (localObject == null) {
            continue;
          }
          if (ImgUtil.isWXGF((byte[])localObject))
          {
            localObject = (d)new g((byte[])localObject);
            paramEmojiInfo = (EmojiInfo)localObject;
          }
          else
          {
            localObject = (d)new f((byte[])localObject);
            paramEmojiInfo = (EmojiInfo)localObject;
          }
        }
      }
    }
    
    public final d getDecoder(String paramString)
    {
      AppMethodBeat.i(199864);
      p.h(paramString, "md5");
      bj localbj = bj.gCJ();
      p.g(localbj, "EmojiStorageMgr.getInstance()");
      paramString = localbj.cgN().blk(paramString);
      if (paramString == null)
      {
        paramString = (d)new b();
        AppMethodBeat.o(199864);
        return paramString;
      }
      paramString = ((Companion)this).getDecoder(paramString);
      AppMethodBeat.o(199864);
      return paramString;
    }
    
    public final d getDecoder(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(199865);
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        try
        {
          if (!ImgUtil.isWXGF(paramArrayOfByte)) {
            continue;
          }
          locald = (d)new g(paramArrayOfByte);
          paramArrayOfByte = locald;
        }
        catch (MMGIFException localMMGIFException)
        {
          d locald;
          Log.printErrStackTrace(MMGIFJNIFactory.access$getTAG$cp(), (Throwable)localMMGIFException, "decode bytes error", new Object[0]);
          if ((localMMGIFException.getErrorCode() != 103) || (paramArrayOfByte == null)) {
            break label145;
          }
          paramArrayOfByte = (d)new e(paramArrayOfByte);
          continue;
          AppMethodBeat.o(199865);
          return paramArrayOfByte;
        }
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = (d)new b();
          AppMethodBeat.o(199865);
          return paramArrayOfByte;
          if (ImgUtil.isGif(paramArrayOfByte))
          {
            locald = (d)new f(paramArrayOfByte);
            paramArrayOfByte = locald;
          }
          else
          {
            locald = (d)new e(paramArrayOfByte);
            paramArrayOfByte = locald;
          }
        }
        else
        {
          label145:
          paramArrayOfByte = null;
        }
      }
    }
    
    public final boolean isValid(d paramd)
    {
      return (paramd != null) && (!(paramd instanceof b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.MMGIFJNIFactory
 * JD-Core Version:    0.7.0.1
 */