package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l
{
  static
  {
    AppMethodBeat.i(140590);
    jMv = new l("OK", 0);
    jMw = new l("ERR_OP_FAIL", 1);
    jMx = new l("ERR_FS_NOT_MOUNTED", 2);
    jMy = new l("ERR_PARENT_DIR_NOT_EXISTS", 3);
    jMz = new l("ERR_PERMISSION_DENIED", 4);
    jMA = new l("RET_ALREADY_EXISTS", 5);
    jMB = new l("RET_NOT_EXISTS", 6);
    jMC = new l("ERR_DIR_NOT_EMPTY", 7);
    jMD = new l("ERR_IS_FILE", 8);
    jME = new l("ERR_IS_DIRECTORY", 9);
    jMF = new l("ERR_SYMLINK", 10);
    jMG = new l("ERR_ILLEGAL_READ_POSITION", 11);
    jMH = new l("ERR_ILLEGAL_READ_LENGTH", 12);
    jMI = new l("ERR_BAD_ZIP_FILE", 13);
    jMJ = new l("ERR_WRITE_ZIP_ENTRY", 14);
    jMK = new l("ERR_EXCEED_DIRECTORY_MAX_SIZE", 15);
    jML = new l("ERR_NOT_SUPPORTED", 16);
    jMM = new l[] { jMv, jMw, jMx, jMy, jMz, jMA, jMB, jMC, jMD, jME, jMF, jMG, jMH, jMI, jMJ, jMK, jML };
    AppMethodBeat.o(140590);
  }
  
  private l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.l
 * JD-Core Version:    0.7.0.1
 */