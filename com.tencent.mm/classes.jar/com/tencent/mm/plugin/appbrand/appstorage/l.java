package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l
{
  static
  {
    AppMethodBeat.i(140590);
    iSq = new l("OK", 0);
    iSr = new l("ERR_OP_FAIL", 1);
    iSs = new l("ERR_FS_NOT_MOUNTED", 2);
    iSt = new l("ERR_PARENT_DIR_NOT_EXISTS", 3);
    iSu = new l("ERR_PERMISSION_DENIED", 4);
    iSv = new l("RET_ALREADY_EXISTS", 5);
    iSw = new l("RET_NOT_EXISTS", 6);
    iSx = new l("ERR_DIR_NOT_EMPTY", 7);
    iSy = new l("ERR_IS_FILE", 8);
    iSz = new l("ERR_IS_DIRECTORY", 9);
    iSA = new l("ERR_SYMLINK", 10);
    iSB = new l("ERR_ILLEGAL_READ_POSITION", 11);
    iSC = new l("ERR_ILLEGAL_READ_LENGTH", 12);
    iSD = new l("ERR_BAD_ZIP_FILE", 13);
    iSE = new l("ERR_WRITE_ZIP_ENTRY", 14);
    iSF = new l("ERR_EXCEED_DIRECTORY_MAX_SIZE", 15);
    iSG = new l("ERR_NOT_SUPPORTED", 16);
    iSH = new l[] { iSq, iSr, iSs, iSt, iSu, iSv, iSw, iSx, iSy, iSz, iSA, iSB, iSC, iSD, iSE, iSF, iSG };
    AppMethodBeat.o(140590);
  }
  
  private l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.l
 * JD-Core Version:    0.7.0.1
 */