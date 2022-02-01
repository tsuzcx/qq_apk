package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/item/EmojiItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "getEditorMatrix", "()Landroid/graphics/Matrix;", "setEditorMatrix", "(Landroid/graphics/Matrix;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "setShowMatrix", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class g
  extends a
{
  private final EmojiInfo fPB;
  private Matrix gPv;
  private Matrix gPw;
  
  public g(EmojiInfo paramEmojiInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    super(e.gPp, paramMatrix2);
    AppMethodBeat.i(93574);
    this.fPB = paramEmojiInfo;
    this.gPv = paramMatrix1;
    this.gPw = paramMatrix2;
    AppMethodBeat.o(93574);
  }
  
  public final com.tencent.mm.bw.a aqw()
  {
    int j = 0;
    AppMethodBeat.i(93573);
    adt localadt = new adt();
    Object localObject = new float[9];
    dqj localdqj1 = new dqj();
    this.gPw.getValues((float[])localObject);
    int i = 0;
    float f;
    while (i < 9)
    {
      f = localObject[i];
      localdqj1.EHU.add(Float.valueOf(f));
      i += 1;
    }
    dqj localdqj2 = new dqj();
    localObject = new float[9];
    this.gPv.getValues((float[])localObject);
    i = j;
    while (i < 9)
    {
      f = localObject[i];
      localdqj2.EHU.add(Float.valueOf(f));
      i += 1;
    }
    localObject = this.fPB;
    String str;
    if (localObject != null)
    {
      str = ((EmojiInfo)localObject).JC();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localadt.md5 = ((String)localObject);
    localObject = this.fPB;
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
    localadt.name = ((String)localObject);
    localadt.Ewz = localdqj1;
    localadt.EwA = localdqj2;
    localObject = (com.tencent.mm.bw.a)localadt;
    AppMethodBeat.o(93573);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.g
 * JD-Core Version:    0.7.0.1
 */