package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.h;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;", "", "()V", "TAG", "", "decodeThumb", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "byteArray", "", "getDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "md5", "isValid", "", "decoder", "plugin-emojisdk_release"})
public final class MMGIFJNIFactory$Companion
{
  public final Bitmap decodeThumb(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(177050);
    p.k(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = ((Companion)this).getDecoder(paramEmojiInfo);
    if (((Companion)this).isValid(paramEmojiInfo))
    {
      paramEmojiInfo.aBh();
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
    AppMethodBeat.i(225424);
    paramArrayOfByte = ((Companion)this).getDecoder(paramArrayOfByte);
    if (((Companion)this).isValid(paramArrayOfByte))
    {
      paramArrayOfByte.aBh();
      Bitmap localBitmap = paramArrayOfByte.getFrame();
      paramArrayOfByte.destroy();
      AppMethodBeat.o(225424);
      return localBitmap;
    }
    AppMethodBeat.o(225424);
    return null;
  }
  
  public final d getDecoder(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105374);
    p.k(paramEmojiInfo, "emojiInfo");
    for (;;)
    {
      try
      {
        if ((paramEmojiInfo.hBy() != EmojiGroupInfo.YCv) && (paramEmojiInfo.hBy() != EmojiInfo.YCC) && (paramEmojiInfo.hBy() != EmojiInfo.YCB)) {
          continue;
        }
        localObject = (d)new e(paramEmojiInfo.C(MMApplicationContext.getContext(), 300));
        paramEmojiInfo = (EmojiInfo)localObject;
      }
      catch (MMGIFException localMMGIFException)
      {
        Object localObject;
        Log.w(MMGIFJNIFactory.access$getTAG$cp(), "decode error: " + localMMGIFException.getErrorCode());
        if (localMMGIFException.getErrorCode() != 103) {
          continue;
        }
        a locala = h.ag(PluginEmoji.class);
        p.j(locala, "MMKernel.plugin(PluginEmoji::class.java)");
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
      if (paramEmojiInfo.hBu())
      {
        localObject = EmojiInfo.cH(MMApplicationContext.getContext(), paramEmojiInfo.getName());
        p.j(localObject, "EmojiInfo.getEmojiFile(M…ontext(), emojiInfo.name)");
        localObject = (d)new f((InputStream)localObject);
        paramEmojiInfo = (EmojiInfo)localObject;
      }
      else
      {
        localObject = h.ag(PluginEmoji.class);
        p.j(localObject, "MMKernel.plugin(PluginEmoji::class.java)");
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
    AppMethodBeat.i(225409);
    p.k(paramString, "md5");
    bj localbj = bj.hyV();
    p.j(localbj, "EmojiStorageMgr.getInstance()");
    paramString = localbj.ctY().bxK(paramString);
    if (paramString == null)
    {
      paramString = (d)new b();
      AppMethodBeat.o(225409);
      return paramString;
    }
    paramString = ((Companion)this).getDecoder(paramString);
    AppMethodBeat.o(225409);
    return paramString;
  }
  
  public final d getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225420);
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
        AppMethodBeat.o(225420);
        return paramArrayOfByte;
      }
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = (d)new b();
        AppMethodBeat.o(225420);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion
 * JD-Core Version:    0.7.0.1
 */