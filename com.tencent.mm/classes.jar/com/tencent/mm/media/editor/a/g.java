package com.tencent.mm.media.editor.a;

import a.l;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/item/EmojiItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "getEditorMatrix", "()Landroid/graphics/Matrix;", "setEditorMatrix", "(Landroid/graphics/Matrix;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "setShowMatrix", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class g
  extends a
{
  private Matrix eSJ;
  private Matrix eSK;
  public final EmojiInfo evH;
  
  public g(EmojiInfo paramEmojiInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    super(e.eSD);
    AppMethodBeat.i(12890);
    this.evH = paramEmojiInfo;
    this.eSJ = paramMatrix1;
    this.eSK = paramMatrix2;
    AppMethodBeat.o(12890);
  }
  
  public final com.tencent.mm.bv.a UF()
  {
    int j = 0;
    AppMethodBeat.i(12889);
    zh localzh = new zh();
    Object localObject = new float[9];
    cqz localcqz1 = new cqz();
    this.eSK.getValues((float[])localObject);
    int i = 0;
    float f;
    while (i < 9)
    {
      f = localObject[i];
      localcqz1.xZD.add(Float.valueOf(f));
      i += 1;
    }
    cqz localcqz2 = new cqz();
    localObject = new float[9];
    this.eSJ.getValues((float[])localObject);
    i = j;
    while (i < 9)
    {
      f = localObject[i];
      localcqz2.xZD.add(Float.valueOf(f));
      i += 1;
    }
    localObject = this.evH;
    String str;
    if (localObject != null)
    {
      str = ((EmojiInfo)localObject).Al();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localzh.cqq = ((String)localObject);
    localObject = this.evH;
    if (localObject != null)
    {
      str = ((EmojiInfo)localObject).getName();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localzh.name = ((String)localObject);
    localzh.wQk = localcqz1;
    localzh.wQl = localcqz2;
    localObject = (com.tencent.mm.bv.a)localzh;
    AppMethodBeat.o(12889);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.g
 * JD-Core Version:    0.7.0.1
 */