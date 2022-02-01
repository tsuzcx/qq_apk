package com.tencent.mm.emoji.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "isHevc", "", "setImageBitmap", "", "bm", "Landroid/graphics/Bitmap;", "setMMGIFFileByteArray", "bytes", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class BaseEmojiView
  extends MMAnimateView
{
  private final String TAG = "MicroMsg.BaseEmojiView";
  public boolean isHevc;
  private EmojiInfo mgK;
  
  public BaseEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  /* Error */
  private final void setMMGIFFileByteArray(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 60
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 72	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   9: ifne +222 -> 231
    //   12: aload_1
    //   13: invokestatic 77	com/tencent/mm/sdk/platformtools/ImgUtil:isWXGF	([B)Z
    //   16: ifeq +64 -> 80
    //   19: ldc 79
    //   21: invokestatic 85	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   24: checkcast 79	com/tencent/mm/plugin/emoji/PluginEmoji
    //   27: invokevirtual 89	com/tencent/mm/plugin/emoji/PluginEmoji:getProvider	()Lcom/tencent/mm/pluginsdk/b/e;
    //   30: invokeinterface 95 1 0
    //   35: ifeq +45 -> 80
    //   38: new 97	com/tencent/mm/plugin/gif/h
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 99	com/tencent/mm/plugin/gif/h:<init>	([B)V
    //   46: checkcast 101	com/tencent/mm/plugin/gif/b
    //   49: astore_2
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 103	com/tencent/mm/emoji/view/BaseEmojiView:isHevc	Z
    //   55: aload_2
    //   56: invokevirtual 106	com/tencent/mm/plugin/gif/b:isRunning	()Z
    //   59: ifne +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 110	com/tencent/mm/plugin/gif/b:reset	()V
    //   66: aload_0
    //   67: aload_2
    //   68: checkcast 112	android/graphics/drawable/Drawable
    //   71: invokevirtual 116	com/tencent/mm/emoji/view/BaseEmojiView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   74: ldc 60
    //   76: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: return
    //   80: aload_0
    //   81: getfield 52	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   84: ldc 121
    //   86: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: new 129	com/tencent/mm/plugin/gif/d
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 130	com/tencent/mm/plugin/gif/d:<init>	([B)V
    //   97: checkcast 101	com/tencent/mm/plugin/gif/b
    //   100: astore_2
    //   101: goto -46 -> 55
    //   104: astore_2
    //   105: aload_2
    //   106: invokestatic 134	com/tencent/mm/emoji/view/BaseEmojiView:a	(Lcom/tencent/mm/plugin/gif/MMGIFException;)V
    //   109: aload_2
    //   110: invokevirtual 138	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   113: bipush 103
    //   115: if_icmpne +83 -> 198
    //   118: aload_0
    //   119: getfield 52	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   122: ldc 140
    //   124: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: invokestatic 149	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([B)Landroid/graphics/Bitmap;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +22 -> 155
    //   136: aload_2
    //   137: aload_0
    //   138: invokevirtual 152	com/tencent/mm/emoji/view/BaseEmojiView:getEmojiDensity	()I
    //   141: invokevirtual 157	android/graphics/Bitmap:setDensity	(I)V
    //   144: aload_0
    //   145: aload_2
    //   146: invokevirtual 160	com/tencent/mm/emoji/view/BaseEmojiView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   149: ldc 60
    //   151: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: return
    //   155: aload_0
    //   156: getfield 52	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   159: ldc 162
    //   161: iconst_1
    //   162: anewarray 164	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: invokestatic 170	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   171: aastore
    //   172: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: aload_0
    //   176: invokevirtual 176	com/tencent/mm/emoji/view/BaseEmojiView:getEmojiInfo	()Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 181	com/tencent/mm/storage/emotion/EmojiInfo:kMa	()V
    //   188: aload_0
    //   189: invokevirtual 184	com/tencent/mm/emoji/view/BaseEmojiView:init	()V
    //   192: ldc 60
    //   194: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: return
    //   198: aload_0
    //   199: getfield 52	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   202: ldc 186
    //   204: iconst_1
    //   205: anewarray 164	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_2
    //   211: invokevirtual 190	com/tencent/mm/plugin/gif/MMGIFException:toString	()Ljava/lang/String;
    //   214: aastore
    //   215: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_0
    //   219: invokevirtual 176	com/tencent/mm/emoji/view/BaseEmojiView:getEmojiInfo	()Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   222: astore_1
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 181	com/tencent/mm/storage/emotion/EmojiInfo:kMa	()V
    //   231: aload_0
    //   232: invokevirtual 184	com/tencent/mm/emoji/view/BaseEmojiView:init	()V
    //   235: ldc 60
    //   237: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: return
    //   241: astore_1
    //   242: aload_0
    //   243: getfield 52	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   246: ldc 186
    //   248: iconst_1
    //   249: anewarray 164	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_1
    //   255: invokevirtual 194	java/io/IOException:toString	()Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: goto -31 -> 231
    //   265: astore_1
    //   266: aload_0
    //   267: getfield 52	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   270: ldc 186
    //   272: iconst_1
    //   273: anewarray 164	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_1
    //   279: invokevirtual 195	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   282: aastore
    //   283: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: goto -55 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	BaseEmojiView
    //   0	289	1	paramArrayOfByte	byte[]
    //   49	52	2	localb	b
    //   104	6	2	localMMGIFException	MMGIFException
    //   131	80	2	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   5	55	104	com/tencent/mm/plugin/gif/MMGIFException
    //   55	66	104	com/tencent/mm/plugin/gif/MMGIFException
    //   66	79	104	com/tencent/mm/plugin/gif/MMGIFException
    //   80	101	104	com/tencent/mm/plugin/gif/MMGIFException
    //   5	55	241	java/io/IOException
    //   55	66	241	java/io/IOException
    //   66	79	241	java/io/IOException
    //   80	101	241	java/io/IOException
    //   5	55	265	java/lang/NullPointerException
    //   55	66	265	java/lang/NullPointerException
    //   66	79	265	java/lang/NullPointerException
    //   80	101	265	java/lang/NullPointerException
  }
  
  public EmojiInfo getEmojiInfo()
  {
    return this.mgK;
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(105785);
    if (s.p(this.mgK, paramEmojiInfo))
    {
      AppMethodBeat.o(105785);
      return;
    }
    this.mgK = paramEmojiInfo;
    if (paramEmojiInfo != null)
    {
      if ((paramEmojiInfo.field_catalog == EmojiGroupInfo.aklE) || (paramEmojiInfo.field_catalog == EmojiInfo.aklL) || (paramEmojiInfo.field_catalog == EmojiInfo.aklK))
      {
        setImageBitmap(paramEmojiInfo.F(getContext(), 300));
        AppMethodBeat.o(105785);
        return;
      }
      if (paramEmojiInfo.kMe())
      {
        InputStream localInputStream = EmojiInfo.cS(getContext(), paramEmojiInfo.getName());
        for (;;)
        {
          try
          {
            if (Util.isNullOrNil("")) {
              continue;
            }
            setCacheKey("");
            localc = c.fJa();
            str = getCacheKey();
            if (localInputStream != null) {
              continue;
            }
            paramEmojiInfo = (EmojiInfo)localObject1;
          }
          catch (MMGIFException paramEmojiInfo)
          {
            c localc;
            String str;
            MMAnimateView.a(paramEmojiInfo);
            if (paramEmojiInfo.getErrorCode() != 103) {
              break label345;
            }
            paramEmojiInfo = BitmapUtil.decodeStream(localInputStream);
            if (paramEmojiInfo == null) {
              break label333;
            }
            paramEmojiInfo.setDensity(getEmojiDensity());
            setImageBitmap(paramEmojiInfo);
            AppMethodBeat.o(105785);
            return;
            paramEmojiInfo = new d(localInputStream);
            continue;
          }
          catch (IOException paramEmojiInfo)
          {
            Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramEmojiInfo.toString() });
          }
          setImageDrawable(paramEmojiInfo);
          AppMethodBeat.o(105785);
          return;
          Log.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", new Object[] { str });
          localObject1 = localObject2;
          if (localc.JgB.get(str) != null) {
            localObject1 = (b)((WeakReference)localc.JgB.get(str)).get();
          }
          paramEmojiInfo = (EmojiInfo)localObject1;
          if (localObject1 == null)
          {
            paramEmojiInfo = new d(localInputStream);
            localc.JgB.put(str, new WeakReference(paramEmojiInfo));
          }
        }
        for (;;)
        {
          init();
          AppMethodBeat.o(105785);
          return;
          label333:
          Log.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
          continue;
          label345:
          Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramEmojiInfo.toString() });
        }
      }
      setMMGIFFileByteArray(((PluginEmoji)h.az(PluginEmoji.class)).getProvider().a(getEmojiInfo()));
    }
    AppMethodBeat.o(105785);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(105786);
    if (paramBitmap != null) {
      paramBitmap.setDensity(320);
    }
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(105786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.view.BaseEmojiView
 * JD-Core Version:    0.7.0.1
 */