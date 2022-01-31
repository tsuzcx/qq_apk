package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import java.io.FileInputStream;
import java.util.HashSet;

final class c$a
{
  private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
  int ebK = 0;
  private FileInputStream fileInputStream = null;
  String filePath = null;
  private HashSet<c> hLT = new HashSet();
  byte[] hLU = null;
  int offset = 0;
  
  public c$a(String paramString)
  {
    this.filePath = paramString;
    this.hLU = null;
    paramString = this.filePath;
    au.Hx();
    int i;
    if (!paramString.startsWith(com.tencent.mm.model.c.FL()))
    {
      i = 0;
      if (i == 0) {
        break label209;
      }
    }
    label209:
    for (this.ebK = bk.bF(this.hLU);; this.ebK = ((int)e.aeQ(this.filePath)))
    {
      if (this.ebK < 0) {
        this.ebK = 0;
      }
      return;
      paramString = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramString);
      if (paramString == null)
      {
        i = 0;
        break;
      }
      if ((paramString.field_reserved4 & EmojiInfo.uDo) != EmojiInfo.uDo)
      {
        i = 0;
        break;
      }
      this.hLU = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramString);
      if (bk.bF(this.hLU) <= 0)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
    }
  }
  
  final boolean b(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      if (this.fileInputStream == null) {
        this.fileInputStream = new FileInputStream(this.filePath);
      }
      if (this.fileInputStream.read(paramArrayOfByte) != paramArrayOfByte.length) {
        return false;
      }
      if (paramBoolean) {
        this.fileInputStream.close();
      }
      return true;
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.c.a
 * JD-Core Version:    0.7.0.1
 */