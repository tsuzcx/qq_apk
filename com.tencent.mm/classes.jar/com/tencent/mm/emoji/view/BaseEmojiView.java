package com.tencent.mm.emoji.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "isHevc", "", "setImageBitmap", "", "bm", "Landroid/graphics/Bitmap;", "setMMGIFFileByteArray", "bytes", "", "plugin-emojisdk_release"})
public class BaseEmojiView
  extends MMAnimateView
{
  private final String TAG = "MicroMsg.BaseEmojiView";
  private EmojiInfo glt;
  public boolean gsO;
  
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
    //   0: ldc 58
    //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 70	com/tencent/mm/sdk/platformtools/bu:cF	([B)Z
    //   9: ifne +238 -> 247
    //   12: aload_1
    //   13: invokestatic 75	com/tencent/mm/sdk/platformtools/u:cy	([B)Z
    //   16: ifeq +80 -> 96
    //   19: ldc 77
    //   21: invokestatic 83	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   24: astore_2
    //   25: aload_2
    //   26: ldc 85
    //   28: invokestatic 91	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   31: aload_2
    //   32: checkcast 77	com/tencent/mm/plugin/emoji/PluginEmoji
    //   35: invokevirtual 95	com/tencent/mm/plugin/emoji/PluginEmoji:getProvider	()Lcom/tencent/mm/pluginsdk/a/e;
    //   38: astore_2
    //   39: aload_2
    //   40: ldc 97
    //   42: invokestatic 91	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   45: aload_2
    //   46: invokeinterface 103 1 0
    //   51: ifeq +45 -> 96
    //   54: new 105	com/tencent/mm/plugin/gif/h
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 107	com/tencent/mm/plugin/gif/h:<init>	([B)V
    //   62: checkcast 109	com/tencent/mm/plugin/gif/b
    //   65: astore_2
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 111	com/tencent/mm/emoji/view/BaseEmojiView:gsO	Z
    //   71: aload_2
    //   72: invokevirtual 114	com/tencent/mm/plugin/gif/b:isRunning	()Z
    //   75: ifne +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 118	com/tencent/mm/plugin/gif/b:reset	()V
    //   82: aload_0
    //   83: aload_2
    //   84: checkcast 120	android/graphics/drawable/Drawable
    //   87: invokevirtual 124	com/tencent/mm/emoji/view/BaseEmojiView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   90: ldc 58
    //   92: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: aload_0
    //   97: getfield 50	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   100: ldc 129
    //   102: invokestatic 135	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: new 137	com/tencent/mm/plugin/gif/d
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 138	com/tencent/mm/plugin/gif/d:<init>	([B)V
    //   113: checkcast 109	com/tencent/mm/plugin/gif/b
    //   116: astore_2
    //   117: goto -46 -> 71
    //   120: astore_2
    //   121: aload_2
    //   122: invokestatic 142	com/tencent/mm/emoji/view/BaseEmojiView:a	(Lcom/tencent/mm/plugin/gif/MMGIFException;)V
    //   125: aload_2
    //   126: invokevirtual 146	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   129: bipush 103
    //   131: if_icmpne +83 -> 214
    //   134: aload_0
    //   135: getfield 50	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   138: ldc 148
    //   140: invokestatic 151	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_1
    //   144: invokestatic 157	com/tencent/mm/sdk/platformtools/h:cu	([B)Landroid/graphics/Bitmap;
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull +22 -> 171
    //   152: aload_2
    //   153: aload_0
    //   154: invokevirtual 160	com/tencent/mm/emoji/view/BaseEmojiView:getEmojiDensity	()I
    //   157: invokevirtual 165	android/graphics/Bitmap:setDensity	(I)V
    //   160: aload_0
    //   161: aload_2
    //   162: invokevirtual 168	com/tencent/mm/emoji/view/BaseEmojiView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   165: ldc 58
    //   167: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: aload_0
    //   172: getfield 50	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   175: ldc 170
    //   177: iconst_1
    //   178: anewarray 172	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_1
    //   184: invokestatic 178	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   187: aastore
    //   188: invokestatic 182	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_0
    //   192: invokevirtual 184	com/tencent/mm/emoji/view/BaseEmojiView:getEmojiInfo	()Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   195: astore_1
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 189	com/tencent/mm/storage/emotion/EmojiInfo:fxo	()V
    //   204: aload_0
    //   205: invokevirtual 192	com/tencent/mm/emoji/view/BaseEmojiView:init	()V
    //   208: ldc 58
    //   210: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: return
    //   214: aload_0
    //   215: getfield 50	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   218: ldc 194
    //   220: iconst_1
    //   221: anewarray 172	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_2
    //   227: invokevirtual 198	com/tencent/mm/plugin/gif/MMGIFException:toString	()Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic 201	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: aload_0
    //   235: invokevirtual 184	com/tencent/mm/emoji/view/BaseEmojiView:getEmojiInfo	()Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   238: astore_1
    //   239: aload_1
    //   240: ifnull +7 -> 247
    //   243: aload_1
    //   244: invokevirtual 189	com/tencent/mm/storage/emotion/EmojiInfo:fxo	()V
    //   247: aload_0
    //   248: invokevirtual 192	com/tencent/mm/emoji/view/BaseEmojiView:init	()V
    //   251: ldc 58
    //   253: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: return
    //   257: astore_1
    //   258: aload_0
    //   259: getfield 50	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   262: ldc 194
    //   264: iconst_1
    //   265: anewarray 172	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: aload_1
    //   271: invokevirtual 202	java/io/IOException:toString	()Ljava/lang/String;
    //   274: aastore
    //   275: invokestatic 201	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -31 -> 247
    //   281: astore_1
    //   282: aload_0
    //   283: getfield 50	com/tencent/mm/emoji/view/BaseEmojiView:TAG	Ljava/lang/String;
    //   286: ldc 194
    //   288: iconst_1
    //   289: anewarray 172	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: aload_1
    //   295: invokevirtual 203	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   298: aastore
    //   299: invokestatic 201	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: goto -55 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	BaseEmojiView
    //   0	305	1	paramArrayOfByte	byte[]
    //   24	93	2	localObject	java.lang.Object
    //   120	6	2	localMMGIFException	com.tencent.mm.plugin.gif.MMGIFException
    //   147	80	2	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   5	71	120	com/tencent/mm/plugin/gif/MMGIFException
    //   71	82	120	com/tencent/mm/plugin/gif/MMGIFException
    //   82	95	120	com/tencent/mm/plugin/gif/MMGIFException
    //   96	117	120	com/tencent/mm/plugin/gif/MMGIFException
    //   5	71	257	java/io/IOException
    //   71	82	257	java/io/IOException
    //   82	95	257	java/io/IOException
    //   96	117	257	java/io/IOException
    //   5	71	281	java/lang/NullPointerException
    //   71	82	281	java/lang/NullPointerException
    //   82	95	281	java/lang/NullPointerException
    //   96	117	281	java/lang/NullPointerException
  }
  
  public EmojiInfo getEmojiInfo()
  {
    return this.glt;
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105785);
    if (p.i(this.glt, paramEmojiInfo))
    {
      AppMethodBeat.o(105785);
      return;
    }
    this.glt = paramEmojiInfo;
    if (paramEmojiInfo != null)
    {
      if ((paramEmojiInfo.getGroup() == EmojiGroupInfo.OzS) || (paramEmojiInfo.getGroup() == EmojiInfo.OzZ) || (paramEmojiInfo.getGroup() == EmojiInfo.OzY))
      {
        setImageBitmap(paramEmojiInfo.z(getContext(), 300));
        AppMethodBeat.o(105785);
        return;
      }
      if (paramEmojiInfo.fxr())
      {
        c(EmojiInfo.bg(getContext(), paramEmojiInfo.getName()), "");
        AppMethodBeat.o(105785);
        return;
      }
      paramEmojiInfo = g.ad(PluginEmoji.class);
      p.g(paramEmojiInfo, "MMKernel.plugin(PluginEmoji::class.java)");
      setMMGIFFileByteArray(((PluginEmoji)paramEmojiInfo).getProvider().a(getEmojiInfo()));
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