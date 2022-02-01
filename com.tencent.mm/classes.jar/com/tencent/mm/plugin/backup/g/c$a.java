package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.HashSet;

final class c$a
{
  private static String TAG = "MicroMsg.BackupDataPushScene.BackFileOp";
  String filePath;
  int iKP;
  private HashSet<c> oPF;
  private InputStream oPG;
  int offset;
  
  public c$a(String paramString)
  {
    AppMethodBeat.i(21702);
    this.oPF = new HashSet();
    this.filePath = null;
    this.iKP = 0;
    this.offset = 0;
    this.oPG = null;
    this.filePath = paramString;
    this.iKP = ((int)s.boW(this.filePath));
    if (this.iKP < 0) {
      this.iKP = 0;
    }
    AppMethodBeat.o(21702);
  }
  
  final boolean b(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(21703);
    try
    {
      if (this.oPG == null) {
        this.oPG = s.openRead(this.filePath);
      }
      int i = this.oPG.read(paramArrayOfByte);
      int j = paramArrayOfByte.length;
      if (i != j)
      {
        AppMethodBeat.o(21703);
        return false;
      }
      if (paramBoolean) {
        this.oPG.close();
      }
      AppMethodBeat.o(21703);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(21703);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.c.a
 * JD-Core Version:    0.7.0.1
 */