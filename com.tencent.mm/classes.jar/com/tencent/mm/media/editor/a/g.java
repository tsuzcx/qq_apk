package com.tencent.mm.media.editor.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.dks;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/EmojiItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "getEditorMatrix", "()Landroid/graphics/Matrix;", "setEditorMatrix", "(Landroid/graphics/Matrix;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "setShowMatrix", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class g
  extends a
{
  private final EmojiInfo fLP;
  private Matrix goN;
  private Matrix goO;
  
  public g(EmojiInfo paramEmojiInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    super(e.goH, paramMatrix2);
    AppMethodBeat.i(93574);
    this.fLP = paramEmojiInfo;
    this.goN = paramMatrix1;
    this.goO = paramMatrix2;
    AppMethodBeat.o(93574);
  }
  
  public final com.tencent.mm.bx.a ajx()
  {
    int j = 0;
    AppMethodBeat.i(93573);
    acu localacu = new acu();
    Object localObject = new float[9];
    dks localdks1 = new dks();
    this.goO.getValues((float[])localObject);
    int i = 0;
    float f;
    while (i < 9)
    {
      f = localObject[i];
      localdks1.DmV.add(Float.valueOf(f));
      i += 1;
    }
    dks localdks2 = new dks();
    localObject = new float[9];
    this.goN.getValues((float[])localObject);
    i = j;
    while (i < 9)
    {
      f = localObject[i];
      localdks2.DmV.add(Float.valueOf(f));
      i += 1;
    }
    localObject = this.fLP;
    String str;
    if (localObject != null)
    {
      str = ((EmojiInfo)localObject).JS();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localacu.md5 = ((String)localObject);
    localObject = this.fLP;
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
    localacu.name = ((String)localObject);
    localacu.Ddt = localdks1;
    localacu.Ddu = localdks2;
    localObject = (com.tencent.mm.bx.a)localacu;
    AppMethodBeat.o(93573);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.g
 * JD-Core Version:    0.7.0.1
 */