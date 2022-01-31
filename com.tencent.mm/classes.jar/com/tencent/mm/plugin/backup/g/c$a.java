package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import java.io.FileInputStream;
import java.util.HashSet;

final class c$a
{
  private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
  private FileInputStream fileInputStream;
  String filePath;
  int fsd;
  private HashSet<c> jFv;
  byte[] jFw;
  int offset;
  
  public c$a(String paramString)
  {
    AppMethodBeat.i(17643);
    this.jFv = new HashSet();
    this.filePath = null;
    this.fsd = 0;
    this.jFw = null;
    this.offset = 0;
    this.fileInputStream = null;
    this.filePath = paramString;
    this.jFw = null;
    paramString = this.filePath;
    aw.aaz();
    int i;
    if (!paramString.startsWith(com.tencent.mm.model.c.YP()))
    {
      i = 0;
      if (i == 0) {
        break label221;
      }
    }
    label221:
    for (this.fsd = bo.cf(this.jFw);; this.fsd = ((int)e.avI(this.filePath)))
    {
      if (this.fsd < 0) {
        this.fsd = 0;
      }
      AppMethodBeat.o(17643);
      return;
      paramString = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramString);
      if (paramString == null)
      {
        i = 0;
        break;
      }
      if ((paramString.field_reserved4 & EmojiInfo.APx) != EmojiInfo.APx)
      {
        i = 0;
        break;
      }
      this.jFw = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l(paramString);
      if (bo.cf(this.jFw) <= 0)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
    }
  }
  
  final boolean c(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(17644);
    try
    {
      if (this.fileInputStream == null) {
        this.fileInputStream = new FileInputStream(this.filePath);
      }
      int i = this.fileInputStream.read(paramArrayOfByte);
      int j = paramArrayOfByte.length;
      if (i != j)
      {
        AppMethodBeat.o(17644);
        return false;
      }
      if (paramBoolean) {
        this.fileInputStream.close();
      }
      AppMethodBeat.o(17644);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(17644);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.c.a
 * JD-Core Version:    0.7.0.1
 */