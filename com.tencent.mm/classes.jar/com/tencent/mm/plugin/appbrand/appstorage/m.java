package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m
{
  static
  {
    AppMethodBeat.i(140590);
    kSu = new m("OK", 0);
    kSv = new m("ERR_OP_FAIL", 1);
    kSw = new m("ERR_FS_NOT_MOUNTED", 2);
    kSx = new m("ERR_PARENT_DIR_NOT_EXISTS", 3);
    kSy = new m("ERR_PERMISSION_DENIED", 4);
    kSz = new m("RET_ALREADY_EXISTS", 5);
    kSA = new m("RET_NOT_EXISTS", 6);
    kSB = new m("ERR_DIR_NOT_EMPTY", 7);
    kSC = new m("ERR_IS_FILE", 8);
    kSD = new m("ERR_IS_DIRECTORY", 9);
    kSE = new m("ERR_SYMLINK", 10);
    kSF = new m("ERR_ILLEGAL_READ_POSITION", 11);
    kSG = new m("ERR_ILLEGAL_READ_LENGTH", 12);
    kSH = new m("ERR_BAD_ZIP_FILE", 13);
    kSI = new m("ERR_WRITE_ZIP_ENTRY", 14);
    kSJ = new m("ERR_EXCEED_DIRECTORY_MAX_SIZE", 15);
    kSK = new m("ERR_NOT_SUPPORTED", 16);
    kSL = new m[] { kSu, kSv, kSw, kSx, kSy, kSz, kSA, kSB, kSC, kSD, kSE, kSF, kSG, kSH, kSI, kSJ, kSK };
    AppMethodBeat.o(140590);
  }
  
  private m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.m
 * JD-Core Version:    0.7.0.1
 */